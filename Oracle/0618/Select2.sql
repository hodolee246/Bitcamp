-- WHERE == IF�� 

/*
    ǥ����
    �񱳿�����( =, >, <, !=, >=, <=, <>) != = <>
    NULL, =NULL(�̷��� ���°žƴ�)NULL ����� 1.IS NULL(���̳�?), 2.IS NOT NULL(�����ʴ�)
    (), NOT, AND, OR,
    
    
    ������
    SELECT  
    FROM    
    WHERE  ������ 
    
*/

-- FIRST_NAME = JULIA

SELECT FIRST_NAME, LAST_NAME, SALARY -- �̰� ����ض�
FROM EMPLOYEES -- ���⿡��
WHERE FIRST_NAME = 'Julia'; -- �̰Ŷ��

SELECT FIRST_NAME, LAST_NAME, salary
FROM EMPLOYEES
WHERE SALARY >= 9000;

-- �̸��� Shanta���� ū �̸�
SELECT first_name, last_name, salary
FROM EMPLOYEES
WHERE first_name >= 'Shanta';

SELECT first_name, last_name, manager_id
FROM employees
WHERE manager_id = ''; -- !NULL '' �� NULL �� �ƴϴ�!

SELECT first_name, last_name, manager_id
FROM employees
WHERE manager_id IS NOT NULL; -- IS NULL OR IS NOT NULL 


-- AND
SELECT first_name, last_name, salary
FROM employees
WHERE first_name = 'Shanta' AND first_name = 'John';  

-- OR
SELECT first_name, last_name, salary
FROM employees
WHERE first_name = 'Shanta' OR first_name = 'John';  

-- �̸� John, �޿� <= 5000

SELECT first_name, last_name, salary
FROM employees
WHERE first_name = 'John'
AND salary > 5000;


-- 2007�� 12�� 31�� ���Ŀ� �Ի��� ����� ����ض�.

SELECT first_name, hire_date
FROM employees
WHERE hire_date > TO_DATE('20071231', 'YYYY/MM/DD'); -- TO_MONTH

-- ALL(AND), ANY(OR)
SELECT first_name, last_name, salary
FROM employees
WHERE first_name = ANY('Julia', 'John', 'Steven');

SELECT first_name, salary
FROM employees
WHERE salary = ANY(8000, 3200, 6000);

-- IN, NOT IN  OR, !OR ����??
SELECT first_name, salary
FROM employees
WHERE salary IN(8000, 3200, 600);  -- ������ �̰��� ������� ����Ѵ�.


SELECT first_name, salary
FROM employees
WHERE salary NOT IN(8000, 3200, 600); -- ������ �̰� �� �ƴ� ������� ����Ѵ�.

SELECT first_name, last_name, salary
FROM employees
WHERE first_name NOT IN('Julia', 'John');

                -- OR �̶��� �ణ �ٸ���
                
SELECT first_name, last_name, salary
FROM employees
WHERE first_name IN('Julia', 'John');

-- EXISTS
SELECT e.first_name, e.job_id
FROM employees e
WHERE EXISTS ( SELECT 1         -- E�� �Ű�ü�� �ؼ� E.JOB ID�� ITPROG �� 1�� ����� �ϰ� ���� 1�� ����̵Ǹ� ����Ʈ �κ��� �̾Ƽ� ����ض� �̶��̴�.
                FROM DUAL       -- �̰� ���� ����
                WHERE e.job_id = 'IT_PROG');


-- BETWEEN ���� ������
/*
    SALARY >= 3200 AND SALARY <= 9000
    BETWEEN ���� AND �� �Է��� �� �ִ�.
*/

SELECT first_name, salary
FROM employees
WHERE SALARY >= 3200 AND SALARY <= 9000;


SELECT first_name, salary
FROM employees
WHERE SALARY BETWEEN 3200 AND 9000;


SELECT first_name, salary
FROM employees
WHERE SALARY NOT BETWEEN 3200 AND 9000; -- 3200~9000 �� �ƴѾֵ� ǥ���Ҷ� NOT BETWEEN

-- LIKE
SELECT first_name, last_name
FROM employees
WHERE first_name LIKE 'G_ra_d'; -- _(�����)�� �ѹ��� G*ra*d ��� ����� ����ض� *�� �� ���ڴ� �޶� �ȴٴ¶�


SELECT first_name, last_name
FROM employees
WHERE first_name LIKE 'K%y'; -- ù���ڰ� K �̰� ������ ���ڰ� y�ϰ��

SELECT first_name
FROM employees
WHERE first_name LIKE '%A%'; -- ��ġ ������� �̸��� A�� ������ ����Ѵ�

SELECT first_name
FROM employees
WHERE first_name LIKE '%Al%'; -- �̸��� Al�� ���ԵǾ������� 


-- 2006�⵵�� �Ի��� ���
SELECT first_name, hire_date
FROM employees
WHERE hire_date LIKE '06/01%'; -- 06�� 1���� �Ի��ѻ���� LIKE �� �Ի����� ���Ҷ����� ��¥ ������ �����־�� �Ѵ�.



































