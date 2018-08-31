package com.supp.work.soft.server.rapport;


import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
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
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

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
import com.itextpdf.text.pdf.PdfTemplate;
import com.itextpdf.text.pdf.PdfWriter;
import com.lowagie.text.pdf.DefaultFontMapper;
import com.supp.work.soft.client.vue.Formulaire;
//import com.supp.work.soft.client.vue.Formulaire;
import com.supp.work.soft.shared.model.Employes;

public class ReportWithSector {

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
	
	JFreeChart chart;

	public JFreeChart getChart() {
		return chart;
	}

	public void setChart(JFreeChart chart) {
		this.chart = chart;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public ReportWithSector() {

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
		Rectangle pageSize = new Rectangle(940, 1100);
		
		// BaseColor backColor = new BaseColor(0xDF, 0xFF, 0xDE);
		// pageSize.setBackgroundColor(backColor);
		try {
			float drh=0;
			float daa=0;
			float dsi=0;			
			float ucdd=0;
			float uep=0;
			float ucsa=0;			
			float dg=0;
			float dee=0;
			float daj=0;
			float dpc=0;
			float dif=0;
			float dgtcp=0;			
			float ucgppp=0;
			float crfpge=0;
			float total=0;
			
//			System.out.println(list.size());
			for(int i=0;i<list.size();i++){
				
				if(list.get(i).getDirection().equals("DAA")){
					daa=daa+Float.valueOf(list.get(i).getValeurAPayer());
				}
				if(list.get(i).getDirection().equals("DRH")){
					drh=drh+Float.valueOf(list.get(i).getValeurAPayer());
				}
				if(list.get(i).getDirection().equals("DSI")){
					dsi=dsi+Float.valueOf(list.get(i).getValeurAPayer());
				}			
				if(list.get(i).getDirection().equals("UCDD")){
					ucdd=ucdd+Float.valueOf(list.get(i).getValeurAPayer());
				}
				if(list.get(i).getDirection().equals("DGTCP")){
					dgtcp=dgtcp+Float.valueOf(list.get(i).getValeurAPayer());
				}								

				if(list.get(i).getDirection().equals("UEP")){
					uep=uep+Float.valueOf(list.get(i).getValeurAPayer());
				}
				if(list.get(i).getDirection().equals("UCSA")){
					ucsa=ucsa+Float.valueOf(list.get(i).getValeurAPayer());
				}		
				if(list.get(i).getDirection().equals("DG")){
					dg=dg+Float.valueOf(list.get(i).getValeurAPayer());
				}
				if(list.get(i).getDirection().equals("DEE")){
					dee=dee+Float.valueOf(list.get(i).getValeurAPayer());
				}
				if(list.get(i).getDirection().equals("DAJ")){
					daj=daj+Float.valueOf(list.get(i).getValeurAPayer());
				}				
				
				if(list.get(i).getDirection().equals("DPC")){
					dpc=dpc+Float.valueOf(list.get(i).getValeurAPayer());
				}			
				if(list.get(i).getDirection().equals("DIF")){
					dif=dif+Float.valueOf(list.get(i).getValeurAPayer());
				}
				if(list.get(i).getDirection().equals("UCGPPP")){
					ucgppp=ucgppp+Float.valueOf(list.get(i).getValeurAPayer());
				}
				if(list.get(i).getDirection().equals("CRFPGE")){
					crfpge=crfpge+Float.valueOf(list.get(i).getValeurAPayer());
				}
				total=total+Float.valueOf(list.get(i).getValeurAPayer());
			}
			System.out.println("dskdfdkfdkfkf===========total"+total);
			

			/* Create Pie Chart */
            DefaultPieDataset myColoredPieChart = new DefaultPieDataset();                
            myColoredPieChart.setValue("DAA "+daa*100/total+"%", daa);
            myColoredPieChart.setValue("DRH "+drh*100/total+"%", drh);
            myColoredPieChart.setValue("DSI "+dsi*100/total+"%", dsi);
            myColoredPieChart.setValue("UCDD "+ucdd*100/total+"%", ucdd);          
            myColoredPieChart.setValue("DGTCP "+dgtcp*100/total+"%", dgtcp);
            myColoredPieChart.setValue("UEP "+uep*100/total+"%", uep);
            myColoredPieChart.setValue("UCSA "+ucsa*100/total+"%", ucsa);
            myColoredPieChart.setValue("DG "+dg*100/total+"%", dg);
            myColoredPieChart.setValue("DEE "+dee*100/total+"%", dee);            
            myColoredPieChart.setValue("DAJ "+daj*100/total+"%", daj);
            myColoredPieChart.setValue("DPC "+dpc*100/total+"%", dpc);
            myColoredPieChart.setValue("DIF "+dif*100/total+"%", dif);
//            myColoredPieChart.setValue("BDPG", bdpg);
            myColoredPieChart.setValue("UCGPPP "+ucgppp*100/total+"%", ucgppp); 
            myColoredPieChart.setValue("CRFPGE "+crfpge*100/total+"%", crfpge);
            
//            myColoredPieChart.setValue("DAA", 10.3);
//            myColoredPieChart.setValue("DRH", 23.6);
//            myColoredPieChart.setValue("DSI", 45.3);
//            myColoredPieChart.setValue("UCDD", 210);          
//            myColoredPieChart.setValue("CC", 232);
//            myColoredPieChart.setValue("UEP", 321);
//            myColoredPieChart.setValue("UCSA", 231);
//            myColoredPieChart.setValue("SG", 98);
//            myColoredPieChart.setValue("DEE", 906);            
//            myColoredPieChart.setValue("DAJ", 24.4);
//            myColoredPieChart.setValue("DPC", 45);
//            myColoredPieChart.setValue("DIF", 567);
//            myColoredPieChart.setValue("BDPG", 432);
//            myColoredPieChart.setValue("UCGPPP", 102); 
            JFreeChart myColoredChart=ChartFactory.createPieChart("R�partition du montant global",myColoredPieChart,true,true,false);
            /* Color Pie Chart */
            PiePlot ColorConfigurator = (PiePlot)myColoredChart.getPlot();                
            ColorConfigurator.setSectionPaint("DAA "+daa*100/total+"%", new Color(160, 160, 255));
            ColorConfigurator.setSectionPaint("DRH "+drh*100/total+"%", Color.ORANGE);
            ColorConfigurator.setSectionPaint("DSI "+dsi*100/total+"%", Color.GREEN);
            ColorConfigurator.setSectionPaint("UCDD "+ucdd*100/total+"%", Color.PINK); 
            ColorConfigurator.setSectionPaint("DGTCP "+dgtcp*100/total+"%", Color.BLUE);
            ColorConfigurator.setSectionPaint("UEP "+uep*100/total+"%", Color.CYAN);
//            ColorConfigurator.setSectionPaint("CC", Color.BLUE);           
            ColorConfigurator.setSectionPaint("UCSA "+ucsa*100/total+"%", Color.GRAY);
            ColorConfigurator.setSectionPaint("DG "+dg*100/total+"%", Color.BLACK);            
            ColorConfigurator.setSectionPaint("DEE "+dee*100/total+"%", Color.MAGENTA);
            ColorConfigurator.setSectionPaint("DAJ "+daj*100/total+"%", Color.DARK_GRAY);
            ColorConfigurator.setSectionPaint("DPC "+dpc*100/total+"%", Color.RED);
            ColorConfigurator.setSectionPaint("DIF "+dif*100/total+"%", Color.WHITE); 
//            ColorConfigurator.setSectionPaint("BDPG", Color.BLACK);
            ColorConfigurator.setSectionPaint("UCGPPP "+ucgppp*100/total+"%", Color.YELLOW);
            ColorConfigurator.setSectionPaint("CRFPGE "+crfpge*100/total+"%", new Color(163, 73, 164));
            /* We have to insert this colored Pie Chart into the PDF file using iText now */                
            int width=1070; /* Width of our chart */
            int height=480; /* Height of our chart */            
			Document document =  new Document(pageSize);

			// To add font color
			PdfWriter writer = PdfWriter.getInstance(document,
					response.getOutputStream());

			document.open();
			
			
			document.addTitle("How to color your Pie Chart and embed in a PDF file using iText");
			document.addAuthor("Adelain EUGENE");                
			document.addKeywords("");                
            PdfContentByte Add_Chart_Content= writer.getDirectContent();                
            PdfTemplate template_Chart_Holder=Add_Chart_Content.createTemplate(width,height);                
//            Graphics2D Graphics_Chart=template_Chart_Holder.createGraphics(width,height,new DefaultFontMapper()); 
            Graphics2D Graphics_Chart=template_Chart_Holder.createGraphics(width, height, true, 102);
            Rectangle2D Chart_Region=new Rectangle2D.Double(20,0,900,450);                
            myColoredChart.draw(Graphics_Chart,Chart_Region);            
            Graphics_Chart.dispose();
//            On peut changer de position
            Add_Chart_Content.addTemplate(template_Chart_Holder,0,400);   
            
            
            
//            DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
//    		dataSet.setValue(drh, "Population", "DRH");
//    		dataSet.setValue(daa, "Population", "DAA");
//    		dataSet.setValue(dsi, "Population", "DSI");
//    		dataSet.setValue(ucdd, "Population", "UCDD");
//    		dataSet.setValue(dgtcp, "Population", "DGTCP");
//    		dataSet.setValue(uep, "Population", "UEP");   		
//    		dataSet.setValue(ucsa, "Population", "UCSA");
//    		dataSet.setValue(dg, "Population", "DG");
//    		dataSet.setValue(dee, "Population", "DEE");
//    		dataSet.setValue(daj, "Population", "DAJ");
//    		dataSet.setValue(dpc, "Population", "DPC");
//    		dataSet.setValue(dif, "Population", "DIF");
//    		dataSet.setValue(ucgppp, "Population", "UCGPPP");
//    		dataSet.setValue(crfpge, "Population", "CRFPGE");
            
            
//            dataSet.setValue(23.6, "Population", "DRH");
//    		dataSet.setValue(10.3, "Population", "DAA");
//    		dataSet.setValue(40.3, "Population", "DSI");
//    		dataSet.setValue(200, "Population", "UCDD");
//    		dataSet.setValue(232, "Population", "CC");
//    		dataSet.setValue(321, "Population", "UEP");   		
//    		dataSet.setValue(231, "Population", "UCSA");
//    		dataSet.setValue(98, "Population", "SG");
//    		dataSet.setValue(906, "Population", "DEE");
//    		dataSet.setValue(24.4, "Population", "DAJ");
//    		dataSet.setValue(45, "Population", "DPC");
//    		dataSet.setValue(267, "Population", "DIF");
//    		dataSet.setValue(102, "Population", "UCGPPP");
    		

    		
//    		JFreeChart chart = ChartFactory.createBarChart(
//    				"Représentation du montant global par direction", "DIRECTION", "",
//    				dataSet, PlotOrientation.VERTICAL, false, true, false);
//    		PdfContentByte Add_Chart_Content2= writer.getDirectContent();                
//            PdfTemplate template_Chart_Holder2=Add_Chart_Content2.createTemplate(5000,5000);                
////            Graphics2D Graphics_Chart=template_Chart_Holder.createGraphics(width,height,new DefaultFontMapper()); 
//            Graphics2D Graphics_Chart2=template_Chart_Holder2.createGraphics(1450, 950, true, 102);
//            Rectangle2D Chart_Region2=new Rectangle2D.Double(0,0,940,360);                
//            chart.draw(Graphics_Chart2,Chart_Region2);            
//            Graphics_Chart2.dispose();                
//            Add_Chart_Content2.addTemplate(template_Chart_Holder2,0,0);
	
			Font fontTableHeader = new Font(FontFamily.COURIER, 17, Font.BOLD);
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
			
			Font fontTitre2 = new Font(FontFamily.TIMES_ROMAN, 16, Font.BOLD);
			BaseColor invoiceColorTitre2 = new BaseColor(0x00, 0x00, 0x0);
			fontTitre2.setColor(invoiceColorTitre2);
			Chunk titre2 = new Chunk("RAPPORT MENSUEL DES HEURES SUPPLEMENTAIRES",
					fontTitre2);
			Paragraph paraTitre2 = new Paragraph();
			paraTitre2.add(titre2);
			paraTitre2.setAlignment(Element.ALIGN_CENTER);

			Font invoiceFont = new Font(FontFamily.TIMES_ROMAN, 15, Font.BOLD);
			BaseColor invoiceColor = new BaseColor(0x00, 0x00, 0x0);
			invoiceFont.setColor(invoiceColor);
			Chunk invoices = new Chunk("PRÉSENTATION GRAPHIQUE",
					invoiceFont);
			Paragraph invoicePara = new Paragraph();
			invoicePara.add(invoices);
			invoicePara.setAlignment(Element.ALIGN_CENTER);
			
			
			
			
			
			

			

			document.add(paraWissen);
			document.add(Chunk.NEWLINE);
			document.add(paraTitre2);
			document.add(Chunk.NEWLINE);
			document.add(invoicePara);
			// document.add(invoiceDescript);
			
			document.add(Chunk.NEWLINE);
//			document.add(Chunk.NEWLINE);
			
			// document.add(billToPara);

			File f = new File("");
			System.out.println(" =============== : " + f.getAbsolutePath());

			Paragraph invoicePara1 = new Paragraph();
			invoicePara1.add(f.getAbsolutePath());
			document.add(Chunk.NEWLINE);
//			document.add(Chunk.NEWLINE);
			
			
			
			
			// document.add(Chunk.NEWLINE);
			// document.add(Chunk.NEWLINE);

			
			
			document.add(Chunk.NEWLINE);
			document.add(Chunk.NEWLINE);
			
			

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

	
	public static JFreeChart generatePieChart() {
		DefaultPieDataset dataSet = new DefaultPieDataset();
		dataSet.setValue("China", 19.64);
		dataSet.setValue("India", 17.3);
		dataSet.setValue("United States", 4.54);
		dataSet.setValue("Indonesia", 3.4);
		dataSet.setValue("Brazil", 2.83);
		dataSet.setValue("Pakistan", 2.48);
		dataSet.setValue("Bangladesh", 2.38);

		JFreeChart chart = ChartFactory.createPieChart(
				"World Population by countries", dataSet, true, true, false);

		return chart;
	}

	public static JFreeChart generateBarChart() {
		DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
		dataSet.setValue(791, "Population", "1750 AD");
		dataSet.setValue(978, "Population", "1800 AD");
		dataSet.setValue(1262, "Population", "1850 AD");
		dataSet.setValue(1650, "Population", "1900 AD");
		dataSet.setValue(2519, "Population", "1950 AD");
		dataSet.setValue(6070, "Population", "2000 AD");

		JFreeChart chart = ChartFactory.createBarChart(
				"World Population growth", "Year", "Population in millions",
				dataSet, PlotOrientation.VERTICAL, false, true, false);

		return chart;
	}

}
