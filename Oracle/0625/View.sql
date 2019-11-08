/*
    view : ���� ���̺�                           *dual : ���� ���̺�
    ���� ����Ǵ� ���� �ƴϴ�(view)  --> pointer
    [int * p;
    int number;
    p = &number; , number�� ���ؼ� p�� ������ �� �� �־�����.] �ڹ�
    �Ѱ��� view�� �������� ���̺��� �����͸� �˻��ϴ� ���� �����ϴ�.
    ó�� �ӵ��� ������.
    ������ ������ �� �ִ�. --> readonly  view�� ��ü�� ��� ��������� ����.
*/

CREATE VIEW UB_TEST_01(

    JOB_ID,
    JOC_TITLE,
    MIN_SALARY
)
AS
SELECT JOB_ID, JOB_TITLE, MIN_SALARY
FROM JOBS;

SELECT
    *
FROM UB_TEST_01;

INSERT INTO UB_TEST_01
VALUES('DEVELOPER', '������', 1000);

SELECT
    *
FROM JOBS

ROLLBACK;
COMMIT;

CREATE TABLE TB_TEST_02(
    KEY_01 VARCHAR2(10),
    KEY_02 VARCHAR2(10),
    COL_01 VARCHAR2(20),
    COL_02 VARCHAR2(20),
    CONSTRAINT PK_TEST_02 PRIMARY KEY(KEY_01, KEY_02)
);
CREATE OR REPLACE VIEW UB_TEST_02(  -- OR REPLACE == ������ �Ҷ����� ���� �������� ������ ��Ų��(������� �׳� �����ϸ� �̹� �ִٰ� ������ ���.)
    KEY_01,
    KEY_02,
    COL_01,
    CONSTRAINT PK_UB_TEST_02 PRIMARY KEY(KEY_01, KEY_02)
        DISABLE NOVALIDATE   
)
AS
SELECT KEY_01, KEY_02, COL_01
FROM TB_TEST_02;
/*
    ���Ἲ = CONSTRAINT
    PRIMARY KEY (�⺻Ű)   UNIQUE KEY + NOT NULL
    UNIQUE      ����Ű     �ϳ��ۿ� ���� + NULL ���
    NOT NULL              NULL�� ��� ����
    CHECK                 ������ ���̳� �������� ���̿ܿ� NUMM�� ���
    FORELGN KEY           1. TABLE. 2.TABLE ����  NULL ���
*/

SELECT * FROM TB_TEST_02;
SELECT * FROM UB_TEST_02;

INSERT INTO UB_TEST_02(KEY_01, KEY_02, COL_01)
VALUES('AAA', 'aaa', '111');

INSERT INTO UB_TEST_02(KEY_01, KEY_02, COL_01)
VALUES('AAA', 'aaa', '111'); -- �ߺ��̱⿡ ������ �߻��Ѵ�(�⺻Ű)

INSERT INTO UB_TEST_02(KEY_01, KEY_02, COL_01)
VALUES('AAA', '', '111'); -- ���̴ϱ� ������ �߻��Ѵ�(�⺻Ű)

INSERT INTO UB_TEST_02(KEY_01, KEY_02, COL_01)
VALUES('AAA', 'AAA', '111'); -- KEY_01, KEY_02�� �� ���� �⺻Ű �̱⿡ �ߺ��� �ƴϰ� �ȴ�.
-- AAA aaa
-- AAA AAA 

CREATE OR REPLACE VIEW EMPVIEW(
    "�����ȣ",     
    "��",
    "�̸���",
    "�Ի���",
    "����",
    CONSTRAINT PK_UB_EMP PRIMARY KEY("�����ȣ") DISABLE NOVALIDATE
    -- �⺻Ű ���̵� ���� �浹(�ߺ�)�� ��� ������ �߻��Ѵ�.
    -- �⺻Ű ���̵� �����ϴ� ������ ������ �ؾ� ���Ҷ� ���̺��� �⺻Ű�� ������ �� �ִ� �׷��� ������� ���̺��� �������Ѵ�.
    -- �⺻Ű ���� �÷��� �ѱ۵� �����ϴ�
)
AS
SELECT employee_id, LAST_NAME, EMAIL, HIRE_DATE, JOB_ID
FROM EMPLOYEES
WITH READ ONLY;     -- VIEW�� â������ �����͸� ���°͸� �����ϴ� (������ �Ұ����ϴ�)

SELECT
    *
FROM EMPVIEW;

INSERT INTO EMPVIEW
VALUES(300,'������ʹ�','GOHOME@NAVER.COM', SYSDATE, 'GO_HOME');
-- READ ONLY�� �����͸� ����������� �߱⿡ ������ �߻��Ѵ�.




























