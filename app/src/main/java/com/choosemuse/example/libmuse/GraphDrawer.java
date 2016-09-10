package com.choosemuse.example.libmuse;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.os.AsyncTask;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;

/**
 * Created by romanismagilov on 10.09.16.
 */
public class GraphDrawer extends View {
    private Paint mPaint = new Paint();
    static Canvas canvas;
    Path path = new Path();
    int height = 100;
    int width = 0;

    public GraphDrawer(Context context) {
        super(context);
        getScreenHeight(context);
        height = getScreenHeight(context);
    }

    int getScreenHeight(Context context) {
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        return size.y;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        this.canvas = canvas;
        // стиль Заливка
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setColor(Color.parseColor("#343639"));

        canvas.drawPaint(mPaint);
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(3);

        new AsyncTask<Void, Void, Void>(){

            @Override
            protected Void doInBackground(Void... params) {
                for (;;){
                    try {
                        Thread.sleep(100);
                        publishProgress();


                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            protected void onProgressUpdate(Void... values) {
                super.onProgressUpdate(values);
                Log.d("MUSE_TEST","beta[2]="+(float)StreamReader.betaBuffer[2]);
                path.lineTo(++width, height * (float) StreamReader.betaBuffer[2]);
                GraphDrawer.canvas.drawPath(path, mPaint);
            }
        }.execute();
//      StreamReader.instance.handler.post(tickUi);
    }



}
