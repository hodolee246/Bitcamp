-- 33) �� ����� �̸��� ǥ���ϰ� �ٹ� �� ��(�Ի��Ϸκ��� ��������� �޼�)�� ����Ͽ�
--�� ���̺��� MONTHS_WORKED�� �����Ͻÿ�. ����� ������ �ݿø��Ͽ� ǥ���ϰ� �ٹ��� ����
--�������� ������������ �����Ͻÿ�.(MONTHS_BETWEEN �Լ� ����)

SELECT ename, round(MONTHS_BETWEEN(SYSDATE,hiredate), 0) as MONTHS_WORKED
FROM emp
ORDER BY MONTHS_WORKED;

-- 34)emp���̺��� �̸�, ����, �ٹ������� ����Ͻÿ�.

SELECT ename, job, round(MONTHS_BETWEEN(SYSDATE,hiredate) / 12, 0) as ����
FROM emp
ORDER BY ���� DESC;

-- 35)emp���̺��� ����̸�, ����, ���ް� Ŀ�̼��� ���� ���� �÷��� �Ǳ޿���� �ؼ� ���.
--     ��, NULL���� ��Ÿ���� �ʰ� �ۼ��Ͻÿ�.

SELECT ename, sal, sal + nvl(comm, 0) as �Ǳ޿�
FROM emp;

-- 36)���ް� Ŀ�̼��� ��ģ �ݾ��� 2,000�̻��� �޿��� �޴� ����� �̸�,����,����,Ŀ�̼�,��볯¥
-- �� ����Ͻÿ�. ��, ��볯¥�� 1980-12-17 ���·� ����Ͻÿ�.

SELECT ename, job, sal, comm, TO_CHAR(hiredate, 'YYYY-MM-DD') as �����
FROM emp
WHERE sal + nvl(comm, 0) >= 2000
ORDER BY �����;

-- 37)DECODE �Ǵ� CASE WHEN THEN �Լ��� ����Ͽ� ���� �����Ϳ� ���� JOB���� ���� �������� ��� ����� ����� ǥ���Ͻÿ�.
/*
����        ���
PRESIDENT   A
ANALYST     B
MANAGER     C
SALESMAN    D
CLERK       E
��Ÿ         0
*/


SELECT empno, ename, job,
    CASE job
        WHEN 'PRESIDENT' THEN 'A'
        WHEN 'ANALYST' THEN 'B'
        WHEN 'MANAGER' THEN 'C'
        WHEN 'SALESMAN' THEN 'D'
        WHEN 'CLERK' THEN 'E'
        ELSE '0'
    END as ���    
FROM emp;

-- HR

-- 1. ���� �ֱ� �Ի��� ��������� �ۼ��ؼ� 1 ~ 10��° ����� ������ ����Ͻÿ�.

SELECT ROWNUM, employee_id, last_name, job_id, salary, department_id, hire_date
FROM employees
WHERE ROWNUM <= 10
ORDER BY hire_date DESC;

-- 2. �޿������� �ۼ��ؼ� 11 ~ 20 ����� ������ ����Ͻÿ�.

SELECT rnum, last_name, job_id, department_id, salary
FROM (SELECT ROWNUM as rnum , EMPLOYEE_id, last_name, job_id, department_id, salary
        FROM ( SELECT
            *
                FROM employees
                ORDER BY SALARY DESC))
WHERE rnum between 11 AND 20;            

-- 3. �Ի��� ������� ��ȣ�� �Ҵ��ϰ�, JOB_ID�� IT_PROG�̸�, 05�⵵�� �Ի��� ����� 3�� ����϶�

SELECT ROWNUM, last_name, job_id, hire_date
FROM employees
WHERE job_id = 'IT_PROG' AND hire_date between to_date(20050101, 'YYYYMMDD') AND to_date(20051231, 'YYYYMMDD')
AND ROWNUM <= 3;

SELECT employee_id, first_name, job_id, hire_date
FROM
    (SELECT row_number() over(partition by substr(hire_date, 1, 2) order by hire_date asc)
        employee_id, first_name, job_id, hire_date
FROM employees
WHERE job_id = 'IT_PROG' AND SUBSTR(hire_date, 1, 2) = '5')
WHERE rn BETWEEN 1 AND 3;


-- hr ���� ��������

-- --1. ��å(Job Title)�� Sales Manager�� ������� �Ի�⵵�� �Ի�⵵(hire_date)�� ��� �޿��� ����Ͻÿ�. 
--   ��� �� �⵵�� �������� �������� �����Ͻÿ�. 

SELECT hire_date, trunc(avg(salary))
FROM employees e, jobs j
WHERE e.job_id = j.job_id
AND j.job_title = 'Sales Manager'
GROUP BY e.hire_date
HAVING TO_CHAR(e.hire_date, 'YYYY'); 
--2. �� ����(city)�� �ִ� ��� �μ� �������� ��ձ޿��� ��ȸ�ϰ��� �Ѵ�. 
--   ��ձ޿��� ���� ���� ���ú��� ���ø�(city)�� ��տ���, �ش� ������ �������� ����Ͻÿ�. 
--   ��, ���ÿ� �ٹ��ϴ� ������ 10�� �̻��� ���� �����ϰ� ��ȸ�Ͻÿ�.

SELECT l.city, TRUNC(AVG(salary)), count(*)
FROM employees e, departments d
WHERE (e.salary) IN

(SELECT TRUNC(AVG(e.salary))
FROM employees e, departments d, locations l
WHERE e.department_id = d.department_id
AND l.location_id = d.location_id
GROUP BY d.department_name
HAVING COUNT(e.department_id) < 10)

AND e.department_id = d.department_id
ORDER BY salary DESC;

--3. ��Public  Accountant���� ��å(job_title)���� ���ſ� �ٹ��� ���� �ִ� ��� ����� ����� �̸��� ����Ͻÿ�. 
--   (���� ��Public Accountant���� ��å(job_title)���� �ٹ��ϴ� ����� ��� ���� �ʴ´�.)      
--   �̸��� first_name, last_name�� �Ʒ��� �������� ���� ����Ѵ�.

SELECT
    *
FROM employees e, job_history h, jobs j
WHERE 

(select * from where 


AND e.department_id = h.department_id
AND h.job_id = j.job_id;
 
 
 
 

 
 
--4. �ڽ��� �Ŵ������� ����(salary)�� ���� �޴� �������� ��(last_name)�� ����(salary)�� �� ���Ͻÿ�. 


SELECT last_name, salary
FROM EMPLOYEES
GROUP BY employee_id         
HAVING salary > (select max(salary)
                 FROM employees
                 GROUP BY manager_id);











































