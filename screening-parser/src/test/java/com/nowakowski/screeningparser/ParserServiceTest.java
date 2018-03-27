package com.nowakowski.screeningparser;

import com.nowakowski.model.Screening;
import org.junit.Test;

import java.util.List;

import static com.nowakowski.screeningparser.model.Cinema.KINEPOLIS;
import static com.nowakowski.screeningparser.model.Cinema.POZNAN_PLAZA;

public class ParserServiceTest {

    @Test
    public void useScreeningApi() {
        ParserService parser = new ParserService();
        List<Screening> kinepolisScreenings = parser.getScreeningsBy("2018-03-28", KINEPOLIS);
        List<Screening> poznanPlazaScreenings = parser.getScreeningsBy("2018-03-28", POZNAN_PLAZA);
    }
}