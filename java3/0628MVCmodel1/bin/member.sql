-- 무결성에 관한걸 다 지워라
DROP TABLE MEMBER
CASCADE CONSTRAINTS;


CREATE TABLE MEMBER(
	ID VARCHAR2(20) PRIMARY KEY,	-- 아이디는 중복이 되면 안된다 == 기본키
	PWD VARCHAR2(50) NOT NULL,		-- 비밀번호를 빈칸으로 해서 db에 저장하는걸 막는다.
	NAME VARCHAR2(50) NOT NULL,		-- ""
	EMAIL VARCHAR2(50) UNIQUE,		-- 중복은 불가능하지만 NULL 은 가능 -- 사용자 입력
	AUTH NUMBER(1) NOT NULL			-- 사용자 입력은 이메일까찌 이거는 직접 입력해주는거다.

)

select * from MEMBER;