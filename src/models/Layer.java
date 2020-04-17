package models;

public class Layer {
    private String name;
    private Double layerThickness;
    private Double lambda;

    public Layer(String name, Double layerThickness, Double lambda) {
        this.name = name;
        this.layerThickness = layerThickness;
        this.lambda = lambda;
    }

    public Layer(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getLayerThickness() {
        return layerThickness;
    }

    public void setLayerThickness(Double layerThickness) {
        this.layerThickness = layerThickness;
    }

    public Double getLambda() {
        return lambda;
    }

    public void setLambda(Double lambda) {
        this.lambda = lambda;
    }
}
