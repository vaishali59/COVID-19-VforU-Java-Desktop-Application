Create Table usertable(
	firstname varchar2(255) NOT NULL,
	lastname varchar2(255) NOT NULL,
    email varchar2(320) check ( regexp_like(email, '[[:alnum:]]+@[[:alnum:]]+\.[[:alnum:]]')) PRIMARY KEY,
    password varchar2(40) NOT NULL,
    usertype varchar2(100) CHECK (usertype='volunteer' OR usertype='requester') NOT NULL,
    phone varchar2(10) NOT NULL,
    notification varchar2(1000),
    city varchar2(50) NOT NULL 
);


Insert into usertable values ('James','Smith','james@gmail.com','James000#','requester',1234567890,'','SANTACLARA');
Insert into usertable values ('Tom','Cook','tom@outlook.com','Tom0001#','volunteer',1324456787,'','SANTACLARA');
Insert into usertable values ('Tim','Horton','tim@gmail.com','Tim0001#','requester',1234543245,'','NEWYORK');
Insert into usertable values ('Mary','John','john@hotmail.com','Mary0001#','volunteer',1324352634,'','SEATTLE');
Insert into usertable values ('Mark','Lee','lee@yahoo.com','Mark000#','requester',9743567877,'','CHICAGO');
Insert into usertable values ('Mike','Jones','mike@gmail.com','Mike000&','volunteer',2345565434,'','SANFRANCISCO');
Insert into usertable values ('David','Smith','smith@gmail.com','david123@','requester',4567543456,'','SEATTLE');
--Insert into usertable values ('Tim','Horton','th@gmail.com','Tim0001#','requester',1234543245,'','NEWYORK');
--delete from usertable where email='vaishali@gmail.com';
--delete from usertable where email='jaya@gmail.com';
--Update usertable set city='santaclara' where email='James000#';
--Update usertable set notification ='' where email='tom@outlook.com';
--Update usertable set notification ='' where email='james@gmail.com';
--select * from usertable;


    