import java.util.Scanner;

// Aplicación principal
public class ClinicaContigoAprendo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1) Crear un objeto de tipo Paciente - Respetar los requerimientos solicitado.
        System.out.print("Ingrese el RUT del paciente: ");
        String rut = scanner.nextLine();
        System.out.print("Ingrese el nombre del paciente: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese la edad del paciente: ");
        int edad = scanner.nextInt();
        System.out.print("Ingrese el sexo del paciente (F/M): ");
        char sexo = scanner.next().charAt(0);
        Paciente paciente = new Paciente(rut, nombre, edad, sexo);

        boolean continuar = true;
        while (continuar) {
            System.out.println("\nOpciones:");
            System.out.println("1) Mostrar todos los atributos del paciente");
            System.out.println("2) Mostrar el mes con menor peso del paciente");
            System.out.println("3) Verificar meses con peso menor a X kilos");
            System.out.println("4) Ver estado del paciente en noviembre");
            System.out.println("5) Salir");
            System.out.print("Seleccione una opción y luego haga Enter: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    // Mostrar todos los atributos del paciente
                    System.out.println("Rut: " + paciente.getRut());
                    System.out.println("Nombre: " + paciente.getNombre());
                    System.out.println("Edad: " + paciente.getEdad());
                    System.out.println("Sexo: " + paciente.getSexo());
                    System.out.print("Pesos mensuales es: ");
                    for (int peso : paciente.getPesosMensuales()) {
                        System.out.print(peso + " ");
                    }
                    System.out.println();
                    break;

                case 2:
                    // Mostrar el mes con menor peso del paciente consultado.
                    int mesMenorPeso = paciente.menorPesoMensual();
                    System.out.println("El mes con menor peso es el mes " + (mesMenorPeso + 1) + " con " + paciente.getPesosMensuales()[mesMenorPeso] + " kilos.");
                    break;

                case 3:
                    // Comparar con un peso ingresado por el usuario en prueba.
                    System.out.print("Ingrese un peso para comparar: ");
                    int pesoComparar = scanner.nextInt();
                    int[] mesesMenores = paciente.menosDeXKilos(pesoComparar);
                    if (mesesMenores != null) {
                        System.out.print("Meses con menor peso a " + pesoComparar + " kg: ");
                        for (int mes : mesesMenores) {
                            System.out.print((mes + 1) + " ");
                        }
                        System.out.println();
                    } else {
                        System.out.println("El paciente no llego a pesar menos que esto " + pesoComparar + " kg.");
                    }
                    break;

                case 4:
                    // Estado del paciente en noviembre
                    System.out.print("Ingrese la estatura del paciente en metros (por ejemplo, 1.75): ");
                    double estatura = scanner.nextDouble();
                    String condicionNoviembre = paciente.pesoMesX(10, estatura); // Mes 10 corresponde a noviembre
                    System.out.println("La condición del paciente en noviembre: " + condicionNoviembre);
                    break;

                case 5:
                    continuar = false;
                    System.out.println("Saliendo!!!!");
                    break;

                default:
                    System.out.println("Opción no válida, ingrese nuevamente.");
                    break;
            }
        }
        scanner.close();
    }
}
