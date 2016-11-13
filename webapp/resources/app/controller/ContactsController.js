Ext.define('IBCS.controller.ContactsController', {
    extend: 'Ext.app.Controller',

    stores: ['Contacts'],

    models: ['Contact'],

    views: ['contact.Edit', 'contact.List', 'contact.Create'],

    refs: [{
            ref: 'contactsPanel',
            selector: 'panel'
        },{
            ref: 'contactlist',
            selector: 'contactlist'
        }
    ],

    init: function() {
        this.control({
            'contactlist dataview': {
                itemdblclick: this.editUser
            },
                        
            'contactCreate button[action=save]': {
            	click: this.saveUser
            },

            'contactCreate button[action=clear]': {
            	click: this.clearUserForm
            }, 
            
            'contactlist button[action=delete]': {
                click: this.deleteUser
            },
            
            'contactedit button[action=save]': {
                click: this.updateUser
            }
        });
    },
    
   
    editUser: function(grid, record) {
        var edit = Ext.create('IBCS.view.contact.Edit').show();
        
        if(record){
        	edit.down('form').loadRecord(record);
        }
    },
    
    deleteUser: function(button) {
    	
    	var grid = this.getContactlist(),
    	record = grid.getSelectionModel().getSelection(), 
        store = this.getContactsStore();

	    store.remove(record);
	    this.getContactsStore().sync();
    },
    
   
    
    updateUser: function(button) {
        var win    = button.up('window'),
            form   = win.down('form'),
            record = form.getRecord(),
            values = form.getValues();
        
        
		if (values.id > 0){
			record.set(values);
		} else{
			record = Ext.create('IBCS.model.Contact');
			record.set(values);
			record.setId(0);
			this.getContactsStore().add(record);
		}
        
		win.close();
        this.getContactsStore().sync();
    },
    
    saveUser : function(button){
    	console.log('Save Clicked...');
    	var form = button.up('form').getForm(),
            record = form.getRecord(),
            values = form.getValues();
        
        
		if (values.id > 0){
			record.set(values);
		} else{
			record = Ext.create('IBCS.model.Contact');
			record.set(values);
			record.setId(0);
			this.getContactsStore().add(record);
		}
		
		form.reset();
        this.getContactsStore().sync();
		
		/*
		var store = this.getContactsStore();
		store.sync({
	        success: function( response ) { 
	        	store.load();
	        	store.refresh();
            }
		});*/
		//this.getLoader().startAutoRefresh(500);
		//store.refresh();
        //this.getContactsStore().load();
        //this.getContactsStore().refresh();
        //this.getContactsStore().sync();
        //this.getContactsStore().load();
		//Ext.getCmp('contactGrid').getView().refresh();
        //var panel = this.getContactlist();
        //panel.reload();
        //var view = this.getListView();
        //view.refresh();
        //var grid = view.down('.contactlist');
        //grid.load();
        //grid.refresh();
        //console.log(this.getContactlist());
        //this.refresh();
        
        
        
    },
    
    
    
    clearUserForm: function(button, e, options) {
		console.log('Reset Button clicked');
		button.up('form').getForm().reset();
    	
    }
});
