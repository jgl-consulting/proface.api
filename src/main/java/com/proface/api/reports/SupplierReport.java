package com.proface.api.reports;

import java.util.List;

import org.springframework.stereotype.Component;

import com.itextpdf.text.Element;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.proface.api.entities.Supplier;
import com.proface.api.entities.SupplierAccount;
import com.proface.api.entities.SupplierContact;

@Component
public class SupplierReport extends ProfaceReport<Supplier> {

	private static final int COLUMNS_NUMBER = 7;
	private static final int WIDTH_PERCENTAGE = 100;
	private static final String TITLE = "Proveedores";
	private static final String TABLE_NAME = "Lista de Proveedores";
	private static final int[] WIDTHS_VALUES = { 1, 2, 2, 1, 1, 2, 2 };
	private static final String[] HEADER_VALUES = { "ID", "Nombre", "Dirección", "País", "Tipo", "Contacto", "Cuenta" };

	protected void fillCellsValues(List<Supplier> entities, PdfPTable table) {
		entities.forEach(e -> {

			PdfPCell cell;

			cell = new PdfPCell(new Phrase(e.getNativeId()));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			table.addCell(cell);

			cell = new PdfPCell(new Phrase(e.getName()));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
			table.addCell(cell);

			cell = new PdfPCell(new Phrase(e.getAddress()));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			table.addCell(cell);

			cell = new PdfPCell(new Phrase(e.getCountry() != null ? e.getCountry().getName() : "Sin país"));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			table.addCell(cell);

			cell = new PdfPCell(new Phrase(e.getType() != null ? e.getType().getName() : "Sin tipo"));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			table.addCell(cell);

			cell = new PdfPCell(new Phrase(getContact(e)));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			table.addCell(cell);

			cell = new PdfPCell(new Phrase(getAccount(e)));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			table.addCell(cell);

		});
	}

	private String getContact(Supplier supplier) {
		List<SupplierContact> contacts = supplier.getContacts();
		if (contacts != null && !contacts.isEmpty()) {
			return contacts.get(0).getFirstName() + " " + contacts.get(0).getLastName();
		} else {
			return "Sin contacto";
		}
	}

	private String getAccount(Supplier supplier) {
		List<SupplierAccount> accounts = supplier.getAccounts();
		if (accounts != null && !accounts.isEmpty()) {
			return accounts.get(0).getNumber();
		} else {
			return "Sin cuenta";
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
