create database QLKhachSan;
Go
use QLKhachSan;
GO
create table Nhanvien(
	MaNV nvarchar(50) primary key not null,
	TenNV nvarchar(255) not null,
	MatKhau nvarchar(50) not null,
	VaiTro bit not null,
);


create table LoaiPhong(
	MaLP nvarchar(50) primary key not null,
	Soluong int not null,
	TenLoai nvarchar(255) not null ,
	Gia float not null
);

create table Phong(
	MaP nvarchar(50) primary key not null,
	TenPhong nvarchar(255) not null ,
	MaLP nvarchar(50) not null,	
	CONSTRAINT fk_P_LP FOREIGN KEY (MaLP) REFERENCES LoaiPhong(MaLP)
);

create table DichVu(
	MaDV nvarchar(50) primary key not null,
	TenDV nvarchar(255) not null,
	Gia float not null
);
create table KhachHang(
	MaKH nvarchar(50) primary key not null,
	HoTen nvarchar (255) not null , 
	SDT nvarchar(50) not null ,
	Email nvarchar(255),
	CMND nvarchar(50) not null ,
	GioiTinh bit not null , 
)
create table CTPhongKhachHang(
	MaPKH nvarchar(50) primary key not null,
	SoNguoi int not null ,
	TongTien float not null,
	MaP nvarchar(50) not null ,
	MaKH nvarchar(50) not null ,
	constraint fk_PKH_KH foreign key (MaKH) references KhachHang(MaKH),
	constraint fk_PKH_P foreign key (MaP) references Phong(MaP),
);


create table ChiTietSDDV(
	MaSD nvarchar(50) primary key not null,
	MaDV nvarchar(50) not null,
	SoLanSD int not null,
	TongTien float not null,
	MaPKH nvarchar(50) not null,
	CONSTRAINT fk_CTSDDV_DV FOREIGN KEY (MaDV) REFERENCES DichVu(MaDV),
	CONSTRAINT fk_CTSDDV_PHK FOREIGN KEY (MaPKH) REFERENCES CTPhongKhachHang(MaPKH)
);

create table HoaDon(
	MaHD nvarchar(50) not null primary key,
	SoNgayThue int not null ,
	NgayTra date not null,
	TongTien float not null ,
	MaNV nvarchar(50) not null,
	MaPKH nvarchar(50) not null,
	TinhTrang nvarchar(255) not null,
	constraint fk_HD_NV foreign key (MaNV) references NhanVien(MaNV),
	constraint fk_HD_CTPKH foreign key (MaPKH) references CTPhongKhachHang(MaPKH)
);
GO
----TÌM KIẾM NHÂN VIÊN
CREATE PROC SP_Find_NV (@MaNV nvarchar(50))
AS 
	SELECT * FROM NhanVien WHERE MaNV=@MaNV
GO
----LẤY DỮ LIỆU NHÂN VIÊN------
CREATE PROC SP_GETDATA_NV 
AS
	SELECT * FROM NHANVIEN
GO

------LẤY DỮ LIỆU KHÁCH HÀNG----
CREATE PROC SP_GETDATA_KH 
AS 
SELECT * FROM KhachHang
GO
-----TÌM KIẾM KHÁCH HÀNG -----
CREATE PROC SP_Find_KH (@MaKH nvarchar(50))
AS 
	SELECT * FROM KhachHang WHERE MaKH=@MaKH
GO

-----LẤY DỮ LIỆU DỊCH VỤ-----
CREATE PROC SP_GETDATA_DV
AS 
	SELECT * FROM DichVu
GO
-----TÌM KIẾM DỊCH VỤ-----
CREATE PROC SP_Find_DV (@MaDV nvarchar(50))
AS 
	SELECT * FROM DichVu WHERE MaDV=@MaDV
GO


-----LẤY DỮ LIỆU CHI TIẾT SỬ DỤNG
CREATE PROC SP_GETDATA_CTSD 
AS
	SELECT * FROM ChiTietSDDV
GO
---- TÌM CHI TIẾT SỬ DỤNG -----
CREATE PROC SP_Find_CTSD  (@MaSD nvarchar(50))
AS 
	SELECT * FROM ChiTietSDDV WHERE MaSD=@MaSD
GO

----LẤY DỮ LIỆU LOẠI PHÒNG-----
CREATE PROC SP_GETDATA_LP
AS 
	SELECT * FROM LoaiPhong
GO
------TÌM KIẾM LOẠI PHÒNG---------
CREATE PROC SP_FIND_LP (@MaLP nvarchar(50))
AS 
	SELECT * FROM LoaiPhong WHERE MaLP= @MaLP
GO
-----LẤY DỮ LIỆU PHÒNG ----
CREATE PROC SP_GETDATA_P
AS 
	SELECT * FROM Phong
GO
----
CREATE PROC SP_GETDATA_PKH
AS
	SELECT * FROM CTPhongKhachHang
GO
-------
CREATE PROC SP_FIND_PKH (@MaPKH nvarchar(50))
AS
	SELECT * FROM CTPhongKhachHang WHERE MaPKH = @MaPKH
GO

CREATE PROC SP_GETDATA_HD
AS 
	SELECT * FROM HoaDon
GO
CREATE PROC SP_FIND_HD (@MaHD nvarchar(50))
AS 
	SELECT * FROM HoaDon WHERE MaHD = @MaHD
GO


CREATE PROC SP_THONGKE_DT(@nam int)
AS 
	SELECT 
	COUNT(hd.MaHD) TONGHOADON ,
	COUNT (pkh.MaKH) KHACHHANG,
	SUM(hd.TongTien) TONGTIEN ,
	@nam NAM
	FROM HoaDon hd join CTPhongKhachHang pkh on hd.MaPKH = pkh.MaPKH
	where YEAR(NgayTra) = @nam ;
go



INSERT INTO NhanVien values('NV01',N'Vòng hồng Hội',123456,1),('NV02','Bánh Bao',123,0);

INSERT INTO LoaiPhong values('LP01',4,N'Thường',500),('LP02',4,'VIP',700),('LP03',4,'VIP',1000);

INSERT INTO Phong values('P01',N'Phòng 01','LP01'),('P02',N'Phòng 02','LP01'),('P03',N'Phòng 03','LP01'),('P04',N'Phòng 04','LP01'),
('P05',N'Phòng 05','LP02'),('P06',N'Phòng 06','LP02'),('P07',N'Phòng 07','LP02'),('P08',N'Phòng 08','LP02'),
('P09',N'Phòng 09','LP03'),('P10',N'Phòng 11','LP03'),('P11',N'Phòng 11','LP03'),('P12',N'Phòng 12','LP03');

INSERT INTO DichVu values('DV01','Giặc ủi',200),('DV02','Đưa đón',300),('DV0','Spa',500);

INSERT INTO KhachHang values('KH01',N'Hội','312318949',N'vhonghoi@gmal.com','371831671273',1),
('KH02',N'Trí','312321321',N'Tri@gmail.com','5345435',1),
('KH03',N'Cương','3132132321',N'cuong@gmail.com','45445342',1);

INSERT INTO CTPhongKhachHang VALUES ('PKH01',4,1000,'P03','KH01'),
('PKH02',3,700,'P02','KH02'),('PKH03',2,500,'P03','KH03');


INSERT INTO ChiTietSDDV VALUES ('SD01','DV01',4,800,'PKH01'),('SD02','DV0',2,1000,'PKH01'),('SD03','DV02',1,300,'PKH02');

INSERT INTO HoaDon values ('HD01',4,'2021-11-10','6000','NV01','PKH01','Đã Thanh Toán'),('HD02',3,'2021-11-10','8000','NV02','PKH03','Chưa Thanh Toán');

