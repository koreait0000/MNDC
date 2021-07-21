package com.example.mndc.sta.model.repository;


import com.example.mndc.sta.model.UserEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

//crud
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    //findBy규칙 -> Username문법
    //select * from user where username = ?(파라미터값) 이렇게 호출된다 JPA 쿼리 메소드
    UserEntity findByMid(String mid);

    @Transactional
    @Modifying
    @Query(value = "UPDATE UserEntity u SET u.mauth = null where u.email = :#{#user.email}")
    Integer updateAuth(@Param("user") UserEntity user);
}
