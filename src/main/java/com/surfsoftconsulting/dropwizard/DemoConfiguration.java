package com.surfsoftconsulting.dropwizard;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import io.dropwizard.db.DataSourceFactory;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Map;

public class DemoConfiguration extends Configuration {

    @Valid
    @NotNull
    private DataSourceFactory database = new DataSourceFactory();

    @NotNull
    private Map<String, String> hibernateConfiguration;

    @JsonProperty("database")
    public DataSourceFactory getDataSourceFactory() {
        return database;
    }

    @JsonProperty("database")
    public void setDataSourceFactory(DataSourceFactory dataSourceFactory) {
        this.database = dataSourceFactory;
    }

    public Map<String, String> getHibernateConfiguration() {
        return hibernateConfiguration;
    }

    public void setHibernateConfiguration(Map<String, String> hibernateConfiguration) {
        this.hibernateConfiguration = hibernateConfiguration;
    }
}
