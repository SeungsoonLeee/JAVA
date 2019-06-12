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
	constraint sns_writer
	foreign key(s_id) references jun05_member(m_id) on delete cascade
);


alter table jun10_sns
add constraint sns_writer
	foreign key(s_id) references jun05_member(m_id) on delete cascade;

alter table jun10_sns
drop constraint sns_writer;
	

create sequence jun10_sns_seq;

select * from jun10_sns, jun05_member where m_id = s_id  order by s_Date;


--------------------------------------------------------------------------------
-- 전체 목록을 가져오는 건 매우 비효율적.
-- 현재 페이지의 목록만 가져오자.

-- 필요 : 게시물 번호
-- s_no는 탈락 -> oracle의 sequence는 insert에 실패해도 올라가기 때문.
-- "rownum"이라는 가상 컬럼을 이용.

-- rownum이 먼저 메겨지고 order되기 때문에 순서가 이상하게 나옴.
-- 따라서 먼저 날짜순으로 정렬 후 rownum을 메기도록 해야함.
-- rownum 3부터 5까지의 내용을 조회.
select rownum, s_no, s_id, s_msg, s_date, m_name, m_photo 
from(select * from jun10_sns, jun05_member where m_id = s_id  order by s_Date)
where rownum >= 3 and rownum <= 5;
-- 하려고 했으나 rownum은 무조건 1부터 조회가 가능하므로 약간의 변형이 필요.
select *
from(select rownum as rn, s_no, s_id, s_msg, s_date, m_name, m_photo 
from(select * from jun10_sns, jun05_member where m_id = s_id  order by s_Date))
where rn >= 3 and rn <= 5
order by rn desc;

select count(*) from jun10_sns, jun05_member where m_id = s_id;

select *
from(select rownum as rn, s_no, s_id, s_msg, s_date, m_name, m_photo 
from(select * from jun10_sns, jun05_member where m_id = s_id like '%?%' or s_msg like '%?%'  order by s_Date))
where rn >= 3 and rn <= 5
order by rn desc;


select count(*)
from(select rownum as rn, s_no, s_id, s_msg, s_date, m_name, m_photo 
from(select * from jun10_sns, jun05_member where m_id = s_id))
where s_id like '%%' or s_msg like '%%'


------------------------------------------------------------------------------------






