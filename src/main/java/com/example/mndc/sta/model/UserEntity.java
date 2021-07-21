package com.example.mndc.sta.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mpk;
    @Column(unique = true, nullable = false)
    private String mid;
    @Column(nullable = false)
    private String mpw;
    @Column(unique = true, nullable = false)
    private String email;
//    @Column(nullable = false)
//    private String phoneNum;
//    @Column(nullable = false)
//    private String name;
    @Column(nullable = false)
    private String mnm;
    private String mrole;
    private String mauth;
    private String provider;
    @CreationTimestamp
    private Timestamp regdt;

}
