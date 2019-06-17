package com.proface.api.reports;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class ProfaceReport<E> {

	public ByteArrayInputStream generateProductReport(List<E> entities) {

		Document document = new Document(PageSize.A3.rotate());
		ByteArrayOutputStream out = new ByteArrayOutputStream();

		try {
			
			/**
			 * Title
			 */
			
			Font font = FontFactory.getFont(FontFactory.COURIER_BOLD, 16);
			Chunk chunk = new Chunk(getTableName(), font);
			
			/**
			 * Table
			 */

			PdfPTable table = new PdfPTable(getColumnsNumber());

			/**
			 * Columns Width
			 */
			table.setWidthPercentage(getWidthPercentage());
			table.setWidths(getWidthValues());

			/**
			 * Headers Font
			 */
			Font headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);

			/**
			 * Headers Values
			 */
			for (String headerValue : getHeadersValues()) {
				PdfPCell cell = new PdfPCell(new Phrase(headerValue, headFont));
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
			}

			/**
			 * Columns values
			 */
			fillCellsValues(entities, table);
			
			PdfWriter.getInstance(document, out);
            document.open();
            document.addTitle(getTitle());
            document.add(chunk);
            document.add(table);
            
		} catch (DocumentException ex) {
			throw new RuntimeException(ex);
		} finally {
			if (document != null && document.isOpen()) {
				document.close();
			}
		}

        return new ByteArrayInputStream(out.toByteArray());
	}

	protected String getTitle() {
		return "Entidades";
	}
	
	protected String getTableName() {
		return "Lista";
	}
	
	protected int getWidthPercentage() {
		return 100;
	}
	
	protected int getColumnsNumber() {
		return 10;
	}
	
	protected int[] getWidthValues() {
		return new int[] {1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
	}
	
	protected String[] getHeadersValues() {
		return new String[] {"", "", "", "", "", "", "", "", "", "" };
	}
	
	protected void fillCellsValues(List<E> entities, PdfPTable table) {
		
	}
	
}
