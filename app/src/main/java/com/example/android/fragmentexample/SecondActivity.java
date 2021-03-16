package com.example.android.fragmentexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SectionIndexer;

public class SecondActivity extends AppCompatActivity {
    private Button mButton,prev_button;
    private boolean isFragmentDisplayed = false;

    static final String STATE_FRAGMENT = "state_of_fragment";

    

    SecondActivity(){
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        mButton = findViewById(R.id.open_button);
        prev_button =findViewById(R.id.btn_previous1);

        prev_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.activity_main);
            }
        });

        final MainActivity main = new MainActivity();

        mButton.setOnClickListener(new View.OnClickListener() {
            private String Tag;

            @Override
            public void onClick(View view) {

                Log.d(Tag, "hello");
                if (!isFragmentDisplayed) {
                    main.displayFragment();
                } else {
                    main.closeFragment();
                }
            }
        });

        if (savedInstanceState != null) {
            isFragmentDisplayed =
                    savedInstanceState.getBoolean(STATE_FRAGMENT);
            if (isFragmentDisplayed) {
                // If the fragment is displayed, change button to "close".
                mButton.setText(R.string.close);
            }
        }
    }

}