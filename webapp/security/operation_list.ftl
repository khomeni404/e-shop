<#import "../se_template/se_app_layout.ftl" as layout>
<@layout.se_app_layout "Test" >
    <#assign ctx = rc.getContextPath()/>
    <#include "../se_template/array.ftl">
<div class="row">
    <div class="col-md-1"></div>
    <div class="col-md-10">
        <div class="block se-block">
            <div class="header se-header">
                &Mopf;&oopf;&dopf;&uopf;&lopf;&eopf; &  &Oopf;&popf;&eopf;&ropf;&aopf;&topf;&iopf;&oopf;&nopf;  &nbsp;&nbsp;
                &Lopf;&iopf;&sopf;&topf;
            </div>
            <div class="content controls">
                <table class="table table-striped">
                    <thead class="se-thead">
                    <tr>
                        <th width="5%">ID</th>
                        <th width="15%">Module Name</th>
                        <th width="25%">Module Description</th>
                        <th width="5%">Op.ID</th>
                        <th width="45%">Operation Description</th>

                    </tr>
                    </thead>
                    <tbody>
                        <#assign modId = 1>

                        <#list moduleList as module>
                        <tr>
                            <td>${modId}</td>
                            <td>${module.name!}</td>
                            <td>${module.description!}</td>
                            <td colspan="3">
                                <table width="100%">
                                    <#assign opeId = 1>
                                    <#list module.operationList as operation>
                                        <tr>
                                            <td width="5%">${modId}.${opeId}</td>
                                            <td width="45%">${operation.description!}</td>
                                        </tr>
                                        <#assign opeId = 1+opeId>
                                    </#list>
                                </table>
                            </td>
                        </tr>
                            <#assign modId = 1+modId>
                        </#list>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
</@layout.se_app_layout>
