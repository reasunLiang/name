package com.lyx.fishgame;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * @Package: com.lyx.fishgame
 * @ClassName: GamePanel
 * @Author: LYX
 * @CreateTime: 2020/8/1 15:06
 * @Description:
 */
public class GameJPanel extends JPanel {
    Fish playFish;
    Date date = new Date();
    Random random = new Random(date.getTime());
    public void setPlayFish(Fish playFish) {
        this.playFish = playFish;
    }
    List<Fish> wildFishes = new ArrayList<>();

    public GameJPanel() {
        new Thread(new drawThread()).start();
        GameUtils.initWildFishes(wildFishes);
    }

    @Override
    protected void paintComponent(Graphics g) {
        //绘制背景图片
        g.drawImage(GameUtils.IMAGES.get("FF201311.jpg"), 0, 0, GameUtils.FRAME_WIDTH, GameUtils.FRAME_HEIGHT, this);
        fishSwimming(g, playFish);

        for (Fish f: wildFishes ) {
            if(f.isDead()){
                continue;
            }
//            System.out.println(f.getState());
//            System.out.println(f.getTarget().x + " _ " + f.getTarget().y  + " _ "  + f.getType());
            fishSwimming(g,f);
            wildFishMove(f);
            //碰撞函数
            intersectResolve(f);
        }
        g.setColor(Color.RED);
        g.setFont(new Font("黑体",Font.BOLD|Font.ITALIC,50));
        g.drawString(playFish.getScore() + "",   80,80);

    }

    /**
     * 如果野生鱼碰撞到玩家鱼时候
     * @param wildFish
     */
    private void intersectResolve(Fish wildFish) {

        if(wildFish.isDead())
            return ;
        if(playFish.getState().equals(Fish.STATE_SWIM) &&
                wildFish.getArea().intersects(playFish.getArea())){

            wildFish.setType(random.nextInt(9) + 1);
            wildFish.setWholeImg(GameUtils.IMAGES.get(wildFish.getState() + "_" + wildFish.getType() + ".png"));
            String[] s = GameUtils.INFOS.get(wildFish.getType()).split(" ");
            wildFish.setHeight(Integer.parseInt(s[1]));
            wildFish.setWidth(Integer.parseInt(s[0]));
            wildFish.setTotal(wildFish.getWholeImg().getWidth() / wildFish.getWidth());
            //初始位置
            wildFish.setNewPoint(new Point(random.nextInt(GameUtils.FRAME_WIDTH) + 1,random.nextInt(GameUtils.FRAME_HEIGHT) + 1));
            wildFish.setSpeed(Integer.parseInt(s[4]));
            wildFish.setTarget(new Point(random.nextInt(GameUtils.FRAME_WIDTH),random.nextInt(GameUtils.FRAME_HEIGHT)));
            wildFish.setDirection(wildFish.getTarget().x - wildFish.getNewPoint().x > 0? Fish.DIRECTION_RIGTH : Fish.DIRECTION_LEFT);
            wildFish.setScore(Integer.parseInt(s[3]));
            playFish.setState(Fish.STATE_EAT);
            playFish.setScore(playFish.getScore() + wildFish.getScore());
        }
    }

    private void fishSwimming(Graphics g, Fish fish) {

        fish.setTotal(fish.getWholeImg().getWidth() / fish.getWidth()) ;
        fish.setDrawIndex(fish.getDrawIndex() == fish.getTotal()-1 ? 0 : fish.getDrawIndex() + 1);
        fish.setCutImg(fish.getWholeImg().getSubimage( fish.getDrawIndex() * fish.getWidth() , 0 , fish.getWidth() ,fish.getHeight())) ;
        BufferedImage cutImg = fish.getCutImg();
        //之前放在方法的第一行，导致最后一次的绘制出问题，得到的不是最新的cutImg
        //        System.out.println(fish.toString());
        //当鱼而在游动时，并且在向右移动，这时将图片反转
        if(fish.getDirection() == Fish.DIRECTION_RIGTH &&
            fish.getState().equals(Fish.STATE_SWIM)){
            cutImg = GameUtils.getOppoImage(fish.getCutImg());
        }
        //当鱼儿在朝左的时，并且状态时转弯时
        else if(fish.getDirection() == Fish.DIRECTION_LEFT
                && fish.getState().equals(Fish.STATE_TURN)){
            cutImg = GameUtils.getOppoImage(fish.getCutImg());
        }
        //当鱼儿在朝左的时候，并且在EAT时反转图片
        else if(fish.getDirection() == Fish.DIRECTION_RIGTH
                && fish.getState().equals(Fish.STATE_EAT)){
            cutImg = GameUtils.getOppoImage(fish.getCutImg());
        }

        //判断是否将转动播放完成，完成就修改鱼的状态
        if(fish.getDrawIndex() == fish.getTotal() - 1  &&
                fish.getState().equals(Fish.STATE_TURN)) {
            fish.setState(Fish.STATE_SWIM);
        }
        //播放完吃的最后一张图后改变状态
        else if (fish.getDrawIndex() == fish.getTotal() - 1 &&
                fish.getState().equals(Fish.STATE_EAT)) {

            fish.setState(Fish.STATE_SWIM);
        }

        g.drawImage( cutImg ,fish.getNewPoint().x,fish.getNewPoint().y, fish.getWidth(),fish.getHeight() ,this);

    }


    //重复调用paintComponent绘制图片
    class  drawThread  implements Runnable{
        @Override
        public void run() {
            while (true){
//                System.out.println("子线程在运行");
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                GameJPanel.this.repaint();
            }
        }
    }


    public void wildFishMove(Fish fish){
        //设置鱼儿的目的地
        //当fish距离的目的地的距离小于，鱼儿的速度时，重写
        int henxiang = fish.getTarget().x - fish.getNewPoint().x;
        int zongxiang = fish.getTarget().y - fish.getNewPoint().y;
        //如果距离小于下一次移动的长度就换新的方向
//       System.out.println(fish.getTarget()  +" _ " + fish.getNewPoint()  +" _ "+ (fish.getTarget().y - fish.getNewPoint().y));
        if( fish.getSpeed() > Math.abs(henxiang)  || fish.getSpeed() > Math.abs(zongxiang)) {
            //设置鱼儿的新目的地
            System.out.println("鱼儿改变了目的地");
            fish.setTarget(new Point(random.nextInt(GameUtils.FRAME_WIDTH - fish.getWidth())  ,random.nextInt(GameUtils.FRAME_HEIGHT - fish.getHeight())));
            fish.setDirection(fish.getTarget().x - fish.getNewPoint().x > 0 ? Fish.DIRECTION_RIGTH : Fish.DIRECTION_LEFT);
        }

        //设置方向
        int d = fish.getTarget().x - fish.getNewPoint().x;
//        System.out.println(fish.getTarget().x + " _ " + fish.getNewPoint().x);
//        System.out.println(d);
//        System.out.println(fish.getTarget().y);
        //切换方位
        fish.setOldPoint(fish.getNewPoint());
        if(d > 0){
            if(fish.getTarget().y > fish.getNewPoint().y)
                fish.setNewPoint(new Point(fish.getNewPoint().x + fish.getSpeed() ,fish.getNewPoint().y + fish.getSpeed()));
            else
                fish.setNewPoint(new Point(fish.getNewPoint().x + fish.getSpeed() ,fish.getNewPoint().y - fish.getSpeed()));
        }
        else{
            if(fish.getTarget().y > fish.getNewPoint().y)
                fish.setNewPoint(new Point(fish.getNewPoint().x - fish.getSpeed() ,fish.getNewPoint().y + fish.getSpeed()));
            else
                fish.setNewPoint(new Point(fish.getNewPoint().x - fish.getSpeed() ,fish.getNewPoint().y - fish.getSpeed()));
        }

    }


}
