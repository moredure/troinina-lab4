package as111.ssm.comparators;

import java.util.Comparator;

import as111.ssm.User;

public abstract class UserComparator implements Comparator<User> {
	public abstract String getComparatorName();
}
