package com.supp.work.soft.server.pdfCreator;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.persistence.Query;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.LineSeparator;
//import com.supp.work.soft.client.vue.Formulaire;
import com.supp.work.soft.server.connexion.Connexion;
import com.supp.work.soft.shared.model.Archiveemployes;
import com.supp.work.soft.shared.model.ArchiveemployesPK;
import com.supp.work.soft.shared.model.Employes;

public class PDFCreator {

	public static String message;
	public static String URL = "Invoice.pdf";

	public PDFCreator() {
		new Connexion();
	}

	public String generatePDF(Employes employe) {
		File file = null;
		try {
			// Connexion.em.
			message = "Enregistrement reussi";
			file = new File(URL);
			Rectangle pageSize = new Rectangle(820, 1080);

			// BaseColor backColor = new BaseColor(0xDF, 0xFF, 0xDE);
			// pageSize.setBackgroundColor(backColor);
			Document document = new Document(pageSize);

			// To add font color
			PdfWriter writer = PdfWriter.getInstance(document,
					new FileOutputStream(file));

			document.open();

			// To return path
			// RealUrl = getUrl(this);

			// RealUrl = "http://localhost:8090/itext/Invoice.pdf";

			Font fontTableHeader = new Font(FontFamily.COURIER, 15, Font.BOLD);
			BaseColor tableheaderColor = new BaseColor(0xf9, 0xf3, 0xf3);
			fontTableHeader.setColor(tableheaderColor);
			Font font = new Font(FontFamily.TIMES_ROMAN, 20, Font.BOLD);
			BaseColor fontColor = new BaseColor(0x00, 0x00, 0x0);
			font.setColor(fontColor);
			Chunk chunkWissen = new Chunk(
					"MINISTERE DE L'ECONOMIE ET DES FINANCES", font);
			Paragraph paraWissen = new Paragraph();

			paraWissen.add(chunkWissen);
			paraWissen.setAlignment(Element.ALIGN_CENTER);

			Font invoiceFont = new Font(FontFamily.TIMES_ROMAN, 15, Font.BOLD);
			BaseColor invoiceColor = new BaseColor(0x00, 0x00, 0x0);
			invoiceFont.setColor(invoiceColor);
			Chunk invoices = new Chunk("FORME DE TRAVAIL SUPPLEMENTAIRE",
					invoiceFont);
			Paragraph invoicePara = new Paragraph();
			invoicePara.add(invoices);
			invoicePara.setAlignment(Element.ALIGN_CENTER);

			// For invoice description
			// Chunk invoiceDescript = new Chunk();
			// Paragraph invoiceDescription = new Paragraph();
			// invoiceDescription.setAlignment(Element.ALIGN_RIGHT);
			// PdfPTable tableDesc = new PdfPTable(2);
			// PdfPCell dateString = new PdfPCell(new Paragraph("DATE:"));
			// disableBorder(dateString);
			// PdfPCell InvoiceString = new PdfPCell(new Paragraph("INVOICE#"));
			// disableBorder(InvoiceString);
			// PdfPCell CustString = new PdfPCell(new Paragraph("Customer ID"));
			// disableBorder(CustString);
			// PdfPCell dateCell = new PdfPCell(new Paragraph("dateStr"));
			// dateCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			// BaseColor datecellColor = new BaseColor(0xE4, 0xE8, 0xF3);
			// dateCell.setBackgroundColor(datecellColor);
			// dateCell.disableBorderSide(PdfPCell.TOP);
			// dateCell.disableBorderSide(PdfPCell.LEFT);
			// dateCell.disableBorderSide(PdfPCell.RIGHT);
			//
			// PdfPCell Invoice = new PdfPCell(new Paragraph("invId"));
			// Invoice.setHorizontalAlignment(Element.ALIGN_RIGHT);
			// PdfPCell CustId = new PdfPCell(new Paragraph("custId"));
			// CustId.setHorizontalAlignment(Element.ALIGN_RIGHT);
			// tableDesc.addCell(dateString);
			// tableDesc.addCell(dateCell);
			// tableDesc.addCell(InvoiceString);
			// tableDesc.addCell(Invoice);
			// tableDesc.addCell(CustString);
			// tableDesc.addCell(CustId);
			// tableDesc.setTotalWidth(175);
			// PdfContentByte cbx = writer.getDirectContent();
			// tableDesc.writeSelectedRows(0, 3, 590, 700, cbx);

			// For address
			Font addressFont = new Font(FontFamily.TIMES_ROMAN, 14, Font.BOLD);
			PdfPTable addrTable = new PdfPTable(1);
			Phrase address = new Phrase();
			address.setFont(addressFont);
			address.add(Chunk.NEWLINE);
			address.add("NOM & PRENOM    :   " + employe.getNom().toUpperCase()
					+ "   " + employe.getPrenom());
			address.add(Chunk.NEWLINE);
			address.add(Chunk.NEWLINE);
			address.add("FONCTION :  " + employe.getFonction());
			address.add("                                     ");
			address.add("SALAIRE  :     " + employe.getSalaire() + ".00");
			address.add(Chunk.NEWLINE);
			address.add(Chunk.NEWLINE);
			address.add("HORAIRE REGULIER   :  " + employe.getHoraireRegulier());
			address.add("                                                     ");
//			address.add("TAUX HORAIRE NORMAL(T)    :  "
//					+ Formulaire.tauxHoraire(employe.getSalaire()));
			address.add(Chunk.NEWLINE);
			address.add(Chunk.NEWLINE);
			address.add("DIRECTION : " + employe.getDirection());
			address.add("                                                 ");
			address.add("SERVICE : " + employe.getService());
			address.add(Chunk.NEWLINE);
			address.add(Chunk.NEWLINE);
			address.add("TRAVAUX SUPPLEMENTAIRES A EFFECTUER:  "+employe.getRaison());
			address.add(Chunk.NEWLINE);
			address.add(Chunk.NEWLINE);
//			address.add("RAISON :------------------------------------------------------------------------");
//			address.add("-------------------------------------------------------------------------");
//			address.add(employe.getRaison());
//			address.add(Chunk.NEWLINE);
			address.add(Chunk.NEWLINE);
//			address.add("AUTORISE PAR------------------------------------------------------------------");
//			address.add("----------------------------------------------------------------------");
//			address.add(Chunk.NEWLINE);
//			address.add(Chunk.NEWLINE);
			address.add(Chunk.NEWLINE);
			address.add(Chunk.NEWLINE);
			address.add("Mois  : " + employe.getMois()+" 2015");
			address.add(Chunk.NEWLINE);
			address.setFont(addressFont);
			Paragraph addressPara = new Paragraph();
			addressPara.add(address);
			addressPara.setAlignment(Element.ALIGN_LEFT);
			addrTable.addCell(addressPara);

			// For Bill paragraph
			// Chunk billto = new Chunk("BILL TO:            ",
			// fontTableHeader);
			// BaseColor billtoColor = new BaseColor(0x3B, 0x4E, 0x87);
			// billto.setBackground(billtoColor);
			// Phrase bill_to_person = new Phrase();
			// bill_to_person.add(Chunk.NEWLINE);
			// bill_to_person.add(Chunk.NEWLINE);
			// bill_to_person.add(Chunk.NEWLINE);
			// bill_to_person.add(billto);
			// bill_to_person.add(Chunk.NEWLINE);
			// bill_to_person.add("custName");
			// bill_to_person.add(Chunk.NEWLINE);
			// bill_to_person.add("M2Wealth international limited");
			// bill_to_person.add(Chunk.NEWLINE);
			// bill_to_person.add("custAdd");
			// Paragraph billToPara = new Paragraph();
			// billToPara.add(bill_to_person);
			// billToPara.setAlignment(Element.ALIGN_LEFT);

			// For Description and amount table
			// To create two cell
			float[] WidthCol = { 2f, 4f };

			PdfPCell descCell = new PdfPCell(new Paragraph("DATE",
					fontTableHeader));
			descCell.setBackgroundColor(new BaseColor(0x3B, 0x4E, 0x87));
			descCell.setHorizontalAlignment(Element.ALIGN_CENTER);
			descCell.disableBorderSide(PdfPCell.TOP);
			descCell.disableBorderSide(PdfPCell.BOTTOM);

			PdfPCell amtCell = new PdfPCell(new Paragraph(
					"NOMBRE D'HEURES SUPPLEMENTAIRES", fontTableHeader));
			amtCell.setBackgroundColor(new BaseColor(0x3B, 0x4E, 0x87));
			amtCell.setHorizontalAlignment(Element.ALIGN_CENTER);
			amtCell.disableBorderSide(PdfPCell.TOP);
			amtCell.disableBorderSide(PdfPCell.BOTTOM);

			// To add cell into table
			PdfPTable tableDay = new PdfPTable(WidthCol);
			Font fontTableCell = new Font(FontFamily.TIMES_ROMAN, 13,
					Font.NORMAL);
			PdfPCell cell1 = new PdfPCell(new Paragraph("Lundi", fontTableCell));
			cell1.disableBorderSide(PdfPCell.TOP);
			cell1.setExtraParagraphSpace(10f);

			PdfPCell cell2 = new PdfPCell(new Paragraph(employe.getLundi(),
					fontTableCell));
			cell2.disableBorderSide(PdfPCell.TOP);
			cell2.setExtraParagraphSpace(10f);

			PdfPCell cell3 = new PdfPCell(new Paragraph("Mardi", fontTableCell));
			cell3.disableBorderSide(PdfPCell.TOP);
			cell3.setExtraParagraphSpace(10f);

			PdfPCell cell4 = new PdfPCell(new Paragraph(employe.getMardi(),
					fontTableCell));
			cell4.disableBorderSide(PdfPCell.TOP);
			cell4.setExtraParagraphSpace(10f);

			PdfPCell cell5 = new PdfPCell(new Paragraph("Mercredi",
					fontTableCell));
			cell5.disableBorderSide(PdfPCell.TOP);
			cell5.setExtraParagraphSpace(10f);

			PdfPCell cell6 = new PdfPCell(new Paragraph(employe.getMercredi(),
					fontTableCell));
			cell6.disableBorderSide(PdfPCell.TOP);
			cell6.setExtraParagraphSpace(10f);

			PdfPCell cell7 = new PdfPCell(new Paragraph("Jeudi", fontTableCell));
			cell7.disableBorderSide(PdfPCell.TOP);
			cell7.setExtraParagraphSpace(10f);

			PdfPCell cell8 = new PdfPCell(new Paragraph(employe.getJeudi(),
					fontTableCell));
			cell8.disableBorderSide(PdfPCell.TOP);
			cell8.setExtraParagraphSpace(10f);

			PdfPCell cell9 = new PdfPCell(new Paragraph("Vendredi",
					fontTableCell));
			cell9.disableBorderSide(PdfPCell.TOP);
			cell9.setExtraParagraphSpace(10f);

			PdfPCell cell10 = new PdfPCell(new Paragraph(employe.getVendredi(),
					fontTableCell));
			cell10.disableBorderSide(PdfPCell.TOP);
			cell10.setExtraParagraphSpace(10f);

			PdfPCell cell11 = new PdfPCell(new Paragraph("Samedi",
					fontTableCell));
			cell11.disableBorderSide(PdfPCell.TOP);
			cell11.setExtraParagraphSpace(10f);

			PdfPCell cell12 = new PdfPCell(new Paragraph(employe.getSamedi(),
					fontTableCell));
			cell12.disableBorderSide(PdfPCell.TOP);
			cell12.setExtraParagraphSpace(10f);

			PdfPCell cell13 = new PdfPCell(new Paragraph("Dimanche",
					fontTableCell));
			cell13.disableBorderSide(PdfPCell.TOP);
			cell13.setExtraParagraphSpace(10f);

			PdfPCell cell14 = new PdfPCell(new Paragraph(employe.getDimanche(),
					fontTableCell));
			cell14.disableBorderSide(PdfPCell.TOP);
			cell14.setExtraParagraphSpace(10f);

			tableDay.addCell(descCell);
			tableDay.addCell(amtCell);
			tableDay.addCell(cell1);
			tableDay.addCell(cell2);
			tableDay.addCell(cell3);
			tableDay.addCell(cell4);
			tableDay.addCell(cell5);
			tableDay.addCell(cell6);
			tableDay.addCell(cell7);
			tableDay.addCell(cell8);
			tableDay.addCell(cell9);
			tableDay.addCell(cell10);
			tableDay.addCell(cell11);
			tableDay.addCell(cell12);
			tableDay.addCell(cell13);
			tableDay.addCell(cell14);
			tableDay.setWidthPercentage(100);

			// To add subtotal and other things

			PdfPCell subTotalCell = new PdfPCell(new Paragraph(
					"Total d'heures/S"));
			disableBorder(subTotalCell);
			subTotalCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			subTotalCell.setPaddingTop(10);
			subTotalCell.setBackgroundColor(new BaseColor(0xE4, 0xE8, 0xF3));
			subTotalCell.setExtraParagraphSpace(10f);
			// To add value in cell
			PdfPCell subTotalValueCell = new PdfPCell(new Paragraph(
					employe.getTotalHeuresS()));
			subTotalValueCell.setPaddingTop(10);
			disableBorder(subTotalValueCell);
			subTotalValueCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			subTotalValueCell
					.setBackgroundColor(new BaseColor(0xE4, 0xE8, 0xF3));
			subTotalValueCell.setExtraParagraphSpace(10f);

			PdfPCell taxRateCell = new PdfPCell(new Paragraph(
					"Total d'heures/W"));
			disableBorder(taxRateCell);
			taxRateCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			taxRateCell.setExtraParagraphSpace(10f);
			// To add value in cell
			PdfPCell taxRateValueCell = new PdfPCell(new Paragraph(
					employe.getTotalHeureW()));
			disableBorder(taxRateValueCell);
			taxRateValueCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			taxRateValueCell.setExtraParagraphSpace(10f);

			// PdfPCell taxCell = new PdfPCell(new Paragraph("Tax"));
			// disableBorder(taxCell);
			// taxCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			// taxCell.setBackgroundColor(new BaseColor(0xE4, 0xE8, 0xF3));
			// taxCell.setExtraParagraphSpace(10f);
			// // To add value in cell
			// PdfPCell taxValueCell = new PdfPCell(new Paragraph("$" + "tax"
			// + ".00"));
			// disableBorder(taxValueCell);
			// taxValueCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			// taxValueCell.setBackgroundColor(new BaseColor(0xE4, 0xE8, 0xF3));
			// taxValueCell.setExtraParagraphSpace(10f);
			//
			// PdfPCell otherCell = new PdfPCell(new Paragraph("Other"));
			// disableBorder(otherCell);
			// otherCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			// otherCell.setExtraParagraphSpace(10f);
			// To add value in cell
			// PdfPCell otherValueCell = new PdfPCell(new Paragraph("$" +
			// "other"
			// + ".00"));
			// disableBorder(otherValueCell);
			// otherValueCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			// otherValueCell.setExtraParagraphSpace(10f);

			PdfPCell totalCell = new PdfPCell(new Paragraph("Total"));
			totalCell.disableBorderSide(PdfPCell.BOTTOM);
			totalCell.disableBorderSide(PdfPCell.LEFT);
			totalCell.disableBorderSide(PdfPCell.RIGHT);
			totalCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			totalCell.setBackgroundColor(new BaseColor(0xE4, 0xE8, 0xF3));
			totalCell.setExtraParagraphSpace(10f);
			// To add value in cell
			PdfPCell totalValueCell = new PdfPCell(new Paragraph(
					employe.getTotalHeures()));
			totalValueCell.disableBorderSide(PdfPCell.BOTTOM);
			totalValueCell.disableBorderSide(PdfPCell.LEFT);
			totalValueCell.disableBorderSide(PdfPCell.RIGHT);
			totalValueCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			totalValueCell.setBackgroundColor(new BaseColor(0xE4, 0xE8, 0xF3));
			totalValueCell.setExtraParagraphSpace(10f);

			PdfPTable otherTable = new PdfPTable(2);
			otherTable.addCell(subTotalCell);
			otherTable.addCell(subTotalValueCell);
			otherTable.addCell(taxRateCell);
			otherTable.addCell(taxRateValueCell);
			// otherTable.addCell(taxCell);
			// otherTable.addCell(taxValueCell);
			// otherTable.addCell(otherCell);
			// otherTable.addCell(otherValueCell);
			otherTable.addCell(totalCell);
			otherTable.addCell(totalValueCell);
			otherTable.setWidthPercentage(25);
			otherTable.setHorizontalAlignment(Element.ALIGN_RIGHT);

			// For table comment
			// Font commentheaderFont = new Font(FontFamily.COURIER, 10,
			// Font.BOLD);
			// PdfPCell comentHeaderCell = new PdfPCell(new Paragraph(
			// "OTHER COMMENTS", commentheaderFont));
			// comentHeaderCell
			// .setBackgroundColor(new BaseColor(0xC0, 0xC0, 0xC0));
			// Phrase commentsPhrase = new Phrase();
			// commentsPhrase.add("1.Total payment due in 30 days");
			// commentsPhrase.add(Chunk.NEWLINE);
			// commentsPhrase
			// .add("2.Please include the invoice number on your check");
			// PdfPCell commentsCell = new PdfPCell(commentsPhrase);
			// commentsCell.setExtraParagraphSpace(20f);
			// PdfPTable commentsTable = new PdfPTable(1);
			// commentsTable.setWidthPercentage(50);
			// commentsTable.addCell(comentHeaderCell);
			// commentsTable.addCell(commentsCell);
			// commentsTable.setHorizontalAlignment(Element.ALIGN_LEFT);
			// commentsTable.setTotalWidth(350f);
			// commentsTable.writeSelectedRows(0, -1, 35, 300,
			// writer.getDirectContent());

			// Check payable
			Font fontTotal = new Font(FontFamily.COURIER, 15, Font.BOLD);
			Phrase check = new Phrase();
			check.setFont(fontTotal);
			check.add(Chunk.NEWLINE);
			check.add("Salaire a payer : ");
			Chunk checkchunk = new Chunk(employe.getValeurAPayer());
			check.add(checkchunk);
			Paragraph tipPara = new Paragraph();
			tipPara.add(check);
			tipPara.setAlignment(Element.ALIGN_RIGHT);
			check.add(Chunk.NEWLINE);
			check.add(Chunk.NEWLINE);

			// Adding footer
			// Chunk footer = new Chunk("Thank You For Your Business!", font);
			PdfPTable tableFooter = new PdfPTable(1);

			Paragraph footerParagraph = new Paragraph(
					"                                                                      5, Avenue Charles Sumner, Port-au-Prince, Haiti");

			// footerPhrase
			// .add();

			footerParagraph.setAlignment(Element.ALIGN_RIGHT);
			PdfPCell footCell = new PdfPCell(footerParagraph);
			footCell.disableBorderSide(PdfPCell.BOTTOM);
			footCell.disableBorderSide(PdfPCell.LEFT);
			footCell.disableBorderSide(PdfPCell.RIGHT);
			tableFooter.addCell(footCell);
			tableFooter.setWidthPercentage(100);

			PdfPTable signature = new PdfPTable(1);
			Font signatureFont = new Font(FontFamily.TIMES_ROMAN, 13, Font.BOLD);
			Phrase phraseSignature = new Phrase();
			phraseSignature.setFont(signatureFont);
			phraseSignature
					.add("                                                        ");
			phraseSignature
					.add("                                                     ");
			phraseSignature
					.add(" APPROUVE PAR :  ----------------------------------------------------------");
			phraseSignature.add(Chunk.NEWLINE);
			phraseSignature
					.add("                                                       ");
			phraseSignature
					.add("                                                      ");
			phraseSignature.add("                                          ");
			phraseSignature.add("Direction des Ressouces Humaines");
			phraseSignature.setFont(signatureFont);
			Paragraph signaturePara = new Paragraph();
			signaturePara.add(phraseSignature);
			signaturePara.setAlignment(Element.ALIGN_LEFT);
			signature.addCell(signaturePara);
			signature.setWidthPercentage(100);
			
			
			
			


			
			
			
//
			
			
			
			
			PdfPTable signature2 = new PdfPTable(1);
			Font signatureFont2 = new Font(FontFamily.TIMES_ROMAN, 13, Font.BOLD);
			Phrase phraseSignature2 = new Phrase();
			phraseSignature2.setFont(signatureFont2);
			
			phraseSignature2
					.add("----------------------------------------------------------");
			phraseSignature2.add(Chunk.NEWLINE);
			phraseSignature2.add("              ");
			phraseSignature2.add("SIGNATURE EMPLOYE (E)");
			phraseSignature2.setFont(signatureFont2);
			Paragraph signaturePara2 = new Paragraph();
			signaturePara2.add(phraseSignature2);
			signaturePara2.setAlignment(Element.ALIGN_LEFT);
			signature2.addCell(signaturePara2);
			signature2.setWidthPercentage(100);
			
			

			// Font fontAnchor = new Font();
			// fontAnchor.setColor(new BaseColor(0x00, 0x48, 0xFF));
			// Chunk AnchorId = new Chunk("sushrut@wissen.co.in", fontAnchor);
			// chunkWissen.setAnchor("http://google.com/");
			// footerPhrase.add("Sushrut Bidwai,");
			// footerPhrase.add(AnchorId);
			// footerPhrase.add(", +91 986 023 8124");
			// footerPhrase.add(Chunk.NEWLINE);
			// footerPhrase.add(Chunk.NEWLINE);
			// footerPhrase.add(footer);

			// --------------------------------------------------------------------
			// PdfContentByte cb1 = writer.getDirectContent();
			// ColumnText ct1 = new ColumnText(cb1);
			// Paragraph ph =new Paragraph (footerPhrase);
			// PdfPCell pdPfCell=new PdfPCell(ph);
			// ct1.setSimpleColumn(ph, 150, 10, 650, 75, 15,
			// Element.ALIGN_CENTER);
			// ct1.go();

			// lineSeparator.drawLine(cb1, 240, 240, 240);
			// footerPhrase.add(lineSeparator);

			// //Ajout d'une image de fond
			// PdfContentByte canvas = writer.getDirectContentUnder();
			// Image image = Image.getInstance("images/backgroundFormMEF.png");
			// image.scaleAbsolute(PageSize.B4.rotate());
			// image.setAbsolutePosition(0, 0);
			// canvas.addImage(image);
			document.add(paraWissen);
			document.add(Chunk.NEWLINE);
			document.add(invoicePara);
			// document.add(invoiceDescript);
			document.add(addressPara);
			// document.add(billToPara);
			document.add(Chunk.NEWLINE);
			document.add(Chunk.NEWLINE);
			document.add(Chunk.NEWLINE);
			document.add(Chunk.NEWLINE);
			document.add(tableDay);
			document.add(Chunk.NEWLINE);
			document.add(otherTable);
			document.add(tipPara);
			document.add(Chunk.NEWLINE);
			document.add(Chunk.NEWLINE);
			document.add(Chunk.NEWLINE);
			document.add(Chunk.NEWLINE);
			document.add(Chunk.NEWLINE);		
			// document.add(Chunk.NEWLINE);
			// document.add(Chunk.NEWLINE);
			
			document.add(signaturePara2);
			document.add(Chunk.NEWLINE);
			document.add(signaturePara);

			document.add(Chunk.NEWLINE);
			document.add(Chunk.NEWLINE);
			document.add(Chunk.NEWLINE);
			document.add(tableFooter);
			// document.add(lineSeparator);

			document.close();
			message = file.getPath();

			// System.out.println("PDF created successfully....");
			// Window.alert("PDF created successfully....");
		} catch (Exception e) {
			System.out
					.println("Error Eugene=======================================:"
							+ e.getMessage());
			message = e.getMessage();
			// Window.alert("PDF Echec....");

		}
		return message;
	}

	public String transfertData(Employes employe) {

		return employe.getNom();
	}

	public String enregistrer(Employes employe) {
		String message = null;
		try {
			Connexion.em.getTransaction().begin();
			Connexion.em.persist(employe);
			Connexion.em.getTransaction().commit();
			message = "Code d'enregistrement :" + employe.getCode();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		} finally {
			Connexion.closeEm();
			Connexion.closeEmf();
		}

		return message;
	}

	public List<Employes> numberSave() {
		List<Employes> list = null;
		try {
			String requete = "Select e from Employes e";
			Query query = Connexion.em.createQuery(requete);
			list = query.getResultList();
		} catch (Exception ex) {
			System.out
					.println("error liste===================================================="
							+ ex.getMessage());
		} finally {
			Connexion.closeEm();
			Connexion.closeEmf();
		}
		return list;
	}

	public Object rechercher(String code) {
		Employes employe = null;
		try {
			employe = Connexion.em.find(Employes.class, code);
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("================================================");
		}
		return employe;
	}

	public String modifier(Employes employe) {
		String message = null;
		try {
			Connexion.em.getTransaction().begin();
//			String requete = "UPDATE Employes e SET e.nom='" + employe.getNom()+ "'," +
//			"e.prenom='" + employe.getPrenom() + "',"+ 
//			"e.salaire='" + employe.getSalaire() + "',"+
//			"e.fonction='" + employe.getFonction() + "',"+ 
//			"e.horaireRegulier='" + employe.getHoraireRegulier()+ "'," +
//			"e.direction='" + employe.getDirection() + "',"+ 
//			"e.service='" + employe.getService() + "',"+ 
//			"e.raison='" + employe.getRaison() + "'," +
//			"e.mois='"+ employe.getMois() + "'," + 
//			"e.lundi='"+ employe.getLundi() + "'," + 
//			"e.mardi='"+ employe.getMardi() + "'," +
//			"e.mercredi='"+ employe.getMercredi() + "'," +
//			"e.jeudi='"+ employe.getJeudi() + "'," + 
//			"e.vendredi='"+ employe.getVendredi() + "'," + 
//			"e.samedi='"+ employe.getSamedi() + "'," +
//			"e.dimanche='"+ employe.getDimanche() + "',"+
//			"e.modifierPar='"+employe.getModifierPar()+"',"+
//			"e.modifierLe='"+employe.getModifierLe()+"' WHERE e.code='"+ employe.getCode() + "'";
//			Query query = Connexion.em.createQuery(requete);
//			query.executeUpdate();
			Employes employe1=Connexion.em.find(Employes.class, employe.getCode());
			employe1.setCode(employe.getCode());
			employe1.setNom(employe.getNom());
			employe1.setPrenom(employe.getPrenom());
			employe1.setSalaire(employe.getSalaire());
			employe1.setFonction(employe.getFonction());
			employe1.setHoraireRegulier(employe.getHoraireRegulier());
			employe1.setDirection(employe.getDirection());
			employe1.setService(employe.getService());
			employe1.setRaison(employe.getRaison());
			employe1.setMois(employe.getMois());
			employe1.setLundi(employe.getLundi());
			employe1.setMardi(employe.getMardi());
			employe1.setMercredi(employe.getMercredi());
			employe1.setJeudi(employe.getJeudi());
			employe1.setVendredi(employe.getVendredi());
			employe1.setSamedi(employe.getSamedi());
			employe1.setDimanche(employe.getDimanche());
			employe1.setModifierPar(employe.getModifierPar());
			employe1.setModifierLe(employe.getModifierLe());
			employe1.setConge(employe.getConge());
			employe1.setAnnee(employe.getAnnee());
			Connexion.em.flush();
			Connexion.em.getTransaction().commit();
			message = "Modification reussie";
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return message;
	}

	public List<Employes> lister() {
		List<Employes> list = null;
		Employes e=new Employes();
		try {
			Query query = Connexion.em
					.createNamedQuery("Employes.findAll");	
			list=query.getResultList();
			
		} catch (Exception ex) {
		}
		return list;

	}
	
	public List<Employes> lister(String mois,String annee) {
		List<Employes> list = null;
		String requete="Select e from Employes e where e.mois='"+mois+"' and e.annee='"+annee+"'";

		try {
			Connexion.em.getTransaction().begin();
			Query query = Connexion.em.createQuery(requete);
			list = query.getResultList();
		} catch (Exception ex) {

		} finally {
			try {
				Connexion.closeEm();
				Connexion.closeEmf();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return list;

	}

	public void disableBorder(PdfPCell cell) {
		cell.disableBorderSide(PdfPCell.TOP);
		cell.disableBorderSide(PdfPCell.BOTTOM);
		cell.disableBorderSide(PdfPCell.LEFT);
		cell.disableBorderSide(PdfPCell.RIGHT);

	}
	
	public String enregistrerArchive(Archiveemployes archive){
		String message = null;
		try {
			Connexion.em.getTransaction().begin();
			Connexion.em.persist(archive);
			Connexion.em.getTransaction().commit();
			message = "Enregistrement réussi:" ;
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		} finally {
			Connexion.closeEm();
			Connexion.closeEmf();
		}

		return message;
	}
	
	public Archiveemployes rechercherArchive(String code,String mois,String annee) {
		Archiveemployes archive = null;
		try{
			ArchiveemployesPK eployes=new ArchiveemployesPK(code,mois,annee);
			archive=Connexion.em.find(Archiveemployes.class, eployes);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return archive;
	}
}
