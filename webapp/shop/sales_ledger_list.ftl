<#import "../se_template/se_app_layout.ftl" as layout>
<@layout.se_app_layout "Test" >
    <#assign ctx = rc.getContextPath()/>

    <div class="row">
        <div class="col-md-1"></div>
        <div class="col-md-10">
            <div class="block se-block">
                <div class="header se-header">
                    &Sopf;&aopf;&lopf;&eopf;&sopf;  &Oopf;&ropf;&dopf;&eopf;&ropf;&nbsp;
                        &Lopf;&iopf;&sopf;&topf;
                </div>
                <div class="content controls">
                    <table class="table table-striped">
                        <thead class="se-thead">
                        <tr>
                            <th>Order No</th>
                            <th>Date</th>
                            <th>Total Amount</th>
                            <th>Discount</th>
                            <th>Payable</th>
                            <th>Paid</th>
                            <th>Due</th>
                            <th>Sales Man</th>
                            <th></th>
                        </tr>
                        </thead>
                        <tbody>
                        <#list salesLedgerList as ledger>
                            <tr>
                                <td>${ledger.orderNo!}</td>
                                <td>${ledger.date!}</td>
                                <td class="se-amt">${ledger.totalAmount+ledger.totalDiscount!}/-</td>
                                <td class="se-amt">${ledger.totalDiscount!}/-</td>
                                <td class="se-amt">${ledger.totalAmount!}/-</td>
                                <td class="se-amt">${ledger.paidTotal!}/-</td>
                                <td class="se-amt">${ledger.dueTotal!}/-</td>
                                <td>${ledger.salesMan.name!}</td>
                                <td>
                                    <a href="${ctx}/shop/salesLedgerView.se?id=${ledger.id}"
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
