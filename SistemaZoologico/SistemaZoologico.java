package SistemaZoologico;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SistemaZoologico {
    private List<Animal> animales;
    private double presupuestoAnual;

    public SistemaZoologico() {
        this.animales = new ArrayList<>();
        this.presupuestoAnual = 0;
    }

    public void agregarAnimal(Animal animal) {
        animales.add(animal);
        System.out.println("Animal agregado con éxito.");
    }

    public void eliminarAnimal(String nombreCientifico) {
        animales.removeIf(animal -> animal.nombreCientifico.equals(nombreCientifico));
        System.out.println("Animal eliminado con éxito (si existía).");
    }

    public void mostrarTodosLosAnimales() {
        for (Animal animal : animales) {
            System.out.println("\n--- Información del Animal ---");
            System.out.println(animal);
            System.out.println("Espacio necesario: " + animal.calcularEspacioNecesario() + " m²");
            System.out.println("Comida diaria: " + animal.calcularComidaDiaria() + " g");
            System.out.println("Costo de mantenimiento diario: Q" + animal.calcularCostoMantenimientoDiario());
            System.out.println("-----------------------------");
        }
    }

    public void consultarAnimal(String nombreCientifico) {
        for (Animal animal : animales) {
            if (animal.nombreCientifico.equals(nombreCientifico)) {
                System.out.println("\n--- Información del Animal ---");
                System.out.println(animal);
                System.out.println("Espacio necesario: " + animal.calcularEspacioNecesario() + " m²");
                System.out.println("Comida diaria: " + animal.calcularComidaDiaria() + " g");
                System.out.println("Costo de mantenimiento diario: Q" + animal.calcularCostoMantenimientoDiario());
                System.out.println("-----------------------------");
                return;
            }
        }
        System.out.println("Animal no encontrado.");
    }

    public void setPresupuestoAnual(double presupuesto) {
        this.presupuestoAnual = presupuesto;
        System.out.println("Presupuesto anual establecido: Q" + presupuesto);
    }

    public void evaluarNuevoEjemplar(Animal animal, double costoRecinto) {
        double costoAnual = animal.calcularCostoMantenimientoDiario() * 365 + costoRecinto;
        double espacioNecesario = animal.calcularEspacioNecesario();

        System.out.println("\n--- Evaluación de Nuevo Ejemplar ---");
        System.out.println("Espacio necesario: " + espacioNecesario + " m²");
        System.out.println("Costo anual estimado: Q" + costoAnual);
        System.out.println("Presupuesto disponible: Q" + presupuestoAnual);

        if (costoAnual <= presupuestoAnual) {
            System.out.println("Recomendación: Se tienen condiciones para recibir al ejemplar.");
        } else {
            System.out.println("Recomendación: No se tienen condiciones suficientes para recibir al ejemplar.");
        }
        System.out.println("-----------------------------");
    }

    public static void main(String[] args) {
        SistemaZoologico sistema = new SistemaZoologico();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Menú del Sistema de Zoológico ---");
            System.out.println("1. Agregar animal");
            System.out.println("2. Eliminar animal");
            System.out.println("3. Mostrar todos los animales");
            System.out.println("4. Consultar animal específico");
            System.out.println("5. Establecer presupuesto anual");
            System.out.println("6. Evaluar nuevo ejemplar");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    System.out.println("¿Qué tipo de ave desea agregar? (1: Voladora, 2: No Voladora)");
                    int tipoAve = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea

                    System.out.print("Nombre científico: ");
                    String nombreCientifico = scanner.nextLine();
                    System.out.print("Hábitat: ");
                    String habitat = scanner.nextLine();
                    System.out.print("Esperanza de vida (años): ");
                    int esperanzaVida = scanner.nextInt();
                    System.out.print("Envergadura de alas (metros): ");
                    double envergaduraAlas = scanner.nextDouble();
                    scanner.nextLine(); // Consumir el salto de línea
                    System.out.print("Tipo de pico: ");
                    String tipoPico = scanner.nextLine();
                    System.out.print("Color del plumaje: ");
                    String colorPlumaje = scanner.nextLine();
                    System.out.print("Cantidad promedio de huevos: ");
                    int cantidadHuevos = scanner.nextInt();
                    System.out.print("Peso (kg): ");
                    double peso = scanner.nextDouble();
                    scanner.nextLine(); // Consumir el salto de línea
                    System.out.print("Dieta: ");
                    String dieta = scanner.nextLine();

                    if (tipoAve == 1) {
                        System.out.print("Velocidad de vuelo (km/h): ");
                        double velocidadVuelo = scanner.nextDouble();
                        System.out.print("Altura máxima de vuelo (metros): ");
                        double alturaMaximaVuelo = scanner.nextDouble();
                        System.out.print("¿Es migratoria? (true/false): ");
                        boolean esMigratoria = scanner.nextBoolean();

                        sistema.agregarAnimal(new AveVoladora(nombreCientifico, habitat, esperanzaVida,
                                envergaduraAlas, tipoPico, colorPlumaje, cantidadHuevos, peso, dieta,
                                velocidadVuelo, alturaMaximaVuelo, esMigratoria));
                    } else {
                        System.out.print("Velocidad de desplazamiento (km/h): ");
                        double velocidadDesplazamiento = scanner.nextDouble();
                        scanner.nextLine(); // Consumir el salto de línea
                        System.out.print("Tipo de desplazamiento (terrestre/acuático): ");
                        String tipoDesplazamiento = scanner.nextLine();

                        sistema.agregarAnimal(new AveNoVoladora(nombreCientifico, habitat, esperanzaVida,
                                envergaduraAlas, tipoPico, colorPlumaje, cantidadHuevos, peso, dieta,
                                velocidadDesplazamiento, tipoDesplazamiento));
                    }
                    break;
                case 2:
                    System.out.print("Ingrese el nombre científico del animal a eliminar: ");
                    String nombreEliminar = scanner.nextLine();
                    sistema.eliminarAnimal(nombreEliminar);
                    break;
                case 3:
                    sistema.mostrarTodosLosAnimales();
                    break;
                case 4:
                    System.out.print("Ingrese el nombre científico del animal a consultar: ");
                    String nombreConsultar = scanner.nextLine();
                    sistema.consultarAnimal(nombreConsultar);
                    break;
                case 5:
                    System.out.print("Ingrese el presupuesto anual: ");
                    double presupuesto = scanner.nextDouble();
                    sistema.setPresupuestoAnual(presupuesto);
                    break;
                case 6:
                    System.out.println("Ingrese los datos del nuevo ejemplar:");
                    System.out.println("¿Qué tipo de ave es? (1: Voladora, 2: No Voladora)");
                    int tipoAveNueva = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea

                    System.out.print("Nombre científico: ");
                    String nombreCientificoNuevo = scanner.nextLine();
                    System.out.print("Hábitat: ");
                    String habitatNuevo = scanner.nextLine();
                    System.out.print("Esperanza de vida (años): ");
                    int esperanzaVidaNueva = scanner.nextInt();
                    System.out.print("Envergadura de alas (metros): ");
                    double envergaduraAlasNueva = scanner.nextDouble();
                    scanner.nextLine(); // Consumir el salto de línea
                    System.out.print("Tipo de pico: ");
                    String tipoPicoNuevo = scanner.nextLine();
                    System.out.print("Color del plumaje: ");
                    String colorPlumajeNuevo = scanner.nextLine();
                    System.out.print("Cantidad promedio de huevos: ");
                    int cantidadHuevosNueva = scanner.nextInt();
                    System.out.print("Peso (kg): ");
                    double pesoNuevo = scanner.nextDouble();
                    scanner.nextLine(); // Consumir el salto de línea
                    System.out.print("Dieta: ");
                    String dietaNueva = scanner.nextLine();

                    Animal nuevoEjemplar;
                    if (tipoAveNueva == 1) {
                        System.out.print("Velocidad de vuelo (km/h): ");
                        double velocidadVueloNueva = scanner.nextDouble();
                        System.out.print("Altura máxima de vuelo (metros): ");
                        double alturaMaximaVueloNueva = scanner.nextDouble();
                        System.out.print("¿Es migratoria? (true/false): ");
                        boolean esMigratoriaNueva = scanner.nextBoolean();

                        nuevoEjemplar = new AveVoladora(nombreCientificoNuevo, habitatNuevo, esperanzaVidaNueva,
                                envergaduraAlasNueva, tipoPicoNuevo, colorPlumajeNuevo, cantidadHuevosNueva,
                                pesoNuevo, dietaNueva, velocidadVueloNueva, alturaMaximaVueloNueva, esMigratoriaNueva);
                    } else {
                        System.out.print("Velocidad de desplazamiento (km/h): ");
                        double velocidadDesplazamientoNueva = scanner.nextDouble();
                        scanner.nextLine(); // Consumir el salto de línea
                        System.out.print("Tipo de desplazamiento (terrestre/acuático): ");
                        String tipoDesplazamientoNuevo = scanner.nextLine();

                        nuevoEjemplar = new AveNoVoladora(nombreCientificoNuevo, habitatNuevo, esperanzaVidaNueva,
                                envergaduraAlasNueva, tipoPicoNuevo, colorPlumajeNuevo, cantidadHuevosNueva,
                                pesoNuevo, dietaNueva, velocidadDesplazamientoNueva, tipoDesplazamientoNuevo);
                    }

                    System.out.print("Ingrese el costo de construcción del recinto: ");
                    double costoRecinto = scanner.nextDouble();

                    sistema.evaluarNuevoEjemplar(nuevoEjemplar, costoRecinto);
                    break;
                case 7:
                    System.out.println("Gracias por usar el Sistema de Gestión del Zoológico La Aurora. ¡Hasta pronto!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
            }
        }
    }
}