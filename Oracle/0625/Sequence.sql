
/*
    sequence : ������ ���� ������ �ִ� Oracle Object��
    ȸ����ȣ, �Խ����� �� ��ȣ
    sequence�� �����ϸ�, Primary key �� ���� ���������� �����ϴ�
    column�� �ڵ������� ������ �� �ִ�
    sequence �� �ʱ�ȭ�� �Ұ��� �ϴ�. ( �����Ǵ� ���ڶ�� �������� )
    1
    2 
    3
*/

CREATE SEQUENCE TEST_SEQ
INCREMENT BY 1      -- 1�� ����(++)
START WITH 10       -- ���۵Ǵ� ��
MAXVALUE 120        -- �ִ�� �����ϴ� �� ������ �����ϴ�. ������ �� ������ �ִ�� �ȴ�.
MINVALUE 1;         -- �ִ밪�� �ݴ�

-- CURRVAL == ���� �������� ��
-- ��ó�� ����� ������ ���� �ѹ��� ����� ���� ���⿡ ���簪�� �����Ƿ� ������ ���� �׷��Ƿ� �ؽ�Ʈ�� �ѹ��̻� ���Ѿ��� �۵��� �ȴ�.
SELECT TEST_SEQ.CURRVAL
FROM DUAL;

-- NEXTVAL == ���� ��

SELECT TEST_SEQ.nextval
FROM DUAL;

-- SEQUENCE ����
ALTER SEQUENCE TEST_SEQ
INCREMENT BY 3;

-- SEQUENCE �ʱ�ȭ�� �Ұ����ϴ�. (�����ϰ� �ٽ� ������ �Ѵ�.)
DROP SEQUENCE TEST_SEQ;


-- INSERT INTO EMPLOYEES(EMPLOYEES_SEQ.NEXTVAL,

-- ���Ǿ�(SYNONYM / ��ü�� ����)

/*
 1.   INT array_postion_number[];
 2.   int arrPosnum[] = array_opstion_number;
 3.   arrPosNum[0] = 1;
*/

CREATE SYNONYM "�����"
FOR EMPLOYEES;      -- EMPLOYEES ���̺��� �ڱⰡ ���ϴ� �̸���� �ٲ㼭 �����͸� �ִ°Ŵ�.

SELECT
    *
FROM "�����";

INSERT INTO "�����"
VALUES(EMPLOYEES_SEQ.NEXTVAL, '�ο�', '��', 'GOHOME', '123-4567', TO_DATE('2019/11/13', 'YYYY/MM/DD'),
'IT_PROG', 20000, NULL, 100, 10);

SELECT
    *
FROM EMPLOYEES







































































