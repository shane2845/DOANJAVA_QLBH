USE QLBanHang;
GO

-- =========================
-- BẢNG TÀI KHOẢN
-- =========================
CREATE TABLE TaiKhoan (
    MaTK INT IDENTITY(1,1) PRIMARY KEY,
    TenDangNhap VARCHAR(50) NOT NULL,
    MatKhau VARCHAR(50) NOT NULL,
    VaiTro VARCHAR(20) NOT NULL
);

-- =========================
-- BẢNG KHÁCH HÀNG
-- =========================
CREATE TABLE KhachHang (
    MaKH INT IDENTITY(1,1) PRIMARY KEY,
    TenKH NVARCHAR(100) NOT NULL,
    SDT VARCHAR(15),
    DiaChi NVARCHAR(200)
);

-- =========================
-- BẢNG SẢN PHẨM
-- =========================
CREATE TABLE SanPham (
    MaSP INT IDENTITY(1,1) PRIMARY KEY,
    TenSP NVARCHAR(100) NOT NULL,
    DonGia FLOAT NOT NULL,
    SoLuongTon INT NOT NULL
);

-- =========================
-- BẢNG HÓA ĐƠN
-- =========================
CREATE TABLE HoaDon (
    MaHD INT IDENTITY(1,1) PRIMARY KEY,
    MaKH INT NOT NULL,
    NgayLap DATE NOT NULL,
    TongTien FLOAT,

    CONSTRAINT FK_HoaDon_KhachHang
    FOREIGN KEY (MaKH)
    REFERENCES KhachHang(MaKH)
);

-- =========================
-- BẢNG CHI TIẾT HÓA ĐƠN
-- =========================
CREATE TABLE ChiTietHoaDon (
    MaHD INT NOT NULL,
    MaSP INT NOT NULL,
    SoLuong INT NOT NULL,
    DonGia FLOAT NOT NULL,

    PRIMARY KEY (MaHD, MaSP),

    CONSTRAINT FK_CTHD_HoaDon
    FOREIGN KEY (MaHD)
    REFERENCES HoaDon(MaHD),

    CONSTRAINT FK_CTHD_SanPham
    FOREIGN KEY (MaSP)
    REFERENCES SanPham(MaSP)
);

-- =========================
-- DỮ LIỆU MẪU TÀI KHOẢN
-- =========================
INSERT INTO TaiKhoan
(TenDangNhap, MatKhau, VaiTro)
VALUES
('admin','123','Admin'),
('nhanvien','123','NhanVien');

-- =========================
-- DỮ LIỆU MẪU KHÁCH HÀNG
-- =========================
INSERT INTO KhachHang
(TenKH, SDT, DiaChi)
VALUES
(N'Nguyễn Văn A','0988888888',N'Hà Nội'),
(N'Trần Thị B','0977777777',N'Hải Phòng'),
(N'Lê Văn C','0966666666',N'Hồ Chí Minh');

-- =========================
-- DỮ LIỆU MẪU SẢN PHẨM
-- =========================
INSERT INTO SanPham
(TenSP, DonGia, SoLuongTon)
VALUES
(N'Bàn phím cơ',500000,20),
(N'Chuột Gaming',300000,15),
(N'Tai nghe Bluetooth',800000,10),
(N'Màn hình 24 inch',2500000,5),
(N'Laptop Dell',15000000,3);

-- =========================
-- DỮ LIỆU MẪU HÓA ĐƠN
-- =========================
INSERT INTO HoaDon
(MaKH, NgayLap, TongTien)
VALUES
(1, GETDATE(), 1300000),
(2, GETDATE(), 300000);

-- =========================
-- DỮ LIỆU MẪU CHI TIẾT HÓA ĐƠN
-- =========================
INSERT INTO ChiTietHoaDon
(MaHD, MaSP, SoLuong, DonGia)
VALUES
(1,1,1,500000),
(1,3,1,800000),
(2,2,1,300000);