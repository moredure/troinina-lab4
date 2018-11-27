package as111.ssm.comparators;

import as111.ssm.User;

public class SurnameComparator extends UserComparator {
	
	@Override
	public int compare(User first, User second) {
		return first.getSurname().compareTo(second.getSurname());
	}
	
	@Override
	public String getComparatorName() {
		return "Surname";
	}
}
