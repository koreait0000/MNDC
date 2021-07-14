package com.example.mndc.sta.model.repository;


import com.example.mndc.sta.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

//crud
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    //findBy규칙 -> Username문법
    //select * from user where username = ?(파라미터값) 이렇게 호출된다 JPA 쿼리 메소드
    UserEntity findByid(String id);

    @Transactional
    @Modifying
    @Query("UPDATE UserEntity u SET u.phoneNum = ?1 where u.id = ?2")
    int updatePhoneNum(String phoneNum, String id);
}
