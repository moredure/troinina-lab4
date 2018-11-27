package as111.ssm.gui;

import java.awt.FlowLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Comparator;

import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableRowSorter;

import as111.ssm.Directory;
import as111.ssm.User;
import as111.ssm.comparators.ComparatorsRegistry;
import as111.ssm.filters.AppRowFilter;
import as111.ssm.filters.FiltersRegistry;

public class ApplicationWindow extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private final Directory directory;
	private TableRowSorter<AppTableModel> rowSorter;
	private JTable table;
	
	public ApplicationWindow(Directory usersDirectory) {
		super();
		this.directory = usersDirectory;
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		add(getFilterPanel());
		
		add(getSortPanel());
		
		AppTableModel model = new AppTableModel(directory);
		rowSorter = new TableRowSorter<AppTableModel>(model);
		rowSorter.sort();

		table = new JTable(model);
		JScrollPane pane = new JScrollPane(table);
		table.setRowSorter(rowSorter);
		table.addMouseListener(new MouseAdapter() {
		    public void mousePressed(MouseEvent me) {
		        JTable table =(JTable) me.getSource();
		        Point p = me.getPoint();
		        int row = table.rowAtPoint(p);
		        if (me.getClickCount() == 2) {
		        	UserWindow window = new UserWindow(directory.getUser(row));
		        	window.addWindowListener(new WindowAdapter() {
		        		@Override
		        		public void windowClosed(WindowEvent e) {
		        			table.repaint();
		        		}
		        	});
		        }
		    }
		});
		add(pane);
	}
	
	private JPanel getFilterPanel() {
		JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		
		panel.add(new JLabel("Choose field: "));
		
		final JComboBox<String> filterCombo = new JComboBox<String>(
				FiltersRegistry.getFiltersNames());
		panel.add(filterCombo);
		
		panel.add(new JLabel("Filter value: "));
		
		final JTextField filterValueField = new JTextField(15);
		panel.add(filterValueField);
		
		ActionListener listener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Object selected = filterCombo.getSelectedItem();
				if(selected instanceof String) {
					AppRowFilter filter = FiltersRegistry.getFilter((String) selected, 
							filterValueField.getText());
					rowSorter.setRowFilter(filter);
				}
			}
		};
		filterCombo.addActionListener(listener);
		filterValueField.addActionListener(listener);
		
		return panel;
	}
	
	private JPanel getSortPanel() {
		JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		
		panel.add(new JLabel("Field to sort: "));
		final JComboBox<String> combo = new JComboBox<String>(
				ComparatorsRegistry.getComparatorsNames());
		
		combo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Object selected = combo.getSelectedItem();
				if(selected instanceof String) {
					Comparator<User> comparator = 
							ComparatorsRegistry.getComparator((String) selected);
					directory.sort(comparator);
					table.repaint();
				}
			}
		});
		
		panel.add(combo);
		
		return panel;
	}
}
