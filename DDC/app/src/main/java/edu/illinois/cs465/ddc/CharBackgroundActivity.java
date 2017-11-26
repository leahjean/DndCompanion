package edu.illinois.cs465.ddc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static edu.illinois.cs465.ddc.GeneralUtil.hideKeyboard;

/**
 * Created by kejij on 11/21/2017.
 */

public class CharBackgroundActivity extends Activity implements View.OnClickListener {
    private Button backPageBtn, nextPageBtn;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_char_background);

        initButtons();
        initEditText();
    }

    // Initialize button variables and button event listeners for each button on the page
    private void initButtons() {
        backPageBtn = (Button) findViewById(R.id.bg_back_page_btn);
        backPageBtn.setOnClickListener(this);

        nextPageBtn = (Button) findViewById(R.id.bg_next_page_btn);
        nextPageBtn.setOnClickListener(this);
    }

    // Initialize editText event listeners
    private void initEditText() {
        editText = (EditText) findViewById(R.id.background_input_field);
        editText.setOnClickListener(this);

        editText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if (!hasFocus) {
                    hideKeyboard(getApplicationContext(), view);
                }
            }
        });
    }

    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.background_input_field:
                String backgroundTxtStr = editText.getText().toString();
                Toast backgroundTxt = Toast.makeText(getBaseContext(), backgroundTxtStr,Toast.LENGTH_LONG);
                backgroundTxt.show();
                break;
            case R.id.bg_back_page_btn:
                this.finish();
                break;
            case R.id.bg_next_page_btn:
                Bundle prevBundle = getIntent().getExtras();
                Intent intent = new Intent(this, CurrencyActivity.class);
                intent.putExtra("Selected Class", prevBundle.getString("Selected Class"));
                intent.putExtra("Selected Race", prevBundle.getString("Selected Race"));
                intent.putExtra("Background", editText.getText().toString());
                startActivity(intent);
        }
    }
}
