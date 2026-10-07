package com.example.myapplication;

import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.List;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    Button buttonNastepne;
    RadioButton radioButtonA, radioButtonB, radioButtonC;
    RadioGroup radioGroupPytania;
    TextView textViewTresc;
    List<Pytanie> listaPytan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        buttonNastepne = findViewById(R.id.button);
        radioButtonA = findViewById(R.id.radioButton1);
        radioButtonB = findViewById(R.id.radioButton2);
        radioButtonC = findViewById(R.id.radioButton3);
        textViewTresc = findViewById(R.id.textViewPytanie);
        radioGroupPytania = findViewById(R.id.radioGroupPytania);

        Reftrofit reftrofit = new Retrofit.Builder()
                .baseUrl()
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        JsonPlaceholderApi jsonPlaceholderApi = reftrofit.create(JsonPlaceholderApi.class);
        Call<List<Pytanie>> call = JsonPlaceholderApi.getPytania();
        call.enqueue(

        )
    }
}