package com.tae.mobile.android.weatherapp.base;

import com.tae.mobile.android.weatherapp.api.ApiConstant;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Pippo on 5/16/2017.
 */

public abstract class BaseService implements ApiConstant {

    protected <F> void subscribe(Observable<F> observable, Consumer<F> consumer) {
        observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(consumer);
    }

    protected <O1, O2, R> Observable<R> zip(
            Observable<O1> observable1,
            Observable<O2> observable2,
            BiFunction<O1, O2, R> observer
    ) {
        return Observable.zip(observable1, observable2, observer);
    }
}
