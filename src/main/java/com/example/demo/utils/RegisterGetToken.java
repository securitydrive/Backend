package com.example.demo.utils;

import com.example.demo.enity.User;
import net.sf.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * <pre>
 *
 * </pre>
 * @author tensor
 */
public class RegisterGetToken {

    /**
     *
     * @param user
     * @return
     */
    public static JSONObject getToken(User user) {
        StringBuffer context = new StringBuffer();
        BufferedReader br = null;
        try {
            URL realUrl = new URL(urlBuilder(user));
            URLConnection connection = realUrl.openConnection();
            connection.connect();
            br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
            String tempLine;
            while ((tempLine = br.readLine()) != null) {
                context.append(tempLine);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return JSONObject.fromObject(context.toString());
    }

    /**
     *
     * @param user
     * @return
     */
    protected static String urlBuilder(User user) {
        StringBuffer sb = new StringBuffer();
        sb
                .append("http://127.0.0.1:8080/oauth/token?username=")
                .append(user.getUserName())
                .append("&password=")
                .append(user.getUserPassword())
                .append("&grant_type=password&scope=all&client_id=client&client_secret=123456");
        return sb.toString();
    }

}
