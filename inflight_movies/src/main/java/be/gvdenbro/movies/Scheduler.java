package be.gvdenbro.movies;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class Scheduler {

    /**
     * This static method will check for pairs of matching movies in an iterative way
     */
    public static boolean hasPairOfMatchingMovies(List<Integer> movies, int minutes) {

        for (int i = 0; i < movies.size() - 1; i++) {
            Integer movie1Length = movies.get(i);
            if (movie1Length >= minutes) {
                break;
            }

            for (int j = i + 1; j < movies.size(); j++) {
                Integer movie2Length = movies.get(j);
                if (movie1Length + movie2Length == minutes) {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * This static method will check for any collection of matching movies in a recursive way.
     * @param movies       a list of movies represented as a of Movies
     * @param totalMinutes the total sum of movie durations
     * @param nbrOfMovies  the number of movies that need to be taken into account
     * @return the first encountered list of movies matching the criteria
     */
    public static List<Movie> matchingMovies(List<Movie> movies, int totalMinutes, int nbrOfMovies) {

        if (movies.size() < nbrOfMovies || nbrOfMovies == 0) {
            return Collections.emptyList();
        }

        Movie movie = movies.get(0);
        Integer firstMovieDuration = movie.getDuration();

        if (nbrOfMovies == 1 && firstMovieDuration == totalMinutes) {
            return Collections.singletonList(movie);
        }

        List<Movie> remainingMovies = movies.subList(1, movies.size());

        if (firstMovieDuration < totalMinutes) {

            int remainingDuration = totalMinutes - firstMovieDuration;
            int remainingNumberOfMovies = nbrOfMovies - 1;

            List<Movie> subMatchingMovies = matchingMovies(remainingMovies, remainingDuration, remainingNumberOfMovies);

            if (!subMatchingMovies.isEmpty()) {

                int subSumMovieDuration = subMatchingMovies.stream().mapToInt(Movie::getDuration).sum();

                if (subSumMovieDuration + firstMovieDuration == totalMinutes) {

                    List<Movie> matchingMovies = new ArrayList<>();
                    matchingMovies.add(movie);
                    matchingMovies.addAll(subMatchingMovies);
                    return matchingMovies;
                }
            }
        }

        return matchingMovies(remainingMovies, totalMinutes, nbrOfMovies);
    }

    /**
     * This static method will check for any collection of matching movies in a recursive way.
     *
     * @param movies       a list of movie duration represented as an array of integers
     * @param totalMinutes the total sum of movie durations
     * @param nbrOfMovies  the number of movies that need to be taken into account
     * @return true if any combination (taking into account nbrOfMovies) matches totalMinutes
     */
    public static boolean hasMatchingMovies(int[] movies, int totalMinutes, int nbrOfMovies) {

        List<Movie> movieList = IntStream.range(0, movies.length)
                .mapToObj(i -> new Movie(i, movies[i]))
                .collect(toList());

        List<Movie> matchingMovies = matchingMovies(movieList, totalMinutes, nbrOfMovies);

        return !matchingMovies.isEmpty();
    }
}
