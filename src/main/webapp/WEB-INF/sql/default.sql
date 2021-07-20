drop database if exists mndc;
create database mndc default character set utf8 collate utf8_general_ci;

use mndc;


-- 각 부대 테이블
create table military_unit(
    mu_pk int AUTO_INCREMENT primary key, -- 부대 pk
    mu_name varchar(40) not null, -- 부대 이름
    mu_type int(1) check(mu_type in(1,2,3,4,5)) -- 부대 편제 정보(1:육, 2:해, 3:공, 4:해병, 5:국)
);
drop table if exists user;
create table user(
    m_pk int AUTO_INCREMENT primary key,
    m_id varchar(20) not null,
    m_pw varchar(60) not null,
    m_type int(1) check(m_type in(1,2,3)),
    m_auth varchar(20) check(m_auth in('ROLE_ADMIN','ROLE_USER')),
    m_nm varchar(10),
    mu_pk int,
    provider varchar(100),
    reg_dt datetime default now(),
    foreign key (mu_pk) references military_unit(mu_pk)
);

create table board(
    b_pk int AUTO_INCREMENT primary key,
    b_title varchar(30) not null,
    b_ctnt varchar(10000) not null,
    b_regdt datetime default now(),
    b_like int default 0,
    b_view int default 0,
    b_type int default 0,

    m_pk int,
    mu_pk int,
    foreign key (m_pk) references user(m_pk),
    foreign key (mu_pk) references military_unit(mu_pk)
);

drop table if exists cmt;
create table cmt(
    c_pk int AUTO_INCREMENT primary key,
    c_ctnt varchar(100) not null ,
    c_regdt date default now(),
    c_alert tinyint(1) default 1,

    b_pk int,
    m_pk int,

    foreign key (b_pk) references board(b_pk),
    foreign key (m_pk) references user(m_pk)
);
drop table if exists fav;
create table fav(
    m_pk int,
    b_pk int,
    toggle tinyint(1) comment '0은 싫어요, 1은 좋아요',
    primary key (m_pk,b_pk),
    foreign key (m_pk) references user(m_pk),
    foreign key (b_pk) references board(b_pk)
);

