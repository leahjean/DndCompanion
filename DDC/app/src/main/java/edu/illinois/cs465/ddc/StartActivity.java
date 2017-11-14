package edu.illinois.cs465.ddc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StartActivity extends Activity implements View.OnClickListener {
    private Button createCharacterBtn;
    private Button[] existingCharacters;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        createCharacterBtn = (Button) findViewById(R.id.create_character_btn);
        createCharacterBtn.setOnClickListener(this);
    }

    public void onClick(View v) {
        if (v.getId() == R.id.create_character_btn) {
            Intent intent = new Intent(StartActivity.this, RaceSelectActivity.class);
            startActivity(intent);
        }
    }
}
