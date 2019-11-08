/*
    ���Ἲ : �÷��� �����ϴ� �����̴�
    -- primary key : �⺻Ű, NULL�� ������� ����.�������� Ȱ������ �ʴ´�. ( ���̵�, �ֹι�ȣ�� ���� ���� )
    unique key : ����Ű. NULL�� ���. �ߺ��� ������� ����.
    cheak : ���� ����. ���� ���� ����. NULL�� ����Ѵ�.
    forign key : �ܷ�Ű. �ٸ� ���̺��� PRIMRY KEY �̰ų� UNIQUE KEY �� ���ɼ��� �ִ�, 
                 ���̺�� ���̺��� ������ �ִ� ������ ������ �ִ�.
    not null : NULL�� ������� �ʰڴ�.

*/

DROP TABLE TB_TEST;

CREATE TABLE TB_TEST(
    COL_01 VARCHAR2(10) NOT NULL,
    COL_02 VARCHAR2(10)
);

INSERT INTO TB_TEST(COL_01, COL_02)
VALUES ('AAA', 'aaa');

INSERT INTO TB_TEST(COL_01, COL_02)
VALUES ('BBB', '');

INSERT INTO TB_TEST(COL_01, COL_02)
VALUES ('', 'CCC');

-- PRIMARY KEY
DROP TABLE TEST_01;

-- ���̺��� ���鶧 �⺻Ű�� N�� ����
CREATE TABLE TEST_01(
    KEY_01 VARCHAR2(10),
    KEY_02 VARCHAR2(10),
    COL_01 VARCHAR2(20),
    COL_02 VARCHAR2(30),
    CONSTRAINT PK_TEST_01 PRIMARY KEY(KEY_01, KEY_02)
);

DROP TABLE TEST_01;

CREATE TABLE TEST_01(
    KEY_01 VARCHAR2(10) ,
    KEY_02 VARCHAR2(10),
    COL_01 VARCHAR2(20),
    COL_02 VARCHAR2(30)
   
);

ALTER TABLE TEST_01
ADD
CONSTRAINT PK_TEST_01
PRIMARY KEY(KEY_01, COL_01);

ALTER TABLE TEST_01
DROP CONSTRAINT PK_TEST_01;

-- PRIMARY KEY Ȯ���� �� �ִ� ������
SELECT
    *
FROM user_constraints
WHERE table_name = 'TEST_01'
    AND constraint_type = 'P';

DROP TABLE TEST_01;

CREATE TABLE TEST_01(
    KEY_01 VARCHAR2(10) ,
    KEY_02 VARCHAR2(10),
    COL_01 VARCHAR2(20),
    COL_02 VARCHAR2(30)
);

INSERT INTO TEST_01(key_01, KEY_02, COL_01, COL_02)
VALUES('AAA', 'aaa', '111', '222');
-- �ߺ��� ����
INSERT INTO TEST_01(key_01, KEY_02, COL_01, COL_02)
VALUES('AAA', 'aaa', '111', '222');
-- NULL �� �Ĥ���
INSERT INTO TEST_01(key_01, KEY_02, COL_01, COL_02)
VALUES('', 'aaa', '111', '222');

CREATE TABLE TEST_01(
    KEY_01 VARCHAR2(10),
    KEY_02 VARCHAR2(10),
    COL_01 VARCHAR2(20),
    COL_02 VARCHAR2(30),
    CONSTRAINT PK_TEST_01 PRIMARY KEY(KEY_01, KEY_02)
);

INSERT INTO TEST_01(key_01, KEY_02, COL_01, COL_02)
VALUES('AAA', 'aaa', '111', '222');

-- �ߺ��� ����
INSERT INTO TEST_01(key_01, KEY_02, COL_01, COL_02)
VALUES('AAA', 'aaa', '111', '222');
-- ������ �ȶ�� ( KEY�� 2���� �ִ��� �ᱹ���� �ѽ����� ���⿡ AAA aaa �� ���ٰ� �Ǵ��Ѵ� �׷��� AAA AAA�� �ٸ� ������ �����Ѥ���.
INSERT INTO TEST_01(key_01, KEY_02, COL_01, COL_02)
VALUES('AAA', 'AAA', '111', '222');

SELECT
    *
FROM TEST_01;

-- �⺻Ű �� �ߺ���, NULL ���� ���� �� ����.

-- ������ ��
-- UNIQUE �ߺ��� ���ʾ����� ���� ����Ѵ�.
CREATE TABLE TEST_02(
    KEY_01 VARCHAR2(10) CONSTRAINT UK_TEST_01 UNIQUE,
    KEY_02 VARCHAR2(10),
    COL_01 VARCHAR2(20),
    COL_02 VARCHAR2(20)
);

INSERT INTO TEST_02(KEY_01, KEY_02, COL_01, COL_02)
VALUES('AAA', 'aaa', '111', '123');

DROP TABLE TEST_02
CASCADE CONSTRAINTS;    -- ���Ἲ���� ��� �����Ѵ�.

CREATE TABLE TEST_02(
    KEY_01 VARCHAR2(10),
    KEY_02 VARCHAR2(10),
    COL_01 VARCHAR2(20),
    COL_02 VARCHAR2(20),
    CONSTRAINT UK_TEST_01 UNIQUE(KEY_01, KEY_02)
);

INSERT INTO TEST_02(KEY_01, KEY_02, COL_01, COL_02)
VALUES('AAA', 'aaa', '111', '123');
-- �ߺ����̹Ƿ� ����������
INSERT INTO TEST_02(KEY_01, KEY_02, COL_01, COL_02)
VALUES('AAA', 'aaa', '111', '123');
-- ����ũ Ű�� �ΰ��� ����ϱ⿡ ������ �ȳ���.
INSERT INTO TEST_02(KEY_01, KEY_02, COL_01, COL_02)
VALUES('AAA', '', '111', '123');

-- CHECK     ���ϴ� ���� ��� ����ִ´� �� ���� ����Ѵ�.
CREATE TABLE TEST_03(
    KEY_01 VARCHAR2(10),
    KEY_02 VARCHAR2(10),
    COL_01 VARCHAR2(20),
    COL_02 NUMBER,
    CONSTRAINT CHK_TEST_01 CHECK(COL_01 IN('���', '��', '�ٳ���')),
    CONSTRAINT CHK_TEST_02 CHECK(COL_02 > 0 AND COL_02 <=100)
);
-- CHECK �ߺ���, �ΰ� ���
-- CHECK ������ CHECK ���� NULL ���� �����ϰ� �ٸ� ���� ��������� ��������.
INSERT INTO TEST_03(KEY_01, KEY_02, COL_01, COL_02)
VALUES('AAA', 'aaa', '���', '1');

INSERT INTO TEST_03(KEY_01, KEY_02, COL_01, COL_02)
VALUES('AAA', 'aaa', '���', '1');

INSERT INTO TEST_03(KEY_01, KEY_02, COL_01, COL_02)
VALUES('AAA', 'aaa', '��', '0');

INSERT INTO TEST_03(KEY_01, KEY_02, COL_01, COL_02)
VALUES('AAA', 'aaa', '', '');

SELECT
    *
    FROM TEST_03;
DROP TABLE TEST_03;

-- �ܷ�Ű FOREIGEN KEY
-- �θ����̺�


CREATE TABLE TEST_PAR(  -- DEPARTMENTTS, JOBS
    KEY_01 VARCHAR2(10),
    KEY_02 VARCHAR2(10),
    COL_01 VARCHAR2(10),
    COL_02 VARCHAR2(10),
    CONSTRAINT PK_TEST_PAR PRIMARY KEY(KEY_01, KEY_02)
);

CREATE TABLE TEST_CHD(  -- EMPLOYEES
    KEY_01 VARCHAR2(10) CONSTRAINT PK_TEST_CHD PRIMARY KEY,
    FK_KEY_01 VARCHAR2(10),
    FK_KEY_02 VARCHAR2(10),
    CONSTRAINT FK_TEST_CHD FOREIGN KEY(FK_KEY_01, FK_KEY_02)
        REFERENCES TEST_PAR(KEY_01, KEY_02) -- �˷��ִ� �κ�
);

INSERT INTO TEST_PAR(KEY_01, KEY_02, COL_01, COL_02)
VALUES ('AAA', 'aaa', '111', '222');

INSERT INTO TEST_PAR(KEY_01, KEY_02, COL_01, COL_02)
VALUES ('BBB', 'bbb', '222', '333');

INSERT INTO TEST_PAR(KEY_01, KEY_02, COL_01, COL_02)
VALUES ('CCC', 'ccc', '333', '444');

SELECT
    *
FROM TEST_PAR;

INSERT INTO TEST_CHD(KEY_01 ,fk_key_01, FK_KEY_02)
VALUES('111', 'AAA', 'aaa');

-- �θ� ���̺� �����Ͱ� ���� ���Ἲ ����
INSERT INTO TEST_CHD(KEY_01 ,fk_key_01, FK_KEY_02)
VALUES('222', 'AAA', 'BBB');

INSERT INTO TEST_CHD(KEY_01 ,fk_key_01, FK_KEY_02)
VALUES('222', 'BBB', 'bbb');

INSERT INTO TEST_CHD(KEY_01 ,fk_key_01, FK_KEY_02)
VALUES('333', '', '');

-- �ܷ�Ű�� ���ο� Ű���� �����ϴ��� Ȥ�� NULL ���� ����Ѵ�.

SELECT
    *
FROM test_chd;


commit;     -- Ŀ�Խ� �����Ͱ� db�� ����Ǳ� ������ �ѹ����ص� ������ �Ǿ��ִ�.

rollback;   -- �ѹ�� ������ ���� X

INSERT INTO test_par(KEY_01, KEY_02, COL_01, COL_02)
VALUES('DDD', 'ddd', '444', '555');

INSERT INTO test_par(COL_01, COL_02, KEY_01, KEY_02)
VALUES('DDD', 'ddd', '444', '555');

INSERT INTO test_par
VALUES('EEE', 'eee', '555', '666');

INSERT INTO test_par(KEY_01, KEY_02)
VALUES('FFF', 'fff');

SELECT
    *
FROM TEST_PAR;

CREATE TABLE TB_TEST_BK
AS
SELECT
    *
FROM JOBS;

SELECT
    *
FROM TB_TEST_BK;

-- UPDATE

UPDATE TB_TEST_BK
SET min_salary = 0, max_salary = 100 -- N���� ���� �ٲٰ� ������ ,�� �����Ѵ�.
WHERE job_id LIKE 'AD%';

UPDATE TB_TEST_BK
SET min_salary = 0, max_salary = 0
WHERE max_salary > 10000;

ROLLBACK;

-- DELETE

DELETE
FROM TB_TEST_BK
WHERE max_salary < 10000;

DROP TABLE TB_TEST_BK;








