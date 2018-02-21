package com.udacity.sandwichclub;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.udacity.sandwichclub.model.Sandwich;
import com.udacity.sandwichclub.utils.JsonUtils;

import java.util.List;

public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_POSITION = "extra_position";
    private static final int DEFAULT_POSITION = -1;

    private ImageView pictureImageView;
    private TextView mainNameTextView;
    private TextView akaTextView;
    private TextView placeOfOriginTextView;
    private TextView descriptionTextView;
    private TextView ingredientsTextView;
    private Sandwich sandwich;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        //Get the views
        pictureImageView = findViewById(R.id.image_iv);
        mainNameTextView = findViewById(R.id.main_name_tv);
        akaTextView = findViewById(R.id.also_known_tv);
        placeOfOriginTextView = findViewById(R.id.origin_tv);
        descriptionTextView = findViewById(R.id.description_tv);
        ingredientsTextView = findViewById(R.id.ingredients_tv);

        Intent intent = getIntent();
        if (intent == null) {
            closeOnError();
        }

        int position = intent.getIntExtra(EXTRA_POSITION, DEFAULT_POSITION);
        if (position == DEFAULT_POSITION) {
            // EXTRA_POSITION not found in intent
            closeOnError();
            return;
        }

        String[] sandwiches = getResources().getStringArray(R.array.sandwich_details);
        String json = sandwiches[position];

        sandwich = JsonUtils.parseSandwichJson(json);
        if (sandwich == null) {
            // Sandwich data unavailable
            closeOnError();
            return;
        }

        populateUI();
    }

    private void closeOnError() {
        finish();
        Toast.makeText(this, R.string.detail_error_message, Toast.LENGTH_SHORT).show();
    }

    private void populateUI() {

        Picasso.with(this)
                .load(sandwich.getImage())
                .into(pictureImageView);


        mainNameTextView.setText(sandwich.getMainName());
        akaTextView.setText(convertListToString(sandwich.getAlsoKnownAs()));
        placeOfOriginTextView.setText(sandwich.getPlaceOfOrigin());
        descriptionTextView.setText(sandwich.getDescription());
        ingredientsTextView.setText(convertListToString(sandwich.getIngredients()));

        //Activity title
        setTitle(sandwich.getMainName());
    }

    private String convertListToString(List<String> list) {

        StringBuilder builder = new StringBuilder();

        for (String s : list) {
            builder.append(builder.length() > 0 ? "\n" : "")
                    .append(s);
        }

        return builder.toString();
    }
}
