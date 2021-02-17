package com.SoulMen.utils;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.DecimalFormat;

public class HttpPostUtil {

    public  String getSuffix(final MultipartFile file){
        if(file == null || file.getSize() == 0){
            return null;
        }
        String fileName = file.getOriginalFilename();
        return fileName.substring(fileName.lastIndexOf(".")+1);
    }
    public String uploadFile(String urlStr, MultipartFile file) throws IOException {

        // 后缀
        String suffix = getSuffix(file);

        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost uploadFile = new HttpPost(urlStr);


        DecimalFormat df = new DecimalFormat("#.##");
        MultipartEntityBuilder builder = MultipartEntityBuilder.create();
        //  HTTP.PLAIN_TEXT_TYPE,HTTP.UTF_8
        builder.addTextBody("name", file.getOriginalFilename(), ContentType.create("text/plain", Consts.UTF_8));
        builder.addTextBody("size", df.format((double) file.getSize() / 1024), ContentType.TEXT_PLAIN);
        builder.addTextBody("suffix", suffix, ContentType.TEXT_PLAIN);
        // 把文件加到HTTP的post请求中
        // String filepath = "/user/test/123.png"
        // File f = new File(filepath);
        builder.addBinaryBody(
                "MultipartFile",
                file.getInputStream(),
                // new FileInputStream(f),
                ContentType.APPLICATION_OCTET_STREAM,
                file.getOriginalFilename()
        );

        HttpEntity multipart = builder.build();
        uploadFile.setEntity(multipart);
        CloseableHttpResponse response = httpClient.execute(uploadFile);
        HttpEntity responseEntity = response.getEntity();
        String sResponse= EntityUtils.toString(responseEntity, "UTF-8");
//        JSONObject jsonObject = JSONObject.parseObject(sResponse);

        // {"code":1,"data":"7efb19980373dd90f5077576afa7481a","message":""}
        // {"code":401,"httpStatus":null,"data":"373656a2-baff-423a-93fb-704f51003509","message":"error"}

        return sResponse;

    }

}
