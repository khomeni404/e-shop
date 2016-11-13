Ext.application({
	name : 'IBCS',

	controllers : [ 'ContactsController' ],

	launch : function() {
		Ext.create('IBCS.view.Viewport', {
			// layout: 'fit',
			padding : '0 400 0 400',
			items : [ {
				xtype : 'contactCreate'
			}, {
				xtype : 'contactlist'
			} ]
		});
	}
});
