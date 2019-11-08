/*

    Join
    �ΰ� �̻��� ���̺��� �����ؼ� �����͸� �˻��ϴ� ����̴�. ^_^
    ���� �� �̻��� ��(ROW)���� ����� ��(Primary Key(�⺻Ű)), Foreign Key(�ܷ�Ű)����
    ����ؼ� Join �Ѵ�.
    
    Primary Key(�⺻Ű) - ���̺� ����, �ߺ����� �ʴ� Ű -> id, seq
    Foreign Key(�ܷ�Ű) - �ٸ� ���̺��� Primary Key, ����Ű�� ���ɼ��� ����.
    
    inner Join  �߿䵵 *****
    cross Join  �߿䵵 *
    outer Join  �߿䵵 ***
        left
        right
    self Join    �߿䵵 *****
    
    SQL : Oracle, Ansi SQL



*/

-- inner Join
-- Ansi SQL
SELECT e.employee_id, e.first_name, e.salary,
    e.department_id, d.department_id,
    d.department_name
FROM employees E Inner JOIN departments D -- E �� �ִ� �����͸� D�� ���� �ʿ��� �����͸� �����´�.
    ON e.department_id = d.department_id;

SELECT
    *
FROM employees
where department_id is null;

SELECT DISTINCT department_id
FROM employees
group by department_id
Order by department_id;

-- Oracle

SELECT e.employee_id, e.first_name, e.salary,
    e.department_id, d.department_id,
    d.department_name, d.location_id
FROM employees e, departments d
where e.department_id = d.department_id;

SELECT e.first_name,
    e.job_id, j.job_id, 
    j.job_title
FROM employees e, jobs j
where e.job_id = j.job_id
    AND e.first_name = 'Shanta';

-- �����ȣ 147���� ����� �μ���, ������ ����ض�
SELECT e.employee_id,
    d.department_id, d.department_id,
    e.job_id, j.job_id,
    d.department_name, j.job_title
FROM employees e, Departments d, jobs j
where e.department_id = d.department_id
    AND e.job_id = j.job_id 
    AND e.employee_id = 147;

-- cross Join     ( 1 2 3 ) ( a b c ) ���δ� �ϳ��� �������ش� (1a 1b 1c 2a 2b 2c 3a 3b 3c)
-- ansi SQL

SELECT e.employee_id, e.first_name,
    e.department_id, d.department_id,
    d.department_name
FROM employees e CROSS JOIN departments d;

-- Oracle

SELECT e.employee_id, e.first_name,
    e.department_id, d.department_id,
    d.department_name
FROM employees e, departments d;

-- full outer Join
-- ansi

SELECT e.employee_id, e.first_name,
    d.department_id, d.department_id,
    d.department_name
FROM employees e FULL OUTER JOIN departments d
    ON e.department_id = d.department_id;
--WHERE e.department_id is null OR d.department_id is null;    
--      Ŵ����                       110�� �̻�Ǵ� �μ���ȣ

-- outer Join
-- left
-- right
-- Ansi
SELECT e.employee_id, e.first_name,
    e.department_id, d.department_id, d.department_name
FROM employees e LEFT/* right outer join */ OUTER JOIN departments d
    ON e.department_id = d.department_id;

-- Oracle

SELECT e.employee_id, e.first_name,
    e.department_id, d.department_id, d.department_name
FROM employees e, departments d
WHERE e.department_id = d.department_id(+);

-- right outer join ansi ������ LEFT �� RIGHT �� �ٲٸ��
SELECT e.employee_id, e.first_name,
    e.department_id, d.department_id, d.department_name
FROM employees e, departments d
WHERE e.department_id(+) = d.department_id;

-- LEFT, RIGHT outer join �κп��� u���� ����
SELECT e.employee_id, e.first_name,
    e.department_id, d.department_id, d.department_name
FROM employees e, departments d
WHERE e.department_id = d.department_id(+)
AND e.department_id is null;

-- self Join : ������ ���̺��� Join ������ ���� �ٸ����̺��̶� ������ �ؾ��Ѵ�.

SELECT a.employee_id, a.first_name,
    a.manager_id, b.employee_id,
    b.first_name
FROM employees a, employees b  -- a(����� ����)�� ������ �Ŵ�����ȣ(����ȣ)�� �̱� ���ؼ�, b(�Ŵ���) : 
WHERE a.manager_id = b.employee_id;

-- ������ ����
SELECT a.employee_id, a.first_name as "���",
    a.manager_id as "����� ���", b.employee_id,
    b.first_name as "���"
FROM employees a, employees b
WHERE a.manager_id = b.employee_id(+)
--CONNECT BY PRIOR a.manager_id = a.employee_id; -- �����
CONNECT BY a.manager_id = PRIOR a.employee_id; -- �����
