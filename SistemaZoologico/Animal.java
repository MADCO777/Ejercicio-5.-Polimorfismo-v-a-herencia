package SistemaZoologico;

public abstract class Animal {
    protected String nombreCientifico;
    protected String habitat;
    protected int esperanzaVida;

    public Animal(String nombreCientifico, String habitat, int esperanzaVida) {
        this.nombreCientifico = nombreCientifico;
        this.habitat = habitat;
        this.esperanzaVida = esperanzaVida;
    }

    public abstract String getTipo();
    public abstract double calcularEspacioNecesario();
    public abstract double calcularComidaDiaria();
    public abstract double calcularCostoMantenimientoDiario();

    @Override
    public String toString() {
        return "Nombre científico: " + nombreCientifico +
                "\nHábitat: " + habitat +
                "\nEsperanza de vida: " + esperanzaVida + " años";
    }
}