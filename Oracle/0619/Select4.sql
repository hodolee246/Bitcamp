-- �빮�ڷ� �ٲٴ� �Լ� UPPER( ���ڿ� )
-- �ҹ��ڷ� �ٲٴ� �Լ� LOWER( ���ڿ� )


-- ���ڿ��� ���ϴ� ��� ||, CONCAT
SELECT first_name || ' ' || last_name
FROM employees;

-- CONCAT
SELECT CONCAT(FIRST_NAME, LAST_NAME)
FROM employees;

-- MONTHS_BETWEEN : �� ��¥���� ����(�� ����)
SELECT MONTHS_BETWEEN(SYSDATE, '2019-11-13')
FROM DUAL;

-- ADD_MONTHS : Ư�� ��¥�� ���� ������ ���� ���� �ش� ��¥�� ��ȯ�Ѵ�.
SELECT ADD_MONTHS('2019-06-23', 2)
FROM DUAL;

-- EXTRACT() : ��¥ �������� Ư���� ����, ��, ��, ��, ��, �ʸ�  ����
SELECT EXTRACT(YEAR FROM SYSDATE), -- ������ �÷� FROM ������ ���
    EXTRACT(MONTH FROM SYSDATE),
    EXTRACT(DAY FROM SYSDATE)
FROM DUAL;
-- �� �� ���� �����Ҷ����� SYSDATE �� ���������� ( SYSDATE �� ��¥�� �����ش� )
-- �� �� �ʸ� �����Ҷ����� SYSTIMESTAMP �� �����ؾ��Ѵ�. ( SYSTIMESTAMP �� �� �ʸ� �����ش�)
-- �ú���
SELECT EXTRACT(HOUR FROM CAST(SYSDATE AS TIMESTAMP)) AS ��,
    EXTRACT(MINUTE FROM CAST(SYSDATE AS TIMESTAMP)) AS ��,
    EXTRACT(SECOND FROM CAST(SYSDATE AS TIMESTAMP)) AS ��
FROM DUAL;

-- �ߺ����� ���� DISTINCT
SELECT DISTINCT department_id
FROM employees
ORDER BY department_id ASC;
-- �׷����� ���� ���
-- JOB_ID(����), DEPARTMENT_ID(�μ�)
-- GROUP BY��    �������� �׷����� ��������� ��� �׷����� ���� �÷��� ������(���)�� �����ϴ�.
SELECT department_id
FROM employees
GROUP BY department_id
ORDER BY department_id ASC;

/*

GROUP �Լ�
COUNT
SUM
AVG
MAX
MIN

*/

SELECT COUNT(SALARY), COUNT(*), SUM(SALARY), AVG(salary),
    SUM(salary) / COUNT(*)
FROM employees
WHERE job_id = 'IT_PROG';

/*
NVL(����� �Ǵ� �÷�, ��) �������̸� ������ ��, �������̸� ������ ��
NVL(����� �Ǵ� �÷��� NULL �ϰ��, ���� �������� NULL�� �ƴҰ�� �׳� �״�� �Ѵ�.

NVL(����� �Ǵ� �÷�, ��1, 0)
����� �Ǵ� �÷��� !- NULL --> ��1
����� �Ǵ� �÷��� NULL �̸� -> ��0
*/

SELECT first_name, NVL(commission_pct, 0)
FROM employees;

SELECT first_name, NVL2(commission_pct, '����', '����')
FROM employees;

SELECT department_id, SUM(salary), MAX(salary), MIN(salary)
FROM employees
GROUP BY department_id
ORDER BY department_id ASC;

SELECT department_id, JOB_ID
FROM employees
GROUP BY department_id, job_id;

-- GROUP BY
-- ������ HAVING 

SELECT job_id, SUM(salary)
FROM employees
GROUP BY job_id
HAVING SUM(SALARY) >= 30000
ORDER BY SUM(salary) DESC;

SELECT job_id, COUNT(*), SUM(salary), TRUNC (AVG(salary))
FROM employees
WHERE salary > 5000
GROUP BY job_id
HAVING SUM(salary) > 20000;







