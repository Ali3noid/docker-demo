package com.nowakowski.screeningparser;

import com.nowakowski.model.Screening;
import com.nowakowski.screeningparser.model.Cinema;
import org.apache.http.client.utils.URIBuilder;
import org.jsoup.nodes.Document;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import static com.nowakowski.screeningparser.converter.LocalDateTimeConverter.from;
import static com.nowakowski.screeningparser.util.Constants.CINEMA_CITY_HOST;
import static com.nowakowski.screeningparser.util.Constants.DIRECTORY;
import static com.nowakowski.screeningparser.util.Constants.HEADLESS_OPTION;
import static com.nowakowski.screeningparser.util.Constants.MOVIE_SELECTOR;
import static com.nowakowski.screeningparser.util.Constants.PATH_TO_CHROME_DRIVER;
import static com.nowakowski.screeningparser.util.Constants.PROTOCOL;
import static com.nowakowski.screeningparser.util.Constants.SCREENING_API;
import static com.nowakowski.screeningparser.util.Constants.SCREENING_SELECTOR;
import static com.nowakowski.screeningparser.util.Constants.WEBDRIVER_CHROME_DRIVER;
import static com.nowakowski.screeningparser.util.Constants.WHEN;
import static com.nowakowski.screeningparser.util.Constants.WHICH_CINEMA;
import static com.nowakowski.screeningparser.util.ParserHelper.getDescription;
import static com.nowakowski.screeningparser.util.ParserHelper.getMovieTitle;
import static java.lang.String.join;
import static org.jsoup.Jsoup.parse;

public class ParserService {


    public List<Screening> getScreeningsBy(String dateToParse, Cinema chosenCinema) {
        ChromeDriver driver = getChromeDriver();
        String uri = getUriForCinemaCityScreening(dateToParse, chosenCinema);
        driver.get(uri);
        Document doc = parse(driver.getPageSource());
        List<Screening> screeningList = new ArrayList<>();
        doc.select(MOVIE_SELECTOR).forEach(movieRow ->
                movieRow.select(SCREENING_SELECTOR).forEach(singleScreening ->
                        screeningList.add(Screening
                                .builder()
                                .cinema(chosenCinema.getDatabaseValue())
                                .duration(from(getDescription(movieRow)))
                                .movie(getMovieTitle(movieRow))
                                .startTime(from(dateToParse, singleScreening.text()))
                                .build()))
        );
        return screeningList;
    }

    private String getUriForCinemaCityScreening(String dateToParse, Cinema chosenCinema) {
        URIBuilder uri = new URIBuilder();
        URIBuilder parameters = new URIBuilder();
        try {
            parameters.setPath(SCREENING_API)
                    .addParameter(WHICH_CINEMA, chosenCinema.getId())
                    .addParameter(WHEN, dateToParse)
                    .build();
            uri.setScheme(PROTOCOL)
                    .setHost(CINEMA_CITY_HOST)
                    .setPath(join("/", DIRECTORY, chosenCinema.getUri()))
                    .setFragment(parameters.toString())
                    .build();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return uri.toString();
    }

    private ChromeDriver getChromeDriver() {
        System.setProperty(WEBDRIVER_CHROME_DRIVER, PATH_TO_CHROME_DRIVER);
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments(HEADLESS_OPTION);
        return new ChromeDriver(chromeOptions);
    }
}
