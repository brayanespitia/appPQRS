package com.appPQRS.view.pdf;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.appPQRS.entity.Solicitud;

import com.lowagie.text.Document;
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

		PdfPTable tabla = new PdfPTable(1);
		tabla.addCell("REPORTE DE SOLICITUDES PQRS");
		
		tabla.addCell(solicitud.getUsuario().getPrimerNombre() + "" + solicitud.getUsuario().getPrimerApellido());

		
		PdfPTable tabla2 = new PdfPTable(1);
		tabla2.addCell("datos de la solicitud");
		tabla2.addCell("solicitud : " + solicitud.getId());
		tabla2.addCell("descripcion" + solicitud.getDescripcion());
		tabla2.addCell("tipo" + solicitud.getMotivoSolicitud());
		
		document.add(tabla);
		document.add(tabla2);
	}

}
