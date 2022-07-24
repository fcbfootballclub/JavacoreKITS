use
master;
DROP
DATABASE IF EXISTS StockExchange;

Create
database StockExchange;
go

use StockExchange;
go

create table Trader
(
    sIDTrader  varchar(50) primary key not null,
    nameTrader varchar(50)
);
go

create table Stock
(
    sIDStock varchar(4) primary key
);
go


create table OrderType
(
    idType  int primary key identity(1,1),
    typeDes varchar(10)
);
go

create table OrderList
(
    orderID   int primary key identity(1,1),
    orderType int foreign key references OrderType(idType),
    sIDStock  varchar(4) foreign key references Stock(sIDStock),
    sIDTrader varchar(50) foreign key references Trader(sIDTrader),
    amount    int,
    price     float
);
go

create table TransactionList
(
    tranID    int primary key identity(1,1),
    idStock   varchar(4) foreign key references Stock(sIDStock),
    idBuyer   varchar(50) foreign key references Trader(sIDTrader),
    idSeller  varchar(50) foreign key references Trader(sIDTrader),
    amount    int,
    price     float,
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
select *
from Stock;
go

insert into OrderType values
('Mua'),
('Ban');
go

select *
from OrderType;
go

insert into Trader values
('TD1', 'A'),
('TD2', 'EA'),
('TD13', 'RA'),
('TD14', 'EA'),
('TD15', 'QA'),
('TD16', 'QA1'),
('TD17', 'QA2'),
('TD18', 'Dao'),
('TD19', 'Phuong'),
('TD20', 'Dola');
go

select *
from Trader;
select *
from OrderList;
select *
from TransactionList;
go

--Create store procedure

--Tổng số tiền giao dịch
create procedure pro_total_revenue
    as
begin
select sum(amount * price)
from TransactionList;
end;
go

exec pro_total_revenue;
go

select *
from TransactionList;
go

select *
from OrderList;
go

--Lấy ra danh sách cổ phiếu với tổng số tiền giao dịch tương ứng;
create procedure MaCP_Revenue
    as
begin
select idStock, sum(amount * price) as TotalValue
from TransactionList
group by idStock;
end;
go

exec MaCP_Revenue;
go

--Lấy ra danh sách cổ phiếu có số tiền giao dịch lớn nhất
create procedure danhSachCP_BestRevenue
    as
begin
select idStock, TotalValue
from (select idStock, sum(amount * price) as TotalValue from TransactionList group by idStock) as bang1
where TotalValue =
      (select max(TotalValue)
       from (select (sum(amount * price)) as TotalValue from TransactionList group by idStock) as tb1);
end;
go

exec danhSachCP_BestRevenue;
go


--Lấy ra danh sách những người mua nhiều cố phiếu nhất của từng mã cổ phiếu
create view SumValueByUserAndStock as
select idBuyer, idStock, sum(amount * price) as rev
from TransactionList
group by idStock, idBuyer;
go

create view maxValueByStock as
select idStock, max(rev) as maxRevenue
from (select idBuyer, idStock, sum(amount * price) as rev from TransactionList group by idStock, idBuyer) as tb
group by idStock;
go

create procedure MaxValueByTraderAndStock
    as
begin
select a.idBuyer, a.idStock, a.rev
from SumValueByUserAndStock a
         join maxValueByStock b on a.rev = b.maxRevenue;
end;
go

exec MaxValueByTraderAndStock;
go

select *
from Trader;
