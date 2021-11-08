package edu.serviceSender.Client;

import java.io.*;
import java.nio.charset.StandardCharsets;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

public class RestClient {

    private static final String PATH = "users.json";

    public RestClient() {
    }

    private void getJSONFile () {
        HttpClient client = new DefaultHttpClient();

        //URL for accounting service
        HttpGet request = new HttpGet("URL");
        try {
            HttpResponse response = client.execute(request);
            BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            String line = "";
            Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("PATH"), StandardCharsets.UTF_8));
            while ((line = rd.readLine()) != null) {
                writer.write(line);
            }
            writer.close();
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("IOException");
            e.printStackTrace();
        }
    }

    //Fills in JSON file from rest server and returns path
    public String getPath() {
        getJSONFile();
        return PATH;
    }
}
