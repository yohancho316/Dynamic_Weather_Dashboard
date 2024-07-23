package model;

import java.io.*;

public class ApiKeyReader {

    private static final String API_KEY_FILE_PATH = "apikey.txt"; // No leading slash

    public static String getKey() {
        StringBuilder apiKey = new StringBuilder();
        ClassLoader classLoader = ApiKeyReader.class.getClassLoader();

        try (InputStream inputStream = classLoader.getResourceAsStream(API_KEY_FILE_PATH);
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            if (inputStream == null) {
                throw new IOException("Resource not found: " + API_KEY_FILE_PATH);
            }
            String line;
            while ((line = reader.readLine()) != null) {
                apiKey.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return apiKey.toString().trim();
    }
    }
