--문제1) EMP 테이블에서 EMPNO,ENAME,SAL,HIREDATE의 
--COLUMN만 선택하여 EMP_10 테이블을 생성한 후 10번 부서만
--선택하여 이에 대응하는 값을 EMP_10테이블에 입력하여라.

CREATE TABLE EMP_10
AS
SELECT empno, ENAME, SAL, HIREDATE
FROM emp
where 1= 2;

insert into emp_10
select empno, ename, sal, hiredate
from emp
where deptno = 10;

SELECT
    *
FROM emp_10;

-- 문제2) EMP 테이블에서 사원 번호가7788인 사원의 부서를 10번으로 변경하여라.

UPDATE EMP
SET deptno = 10
WHERE empno = 7369;


-- 문제3) EMP 테이블에서 사원 번호가7788인 사원의 부서를 20, 급여를 3500으로 변경하여라.

UPDATE EMP
SET DEPTNO = 20, SAL = 3500
WHERE EMPNO = 7369;


-- 문제4) EMP 테이블에서 10번 부서의 사원을 모두 91번 부서로 갱신하여라.

INSERT INTO dept(DEPTNO, DNAME, LOC)
VALUES ('91', 'Guro', 'Seoul');

UPDATE emp
SET DEPTNO = 91
WHERE DEPTNO = 10;


-- 문제5) DEPT 테이블에서 부서 번호 10을 15로 갱신하여라. -- 칠드런 레코드 낫파운드

INSERT INTO emp
VALUES ('1234', 'INWOO', 'IT', '1234', '19/06/24', '5000', '1500', '15');

UPDATE DEPT
SET deptno = 15
WHERE deptno = 10;



-- 문제6) EMP 테이블에서 사원번호가 7499인 사원의 정보를 삭제하여라.

DELETE
FROM EMP
WHERE empno = 7499;



-- 문제7) EMP 테이블에서 입사일자가 83년인 사원의 정보를 삭제하여라.

DELETE
FROM emp
WHERE hiredate LIKE '83%';



-- 1. 아래의 구조를 만족하는 MY_DATA 테이블을 생성하시오. 단 ID가 PRIMARY KEY이다.

CREATE TABLE MY_DATA(
    M_ID NUMBER(4),
    M_NAME VARCHAR2(10),
    M_USERID VARCHAR2(30),
    M_SALARY NUMBER(10, 2),
    CONSTRAINT M_DATA PRIMARY KEY(M_ID)
);



-- 2. 1번에 의해 생성된 테이블에 아래의 값을 입력하여라.

INSERT INTO MY_DATA
VALUES('1','Scott', 'sscott', '10000');
INSERT INTO MY_DATA
VALUES('2','Ford', 'fford', '13000');
INSERT INTO MY_DATA
VALUES('3','Patel', 'ppatel', '33000');
INSERT INTO MY_DATA
VALUES('4','Report', 'rreport', '23500');
INSERT INTO MY_DATA
VALUES('5','Good', 'ggood', '44450');


-- 3. ID가 3번인 사람의 급여를 65,000.00으로 갱신하고 영구적으로 데이터베이스에 반영하여라.

update my_data
set m_salary = 65000.00
where m_id = 3;

commit;

-- 4. 이름이 Ford인 사원을 영구 제명하여라.

DELETE
FROM MY_DATA
WHERE M_NAME = 'Ford';

SELECT
    *
FROM MY_DATA;

-- 5. 급여가 15,000이하인 사람의 급여를 15,000로 변경하여라.

UPDATE MY_DATA
SET M_SALARY = 15000
WHERE M_SALARY < 15000;




-- 6. 1번에서 생성한 테이블을 삭제하여라.


DROP TABLE MY_DATA;


-- 문제1) EMPLOYEES 테이블에서 부서별로 인원수,평균 급여,
-- 급여의 합,최소 급여,최대 급여를 포함하는 EMP_DEPTNO 테이블을 생성하라.

CREATE TABLE EMP_DEPTNO
-- create table emp_deptno("부서번호", "인원수", "평균급여", ... 이런식으로 create 자체에 써도 as가 적용된다.)
AS
SELECT department_id AS DEPTNO, COUNT(*) AS e_count, AVG(SALARY) AS E_AVG, SUM(SALARY) AS E_SUM, MIN(SALARY) AS E_MIN, MAX(SALARY) AS E_MAX 
FROM employees
GROUP BY DEPARTMENT_ID;

SELECT
    *
FROM emp_deptno;

--문제2) EMP_DEPTNO 테이블에 ETC COLUMN을 추가하라. 
--단 자료형은 VARCHAR2(50) 사용하라.

ALTER TABLE EMP_DEPTNO ADD(
ETC_COLUMN VARCHAR2(50));

--문제3) EMP_DEPTNO 테이블에 ETC COLUMN을 수정하라. 
--자료 형은 VARCHAR2(15)로 하라.


ALTER TABLE EMP_DEPTNO MODIFY(
ETC_COLUMN VARCHAR2(15));

-- 문제4) EMP_DEPTNO 테이블에 있는 ETC 을 삭제하고 확인하라.

ALTER TABLE EMP_DEPTNO DROP(
ETC_COLUMN );

-- 문제 5 이전에 생성한 EMP_DEPTNO 테이블의 이름을 EMP_DEPT로 변경하라.

ALTER TABLE EMP_DEPTNO RENAME TO EMP_DEPT;

--문제6) EMP_DEPT 테이블을 삭제하라.

DROP TABLE EMP_DEPT;

-- 문제7) EMPLOYEES 테이블을 EMP 테이블을 생성하고 복제하도록 하라.
-- (데이터 포함)

CREATE TABLE EMP
AS
SELECT
    *
FROM EMPLOYEES;

-- 문제8) EMP 테이블에 row를 추가해 봅니다.
-- 다만, 반드시 데이터를 기입을 안해도 되면, NULL로 설정하도록 한다.

INSERT INTO employees(employee_id, first_name, last_name, email, phone_number,
hire_date, job_id, salary, commission_pct, manager_id, department_id)
values(300, null, '홍', 'hgd@naver.com', null,
    to_date('2005/10/15', 'YYYY/MM/DD'), 'IT_PROG', 100000, null, null, null);
    

SELECT
    *
FROM EMP;
 
--문제9) EMPLOYEES 테이블에서 EMPNO,ENAME,SAL,HIREDATE의 COLUMN만 선택하여
--EMP_10 테이블을 생성(데이터 미포함)한 후 10번 부서만 선택하여 
--이에 대응하는 값을 EMP_10테이블에 입력하라.

CREATE TABLE EMP_10
AS
SELECT employee_id, last_name, salary, hire_date
FROM EMPLOYEES
WHERE 1=2;
/*
INSERT INTO EMP_10(EMPLOYEE_ID, LAST_NAME, SALARY, HIRE_DATE)
VALUES(SELECT employee_id, last_name, SALARY, HIRE_DATE)
FROM employees
WHERE department_id = 10;*/

INSERT INTO EMP_10
SELECT employee_id, last_name, SALARY, HIRE_DATE
FROM employees
WHERE department_id = 10;

-- 문제10) EMPLOYEES 테이블에서 사원 번호가 107인 사원의 부서를 10번으로 변경하여라.

UPDATE EMPLOYEES
SET department_id = 10
WHERE employee_id = 107;

-- 문제11) EMPLOYEES 테이블에서 사원 번호가 180인
--사원의 부서를 20, 급여를 3500으로 변경하여라.

UPDATE EMPLOYEES
SET department_id = 20, salary = 3500
WHERE employee_id = 180;

--문제12) EMPLOYEES 테이블에서 Smith의 업무와 급여가 Hall의 업무와 급여와
--일치하도록 수정하라.

UPDATE employees
SET (JOB_ID, salary) = (SELECT JOB_ID, SALARY
                         FROM employees
                         WHERE LAST_NAME = 'Hall')
WHERE last_name = 'Smith';






