// Beginner-friendly example of the Adapter Design Pattern in Java
// This version models adapting a legacy SQL database API to a modern repository-style interface.

import java.util.ArrayList;
import java.util.List;

interface UserRepository {
    List<String> findAllUsers();
}

class LegacyDatabase {
    public List<String> executeRawQuery(String sql) {
        List<String> rows = new ArrayList<>();

        if (sql.contains("FROM users")) {
            rows.add("id=1, name=Alice, role=ADMIN");
            rows.add("id=2, name=Bob, role=USER");
        }

        return rows;
    }
}

class DatabaseAdapter implements UserRepository {
    private final LegacyDatabase legacyDatabase;

    public DatabaseAdapter(LegacyDatabase legacyDatabase) {
        this.legacyDatabase = legacyDatabase;
    }

    @Override
    public List<String> findAllUsers() {
        String sql = "SELECT id, name, role FROM users";
        return legacyDatabase.executeRawQuery(sql);
    }
}

public class AdapterDesignPatternDemo {
    public static void main(String[] args) {
        UserRepository repository = new DatabaseAdapter(new LegacyDatabase());

        System.out.println("Users from legacy database via adapter:");
        for (String user : repository.findAllUsers()) {
            System.out.println(user);
        }
    }
}
