create table may10_lectureroom(
	l_name varchar2(10 char) primary key,
	l_location varchar2(10 char) not null,
	l_title varchar2(10 char) not null,
	l_start date not null,
	l_end date not null
);
insert into may10_lectureroom 
values('1강의실', '입구 옆', '네트워크', to_date('20190101','YYYYMMDD'), to_date('20190601','YYYYMMDD'));
insert into may10_lectureroom 
values('2강의실', '입구 앞', '네트워크', to_date('20190201','YYYYMMDD'), to_date('20190501','YYYYMMDD'));
insert into may10_lectureroom 
values('3강의실', '휴게실 앞', '인공지능', to_date('20190301','YYYYMMDD'), to_date('20190701','YYYYMMDD'));
insert into may10_lectureroom 
values('4강의실', '휴게실 뒤', '빅데이터', to_date('20190301','YYYYMMDD'), to_date('20190701','YYYYMMDD'));

create table may10_student(
	s_no number(5) primary key,
	s_name varchar2(10 char) not null,
	s_age number(3) not null,
	s_gender char(1 char) not null,
	s_address varchar2(10 char) not null,
	s_l_name varchar2(10 char) not null
);
create sequence may10_student_seq;

insert into may10_student
values(may10_student_seq.nextval, '홍길동', 20, '남', '서울', '1강의실');
insert into may10_student
values(may10_student_seq.nextval, '김길동', 21, '여', '서울', '1강의실');
insert into may10_student
values(may10_student_seq.nextval, '이길동', 23, '여', '서울', '2강의실');
insert into may10_student
values(may10_student_seq.nextval, '박길동', 24, '여', '분당', '3강의실');
insert into may10_student
values(may10_student_seq.nextval, '정길동', 25, '여', '부천', '3강의실');
insert into may10_student
values(may10_student_seq.nextval, '장길동', 23, '남', '서울', '4강의실');
insert into may10_student
values(may10_student_seq.nextval, '강길동', 21, '남', '서울', '4강의실');

create table may10_course(
	c_title varchar2(10 char) primary key,
	c_category varchar2(10 char) not null
);
insert into may10_course values('네트워크', '엔지니어');
insert into may10_course values('인공지능', '개발자');
insert into may10_course values('빅데이터', '개발자');

create table may10_pay(
	p_c_category varchar2(10 char) primary key,
	p_pay number(3) not null
);
insert into may10_pay values('엔지니어', 30);
insert into may10_pay values('개발자', 35);


select * from may10_lectureroom;
select * from may10_student;
select * from may10_course;
select * from may10_pay;