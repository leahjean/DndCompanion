package edu.illinois.cs465.ddc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class CurrencyActivity extends Activity implements View.OnClickListener {
    private ImageButton back_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency);

        back_button = (ImageButton) findViewById(R.id.currencyBackBtn);
        back_button.setOnClickListener(this);

        // Initialize arc bubble
        ArcBubbleUtil.createArcBubble(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.currencyBackBtn:
                this.finish();
                break;
        }
    }
}
