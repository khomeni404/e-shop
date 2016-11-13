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

var genFormPanel;
Ext.onReady(function () {
    genFormPanel = Ext.create('Ext.form.Panel', {
        title: 'Item Form',
        bodyPadding: 5,
        bodyStyle: 'padding: 5px 0 0 23px;',
        //width: 350,
        //url: 'saveItem2.se',
        //layout: 'anchor', //layout : 'fit',
        defaults: {
            anchor: '80%'
        },
        items: [{
            xtype: 'textfield'
            , name: 'name'
            , fieldLabel: 'User Id'
            , value: 'Busket Ball'
            , allowBlank: false
        }, {
            xtype: 'textfield'
            , name: 'itemCode'
            , fieldLabel: 'Item Code'
            , value: 'ET-0025'
            , allowBlank: false
        }, {
            xtype: 'textfield'
            , name: 'priceCode'
            , fieldLabel: 'Price Code'
            , value: 'WE3'
            , allowBlank: false
        },[
            categoryCombo
        ],{
            xtype: 'textfield'
            , name: 'purchasedPrice'
            , value: '20'
            , fieldLabel: 'Unit Id'
            //,vtype: 'email'
        }],

        buttons: [{
            text: 'Submit',
            formBind: true, //only enabled once the form is valid
            disabled: true,
            handler: function () {
                // The getForm() method returns the Ext.form.Basic instance:
                var form = this.up('form').getForm();
                if (form.isValid()) {
                    Ext.Ajax.request({
                        url: '/e-shop/home/saveItem2.se',
                        method: 'POST',
                        params: {
                            itemData: Ext.encode(form.getValues())
                        },
                        scope: this,
                        //method to call when the request is successful
                        success: function (response, opts) {
                            response = Ext.decode(response.responseText);
                            if (response.success) {
                                Ext.MessageBox.alert('Alhamdulillah...', response.message);
                            }
                            else {
                                Ext.MessageBox.alert('Ops !!', response.message);
                            }
                        },
                        failure: function (err) {
                            //Alert the user about communication error
                            Ext.MessageBox.alert('Server Error', 'Please try later!'+err);
                        }
                    });
                }
            }
        }]
    });
});