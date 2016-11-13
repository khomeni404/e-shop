/**
 * Created by MAK on 25/02/16.
 */
var staticData = [{"id": 1, "name": "Store 32", "salesLedgerList": [], "stockLedgerList": []}, {
    "id": 2,
    "name": "Store 2",
    "salesLedgerList": [],
    "stockLedgerList": []
}, {"id": 3, "name": "Store 3", "salesLedgerList": [], "stockLedgerList": []}];

var staticStore = Ext.create('Ext.data.Store', {
    fields: ['id', 'name'],
    data: staticData
});