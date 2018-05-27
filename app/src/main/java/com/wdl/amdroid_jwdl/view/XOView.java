package com.wdl.amdroid_jwdl.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.wdl.amdroid_jwdl.R;


/**
 * author：lhm on 2018/5/26 22:42
 * <p>
 * email：3186834196@qq.com
 */
public class XOView extends View {
    private Paint paintBlueC;
    private Paint paintRedX;
    private Paint paintHuiC;
    private Paint PaintHuiX;
    private int status;
    private int color;

    public XOView(Context context) {
        this(context, null);
    }

    public XOView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public XOView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.XOView);
        status=typedArray.getInt(R.styleable.XOView_xo_status, 0);
        color=typedArray.getColor(R.styleable.XOView_xo_color, Color.parseColor("#88888888"));

        paintBlueC = new Paint();
        paintBlueC.setColor(Color.parseColor("#ff3f7fff"));
        paintBlueC.setStrokeWidth(15);
        paintBlueC.setStyle(Paint.Style.STROKE);

        paintRedX = new Paint();
        paintRedX.setColor(Color.parseColor("#ffff3366"));
        paintRedX.setStrokeWidth(15);


        paintHuiC = new Paint();
        paintHuiC.setColor(Color.parseColor("#88888888"));
        paintHuiC.setStrokeWidth(15);
        paintHuiC.setStyle(Paint.Style.STROKE);

        PaintHuiX = new Paint();
        PaintHuiX.setColor(Color.parseColor("#88888888"));
        PaintHuiX.setStrokeWidth(15);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        //将当前画布的点移到getPaddingLeft,getPaddingTop,后面的操作都以该点作为参照点
        // canvas.translate(200, 200);
        if (status == 0) { //蓝圈
            canvas.drawCircle(getWidth() / 2, getWidth() / 2, getWidth() / 2 - 10, paintBlueC);

        } else if (status == 1) {//红叉
            canvas.drawLine(getWidth() * 0.1f, getWidth() * 0.1f, getWidth() - getWidth() * 0.1f, getWidth() - getWidth() * 0.1f, paintRedX);
            canvas.drawLine(getWidth() - getWidth() * 0.1f, getWidth() * 0.1f, getWidth() * 0.1f, getWidth() - getWidth() * 0.1f, paintRedX);
        } else if (status == 2) {//灰圈
            canvas.drawCircle(getWidth() / 2, getWidth() / 2, getWidth() / 2 - 10, paintHuiC);

        } else if (status == 3) {//灰叉
            canvas.drawLine(getWidth() * 0.1f, getWidth() * 0.1f, getWidth() - getWidth() * 0.1f, getWidth() - getWidth() * 0.1f, PaintHuiX);
            canvas.drawLine(getWidth() - getWidth() * 0.1f, getWidth() * 0.1f, getWidth() * 0.1f, getWidth() - getWidth() * 0.1f, PaintHuiX);
        }
    }


    private int getMySize(int defaultSize, int measureSpec) {
        int mySize = defaultSize;

        int mode = MeasureSpec.getMode(measureSpec);
        int size = MeasureSpec.getSize(measureSpec);

        switch (mode) {
            case MeasureSpec.UNSPECIFIED: {//如果没有指定大小，就设置为默认大小
                mySize = defaultSize;
                break;
            }
            case MeasureSpec.AT_MOST: {//如果测量模式是最大取值为size
                //我们将大小取最大值,你也可以取其他值
                mySize = size;
                break;
            }
            case MeasureSpec.EXACTLY: {//如果是固定的大小，那就不要去改变它
                mySize = size;
                break;
            }
        }
        return mySize;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int width = getMySize(100, widthMeasureSpec);
        int height = getMySize(100, heightMeasureSpec);

        if (width < height) {
            height = width;
        } else {
            width = height;
        }
        setMeasuredDimension(width, height);
    }


    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
        invalidate();
    }
}
