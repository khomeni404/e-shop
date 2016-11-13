<#import "../se_template/se_app_layout.ftl" as layout>
<@layout.se_app_layout "Test" >
    <#assign ctx = rc.getContextPath()/>
    <#assign sourceArr = ["Sales", "Re-pricing", "Rejected"]>
<div class="row">
    <div class="col-lg-11 text-right">
        <a href="${ctx}/mis/printSalesOrder.se?id=${salesLedger.id}"
           class="btn btn-info"> <i class="icon-print"></i>&nbsp;&nbsp;Print</a>
    </div>
</div>
<div class="row">
    <div class="col-md-1"></div>
    <div class="col-md-10">
        <div class="block se-block">
            <div class="header se-header  se-header-bl">
                &Oopf;&ropf;&dopf;&eopf;&ropf; &Vopf;&iopf;&eopf;&wopf;
            </div>
            <div class="content controls">
                <table class="table" width="100%">
                    <tbody>
                    <tr>
                        <td class="se-dt-left">ORDER NO</td>
                        <td class="se-dt-center">:</td>
                        <td class="se-dt-right">${salesLedger.orderNo!}</td>

                        <td class="se-dt-left">ORDER DATE</td>
                        <td class="se-dt-center">:</td>
                        <td class="se-dt-right">${salesLedger.date!}</td>
                    </tr>
                    <tr>
                        <td class="se-dt-left">CUSTOMER NAME</td>
                        <td class="se-dt-center">:</td>
                        <td class="se-dt-right">
                        ${salesLedger.customerName!}
                            <#--<#if salesLedger.customer??>
                                ${salesLedger.customerName!}
                                <#else >
                                ${salesLedger.customer.name!}
                            </#if>-->
                        </td>

                        <td class="se-dt-left">TOTAL AMOUNT</td>
                        <td class="se-dt-center">:</td>
                        <td class="se-dt-right"> ${salesLedger.totalAmount + salesLedger.totalDiscount} </td>
                    </tr>
                    <tr>
                        <td class="se-dt-left"> TOTAL DISCOUNT </td>
                        <td class="se-dt-center">:</td>
                        <td class="se-dt-right">${salesLedger.totalDiscount!}</td>

                        <td class="se-dt-left">PAID TOTAL</td>
                        <td class="se-dt-center">:</td>
                        <td class="se-dt-right">${salesLedger.paidTotal!}</td>
                    </tr>
                    <tr>
                        <td class="se-dt-left">DUE TOTAL</td>
                        <td class="se-dt-center">:</td>
                        <td class="se-dt-right">${salesLedger.dueTotal!}</td>

                        <td class="se-dt-left"> SALES MAN </td>
                        <td class="se-dt-center">:</td>
                        <td class="se-dt-right">${salesLedger.salesMan.name!}</td>

                    </tr>

                    </tbody>
                </table>
                <hr style="border: 2px double #7597aa"/>
                <div class="header se-header  se-header-bl">
                    &Iopf;&topf;&eopf;&mopf;&sopf;
                </div>
                <table class="table table-hover">
                    <thead class="se-thead">
                    <tr>
                        <th>Sl</th>
                        <th>Item ID</th>
                        <th>Item Name</th>
                        <th>Quantity</th>
                        <th>Price</th>
                        <th>Discount</th>
                        <th>Sales Price</th>
                    </tr>
                    </thead>
                    <tbody>
                    <#assign sl = 1>
                        <#list salesLedger.outLogList as log>
                        <tr>
                            <td>${sl}</td>
                            <td style="text-align: center">${log.item.itemCode!}</td>
                            <td>${log.item.name!}</td>
                            <td style="text-align: center">${log.qty + " " +log.item.unit.name!}</td>
                            <td class="se-amt">${log.labeledPrice!}/-</td>
                            <td class="se-amt">${log.discount!}/-</td>
                            <td class="se-amt">${log.salesPrice!}/-</td>

                        </tr>

                            <#assign sl = sl + 1>
                        </#list>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
    <div class="col-md-1"></div>
</div>

</@layout.se_app_layout>
