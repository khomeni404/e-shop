Ext.define('IBCS.view.contact.List' ,{
    extend: 'Ext.grid.Panel',
    alias : 'widget.contactlist',
    id: 'contactGrid',
    requires: ['Ext.toolbar.Paging'],
    
    iconCls: 'icon-grid',

    title : 'User List',
    height: 400,
    width:550,
    store: 'Contacts',
 

    columns: [{
    	header: "Name",
		width: 170,
		flex:1,
		dataIndex: 'name'
	},{
		header: "Username",
		width: 160,
		flex:1,
		dataIndex: 'email'
	},{
		header: "Date of Birth",
		width: 170,
		flex:1,
		dataIndex: 'phone'
	}],
	
	initComponent: function() {
		
		this.dockedItems = [{
            xtype: 'toolbar',
            dock: 'top',
            items: [{
                iconCls: 'icon-delete',
                text: 'Delete',
                action: 'delete'
            }]
        },{  xtype: 'pagingtoolbar',
            dock:'bottom',
            store: 'Contacts',
            displayInfo: true,
            displayMsg: 'Displaying contacts {0} - {1} of {2}',
            emptyMsg: "No contacts to display"
        }];
		
		this.callParent(arguments);
	}
});
