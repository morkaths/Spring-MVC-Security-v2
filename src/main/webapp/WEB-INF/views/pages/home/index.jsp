<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<section class="section">
    <div class="col-12">
            <div class="card">
                <div class="card-header">
                    <h4>Chào mừng!</h4>
                </div>
                <div class="card-body">
                    <p>Xin chào!</p>
                    <p>Bạn đã đăng nhập thành công.</p>
                    <a href="<c:url value='/auth/logout'/>" class="btn btn-danger">Đăng xuất</a>
                </div>
            </div>
        </div>
</section>