Create Table requesttable(
	requesterEmail varchar2(255),
	reqId varchar2(255) NOT NULL PRIMARY KEY,
    reqTitle varchar2(255) NOT NULL,
    reqDescription varchar2(800) NOT NULL,
    city varchar2(255) NOT NULL,
    zipcode varchar2(255) NOT NULL,
    fulladdress varchar2(800) NOT NULL,
    name varchar2(255) NOT NULL,
    phone varchar2(10) NOT NULL,
    FOREIGN KEY(requesterEmail) REFERENCES usertable(email)
   	ON DELETE CASCADE
   
);
--select * from requesttable;
--delete from REQUESTTABLE where requesterEmail='peter@gmail.com';
--
--update REQUESTTABLE set city='SEATTLE' where requesterEmail='dsmith@gmail.com';
--Select fulladdress from requesttable where reqId=1;
--
-- ON DELETE CASCADE

