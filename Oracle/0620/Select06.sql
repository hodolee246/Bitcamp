-- SUB QUERY
-- QUERY 안의 QUERY 문이다.
-- 한개의 행에서 결과 값이 반환되는 QUERY
    --   ROW
-- SELECT   단일행 단일컬럼 나오는 데이터는 한개, 컬럼 한개
-- FROM     다중행 다중컬럼이 가능하다
-- WHERE    다중행 다중컬럼을 사용할 수 있다. -- 제일 많이 사용하는 ㅓㅅ
/*
    SELECT (SELECT FIRST_NAME, LAST_NAME FROM EMPLOYEES)    X 단일컬럼이 아님
    SELECT EMPLOYEE_ID,(SELECT FIRST_NAME FROM EMPLOYEES)               X ROW가 다중 값
    
    SELECT (SELECT FIRST_NAME FROM EMPLOYEES WHERE EMPLOYEE_ID = 100)
      
*/
-- SELECT
SELECT employee_id, first_name,salary,
    (SELECT SUM(salary)  from employees),
    (SELECT COUNT(*) FROM employees)
FROM employees;
    
-- FROM
SELECT employee_id, LAST_NAME, SALARY, DEPARTMENT_ID
FROM (SELECT employee_id, last_name, salary, department_id
    FROM employees
    WHERE department_id = 10);
/*
-- 부서번호가 20번이고 급여가 6000이상인 사원
SELECT
    *
FROM employees
WHERE department_id = 20;
    AND salary >= 6000;
    */
 SELECT
     *
 FROM (select
        *
        FROM employees
        WHERE department_id = 20)
WHERE salary >= 7000;
/*
SELECT a.employee_id, a.first_name, a.job_id, b.job_id b."급여합계", b."인원수"
FROM employees a, (select job_id, sum(sal) as "급여합계", count(*) as "인원수" 
                    From employees
                   GROUP BY job_id) b
WHERE a.job_id = b.job_id AND a.first_name = 'Steven';                            
*/
-- WHERE 절
SELECT first_name, salary
FROM employees
WHERE salary > (SELECT AVG(salary) FROM employees);

SELECT first_name, job_id
FROM employees
WHERE job_id IN(SELECT job_id FROM jobs WHERE job_id = 'IT_PROG');

-- 부서별로 가장 급여를 적게 받는 사원과 같은 급여를 받는 사원
-- 10 -> 2500 ==

SELECT first_name, salary, department_id
FROM employees
WHERE salary  IN(SELECT MIN(salary)
                FROM employees
                GROUP BY department_id)
                ORDER BY department_id, salary;

-- 부서별로 가장 급여를 적게 받는 사원의 정보
SELECT department_id, first_name, salary
FROM employees
WHERE (department_id, salary) IN(   SELECT department_id, min(salary)
                                    FROM employees
                                    GROUP BY department_id)
                                     ORDER BY department_id;

-- subquery 문제 scoff

-- 60) BLAKE와 같은 부서에 있는 사원들의 이름과 입사일을 구하는데 
--    BLAKE는 제외하고 출력하시오.(BLAKE가 여러명일 수 있음)
SELECT ename, hiredate, deptno
FROM emp
WHERE (deptno) in (     SELECT deptno
                        FROM emp
                        WHERE ename = 'BLAKE')
                        AND ename <> 'BLAKE';
                        
-- 61) (평균급여보다 많은 급여)를 받는 사원들의 사원번호, 이름, 월급을 출력하는데 (월급이
--    높은 사람순으로 출력)하시오.

SELECT empno, ename, sal
FROM emp
WHERE sal >(SELECT trunc(avg(sal))
            FROM emp)
 ORDER BY sal DESC;           

-- 62) (10번부서에서 급여를 가장 적게 받는 사원)과 동일한 급여를 받는 사원의 이름을 출력하시오.

SELECT ename, sal, deptno
FROM emp
WHERE (sal) in (SELECT min(sal)
                FROM emp
                WHERE deptno = 10);
   --             AND deptno <> 10;

-- 63) 사원수가 3명이 넘는 부서의 부서명과 사원수를 출력하시오--------------

SELECT d.dname, count(e.empno)
FROM emp e, dept d
WHERE e.deptno = d.deptno
GROUP BY d.dname
HAVING COUNT(e.empno) > 3; 
--64) 사원번호가 7844인 사원보다 빨리 입사한 사원의 이름과 입사일을 출력하시오.

SELECT ename, hiredate
FROM emp
WHERE (hiredate) < ( SELECT hiredate
                            FROM emp
                            WHERE empno = 7844);
                            

-- 65) 직속상사(mgr)가 KING인 모든 사원의 이름과 급여를 출력하시오

SELECT ename, sal, mgr
FROM emp
WHERE mgr IN (SELECT empno
              FROM emp
              WHERE ename = 'KING');

-- 66) 20번 부서에서 가장 급여를 많이 받는 사원과 동일한 급여를 받는 사원의 이름과 부서명,
    -- 급여, 급여등급을 출력하시오.(emp, dept, salgrade


SELECT e.ename, e.sal, d.deptno, d.dname, s.grade
FROM emp e,dept d, salgrade s
WHERE (sal) in (SELECT max(sal)
                FROM emp
                WHERE deptno = 20)
                AND e.deptno = d.deptno
                AND e.sal BETWEEN s.losal AND s.hisal;
                
--                AND deptno <> 20;

-- 67) 총급여(sal+comm)가 평균 급여보다 많은 급여를 받는 사람의 부서번호, 이름, 총급여, 
--    커미션을 출력하시오.(커미션은 유(O),무(X)로 표시하고 컬럼명은 "comm유무" 출력)

SELECT deptno, ename, sal + comm, comm
FROM emp
WHERE sal + nvl(comm, 0) > (SELECT trunc(avg(sal + nvl(comm, 0)))
                        FROM emp);
                        
-- 68) CHICAGO 지역에서 근무하는 사원의 평균 급여보다 높은 급여를 받는 사원의 이름과 급여, --------------
--    지역명을 출력하시오.

SELECT e.ename, e.sal, d.loc
FROM emp e, dept d
WHERE e.deptno = d.deptno AND
(sal) > (SELECT trunc(avg(sal))
                     FROM emp
                       WHERE  deptno in (SELECT deptno
                                        FROM dept
                                        WHERE loc = 'CHICAGO')
                    GROUP BY deptno);                    
                                                

-- 69) 업무가 SALESMAN인 직원이 2명 이상인 부서의 이름, 근무하는 사원의 이름, 업무를 출력--------
SELECT d.dname, e.ename, e.job
FROM emp e, dept d
WHERE e.deptno = d.deptno
AND e.deptno IN
(SELECT deptno
FROM emp
WHERE job = 'SALESMAN'
GROUP BY deptno
HAVING COUNT(job) >= 2);

-- 70) 커미션이 없는 사원들 중 월급이 가장 높은 사원의 이름과 급여등급을 출력하시오.

SELECT e.ename, e.sal, s.grade, e.comm
FROM emp e, salgrade s
WHERE (e.sal) IN (SELECT MAX(sal) 
                    FROM emp
                    WHERE comm is null)
AND e.sal BETWEEN s.losal AND s.hisal;

-- 71) SMITH의 관리자(mgr)의 이름과 부서명, 근무지역을 출력하시오.

SELECT e.ename, d.dname, e.mgr, d.loc
FROM emp e, dept d
WHERE e.empno IN (SELECT mgr
                FROM emp 
                WHERE ename = 'SMITH')
AND e.deptno = d.deptno;                

-- SubQery(?) ppt SR

-- 문제1) EMPLOYEES 테이블에서 Kochhar의 급여보다 많은 사원의 정보를 사원번호,이름,담당업무,급여를 출력하라


-- 문제2) EMPLOYEES 테이블에서 급여의 평균보다 적은 사원의 정보를 사원번호,이름,담당업무,급여,부서번호를 출력하여라.

SELECT employee_id, first_name, job_id, salary, department_id
FROM employees
WHERE salary < (SELECT TRUNC(AVG(salary))
                FROM employees)
ORDER BY salary DESC;

-- 문제3) EMPLOYEES 테이블에서 100번 부서의 최소 급여보다 최소 급여가 많은 다른 모든 부서를 출력하라

SELECT department_id
FROM employees
GROUP BY department_id
HAVING MIN(salary) > (SELECT MIN(salary)
                     FROM employees
                     WHERE department_id = 100);
                    
--  문제4) 업무별로 최소 급여를 받는 사원의 정보를 사원번호,이름,업무,부서번호를 출력하여라. 단 업무별로 정렬하여라.

SELECT employee_id, last_name, job_id, department_id, salary
FROM employees
WHERE (job_id, salary) IN (SELECT job_id, MIN(salary)
                 FROM employees
                 GROUP BY job_id)
ORDER BY job_id;
-- 문제5) EMPLOYEES 과 DEPARTMENTS 테이블에서 업무가 SA_MAN 사원의 정보를 이름,업무,부서명,근무지를 출력하라.

SELECT e.last_name, e.job_id, d.department_name, d.location_id
FROM employees e, departments d
WHERE e.department_id = d.department_id
AND e.job_id = 'SA_MAN';

SELECT e.last_name, e.job_id, d.department_name, d.location_id
FROM (select first_name, job_id, department_id
      FROM employees
      WHERE job_id = 'SA_MAN') e, dpartments d
WHERE e.department_id = d.department_id;


-- 문제6)   EMPLOYEES  테이블에서 가장 많은 사원을 갖는 MANAGER의 사원번호를 출력하라.

SELECT MANAGER_ID
FROM EMPLOYEES
GROUP BY MANAGER_ID
HAVING COUNT(manager_id) = ( SELECT MAX(COUNT(*))
                     FROM EMPLOYEES
                     GROUP BY MANAGER_ID);

 
--문제7) EMPLOYEES  테이블에서 가장 많은 사원이 속해있는 부서번호와 사원수를 출력하라.
 
SELECT department_id, COUNT(*)
FROM EMPLOYEES
GROUP BY department_id
HAVING COUNT(department_id) = ( SELECT MAX(COUNT(*))
                                 FROM EMPLOYEES
                                 GROUP BY department_id);

-- 문제8)   EMPLOYEES  테이블에서 사원번호가 123인 사원의 직업과 같고 
--사원번호가 192인 사원의 급여(SAL)보다 많은 사원의 사원번호, 이름, 
--직업, 급여를 출력하라.

SELECT employee_id, last_name, job_id, salary    
FROM EMPLOYEES
WHERE (job_id) IN ( SELECT job_id   
                         FROM employees
                         WHERE employee_id = 123 AND salary > (SELECT salary
                                                                 FROM employees
                                                                WHERE employee_id = 192));

-- 문제9)   직업(JOB)별로 최소 급여를 받는 사원의 정보를 사원번호, 이름, 업무, 부서명을 출력하라.
-- 조건1 : 직업별로 내림차순 정렬

SELECT employee_id, job_id, last_name, d.department_name, e.salary
FROM employees e, departments d
WHERE e.department_id = d.department_id
AND (salary, job_id) IN ( SELECT MIN(salary), job_id
                   FROM employees   
                   GROUP BY job_id)
ORDER BY e.job_id  DESC;                  

-- 문제10) EMPLOYEES 테이블에서 50번 부서의 최소 급여를 받는 사원 보다 많은 급여를 받는 사원의 정보를
-- 사원번호,이름,업무,입사일자,급여,부서번호를 출력하라. 단 50번은 제외

SELECT employee_id, last_name, job_id, hire_date, salary, department_id
FROM employees
WHERE (salary) > (SELECT MIN(salary)
                     FROM employees
                     WHERE department_id = 50)
AND department_id <> 50
ORDER BY salary desc;

-- 문제11) EMPLOYEES 테이블에서 50번 부서의 최고 급여를 받는 사원 보다 
--많은 급여를 받는 사원의 정보를 사원번호,이름,업무,입사일자,급여,부서번호를
--출력하라. 단50번은 제외

SELECT employee_id, last_name, job_id, hire_date, salary, department_id
FROM employees
WHERE (salary) > (SELECT MAX(salary)
                     FROM employees
                     WHERE department_id = 50)
AND department_id <> 50
ORDER BY salary ;













