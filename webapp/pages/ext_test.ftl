<#--
<link href="../resources/taurus/HTML/css/stylesheets.css" rel="stylesheet" type="text/css"/>
-->

<link rel="stylesheet" type="text/css" href="../resources/ExtJS-4.0.0/resources/css/ext-all.css" />
<script type="text/javascript" src="../resources/ExtJS-4.0.0/ext-all.js"></script>

<#--<#include "../se_template/script.ftl">-->
<script src="../resources/app/combo/combo-form.js"></script>
<script src="../resources/app/combo/store-combo.js"></script>
<script src="../resources/app/combo/category-combo.js"></script>
<script src="../resources/app/combo/item-create.js"></script>
<script src="../resources/app/sales_ledger_list.js"></script>
<script src="../resources/app/sales_ledger_list_paging_2.js"></script>
<script src="../resources/app/sales_ledger_list_paging_3.js"></script>

<body class="td-color1" background="http://cdn.backgroundhost.com/backgrounds/subtlepatterns/diagonal_striped_brick.png">
<div class="row">
    <table>
        <tr style="vertical-align: top">
            <td width="10"></td>
            <td>
                <div class="col-lg-2">
                    <h1> Window</h1>
                    <input type="button" id="show-btn" style="cursor: hand" value="Create Item"/><br/><br/>
                    <input type="button" id="sales-ledger-list" style="cursor: hand" value="Create Item"/><br/><br/>
                    <input type="button" id="sales-ledger-list-paging" style="cursor: hand" value="Paging"/><br/><br/>
                    <input type="button" id="sales-ledger-list-paging_2" style="cursor: hand" value="Paging 2"/><br/><br/>
                    <input type="button" id="sales-ledger-list-paging_3" style="cursor: hand" value="Paging 3"/><br/><br/>
                    <input type="button" id="combo-form-btn"  style="cursor: hand"  value="View Combo Form"/><br/><br/>
                </div>
            </td>
            <td><div class="col-lg-8" style="margin: 20px 20px 20px 20px" id="nested"></div></td>
        </tr>
    </table>




</div>
</body>
<script>

    Ext.get('sales-ledger-list-paging_3').on('click', function () {
        Ext.fly('nested').update('');
        loadPagingGrid3()
    });
    Ext.get('sales-ledger-list-paging').on('click', function () {
        Ext.fly('nested').update('');
        loadPageigGrid()
    });
    Ext.get('sales-ledger-list-paging_2').on('click', function () {
        Ext.fly('nested').update('');
        loadPagingGrid()
    });

    Ext.get('sales-ledger-list').on('click', function () {
        Ext.fly('nested').update('');
        showStockLedgerList()
    });
    Ext.get('combo-form-btn').on('click', function () {
        Ext.fly('nested').update('');
        new Ext.Panel({
            width: 500,
            //padding: 20,
            height: 500,
            title: 'Item Create',
            frame: true,
            items: [comboFormPanel],
            renderTo: Ext.get('nested')
        });
    });
    Ext.get('combo-form-btn').on('click', function () {
        Ext.fly('nested').update('');
        new Ext.Panel({
            width: 500,
            //padding: 20,
            height: 500,
            title: 'Item Create',
            frame: true,
            items: [comboFormPanel],
            renderTo: Ext.get('nested')
        });
    });


    Ext.get('show-btn').on('click', function () {
        Ext.fly('nested').update('');
        //if (!myGenPanel) {
        new Ext.Panel({
            width: 500,
            //padding: 20,
            height: 500,
            title: 'Item Create',
            frame: true,
            items: [genFormPanel],
            renderTo: Ext.get('nested')
        });
        //}
    });
</script>