package com.example.plannerr.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import com.example.plannerr.R;

public class CustomView extends View {

    private Rect mRectShape;
    private Paint mPaintShape;
    public CustomView(Context context) {
        super(context);
        init(null);
    }

    public CustomView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public CustomView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public CustomView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(attrs);
    }

    private void init(@Nullable AttributeSet set){
        mRectShape = new Rect();
        mPaintShape = new Paint();
    }

    @Override
    protected void onDraw(Canvas canvas) {

        mRectShape.top = 10;

        mPaintShape.setColor(getResources().getColor(R.color.colorPrimary));
        canvas.drawRect(mRectShape, mPaintShape);
    }
}
