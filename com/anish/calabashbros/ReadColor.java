package com.anish.calabashbros;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.awt.Color;

public class ReadColor {

    private static int colornum = 0;
    
    public static Color[] getColor(String imgpath){
        File file  = new File(imgpath);
        int[] result = null;
        Color[] colors = null;
        colornum = 0;
        if (!file.exists()) {
            return null;
        }
        try {           
            BufferedImage bufImg = ImageIO.read(file);
            int height = bufImg.getHeight();
            int width = bufImg.getWidth();
            int offsetX = (width+15)/16;
            int offsetY = (height+15)/16;
            result = new int[256];
            colors = new Color[256];
            for (int y = 1; y < height; y += offsetY) {
                for (int x = 1; x < width; x += offsetX) {
                    result[colornum] = bufImg.getRGB(x, y)& 0xFFFFFF;//只读取RGB，不管A
                    int rgb = result[colornum];
                    colors[colornum] = new Color(rgb >> 16, (rgb & 0x00ff00) >> 8, rgb & 0x0000ff);                   
                    //System.out.println("RGB: " + rgb + "\nR(" + (rgb >> 16) + ") G(" + ((rgb & 0x00ff00) >> 8) + ") B(" + (rgb & 0x0000ff) + ")");
                    //System.out.println("\033[48;2;" + (rgb >> 16) + ";" + ((rgb & 0x00ff00) >> 8) + ";" + (rgb & 0x0000ff) + "m   \033[0m");  
                    colornum++;                    
                }
            }
             
        } catch (IOException error) {
            error.printStackTrace();
        }
        
        return colors;
    }
}

   