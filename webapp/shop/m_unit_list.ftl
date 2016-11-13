<#import "../se_template/se_app_layout.ftl" as layout>
<@layout.se_app_layout "Test" >
    <#assign ctx = rc.getContextPath()/>

<div class="row">
    <div class="col-md-1"></div>
    <div class="col-md-10">
        <div class="block se-block">
            <div class="header se-header">
                &Uopf;&nopf;&iopf;&topf; &nbsp;&nbsp;
                &Lopf;&iopf;&sopf;&topf;
            </div>
            <div class="content controls">
                <table class="table table-striped">
                    <thead class="se-thead">
                    <tr>
                        <th>Unit ID</th>
                        <th>Name</th>
                        <th>Description</th>
                        <th>No of Items</th>
                    </tr>
                    </thead>
                    <tbody>
                        <#list mUnitList as unit>
                        <tr>
                            <td>${unit.id!}</td>
                            <td>${unit.name!}</td>
                            <td>${unit.description!}</td>
                            <td>
                            <table width="100%">
                                <#list unit.itemList as item>
                                    <tr>
                                        <td width="20%">${item.itemCode!}</td>
                                        <td width="20%">${item.name!}</td>
                                        <td width="20%">${item.purchasedPrice!}</td>
                                        <td width="20%">${item.labeledPrice!}</td>
                                        <td width="20%">${item.category.name!}</td>
                                    </tr>
                                </#list>
                            </table>
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
