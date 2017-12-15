package be.gvdenbro.movies;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class SchedulerTest {

    @Test
    public void none() {

        List<Integer> movies = new ArrayList<>();

        assertFalse(Scheduler.hasPairOfMatchingMovies(movies, 240));
    }

    @Test
    public void hasPairOfMoviesMatching() {

        List<Integer> movies = new ArrayList<>();

        movies.add(90);// 0
        movies.add(85);// 1
        movies.add(96);// 2
        movies.add(104);// 3
        movies.add(120);// 4

        assertTrue(Scheduler.hasPairOfMatchingMovies(movies, 175)); //(0, 1)
        assertTrue(Scheduler.hasPairOfMatchingMovies(movies, 186)); //(0, 2)
        assertTrue(Scheduler.hasPairOfMatchingMovies(movies, 194)); //(0, 3)
        assertTrue(Scheduler.hasPairOfMatchingMovies(movies, 210)); //(0, 4)

        assertTrue(Scheduler.hasPairOfMatchingMovies(movies, 181)); //(1, 2)
        assertTrue(Scheduler.hasPairOfMatchingMovies(movies, 189)); //(1, 3)
        assertTrue(Scheduler.hasPairOfMatchingMovies(movies, 205)); //(1, 4)

        assertTrue(Scheduler.hasPairOfMatchingMovies(movies, 200)); //(2, 3)
        assertTrue(Scheduler.hasPairOfMatchingMovies(movies, 216)); //(2, 4)

        assertTrue(Scheduler.hasPairOfMatchingMovies(movies, 224)); //(3, 4)

        // non matching
        assertFalse(Scheduler.hasPairOfMatchingMovies(movies, 0));
        assertFalse(Scheduler.hasPairOfMatchingMovies(movies, 111));
        assertFalse(Scheduler.hasPairOfMatchingMovies(movies, 666));
        assertFalse(Scheduler.hasPairOfMatchingMovies(movies, 234));
    }

    @Test
    public void matchingMovies() {

        List<Movie> movies = new ArrayList<>();

        Movie movie0 = new Movie(0, 90);
        Movie movie1 = new Movie(0, 85);
        Movie movie2 = new Movie(0, 96);
        Movie movie3 = new Movie(0, 104);
        Movie movie4 = new Movie(0, 120);

        movies.add(movie0);
        movies.add(movie1);
        movies.add(movie2);
        movies.add(movie3);
        movies.add(movie4);

        assertThat(Scheduler.matchingMovies(movies, 175, 2).size(), is(2));
        assertThat(Scheduler.matchingMovies(movies, 175, 2), hasItems(movie0, movie1));
        assertThat(Scheduler.matchingMovies(movies, 186, 2).size(), is(2));
        assertThat(Scheduler.matchingMovies(movies, 186, 2), hasItems(movie0, movie2));
        assertThat(Scheduler.matchingMovies(movies, 194, 2).size(), is(2));
        assertThat(Scheduler.matchingMovies(movies, 194, 2), hasItems(movie0, movie3));
        assertThat(Scheduler.matchingMovies(movies, 210, 2), hasItems(movie0, movie4));
        assertThat(Scheduler.matchingMovies(movies, 210, 2).size(), is(2));

        assertThat(Scheduler.matchingMovies(movies, 181, 2).size(), is(2));
        assertThat(Scheduler.matchingMovies(movies, 181, 2), hasItems(movie1, movie2));
        assertThat(Scheduler.matchingMovies(movies, 189, 2).size(), is(2));
        assertThat(Scheduler.matchingMovies(movies, 189, 2), hasItems(movie1, movie3));
        assertThat(Scheduler.matchingMovies(movies, 205, 2).size(), is(2));
        assertThat(Scheduler.matchingMovies(movies, 205, 2), hasItems(movie1, movie4));

        assertThat(Scheduler.matchingMovies(movies, 200, 2).size(), is(2));
        assertThat(Scheduler.matchingMovies(movies, 200, 2), hasItems(movie2, movie3));
        assertThat(Scheduler.matchingMovies(movies, 216, 2).size(), is(2));
        assertThat(Scheduler.matchingMovies(movies, 216, 2), hasItems(movie2, movie4));

        assertThat(Scheduler.matchingMovies(movies, 224, 2).size(), is(2));
        assertThat(Scheduler.matchingMovies(movies, 224, 2), hasItems(movie3, movie4));
    }

    @Test
    public void cornerCasesMatchingMovies() {

        Movie movie0 = new Movie(0, 90);
        Movie movie1 = new Movie(0, 85);

        assertThat(Scheduler.matchingMovies(emptyList(), 90, 0).size(), is(0));
        assertThat(Scheduler.matchingMovies(emptyList(), 90, 1).size(), is(0));
        assertThat(Scheduler.matchingMovies(singletonList(movie0), 90, 1).size(), is(1));
        assertThat(Scheduler.matchingMovies(singletonList(movie0), 89, 1).size(), is(0));
        assertThat(Scheduler.matchingMovies(singletonList(movie0), 91, 1).size(), is(0));
        assertThat(Scheduler.matchingMovies(Arrays.asList(movie0, movie1), 90, 1).size(), is(1));
        assertThat(Scheduler.matchingMovies(Arrays.asList(movie0, movie1), 90, 2).size(), is(0));
    }

    @Test
    public void hasMatchingMoviesFor2Movies() {
        // combinations with 90
        assertTrue(Scheduler.hasMatchingMovies(new int[]{90, 85, 96, 104, 120}, 175, 2));
        assertTrue(Scheduler.hasMatchingMovies(new int[]{90, 85, 96, 104, 120}, 186, 2));
        assertTrue(Scheduler.hasMatchingMovies(new int[]{90, 85, 96, 104, 120}, 194, 2));
        assertTrue(Scheduler.hasMatchingMovies(new int[]{90, 85, 96, 104, 120}, 210, 2));
        // combinations with 85
        assertTrue(Scheduler.hasMatchingMovies(new int[]{90, 85, 96, 104, 120}, 181, 2));
        assertTrue(Scheduler.hasMatchingMovies(new int[]{90, 85, 96, 104, 120}, 189, 2));
        assertTrue(Scheduler.hasMatchingMovies(new int[]{90, 85, 96, 104, 120}, 205, 2));
        // combinations with 96
        assertTrue(Scheduler.hasMatchingMovies(new int[]{90, 85, 96, 104, 120}, 200, 2));
        assertTrue(Scheduler.hasMatchingMovies(new int[]{90, 85, 96, 104, 120}, 216, 2));
        // combinations with 104
        assertTrue(Scheduler.hasMatchingMovies(new int[]{90, 85, 96, 104, 120}, 224, 2));
    }

    @Test
    public void hasMatchingMoviesFor3Movies() {
        // combinations with 90
        assertTrue(Scheduler.hasMatchingMovies(new int[]{90, 85, 96, 104, 120}, 271, 3));// 90 + 85 + 96
        assertTrue(Scheduler.hasMatchingMovies(new int[]{90, 85, 96, 104, 120}, 279, 3));// 90 + 85 + 104
        assertTrue(Scheduler.hasMatchingMovies(new int[]{90, 85, 96, 104, 120}, 295, 3));// 90 + 85 + 120
        assertTrue(Scheduler.hasMatchingMovies(new int[]{90, 85, 96, 104, 120}, 290, 3));// 90 + 96 + 104
        assertTrue(Scheduler.hasMatchingMovies(new int[]{90, 85, 96, 104, 120}, 306, 3));// 90 + 96 + 120
        // etc.
    }
}