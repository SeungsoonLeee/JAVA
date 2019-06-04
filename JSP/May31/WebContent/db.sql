create table jun03_product(
	p_no number(5) primary key,
	p_name varchar2(10 char) not null,
	p_price number(6) not null,
	p_desc varchar2(150 char) not null,
	p_photo varchar2(100 char) not null
);
create sequence jun03_product_seq;
select * from jun03_product;

create table may31_snack(
	s_no number(5) primary key,
	s_name varchar2(10 char) not null,
	s_price number(5) not null,
	s_exp date not null,
	s_desc varchar2(100 char) not null
);
select * from may31_snack;

create sequence may31_snack_seq;


create table may31_product(
	p_name varchar2(10 char) primary key,
	p_price number(5) not null
);

insert into may31_product values('Å×½ºÆ®', 1);

select * from may31_product;
