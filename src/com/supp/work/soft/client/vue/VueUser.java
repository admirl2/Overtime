package com.supp.work.soft.client.vue;

import java.util.Date;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.data.shared.StringLabelProvider;
import com.sencha.gxt.widget.core.client.form.SimpleComboBox;
import com.supp.work.soft.client.service.UserService;
import com.supp.work.soft.client.service.UserServiceAsync;
import com.supp.work.soft.shared.FieldVerifier;
import com.supp.work.soft.shared.model.Utilisateur;

public class VueUser implements IsWidget {

	private final UserServiceAsync serviceEnregistrer = GWT
			.create(UserService.class);
	private final UserServiceAsync serviceRecherhce = GWT
			.create(UserService.class);
	private final UserServiceAsync serviceModifier = GWT
			.create(UserService.class);
	VerticalPanel vPanelUser;
	SimplePanel message;
	TextBox recherche;
	TextBox login;
	PasswordTextBox password;
	PasswordTextBox validerPassword;
	SimpleComboBox<String> typeUser;

//	DateBox dateB;
	Button bRecherche;
	Label lLogin;
	Label lPassword;
	Label lValiderPassword;
	Label lTypeUser;
	Button save;
	Button edit;

	Label error;
	FlexTable tableUser;

	HorizontalPanel horizontalPanel;
	HorizontalPanel hPanelBox;
	CheckBox box;
	Label afficherPass;

	public VueUser() {

		// Creation des objets
		message = new SimplePanel();
		vPanelUser = new VerticalPanel();
		vPanelUser.setStyleName("vPanelUser");
		bRecherche = new Button("Recherche");
		lLogin = new Label("Nom d'utilisateur");

		lPassword = new Label("Mot de passe");
		lValiderPassword = new Label("Confirmer");
		lTypeUser = new Label("Type d'utilisateur");
		horizontalPanel = new HorizontalPanel();
		hPanelBox = new HorizontalPanel();

		afficherPass = new Label("Afficher mot de passe");
		error = new Label("");
		error.setStyleName("error");

		recherche = new TextBox();
//		recherche.setSearchQuery(true);
//		recherche.setPlaceholder("Recherche...");
		// tCodeBud.setStyleName("textBoxVueFonctionnaire");
		login = new TextBox();
		login.setStyleName("textBoxVueFonctionnaire");
		password = new PasswordTextBox();
		password.setStyleName("textBoxVueFonctionnaire");
		validerPassword = new PasswordTextBox();
		validerPassword.setStyleName("validerPassword");
		typeUser = new SimpleComboBox<String>(new StringLabelProvider<String>());
		typeUser.setStyleName("textBoxVueFonctionnaire");
		typeUser.add("Administrateur");
		typeUser.add("Simple Utilisateur");
		typeUser.add("Super Utilisateur");

		save = new Button("Enregistrer");
		save.setStyleName("save");
//		save.setType(ButtonType.PRIMARY);
//		save.setIcon(IconType.SAVE);

		edit = new Button("Modifier");
//		edit.setIcon(IconType.EDIT);
//		edit.setType(ButtonType.WARNING);
		edit.setStyleName("edit");
		tableUser = new FlexTable();
		box = new CheckBox();
//		dateB = new DateBox();
		// Ajout des elements dans les conteneurs

		tableUser.setWidget(0, 0, error);
		// tableUser.setWidget(0, 1, tCodeBud);
		hPanelBox.add(validerPassword);
		hPanelBox.add(box);
		hPanelBox.add(afficherPass);
		tableUser.setWidget(1, 0, lLogin);
		tableUser.setWidget(1, 1, login);
		tableUser.setWidget(2, 0, lPassword);
		tableUser.setWidget(2, 1, password);
		tableUser.setWidget(3, 0, lValiderPassword);
		tableUser.setWidget(3, 1, hPanelBox);
		tableUser.setWidget(4, 0, lTypeUser);
		tableUser.setWidget(4, 1, typeUser);
		tableUser.setWidget(5, 0, save);
		tableUser.setWidget(5, 1, edit);

		horizontalPanel.add(recherche);
		horizontalPanel.add(bRecherche);

		vPanelUser.add(horizontalPanel);
		vPanelUser.add(message);
		vPanelUser.add(tableUser);

		save.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				if (password.getText().equals(validerPassword.getText())) {
					Utilisateur utilisateur = new Utilisateur();

					try {
						utilisateur.setLogin(login.getText());
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					try {
						utilisateur.setPassword(password.getText());
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					utilisateur.setTypeUser(typeUser.getText());
					utilisateur.setCreerPar(Login.log);
					utilisateur.setCreerLe(FieldVerifier
							.formateDate(new Date()));
					utilisateur.setModifierPar("");
					utilisateur.setModifierLe("");
					utilisateur.setNbrFoisLog("0");
					serviceEnregistrer.enregistrer(utilisateur,
							new AsyncCallback<String>() {

								@Override
								public void onFailure(Throwable caught) {
									// TODO Auto-generated method stub

								}

								@Override
								public void onSuccess(String result) {
									// TODO Auto-generated method stub
									message.clear();
									message.add(new Label(result));
									message.setStyleName("messageUser");
								}
							});
					
				} else {
					validerPassword.setText("");
//					validerPassword.setPlaceholder("Mot de passe different");
				}
			}
		});

		bRecherche.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				try {
					serviceRecherhce.rechercher(recherche.getText(),
							new AsyncCallback<Utilisateur>() {

								@Override
								public void onFailure(Throwable caught) {
									// TODO Auto-generated method stub

								}

								@Override
								public void onSuccess(Utilisateur result) {
									// TODO Auto-generated method stub
									if (result != null) {
										login.setText(result.getLogin());
										password.setText(result.getPassword());
										typeUser.setText(result.getTypeUser());
										error.setVisible(false);
									} else {
										error.setText("Verifier le nom d'utilisateur");
									}
								}
							});
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		edit.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				if (password.getText().equals(validerPassword.getText())) {
					Utilisateur utilisateur=new Utilisateur();
					utilisateur.setLogin(login.getText());
					try {
						utilisateur.setPassword(password.getText());
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					utilisateur.setNbrFoisLog("0");
					utilisateur.setTypeUser(typeUser.getText());
					serviceModifier.modifier(utilisateur,
							new AsyncCallback<String>() {

								@Override
								public void onFailure(Throwable caught) {
									// TODO Auto-generated method stub

								}

								@Override
								public void onSuccess(String result) {
									// TODO Auto-generated method stub
									message.add(new Label(result));
									message.setStyleName("messageUser");
								}
							});
				} else {
					validerPassword.setText("");
//					validerPassword.setPlaceholder("Mot de passe different");
				}
			}
		});
		box.addClickHandler(new ClickHandler() {

			@SuppressWarnings("deprecation")
			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				if (box.isChecked() && !password.getText().isEmpty() && validerPassword.getText().isEmpty()) {
					validerPassword.setText("");
//					validerPassword.setPlaceholder(password.getText());
				} else {
					if (!validerPassword.getText().isEmpty() && !password.getText().isEmpty()) {
						String valeur=validerPassword.getText();
						validerPassword.setText("");
//						validerPassword.setPlaceholder(valeur);
					}else{
//						String valeur=validerPassword.getPlaceholder();;
//						validerPassword.setText(valeur);
					}

				}

			}
		});
	}

	private int calculDate(Date date, Date date2) {
		int sum = 0;
		try {
			if (date2.getYear() > date.getYear()) {
				int dateP = date.getYear();
				int dateD = date2.getYear();
				sum = dateD - dateP;
			}

		} catch (Exception ex) {

		}

		return sum;
	}

	@Override
	public Widget asWidget() {
		// TODO Auto-generated method stub
		return vPanelUser;
	}

}
