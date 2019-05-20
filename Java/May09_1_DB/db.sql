-- 테이블 만들기
-- 		create table 테이블명(
--	 		필드명 자료형 옵션,
--	 		필드명 자료형 옵션,
--	 		...
-- 		);

-- 테이블 지우기
--		drop table 테이블명 cascade constraint purge;

-- 시퀀스 만들기
--		create sequence 시퀀스명;


-- C(Create) : 데이터 만들기
-- 		insert into 테이블명(필드명, 필드명, ...) 
-- 		values(값, 값, ...);

-- R(Read) : 데이터 읽기
-- 		select 필드명, 필드명 (as 별명), ...
-- 		from 테이블명, 테이블명, ...
-- 		where 조건식
--		order by 필드명 (desc), 필드명 (desc), ...;

-- U(Update) : 데이터 수정하기
--		update 테이블명
--		set 필드명=값, 필드명=값, ...
--		where 조건;

-- D(Delete) : 데이터 삭제하기
--		delete from 테이블명
--		where 조건;

-- 계란과자, 오리온, 1500원, 유통기한이 지금이순간
insert into may08snack 
values(may08snack_seq.nextval, 
'계란과자', 1500, '오리온', sysdate);

-- 맛동산, 해태, 2000원, 유통기한이 오늘오전11시까지
insert into may08snack 
values(may08snack_seq.nextval, 
'맛동산', 2000, '해태', to_date('2019050911', 'YYYYMMDDHH'));

-- 과자 최고가 얼마?
select max(s_price) from may08snack;
-- 과자는 모두 몇 종류?
select count(*) from MAY08SNACK;
-- 모든 과자들의 이름, 가격, 유통기한 조회
select s_name, s_price, s_exp from MAY08SNACK;
-- 1000원 이상인 과자들의 이름, 가격, 부가세 조회
select s_name, s_price, s_price*0.1
from MAY08SNACK
where s_price >= 1000;
-- 이름에 '칩'들어가는 과자들의 평균가 조회
select avg(s_price)
from MAY08SNACK
where s_name like '%칩%';
-- 유통기한 지나지 않은 과자들의 모든 정보 조회
-- 유통기한이 2019/05/09 오전10:06보다 큰거
select * from may08snack
where s_exp > sysdate; 

sysdate -- 날짜(2019/05/09 오전10:10:10)
select sysdate from dual;

to_char(sysdate, 'YYYYMMDD') -- 문자열(20190509)
select to_char(sysdate, 'YYYYMMDD') from dual;

-- 문자열(20190509235959)
concat(to_char(sysdate, 'YYYYMMDD'), '235959')
select concat(to_char(sysdate, 'YYYYMMDD'), '235959')
from dual;

-- HH24 : 24시간제
-- 날짜(20190509235959)
to_date(concat(to_char(sysdate, 'YYYYMMDD'), '235959'),'YYYYMMDDHH24MISS')
select to_date(concat(to_char(sysdate, 'YYYYMMDD'), '235959'),'YYYYMMDDHH24MISS')
from dual;

-- 유통기한이 오늘까지인 과자들의 모든 정보 조회
-- 오늘 오전 9:50(o)
select * from may08snack
where s_exp <= to_date(concat(to_char(sysdate, 'YYYYMMDD'), '235959'),'YYYYMMDDHH24MISS');

-- 유통기한 지난 과자들은 몇 종류
select count(*) from may08snack where s_exp < sysdate;

-- 날짜계산
sysdate + 1 -- 날짜 하루 증가
sysdate + (1/24) -- 한시간 증가
select sysdate + (1/24) from dual; 

-- 유통기한이 내일까지인 과자 모든 정보
select * from may08snack
where s_exp <= to_date(concat(to_char(sysdate+1, 'YYYYMMDD'), '235959'),'YYYYMMDDHH24MISS');
------------------
-- 1000<가격<2000 과자 모든 정보
-- 가격 > 1000 && 가격 < 2000
select * from may08snack
where s_price > 1000 and s_price < 2000;

-- 서울에 있거나, 수원에 있는 회사의 모든 정보
select * from MAY08COMPANY
where c_addr = '서울' or c_addr = '수원';
-- 100<직원수<300 회사는 몇군데
select count(*) from MAY08COMPANY
where c_employee > 100 and c_employee < 300;
-- '초코'나 '칩'이 포함된 과자 평균가
select avg(s_price) from MAY08SNACK
where s_name like '%초코%' or s_name like '%칩%';
-- 유통기한 2019/01/01 ~ 2019/12/31인 과자의 모든 정보
select * from MAY08SNACK
where 
	s_exp >= to_date('2019/01/01', 'YYYY/MM/DD')
	and
	s_exp <= to_date('20191231235959', 'YYYYMMDDHH24MISS');
	
-- 롯데에서 만들었거나 과자 가격이 2000원 미만인 과자의 평균가
select avg(s_price) from MAY08SNACK
where s_maker = '롯데' or s_price < 2000;
-------------------------------------------------------------
-- max, min, ... : select(o), where(x)
-- 최고가
select max(s_price)
from MAY08SNACK;
-- subquery
-- 제일 비싼 과자 이름
select s_name
from MAY08SNACK
where s_price = 
	(
		select max(s_price)
		from MAY08SNACK
	);
-- 직원수 제일 적은 회사이름, 직원수, 주소
select c_name, c_employee, c_addr
from MAY08COMPANY
where c_employee = (
	select min(c_employee)
	from MAY08COMPANY
);
-- 평균가보다 비싼 과자이름, 가격, 회사
select s_name, s_price, s_maker
from MAY08SNACK
where s_price > (
	select avg(s_price)
	from MAY08SNACK
);

select s_maker
from MAY08SNACK
where s_name = '계란과자';
-- 계란과자는 어떤 지역에서 만들어졌나
select c_addr
from MAY08COMPANY
where c_name = (
	select s_maker
	from MAY08SNACK
	where s_name = '계란과자'
);

-- 홍길동네 회사에서 만든 과자이름, 가격
select s_name, s_price
from MAY08SNACK
where s_maker = (
	select c_name
	from MAY08COMPANY
	where c_ceo = '김길동'
);

-- 직원수가 가장 많은 회사에서 만든 과자 평균가
select avg(s_price)
from MAY08SNACK
where s_maker = (
	select c_name
	from MAY08COMPANY
	where c_employee = (
		select max(c_employee)
		from MAY08COMPANY
	)
);

-- 제일 비싼 과자 만든 회사이름, 위치
select c_name, c_addr
from MAY08COMPANY
where c_name in (
	select s_maker
	from MAY08SNACK
	where s_price = (
		select max(s_price)
		from MAY08SNACK
	)
);

-- 평균가보다 비싼 과자 만든 회사이름, 위치
select c_name, c_addr
from MAY08COMPANY
where c_name in (
	select s_maker
	from MAY08SNACK
	where s_price > (
		select avg(s_price)
		from MAY08SNACK
	)
);
--------------------------------------------------------
-- join
select *
from MAY08SNACK, MAY08COMPANY
where s_maker = c_name;

-- 모든 과자이름, 가격, 회사이름, 위치, 직원수, 유통기한
select s_name, s_price, s_maker, c_addr, c_employee, s_exp
from MAY08SNACK, MAY08COMPANY
where s_maker = c_name;

-- 가격이 1000원 이상인 과자이름, 가격, 회사이름, ceo이름
select s_name, s_price, s_maker, c_ceo
from MAY08SNACK, MAY08COMPANY
where s_maker = c_name and s_price >= 1000;
-- 평균가보다 비싼 과자이름, 가격, 회사이름, 회사위치
select s_name, s_price, s_maker, c_addr
from MAY08COMPANY, MAY08SNACK
where c_name = s_maker 
	and s_price > (
		select avg(s_price)
		from MAY08SNACK
	);
-- '초코'들어가는 과자이름, 가격, 회사이름, 직원수
select s_name, s_price, c_name, c_employee
from MAY08COMPANY, MAY08SNACK
where c_name = s_maker and s_name like '%초코%';
-- 유통기한 제일 오래남은 과자이름, 가격, 회사이름, 회사위치
select s_name, s_price, s_maker, c_addr
from MAY08COMPANY, MAY08SNACK
where c_name = s_maker 
	and s_exp = (
		select max(s_exp)
		from MAY08SNACK
	);
-- 오늘 ~ 20191231일까지 유통기한인 과자의 전체정보(과자,회사)
sysdate
to_char(sysdate, 'YYYYMMDD')
to_date(to_char(sysdate, 'YYYYMMDD'), 'YYYYMMDD')

to_date('20191231235959', 'YYYYMMDDHH24MISS')

select *
from MAY08COMPANY, MAY08SNACK
where c_name = s_maker 
	and s_exp >= to_date(to_char(sysdate, 'YYYYMMDD'), 'YYYYMMDD')
	and s_exp <= to_date('20191231235959', 'YYYYMMDDHH24MISS');
	
-- 과자 테이블 전체조회, 과자이름 가나다순
select *
from MAY08SNACK
order by s_name;

-- 회사 테이블 전체조회, 지역명 가나다순
--	(지역명 같으면 직원수 내림차순)
select *
from MAY08COMPANY
order by c_addr, c_employee desc;

-- 평균가보다 비싼 과자이름, 가격, 회사명, 회사위치
-- 과자이름 가나다순
--	(같으면 가격 오름차순, 같으면 회사명 가나다역순)

select s_name, s_price, s_maker, c_addr
from MAY08COMPANY, MAY08SNACK
where c_name = s_maker
	and s_price > (
		select avg(s_price)
		from MAY08SNACK
	)
order by s_name, s_price, s_maker desc;

-- rownum : 가상필드
--		rownum이 order by보다 먼저
--		1번부터 조회해야

-- 과자 가나다순 정렬
-- 2번째 ~ 7번째과자 
select *
from (
	select rownum as rn, s_name, s_price
	from (
		select *
		from MAY08SNACK
		order by s_name
	)
)
where rn >= 2 and rn <= 7;
---------------------------------------------------------
-- 계란과자를 2500원으로 수정
update MAY08SNACK
set s_price = 2500
where s_name = '계란과자';

-- 농심을 제주, 1000명으로 수정
update MAY08COMPANY
set c_addr='제주', c_employee=1000
where c_name='농심';

-- 제일 싼 과자를 공짜
update MAY08SNACK
set s_price = 0
where s_price = (
	select min(s_price)
	from MAY08SNACK
);
-- 서울에서 만든 과자들 유통기한을 2020/01/01로
update MAY08SNACK
set s_exp = to_date('20200101', 'YYYYMMDD')
where s_maker in (
	select c_name
	from MAY08COMPANY
	where c_addr = '서울'
);

-- '초코'들어간 과자 가격 10% 상승
update MAY08SNACK
set s_price = s_price * 1.1
where s_name like '%초코%';

-- 평균가보다 높은 과자 가격 20% 다운
update MAY08SNACK
set s_price = s_price * 0.8
where s_price > (
	select avg(s_price)
	from MAY08SNACK
);
-- 서울지역 회사 직원 10명씩 해고
update MAY08COMPANY
set c_employee = c_employee - 10
where c_addr = '서울';

-- 제일 비싼과자의 가격을 평균가에서 1000원 더한걸로
update MAY08SNACK
set s_price = (select avg(s_price) from may08snack) + 1000
where s_price = (
	select max(s_price) 
	from MAY08SNACK
);
-- 평균 직원수보다 많은 회사의 직원수를 평균직원수로
update MAY08COMPANY
set c_employee = (select avg(c_employee) from MAY08COMPANY)
where c_employee > (
	select avg(c_employee)
	from MAY08COMPANY
);
----------------------------------------------------------
-- 제일 비싼 과자 삭제
delete from MAY08SNACK
where s_price = (
	select max(s_price) 
	from MAY08SNACK
);
-- 평균 직원수보다 직원수가 적은 회사 삭제
delete from MAY08COMPANY
where c_employee < (
	select avg(c_employee)
	from MAY08COMPANY
);

select * from MAY08SNACK order by s_name;
select * from MAY08COMPANY order by c_name;



















