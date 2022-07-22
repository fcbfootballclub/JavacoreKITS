
use master;
DROP DATABASE IF EXISTS StockExchange;

Create database StockExchange;
go
use StockExchange;
go
create table Trader(
sIDTrader varchar(50) primary key not null,
nameTrader varchar(50)
);
go

create table Stock(
sIDStock varchar(4) primary key
);
go


create table OrderType(
idType int primary key identity(1,1),
typeDes varchar(10)
);
go

create table OrderList(
orderID int primary key identity(1,1),
orderType int foreign key references OrderType(idType),
sIDStock varchar(4) foreign key references Stock(sIDStock),
sIDTrader varchar(50) foreign key references Trader(sIDTrader),
amount int,
price float
);
go

create table TransactionList(
tranID int primary key identity(1,1),
idStock varchar(4) foreign key references Stock(sIDStock),
idBuyer varchar(50) foreign key references Trader(sIDTrader),
idSeller varchar(50) foreign key references Trader(sIDTrader),
amount int,
price float,
orderDate date
);
go

-- Insert demo data to the list
insert into Stock values 
('VCB'),
('SHB'),
('VIN'),
('SAM'),
('FPT'),
('VNPT');
select * from Stock;

insert into OrderType values 
('Mua'),
('Ban');

select * from OrderType;
go
insert into Trader values
('TD1', 'A'),
('TD2', 'EA'),
('TD13', 'RA'),
('TD14', 'EA'),
('TD15', 'QA');

select * from Trader;
select * from OrderList;
select * from TransactionList;
