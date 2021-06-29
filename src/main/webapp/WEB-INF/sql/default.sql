create database mndc default character set utf8 collate utf8_general_ci;

use mndc;


-- 각 부대 테이블
create table military_unit(
    mu_pk int AUTO_INCREMENT primary key, -- 부대 pk
    mu_name varchar(20) not null, -- 부대 이름
    mu_type int(1) check(mu_type in(1,2,3,4,5)) -- 부대 편제 정보(1:육, 2:해, 3:공, 4:해병, 5:국)
);

create table member(
    m_pk int AUTO_INCREMENT primary key,
    m_id varchar(20) not null,
    m_pw varchar(60) not null,
    m_nm varchar(10) not null unique,
    /* TODO : 닉네임 추가했습니다. 회원가입 및 프로필 설정에서 닉네임 변경,등록 추가해주세요.ENtity 수정은 했습니다*/
    m_type int(1) check(m_type in(1,2,3)),
    m_auth int(1) check(m_auth in(1,2,3)),
    mu_pk int,
    foreign key (mu_pk) references military_unit(mu_pk)
);

create table board(
    b_pk int AUTO_INCREMENT primary key comment 'pk입니다',
    b_title varchar(30) not null comment '글 제목입니다',
    b_ctnt varchar(10000) not null,
    b_regdt date default now(),
    b_like int default 0,
    b_view int default 0,
    b_type int default 0,

    m_pk int,
    mu_pk int,
    foreign key (m_pk) references member(m_pk),
    foreign key (mu_pk) references military_unit(mu_pk)
);


--
--
