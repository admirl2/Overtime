package com.supp.work.soft.server.rapport;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.output.ByteArrayOutputStream;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.supp.work.soft.client.vue.Formulaire;
//import com.supp.work.soft.client.vue.Formulaire;
import com.supp.work.soft.shared.model.Employes;

public class SupplementaireRaport {

	private HttpServletRequest request;
	private HttpServletResponse response;
	private String methodName;
	private String filters;
	private List<Employes> list;
	private String url;

	private byte[] imageInByte;
	private ByteArrayOutputStream baos;
	private FileOutputStream fileOuputStream;
	private Image image;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public SupplementaireRaport() {

	}

	public String getFilters() {
		return filters;
	}

	public void setFilters(String filters) {
		this.filters = filters;
	}

	public List<Employes> getList() {
		return list;
	}

	public void setList(List<Employes> list) {
		this.list = list;
	}

	public void buildReport() {
		Rectangle pageSize = new Rectangle(850, 1100);

		// BaseColor backColor = new BaseColor(0xDF, 0xFF, 0xDE);
		// pageSize.setBackgroundColor(backColor);
		try {
			Document document = new Document(pageSize);

			// To add font color
			PdfWriter writer = PdfWriter.getInstance(document,
					response.getOutputStream());

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
			address.add("NOM & PRENOM    :   "
					+ list.get(0).getNom().toUpperCase() + "   "
					+ list.get(0).getPrenom());
			address.add(Chunk.NEWLINE);
			address.add(Chunk.NEWLINE);
			address.add("FONCTION :  " + list.get(0).getFonction());
			address.add("                                     ");
			address.add("SALAIRE  :     " + list.get(0).getSalaire() + ".00");
			address.add(Chunk.NEWLINE);
			address.add(Chunk.NEWLINE);
			address.add("HORAIRE REGULIER   :  "
					+ list.get(0).getHoraireRegulier());
			address.add("                                                     ");
			address.add("TAUX HORAIRE NORMAL(T)    :  "
					+ Formulaire.tauxHoraire(list.get(0).getSalaire()));
			address.add(Chunk.NEWLINE);
			address.add(Chunk.NEWLINE);
			address.add("DIRECTION : " + list.get(0).getDirection());
			address.add("                                                 ");
			address.add("SERVICE : " + list.get(0).getService());
			address.add(Chunk.NEWLINE);
			address.add(Chunk.NEWLINE);
			address.add("TRAVAUX SUPPLEMENTAIRES  EFFECTUÉS:  "+ list.get(0).getRaison());
			address.add(Chunk.NEWLINE);
			address.add(Chunk.NEWLINE);
			// address.add("RAISON :------------------------------------------------------------------------");
			// address.add("-------------------------------------------------------------------------");
			// address.add(employe.getRaison());
			// address.add(Chunk.NEWLINE);
			address.add(Chunk.NEWLINE);
			// address.add("AUTORISE PAR------------------------------------------------------------------");
			// address.add("----------------------------------------------------------------------");
			// address.add(Chunk.NEWLINE);
			// address.add(Chunk.NEWLINE);
//			address.add(Chunk.NEWLINE);
//			address.add(Chunk.NEWLINE);
			address.add("Mois  : " + list.get(0).getMois() + " "+list.get(0).getAnnee());
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

			PdfPCell cell2 = new PdfPCell(new Paragraph(list.get(0).getLundi(),
					fontTableCell));
			cell2.disableBorderSide(PdfPCell.TOP);
			cell2.setExtraParagraphSpace(10f);

			PdfPCell cell3 = new PdfPCell(new Paragraph("Mardi", fontTableCell));
			cell3.disableBorderSide(PdfPCell.TOP);
			cell3.setExtraParagraphSpace(10f);

			PdfPCell cell4 = new PdfPCell(new Paragraph(list.get(0).getMardi(),
					fontTableCell));
			cell4.disableBorderSide(PdfPCell.TOP);
			cell4.setExtraParagraphSpace(10f);

			PdfPCell cell5 = new PdfPCell(new Paragraph("Mercredi",
					fontTableCell));
			cell5.disableBorderSide(PdfPCell.TOP);
			cell5.setExtraParagraphSpace(10f);

			PdfPCell cell6 = new PdfPCell(new Paragraph(list.get(0)
					.getMercredi(), fontTableCell));
			cell6.disableBorderSide(PdfPCell.TOP);
			cell6.setExtraParagraphSpace(10f);

			PdfPCell cell7 = new PdfPCell(new Paragraph("Jeudi", fontTableCell));
			cell7.disableBorderSide(PdfPCell.TOP);
			cell7.setExtraParagraphSpace(10f);

			PdfPCell cell8 = new PdfPCell(new Paragraph(list.get(0).getJeudi(),
					fontTableCell));
			cell8.disableBorderSide(PdfPCell.TOP);
			cell8.setExtraParagraphSpace(10f);

			PdfPCell cell9 = new PdfPCell(new Paragraph("Vendredi",
					fontTableCell));
			cell9.disableBorderSide(PdfPCell.TOP);
			cell9.setExtraParagraphSpace(10f);

			PdfPCell cell10 = new PdfPCell(new Paragraph(list.get(0)
					.getVendredi(), fontTableCell));
			cell10.disableBorderSide(PdfPCell.TOP);
			cell10.setExtraParagraphSpace(10f);

			PdfPCell cell11 = new PdfPCell(new Paragraph("Samedi",
					fontTableCell));
			cell11.disableBorderSide(PdfPCell.TOP);
			cell11.setExtraParagraphSpace(10f);

			PdfPCell cell12 = new PdfPCell(new Paragraph(list.get(0)
					.getSamedi(), fontTableCell));
			cell12.disableBorderSide(PdfPCell.TOP);
			cell12.setExtraParagraphSpace(10f);

			PdfPCell cell13 = new PdfPCell(new Paragraph("Dimanche",
					fontTableCell));
			cell13.disableBorderSide(PdfPCell.TOP);
			cell13.setExtraParagraphSpace(10f);
			

			PdfPCell cell14 = new PdfPCell(new Paragraph(list.get(0)
					.getDimanche(), fontTableCell));
			cell14.disableBorderSide(PdfPCell.TOP);
			cell14.setExtraParagraphSpace(10f);
			
			PdfPCell cell15 = new PdfPCell(new Paragraph("Jours fériés",
					fontTableCell));
			cell15.disableBorderSide(PdfPCell.TOP);
			cell15.setExtraParagraphSpace(10f);
			
			PdfPCell cell16 = new PdfPCell(new Paragraph(list.get(0)
					.getConge(), fontTableCell));
			cell16.disableBorderSide(PdfPCell.TOP);
			cell16.setExtraParagraphSpace(10f);

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
			tableDay.addCell(cell15);
			tableDay.addCell(cell16);
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
			PdfPCell subTotalValueCell = new PdfPCell(new Paragraph(list.get(0)
					.getTotalHeuresS()));
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
			PdfPCell taxRateValueCell = new PdfPCell(new Paragraph(list.get(0)
					.getTotalHeureW()));
			disableBorder(taxRateValueCell);
			taxRateValueCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			taxRateValueCell.setExtraParagraphSpace(10f);
			
			PdfPCell subTotalCell1 = new PdfPCell(new Paragraph(
					"Total d'heures/JF"));
			disableBorder(subTotalCell1);
			subTotalCell1.setHorizontalAlignment(Element.ALIGN_RIGHT);
			subTotalCell1.setPaddingTop(10);
			subTotalCell1.setBackgroundColor(new BaseColor(0xE4, 0xE8, 0xF3));
			subTotalCell1.setExtraParagraphSpace(10f);
			// To add value in cell
			PdfPCell subTotalValueCell1 = new PdfPCell(new Paragraph(list.get(0)
					.getConge()));
			subTotalValueCell1.setPaddingTop(10);
			disableBorder(subTotalValueCell1);
			subTotalValueCell1.setHorizontalAlignment(Element.ALIGN_RIGHT);
			subTotalValueCell1
					.setBackgroundColor(new BaseColor(0xE4, 0xE8, 0xF3));
			subTotalValueCell1.setExtraParagraphSpace(10f);

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
			PdfPCell totalValueCell = new PdfPCell(new Paragraph(list.get(0)
					.getTotalHeures()));
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
			otherTable.addCell(subTotalCell1);
			otherTable.addCell(subTotalValueCell1);
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
			check.add("Montant à payer : ");
			Chunk checkchunk = new Chunk(list.get(0).getValeurAPayer());
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
					.add(" APPROUVÉE PAR :  ----------------------------------------------------------");
			phraseSignature.add(Chunk.NEWLINE);
			phraseSignature
					.add("                                                       ");
			phraseSignature
					.add("                                                      ");
			phraseSignature.add("                                          ");
			phraseSignature.add("Direction des Ressources Humaines");
			phraseSignature.setFont(signatureFont);
			Paragraph signaturePara = new Paragraph();
			signaturePara.add(phraseSignature);
			signaturePara.setAlignment(Element.ALIGN_LEFT);
			signature.addCell(signaturePara);
			signature.setWidthPercentage(100);

			//

			PdfPTable signature2 = new PdfPTable(1);
			Font signatureFont2 = new Font(FontFamily.TIMES_ROMAN, 13,
					Font.BOLD);
			Phrase phraseSignature2 = new Phrase();
			phraseSignature2.setFont(signatureFont2);

			phraseSignature2
					.add("----------------------------------------------------------");
			phraseSignature2.add(Chunk.NEWLINE);
			phraseSignature2.add("              ");
			phraseSignature2.add("SIGNATURE EMPLOYÉ(E)");
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

			document.add(paraWissen);
			document.add(Chunk.NEWLINE);
			document.add(invoicePara);
			// document.add(invoiceDescript);
			document.add(Chunk.NEWLINE);
			document.add(Chunk.NEWLINE);
			document.add(Chunk.NEWLINE);
			document.add(Chunk.NEWLINE);
			document.add(Chunk.NEWLINE);
//			document.add(Chunk.NEWLINE);
			document.add(addressPara);
			// document.add(billToPara);

			File f = new File("");
			System.out.println(" =============== : " + f.getAbsolutePath());

			Paragraph invoicePara1 = new Paragraph();
			invoicePara1.add(f.getAbsolutePath());
			document.add(Chunk.NEWLINE);
//			document.add(Chunk.NEWLINE);
			
			//document.add(invoicePara1);
			document.add(tableDay);
			document.add(Chunk.NEWLINE);
			document.add(otherTable);
			document.add(tipPara);
			
			
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
//			document.add(Chunk.NEWLINE);
			
			document.add(tableFooter);
			// document.add(lineSeparator);
			//document.add(invoicePara1);
			// //Ajout d'une image de fond
			// PdfContentByte canvas = writer.getDirectContentUnder();
//			Image image = Image.getInstance("/var/lib/tomcat6/supplementaire/background.png");
//			Image image = Image.getInstance("/var/lib/tomcat8/supplementaire/background.png");
			Image image = Image.getInstance("images/backgroundFormMEF.png");
			image.scaleAbsolute(PageSize.A3);
			image.setAbsolutePosition(2, 0);
			// canvas.addImage(image);
			document.add(image);

			document.close();

		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest resquest) {
		this.request = resquest;
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public void disableBorder(PdfPCell cell) {
		cell.disableBorderSide(PdfPCell.TOP);
		cell.disableBorderSide(PdfPCell.BOTTOM);
		cell.disableBorderSide(PdfPCell.LEFT);
		cell.disableBorderSide(PdfPCell.RIGHT);

	}

	// public void imageToByte(){
	//
	//
	// try {
	// BufferedImage originalImage = ImageIO.read(new File(
	// "background.png"));
	//
	// baos = new ByteArrayOutputStream();
	// ImageIO.write(originalImage, "png", baos);
	// baos.flush();
	// imageInByte = baos.toByteArray();
	//
	// // convert array of bytes into modified file again
	// fileOuputStream = new FileOutputStream(
	// "Converted_Small_Red_Rose.JPG");
	// fileOuputStream.write(imageInByte);
	//
	// System.out.println("Conversion completed");
	// System.out.println("Byte================"+fileOuputStream.getChannel());
	//
	// } catch (IOException e) {
	// e.printStackTrace();
	// }finally{
	// try {
	// baos.close();
	// fileOuputStream.close();
	// } catch (IOException e) {
	// e.printStackTrace();
	// }
	//
	// }
	// }

	// public Image byteToImage(){
	// try{
	// InputStream in = new ByteArrayInputStream(imageInByte);
	// BufferedImage bImageFromConvert = ImageIO.read(in);
	//
	// boolean image=ImageIO.write(bImageFromConvert, "jpg",
	// response.getOutputStream());
	// }catch(Exception ex){}
	// return null;
	// }

}
