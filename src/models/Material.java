package models;

public class Material {

    private String name;
    private int type;
    private double A;
    private double B;
    private double C;
    private double plotnost;

    public Material() {
    }

    public Material(String name, int type, double a, double b, double c, double plotnost) {
        this.name = name;
        this.type = type;
        A = a;
        B = b;
        C = c;
        this.plotnost = plotnost;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public double getA() {
        return A;
    }

    public void setA(double a) {
        A = a;
    }

    public double getB() {
        return B;
    }

    public void setB(double b) {
        B = b;
    }

    public double getC() {
        return C;
    }

    public void setC(double c) {
        C = c;
    }

    public double getPlotnost() {
        return plotnost;
    }

    public void setPlotnost(double plotnost) {
        this.plotnost = plotnost;
    }

    @Override
    public String toString() {
        return "Material{" +
                "name='" + name + '\'' +
                ", type=" + type +
                ", A=" + A +
                ", B=" + B +
                ", C=" + C +
                ", plotnost=" + plotnost +
                '}';
    }
}