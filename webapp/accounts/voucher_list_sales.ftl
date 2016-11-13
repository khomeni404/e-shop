<#import "../se_template/se_app_layout.ftl" as layout>
<@layout.se_app_layout "Test" >
    <#assign ctx = rc.getContextPath()/>
    <#include "../se_template/array.ftl">
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
                        <th>Type</th>
                        <th>Date</th>
                        <th>Amount</th>
                        <th>Status</th>
                        <th>Operator</th>
                    </tr>
                    </thead>
                    <tbody>

                        <#list voucherList as voucher>
                        <tr>
                            <td>${voucher.instrumentNo!}</td>
                            <td>${voucher.getDiscriminatorValue()!}</td>
                            <td>${voucher.date!}</td>
                            <td>${voucher.amount!}</td>
                            <td>${voucherStatusArr[voucher.status]!}</td>
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
