package ru.architecture22.model;

public abstract class Factory {
    public static final String POSTGRE_SQL_CLIENT = "client1";
    public static final String MONGO_DB_CLIENT = "client2";

    public static FactoryProvider getProvider(String clientType) {
        if (clientType == POSTGRE_SQL_CLIENT)
            return new PostgreSQLProvider();
        return new MongoDBProvider();
    }
}
