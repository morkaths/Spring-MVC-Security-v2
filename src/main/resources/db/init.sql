-- Create database
CREATE DATABASE IF NOT EXISTS multilang;
USE multilang;

-- Drop tables if exist (for clean setup)
DROP TABLE IF EXISTS auth_user_role;
DROP TABLE IF EXISTS auth_role_permission;
DROP TABLE IF EXISTS product_translation;
DROP TABLE IF EXISTS product_category_translation;
DROP TABLE IF EXISTS product;
DROP TABLE IF EXISTS product_category;
DROP TABLE IF EXISTS auth_user;
DROP TABLE IF EXISTS auth_role;
DROP TABLE IF EXISTS auth_permission;
DROP TABLE IF EXISTS language;

-- Create Language table
CREATE TABLE language (
    LanguageID BIGINT AUTO_INCREMENT PRIMARY KEY,
    Code VARCHAR(10) NOT NULL UNIQUE,
    Name VARCHAR(100) NOT NULL,
    IsDefault BOOLEAN DEFAULT FALSE,
    Status INT NOT NULL DEFAULT 1,
    CreatedDate DATETIME DEFAULT CURRENT_TIMESTAMP,
    UpdatedDate DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- Create AuthPermission table
CREATE TABLE auth_permission (
    UserPermissionID BIGINT AUTO_INCREMENT PRIMARY KEY,
    Code VARCHAR(100) NOT NULL UNIQUE,
    Name VARCHAR(255) NOT NULL,
    CreatedDate DATETIME DEFAULT CURRENT_TIMESTAMP,
    UpdatedDate DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- Create AuthRole table
CREATE TABLE auth_role (
    RoleID BIGINT AUTO_INCREMENT PRIMARY KEY,
    Code VARCHAR(100) NOT NULL UNIQUE,
    Name VARCHAR(255) NOT NULL,
    CreatedDate DATETIME DEFAULT CURRENT_TIMESTAMP,
    UpdatedDate DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- Create AuthUser table
CREATE TABLE auth_user (
    UserID BIGINT AUTO_INCREMENT PRIMARY KEY,
    Username VARCHAR(255) NOT NULL UNIQUE,
    Password VARCHAR(255) NOT NULL,
    Email VARCHAR(255) NOT NULL UNIQUE,
    FullName VARCHAR(255),
    Status INT NOT NULL DEFAULT 1,
    CreatedDate DATETIME DEFAULT CURRENT_TIMESTAMP,
    UpdatedDate DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- Create ProductCategory table
CREATE TABLE product_category (
    CategoryID BIGINT AUTO_INCREMENT PRIMARY KEY,
    Code VARCHAR(100) NOT NULL UNIQUE,
    DefaultName VARCHAR(255) NOT NULL,
    Status INT NOT NULL DEFAULT 1,
    CreatedDate DATETIME DEFAULT CURRENT_TIMESTAMP,
    UpdatedDate DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- Create Product table
CREATE TABLE product (
    ProductID BIGINT AUTO_INCREMENT PRIMARY KEY,
    Code VARCHAR(100) NOT NULL UNIQUE,
    DefaultName VARCHAR(255) NOT NULL,
    Price DECIMAL(10,2) NOT NULL,
    CategoryID BIGINT,
    Status INT NOT NULL DEFAULT 1,
    CreatedDate DATETIME DEFAULT CURRENT_TIMESTAMP,
    UpdatedDate DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (CategoryID) REFERENCES product_category(CategoryID)
);

-- Create junction tables
CREATE TABLE auth_user_role (
    UserID BIGINT,
    RoleID BIGINT,
    PRIMARY KEY (UserID, RoleID),
    FOREIGN KEY (UserID) REFERENCES auth_user(UserID) ON DELETE CASCADE,
    FOREIGN KEY (RoleID) REFERENCES auth_role(RoleID) ON DELETE CASCADE
);

CREATE TABLE auth_role_permission (
    RoleID BIGINT,
    PermissionID BIGINT,
    PRIMARY KEY (RoleID, PermissionID),
    FOREIGN KEY (RoleID) REFERENCES auth_role(RoleID) ON DELETE CASCADE,
    FOREIGN KEY (PermissionID) REFERENCES auth_permission(UserPermissionID) ON DELETE CASCADE
);

-- Create translation tables with composite keys
CREATE TABLE product_category_translation (
    CategoryID BIGINT,
    LanguageID BIGINT,
    Name VARCHAR(255) NOT NULL,
    Description TEXT,
    PRIMARY KEY (CategoryID, LanguageID),
    FOREIGN KEY (CategoryID) REFERENCES product_category(CategoryID) ON DELETE CASCADE,
    FOREIGN KEY (LanguageID) REFERENCES language(LanguageID) ON DELETE CASCADE
);

CREATE TABLE product_translation (
    ProductID BIGINT,
    LanguageID BIGINT,
    Name VARCHAR(255) NOT NULL,
    Description TEXT,
    PRIMARY KEY (ProductID, LanguageID),
    FOREIGN KEY (ProductID) REFERENCES product(ProductID) ON DELETE CASCADE,
    FOREIGN KEY (LanguageID) REFERENCES language(LanguageID) ON DELETE CASCADE
);