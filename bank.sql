bank 데이터베이스 생성

create database bank;

테이블 생성

create table member(
	id varchar(10) not null primary key,
	name varchar(10) not null,
	age int(11) not null,
	tel int(20) not null
	);
	
삽입(sql)

insert into member values(?,?,?,?)

수정(sql)

update member set tel=? where id=?

삭제(sql)

delete from member where id = ?

검색(sql)

select * from member where id=?

전체검색(sql)

select * from member