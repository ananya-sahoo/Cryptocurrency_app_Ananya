package com.example.hp.ananya_final;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    static Get_Data get_data;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void handle_For_Click(View view)
    {
        try {
            get_data = new Get_Data(this);
            get_data.execute();

        }
        catch (Exception e)
        {

        }

    }
}
