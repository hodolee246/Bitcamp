-- Function return value *(���ν����� �ŰԺ����� return value�� �޴´�)
-- �Է¹��� ������ ���� 10%�� ����������ϴ� �Լ�

CREATE OR REPLACE FUNCTION tax_value(p_val IN NUMBER)
    RETURN NUMBER   -- ���� �ڷ��� ��������� �Ѵ�.

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


-- ��� ��ȣ�� �Է��ϸ�, ����� �޿��� �����ϴ� FUNCTION �� ������!

CREATE OR REPLACE FUNCTION empno_sal(p_empno IN NUMBER)
    RETURN NUMBER
IS
    v_sal employees.salary%TYPE;
BEGIN
    SELECT salary into v_sal
    FROM employees
    WHERE employee_id = p_empno;
    
    RETURN v_sal;       -- �ݵ�� ���Ϲ��� �����ؾ��Ѵ� (�ݵ��)(������)(����)
END;
/
SELECT empno_sal(102)
FROM dual;
















