package com.proface.api.reports;

import java.util.List;

import org.springframework.stereotype.Component;

import com.itextpdf.text.Element;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.proface.api.entities.Product;

@Component
public class ProductReport extends ProfaceReport<Product> {

	private static final int COLUMNS_NUMBER = 8;
	private static final int WIDTH_PERCENTAGE = 100;
	private static final String TITLE = "Productos";
	private static final String TABLE_NAME = "Lista de Productos";
	private static final int[] WIDTHS_VALUES = { 1, 2, 3, 1, 1, 1, 1, 1 };
	private static final String[] HEADER_VALUES = { "ID", "Nombre", "Descripción", "Línea", "Precio", "Total",
			"Separado", "Disponible" };

	@Override
	protected void fillCellsValues(List<Product> entities, PdfPTable table) {
		entities.forEach(e -> {

			PdfPCell cell;

			cell = new PdfPCell(new Phrase(e.getNativeId()));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			table.addCell(cell);

			cell = new PdfPCell(new Phrase(e.getName()));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			table.addCell(cell);

			cell = new PdfPCell(new Phrase(e.getDescription()));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			table.addCell(cell);

			cell = new PdfPCell(new Phrase(e.getLine() != null ? e.getLine().getName() : "Sin línea"));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			table.addCell(cell);

			cell = new PdfPCell(new Phrase("S/. " + e.getLocalPrice()));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			table.addCell(cell);

			cell = new PdfPCell(new Phrase(String.valueOf(e.getTotalStock())));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			table.addCell(cell);

			cell = new PdfPCell(new Phrase(String.valueOf(e.getTotalStock() - e.getAvaliableStock())));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			table.addCell(cell);

			cell = new PdfPCell(new Phrase(String.valueOf(e.getAvaliableStock())));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			table.addCell(cell);

		});
	}

	@Override
	protected int getColumnsNumber() {
		return COLUMNS_NUMBER;
	}

	@Override
	protected String[] getHeadersValues() {
		return HEADER_VALUES;
	}

	@Override
	protected String getTableName() {
		return TABLE_NAME;
	}

	@Override
	protected String getTitle() {
		return TITLE;
	}

	@Override
	protected int getWidthPercentage() {
		return WIDTH_PERCENTAGE;
	}

	@Override
	protected int[] getWidthValues() {
		return WIDTHS_VALUES;
	}

}
