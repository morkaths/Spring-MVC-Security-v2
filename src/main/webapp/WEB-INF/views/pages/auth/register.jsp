<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="row h-100">
    <div class="col-lg-5 col-12">
        <div id="auth-left">
            <div class="auth-logo">
                <a href="<c:url value='/'/>">
                	<img src="<c:url value='/assets/static/images/logos/logo.svg'/>" alt="Logo">
               	</a>
            </div>
            <h1 class="auth-title">Sign Up</h1>
            <p class="auth-subtitle mb-5">Input your data to register to our website.</p>

            <form:form modelAttribute="registerForm" action="<c:url value='/auth/register'/>" method="post">
                <div class="form-group position-relative has-icon-left mb-4">
                    <form:input path="email" type="text" class="form-control form-control-xl" placeholder="Email"/>
                    <form:errors path="email" cssClass="text-danger"/>
                    <div class="form-control-icon">
                        <i class="bi bi-envelope"></i>
                    </div>
                </div>
                <div class="form-group position-relative has-icon-left mb-4">
                    <form:input path="username" type="text" class="form-control form-control-xl" placeholder="Username"/>
                    <form:errors path="username" cssClass="text-danger"/>
                   	<div class="form-control-icon">
                        <i class="bi bi-person"></i>
                    </div>
                </div>
                <div class="form-group position-relative has-icon-left mb-4">
                    <form:input path="password" type="password" class="form-control form-control-xl" placeholder="Password"/>
                    <form:errors path="password" cssClass="text-danger"/>
                    <div class="form-control-icon">
                        <i class="bi bi-shield-lock"></i>
                    </div>
                </div>
                <div class="form-group position-relative has-icon-left mb-4">
                    <form:input path="confirmPassword" type="password" class="form-control form-control-xl" placeholder="Confirm Password"/>
                    <form:errors path="confirmPassword" cssClass="text-danger"/>
                    <div class="form-control-icon">
                        <i class="bi bi-shield-lock"></i>
                    </div>
                </div>
                <button class="btn btn-primary btn-block btn-lg shadow-lg mt-5">Sign Up</button>
            </form:form>
            <div class="text-center mt-5 text-lg fs-4">
                <p class='text-gray-600'>Already have an account? <a href="<c:url value='/auth/login'/>" class="font-bold">Log in</a>.</p>
            </div>
        </div>
    </div>
    <div class="col-lg-7 d-none d-lg-block">
        <div id="auth-right">

        </div>
    </div>
</div>