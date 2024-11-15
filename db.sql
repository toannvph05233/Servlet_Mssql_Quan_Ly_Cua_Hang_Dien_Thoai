use QLCHDD;

CREATE TABLE ChucVu (
                        MACV VARCHAR(5) NOT NULL,
                        TENCV NVARCHAR(50),
                        PRIMARY KEY (MACV)
);

CREATE TABLE CT_HDBH (
                         MAHDBH VARCHAR(10) NOT NULL,
                         MAMH VARCHAR(20) NOT NULL,
                         SL SMALLINT,
                         DONGIA INT,
                         MAKM VARCHAR(10),
                         THANHTIEN INT,
                         PRIMARY KEY (MAHDBH, MAMH)
);

CREATE TABLE CT_PNH (
                        MAPNH VARCHAR(10) NOT NULL,
                        MAMH VARCHAR(20) NOT NULL,
                        SL SMALLINT,
                        PRIMARY KEY (MAPNH, MAMH)
);

CREATE TABLE CT_PXH (
                        MAPXH VARCHAR(10) NOT NULL,
                        MAMH VARCHAR(20) NOT NULL,
                        SL SMALLINT,
                        PRIMARY KEY (MAPXH, MAMH)
);

CREATE TABLE HoaDonBanHang (
                               MAHDBH VARCHAR(10) NOT NULL,
                               NGAYLAP DATE,
                               MAKH VARCHAR(10),
                               MANV VARCHAR(10),
                               TONGTIEN INT,
                               PRIMARY KEY (MAHDBH)
);

CREATE TABLE KhachHang (
                           MAKH VARCHAR(10) NOT NULL,
                           TENKH NVARCHAR(50),
                           SDT VARCHAR(10),
                           PRIMARY KEY (MAKH)
);

CREATE TABLE Kho (
                     MAKHO VARCHAR(10) NOT NULL,
                     NVQuanLyKho VARCHAR(10) NOT NULL,
                     PRIMARY KEY (MAKHO, NVQuanLyKho)
);

CREATE TABLE KhuyenMai (
                           MAKM VARCHAR(10) NOT NULL,
                           TENKM NVARCHAR(50),
                           DieuKienApDung TEXT,
                           PRIMARY KEY (MAKM)
);

CREATE TABLE LoaiHang (
                          MALOAI VARCHAR(10) NOT NULL,
                          TENLOAI NVARCHAR(50),
                          PRIMARY KEY (MALOAI)
);

CREATE TABLE MatHang (
                         MAMH VARCHAR(20) NOT NULL,
                         TENMH NVARCHAR(50),
                         DONGIA INT,
                         MALOAI VARCHAR(10),
                         PRIMARY KEY (MAMH)
);

CREATE TABLE NhaCungCap (
                            MANCC VARCHAR(10) NOT NULL,
                            TENNCC NVARCHAR(50),
                            SDT VARCHAR(10),
                            DIACHI NVARCHAR(50),
                            PRIMARY KEY (MANCC)
);

CREATE TABLE NhanVien (
                          MANV VARCHAR(10) NOT NULL,
                          TENNV NVARCHAR(50),
                          CMND VARCHAR(12),
                          DIACHI NVARCHAR(50),
                          SDT VARCHAR(10),
                          MACV VARCHAR(5),
                          PRIMARY KEY (MANV)
);

CREATE TABLE PhieuNhapHang (
                               MAPNH VARCHAR(10) NOT NULL,
                               NGAYLAP DATE,
                               MANCC VARCHAR(10),
                               MAKHO VARCHAR(10),
                               NVQuanLyKho VARCHAR(10),
                               PRIMARY KEY (MAPNH)
);

CREATE TABLE PhieuXuatHang (
                               MAPXH VARCHAR(10) NOT NULL,
                               NGAYLAP DATE,
                               MAKHO VARCHAR(10),
                               NVQuanLyKho VARCHAR(10),
                               MACH VARCHAR(10),
                               PRIMARY KEY (MAPXH)
);

CREATE TABLE TaiKhoan (
                          MATK VARCHAR(10) NOT NULL,
                          PASSWORD VARCHAR(20),
                          PRIMARY KEY (MATK)
);

CREATE TABLE TheThanhVien (
                              HANSD DATE,
                              MAKH VARCHAR(10) NOT NULL,
                              PRIMARY KEY (MAKH)
);
-- Insert into ChucVu table
INSERT INTO ChucVu (MACV, TENCV) VALUES ('NV', 'Nhân Viên');
INSERT INTO ChucVu (MACV, TENCV) VALUES ('QLCH', 'Quản Lí Cửa Hàng');
INSERT INTO ChucVu (MACV, TENCV) VALUES ('QLK', 'Quản Lí Kho');

-- Insert into CT_HDBH table
INSERT INTO CT_HDBH (MAHDBH, MAMH, SL, DONGIA, MAKM, THANHTIEN)
VALUES ('HD001', 'AWSE40', 5, 400, NULL, 2000);
INSERT INTO CT_HDBH (MAHDBH, MAMH, SL, DONGIA, MAKM, THANHTIEN)
VALUES ('HD001', 'IP11P64', 10, 449, NULL, 4490);
INSERT INTO CT_HDBH (MAHDBH, MAMH, SL, DONGIA, MAKM, THANHTIEN)
VALUES ('HD001', 'MACP13M18512', 10, 2400, NULL, 24000);
INSERT INTO CT_HDBH (MAHDBH, MAMH, SL, DONGIA, MAKM, THANHTIEN)
VALUES ('HD002', 'AWSE44', 4, 450, NULL, 1800);
INSERT INTO CT_HDBH (MAHDBH, MAMH, SL, DONGIA, MAKM, THANHTIEN)
VALUES ('HD002', 'IPADP12', 2, 790, NULL, 1580);
INSERT INTO CT_HDBH (MAHDBH, MAMH, SL, DONGIA, MAKM, THANHTIEN)
VALUES ('HD002', 'MACP13M18512', 10, 2400, NULL, 24000);
INSERT INTO CT_HDBH (MAHDBH, MAMH, SL, DONGIA, MAKM, THANHTIEN)
VALUES ('HD003', 'IPXS64', 20, 479, NULL, 9580);

-- Insert into HoaDonBanHang table
INSERT INTO HoaDonBanHang (MAHDBH, NGAYLAP, MAKH, MANV, TONGTIEN)
VALUES ('HD001', DATE('2024-06-02'), NULL, 'NV01', 30490);
INSERT INTO HoaDonBanHang (MAHDBH, NGAYLAP, MAKH, MANV, TONGTIEN)
VALUES ('HD002', DATE('2020-03-01'), 'KH02', 'NV02', 27380);
INSERT INTO HoaDonBanHang (MAHDBH, NGAYLAP, MAKH, MANV, TONGTIEN)
VALUES ('HD003', DATE('2024-05-30'), NULL, 'NV04', 9580);

-- Insert into KhachHang table
INSERT INTO KhachHang (MAKH, TENKH, SDT)
VALUES ('KH02', 'Trần Châu Khoa', '0934165224');
INSERT INTO KhachHang (MAKH, TENKH, SDT)
VALUES ('KH03', 'Lê Hải Long', '0543206461');
INSERT INTO KhachHang (MAKH, TENKH, SDT)
VALUES ('KH04', 'Trần Ngọc Bảo', '0389093173');
INSERT INTO KhachHang (MAKH, TENKH, SDT)
VALUES ('KH05', 'Lý Ngọc Trân', '0406327919');
INSERT INTO KhachHang (MAKH, TENKH, SDT)
VALUES ('KH06', 'Hồ Quốc Vương', '0412336718');
INSERT INTO KhachHang (MAKH, TENKH, SDT)
VALUES ('KH07', 'Vương Hoàng Hậu', '0423057652');
INSERT INTO KhachHang (MAKH, TENKH, SDT)
VALUES ('KH08', 'Đặng Hoàng Tuấn', '0733319741');
INSERT INTO KhachHang (MAKH, TENKH, SDT)
VALUES ('KH09', 'Đỗ Ngọc Thuận', '0144650912');
INSERT INTO KhachHang (MAKH, TENKH, SDT)
VALUES ('KH10', 'Lý Tiểu Thần', '0475023203');
INSERT INTO KhachHang (MAKH, TENKH, SDT)
VALUES ('KH11', 'Vi Tieu Bao', '0123456789');

-- Insert into Kho table
INSERT INTO Kho (MAKHO, NVQuanLyKho) VALUES ('K01', 'NV02');
INSERT INTO Kho (MAKHO, NVQuanLyKho) VALUES ('K02', 'NV03');

-- Insert into LoaiHang table
INSERT INTO LoaiHang (MALOAI, TENLOAI) VALUES ('AW', 'Apple Watch');
INSERT INTO LoaiHang (MALOAI, TENLOAI) VALUES ('DD', 'Di Động');
INSERT INTO LoaiHang (MALOAI, TENLOAI) VALUES ('IPAD', 'Ipad');
INSERT INTO LoaiHang (MALOAI, TENLOAI) VALUES ('MAC', 'Macbook');
INSERT INTO LoaiHang (MALOAI, TENLOAI) VALUES ('PK', 'Phụ Kiện');

-- Insert into MatHang table
INSERT INTO MatHang (MAMH, TENMH, DONGIA, MALOAI)
VALUES ('AW544', 'Apple Watch Series 5 44mm', 400, 'AW');
INSERT INTO MatHang (MAMH, TENMH, DONGIA, MALOAI)
VALUES ('AW640', 'Apple Watch Series 6 40mm', 500, 'AW');
INSERT INTO MatHang (MAMH, TENMH, DONGIA, MALOAI)
VALUES ('AW644', 'Apple Watch Series 6 44mm', 600, 'AW');
INSERT INTO MatHang (MAMH, TENMH, DONGIA, MALOAI)
VALUES ('AWSE40', 'Apple Watch SE 40mm', 400, 'AW');
INSERT INTO MatHang (MAMH, TENMH, DONGIA, MALOAI)
VALUES ('AWSE44', 'Apple Watch SE 44mm', 450, 'AW');
-- (Continue with similar structure for other MatHang values)

-- Insert into NhaCungCap table
INSERT INTO NhaCungCap (MANCC, TENNCC, SDT, DIACHI)
VALUES ('NCC01', 'Đại Lý Ủy Quyền Apple Việt Nam', '1900 6886', 'Quận 1, TPHCM');
INSERT INTO NhaCungCap (MANCC, TENNCC, SDT, DIACHI)
VALUES ('NCC02', 'Công Ty Cung Cấp Linh Kiện', '0914930115', 'Phú Nhuận, TPHCM');

-- Insert into NhanVien table
INSERT INTO NhanVien (MANV, TENNV, CMND, DIACHI, SDT, MACV)
VALUES ('NV01', 'Nguyễn Thành Long', '026011882', 'Bình Chánh', '0902754112', 'QLCH');
-- (Continue with similar structure for other NhanVien values)

-- Insert into TaiKhoan table
INSERT INTO TaiKhoan (MATK, PASSWORD) VALUES ('NV01', '123456');
-- (Continue with similar structure for other TaiKhoan values)

-- Insert into TheThanhVien table
INSERT INTO TheThanhVien (HANSD, MAKH) VALUES (DATE('2020-03-12'), 'KH02');
-- (Continue with similar structure for other TheThanhVien values)

-- Adding Foreign Keys and Constraints (Relationship constraints remain the same)
ALTER TABLE CT_HDBH ADD CONSTRAINT FK_HoaDonBanHang FOREIGN KEY (MAHDBH) REFERENCES HoaDonBanHang (MAHDBH);

