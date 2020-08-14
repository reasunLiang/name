package com.lyx.fishgame;

import org.w3c.dom.css.Rect;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Objects;

/**
 * @Package: com.lyx.fishgame
 * @ClassName: fish
 * @Author: LYX
 * @CreateTime: 2020/8/4 16:54
 * @Description:
 */
public class Fish {
    private BufferedImage cutImg ,wholeImg;
    private int drawIndex = 0, width, height,total;
    private Point newPoint = new Point( 200 ,200);
    private Point oldPoint;
    private int speed;
    public final static int DIRECTION_LEFT = 1;
    public final static int DIRECTION_RIGTH = 2;
    //游动的方向
    private int direction;
    //鱼的状态
    private String state = STATE_SWIM;
    private int type ;
    //游动状态
    public final static String STATE_SWIM = "swim";
    //转身状态
    public final static String STATE_TURN = "turn";
    //吃状态
    public final static String STATE_EAT = "eat";
    //目的坐标
    private Point Target;
    //是否生存
    private boolean isDead = false;

    //分数
    private int score = 0;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public boolean isDead() {
        return isDead;
    }

    public void setDead(boolean dead) {
        isDead = dead;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
    public Point getTarget() {
        return Target;
    }

    public void setTarget(Point target) {
        Target = target;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Fish() {
        this.oldPoint = this.newPoint;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        if(this.state != null && !this.state.equals(state)){
            this.setWholeImg(GameUtils.IMAGES.get(state + "_" + this.type + ".png"));
            this.setTotal( this.wholeImg.getWidth() / this.getWidth());
            this.setDrawIndex(0);
        }
        this.state = state;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
//        System.out.println("direction:"+direction);
        if(this.direction != direction){
            this.setState(STATE_TURN);
        }
        this.direction = direction;
    }

    public Point getOldPoint() {
        return oldPoint;
    }

    public void setOldPoint(Point oldPoint) {
        this.oldPoint = oldPoint;
    }

    public int getTotal() {
        return total;
    }

    public Point getNewPoint() {
        return newPoint;
    }

    public void setNewPoint(Point newPoint) {
        this.newPoint = newPoint;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Fish(BufferedImage wholeImg, int width, int height) {
        this.wholeImg = wholeImg;
        this.width = width;
        this.height = height;
    }

    public BufferedImage getWholeImg() {
        return wholeImg;
    }

    public void setWholeImg(BufferedImage wholeImg) {
        this.wholeImg = wholeImg;
    }

    public BufferedImage getCutImg() {
        return cutImg;
    }

    public void setCutImg(BufferedImage cutImg) {
        this.cutImg = cutImg;
    }

    public int getDrawIndex() {
        return drawIndex;
    }

    public void setDrawIndex(int drawIndex) {
        this.drawIndex = drawIndex;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * 获取鱼的矩形区域
     * @return
     */
    public Rectangle getArea(){
        Rectangle rect = new Rectangle();
        rect.setLocation(this.getNewPoint().x,this.getNewPoint().y);
        rect.setSize(this.getWidth()-50,this.getHeight()-50);
        return rect;
    }




}
