package as111.ssm.comparators;

import as111.ssm.User;

public class NameComparator extends UserComparator {

	@Override
	public int compare(User first, User second) {
		return first.getName().compareTo(second.getName());
	}

	@Override
	public String getComparatorName() {
		return "Name";
	}
}
