package org.trares.challenges.inflightentertainmentsystem;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@RunWith(JUnit4.class)
public class IFEMovieCalculatorTests {

	@Test
	public void exist2MoviesWithTheSameFlightTimeTest() {

		final int flightTime = 135; //LON-MAD (2:15h)
		final int[] movieCatalog = {
			90, // RM vs BCN
			45  // Champions League Weekly Summary
		};

		final IFEMovieCalculator ifem = new IFEMovieCalculatorImpl(movieCatalog);
		final boolean result = ifem.exist2MoviesForFlight(flightTime);

		assertThat(result, is(true));
	}

	@Test
	public void noExist2MoviesWithTheSameFlightTimeTest() {

		final int flightTime = 135; //LON-MAD (2:15h)
		final int[] movieCatalog = {
				90, // RM vs BCN
				90  // MAN vs CITY
		};

		final IFEMovieCalculator ifem = new IFEMovieCalculatorImpl(movieCatalog);
		final boolean result = ifem.exist2MoviesForFlight(flightTime);

		assertThat(result, is(false));
	}

	@Test
	public void movieCatalogNotReachFlightTimeTest() {

		final int flightTime = 135; //LON-MAD (2:15h)
		final int[] movieCatalog = {
				45, // RM vs BCN HighLights
				45  // MAN vs CITY HighLights
		};

		final IFEMovieCalculator ifem = new IFEMovieCalculatorImpl(movieCatalog);
		final boolean result = ifem.exist2MoviesForFlight(flightTime);

		assertThat(result, is(false));
	}

	@Test(expected = IllegalArgumentException.class)
	public void emptyMovieCatalogTest() {

		final int[] movieCatalog = { };

		final IFEMovieCalculator ifem = new IFEMovieCalculatorImpl(movieCatalog);
	}

	@Test(expected = IllegalArgumentException.class)
	public void nullMovieCatalogTest() {

		final int[] movieCatalog = null;

		final IFEMovieCalculator ifem = new IFEMovieCalculatorImpl(movieCatalog);
	}

	@Test
	public void shortMovieCatalogTest() {

		final int flightTime = 135; //LON-MAD (2:15h)
		final int[] movieCatalog = {
				90 // RM vs BCN
		};

		final IFEMovieCalculator ifem = new IFEMovieCalculatorImpl(movieCatalog);
		final boolean result = ifem.exist2MoviesForFlight(flightTime);

		assertThat(result, is(false));
	}

	@Test
	public void CornerCaseTest() {

		/*
		70 10 10
		10
		10
		 */

		final int flightTime = 140; //LON-MAD with Short Delay (2:20h)
		final int[] movieCatalog = {
				70, // Lions Documentary
				10, // Air Company Short Movie
				10  // Air Company Short Movie 2
		};

		final IFEMovieCalculator ifem = new IFEMovieCalculatorImpl(movieCatalog);
		final boolean result = ifem.exist2MoviesForFlight(flightTime);

		assertThat(result, is(false));
	}

}
