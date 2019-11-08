-- WHERE == IF문 

/*
    표현식
    비교연산자( =, >, <, !=, >=, <=, <>) != = <>
    NULL, =NULL(이렇게 쓰는거아님)NULL 사용방법 1.IS NULL(눌이냐?), 2.IS NOT NULL(같지않다)
    (), NOT, AND, OR,
    
    
    사용순서
    SELECT  
    FROM    
    WHERE  조건절 
    
*/

-- FIRST_NAME = JULIA

SELECT FIRST_NAME, LAST_NAME, SALARY -- 이걸 출력해라
FROM EMPLOYEES -- 여기에서
WHERE FIRST_NAME = 'Julia'; -- 이거라면

SELECT FIRST_NAME, LAST_NAME, salary
FROM EMPLOYEES
WHERE SALARY >= 9000;

-- 이름이 Shanta보다 큰 이름
SELECT first_name, last_name, salary
FROM EMPLOYEES
WHERE first_name >= 'Shanta';

SELECT first_name, last_name, manager_id
FROM employees
WHERE manager_id = ''; -- !NULL '' 는 NULL 이 아니다!

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

-- 이름 John, 급여 <= 5000

SELECT first_name, last_name, salary
FROM employees
WHERE first_name = 'John'
AND salary > 5000;


-- 2007년 12월 31일 이후에 입사한 사원을 출력해라.

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

-- IN, NOT IN  OR, !OR 느낌??
SELECT first_name, salary
FROM employees
WHERE salary IN(8000, 3200, 600);  -- 월급이 이거인 사람들을 출력한다.


SELECT first_name, salary
FROM employees
WHERE salary NOT IN(8000, 3200, 600); -- 월급이 이거 가 아님 사람들을 출력한다.

SELECT first_name, last_name, salary
FROM employees
WHERE first_name NOT IN('Julia', 'John');

                -- OR 이랑은 약간 다르다
                
SELECT first_name, last_name, salary
FROM employees
WHERE first_name IN('Julia', 'John');

-- EXISTS
SELECT e.first_name, e.job_id
FROM employees e
WHERE EXISTS ( SELECT 1         -- E로 매개체로 해서 E.JOB ID가 ITPROG 면 1로 출력을 하고 만약 1이 출력이되면 셀렉트 부분을 뽑아서 출력해라 이뜻이다.
                FROM DUAL       -- 이게 서브 쿼리
                WHERE e.job_id = 'IT_PROG');


-- BETWEEN 범위 연산자
/*
    SALARY >= 3200 AND SALARY <= 9000
    BETWEEN 사용시 AND 만 입력할 수 있다.
*/

SELECT first_name, salary
FROM employees
WHERE SALARY >= 3200 AND SALARY <= 9000;


SELECT first_name, salary
FROM employees
WHERE SALARY BETWEEN 3200 AND 9000;


SELECT first_name, salary
FROM employees
WHERE SALARY NOT BETWEEN 3200 AND 9000; -- 3200~9000 이 아닌애들 표현할때 NOT BETWEEN

-- LIKE
SELECT first_name, last_name
FROM employees
WHERE first_name LIKE 'G_ra_d'; -- _(언더바)는 한문자 G*ra*d 라는 사람을 출력해라 *는 저 글자는 달라도 된다는뜻


SELECT first_name, last_name
FROM employees
WHERE first_name LIKE 'K%y'; -- 첫글자가 K 이고 마지막 글자가 y일경우

SELECT first_name
FROM employees
WHERE first_name LIKE '%A%'; -- 위치 상관없이 이름에 A가 있으면 출력한다

SELECT first_name
FROM employees
WHERE first_name LIKE '%Al%'; -- 이름이 Al인 포함되어있으면 


-- 2006년도에 입사한 사원
SELECT first_name, hire_date
FROM employees
WHERE hire_date LIKE '06/01%'; -- 06년 1월에 입사한사람들 LIKE 로 입사일을 구할때에는 날짜 형식을 맞춰주어야 한다.



































