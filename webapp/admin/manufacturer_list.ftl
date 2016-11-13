<#import "../se_template/se_app_layout.ftl" as layout>
<@layout.se_app_layout "Test" >
    <#assign ctx = rc.getContextPath()/>
    <#include "../se_template/array.ftl">
<div class="row">
    <div class="col-md-1"></div>
    <div class="col-md-10">
        <div class="block se-block">
            <div class="header se-header">
                &Copf;&uopf;&sopf;&topf;&oopf;&mopf;&eopf;&ropf; &nbsp;&nbsp;
                &Lopf;&iopf;&sopf;&topf;
            </div>
            <div class="content controls">
                <table class="table table-striped">
                    <thead class="se-thead">
                    <tr>
                        <th>Customer ID</th>
                        <th>NFull ame</th>
                        <th>Cell Number</th>
                        <th>Customer Type</th>
                        <th>Due</th>
                        <th>E-mail Address</th>
                    </tr>
                    </thead>
                    <tbody>
                        <#list manuFList as cust>
                        <tr>
                            <td>SC-000${cust.id!}</td>
                            <td>${cust.name!}</td>
                            <td>${cust.hotLine!}</td>
                            <td>${cust.email!}</td>
                            <td class="se-amt"></td>
                            <td></td>
                        </tr>
                        </#list>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
</@layout.se_app_layout>
