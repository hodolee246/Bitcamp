
create table ACCOUNT(
ID VARCHAR2(20) PRIMARY KEY,
PWD VARCHAR2(40) NOT NULL,
NAME VARCHAR2(40) NOT NULL,
AGE NUMBER(10) NOT NULL
);

CREATE TABLE COFFEE(
	NAME VARCHAR2(30) NOT NULL,
	CUPSIZE VARCHAR2(15) NOT NULL,
	SYRUP VARCHAR2(20) NOT NULL,
	ADDSHOT VARCHAR2(20) NOT NULL,
	ADDCREAM VARCHAR2(20) NOT NULL,
	CUP NUMBER(5) NOT NULL,
	MONEY NUMBER(8) NOT NULL
);



DROP TABLE COFFEE;






CREATE TABLE COFFEEMONEY(
	ESPRESSOBEVERAGES VARCHAR2(30)  NOT NULL,
	SHORT NUMBER(5) NOT NULL,
	TALL NUMBER(5) NOT NULL,
	GRANDE NUMBER(5) NOT NULL
);


select * from coffee;

DROP TABLE COFFEE;

CREATE SEQUENCE SEQ_BBS
START WITH 1
INCREMENT BY 1;


select * from coffeemoney

