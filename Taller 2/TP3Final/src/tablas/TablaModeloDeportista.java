package tablas;

import javax.swing.table.DefaultTableModel;

import entregable3.*;

public class TablaModeloDeportista extends DefaultTableModel {

	private static final long serialVersionUID = 1L;

	public TablaModeloDeportista(final Object[][] datos, final String[] titulos) {
		super(datos, titulos);
	}
	
	public Class<? extends Object> getColumnClass(final int column) {
		return this.getValueAt(0, column).getClass();
	}
	
	public void removeRow(int row) {
		super.removeRow(row);
	}
	@Override
	public boolean isCellEditable(int row, int column) {
		
		return false;
	}
	@Override
	public void addRow(Object[] datos) {
		super.addRow(datos);
		GestorDeOlimpiadasPais gestor = new GestorDeOlimpiadasPais();
		gestor.cargaTabla();
		gestor = null;
	}

}