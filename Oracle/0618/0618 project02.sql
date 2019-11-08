
-- 巩力 1
SELECT employee_id, last_name, job_id, salary
FROM employees
WHERE salary >= 3000;

-- 巩力 2
SELECT employee_id, last_name, job_id, salary, department_id
FROM employees
WHERE job_id = 'ST_MAN';

-- 巩力 3
SELECT employee_id, last_name, job_id, salary, hire_date, department_id
FROM employees
WHERE hire_date > TO_DATE('20060101', 'YYYY/MM/DD');

-- 巩力 4
SELECT last_name, salary, department_id
FROM employees
WHERE salary BETWEEN 3000 AND 5000;

-- 巩力 5
SELECT employee_id, last_name, job_id, salary, hire_date
FROM employees
WHERE employee_id IN(145, 152, 203);

-- 巩力 6
SELECT employee_id, last_name, job_id, salary, hire_date, department_id
FROM employees
WHERE hire_date LIKE '06%';

-- 巩力 7
SELECT employee_id, last_name, job_id, salary, hire_date, commission_pct, department_id
FROM employees
WHERE commission_pct IS NULL;

-- 巩力 8
SELECT employee_id, last_name, job_id, salary, hire_date, department_id 
FROM employees
WHERE salary >= 1000 AND job_id = 'ST_MAN';

-- 巩力 9
SELECT employee_id, last_name, job_id, salary, hire_date, department_id
FROM employees
WHERE salary >= 10000 OR job_id = 'ST_MAN';

-- 巩力 10
SELECT employee_id, last_name, job_id, salary, department_id
FROM employees
WHERE job_id NOT IN('ST_MAN', 'SA_MAN', 'SA_REP');

-- 巩力 11
SELECT employee_id, last_name, job_id, salary
FROM employees
WHERE job_id = 'AD_PRES' AND salary >= 12000 OR job_id = 'SA_MAN';

-- 巩力 12
SELECT employee_id, last_name, job_id, salary
FROM employees
WHERE job_id = 'AD_PRES' OR job_id = 'SA_MAN' AND salary > 12000;

















