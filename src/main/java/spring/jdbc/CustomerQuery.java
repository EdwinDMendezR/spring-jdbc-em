package spring.jdbc;

public enum CustomerQuery {

    SELECT_CUSTOMER("SELECT * FROM customer", true);

    private final String query;
    private final boolean isRequired;

    CustomerQuery(
            String query,
            boolean isRequired) {
        this.query = query;
        this.isRequired = isRequired;
    }

    public String getQuery() {
        if(isRequired) {
            throw new UnsupportedOperationException("This query requires completion.");
        }
        return query;
    }


}
