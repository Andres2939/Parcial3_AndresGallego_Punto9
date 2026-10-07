import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Queue<Solicitud> listaSolicitudes = new LinkedList<>();
        Scanner sc = new Scanner(System.in);
        Solicitud solicitud = null;
        boolean continuar = true;
        Metodos m = new Metodos();
        
        while (continuar) {
            System.out.println("Bienvenido al servicio posventa");
            System.out.println("¿Que desea hacer?");
            System.out.println("1)Seleccionar motivo de solicitud");
            System.out.println("2)Cambiar motivo de solicitud");
            System.out.println("3)Cancelar el proceso");
            System.out.println("4)Ingresar nuevos datos");
            System.out.println("5)Atender cliente");
            System.out.println("6)Mostrar solicitudes");
            System.out.println("7)Salir");
            int opcion = sc.nextInt();
            sc.nextLine();
            switch (opcion) {
                case 1:
                    m.registrarsolicitud(listaSolicitudes, sc);
                    break;
                case 2:
                    m.CambiarSolicitud(listaSolicitudes, sc, solicitud);
                    break;
                case 3:
                    m.Cancelar(listaSolicitudes, sc, solicitud);
                    break;
                case 4:
                    m.Añadir(listaSolicitudes, sc, solicitud);
                    break;
                case 5:
                    m.AtenderCliente(listaSolicitudes, solicitud);
                    break;
                case 6:
                    m.Mostrarsolicitudes(listaSolicitudes, solicitud);
                    break;
                case 7:
                    System.out.println("Hasta luego");
                    continuar=false;
                default:
                    break;
            }
        }
}
}