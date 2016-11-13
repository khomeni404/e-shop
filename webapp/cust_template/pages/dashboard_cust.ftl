<#import "../cust_app_layout.ftl" as layout>
<@layout.cust_app_layout "Test" >
    <#assign ctx = rc.getContextPath()/>
<div class="row">
    <div class="col-md-1"></div>
    <div class="col-md-10">
        <div class="block se-block">
            <div class="header se-header  se-header-bl">
            ${customer.name!}
            </div>
            <div class="content controls">
                <table class="table" width="100%">
                    <tbody>
                    <tr>
                        <td class="se-dt-left">CUSTOMER NAME</td>
                        <td class="se-dt-center">:</td>
                        <td class="se-dt-right">${customer.name!}</td>

                        <td class="se-dt-left">KEY NAME</td>
                        <td class="se-dt-center">:</td>
                        <td class="se-dt-right">${customer.keyName!}</td>
                    </tr>
                    <tr>
                        <td class="se-dt-left">CELL PHONE</td>
                        <td class="se-dt-center">:</td>
                        <td class="se-dt-right">${customer.cellPhone!}</td>
                        <td class="se-dt-left">OTHER PHONE</td>
                        <td class="se-dt-center">:</td>
                        <td class="se-dt-right"> ${customer.altPhone!} </td>
                    </tr>
                    <tr>
                        <td class="se-dt-left">CUSTOMER TYPE</td>
                        <td class="se-dt-center">:</td>
                        <td class="se-dt-right">${customer.custType!}</td>

                        <td class="se-dt-left">EMAIL ADDRESS</td>
                        <td class="se-dt-center">:</td>
                        <td class="se-dt-right">${customer.emailAddress!}</td>
                    </tr>
                    <tr>
                        <td class="se-dt-left">NATIONAL ID NO.</td>
                        <td class="se-dt-center">:</td>
                        <td class="se-dt-right">${customer.nid!}</td>

                        <td class="se-dt-left">TIN</td>
                        <td class="se-dt-center">:</td>
                        <td class="se-dt-right">${customer.tin!}</td>

                    </tr>
                    <tr>
                        <td class="se-dt-left">MAILING ADDRESS</td>
                        <td class="se-dt-center">:</td>
                        <td class="se-dt-right">${customer.mailingAddress!}</td>

                        <td class="se-dt-left">BUSINESS ADDRESS</td>
                        <td class="se-dt-center">:</td>
                        <td class="se-dt-right">${customer.businessAddress!}</td>

                    </tr>
                    <tr style="color:#c40000">
                        <td class="se-dt-left">TOTAL DUE</td>
                        <td class="se-dt-center">:</td>
                        <td class="se-dt-right">${customer.cashAccount.balance!}/-</td>

                        <td class="se-dt-center" style="text-align: left" colspan="3">${balance_in_word}</td>

                    </tr>

                    </tbody>
                </table>
                <hr style="border: 2px double #7597aa"/>
                <div class="header se-header  se-header-bl">
                    &Vopf;&oopf;&uopf;&copf;&hopf;&eopf;&ropf;&sopf;
                </div>

                <table class="table table-striped">
                    <thead class="se-thead">
                    <tr>
                        <th>Instrument No</th>
                        <th>Date</th>
                        <th>Party Name</th>
                        <th>Due</th>
                        <th>Paid</th>
                        <th>Note</th>
                        <th>Status</th>
                        <th>Operator</th>
                        <th></th>
                    </tr>
                    </thead>
                    <tbody>
                        <#assign statusArr = ["Pending", "Passed", "Rejected"]>
                        <#list customer.drCrVoucherList as voucher>
                        <tr>
                            <td>${voucher.instrumentNo!}</td>
                            <td>${voucher.date!}</td>
                            <td>${voucher.customerName!}</td>
                            <td class="se-amt">
                                <#if voucher.crAc??>
                                    <#if voucher.crAc.id! == customer.cashAccount.id!>
                                    ${voucher.amount!}/-
                                    </#if>
                                </#if>
                            </td>
                            <td class="se-amt">
                                <#if voucher.drAc??>
                                    <#if voucher.drAc.id! == customer.cashAccount.id!>
                                    ${voucher.amount!}/-
                                    </#if>
                                </#if>
                            </td>
                            <td>${voucher.note!}</td>
                            <td>${statusArr[voucher.status]!}</td>
                            <#if voucher.operator??>
                                <td>${voucher.operator.name!}</td>
                            <#else >
                                <td>System</td>
                            </#if>
                            <td>
                                <#if voucher.salesLedger??>
                                    <a href="${ctx}/shop/salesLedgerCustomerView.se?id=${voucher.salesLedger.id}"
                                       class="btn btn-info"> <i class="icon-ok"></i>&nbsp;&nbsp;View</a>
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
</@layout.cust_app_layout>