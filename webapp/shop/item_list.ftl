<#import "../se_template/se_app_layout.ftl" as layout>
<@layout.se_app_layout "Test" >
    <#assign ctx = rc.getContextPath()/>

    <div class="row">
        <div class="col-md-1"></div>
        <div class="col-md-10">
            <div class="block se-block">
                <div class="header se-header">
                    &Iopf;&topf;&eopf;&mopf; &nbsp;&nbsp;
                        &Lopf;&iopf;&sopf;&topf;
                </div>
                <div class="content controls">
                    <table class="table table-striped">
                        <thead class="se-thead">
                        <tr>
                            <th>Item Code</th>
                            <th>Name</th>
                            <th>Category</th>
                            <th>Stock</th>
                            <th>Purchased</th>
                            <th>Labeled</th>
                            <th></th>
                        </tr>
                        </thead>
                        <tbody>
                        <#list itemList as item>
                            <tr>
                                <td>${item.itemCode!}</td>
                                <td>${item.name!}</td>
                                <td>${item.category.name!}</td>
                                <td>${item.stock!}&nbsp;${item.unit.name!}</td>
                                <td class="se-amt" width="50">${item.purchasedPrice!}/-</td>
                                <td class="se-amt" width="50">${item.labeledPrice!}/-</td>
                                <td>
                                    <a href="${ctx}/shop/viewItem.se?id=${item.id}"
                                       class="btn btn-info"> <i class="icon-ok"></i>&nbsp;&nbsp;View</a>
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
