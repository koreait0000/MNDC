drop database if exists mndc;
create database mndc default character set utf8 collate utf8_general_ci;

use mndc;

-- 각 부대 테이블
create table military_unit(
    mu_pk int AUTO_INCREMENT primary key, -- 부대 pk
    mu_name varchar(40) not null, -- 부대 이름
    mu_type int(1) check(mu_type in(1,2,3,4,5)) -- 부대 편제 정보(1:육, 2:해, 3:공, 4:해병, 5:국)
);

create table user(
     mpk bigint not null auto_increment,
     email varchar(255) not null,
     mauth varchar(255),
     mid varchar(255) not null,
     mnm varchar(255) not null,
     mpw varchar(255) not null,
     mrole varchar(255),
     provider varchar(255),
     regdt datetime(6),
     primary key (mpk)
--      foreign key (mu_pk) references military_unit(mu_pk)
drop table if exists user;

create table board(
    bpk int AUTO_INCREMENT primary key,
    b_title varchar(30) not null,
    b_ctnt varchar(10000) not null,
    b_regdt datetime default now(),
    b_like int default 0,
    b_view int default 0,
    b_type int default 0,

    mpk bigint,
    mu_pk int,

    foreign key (mpk) references user(mpk),
    foreign key (mu_pk) references military_unit(mu_pk)
);

drop table if exists cmt;
create table cmt(
    cpk int AUTO_INCREMENT primary key,
    c_ctnt varchar(100) not null ,
    c_regdt datetime default now(),
    c_alert tinyint(1) default 1,

    bpk int,
    mpk bigint,

    foreign key (bpk) references board(bpk),
    foreign key (mpk) references user(mpk)
);
drop table if exists fav;
create table fav(
    mpk bigint,
    bpk int,
    toggle tinyint(1) comment '0은 싫어요, 1은 좋아요',
    primary key (mpk,bpk),

    foreign key (mpk) references user(mpk),
    foreign key (bpk) references board(bpk)
);

