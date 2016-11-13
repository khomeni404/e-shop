<#assign ctx = rc.getContextPath()/>

<#--<form action="${ctx}/auth/authenticateUser.se" method="POST">
    <input type="text" name="username" value="account"/><br/>
    <input type="password" name="password" value="asadmin"/>
    <br/>
    <input type="submit"/>
</form>-->


<!DOCTYPE html>
<html lang="en">
<head>
    <title>Taurus</title>

    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>

    <link rel="icon" type="image/ico" href="favicon.ico"/>

    <link href="../resources/taurus/HTML/css/stylesheets.css" rel="stylesheet" type="text/css"/>


    <script type='text/javascript' src='../resources/taurus/HTML/js/plugins/jquery/jquery.min.js'></script>
    <script type='text/javascript' src='../resources/taurus/HTML/js/plugins/jquery/jquery-ui.min.js'></script>
    <script type='text/javascript' src='../resources/taurus/HTML/js/plugins/jquery/jquery-migrate.min.js'></script>
    <script type='text/javascript' src='../resources/taurus/HTML/js/plugins/jquery/globalize.js'></script>
    <script type='text/javascript' src='../resources/taurus/HTML/js/plugins/bootstrap/bootstrap.min.js'></script>

    <script type='text/javascript' src='../resources/taurus/HTML/js/plugins/uniform/jquery.uniform.min.js'></script>

    <script type='text/javascript' src='../resources/taurus/HTML/js/plugins.js'></script>
    <script type='text/javascript' src='js/actions.js'></script>
    <script type='text/javascript' src='js/settings.js'></script>
</head>
<body class="bg-img-num3">

<div class="container">
    <form name="loginForm" action="${ctx}/auth/authenticateUser.se" method="POST">
        <div class="login-block">
            <div class="block block-transparent text-left">
                <div class="head">
                    <div class="user">
                        <div class="info user-change">
                            <#--<img src="../resources/taurus/HTML/img/example/user/dmitry_b.jpg" class="img-circle img-thumbnail"/>-->
                            <img src="../resources/images/users/sadhon.png" class="img-circle img-thumbnail"/>
                            <#--<img src="../resources/images/logo/se_logo.png" class=""/>-->

                            <div class="user-change-button">
                                <span class="icon-off"></span>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="content controls npt">
                    <#--<div class="form-row user-change-row">
                        <div class="col-md-12">
                            <div class="input-group">
                                <div class="input-group-addon">
                                    <span class="icon-user"></span>
                                </div>
                                <input type="text" name="username" value="account" class="form-control"
                                       placeholder="Login"/>
                            </div>
                        </div>
                    </div>-->
                    <div class="form-row">
                        <div class="col-md-12">
                            <div class="input-group">
                                <div class="input-group-addon">
                                    <span class="icon-user"></span>
                                </div>
                                <input type="text" name="username" class="form-control" placeholder="Username" value="admin"/>
                            </div>
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="col-md-12">
                            <div class="input-group">
                                <div class="input-group-addon">
                                    <span class="icon-key"></span>
                                </div>
                                <input type="password" name="password" class="form-control" placeholder="Password" value="asadmin"/>
                            </div>
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="col-md-6">
                            <a href="#" class="btn btn-info btn-block">Clear</a>
                        </div>
                        <div class="col-md-6">
                            <a href="#" id="submit-btn" class="btn btn-success btn-block">Log In</a>
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="col-md-12">
                            <a href="#" class="btn btn-link btn-block">Forgot your password?</a>
                        </div>
                    </div>
          <#--          <div class="form-row">
                        <div class="col-md-12 tac"><strong>OR USE</strong></div>
                    </div>
                    <div class="form-row">
                        <div class="col-md-12">
                            <a href="#" class="btn btn-info btn-block"><span class="icon-facebook"></span> &nbsp;
                                Facebook</a>
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="col-md-12">
                            <a href="#" class="btn btn-primary btn-block"><span class="icon-twitter"></span> &nbsp;
                                Tweeter</a>
                        </div>
                    </div>-->
                </div>
            </div>
        </div>
    </form>
</div>

</body>
</html>

<script>
    $('#submit-btn').click(function () {
        document.loginForm.submit();
    });
</script>