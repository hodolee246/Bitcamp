-- Function return value *(프로시져는 매게변수로 return value로 받는다)
-- 입력받은 값으로 부터 10%의 세율을취득하는 함수

CREATE OR REPLACE FUNCTION tax_value(p_val IN NUMBER)
    RETURN NUMBER   -- 리턴 자료형 설정해줘야 한다.

IS

BEGIN
    RETURN (p_val * 0.1);
END;
/   


SELECT tax_value(100)
FROM dual;

VAR t_val NUMBER;
EXECUT :t_val := tax_value(100);
print t_val;


-- 사원 번호를 입력하면, 사원의 급여를 리턴하는 FUNCTION 을 만들어보자!

CREATE OR REPLACE FUNCTION empno_sal(p_empno IN NUMBER)
    RETURN NUMBER
IS
    v_sal employees.salary%TYPE;
BEGIN
    SELECT salary into v_sal
    FROM employees
    WHERE employee_id = p_empno;
    
    RETURN v_sal;       -- 반드시 리턴문이 존재해야한다 (반드시)(무조건)(절대)
END;
/
SELECT empno_sal(102)
FROM dual;
















