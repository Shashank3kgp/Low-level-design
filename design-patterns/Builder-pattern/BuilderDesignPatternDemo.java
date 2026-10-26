// Beginner-friendly example of the Builder Design Pattern in Java
// This version models an ORM-style SQL query builder.

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

class UserQueryBuilder {
    private final List<String> columns = new ArrayList<>();
    private String table;
    private final Map<String, Object> filters = new LinkedHashMap<>();
    private String orderBy;

    public UserQueryBuilder select(String... columnNames) {
        for (String column : columnNames) {
            columns.add(column);
        }
        return this;
    }

    public UserQueryBuilder from(String tableName) {
        this.table = tableName;
        return this;
    }

    public UserQueryBuilder where(String field, Object value) {
        filters.put(field, value);
        return this;
    }

    public UserQueryBuilder orderBy(String column) {
        this.orderBy = column;
        return this;
    }

    public String build() {
        StringBuilder query = new StringBuilder();

        query.append("SELECT ");
        if (columns.isEmpty()) {
            query.append("*");
        } else {
            query.append(String.join(", ", columns));
        }

        if (table == null || table.isBlank()) {
            throw new IllegalStateException("Table name is required before building the query.");
        }

        query.append(" FROM ").append(table);

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

public class BuilderDesignPatternDemo {
    public static void main(String[] args) {
        String query = new UserQueryBuilder()
                .select("id", "name", "email")
                .from("users")
                .where("status", "ACTIVE")
                .where("role", "ADMIN")
                .orderBy("created_at DESC")
                .build();

        System.out.println("Generated SQL query:");
        System.out.println(query);
    }
}
