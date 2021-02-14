package util;

public class Constants {

    public static class Format {
        public final static String XML = "xml";
        public final static String YAML = "yaml";
        public final static String CSV = "csv";
        public final static String JSON = "json";
        public final static String BINARY = "bin";
        public final static String MY_SQL = "MySQL";
        public final static String POSTGRE_SQL = "PostgreSQL";
        public final static String H2 = "H2";
        public final static String MONGO_DB = "MongoDB";
        public final static String REDIS = "Redis";
        public final static String CASSANDRA = "Cassandra";
        public final static String NEO_4J = "Neo4J";
    }

    public static class Cmd {
        public final static String CREATE = "create";
        public final static String UPDATE = "update";
        public final static String READ = "read";
        public final static String DELETE = "delete";
        public final static String EXIT = "exit";
        public final static String HELP = "help";
        public final static String SWITCH = "switch";
        public final static String START = "start";
    }


    // if these DBs don't have specific formats than it's better to use ENUMs
    public static class DB {
        public final static String MY_SQL = "mysql";
        public final static String MARIA_DB = "mariadb";
        public final static String POSTGRE_SQL = "postgresql";
        public final static String MONGO_DB = "mongodb";
    }
}
