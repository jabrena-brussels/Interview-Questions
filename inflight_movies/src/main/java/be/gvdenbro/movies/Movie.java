package be.gvdenbro.movies;

import java.util.Objects;

public class Movie {

    private final int index;
    private final int duration;

    public Movie(int index, int duration) {
        this.index = index;
        this.duration = duration;
    }

    public int getIndex() {
        return index;
    }

    public int getDuration() {
        return duration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return index == movie.index &&
                duration == movie.duration;
    }

    @Override
    public int hashCode() {

        return Objects.hash(index, duration);
    }
}
