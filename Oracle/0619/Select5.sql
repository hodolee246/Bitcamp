/*

    Join
    두개 이상의 테이블을 연결해서 데이터를 검색하는 방법이다. ^_^
    보통 둘 이상의 행(ROW)들의 공통된 값(Primary Key(기본키)), Foreign Key(외래키)값을
    사용해서 Join 한다.
    
    Primary Key(기본키) - 테이블에 내장, 중복되지 않는 키 -> id, seq
    Foreign Key(외래키) - 다른 테이블에서 Primary Key, 고유키일 가능성이 높다.
    
    inner Join  중요도 *****
    cross Join  중요도 *
    outer Join  중요도 ***
        left
        right
    self Join    중요도 *****
    
    SQL : Oracle, Ansi SQL



*/

-- inner Join
-- Ansi SQL
SELECT e.employee_id, e.first_name, e.salary,
    e.department_id, d.department_id,
    d.department_name
FROM employees E Inner JOIN departments D -- E 에 있는 데이터를 D로 가서 필요한 데이터를 가져온다.
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

-- 사원번호 147번의 사람의 부서명, 업무명 출력해라
SELECT e.employee_id,
    d.department_id, d.department_id,
    e.job_id, j.job_id,
    d.department_name, j.job_title
FROM employees e, Departments d, jobs j
where e.department_id = d.department_id
    AND e.job_id = j.job_id 
    AND e.employee_id = 147;

-- cross Join     ( 1 2 3 ) ( a b c ) 전부다 하나씩 조인해준다 (1a 1b 1c 2a 2b 2c 3a 3b 3c)
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
--      킴벌리                       110번 이상되는 부서번호

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

-- right outer join ansi 문법은 LEFT 를 RIGHT 로 바꾸면됨
SELECT e.employee_id, e.first_name,
    e.department_id, d.department_id, d.department_name
FROM employees e, departments d
WHERE e.department_id(+) = d.department_id;

-- LEFT, RIGHT outer join 부분에서 u집합 제외
SELECT e.employee_id, e.first_name,
    e.department_id, d.department_id, d.department_name
FROM employees e, departments d
WHERE e.department_id = d.department_id(+)
AND e.department_id is null;

-- self Join : 동일한 테이블을 Join 하지만 서로 다른테이블이라 생각을 해야한다.

SELECT a.employee_id, a.first_name,
    a.manager_id, b.employee_id,
    b.first_name
FROM employees a, employees b  -- a(사원의 정보)의 목적은 매니저번호(상사번호)를 뽑기 위해서, b(매니저) : 
WHERE a.manager_id = b.employee_id;

-- 계층형 구조
SELECT a.employee_id, a.first_name as "사원",
    a.manager_id as "사원의 상사", b.employee_id,
    b.first_name as "상사"
FROM employees a, employees b
WHERE a.manager_id = b.employee_id(+)
--CONNECT BY PRIOR a.manager_id = a.employee_id; -- 상향식
CONNECT BY a.manager_id = PRIOR a.employee_id; -- 하향식
