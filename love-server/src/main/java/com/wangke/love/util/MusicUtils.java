package com.wangke.love.util;

import javazoom.jl.player.Player;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * 作者：wk
 * 播放音乐的工具类，需要使用jl1.0.jar，所以需要先导入jl1.0.jar
 */
public class MusicUtils {
    /**
     * 播放音乐的类
     * @param filepath
     * @throws Exception
     */
    public void play(String filepath){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    File file=new File(filepath);
                    FileInputStream fis = new FileInputStream(file);
                    BufferedInputStream stream=new BufferedInputStream(fis);
                    Player player;
                    player = new Player(stream);
                    player.play();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
    /**
     * 播放音乐的类
     * @throws Exception
     */

    public void play(InputStream inputStream){
        // 采用匿名内部类的方式播放音乐
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    // 缓冲输入流
                    BufferedInputStream stream=new BufferedInputStream(inputStream);
                    Player player=new Player(stream);
                    // 播放音乐
                    player.play();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
