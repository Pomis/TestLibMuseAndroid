package com.choosemuse.example.libmuse;

import android.app.Activity;
import android.graphics.Paint;
import android.os.Bundle;

public class GraphActivity extends Activity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new GraphDrawer(this));


    }
}
