package com.supp.work.soft.client;

import com.supp.work.soft.client.vue.Login;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.RootPanel;


/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class DRH_SUPPWORK_SOFT implements EntryPoint {
	public static HorizontalPanel hPanel;

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		hPanel=new HorizontalPanel();
		hPanel.add(new Login().asWidget());
		RootPanel.get().add(hPanel);
	}
}
