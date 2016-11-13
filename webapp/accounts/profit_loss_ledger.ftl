<#import "../se_template/se_app_layout.ftl" as layout>
<@layout.se_app_layout "Test" >
    <#assign ctx = rc.getContextPath()/>
    <#assign sourceArr = ["Sales", "Re-pricing", "Rejected"]>
<div class="row">
    <div class="col-md-1"></div>
    <div class="col-md-10">
        <div class="block se-block">
            <div class="header se-header  se-header-bl">
                &Popf;&ropf;&oopf;&fopf;&iopf;&topf;-&Lopf;&oopf;&sopf;&sopf; &Lopf;&eopf;&dopf;&gopf;&eopf;&ropf; &Vopf;&iopf;&eopf;&wopf;
            </div>
            <div class="content controls">
                <table class="table" width="100%">
                    <tbody>
                    <tr>
                        <td class="se-dt-left">ID</td>
                        <td class="se-dt-center">:</td>
                        <td class="se-dt-right">${profitLossLedger.id!}</td>

                        <td class="se-dt-left">LEDGER DATE</td>
                        <td class="se-dt-center">:</td>
                        <td class="se-dt-right">${profitLossLedger.date!}</td>
                    </tr>
                    <tr>
                        <td class="se-dt-left">SOURCE</td>
                        <td class="se-dt-center">:</td>
                        <td class="se-dt-right">${sourceArr[profitLossLedger.field!]}</td>

                        <td class="se-dt-left">MARKING</td>
                        <td class="se-dt-center">:</td>
                        <td class="se-dt-right">
                            <#if profitLossLedger.amt<0>
                                Loss
                            <#else >
                                Profit
                            </#if>
                        </td>
                    </tr>
                    <tr>
                        <td class="se-dt-left">
                            <#if profitLossLedger.amt<0>
                                LOSS AMOUNT
                            <#else >
                                PROFIT AMOUNT
                            </#if>
                        </td>
                        <td class="se-dt-center">:</td>
                        <td class="se-dt-right">
                            <#if profitLossLedger.amt! &lt;= 0>
                                    (${-profitLossLedger.amt!})/-
                                <#else >
                                    ${profitLossLedger.amt!}
                            </#if>
                        </td>

                        <td class="se-dt-left">OPERATOR</td>
                        <td class="se-dt-center">:</td>
                        <td class="se-dt-right">${profitLossLedger.operator.name!}</td>
                    </tr>

                    </tbody>
                </table>
                <hr style="border: 2px double #7597aa"/>
                <div class="header se-header  se-header-bl">
                    &Iopf;&topf;&eopf;&mopf; &Lopf;&oopf;&gopf; &Dopf;&eopf;&topf;&aopf;&iopf;&lopf;&sopf;
                </div>
                <table class="table  table-hover">
                    <thead class="se-thead">
                    <tr>
                        <th>ID No</th>
                        <th>Name</th>
                        <th>Quantity</th>
                        <th>Purchased Price</th>
                        <th>Labeled Price</th>
                        <th>Discount Amt</th>
                        <th>Sales Price</th>
                        <th>Profit/Loss</th>
                    </tr>
                    </thead>
                    <tbody>
                        <#list profitLossLedger.logList as log>
                        <tr>
                            <td>${log.id!}</td>
                            <td>${log.item.name!}</td>
                            <td>${log.qty + " " +log.item.unit.name!}</td>
                            <td class="se-amt">${log.purchasedPrice!}/-</td>
                            <td class="se-amt">${log.labeledPrice!}/-</td>
                            <td class="se-amt">${log.discountAmt!}/-</td>
                            <td class="se-amt">${log.salesPrice!}/-</td>
                            <td class="se-amt">
                                <#if log.profitAmt &lt; 0>
                                    (${-log.profitAmt!})/-
                                <#else >
                                    ${log.profitAmt!}/-
                                </#if>
                            </td>
                        </tr>
                        </#list>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
    <div class="col-md-1"></div>
</div>

</@layout.se_app_layout>
