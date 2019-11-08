/*
    호출해서 실행한다 exec 이름();
    -- procedure    애는 리턴값이 없어도됨 사용하는거(insert, delete, update)
    -- function     애는 리턴값이 반드시 있어야함 (절대, 기필코, 무조건) 사용하는거(select)
    
    -- trigger  -   촉발시키다. 스스로 발생(약간 function 의 일종이지만 function은 실행을 시켜야하지만 애는 자동으로 실행함)
    insert : 새로 넣는거라 old 값이 없음(예전값(그전값))             했을때 실행을 해라 이런식으로... ?!?! 
    delete : 삭제하는거라 NEW 값이 없음(새로 생긴값)
    update  : 둘다 있는건 update만 있다. 

    사원번호 1001이 사장데이터라면 누가 변경하려고 하면 변경 못하게 막을때 트리거를 사용하여
    너 변경 하지마! 형식으로 자동으로 실행되면서 막을수 있게 하는 그런용도로 사용된다.
*/
    

SET serveroutput on

CREATE OR REPLACE TRIGGER triger_test   -- 애는 매개변수 없음! why(밖에서 호출하는게 아니라 바로 실행되기 때문에)
   -- BEFORE AFTER 2개의 명령어로 뭐뭐하기전에 싱행되게 혹은 하고나서 실행되게 설정을 한다.
    BEFORE
        UPDATE ON departments       -- departments table을 업데이트 하기전에! 실행되게끔
        FOR EACH row                -- 돌아가기 전에 모든 ROW(행) 에 적용해라
BEGIN
    DBMS_OUTPUT.PUT_LINE('변경전 컬럼의 값' || :OLD.department_name);     -- 문자 그대로 변경전
    DBMS_OUTPUT.PUT_LINE('변경후 컬럼의 값' || :NEW.department_name);     -- 변경후
END;
/


update departments
set department_name = '개발'
WHERE department_id = 60;

rollback;

CREATE OR REPLACE TRIGGER sum_trigger
    BEFORE
        INSERT OR UPDATE ON employees
        FOR EACH ROW
DECLARE
    avg_sal NUMBER;
BEGIN
    SELECT round( avg(salary), 3) INTO avg_sal
    FROM empolyees;   
    
    INSERT INTO employees(employee_id, last_name, hire_date, department_id, job_id, salary, email)
    VALUES(500, 'tiger', sysdate, 60, 'IT_PROG', 10000, 'tigert@naver.com');
    
    DBMS_OUTPUT.PUT_LINE('급여 평균:' || avg_sal);

END;
/

SELECT round(avg(salary), 3)
FROM employees;


-- 사번을 수정하지 못하게 할 경우
-- 삭제 할수 없게 할 경우
-- 입력 할수 없게 할 경우  영구결번 or 예
CREATE OR REPLACE TRIGGER emp_tigger
    BEFORE
        UPDATE OR DELETE OR INSERT ON employees
        FOR EACH ROW
BEGIN
    IF UPDATING THEN
        IF :OLD.employee_id = '100' THEN
            RAISE_APPLICATION_ERROR(-20001, '이 사원번호는 수정할수 없습니다.');
        END IF;
    END IF; 
END;
/

UPDATE employees
SET salary = 2500
WHERE employee_id = 100;

SET SERVEROUTPUT ON

-- 문제1) 이름을 입력받아 그 사원의 정보 중 부서명과 급여를 검색하는 프로시저를 생성하여라.
    CREATE OR REPLACE PROCEDURE s_dnsal(ename IN emp.name%TYPE) -- v_dname OUT dept.dname%TYPE, v_sal OUT emp.sal%TYPE
IS
    v_emp emp%ROWTYPE;
    v_dept dept%ROWTYPE;
BEGIN
   
   SELECT d.dname, e.sal into v_dept.dname, v_emp.sal
   FROM emp e, dept d
   WHERE e.name = UPPER(ename) AND e.deptno = d.deptno;
    
    DBMS_OUTPUT.PUT_LINE('부서명' || v_dept.dname);
    DBMS_OUTPUT.PUT_LINE('급여' || v_emp.sal);
    
EXCEPTION
    WHEN NO_DATA_FOUND THEN
         dbms_output.put_line('입력한 사원은 존재하지 않습니다.');
    WHEN TOO_MANY_ROWS THEN
         DBMS_OUTPUT.PUT_LINE('자료가 2건 이상입니다.');
    WHEN OTHERS THEN
         DBMS_OUTPUT.PUT_LINE('기타 에러입니다.');     -- 기타 에러일경우 update or insert or delete 같은경우 기타에러에 roll back도 붙여두자
         
END;
/
    
ACCEPT ename PROMPT '사원이름 입력'
EXEC s_dnsal('&ename');


-- 문제2) EMP 테이블에서 이름으로 부서 번호를 검색하는 함수를 작성하여라.
CREATE OR REPLACE PROCEDURE ev_name(ename IN emp.name%TYPE)
IS
    v_emp emp.deptno%TYPE;
BEGIN
    SELECT deptno into v_emp
    FROM emp
    WHERE name = UPPER(ename);
         dbms_output.put_line(v_emp);  
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('해당사원이없습니다.');
END;
/

CREATE OR REPLACE FUNCTION ename_deptno(v_ename IN emp.name%TYPE)
    RETURN number
IS    
    v_deptno emp.deptno%type;
BEGIN
    SELECT deptno into v_deptno
    FROM emp
    where name = UPPER(v_ename);
    
    return v_deptno;
    
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('사원을 찾을수 없습니다.');
    WHEN TOO_MANY_ROWS THEN
        DBMS_OUTPUT.PUT_LINE('자료가 2개 이상입니다.');
END;
/

VAR g_dn NUMBER;
EXEC :g_dn := ename_DEPTNO('WARD');
PRINT g_dn;

ACCEPT n_ame PROMPT '이름입력'
EXEC ev_name('&n_ame');
-- 문제3) EMP 테이블에서 이름을 입력 받아 부서번호,부서명,급여를 검색하는 FUNCTION을 작성하여라. 단 부서번호를 RETURN에 사용하여라.

CREATE OR REPLACE FUNCTION f_ename(f_name IN emp.name%TYPE)
    RETURN NUMBER
IS    
    v_emp emp%ROWTYPE;
    v_dept dept%ROWTYPE;
BEGIN
    SELECT d.deptno, d.dname, e.sal INTO v_dept.deptno, v_dept.dname, v_emp.sal 
    FROM emp e, dept d
    WHERE e.name = f_name AND e.deptno = d.deptno;
    DBMS_OUTPUT.PUT_LINE(v_dept.deptno);
    DBMS_OUTPUT.PUT_LINE(v_dept.dname);
    DBMS_OUTPUT.PUT_LINE(v_emp.sal);
    
    return v_dept.deptno;
    
    EXCEPTION
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('해당사원이없습니다.');
END;
/

ACCEPT emp_no PROMPT '사원번호입력'
SELECT f_ename(&emp_no)
FROM dual;

--) 두 숫자를 제공하면 덧셈을 해서 결과값을 반환하는 함수를 정의하시오.(함수명 add_num)

CREATE OR REPLACE FUNCTION add_num(f_num IN NUMBER, s_num IN NUMBER)
    RETURN NUMBER
IS
    alu NUMBER;
BEGIN
    alu := f_num + s_num;
    
    return alu;
END;
/
ACCEPT fnum PROMPT '숫자'
ACCEPT snum PROMPT '숫자'
SELECT add_num(&fnum, &snum)
from dual;

CREATE OR REPLACE FUNCTION add_sum(num1 INTEGER, num2 INTEGER)
    RETURN INTEGER

IS
BEGIN
    RETURN  (num1 + num2);
END;

SELECT add_sum(10,2)
FROM dual;

SELECT add_sum(salary, salary * nvl(commission_pct, 0)) as "급여"
FROM employees;

--2) 급여(보너스 포함)에 대한 세율을 다음과 같이 정의하는 함수를 작성하시오.
--급여가 월 $3,000보다 적으면 세율을 0% 적용하며, $3,000이상 $7,000 미만이면 10%, 
--$7,000이상 $10,000 미만이면 20%, $10,000을 이상이면 30%를 적용함
CREATE OR REPLACE PROCEDURE p_second(p_salp OUT VARCHAR2)
iS
    p_sal emp.sal%type;
    p_salp VARCHAR2(10);
BEGIN
    SELECT sal into p_sal
    FROM emp;
    IF p_sal < 3000 THEN
        p_salp := '0%';
    elsif p_sal > 3000 AND p_sal < 7000 THEN
        p_salp := '10%';
    elsif p_sal > 7000 AND p_sal < 10000 THEN
        p_salp := '20%';  
    elsif  p_sal < 10000 THEN
        p_salp := '30%';    
        
    end if;
END;
/
VAR p_val VARCHAR2(10) ;

EXECUTE p_second(:p_val);


CREATE OR REPLACE FUNCTION sal_tax(p_sal employees.salary%TYPE,
                                p_bonus IN employees.commission_pct%TYPE)
     RETURN NUMBER                           
IS
    i_sum NUMBER;
    i_tax NUMBER;
BEGIN
    i_sum := p_sal + (p_sal * nvl(p_bonus, 0));
    
    IF i_sum < 3000 THEN
        i_tax := 0;
    elsif i_sum < 7000 THEN
        i_tax := i_sum * 0.1;
    elsif i_sum < 10000 THEN
        i_tax := i_sum * 0.2;    
    else
        i_tax := i_sum * 0.3;
    end if;
    
    return i_tax;
    
END;
/

SELECT salary, nvl(commission_pct, 0),
    salary + nvl(commission_pct, 0) 실급여,
    sal_tax(salary, commission_pct) 세금
FROM employees;

--3) 부서번호를 입력하면 해당 부서에서 근무하는 사원 수를 반환하는 함수를 정의하시오.
 --  (함수명 get_emp_count)
CREATE OR REPLACE FUNCTION get_emp_count(v_deptno IN number)
    return number
IS
    v_count number;
BEGIN
    SELECT  count(deptno) into v_count
    FROM emp
    GROUP BY deptno
    having deptno = v_deptno;

    return v_count;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('해당사원이없습니다.');
END;
/

ACCEPT dpno PROMPT '부서번호'

SELECT get_emp_count(&dpno)
from dual;



--4) employees테이블을 이용해서 입사일을 제공하면 근무연차를 구하는 함수를 정의하시오.(소수점 
--   자리 절삭, 함수명 get_info_hiredate)
CREATE OR REPLACE FUNCTION get_info_hiredate(vire_date IN employees.employee_id%TYPE) return number
IS
   v_hire_date employees.hire_date%TYPE;
   v_vire_date number;
BEGIN
    SELECT hire_date into v_hire_date
    FROM employees
    WHERE employee_id = vire_date;
    
    v_vire_date := sysdate - v_hire_date;
    v_vire_date := v_vire_date /365;
    return trunc(v_vire_date);
END;
/

ACCEPT h_d PROMPT '사원번호'

SELECT get_info_hiredate(&h_d)
from dual;

SELECT sysdate - (sysdate+31)
FROM dual;


CREATE OR REPLACE FUNCTION get_info_hiredate(hiredate date)
    return integer
is
begin
    return trunc(months_between(sysdate, hiredate) / 12);
end;
/

SELECT first_name, get_info_hiredate(hire_date) 연차
FROM employees;


--5) employees테이블을 이용해서 사원번호를 입력하면 해당 사원의 관리자 이름을 구하는 함수를
--   정의하시오.(함수명 get_mgr_name)
CREATE OR REPLACE FUNCTION get_mgr_name(v_eno IN employees.employee_id%TYPE) return employees.first_name%TYPE
IS
   v_vname employees.first_name%TYPE;
BEGIN
   SELECT b.first_name into v_vname
   FROM employees a, employees b
   where a.employee_id = v_eno
   AND a.manager_id = b.employee_id;
   
   return v_vname;
END;
/

ACCEPT emplno PROMPT '사원번호입력'
SELECT get_mgr_name(&emplno)
FROM dual;

-- 6) emp테이블(SCOTT)을 이용해서 사원번호를 입력하면 급여 등급을 구하는 함수를 정의하시오.
-- (4000~5000 A, 3000~4000미만 B, 2000~3000미만 C, 1000~200미만 D, 1000미만 F, 함수명 get_sal_grade)

CREATE OR REPLACE FUNCTION get_sal_grade(v_grade IN emp.empno%TYPE) return VARCHAR2
IS
   v_sal emp.sal%TYPE;
   v_gr varchar2(20);
BEGIN
   SELECT sal into v_sal
   FROM emp
   where v_grade = empno;
   IF v_sal < 1000 then
    v_gr := 'f';
   elsif v_sal >= 1000 AND v_sal < 2000 then
    v_gr := 'd';
    elsif v_sal >= 2000 AND v_sal < 3000 then
    v_gr := 'c';
    elsif v_sal >= 3000 AND v_sal < 4000 then
    v_gr := 'b';
    elsif v_sal >= 4000 AND v_sal < 5000 then
    v_gr := 'a';
   end if;
   return v_gr;
END;
/

ACCEPT eno PROMPT '사원번호를 입력해주세요'
SELECT get_sal_grade('&eno')
FROM dual;

CREATE OR REPLACE FUNCTION get_sal_grade(emp_no emp.empno%TYPE)
    RETURN VARCHAR2
is
    sgrade varchar2(2);
BEGIN
    SELECT
        CASE WHEN   sal >= 4000 AND sal <= 5000 THEN 'A'
             WHEN   sal >= 3000 AND sal < 4000 THEN 'B'
             WHEN   sal >= 2000 AND sal < 3000 THEN 'C'
             WHEN   sal >= 1000 AND sal < 2000 THEN 'D'
             ELSE 'E'
        END grade into sgrade     
    FROM emp
    where empno = emp_no;
    
    return sgrade;
END;
/

SELECT ename, sal, get_sal_grade(empno) 급여등급
FROM emp
order by sal;


INSERT INTO employees(employee_id, last_name, email, hire_date, job_id)
values(400, 'inwoo', 'aa', sysdate, 'IT_PROG');

COMMIT;

