package designPatterns.structuralPatterns;

interface Database {
    void query(String sqlQuery);
}

class RealDatabase implements Database {
    @Override
    public void query(String sqlQuery) {
        System.out.println("Executing query: " + sqlQuery);
    }
}

class DatabaseProxy implements Database {
    private RealDatabase realDatabase;
    private boolean isAdmin;

    DatabaseProxy(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    @Override
    public void query(String sqlQuery) {
        // Lazy initialization: Create the real database only when needed
        if (isAdmin) {
            realDatabase = new RealDatabase();
        }

        if (isAdmin) {
            System.out.println("Log: Query executed by admin: " + sqlQuery);
            realDatabase.query(sqlQuery);
        } else {
            System.out.println("Log: Access denied. Only admins can execute queries: " + sqlQuery);
        }
    }
}

class Proxy {
    public static void main(String[] args) {
        // Create a proxy for a non-admin user
        Database nonAdminProxy = new DatabaseProxy(false);
        nonAdminProxy.query("SELECT * FROM users");

        // Create a proxy for an admin user
        Database adminProxy = new DatabaseProxy(true);
        adminProxy.query("SELECT FROM users WHERE id = 1");
    }
}
