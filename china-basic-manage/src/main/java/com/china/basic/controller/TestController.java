package com.china.basic.controller;

import com.china.common.common.ResultRespose;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xslf.usermodel.XSLFSlide;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;

@Slf4j
@Api(tags = "test接口")
@RestController
@RequestMapping("/test")
public class TestController {
    @GetMapping("/getQrCode")
    private ResultRespose<?> getQrCode(){
        try {
            FileInputStream pptFile = new FileInputStream("C:\\Users\\Administrator\\Downloads\\1234.pptx");

            XMLSlideShow ppt = new XMLSlideShow(pptFile);
            int slideNumber = 1;
            for (XSLFSlide slide : ppt.getSlides()) {
                int height = (int) slide.getSlideShow().getPageSize().getHeight();
                int width = (int) slide.getSlideShow().getPageSize().getWidth();

                BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
                Graphics2D graphics = image.createGraphics();
                Graphics g2 = image.getGraphics();
                g2.drawString( "tidekong ",5,5);
                if   (g2!=null){
                    g2.dispose();
                }
                slide.draw(graphics);
                ImageIO.write(image, "png", new File("D://123//" + slideNumber + ".png"));
                slideNumber++;
            }

            System.out.println(ppt);
        }catch (Exception e){
            e.printStackTrace();
        }
        return ResultRespose.success();
    }
}
