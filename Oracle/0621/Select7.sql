-- 특수 Query
-- CASE, DECODE

SELECT employee_id, first_name, phone_number,
    CASE SUBSTR(phone_number, 1, 3)     --CASE 조건(명확한 값)일경우
        WHEN '515' THEN '써울'            --
        WHEN '590' THEN '부산'
        WHEN '659' THEN '광주'
        WHEN '603' THEN '대전'
        ELSE '기타'
    END as "지역입니당."
FROM employees;


/*
SELECT employee_id, first_name, phone_number, 
    CASE
        WHEN SUBSTR(phone_number, 1, 3) = '515' THEN 'Tㅓ울'
        WHEN SUBSTR(phone_number, 1, 3) = '590' THEN '부산'
        WHEN SUBSTR(phone_number, 1, 3) = '659' THEN '광주'
        WHEN SUBSTR(phone_number, 1, 3) = '603' THEN '디ㅓ전'
        ELSE 'Gi타'
    END as "테스트 입니다~~" 
FROM emplyees;
*/
SELECT employee_id, FIRST_name, salary,
    CASE
        WHEN salary BETWEEN 7000 AND 8000 THEN '7'
        WHEN salary BETWEEN 8001 AND 9000 THEN '구'
        WHEN salary BETWEEN 9001 AND 10000 THEN '만!'
        ELSE 'ㅠㅠ'
    END as "월급"    
FROM employees ;

-- DECODE

SELECT employee_id, first_name, phone_number,
    DECODE(SUBSTR(phone_number, 1, 3), 
        '515', 'tj울',
        '590', 'qn산',
        '659', '광wn',
        '603', '대전', '기타') as "wwllgguurr"
FROM employees;


-- OVER(  ) PARTITION BY ORDER BY
-- 월급 랭킹 1위부터 5위까지 출력하시오

-- HOW TO CUT?          -- 파티션 바이는 그룹바이 대신으로 사용한다
                                            -- 그룹으로 묶어라         -- 순번
SELECT job_id, salary, count(*)OVER(PARTITION BY job_id ORDER BY job_id, salary desc)
FROM employees;                             -- 그룹으로 정하고            정렬!

SELECT job_id,  count(*)OVER()  -- 이럴경우 이 테이블을 전부다 카운트한 숫자인 107이 출력된다.
FROM employees;

SELECT job_id,  count(*)OVER(PARTITION BY job_id) -- 이 테이블에 있는 job id  갯수를 세어라
FROM employees;                         

    -- 그룹으로 묶지않고 컬럼을 확인하고 싶을때 사용한다(?)
    -- MAX, MIN, SUM, AVG
    
SELECT department_id,last_name, salary,  MAX(salary)OVER(PARTITION BY department_id)
FROM employees;
    
SELECT department_id,last_name, salary,  SUM(salary)OVER(PARTITION BY department_id)
FROM employees;    
    
-- 많이 사용되는 함수 "분석함수"
-- 순위(RANK)
-- RANK()       1 2 3 3 5 6 7 (랭킹 표시 등수) 공동순위가 있으면 숫자만큼 랭킹을 넘어간다
-- DENSE_RANK() 1 2 3 3 4 5 6 (랭킹 표시 등수) 공동순위가 있어도 그다음 숫자 등수가온다
-- ROW_NUMBER() 1 2 3 4 5 6 7 (랭킹 표시 등수)  공동순위 무시하고 그냥 순서대로 표시한다.
-- ROWNUM       1 2 3 4 5 6 7 (랭킹 표시 등수) 공동순위 무시하고 그냥 순서대로 표시한다.

SELECT salary, first_name,
    RANK()OVER(ORDER BY salary DESC) AS 랭크,
    DENSE_RANK()OVER(ORDER BY salary DESC) AS 덴스랭크,
    ROW_number()OVER(ORDER BY salary DESC) AS 로우넘버
FROM employees
ORDER BY salary DESC;    

-- 10명의 데이터만 산출하는 경우

SELECT rownum, employee_id, first_name, salary            -- 2. (실행순서)
FROM employees
WHERE rownum > 10 AND rownum <= 20;                       -- 1. (실행순서)

-- 1. 설정
-- 2. rownum
-- 3. 범위를 설정
SELECT RNUM, employee_id, first_name, salary
FROM
    (SELECT ROWNUM AS RNUM,                 -- 2.rownum 완성
        employee_id, first_name, salary
    FROM
        (SELECT employee_id, first_name, salary -- 1. data의 설정
        FROM employees)
    )
WHERE RNUM > 10 AND RNUM <= 20;    -- 3. 범위설정



SELECT test, employee_id, last_name, salary
FROM
        (SELECT rownum as test,
             employee_id, salary, last_name
             
        FROM
        
            (SELECT employee_id, salary, last_name
            FROM employees))
WHERE test between 1 AND 5;









































































