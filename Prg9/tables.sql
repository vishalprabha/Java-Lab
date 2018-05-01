create table tshirt (
	orderno int(50) primary key auto_increment,
	acc varchar(100) not null,
	tag varchar(100) not null,
	pocket int(1) not null,
	colour varchar(50) not null
);

alter table tshirt AUTO_INCREMENT = 100;
