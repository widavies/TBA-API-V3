package com.cpjd.utils;

import com.cpjd.main.Constants;
import org.json.simple.parser.JSONParser;
import com.cpjd.utils.exceptions.AuthTokenNotFoundException;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Pulls raw data from the server.
 * @since 1.0.0
 * @author Will Davies
 *
 */
public class IO {
    private static final JSONParser parser = new JSONParser();

    public static Object doRequest(String targetURL) {
        if(Constants.AUTH_TOKEN == null || Constants.AUTH_TOKEN.equals("")) throw new AuthTokenNotFoundException("You have not set an auth token for TBA-API-V3. Please set it with TBA.setAuthToken(String token).");

        HttpURLConnection connection = null;
        try {
            URL url = new URL( Constants.URL + targetURL);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("User-Agent", "TBA-API-V3");
            connection.setRequestProperty("X-TBA-Auth-Key", Constants.AUTH_TOKEN);
            connection.setRequestProperty("Content-SortingType", "application/x-www-form-urlencoded");
            connection.setRequestProperty("charset", "utf-8");
            connection.setUseCaches(false);

            InputStream is = connection.getInputStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(is));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = rd.readLine()) != null) {
                response.append(line);
                response.append('\r');
            }
            rd.close();
            return parser.parse(response.toString());
        } catch(Exception e) {
            // do nothing, should be handled somewhere else
        } finally {
            if(connection != null) connection.disconnect();
        }
        return null;
    }
}
