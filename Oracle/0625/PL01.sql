/*
    
    PL/SQL Procedural extension to Structured Query Language
    Query�� �Լ�ȭ�� �ٲٴ� �۾��� PL �̴�
    script�� ���� ����, Procedure ����, function ����, Ʈ���� ����
    SQL�� Ȯ���� ������ ó�� ��� �̴�.
    �����ͺ��̽� ���Ǿ��� SQL�� �Ϲ� ���α׷��� ����� Ư���� ������ ����̴�.
*/


-- PL �⺻ ����
/*
    ����� : ����� ������ ����� ����
    ����� : ���� ó���� logic�κ��� �����ϴ� �κ�
    ����ó�� : ó���߿� �߻��� �� �ִ� ���� ������ �ϴ� ó���� �� �ִ°ѵ��� ó��
*/

SET SERVEROUT ON
BEGIN
    -- �����
 DBMS_OUTPUT.PUT_LINE('HELLO PL');
END;

DECLARE -- �����
    message VARCHAR2(10);
BEGIN   -- �����
    message := 'hello pl';
    
    DBMS_OUTPUT.PUT_LINE(MESSAGE);
        -- ����ó����
END;
/
-- IF ���ǹ�
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
        EXIT WHEN v_cnt = 10;       -- v_cnt �� 10 �̸� Ż��
        
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


-- ����ó����

DECLARE
    counter integer;
BEGIN
    counter := 10;
    counter := counter / 0;
    dbms_output.put_line(counter);
    
EXCEPTION WHEN OTHERS THEN  -- ����ó����
    dbms_output.put_line('OTHERS error');
    -- ����ó���δ� �������� ������ �ִ�. exception �ڵ常 �ȴٸ�...
END;
/

-- varray : variable
   --        ����
DECLARE
    TYPE varray_test IS VARRAY(3) OF INTEGER;   -- int�� �迭�̴� ������ �����Ѱ� �ƴ϶� Ÿ���� �����ѰŴ�.
    varray1 varray_test; -- �̰� ��������
BEGIN
    varray1 := varray_test(11, 22, 33);
    dbms_output.put_line(varray1(2)); -- �ڹٶ� �ٸ��� 1���� ���� �����Ѵ� 2������ ����ϸ� 22�� ��µȴ�.
END;
/

ACCEPT p_deptno PROMPT '�μ� ��ȣ�� �Է��Ͻÿ�(�޿��� ��):'   -- ACCEPT PROMPT WINDOW

DECLARE
    v_salTotal NUMBER;
BEGIN
    SELECT SUM(salary) INTO v_saltotal
    FROM employees
    WHERE department_id = &p_deptno;
    
    dbms_output.put_line(&p_deptno || '�� �μ��� �޿��� ���� ' || TO_CHAR(v_saltotal, '$999,999,999'));
END;
/

-- �����ȣ �Է� �ް� �� ����� �޿��� 1000�� ���� ������ �����϶�.

ACCEPT p_no PROMPT '��� ��ȣ�� �Է����ּ��� :'

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
    
     dbms_output.put_line(&p_no || '�� ����� �޿� + 1000 :' || p_salTotal);
end;
/

rollback;

DECLARE
    -- ROWTYPE
    v_emp employees%ROWTYPE;   -- �Ȱ��� �ڷ��� Ÿ�� ������ ����Ѵ�
BEGIN
    SELECT employee_id, first_name, last_name, salary
        INTO v_emp.employee_id, v_emp.first_name, v_emp.last_name, v_emp.salary
    FROM employees
    WHERE employee_id = 100;
    
    
    dbms_output.put_line('�����ȣ' || v_emp.employee_id);
    dbms_output.put_line('�̸�' || v_emp.first_name);
    dbms_output.put_line('��' || v_emp.last_name);
    dbms_output.put_line('�޿�' || v_emp.salary);
END;
/
SET SERVEROUT ON

--����1) �����ȣ�� 7369�� ����� �޿��� 1500�� ���Ͽ� �����Ͽ���.


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
--����2) ������ �Է¹޾� �޿��� ���� ����ϴ� SCRIPT�� �ۼ��Ͽ���.
ACCEPT b_job PROMPT '�����Է�'
DECLARE
    b_sal number;  -- ��¿� ���� �̴�.
BEGIN
    SELECT sum(sal) into b_sal
    FROM emp
    where job = UPPER('&b_job');
    
    dbms_output.put_line('�޿��� �� : ' || TO_CHAR(b_sal, '$999,999,999'));
END;
/


--����3) EMP ���̺� EMPNO_SEQUENCE�� SEQUENCE�� �̿��Ͽ� �̸�.�޿�,�μ���ȣ��
--�Է¹޾� ����ϴ� SCRIPT�� �ۼ��Ͽ���. �� 10���μ��� �Էµ� �޿��� 20%�� �����Ͽ� ����ϰ� 30���μ��� 10% ���� ���� �ִ�.

CREATE SEQUENCE emp_SEQ
INCREMENT BY 1      -- 1�� ����(++)
START WITH 7903       -- ���۵Ǵ� ��       
MINVALUE 1; 

ACCEPT c_name PROMPT '�̸��Է�'
ACCEPT c_sal PROMPT '�޿� �Է�'
ACCEPT c_deptno PROMPT '�μ���ȣ�Է�'

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

--����4) EMP ���̺��� �̸��� �Է� �޾� �Ʒ��� ���·� ����ϴ� SCRIPT�� �ۼ��Ͽ���.
--��ȸ�ϰ��� �ϴ� ����� �̸��� �Է��Ͻÿ� : scott

ACCEPT d_name PROMPT '��ȸ�ϰ��� �ϴ� ����� �̸��� �Է��Ͻÿ� :'

DECLARE
    
    d_emp emp%ROWTYPE;
BEGIN
    SELECT * into d_emp.empno, d_emp.name, d_emp.job, d_emp.mgr, d_emp.hiredate, d_emp.sal, d_emp.comm, d_emp.deptno
    FROM emp
    where name = '&d_name';
    
    dbms_output.put_line('�����ȣ ' || d_emp.empno);
    dbms_output.put_line('�̸� ' || d_emp.name);
    dbms_output.put_line('���� ' || d_emp.job);
    dbms_output.put_line('��� ' || d_emp.mgr);
    dbms_output.put_line('�Ի��� ' || d_emp.hiredate);
    dbms_output.put_line('�޿� ' || d_emp.sal);
    dbms_output.put_line('���ʽ� ' || NVL(d_emp.comm, 0));
    dbms_output.put_line('��ȣ ' || d_emp.deptno);
    
-- ���� �� ó��
EXCEPTION   -- �Լ��� �κп��� ���� �߻�(������ ã����)
    WHEN NO_DATA_FOUND THEN
        dbms_output.put_line(&d_name || ' ����� �������� �ʽ��ϴ�.');
    WHEN TOO_MANY_ROWS THEN
        dbms_output.put_line( &d_name  || '����� �ΰ� �̻��Դϴ�.');
    WHEN OTHERS THEN
        dbms_output.put_line( '��Ÿ ���� �Դϴ�.');
END;
/


--����5) �̸��� �Է¹޾� �޿��� �Ի����� ����ϴ� SCRIPT�� �ۼ��Ͽ���.
ACCEPT f_name PROMPT '�̸��Է�'
DECLARE
    f_emp emp%ROWTYPE;
BEGIN
    SELECT sal, hiredate into f_emp.sal, f_emp.hiredate
    FROM emp
    WHERE name = '&f_name';

    dbms_output.put_line('�޿�' || f_emp.sal);
    dbms_output.put_line('�Ի糯¥' || f_emp.hiredate);

EXCEPTION   -- �Լ��� �κп��� ���� �߻�(������ ã����)
    WHEN NO_DATA_FOUND THEN
        dbms_output.put_line(&d_name || ' ����� �������� �ʽ��ϴ�.');
    WHEN TOO_MANY_ROWS THEN
        dbms_output.put_line( &d_name  || '����� �ΰ� �̻��Դϴ�.');
    WHEN OTHERS THEN
        dbms_output.put_line( '��Ÿ ���� �Դϴ�.');    
    
END;
/

















































