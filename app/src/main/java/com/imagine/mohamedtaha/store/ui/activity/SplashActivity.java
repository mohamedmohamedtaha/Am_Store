package com.imagine.mohamedtaha.store.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.imagine.mohamedtaha.store.R;
import com.imagine.mohamedtaha.store.databinding.ActivitySplashBinding;
import com.imagine.mohamedtaha.store.mvvm.interactor.InteractorSplash;
import com.imagine.mohamedtaha.store.mvvm.presenter.PresenterSplash;
import com.imagine.mohamedtaha.store.mvvm.view.ViewSplash;

public class SplashActivity extends AppCompatActivity implements ViewSplash {
    ActivitySplashBinding activitySplashBinding;
    private PresenterSplash presenterSplash;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activitySplashBinding = DataBindingUtil.setContentView(this, R.layout.activity_splash);
        presenterSplash = new InteractorSplash(this);
        presenterSplash.showSplashAnimation();
    }

    @Override
    public void goToMainActivity() {
        Intent goToMainActivity = new Intent(SplashActivity.this, MainActivity.class);
        startActivity(goToMainActivity);
        finish();
    }

    @Override
    public void startAnimation() {
        Animation animationImage = AnimationUtils.loadAnimation(this, R.anim.move_splash);
        activitySplashBinding.imageSplash.startAnimation(animationImage);
    }
}