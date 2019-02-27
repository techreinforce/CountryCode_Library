package com.techreinforce.country_code_library;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.techreinforce.countypickerlibrary.CountryPicker;
import com.techreinforce.countypickerlibrary.CountryPickerListener;

public class MainActivity extends AppCompatActivity {
    String countrypicker = "COUNTRY_PICKER";
    CountryPicker mCountryPicker = new CountryPicker();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mCountryPicker.show(getSupportFragmentManager(), countrypicker);

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
        });
    }
}
