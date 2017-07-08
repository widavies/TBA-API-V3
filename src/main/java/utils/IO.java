package utils;

import org.json.simple.parser.JSONParser;

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
        HttpURLConnection connection = null;
        try {
            URL url = new URL( Constants.URL + targetURL);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("User-Agent", "TBA-API-V3");
            connection.setRequestProperty("X-TBA-Auth-Key", Constants.AUTH_TOKEN);
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
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
        } catch(java.lang.Error e) {

        } catch (Exception e) {
            System.err.println("Data request failed. Check your connection / verify correct data key. If the issue persists, contact the developer");
            e.printStackTrace();
        } finally {
            if(connection != null) connection.disconnect();
        }
        return null;
    }
}
