
/*
    sequence : 유일한 값을 생성해 주는 Oracle Object다
    회원번호, 게시판의 글 번호
    sequence를 생성하면, Primary key 와 같이 순차적으로 증가하는
    column을 자동적으로 생성할 수 있다
    sequence 는 초기화가 불가능 하다. ( 누적되는 숫자라고 생각하자 )
    1
    2 
    3
*/

CREATE SEQUENCE TEST_SEQ
INCREMENT BY 1      -- 1씩 증가(++)
START WITH 10       -- 시작되는 값
MAXVALUE 120        -- 최대로 증가하는 값 생략이 가능하다. 생략시 값 설정은 최대로 된다.
MINVALUE 1;         -- 최대값의 반대

-- CURRVAL == 현재 시퀀스의 값
-- 맨처음 실행시 오류가 난다 한번도 진행된 적이 없기에 현재값이 없으므로 오류가 난다 그러므로 넥스트를 한번이상 시켜야지 작동이 된다.
SELECT TEST_SEQ.CURRVAL
FROM DUAL;

-- NEXTVAL == 진행 값

SELECT TEST_SEQ.nextval
FROM DUAL;

-- SEQUENCE 수정
ALTER SEQUENCE TEST_SEQ
INCREMENT BY 3;

-- SEQUENCE 초기화가 불가능하다. (삭제하고 다시 만들어야 한다.)
DROP SEQUENCE TEST_SEQ;


-- INSERT INTO EMPLOYEES(EMPLOYEES_SEQ.NEXTVAL,

-- 동의어(SYNONYM / 객체의 별명)

/*
 1.   INT array_postion_number[];
 2.   int arrPosnum[] = array_opstion_number;
 3.   arrPosNum[0] = 1;
*/

CREATE SYNONYM "사원들"
FOR EMPLOYEES;      -- EMPLOYEES 테이블을 자기가 원하는 이름대로 바꿔서 데이터를 넣는거다.

SELECT
    *
FROM "사원들";

INSERT INTO "사원들"
VALUES(EMPLOYEES_SEQ.NEXTVAL, '인우', '전', 'GOHOME', '123-4567', TO_DATE('2019/11/13', 'YYYY/MM/DD'),
'IT_PROG', 20000, NULL, 100, 10);

SELECT
    *
FROM EMPLOYEES







































































