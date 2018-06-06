package io.shellee.movies;

import android.app.Activity;
import android.app.Application;

import io.shellee.movies.di.DaggerMoviesApplicationComponent;
import io.shellee.movies.di.MoviesApplicationComponent;
import io.shellee.movies.di.modules.ContextModule;
import io.shellee.movies.di.modules.MovieServiceModule;

public class MoviesApplication extends Application {

    private MoviesApplicationComponent component;

    public static MoviesApplication get(Activity activity) {
        return (MoviesApplication) activity.getApplication();
    }

    @Override
    public void onCreate() {
        super.onCreate();

        component = DaggerMoviesApplicationComponent.builder()
                .contextModule(new ContextModule(this))
                .movieServiceModule(new MovieServiceModule(this))
                .build();

        component.inject(this);
    }

    public MoviesApplicationComponent getApplicationComponent() {
        return component;
    }

//    PROJECT SPECIFICATION
//    Popular Movies, Stage 2
//
//    Common Project Requirements
//
//    MEETS SPECIFICATIONS
//Completed 6/1/2018    App is written solely in the Java Programming Language.
//
//Completed 6/1/2018    App conforms to common standards found in the Android Nanodegree General Project Guidelines.
//
//Completed 6/1/2018    App utilizes stable release versions of all libraries, Gradle, and Android Studio.
//
//    User Interface - Layout
//
//    MEETS SPECIFICATIONS
//TODO:  Refactor this as it's clunky - UI contains an element (e.g., a spinner or settings menu) to toggle the sort order of the movies by: most popular, highest rated.
//
//Completed 6/5/2018: Refactor this according to Mock UX -  Movies are displayed in the main layout via a grid of their corresponding movie poster thumbnails.
//
//Completed 6/1/2018    UI contains a screen for displaying the details for a selected movie.
//
//Completed 6/5/2018 REFACTOR need to include the Vote Average -  Movie Details layout contains title, release date, movie poster, vote average, and plot synopsis.
//
//TODO: Movie Details layout contains a section for displaying trailer videos and user reviews.
//
//    User Interface - Function
//
//    MEETS SPECIFICATIONS
//TODO: ADD FAVORITE -  When a user changes the sort criteria (most popular, highest rated, and favorites) the main view gets updated correctly.
//
//Completed 6/1/2018    When a movie poster thumbnail is selected, the movie details screen is launched.
//
//TODO:: When a trailer is selected, app uses an Intent to launch the trailer.
//
//TODO: In the movies detail screen, a user can tap a button (for example, a star) to mark it as a Favorite. Tap the button on a favorite movie will unfavorite it.
//
//    Network API Implementation
//
//    MEETS SPECIFICATIONS
//Completed 6/1/2018    In a background thread, app queries the /movie/popular or /movie/top_rated API for the sort criteria specified in the settings menu.
//
//TODO: App requests for related videos for a selected movie via the /movie/{id}/videos endpoint in a background thread and displays those details when the user selects a movie.
//
//TODO: App requests for user reviews for a selected movie via the /movie/{id}/reviews endpoint in a background thread and displays those details when the user selects a movie.
//
//    Data Persistence
//
//    MEETS SPECIFICATIONS
//Completed 6/1/2018   The titles and IDs of the user’s favorite movies are stored in a native SQLite database and exposed via a ContentProvider
//            OR
//    stored using Room.
//
//TODO: Data is updated whenever the user favorites or unfavorites a movie. No other persistence libraries are used.
//
//TODO: add a new operation to the Repository -    When the "favorites" setting option is selected, the main view displays the entire favorites collection based on movie ids stored in the database.
//
//    Android Architecture Components
//
//    MEETS SPECIFICATIONS
//Completed 6/1/2018  If Room is used, database is not re-queried unnecessarily. LiveData is used to observe changes in the database and update the UI accordingly.
//
//Completed 6/1/2018  If Room is used, database is not re-queried unnecessarily after rotation. Cached LiveData from ViewModel is used instead.
}
