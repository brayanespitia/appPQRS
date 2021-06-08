package com.appPQRS.view.pdf;

import java.awt.Color;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.appPQRS.entity.Solicitud;

import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfTable;
import com.lowagie.text.pdf.PdfWriter;


@Component("main/pqrs")
public class pqrsPdfView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		Solicitud solicitud = (Solicitud) model.get("solicitud");

		
		
		/*Fuentes, tamaños y colores para cada seccion*/
		Font fuenteTitulo = FontFactory.getFont(FontFactory.HELVETICA_BOLD,20,Color.BLACK);
		Font fuenteTituloColumnas = FontFactory.getFont(FontFactory.HELVETICA_BOLD ,8,Color.BLACK);
		Font fuenteDataCeldas = FontFactory.getFont(FontFactory.COURIER ,10,Color.BLACK);
	
		
	
		
		document.setPageSize(PageSize.LETTER.rotate());
		document.setMargins(-20,-20,30,30);
	
		document.open();
		PdfPCell celda = null;
		
		
		
		   
		  
	      
		  

		
		/*Tabla Para El Titulo del PDF*/
		
	
		
		
		PdfPTable tablaTitulo = new PdfPTable(1);
		
		celda = new PdfPCell(new Phrase("LISTADO DE PQRS", fuenteTitulo));
		celda.setBorder(0);
		celda.setBackgroundColor(new Color(255,0,0));
		
		celda.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
		celda.setVerticalAlignment(PdfPCell.ALIGN_CENTER);
		celda.setPadding(30);
		
		tablaTitulo.addCell(celda);
		tablaTitulo.setSpacingAfter(20);
		
		
		
		/*Tabla Para Mostrar Listado de Clientes*/
		PdfPTable tablaSolicitudes = new PdfPTable(8);
		tablaSolicitudes.setWidths(new float[] {0.8f, 2f, 2f, 1.5f, 1.5f, 2.5f,2.5f, 4f});	
		
		celda = new PdfPCell(new Phrase("ID", fuenteTituloColumnas));
		celda.setBackgroundColor(Color.lightGray);
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(10);
		tablaSolicitudes.addCell(celda);
		
		celda = new PdfPCell(new Phrase("Usuario", fuenteTituloColumnas));
		celda.setBackgroundColor(Color.lightGray);
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(5);
		tablaSolicitudes.addCell(celda);
		
		celda = new PdfPCell(new Phrase("Identificacion", fuenteTituloColumnas));
		celda.setBackgroundColor(Color.lightGray);
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(5);
		tablaSolicitudes.addCell(celda);
		
		celda = new PdfPCell(new Phrase("Tipo PQRS", fuenteTituloColumnas));
		celda.setBackgroundColor(Color.lightGray);
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(5);
		tablaSolicitudes.addCell(celda);
		
		celda = new PdfPCell(new Phrase("Motivo", fuenteTituloColumnas));
		celda.setBackgroundColor(Color.lightGray);
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(5);
		tablaSolicitudes.addCell(celda);
		
		celda = new PdfPCell(new Phrase("Funcionario", fuenteTituloColumnas));
		celda.setBackgroundColor(Color.lightGray);
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(5);
		tablaSolicitudes.addCell(celda);
		
		celda = new PdfPCell(new Phrase("Fecha solicitud", fuenteTituloColumnas));
		celda.setBackgroundColor(Color.lightGray);
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(5);
		tablaSolicitudes.addCell(celda);
		
		celda = new PdfPCell(new Phrase("Solicitud", fuenteTituloColumnas));
		celda.setBackgroundColor(Color.lightGray);
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(5);
		tablaSolicitudes.addCell(celda);
		
		
	
		
	
	
		
		
		
		
		List<Solicitud> listadoSolicitudes = (List<Solicitud>) model.get("solicitudes");
		
		
		/*Bucle For, mostrar todos los datos de los clientes*/	
		
		for (Solicitud solicitu : listadoSolicitudes) {
			
			celda = new PdfPCell(new Phrase("" + solicitu.getId(), fuenteDataCeldas));
			celda.setPadding(5);
			tablaSolicitudes.addCell(celda);
			
			
			celda = new PdfPCell(new Phrase(solicitu.getUsuario().getPrimerNombre() + "" +solicitu.getUsuario().getPrimerApellido() , fuenteDataCeldas));
			celda.setPadding(5);			
			tablaSolicitudes.addCell(celda);
			
			celda = new PdfPCell(new Phrase(solicitu.getUsuario().getIdentificacion(), fuenteDataCeldas));
			celda.setPadding(5);
			tablaSolicitudes.addCell(celda);
			
			celda = new PdfPCell(new Phrase(solicitu.getTipoSolicitud(), fuenteDataCeldas));
			celda.setPadding(5);
			tablaSolicitudes.addCell(celda);
			
			celda = new PdfPCell(new Phrase(solicitu.getMotivoSolicitud(), fuenteDataCeldas));
			celda.setPadding(5);
			tablaSolicitudes.addCell(celda);
			
			celda = new PdfPCell(new Phrase(solicitu.getFuncionario(), fuenteDataCeldas));
			celda.setPadding(5);
			tablaSolicitudes.addCell(celda);
			
			celda = new PdfPCell(new Phrase(solicitu.getFechaRegistro().toString(), fuenteDataCeldas));
			celda.setPadding(5);
			tablaSolicitudes.addCell(celda);
			
			celda = new PdfPCell(new Phrase(solicitu.getDescripcion(), fuenteDataCeldas));
			celda.setPadding(5);
			tablaSolicitudes.addCell(celda);
			
		}
		
		
	
		
		
		document.add(tablaTitulo);
		document.add(tablaSolicitudes);
		
	}

}
