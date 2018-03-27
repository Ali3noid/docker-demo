package com.nowakowski.screeningparser.util;

import org.jsoup.nodes.Element;

import static com.nowakowski.screeningparser.util.Constants.DESCRIPTION_SELECTOR;
import static com.nowakowski.screeningparser.util.Constants.TITLE_SELECTOR;

public class ParserHelper {

    private ParserHelper() {
    }

    public static String getDescription(Element movieRow) {
        return movieRow.select(DESCRIPTION_SELECTOR).text();
    }

    public static String getMovieTitle(Element movieRow) {
        return movieRow.select(TITLE_SELECTOR).text();
    }
}
