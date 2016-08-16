package com.myorg.gwt.common.server;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.List;
import java.util.regex.Pattern;


public class FileUploadHandler extends HttpServlet {

    private static final String FILE_EXTENTION = ".CSV";
    private static final String CHAR_TERMINATOR = ",";
    private static final String LINE_DELIMITER = "\n";

    private long FILE_SIZE_LIMIT = 1 * 1024 * 1024; // 1 MiB
    private final Logger logger = Logger.getLogger("UploadServlet");

    private static final Pattern NAME_SURNAME_PATTERN = Pattern.compile("^[а-яА-ЯёЁa-zA-Z]{1,40} [а-яА-ЯёЁa-zA-Z]{1,40}$");
    private static final Pattern DATE_PATTERN = Pattern.compile("^[0-3]?[0-9].[0-3]?[0-9].(?:[0-9]{2})?[0-9]{2}$");
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[-\\w.]+@([A-z0-9][-A-z0-9]+\\.)+[A-z]{2,4}$");

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(fileItemFactory);
        upload.setSizeMax(FILE_SIZE_LIMIT);

        BufferedReader bufReader = null;
        PrintWriter responseWriter = null;
        try {
            List<FileItem> items = upload.parseRequest(request);
            for (FileItem item : items) {
                if(!item.isFormField() && item.getName().toUpperCase().endsWith(FILE_EXTENTION)) {

                    bufReader = new BufferedReader(new InputStreamReader(item.getInputStream()));
                    StringBuilder stringBuilder = new StringBuilder();
                    String line;
                    while ((line = bufReader.readLine()) != null) {
                        if(IsCorrectLine(line)) {
                            stringBuilder.append(line).append(LINE_DELIMITER);
                        }
                    }
                    response.setContentType("text/html; charset=UTF-8");
                    response.setCharacterEncoding("UTF-8");
                    responseWriter = response.getWriter();
                    responseWriter.write(stringBuilder.toString());
                }
            }
        } catch (FileUploadException e) {
            logger.error("Throwing servlet exception for unhandled exception", e);
            throw new ServletException("Cannot parse multipart request.", e);
        } finally {
            if(bufReader != null) {
                bufReader.close();
            }
            if(responseWriter != null) {
                responseWriter.close();
            }
        }
    }

    private boolean IsCorrectLine(String line) {
        String[] parts = line.split(CHAR_TERMINATOR);
        return parts.length == 3
                && NAME_SURNAME_PATTERN.matcher(parts[0].trim()).matches()
                && DATE_PATTERN.matcher(parts[1].trim()).matches()
                && EMAIL_PATTERN.matcher(parts[2].trim()).matches();

    }
}
