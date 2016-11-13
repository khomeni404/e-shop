<#import "../se_template/se_app_layout.ftl" as layout>
<@layout.se_app_layout "Test" >
    <#assign ctx = rc.getContextPath()/>

    <div class="row">
        <div class="col-md-1"></div>
        <div class="col-md-10">
            <div class="block se-block">
                <div class="header se-header">
                    &Sopf;&topf;&oopf;&copf;&kopf;&nbsp;&Lopf;&eopf;&dopf;&gopf;&eopf;&ropf; &nbsp;
                    &Lopf;&iopf;&sopf;&topf;
                </div>
                <div class="content controls">
                    <table class="table table-striped">
                        <thead class="se-thead">
                        <tr>
                            <th>Ref No</th>
                            <th>Date</th>
                            <th>Vendor Name</th>
                            <th>Total Amount</th>
                            <th>Source</th>
                            <th>Data Operator</th>
                        </tr>
                        </thead>
                        <tbody>
                        <#list stockLedgerList as stock>
                            <tr>
                                <td>${stock.refNo!}</td>
                                <td>${stock.orderDate!}</td>
                                <td>${stock.vendorName!}</td>
                                <td class="se-amt">${stock.totalAmount!}/-</td>
                                <td>${stock.source.name!}</td>
                                <td>${stock.dataOperator.name!}</td>
                            </tr>
                        </#list>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</@layout.se_app_layout>
