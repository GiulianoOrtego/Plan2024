import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

class Paciente {
    private String rut;
    private String nombre;
    private int edad;
    private char sexo;
    private int[] pesosMensuales = new int[12];

    // Constructor
    public Paciente(String rut, String nombre, int edad, char sexo) {
        this.rut = rut;
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = sexo;
        Random random = new Random();
        for (int i = 0; i < 12; i++) {
            this.pesosMensuales[i] = 70 + random.nextInt(181); // Peso en el rango [70, 250]
        }
    }

    // Accesadores y mutadores
    public String getRut() { return rut; }
    public void setRut(String rut) { this.rut = rut; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public int getEdad() { return edad; }
    public void setEdad(int edad) { this.edad = edad; }

    public char getSexo() { return sexo; }
    public void setSexo(char sexo) { this.sexo = sexo; }

    public int[] getPesosMensuales() { return pesosMensuales; }
    public void setPesosMensuales(int[] pesosMensuales) { this.pesosMensuales = pesosMensuales; }

    // Retorna el mes (0-11) en que el paciente pesó menos kilos
    public int menorPesoMensual() {
        int mesMenorPeso = 0;
        for (int i = 1; i < pesosMensuales.length; i++) {
            if (pesosMensuales[i] < pesosMensuales[mesMenorPeso]) {
                mesMenorPeso = i;
            }
        }
        return mesMenorPeso;
    }

    // Calcula el índice de masa corporal (IMC) para un mes específico
    public double indiceMasaCorporal(int mes, double estatura) {
        if (mes < 0 || mes >= pesosMensuales.length) {
            throw new IllegalArgumentException("Mes inválido");
        }
        return pesosMensuales[mes] / (estatura * estatura);
    }

    // Retorna un array con los meses en los que el paciente pesó menos de X kilos
    public int[] menosDeXKilos(int x) {
        ArrayList<Integer> meses = new ArrayList<>();
        for (int i = 0; i < pesosMensuales.length; i++) {
            if (pesosMensuales[i] < x) {
                meses.add(i);
            }
        }
        if (meses.isEmpty()) {
            return null;
        }
        return meses.stream().mapToInt(Integer::intValue).toArray();
    }

    // Retorna la condición (normal, sobrepeso, obeso) basada en el IMC para un mes dado
    public String pesoMesX(int mes, double estatura) {
        double imc = indiceMasaCorporal(mes, estatura);
        if (imc >= 15 && imc < 20) {
            return "Normal";
        } else if (imc >= 20 && imc < 28) {
            return "Sobrepeso";
        } else {
            return "Obeso";
        }
    }
}

