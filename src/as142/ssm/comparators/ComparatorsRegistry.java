package as111.ssm.comparators;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import as111.ssm.User;

public class ComparatorsRegistry {
	public static Map<String, UserComparator> comparatorsByName;
	static {
		comparatorsByName = new HashMap<String, UserComparator>();
		UserComparator[] comparators = new UserComparator[] {
				new ContractIdComparator(),
				new NameComparator(),
				new SurnameComparator(),
				new PhoneComparator(),
				new MiddleNameComparator(),
		};
		
		for(UserComparator comparator : comparators) {
			comparatorsByName.put(comparator.getComparatorName(), comparator);
		}
	}
	
	public static String[] getComparatorsNames() {
		String[] arr = comparatorsByName.keySet().toArray(new String[comparatorsByName.size()]);
		Arrays.sort(arr);
		return arr;
	}
	
	public static Comparator<User> getComparator(String name) {
		return comparatorsByName.get(name);
	}
}
