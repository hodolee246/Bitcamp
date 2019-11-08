-- ORDER BY �� : ����
SELECT *
FROM emp
-- WHERE deptno = 10
--ORDER BY SAL ASC;   -- �ø����� ����
--  ORDER BY SAL; ASC �� �����ص� ������������ �����̵ȴ�.
-- ORDER BY SAL DESC;      -- �������� ����

-- ORDER BY SAL, ENAME;
ORDER BY DEPTNO DESC, sal ASC; -- ���� �μ� �ѹ��� ������������ ���� �� ������  ������������ ������ �Ѵ�. �μ� �ѹ��� ������ ���޼����� �������Ѵ�.(?) ���� ���ϰ����� �����غ���

-- ALIAS
SELECT empno, ENAME, SAL*12 AS annsal
FROM emp
ORDER BY annsal; 

-- nulls first �Ǵ� nulls last Ű����
SELECT ename, TO_CHAR(sal, '$', 15)
FROM emp
ORDER BY COMM NULLS FIRST;

SELECT
    *
FROM emp
ORDER BY MGR NULLS LAST;

-- DB�� ������ �ϳ��� sorting�� ������. ORDER BY�� ��û ������.
-- ������ʹ�.

-- SCOTT
-- ���� 1
SELECT empno, ENAME, HIREDATE
FROM emp
ORDER BY hiredate ASC;
--���� 2
SELECT ename, sal, sal*12 as ����
FROM emp
ORDER BY ���� DESC;
-- ���� 3
SELECT ename, deptno
FROM emp
WHERE deptno IN(10, 20)
ORDER BY ename ASC;
-- ����4
SELECT ename, sal, comm
FROM emp
where comm is not null AND comm != 0
ORDER BY comm DESC;

-- hr ���� 1
SELECT  hire_date, employee_id, last_name, job_id, salary, department_id
FROM employees
ORDER BY hire_date ;
-- ���� 2
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
