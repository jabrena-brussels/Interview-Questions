package org.trares.challenges.inflightentertainmentsystem;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@RunWith(JUnit4.class)
public class InFlightEntertainmentMovieCalculatorTests {

	@Test
	public void exist2MoviesWithTheSameFlightTimeOKTest() {

		final int flightTime = 135;//LON-MAD (2:15h)
		final int[] movieCatalog = {
			90, // RM vs BCN
			45  // Champions League Weekly Summary
		};

		final IFEMovieCalculator ifem = new IFEMovieCalculatorImpl(movieCatalog);
		final boolean result = ifem.exist2MoviesForFlight(flightTime);

		assertThat(result, is(true));
	}

}
