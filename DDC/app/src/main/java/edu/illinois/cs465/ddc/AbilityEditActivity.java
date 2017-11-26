package edu.illinois.cs465.ddc;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class AbilityEditActivity extends Activity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ability_edit);

        Button next_button, back_button;
        next_button = (Button) findViewById(R.id.stats_edit_next_page_btn);
        next_button.setOnClickListener(this);
        back_button = (Button) findViewById(R.id.stats_edit_back_page_btn);
        back_button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.stats_edit_back_page_btn:
                this.finish();
                break;
            case R.id.stats_edit_next_page_btn:
                Intent intent = new Intent(this, CharacterMainScreenActivity.class);
                startActivity(intent);
        }

    }
}
