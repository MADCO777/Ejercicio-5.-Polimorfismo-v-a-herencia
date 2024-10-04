package SistemaZoologico;

public class AveVoladora extends Ave {
    private double velocidadVuelo;
    private double alturaMaximaVuelo;
    private boolean esMigratoria;

    public AveVoladora(String nombreCientifico, String habitat, int esperanzaVida,
                       double envergaduraAlas, String tipoPico, String colorPlumaje,
                       int cantidadHuevos, double peso, String dieta,
                       double velocidadVuelo, double alturaMaximaVuelo, boolean esMigratoria) {
        super(nombreCientifico, habitat, esperanzaVida, envergaduraAlas, tipoPico, true,
                colorPlumaje, cantidadHuevos, peso, dieta);
        this.velocidadVuelo = velocidadVuelo;
        this.alturaMaximaVuelo = alturaMaximaVuelo;
        this.esMigratoria = esMigratoria;
    }

    @Override
    public String getTipo() {
        return "Ave Voladora";
    }

    @Override
    public double calcularEspacioNecesario() {
        return Math.max(5, 5 * envergaduraAlas * envergaduraAlas);
    }

    @Override
    public double calcularComidaDiaria() {
        if (peso < 0.2) return peso * 0.25;
        else if (peso < 0.8) return peso * 0.15;
        else if (peso < 7) return peso * 0.1;
        else return peso * 0.035;
    }

    @Override
    public double calcularCostoMantenimientoDiario() {
        double costoBase;
        if (peso < 0.2) costoBase = 150;
        else if (peso < 0.8) costoBase = 200;
        else if (peso < 7) costoBase = 300;
        else costoBase = 500;
        return costoBase + calcularComidaDiaria() * 2; // Asumimos un costo de 2 quetzales por gramo de comida
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nVelocidad de vuelo: " + velocidadVuelo + " km/h" +
                "\nAltura máxima de vuelo: " + alturaMaximaVuelo + " metros" +
                "\nEs migratoria: " + (esMigratoria ? "Sí" : "No");
    }
}