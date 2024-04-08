package com.example.route.rpc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONArray;
import org.apache.tomcat.util.codec.binary.StringUtils;
import org.springframework.stereotype.Service;

/**
 * @author: Richerlv
 * @date: 2024/4/8 14:43
 * @description:
 */
@Service
public class GpgModelClient {

    public List<Integer> invokeGpg(int start, int end, int time) {
        try {
            URL url = new URL("http://127.0.0.1:8001/gpg");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);

            // 构造 JSON 请求数据
            String jsonInputString = "{\"start\": %s, \"end\": %s, \"time_budget\": %s}";
            jsonInputString = String.format(jsonInputString, start, end, time);

            // 发送请求数据
            try (OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream())) {
                wr.write(jsonInputString);
                wr.flush();
            }

            // 读取响应数据
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder response = new StringBuilder();
            String responseLine;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }
            System.out.println(this.getClass() + ": " + response.toString());

            // 关闭连接
            conn.disconnect();
            return parseInvokeGpgResponse(response.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private List<Integer> parseInvokeGpgResponse(String response) {
        JSONArray jsonArray = JSON.parseObject(response).getJSONArray("path");
        List<Integer> pathList = new ArrayList<>();
        for (int i = 0; i < jsonArray.size(); i++) {
            pathList.add(jsonArray.getInteger(i));
        }
        return pathList;
    }

}
