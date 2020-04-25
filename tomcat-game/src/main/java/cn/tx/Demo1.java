package cn.tx;

import javax.swing.*;

/**
 * 拓薪教育 -- 腾讯课程认证机构
 * 樱木老师
 */
public class Demo1 {

    public static void main(String[] args) {
        // Java的窗口程序
        // 需求：运行主函数，在生产窗口 JFrame
        JFrame frame = new JFrame();
        // 调用对象提供的方法，完成效果
        // 设置窗口的大小
        frame.setSize(600,700);
        // 设置标题
        frame.setTitle("hello");
        // 设置窗口居中显示
        frame.setLocationRelativeTo(null);

        // 给窗口设置一张背景图片
        // 先创建标签组件对象
        JLabel label = new JLabel();
        // 把图片存储到标签组件中去
        // 设置图片（把图片存储到标签组件中），照着老师抄，Java反射
        label.setIcon(new ImageIcon(Demo1.class.getResource("/img/Animations/Angry/angry_00.jpg")));
        //label.setIcon(new ImageIcon(Demo1.class.getResourceAs("bg.jpg")));
        // 把标签组件存储到窗口上
        frame.add(label);

        // 显示出窗口
        frame.setVisible(true);
    }

}
