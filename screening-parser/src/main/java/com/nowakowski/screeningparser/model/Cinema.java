package com.nowakowski.screeningparser.model;

public enum Cinema {
    POZNAN_PLAZA("Poznań Plaza", "poznanplaza", "1078"), KINEPOLIS("Kinepolis", "kinepolis", "1081");

    private final String databaseValue;
    private final String uri;
    private final String id;

    Cinema(String databaseValue, String uri, String id) {
        this.databaseValue = databaseValue;
        this.uri = uri;
        this.id = id;
    }

    public String getDatabaseValue() {
        return databaseValue;
    }

    public String getUri() {
        return uri;
    }

    public String getId() {
        return id;
    }
}
