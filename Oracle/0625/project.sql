-- view

-- ����1) EMP ���̺��� 20�� �μ��� ���� ������ �����ϴ� EMP_20 VIEW�� ���� �Ͽ���

CREATE VIEW EMP_20(
"�����ȣ", "�̸�", "����", "�޿�"
)
AS
SELECT EMP_NO, NAME, JOB, sal
FROM emp
WHERE deptno = 20;
-- ����2) EMP ���̺��� 30�� �μ��� EMPNO�� EMP_NO�� ENAME�� NAME�� SAL�� SALARY�� �ٲپ� EMP_30 VIEW�� ���� �Ͽ���.

CREATE VIEW EMP_30(
"EMP_NO", "NAME", "SALARY")
AS
SELECT emp_no, name, salary
FROM EMP
WHERE deptno = 30;

-- ����3) �μ����� �μ���,�ּ� �޿�,�ִ� �޿�,�μ��� ��� �޿��� �����ϴ� DEPT_SUM VIEW�� �����Ͽ���.

CREATE VIEW DEPT_SUM(
"�μ���", "�ּұ޿�", "�ִ�޿�", "��ձ޿�"
)
AS
SELECT d.dname, min(e.sal), max(e.sal), avg(e.sal)
FROM emp e, dept d
WHERE e.deptno = d.deptno
GROUP BY d.dname;


--1. �ʱⰪ1���� �ִ밪999,999���� 1�� �����ϴ� TEST_SEQ SEQUENCE�� �����Ͽ���.
CREATE SEQUENCE TEST_SEQ
INCREMENT BY 1      -- 1�� ����(++)
START WITH 1       -- ���۵Ǵ� ��
MINVALUE 1;         -- �ִ밪�� �ݴ�



-- 2. 1������ �ۼ��� SRQUENCE�� ���� ���� ��ȸ�Ͽ���.
 
SELECT test_seq.nextval
FROM dual;
  
-- 3. CURRVAL�� NEXTVAL�� �����Ͽ���.

--? ����??? CURVAL �� ���簪�� ��ȸ�ϰ� NEXTVAL �� �������� ��Ÿ���� �ٸ� ��ó�� ������ ������ �ѹ��� �������� �ʾҴٸ� ���簪 ��ȸ�� ������ �߻��Ѵ�. 

-- 4. 1������ ������ SRQUENCE�� �����Ͽ���.

DROP SEQUENCE test_seq;

-- ����1) EMPLOYEES ���̺��� 20�� �μ��� ���� ������ �����ϴ� EMP_20 VIEW�� ���� �϶�

CREATE VIEW EMP_20(
"�����ȣ", "�̸�", "����", "�޿�"
)
AS
SELECT employee_id, last_name, job_id, salary
FROM employees
WHERE department_id = 20;

SELECT
    *
FROM EMP_20;

-- ����2) EMPLOYEES ���̺��� 30�� �μ��� EMPLOYEE_ID
-- �� emp_no �� LAST_NAME�� name���� SALARY�� sal�� �ٲپ� EMP_30 VIEW�� �����϶�

CREATE VIEW EMP_30(
"EMP_NO", "NAME", "SAL"
)
AS
SELECT employee_id, last_name, salary
FROM employees;

-- ����3) �μ����� �μ���,�ּ� �޿�,�ִ� �޿�,�μ��� ��� �޿��� �����ϴ� DEPT_SUM VIEW�� �����Ͽ���.
CREATE VIEW DEPT_SUM(
"�μ���", "�ּұ޿�", "�ִ�޿�", "��ձ޿�"
)
AS
SELECT  d.department_name, min(e.salary), max(e.salary), avg(e.salary)  -- �׷����� �����ʾƵ� ���� ���� ��� ���� ��Ƽ�� ����
FROM employees e, departments d
WHERE e.department_id = d.department_id
GROUP BY d.department_name;

-- ����4) �տ��� ������ EMP_20,EMP_30 VIEW�� �����Ͽ���.

DROP VIEW EMP_20;
DROP VIEW EMP_30;