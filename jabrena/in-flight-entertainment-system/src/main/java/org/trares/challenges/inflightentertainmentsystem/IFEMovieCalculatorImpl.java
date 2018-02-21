package org.trares.challenges.inflightentertainmentsystem;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class IFEMovieCalculatorImpl implements IFEMovieCalculator {

    final int[] movieCatalog;

    public IFEMovieCalculatorImpl(final int[] movieCatalog) {

        if ((movieCatalog == null) || (movieCatalog.length == 0)) {
            LOGGER.error("Bad movie catalog provided");
            throw new IllegalArgumentException("Bad movie catalog provided");
        }

        this.movieCatalog = movieCatalog;
    }

    @Override
    public boolean exist2MoviesForFlight(final int flightTime) {

        if (movieCatalog.length < 2) {
            return false;
        }

        boolean result = false;

        for (int i = 0; i < movieCatalog.length; i++) {

            for (int j = 0; j < movieCatalog.length; j++) {

                //Optimization to not check the same movie
                if (j==i) {
                    continue;
                }

                int moviesSum = movieCatalog[i] + movieCatalog[j];
                if (moviesSum == flightTime) {
                    LOGGER.info("Detected one Match with Movie with Index {} & Index {}", i, j);
                    result = true;
                    break;
                }
            }

            //Optimization to break both loop
            if (result) {
                break;
            }
        }

        return result;
    }
}
