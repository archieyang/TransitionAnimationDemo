package me.codethink.transitionanimationdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.AccelerateInterpolator;

/**
 * Created by archie on 15/6/21.
 */
public class SecondActivity extends AppCompatActivity {
    private View rootView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_second);

        rootView = findViewById(R.id.root);

        if (savedInstanceState == null) {
            rootView.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
                @Override
                public boolean onPreDraw() {
                    rootView.getViewTreeObserver().removeOnPreDrawListener(this);
                    startRootAnimation();
                    return true;
                }
            });
        }
    }

    private void startRootAnimation() {
        rootView.setScaleY(0.1f);
        rootView.setPivotY(rootView.getY() + rootView.getHeight() / 2);

        rootView.animate()
                .scaleY(1)
                .setDuration(1000)
                .setInterpolator(new AccelerateInterpolator())
                .start();
    }
}
