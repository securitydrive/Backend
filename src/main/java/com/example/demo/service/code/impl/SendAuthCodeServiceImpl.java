package com.example.demo.service.code.impl;

import com.example.demo.enity.User;
import com.example.demo.service.code.SendAuthCodeService;
import com.example.demo.utils.ResultData;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * @author tensor
 */
@Component
@Service(value = "SendAuthCode")
public class SendAuthCodeServiceImpl implements SendAuthCodeService {

    /**
     *     智能匹配模板发送接口的http地址
     */
    protected final static String URI_SEND_SMS = "https://sms.yunpian.com/v2/sms/single_send.json";

    /**
     *     编码格式。发送编码格式统一用UTF-8
     */
    protected final static String ENCODING = "UTF-8";

    /**
     * 手机端获取验证码服务
     * @param phone
     * @param session
     * @return
     */
    protected String MakeAuthCode(String phone, HttpSession session) {
        String authCode = setAuthCode();
        session.setAttribute("authcode", authCode);
        String text = "【nb-loT】您的订单编号：" + authCode + ",物流信息：" + authCode;
        Map<String, String> params = new HashMap();
        params.put("apikey", "e8f3237e68e9d58a4d5fc5122470ccbd");
        params.put("text", text);
        params.put("mobile", phone);
        return post(URI_SEND_SMS, params);
    }

    @Override
    public ResultData<String> sendCode(User user, HttpSession session) {
        Map<String, Object> jwt = new HashMap<>();
        jwt.put("code", MakeAuthCode(user.getUserPhone(), session));
        VerificationCodeExpired(session);
        return new ResultData(jwt);
    }

    /**
     * 创建一个定时的异步任务用于删除验证码服务
     * @param session
     */
    @Async
    protected void VerificationCodeExpired(HttpSession session) {

    }

    /**
     * 基于HttpClient4.3的post提交
     * @param url
     * @param paramsMap
     * @return
     */
    protected String post(String url, Map<String, String> paramsMap) {
        CloseableHttpClient client = HttpClients.createDefault();
        String responseText = "";
        CloseableHttpResponse response = null;
        try {
            HttpPost method = new HttpPost(url);
            if (paramsMap != null) {
                List<NameValuePair> paramList = new ArrayList();
                for (Map.Entry<String, String> param : paramsMap.entrySet()) {
                    NameValuePair pair = new BasicNameValuePair(param.getKey(), param.getValue());
                    paramList.add(pair);
                }
                method.setEntity(new UrlEncodedFormEntity(paramList, ENCODING));
            }
            response = client.execute(method);
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                responseText = EntityUtils.toString(entity, ENCODING);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (response != null) {
                    response.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return responseText;
    }

    private static String setAuthCode() {
        String authcode = "";
        Random random = new Random();
        for(int i = 0; i < 6; i++) {
            String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";
            if( "char".equalsIgnoreCase(charOrNum) ) {
                int temp = random.nextInt(2) % 2 == 0 ? 65 : 97;
                authcode += (char)(random.nextInt(26) + temp);
            } else if( "num".equalsIgnoreCase(charOrNum) ) {
                authcode += String.valueOf(random.nextInt(10));
            }
        }
        return authcode;
    }

}
