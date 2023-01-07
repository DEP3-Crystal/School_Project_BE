package com.crystal.school.utill;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

public class DownloadService {

    public byte[] downloadFromURL(String url) {

        try {
            URL link = new URL(url);

            // Open a connection to the URL
            URLConnection connection = link.openConnection();

            // Set up some things to make the connection faster
            connection.setConnectTimeout(1000);
            connection.setReadTimeout(1000);

            // Define an input stream to read data from the URL
            BufferedInputStream in = new BufferedInputStream(connection.getInputStream());

            // Define an output stream to write data to a file
            ByteArrayOutputStream out = new ByteArrayOutputStream();

            // Create an array to store bytes that are read from the input stream
            byte[] buffer = new byte[1024];

            // Keep track of the number of bytes read
            int numBytesRead;

            // Read bytes from the input stream and store them in the buffer
            while ((numBytesRead = in.read(buffer)) != -1) {
                out.write(buffer, 0, numBytesRead);
            }

            in.close();
            out.close();
            return out.toByteArray();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
