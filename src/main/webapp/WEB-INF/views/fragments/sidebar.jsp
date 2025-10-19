<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="sidebar">
    <div class="sidebar-wrapper active">
        <div class="sidebar-header position-relative">
            <div class="d-flex justify-content-between align-items-center">
                <div class="logo">
                    <jsp:include page="logo.jsp" />
                </div>
                <div class="sidebar-toggler x">
                    <a href="#" class="sidebar-hide d-xl-none d-block"><i class="bi bi-x bi-middle"></i></a>
                </div>
            </div>
        </div>

        <div class="sidebar-menu">
            <ul class="menu">
                <li class="sidebar-title">Menu</li>

                <li class="sidebar-item">
                    <a href="<c:url value='/' />" class='sidebar-link' data-path="/">
                        <i class="bi bi-house-door-fill"></i>
                        <span>Trang chủ</span>
                    </a>
                </li>

                <li class="sidebar-item">
                    <a href="<c:url value='/categories' />" class='sidebar-link' data-path="/categories">
                        <i class="bi bi-tags-fill"></i>
                        <span>Danh mục</span>
                    </a>
                </li>

                <li class="sidebar-item">
                    <a href="<c:url value='/admin/dashboard' />" class='sidebar-link' data-path="/admin/dashboard">
                        <i class="bi bi-grid-fill"></i>
                        <span>Dashboard</span>
                    </a>
                </li>

                <li class="sidebar-item has-sub">
                    <a href="#" class='sidebar-link' data-path="/admin">
                        <i class="bi bi-tools"></i>
                        <span>Quản lý</span>
                    </a>
                    <ul class="submenu">
                        <li class="submenu-item">
                            <a href="<c:url value='/admin/categories' />" class="submenu-link" data-path="/admin/categories">
                                <i class="bi bi-tag"></i> 
                                Danh mục
                            </a>
                        </li>
                        <li class="submenu-item">
                            <a href="<c:url value='/admin/products' />" class="submenu-link" data-path="/admin/products">
                                <i class="bi bi-box"></i> 
                                Sản phẩm
                            </a>
                        </li>
                        <li class="submenu-item">
                            <a href="<c:url value='/admin/languages' />" class="submenu-link" data-path="/admin/languages">
                                <i class="bi bi-translate"></i> 
                                Ngôn ngữ
                            </a>
                        </li>
                        <li class="submenu-item">
                            <a href="<c:url value='/admin/users' />" class="submenu-link" data-path="/admin/users">
                                <i class="bi bi-person"></i>
                                Người dùng
                            </a>
                        </li>
                    </ul>
                </li>

                <li class="sidebar-item">
                    <a href="<c:url value='/account-profile' />" class='sidebar-link' data-path="/account-profile">
                        <i class="bi bi-person-circle"></i>
                        <span>Tài khoản</span>
                    </a>
                </li>

                <li class="sidebar-item">
                    <a href="<c:url value='/support' />" class='sidebar-link' data-path="/support">
                        <i class="bi bi-question-circle"></i>
                        <span>Hỗ trợ</span>
                    </a>
                </li>

                <li class="sidebar-item">
                    <a href="<c:url value='/contact' />" class='sidebar-link' data-path="/contact">
                        <i class="bi bi-envelope"></i>
                        <span>Liên hệ</span>
                    </a>
                </li>

                <li class="sidebar-item">
                    <a href="<c:url value='/logout' />" class='sidebar-link' data-path="/logout">
                        <i class="bi bi-box-arrow-right"></i>
                        <span>Đăng xuất</span>
                    </a>
                </li>
            </ul>
        </div>
    </div>
</div>

<script>
document.addEventListener('DOMContentLoaded', function() {
    var currentPath = window.location.pathname.replace('${pageContext.request.contextPath}', '');
    
    // Xóa active cũ
    document.querySelectorAll('.sidebar-item, .submenu-item').forEach(el => el.classList.remove('active'));
    document.querySelectorAll('.submenu').forEach(el => el.classList.remove('active'));
    
    // Tìm và active link phù hợp
    document.querySelectorAll('[data-path]').forEach(function(link) {
        var path = link.getAttribute('data-path');
        
        if ((path === '/' && currentPath === '') || 
            (path === '/' && currentPath === '/') || 
            (path !== '/' && currentPath.includes(path))) {
            
            // Active link
            link.closest('.sidebar-item, .submenu-item').classList.add('active');
            
            // Nếu là submenu, active parent
            if (link.closest('.submenu')) {
                link.closest('.submenu').classList.add('active');
                link.closest('.has-sub').classList.add('active');
            }
        }
    });
});
</script>