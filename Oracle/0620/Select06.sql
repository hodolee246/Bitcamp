-- SUB QUERY
-- QUERY ���� QUERY ���̴�.
-- �Ѱ��� �࿡�� ��� ���� ��ȯ�Ǵ� QUERY
    --   ROW
-- SELECT   ������ �����÷� ������ �����ʹ� �Ѱ�, �÷� �Ѱ�
-- FROM     ������ �����÷��� �����ϴ�
-- WHERE    ������ �����÷��� ����� �� �ִ�. -- ���� ���� ����ϴ� �ä�
/*
    SELECT (SELECT FIRST_NAME, LAST_NAME FROM EMPLOYEES)    X �����÷��� �ƴ�
    SELECT EMPLOYEE_ID,(SELECT FIRST_NAME FROM EMPLOYEES)               X ROW�� ���� ��
    
    SELECT (SELECT FIRST_NAME FROM EMPLOYEES WHERE EMPLOYEE_ID = 100)
      
*/
-- SELECT
SELECT employee_id, first_name,salary,
    (SELECT SUM(salary)  from employees),
    (SELECT COUNT(*) FROM employees)
FROM employees;
    
-- FROM
SELECT employee_id, LAST_NAME, SALARY, DEPARTMENT_ID
FROM (SELECT employee_id, last_name, salary, department_id
    FROM employees
    WHERE department_id = 10);
/*
-- �μ���ȣ�� 20���̰� �޿��� 6000�̻��� ���
SELECT
    *
FROM employees
WHERE department_id = 20;
    AND salary >= 6000;
    */
 SELECT
     *
 FROM (select
        *
        FROM employees
        WHERE department_id = 20)
WHERE salary >= 7000;
/*
SELECT a.employee_id, a.first_name, a.job_id, b.job_id b."�޿��հ�", b."�ο���"
FROM employees a, (select job_id, sum(sal) as "�޿��հ�", count(*) as "�ο���" 
                    From employees
                   GROUP BY job_id) b
WHERE a.job_id = b.job_id AND a.first_name = 'Steven';                            
*/
-- WHERE ��
SELECT first_name, salary
FROM employees
WHERE salary > (SELECT AVG(salary) FROM employees);

SELECT first_name, job_id
FROM employees
WHERE job_id IN(SELECT job_id FROM jobs WHERE job_id = 'IT_PROG');

-- �μ����� ���� �޿��� ���� �޴� ����� ���� �޿��� �޴� ���
-- 10 -> 2500 ==

SELECT first_name, salary, department_id
FROM employees
WHERE salary  IN(SELECT MIN(salary)
                FROM employees
                GROUP BY department_id)
                ORDER BY department_id, salary;

-- �μ����� ���� �޿��� ���� �޴� ����� ����
SELECT department_id, first_name, salary
FROM employees
WHERE (department_id, salary) IN(   SELECT department_id, min(salary)
                                    FROM employees
                                    GROUP BY department_id)
                                     ORDER BY department_id;

-- subquery ���� scoff

-- 60) BLAKE�� ���� �μ��� �ִ� ������� �̸��� �Ի����� ���ϴµ� 
--    BLAKE�� �����ϰ� ����Ͻÿ�.(BLAKE�� �������� �� ����)
SELECT ename, hiredate, deptno
FROM emp
WHERE (deptno) in (     SELECT deptno
                        FROM emp
                        WHERE ename = 'BLAKE')
                        AND ename <> 'BLAKE';
                        
-- 61) (��ձ޿����� ���� �޿�)�� �޴� ������� �����ȣ, �̸�, ������ ����ϴµ� (������
--    ���� ��������� ���)�Ͻÿ�.

SELECT empno, ename, sal
FROM emp
WHERE sal >(SELECT trunc(avg(sal))
            FROM emp)
 ORDER BY sal DESC;           

-- 62) (10���μ����� �޿��� ���� ���� �޴� ���)�� ������ �޿��� �޴� ����� �̸��� ����Ͻÿ�.

SELECT ename, sal, deptno
FROM emp
WHERE (sal) in (SELECT min(sal)
                FROM emp
                WHERE deptno = 10);
   --             AND deptno <> 10;

-- 63) ������� 3���� �Ѵ� �μ��� �μ���� ������� ����Ͻÿ�--------------

SELECT d.dname, count(e.empno)
FROM emp e, dept d
WHERE e.deptno = d.deptno
GROUP BY d.dname
HAVING COUNT(e.empno) > 3; 
--64) �����ȣ�� 7844�� ������� ���� �Ի��� ����� �̸��� �Ի����� ����Ͻÿ�.

SELECT ename, hiredate
FROM emp
WHERE (hiredate) < ( SELECT hiredate
                            FROM emp
                            WHERE empno = 7844);
                            

-- 65) ���ӻ��(mgr)�� KING�� ��� ����� �̸��� �޿��� ����Ͻÿ�

SELECT ename, sal, mgr
FROM emp
WHERE mgr IN (SELECT empno
              FROM emp
              WHERE ename = 'KING');

-- 66) 20�� �μ����� ���� �޿��� ���� �޴� ����� ������ �޿��� �޴� ����� �̸��� �μ���,
    -- �޿�, �޿������ ����Ͻÿ�.(emp, dept, salgrade


SELECT e.ename, e.sal, d.deptno, d.dname, s.grade
FROM emp e,dept d, salgrade s
WHERE (sal) in (SELECT max(sal)
                FROM emp
                WHERE deptno = 20)
                AND e.deptno = d.deptno
                AND e.sal BETWEEN s.losal AND s.hisal;
                
--                AND deptno <> 20;

-- 67) �ѱ޿�(sal+comm)�� ��� �޿����� ���� �޿��� �޴� ����� �μ���ȣ, �̸�, �ѱ޿�, 
--    Ŀ�̼��� ����Ͻÿ�.(Ŀ�̼��� ��(O),��(X)�� ǥ���ϰ� �÷����� "comm����" ���)

SELECT deptno, ename, sal + comm, comm
FROM emp
WHERE sal + nvl(comm, 0) > (SELECT trunc(avg(sal + nvl(comm, 0)))
                        FROM emp);
                        
-- 68) CHICAGO �������� �ٹ��ϴ� ����� ��� �޿����� ���� �޿��� �޴� ����� �̸��� �޿�, --------------
--    �������� ����Ͻÿ�.

SELECT e.ename, e.sal, d.loc
FROM emp e, dept d
WHERE e.deptno = d.deptno AND
(sal) > (SELECT trunc(avg(sal))
                     FROM emp
                       WHERE  deptno in (SELECT deptno
                                        FROM dept
                                        WHERE loc = 'CHICAGO')
                    GROUP BY deptno);                    
                                                

-- 69) ������ SALESMAN�� ������ 2�� �̻��� �μ��� �̸�, �ٹ��ϴ� ����� �̸�, ������ ���--------
SELECT d.dname, e.ename, e.job
FROM emp e, dept d
WHERE e.deptno = d.deptno
AND e.deptno IN
(SELECT deptno
FROM emp
WHERE job = 'SALESMAN'
GROUP BY deptno
HAVING COUNT(job) >= 2);

-- 70) Ŀ�̼��� ���� ����� �� ������ ���� ���� ����� �̸��� �޿������ ����Ͻÿ�.

SELECT e.ename, e.sal, s.grade, e.comm
FROM emp e, salgrade s
WHERE (e.sal) IN (SELECT MAX(sal) 
                    FROM emp
                    WHERE comm is null)
AND e.sal BETWEEN s.losal AND s.hisal;

-- 71) SMITH�� ������(mgr)�� �̸��� �μ���, �ٹ������� ����Ͻÿ�.

SELECT e.ename, d.dname, e.mgr, d.loc
FROM emp e, dept d
WHERE e.empno IN (SELECT mgr
                FROM emp 
                WHERE ename = 'SMITH')
AND e.deptno = d.deptno;                

-- SubQery(?) ppt SR

-- ����1) EMPLOYEES ���̺��� Kochhar�� �޿����� ���� ����� ������ �����ȣ,�̸�,������,�޿��� ����϶�


-- ����2) EMPLOYEES ���̺��� �޿��� ��պ��� ���� ����� ������ �����ȣ,�̸�,������,�޿�,�μ���ȣ�� ����Ͽ���.

SELECT employee_id, first_name, job_id, salary, department_id
FROM employees
WHERE salary < (SELECT TRUNC(AVG(salary))
                FROM employees)
ORDER BY salary DESC;

-- ����3) EMPLOYEES ���̺��� 100�� �μ��� �ּ� �޿����� �ּ� �޿��� ���� �ٸ� ��� �μ��� ����϶�

SELECT department_id
FROM employees
GROUP BY department_id
HAVING MIN(salary) > (SELECT MIN(salary)
                     FROM employees
                     WHERE department_id = 100);
                    
--  ����4) �������� �ּ� �޿��� �޴� ����� ������ �����ȣ,�̸�,����,�μ���ȣ�� ����Ͽ���. �� �������� �����Ͽ���.

SELECT employee_id, last_name, job_id, department_id, salary
FROM employees
WHERE (job_id, salary) IN (SELECT job_id, MIN(salary)
                 FROM employees
                 GROUP BY job_id)
ORDER BY job_id;
-- ����5) EMPLOYEES �� DEPARTMENTS ���̺��� ������ SA_MAN ����� ������ �̸�,����,�μ���,�ٹ����� ����϶�.

SELECT e.last_name, e.job_id, d.department_name, d.location_id
FROM employees e, departments d
WHERE e.department_id = d.department_id
AND e.job_id = 'SA_MAN';

SELECT e.last_name, e.job_id, d.department_name, d.location_id
FROM (select first_name, job_id, department_id
      FROM employees
      WHERE job_id = 'SA_MAN') e, dpartments d
WHERE e.department_id = d.department_id;


-- ����6)   EMPLOYEES  ���̺��� ���� ���� ����� ���� MANAGER�� �����ȣ�� ����϶�.

SELECT MANAGER_ID
FROM EMPLOYEES
GROUP BY MANAGER_ID
HAVING COUNT(manager_id) = ( SELECT MAX(COUNT(*))
                     FROM EMPLOYEES
                     GROUP BY MANAGER_ID);

 
--����7) EMPLOYEES  ���̺��� ���� ���� ����� �����ִ� �μ���ȣ�� ������� ����϶�.
 
SELECT department_id, COUNT(*)
FROM EMPLOYEES
GROUP BY department_id
HAVING COUNT(department_id) = ( SELECT MAX(COUNT(*))
                                 FROM EMPLOYEES
                                 GROUP BY department_id);

-- ����8)   EMPLOYEES  ���̺��� �����ȣ�� 123�� ����� ������ ���� 
--�����ȣ�� 192�� ����� �޿�(SAL)���� ���� ����� �����ȣ, �̸�, 
--����, �޿��� ����϶�.

SELECT employee_id, last_name, job_id, salary    
FROM EMPLOYEES
WHERE (job_id) IN ( SELECT job_id   
                         FROM employees
                         WHERE employee_id = 123 AND salary > (SELECT salary
                                                                 FROM employees
                                                                WHERE employee_id = 192));

-- ����9)   ����(JOB)���� �ּ� �޿��� �޴� ����� ������ �����ȣ, �̸�, ����, �μ����� ����϶�.
-- ����1 : �������� �������� ����

SELECT employee_id, job_id, last_name, d.department_name, e.salary
FROM employees e, departments d
WHERE e.department_id = d.department_id
AND (salary, job_id) IN ( SELECT MIN(salary), job_id
                   FROM employees   
                   GROUP BY job_id)
ORDER BY e.job_id  DESC;                  

-- ����10) EMPLOYEES ���̺��� 50�� �μ��� �ּ� �޿��� �޴� ��� ���� ���� �޿��� �޴� ����� ������
-- �����ȣ,�̸�,����,�Ի�����,�޿�,�μ���ȣ�� ����϶�. �� 50���� ����

SELECT employee_id, last_name, job_id, hire_date, salary, department_id
FROM employees
WHERE (salary) > (SELECT MIN(salary)
                     FROM employees
                     WHERE department_id = 50)
AND department_id <> 50
ORDER BY salary desc;

-- ����11) EMPLOYEES ���̺��� 50�� �μ��� �ְ� �޿��� �޴� ��� ���� 
--���� �޿��� �޴� ����� ������ �����ȣ,�̸�,����,�Ի�����,�޿�,�μ���ȣ��
--����϶�. ��50���� ����

SELECT employee_id, last_name, job_id, hire_date, salary, department_id
FROM employees
WHERE (salary) > (SELECT MAX(salary)
                     FROM employees
                     WHERE department_id = 50)
AND department_id <> 50
ORDER BY salary ;













