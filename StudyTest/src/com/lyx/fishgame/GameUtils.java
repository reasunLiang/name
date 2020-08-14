package com.lyx.fishgame;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.List;

/**
 * @Package: com.lyx.fishgame
 * @ClassName: GameUtils
 * @Author: LYX
 * @CreateTime: 2020/8/4 11:16
 * @Description:
 */
public class GameUtils {
        //键值对
    //获取图片的BuffteredImage对象时，只需要根据图片的名称，就可以获取到
    static final Map<String, BufferedImage> IMAGES = new HashMap<>();

        //鱼的信息，等级，宽高，分数
    static final Map<Integer, String> INFOS = new HashMap<>();

    final static int FRAME_WIDTH = 1184;
    final static int FRAME_HEIGHT = 888;


    //静态代码块，遍历resoure文件的所有文件，并加载到bufferImage中
    static {
        File dir = new File("resource");
        File[] files = dir.listFiles();
        for (File f : files){
            try {
                BufferedImage img = ImageIO.read(f);
                IMAGES.put(f.getName(),img);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //设置鱼的信息参数
        INFOS.put(0,"200 180 3 0");
        INFOS.put(1,"125 105 1 10 8");
        INFOS.put(2,"200 145 4 40 8");
        INFOS.put(3,"180 160 2 20 5");
        INFOS.put(4,"270 120 7 100 6");
        INFOS.put(5,"250 175 2 20 7");
        INFOS.put(6,"240 120 5 60 6");
        INFOS.put(7,"170 105 3 80 5");
        INFOS.put(8,"375 140 8 150 2");
        INFOS.put(9,"190 120 3 30 1");
    }

    public static int getDirectionByPoint(Fish fish){
        if (fish.getNewPoint().x - fish.getOldPoint().x > 0){
            return Fish.DIRECTION_RIGTH;
        }
        else {
            return Fish.DIRECTION_LEFT;
        }
    }

    /**
     * 随机产生一些野鱼
     * @param wildFishes
     */
    public static void initWildFishes(List<Fish> wildFishes){
        Random rand = new Random();
        int count = rand.nextInt(5) + 4;
//        int count = rand.nextInt(2) + 1;
        for(int i = 0; i< count ; i++){
            Fish f = new Fish();
            f.setType(rand.nextInt(9) + 1);
            f.setWholeImg(IMAGES.get(f.getState() + "_" + f.getType() + ".png"));
            String[] s = INFOS.get(f.getType()).split(" ");
            f.setHeight(Integer.parseInt(s[1]));
            f.setWidth(Integer.parseInt(s[0]));
            f.setTotal(f.getWholeImg().getWidth() / f.getWidth());
            //初始位置
            f.setNewPoint(new Point(rand.nextInt(FRAME_WIDTH) + 1,rand.nextInt(FRAME_HEIGHT) + 1));
            f.setSpeed(Integer.parseInt(s[4]));
            f.setTarget(new Point(rand.nextInt(FRAME_WIDTH),rand.nextInt(FRAME_HEIGHT)));
            f.setDirection(f.getTarget().x - f.getNewPoint().x > 0? Fish.DIRECTION_RIGTH : Fish.DIRECTION_LEFT);
            f.setScore(Integer.parseInt(s[3]));
            wildFishes.add(f);
        }
    }

    /**
     * 对图像进行翻转，得到一个水平翻转的图像
     */
    public static BufferedImage getOppoImage(BufferedImage img){
        //System.out.println("在转动中");
        int width = img.getWidth();
        int height = img.getHeight();
        BufferedImage dstImage = new BufferedImage(width, height,2);
        AffineTransform affineTransform = new AffineTransform( -1, 0, 0, 1, width, 0);
        AffineTransformOp affineTransformOp = new AffineTransformOp(affineTransform, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
        return affineTransformOp.filter(img, dstImage);
    }
}
