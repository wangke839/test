package com.wangke.love;

import com.wangke.love.util.Snow;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 程序主类，用来绘图的主类，控制整个程序执行的主类
 * 作者：wk
 */
public class GameJpanel extends JPanel{

    // 集合用来存储生成的雪花对象
    private List<com.wangke.love.util.Snow> list = new ArrayList<>();
    private JFrame frame;
    // 读取到的雪花图片
    private BufferedImage image;
    // 设置背景图片
    private JLabel label = new JLabel();

    /**
     * 构造方法
     * @param frame
     */
    public GameJpanel(JFrame frame){
        this.frame = frame;
        try {
            // 读取雪花的图片
            image = ImageIO.read(GameJpanel.class.getResource("/snow.png"));

            // 给面板设置背景图片，读取了src目录下 bg.png的图片
            ImageIcon icon = new ImageIcon(GameJpanel.class.getResource("/bg.png"));
            // 设置图片
            label.setIcon(icon);
            this.add(label);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 定义循环的长度
    int len = 0;

    /**
     * 采用java的定时器方式，每隔6秒切换背景图片
     * 开启了新的线程
     * 切换背景图片
     */
    public void changebg(GameJpanel jpanel, String [] bgs) {
        // 定义了任务的方法
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                // 从数组中获取到0下标的元素
                String bg = bgs[len];
                // 给面板设置背景图片
                ImageIcon icon = new ImageIcon(GameJpanel.class.getResource("/"+bg));
                label.setIcon(icon);
                // 设置背景图片
                jpanel.add(label);
                // 让len变量+1
                len++;
                if(len == bgs.length){
                    len = 0;
                }
            }
        };

        // 启动定时任务的对象
        Timer timer = new Timer();
        // 6秒后开始切换
        long delay = 0;
        // 每隔6秒执行一次 1000 1秒
        long intevalPeriod = 6000;
        // 开启定时任务
        timer.schedule(timerTask,delay,intevalPeriod);
    }

    // 用来记录产生雪花的数量
    int sum = 0;

    /**
     * 采用java的定时器方式，创建出雪花对象，存入到list集合中。
     * 切换背景图片
     */
    public void createXuehua() {
        Timer timer = new Timer();
        // 读取雪花的图片
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                // 创建雪花，传入到list集合中
                new Snow(frame,list);
                // 创建一个雪花，记录一个数量
                sum++;
                // 判断，雪花的数量如果是100个，清除掉该定时器，不再需要创建新的雪花
                if(sum == 100){
                    // 取消定时器
                    timer.cancel();
                }
            }
        };
        // 5秒后开始切换
        long delay = 0;
        // 每隔150毫秒执行一次
        long intevalPeriod = 150;
        // 开启定时任务
        timer.schedule(timerTask,delay,intevalPeriod);
    }

    /**
     * 调用面板的重新绘制的方法
     */
    public void redraw(){
        // 读取雪花的图片
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                // 重绘的方法
                repaint();
            }
        };
        Timer timer = new Timer();
        // 0秒后开始切换
        long delay = 0;
        // 每隔15毫秒执行一次
        long intevalPeriod = 15;
        // 开启定时任务
        timer.schedule(timerTask,delay,intevalPeriod);
    }

    /**
     * 绘图的方法，这是重写JPanel绘图的方法，就是靠该方法把雪花和背景图片画到面板上。
     * @param g
     */
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        // 从集合中获取到雪花，然后画在面板上
        for (int i = 0; i < list.size(); i++) {
            // 获取到雪花对象
            Snow xueHua = list.get(i);
            // 让雪花产生动画效果
            xueHua.move();
            // 画在面板上
            g.drawImage(image,(int)xueHua.x,(int)xueHua.y,xueHua.w,xueHua.h,null);
        }

        // 设置字体颜色
        g.setColor(Color.PINK);
        // 设置字体
        g.setFont(new Font("隶书",Font.BOLD,20));

        // 当雪花数量大于30的时候，开始产生文字
        if(sum >= 30) {
            // 获取到标题内容
            String title = frame.getTitle();
            g.drawString(title, 40, 40);
        }
    }

}
