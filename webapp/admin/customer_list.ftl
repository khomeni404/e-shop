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
                        <th>Username</th>
                        <th></th>
                    </tr>
                    </thead>
                    <tbody>
                        <#list customerList as cust>
                        <tr>
                            <td>SC-000${cust.id!}</td>
                            <td>${cust.name!}</td>
                            <td>${cust.cellPhone!}</td>
                            <td>${custTypeArray[cust.custType]!}</td>
                            <td class="se-amt">${cust.cashAccount.balance!}/-</td>
                            <td>${cust.emailAddress!}</td>
                            <td>${cust.token.username!}</td>
                            <td class="text-center">
                                <#if cust.active?string == "false">
                                    <a href="${ctx}/security/activateUser.se?active=1&id=${cust.id}"
                                       class="btn btn-warning"><i class="icon-ok"></i>&nbsp;&nbsp;Activate</a>
                                <#else>
                                    <a href="${ctx}/security/activateUser.se?active=0&id=${cust.id}"
                                       class="btn btn-success"><i class="icon-ok"></i>&nbsp;&nbsp;Deactivate</a>
                                </#if>
                            </td>
                        </tr>
                        </#list>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
</@layout.se_app_layout>
