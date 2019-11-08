
-- 문제 1번-------------------------------
SELECT employee_id, last_name, LOWER(last_name), LOWER(job_id), department_id
FROM employees
WHERE LOWER(last_name) = 'king';
-- 문제 2번--------------------------------
SELECT employee_id, last_name, UPPER(last_name), UPPER(job_id), department_id
FROM employees
WHERE UPPER(last_name) = 'KING';
-- 문제 3번
SELECT department_id || ' ' || department_name,
    department_name || ' ' ||  LOCATION_ID
FROM DEPARTMENTS;

-- 문제 4번
SELECT employee_id, first_name, job_id, salary, department_id
FROM employees
-- WHERE first_name > 'K' AND first_name < 'Y';
WHERE SUBSTR(first_name, 0, 1) > 'K' AND SUBSTR(first_name, 0, 1) < 'Y'
ORDER BY first_name ASC;

-- 문제 5번
SELECT LENGTH(first_name), LENGTH(EMPLOYEE_ID), LENGTH(salary) 
FROM employees
WHERE department_id = 20;

-- 문제 6번
SELECT first_name, INSTR(first_name, 'e', 1, 1)
FROM employees;

-- 문제 7번

SELECT ROUND(4567.678),ROUND(4567.678,0),
ROUND(4567.678,2),ROUND(4567.678,-2)
FROM dual;

-- 문제 8번

SELECT mod(salary, 30), salary
FROM employees
WHERE department_id = 80;

-- 문제 9번----------------------------------------------
SELECT first_name || CHR(10) || job_id      -- ASCII ('A') -> 65 CHR 의 반대
FROM employees
WHERE department_id = 30;
-- CHR(10) == 개행

-- 문제 10번
SELECT first_name, FLOOR((SYSDATE - HIRE_DATE) / 7) as 주 ,
FLOOR(MOD((SYSDATE - HIRE_DATE), 7)) as 일
-- 특정 날짜까지 잡는다면 TO_DATE('09/05/11') 형식으로 날짜를 지정할 수 있다 (sysdate 대용)
FROM employees
ORDER BY 주 DESC, 일 DESC;

-- 문제 11번------------------- 문자 삽입

SELECT first_name, salary, TO_CHAR(salary, '$999,999,999')
FROM employees
WHERE department_id = 50;

-- 문제 12번

SELECT employee_id, LAST_name, job_id, salary,
    DECODE(JOB_ID,
        'IT_PROG', salary * 1.1,
        'ST_MAN', salary * 1.15,
        'SA_MAN', salary * 1.2, salary)
FROM employees
WHERE job_id in('IT_PROG', 'ST_MAN', 'SA_MAN')
ORDER BY salary DESC;
-- 그룹 함수

-- 문제 1번 
SELECT AVG(salary) as 평균,
        MAX(salary) as 최고액,
        MIN(salary) as 최저액,
        SUM(salary)as 합계
    
FROM employees
WHERE job_id LIKE 'SA%';

-- 문제 2번-- 
SELECT
count(*), FLOOR(AVG(salary * commission_pct)), count(DISTINCT department_id)
FROM employees;

-- 문제 3번

SELECT department_id ,count(department_id), TRUNC(AVG(salary)), SUM(salary), MAX(salary), MIN(salary)
FROM employees
GROUP BY department_id
ORDER BY SUM(salary) DESC;
-- 문제 4번

SELECT department_id ,
        count(department_id),
        AVG(salary),
        MAX(salary), 
        MIN(salary), 
        SUM(salary)
FROM employees
GROUP BY department_id
ORDER BY sum(salary) DESC;

-- 문제 5번
SELECT department_id,
        job_id, count(department_id),
        trunc(AVG(salary)),
        SUM(salary)
    
FROM employees
GROUP BY department_id, JOB_ID;

-- 문제 6번
SELECT department_id, count(department_id), sum(salary)
FROM employees
GROUP BY department_id
HAVING count(department_id) > 4;

-- 문제 7번
SELECT department_id, trunc(AVG(salary)), sum(salary)
FROM employees
GROUP BY department_id
HAVING max(salary) >= 10000
ORDER BY department_id DESC;

-- 문제 8번
SELECT job_id, trunc(AVG(salary)), SUM(salary)
FROM employees
GROUP BY job_id
HAVING AVG(salary) >= 10000;

-- 문제 9번 
SELECT job_id, SUM(salary)
FROM employees
WHERE job_id NOT LIKE 'SA%'
GROUP BY job_id
HAVING  SUM(salary) > 10000
ORDER BY SUM(salary) DESC;

-- SCOTT 함수
-- 문제 23번
SELECT INITCAP(job)
FROM emp;

-- 문제 24번
SELECT ename, substr(ename, 1, 3)
    
FROM emp
WHERE ename LIKE '%A%';

-- 문제 25번
SELECT ename
FROM emp
where ename LIKE '__A%';

-- 문제 26번

SELECT ename, INITCAP(ename) as name, LENGTH(ename) as length
FROM emp
WHERE ename LIKE 'J%' OR ename LIKE 'A%' OR ename LIKE 'M%';

-- 문제 27번

SELECT LOWER(ename)
FROM emp
WHERE LENGTH(ename) >= 6;

-- 문제 28번

SELECT LOWER(substr(ename, 1, 3))
FROM emp
WHERE LENGTH(ename) >= 6;

-- 문제 29번------------
SELECT ename, sal, LPAD(sal, 15, '$') as salary
FROM emp;

-- join

-- 문제 50번

SELECT e.ename, d.deptno, d.dname
FROM emp e, dept d
WHERE e.deptno = d.deptno;

-- 문제 51번

SELECT e.ename, e.job, d.dname, d.loc
FROM emp e, dept d
WHERE e.deptno = d.deptno 
    AND e.job = 'MANAGER';

-- 문제 52번

SELECT e.ename, d.dname, d.loc, e.sal, e.comm
FROM emp e, dept d
WHERE e.deptno = d.deptno
    AND e.comm IS NOT NULL
    AND e.comm <> 0
    AND e.sal >= 1600;

-- 문제 53번

SELECT e.ename, e.job, d.deptno, d.dname
FROM emp e, dept d
WHERE e.deptno = d.deptno 
    AND d.loc = 'CHICAGO';

-- 문제 54번

SELECT d.loc, count(e.empno)
FROM emp e, dept d
WHERE e.deptno(+) = d.deptno
GROUP BY d.loc
HAVING count(e.empno) <= 5
ORDER BY count(e.empno) ASC;

-- 문제  55번----------------------------------------------------

SELECT a.ename employee, b.ename manager, a.empno emp#, b.empno mgr#
FROM emp a, emp b
WHERE a.mgr = b.empno;

-- 문제 56번

SELECT a.ename || ' ' || b.ename, a.hiredate || ' ' || b.hiredate
FROM emp a, emp b
WHERE a.mgr = b.empno
    AND a.hiredate < b.hiredate;

-- 문제 57번
SELECT a.ename employee, a.empno emp#, b.ename manager, b.empno mgr#
    
FROM emp a, emp b
WHERE a.mgr = b.empno(+)
ORDER BY a.empno ASC;

-- 문제 58번-------------------------------
SELECT a.empno, a.deptno, b.deptno, b.empno colleague
FROM emp a, emp b   -- a 는 모든 사원의 정보, b 는 같은 부서에서 일하는 동료
WHERE a.deptno = b.deptno
    AND a.empno <> b.empno
ORDER BY a.deptno, a.ename, b.ename;

-- 문제 59번

SELECT e.deptno, d.dname, e.ename, e.sal, s.grade
FROM emp e, dept d, salgrade s
WHERE e.deptno = d.deptno
    AND e.deptno = 10
  --  AND e.sal >= s.losal AND e.sal <= s.hisal;
    AND e.sal BETWEEN s.losal AND s.hisal;
----------------- 조인 ppt -- JOIN : 다른 테이블에 저장되어 데이터를 산출하기 위한 처리

-- 문제 1번

SELECT e.last_name, e.first_name,
        e.department_id, d.department_id,
        d.department_name
FROM employees e, departments d
WHERE e.department_id = d.department_id     -- join 은 기본키랑 외래키로 조인한다.
    AND e.first_name = 'Steven'
    AND e.last_name = 'King';

-- 문제 2번

SELECT e.first_name, e.department_id, e.job_id
FROM employees e, departments d
WHERE e.department_id = d.department_id 
    AND d.department_name LIKE 'IT%';

-- 문제 3번

SELECT 
    *
FROM employees e, departments d;

-- 문제 4번

SELECT e.employee_id, e.first_name, e.job_id, e.department_id,
    d.department_id, d.department_name, d.location_id
FROM employees e, departments d
WHERE e.department_id = d.department_id;
-- 문제 5번

SELECT e.employee_id, e.first_name, e.salary, e.job_id, d.location_id
FROM employees e, departments d
WHERE e.department_id = d.department_id AND e.job_id = 'SA_MAN';

-- 문제 6번

SELECT e.employee_id, e.first_name, e.job_id,
    e.department_id, d.department_id, d.department_name, d.location_id
FROM employees e, departments d
WHERE d.department_id = e.department_id(+);
-- 문제 7번

SELECT a.first_name, a.manager_id, b.first_name, b.employee_id
FROM employees a, employees b
WHERE a.manager_id = b.employee_id;

-- 문제 8번

SELECT a.employee_id, a.first_name, a.manager_id,
        b.employee_id, b.first_name
FROM employees a, employees b
WHERE a.manager_id = b.employee_id(+)
START WITH a.manager_id is not null
CONNECT BY a.manager_id = PRIOR a.employee_id
ORDER BY a.salary DESC;

-- 문제 9번

SELECT a.employee_id, a.first_name, a.salary,
        a.manager_id, b.employee_id,
        b.first_name
FROM employees a, employees b
WHERE a.manager_id(+) = b.employee_id
    AND a.manager_id = 108
CONNECT BY PRIOR a.manager_id = a.employee_id
ORDER BY a.salary DESC;





