<#import "../se_template/se_app_layout.ftl" as layout>
<@layout.se_app_layout "Test" >
    <#assign ctx = rc.getContextPath()/>
<h1>Successful Logged in !</h1>

</@layout.se_app_layout>