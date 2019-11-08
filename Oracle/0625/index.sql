/*
    index �˻��� ����
    ���ϴ� ������ ��ġ�� ������ ��Ȯ�ϰ� �˾Ƴ��� �ִ� ���
    -- �ڵ����� : Primary key, Unique ���ο��� �������
    -- �������� : Query
    
    �����ؾ� ���� ���
    1.where���̳� join���Ǿȿ� ���� ���Ǵ� �÷� department_id
    2.null���� ���� ���ԵǾ� �ִ� �÷�           manager_id
    3.where���̳� join���Ǿȿ� �ΰ��̻��� ���÷�
    
    �����ؼ� ������ ���
    1. ���̺� ũ��(row)�� ������(3000������) ����� �Ǹ� ������ �ӵ��� ���Ͻ�Ŵ
    2. ���̺��� ���� ���ŵɋ�
*/

CREATE TABLE EMP_COPY
AS
SELECT * FROM employees;

-- �ڵ����� �ε��� �ڵ�����

ALTER TABLE EMP_COPY
ADD
CONSTRAINT PK_EMPCOPY_01 PRIMARY KEY(EMPLOYEE_ID);

-- INDEX Ȯ��
SELECT *
FROM ALL_INDEXES
WHERE INDEX_NAME IN('PK_EMPCOPY_01'); -- �ε��� ��Ī�̶� PRIMARY ���̵�� ����

-- ���� ����
CREATE INDEX EMP_INDEX01
ON EMP_COPY(MANAGER_ID); -- index �˻��� �����ϱ� ���� ����

DROP INDEX EMP_INDEX01;
