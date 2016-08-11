package org.snow.cms.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Chptcha {
    private int width;
    private int heigh;
    private int num;
    private String code;
    private static final Random rdm = new Random();
    private static Chptcha chptcha;

    private Chptcha() {
        this.code = "0123456789abcdefghijklmnopqretuvwxwzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        this.num = 4;
    }

    public static Chptcha getInstance() {
        if (chptcha == null) chptcha = new Chptcha();
        return chptcha;
    }

    public int getWidth() {
        return this.width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeigh() {
        return this.heigh;
    }

    public void setHeigh(int heigh) {
        this.heigh = heigh;
    }

    public int getNum() {
        return this.num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void set(int width, int height, int num, String code) {
        this.width = width;
        this.heigh = height;
        setNum(num);
        setCode(code);
    }

    public void set(int width, int height) {
        this.width = width;
        this.heigh = height;
    }

    public String generateCheckcode() {
        StringBuffer cc = new StringBuffer();
        for (int i = 0; i < this.num; i++) {
            cc.append(this.code.charAt(rdm.nextInt(this.code.length())));
        }
        return cc.toString();
    }

    public BufferedImage generateCheckImg(String checkcode) {
        BufferedImage img = new BufferedImage(this.width, this.heigh, 1);

        Graphics2D graphic = img.createGraphics();
        graphic.setColor(Color.WHITE);
        graphic.fillRect(0, 0, this.width, this.heigh);
        graphic.setColor(Color.BLACK);
        graphic.drawRect(0, 0, this.width - 1, this.heigh - 1);
        Font font = new Font("宋体", 3, (int) (this.heigh * 0.8D));
        graphic.setFont(font);
        for (int i = 0; i < this.num; i++) {
            graphic.setColor(new Color(rdm.nextInt(200), rdm.nextInt(200), rdm.nextInt(200)));
            graphic.drawString(String.valueOf(checkcode.charAt(i)), i * (this.width / this.num) + 4, (int) (this.heigh * 0.8D));
        }

        for (int i = 0; i < this.width + this.heigh; i++) {
            graphic.setColor(new Color(rdm.nextInt(255), rdm.nextInt(255), rdm.nextInt(255)));
            graphic.drawOval(rdm.nextInt(this.width), rdm.nextInt(this.heigh), 1, 1);
        }

        for (int i = 0; i < 3; i++) {
            graphic.setColor(new Color(rdm.nextInt(255), rdm.nextInt(255), rdm.nextInt(255)));
            graphic.drawLine(rdm.nextInt(this.width), rdm.nextInt(this.heigh), rdm.nextInt(this.width), rdm.nextInt(this.heigh));
        }
        return img;
    }
}
