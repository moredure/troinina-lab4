package as111.ssm.filters;

import as111.ssm.User;

public class NameFilter extends PrefixFilter {
	
	@Override
	protected String getField(User user) {
		return user.getName();
	}
	
	@Override
	public String getFilterName() {
		return "name";
	}
}
