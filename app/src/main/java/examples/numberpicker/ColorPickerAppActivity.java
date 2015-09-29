package examples.numberpicker;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.NumberPicker;


public class ColorPickerAppActivity extends Activity {

    int rVal = 0;
    int gVal = 0;
    int bVal = 0;
    int color;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.color_picker_app);

        final NumberPicker numberPickerR = (NumberPicker) findViewById(R.id.numPicker_R);
        final NumberPicker numberPickerG = (NumberPicker) findViewById(R.id.numPicker_G);
        final NumberPicker numberPickerB = (NumberPicker) findViewById(R.id.numPicker_B);


        numberPickerR.setMaxValue(255);
        numberPickerR.setMinValue(0);
        numberPickerR.setWrapSelectorWheel(true);
        numberPickerR.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                rVal = newVal;
                setColor(rVal, gVal, bVal);
            }
        });


        numberPickerG.setMaxValue(255);
        numberPickerG.setMinValue(0);
        numberPickerG.setWrapSelectorWheel(true);
        numberPickerG.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                gVal = newVal;
                setColor(rVal, gVal, bVal);
            }
        });

        numberPickerB.setMaxValue(255);
        numberPickerB.setMinValue(0);
        numberPickerB.setWrapSelectorWheel(true);
        numberPickerB.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                bVal = newVal;
                setColor(rVal, gVal, bVal);
            }
        });
    }//end onCreate


    private void setColor(int rVal, int gVal, int bVal) {
        Log.i("SettingColor", "Red: " + rVal + " Green: " + gVal + " Blue: " + bVal);
        color = Color.rgb(rVal, gVal, bVal);
        View bgElement = findViewById(R.id.myRectangleView);
        bgElement.setBackgroundColor(color);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_number_picker_app, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
