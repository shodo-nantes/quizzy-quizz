package io.shodo.quizzyquizz.infra;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Objects;

public final class MovieCredits {
    private final List<Movie> cast;

    public MovieCredits(@JsonProperty("cast") List<Movie> cast) {
        this.cast = cast;
    }

    public List<Movie> cast() {
        return cast;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (MovieCredits) obj;
        return Objects.equals(this.cast, that.cast);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cast);
    }

    @Override
    public String toString() {
        return "MovieCredits[" +
                "cast=" + cast + ']';
    }


}
