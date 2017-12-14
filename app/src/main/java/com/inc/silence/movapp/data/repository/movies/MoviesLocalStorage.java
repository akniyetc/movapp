package com.inc.silence.movapp.data.repository.movies;

import com.inc.silence.movapp.data.exception.NetworkConnectionException;
import com.inc.silence.movapp.domain.entity.main.MovieDetail;
import com.inc.silence.movapp.domain.entity.main.Movies;

import java.util.Map;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.realm.Realm;
import io.realm.RealmQuery;

/**
 * Created by silence on 11.12.2017.
 */

public class MoviesLocalStorage implements MoviesStore {

    @Inject
    MoviesLocalStorage() {

    }


    @Override
    public Observable<Movies> getTopRated(Map<String, String> queries, String id) {
        Realm realm = Realm.getDefaultInstance();
        if (ifMoviesIsExists(realm)) {
            Movies movies = realm.copyFromRealm(realm.where(Movies.class).equalTo("id", id).findFirst());
            realm.close();
            return Observable.just(movies);
        }
        realm.close();
        return Observable.error(new NetworkConnectionException());
    }

    @Override
    public Observable<Movies> getPopular(Map<String, String> queries, String id) {
        Realm realm = Realm.getDefaultInstance();
        if (ifMoviesIsExists(realm)) {
            Movies movies = realm.copyFromRealm(realm.where(Movies.class).equalTo("id", id).findFirst());
            realm.close();
            return Observable.just(movies);
        }
        realm.close();
        return Observable.error(new NetworkConnectionException());
    }

    @Override
    public void savePopularMovies(Movies movies, boolean clear) {
        Realm realm = Realm.getDefaultInstance();
        realm.executeTransaction(realm1 -> {
            if (clear) {
                realm1.delete(Movies.class);
                realm1.insertOrUpdate(movies);
            } else {
                Movies realmMovies = realm1.copyFromRealm(realm1.where(Movies.class).findFirst());
                realmMovies.getResults().addAll(movies.getResults());
                realm1.delete(Movies.class);
                realm1.insertOrUpdate(realmMovies);
            }
        });
        realm.close();
    }

    @Override
    public Observable<MovieDetail> getDetailMovie(String movieId, Map<String, String> queries) {
        Realm realm = Realm.getDefaultInstance();
        if (ifMovieIsExists(realm, movieId)) {
            MovieDetail detail = realm.copyFromRealm(realm.where(MovieDetail.class).equalTo("id", movieId).findFirst());
            realm.close();
            return Observable.just(detail);
        }
        realm.close();
        return Observable.error(new NetworkConnectionException());
    }



    @Override
    public void saveTopRated(Movies movies, boolean clear) {
        Realm realm = Realm.getDefaultInstance();
        realm.executeTransaction(realm1 -> {
            if (clear) {
                realm1.delete(Movies.class);
                realm1.insertOrUpdate(movies);
            } else {
                Movies realmMovies = realm1.copyFromRealm(realm1.where(Movies.class).findFirst());
                realmMovies.getResults().addAll(movies.getResults());
                realm1.delete(Movies.class);
                realm1.insertOrUpdate(realmMovies);
            }
        });
        realm.close();
    }

    @Override
    public void saveMovieDetail(MovieDetail movieDetail) {
        Realm realm = Realm.getDefaultInstance();
        realm.executeTransaction(realm1 -> realm1.insertOrUpdate(movieDetail));
        realm.close();
    }

    private boolean ifMoviesIsExists(Realm realm) {
        RealmQuery<Movies> query = realm.where(Movies.class);
        return query.count() != 0;
    }

//    private boolean ifTopRatedMoviesIsExists(Realm realm, String id) {
//        RealmQuery<Movies> query = realm.where(Movies.class).equalTo("id", id);
//        return query.count() != 0;
//    }

    private boolean ifMovieIsExists(Realm realm, String id) {
        RealmQuery<MovieDetail> query = realm.where(MovieDetail.class).equalTo("id", id);
        return query.count() != 0;
    }
}
