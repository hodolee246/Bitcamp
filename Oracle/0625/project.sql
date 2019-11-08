-- view

-- 문제1) EMP 테이블에서 20번 부서의 세부 사항을 포함하는 EMP_20 VIEW를 생성 하여라

CREATE VIEW EMP_20(
"사원번호", "이름", "직업", "급여"
)
AS
SELECT EMP_NO, NAME, JOB, sal
FROM emp
WHERE deptno = 20;
-- 문제2) EMP 테이블에서 30번 부서만 EMPNO를 EMP_NO로 ENAME를 NAME로 SAL를 SALARY로 바꾸어 EMP_30 VIEW를 생성 하여라.

CREATE VIEW EMP_30(
"EMP_NO", "NAME", "SALARY")
AS
SELECT emp_no, name, salary
FROM EMP
WHERE deptno = 30;

-- 문제3) 부서별로 부서명,최소 급여,최대 급여,부서의 평균 급여를 포함하는 DEPT_SUM VIEW을 생성하여라.

CREATE VIEW DEPT_SUM(
"부서명", "최소급여", "최대급여", "평균급여"
)
AS
SELECT d.dname, min(e.sal), max(e.sal), avg(e.sal)
FROM emp e, dept d
WHERE e.deptno = d.deptno
GROUP BY d.dname;


--1. 초기값1부터 최대값999,999까지 1씩 증가하는 TEST_SEQ SEQUENCE를 생성하여라.
CREATE SEQUENCE TEST_SEQ
INCREMENT BY 1      -- 1씩 증가(++)
START WITH 1       -- 시작되는 값
MINVALUE 1;         -- 최대값의 반대



-- 2. 1번에서 작성한 SRQUENCE의 현재 값을 조회하여라.
 
SELECT test_seq.nextval
FROM dual;
  
-- 3. CURRVAL과 NEXTVAL을 설명하여라.

--? 설명??? CURVAL 은 현재값을 조회하고 NEXTVAL 는 다음값을 나타낸다 다만 맨처음 시퀀스 생성후 한번도 실행하지 않았다면 현재값 조회는 오류가 발생한다. 

-- 4. 1번에서 생성한 SRQUENCE를 삭제하여라.

DROP SEQUENCE test_seq;

-- 문제1) EMPLOYEES 테이블에서 20번 부서의 세부 사항을 포함하는 EMP_20 VIEW를 생성 하라

CREATE VIEW EMP_20(
"사원번호", "이름", "직업", "급여"
)
AS
SELECT employee_id, last_name, job_id, salary
FROM employees
WHERE department_id = 20;

SELECT
    *
FROM EMP_20;

-- 문제2) EMPLOYEES 테이블에서 30번 부서만 EMPLOYEE_ID
-- 를 emp_no 로 LAST_NAME을 name으로 SALARY를 sal로 바꾸어 EMP_30 VIEW를 생성하라

CREATE VIEW EMP_30(
"EMP_NO", "NAME", "SAL"
)
AS
SELECT employee_id, last_name, salary
FROM employees;

-- 문제3) 부서별로 부서명,최소 급여,최대 급여,부서의 평균 급여를 포함하는 DEPT_SUM VIEW을 생성하여라.
CREATE VIEW DEPT_SUM(
"부서명", "최소급여", "최대급여", "평균급여"
)
AS
SELECT  d.department_name, min(e.salary), max(e.salary), avg(e.salary)  -- 그룹으로 묶지않아도 값을 보는 방법 오버 파티션 바이
FROM employees e, departments d
WHERE e.department_id = d.department_id
GROUP BY d.department_name;

-- 문제4) 앞에서 생성한 EMP_20,EMP_30 VIEW을 삭제하여라.

DROP VIEW EMP_20;
DROP VIEW EMP_30;