package com.techreinforce.country_code_library;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.techreinforce.countypickerlibrary.Country;
import com.techreinforce.countypickerlibrary.CountryPicker;

public class MainActivity extends AppCompatActivity {
    String countrypicker = "COUNTRY_PICKER";
    CountryPicker mCountryPicker = new CountryPicker();
    EditText editText;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.et_code);
        textView = findViewById(R.id.tv_country_name);

       /* mCountryPicker.show(getSupportFragmentManager(), countrypicker);

        mCountryPicker.setListener(new CountryPickerListener() {
            @Override
            public void onSelectCountry(String name, String code, String dialCode, int flagDrawableResID, int min, int max) {

                Log.d("mCountryPicker: "+name,name);
                Log.d("mCountryPicker: "+code,code);
                Log.d("mCountryPicker: "+dialCode,dialCode);
                Log.d("mCountryPicker: "+flagDrawableResID,flagDrawableResID+"");
                Log.d("mCountryPicker: "+min,min+"");
                Log.d("mCountryPicker: "+min,min+"");


                if (mCountryPicker.isVisible())
                    mCountryPicker.dismiss();
            }
        });*/
        Log.d("sfgsdffdgdf", String.valueOf(mCountryPicker.getUserCountryInfo(this).toString()));
        Log.d("sfgsdffdgdf", String.valueOf(mCountryPicker.getCountryInfo(this, "+91").toString()));


    }

    public void findData(View view) {
        Country country = mCountryPicker.getCountryInfo(this, editText.getText().toString());
        Log.d("sfgsdffdgdf", String.valueOf(country.getCode()));
        Log.d("sfgsdffdgdf", String.valueOf(country.getDialCode()));
        Log.d("sfgsdffdgdf", String.valueOf(country.getName()));
        Log.d("sfgsdffdgdf", String.valueOf(country.getFlag()));
        textView.setText(country.getCode());
    }
}
