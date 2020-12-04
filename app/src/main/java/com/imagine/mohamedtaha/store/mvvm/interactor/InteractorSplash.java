package com.imagine.mohamedtaha.store.mvvm.interactor;

import android.os.Handler;

import com.imagine.mohamedtaha.store.R;
import com.imagine.mohamedtaha.store.mvvm.presenter.PresenterSplash;
import com.imagine.mohamedtaha.store.mvvm.view.ViewSplash;

public class InteractorSplash implements PresenterSplash {
    private static boolean splashLoad = false;
    private static final int SPLASH_TIME  = 1750;
    private ViewSplash viewSplash;

    public InteractorSplash(ViewSplash viewSplash) {
        this.viewSplash = viewSplash;
    }

    @Override
    public void showSplashAnimation() {
        if (!splashLoad) {
            viewSplash.startAnimation();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    viewSplash.goToMainActivity();
                }
            }, SPLASH_TIME);
            splashLoad = true;
        } else {
            viewSplash.goToMainActivity();
        }
    }
}
