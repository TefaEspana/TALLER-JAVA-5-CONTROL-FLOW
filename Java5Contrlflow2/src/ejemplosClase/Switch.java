package ejemplosClase;

import java.util.Scanner;

public class Switch {
    public static void calificaciones(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingresa tu calificacion: ");
        String calificacion = scanner.nextLine();

        switch (calificacion.toLowerCase()){
            case "a":
                System.out.println("Pasaste");
                break;
            case "b":
                System.out.println("Pasaste, raspando");
                break;
            case "c":
                System.out.println("No Pasaste");
                break;
            default:
                System.out.println("La calificacion no es Valida");
        }
    }

//Falta el dia de la semana


//Falta los aminimalitos


//public static void calificaciones(){
//    Scanner scanner = new Scanner(System.in);
//    System.out.println("Ingresa un animal: ");
//    String calificacion = scanner.nextLine();
//
//    switch (calificacion.toLowerCase()){
//        case "a":
//            System.out.println("Pasaste");
//            break;
//        case "b":
//             System.out.println("Pasaste, raspando");
//             break;
//        case "c":
//             System.out.println("No Pasaste");
//             break;
//        default:
//             System.out.println("La calificacion no es Valida");
//    }
//}

}
