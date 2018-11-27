package as111.ssm.comparators;

import as111.ssm.User;

public class MiddleNameComparator extends UserComparator {

    @Override
    public int compare(User first, User second) {
        return first.getMiddleName().compareTo(second.getMiddleName());
    }

    @Override
    public String getComparatorName() {
        return "middleName";
    }
}