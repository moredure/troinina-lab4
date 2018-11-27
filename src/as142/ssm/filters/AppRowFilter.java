package as111.ssm.filters;

import javax.swing.RowFilter;

import as111.ssm.User;
import as111.ssm.gui.AppTableModel;

public abstract class AppRowFilter extends RowFilter<AppTableModel, Integer> {
	protected String filterValue;
	
	public void setFilterValue(String value) {
		filterValue = (value == null)? null : value.toLowerCase();
	}
	
	public abstract String getFilterName();
	
	@Override
	public boolean include(RowFilter.Entry<? extends AppTableModel, ? extends Integer> entry) {
		int rowIndex = entry.getIdentifier();
		return isIncluded(entry.getModel().getUser(rowIndex));
	}
	
	public abstract boolean isIncluded(User user);
}
