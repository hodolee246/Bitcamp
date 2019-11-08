/*
    ȣ���ؼ� �����Ѵ� exec �̸�();
    -- procedure    �ִ� ���ϰ��� ����� ����ϴ°�(insert, delete, update)
    -- function     �ִ� ���ϰ��� �ݵ�� �־���� (����, ������, ������) ����ϴ°�(select)
    
    -- trigger  -   �˹߽�Ű��. ������ �߻�(�ణ function �� ���������� function�� ������ ���Ѿ������� �ִ� �ڵ����� ������)
    insert : ���� �ִ°Ŷ� old ���� ����(������(������))             ������ ������ �ض� �̷�������... ?!?! 
    delete : �����ϴ°Ŷ� NEW ���� ����(���� ���䰪)
    update  : �Ѵ� �ִ°� update�� �ִ�. 

    �����ȣ 1001�� ���嵥���Ͷ�� ���� �����Ϸ��� �ϸ� ���� ���ϰ� ������ Ʈ���Ÿ� ����Ͽ�
    �� ���� ������! �������� �ڵ����� ����Ǹ鼭 ������ �ְ� �ϴ� �׷��뵵�� ���ȴ�.
*/
    

SET serveroutput on

CREATE OR REPLACE TRIGGER triger_test   -- �ִ� �Ű����� ����! why(�ۿ��� ȣ���ϴ°� �ƴ϶� �ٷ� ����Ǳ� ������)
   -- BEFORE AFTER 2���� ��ɾ�� �����ϱ����� ����ǰ� Ȥ�� �ϰ��� ����ǰ� ������ �Ѵ�.
    BEFORE
        UPDATE ON departments       -- departments table�� ������Ʈ �ϱ�����! ����ǰԲ�
        FOR EACH row                -- ���ư��� ���� ��� ROW(��) �� �����ض�
BEGIN
    DBMS_OUTPUT.PUT_LINE('������ �÷��� ��' || :OLD.department_name);     -- ���� �״�� ������
    DBMS_OUTPUT.PUT_LINE('������ �÷��� ��' || :NEW.department_name);     -- ������
END;
/


update departments
set department_name = '����'
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
    
    DBMS_OUTPUT.PUT_LINE('�޿� ���:' || avg_sal);

END;
/

SELECT round(avg(salary), 3)
FROM employees;


-- ����� �������� ���ϰ� �� ���
-- ���� �Ҽ� ���� �� ���
-- �Է� �Ҽ� ���� �� ���  ������� or ��
CREATE OR REPLACE TRIGGER emp_tigger
    BEFORE
        UPDATE OR DELETE OR INSERT ON employees
        FOR EACH ROW
BEGIN
    IF UPDATING THEN
        IF :OLD.employee_id = '100' THEN
            RAISE_APPLICATION_ERROR(-20001, '�� �����ȣ�� �����Ҽ� �����ϴ�.');
        END IF;
    END IF; 
END;
/

UPDATE employees
SET salary = 2500
WHERE employee_id = 100;

SET SERVEROUTPUT ON

-- ����1) �̸��� �Է¹޾� �� ����� ���� �� �μ���� �޿��� �˻��ϴ� ���ν����� �����Ͽ���.
    CREATE OR REPLACE PROCEDURE s_dnsal(ename IN emp.name%TYPE) -- v_dname OUT dept.dname%TYPE, v_sal OUT emp.sal%TYPE
IS
    v_emp emp%ROWTYPE;
    v_dept dept%ROWTYPE;
BEGIN
   
   SELECT d.dname, e.sal into v_dept.dname, v_emp.sal
   FROM emp e, dept d
   WHERE e.name = UPPER(ename) AND e.deptno = d.deptno;
    
    DBMS_OUTPUT.PUT_LINE('�μ���' || v_dept.dname);
    DBMS_OUTPUT.PUT_LINE('�޿�' || v_emp.sal);
    
EXCEPTION
    WHEN NO_DATA_FOUND THEN
         dbms_output.put_line('�Է��� ����� �������� �ʽ��ϴ�.');
    WHEN TOO_MANY_ROWS THEN
         DBMS_OUTPUT.PUT_LINE('�ڷᰡ 2�� �̻��Դϴ�.');
    WHEN OTHERS THEN
         DBMS_OUTPUT.PUT_LINE('��Ÿ �����Դϴ�.');     -- ��Ÿ �����ϰ�� update or insert or delete ������� ��Ÿ������ roll back�� �ٿ�����
         
END;
/
    
ACCEPT ename PROMPT '����̸� �Է�'
EXEC s_dnsal('&ename');


-- ����2) EMP ���̺��� �̸����� �μ� ��ȣ�� �˻��ϴ� �Լ��� �ۼ��Ͽ���.
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
        DBMS_OUTPUT.PUT_LINE('�ش����̾����ϴ�.');
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
        DBMS_OUTPUT.PUT_LINE('����� ã���� �����ϴ�.');
    WHEN TOO_MANY_ROWS THEN
        DBMS_OUTPUT.PUT_LINE('�ڷᰡ 2�� �̻��Դϴ�.');
END;
/

VAR g_dn NUMBER;
EXEC :g_dn := ename_DEPTNO('WARD');
PRINT g_dn;

ACCEPT n_ame PROMPT '�̸��Է�'
EXEC ev_name('&n_ame');
-- ����3) EMP ���̺��� �̸��� �Է� �޾� �μ���ȣ,�μ���,�޿��� �˻��ϴ� FUNCTION�� �ۼ��Ͽ���. �� �μ���ȣ�� RETURN�� ����Ͽ���.

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
        DBMS_OUTPUT.PUT_LINE('�ش����̾����ϴ�.');
END;
/

ACCEPT emp_no PROMPT '�����ȣ�Է�'
SELECT f_ename(&emp_no)
FROM dual;

--) �� ���ڸ� �����ϸ� ������ �ؼ� ������� ��ȯ�ϴ� �Լ��� �����Ͻÿ�.(�Լ��� add_num)

CREATE OR REPLACE FUNCTION add_num(f_num IN NUMBER, s_num IN NUMBER)
    RETURN NUMBER
IS
    alu NUMBER;
BEGIN
    alu := f_num + s_num;
    
    return alu;
END;
/
ACCEPT fnum PROMPT '����'
ACCEPT snum PROMPT '����'
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

SELECT add_sum(salary, salary * nvl(commission_pct, 0)) as "�޿�"
FROM employees;

--2) �޿�(���ʽ� ����)�� ���� ������ ������ ���� �����ϴ� �Լ��� �ۼ��Ͻÿ�.
--�޿��� �� $3,000���� ������ ������ 0% �����ϸ�, $3,000�̻� $7,000 �̸��̸� 10%, 
--$7,000�̻� $10,000 �̸��̸� 20%, $10,000�� �̻��̸� 30%�� ������
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
    salary + nvl(commission_pct, 0) �Ǳ޿�,
    sal_tax(salary, commission_pct) ����
FROM employees;

--3) �μ���ȣ�� �Է��ϸ� �ش� �μ����� �ٹ��ϴ� ��� ���� ��ȯ�ϴ� �Լ��� �����Ͻÿ�.
 --  (�Լ��� get_emp_count)
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
        DBMS_OUTPUT.PUT_LINE('�ش����̾����ϴ�.');
END;
/

ACCEPT dpno PROMPT '�μ���ȣ'

SELECT get_emp_count(&dpno)
from dual;



--4) employees���̺��� �̿��ؼ� �Ի����� �����ϸ� �ٹ������� ���ϴ� �Լ��� �����Ͻÿ�.(�Ҽ��� 
--   �ڸ� ����, �Լ��� get_info_hiredate)
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

ACCEPT h_d PROMPT '�����ȣ'

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

SELECT first_name, get_info_hiredate(hire_date) ����
FROM employees;


--5) employees���̺��� �̿��ؼ� �����ȣ�� �Է��ϸ� �ش� ����� ������ �̸��� ���ϴ� �Լ���
--   �����Ͻÿ�.(�Լ��� get_mgr_name)
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

ACCEPT emplno PROMPT '�����ȣ�Է�'
SELECT get_mgr_name(&emplno)
FROM dual;

-- 6) emp���̺�(SCOTT)�� �̿��ؼ� �����ȣ�� �Է��ϸ� �޿� ����� ���ϴ� �Լ��� �����Ͻÿ�.
-- (4000~5000 A, 3000~4000�̸� B, 2000~3000�̸� C, 1000~200�̸� D, 1000�̸� F, �Լ��� get_sal_grade)

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

ACCEPT eno PROMPT '�����ȣ�� �Է����ּ���'
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

SELECT ename, sal, get_sal_grade(empno) �޿����
FROM emp
order by sal;


INSERT INTO employees(employee_id, last_name, email, hire_date, job_id)
values(400, 'inwoo', 'aa', sysdate, 'IT_PROG');

COMMIT;

