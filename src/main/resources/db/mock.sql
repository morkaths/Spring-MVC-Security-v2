-- Thêm dữ liệu mẫu cho bảng ngôn ngữ
INSERT INTO Language (LanguageID, Language) VALUES
('vi', 'Tiếng Việt'),
('en', 'English'),
('fr', 'Français'),
('ja', '日本語');

-- Thêm dữ liệu mẫu cho danh mục sản phẩm
INSERT INTO ProductCategory (CanBeShipped) VALUES
(1),
(0),
(1);

-- Thêm bản dịch cho danh mục sản phẩm
INSERT INTO ProductCategoryTranslation (ProductCategoryID, LanguageID, CategoryName) VALUES
(1, 'vi', 'Điện tử'),
(1, 'en', 'Electronics'),
(1, 'fr', 'Électronique'),
(1, 'ja', '電子機器'),
(2, 'vi', 'Thực phẩm'),
(2, 'en', 'Food'),
(2, 'fr', 'Nourriture'),
(2, 'ja', '食品'),
(3, 'vi', 'Thời trang'),
(3, 'en', 'Fashion'),
(3, 'fr', 'Mode'),
(3, 'ja', 'ファッション');

-- Thêm sản phẩm
INSERT INTO Product (Price, Weight, ProductCategoryID) VALUES
(1000000, 1.5, 1),
(50000, 0.5, 2),
(250000, 0.3, 3),
(15000000, 2.0, 1);

-- Thêm bản dịch cho sản phẩm
INSERT INTO ProductTranslation (ProductID, LanguageID, ProductName, ProductDescription) VALUES
(1, 'vi', 'Điện thoại', 'Điện thoại thông minh'),
(1, 'en', 'Smartphone', 'Smart mobile phone'),
(1, 'fr', 'Téléphone intelligent', 'Téléphone mobile intelligent'),
(1, 'ja', 'スマートフォン', 'スマートな携帯電話'),
(2, 'vi', 'Bánh mì', 'Bánh mì tươi'),
(2, 'en', 'Bread', 'Fresh bread'),
(2, 'fr', 'Pain', 'Pain frais'),
(2, 'ja', 'パン', '新鮮なパン'),
(3, 'vi', 'Áo sơ mi', 'Áo sơ mi thời trang'),
(3, 'en', 'Shirt', 'Fashion shirt'),
(3, 'fr', 'Chemise', 'Chemise à la mode'),
(3, 'ja', 'シャツ', 'ファッションシャツ'),
(4, 'vi', 'Laptop', 'Máy tính xách tay cao cấp'),
(4, 'en', 'Laptop', 'High-end laptop'),
(4, 'fr', 'Ordinateur portable', 'Ordinateur portable haut de gamme'),
(4, 'ja', 'ノートパソコン', '高級ノートパソコン');

-- Thêm role
INSERT INTO auth_role (code, name) VALUES ('ADMIN', 'Admin'), ('STAFF', 'Staff'), ('USER', 'User'), ('GUEST', 'Guest');

-- Thêm permission
INSERT INTO auth_permission (code, name) VALUES ('VIEW', 'View'), ('EDIT', 'Edit'), ('DELETE', 'Delete');

-- Gán quyền cho role
INSERT INTO auth_role_permission (role_id, permission_id) VALUES
(1, 1), (1, 2), (1, 3), -- ADMIN có VIEW, EDIT, DELETE
(2, 1);                 -- STAFF chỉ có VIEW

-- Thêm user (status 1 = active, 0 = inactive, 2 = locked)
INSERT INTO auth_user (username, password, email, status) VALUES
('admin', '12345', 'admin@email.com', 1),
('staff', '12345', 'staff@email.com', 1),
('user', '12345', 'user@email.com', 1);

-- Gán role cho user
INSERT INTO auth_user_role (user_id, role_id) VALUES
(1, 1), -- admin là ADMIN
(2, 2), -- staff là STAFF
(3, 3); -- user là USER