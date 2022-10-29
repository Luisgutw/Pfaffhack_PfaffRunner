package com.example.pfaffhack.ui.home;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

import com.example.pfaffhack.MainActivity;

public class Draw extends View {

    Paint paint;
    Path path;

    float left;
    float top;
    float right;
    float bottom;


    public Draw(Context context, float left, float top, float right, float bottom) {
        super(context);
        this.left = left;
        this.top = top;
        this.right = right;
        this.bottom = bottom;
        init();
    }

    public Draw(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public Draw(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public void init(){
        paint = new Paint();
        paint.setColor(Color.GREEN);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setStrokeWidth(10);
        paint.setStyle(Paint.Style.STROKE);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        // TODO Auto-generated method stub
        super.onDraw(canvas);

        canvas.drawRect(left, top, right, bottom, paint);
    }

    public void inv(int x, int y) {
        postInvalidate();

        left = x*(760-230)/4 + 230;
        right = left + 65;
        top = y *(1240-630)/5 + 630;
        bottom = top + 65;
    }
}
