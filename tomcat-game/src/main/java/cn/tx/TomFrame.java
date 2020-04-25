package cn.tx;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 拓薪教育 -- 腾讯课程认证机构
 * 樱木老师
 *
 * 继承是否了解？
 * 编写Tom小程序
 */
public class TomFrame extends JFrame implements Runnable{

    // 定义list集合，存储图片
    private List<ImageIcon> imageIcons = new ArrayList<>();

    // 定义属性，标签的组件（存放图片），标签组件里面没有任何一张图片
    private static JLabel label = new JLabel();

    // 定义下标值，默认是0
    private int num = 0;

    // 先把所有的图片加载到，存储到list集合中
    public TomFrame(){
        // 编写for循环
        for (int i = 0; i < 26; i++) {
            // 获取到图片的路径
            String path = "static/img/Animations/Angry/angry_" +(i<10?"0":"")+i+".jpg";
            // 加载图片
            ImageIcon icon = new ImageIcon(TomFrame.class.getResource(path));
            // 存储到imageIcons集合中
            imageIcons.add(icon);
        }
    }

    /**
     * 模拟100毫秒一帧的效果
     * 100毫秒循环一次
     */
    @Override
    public void run() {
        // 死循环
        while (true){
            // 切换图片就OK
            ImageIcon icon = imageIcons.get(num);
            // 设置到标签组件中去
            label.setIcon(icon);
            // 让num循环一次，+1
            num++;

            // 判断
            if(num == imageIcons.size()){
                num = 0;
            }

            try {
                // 睡眠操作
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        // 创建窗口
        TomFrame frame = new TomFrame();
        // 调用方法
        frame.setTitle("Tom猫");
        // 设置大小
        frame.setSize(600,700);
        // 设置居中显示
        frame.setLocationRelativeTo(null);

        // 把标签组件放到窗口上
        frame.add(label);

        // 启动线程
        new Thread(frame).start();

        // 显示窗口
        frame.setVisible(true);
    }


}
