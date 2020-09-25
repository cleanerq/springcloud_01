package com.qby.rxjava;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RxjavaMain {

    private void sss() {
//        log.info("111");
    }
    public static void main(String[] args) {
        
        //被观察者
        Observable novel = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> emitter) throws Exception {
                emitter.onNext("连载1");
                emitter.onNext("连载2");
                emitter.onNext("连载3");
                emitter.onComplete();
            }
        });

//        final Disposable mDisposable = null;
        //观察者
        Observer<String> reader=new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
//                mDisposable=d;
//                Log.e(TAG,"onSubscribe");

            }

            @Override
            public void onNext(String value) {
                if ("2".equals(value)){
//                    mDisposable.dispose();
                    return;
                }
//                Log.e(TAG,"onNext:"+value);
            }

            @Override
            public void onError(Throwable e) {
//                Log.e(TAG,"onError="+e.getMessage());
            }

            @Override
            public void onComplete() {
//                Log.e(TAG,"onComplete()");
            }
        };
    }
}
