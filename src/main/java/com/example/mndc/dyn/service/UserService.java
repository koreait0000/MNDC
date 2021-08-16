package com.example.mndc.dyn.service;

import com.example.mndc.dyn.dao.BoardDAO;
import com.example.mndc.dyn.utils.CommonUtils;
import com.example.mndc.sta.auth.PrincipalDetails;
import com.example.mndc.sta.model.UserEntity;
import com.example.mndc.sta.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Random;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CommonUtils commonUtils;
    @Autowired
    private EmailService emailService;
    @Autowired
    private BoardDAO boardDAO;

    // 로그인 체크
    public boolean isLogin(PrincipalDetails principalDetails){
        return principalDetails != null;
    }
    // 로그인 체크 + 계정일치 체크
    public boolean isLoginMatch(PrincipalDetails principalDetails,int b_pk){

        return principalDetails.getUserEntity().getMpk().intValue() == boardDAO.selectInfoByBPk(b_pk).getM_pk();
    }

    public int join(UserEntity userEntity){
        if(userRepository.findByEmail(userEntity.getEmail()) != null || userRepository.findByMid(userEntity.getMid()) != null){
            return 0;
        }else if(userEntity.getMid() != null && userEntity.getMpw() != null && userEntity.getEmail() != null){
            String authCd = commonUtils.getRandomDigit(6);
            String hashPw = new BCryptPasswordEncoder().encode(userEntity.getMpw());
            userEntity.setMauth(authCd);
            userEntity.setMrole("ROLE_USER");
            userEntity.setMnm(userEntity.getMid());
            userEntity.setMpw(hashPw);
            userRepository.save(userEntity);

            String subject = "[Almond] 이메일 인증번호가 도착하였습니다.";
            String txt = String.format("<div>이메일 계정을 인증받으시려면 아래 링크를 클릭해주세요. (혹시 잘못 전달되었다면 이 이메일을 무시하셔도 됩니다)</div>" +
                            "<a href=\"http://localhost:8090/auth?email=%s&authCd=%s\">링크를 클릭하여 이메일 인증</a>"
                    , userEntity.getEmail(), authCd);
            emailService.sendMimeMessage(userEntity.getEmail(), subject, txt);
        }
        return 1;
    }

    public void auth(UserEntity userEntity){
        userRepository.updateAuth(userEntity);
    }
}
