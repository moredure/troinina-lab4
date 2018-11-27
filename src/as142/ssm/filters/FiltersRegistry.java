package as111.ssm.filters;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FiltersRegistry {
	private static Map<String, AppRowFilter> filtersByName;
	static {
		filtersByName = new HashMap<String, AppRowFilter>();
		AppRowFilter[] filters = {
				new NameFilter(),
				new SurnameFilter(),
				new ContractIdFilter(),
				new MiddleNameFilter(),
		};
		for(AppRowFilter filter : filters) {
			filtersByName.put(filter.getFilterName(), filter);
		}
	}
	
	public static String[] getFiltersNames() {
		String[] arr = filtersByName.keySet().toArray(new String[filtersByName.size()]);
		Arrays.sort(arr);
		return arr;
	}
	
	public static AppRowFilter getFilter(String name, String value) {
		AppRowFilter filter = filtersByName.get(name);
		if(filter != null) {
			filter.setFilterValue(value);
		}
		return filter;
	}
}
