<#import "../se_template/se_app_layout.ftl" as layout>
<@layout.se_app_layout "Test" >
    <#assign ctx = rc.getContextPath()/>

<div class="row">
    <form action="${ctx}/security/updatePassword.se" method="post">
        <div class="col-md-12" style="color: red; font-size: 20px;">${message!}</div>
        <div class="col-md-1"></div>
        <div class="col-md-6">
            <div class="block se-block <#--block-fill-white-->">
                <div class="header se-header">
                    &Copf;&hopf;&aopf;&nopf;&gopf;&eopf; &Popf;&aopf;&sopf;&sopf;&wopf;&oopf;&ropf;&dopf;
                </div>
                <div class="content controls">
                    <div class="form-row">
                        <div class="col-md-4 text-right">USERNAME</div>
                        <div class="col-md-6">
                            <input type="text" name="" value="${user.token.username}" disabled style="color:green" class="form-control"/>
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="col-md-4 text-right">NEW PASSWORD</div>
                        <div class="col-md-6">
                            <input type="password" name="passNew" class="form-control"/>
                        </div>

                    </div>
                    <div class="form-row">
                        <div class="col-md-4 text-right">OLD PASSWORD</div>
                        <div class="col-md-6">
                            <input type="password" name="passOld" class="form-control"/>
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="col-md-4 text-right">CONFIRM NEW PASSWORD</div>
                        <div class="col-md-6">
                            <input type="password" name="passNewRe" class="form-control"/>
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="col-md-7 text-right"></div>
                        <div class="col-md-3">
                            <input type="submit" class="form-control btn btn-success"
                                   value="Change"/>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </form>
</div>

</@layout.se_app_layout>