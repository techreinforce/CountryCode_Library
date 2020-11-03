package com.techreinforce.country_code_library;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.techreinforce.countypickerlibrary.Country;
import com.techreinforce.countypickerlibrary.CountryPicker;

import java.util.ArrayList;

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
        Log.d("sfgsdffdgdf1 : ", mCountryPicker.getUserCountryInfo(this).toString());
        Log.d("sfgsdffdgdf2 : ", mCountryPicker.getCountryInfo(this, "+91").toString());
        Log.d("sfgsdffdgdf3 : ", mCountryPicker.getCountryInfoFromCountryCode(this, "US").toString());
        Log.d("sfgsdffdgdf4 : ", mCountryPicker.getUserCountryInfoLocal(this).toString()+"");


    }

    public void findData(View view) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("IL");
        arrayList.add("ISR");
        mCountryPicker.hideCountries(arrayList);

        Country country = mCountryPicker.getCountryInfo(this, editText.getText().toString());
        Log.d("sfgsdffdgdf1", String.valueOf(country.getCode()));
        Log.d("sfgsdffdgdf2", String.valueOf(country.getDialCode()));
        Log.d("sfgsdffdgdf3", String.valueOf(country.getName()));
        Log.d("sfgsdffdgdf4", String.valueOf(country.getFlag()));
        textView.setText(country.getCode());
    }
}
