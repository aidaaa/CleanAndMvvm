package com.example.cleanmvvm.clean.domain.interactor.base;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public abstract class UseCase<T>  {
    private CompositeDisposable mdisposable;

    public UseCase() {
        mdisposable=new CompositeDisposable();
    }

    public abstract Observable<T> buildObservable();

    public void execute(DisposableObserver<T> observer)
    {
        Observable<T> tObservable=this.buildObservable()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
        addDisposable(tObservable.subscribeWith(observer));
    }

    private void addDisposable(Disposable disposable){
        mdisposable.add(disposable);
    }
}
