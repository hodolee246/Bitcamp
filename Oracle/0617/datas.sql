Select * FROM employees;

SELECT * FROM EMPLOYEES;    /*     ���� ����(���δ� �빮�ڷ� ���)     */

-- ���� �ּ���
/*
���� �ּ���
*/

-- �ڷ��� 
-- JAVA   Oracle
-- int == NUMBER
-- String == VARCHAR2
-- double == NUMBER(������ �ڸ���, �Ҽ��� �ڸ���)
-- Date == Date


-- ���ڿ� �ڷ���
-- CHAR
CREATE TABLE TB_CHAR(
    COL_CHAR1 CHAR(10 BYTE),    --  COL_String COL_CHAR1;
    COL_CHAR2 CHAR(10 CHAR),    -- CHAR : 10 BYTE
    COL_CHAR3 CHAR(10)  -- �ƹ��͵� �������� ����Ʈ�� ����.
    
)  ; 

/*
CREATE TABLE ���̺��(
    �÷��� �÷��� �ڷ���(ũ��),
    �÷��� �÷��� �ڷ���(ũ��)

);
*/
INSERT INTO TB_CHAR(COL_CHAR1, COL_CHAR2, COL_CHAR3)
VALUES('ABC', 'ABC', 'ABC'); -- ����ũ�� 1BYTE, 

SELECT * FROM TB_CHAR;

INSERT INTO TB_CHAR(COL_CHAR1, COL_CHAR2, COL_CHAR3)
VALUES('����', '����', '����'); -- �ѱ�ũ�� 3 BYTE

INSERT INTO TB_CHAR(COL_CHAR1, COL_CHAR2, COL_CHAR3)
VALUES('������', '������', '������');

SELECT col_char1, col_char2, col_char3,
    LENGTHB(col_char1), LENGTHB(col_char2), LENGTHB(col_char3)
FROM TB_CHAR;

/*
CHAR : 10BYTE 00000 00000
ABC ->        ABC00 00000

10 BYTE
������ -> ������0 (3*3 + 0)

10 CHAR
�� 3 + 9 = 12;               ��0000 00000
���� 3 + 3 + 8 = 14          ����000 00000
������ 3 + 3 + 3 + 7 = 16     ������00 00000
*/

-- VARCHAR2 (���ڿ�)
CREATE TABLE TB_VARCHAR(
    �÷�1 VARCHAR2(10 BYTE),
    �÷�2 VARCHAR2(10 CHAR),
    �÷�3 VARCHAR2(10) -- VARCHAR �� �ƹ��͵� �������� BYTE������ ����.
);

INSERT INTO tb_varchar(�÷�1, �÷�2, �÷�3)
VALUES('ABC', 'ABC', 'ABC');

INSERT INTO tb_varchar(�÷�1, �÷�2, �÷�3)
VALUES('������', '������', '������');

SELECT "�÷�1", "�÷�2", "�÷�3",
    LENGTHB("�÷�1"), LENGTHB("�÷�2"), LENGTHB("�÷�3")
FROM tb_varchar;

-- LONG �ִ� 2GB���� ���� ����
CREATE TABLE TB_LONG(
    COL_LONG1 LONG
--    COL_LONG2 LONG
    
);

INSERT INTO tb_long(COL_LONG1)
VALUES('ABC');

-- ����Ŭ���� LONG�� 2GB���� ������ ������ ���ڿ��̴�.

-- ���� �ڷ��� INTEGER
CREATE  TABLE TB_INTEGER(
COL_INT1 INTEGER,
COL_INT2 INTEGER
);

-- NUMBER(����, �Ǽ� �Ѵ� ��밡����)

CREATE TABLE TB_NUMBER(
COL_NUM1 NUMBER,
COL_NUM2 NUMBER(5),
COL_NUM3 NUMBER(5, 2),
COL_NUM4 NUMBER(*, 2)
);

INSERT INTO TB_NUMBER(COL_NUM1, COL_NUM2, COL_NUM3, COL_NUM4)
VALUES(1234.5678, 12345, 123.456, 1234.56789);

SELECT * FROM TB_NUMBER;

/*
INSERT INTO TB_NUMBER(COL_NUM1, COL_NUM2, COL_NUM3, COL_NUM4)
VALUES(1234.5678, 12345, 1234.567, 1234.56789);
*/
-- ���� 1234,567 5�ڸ� ���� �ȿ� �Ҽ��� 2�ڸ������̹Ƿ�  ������ ������ �Ѿ�� ������ �߻�

-- ��¥ �ڷ��� DATE
-- ����, ��, ��, ��, ��, �� ���� ���δ� ����.
CREATE TABLE TB_DATE(
    COL_DATE1 DATE,
    COL_DATE2 DATE
);

INSERT INTO TB_DATE(COL_DATE1, COL_DATE2)
VALUES(SYSDATE, SYSDATE -1);

SELECT * FROM TB_DATE;

INSERT INTO TB_DATE(COL_DATE1, COL_DATE2)
VALUES(SYSDATE, TO_DATE('2019-07-12 10:32:21', 'YYYY-MM-DD HH:MI-SS'));

INSERT INTO TB_DATE(COL_DATE1, COL_DATE2)
VALUES('19/08/15', '19/07/12');

INSERT INTO TB_DATE(COL_DATE1, COL_DATE2)
VALUES(SYSDATE, '2019-07-12 10:32:21');

INSERT INTO TB_DATE(COL_DATE1, COL_DATE2)
VALUES(SYSDATE, TO_DATE('20190712103221', 'YYYYMMDDHHMISS'));

/* VARCHAR2 (���ڿ�) -> DATE(��¥�������� �ٲ� �� ����) : TO_DATE */
/* DATE(��¥����) -> VARCHAR2(���ڿ�) : TO_CHAR */



