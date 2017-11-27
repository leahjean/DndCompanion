package edu.illinois.cs465.ddc;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Button;
import android.widget.Toast;

public class InventoryActivity extends Activity implements View.OnClickListener {
    private Button equipment_button, supplies_button, currency_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventory);

        equipment_button = (Button) findViewById(R.id.equipmentButton);
        equipment_button.setOnClickListener(this);

        supplies_button = (Button) findViewById(R.id.suppliesButton);
        supplies_button.setOnClickListener(this);

        currency_button = (Button) findViewById(R.id.currencyButton);
        currency_button.setOnClickListener(this);

        // Initialize arc bubble
        ArcBubbleUtil.createArcBubble(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.equipmentButton:
                Intent intent_equip = new Intent(this, EquipmentActivity.class);
                startActivity(intent_equip);
                break;
            case R.id.suppliesButton:
                Intent intent_supplies = new Intent(this, SuppliesActivity.class);
                startActivity(intent_supplies);
                break;
            case R.id.currencyButton:
                Intent intent_currency = new Intent(this, CurrencyActivity.class);
                startActivity(intent_currency);
                break;
            case R.id.headerBackBtn:
                this.finish();
                break;
        }
    }
}
