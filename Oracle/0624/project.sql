--����1) EMP ���̺��� EMPNO,ENAME,SAL,HIREDATE�� 
--COLUMN�� �����Ͽ� EMP_10 ���̺��� ������ �� 10�� �μ���
--�����Ͽ� �̿� �����ϴ� ���� EMP_10���̺� �Է��Ͽ���.

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

-- ����2) EMP ���̺��� ��� ��ȣ��7788�� ����� �μ��� 10������ �����Ͽ���.

UPDATE EMP
SET deptno = 10
WHERE empno = 7369;


-- ����3) EMP ���̺��� ��� ��ȣ��7788�� ����� �μ��� 20, �޿��� 3500���� �����Ͽ���.

UPDATE EMP
SET DEPTNO = 20, SAL = 3500
WHERE EMPNO = 7369;


-- ����4) EMP ���̺��� 10�� �μ��� ����� ��� 91�� �μ��� �����Ͽ���.

INSERT INTO dept(DEPTNO, DNAME, LOC)
VALUES ('91', 'Guro', 'Seoul');

UPDATE emp
SET DEPTNO = 91
WHERE DEPTNO = 10;


-- ����5) DEPT ���̺��� �μ� ��ȣ 10�� 15�� �����Ͽ���. -- ĥ�己 ���ڵ� ���Ŀ��

INSERT INTO emp
VALUES ('1234', 'INWOO', 'IT', '1234', '19/06/24', '5000', '1500', '15');

UPDATE DEPT
SET deptno = 15
WHERE deptno = 10;



-- ����6) EMP ���̺��� �����ȣ�� 7499�� ����� ������ �����Ͽ���.

DELETE
FROM EMP
WHERE empno = 7499;



-- ����7) EMP ���̺��� �Ի����ڰ� 83���� ����� ������ �����Ͽ���.

DELETE
FROM emp
WHERE hiredate LIKE '83%';



-- 1. �Ʒ��� ������ �����ϴ� MY_DATA ���̺��� �����Ͻÿ�. �� ID�� PRIMARY KEY�̴�.

CREATE TABLE MY_DATA(
    M_ID NUMBER(4),
    M_NAME VARCHAR2(10),
    M_USERID VARCHAR2(30),
    M_SALARY NUMBER(10, 2),
    CONSTRAINT M_DATA PRIMARY KEY(M_ID)
);



-- 2. 1���� ���� ������ ���̺� �Ʒ��� ���� �Է��Ͽ���.

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


-- 3. ID�� 3���� ����� �޿��� 65,000.00���� �����ϰ� ���������� �����ͺ��̽��� �ݿ��Ͽ���.

update my_data
set m_salary = 65000.00
where m_id = 3;

commit;

-- 4. �̸��� Ford�� ����� ���� �����Ͽ���.

DELETE
FROM MY_DATA
WHERE M_NAME = 'Ford';

SELECT
    *
FROM MY_DATA;

-- 5. �޿��� 15,000������ ����� �޿��� 15,000�� �����Ͽ���.

UPDATE MY_DATA
SET M_SALARY = 15000
WHERE M_SALARY < 15000;




-- 6. 1������ ������ ���̺��� �����Ͽ���.


DROP TABLE MY_DATA;


-- ����1) EMPLOYEES ���̺��� �μ����� �ο���,��� �޿�,
-- �޿��� ��,�ּ� �޿�,�ִ� �޿��� �����ϴ� EMP_DEPTNO ���̺��� �����϶�.

CREATE TABLE EMP_DEPTNO
-- create table emp_deptno("�μ���ȣ", "�ο���", "��ձ޿�", ... �̷������� create ��ü�� �ᵵ as�� ����ȴ�.)
AS
SELECT department_id AS DEPTNO, COUNT(*) AS e_count, AVG(SALARY) AS E_AVG, SUM(SALARY) AS E_SUM, MIN(SALARY) AS E_MIN, MAX(SALARY) AS E_MAX 
FROM employees
GROUP BY DEPARTMENT_ID;

SELECT
    *
FROM emp_deptno;

--����2) EMP_DEPTNO ���̺� ETC COLUMN�� �߰��϶�. 
--�� �ڷ����� VARCHAR2(50) ����϶�.

ALTER TABLE EMP_DEPTNO ADD(
ETC_COLUMN VARCHAR2(50));

--����3) EMP_DEPTNO ���̺� ETC COLUMN�� �����϶�. 
--�ڷ� ���� VARCHAR2(15)�� �϶�.


ALTER TABLE EMP_DEPTNO MODIFY(
ETC_COLUMN VARCHAR2(15));

-- ����4) EMP_DEPTNO ���̺� �ִ� ETC �� �����ϰ� Ȯ���϶�.

ALTER TABLE EMP_DEPTNO DROP(
ETC_COLUMN );

-- ���� 5 ������ ������ EMP_DEPTNO ���̺��� �̸��� EMP_DEPT�� �����϶�.

ALTER TABLE EMP_DEPTNO RENAME TO EMP_DEPT;

--����6) EMP_DEPT ���̺��� �����϶�.

DROP TABLE EMP_DEPT;

-- ����7) EMPLOYEES ���̺��� EMP ���̺��� �����ϰ� �����ϵ��� �϶�.
-- (������ ����)

CREATE TABLE EMP
AS
SELECT
    *
FROM EMPLOYEES;

-- ����8) EMP ���̺� row�� �߰��� ���ϴ�.
-- �ٸ�, �ݵ�� �����͸� ������ ���ص� �Ǹ�, NULL�� �����ϵ��� �Ѵ�.

INSERT INTO employees(employee_id, first_name, last_name, email, phone_number,
hire_date, job_id, salary, commission_pct, manager_id, department_id)
values(300, null, 'ȫ', 'hgd@naver.com', null,
    to_date('2005/10/15', 'YYYY/MM/DD'), 'IT_PROG', 100000, null, null, null);
    

SELECT
    *
FROM EMP;
 
--����9) EMPLOYEES ���̺��� EMPNO,ENAME,SAL,HIREDATE�� COLUMN�� �����Ͽ�
--EMP_10 ���̺��� ����(������ ������)�� �� 10�� �μ��� �����Ͽ� 
--�̿� �����ϴ� ���� EMP_10���̺� �Է��϶�.

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

-- ����10) EMPLOYEES ���̺��� ��� ��ȣ�� 107�� ����� �μ��� 10������ �����Ͽ���.

UPDATE EMPLOYEES
SET department_id = 10
WHERE employee_id = 107;

-- ����11) EMPLOYEES ���̺��� ��� ��ȣ�� 180��
--����� �μ��� 20, �޿��� 3500���� �����Ͽ���.

UPDATE EMPLOYEES
SET department_id = 20, salary = 3500
WHERE employee_id = 180;

--����12) EMPLOYEES ���̺��� Smith�� ������ �޿��� Hall�� ������ �޿���
--��ġ�ϵ��� �����϶�.

UPDATE employees
SET (JOB_ID, salary) = (SELECT JOB_ID, SALARY
                         FROM employees
                         WHERE LAST_NAME = 'Hall')
WHERE last_name = 'Smith';






