package com.example.mndc.sta.repository;


import com.example.mndc.sta.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

//crud
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    //findBy규칙 -> Username문법
    //select * from user where username = ?(파라미터값) 이렇게 호출된다 JPA 쿼리 메소드
    public UserEntity findById(String id);

}
