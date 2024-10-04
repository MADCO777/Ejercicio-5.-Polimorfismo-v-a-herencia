package SistemaZoologico;

public abstract class Ave extends Animal {
    protected double envergaduraAlas;
    protected String tipoPico;
    protected boolean esVoladora;
    protected String colorPlumaje;
    protected int cantidadHuevos;
    protected double peso;
    protected String dieta;

    public Ave(String nombreCientifico, String habitat, int esperanzaVida,
               double envergaduraAlas, String tipoPico, boolean esVoladora,
               String colorPlumaje, int cantidadHuevos, double peso, String dieta) {
        super(nombreCientifico, habitat, esperanzaVida);
        this.envergaduraAlas = envergaduraAlas;
        this.tipoPico = tipoPico;
        this.esVoladora = esVoladora;
        this.colorPlumaje = colorPlumaje;
        this.cantidadHuevos = cantidadHuevos;
        this.peso = peso;
        this.dieta = dieta;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nEnvergadura de alas: " + envergaduraAlas + " metros" +
                "\nTipo de pico: " + tipoPico +
                "\nEs voladora: " + (esVoladora ? "Sí" : "No") +
                "\nColor del plumaje: " + colorPlumaje +
                "\nCantidad promedio de huevos: " + cantidadHuevos +
                "\nPeso: " + peso + " kg" +
                "\nDieta: " + dieta;
    }
}