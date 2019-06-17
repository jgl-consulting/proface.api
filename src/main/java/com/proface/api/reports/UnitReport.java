package com.proface.api.reports;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.stereotype.Component;

import com.itextpdf.text.Element;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.proface.api.entities.Unit;

@Component
public class UnitReport extends ProfaceReport<Unit> {

	private static final int COLUMNS_NUMBER = 8;
	private static final int WIDTH_PERCENTAGE = 100;
	private static final String TITLE = "Unidades";
	private static final String TABLE_NAME = "Lista de Unidades";
	private static final int[] WIDTHS_VALUES = { 1, 2, 2, 1, 1, 1, 1, 1 };
	private static final String[] HEADER_VALUES = { "ID", "Producto", "Ubicación", "Fecha de Ingreso",
			"Fecha de Expiración", "Empaque", "Orden de Compra", "Estado" };

	@Override
	protected void fillCellsValues(List<Unit> entities, PdfPTable table) {
		entities.forEach(e -> {

			PdfPCell cell;

			cell = new PdfPCell(new Phrase(e.getNativeId()));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(cell);

			cell = new PdfPCell(new Phrase(e.getProduct() != null ? e.getProduct().getName() : "Sin producto"));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
			table.addCell(cell);

			cell = new PdfPCell(
					new Phrase(e.getLocation() != null ? e.getLocation().getDescription() : "Sin ubicación"));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			table.addCell(cell);

			cell = new PdfPCell(
					new Phrase(e.getBatch() != null ? formatLocalDate(e.getBatch().getEntryDate()) : "Sin fecha"));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			table.addCell(cell);

			cell = new PdfPCell(
					new Phrase(e.getBatch() != null ? formatLocalDate(e.getBatch().getExpirationDate()) : "Sin fecha"));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			table.addCell(cell);

			cell = new PdfPCell(new Phrase(e.getBatch() != null ? e.getBatch().getNativeId() : "Sin empaque"));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			table.addCell(cell);

			cell = new PdfPCell(new Phrase(
					e.getBatch() != null
							? e.getBatch().getPurchase() != null ? e.getBatch().getPurchase().getNativeId()
									: "Sin orden de compra"
							: "Sin empaque"));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			table.addCell(cell);

			cell = new PdfPCell(new Phrase(e.getStatus() != null ? e.getStatus().getDescription() : "Sin estado"));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
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
