package Vista;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class VistaTable extends JPanel{
	private DefaultTableModel tableModel;
	private JTable table;
	private JScrollPane scroll;
	private JButton actualizar;
	public VistaTable(){
		actualizar = new JButton("Actualizar tabla");
		tableModel = new DefaultTableModel() {
			public boolean isCellEditable(int fila, int columna) {
			       return false; //Con esto conseguimos que la tabla no se pueda editar
			   }
			
		};
		table = new JTable(tableModel);
		tableModel.addColumn("Codigo");
		tableModel.addColumn("Nombre");
		tableModel.addColumn("PartidasGanadas");
		scroll = new JScrollPane(table);
		add(actualizar);
		add(table);
	}
	
	public JTable enviarTabla(){
		return table;
	}
	public DefaultTableModel enviarModelo(){
		return tableModel;
	}
	
	public JButton getBotonActualizar(){
		return actualizar;
	}
	
}
