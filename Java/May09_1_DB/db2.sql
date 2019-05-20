-- Oracle, MySQL, MariaDB, ... => RDB(Relational DB)
--		테이블을 나눠놓고, 그 관계를 중심으로 해결

-- 김밥천국 프랜차이즈 DB
-- 설계
--		1. 한줄에는 하나의 정보만
--		2. 종속적인 정보를 따로 테이블을 분리
--		3. 테이블마다 PK가 있는게 좋음
강남점은 역삼동123에 있고,
	제육덮밥(쌀, 돼지고기, 야채, 양념)을 5000원에 팔고,
	불고기덮밥(쌀, 소고기, 야채, 양념)을 5500원에 팔고,
	야채김밥(쌀, 야채, 김)을 4000원에 팔고,
	소고기김밥(쌀, 소고기, 야채, 김)을 4500원에 판다

서초점은 서초동123에 있고,
	불고기덮밥(쌀, 소고기, 야채, 양념)을 6000원에 팔고,
	소고기김밥(쌀, 소고기, 야채, 김)을 5000원에 판다

우리 프랜차이즈에서는 쌀, 돼지고기, 소고기는 국산,
	야채는 북한산,
	양념은 중국산을 제공한다.

may09restaurant		may09ingredient
r_name	|r_addr		i_name	|i_from
PK		|NN			PK		|NN

may09menu									may09menu_seq
m_no 	|m_name	|m_ingredient				
PK,AI	|NN		|NN			

may09sell									may09sell_seq
s_no	|s_r_name	|s_m_name	|s_price
PK,AI	|NN			|NN			|NN
--------------------------------------------------------------
create table may09restaurant(
	r_name varchar2(10 char) primary key,
	r_addr varchar2(10 char) not null
);
insert into may09restaurant values('강남점', '역삼동123');
insert into may09restaurant values('서초점', '서초동123');
--------------------------------------------------------------
create table may09menu(
	m_no number(5) primary key,
	m_name varchar2(10 char) not null,
	m_ingredient varchar2(10 char) not null
);
create sequence may09menu_seq;
insert into may09menu values(may09menu_seq.nextval, '제육덮밥', '쌀');
insert into may09menu values(may09menu_seq.nextval, '제육덮밥', '돼지고기');
insert into may09menu values(may09menu_seq.nextval, '제육덮밥', '야채');
insert into may09menu values(may09menu_seq.nextval, '제육덮밥', '양념');

insert into may09menu values(may09menu_seq.nextval, '불고기덮밥', '쌀');
insert into may09menu values(may09menu_seq.nextval, '불고기덮밥', '소고기');
insert into may09menu values(may09menu_seq.nextval, '불고기덮밥', '야채');
insert into may09menu values(may09menu_seq.nextval, '불고기덮밥', '양념');

insert into may09menu values(may09menu_seq.nextval, '야채김밥', '쌀');
insert into may09menu values(may09menu_seq.nextval, '야채김밥', '야채');
insert into may09menu values(may09menu_seq.nextval, '야채김밥', '김');

insert into may09menu values(may09menu_seq.nextval, '소고기김밥', '쌀');
insert into may09menu values(may09menu_seq.nextval, '소고기김밥', '소고기');
insert into may09menu values(may09menu_seq.nextval, '소고기김밥', '야채');
insert into may09menu values(may09menu_seq.nextval, '소고기김밥', '김');
--------------------------------------------------------------
create table may09ingredient(
	i_name varchar2(10 char) primary key,
	i_from varchar2(10 char) not null
);

insert into may09ingredient values('쌀','국산');
insert into may09ingredient values('돼지고기','국산');
insert into may09ingredient values('소고기','국산');
insert into may09ingredient values('야채','북한산');
insert into may09ingredient values('양념','중국산');
insert into may09ingredient values('김','국산');
--------------------------------------------------------------
create table may09sell(
	s_no number(5) primary key,
	s_r_name varchar2(10 char) not null,
	s_m_name varchar2(10 char) not null,
	s_price number(5) not null
);
create sequence may09sell_seq;
insert into may09sell values(may09sell_seq.nextval, '강남점', '제육덮밥', 5000);
insert into may09sell values(may09sell_seq.nextval, '강남점', '불고기덮밥', 5500);
insert into may09sell values(may09sell_seq.nextval, '강남점', '야채김밥', 4000);
insert into may09sell values(may09sell_seq.nextval, '강남점', '소고기덮밥', 4500);

insert into may09sell values(may09sell_seq.nextval, '서초점', '불고기덮밥', 6000);
insert into may09sell values(may09sell_seq.nextval, '서초점', '소고기김밥', 5000);
--------------------------------------------------------------
select * from may09restaurant;
select * from may09menu;
select * from may09ingredient;
select * from may09sell;
--------------------------------------------------------------
-- 새로운 재료 닭, 브라질산
insert into MAY09INGREDIENT values('닭', '브라질산');
-- 신메뉴 닭강정(닭, 양념)출시
insert into MAY09MENU values(may09menu_seq.nextval, '닭강정', '닭');
insert into MAY09MENU values(may09menu_seq.nextval, '닭강정', '양념');
-- 닭강정을 강남점에서 10000원에 판매
insert into MAY09SELL values(may09sell_seq.nextval, '강남점', '닭강정', 10000);
-- 닭강정을 서초점에서 12000원에 판매
insert into MAY09SELL values(may09sell_seq.nextval, '서초점', '닭강정', 12000);
-- 남산점, 남산꼭대기 식당이 새로 개업
--		제육덮밥을 6000원에
--		닭강정을 15000원에
insert into MAY09RESTAURANT values('남산점','남산꼭대기');
insert into MAY09SELL values(may09sell_seq.nextval, '남산점', '제육덮밥', 6000);
insert into MAY09SELL values(may09sell_seq.nextval, '남산점', '닭강정', 15000);
------------------------------------------------------------
-- 전국의 지점명, 위치
select * 
from MAY09RESTAURANT
order by r_name;

-- 강남점의 메뉴명, 가격
select s_m_name, s_price 
from may09sell 
where s_r_name = '강남점';

-- 서초점의 메뉴명, 재료, 원산지
select m_name, m_ingredient, i_from
from may09menu, may09ingredient
where m_ingredient = i_name
	and m_name in (
		select s_m_name
		from may09sell
		where s_r_name='서초점'
	)
order by m_name;

-- 전체 제육덮밥 평균가격
select avg(s_price) from may09sell where s_m_name = '제육덮밥';

-- 전체 김밥시리즈 최고가
select max(s_price)
from may09sell
where s_m_name like '%김밥';

-- 제일 비싼 메뉴의 이름, 가격, 판매지점, 재료명, 원산지
select s_m_name, s_price, s_r_name, m_ingredient, i_from
from may09sell, may09menu, may09ingredient
where s_m_name = m_name and m_ingredient = i_name
	and s_price = (
		select max(s_price)
		from may09sell
	);
-- 중국산 재료 쓰는 식당명, 메뉴명
select s_r_name, s_m_name
from may09sell
where s_m_name in (
	select m_name
	from may09menu
	where m_ingredient in (
		select i_name
		from may09ingredient
		where i_from = '중국산'
	)
);
-- 강남점에서 가장 비싼 메뉴이름
select s_m_name
from may09sell
where s_price = (
	select max(s_price)
	from may09sell
	where s_r_name = '강남점'
) and s_r_name = '강남점';

-- 서초점이 서초동999로 이전
update may09restaurant
set r_addr = '서초동999'
where r_name = '서초점';

-- 모든 메뉴 가격 10% 올리기
update may09sell
set s_price = s_price * 1.1;

-- 국산재료 쓰는 메뉴 가격 20% 올리기
update may09sell
set s_price = s_price * 1.2
where s_m_name in (
	select distinct m_name
	from may09menu
	where m_ingredient in (
		select i_name
		from may09ingredient
		where i_from = '국산'
	)
);

-- 프랜차이즈에서 더이상 김밥시리즈를 팔지 않기로
delete from may09menu where m_name like '%김밥';
delete from may09sell where s_m_name like '%김밥';

-- 남산점이 폐점
delete from may09restaurant where r_name = '남산점';
delete from may09sell where s_r_name = '남산점';

select s_m_name, s_price, s_r_name, m_ingredient, i_from
from may09sell, may09menu, may09ingredient
where s_m_name=m_name and m_ingredient=i_name
order by s_r_name, s_m_name;

select s_m_name, s_price, s_r_name, r_addr
from may09sell, may09restaurant
where s_r_name = r_name and s_price <= 9000;

select * from may08snack;






