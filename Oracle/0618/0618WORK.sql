-- DML(INSERT, DELETE, SELECT(90%), UPDATE) 
-- PL (PROCEDURAL LANGUAGE) PL은 이클립스에서 제작은 못한다

SELECT * FROM EMP;       -- SCOOTT 계정의 사원테이블

SELECT * FROM EMPLOYEES; -- HR(HUMAN RESOURCE)
/*
SELECT 절  선택
    *  모든 (값, 문자, COLUMN, 함수, SUB QUERY
                                    QUERY 안에 QUERY가 하나 더 있는걸 서브 쿼리라하낟.
FROM 절 (테이블명, SUB QUERY 
*/

-- 현재 계정의 테이블 모두 명세(출력한다)
SELECT * FROM TAB;

-- 테이블에서 원하는 COLUMN만을 명세
SELECT EMPNO, ENAME, SAL
    
FROM EMP;

-- DUAL : 가상 테이블
SELECT SYSDATE FROM DUAL;

SELECT 4 * 9 FROM DUAL;

SELECT 'HELLO' || 'HELLO' FROM DUAL; -- 문자열 붙이기 자바에서는 + 라면 여기는 ||이다.

SELECT ROUND(11.4) FROM DUAL; -- ROUND(반올림)

SELECT ENAME, SAL, SAL + 300
FROM EMP;

SELECT SAL, SAL * 12
FROM EMP;

-- ALIAS int alias[] = array;   alias[] = 12;

SELECT
SAL AS "월급", SAL * 12 AS 연봉 -- AS 에서는 큰따움표를 사용한다 사용을 안하더라도 출력은 가능하지만
-- 중간에 띄어쓰기가 있을경우 오라클이 인식을 못해서 오류를 일으키니 띄어쓰기
-- 값이 널어질경우 큰따움표를 사용해야 정삭적으로 출력이된다.
FROM EMP;

-- 연결 연산자 ||  JAVA "ABC" + "DEF"    ORACLE "ABC" || "DEF"
SELECT
ENAME || ' has $ ' || SAL
FROM EMP;

-- distint : 중복행(row) 삭제 == group by (사용 빈도는 이게 더 높음)

SELECT
DISTINCT DEPTNO
FROM EMP;

-- DESC : 테이블의 COLUMN의 자료형과 구조를 명세
DESC EMP;

-- 1번
SELECT
EMPNO, ENAME, SAL
FROM EMP;

-- 2번
SELECT
ENAME AS "이 름", SAL AS "월 급"    -- as는 생략이 가능하다. 그냥 붙여라
FROM EMP;

-- 3번
SELECT
EMPNO AS "사원번호", ENAME AS "사원이름", SAL AS "월급", SAL * 12 AS "연봉"    
FROM EMP;

-- 4번
SELECT
DISTINCT JOB
FROM EMP;

-- 5번
SELECT
'(' || ENAME || ', ' || JOB || ')' AS "Employee and Job"    
FROM EMP;

-- 6번

SELECT
LAST_NAME AS "이름", SALARY AS "급여"
FROM EMPLOYEES;

-- 7번
SELECT
LAST_NAME AS "NAME", salary*12 AS "Annual Salary(연봉)"    
FROM EMPLOYEES;

-- 8번
SELECT
LAST_NAME || JOB_ID
FROM EMPLOYEES;

-- 9번
SELECT
LAST_NAME || ' is a ' || JOB_ID AS "employees Details"
FROM employees;

-- 10번
SELECT
LAST_NAME || ': 1 Year Salary =' || salary * 12 AS "MONTHLY"
FROM EMPLOYEES;

-- 11번
SELECT
job_id
FROM EMPLOYEES;

-- NVL(컬러명, 0)  매개변수 앞은 컬럼명을 넣어주고 (만약에 컬럼이 Null 이라면, 0으로 세팅해라 이 뜻이다.) 뒤에 값이 눌이라면 대입할 값을 입력



