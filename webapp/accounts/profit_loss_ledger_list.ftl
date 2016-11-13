<#import "../se_template/se_app_layout.ftl" as layout>
<@layout.se_app_layout "Test" >
    <#assign ctx = rc.getContextPath()/>

<div class="row">
    <div class="col-md-1"></div>
    <div class="col-md-10">
        <div class="block se-block">
            <div class="header se-header">
                &Popf;&ropf;&oopf;&fopf;&iopf;&topf;/&Lopf;&oopf;&sopf;&sopf; &Lopf;&eopf;&dopf;&gopf;&eopf;&ropf;
            </div>
            <div class="content controls">
                <table class="table table-striped">
                    <thead class="se-thead">
                    <tr>
                        <th>ID</th>
                        <th>Date</th>
                        <th>Source</th>
                        <th>Definition</th>
                        <th>Amount</th>
                        <th>Note</th>
                        <th>Operator</th>
                        <th></th>
                    </tr>
                    </thead>
                    <tbody>
                        <#assign sourceArr = ["Sales", "Re-pricing", "Rejected"]>
                        <#list profitLossLedgerList as ledger>
                        <tr>
                            <td>${ledger.id!}</td>
                            <td>${ledger.date!}</td>
                            <td>${sourceArr[ledger.field!]}</td>
                            <td>
                                <#if ledger.amt<0>
                                    Loss
                                    <#else >
                                    Profit
                                </#if>
                            </td>
                            <td class="se-amt">${ledger.amt!}/-</td>
                            <td>${ledger.note!}</td>
                            <#if ledger.operator??>
                                <td>${ledger.operator.name!}</td>
                            <#else >
                                <td>System</td>
                            </#if>
                            <td>
                                <a href="${ctx}/accounts/viewProfitLossLedger.se?id=${ledger.id}"
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
