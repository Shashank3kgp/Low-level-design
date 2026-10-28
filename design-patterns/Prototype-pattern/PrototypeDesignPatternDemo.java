// Beginner-friendly example of the Prototype Design Pattern in Java
// This version models an ORM-style SQL query prototype.

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

interface QueryPrototype {
    QueryPrototype clone();
    String toSql();
}

class SelectQuery implements QueryPrototype {
    private String table;
    private List<String> columns;
    private Map<String, Object> filters;
    private String orderBy;

    public SelectQuery(String table, List<String> columns, Map<String, Object> filters, String orderBy) {
        this.table = table;
        this.columns = new ArrayList<>(columns);
        this.filters = new HashMap<>(filters);
        this.orderBy = orderBy;
    }

    private SelectQuery(SelectQuery source) {
        this.table = source.table;
        this.columns = new ArrayList<>(source.columns);
        this.filters = new HashMap<>(source.filters);
        this.orderBy = source.orderBy;
    }

    public SelectQuery withTable(String table) {
        this.table = table;
        return this;
    }

    public SelectQuery withFilter(String key, Object value) {
        this.filters.put(key, value);
        return this;
    }

    public SelectQuery withOrderBy(String orderBy) {
        this.orderBy = orderBy;
        return this;
    }

    @Override
    public QueryPrototype clone() {
        return new SelectQuery(this);
    }

    @Override
    public String toSql() {
        StringBuilder query = new StringBuilder();
        query.append("SELECT ").append(String.join(", ", columns))
                .append(" FROM ").append(table);

        if (!filters.isEmpty()) {
            query.append(" WHERE ");
            int index = 0;
            for (Map.Entry<String, Object> entry : filters.entrySet()) {
                if (index > 0) {
                    query.append(" AND ");
                }
                query.append(entry.getKey()).append(" = '").append(entry.getValue()).append("'");
                index++;
            }
        }

        if (orderBy != null && !orderBy.isBlank()) {
            query.append(" ORDER BY ").append(orderBy);
        }

        return query.toString();
    }
}

public class PrototypeDesignPatternDemo {
    public static void main(String[] args) {
        SelectQuery baseQuery = new SelectQuery(
                "users",
                List.of("id", "name", "email"),
                new HashMap<>(),
                "created_at DESC"
        );

        SelectQuery activeUsersQuery = (SelectQuery) baseQuery.clone();
        activeUsersQuery.withFilter("status", "ACTIVE");

        SelectQuery adminUsersQuery = (SelectQuery) baseQuery.clone();
        adminUsersQuery.withFilter("role", "ADMIN");

        System.out.println("Base query:");
        System.out.println(baseQuery.toSql());

        System.out.println("\nActive users query:");
        System.out.println(activeUsersQuery.toSql());

        System.out.println("\nAdmin users query:");
        System.out.println(adminUsersQuery.toSql());
    }
}
