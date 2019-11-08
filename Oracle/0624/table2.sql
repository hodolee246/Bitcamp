/*
    무결성 : 컬럼의 지정하는 성질이다
    -- primary key : 기본키, NULL을 허용하지 않음.정복으로 활용하지 않는다. ( 아이디, 주민번호에 많이 사용됨 )
    unique key : 고유키. NULL을 허용. 중복을 허용하지 않음.
    cheak : 범위 설정. 선택 값을 설정. NULL을 허용한다.
    forign key : 외래키. 다른 테이블에서 PRIMRY KEY 이거나 UNIQUE KEY 일 가능성이 있다, 
                 테이블과 테이블을 연결해 주는 목적을 가지고 있다.
    not null : NULL을 허용하지 않겠다.

*/

DROP TABLE TB_TEST;

CREATE TABLE TB_TEST(
    COL_01 VARCHAR2(10) NOT NULL,
    COL_02 VARCHAR2(10)
);

INSERT INTO TB_TEST(COL_01, COL_02)
VALUES ('AAA', 'aaa');

INSERT INTO TB_TEST(COL_01, COL_02)
VALUES ('BBB', '');

INSERT INTO TB_TEST(COL_01, COL_02)
VALUES ('', 'CCC');

-- PRIMARY KEY
DROP TABLE TEST_01;

-- 테이블을 만들때 기본키를 N개 생성
CREATE TABLE TEST_01(
    KEY_01 VARCHAR2(10),
    KEY_02 VARCHAR2(10),
    COL_01 VARCHAR2(20),
    COL_02 VARCHAR2(30),
    CONSTRAINT PK_TEST_01 PRIMARY KEY(KEY_01, KEY_02)
);

DROP TABLE TEST_01;

CREATE TABLE TEST_01(
    KEY_01 VARCHAR2(10) ,
    KEY_02 VARCHAR2(10),
    COL_01 VARCHAR2(20),
    COL_02 VARCHAR2(30)
   
);

ALTER TABLE TEST_01
ADD
CONSTRAINT PK_TEST_01
PRIMARY KEY(KEY_01, COL_01);

ALTER TABLE TEST_01
DROP CONSTRAINT PK_TEST_01;

-- PRIMARY KEY 확인할 수 있는 쿼리문
SELECT
    *
FROM user_constraints
WHERE table_name = 'TEST_01'
    AND constraint_type = 'P';

DROP TABLE TEST_01;

CREATE TABLE TEST_01(
    KEY_01 VARCHAR2(10) ,
    KEY_02 VARCHAR2(10),
    COL_01 VARCHAR2(20),
    COL_02 VARCHAR2(30)
);

INSERT INTO TEST_01(key_01, KEY_02, COL_01, COL_02)
VALUES('AAA', 'aaa', '111', '222');
-- 중복값 에러
INSERT INTO TEST_01(key_01, KEY_02, COL_01, COL_02)
VALUES('AAA', 'aaa', '111', '222');
-- NULL 값 ㅔㅇ러
INSERT INTO TEST_01(key_01, KEY_02, COL_01, COL_02)
VALUES('', 'aaa', '111', '222');

CREATE TABLE TEST_01(
    KEY_01 VARCHAR2(10),
    KEY_02 VARCHAR2(10),
    COL_01 VARCHAR2(20),
    COL_02 VARCHAR2(30),
    CONSTRAINT PK_TEST_01 PRIMARY KEY(KEY_01, KEY_02)
);

INSERT INTO TEST_01(key_01, KEY_02, COL_01, COL_02)
VALUES('AAA', 'aaa', '111', '222');

-- 중복값 에러
INSERT INTO TEST_01(key_01, KEY_02, COL_01, COL_02)
VALUES('AAA', 'aaa', '111', '222');
-- 에러가 안뜬다 ( KEY를 2개를 주더라도 결국에는 한쌍으로 보기에 AAA aaa 가 들어갔다고 판단한다 그래서 AAA AAA는 다른 값으로 생각한ㄷㅏ.
INSERT INTO TEST_01(key_01, KEY_02, COL_01, COL_02)
VALUES('AAA', 'AAA', '111', '222');

SELECT
    *
FROM TEST_01;

-- 기본키 는 중복값, NULL 값을 넣을 수 없다.

-- 고유한 값
-- UNIQUE 중복은 허용않아지만 눌은 허용한다.
CREATE TABLE TEST_02(
    KEY_01 VARCHAR2(10) CONSTRAINT UK_TEST_01 UNIQUE,
    KEY_02 VARCHAR2(10),
    COL_01 VARCHAR2(20),
    COL_02 VARCHAR2(20)
);

INSERT INTO TEST_02(KEY_01, KEY_02, COL_01, COL_02)
VALUES('AAA', 'aaa', '111', '123');

DROP TABLE TEST_02
CASCADE CONSTRAINTS;    -- 무결성까지 모두 삭제한다.

CREATE TABLE TEST_02(
    KEY_01 VARCHAR2(10),
    KEY_02 VARCHAR2(10),
    COL_01 VARCHAR2(20),
    COL_02 VARCHAR2(20),
    CONSTRAINT UK_TEST_01 UNIQUE(KEY_01, KEY_02)
);

INSERT INTO TEST_02(KEY_01, KEY_02, COL_01, COL_02)
VALUES('AAA', 'aaa', '111', '123');
-- 중복값이므로 에러가난다
INSERT INTO TEST_02(KEY_01, KEY_02, COL_01, COL_02)
VALUES('AAA', 'aaa', '111', '123');
-- 유니크 키는 널값을 허용하기에 에러가 안난다.
INSERT INTO TEST_02(KEY_01, KEY_02, COL_01, COL_02)
VALUES('AAA', '', '111', '123');

-- CHECK     원하는 값만 골라서 집어넣는다 단 눌은 허용한다.
CREATE TABLE TEST_03(
    KEY_01 VARCHAR2(10),
    KEY_02 VARCHAR2(10),
    COL_01 VARCHAR2(20),
    COL_02 NUMBER,
    CONSTRAINT CHK_TEST_01 CHECK(COL_01 IN('사과', '배', '바나나')),
    CONSTRAINT CHK_TEST_02 CHECK(COL_02 > 0 AND COL_02 <=100)
);
-- CHECK 중복값, 널값 허용
-- CHECK 설정한 CHECK 값과 NULL 값을 제외하고 다른 값을 집어넣으면 에러난다.
INSERT INTO TEST_03(KEY_01, KEY_02, COL_01, COL_02)
VALUES('AAA', 'aaa', '사과', '1');

INSERT INTO TEST_03(KEY_01, KEY_02, COL_01, COL_02)
VALUES('AAA', 'aaa', '사과', '1');

INSERT INTO TEST_03(KEY_01, KEY_02, COL_01, COL_02)
VALUES('AAA', 'aaa', '배', '0');

INSERT INTO TEST_03(KEY_01, KEY_02, COL_01, COL_02)
VALUES('AAA', 'aaa', '', '');

SELECT
    *
    FROM TEST_03;
DROP TABLE TEST_03;

-- 외래키 FOREIGEN KEY
-- 부모테이블


CREATE TABLE TEST_PAR(  -- DEPARTMENTTS, JOBS
    KEY_01 VARCHAR2(10),
    KEY_02 VARCHAR2(10),
    COL_01 VARCHAR2(10),
    COL_02 VARCHAR2(10),
    CONSTRAINT PK_TEST_PAR PRIMARY KEY(KEY_01, KEY_02)
);

CREATE TABLE TEST_CHD(  -- EMPLOYEES
    KEY_01 VARCHAR2(10) CONSTRAINT PK_TEST_CHD PRIMARY KEY,
    FK_KEY_01 VARCHAR2(10),
    FK_KEY_02 VARCHAR2(10),
    CONSTRAINT FK_TEST_CHD FOREIGN KEY(FK_KEY_01, FK_KEY_02)
        REFERENCES TEST_PAR(KEY_01, KEY_02) -- 알려주는 부분
);

INSERT INTO TEST_PAR(KEY_01, KEY_02, COL_01, COL_02)
VALUES ('AAA', 'aaa', '111', '222');

INSERT INTO TEST_PAR(KEY_01, KEY_02, COL_01, COL_02)
VALUES ('BBB', 'bbb', '222', '333');

INSERT INTO TEST_PAR(KEY_01, KEY_02, COL_01, COL_02)
VALUES ('CCC', 'ccc', '333', '444');

SELECT
    *
FROM TEST_PAR;

INSERT INTO TEST_CHD(KEY_01 ,fk_key_01, FK_KEY_02)
VALUES('111', 'AAA', 'aaa');

-- 부모 테이블에 데이터가 없다 무결성 에러
INSERT INTO TEST_CHD(KEY_01 ,fk_key_01, FK_KEY_02)
VALUES('222', 'AAA', 'BBB');

INSERT INTO TEST_CHD(KEY_01 ,fk_key_01, FK_KEY_02)
VALUES('222', 'BBB', 'bbb');

INSERT INTO TEST_CHD(KEY_01 ,fk_key_01, FK_KEY_02)
VALUES('333', '', '');

-- 외래키는 내부에 키값과 동일하던가 혹은 NULL 값만 허용한다.

SELECT
    *
FROM test_chd;


commit;     -- 커밋시 데이터가 db에 저장되기 때문에 롤백을해도 저장이 되어있다.

rollback;   -- 롤백시 데이터 저장 X

INSERT INTO test_par(KEY_01, KEY_02, COL_01, COL_02)
VALUES('DDD', 'ddd', '444', '555');

INSERT INTO test_par(COL_01, COL_02, KEY_01, KEY_02)
VALUES('DDD', 'ddd', '444', '555');

INSERT INTO test_par
VALUES('EEE', 'eee', '555', '666');

INSERT INTO test_par(KEY_01, KEY_02)
VALUES('FFF', 'fff');

SELECT
    *
FROM TEST_PAR;

CREATE TABLE TB_TEST_BK
AS
SELECT
    *
FROM JOBS;

SELECT
    *
FROM TB_TEST_BK;

-- UPDATE

UPDATE TB_TEST_BK
SET min_salary = 0, max_salary = 100 -- N개의 값을 바꾸고 싶으면 ,로 관리한다.
WHERE job_id LIKE 'AD%';

UPDATE TB_TEST_BK
SET min_salary = 0, max_salary = 0
WHERE max_salary > 10000;

ROLLBACK;

-- DELETE

DELETE
FROM TB_TEST_BK
WHERE max_salary < 10000;

DROP TABLE TB_TEST_BK;








