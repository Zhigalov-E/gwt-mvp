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


public class FileUploadHandler extends HttpServlet {

    private static String FILE_EXTENTION = ".CSV";

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
                        stringBuilder.append(line).append(";\n");
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
}
