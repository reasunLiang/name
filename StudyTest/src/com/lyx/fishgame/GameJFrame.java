package com.lyx.fishgame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

/**
 * @Package: PACKAGE_NAME
 * @ClassName: GameJfame
 * @Author: LYX
 * @CreateTime: 2020/8/1 10:40
 * @Description:
 */
public class GameJFrame  extends JFrame{
    public GameJFrame(){
        //设置窗口大小
        setSize( GameUtils.FRAME_WIDTH, GameUtils.FRAME_HEIGHT);
        Fish playerFish = new Fish(GameUtils.IMAGES.get("swim_0.png"),200,180);
        //关闭窗口即退出程序
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("JAVA大鱼吃小鱼");
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Cursor c = toolkit.createCustomCursor(GameUtils.IMAGES.get("cursor.png"), new Point(0, 0), "");
        setCursor(c);

        GameJPanel panel = new GameJPanel();
        panel.setPlayFish(playerFish);
        //不可调节窗口大小
        setResizable(false);
        //剧中显示
        setLocationRelativeTo(null);
        setContentPane(panel);

        getContentPane().addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                //获取鼠标位置，将之前的位置存在oldPoint里面，再将鼠标的位置放到newPoint里
                Point p = e.getPoint();
                playerFish.setOldPoint(playerFish.getNewPoint());
                //让鱼和鼠标一起动，将鼠标放在图片的中心
                playerFish.setNewPoint(new Point(p.x - (playerFish.getWidth()/2 ), p.y - (playerFish.getHeight()/2)));
                playerFish.setDirection(GameUtils.getDirectionByPoint(playerFish));
            }
        });
        //显示窗口
        setVisible(true);
    }
    public static void main(String[] args) {
        GameJFrame gameJFrame = new GameJFrame();
    }
}
