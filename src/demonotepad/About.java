/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demonotepad;

import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
/**
 *
 * @author Phạm Văn Hiếu
 */
public class About extends JFrame {
    About(){
        setBounds(600, 200, 475, 425);
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/windows.png"));
        Image i2 = i1.getImage().getScaledInstance(320, 60, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(85,15,320,60);
        add(l1);
        
        JSeparator s1= new JSeparator();
        s1.setBounds(50,90,400,1);
        add(s1);
        
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("images/notepad.png"));
        Image i5 = i4.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel l2 = new JLabel(i6);
        l2.setBounds(50,105,30,30);
        add(l2);
        
        JLabel l3 = new JLabel("<html>Microsoft Windows<br>"
                + "Version 21H1 (OS Build 19043.1288)<br>"
                + "© Microsoft Corporation. All rights reserved.<html>"
        );
        l3.setBounds(85,15,500,300);
        l3.setFont(new Font("SAN_SERIF", Font.PLAIN, 11));
        add(l3);
        
        JLabel l4 = new JLabel(
                "<html> The windows 10 Home Single Language operating system and its user<br>"
                + "interface are protected by trademark and other pending or existing<br>"
                + "intellectual property rights in the United States and other<br>"
                + "countries/regions <html>" );
        l4.setBounds(85,85,500,300);
        l4.setFont(new Font("SAN_SERIF", Font.PLAIN, 11));
        add(l4);
        
        JLabel l5 = new JLabel(
                "<html> The windows 10 Home Single Language operating system and its user<br>"
                + "interface are protected by trademark and other pending or existing<br>"
                + "intellectual property rights in the United States and other<br>"
                + "countries/regions <html>" );
        l5.setBounds(85,175,500,300);
        l5.setFont(new Font("SAN_SERIF", Font.PLAIN, 11));
        add(l5);
    }
    public static void main(String[] args) {
        new About().setVisible(true);
    }
    public Icon load(String linkImage, int k, int m) {/*linkImage là tên icon, k kích thước chiều rộng mình muốn,m chiều dài và hàm này trả về giá trị là 1 icon.*/
    try {
        BufferedImage image = ImageIO.read(new File(linkImage));//đọc ảnh dùng BufferedImage
 
        int x = k;
        int y = m;
        int ix = image.getWidth();
        int iy = image.getHeight();
        int dx = 0, dy = 0;
 
        if (x / y > ix / iy) {
            dy = y;
            dx = dy * ix / iy;
        } else {
            dx = x;
            dy = dx * iy / ix;
        }
 
        return new ImageIcon(image.getScaledInstance(dx, dy,
                image.SCALE_SMOOTH));
 
    } catch (IOException e) {
 
        e.printStackTrace();
    }
 
    return null;
}
    
}
