package br.edu.fei.yolo;

import br.edu.fei.yolo.service.classifier.ObjectDetector;
import br.edu.fei.yolo.util.ImageUtil;
import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.videoio.VideoCapture;
import javax.swing.*;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class YoloRunnable {
    static{
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
    }

    static public void main(String args[]){

        Mat frame = new Mat();
        VideoCapture camera = new VideoCapture("/home/ldlopes/Videos/elton.mp4");
        JFrame jframe = new JFrame("Teste LIDA com video");
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel vidpanel = new JLabel();
        jframe.setContentPane(vidpanel);
        jframe.setVisible(true);

        //camera.read(frame);
        //ImageIcon image = new ImageIcon(ImageUtil.mat2BufferedImage(frame));
        //System.out.println(image);

        while (camera.read(frame)) {
            //if (camera.read(frame)) {

                ImageIcon image = new ImageIcon(ImageUtil.mat2BufferedImage(frame));
                vidpanel.setIcon(image);
                vidpanel.repaint();

            ApplicationProperties properties = new ApplicationProperties("/home/ldlopes/Dropbox/Home/Projects/yolo-java/yolo-java/src/main/");
            ObjectDetector objectDetector = new ObjectDetector(properties);

                Map<String, Object> result = objectDetector.detect(frame);
                System.out.println(result);

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch(Exception e){
                e.printStackTrace();
            }

            //}
        }

/*

        ApplicationProperties properties = new ApplicationProperties("/home/ldlopes/Dropbox/Home/Projects/yolo-java/yolo-java/src/main/");
        ObjectDetector objectDetector = new ObjectDetector(properties);
//        String originalImagePath = "C:\\Users\\Windows 10Pro\\Pictures\\";
        String originalImagePath = "/home/ldlopes/Desktop/mestrado/data/";

        String imageName = "people-to-people";
        String imageExtension = ".jpg";

        System.out.println("grafo: " + properties.getGraph());
        System.out.println("label: " + properties.getLabel());
        System.out.println("Tamanho: " + properties.getOutputDir());

        System.out.println("Tamanho: " + properties.getImageSize());
        Map<String, Object> result = objectDetector.detect(originalImagePath + imageName + imageExtension);
*/
    }

}
