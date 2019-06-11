create table jun05_member(
	m_id varchar2(10 char) primary key,
	m_pw varchar2(10 char) not null,
	m_name varchar2(10 char) not null,
	m_comment varchar2(150 char) not null,
	m_photo varchar2(150 char) not null
);

select * from jun05_member;

create table jun10_sns(
	s_no number(10) primary key,
	s_id varchar2(10 char) not null,
	s_msg varchar2(100 char) not null,	
	s_date date not null
);

create sequence jun10_sns_seq;

select * from jun10_sns, jun05_member where m_id = s_id;