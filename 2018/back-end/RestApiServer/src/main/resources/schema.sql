CREATE table IF NOT EXISTS company(
	companyId int primary key, 
	companyName varchar(30),
	jobCategoryLevel1 varchar(2),
	jobCategoryLevel2 varchar(2),
	registDate date,
	registUser varchar(10),
	updateDate date,
	updateUser varchar(10)
);
