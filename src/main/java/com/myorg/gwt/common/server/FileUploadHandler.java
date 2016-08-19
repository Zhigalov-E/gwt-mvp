package com.myorg.gwt.common.server;

import com.myorg.gwt.common.server.model.Client;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.log4j.Logger;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;


public class FileUploadHandler extends HttpServlet {
    private static final Logger LOGGER = Logger.getLogger(FileUploadHandler.class.getName());

    private static final String FILE_EXTENTION = ".CSV";
    private static final String CHAR_TERMINATOR = ",";

    private long FILE_SIZE_LIMIT = 1 * 1024 * 1024; // 1 MiB

    private static final Pattern DATE_PATTERN = Pattern.compile("^[0-3]?[0-9].[0-3]?[0-9].(?:[0-9]{2})?[0-9]{2}$");
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[-\\w.]+@([A-z0-9][-A-z0-9]+\\.)+[A-z]{2,4}$");

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(fileItemFactory);
        upload.setSizeMax(FILE_SIZE_LIMIT);

        List<Client> clients = new ArrayList<>();

        BufferedReader bufReader = null;
        PrintWriter responseWriter = null;
        try {
            List<FileItem> items = upload.parseRequest(request);
            for (FileItem item : items) {
                if (!item.isFormField() && item.getName().toUpperCase().endsWith(FILE_EXTENTION)) {

                    bufReader = new BufferedReader(new InputStreamReader(item.getInputStream()));
                    String line;
                    while ((line = bufReader.readLine()) != null) {
                        try {
                            clients.add(parseLine(line));
                        } catch (RuntimeException e) {
                            LOGGER.warn(e.getMessage());
                        }
                    }
                    response.setContentType("text/html; charset=UTF-8");
                    response.setCharacterEncoding("UTF-8");
                    responseWriter = response.getWriter();
                    responseWriter.write(convertToJSON(clients).toString());
                }
            }
        } catch (FileUploadException e) {
            LOGGER.error("Throwing servlet exception for unhandled exception", e);
            throw new ServletException("Cannot parse multipart request.", e);
        } finally {
            if (bufReader != null) {
                bufReader.close();
            }
            if (responseWriter != null) {
                responseWriter.close();
            }
        }
    }

    private Client parseLine(String line) throws RuntimeException {
        String[] parts = line.split(CHAR_TERMINATOR);
        Client client = new Client();

        if(parts[0]== null || parts[0].equals("")) {
            throw new RuntimeException("Invalid Name format");
        } else {
            client.setName(parts[0]);
        }
        if(DATE_PATTERN.matcher(parts[1].trim()).matches()) {
            client.setDate(parts[1]);
        }
        if(EMAIL_PATTERN.matcher(parts[2].trim()).matches()) {
            client.setEmail(parts[2]);
        }

        return client;
    }

    private JSONObject convertToJSON(List<Client> clients) {
        List<JSONObject> clientObjects = new ArrayList<>();
        for(Client client: clients) {
            JSONObject clientObj = new JSONObject();
            clientObj.put("name",client.getName());
            clientObj.put("date",client.getDate());
            clientObj.put("email",client.getEmail());
            clientObjects.add(clientObj);
        }
        JSONObject responseObject = new JSONObject();
        responseObject.put("clients", clientObjects);
        return responseObject;
    }
}
