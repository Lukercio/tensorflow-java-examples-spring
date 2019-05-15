package br.edu.fei.yolo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

// Reading from yolo.properties file
public class ApplicationProperties {
    private String graph;
    private String label;
    private String outputDir;
    private String uploadDir;
    private Integer imageSize;
    private Float imageMean;
    //private String path = "C:\\Users\\Windows 10Pro\\IdeaProjects\\yolo-java\\src\\main\\";
    private String path = "/home/ldlopes/Dropbox/Home/Projects/yolo-java/yolo-java/src/main/";


    private InputStream input;
    private Properties prop = new Properties();


    ApplicationProperties(){
        try {
            //input = new FileInputStream(path + "resources\\yolo.properties");
            input = new FileInputStream(path + "resources/yolo.properties");

            prop.load(input);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    ApplicationProperties(String path){
        try {
//            input = new FileInputStream(path + "resources\\yolo.properties");
            input = new FileInputStream(path + "resources/yolo.properties");

            prop.load(input);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public String getGraph () { return prop.getProperty("graph"); }

    public void setGraph (String graph){ prop.setProperty("graph", graph);}

    public String getLabel () { return prop.getProperty("label");}

    public void setLabel (String label){ prop.setProperty("label", label);}

    public String getOutputDir () { return prop.getProperty("outputDir");}

    public void setOutputDir (String outputDir){ prop.setProperty("outputDir", outputDir);}

    public String getUploadDir () { return prop.getProperty("uploadDir");}

    public void setUploadDir (String uploadDir){ prop.setProperty("uploadDir", uploadDir);}

    public Integer getImageSize () { return Integer.parseInt(prop.getProperty("imageSize"));}

    public void setImageSize (Integer imageSize){ prop.setProperty("imageSize", imageSize.toString());}

    public Float getImageMean () { return Float.parseFloat(prop.getProperty("imageMean"));}

    public void setImageMean (Float imageMean){ prop.setProperty("imageMean", imageMean.toString());}

}
