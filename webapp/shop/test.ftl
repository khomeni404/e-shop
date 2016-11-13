<#import "../se_template/se_app_layout.ftl" as layout>
<@layout.se_app_layout "Test" >
    <#assign ctx = rc.getContextPath()/>

<div class="col-md-10">
    <div class="col-md-5">
        <div class="block block-drop-shadow">
            <div class="head bg-default bg-light-ltr">
                <div class="row">
                    <div class="col-md-12">
                        <div class="block">
                            <div class="header se-header">
                                <h2>Default elements</h2>
                            </div>
                            <div class="content controls">
                                <div class="form-row">
                                    <div class="col-md-3">Name</div>
                                    <div class="col-md-9"><input type="text" class="form-control" value="Md. Khomeni Ayatullah"/>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

            </div>
        </div>
    </div>
</div>

</@layout.se_app_layout>