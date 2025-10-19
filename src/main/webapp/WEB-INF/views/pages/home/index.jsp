<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<section id="content-types">
    <div class="row">
        <c:forEach var="product" items="${products}">
            <div class="col-12 col-sm-6 col-md-4 col-lg-3">
                <div class="card">
                    <div class="card-content">
                        <img src="https://i.pinimg.com/1200x/8f/74/f1/8f74f188d044afdb98d3c7658996b502.jpg"
                            class="card-img-top img-fluid" alt="${product.name}">
                        <div class="card-body">
                            <h5 class="card-title">${product.name}</h5>
                            <p class="card-text">${product.description}</p>
                            <div class="badges">
                                <a href="#" class="badge bg-light-primary">
                                    <p class="card-text">${product.categoryName}</p>
                                </a>
                            </div>
                            <p class="card-text"><small class="text-muted">Weight: ${product.weight}kg</small>
                            </p>
                            <div class="d-flex justify-content-between align-items-center">
                                <span class="card-text"><strong>Price:</strong> $${product.price}</span>
                                <button type="button" class="btn btn-primary">Xem chi tiết</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</section>