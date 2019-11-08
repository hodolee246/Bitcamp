/*
    block�Ǿ� �ִ� ó�� -> �Լ�ȭ
    PROCEDURE ó��    - INSERT, DELETE, UPDATE, SELECT(��ǿ��� ��� �ַ� ����ؼ� ���󵵰� ����(���� ����)
                        1. IN, OUT(return value)
    FUNCTION ó��     - ���Ұ���(INSERT, DELETE, UPDATE) SELECT(�ַ� �����)
         FUNCTION �⺻���  1. �Ű�����
                           2. RETURN VALUE
                        
*/

-- PROCEDURE
SET SERVEROUTPUT ON

CREATE OR REPLACE PROCEDURE pl_func(inNumber IN NUMBER, outNumber OUT NUMBER)
IS      
    -- �����
    
    
BEGIN   
    -- �����
    DBMS_OUTPUT.PUT_LINE('inNumber:' || inNumber);
    
    outNumber := 112233;
    
    -- ����ó����
END;
/

-- �ܺ� ���� ����
VAR val NUMBER ;

-- ���ν��� ȣ��
EXECUTE pl_func(123, :val);             -- �ϳ��� �˰��� EXECUTE = ���� ���� ���� exe �� execute �����̴�.

-- ���� ���
-- 1. dual �� ���
-- 2. print �� ���

PRINT val;

-- �Ű����� ���� ���
CREATE OR REPLACE PROCEDURE Hell_procedure  -- �Ű������� ���� �ʴ°�� ��ȣ�� ���� ����!
IS
    msg VARCHAR2(100);
BEGIN
    msg := 'Hell PROCEDURE';
    DBMS_OUTPUT.PUT_LINE(msg);
END;
/



EXEC Hell_procedure;


-- DEPARTMENTS ���̺��ٰ� ROW�� �߰��� �غ���!
CREATE OR REPLACE PROCEDURE add_deptCol(p_deptno IN departments.department_id%TYPE,
                                        p_deptname IN departments.department_name%TYPE,
                                        p_loc IN departments.location_id%TYPE)
IS
    -- ������ ������ ����δ� ����~
BEGIN
    INSERT into departments(department_id, department_name, location_id)
    VALUES(p_deptno, p_deptname, p_loc);
    
EXCEPTION WHEN OTHERS THEN
    DBMS_OUTPUT.PUT_LINE('�߰��� �����߽��ϴ�');
    --ROLLBACK;
END;
/

EXEC add_deptCol(300, '���ο� �������̸�Ʈ', 1500);

SELECT
    *
FROM departments;

-- update_sal ���ν����� �����ȣ�� �Է¹޾Ƽ� �޿��λ� 30%

CREATE OR REPLACE PROCEDURE update_sal(emno IN NUMBER)
IS

BEGIN
    UPDATE employees
    SET salary = salary * 1.3
    WHERE employee_id = emno;
EXCEPTION    
WHEN NO_DATA_FOUND THEN
        dbms_output.put_line(emno || ' ����� �������� �ʽ��ϴ�.');    
END;
/

ACCEPT empno PROMPT '�����ȣ �Է�:'
EXEC update_sal(&empno);

-- �����ȣ�� �Է� ������ �� ����� �̸�, �����ȣ, ����޿��� ��� �ǵ��� �϶�.

CREATE OR REPLACE PROCEDURE insert_emno(emno IN employees.employee_id%TYPE)
IS
    v_emp employees%ROWTYPE;
BEGIN
    SELECT first_name, employee_id, salary into v_emp.first_name, v_emp.employee_id, v_emp.salary
    FROM employees
    WHERE employee_id = emno;
    
    DBMS_OUTPUT.PUT_LINE(emno || ' ��� �̸�:' || v_emp.first_name || ' ��� ��ȣ:' || v_emp.employee_id || ' ��� �޿�:' || v_emp.salary);
    
EXCEPTION
    WHEN NO_DATA_FOUND THEN
         dbms_output.put_line(emno || ' ����� �������� �ʽ��ϴ�.');    
END;
/
ACCEPT empno PROMPT '�����ȣ �Է�:'
EXEC insert_emno(&empno);



rollback;


/*
    Cursor : ���� �ּҰ��� -> pointer 
    Ŀ�� Ÿ��
    �Ͻ��� Ŀ�� : ������ ���ִ� Ŀ��(?) �ڵ������� �ȴ�. �������� �������Ŵ�.
        SQL%ROWCOUNT : ROW�� ��
        SQL%FOUND : ROW���� �Ѱ� �̻��� ���
        SQL%NOTFOUND : ROW���� 0�� �̴�.
    ����� Ŀ�� : �������� �ؾ� �Ѵ�.
*/

-- �Ͻ��� Ŀ��

CREATE OR REPLACE PROCEDURE implicit_cursor(p_empno IN employees.employee_id%TYPE)
IS
    v_sal employees.salary%TYPE;
    v_update_row NUMBER;        -- ��� ���� �����Ǵ� �����ϴ� ���� ����
BEGIN
    -- �˻�
    SELECT salary INTO v_sal
    FROM employees
    WHERE employee_id = p_empno;
    
    -- �˻��� �� �����Ͱ� �ִ� ���
    IF SQL%FOUND THEN
        DBMS_OUTPUT.PUT_LINE('�˻��� ������:' || v_sal);
    END IF;
    
    -- ����
    UPDATE employees
    SET salary = salary * 1.1
    WHERE employee_id = p_empno;
    
    -- ���
    v_update_row := SQL%ROWCOUNT;
    DBMS_OUTPUT.PUT_LINE('�޿��� �λ�� �����:' || v_update_row);
    
-- ����
EXCEPTION
WHEN NO_DATA_FOUND THEN
    dbms_output.put_line('�˻��� �����Ͱ� �����ϴ�.');  
END;
/

EXEC implicit_cursor(101);

EXEC implicit_cursor(333);

ROLLBACK;

-- ����� Ŀ��
CREATE OR REPLACE PROCEDURE expCursor_test(v_deptno IN departments.department_id%TYPE)
IS
    CURSOR dept_avg     -- 3���� �����͸� ������ �ִ� Ŀ���� ����
    IS
    SELECT  d.department_name, count(e.employee_id) CNT,
        ROUND(AVG(e.salary), 3)sal
    FROM employees e, departments d
    WHERE e.department_id = d.department_id
        AND e.department_id = v_deptno
    GROUP BY d.department_name;
    
    -- CURSOR�� FETCH�ϱ� ���� �������� ����
    v_dname departments.department_name%TYPE;
    emp_cnt NUMBER;
    sal_avg NUMBER;
    
BEGIN
    --CURSOR OPEN
    OPEN dept_avg;
    
    -- CURSOR FETCH
    FETCH dept_avg into v_dname, emp_cnt, sal_avg;
    
    DBMS_OUTPUT.PUT_LINE('�μ���:' || v_dname);
    DBMS_OUTPUT.PUT_LINE('�����:' || emp_cnt);
    DBMS_OUTPUT.PUT_LINE('��ձ޿�:' || sal_avg);
    
    -- CURSOR�� �������� �ݾ�����Ѵ�. 
    CLOSE dept_avg;
    
END;
/

EXEC expCursor_test(50);















