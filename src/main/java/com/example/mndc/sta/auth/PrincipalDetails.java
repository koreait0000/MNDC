package com.example.mndc.sta.auth;

import com.example.mndc.sta.model.UserEntity;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.*;


//security session (security ContextHolder)
// obj type -> Authentication type obj
// authentication in userInfo
// user obj -> userdetails type ojb
@Data
// security session => Authentication => UserDetails(PrincipalDetails)
public class PrincipalDetails implements UserDetails, OAuth2User {

    private UserEntity userEntity;
    private Map<String, Object> attributes;

    //일반 로그인
    public PrincipalDetails(UserEntity userEntity){
        this.userEntity = userEntity;
    }
    //oauth로그인
    public PrincipalDetails(UserEntity userEntity, Map<String, Object> attributes){
        this.userEntity = userEntity;
        this.attributes = attributes;
    }

    @Override
    public Map<String, Object> getAttributes() {
        return attributes;
    }

    @Override
    public String getName() {
        return null;
    }

    //해당 user의 권한을 리턴하는곳
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> collect = new ArrayList<>();

        collect.add(new GrantedAuthority() {
            @Override
            public String getAuthority() {
                return userEntity.getMrole();
            }
        });
        return collect;
    }

    @Override
    public String getPassword() {
        return userEntity.getMpw();
    }

    @Override
    public String getUsername() {
        return userEntity.getMid();
    }

    public Long getMpk(){
        return this.userEntity.getMpk();
    }
    public void setMpk(Long mpk){
        this.userEntity.setMpk(mpk);
    }


    //계정 만료 됬는지
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    //계정 잠겼는지
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
    //계정 비밀번호 오래 지났는지
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    //계정 활성화 됬는지
    @Override
    public boolean isEnabled() {
        
        //우리 사이트에서 1년동안 회원이 로그인을 안하면 휴먼계정으로 이용가능
        return true;
    }


}
