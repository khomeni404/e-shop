<#import "../se_template/se_app_layout.ftl" as layout>
<@layout.se_app_layout "Test" >
    <#assign ctx = rc.getContextPath()/>
    <#include "../se_template/array.ftl">
    <div class="row">
        <div class="col-md-1"></div>
        <div class="col-md-10">
            <div class="block se-block">
                <div class="header se-header">
                    &Sopf;&topf;&aopf;&fopf;&fopf; &nbsp;&nbsp;
                        &Lopf;&iopf;&sopf;&topf;
                </div>
                <div class="content controls">
                    <table class="table table-striped">
                        <thead class="se-thead">
                        <tr>
                            <th>Staff ID</th>
                            <th>Name</th>
                            <th>Cell</th>
                            <th>Type</th>
                            <th>Balance</th>
                            <th>E-mail</th>
                        </tr>
                        </thead>
                        <tbody>

                        <#list staffList as staff>
                            <tr>
                                <td>S-${staff.sid!}</td>
                                <td>${staff.name!}</td>
                                <td>${staff.cellPhone!}</td>
                                <td>${staffTypeArray[staff.staffType]!}</td>
                                <td class="se-amt">${staff.cashAccount.balance!}/-</td>
                                <td>${staff.emailAddress!}</td>
                            </tr>
                        </#list>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</@layout.se_app_layout>
