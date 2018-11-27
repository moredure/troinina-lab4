package as111.ssm.comparators;

import as111.ssm.User;

public class PhoneComparator extends UserComparator {

	@Override
	public int compare(User first, User second) {
		return first.getPhone().compareTo(second.getPhone());
	}

	@Override
	public String getComparatorName() {
		return "Phone";
	}
}
