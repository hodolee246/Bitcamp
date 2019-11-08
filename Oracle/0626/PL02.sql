/*
    block되어 있는 처리 -> 함수화
    PROCEDURE 처리    - INSERT, DELETE, UPDATE, SELECT(펑션에서 사용 주로 사용해서 사용빈도가 낮음(거의 없음)
                        1. IN, OUT(return value)
    FUNCTION 처리     - 사용불가능(INSERT, DELETE, UPDATE) SELECT(주로 사용함)
         FUNCTION 기본요소  1. 매개변수
                           2. RETURN VALUE
                        
*/

-- PROCEDURE
SET SERVEROUTPUT ON

CREATE OR REPLACE PROCEDURE pl_func(inNumber IN NUMBER, outNumber OUT NUMBER)
IS      
    -- 선언부
    
    
BEGIN   
    -- 실행부
    DBMS_OUTPUT.PUT_LINE('inNumber:' || inNumber);
    
    outNumber := 112233;
    
    -- 예외처리부
END;
/

-- 외부 변수 선언
VAR val NUMBER ;

-- 프로시저 호출
EXECUTE pl_func(123, :val);             -- 하나더 알고가기 EXECUTE = 실행 흔히 쓰는 exe 가 execute 약자이다.

-- 변수 출력
-- 1. dual 에 출력
-- 2. print 로 출력

PRINT val;

-- 매개변수 없는 경우
CREATE OR REPLACE PROCEDURE Hell_procedure  -- 매개변수를 넣지 않는경우 괄호는 하지 말자!
IS
    msg VARCHAR2(100);
BEGIN
    msg := 'Hell PROCEDURE';
    DBMS_OUTPUT.PUT_LINE(msg);
END;
/



EXEC Hell_procedure;


-- DEPARTMENTS 테이블에다가 ROW를 추가를 해보자!
CREATE OR REPLACE PROCEDURE add_deptCol(p_deptno IN departments.department_id%TYPE,
                                        p_deptname IN departments.department_name%TYPE,
                                        p_loc IN departments.location_id%TYPE)
IS
    -- 변수는 없으니 선언부는 생략~
BEGIN
    INSERT into departments(department_id, department_name, location_id)
    VALUES(p_deptno, p_deptname, p_loc);
    
EXCEPTION WHEN OTHERS THEN
    DBMS_OUTPUT.PUT_LINE('추가에 실패했습니다');
    --ROLLBACK;
END;
/

EXEC add_deptCol(300, '전인우 엔터테이먼트', 1500);

SELECT
    *
FROM departments;

-- update_sal 프로시저는 사원번호를 입력받아서 급여인상 30%

CREATE OR REPLACE PROCEDURE update_sal(emno IN NUMBER)
IS

BEGIN
    UPDATE employees
    SET salary = salary * 1.3
    WHERE employee_id = emno;
EXCEPTION    
WHEN NO_DATA_FOUND THEN
        dbms_output.put_line(emno || ' 사원은 존재하지 않습니다.');    
END;
/

ACCEPT empno PROMPT '사원번호 입력:'
EXEC update_sal(&empno);

-- 사원번호를 입력 받으면 그 사원의 이름, 사원번호, 사원급여도 출력 되도록 하라.

CREATE OR REPLACE PROCEDURE insert_emno(emno IN employees.employee_id%TYPE)
IS
    v_emp employees%ROWTYPE;
BEGIN
    SELECT first_name, employee_id, salary into v_emp.first_name, v_emp.employee_id, v_emp.salary
    FROM employees
    WHERE employee_id = emno;
    
    DBMS_OUTPUT.PUT_LINE(emno || ' 사원 이름:' || v_emp.first_name || ' 사원 번호:' || v_emp.employee_id || ' 사원 급여:' || v_emp.salary);
    
EXCEPTION
    WHEN NO_DATA_FOUND THEN
         dbms_output.put_line(emno || ' 사원은 존재하지 않습니다.');    
END;
/
ACCEPT empno PROMPT '사원번호 입력:'
EXEC insert_emno(&empno);



rollback;


/*
    Cursor : 저장 주소공간 -> pointer 
    커서 타입
    암시적 커서 : 제공을 해주는 커서(?) 자동생성이 된다. 누군가가 만들은거다.
        SQL%ROWCOUNT : ROW의 수
        SQL%FOUND : ROW수가 한개 이상일 경우
        SQL%NOTFOUND : ROW수가 0개 이다.
    명시적 커서 : 수동생성 해야 한다.
*/

-- 암시적 커서

CREATE OR REPLACE PROCEDURE implicit_cursor(p_empno IN employees.employee_id%TYPE)
IS
    v_sal employees.salary%TYPE;
    v_update_row NUMBER;        -- 몇개의 행이 수정되는 조사하는 저장 변수
BEGIN
    -- 검색
    SELECT salary INTO v_sal
    FROM employees
    WHERE employee_id = p_empno;
    
    -- 검색이 된 데이터가 있는 경우
    IF SQL%FOUND THEN
        DBMS_OUTPUT.PUT_LINE('검색된 데이터:' || v_sal);
    END IF;
    
    -- 수정
    UPDATE employees
    SET salary = salary * 1.1
    WHERE employee_id = p_empno;
    
    -- 출력
    v_update_row := SQL%ROWCOUNT;
    DBMS_OUTPUT.PUT_LINE('급여가 인상된 사원수:' || v_update_row);
    
-- 예외
EXCEPTION
WHEN NO_DATA_FOUND THEN
    dbms_output.put_line('검색된 데이터가 없습니다.');  
END;
/

EXEC implicit_cursor(101);

EXEC implicit_cursor(333);

ROLLBACK;

-- 명시적 커서
CREATE OR REPLACE PROCEDURE expCursor_test(v_deptno IN departments.department_id%TYPE)
IS
    CURSOR dept_avg     -- 3개의 데이터를 뽑을수 있는 커서를 만듬
    IS
    SELECT  d.department_name, count(e.employee_id) CNT,
        ROUND(AVG(e.salary), 3)sal
    FROM employees e, departments d
    WHERE e.department_id = d.department_id
        AND e.department_id = v_deptno
    GROUP BY d.department_name;
    
    -- CURSOR에 FETCH하기 위한 변수들을 선언
    v_dname departments.department_name%TYPE;
    emp_cnt NUMBER;
    sal_avg NUMBER;
    
BEGIN
    --CURSOR OPEN
    OPEN dept_avg;
    
    -- CURSOR FETCH
    FETCH dept_avg into v_dname, emp_cnt, sal_avg;
    
    DBMS_OUTPUT.PUT_LINE('부서명:' || v_dname);
    DBMS_OUTPUT.PUT_LINE('사원수:' || emp_cnt);
    DBMS_OUTPUT.PUT_LINE('평균급여:' || sal_avg);
    
    -- CURSOR를 열었으면 닫아줘야한다. 
    CLOSE dept_avg;
    
END;
/

EXEC expCursor_test(50);















