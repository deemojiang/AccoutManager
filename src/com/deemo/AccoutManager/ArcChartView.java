package com.deemo.AccoutManager;

import android.content.Context;
import android.graphics.*;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by 小默 on 2015/4/10.
 */
public class ArcChartView extends View {

    private Paint arcPaint;
    private RectF arcRect;
    private RectF arcRect2;
    private int []date;

    public ArcChartView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }



    public ArcChartView(Context context) {
        this(context,null);
    }

    private void init(Context context, AttributeSet attrs) {

        arcPaint=new Paint();
        arcPaint.setColor(Color.BLACK);
        arcPaint.setAntiAlias(true);
        arcRect2=new RectF(10,10,210,210);
        arcRect=new RectF(260,10,460,210);

        date=new int[]{8000,2000,4500,1100,2500,400,150};

    }

    public  void  setData(int[] data) {
        this.date = data;
        if (data != null) {
            //进行刷新操作
            invalidate();
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        float start=0;
        float size=0;

        float income=date[0]+date[1];
        float expend=date[2]+date[3]+date[4]+date[5]+date[6];




        //工资占40%，蓝色
        arcPaint.setColor(Color.BLUE);
        size=date[0]*360/income;
        canvas.drawArc(arcRect2,start,size,true,arcPaint);
        start+=(size);

        //外快占49%，绿色
        arcPaint.setColor(Color.GREEN);
        size=date[1]*360/income+2;
        canvas.drawArc(arcRect2,start,size,true,arcPaint);
        start=0;






        //吃占40%，红色
        arcPaint.setColor(Color.MAGENTA);
        size=date[2]*360/expend;
        canvas.drawArc(arcRect,start,size,true,arcPaint);
        start+=(size);

        //穿占49%，绿色
        arcPaint.setColor(Color.GREEN);
        size=date[3]*360/expend;
        canvas.drawArc(arcRect,start,size,true,arcPaint);
        start+=(size);

        //住占8%，蓝色
        size=date[4]*360/expend;
        arcPaint.setColor(Color.BLUE);
        canvas.drawArc(arcRect,start,size,true,arcPaint);
        start+=(size);

        //行占3%，黄色
        size=date[5]*360/expend;
        arcPaint.setColor(Color.YELLOW);
        canvas.drawArc(arcRect,start,size,true,arcPaint);
        start+=(size);

        //用占3%，黄色
        size=date[6]*360/expend;
        arcPaint.setColor(Color.RED);
        canvas.drawArc(arcRect,start,size,true,arcPaint);



//        //画中间白色部分
//        arcPaint.setColor(Color.BLACK);
//        canvas.drawCircle(110,110,50,arcPaint);

    }


}
