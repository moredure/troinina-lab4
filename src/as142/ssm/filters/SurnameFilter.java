package as111.ssm.filters;

import as111.ssm.User;

public class SurnameFilter extends PrefixFilter {

	@Override
	protected String getField(User user) {
		return user.getSurname();
	}
	
	@Override
	public String getFilterName() {
		return "surname";
	}
}
