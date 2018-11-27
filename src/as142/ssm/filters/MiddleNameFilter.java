package as111.ssm.filters;

import as111.ssm.User;

public class MiddleNameFilter extends PrefixFilter {

    @Override
    protected String getField(User user) {
        return user.getMiddleName();
    }

    @Override
    public String getFilterName() {
        return "middleName";
    }
}