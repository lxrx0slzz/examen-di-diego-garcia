package com.example.examendidiegogarcia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;

public class Arranque extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.arranque);
        openLogin();

        ImageView logoSplash = findViewById(R.id.logoSplash);
        TextView appNameSplash = findViewById(R.id.appNameSplash);

        Animation fadeAnimation = AnimationUtils.loadAnimation(this, R.anim.shake);
        appNameSplash.startAnimation(fadeAnimation);

        Animation shakeAnimation = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        logoSplash.startAnimation(shakeAnimation);

        ImageView background = findViewById(R.id.backgroundSplash);
        Glide.with(this)
                .load("https://th.bing.com/th/id/OIP.RMvQsi2QKuTs86MaQavGcgHaE7?w=273&h=182&c=7&r=0&o=5&pid=1.7")
                .transition(DrawableTransitionOptions.withCrossFade(2000))
                .centerCrop()
                .into(background);
    }
    public void openLogin(){
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Arranque.this, Acceso.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        }, 3000);
    }
}


