-- 33) 각 사원의 이름을 표시하고 근무 달 수(입사일로부터 현재까지의 달수)를 계산하여
--열 레이블을 MONTHS_WORKED로 지정하시오. 결과는 정수로 반올림하여 표시하고 근무달 수를
--기준으로 오름차순으로 정렬하시오.(MONTHS_BETWEEN 함수 참고)

SELECT ename, round(MONTHS_BETWEEN(SYSDATE,hiredate), 0) as MONTHS_WORKED
FROM emp
ORDER BY MONTHS_WORKED;

-- 34)emp테이블에서 이름, 업무, 근무연차를 출력하시오.

SELECT ename, job, round(MONTHS_BETWEEN(SYSDATE,hiredate) / 12, 0) as 연차
FROM emp
ORDER BY 연차 DESC;

-- 35)emp테이블에서 사원이름, 월급, 월급과 커미션을 더한 값을 컬럼명 실급여라고 해서 출력.
--     단, NULL값은 나타나지 않게 작성하시오.

SELECT ename, sal, sal + nvl(comm, 0) as 실급여
FROM emp;

-- 36)월급과 커미션을 합친 금액이 2,000이상인 급여를 받는 사원의 이름,업무,월급,커미션,고용날짜
-- 를 출력하시오. 단, 고용날짜는 1980-12-17 형태로 출력하시오.

SELECT ename, job, sal, comm, TO_CHAR(hiredate, 'YYYY-MM-DD') as 고용일
FROM emp
WHERE sal + nvl(comm, 0) >= 2000
ORDER BY 고용일;

-- 37)DECODE 또는 CASE WHEN THEN 함수를 사용하여 다음 데이터에 따라 JOB열의 값을 기준으로 모든 사원의 등급을 표시하시오.
/*
업무        등급
PRESIDENT   A
ANALYST     B
MANAGER     C
SALESMAN    D
CLERK       E
기타         0
*/


SELECT empno, ename, job,
    CASE job
        WHEN 'PRESIDENT' THEN 'A'
        WHEN 'ANALYST' THEN 'B'
        WHEN 'MANAGER' THEN 'C'
        WHEN 'SALESMAN' THEN 'D'
        WHEN 'CLERK' THEN 'E'
        ELSE '0'
    END as 등급    
FROM emp;

-- HR

-- 1. 가장 최근 입사한 사원순으로 작성해서 1 ~ 10번째 사원의 정보를 출력하시오.

SELECT ROWNUM, employee_id, last_name, job_id, salary, department_id, hire_date
FROM employees
WHERE ROWNUM <= 10
ORDER BY hire_date DESC;

-- 2. 급여순으로 작성해서 11 ~ 20 사원의 정보를 출력하시오.

SELECT rnum, last_name, job_id, department_id, salary
FROM (SELECT ROWNUM as rnum , EMPLOYEE_id, last_name, job_id, department_id, salary
        FROM ( SELECT
            *
                FROM employees
                ORDER BY SALARY DESC))
WHERE rnum between 11 AND 20;            

-- 3. 입사한 순서대로 번호를 할당하고, JOB_ID가 IT_PROG이며, 05년도에 입사한 사원을 3명만 출력하라

SELECT ROWNUM, last_name, job_id, hire_date
FROM employees
WHERE job_id = 'IT_PROG' AND hire_date between to_date(20050101, 'YYYYMMDD') AND to_date(20051231, 'YYYYMMDD')
AND ROWNUM <= 3;

SELECT employee_id, first_name, job_id, hire_date
FROM
    (SELECT row_number() over(partition by substr(hire_date, 1, 2) order by hire_date asc)
        employee_id, first_name, job_id, hire_date
FROM employees
WHERE job_id = 'IT_PROG' AND SUBSTR(hire_date, 1, 2) = '5')
WHERE rn BETWEEN 1 AND 3;


-- hr 계쩡 연습문제

-- --1. 직책(Job Title)이 Sales Manager인 사원들의 입사년도와 입사년도(hire_date)별 평균 급여를 출력하시오. 
--   출력 시 년도를 기준으로 오름차순 정렬하시오. 

SELECT hire_date, trunc(avg(salary))
FROM employees e, jobs j
WHERE e.job_id = j.job_id
AND j.job_title = 'Sales Manager'
GROUP BY e.hire_date
HAVING TO_CHAR(e.hire_date, 'YYYY'); 
--2. 각 도시(city)에 있는 모든 부서 직원들의 평균급여를 조회하고자 한다. 
--   평균급여가 가장 낮은 도시부터 도시명(city)과 평균연봉, 해당 도시의 직원수를 출력하시오. 
--   단, 도시에 근무하는 직원이 10명 이상인 곳은 제외하고 조회하시오.

SELECT l.city, TRUNC(AVG(salary)), count(*)
FROM employees e, departments d
WHERE (e.salary) IN

(SELECT TRUNC(AVG(e.salary))
FROM employees e, departments d, locations l
WHERE e.department_id = d.department_id
AND l.location_id = d.location_id
GROUP BY d.department_name
HAVING COUNT(e.department_id) < 10)

AND e.department_id = d.department_id
ORDER BY salary DESC;

--3. ‘Public  Accountant’의 직책(job_title)으로 과거에 근무한 적이 있는 모든 사원의 사번과 이름을 출력하시오. 
--   (현재 ‘Public Accountant’의 직책(job_title)으로 근무하는 사원은 고려 하지 않는다.)      
--   이름은 first_name, last_name을 아래의 실행결과와 같이 출력한다.

SELECT
    *
FROM employees e, job_history h, jobs j
WHERE 

(select * from where 


AND e.department_id = h.department_id
AND h.job_id = j.job_id;
 
 
 
 

 
 
--4. 자신의 매니저보다 연봉(salary)를 많이 받는 직원들의 성(last_name)과 연봉(salary)를 출 력하시오. 


SELECT last_name, salary
FROM EMPLOYEES
GROUP BY employee_id         
HAVING salary > (select max(salary)
                 FROM employees
                 GROUP BY manager_id);











































