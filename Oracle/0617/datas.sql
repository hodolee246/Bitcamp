Select * FROM employees;

SELECT * FROM EMPLOYEES;    /*     제일 권장(전부다 대문자로 사용)     */

-- 한줄 주석문
/*
범위 주석문
*/

-- 자료형 
-- JAVA   Oracle
-- int == NUMBER
-- String == VARCHAR2
-- double == NUMBER(정수의 자리수, 소수의 자리수)
-- Date == Date


-- 문자열 자료형
-- CHAR
CREATE TABLE TB_CHAR(
    COL_CHAR1 CHAR(10 BYTE),    --  COL_String COL_CHAR1;
    COL_CHAR2 CHAR(10 CHAR),    -- CHAR : 10 BYTE
    COL_CHAR3 CHAR(10)  -- 아무것도 안적으면 바이트로 들어간다.
    
)  ; 

/*
CREATE TABLE 테이블명(
    컬럼명 컬럼의 자료형(크기),
    컬럼명 컬럼의 자로형(크기)

);
*/
INSERT INTO TB_CHAR(COL_CHAR1, COL_CHAR2, COL_CHAR3)
VALUES('ABC', 'ABC', 'ABC'); -- 영문크기 1BYTE, 

SELECT * FROM TB_CHAR;

INSERT INTO TB_CHAR(COL_CHAR1, COL_CHAR2, COL_CHAR3)
VALUES('가나', '가나', '가나'); -- 한글크기 3 BYTE

INSERT INTO TB_CHAR(COL_CHAR1, COL_CHAR2, COL_CHAR3)
VALUES('가나다', '가나다', '가나다');

SELECT col_char1, col_char2, col_char3,
    LENGTHB(col_char1), LENGTHB(col_char2), LENGTHB(col_char3)
FROM TB_CHAR;

/*
CHAR : 10BYTE 00000 00000
ABC ->        ABC00 00000

10 BYTE
가나다 -> 가나다0 (3*3 + 0)

10 CHAR
가 3 + 9 = 12;               가0000 00000
가나 3 + 3 + 8 = 14          가나000 00000
가나다 3 + 3 + 3 + 7 = 16     가나다00 00000
*/

-- VARCHAR2 (문자열)
CREATE TABLE TB_VARCHAR(
    컬럼1 VARCHAR2(10 BYTE),
    컬럼2 VARCHAR2(10 CHAR),
    컬럼3 VARCHAR2(10) -- VARCHAR 도 아무것도 안적으면 BYTE값으로 들어간다.
);

INSERT INTO tb_varchar(컬럼1, 컬럼2, 컬럼3)
VALUES('ABC', 'ABC', 'ABC');

INSERT INTO tb_varchar(컬럼1, 컬럼2, 컬럼3)
VALUES('가나다', '가나다', '가나다');

SELECT "컬럼1", "컬럼2", "컬럼3",
    LENGTHB("컬럼1"), LENGTHB("컬럼2"), LENGTHB("컬럼3")
FROM tb_varchar;

-- LONG 최대 2GB까지 저장 가능
CREATE TABLE TB_LONG(
    COL_LONG1 LONG
--    COL_LONG2 LONG
    
);

INSERT INTO tb_long(COL_LONG1)
VALUES('ABC');

-- 오라클에서 LONG은 2GB까지 저장이 가능한 문자열이다.

-- 숫자 자료형 INTEGER
CREATE  TABLE TB_INTEGER(
COL_INT1 INTEGER,
COL_INT2 INTEGER
);

-- NUMBER(정수, 실수 둘다 사용가능함)

CREATE TABLE TB_NUMBER(
COL_NUM1 NUMBER,
COL_NUM2 NUMBER(5),
COL_NUM3 NUMBER(5, 2),
COL_NUM4 NUMBER(*, 2)
);

INSERT INTO TB_NUMBER(COL_NUM1, COL_NUM2, COL_NUM3, COL_NUM4)
VALUES(1234.5678, 12345, 123.456, 1234.56789);

SELECT * FROM TB_NUMBER;

/*
INSERT INTO TB_NUMBER(COL_NUM1, COL_NUM2, COL_NUM3, COL_NUM4)
VALUES(1234.5678, 12345, 1234.567, 1234.56789);
*/
-- 오류 1234,567 5자리 숫자 안에 소수점 2자리까지이므로  숫자의 범위가 넘어가서 오류가 발생

-- 날짜 자료형 DATE
-- 연도, 월, 일, 시, 분, 초 까지 전부다 들어간다.
CREATE TABLE TB_DATE(
    COL_DATE1 DATE,
    COL_DATE2 DATE
);

INSERT INTO TB_DATE(COL_DATE1, COL_DATE2)
VALUES(SYSDATE, SYSDATE -1);

SELECT * FROM TB_DATE;

INSERT INTO TB_DATE(COL_DATE1, COL_DATE2)
VALUES(SYSDATE, TO_DATE('2019-07-12 10:32:21', 'YYYY-MM-DD HH:MI-SS'));

INSERT INTO TB_DATE(COL_DATE1, COL_DATE2)
VALUES('19/08/15', '19/07/12');

INSERT INTO TB_DATE(COL_DATE1, COL_DATE2)
VALUES(SYSDATE, '2019-07-12 10:32:21');

INSERT INTO TB_DATE(COL_DATE1, COL_DATE2)
VALUES(SYSDATE, TO_DATE('20190712103221', 'YYYYMMDDHHMISS'));

/* VARCHAR2 (문자열) -> DATE(날짜형식으로 바꿀 수 있음) : TO_DATE */
/* DATE(날짜형식) -> VARCHAR2(문자열) : TO_CHAR */



