import java.util.Iterator;
import java.util.Queue;
import java.util.Scanner;

public class Metodos {
    int turno = 0;

    public static int ValidarEntero(Scanner sc) {
        while (!sc.hasNextInt()) {
            System.out.println("Error: Debe ser un numero entero");
            sc.next();
        }
        return sc.nextInt();
    }

    public Queue<Solicitud> registrarsolicitud(Queue<Solicitud> listaSolicitudes, Scanner sc) {
        Solicitud solicitud = new Solicitud();
        solicitud.setTipoSolicitud(tipoSolicitud(sc));
        solicitud.setAtendido(0);
        solicitud.setTurno(AsignarTurno());
        System.out.println("Turno: " + solicitud.getTurno());
        System.out.println("---------------------------------");
        listaSolicitudes.offer(solicitud);
        return listaSolicitudes;
    }

    private static String tipoSolicitud(Scanner sc) {
        int opt = 0;
        String tipo = null;
        boolean continuar = true;
        while (continuar) {
            System.out.println("Seleccione tipo de solicitud");
            System.out.println("1) Cambio");
            System.out.println("2) Garantia");
            System.out.println("3) Devolucion");
            opt = ValidarEntero(sc);
            sc.nextLine();
            switch (opt) {
                case 1:
                    tipo = "Cambio";
                    continuar = false;
                    break;
                case 2:
                    tipo = "Garantia";
                    continuar = false;
                    break;
                case 3:
                    tipo = "Devolucion";
                    continuar = false;
                    break;
                default:
                    System.out.println("Esta opcion no existe");
                    break;
            }
            System.out.println("Eligio: " + tipo);
        }

        return tipo;

    }

    public int AsignarTurno() {
        turno++;
        return turno;
    }

    public String CambiarSolicitud(Queue<Solicitud> listaSolicitudes, Scanner sc, Solicitud solicitud) {

        String tipo = null;
        System.out.println("¿Desea cambiar la solicitud?");
        System.out.println("1) Si");
        System.out.println("2) No");
        int eleccion = ValidarEntero(sc);
        sc.nextLine();
        if (eleccion == 1) {
            System.out.println("Digite su turno");
            int BuscarTurno = ValidarEntero(sc);
            boolean encontrado = false;
            Iterator<Solicitud> it = listaSolicitudes.iterator();
            while (it.hasNext()) {
                solicitud = it.next();
                if (solicitud.getTurno() == BuscarTurno) {
                    if (solicitud.getAtendido() == 0) {
                        System.out.println("Solicitud actual: " + solicitud.getTipoSolicitud());
                        System.out.println("¿A que desea cambiar?");
                        System.out.println("1) Cambio");
                        System.out.println("2) Garantia");
                        System.out.println("3) Devolucion");
                        int opt = ValidarEntero(sc);
                        sc.nextLine();
                        switch (opt) {
                            case 1:
                                solicitud.setTipoSolicitud("Cambio");
                                System.out.println("Se a seleccionado: " + solicitud.getTipoSolicitud());
                                break;
                            case 2:
                                solicitud.setTipoSolicitud("Garantia");
                                System.out.println("Se a seleccionado: " + solicitud.getTipoSolicitud());
                                break;
                            case 3:
                                solicitud.setTipoSolicitud("Devolucion");
                                System.out.println("Se a seleccionado: " + solicitud.getTipoSolicitud());
                                break;
                            default:
                                System.out.println("Esta opcion no existe");
                                break;
                        }

                        System.out.println("---------------------------------");
                        encontrado = true;
                        break;
                    } else {
                        System.out.println("Turno ya atendido");
                    }

                }
            }

            if (!encontrado) {
                System.out.println("No encontrado");
            }
        } else if (eleccion == 2) {
            System.out.println("Ok");
        } else if (eleccion != 1 && eleccion != 2) {
            System.out.println("No valido");
        }
        return null;
    }

    public Queue<Solicitud> Cancelar(Queue<Solicitud> listaSolicitudes, Scanner sc, Solicitud solicitud) {
        if (listaSolicitudes.isEmpty()) {
            System.out.println("No hay nada que mostrar");
        } else {
            System.out.println("Turno a cancelar:");
            int BuscarTurno = ValidarEntero(sc);
            Iterator<Solicitud> it = listaSolicitudes.iterator();
            while (it.hasNext()) {
                solicitud = it.next();
                if (solicitud.getTurno() == BuscarTurno) {
                    if (solicitud.getAtendido() == 0) {
                        System.out.println("Turno encontrado con la solicitud: " + solicitud.getTipoSolicitud());
                        Boolean continuar = true;
                        while (continuar) {
                            System.out.println("¿Desea cancelar el turno?");
                            System.out.println("1)Si");
                            System.out.println("2)No");
                            int opt = ValidarEntero(sc);
                            sc.nextLine();
                            switch (opt) {
                                case 1:
                                    it.remove();
                                    System.out.println("Turno cancelado");
                                    continuar = false;
                                    break;
                                case 2:
                                    System.out.println("Ok");
                                    continuar = false;
                                    break;
                                default:
                                    System.out.println("Opcion no valida");

                                    break;
                            }
                        }

                    } else {
                        System.out.println("Turno ya atendido");
                    }

                }
            }
        }

        return listaSolicitudes;

    }

    public Solicitud AtenderCliente(Queue<Solicitud> listaSolicitudes, Solicitud solicitud) {
        if (listaSolicitudes.isEmpty()) {
            System.out.println("No hay nada que mostrar");
        } else {
            System.out.println("Se atendio el turno: " + listaSolicitudes.peek().getTurno());
            listaSolicitudes.peek().setAtendido(1);
        }
        return null;
    }

    public Queue<Solicitud> Añadir(Queue<Solicitud> listaSolicitudes, Scanner sc, Solicitud solicitud) {
        if (listaSolicitudes.isEmpty()) {
            System.out.println("No hay nada que mostrar");
        } else {
            System.out.println("Turno para añadir proceso:");
            int BuscarTurno = ValidarEntero(sc);
            Iterator<Solicitud> it = listaSolicitudes.iterator();
            while (it.hasNext()) {
                solicitud = it.next();
                if (solicitud.getTurno() == BuscarTurno) {
                    if (solicitud.getAtendido() == 0) {
                        System.out.println("Turno encontrado con la solicitud: " + solicitud.getTipoSolicitud());
                        Boolean continuar = true;
                        while (continuar) {
                            System.out.println("¿Desea añadir otro proceso?");
                            System.out.println("1)Si");
                            System.out.println("2)No");
                            int opt = ValidarEntero(sc);
                            String tipo = null;
                            sc.nextLine();
                            switch (opt) {
                                case 1:
                                    System.out.println("Seleccione tipo de solicitud");
                                    System.out.println("1) Cambio");
                                    System.out.println("2) Garantia");
                                    System.out.println("3) Devolucion");
                                    opt = ValidarEntero(sc);
                                    sc.nextLine();
                                    switch (opt) {
                                        case 1:
                                            tipo = "Cambio";
                                            solicitud.setTipoSolicitud2(tipo);
                                            continuar = false;
                                            break;
                                        case 2:
                                            tipo = "Garantia";
                                            solicitud.setTipoSolicitud2(tipo);
                                            continuar = false;
                                            break;
                                        case 3:
                                            tipo = "Devolucion";
                                            solicitud.setTipoSolicitud2(tipo);
                                            continuar = false;
                                            break;
                                        default:
                                            System.out.println("Esta opcion no existe");
                                            break;
                                    }
                                    System.out.println("Eligio: " + tipo);

                                    break;
                                case 2:
                                    System.out.println("Ok");
                                    continuar = false;
                                    break;
                                default:
                                    System.out.println("Opcion no valida");

                                    break;
                            }
                            System.out.println("¿Desea añadir tercer proceso?");
                            System.out.println("1)Si");
                            System.out.println("2)No");
                            opt = ValidarEntero(sc);
                            tipo = null;
                            sc.nextLine();
                            switch (opt) {
                                case 1:
                                    System.out.println("Seleccione tipo de solicitud");
                                    System.out.println("1) Cambio");
                                    System.out.println("2) Garantia");
                                    System.out.println("3) Devolucion");
                                    opt = ValidarEntero(sc);
                                    sc.nextLine();
                                    switch (opt) {
                                        case 1:
                                            tipo = "Cambio";
                                            solicitud.setTipoSolicitud3(tipo);
                                            continuar = false;
                                            break;
                                        case 2:
                                            tipo = "Garantia";
                                            solicitud.setTipoSolicitud3(tipo);
                                            continuar = false;
                                            break;
                                        case 3:
                                            tipo = "Devolucion";
                                            solicitud.setTipoSolicitud3(tipo);
                                            continuar = false;
                                            break;
                                        default:
                                            System.out.println("Esta opcion no existe");
                                            break;
                                    }
                                    System.out.println("Eligio: " + tipo);

                                    break;
                                case 2:
                                    System.out.println("Ok");
                                    continuar = false;
                                    break;
                                default:
                                    System.out.println("Opcion no valida");

                                    break;
                            }

                        }

                    } else {
                        System.out.println("Turno ya atendido");
                    }

                }
            }
        }

        return listaSolicitudes;

    }

    public void Mostrarsolicitudes(Queue<Solicitud> listasSolicitudes, Solicitud solicitud) {
        Iterator<Solicitud> contador = listasSolicitudes.iterator();
        while (contador.hasNext()) {
            solicitud = contador.next();
            System.out.println("Turno: " + solicitud.getTurno());
            System.out.println("Solicitud 1: " + solicitud.getTipoSolicitud());
            if (solicitud.getTipoSolicitud2() != null) {
                System.out.println("Solicitud 2: " + solicitud.getTipoSolicitud2());
            }
            if (solicitud.getTipoSolicitud3() != null) {
                System.out.println("Solicitud 3: " + solicitud.getTipoSolicitud3());
            }
            if (solicitud.getAtendido() == 0)
                System.out.println("No ha sido atendido");
            else if (solicitud.getAtendido() == 1) {
                System.out.println("Atendido");
            }
            System.out.println("-----------------------------------------");
        }
    }
}