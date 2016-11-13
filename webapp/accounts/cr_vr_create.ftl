<#import "../se_template/se_app_layout.ftl" as layout>
<@layout.se_app_layout "Test" >
    <#assign ctx = rc.getContextPath()/>
<style xmlns="http://www.w3.org/1999/html">
    th {
        text-align: center
    }

    #sales-ledger-item-table tr th, td {
        border: 1px solid black
    }
</style>
<div class="row">
    <div class="col-md-12">
        <div class="block se-block">
            <div class="header se-header">
                &Copf;&ropf;&eopf;&dopf;&iopf;&topf; &Vopf;&oopf;&uopf;&copf;&hopf;&eopf;&ropf; &Copf;&ropf;&eopf;&aopf;&topf;&eopf;
            </div>
        </div>
    </div>
</div>
<form action="${ctx}/accounts/saveCrVoucher.se" method="post">
    <input type="hidden" name="receiverId" value="${operator.id!}"/>
    <div class="row">
        <div class="col-md-1"></div>
        <div class="col-md-5">
            <div class="block se-block">
                <div class="header se-header  se-header-bl">
                    &Popf;&aopf;&ropf;&topf;&yopf; &Iopf;&nopf;&fopf;&oopf;
                </div>
                <div class="content controls">
                    <div class="form-row">
                        <div class="col-md-4 text-right">PARTY NAME</div>
                        <div class="col-md-6">
                            <select name="custId" id="custId" class="form-control se-select" onchange="setCustomerName()">
                                <option value="0">--Select Party--</option>
                                <#list customerList as customer>
                                    <option value="${customer.id!}">${customer.name!}</option>
                                </#list>
                            </select>
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="col-md-4 text-right">DEPOSITED AMT</div>
                        <div class="col-md-6">
                            <input type="text" name="amount" id="amount"
                                   class="form-control"
                                   value=""/>
                        </div>
                    </div>

                    <div class="form-row">
                        <div class="col-md-4 text-right">ORDER NO</div>
                        <div class="col-md-6">
                            <input type="text" name="orderNo" id="orderNo"
                                   class="form-control"
                                   value="1605021584"/>
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="col-md-4 text-right">NOTE</div>
                        <div class="col-md-6">
                            <textarea name="note" id="note" cols="2" rows="" class="form-control se-textarea">Test Deposit</textarea>
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="col-md-7"></div>
                        <div class="col-md-3">
                            <button type="submit" class="btn btn-success">
                                <i class="icon-ok"></i> Receive Payment</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-md-5">
            <div class="block se-block">
                <div class="header se-header  se-header-bl">
                    &Ropf;&eopf;&copf;&eopf;&iopf;&vopf;&eopf;&ropf; &Iopf;&nopf;&fopf;&oopf;
                </div>
                <div class="content controls">
                    <table class="table table-hover">
                        <tbody>
                        <tr>
                            <td class="font-bold">Sender Name</td>
                            <td>:</td>
                            <td>${operator.name!}</td>
                        </tr>
                        <tr>
                            <td class="font-bold">Staff Type</td>
                            <td>:</td>
                            <td>${operator.staffType!}</td>
                        </tr>
                        <tr>
                            <td class="font-bold">Is Active</td>
                            <td>:</td>
                            <td>${operator.active?string("Active", "Inactive")!}</td>
                        </tr>
                        <tr>
                            <td class="font-bold">Balance</td>
                            <td>:</td>
                            <td>${operator.cashAccount.balance!}</td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        <div class="col-md-1"></div>
    </div>
</form>


</@layout.se_app_layout>
