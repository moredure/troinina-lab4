package as111.ssm.filters;

import as111.ssm.User;

public abstract class PrefixFilter extends AppRowFilter {
	
	@Override
	public boolean isIncluded(User user) {
		if(filterValue == null) return true;
		String field = getField(user);
		if(field == null) field = "";
		return field.toLowerCase().startsWith(filterValue);
	}
	
	protected abstract String getField(User user);
}
