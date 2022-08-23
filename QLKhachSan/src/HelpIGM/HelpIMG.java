/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HelpIGM;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author Lenovo
 */
public class HelpIMG {
public static ImageIcon reSizeImg(ImageIcon icon, int scaleWidth, int scaleHeight) {
        Image image = icon.getImage();
        double height = icon.getIconHeight();
        double width = icon.getIconWidth();
        if (icon.getIconWidth() > scaleWidth ) {
            width = scaleWidth;
            height = (scaleWidth * icon.getIconHeight()) / icon.getIconWidth();
        }
        else if (icon.getIconHeight() > scaleHeight) {
            height = scaleHeight;
            width = (scaleWidth * icon.getIconHeight()) / icon.getIconHeight();
        }
        Image newimg = image.getScaledInstance((int) width, (int) height, java.awt.Image.SCALE_SMOOTH);
        return new ImageIcon(newimg);
    }
}
