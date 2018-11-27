package as111.ssm.gui;

import javax.swing.table.AbstractTableModel;

import as111.ssm.Directory;
import as111.ssm.User;

public class AppTableModel extends AbstractTableModel {
	static final String[] COLUMN_NAMES = new String[] {
			"ContractID", "Name", "Surname", "Phone", "E-mail", "MiddleName"
	};
	private static final long serialVersionUID = 1L;
	private final Directory directory;
	
	public AppTableModel(Directory directory) {
		this.directory = directory;
	}
	
	public User getUser(int rowIndex) {
		return directory.getUser(rowIndex);
	}
	
	@Override
	public int getRowCount() {
		return directory.getUsersCount();
	}

	@Override
	public int getColumnCount() {
		return COLUMN_NAMES.length;
	}
	
	@Override
	public String getColumnName(int column) {
		return COLUMN_NAMES[column];
	};
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		User user = directory.getUser(rowIndex);
		String value = null;
		if(user != null) {
			switch(columnIndex) {
			case 0:
				value = user.getContractId(); break;
			case 1:
				value = user.getName(); break;
			case 2:
				value = user.getSurname(); break;
			case 3:
				value = user.getPhone(); break;
			case 4:
				value = user.getMail(); break;
			case 5:
				value = user.getMiddleName(); break;
			}
		}
		return value;
	}
}
