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

ALTER TABLE TECH_STACKS
ADD CONSTRAINT unique_stack UNIQUE(STACK_TYPE, STACK_NM);

INSERT INTO TECH_STACKS (STACK_TYPE, STACK_NM) VALUES
-- Language로도 추가
('Language', 'HTML'),
('Language', 'CSS'),
('Language', 'JavaScript');

SELECT * FROM PROJECTS where user_id='mstop0809';
select * from RECRUITS;

<<<<<<< HEAD
SELECT * FROM TASKS;
=======
CREATE TABLE RECRUIT_STACKS(
    `R_STACK_IDX` INT NOT NULL AUTO_INCREMENT COMMENT '모집 스텍 식별자',
    `RC_IDX` INT NOT NULL COMMENT '모집 식별자',
    `STACK_IDX` INT NOT NULL COMMENT '스텍 식별자',
    PRIMARY KEY (R_STACK_IDX)
);

ALTER TABLE RECRUIT_STACKS
    ADD CONSTRAINT FK_RECRUIT_STACKS_RC_IDX_RECRUITS_RC_IDX
    FOREIGN KEY (RC_IDX)
    REFERENCES RECRUITS (RC_IDX) ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE RECRUIT_STACKS
    ADD CONSTRAINT FK_RECRUIT_STACKS_STACK_IDX_TECH_STACKS_STACK_IDX
    FOREIGN KEY (STACK_IDX)
    REFERENCES TECH_STACKS (STACK_IDX) ON DELETE RESTRICT ON UPDATE RESTRICT;
<<<<<<< HEAD

select * from JOININGS;
delete from JOININGS;
delete from NOTIFICATIONS;
select * from NOTIFICATIONS;
=======
>>>>>>> branch 'master' of https://github.com/2024-SMHRD-KDT-BigData-32/mz_company_test.git
>>>>>>> branch 'master' of https://github.com/2024-SMHRD-KDT-BigData-32/mz_company_test.git
