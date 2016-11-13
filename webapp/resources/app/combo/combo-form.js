/**
 * Copyright (C) 2002-2003 Islami Bank Bangladesh Limited
 * <p>
 * Original author: Ayatullah Khomeni<br/>
 * Date: 25/02/2016
 * Last modification by: ayat $
 * Last modification on 25/02/2016: 3:50 PM
 * Current revision: : 1.1.1.1
 * <p/>
 * Revision History:
 * ------------------
 */

var myRemoteStore;
var comboBox;
var comboFormPanel;

Ext.onReady(function() {
    Ext.define('Store', {
        extend: 'Ext.data.Model',
        fields: [
            {name: 'id', type: 'int'},
            {name: 'name', type: 'string'}
        ]
    });

    myRemoteStore = Ext.create('Ext.data.Store', {
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


    comboBox = Ext.create('Ext.form.ComboBox', {
        fieldLabel: 'Choose State',
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


    comboFormPanel = Ext.create('Ext.form.Panel', {
        title: 'Simple Form',
        bodyPadding: 5,
        width: 350,

        // The form will submit an AJAX request to this URL when submitted
        url: 'save-form.php',

        // Fields will be arranged vertically, stretched to full width
        layout: 'anchor',
        defaults: {
            anchor: '100%'
        },

        // The fields
        defaultType: 'textfield',
        items: [{
            fieldLabel: 'First Name',
            name: 'first',
            allowBlank: false
        }, {
            fieldLabel: 'Last Name',
            name: 'last',
            allowBlank: false
        },
            comboBox],

        // Reset and Submit buttons
        buttons: [{
            text: 'Reset',
            handler: function () {
                this.up('form').getForm().reset();
            }
        }, {
            text: 'Submit',
            formBind: true, //only enabled once the form is valid
            disabled: true,
            handler: function () {
                var form = this.up('form').getForm();
                if (form.isValid()) {
                    form.submit({
                        success: function (form, action) {
                            Ext.Msg.alert('Success', action.result.msg);
                        },
                        failure: function (form, action) {
                            Ext.Msg.alert('Failed', action.result.msg);
                        }
                    });
                }
            }
        }]
    });
});