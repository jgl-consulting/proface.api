package com.proface.api.reports;

import java.io.ByteArrayInputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.stereotype.Component;

import com.itextpdf.text.Element;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.proface.api.entities.PurchaseOrder;

@Component
public class PurchaseOrderReport extends ProfaceReport<PurchaseOrder> {

	private static final int COLUMNS_NUMBER = 6;
	private static final int WIDTH_PERCENTAGE = 100;
	private static final String TITLE = "Órdenes de Compra";
	private static final String TABLE_NAME = "Lista de órdenes de compra";
	private static final int[] WIDTHS_VALUES = { 1, 1, 3, 1, 1, 1 };
	private static final String[] HEADER_VALUES = { "ID", "Fecha de emisión", "Proveedor", "Total", "Costos",
			"Estado" };

	@Override
	protected void fillCellsValues(List<PurchaseOrder> entities, PdfPTable table) {
		entities.forEach(e -> {

			PdfPCell cell;

			cell = new PdfPCell(new Phrase(e.getNativeId()));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			table.addCell(cell);

			cell = new PdfPCell(new Phrase(formatLocalDate(e.getCreationDate())));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			table.addCell(cell);

			cell = new PdfPCell(new Phrase(e.getSupplier() != null ? e.getSupplier().getName() : "Sin Proveedor"));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			table.addCell(cell);

			cell = new PdfPCell(new Phrase("S/. " + e.getLocalTotal()));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			table.addCell(cell);

			cell = new PdfPCell(new Phrase("S/. " + e.getLocalCost()));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			table.addCell(cell);

			cell = new PdfPCell(new Phrase(e.getStatus() != null ? e.getStatus().getDescription() : "Sin estado"));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			table.addCell(cell);

		});
	}

	private String formatLocalDate(LocalDate date) {
		if (date != null) {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			return date.format(formatter);
		} else {
			return "Sin fecha";
		}
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
