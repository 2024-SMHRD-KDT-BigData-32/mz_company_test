-- Member 테이블 생성
create table Member(
	email varchar(100) not null,
	pw varchar(100) not null,
	tel varchar(100) not null,
	address varchar(100) not null,
	primary key(email)
);

-- test 데이터 삽입하기
insert into Member values('admin@gmail.com', '1234', '010-1234-5678', '우산동');

select * from board;

-- board 테이블 생성
-- idx, title, writer, filename, contents, b_date
create table board (
	idx int not null auto_increment, 
	title varchar(100) not null,
	writer varchar(100) not null, 
	filename varchar(100) not null,
	content varchar(1000) not null,
	b_date datetime default now(),
	primary key(idx)
);

insert into board(title, writer, filename, content)
values('test1', 'test1', 'test1', 'test1');
insert into board(title, writer, filename, content)
values('test2', 'test2', 'test2', 'test2');




SELECT * FROM TASKS;
