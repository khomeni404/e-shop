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
    <div class="col-md-1"></div>
    <div class="col-md-10">
        <div class="block se-block">
            <div class="header se-header">
                &Jopf;&oopf;&uopf;&ropf;&nopf;&aopf;&lopf; &Vopf;&oopf;&uopf;&copf;&hopf;&eopf;&ropf; &Copf;&ropf;&eopf;&aopf;&topf;&eopf;
            </div>
        </div>
    </div>
</div>
<form action="${ctx}/accounts/saveJournalVoucher.se" method="post">
    <input type="hidden" name="drAcHolderId" value="${operator.id!}"/>
    <div class="row">
        <div class="col-md-1"></div>
        <div class="col-md-5">
            <div class="block se-block">
                <div class="header  se-header-bl">
                 <b>  &Sopf;&eopf;&nopf;&dopf;&eopf;&ropf; &Iopf;&nopf;&fopf;&oopf;</b>
                </div>
                <div class="content controls">
                    <table class="table table-hover">
                        <tbody>
                        <tr>
                            <td class="se-dt-left">Sender Name</td>
                            <td class="se-dt-center">:</td>
                            <td class="se-dt-right">${operator.name!}</td>
                        </tr>
                        <tr>
                            <td class="se-dt-left">Staff Type</td>
                            <td class="se-dt-center">:</td>
                            <td class="se-dt-right">${operator.staffType!}</td>
                        </tr>
                        <tr>
                            <td class="se-dt-left">Is Active</td>
                            <td class="se-dt-center">:</td>
                            <td class="se-dt-right">${operator.active?string("Active", "Inactive")!}</td>
                        </tr>
                        <tr>
                            <td class="se-dt-left">Balance</td>
                            <td  class="se-dt-center">:</td>
                            <td class="se-dt-right">${operator.cashAccount.balance!}</td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        <div class="col-md-5">
            <div class="block se-block">
                <div class="header se-header  se-header-bl">
                    &Ropf;&eopf;&copf;&eopf;&iopf;&vopf;&eopf;&ropf; &Iopf;&nopf;&fopf;&oopf;
                </div>
                <div class="content controls">
                    <div class="form-row">
                        <div class="col-md-4 text-right">RECEIVER</div>
                        <div class="col-md-6">
                            <select name="crAcHolderId" class="form-control se-select" id="crAcHolderId" onchange="setCustomerName()">
                                <option value="0">--Select Staff--</option>
                                <#list staffList as staff>
                                    <option value="${staff.id!}">${staff.name!}</option>
                                </#list>
                            </select>
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="col-md-4 text-right">TRANSFER AMT</div>
                        <div class="col-md-6">
                            <input type="text" name="amount" id="amount"
                                   class="form-control"
                                   value=""/>
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="col-md-4 text-right">NOTE</div>
                        <div class="col-md-6">
                            <textarea name="note" id="note" cols="2" rows="" class="form-control se-textarea">Test Transfers</textarea>
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="col-md-7"></div>
                        <div class="col-md-3">
                            <button type="submit" class="btn btn-success">
                                <i class="icon-share-sign"></i> Transfer</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-md-1"></div>
    </div>
</form>
<div class="row">
    <div class="col-lg-1"></div>
    <div class="col-lg-10">
        <div class="block se-block <#--block-fill-white-->">
            <div class="header se-header se-header-bl">
                 &Lopf;&iopf;&sopf;&topf;
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
                            <td>${voucher.amount!}</td>
                            <td>${voucher.sender.name!}</td>
                            <td>${voucher.receiver.name!}</td>
                            <td>${statusArr[voucher.status]!}</td>
                            <#if voucher.status == 0>
                                <td class="text-center"><a href="${ctx}/accounts/acceptJournalVoucher.se?vrId=${voucher.id}" class="btn btn-info"><i class="icon-ok"></i>&nbsp;&nbsp;Accept</a></td>
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



<#--
<div class="col-lg-3">
                    <table class="table table-bordered table-hover">
                        <#list downStockList as dStock>
                            <tr>
                                <td>${dStock.name!}</td>
                                <td>${dStock.stock}</td>
                            </tr>
                        </#list>

                    </table>
                </div>
-->
</@layout.se_app_layout>

<script>
    var totalPrice = 0;
    $(".calculate").live('keyup', function () {
        var $row = $(this).closest("tr");
        var qty = eval($row.find(".qty-arr").val());
        var discount = eval($row.find(".discount-arr").val());
        var price = eval($row.find(".price-arr").val());
        $row.find(".tot-price-arr").val(qty * (price - discount));
        totalPrice = 0;
        jQuery("input[name='totPriceArr']").each(function () {
            totalPrice += eval($(this).val());
        });
        $('#totalPrice').val(totalPrice);
    });


    $(".item-arr").live('change', function () {
        var item = $(this).find('option:selected');
        var unitName = item.attr("unitName");
        var price = item.attr("labeledPrice");
        var stock = item.attr("stock");
        var $row = $(this).closest("tr");
        var qty = $row.find(".qty-arr");
        qty.attr("placeholder", unitName);
        $row.find(".price-arr").val(price);
        $row.find(".stock").val(stock);
        if (eval(stock) <= 0)
            qty.attr('readonly', true);
        else
            qty.attr('readonly', false);
        qty.focus();
    });


    function addRow(tableID) {
        var table = document.getElementById(tableID);
        var rowCount = table.rows.length;
        var row = table.insertRow(rowCount);
        var newRowCount = rowCount - 1;     // 1
        var oldRowCount = rowCount - 2;     // 0
        var colCount = table.rows[rowCount - 1].cells.length;
        for (var i = 0; i < colCount; i++) {
            var newCell = row.insertCell(i);
            var cell = table.rows[rowCount - 1].cells[i].innerHTML;
            //cell = cell.replace(property + "[" + oldRowCount + "]", property + "[" + newRowCount + "]");
            newCell.innerHTML = cell;
            switch (newCell.childNodes[0].type) {
                case "text":
                    newCell.childNodes[0].value = "";
                    break;
                case "checkbox":
                    newCell.childNodes[0].checked = false;
                    break;
                case "select-one":
                    newCell.childNodes[0].selectedIndex = 0;
                    break;
            }
        }
    }

    function deleteRow(tableID, rowId) {
        try {
            var table = document.getElementById(tableID);
            var rowCount = table.rows.length;
            if (rowCount <= 2) {
                alert("Cannot delete all the rows.");
            }
            else {
                var i = rowId.parentNode.parentNode.rowIndex;
                document.getElementById(tableID).deleteRow(i);
            }
        } catch (e) {
            alert(e);
        }
    }

    function setCustomerName() {
        var obj = $("#customerId option:selected");
        var id = obj.val();
        if (id != 0) {
            var name = obj.text();
            $('#customerName').val(name);
        } else {
            $('#customerName').val("");
        }
    }

</script>