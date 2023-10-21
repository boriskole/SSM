<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:template>

    <jsp:attribute name="title">
        Login - SSM
    </jsp:attribute>

    <jsp:attribute name="css">
        <link rel="stylesheet" href="content/css/main.css" type="text/css">
        <link rel="stylesheet" href="content/css/login.css" type="text/css">
    </jsp:attribute>

    <jsp:attribute name="content">

        <div class="container-fluid px-3 text-center position-absolute top-50 start-50 translate-middle mt-3">
            <div class="row justify-content-center">
                <div class="col-md-3 box bg-light">

                    <img src="content/img/auth/profile.png" width="250px" class="my-5 img-fluid" alt="Foto van een persoon">

                    <form action="doLogin" method="post">

                        <h2 class="form-header">Login</h2>

                        <div class="form-floating mt-3">
                            <input type="email" name="email" id="email" placeholder="E-mail" class="form-control">
                            <label for="email" class="col-form-label form-label-group">E-mail</label>
                        </div>

                        <div class="form-floating mt-1">
                            <input type="password" name="password" id="password" placeholder="Wachtwoord" class="form-control">
                            <label for="password" class="col-form-label form-label-group">Wachtwoord</label>
                        </div>

                        <input type="submit" value="Inloggen" class="submit-btn form-control my-3 py-3">

                    </form>

                </div>
            </div>
        </div>

    </jsp:attribute>

</t:template>