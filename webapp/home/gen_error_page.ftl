<#import "../se_template/se_app_layout.ftl" as layout>
<@layout.se_app_layout "Test" >
    <#assign ctx = rc.getContextPath()/>
    <div class="row">
        <div class="col-md-1"></div>
        <div class="col-md-10">
            <div class="block <#--se-block  bg-lblue bg-light --> block-fill-white">
                <div class="header" style="font-size: 23px">
                ${PageTitle!}
                </div>
                <div class="content controls">
                    <div class="form-row text-center" style="color: red; font-size: 20px;">
                    ${errorMsg!}
                    </div>
                </div>
            </div>
        </div>
    </div>

</@layout.se_app_layout>

