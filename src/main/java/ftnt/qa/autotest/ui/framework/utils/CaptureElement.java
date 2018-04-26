package ftnt.qa.autotest.ui.framework.utils;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.internal.WrapsDriver;

public class CaptureElement {

    public static File captureElement(WebElement element) throws Exception {
        WrapsDriver wrapsDriver = (WrapsDriver) element;
        File elementFile = ((TakesScreenshot) wrapsDriver.getWrappedDriver()).getScreenshotAs(OutputType.FILE);
        BufferedImage img = ImageIO.read(elementFile);
        int width = element.getSize().getWidth();
        int height = element.getSize().getHeight();
        Rectangle rect = new Rectangle(width, height);
        Point p = element.getLocation();
        BufferedImage dest = img.getSubimage(p.getX(), p.getY(), rect.width, rect.height);
        ImageIO.write(dest, "png", elementFile);
        return elementFile;
    }

}