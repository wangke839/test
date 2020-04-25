package cn.tx;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 拓薪教育 -- 腾讯课程认证机构
 * 樱木老师
 */
public class TomGame extends JFrame implements Runnable{

    // 生气图片集合
    private List<ImageIcon> angryIcons = new ArrayList<>();
    // 吃饭 图片集合
    private List<ImageIcon> eatIcons = new ArrayList<>();
    // 喝水
    private List<ImageIcon> drinkIcons = new ArrayList<>();
    // 图片
    private static JLabel bgLabel = new JLabel();
    // 吃按钮
    private static JLabel eatLabel = new JLabel();
    // 喝水按钮
    private static JLabel drinkLabel = new JLabel();
    // 定义下标值
    private static int num = 0;
    // 点击按钮，切换动作
    private static String action = "angry";

    public TomGame(){
        try {
            // 加载生气图片，一共26张图片
            for (int i = 0; i < 26; i++) {
                // 图片的路径
                String path = "/img/Animations/Angry/angry_" +(i<10?"0":"")+i+".jpg";
                // 读取图片
                BufferedImage image = ImageIO.read(TomGame.class.getResource(path));
                // 图片
                ImageIcon icon = new ImageIcon(image);
                // 存入到集合中
                angryIcons.add(icon);
            }

            // 吃东西的图片
            eatLabel.setIcon(new ImageIcon(TomGame.class.getResource("/img/Buttons/eat.png")));

            // 吃集合
            for (int i = 0; i < 40; i++) {
                // 图片的路径
                String path = "/img/Animations/Eat/eat_" +(i<10?"0":"")+i+".jpg";
                // 读取图片
                BufferedImage image = ImageIO.read(TomGame.class.getResource(path));
                // 图片
                ImageIcon icon = new ImageIcon(image);
                // 存入到集合中
                eatIcons.add(icon);
            }

            // 吃东西的图片
            drinkLabel.setIcon(new ImageIcon(TomGame.class.getResource("/img/Buttons/drink.png")));

            // 吃集合
            for (int i = 0; i < 81; i++) {
                // 图片的路径
                String path = "/img/Animations/Drink/drink_" +(i<10?"0":"")+i+".jpg";
                // 读取图片
                BufferedImage image = ImageIO.read(TomGame.class.getResource(path));
                // 图片
                ImageIcon icon = new ImageIcon(image);
                // 存入到集合中
                drinkIcons.add(icon);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 线程run方法
     * 1. 编写死循环
     * 2. 定义num = 0;
     * 3. 从list集合中获取到图片的对象  list.get(num);
     * 3.1 设置背景图片就搞定
     * 4. num++;
     * 5. Thread.sleep(100);
     */
    @Override
    public void run() {
        // 死循环
        while (true){
            // 没循环一次，让num+1，从集合中取值
            num++;
            try {
                // 判断当前用户点击了什么按钮
                // 当用户点击了生气的按钮
                if("angry".equals(action)){
                    // 设置图片 list.get(index);
                    bgLabel.setIcon(angryIcons.get(num));
                    int size = angryIcons.size()-1;
                    // 判断num
                    if(num == size){
                        num = 0;
                    }
                }

                // 当用户点击了吃东西按钮
                if("eat".equals(action)){
                    // 设置图片
                    bgLabel.setIcon(eatIcons.get(num));
                    int size = eatIcons.size()-1;
                    // 判断num
                    if(num == size){
                        num = 0;
                    }
                }

                // 当用户点击了吃东西按钮
                if("drink".equals(action)){
                    // 设置图片
                    bgLabel.setIcon(drinkIcons.get(num));
                    int size = drinkIcons.size()-1;
                    // 判断num
                    if(num == size){
                        num = 0;
                    }
                }

                // 每100毫秒一针
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 主函数
     * @param args
     */
    public static void main(String[] args) {
        // 窗口，
        // 做了什么事情：编写for循环，循环26次。一共有26张图片。
        // 加载26张图片，创建ImageIcon(图片)
        // List list = new ArrayList();
        // list.add(ImageIcon(图片));
        TomGame frame = new TomGame();

        // 设置标题
        frame.setTitle("可爱的Tom猫");
        // 设置大小
        frame.setSize(600,700);
        // 设置居中显示
        frame.setLocationRelativeTo(null);
        // 设置关闭
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 清空布局方式
        frame.setLayout(null);



        // 设置吃饭图片位置
        eatLabel.setBounds(10,420,60,60);
        frame.add(eatLabel);
        // 绑定鼠标点击事件
        eatLabel.addMouseListener(new MouseAdapter() {
            /**
             * 当用户一点击按钮，就切换效果
             * @param e
             */
            @Override
            public void mouseClicked(MouseEvent e) {
                action = "eat";
                num = 0;
            }
        });


        // 设置吃饭图片位置
        drinkLabel.setBounds(10,480,60,60);
        frame.add(drinkLabel);
        // 绑定鼠标点击事件
        drinkLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                action = "drink";
                num = 0;
            }
        });


        // 设置位置
        bgLabel.setBounds(0,0,600,700);
        // 添加组件
        frame.add(bgLabel);
        // 点击其他位置，切换会生气图片
        bgLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                action = "angry";
                num = 0;
            }
        });

        // 启动线程，设置背景照片
        new Thread(frame).start();
        // 播放背景音乐（播放音乐工具类）
        //new MusicUtils().play(TomGame.class.getResourceAsStream("/pfzl.mp3"));
        // 显示窗口
        frame.setVisible(true);
    }


}
