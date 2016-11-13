<#import "../se_template/se_app_layout.ftl" as layout>
<@layout.se_app_layout "Test" >
    <#assign ctx = rc.getContextPath()/>
<div class="row">
    <div class="col-lg-12 text-center" style="color: #d51a1c; font-size: 25px">
        <br/>
        <br/>
        <br/>
        <br/>
        <h1>${message!}</h1>
    </div>
</div>
</@layout.se_app_layout>