-- ����� ���̺�
CREATE TABLE member(
  name VARCHAR2(20),
  userid VARCHAR2(10),
  pwd VARCHAR2(10),
  email VARCHAR2(20),
  phone char(13),
  admin NUMBER(1) default 0, -- ����ڴ� 0, �����ڴ� 1
  PRIMARY KEY(userid)
);

insert into member values('�̼���', 'sslee', '1234', 'sslee@email.com', '010-
2220-2332', 0);
insert into member values('������', 'ksyou', '1234', 'ksyou@email.com', '010-
8847-5633', 1);
insert into member values('�庸��', 'bkjang', '1234', 'bkjang@email.com',
'010-5574-7868', 0);
commit;

SELECT * FROM member;

-- ��ǰ���� ���̺�
CREATE TABLE item(
  name VARCHAR2(20),
  price NUMBER(8),
  description VARCHAR2(100)
);

SELECT * FROM item;

-- ��ǰ���� ���̺�
CREATE TABLE product(
  code number(5),
  name varchar2(100),
  price number(8),
  pictureurl varchar(50),
  description varchar(1000),
  primary key(code)
);

CREATE SEQUENCE product_sqe
START WITH 1
INCREMENT BY 1
MINVALUE 1
NOCYCLE
NOCACHE;

INSERT INTO product VALUES(product_sqe.NEXTVAL, '�ۺ��λ�', 12600, 'book1.jpg', 
'�迵�� ����Ҽ�');
INSERT INTO product VALUES(product_sqe.NEXTVAL, '���ѳ���10', 12150, 'book2.jpg', 
'������ ������ �ھƳ��� ���ѳ����� Ȱ���� �ϻ�');
INSERT INTO product VALUES(product_sqe.NEXTVAL, '������ ������', 12600, 'book3.jpg', 
'��ȣ�� �۰��� ����Ҽ�');
INSERT INTO product VALUES(product_sqe.NEXTVAL, '������ ��Ģ', 14400, 'book4.jpg', 
'����� ������ ������ 51���� �ɸ���');
INSERT INTO product VALUES(product_sqe.NEXTVAL, '��ȭ�ϴ� ��������', 34200, 'book5.jpg', 
'�迵�� ����Ҽ�');
commit;

SELECT * FROM product;

-- �Խ��� ���̺�
CREATE TABLE board (
  num NUMBER(5) PRIMARY KEY,
  pass VARCHAR(30),
  name VARCHAR2(30),
  email VARCHAR2(30),
  title VARCHAR2(50),
  content VARCHAR2(1000),
  readcount NUMBER(4) default 0,
  writedate DATE default SYSDATE
);

CREATE SEQUENCE board_seq
START WITH 1
INCREMENT BY 1
MINVALUE 1
NOCYCLE
NOCACHE;

INSERT INTO board(num, pass, name, email, title, content)
    VALUES(board_seq.NEXTVAL, '1234', '�庸��', 'bkjang@email.com', '�������', '���� �ݿ��Ͽ� �𿩿�!');
INSERT INTO board(num, pass, name, email, title, content)
    VALUES(board_seq.NEXTVAL, '1234', '������', 'kckang@email.com', '�Խñ� ����', 'ù��° �Խñ��Դϴ�.');
INSERT INTO board(num, pass, name, email, title, content)
    VALUES(board_seq.NEXTVAL, '1234', '��âȣ', 'chahn@email.com', '����1', '����1 �Խñ��Դϴ�.');

commit;

SELECT * FROM board;
SELECT * FROM board ORDER BY num desc;
drop table board;
drop sequence board_seq;

-- ��ȭ ���̺�
CREATE TABLE movie(
  code NUMBER(4) PRIMARY KEY,
  title VARCHAR2(50),
  price NUMBER(10),
  director VARCHAR2(20),
  actor VARCHAR2(20),
  poster VARCHAR2(100),
  synopsis VARCHAR2(3000)
);

CREATE SEQUENCE movie_seq
START WITH 1
INCREMENT BY 1
MINVALUE 1
NOCYCLE
NOCACHE;

INSERT INTO movie
       VALUES(movie_seq.NEXTVAL, 'ù Ű���� 50�� °', 9900, '���� �ð�', '�ƴ� ���鷯', 'movie1.jfif', '�(�ƴ� ���鷯)�� ������ �Ͽ��� ���������� �������� ������, �㿡�� ���ఴ����� ȭ���� �Ϸ���� ���� ����� �۾���. �쿬�� ��ø� ������ �� �״� ��������� �׳࿡�� ù ���� ���� �ٰ�����. �׷��� ��� ȭ���� �Դ㿡 �Ѿ�� �ٷθ� �˾Ҵ� ��ô� ���� �� �׸� �ķ�ġ�� ����ϸ� ������� ���� ���Ѵ�. ��� �׳డ �ܱ� ��������� �ɷ�����, ���� ��ħ�̸� ��� ����� 10�� 13�� �Ͽ��� ������ ���Ϸ� ���ư������ٴ� ����� �˰� �ȴ�. ������ �ڽŰ��� ù ������ ����á��� ������ ������ ���� ��� �Ź� ���õ���� �۾��� �õ��ϰ�, �Ϸ� �Ϸ� ������ ù ����Ʈ�� ������ ��� ��, ��ô� �ڽ��� �ܱ� ��������� �ɷȴٴ� ����� ���ݰ� ����� �ް� �Ǵµ�... ����, �� ����� ����� �̷��� �� ������?');
INSERT INTO movie(code, title, price, director, actor, poster, synopsis)
       VALUES(movie_seq.NEXTVAL, '�ظ��� ������ ������ ��', 9900, '�� ���̳�', '�� ���̾�', 'movie2.jfif', '"�츰 ģ���� �� �� ���ڳ׿�." ���� ���� �� �������� �Բ� �ϰ� �� �ظ��� ����. ���ڿ� ���ڴ� ģ���� �� �� ���١��� ������ �� ����� ������ ���̰�, ���ݵ� ���⵵ ���ݴ��� ���θ� �����̶� �����Ѵ�. ���忡 ������ �� ����� ª�� �λ縦 ������ ��ٷ� �������. "�ʶ� ���� �� �ϱ� õ�������̾�." �� �� ��, �쿬�� �������� ��ȸ�� �� ���. ������ ���ΰ� �̺��߰� �ظ��� �Ƴ����� ��ȥ�� �뺸 �޾Ҵ�. �� ����� �̺��� ���� �̾߱��ϸ� �޼ӵ��� ��������� ��μ� �ѵ� ���� ģ���� �ȴ�. "���ݸ� �� �Ⱦ���." ��� �� ������ ����� ������ ��ȥ �ҽ��� ��� �ǰ� �ڴ��� �̺��� ���Ŀ� �����Ѵ�. �ظ��� �׷� �׳ฦ ������ �Ⱦ��ְ� ������ Ű���� ����� �Ϸ������ �̾����µ��� ���� �� ��ħ, �츰 ģ���ϱ�, �����ϱ�?');
INSERT INTO movie(code, title, price, director, actor, poster, synopsis)
       VALUES(movie_seq.NEXTVAL, '������ ����� ������ �ȴ�', 9900, '�� ��ƿ��', '�� ��ƿ��', 'movie3.jfif', '������ �����翡�� 16��° �ٹ� ���� ���� ��Ƽ. �ݺ��Ǵ� �ϻ������� ����� ���� Ư���� ������ �޲ٴ� �׿��� ���� �յ� ���������� ������ ȣ ǥ�� ������ ã�ƿ��� �̼��� �����. ��� ������ ��� �� �� ���� ���ʹ� ������ ������ ã�� �׸�����, ���̽����� ���� �ѳ���� ��� �ڽ��� ������ ���� �� ���� �Ŵ��� ��庥ó�� �����Ѵ�. �������� ����� �ϻ��� ��� ����, �� ������ ���� �� ���� Ư���� ���� �ְ��� ������ �����ϰ� �ȴ�!');
INSERT INTO movie(code, title, price, director, actor, poster, synopsis)
       VALUES(movie_seq.NEXTVAL, '�׸� ����Ʈ', 9900, '���̺� �ο���', '���� ����', 'movie4.jfif', 'ũ�������� �̺�, �Ƽ��հ� ��Ź�� ���� �տ� ��Ÿ�� ��� ���, "���� ����� ��, ���� ���� ����ġ�� ���� �繰�� �ְڴ�"�� �����Ѵ�. ��, 1�� �� ��� ����翡 ã�ƿ� �Ȱ��� �ڽ��� �������� �޴´ٴ� ��������. �Ƽ����� ��ī �������� ������ ���ϰ� ��ħ�� 1�� ��, 5���� ���� ������ ��ġ�� ������ �����ϴµ��� ������ �� ���ο� ����, ���� �� ���� �ɾ��!');
INSERT INTO movie(code, title, price, director, actor, poster, synopsis)
       VALUES(movie_seq.NEXTVAL, '����� ���', 9900, '������', '������', 'movie5.jfif', '�� ���󿡼� �߶��� �� ������ ���� ���. ��� ���� ����(������)�� ������� �Ƴ� ����(������)�� �����ϰ� �ȴ�. "�꿡 ���� �� ���� �����߾��, ��ħ�� ������ ��." ������ ���� �տ��� Ư���� ���並 ������ �ʴ� ����. ������ ������ ���������� �ٸ� ������ ���Ǽ��� �ø���. ������ ��� ������ �˸����� Ž���� �Ź�, �ẹ���縦 ���� ������ �˾ư��鼭 �׳࿡ ���� ������ ���� Ŀ������ ���� ������. ����, ��ó�� ���� �����ϱ� ����� ������ ��밡 �ڽ��� �ǽ��Ѵٴ� ���� �˸鼭�� ������ �����ӵ� ���� ������ ���ϴµ���. ������ ����� ������ �����ڿ��� �ǽɰ� ������ ���ÿ� ������ ���� �׵��� <����� ���>');
commit;
SELECT * FROM movie;

DROP TABLE movie;