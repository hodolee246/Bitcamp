/*
    view : 가상 테이블                           *dual : 가상 테이블
    실제 저장되는 것은 아니다(view)  --> pointer
    [int * p;
    int number;
    p = &number; , number를 통해서 p로 접근을 할 수 있어진다.] 자바
    한개의 view로 여러개의 테이블의 데이터를 검색하는 것이 가능하다.
    처리 속도가 빠르다.
    제한을 설정할 수 있다. --> readonly  view는 실체가 없어서 저장공간이 없다.
*/

CREATE VIEW UB_TEST_01(

    JOB_ID,
    JOC_TITLE,
    MIN_SALARY
)
AS
SELECT JOB_ID, JOB_TITLE, MIN_SALARY
FROM JOBS;

SELECT
    *
FROM UB_TEST_01;

INSERT INTO UB_TEST_01
VALUES('DEVELOPER', '개발자', 1000);

SELECT
    *
FROM JOBS

ROLLBACK;
COMMIT;

CREATE TABLE TB_TEST_02(
    KEY_01 VARCHAR2(10),
    KEY_02 VARCHAR2(10),
    COL_01 VARCHAR2(20),
    COL_02 VARCHAR2(20),
    CONSTRAINT PK_TEST_02 PRIMARY KEY(KEY_01, KEY_02)
);
CREATE OR REPLACE VIEW UB_TEST_02(  -- OR REPLACE == 생성을 할때마다 위에 덮씌워서 생성을 시킨다(원래라면 그냥 생성하면 이미 있다고 오류가 뜬다.)
    KEY_01,
    KEY_02,
    COL_01,
    CONSTRAINT PK_UB_TEST_02 PRIMARY KEY(KEY_01, KEY_02)
        DISABLE NOVALIDATE   
)
AS
SELECT KEY_01, KEY_02, COL_01
FROM TB_TEST_02;
/*
    무결성 = CONSTRAINT
    PRIMARY KEY (기본키)   UNIQUE KEY + NOT NULL
    UNIQUE      고유키     하나밖에 없는 + NULL 허용
    NOT NULL              NULL을 허용 안함
    CHECK                 지정한 값이나 범위안의 값이외에 NUMM을 허용
    FORELGN KEY           1. TABLE. 2.TABLE 연결  NULL 허용
*/

SELECT * FROM TB_TEST_02;
SELECT * FROM UB_TEST_02;

INSERT INTO UB_TEST_02(KEY_01, KEY_02, COL_01)
VALUES('AAA', 'aaa', '111');

INSERT INTO UB_TEST_02(KEY_01, KEY_02, COL_01)
VALUES('AAA', 'aaa', '111'); -- 중복이기에 오류가 발생한다(기본키)

INSERT INTO UB_TEST_02(KEY_01, KEY_02, COL_01)
VALUES('AAA', '', '111'); -- 널이니까 오류가 발생한다(기본키)

INSERT INTO UB_TEST_02(KEY_01, KEY_02, COL_01)
VALUES('AAA', 'AAA', '111'); -- KEY_01, KEY_02는 한 쌍의 기본키 이기에 중복이 아니게 된다.
-- AAA aaa
-- AAA AAA 

CREATE OR REPLACE VIEW EMPVIEW(
    "사원번호",     
    "성",
    "이메일",
    "입사일",
    "업무",
    CONSTRAINT PK_UB_EMP PRIMARY KEY("사원번호") DISABLE NOVALIDATE
    -- 기본키 아이디 값은 충돌(중복)날 경우 오류가 발생한다.
    -- 기본키 아이디 설정하는 이유는 설정을 해야 원할때 테이블의 기본키를 삭제할 수 있다 그렇지 않을경우 테이블을 날려야한다.
    -- 기본키 설정 컬럼은 한글도 가능하다
)
AS
SELECT employee_id, LAST_NAME, EMAIL, HIRE_DATE, JOB_ID
FROM EMPLOYEES
WITH READ ONLY;     -- VIEW를 창문으로 데이터를 보는것만 가능하다 (수정은 불가능하다)

SELECT
    *
FROM EMPVIEW;

INSERT INTO EMPVIEW
VALUES(300,'집가고싶다','GOHOME@NAVER.COM', SYSDATE, 'GO_HOME');
-- READ ONLY에 데이터를 집어넣으려고 했기에 오류가 발생한다.




























