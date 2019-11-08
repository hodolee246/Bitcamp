/*
    index 검색용 색인
    원하는 정보와 위치를 빠르고 정확하게 알아낼수 있는 방법
    -- 자동생성 : Primary key, Unique 내부에서 만들어줌
    -- 수종생성 : Query
    
    생성해야 좋은 경우
    1.where절이나 join조건안에 자주 사용되는 컬럼 department_id
    2.null값이 많이 포함되어 있는 컬럼           manager_id
    3.where절이나 join조건안에 두개이상으 ㅣ컬럼
    
    생성해서 안좋은 경우
    1. 테이블 크기(row)가 작을때(3000개이하) 만들게 되면 오히려 속도를 저하시킴
    2. 테이블이 자주 갱신될떄
*/

CREATE TABLE EMP_COPY
AS
SELECT * FROM employees;

-- 자동생성 인덱스 자동생성

ALTER TABLE EMP_COPY
ADD
CONSTRAINT PK_EMPCOPY_01 PRIMARY KEY(EMPLOYEE_ID);

-- INDEX 확인
SELECT *
FROM ALL_INDEXES
WHERE INDEX_NAME IN('PK_EMPCOPY_01'); -- 인덱스 명칭이랑 PRIMARY 아이디랑 같다

-- 강제 생성
CREATE INDEX EMP_INDEX01
ON EMP_COPY(MANAGER_ID); -- index 검색을 빨리하기 위한 목적

DROP INDEX EMP_INDEX01;
