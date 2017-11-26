package edu.illinois.cs465.ddc;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import static edu.illinois.cs465.ddc.GeneralUtil.hideKeyboard;

/**
 * Created by kejij on 11/24/2017.
 */

public class NoteActivity extends Activity implements View.OnClickListener {
    private ImageButton headerBackBtn;
    private LinedEditText linedEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);

        headerBackBtn = (ImageButton) findViewById(R.id.headerBackBtn);
        headerBackBtn.setOnClickListener(this);

        // Initalize editText event listeners to make keyboard disappear on change
        linedEditText = (LinedEditText) findViewById(R.id.note_input_field);
        linedEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if (!hasFocus) {
                    hideKeyboard(getApplicationContext(), view);
                }
            }
        });

        // Initialize editText text based on previous note data
        Bundle bundle = getIntent().getExtras();
        linedEditText.setText(bundle.getString("Note Msg"), TextView.BufferType.EDITABLE);

        // Initialize arc bubble
        ArcBubbleUtil.createArcBubble(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.note_input_field:
                String backgroundTxtStr = linedEditText.getText().toString();
                Toast backgroundTxt = Toast.makeText(getBaseContext(), backgroundTxtStr,Toast.LENGTH_LONG);
                backgroundTxt.show();
                break;
            case R.id.headerBackBtn:
                this.finish();
                break;
        }
    }
}
