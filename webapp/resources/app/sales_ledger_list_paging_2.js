function loadPagingGrid(){
    Ext.define('SalesLedger', {
        extend: 'Ext.data.Model',
        fields: [
            {name: 'id', type: 'long'}
            ,{name: 'orderNo', type: 'string'}
            ,{name: 'date', type: 'string'}
            ,{name: 'customerName', type: 'string'}
            ,{name: 'totalAmount', type: 'long'}
            ,{name: 'paidTotal', type: 'long'}
            ,{name: 'dueTotal', type: 'long'}
            ,{name: 'totalOff', type: 'long'}
        ]
    });

    var itemsPerPage = 2;
    var store = Ext.create('Ext.data.Store', {
        model: 'SalesLedger',
        autoLoad: true,
       // pageSize: itemsPerPage,
        proxy: {
            type: 'ajax',
            url: '/e-shop/home/getSalesLedgerJsonData.se',
            reader: {
                type: 'json',
                root: 'data'
            }
        }
    });



    // specify segment of data you want to load using params
    store.load({
        params:{
            start:0,
            limit: itemsPerPage
        }
    });

    Ext.create('Ext.grid.Panel', {
        title: 'Ledgers',
        store: store,
        columns: [
            {header: 'ID',  dataIndex: 'id'},
            {header: 'orderNo', dataIndex: 'orderNo'},
            {header: 'date', dataIndex: 'date'},
            {header: 'customerName', dataIndex: 'customerName'}
        ],
        width: 400,
        height: 125,
        dockedItems: [{
            xtype: 'pagingtoolbar',
            store: store,   // same store GridPanel is using
            dock: 'bottom',
            displayInfo: true
        }],
        renderTo: Ext.get('nested')
    });
}