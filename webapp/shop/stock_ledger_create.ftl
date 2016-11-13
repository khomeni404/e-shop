<#import "../se_template/se_app_layout.ftl" as layout>
<@layout.se_app_layout "Test" >
    <#assign ctx = rc.getContextPath()/>
<style>
    th {
        text-align: center
    }

    #stock-ledger-item-table tr td {
        border: 1px solid black
    }

</style>
<form action="${ctx}/shop/saveStockLedger.se" method="post">
    <input type="hidden" name="storeId" value="1"/>

    <div class="row">
        <div class="col-md-1"></div>
        <div class="col-md-10">
            <div class="block se-block <#--block-fill-white-->">
                <div class="header se-header">
                    &Sopf;&topf;&oopf;&copf;&kopf; &Lopf;&eopf;&dopf;&gopf;&eopf;&ropf;
                </div>
                <div class="content controls">
                    <div class="form-row">
                        <div class="col-md-2 text-right">Source</div>
                        <div class="col-md-3">
                            <input type="text" name="" id="" class="form-control" disabled
                                   value="${source.name!}" style="color: black"/>
                            <input type="hidden" name="sourceId" value="${source.id!}"/>
                        </div>

                        <div class="col-md-2 text-right">Reference No.</div>
                        <div class="col-md-3"><input type="text" name="refNo" id="refNo" class="form-control"
                                                     value="10001"/>
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="col-md-2 text-right">Purchase Date</div>
                        <div class="col-md-3"><input type="text" name="orderDate" id="orderDate" class="form-control"
                                                     value="10/15/2015"/>
                        </div>

                        <div class="col-md-2 text-right">Vendor. Name</div>
                        <div class="col-md-3"><input type="text" name="vendorName" id="vendorName" class="form-control"
                                                     value="Alfaz Enterprize"/>
                        </div>
                    </div>


                    <div class="form-row">
                        <div class="col-md-2 text-right">Purchaser</div>
                        <div class="col-md-3">
                            <select name="propId" id="propId" class="form-control se-select">
                                <#list proprietorList as prop>
                                    <option value="${prop.id}">${prop.name}</option>
                                </#list>
                            </select>
                        </div>
                        <div class="col-md-2 text-right">Total Amt</div>
                        <div class="col-md-3"><input type="text" name="gt-price" id="gt-price" class="form-control"
                                                     readonly="readonly"
                                                     style="color: #000000; font-weight: bold;" value=""/>
                        </div>

                    </div>
                    <div class="form-row">
                        <div class="col-md-2 text-right"></div>
                        <div class="col-md-3">
                        </div>
                        <div class="col-md-2"></div>
                        <div class="col-md-3"><input type="submit" class="form-control btn btn-success"
                                                     value="Save Ledger"/>
                        </div>
                    </div>
                </div>
            </div>
        </div>


    <#--Items List-->
    </div>
    <div class="row">

        <div class="col-md-1"></div>
        <div class="col-md-10">
            <div class="block se-block <#--block-fill-white-->">
                <div class="header se-header">
                    &Iopf;&topf;&eopf;&mopf; &Lopf;&iopf;&sopf;&topf;
                </div>
                <div class="content">
                    <table id="stock-ledger-item-table" style="margin-left: 10px">
                        <thead>
                        <tr>
                            <th>Item Name</th>
                            <th>QTY</th>
                            <th>Purchased</th>
                            <th>Labeled</th>
                            <th>Total Price</th>
                        </tr>
                        </thead>
                        <tr>
                        <#--<td>1.</td>-->
                            <td>
                                <select name="itemArr" class="item-arr se-select"
                                        style="width: 400px; height: 35px; padding-left: 10px">
                                    <option value="">--Select--</option>
                                    <#list itemList as item>
                                        <option value="${item.id!}" unitName="${item.unit.name!}">${item.name!}</option>
                                    </#list>
                                </select>

                            </td>
                            <td><input type="text" name="qtyArr" class="qty-arr calculate"
                                       style="width: 80px; height: 35px; padding-left: 5px; text-align: left"/>
                            </td>

                            <td><input type="text" name="ppArr" class="pp-arr calculate"
                                       style="width: 100px; height: 35px; padding-right: 10px; text-align: right"/>
                            </td>
                            <td><input type="text" name="lpArr" class="lp-arr"
                                       style="width: 100px; height: 35px; padding-right: 10px; text-align: right"/>
                            </td>
                            <td><input type="text" name="tpArr" class="tp-arr"
                                       style="width: 120px; height: 35px; padding-right: 10px; text-align: right"/>
                            </td>
                            <td class="text-center no-border">
                                <button style="margin: 2px 2px 2px 2px;" type="button"
                                        onclick="deleteRow('stock-ledger-item-table', this)" class="btn btn-danger"><i
                                        class="icon-minus"></i></button>
                            </td>
                        </tr>
                    </table>
                <#--<table>
                    <tr class="text-right">
                        <td>Total Price =</td>
                        <td id="gt-price"></td>
                    </tr>
                </table>-->

                    <button style="margin-left: 10px; margin-top: 5px" type="button"
                            onclick="addRow('stock-ledger-item-table')" class="btn btn-success"><i
                            class="icon-plus"></i></button>
                </div>
            </div>
        </div>
    </div>

</form>
</@layout.se_app_layout>

<script>

    $(".calculate").live('keyup', function () {
        var $row = $(this).closest("tr");
        var qty = eval($row.find(".qty-arr").val());
        var pp = eval($row.find(".pp-arr").val());
        $row.find(".tp-arr").val(qty * pp);

        var gt = 0;
        $(".tp-arr").each(function () {
            var v = $(this).val();
            gt += parseInt(v);
        });
        $('#gt-price').val(gt);
    });


    $(".item-arr").live('change', function () {
        var item = $(this).find('option:selected');
        var unitName = item.attr("unitName");
        var $row = $(this).closest("tr");
        var unit = $row.find(".qty-arr");
        unit.attr("placeholder", unitName);
        unit.focus();
    });


    function addRow(tableID) {
        var table = document.getElementById(tableID);
        var rowCount = table.rows.length;
        var row = table.insertRow(rowCount);
        var colCount = table.rows[rowCount - 1].cells.length;
        for (var i = 0; i < colCount; i++) {
            var newCell = row.insertCell(i);
            var cell = table.rows[rowCount - 1].cells[i].innerHTML;
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
        /*$(".no-border").css({
            "border-top": 0,
            "border-right": 0,
            "border-bottom": 0
        })*/
    }

    function deleteRow(tableID, rowId) {
        try {
            var table = document.getElementById(tableID);
            var rowCount = table.rows.length;
            if (rowCount <= 2) {
                alert("Can't delete all the rows.");
            }
            else {
                var i = rowId.parentNode.parentNode.rowIndex;
                document.getElementById(tableID).deleteRow(i);
            }
        } catch (e) {
            alert(e);
        }
    }

</script>