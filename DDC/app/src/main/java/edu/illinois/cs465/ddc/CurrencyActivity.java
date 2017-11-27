package edu.illinois.cs465.ddc;

import android.app.Activity;
import android.os.Bundle;

public class CurrencyActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency);

        // Initialize arc bubble
        ArcBubbleUtil.createArcBubble(this);
    }
}
