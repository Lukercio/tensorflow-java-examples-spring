package br.edu.fei.yolo;

import br.edu.fei.yolo.service.classifier.ObjectDetector;

import java.util.Map;

public class YoloRunnable {

    static public void main(String args[]){
        ApplicationProperties properties = new ApplicationProperties("C:\\Users\\Windows 10Pro\\IdeaProjects\\yolo-java\\src\\main\\");
        ObjectDetector objectDetector = new ObjectDetector(properties);
        String originalImagePath = "C:\\Users\\Windows 10Pro\\Pictures\\";
        String imageName = "people-to-people";
        String imageExtension = ".jpg";

        System.out.println("grafo: " + properties.getGraph());
        System.out.println("label: " + properties.getLabel());
        System.out.println("Tamanho: " + properties.getOutputDir());

        System.out.println("Tamanho: " + properties.getImageSize());
        Map<String, Object> result = objectDetector.detect(originalImagePath + imageName + imageExtension);

    }
}
