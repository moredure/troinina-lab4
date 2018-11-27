package as111.ssm.filters;

import as111.ssm.User;

public class ContractIdFilter extends PrefixFilter {

	@Override
	protected String getField(User user) {
		return user.getContractId();
	}

	@Override
	public String getFilterName() {
		return "Contract ID";
	}
}
