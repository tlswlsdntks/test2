
CREATE TABLE member(
id VARCHAR2(10) PRIMARY KEY,
password VARCHAR2(30) NOT NULL,
name VARCHAR2(30) NOT NULL,
birth DATE NOT NULL
)

SELECT * FROM member

DROP TABLE member

CREATE TABLE board(
num NUMBER PRIMARY KEY,
writer VARCHAR2(10) NOT NULL,
title VARCHAR2(60) NOT NULL,
content VARCHAR2(1000) NOT NULL,
readCnt NUMBER DEFAULT 0, 
writeDay DATE DEFAULT SYSDATE,
repRoot NUMBER, 
repStep NUMBER, 
repIndent NUMBER,
id VARCHAR2(10), CONSTRAINT fk_member_id FOREIGN KEY(id) REFERENCES member(id) 
)

SELECT * FROM board

DROP TABLE board

SELECT CONSTRAINT_NAME FROM USER_CONSTRAINTS;

alter table board drop constraint fk_member_id
