package tablas;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;

public class RenderizacionBotones implements TableCellRenderer {
	
		private TableCellRenderer defaultRenderer;

		public RenderizacionBotones(TableCellRenderer renderer) {
			defaultRenderer = renderer;
		}

		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			if (value instanceof Component)
				return (Component) value;
			return defaultRenderer.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
		}

	}
