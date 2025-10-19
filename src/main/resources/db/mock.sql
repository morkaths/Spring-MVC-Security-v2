-- Insert roles
INSERT INTO roles (code, name) VALUES
('ADMIN', 'Admin'),
('STAFF', 'Staff'),
('USER', 'User'),
('GUEST', 'Guest');

-- Insert users
INSERT INTO users (username, password, email, status) VALUES
('admin', '12345', 'admin@email.com', 1),
('staff', '12345', 'staff@email.com', 1),
('user', '12345', 'user@email.com', 1);

-- Assign roles to users
INSERT INTO user_roles (user_id, role_id) VALUES
(1, 1), -- admin is ADMIN
(2, 2), -- staff is STAFF
(3, 3); -- user is USER