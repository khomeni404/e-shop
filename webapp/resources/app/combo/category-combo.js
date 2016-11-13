var categoryCombo;
Ext.onReady(function () {
    Ext.define('Category', {
        extend: 'Ext.data.Model',
        fields: [
            {name: 'id', type: 'int'},
            {name: 'name', type: 'string'}
        ]
    });

   var categoryComboDataStore = Ext.create('Ext.data.Store', {
        model: 'Category',
        proxy: {
            type: 'ajax',
            url: '/e-shop/home/getCategoryComboJsonData.se',
            reader: {
                type: 'json',
                root: 'rows'
            }
        },
        autoLoad: true
    });


    categoryCombo = Ext.create('Ext.form.ComboBox', {
        fieldLabel: 'Category Name',
        name: 'catId',
        store: categoryComboDataStore,// staticStore,
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