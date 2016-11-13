/**
 * Created by MAK on 28/02/16.
 */


function abc() {
   var store = Ext.define('IBCS.store.Contacts', {
        extend: 'Ext.data.Store',
        model: 'IBCS.model.Contact',
        autoLoad: true,
        pageSize: 25,
        autoLoad: {start: 0, limit: 25},

        proxy: {
            type: 'ajax',
            api: {
                read : '/e-shop/contact/view.do'
                //,create : 'contact/create.do'
                //,update: 'contact/update.do'
                //,destroy: 'contact/delete.do'
            },
            reader: {
                type: 'json',
                root: 'data',
                successProperty: 'success'
            },
            writer: {
                type: 'json',
                writeAllFields: true,
                encode: false,
                root: 'data'
            },
            listeners: {
                exception: function(proxy, response, operation){
                    Ext.MessageBox.show({
                        title: 'REMOTE EXCEPTION',
                        msg: operation.getError(),
                        icon: Ext.MessageBox.ERROR,
                        buttons: Ext.Msg.OK
                    });
                }
            }
        }
    });
}