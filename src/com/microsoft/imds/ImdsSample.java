package com.microsoft.imds;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * This example has two dependencies:
 *  1. Google Gson library: https://github.com/google/gson
 *  2. BouncyCastle Java library: https://www.bouncycastle.org/java.html
 */
public class ImdsSample
{
    public static final String ImdsServer = "http://169.254.169.254";
    public static final String InstanceEndpoint = ImdsServer + "/metadata/instance/compute";
    public static final String AttestedEndpoint = ImdsServer + "/metadata/attested/document";
    public static final String NonceValue = "123456";


    private static final String API_VERSION = "api-version=2020-12-01"; // this is the latest version
    private static final String JSON_FORMAT = "format=json";
    private static final int MAX_RESPONSE_BUFFER_SIZE = 512;
    private static final long TIMEOUT = TimeUnit.MINUTES.toSeconds(10);
    private static final String BASE_URL = "http://169.254.169.254/metadata/instance/compute";


    public static void main(String[] args)
    {
        // Query instance metadata
        try {
            String result = QueryInstanceEndpoint();
            ParseInstanceResponse(result);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static void ParseInstanceResponse(String response)
    {
        System.out.println("Instance response: " + response);
    }

    private static String QueryInstanceEndpoint() throws Exception
    {
        return QueryImds(InstanceEndpoint, "2017-08-01");
    }

    private static String QueryImds(String path, String apiVersion) throws Exception
    {
        return QueryImds(path, apiVersion, "format=json");
    }

    private static String QueryImds(String path, String apiVersion, String otherParams) throws Exception
    {
        String imdsUrl = path + "?api-version=" + apiVersion;
        if(otherParams != null && !otherParams.isEmpty())
        {
            imdsUrl += "&" + otherParams;
        }

        System.out.println("url: " + imdsUrl);

        try
        {
            URL url = new URL(imdsUrl);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("Metadata", "true");
            con.setConnectTimeout((int)TimeUnit.MINUTES.toMillis(10));
            InputStream inputStream = con.getInputStream();
            if (inputStream != null) {
                BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
                String line;
                StringBuffer response = new StringBuffer();
                while ((line = in.readLine()) != null) {
                    response.append(line);
                }
                in.close();
                return response.toString();
            }
            return null;
        }
        catch(Exception ex)
        {
            System.out.println(ex.getStackTrace());
            throw ex;
        }
    }
}
