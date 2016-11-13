<#import "../se_template/se_app_layout.ftl" as layout>
<@layout.se_app_layout "Test" >
    <#assign ctx = rc.getContextPath()/>
<style>
    th {
        text-align: center
    }
    #sales-ledger-item-table tr th, td {
        border: 1px solid black
    }
</style>

<form action="${ctx}/shop/saveSalesLedger.se" method="post">
    <input type="hidden" name="storeId" value="1"/>
    <input type="hidden" name="sourceName" value="Sales"/>

    <div class="row">

        <div class="col-md-12" style="color: red; font-size: 20px;">${message!}</div>
        <div class="col-md-1"></div>
        <div class="col-md-10">
            <div class="block se-block <#--block-fill-white-->">
                <div class="header se-header" >
                    &Sopf;&aopf;&lopf;&eopf;&sopf; &Oopf;&ropf;&dopf;&eopf;&ropf;
                </div>
                <div class="content controls">
                    <#--<div class="form-row">
                        <div class="col-md-2 text-right">ORDER NO.</div>
                        <div class="col-md-3">
                            <input type="text" name="orderNo" id="orderNo" class="form-control" value="10001"/>
                        </div>

                        <div class="col-md-2 text-right">ORDER DATE</div>
                        <div class="col-md-3">
                            <div class="input-group">
                                <div class="input-group-addon"><span class="icon-calendar"></span></div>
                                <input type="text"  name="orderDate" id="orderDate" class="datepicker form-control" value=""/>
                            </div>
                        </div>
                    </div>-->
                    <div class="form-row">
                        <div class="col-md-2 text-right">CUSTOMER</div>
                        <div class="col-md-3">
                            <select name="customerId" id="customerId" onchange="setCustomerName()" class="form-control se-select">
                                <option value="0">--Select Customer--</option>
                                <#list customerList as cust>
                                    <option value="${cust.id!}">${cust.name!}</option>
                                </#list>
                            </select>
                        </div>
                        <div class="col-md-2 text-right">CUSTOMER NAME</div>
                        <div class="col-md-3">
                            <input type="text" name="customerName" id="customerName"
                                                     class="form-control"
                                                     value=""/>
                        </div>

                    </div>

                    <div class="form-row">
                        <div class="col-md-2 text-right">CALCULATED PRICE</div>
                        <div class="col-md-3">
                            <input type="text" name="" id="totalPrice" disabled="disabled" style="color: green; font-weight: bold"
                                                     class="form-control"
                                                     value=""/>
                        </div>
                        <div class="col-md-2 text-right">PAYABLE AMT</div>
                        <div class="col-md-3">
                            <input type="text" name="payable" id="payable"
                                   class="form-control" disabled="disabled" style="color: green; font-weight: bold"
                                   value=""/>
                        </div>

                    </div>
                    <div class="form-row">
                        <div class="col-md-2 text-right">ROUND DISCOUNT</div>
                        <div class="col-md-3">
                            <input type="text" name="roundDiscount" onkeyup="setPayableAmt(this.value)" id="roundDiscount"
                                   class="form-control"
                                   value=""/>
                        </div>

                        <div class="col-md-2 text-right">PAID TOTAL</div>
                        <div class="col-md-3">
                            <input type="text" name="paid" id="paid"
                                   class="form-control"
                                   value=""/>
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="col-md-7"></div>
                        <div class="col-md-3"><input type="submit" class="form-control btn btn-success"
                                                     value="Save Order"/>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-lg-1"></div>
        <div class="col-lg-10">
            <div class="block se-block <#--block-fill-white-->">
                <div class="header se-header" >
                    &Iopf;&topf;&eopf;&mopf; &Lopf;&iopf;&sopf;&topf;
                </div>
                <div class="content">
                    <table id="sales-ledger-item-table" style="margin-left: 10px">
                        <thead>
                        <tr>
                            <th>Item Name</th>
                            <th>AVL.</th>
                            <th>QTY</th>
                            <th>TK./Unit</th>
                            <th>Off/Unit</th>
                            <th>Total Price</th>
                            <th>X</th>
                        </tr>
                        </thead>
                        <tr>
                        <#--<td>1.</td>-->
                            <td>
                                <select name="itemArr" class="item-arr item-comp se-select"
                                        style="width: 400px; height: 35px; padding-left: 10px">
                                    <option value="">--Select--</option>
                                    <#list itemList as item>
                                        <option value="${item.id!}" stock="${item.stock!}"
                                                labeledPrice="${item.labeledPrice!}"
                                                unitName="${item.unit.name!}">${item.name!}
                                            - ${item.stock!}</option>
                                    </#list>
                                </select>

                            </td>
                            <td><input type="text" name="stock" class="stock item-comp" readonly
                                       style="width: 60px; height: 35px; padding-right: 10px; text-align: right"/>
                            </td>
                            <td><input type="text" name="qtyArr" class="qty-arr calculate item-comp"
                                       style="width: 80px; height: 35px; padding-left: 5px; text-align: left"/>
                            </td>

                            <td><input type="text" name="priceArr" class="price-arr calculate item-comp"
                                       readonly
                                       style="width: 90px; height: 35px; padding-right: 10px; text-align: right"/>
                            </td>
                            <td><input type="text" name="discountArr" class="discount-arr calculate item-comp"
                                       value="0"
                                       style="width: 90px; height: 35px; padding-right: 10px; text-align: right"/>
                            </td>
                            <td><input type="text" name="totPriceArr" class="tot-price-arr item-comp"
                                       style="width: 100px; height: 35px; padding-right: 10px; text-align: right"/>
                            </td>
                            <td class="text-center">
                                <button style="margin: 2px 2px 2px 2px;" type="button"
                                        onclick="deleteRow('sales-ledger-item-table', this)"
                                        class="btn btn-danger"><i
                                        class="icon-minus"></i></button>
                            </td>
                        </tr>
                    </table>
                    <button style="margin-left: 10px; margin-top: 5px" type="button"
                            onclick="addRow('sales-ledger-item-table')" class="btn btn-success"><i
                            class="icon-plus"></i></button>
                </div>
            </div>

        </div>
    </div>

</form>

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
        jQuery("input[name='totPriceArr']").each(function() {
            totalPrice += eval($(this).val());
        });
        $('#totalPrice').val(totalPrice);
        $('#payable').val(totalPrice);
    });

    function setPayableAmt(roundDiscount) {
        //roundDiscount = eval(roundDiscount);
        var totalPrice = eval($('#totalPrice').val())
        $('#payable').val(totalPrice - roundDiscount);
    }

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
        if(id != 0) {
            var name = obj.text();
            $('#customerName').val(name);
        }else{
            $('#customerName').val("");
        }
    }

</script>