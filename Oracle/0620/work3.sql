-- hr ���� 1
SELECT employee_id, last_name, LOWER(last_name), LOWER(job_id), department_id
FROM employees
WHERE LOWER(last_name) = 'king';

-- ���� 2

SELECT employee_id, last_name, UPPER(last_name), UPPER(job_id), department_id
FROM employees
WHERE UPPER(last_name) = 'KING';

-- ���� 3��

sele







































