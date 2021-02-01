package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements RatingDialog.SaveRatingListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initChangeRateButton();
    }

    private void initChangeRateButton() {
        Button changeDate = findViewById(R.id.rateBtn);
        changeDate.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                FragmentManager fm = getSupportFragmentManager();
                RatingDialog ratingDialog = new RatingDialog(); // We create the dialog here
                ratingDialog.show(fm, "RateMe"); // DialogFragment.show() method shows the actual dialog. For this to happen, we need the fragment manager that is above
            }
        });
    }

    @Override
    public void didFinishRating(float myRating) {
        TextView rate = findViewById(R.id.starText);
        rate.setText(String.format("%s Stars!", Float.toString(myRating)));

        TextView emoji = findViewById(R.id.emojiText);
        int intRating = (int) myRating;

        switch (intRating) {
            case 0:
                emoji.setText("\uD83E\uDD2E");
            case 1:
                emoji.setText("\uD83E\uDD2E");
                break;
            case 2:
                emoji.setText("\uD83D\uDE1E");
                break;
            case 3:
                emoji.setText("\uD83C\uDD97");
                break;
            case 4:
                emoji.setText("\uD83D\uDC4C");
                break;
            case 5:
                emoji.setText("\uD83C\uDF20");
                break;
        }
    }
}