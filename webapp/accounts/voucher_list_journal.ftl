<#import "../se_template/se_app_layout.ftl" as layout>
<@layout.se_app_layout "Test" >
    <#assign ctx = rc.getContextPath()/>

<div class="row">
    <div class="col-md-1"></div>
    <div class="col-md-10">
        <div class="block se-block">
            <div class="header se-header">
                &Vopf;&oopf;&uopf;&copf;&hopf;&eopf;&ropf; &Lopf;&iopf;&sopf;&topf; :
                &Jopf;&oopf;&uopf;&ropf;&nopf;&aopf;&lopf;
            </div>
            <div class="content controls">
                <table class="table table-striped">
                    <thead class="se-thead">
                    <tr>
                        <th>Instrument No</th>
                        <th>Date</th>
                        <th>Amount</th>
                        <th>Sender</th>
                        <th>Receiver</th>
                        <th>Status</th>
                        <th>Received Date</th>
                    </tr>
                    </thead>
                    <tbody>
                        <#assign statusArr = ["Pending", "Received", "Rejected"]>
                        <#list voucherList as voucher>
                        <tr>
                            <td>${voucher.instrumentNo!}</td>
                            <td>${voucher.date!}</td>
                            <td class="se-amt">${voucher.amount!}/-</td>
                            <td>${voucher.sender.name!}</td>
                            <td>${voucher.receiver.name!}</td>
                            <td>${statusArr[voucher.status]!}</td>
                            <#if voucher.status == 0>
                            <td><a href="${ctx}/accounts/acceptJournalVoucher.se?vrId=${voucher.id}" class="btn btn-info"><i class="icon-ok"></i>&nbsp;&nbsp;Accept</a></td>
                            <#else >
                                <td>${voucher.receiveDate!}</td>
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
