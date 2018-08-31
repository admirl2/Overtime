package com.supp.work.soft.client.vue;

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
import com.supp.work.soft.shared.model.Utilisateur;

public class Login implements IsWidget {
	TextBox login;
	Label lLogin;
	PasswordTextBox password;
	Label lPassword;
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
	private final UserServiceAsync serviceConnect = GWT
	 .create(UserService.class);
	
	public static DialogBox dialog;
	public Login() {

		// Instenciation des variables
		vPanel1 = new VerticalPanel();
		vPanel1.setStyleName("vPanel1");
		vPanel2 = new VerticalPanel();
		vPanel2.setStyleName("vPanel1");
		login = new TextBox();
		login.setStyleName("text");

		form = new VerticalPanel();
		form.setStyleName("form");
		password = new PasswordTextBox();
		password.setStyleName("text");

		valider = new Button("Valider");
		valider.setStyleName("valider");

		lLogin = new Label("Nom de l'utilisateur");
		lLogin.setStyleName("label");
		lPassword = new Label("Mot de passe");
		lPassword.setStyleName("label");

		vPanel1.add(lLogin);
		vPanel1.add(login);
		vPanel2.add(lPassword);
		vPanel2.add(password);

		hPanel = new HorizontalPanel();
		logoVerticalPanel = new VerticalPanel();
		logoVerticalPanel.setStyleName("logoVerticalPanel");
		logEtImage = new HorizontalPanel();
		logEtImage.setStyleName("logEtImage");
		gVerticalPanel = new VerticalPanel();
		gVerticalPanel.setStyleName("gVerticalPanelLog");

		entete = new Label("Veuillez-vous identifier");
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

		password.addKeyDownHandler(new KeyDownHandler() {

			@Override
			public void onKeyDown(KeyDownEvent event) {
				// TODO Auto-generated method stub
				if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
					try {
						serviceConnect.rechercher(login.getText(),
								password.getText(),
								new AsyncCallback<Utilisateur>() {

									@Override
									public void onFailure(Throwable caught) {
										// TODO Auto-generated method stub

									}

									@Override
									public void onSuccess(Utilisateur result) {
										// TODO Auto-generated method stub
										if (result != null) {
											error.setVisible(false);
											typeUser = result.getTypeUser();
											log = result.getLogin();
											pass = result.getPassword();
											if (result.getNbrFoisLog().equals(
													"0")) {
												
												dialog=new DialogBox();
												dialog.setWidget(new ChangePassword());
												dialog.show();
//												new ChangePassword()
//														.show();
											} else {
												try {
													if (result
															.getTypeUser()
															.equals("Super Utilisateur")) {
														DRH_SUPPWORK_SOFT.hPanel
																.clear();
														DRH_SUPPWORK_SOFT.hPanel
																.add(new FenetreAdmin()
																		.asWidget());
													} else {

														DRH_SUPPWORK_SOFT.hPanel
																.clear();
														DRH_SUPPWORK_SOFT.hPanel
																.add(new FenetreAdmin()
																		.asWidget());
														FenetreAdmin.dAdmin.setVisible(false);
														FenetreAdmin.dArchive.setVisible(false);
														FenetreAdmin.iArchive.setVisible(false);
														FenetreAdmin.iUser.setVisible(false);
														FenetreAdmin.lArchive.setVisible(false);
														FenetreAdmin.lUser.setVisible(false);
													}
												} catch (Exception e) {
													// TODO Auto-generated catch
													// block
													e.printStackTrace();
												}
											}
										} else {

											error.setVisible(true);
											error.setText("Mot de passe incorrect");
//											password.setText(null);
											lLogin.setStyleName("label2");
											lPassword.setStyleName("label2");
											vPanel1.setStyleName("vPanel3");
											vPanel2.setStyleName("vPanel3");
										}
									}
								});
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
					
					serviceConnect.rechercher(login.getText(),
							password.getText(),
							new AsyncCallback<Utilisateur>() {

								@Override
								public void onFailure(Throwable caught) {
									// TODO Auto-generated method stub
									Window.alert("the message is :  ==="+caught.getCause());
								}

								@Override
								public void onSuccess(Utilisateur result) {
									// TODO Auto-generated method stub
									
									if (result != null) {
									
										error.setVisible(false);
										typeUser = result.getTypeUser();
										log = result.getLogin();
										pass = result.getPassword();
										if (result.getNbrFoisLog().equals("0")) {
											dialog=new DialogBox();
											dialog.setWidget(new ChangePassword());
											dialog.show();
										} else {
											try {
												if (result
														.getTypeUser()
														.equals("Super Utilisateur")) {
													DRH_SUPPWORK_SOFT.hPanel
															.clear();
													DRH_SUPPWORK_SOFT.hPanel
															.add(new FenetreAdmin()
																	.asWidget());
												} else {

													DRH_SUPPWORK_SOFT.hPanel
															.clear();
													DRH_SUPPWORK_SOFT.hPanel
													.add(new FenetreAdmin()
															.asWidget());
											FenetreAdmin.dAdmin.setVisible(false);
											FenetreAdmin.dArchive.setVisible(false);
											FenetreAdmin.iArchive.setVisible(false);
											FenetreAdmin.iUser.setVisible(false);
											FenetreAdmin.lArchive.setVisible(false);
											FenetreAdmin.lUser.setVisible(false);

												}
											} catch (Exception e) {
												// TODO Auto-generated catch
												// block
												e.printStackTrace();
											}
										}
									} else {

										error.setVisible(true);
										error.setText("Mot de passe incorrect");
//										password.setText(null);
										lLogin.setStyleName("label2");
										lPassword.setStyleName("label2");
										vPanel1.setStyleName("vPanel3");
										vPanel2.setStyleName("vPanel3");
									}
								}
							});
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		login.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub

				if (login.getText().equals("")) {
					lLogin.setStyleName("label1");
					vPanel1.setStyleName("vPanel2");
				} else {
					lLogin.setStyleName("label1");
				}
			}
		});

		// tboxChiffre1.
		login.addBlurHandler(new BlurHandler() {

			@Override
			public void onBlur(BlurEvent event) {
				// TODO Auto-generated method stub
				if (login.getText().equals("")) {
					// Window.alert("");
					lLogin.setStyleName("label");
					vPanel1.setStyleName("vPanel1");
				}
			}
		});

		login.addKeyUpHandler(new KeyUpHandler() {

			@Override
			public void onKeyUp(KeyUpEvent event) {
				// TODO Auto-generated method stub
				if (event.getNativeKeyCode() == KeyCodes.KEY_TAB) {
					if (login.getText().equals("")) {
						lLogin.setStyleName("label1");
						vPanel1.setStyleName("vPanel2");
					} else {
						lLogin.setStyleName("label1");
					}
				}
			}
		});

		password.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				if (password.getText().equals("")) {
					lPassword.setStyleName("label1");
					vPanel2.setStyleName("vPanel2");
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
					vPanel2.setStyleName("vPanel1");
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
						vPanel2.setStyleName("vPanel2");
					} else {
						lPassword.setStyleName("label1");
					}
				}
			}
		});

//		valider.addClickHandler(new ClickHandler() {
//
//			@Override
//			public void onClick(ClickEvent event) {
//				// TODO Auto-generated method stub
//
//				DRH_SUPPWORK_SOFT.hPanel.clear();
//				DRH_SUPPWORK_SOFT.hPanel.add(new FenetreAdmin().asWidget());
//			}
//		});

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
