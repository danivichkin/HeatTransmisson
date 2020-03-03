package models;

public class Material {

    private String name;
    private int type;
    private int A;
    private int B;
    private int C;
    private int plotnost;

    public Material(String name, int type, int a, int b, int c, int plotnost) {
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

    public int getA() {
        return A;
    }

    public void setA(int a) {
        A = a;
    }

    public int getB() {
        return B;
    }

    public void setB(int b) {
        B = b;
    }

    public int getC() {
        return C;
    }

    public void setC(int c) {
        C = c;
    }

    public int getPlotnost() {
        return plotnost;
    }

    public void setPlotnost(int plotnost) {
        this.plotnost = plotnost;
    }
}
