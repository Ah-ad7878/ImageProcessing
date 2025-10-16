package org.pk.cas.image;

import java.awt.image.BufferedImage;

public class Main {
    public static void main(String[] args) {
        BufferedImage tv = null,car = null;
        tv = ImageProcessingByOOp.tvPic("F:/tvpic.jpg");
        car = ImageProcessingByOOp.carPic("F:/Supra.jpg");
        BufferedImage result = ImageProcessingByOOp.effectOnImage(tv);

        ImageProcessingByOOp.writePic(result,"jpg","F:/tvpic4.jpg");

    }
}
