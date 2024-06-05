package com.triangle;

import com.exception.TriangleExceptionNotCreate;

public class Triangulo {

    private double ladoA, ladoB, ladoC;
    private String tipo;
    private double area;
    private double perimetro;

    public Triangulo() {
    }

    public Triangulo(double ladoA, double ladoB, double ladoC) throws TriangleExceptionNotCreate {
        if (esTriangulo(ladoA, ladoB, ladoC)) {
            this.ladoA = ladoA;
            this.ladoB = ladoB;
            this.ladoC = ladoC;
            this.tipo = calcularTipo();
            this.area = calcularArea();
            this.perimetro = calcularPerimetro();
        } else {
            throw new TriangleExceptionNotCreate(
                    "El triángulo no puede ser creado con los lados o dimensiones [" + ladoA + ", " + ladoB + ", "
                            + ladoC + "] proporcionados.");
        }
    }

    public boolean esTriangulo(double ladoA, double ladoB, double ladoC) {
        return (ladoA + ladoB > ladoC) && (ladoA + ladoC > ladoB) && (ladoB + ladoC > ladoA);
    }

    public String calcularTipo() {
        if (ladoA == ladoB && ladoB == ladoC) {
            return "Equilátero";
        } else if (ladoA == ladoB || ladoA == ladoC || ladoB == ladoC) {
            return "Isósceles";
        } else {
            return "Escaleno";
        }
    }

    public double calcularArea() {
        double s = (ladoA + ladoB + ladoC) / 2;
        return Math.sqrt(s * (s - ladoA) * (s - ladoB) * (s - ladoC));
    }

    public double calcularPerimetro() {
        return ladoA + ladoB + ladoC;
    }

    public double getLadoA() {
        return ladoA;
    }

    public double getLadoB() {
        return ladoB;
    }

    public double getLadoC() {
        return ladoC;
    }

    public String getTipo() {
        return tipo;
    }

    public double getArea() {
        return area;
    }

    public double getPerimetro() {
        return perimetro;
    }

    public void setLadoA(double ladoA) {
        this.ladoA = ladoA;
    }

    public void setLadoB(double ladoB) {
        this.ladoB = ladoB;
    }

    public void setLadoC(double ladoC) {
        this.ladoC = ladoC;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public void setPerimetro(double perimetro) {
        this.perimetro = perimetro;
    }

    @Override
    public String toString() {
        return "Triangulo [area=" + area + ", ladoA=" + ladoA + ", ladoB=" + ladoB + ", ladoC=" + ladoC + ", perimetro="
                + perimetro + ", tipo=" + tipo + "]";
    }

    public static void main(String[] args) {
        try {
            Triangulo t = new Triangulo(14, 14, 14);
            System.out.println(t);
        } catch (TriangleExceptionNotCreate e) {
            e.printStackTrace();
        }
    }

}
