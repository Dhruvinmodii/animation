package com.example.enimation;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.ArcShape;
import android.graphics.drawable.shapes.PathShape;
import android.graphics.drawable.shapes.RoundRectShape;
import android.os.Build;
import android.view.View;
import android.widget.ImageButton;

import androidx.annotation.RequiresApi;

public class Myclass extends View {

    int x,y;

    public Myclass(Context context) {
        super(context);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        Paint p=new Paint();
        x=canvas.getWidth()/2;
        y=canvas.getHeight()/2;

        canvas.drawColor(Color.GRAY);
        p.setColor(Color.WHITE);

        canvas.drawCircle(x,y,2*y/3,p);
        canvas.drawOval(50,70,300,200,p);
        canvas.drawRect(100,120,120,130,p);
        canvas.drawRoundRect(100,220,160,150,5,10,p);
        canvas.drawText("Sample Text",200,200,p);

        p.setStrokeWidth(4);
        p.setStyle(Paint.Style.FILL);
        canvas.drawLine(x,y,x-20,y+50,p);
        canvas.drawLine(x,y,x+20,y+50,p);
        canvas.drawLine(x-20,y+50,x+20,y+50,p);
        canvas.drawArc(new RectF(x-80,y+50,x+80,y+100) ,0,180,false,p);

        //star

        ImageButton btn;
        btn=(ImageButton)findViewById(R.id.iv);
        btn.setBackgroundColor(Color.WHITE);
        Path p=new Path();
        p.moveTo(50,0);
        p.lineTo(25,100);
        p.lineTo(100,50);
        p.lineTo(0,50);
        p.lineTo(75,100);
        p.lineTo(50,0);
        ShapeDrawable s=new ShapeDrawable(new PathShape(p,100,100));
        s.setIntrinsicHeight(100);
        s.setIntrinsicWidth(100);
        s.getPaint().setColor(Color.YELLOW);
        btn.setImageDrawable(s);

        //arc

        ImageButton btn1;
        btn1=(ImageButton)findViewById(R.id.iv);
        ShapeDrawable a=new ShapeDrawable(new
                ArcShape(0,345));
        a.setIntrinsicHeight(100);
        a.setIntrinsicWidth(100);
        a.getPaint().setColor(Color.BLUE);
        btn1.setImageDrawable(a);

        //round rect

        ImageButton btn3;
        btn3=(ImageButton)findViewById(R.id.iv);
        btn3.setBackgroundColor(Color.WHITE);
        ShapeDrawable rr=new ShapeDrawable(new
                RoundRectShape(new float[]
                {5,5,5,5,5,5,5,5},null,null));
        rr.setIntrinsicWidth(100);
        rr.setIntrinsicHeight(50);
        rr.getPaint().setColor(Color.RED);
        btn3.setImageDrawable(rr);
    }


}

