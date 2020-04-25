package cn.tx;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 拓薪教育 -- 腾讯课程认证机构
 * 樱木老师
 *
 * 继承 咱爹是个窗口，做为儿子也是窗口
 */
public class Demo6 extends JFrame implements Runnable{

    // List集合，存储很多的数据，存储图片 list集合中已经存储了26图片
    private List<ImageIcon> list = new ArrayList<>();

    // 创建标签的对象
    static JLabel label = new JLabel();

    // 变量
    int num = 0;

    // 重写构造方法，new对象，做一些事情
    public Demo6(){
        // 把图片加载到list集合中
        // 编写for循环
        for(int i=0;i<26;i++){
            // 创建图片对象
            ImageIcon icon = new ImageIcon(Demo6.class.getResource("/img/Animations/Angry/angry_" +(i<10?"0":"")+i+".jpg"));
            // 存入list集合中
            list.add(icon);
        }
    }

    // 多线程的代码
    @Override
    public void run() {
        // 编写一些代码
        // 死循环
        while (true){
            // 每循环一次，从list集合中取出一张图片
            ImageIcon icon = list.get(num);
            // 设置给标签组件
            label.setIcon(icon);
            // 让num加1
            num++;
            // 判断
            if(num == list.size()){
                num = 0;
            }

            try {
                // 睡眠
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Demo6 demo6 = new Demo6();
        // 调用父类的setTitle方法
        demo6.setTitle("Tom猫");
        demo6.setSize(600,700);
        demo6.setLocationRelativeTo(null);

        // 标签中没有图片
        // 把标签存放到窗口上
        demo6.add(label);
        // 启动线程
        new Thread(demo6).start();

        // 显示窗口
        demo6.setVisible(true);

    }


}
