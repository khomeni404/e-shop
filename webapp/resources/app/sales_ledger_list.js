/**
 * Created by MAK on 28/02/16.
 */


function showStockLedgerList() {
    Ext.define('SalesLedger', {
        extend: 'Ext.data.Model',
        fields: [
            {name: 'orderNo', type: 'string'},
            {name: 'date', type: 'string'},
            {name: 'customerName', type: 'string'}
            ,{name: 'totalAmount', type: 'long'}
            ,{name: 'paidTotal', type: 'long'}
            ,{name: 'dueTotal', type: 'long'}
            ,{name: 'totalOff', type: 'long'}
        ]
    });

    var stock_ledger_data_store = Ext.create('Ext.data.Store', {
        model: 'SalesLedger',
        buffered: true,
        pageSize: 2,
        proxy: {
            type: 'ajax',
            url: '/e-shop/home/getSalesLedgerJsonData.se',
            reader: {
                type: 'json',
                root: 'rows'
            }
        },
        autoLoad: true
    });


    var stock_ledger_grid = Ext.create('Ext.grid.Panel', {
        title: 'Sales Ledger',
        store: stock_ledger_data_store,
        columns: [
            {header: 'Order No', dataIndex: 'orderNo'},
            {header: 'Order date', dataIndex: 'date'},
            {header: 'customerName', dataIndex: 'customerName'},
            {header: 'Total Amount', dataIndex: 'totalAmount'}
            , {header: 'paidTotal', dataIndex: 'paidTotal'}
            , {header: 'dueTotal', dataIndex: 'dueTotal'}
            , {header: 'totalOff', dataIndex: 'totalOff'}
        ],
        height: 200,
        width: 900,
        /*autoLoad: true,
        verticalScroller: {
            trailingBufferZone: 2,  // Keep 200 records buffered in memory behind scroll
            leadingBufferZone: 2   // Keep 5000 records buffered in memory ahead of scroll
        },*/
        renderTo: Ext.get('nested')
    });

   /* new Ext.Panel({
        width: 500,
        //padding: 20,
        height: 500,
        title: 'stock_ledger_grid',
        frame: true,
        items: [stock_ledger_grid],
        renderTo: Ext.get('nested')
    });*/

}
