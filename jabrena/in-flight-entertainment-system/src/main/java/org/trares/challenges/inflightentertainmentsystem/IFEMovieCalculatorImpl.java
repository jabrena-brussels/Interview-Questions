package org.trares.challenges.inflightentertainmentsystem;

public class IFEMovieCalculatorImpl implements IFEMovieCalculator {

    final int[] movieCatalog;

    public IFEMovieCalculatorImpl(final int[] movieCatalog) {
        this.movieCatalog = movieCatalog;
    }

    @Override
    public boolean exist2MoviesForFlight(final int flightTime) {

        boolean result = false;

        for(int i = 0; i < movieCatalog.length; i++) {

            for(int j = 0; j < movieCatalog.length; j++) {

                int moviesSum = movieCatalog[i] + movieCatalog[j];
                if(moviesSum == flightTime) {
                    result = true;
                    break;
                }
            }
        }

        return result;
    }
}
