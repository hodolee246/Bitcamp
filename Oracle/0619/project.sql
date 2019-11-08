
-- ���� 1��-------------------------------
SELECT employee_id, last_name, LOWER(last_name), LOWER(job_id), department_id
FROM employees
WHERE LOWER(last_name) = 'king';
-- ���� 2��--------------------------------
SELECT employee_id, last_name, UPPER(last_name), UPPER(job_id), department_id
FROM employees
WHERE UPPER(last_name) = 'KING';
-- ���� 3��
SELECT department_id || ' ' || department_name,
    department_name || ' ' ||  LOCATION_ID
FROM DEPARTMENTS;

-- ���� 4��
SELECT employee_id, first_name, job_id, salary, department_id
FROM employees
-- WHERE first_name > 'K' AND first_name < 'Y';
WHERE SUBSTR(first_name, 0, 1) > 'K' AND SUBSTR(first_name, 0, 1) < 'Y'
ORDER BY first_name ASC;

-- ���� 5��
SELECT LENGTH(first_name), LENGTH(EMPLOYEE_ID), LENGTH(salary) 
FROM employees
WHERE department_id = 20;

-- ���� 6��
SELECT first_name, INSTR(first_name, 'e', 1, 1)
FROM employees;

-- ���� 7��

SELECT ROUND(4567.678),ROUND(4567.678,0),
ROUND(4567.678,2),ROUND(4567.678,-2)
FROM dual;

-- ���� 8��

SELECT mod(salary, 30), salary
FROM employees
WHERE department_id = 80;

-- ���� 9��----------------------------------------------
SELECT first_name || CHR(10) || job_id      -- ASCII ('A') -> 65 CHR �� �ݴ�
FROM employees
WHERE department_id = 30;
-- CHR(10) == ����

-- ���� 10��
SELECT first_name, FLOOR((SYSDATE - HIRE_DATE) / 7) as �� ,
FLOOR(MOD((SYSDATE - HIRE_DATE), 7)) as ��
-- Ư�� ��¥���� ��´ٸ� TO_DATE('09/05/11') �������� ��¥�� ������ �� �ִ� (sysdate ���)
FROM employees
ORDER BY �� DESC, �� DESC;

-- ���� 11��------------------- ���� ����

SELECT first_name, salary, TO_CHAR(salary, '$999,999,999')
FROM employees
WHERE department_id = 50;

-- ���� 12��

SELECT employee_id, LAST_name, job_id, salary,
    DECODE(JOB_ID,
        'IT_PROG', salary * 1.1,
        'ST_MAN', salary * 1.15,
        'SA_MAN', salary * 1.2, salary)
FROM employees
WHERE job_id in('IT_PROG', 'ST_MAN', 'SA_MAN')
ORDER BY salary DESC;
-- �׷� �Լ�

-- ���� 1�� 
SELECT AVG(salary) as ���,
        MAX(salary) as �ְ��,
        MIN(salary) as ������,
        SUM(salary)as �հ�
    
FROM employees
WHERE job_id LIKE 'SA%';

-- ���� 2��-- 
SELECT
count(*), FLOOR(AVG(salary * commission_pct)), count(DISTINCT department_id)
FROM employees;

-- ���� 3��

SELECT department_id ,count(department_id), TRUNC(AVG(salary)), SUM(salary), MAX(salary), MIN(salary)
FROM employees
GROUP BY department_id
ORDER BY SUM(salary) DESC;
-- ���� 4��

SELECT department_id ,
        count(department_id),
        AVG(salary),
        MAX(salary), 
        MIN(salary), 
        SUM(salary)
FROM employees
GROUP BY department_id
ORDER BY sum(salary) DESC;

-- ���� 5��
SELECT department_id,
        job_id, count(department_id),
        trunc(AVG(salary)),
        SUM(salary)
    
FROM employees
GROUP BY department_id, JOB_ID;

-- ���� 6��
SELECT department_id, count(department_id), sum(salary)
FROM employees
GROUP BY department_id
HAVING count(department_id) > 4;

-- ���� 7��
SELECT department_id, trunc(AVG(salary)), sum(salary)
FROM employees
GROUP BY department_id
HAVING max(salary) >= 10000
ORDER BY department_id DESC;

-- ���� 8��
SELECT job_id, trunc(AVG(salary)), SUM(salary)
FROM employees
GROUP BY job_id
HAVING AVG(salary) >= 10000;

-- ���� 9�� 
SELECT job_id, SUM(salary)
FROM employees
WHERE job_id NOT LIKE 'SA%'
GROUP BY job_id
HAVING  SUM(salary) > 10000
ORDER BY SUM(salary) DESC;

-- SCOTT �Լ�
-- ���� 23��
SELECT INITCAP(job)
FROM emp;

-- ���� 24��
SELECT ename, substr(ename, 1, 3)
    
FROM emp
WHERE ename LIKE '%A%';

-- ���� 25��
SELECT ename
FROM emp
where ename LIKE '__A%';

-- ���� 26��

SELECT ename, INITCAP(ename) as name, LENGTH(ename) as length
FROM emp
WHERE ename LIKE 'J%' OR ename LIKE 'A%' OR ename LIKE 'M%';

-- ���� 27��

SELECT LOWER(ename)
FROM emp
WHERE LENGTH(ename) >= 6;

-- ���� 28��

SELECT LOWER(substr(ename, 1, 3))
FROM emp
WHERE LENGTH(ename) >= 6;

-- ���� 29��------------
SELECT ename, sal, LPAD(sal, 15, '$') as salary
FROM emp;

-- join

-- ���� 50��

SELECT e.ename, d.deptno, d.dname
FROM emp e, dept d
WHERE e.deptno = d.deptno;

-- ���� 51��

SELECT e.ename, e.job, d.dname, d.loc
FROM emp e, dept d
WHERE e.deptno = d.deptno 
    AND e.job = 'MANAGER';

-- ���� 52��

SELECT e.ename, d.dname, d.loc, e.sal, e.comm
FROM emp e, dept d
WHERE e.deptno = d.deptno
    AND e.comm IS NOT NULL
    AND e.comm <> 0
    AND e.sal >= 1600;

-- ���� 53��

SELECT e.ename, e.job, d.deptno, d.dname
FROM emp e, dept d
WHERE e.deptno = d.deptno 
    AND d.loc = 'CHICAGO';

-- ���� 54��

SELECT d.loc, count(e.empno)
FROM emp e, dept d
WHERE e.deptno(+) = d.deptno
GROUP BY d.loc
HAVING count(e.empno) <= 5
ORDER BY count(e.empno) ASC;

-- ����  55��----------------------------------------------------

SELECT a.ename employee, b.ename manager, a.empno emp#, b.empno mgr#
FROM emp a, emp b
WHERE a.mgr = b.empno;

-- ���� 56��

SELECT a.ename || ' ' || b.ename, a.hiredate || ' ' || b.hiredate
FROM emp a, emp b
WHERE a.mgr = b.empno
    AND a.hiredate < b.hiredate;

-- ���� 57��
SELECT a.ename employee, a.empno emp#, b.ename manager, b.empno mgr#
    
FROM emp a, emp b
WHERE a.mgr = b.empno(+)
ORDER BY a.empno ASC;

-- ���� 58��-------------------------------
SELECT a.empno, a.deptno, b.deptno, b.empno colleague
FROM emp a, emp b   -- a �� ��� ����� ����, b �� ���� �μ����� ���ϴ� ����
WHERE a.deptno = b.deptno
    AND a.empno <> b.empno
ORDER BY a.deptno, a.ename, b.ename;

-- ���� 59��

SELECT e.deptno, d.dname, e.ename, e.sal, s.grade
FROM emp e, dept d, salgrade s
WHERE e.deptno = d.deptno
    AND e.deptno = 10
  --  AND e.sal >= s.losal AND e.sal <= s.hisal;
    AND e.sal BETWEEN s.losal AND s.hisal;
----------------- ���� ppt -- JOIN : �ٸ� ���̺� ����Ǿ� �����͸� �����ϱ� ���� ó��

-- ���� 1��

SELECT e.last_name, e.first_name,
        e.department_id, d.department_id,
        d.department_name
FROM employees e, departments d
WHERE e.department_id = d.department_id     -- join �� �⺻Ű�� �ܷ�Ű�� �����Ѵ�.
    AND e.first_name = 'Steven'
    AND e.last_name = 'King';

-- ���� 2��

SELECT e.first_name, e.department_id, e.job_id
FROM employees e, departments d
WHERE e.department_id = d.department_id 
    AND d.department_name LIKE 'IT%';

-- ���� 3��

SELECT 
    *
FROM employees e, departments d;

-- ���� 4��

SELECT e.employee_id, e.first_name, e.job_id, e.department_id,
    d.department_id, d.department_name, d.location_id
FROM employees e, departments d
WHERE e.department_id = d.department_id;
-- ���� 5��

SELECT e.employee_id, e.first_name, e.salary, e.job_id, d.location_id
FROM employees e, departments d
WHERE e.department_id = d.department_id AND e.job_id = 'SA_MAN';

-- ���� 6��

SELECT e.employee_id, e.first_name, e.job_id,
    e.department_id, d.department_id, d.department_name, d.location_id
FROM employees e, departments d
WHERE d.department_id = e.department_id(+);
-- ���� 7��

SELECT a.first_name, a.manager_id, b.first_name, b.employee_id
FROM employees a, employees b
WHERE a.manager_id = b.employee_id;

-- ���� 8��

SELECT a.employee_id, a.first_name, a.manager_id,
        b.employee_id, b.first_name
FROM employees a, employees b
WHERE a.manager_id = b.employee_id(+)
START WITH a.manager_id is not null
CONNECT BY a.manager_id = PRIOR a.employee_id
ORDER BY a.salary DESC;

-- ���� 9��

SELECT a.employee_id, a.first_name, a.salary,
        a.manager_id, b.employee_id,
        b.first_name
FROM employees a, employees b
WHERE a.manager_id(+) = b.employee_id
    AND a.manager_id = 108
CONNECT BY PRIOR a.manager_id = a.employee_id
ORDER BY a.salary DESC;





