-- Ư�� Query
-- CASE, DECODE

SELECT employee_id, first_name, phone_number,
    CASE SUBSTR(phone_number, 1, 3)     --CASE ����(��Ȯ�� ��)�ϰ��
        WHEN '515' THEN '���'            --
        WHEN '590' THEN '�λ�'
        WHEN '659' THEN '����'
        WHEN '603' THEN '����'
        ELSE '��Ÿ'
    END as "�����Դϴ�."
FROM employees;


/*
SELECT employee_id, first_name, phone_number, 
    CASE
        WHEN SUBSTR(phone_number, 1, 3) = '515' THEN 'T�ÿ�'
        WHEN SUBSTR(phone_number, 1, 3) = '590' THEN '�λ�'
        WHEN SUBSTR(phone_number, 1, 3) = '659' THEN '����'
        WHEN SUBSTR(phone_number, 1, 3) = '603' THEN '�����'
        ELSE 'GiŸ'
    END as "�׽�Ʈ �Դϴ�~~" 
FROM emplyees;
*/
SELECT employee_id, FIRST_name, salary,
    CASE
        WHEN salary BETWEEN 7000 AND 8000 THEN '7'
        WHEN salary BETWEEN 8001 AND 9000 THEN '��'
        WHEN salary BETWEEN 9001 AND 10000 THEN '��!'
        ELSE '�Ф�'
    END as "����"    
FROM employees ;

-- DECODE

SELECT employee_id, first_name, phone_number,
    DECODE(SUBSTR(phone_number, 1, 3), 
        '515', 'tj��',
        '590', 'qn��',
        '659', '��wn',
        '603', '����', '��Ÿ') as "wwllgguurr"
FROM employees;


-- OVER(  ) PARTITION BY ORDER BY
-- ���� ��ŷ 1������ 5������ ����Ͻÿ�

-- HOW TO CUT?          -- ��Ƽ�� ���̴� �׷���� ������� ����Ѵ�
                                            -- �׷����� �����         -- ����
SELECT job_id, salary, count(*)OVER(PARTITION BY job_id ORDER BY job_id, salary desc)
FROM employees;                             -- �׷����� ���ϰ�            ����!

SELECT job_id,  count(*)OVER()  -- �̷���� �� ���̺��� ���δ� ī��Ʈ�� ������ 107�� ��µȴ�.
FROM employees;

SELECT job_id,  count(*)OVER(PARTITION BY job_id) -- �� ���̺� �ִ� job id  ������ �����
FROM employees;                         

    -- �׷����� �����ʰ� �÷��� Ȯ���ϰ� ������ ����Ѵ�(?)
    -- MAX, MIN, SUM, AVG
    
SELECT department_id,last_name, salary,  MAX(salary)OVER(PARTITION BY department_id)
FROM employees;
    
SELECT department_id,last_name, salary,  SUM(salary)OVER(PARTITION BY department_id)
FROM employees;    
    
-- ���� ���Ǵ� �Լ� "�м��Լ�"
-- ����(RANK)
-- RANK()       1 2 3 3 5 6 7 (��ŷ ǥ�� ���) ���������� ������ ���ڸ�ŭ ��ŷ�� �Ѿ��
-- DENSE_RANK() 1 2 3 3 4 5 6 (��ŷ ǥ�� ���) ���������� �־ �״��� ���� ������´�
-- ROW_NUMBER() 1 2 3 4 5 6 7 (��ŷ ǥ�� ���)  �������� �����ϰ� �׳� ������� ǥ���Ѵ�.
-- ROWNUM       1 2 3 4 5 6 7 (��ŷ ǥ�� ���) �������� �����ϰ� �׳� ������� ǥ���Ѵ�.

SELECT salary, first_name,
    RANK()OVER(ORDER BY salary DESC) AS ��ũ,
    DENSE_RANK()OVER(ORDER BY salary DESC) AS ������ũ,
    ROW_number()OVER(ORDER BY salary DESC) AS �ο�ѹ�
FROM employees
ORDER BY salary DESC;    

-- 10���� �����͸� �����ϴ� ���

SELECT rownum, employee_id, first_name, salary            -- 2. (�������)
FROM employees
WHERE rownum > 10 AND rownum <= 20;                       -- 1. (�������)

-- 1. ����
-- 2. rownum
-- 3. ������ ����
SELECT RNUM, employee_id, first_name, salary
FROM
    (SELECT ROWNUM AS RNUM,                 -- 2.rownum �ϼ�
        employee_id, first_name, salary
    FROM
        (SELECT employee_id, first_name, salary -- 1. data�� ����
        FROM employees)
    )
WHERE RNUM > 10 AND RNUM <= 20;    -- 3. ��������



SELECT test, employee_id, last_name, salary
FROM
        (SELECT rownum as test,
             employee_id, salary, last_name
             
        FROM
        
            (SELECT employee_id, salary, last_name
            FROM employees))
WHERE test between 1 AND 5;









































































