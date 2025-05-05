package ejemplosClase;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class LabTALLERJAVA5CONTROLFLOW {
    public static void costco(){
        //Declarando a scanner
        Scanner scanner = new Scanner(System.in);
        // pedir el valor TOTAL de la compra
        System.out.println("Ingresa valor TOTAL de tu compra: $");
        // recibimos y guardamos el numero que da el usuario
        double totalCompra = scanner.nextDouble();

        // pedir la cantidad de productos
        System.out.println("Ingresa cuantos productos compraste(en numero): ");
        // recibimos y guardamos el numero que da el usuario
        int cantidadProductos = scanner.nextInt();

        // se limpia nextLine
        scanner.nextLine();

        //Pregunta al usuario si tiene menbresía
        System.out.println("¿Tienes nuestra membresía? ¿Sí o no?");
        // recibimos y guardamos la respuesta
        String membresia = scanner.nextLine();

        // Nueva variable totalFinal
        double totalFinal = totalCompra;

        //IF para los descuentos
        // primer descuento - membresía 10%
        if (membresia.toLowerCase().equals("si")){
            //aplica el primer descuento
            totalFinal = totalFinal * 0.90;
        }

        // segundo descuento + de 10 productos
        if (cantidadProductos >= 11) {
            //aplica el segundo descuento
            totalFinal = totalFinal * 0.95;
        }

        System.out.println("Tu total a pagar es: $" + totalFinal);
    }

    public static void Veterinaria (){
        //Declarando a scanner
        Scanner scanner = new Scanner(System.in);

        // preguntar el tipo mascota && declarar la variable
        System.out.println("¿Qué mascota llega (perro, gato, ave, otro)?: ");
        String tipoMascota = scanner.nextLine().toLowerCase();

        // preguntar edad && declarar la variable
        System.out.println("¿Cuántos años tiene la mascota?: ");
        int edadMascota = scanner.nextInt();

        // se limpia nextLine
        scanner.nextLine();

        // Variable vacía para dar respuesta a los ifs para dar el veterinario indicado
        String veterinario = "";

        // que veterinario es el indicado
        if (tipoMascota.equals("perro") || tipoMascota.equals("gato")) {
            veterinario = "Veterinario general";
        } else if (tipoMascota.equals("ave")) {
            veterinario = "Veterinario aviar";
        } else if (tipoMascota.equals("otro")) {
            veterinario = "Veterinario especializado";
        }
        // Print que veterinario es el indicado
        System.out.println("El veterinario asignado es: " + veterinario);

        // necesita vacunación segun la edad
        if ((tipoMascota.equals("perro") || tipoMascota.equals("gato")) && edadMascota > 5) {
            System.out.println("Recomendamos vacunación.");
        } else if ((tipoMascota.equals("perro") || tipoMascota.equals("gato")) && edadMascota <= 5) {
            System.out.println("Aun no recomienda vacunación.");
        }
    }

    public static void Parqueadero (){
        //Declarando a scanner
        Scanner scanner = new Scanner(System.in);
        //Declarando a formatter, se usa para analizar horas
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

        // preguntar tipo vehiculo && declarar la variable
        System.out.println("¿Qué vehículo es (auto, moto, bici)?: ");
        String tipoVehiculo = scanner.nextLine().toLowerCase();

        //Declara hora de llegada tipo LocalTime (hora sin fecha) null variable vacía
        LocalTime horaLlegada = null;
        //Declara variable validacion para no crear un bucle en el while
        boolean horaLlegadaValida = false;
        //no inicia el while a menos que horaLlegadaValida se T o !horaLlegadaValida
        while (!horaLlegadaValida) {
            // pregunta hora llegada && declarar la variable
            System.out.println("Ingresa la hora de llegada (en formato 24H Ej: 23:15): ");
            String horaLlegadaStr = scanner.nextLine();
            // Este es el bloque try-catch usado para manejar posibles errores en el formato de la hora
            try {
                horaLlegada = LocalTime.parse(horaLlegadaStr, formatter);
                horaLlegadaValida = true;
            } catch (Exception e) {
                System.out.println("Formato incorrecto! Intenta de nuevo (HH:mm).");
            }
        }

        //Declara hora de salida tipo LocalTime (hora sin fecha) null variable vacía
        LocalTime horaSalida = null;
        //Declara variable validacion para no crear un bucle en el while
        boolean horaSalidaValida = false;
        //no inicia el while a menos que horaSalidaValida se T o !horaSalidaValida
        while (!horaSalidaValida) {
            // pregunta hora llegada && declarar la variable
            System.out.println("Ingresa la hora de salida (en formato 24H Ej: 23:15): ");
            String horaSalidaStr = scanner.nextLine();
            // Este es el bloque try-catch usado para manejar posibles errores en el formato de la hora
            try {
                horaSalida = LocalTime.parse(horaSalidaStr, formatter);
                horaSalidaValida = true;
            } catch (Exception e) {
                System.out.println("Formato incorrecto! Intenta de nuevo (HH:mm).");
            }
        }

        // Definir variable de costo base para dar respuesta a los ifs (dependiendo del tipo de vehículo)
        double costoPorHora = 0; //costo base

        if (tipoVehiculo.equals("auto")) {
            costoPorHora = 9000;  // Costo hora auto
        } else if (tipoVehiculo.equals("moto")) {
            costoPorHora = 4000;  // Costo hora moto
        } else if (tipoVehiculo.equals("bici")) {
            costoPorHora = 1000;  // Costo hora bicicleta
        } else {
            System.out.println("Escribe como se te pide el tipo de vehículo, este NO es válido");
            return;
        }

        // Calcula la duración en horas (con decimales para minutos)
        long minutosEstacionados = ChronoUnit.MINUTES.between(horaLlegada, horaSalida);
        double horasEstacionadas = (double) minutosEstacionados / 60.0;

        // If si llega después de las 20:00 (se aplica al costo por hora)
        if (horaLlegada.getHour() >= 20) {
            costoPorHora *= 1.20;  // sumar el 20% recargo al costo por hora
        }

        // Calcular el pago total
        double pagoTotal = horasEstacionadas * costoPorHora;

        // Print de los calculos (horas y recargo)
        System.out.println("Tiempo estacionado: " + String.format("%.2f", horasEstacionadas) + " horas");
        System.out.println("Valor total del parqueadero: $" + String.format("%.2f", pagoTotal));

        scanner.close();
    }

    public static void Tienda (){
        //Declarando a scanner
        Scanner scanner = new Scanner(System.in);

        // preguntar tipo de prenda && declarar la variable
        System.out.println("¿Qué prenda quieres comprar hoy (camisa, pantalon, chaqueta)?: ");
        String tipoPrenda = scanner.nextLine().toLowerCase();

        // preguntar cantidad de prendas && declarar la variable
        System.out.println("¿Cuántas " + tipoPrenda + " quieres llevar?: ");
        int cantidadPrendas = scanner.nextInt();

        // Definir variable precio (base) para dar respuesta a los ifs (dependiendo de la prenda)
        double precio = 0;

        if (tipoPrenda.equals("camisa")) {
            precio = 15000;  // Precio camisa
        } else if (tipoPrenda.equals("pantalon")) {
            precio = 60000;  // Precio pantalón
        } else if (tipoPrenda.equals("chaqueta")) {
            precio = 90000;  // Precio chaqueta
        } else {
            System.out.println("Ese tipo de prenda NO válido.");
            return;
        }

        // calcular el total a pagar
        double total = precio * cantidadPrendas;

        // aplicar descuanto si aplica x cantidad
        if (cantidadPrendas > 5) {
            total = total * 0.85;
        }

        // Print del monto a pagar con o sin descuento segun aplique
        System.out.println("El total a pagar es: $" + total);
    }
}
