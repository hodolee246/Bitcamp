-- DML(INSERT, DELETE, SELECT(90%), UPDATE) 
-- PL (PROCEDURAL LANGUAGE) PL�� ��Ŭ�������� ������ ���Ѵ�

SELECT * FROM EMP;       -- SCOOTT ������ ������̺�

SELECT * FROM EMPLOYEES; -- HR(HUMAN RESOURCE)
/*
SELECT ��  ����
    *  ��� (��, ����, COLUMN, �Լ�, SUB QUERY
                                    QUERY �ȿ� QUERY�� �ϳ� �� �ִ°� ���� �������ϳ�.
FROM �� (���̺��, SUB QUERY 
*/

-- ���� ������ ���̺� ��� ��(����Ѵ�)
SELECT * FROM TAB;

-- ���̺��� ���ϴ� COLUMN���� ��
SELECT EMPNO, ENAME, SAL
    
FROM EMP;

-- DUAL : ���� ���̺�
SELECT SYSDATE FROM DUAL;

SELECT 4 * 9 FROM DUAL;

SELECT 'HELLO' || 'HELLO' FROM DUAL; -- ���ڿ� ���̱� �ڹٿ����� + ��� ����� ||�̴�.

SELECT ROUND(11.4) FROM DUAL; -- ROUND(�ݿø�)

SELECT ENAME, SAL, SAL + 300
FROM EMP;

SELECT SAL, SAL * 12
FROM EMP;

-- ALIAS int alias[] = array;   alias[] = 12;

SELECT
SAL AS "����", SAL * 12 AS ���� -- AS ������ ū����ǥ�� ����Ѵ� ����� ���ϴ��� ����� ����������
-- �߰��� ���Ⱑ ������� ����Ŭ�� �ν��� ���ؼ� ������ ����Ű�� ����
-- ���� �ξ������ ū����ǥ�� ����ؾ� ���������� ����̵ȴ�.
FROM EMP;

-- ���� ������ ||  JAVA "ABC" + "DEF"    ORACLE "ABC" || "DEF"
SELECT
ENAME || ' has $ ' || SAL
FROM EMP;

-- distint : �ߺ���(row) ���� == group by (��� �󵵴� �̰� �� ����)

SELECT
DISTINCT DEPTNO
FROM EMP;

-- DESC : ���̺��� COLUMN�� �ڷ����� ������ ��
DESC EMP;

-- 1��
SELECT
EMPNO, ENAME, SAL
FROM EMP;

-- 2��
SELECT
ENAME AS "�� ��", SAL AS "�� ��"    -- as�� ������ �����ϴ�. �׳� �ٿ���
FROM EMP;

-- 3��
SELECT
EMPNO AS "�����ȣ", ENAME AS "����̸�", SAL AS "����", SAL * 12 AS "����"    
FROM EMP;

-- 4��
SELECT
DISTINCT JOB
FROM EMP;

-- 5��
SELECT
'(' || ENAME || ', ' || JOB || ')' AS "Employee and Job"    
FROM EMP;

-- 6��

SELECT
LAST_NAME AS "�̸�", SALARY AS "�޿�"
FROM EMPLOYEES;

-- 7��
SELECT
LAST_NAME AS "NAME", salary*12 AS "Annual Salary(����)"    
FROM EMPLOYEES;

-- 8��
SELECT
LAST_NAME || JOB_ID
FROM EMPLOYEES;

-- 9��
SELECT
LAST_NAME || ' is a ' || JOB_ID AS "employees Details"
FROM employees;

-- 10��
SELECT
LAST_NAME || ': 1 Year Salary =' || salary * 12 AS "MONTHLY"
FROM EMPLOYEES;

-- 11��
SELECT
job_id
FROM EMPLOYEES;

-- NVL(�÷���, 0)  �Ű����� ���� �÷����� �־��ְ� (���࿡ �÷��� Null �̶��, 0���� �����ض� �� ���̴�.) �ڿ� ���� ���̶�� ������ ���� �Է�



