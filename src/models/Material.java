package models;

public class Material {

    private int id;
    private String name;
    private String type;
    private Double coefficientA;
    private Double coefficientB;
    private Double coefficientC;
    private Double density;

    public Material() {
    }

    public Material(int id, String name, String type, Double coefficientA, Double coefficientB, Double coefficientC, Double density) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.coefficientA = coefficientA;
        this.coefficientB = coefficientB;
        this.coefficientC = coefficientC;
        this.density = density;
    }

    public Material(String name, String type, Double coefficientA, Double coefficientB, Double coefficientC, Double density) {
        this.name = name;
        this.type = type;
        this.coefficientA = coefficientA;
        this.coefficientB = coefficientB;
        this.coefficientC = coefficientC;
        this.density = density;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getCoefficientA() {
        return coefficientA;
    }

    public void setCoefficientA(Double coefficientA) {
        this.coefficientA = coefficientA;
    }

    public Double getCoefficientB() {
        return coefficientB;
    }

    public void setCoefficientB(Double coefficientB) {
        this.coefficientB = coefficientB;
    }

    public Double getCoefficientC() {
        return coefficientC;
    }

    public void setCoefficientC(Double coefficientC) {
        this.coefficientC = coefficientC;
    }

    public Double getDensity() {
        return density;
    }

    public void setDensity(Double density) {
        this.density = density;
    }

    @Override
    public String toString() {
        return name;
    }
}