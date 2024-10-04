package SistemaZoologico;

public class AveNoVoladora extends Ave {
    private double velocidadDesplazamiento;
    private String tipoDesplazamiento;

    public AveNoVoladora(String nombreCientifico, String habitat, int esperanzaVida,
                         double envergaduraAlas, String tipoPico, String colorPlumaje,
                         int cantidadHuevos, double peso, String dieta,
                         double velocidadDesplazamiento, String tipoDesplazamiento) {
        super(nombreCientifico, habitat, esperanzaVida, envergaduraAlas, tipoPico, false,
                colorPlumaje, cantidadHuevos, peso, dieta);
        this.velocidadDesplazamiento = velocidadDesplazamiento;
        this.tipoDesplazamiento = tipoDesplazamiento;
    }

    @Override
    public String getTipo() {
        return "Ave No Voladora";
    }

    @Override
    public double calcularEspacioNecesario() {
        if (tipoDesplazamiento.equalsIgnoreCase("terrestre")) {
            if (peso > 100) return 800; // Recinto grande para aves terrestres grandes
            else if (peso > 50) return 450; // Recinto mediano
            else return 200; // Recinto pequeño
        } else if (tipoDesplazamiento.equalsIgnoreCase("acuático")) {
            if (peso > 50) return 300; // Recinto grande para aves acuáticas
            else if (peso > 20) return 150; // Recinto mediano
            else return 50; // Recinto pequeño
        } else { // Pingüinos
            if (peso > 30) return 225; // Recinto grande para pingüinos
            else if (peso > 15) return 100; // Recinto mediano
            else return 25; // Recinto pequeño
        }
    }

    @Override
    public double calcularComidaDiaria() {
        if (envergaduraAlas < 0.5) return 50;
        else if (envergaduraAlas < 0.7) return 150;
        else if (envergaduraAlas < 1.0) return 350;
        else if (envergaduraAlas < 1.5) return 600;
        else return 1200;
    }

    @Override
    public double calcularCostoMantenimientoDiario() {
        double costoBase;
        if (peso < 1.5) costoBase = 150;
        else if (peso < 3.5) costoBase = 200;
        else if (peso < 12) costoBase = 300;
        else costoBase = 500;
        return costoBase + calcularComidaDiaria() * 2; // Asumimos un costo de 2 quetzales por gramo de comida
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nVelocidad de desplazamiento: " + velocidadDesplazamiento + " km/h" +
                "\nTipo de desplazamiento: " + tipoDesplazamiento;
    }
}