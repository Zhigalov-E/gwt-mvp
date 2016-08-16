package com.myorg.gwt.common.server;

import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.regex.Pattern;


public class FileUploadHandler extends HttpServlet {

    private static final String FILE_EXTENTION = ".CSV";
    private static final String CHAR_TERMINATOR = ",";
    private static final String LINE_DELIMITER = "\n";

    private static final String INVALID_LINE_FORMAT = "Invalid line format";

    private static final Pattern NAME_SURNAME_PATTERN = Pattern.compile("^[а-яА-ЯёЁa-zA-Z]{1,40} [а-яА-ЯёЁa-zA-Z]{1,40}$");
    private static final Pattern DATE_PATTERN = Pattern.compile("^[0-3]?[0-9].[0-3]?[0-9].(?:[0-9]{2})?[0-9]{2}$");
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[-\\w.]+@([A-z0-9][-A-z0-9]+\\.)+[A-z]{2,4}$");

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletFileUpload upload = new ServletFileUpload();
        BufferedReader bufReader = null;
        PrintWriter responseWriter = null;
        try {
            FileItemIterator iter = upload.getItemIterator(request);
            while (iter.hasNext()) {
                FileItemStream item = iter.next();

                if(!item.isFormField() && item.getName().toUpperCase().endsWith(FILE_EXTENTION)) {

                    bufReader = new BufferedReader(new InputStreamReader(item.openStream()));
                    StringBuilder stringBuilder = new StringBuilder();
                    String line;
                    while ((line = bufReader.readLine()) != null) {
                        if(IsCorrectLine(line)) {
                            stringBuilder.append(line).append(LINE_DELIMITER);
                        } else {
                            stringBuilder.append(INVALID_LINE_FORMAT).append(LINE_DELIMITER);
                        }
                    }
                    response.setContentType("text/html; charset=UTF-8");
                    response.setCharacterEncoding("UTF-8");
                    responseWriter = response.getWriter();
                    responseWriter.write(stringBuilder.toString());
                }
            }
        } catch (FileUploadException e) {
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
