-- 대문자로 바꾸는 함수 UPPER( 문자열 )
-- 소문자로 바꾸는 함수 LOWER( 문자열 )


-- 문자열을 합하는 기능 ||, CONCAT
SELECT first_name || ' ' || last_name
FROM employees;

-- CONCAT
SELECT CONCAT(FIRST_NAME, LAST_NAME)
FROM employees;

-- MONTHS_BETWEEN : 두 날짜간의 월수(월 간격)
SELECT MONTHS_BETWEEN(SYSDATE, '2019-11-13')
FROM DUAL;

-- ADD_MONTHS : 특정 날짜의 월에 정수의 더한 다음 해당 날짜를 반환한다.
SELECT ADD_MONTHS('2019-06-23', 2)
FROM DUAL;

-- EXTRACT() : 날짜 정보에서 특정한 연도, 월, 일, 시, 분, 초를  추출
SELECT EXTRACT(YEAR FROM SYSDATE), -- 추출할 컬럼 FROM 추출할 대상
    EXTRACT(MONTH FROM SYSDATE),
    EXTRACT(DAY FROM SYSDATE)
FROM DUAL;
-- 년 월 일을 추출할때에는 SYSDATE 로 가능하지만 ( SYSDATE 는 날짜를 구해준다 )
-- 시 분 초를 추출할때에는 SYSTIMESTAMP 로 추출해야한다. ( SYSTIMESTAMP 시 분 초를 구해준다)
-- 시분초
SELECT EXTRACT(HOUR FROM CAST(SYSDATE AS TIMESTAMP)) AS 시,
    EXTRACT(MINUTE FROM CAST(SYSDATE AS TIMESTAMP)) AS 분,
    EXTRACT(SECOND FROM CAST(SYSDATE AS TIMESTAMP)) AS 초
FROM DUAL;

-- 중복행을 제거 DISTINCT
SELECT DISTINCT department_id
FROM employees
ORDER BY department_id ASC;
-- 그룹으로 묶는 기능
-- JOB_ID(업무), DEPARTMENT_ID(부서)
-- GROUP BY절    주의할점 그룹으로 묶어버렸을 경우 그룹으로 묶은 컬럼만 실행을(출력)이 가능하다.
SELECT department_id
FROM employees
GROUP BY department_id
ORDER BY department_id ASC;

/*

GROUP 함수
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
NVL(대상이 되는 컬럼, 값) 문자형이만 문자형 값, 숫자형이면 숫자형 값
NVL(대상이 되는 컬럼이 NULL 일경우, 값을 내보내고 NULL이 아닐경우 그냥 그대로 한다.

NVL(대상이 되는 컬럼, 값1, 0)
대상이 되는 컬럼이 !- NULL --> 값1
대사이 되는 컬럼이 NULL 이면 -> 값0
*/

SELECT first_name, NVL(commission_pct, 0)
FROM employees;

SELECT first_name, NVL2(commission_pct, '있음', '없음')
FROM employees;

SELECT department_id, SUM(salary), MAX(salary), MIN(salary)
FROM employees
GROUP BY department_id
ORDER BY department_id ASC;

SELECT department_id, JOB_ID
FROM employees
GROUP BY department_id, job_id;

-- GROUP BY
-- 조건절 HAVING 

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







