package com.supp.work.soft.client.vue;

import java.util.Date;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.BlurEvent;
import com.google.gwt.event.dom.client.BlurHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyDownHandler;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.supp.work.soft.client.DRH_SUPPWORK_SOFT;
import com.supp.work.soft.client.service.UserService;
import com.supp.work.soft.client.service.UserServiceAsync;
import com.supp.work.soft.shared.FieldVerifier;
import com.supp.work.soft.shared.model.Utilisateur;

public class ChangePassword implements IsWidget {
	PasswordTextBox password;
	Label lPassword;
	PasswordTextBox confirm;
	Label lConfirm;
	Label entete;
	Label error;
	Button valider;
	Image logo;
	Image systeme;

	VerticalPanel gVerticalPanel;
	VerticalPanel logoVerticalPanel;
	HorizontalPanel hPanel;
	HorizontalPanel logEtImage;
	VerticalPanel vPanel1;
	VerticalPanel vPanel2;

	VerticalPanel form;

	public static String log;
	public static String typeUser;
	public static String pass;
	private final UserServiceAsync serviceEnregistrer = GWT
			.create(UserService.class);

	public ChangePassword() {

		// Instenciation des variables
		vPanel1 = new VerticalPanel();
		vPanel1.setStyleName("vPanel1");
		vPanel2 = new VerticalPanel();
		vPanel2.setStyleName("vPanel1");
		password = new PasswordTextBox();
		password.setStyleName("text");

		form = new VerticalPanel();
		form.setStyleName("form");
		confirm = new PasswordTextBox();
		confirm.setStyleName("text");

		valider = new Button("Valider");
		valider.setStyleName("valider");

		lPassword = new Label("New password");
		lPassword.setStyleName("label");
		lConfirm = new Label("Confirm");
		lConfirm.setStyleName("label");

		vPanel1.add(lPassword);
		vPanel1.add(password);
		vPanel2.add(lConfirm);
		vPanel2.add(confirm);

		hPanel = new HorizontalPanel();
		logoVerticalPanel = new VerticalPanel();
		logoVerticalPanel.setStyleName("logoVerticalPanel");
		logEtImage = new HorizontalPanel();
		logEtImage.setStyleName("logEtImage");
		gVerticalPanel = new VerticalPanel();
		gVerticalPanel.setStyleName("gVerticalPanelLog");

		entete = new Label("Change your password");
		entete.setStyleName("entete");

		error = new Label();
		error.setStyleName("loginError");

		logo = new Image("images/logo.png");
		logo.setStyleName("logoLogin");

		systeme = new Image("images/systeme.png");

		// Ajout des ecouteurs
		// valider.addClickHandler(new ClickHandler() {
		//
		// @Override
		// public void onClick(ClickEvent event) {
		// // TODO Auto-generated method stub
		// // Window.alert("Bonjour");
		// //
		// //
		// greet.bonjour(new AsyncCallback<String>(){
		//
		// @Override
		// public void onFailure(Throwable caught) {
		// // TODO Auto-generated method stub
		//
		// }
		//
		// @Override
		// public void onSuccess(String result) {
		// // TODO Auto-generated method stub
		// Window.alert(result);
		// }});
		//

		// try {
		// // Window.alert("password");
		// serviceEnregistrer.rechercher(login.getText(),
		// password.getText(), new AsyncCallback<Utilisateur>() {
		//
		// @Override
		// public void onFailure(Throwable caught) {
		// // TODO Auto-generated method stub
		//
		// }
		//
		// @Override
		// public void onSuccess(Utilisateur result) {
		// // TODO Auto-generated method stub
		// if (result != null) {
		// error.setVisible(false);
		// typeUser = result.getTypeuser();
		// log = result.getLogin();
		// pass = result.getPassword();
		// if (result.getNbrfoislog().equals("0")) {
		// new ChangePasswordModal().show();
		// } else {
		// try {
		// if (result.getTypeuser().equals(
		// "Super Utilisateur")
		// && login.getText().equals(
		// result.getLogin())
		// && password.getText().equals(
		// result.getPassword())) {
		// DRH_SUPPWORK_SOFT.hPanel.clear();
		// DRH_SUPPWORK_SOFT.hPanel
		// .add(new FenetreAdmin()
		// .asWidget());
		// } else {
		// if (login.getText().equals(
		// result.getLogin())
		// && password
		// .getText()
		// .equals(result
		// .getPassword())) {
		// DRH_SUPPWORK_SOFT.hPanel
		// .clear();
		// DRH_SUPPWORK_SOFT.hPanel
		// .add(new FenetrePrincipale()
		// .asWidget());
		// }
		// }
		// } catch (Exception e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// Window.alert(e.getMessage());
		// }
		// // Window.alert("password1========");
		// }
		// } else {
		//
		// error.setVisible(true);
		// error.setText("Mot de passe incorrect");
		// password.setText(null);
		// password.setStyleName("password");
		// password.setPlaceholder("Mot de passe incorrect");
		// }
		// }
		// });
		// } catch (Exception e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// }
		// });

		confirm.addKeyDownHandler(new KeyDownHandler() {

			@Override
			public void onKeyDown(KeyDownEvent event) {
				// TODO Auto-generated method stub
				if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
					try {
						if(password.getText().equals(confirm.getText())){
							Utilisateur utilisateur = new Utilisateur();
							utilisateur.setLogin(Login.log);
							utilisateur.setPassword(password.getText());
							utilisateur.setTypeUser(Login.typeUser);
							utilisateur.setModifierPar(Login.log);
							utilisateur.setModifierLe(FieldVerifier.formateDate(new Date()));
							serviceEnregistrer.modifier(utilisateur,
									new AsyncCallback<String>() {

										@Override
										public void onFailure(Throwable caught) {
											// TODO Auto-generated method stub

										}

										@Override
										public void onSuccess(String result) {
											// TODO Auto-generated method stub
											if (result.equals("Modification reussie")) {
												Login.dialog.hide();
												DRH_SUPPWORK_SOFT.hPanel
												.clear();
										DRH_SUPPWORK_SOFT.hPanel
												.add(new FenetrePrincipale()
														.asWidget());
											}
										}
									});
						}else{
							error.setVisible(true);
							error.setText("Mots de passe differents");
							password.setText(null);
							lPassword.setStyleName("label2");
							lConfirm.setStyleName("label2");
							vPanel1.setStyleName("vPanel3");
							vPanel2.setStyleName("vPanel3");
						}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});

		valider.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				try {
					if(password.getText().equals(confirm.getText())){
						Utilisateur utilisateur = new Utilisateur();
						utilisateur.setLogin(Login.log);
						utilisateur.setPassword(password.getText());
						utilisateur.setTypeUser(Login.typeUser);
						utilisateur.setModifierPar(Login.log);
						utilisateur.setModifierLe(FieldVerifier.formateDate(new Date()));
						serviceEnregistrer.modifier(utilisateur,
								new AsyncCallback<String>() {

									@Override
									public void onFailure(Throwable caught) {
										// TODO Auto-generated method stub

									}

									@Override
									public void onSuccess(String result) {
										// TODO Auto-generated method stub
										if (result.equals("Modification reussie")) {
											Login.dialog.hide();
											DRH_SUPPWORK_SOFT.hPanel
											.clear();
									DRH_SUPPWORK_SOFT.hPanel
											.add(new FenetrePrincipale()
													.asWidget());
										}
									}
								});
					}else{
						error.setVisible(true);
						error.setText("Mots de passe differents");
						password.setText(null);
						lPassword.setStyleName("label2");
						lConfirm.setStyleName("label2");
						vPanel1.setStyleName("vPanel3");
						vPanel2.setStyleName("vPanel3");
					}
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		password.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub

				if (password.getText().equals("")) {
					lPassword.setStyleName("label1");
					vPanel1.setStyleName("vPanel2");
				} else {
					lPassword.setStyleName("label1");
				}
			}
		});

		// tboxChiffre1.
		password.addBlurHandler(new BlurHandler() {

			@Override
			public void onBlur(BlurEvent event) {
				// TODO Auto-generated method stub
				if (password.getText().equals("")) {
					// Window.alert("");
					lPassword.setStyleName("label");
					vPanel1.setStyleName("vPanel1");
				}
			}
		});

		password.addKeyUpHandler(new KeyUpHandler() {

			@Override
			public void onKeyUp(KeyUpEvent event) {
				// TODO Auto-generated method stub
				if (event.getNativeKeyCode() == KeyCodes.KEY_TAB) {
					if (password.getText().equals("")) {
						lPassword.setStyleName("label1");
						vPanel1.setStyleName("vPanel2");
					} else {
						lPassword.setStyleName("label1");
					}
				}
			}
		});

		confirm.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				if (confirm.getText().equals("")) {
					lConfirm.setStyleName("label1");
					vPanel2.setStyleName("vPanel2");
				} else {
					lConfirm.setStyleName("label1");
				}
			}
		});

		// tboxChiffre1.
		confirm.addBlurHandler(new BlurHandler() {

			@Override
			public void onBlur(BlurEvent event) {
				// TODO Auto-generated method stub
				if (confirm.getText().equals("")) {
					// Window.alert("");
					lConfirm.setStyleName("label");
					vPanel2.setStyleName("vPanel1");
				}
			}
		});

		confirm.addKeyUpHandler(new KeyUpHandler() {

			@Override
			public void onKeyUp(KeyUpEvent event) {
				// TODO Auto-generated method stub
				if (event.getNativeKeyCode() == KeyCodes.KEY_TAB) {

					if (confirm.getText().equals("")) {
						lConfirm.setStyleName("label1");
						vPanel2.setStyleName("vPanel2");
					} else {
						lConfirm.setStyleName("label1");
					}
				}
			}
		});

		// valider.addClickHandler(new ClickHandler() {
		//
		// @Override
		// public void onClick(ClickEvent event) {
		// // TODO Auto-generated method stub
		//
		// DRH_SUPPWORK_SOFT.hPanel.clear();
		// DRH_SUPPWORK_SOFT.hPanel.add(new FenetreAdmin().asWidget());
		// }
		// });

		// Ajout des elements dans leurs conteneurs

		logoVerticalPanel.add(entete);
		logoVerticalPanel.add(logo);

		hPanel.add(valider);
		form.add(logoVerticalPanel);
		form.add(error);
		form.add(vPanel1);
		form.add(vPanel2);
		form.add(valider);
		logEtImage.add(form);
		logEtImage.add(systeme);
		gVerticalPanel.add(logEtImage);

	}

	@Override
	public Widget asWidget() {
		// TODO Auto-generated method stub
		return gVerticalPanel;
	}

}
