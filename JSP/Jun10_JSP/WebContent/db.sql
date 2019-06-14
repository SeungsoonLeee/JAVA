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

--댓글 테이블
--댓글 번호, 글번호, 쓴사람ID, 쓴사람 사진, 댓글 내용, 날짜
--댓글을 단 사람이 탈퇴를 하거나, 댓글을 단 글이 지워지면 자동으로 지워지게 외래키를 걸어둔다.
create sequence jun12_reply_seq;

create table jun12_reply(
	r_no number(20) primary key,
	r_snsNo number(10) not null,
	r_id varchar2(10 char) not null,
	r_photo varchar2(150 char) not null,
	r_reply varchar2(150 char) not null,
	r_date date not null
);

alter table jun12_reply
add constraint reply_writer
	foreign key(r_id) references jun05_member(m_id) on delete cascade;

alter table jun12_reply
add constraint reply_snsNo
	foreign key(r_snsNo) references jun10_sns(s_no) on delete cascade;
	
	
-----------------------------------------------------------------------------------------
create sequence jun14_gallery_seq;
	
create table jun14_gallery(
	g_no number(20) primary key,
	g_title varchar2(20 char) not null,
	g_id varchar2(20 char) not null,
	g_file varchar2(150 char) not null,
	g_date date,
	constraint gallery_wirter foreign key(g_id) references jun05_member(m_id) on delete cascade
);
	
	


select *
from(select rownum as rn, g_no, g_title, g_id, g_date, g_file
from(select * from jun14_gallery order by g_date))
where rn >= 3 and rn <= 5
order by rn desc;
	
	
	