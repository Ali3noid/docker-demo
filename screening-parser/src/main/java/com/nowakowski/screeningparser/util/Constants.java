package com.nowakowski.screeningparser.util;

public class Constants {

    public static final String PROTOCOL = "https";
    public static final String CINEMA_CITY_HOST = "www.cinema-city.pl";
    public static final String DIRECTORY = "/kina";
    public static final String WHICH_CINEMA = "in-cinema";
    public static final String WHEN = "at";
    public static final String SCREENING_API = "buy-tickets-by-cinema";

    public static final String WEBDRIVER_CHROME_DRIVER = "webdriver.chrome.driver";
    public static final String PATH_TO_CHROME_DRIVER = "src/main/resources/chromedriver.exe";
    public static final String HEADLESS_OPTION = "--headless";

    public static final String MOVIE_SELECTOR = "div.row.movie-row";
    public static final String SCREENING_SELECTOR = ".btn.btn-sm.btn-primary";
    static final String TITLE_SELECTOR = "h4.qb-movie-name";
    static final String DESCRIPTION_SELECTOR = ".qb-movie-info";

    public static final int YEAR = 0;
    public static final int MONTH = 1;
    public static final int DAY = 2;
    public static final int HOUR = 0;
    public static final int MINUTE = 1;
    public static final int MINUTES = 0;
    public static final int SINGLE_HOUR = 60;

    private Constants() {
    }
}
