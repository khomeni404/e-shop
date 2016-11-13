var comboBox2;
Ext.onReady(function () {
    Ext.define('Store', {
        extend: 'Ext.data.Model',
        fields: [
            {name: 'id', type: 'int'},
            {name: 'name', type: 'string'}
        ]
    });

   var myRemoteStore = Ext.create('Ext.data.Store', {
        model: 'Store',
        proxy: {
            type: 'ajax',
            url: '/e-shop/home/getStoreJsonData2.se',
            reader: {
                type: 'json',
                root: 'rows'
            }
        },
        autoLoad: true
    });


    comboBox2 = Ext.create('Ext.form.ComboBox', {
        fieldLabel: 'Store Name',
        name: 'storeId',
        store: myRemoteStore,// staticStore,
        queryMode: 'local',
        displayField: 'name',
        valueField: 'id',
        allowBlank: false,
        //renderTo: Ext.getBody(),
        listeners: {
            //scope: this,
            'select': function () {
                abc();
                //Ext.Msg.alert('Attention', this.getValue());
            }
        }
    });

});