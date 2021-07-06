package com.example.mndc.service;

import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Random;

@Service
public class UserService {

    public String randNum(){
        Random rand = new Random();
        String numStr="";

        for(int i=0; i<6;i++){
            String ran = Integer.toString(rand.nextInt(10));
            numStr+=ran;
        }
        System.out.println("인증번호: "+numStr);
        return numStr;
    }

    public int certifiedPhoneNumber(String phoneNumber, String rNum) {
        String api_key = "NCSFNGQWT6LR7VI3"; //TODO: 키와 시크릿은 yml파일로 관리
        String api_secret = "WNSHSGKRJND0KRVVOIJXPUK2SHNS4ESA";
        Message coolSms = new Message(api_key, api_secret);

        HashMap<String, String> params = new HashMap<>();
        params.put("to",phoneNumber);
        params.put("from","01093313677");
        params.put("type","SMS");
        params.put("text",String.format("[Amond] 인증번호 [%s]를 입력해주세요.", rNum));
        params.put("app_version","test app 1.2");

        try {
            JSONObject obj = coolSms.send(params);
//            System.out.println(obj.toString());
        }catch (CoolsmsException e){
            System.out.println(e.getMessage());
            System.out.println(e.getCode());
            return e.getCode();
        }
        return 0;
    }
}
