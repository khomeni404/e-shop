<#import "../se_template/se_app_layout.ftl" as layout>
<@layout.se_app_layout "Test" >
    <#assign ctx = rc.getContextPath()/>

<div class="row">
    <div class="col-lg-1"></div>
    <div class="col-lg-4 se-in-msg">${msg!}</div>
</div>
<div class="row">
    <div class="col-lg-1"></div>
    <div class="col-lg-10">
        <div class="block se-block <#--block-fill-white-->">
            <div class="header se-header se-header-bl">
                &Lopf;&oopf;&gopf;&iopf;&nopf; &Lopf;&oopf;&gopf; &Lopf;&iopf;&sopf;&topf;
            </div>
            <div class="content controls">
                <table class="table table-striped">
                    <thead class="se-thead">
                    <tr>
                        <th>ID</th>
                        <th>IN/OUT</th>
                        <th>DATE</th>
                        <th>TIME</th>
                        <th>USER NAME</th>
                    </tr>
                    </thead>
                    <tbody>
                        <#list logList as log>
                        <tr>
                            <td>${log.id!}</td>
                            <#assign inOut = log.in?string("Sign In", "Sign Out")>
                            <td>${inOut}</td>
                            <td>${log.date!}</td>
                            <td>${log.time!}</td>
                            <td>${log.user.name!}</td>
                        </tr>
                        </#list>
                    </tbody>
                </table>
            </div>
        </div>

    </div>
</div>

</@layout.se_app_layout>