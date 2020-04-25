package com.wangke.love;

import com.wangke.love.util.MusicUtils;

import javax.swing.*;

public class Love {

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setTitle("ke love xiao");
        // 设置大小
        frame.setSize(1000,700);
        // 居中显示
        frame.setLocationRelativeTo(null);
        // 设置关闭按钮，停止Java虚拟机
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 创建面板对象
        GameJpanel panel = new GameJpanel(frame);
        // 添加
        frame.add(panel);
        // 定义字符串的数组
        // 切换背景图片
        String [] bgs = {"1.jpg","2.jpg","3.jpg"};
        // 切换背景图片
        panel.changebg(panel,bgs);

        // ==============================================

        // 每隔150毫秒生产出一个雪花
        panel.createXuehua();

        // 每隔15毫秒重绘一次，把雪花图片绘制面板上
        panel.redraw();

        // 播放背景音乐（播放音乐工具类）
        new MusicUtils().play(Love.class.getResourceAsStream("/pfzl.mp3"));

        // 显示窗口
        frame.setVisible(true);

    }
}
