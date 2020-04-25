package com.wangke.love.util;

import javax.swing.*;
import java.util.List;
import java.util.Random;

public class Snow {
    // 雪花的宽度和高度
    public int w,h;
    // 雪花产生的位置 x y
    // sdx,sdy雪花每次移动的距离
    public float x,y,sdx,sdy;
    // 集合，用来存储雪花对象
    private List<Snow> list;
    // 创建类
    private JFrame frame;
    // 随机
    private Random random = new Random();

    /**
     * 创建雪花对象，设置雪花在窗口中出现的位置，把雪花对象存入到list集合中。
     * @param frame
     * @param list
     */
    public Snow(JFrame frame, List<Snow> list){
        this.list = list;
        this.frame = frame;
        // 随机大小
        w=h=(int)(Math.random()*20+10);
        // x轴移动速度
        sdx=(float) (Math.random()*0.7+0.3);
        // y轴移动速度
        sdy=(float) (Math.random()*0.4+0.3);

        // 随机获取10以内的数字
        int num = random.nextInt(10);
        // 随机数整除
        if(num % 2 == 0){
            // 雪花在屏幕上方
            y=-h;
            x=(int)(Math.random()*frame.getWidth());
        }else{
            // 雪花在屏幕右方
            x=frame.getWidth();
            y=(int)(Math.random()*frame.getHeight());
        }
        // 添加进集合
        this.list.add(this);
    }

    /**
     * 雪花每次移动的距离
     */
    public void move(){
        // 如果雪花超出屏幕范围的话就从集合中删掉
        if(x+w<0||y>this.frame.getHeight()){
            //this.list.remove(this);
            // 恢复雪花的位置
            // 随机获取10以内的数字
            int num = random.nextInt(10);
            // 随机数整除
            if(num % 2 == 0){
                // 雪花在屏幕上方
                y=-h;
                x=(int)(Math.random()*frame.getWidth());
            }else{
                // 雪花在屏幕右方
                x=frame.getWidth();
                y=(int)(Math.random()*frame.getHeight());
            }
        }
        y+=sdy;
        x-=sdx;
    }
}
