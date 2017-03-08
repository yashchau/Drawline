package com.bt.drawline;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    // EditText xvalue=(EditText)findViewById(R.id.xvalue);
    //EditText yvalue=(EditText)findViewById(R.id.yvalue);
    int i, j;
    int startx = 700;
    int starty = 2500;
    int endx = 700;
    int endy = 2000;
    /*    Bitmap bitmap = Bitmap.createBitmap((int) getWindowManager()
                .getDefaultDisplay().getWidth(), (int) getWindowManager()
                .getDefaultDisplay().getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        Paint paint = new Paint();
        EditText xvalue=(EditText)findViewById(R.id.xvalue);
        EditText yvalue=(EditText)findViewById(R.id.yvalue);*/
    ImageView drawingImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawingImageView = (ImageView) this.findViewById(R.id.DrawingImageView);

        EditText xvalue = (EditText) findViewById(R.id.xvalue);
        EditText yvalue = (EditText) findViewById(R.id.yvalue);
        Bitmap bitmap = Bitmap.createBitmap(getWindowManager()
                .getDefaultDisplay().getWidth(), getWindowManager()
                .getDefaultDisplay().getHeight(), Bitmap.Config.ARGB_8888);
        final Canvas canvas = new Canvas(bitmap);
//
//
        final Paint paint = new Paint();
        paint.setColor(Color.rgb(255, 153, 51));
        paint.setStrokeWidth(10);
        //canvas.drawLine(startx, starty, endx, endy, paint);
        xvalue.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                String is = v.getText().toString();
                i = Integer.parseInt(is);
                System.out.println("Value: " + i);
                endx = endx + i;
                //canvas.drawLine(startx, starty, endx, endy, paint);
                //startx = endx;

                return false;
            }
        });
        yvalue.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                String is = v.getText().toString();
                j = Integer.parseInt(is);
                endy = endy - j;
                canvas.drawLine(startx, starty, endx, endy, paint);
                starty = endy;
                startx = endx;

                return false;
            }
        });
        drawingImageView.setImageBitmap(bitmap);
    }
}
