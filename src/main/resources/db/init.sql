-- Tạo database
CREATE DATABASE IF NOT EXISTS multilang;
USE multilang;

-- Bảng ngôn ngữ
CREATE TABLE Language (
    LanguageID CHAR(2) PRIMARY KEY,
    Language VARCHAR(20) NOT NULL
);

-- Bảng danh mục sản phẩm
CREATE TABLE ProductCategory (
    ProductCategoryID INT PRIMARY KEY AUTO_INCREMENT,
    CanBeShipped BIT NOT NULL
);

-- Bảng sản phẩm
CREATE TABLE Product (
    ProductID INT PRIMARY KEY AUTO_INCREMENT,
    Price DECIMAL(10,2) NOT NULL,
    Weight DECIMAL(4,2),
    ProductCategoryID INT,
    FOREIGN KEY (ProductCategoryID) REFERENCES ProductCategory(ProductCategoryID)
        ON DELETE SET NULL
        ON UPDATE CASCADE
);

-- Bảng bản dịch cho sản phẩm
CREATE TABLE ProductTranslation (
    ProductID INT,
    LanguageID CHAR(2),
    ProductName VARCHAR(100),
    ProductDescription VARCHAR(100),
    PRIMARY KEY (ProductID, LanguageID),
    FOREIGN KEY (ProductID) REFERENCES Product(ProductID)
        ON DELETE CASCADE
        ON UPDATE CASCADE,
    FOREIGN KEY (LanguageID) REFERENCES Language(LanguageID)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);

-- Bảng bản dịch cho danh mục sản phẩm
CREATE TABLE ProductCategoryTranslation (
    ProductCategoryID INT,
    LanguageID CHAR(2),
    CategoryName VARCHAR(100),
    PRIMARY KEY (ProductCategoryID, LanguageID),
    FOREIGN KEY (ProductCategoryID) REFERENCES ProductCategory(ProductCategoryID)
        ON DELETE CASCADE
        ON UPDATE CASCADE,
    FOREIGN KEY (LanguageID) REFERENCES Language(LanguageID)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);

-- Bảng user
CREATE TABLE auth_user (
    id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    status INT DEFAULT 1
);

-- Bảng role
CREATE TABLE auth_role (
    id INT PRIMARY KEY AUTO_INCREMENT,
    code VARCHAR(50) NOT NULL UNIQUE,
    name VARCHAR(100) NOT NULL
);

-- Bảng permission
CREATE TABLE auth_permission (
    id INT PRIMARY KEY AUTO_INCREMENT,
    code VARCHAR(50) NOT NULL UNIQUE,
    name VARCHAR(100) NOT NULL
);

-- Bảng liên kết user-role
CREATE TABLE auth_user_role (
    user_id INT,
    role_id INT,
    PRIMARY KEY (user_id, role_id),
    FOREIGN KEY (user_id) REFERENCES auth_user(id) ON DELETE CASCADE,
    FOREIGN KEY (role_id) REFERENCES auth_role(id) ON DELETE CASCADE
);

-- Bảng liên kết role-permission
CREATE TABLE auth_role_permission (
    role_id INT,
    permission_id INT,
    PRIMARY KEY (role_id, permission_id),
    FOREIGN KEY (role_id) REFERENCES auth_role(id) ON DELETE CASCADE,
    FOREIGN KEY (permission_id) REFERENCES auth_permission(id) ON DELETE CASCADE
);