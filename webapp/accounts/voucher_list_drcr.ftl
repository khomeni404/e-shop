<#import "../se_template/se_app_layout.ftl" as layout>
<@layout.se_app_layout "Test" >
    <#assign ctx = rc.getContextPath()/>

<div class="row">
    <div class="col-md-1"></div>
    <div class="col-md-10">
        <div class="block se-block">
            <div class="header se-header">
                &Dopf;&ropf;/&Copf;&ropf;
                &Vopf;&oopf;&uopf;&copf;&hopf;&eopf;&ropf; &Lopf;&iopf;&sopf;&topf;
                &oopf;&fopf; &Popf;&aopf;&ropf;&topf;&yopf;

            </div>
            <div class="content controls">
                <table class="table table-striped">
                    <thead class="se-thead">
                    <tr>
                        <th>Instrument No</th>
                        <th>Date</th>
                        <th>Party Name</th>
                        <th>Amount</th>
                        <th>Note</th>
                        <th>Status</th>
                        <th>Operator</th>
                    </tr>
                    </thead>
                    <tbody>
                        <#assign statusArr = ["Pending", "Passed", "Rejected"]>
                        <#list voucherList as voucher>
                        <tr>
                            <td>${voucher.instrumentNo!}</td>
                            <td>${voucher.date!}</td>
                            <td>${voucher.customerName!}</td>
                            <td class="se-amt">${voucher.amount!}/-</td>
                            <td>${voucher.note!}</td>
                            <td>${statusArr[voucher.status]!}</td>
                            <#if voucher.operator??>
                                <td>${voucher.operator.name!}</td>
                            <#else >
                                <td>System</td>
                            </#if>

                        </tr>
                        </#list>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
</@layout.se_app_layout>
