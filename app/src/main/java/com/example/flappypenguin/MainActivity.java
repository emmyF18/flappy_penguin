package com.example.flappypenguin;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.content.DialogInterface;
import android.os.Bundle;
import android.content.Intent;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Toast;
import android.widget.ImageButton;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;
import android.view.View.OnClickListener;

import com.daasuu.ei.Ease;
import com.daasuu.ei.EasingInterpolator;

public class MainActivity extends AppCompatActivity
{
    private Integer[] countdownImages = {R.drawable.countdown_3, R.drawable.countdown_2, R.drawable.countdown_1, R.drawable.countdown_start, R.drawable.blank};
    private ImageSwitcher imageSwitcher;
    private ImageButton imageButton;
    private int position = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // SOURCE: https://www.tutlane.com/tutorial/android/android-imageswitcher-with-examples
        listenForButton();
        imageSwitcher = findViewById(R.id.countdown);
        imageSwitcher.setFactory(new ViewSwitcher.ViewFactory()
        {
            @Override
            public View makeView()
            {
                ImageView imageView = new ImageView(MainActivity.this);
                imageView.setImageResource(countdownImages[position]);

                return imageView;
            }
        });

        imageSwitcher.setInAnimation(this, android.R.anim.fade_in);
        imageSwitcher.setOutAnimation(this, android.R.anim.fade_out);
        startCountdown();

        moveDown();
    }

    // SOURCE: https://www.tutlane.com/tutorial/android/android-imageswitcher-with-examples
    // SOURCE: https://abhiandroid.com/ui/countdown-timer
    private void startCountdown()
    {
        new CountDownTimer(4000, 1000)
        {
            @Override
            public void onTick(long millisUntilFinished)
            {
                imageSwitcher.setImageResource(countdownImages[position]);

                if (position < countdownImages.length)
                {
                    position++;
                }
            }

            @Override
            public void onFinish()
            {
                imageSwitcher.setImageResource(countdownImages[countdownImages.length - 1]);
            }
        }.start();
    }

    private void listenForButton()
    {
        imageButton = findViewById(R.id.penguin);
        imageButton.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                imageButton.setY(imageButton.getY()-50);
            }

        });
    }

    //click code from https://www.mkyong.com/android/android-imagebutton-example/
    private void moveDown()
    {
        imageButton = findViewById(R.id.penguin);

        while(imageButton.getY() > findViewById(R.id.gameBackground).getBottom())
        {
            bounceUp(imageButton);

           // imageButton.setY(imageButton.getY() + 50);
        }
    }
<<<<<<< HEAD
=======
    private void bounceUp(View targetView)
    {
        ObjectAnimator animator = ObjectAnimator.ofFloat(targetView,"translationY",0,50,25);
        animator.setInterpolator(new EasingInterpolator(Ease.BOUNCE_IN_OUT));
        animator.setStartDelay(500);
        animator.setDuration(1500);
        animator.start();
    }

>>>>>>> 4a1b67bc72626804fae7e6c827254ea187af69bd
}
