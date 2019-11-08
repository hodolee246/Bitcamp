/*
    
    PL/SQL Procedural extension to Structured Query Language
    Query를 함수화로 바꾸는 작업이 PL 이다
    script만 쓰는 형식, Procedure 형식, function 형식, 트리거 형식
    SQL을 확장한 순차적 처리 언어 이다.
    데이터베이스 질의어인 SQL과 일반 프로그래밍 언어의 특성을 결합한 언어이다.
*/


-- PL 기본 구조
/*
    선언부 : 사용할 변수나 상수를 선언
    실행부 : 실제 처리한 logic부분을 감당하는 부분
    예외처리 : 처리중에 발생할 수 있는 각종 오류를 일단 처리할 수 있는겉들을 처리
*/

SET SERVEROUT ON
BEGIN
    -- 실행부
 DBMS_OUTPUT.PUT_LINE('HELLO PL');
END;

DECLARE -- 선언부
    message VARCHAR2(10);
BEGIN   -- 실행부
    message := 'hello pl';
    
    DBMS_OUTPUT.PUT_LINE(MESSAGE);
        -- 예외처리부
END;
/
-- IF 조건문
DECLARE
    COUNTER INTEGER;
BEGIN
    COUNTER := 1;
    COUNTER := COUNTER + 1;
    
    IF COUNTER IS NULL THEN
        DBMS_OUTPUT.PUT_LINE('result:counter is null');
    ELSE
        DBMS_OUTPUT.PUT_LINE('result:counter is NOT null');
    END IF;    
END;
/


-- FOR

DECLARE
    counter integer;
    i integer ;

BEGIN
    FOR I IN 1..9 LOOP
        DBMS_OUTPUT.PUT_LINE('i = ' || i);
        COUNTER := 2 * i;
        dbms_output.put_line('2 * ' || i || ' = ' || counter);
    END LOOP;
END;
/


-- loop

DECLARE
    v_cnt number := 0;
    v_tot number := 0;
BEGIN
    LOOP
        EXIT WHEN v_cnt = 10;       -- v_cnt 가 10 이면 탈출
        
        v_cnt := v_cnt + 1;
        v_tot := v_tot + v_cnt;
        
    END LOOP;
    dbms_output.put_line('v_cnt = ' || v_cnt);
    dbms_output.put_line('v_tot = ' || v_tot);
END;
/

-- while

DECLARE
    v_cnt number := 0;
    v_tot number := 0;
BEGIN
    WHILE v_cnt < 10
    LOOP
        
        v_cnt := v_cnt + 1;
        v_tot := v_tot + v_cnt;
        
    END LOOP;
    dbms_output.put_line('v_cnt = ' || v_cnt);
    dbms_output.put_line('v_tot = ' || v_tot);
END;
/

-- goto

DECLARE
    v_name varchar2(10) := 'JEON';
    v_case number := 1;
BEGIN
    CASE WHEN MOD(v_case, 2) = 0 THEN
             GOTO test1;
         WHEN MOD(v_case, 2) = 1 THEN
             GOTO test2;
         ELSE
             GOTO ERR;
     END CASE;        
<<test1>>
    dbms_output.put_line('v_name = ' || ' is woman');
    GOTO sub_end;
<<test2>>
    dbms_output.put_line('v_name = ' || ' is man');
    GOTO sub_end;
<<ERR>>
    dbms_output.put_line('ERR');
    GOTO sub_end;
<<sub_end>>
    dbms_output.put_line('exit');
END;
/


-- 예외처리부

DECLARE
    counter integer;
BEGIN
    counter := 10;
    counter := counter / 0;
    dbms_output.put_line(counter);
    
EXCEPTION WHEN OTHERS THEN  -- 예외처리부
    dbms_output.put_line('OTHERS error');
    -- 예외처리부는 여러개가 있을수 있다. exception 코드만 안다면...
END;
/

-- varray : variable
   --        변수
DECLARE
    TYPE varray_test IS VARRAY(3) OF INTEGER;   -- int형 배열이다 변수를 선언한게 아니라 타입을 선언한거다.
    varray1 varray_test; -- 이게 변수선언
BEGIN
    varray1 := varray_test(11, 22, 33);
    dbms_output.put_line(varray1(2)); -- 자바랑 다르게 1번지 부터 시작한다 2번지를 출력하면 22가 출력된다.
END;
/

ACCEPT p_deptno PROMPT '부서 번호를 입력하시오(급여의 합):'   -- ACCEPT PROMPT WINDOW

DECLARE
    v_salTotal NUMBER;
BEGIN
    SELECT SUM(salary) INTO v_saltotal
    FROM employees
    WHERE department_id = &p_deptno;
    
    dbms_output.put_line(&p_deptno || '번 부서의 급여의 합은 ' || TO_CHAR(v_saltotal, '$999,999,999'));
END;
/

-- 사원번호 입력 받고 그 사원의 급여에 1000을 더한 값으로 갱신하라.

ACCEPT p_no PROMPT '사원 번호를 입력해주세요 :'

DECLARE
    p_sal employees.salary%TYPE := 1000;
    p_salTotal Number;
BEGIN
    UPDATE employees
    SET salary = salary + p_sal
    WHERE employee_id = &p_no;
    
    SELECT salary into p_salTotal
    FROM employees
    WHERE employee_id = &p_no;
    
     dbms_output.put_line(&p_no || '번 사원의 급여 + 1000 :' || p_salTotal);
end;
/

rollback;

DECLARE
    -- ROWTYPE
    v_emp employees%ROWTYPE;   -- 똑같은 자료형 타입 변수를 사용한다
BEGIN
    SELECT employee_id, first_name, last_name, salary
        INTO v_emp.employee_id, v_emp.first_name, v_emp.last_name, v_emp.salary
    FROM employees
    WHERE employee_id = 100;
    
    
    dbms_output.put_line('사원번호' || v_emp.employee_id);
    dbms_output.put_line('이름' || v_emp.first_name);
    dbms_output.put_line('성' || v_emp.last_name);
    dbms_output.put_line('급여' || v_emp.salary);
END;
/
SET SERVEROUT ON

--문제1) 사원번호가 7369인 사원의 급여에 1500을 더하여 갱신하여라.


DECLARE
    a_sal emp.sal%TYPE := 1500;
    a_salTotal number;
    a_num number := 7369;
begin
    UPDATE emp
    set sal = sal + a_sal
    WHERE emp_no = a_num;
    
    SELECT (sal + a_sal) INTO a_salTotal 
    FROM emp
    WHERE emp_no = a_num;
    

    
    dbms_output.put_line(a_salTotal);
    
end;
/

rollback;
--문제2) 업무를 입력받아 급여의 합을 출력하는 SCRIPT를 작성하여라.
ACCEPT b_job PROMPT '업무입력'
DECLARE
    b_sal number;  -- 출력용 변수 이다.
BEGIN
    SELECT sum(sal) into b_sal
    FROM emp
    where job = UPPER('&b_job');
    
    dbms_output.put_line('급여의 합 : ' || TO_CHAR(b_sal, '$999,999,999'));
END;
/


--문제3) EMP 테이블에 EMPNO_SEQUENCE의 SEQUENCE를 이용하여 이름.급여,부서번호를
--입력받아 등록하는 SCRIPT를 작성하여라. 단 10번부서는 입력된 급여에 20%의 가산하여 등록하고 30번부서는 10% 가산 점이 있다.

CREATE SEQUENCE emp_SEQ
INCREMENT BY 1      -- 1씩 증가(++)
START WITH 7903       -- 시작되는 값       
MINVALUE 1; 

ACCEPT c_name PROMPT '이름입력'
ACCEPT c_sal PROMPT '급여 입력'
ACCEPT c_deptno PROMPT '부서번호입력'

DECLARE
    v_name emp.name%TYPE :=UPPER('&cname');
    v_sal emp.sal%TYPE :=&sal;
    v_deptno emp.deptno%TYPE := &deptno ;
BEGIN
    IF v_deptno = 10 THEN
         v_sal := 1.2;
    ELSIF v_deptno = 30 THEN
            v_sal := 1.1;
    END IF;  
     INSERT into emp(emp_no, name, sal, deptno)
        values(emp_SEQ.nextval, v_name, v_sal, v_deptno);
end;
/

--문제4) EMP 테이블에서 이름을 입력 받아 아래의 형태로 출력하는 SCRIPT를 작성하여라.
--조회하고자 하는 사원의 이름을 입력하시오 : scott

ACCEPT d_name PROMPT '조회하고자 하는 사원의 이름을 입력하시오 :'

DECLARE
    
    d_emp emp%ROWTYPE;
BEGIN
    SELECT * into d_emp.empno, d_emp.name, d_emp.job, d_emp.mgr, d_emp.hiredate, d_emp.sal, d_emp.comm, d_emp.deptno
    FROM emp
    where name = '&d_name';
    
    dbms_output.put_line('사원번호 ' || d_emp.empno);
    dbms_output.put_line('이름 ' || d_emp.name);
    dbms_output.put_line('직업 ' || d_emp.job);
    dbms_output.put_line('상사 ' || d_emp.mgr);
    dbms_output.put_line('입사일 ' || d_emp.hiredate);
    dbms_output.put_line('급여 ' || d_emp.sal);
    dbms_output.put_line('보너스 ' || NVL(d_emp.comm, 0));
    dbms_output.put_line('번호 ' || d_emp.deptno);
    
-- 없을 때 처리
EXCEPTION   -- 입셉션 부분에서 오류 발생(이유는 찾는중)
    WHEN NO_DATA_FOUND THEN
        dbms_output.put_line(&d_name || ' 사원은 존재하지 않습니다.');
    WHEN TOO_MANY_ROWS THEN
        dbms_output.put_line( &d_name  || '사원은 두건 이상입니다.');
    WHEN OTHERS THEN
        dbms_output.put_line( '기타 에러 입니다.');
END;
/


--문제5) 이름을 입력받아 급여와 입사일을 출력하는 SCRIPT를 작성하여라.
ACCEPT f_name PROMPT '이름입력'
DECLARE
    f_emp emp%ROWTYPE;
BEGIN
    SELECT sal, hiredate into f_emp.sal, f_emp.hiredate
    FROM emp
    WHERE name = '&f_name';

    dbms_output.put_line('급여' || f_emp.sal);
    dbms_output.put_line('입사날짜' || f_emp.hiredate);

EXCEPTION   -- 입셉션 부분에서 오류 발생(이유는 찾는중)
    WHEN NO_DATA_FOUND THEN
        dbms_output.put_line(&d_name || ' 사원은 존재하지 않습니다.');
    WHEN TOO_MANY_ROWS THEN
        dbms_output.put_line( &d_name  || '사원은 두건 이상입니다.');
    WHEN OTHERS THEN
        dbms_output.put_line( '기타 에러 입니다.');    
    
END;
/

















































