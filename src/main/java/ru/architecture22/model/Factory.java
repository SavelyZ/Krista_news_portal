package ru.architecture22.model;

public abstract class Factory {
    private static final String postgreSQLClient = "client1";
    private static final String mongoDBClient = "client2";

    public static FactoryProvider getProvider(String clientType) {
        if (clientType == postgreSQLClient)
            return new PostgreSQLProvider();
        return new MongoDBProvider();
    }
}
