package test;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ScreenCaptureTest{
	
	public static void main(String[] args) throws AWTException, IOException{
		Robot robot = new Robot();
		BufferedImage image = robot.createScreenCapture(new Rectangle(0, 0, 1920, 1080));
		ImageIO.write(image, "jpg", new File("d:/screenshot.jpg"));
	}
}
