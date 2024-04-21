package com.bca.util;

public class EnableDevDataSource implements DataSourceConfig{
    @Override
    public void makeConnection() {
        System.out.println("Connection established to dev data");
    }
}
