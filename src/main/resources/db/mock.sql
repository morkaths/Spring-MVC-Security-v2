-- Insert mock data
-- Languages
INSERT INTO language (LanguageID, Language) VALUES
('en', 'English'),
('vi', 'Tiếng Việt'),
('fr', 'Français'),
('es', 'Español'),
('ja', '日本語');

-- Permissions
INSERT INTO auth_permission (Code, Name) VALUES
('USER:READ', 'Read Users'),
('USER:WRITE', 'Write Users'),
('USER:DELETE', 'Delete Users'),
('PRODUCT:READ', 'Read Products'),
('PRODUCT:WRITE', 'Write Products'),
('PRODUCT:DELETE', 'Delete Products'),
('CATEGORY:READ', 'Read Categories'),
('CATEGORY:WRITE', 'Write Categories'),
('CATEGORY:DELETE', 'Delete Categories'),
('ADMIN:PANEL', 'Access Admin Panel'),
('SYSTEM:CONFIG', 'System Configuration');

-- Roles
INSERT INTO auth_role (Code, Name) VALUES
('ADMIN', 'Administrator'),
('USER', 'Regular User'),
('MANAGER', 'Manager'),
('EDITOR', 'Content Editor'),
('VIEWER', 'Read Only User');

-- Users (password: 123456 - BCrypt hash)
INSERT INTO auth_user (Username, Password, Email, FullName, Status) VALUES
('admin',   '$2a$10$92IXUNpkjO0rOQ5byMi.Ye4oKoEa3Ro9llC/.og/at2uheWG/igi.', 'admin@example.com',   'System Administrator', 1),
('user',    '$2a$10$92IXUNpkjO0rOQ5byMi.Ye4oKoEa3Ro9llC/.og/at2uheWG/igi.', 'user@example.com',    'Regular User',         1),
('manager', '$2a$10$92IXUNpkjO0rOQ5byMi.Ye4oKoEa3Ro9llC/.og/at2uheWG/igi.', 'manager@example.com', 'Manager',              1),
('editor',  '$2a$10$92IXUNpkjO0rOQ5byMi.Ye4oKoEa3Ro9llC/.og/at2uheWG/igi.', 'editor@example.com',  'Content Editor',       1),
('viewer',  '$2a$10$92IXUNpkjO0rOQ5byMi.Ye4oKoEa3Ro9llC/.og/at2uheWG/igi.', 'viewer@example.com',  'Read Only User',       1);

-- Product Categories
INSERT INTO product_category (CanBeShipped) VALUES
(TRUE), -- Electronics
(TRUE), -- Clothing
(TRUE), -- Books
(TRUE), -- Sports
(TRUE), -- Home
(TRUE); -- Food

-- Products
INSERT INTO product (Price, Weight, ProductCategoryID) VALUES
(1500.00, 2.5, 1),  -- Gaming Laptop
(800.00, 0.4, 1),   -- Smartphone
(300.00, 0.5, 1),   -- Tablet
(20.00, 0.3, 2),    -- T-Shirt
(40.00, 0.7, 2),    -- Jeans
(15.00, 0.2, 3),    -- Novel Book
(25.00, 0.4, 3),    -- Programming Book
(50.00, 1.0, 4),    -- Football
(700.00, 14.0, 4),  -- Mountain Bike
(120.00, 10.0, 5),  -- Office Chair
(30.00, 1.5, 6),    -- Coffee Maker
(10.00, 0.5, 6);    -- Organic Tea 

-- User-Role assignments
INSERT INTO auth_user_role (UserID, RoleID) VALUES
(1, 1), -- admin -> ADMIN
(2, 2), -- user -> USER
(3, 3), -- manager -> MANAGER
(4, 4), -- editor -> EDITOR
(5, 5); -- viewer -> VIEWER

-- Role-Permission assignments
INSERT INTO auth_role_permission (RoleID, PermissionID) VALUES
-- ADMIN has all permissions
(1, 1), (1, 2), (1, 3), (1, 4), (1, 5), (1, 6), (1, 7), (1, 8), (1, 9), (1, 10), (1, 11),
-- USER has basic read permissions
(2, 1), (2, 4), (2, 7),
-- MANAGER has read/write permissions
(3, 1), (3, 2), (3, 4), (3, 5), (3, 7), (3, 8), (3, 10),
-- EDITOR has content permissions
(4, 4), (4, 5), (4, 7), (4, 8),
-- VIEWER has only read permissions
(5, 1), (5, 4), (5, 7);

-- Product Category Translations
INSERT INTO product_category_translation (ProductCategoryID, LanguageID, CategoryName) VALUES
-- Electronics
(1, "en", 'Electronics'),
(1, "vi", 'Thiết bị điện tử'),
(1, "fr", 'Électronique'),
(1, "es", 'Electrónica'),
(1, "ja", '電子機器'),
-- Clothing
(2, "en", 'Clothing'),
(2, "vi", 'Quần áo'),
(2, "fr", 'Vêtements'),
(2, "es", 'Ropa'),
(2, "ja", '衣類'),
-- Books
(3, "en", 'Books'),
(3, "vi", 'Sách'),
(3, "fr", 'Livres'),
(3, "es", 'Libros'),
(3, "ja", '本'),
-- Sports
(4, "en", 'Sports'),
(4, "vi", 'Thể thao'),
(4, "fr", 'Sports'),
(4, "es", 'Deportes'),
(4, "ja", 'スポーツ'),
-- Home
(5, "en", 'Home'),
(5, "vi", 'Nhà cửa'),
(5, "fr", 'Maison'),
(5, "es", 'Hogar'),
(5, "ja", 'ホーム'),
-- Food
(6, "en", 'Food'),
(6, "vi", 'Thực phẩm'),
(6, "fr", 'Nourriture'),
(6, "es", 'Comida'),
(6, "ja", '食べ物');

-- Product Translations
INSERT INTO product_translation (ProductID, LanguageID, ProductName, ProductDescription) VALUES
-- Gaming Laptop
(1, "en", 'Gaming Laptop Pro', 'High-performance laptop designed for gaming enthusiasts'),
(1, "vi", 'Laptop Gaming Pro', 'Laptop hiệu suất cao dành cho game thủ chuyên nghiệp'),
(1, "fr", 'Ordinateur Portable Gaming Pro', 'Ordinateur portable haute performance conçu pour les passionnés de jeux'),
(1, "es", 'Portátil para Juegos Pro', 'Portátil de alto rendimiento diseñado para entusiastas de los juegos'),
(1, "ja", 'ゲーミングラップトッププロ', 'ゲーマー向けに設計された高性能ラップトップ'),
-- Smartphone
(2, "en", 'Smartphone X', 'Latest smartphone with cutting-edge features'),
(2, "vi", 'Điện thoại thông minh X', 'Điện thoại thông minh mới nhất với các tính năng tiên tiến'),
(2, "fr", 'Smartphone X', 'Dernier smartphone avec des fonctionnalités de pointe'),
(2, "es", 'Smartphone X', 'El último smartphone con características de vanguardia'),
(2, "ja", 'スマートフォンX', '最先端の機能を備えた最新のスマートフォン'),
-- Tablet
(3, "en", 'Tablet Z', 'Lightweight tablet perfect for on-the-go use'),
(3, "vi", 'Máy tính bảng Z', 'Máy tính bảng nhẹ hoàn hảo cho việc sử dụng khi di chuyển'),
(3, "fr", 'Tablette Z', 'Tablette légère parfaite pour une utilisation en déplacement'),
(3, "es", 'Tableta Z', 'Tableta ligera perfecta para uso en movimiento'),
(3, "ja", 'タブレットZ', '外出先での使用に最適な軽量タブレット'),
-- T-Shirt
(4, "en", 'Classic T-Shirt', 'Comfortable cotton t-shirt available in various sizes'),
(4, "vi", 'Áo thun cổ điển', 'Áo thun cotton thoải mái có sẵn trong nhiều kích cỡ'),
(4, "fr", 'T-Shirt Classique', 'T-shirt en coton confortable disponible en plusieurs tailles'),
(4, "es", 'Camiseta Clásica', 'Camiseta de algodón cómoda disponible en varias tallas'),
(4, "ja", 'クラシックTシャツ', 'さまざまなサイズで利用可能な快適なコットンTシャツ'),
-- Jeans
(5, "en", 'Denim Jeans', 'Stylish denim jeans with a comfortable fit'),
(5, "vi", 'Quần jean denim', 'Quần jean denim thời trang với kiểu dáng thoải mái'),
(5, "fr", 'Jeans en Denim', 'Jeans en denim élégants avec une coupe confortable'),
(5, "es", 'Jeans de Mezclilla', 'Jeans de mezclilla elegantes con un ajuste cómodo'),
(5, "ja", 'デニムジーンズ', '快適なフィット感のあるスタイリッシュなデニムジーンズ'),
-- Novel Book
(6, "en", 'Mystery Novel', 'A thrilling mystery novel that keeps you on the edge of your seat'),
(6, "vi", 'Tiểu thuyết bí ẩn', 'Một cuốn tiểu thuyết bí ẩn ly kỳ khiến bạn hồi hộp'),
(6, "fr", 'Roman Mystère', 'Un roman mystérieux passionnant qui vous tient en haleine'),
(6, "es", 'Novela de Misterio', 'Una emocionante novela de misterio que te mantiene al borde de tu asiento'),
(6, "ja", 'ミステリーノベル', 'あなたを座席の端に保つスリリングなミステリーノベル'),
-- Programming Book
(7, "en", 'Learn Programming', 'Comprehensive guide to learning programming languages'),
(7, "vi", 'Học lập trình', 'Hướng dẫn toàn diện để học các ngôn ngữ lập trình'),
(7, "fr", 'Apprendre la Programmation', 'Guide complet pour apprendre les langages de programmation'),
(7, "es", 'Aprender Programación', 'Guía completa para aprender lenguajes de programación'),
(7, "ja", 'プログラミングを学ぶ', 'プログラミング言語を学ぶための包括的なガイド'),
-- Football
(8, "en", 'Professional Football', 'High-quality football for professional matches'),
(8, "vi", 'Bóng đá chuyên nghiệp', 'Bóng đá chất lượng cao cho các trận đấu chuyên nghiệp'),
(8, "fr", 'Football Professionnel', 'Football de haute qualité pour les matchs professionnels'),
(8, "es", 'Fútbol Profesional', 'Fútbol de alta calidad para partidos profesionales'),
(8, "ja", 'プロフェッショナルフットボール', 'プロの試合のための高品質のフットボール'),
-- Mountain Bike
(9, "en", 'Mountain Bike', 'Durable mountain bike suitable for all terrains'),
(9, "vi", 'Xe đạp địa hình', 'Xe đạp địa hình bền bỉ phù hợp với mọi địa hình'),
(9, "fr", 'Vélo de Montagne', 'Vélo de montagne durable adapté à tous les terrains'),
(9, "es", 'Bicicleta de Montaña', 'Bicicleta de montaña duradera adecuada para todos los terrenos'),
(9, "ja", 'マウンテンバイク', 'あらゆる地形に適した耐久性のあるマウンテンバイク'),
-- Office Chair
(10, "en", 'Ergonomic Office Chair', 'Comfortable office chair with ergonomic design'),
(10, "vi", 'Ghế văn phòng công thái học', 'Ghế văn phòng thoải mái với thiết kế công thái học'),
(10, "fr", 'Chaise de Bureau Ergonomique', 'Chaise de bureau confortable avec un design ergonomique'),
(10, "es", 'Silla de Oficina Ergonómica', 'Silla de oficina cómoda con diseño ergonómico'),
(10, "ja", '人間工学に基づいたオフィスチェア', '人間工学に基づいた快適なオフィスチェア'),
-- Coffee Maker
(11, "en", 'Coffee Maker', 'Automatic coffee maker with programmable settings'),
(11, "vi", 'Máy pha cà phê', 'Máy pha cà phê tự động với các cài đặt lập trình được'),
(11, "fr", 'Cafetière', 'Cafetière automatique avec paramètres programmables'),
(11, "es", 'Cafetera', 'Cafetera automática con configuraciones programables'),
(11, "ja", 'コーヒーメーカー', 'プログラム可能な設定を備えた自動コーヒーメーカー'),
-- Organic Tea
(12, "en", 'Organic Tea', 'Refreshing organic tea with natural flavors'),
(12, "vi", 'Trà hữu cơ', 'Trà hữu cơ sảng khoái với hương vị tự nhiên'),
(12, "fr", 'Thé Biologique', 'Thé biologique rafraîchissant aux saveurs naturelles'),
(12, "es", 'Té Orgánico', 'Té orgánico refrescante con sabores naturales'),
(12, "ja", 'オーガニックティー', '自然な風味のリフレッシュオーガニックティー');

-- Create indexes for better performance
CREATE INDEX idx_auth_user_username ON auth_user(Username);
CREATE INDEX idx_product_category_canbeshipped ON product_category(CanBeShipped);
CREATE INDEX idx_product_price ON product(Price);
CREATE INDEX idx_product_categoryid ON product(ProductCategoryID);
CREATE INDEX idx_auth_role_code ON auth_role(Code);
CREATE INDEX idx_auth_permission_code ON auth_permission(Code);
CREATE INDEX idx_language_code ON language(Language);