package models;

public class Layer {
    private Material material;
    private Double layerThickness;
    private Double lambda;

    public Layer(Material material, Double layerThickness, Double lambda) {
        this.material = material;
        this.layerThickness = layerThickness;
        this.lambda = lambda;
    }

    public Layer(){}

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
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

    @Override
    public String toString() {
        return "Layer{" +
                "material=" + material +
                ", layerThickness=" + layerThickness +
                ", lambda=" + lambda +
                '}';
    }

}
