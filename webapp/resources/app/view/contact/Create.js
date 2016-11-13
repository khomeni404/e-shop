Ext.define('IBCS.view.contact.Create', {
	extend : 'Ext.form.Panel',
	alias : 'widget.contactCreate',

	requires: ['Ext.form.Panel','Ext.form.field.Text','Ext.form.field.Date'],

    title : 'Create User',
    //layout: 'fit',
    autoShow: true,
    width: 550,
    padding: '10 0 10 0',
    
    iconCls: 'icon-user-add',

    initComponent: function() {
        this.items = [
            {
                xtype: 'form',
                padding: '5 5 0 5',
                border: false,
                //style: 'background-color: #fff;',
                
                fieldDefaults: {
                    anchor: '100%',
                    labelAlign: 'left',
                    allowBlank: false,
                    combineErrors: true,
                    msgTarget: 'side'
                },

                items: [
					{
					    xtype: 'textfield',
					    name : 'id',
					    fieldLabel: 'id',
					    hidden:true
					},    
                    {
                        xtype: 'textfield',
                        name : 'name',
                        fieldLabel: 'Name'
                    },
                    {
                        xtype: 'textfield',
                        name : 'email',
                        fieldLabel: 'Username',
                        msgTarget : 'under',
                		listeners : {
                			blur : function(field, event) {
                				//var form = this.up('form').getForm();
                				//var passField = form.findField('password');
                				var username = field.getValue(); //form.findField('username').getSubmitValue();
                				//var xyz = field.getValue().trim();
                				//console.log('xyzs = '+xyz);
                				Ext.Ajax.request({
                					url : '/ext4-crud-mvc/contact/checkDuplicateUser.do',
                					params : {
                						username : username
                					},
                					failure : function(conn, response, options, eOpts) {
                						Ext.Msg.show({
                							title : 'Server Error',
                							msg : conn.responseText,
                							icon : Ext.Msg.ERROR,
                							buttons : Ext.Msg.OK
                						});
                					},
                					success : function(conn, response, options, eOpts) {
                						var result = Ext.JSON.decode(conn.responseText, true);

                						if (result.success) {
                							field.clearInvalid();
                							validfield = true;
                							//passField.focus();
                						} else {
                							field.markInvalid(result.msg);
                							field.focus();
                						}
                					}
                				});

                			},
                			specialkey : function(f, e) {
                				if (e.getKey() == e.ENTER) {
                					var form = this.up('form').getForm();
                					var field = form.findField('password');
                					field.focus();
                				}
                			}
                		}
                    },
                    {
                        xtype: 'datefield',
                        name : 'phone',
                        value:'01/09/2015',
                        fieldLabel: 'DOB'
                    }
                ]
            }
        ];
        
        this.dockedItems = [{
            xtype: 'toolbar',
            dock: 'bottom',
            id:'buttonsCreate',
            ui: 'footer',
            items: ['->', {
                iconCls: 'icon-save',
                itemId: 'save',
                text: 'Save',
                action: 'save'
            },{
                iconCls: 'icon-reset',
                itemId: 'clear',
                text: 'Clear',
                action: 'clear'
                
                //scope: this,
                //handler: this.close,
                
            }]
        }];

        this.callParent(arguments);
    }

});