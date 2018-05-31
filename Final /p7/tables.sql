create table phonebook (
	name varchar(50) not null, 
	phno bigint(50) primary key, 
	address varchar(50) not null, 
	company varchar(50) not null, 
	zipcode int(10) not null
);

insert into phonebook values ('Anisha' , 9036403321, 'Bangalore', 'LinkedIn', 560024 );
insert into phonebook values ('Amisha' , 8036403321, 'Mangalore', 'Google', 560024 );
insert into phonebook values ('Arjun' , 9036403322, 'Hyderabad', 'Amazon', 560024 );
insert into phonebook values ('Ayush' , 9036403323, 'Delhi', 'Flipkart', 560024 );
insert into phonebook values ('Anisha' , 9036403324, 'Mumbai', 'Facebook', 560024 );
insert into phonebook values ('Anna' , 7036403321, 'Gurgaon', 'Yahoo', 560024 );
insert into phonebook values ('Arianna' , 6036403321, 'Surat', 'Cognizant', 560024 );
insert into phonebook values ('Arjun' , 5036403321, 'Pilani', 'Swiggy', 560024 );
insert into phonebook values ('Anita' , 9036403325, 'Chennai', 'LinkedIn', 560024 );
insert into phonebook values ('Antony' , 9036403326, 'Mysore', 'LinkedIn', 560024 );
insert into phonebook values ('Alice' , 9036403327, 'Kochi', 'LinkedIn', 560024 );
