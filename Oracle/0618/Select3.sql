-- ORDER BY 절 : 정렬
SELECT *
FROM emp
-- WHERE deptno = 10
--ORDER BY SAL ASC;   -- 올림차순 정렬
--  ORDER BY SAL; ASC 를 생략해도 오름차순으로 정렬이된다.
-- ORDER BY SAL DESC;      -- 내림차순 정렬

-- ORDER BY SAL, ENAME;
ORDER BY DEPTNO DESC, sal ASC; -- 먼져 부서 넘버가 내림차순으로 정렬 후 월급을  오름차순으로 재정렬 한다. 부서 넘버가 같으면 월급순으로 재정렬한다.(?) 이해 못하겠으면 직접해보고

-- ALIAS
SELECT empno, ENAME, SAL*12 AS annsal
FROM emp
ORDER BY annsal; 

-- nulls first 또는 nulls last 키워드
SELECT ename, TO_CHAR(sal, '$', 15)
FROM emp
ORDER BY COMM NULLS FIRST;

SELECT
    *
FROM emp
ORDER BY MGR NULLS LAST;

-- DB의 장점중 하나가 sorting이 빠르다. ORDER BY가 엄청 빠르다.
-- 집가고싶다.

-- SCOTT
-- 문제 1
SELECT empno, ENAME, HIREDATE
FROM emp
ORDER BY hiredate ASC;
--문제 2
SELECT ename, sal, sal*12 as 연봉
FROM emp
ORDER BY 연봉 DESC;
-- 문제 3
SELECT ename, deptno
FROM emp
WHERE deptno IN(10, 20)
ORDER BY ename ASC;
-- 문제4
SELECT ename, sal, comm
FROM emp
where comm is not null AND comm != 0
ORDER BY comm DESC;

-- hr 문제 1
SELECT  hire_date, employee_id, last_name, job_id, salary, department_id
FROM employees
ORDER BY hire_date ;
-- 문제 2
SELECT hire_date, employee_id, last_name, job_id, salary, department_id 
FROM employees
ORDER BY hire_date DESC;
-- 3
SELECT department_id, salary, employee_id, last_name, job_id
FROM employees
ORDER BY department_id asc, salary DESC;
-- 4
SELECT department_id, job_id, salary, employee_id, last_name, hire_date
FROM employees
order by department_id ASC, job_id ASC, salary DESC;
