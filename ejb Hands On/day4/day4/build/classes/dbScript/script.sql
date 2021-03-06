create table student(stuid number,name varchar2(20));
create table employee_test(empid number,empname varchar2(20));
create table passport_test(empid number,country varchar2(20));
create table parent(id number,pname varchar2(20));
create table child(id number,cname varchar2(20),parent_id number);
create table supplier(sid number,sname varchar2(20));
create table procuct(pid number,pname varchar2(20));
create table supplierpart(sid number,pid number);
create table ABSTRACT_PRODUCT (PRODUCT_ID number,name varchar2(20),DESCRIPTION varchar2(50), type varchar2(20));
create table PRODUCT (PRODUCT_ID number,price varchar2(50));
create table Book (PRODUCT_ID number,ISBN varchar2(50),TITLE varchar2(50), AUTHOR varchar2(50));
create table TRAVEL_GUIDE (PRODUCT_ID number,country varchar2(50));
create sequence person_seq start with 1 minvalue 1;
create sequence PRODUCT_SEQ start with 1 minvalue 1;
create sequence ADDRESS_SEQ start with 1 minvalue 1;
create table SEQUENCE_TABLE(seq_name varchar2(20),seq_count number);
create table TEST_VERSION (id number,version number,name varchar2(50),phone varchar2(50));
create table Event (Event_id number,name varchar2(50),event_date date);
create table Participant (participant_id number,name varchar2(50),contact_number varchar2(50));
create table Event_participant (Event_id number,participant_id number,date_of_registration date);
commit;