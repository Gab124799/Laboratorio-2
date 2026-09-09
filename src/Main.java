import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Nave nave = null;
        int opcion = 0;

        System.out.print("Nombre de la nave: ");
        String nombreNave = scanner.nextLine();
        System.out.print("ID de la nave: ");
        int idNave = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Comandante: ");
        String comandante = scanner.nextLine();
        nave = new Nave(nombreNave, idNave, comandante);

        do {
            System.out.println("\n1. Nueva nave");
            System.out.println("2. Instalar módulo");
            System.out.println("3. Consultar módulos");
            System.out.println("4. Consultar un módulo");
            System.out.println("5. Modificar módulo");
            System.out.println("6. Retirar módulo");
            System.out.println("7. Registrar planeta");
            System.out.println("8. Consultar planetas");
            System.out.println("9. Buscar planeta");
            System.out.println("10. Modificar planeta");
            System.out.println("11. Eliminar planeta");
            System.out.println("12. Mostrar reporte de misión");
            System.out.println("13. Salir");

            try {
                System.out.print("Opción: ");
                opcion = scanner.nextInt();
                scanner.nextLine();

                switch (opcion) {
                    case 1:
                        System.out.print("Nombre de la nave: ");
                        nombreNave = scanner.nextLine();
                        System.out.print("ID de la nave: ");
                        idNave = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Comandante: ");
                        comandante = scanner.nextLine();
                        nave = new Nave(nombreNave, idNave, comandante);
                        System.out.println("Nueva nave registrada.");
                        break;

                    case 2:
                        try {
                            System.out.print("Posición (0-4): ");
                            int pos = scanner.nextInt();
                            scanner.nextLine();

                            if (pos < 0 || pos >= 5) {
                                System.out.println("Posición inválida.");
                                break;
                            }
                            if (nave.getModulo()[pos] != null) {
                                System.out.println("Posición ocupada.");
                                break;
                            }

                            System.out.print("Código: ");
                            String cod = scanner.nextLine();
                            System.out.print("Nombre: ");
                            String nom = scanner.nextLine();
                            System.out.print("Tipo: ");
                            String tipo = scanner.nextLine();
                            System.out.print("Consumo de energía: ");
                            double consumo = scanner.nextDouble();
                            System.out.print("Estado (true/false): ");
                            boolean est = scanner.nextBoolean();
                            scanner.nextLine();

                            Modulo nuevoModulo = new Modulo(cod, nom, tipo, consumo, est);
                            Modulo[] arregloModulos = nave.getModulo();
                            arregloModulos[pos] = nuevoModulo;
                            nave.setModulo(arregloModulos);

                            System.out.println("Módulo instalado exitosamente.");
                        } catch (InputMismatchException e) {
                            System.out.println("Entrada no válida.");
                            scanner.nextLine();
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        } finally {
                            System.out.println("Operación de módulo finalizada.");
                        }
                        break;

                    case 3:
                        boolean hayModulos = false;
                        Modulo[] modulosActuales = nave.getModulo();
                        for (int i = 0; i < modulosActuales.length; i++) {
                            if (modulosActuales[i] != null) {
                                System.out.println("Posición " + i + ": " + modulosActuales[i]);
                                hayModulos = true;
                            }
                        }
                        if (!hayModulos) {
                            System.out.println("No hay módulos instalados.");
                        }
                        break;

                    case 4:
                        System.out.print("Posición (0-4): ");
                        int posConsulta = scanner.nextInt();
                        scanner.nextLine();
                        if (posConsulta < 0 || posConsulta >= 5) {
                            System.out.println("Posición no válida.");
                        } else if (nave.getModulo()[posConsulta] == null) {
                            System.out.println("Posición vacía.");
                        } else {
                            System.out.println(nave.getModulo()[posConsulta]);
                        }
                        break;

                    case 5:
                        System.out.print("Posición a modificar (0-4): ");
                        int posMod = scanner.nextInt();
                        scanner.nextLine();
                        if (posMod < 0 || posMod >= 5 || nave.getModulo()[posMod] == null) {
                            System.out.println("Posición inválida o vacía.");
                            break;
                        }
                        System.out.print("Nuevo consumo: ");
                        double nuevoConsumo = scanner.nextDouble();
                        System.out.print("Nuevo estado (true/false): ");
                        boolean nuevoEst = scanner.nextBoolean();
                        scanner.nextLine();

                        nave.getModulo()[posMod].setConsumoEnergia(nuevoConsumo);
                        nave.getModulo()[posMod].setEstado(nuevoEst);
                        System.out.println("Módulo modificado.");
                        break;

                    case 6:
                        System.out.print("Posición a retirar (0-4): ");
                        int posRet = scanner.nextInt();
                        scanner.nextLine();
                        if (posRet < 0 || posRet >= 5 || nave.getModulo()[posRet] == null) {
                            System.out.println("Posición inválida o vacía.");
                        } else {
                            nave.getModulo()[posRet] = null;
                            System.out.println("Módulo retirado.");
                        }
                        break;

                    case 7:
                        System.out.print("Código del planeta: ");
                        int codPlaneta = scanner.nextInt();
                        scanner.nextLine();

                        boolean existe = false;
                        for (int i = 0; i < nave.getPlanetas().size(); i++) {
                            if (nave.getPlanetas().get(i).getCodigo() == codPlaneta) {
                                existe = true;
                                break;
                            }
                        }
                        if (existe) {
                            System.out.println("El código de planeta ya existe.");
                            break;
                        }

                        System.out.print("Nombre: ");
                        String nomPlaneta = scanner.nextLine();
                        System.out.print("Distancia: ");
                        double dist = scanner.nextDouble();
                        System.out.print("Temperatura: ");
                        double temp = scanner.nextDouble();
                        System.out.print("Nivel de habitabilidad (0-100): ");
                        double hab = scanner.nextDouble();
                        scanner.nextLine();

                        Planeta nuevoPlaneta = new Planeta(codPlaneta, nomPlaneta, dist, temp, hab);
                        nave.getPlanetas().add(nuevoPlaneta);
                        System.out.println("Planeta registrado exitosamente.");
                        break;

                    case 8:
                        if (nave.getPlanetas().isEmpty()) {
                            System.out.println("No hay planetas registrados.");
                        } else {
                            for (int i = 0; i < nave.getPlanetas().size(); i++) {
                                System.out.println(nave.getPlanetas().get(i));
                            }
                        }
                        break;

                    case 9:
                        System.out.print("Código de planeta a buscar: ");
                        int codBuscar = scanner.nextInt();
                        scanner.nextLine();

                        Planeta encontrado = null;
                        for (int i = 0; i < nave.getPlanetas().size(); i++) {
                            if (nave.getPlanetas().get(i).getCodigo() == codBuscar) {
                                encontrado = nave.getPlanetas().get(i);
                                break;
                            }
                        }
                        if (encontrado != null) {
                            System.out.println(encontrado);
                        } else {
                            System.out.println("Planeta no encontrado.");
                        }
                        break;

                    case 10:
                        System.out.print("Código de planeta a modificar: ");
                        int codModP = scanner.nextInt();
                        scanner.nextLine();

                        Planeta planetaMod = null;
                        for (int i = 0; i < nave.getPlanetas().size(); i++) {
                            if (nave.getPlanetas().get(i).getCodigo() == codModP) {
                                planetaMod = nave.getPlanetas().get(i);
                                break;
                            }
                        }
                        if (planetaMod == null) {
                            System.out.println("Planeta no registrado.");
                            break;
                        }

                        System.out.print("Nuevo nombre: ");
                        String nuevoNom = scanner.nextLine();
                        System.out.print("Nueva distancia: ");
                        double nuevaDist = scanner.nextDouble();
                        System.out.print("Nueva temperatura: ");
                        double nuevaTemp = scanner.nextDouble();
                        System.out.print("Nuevo nivel de habitabilidad (0-100): ");
                        double nuevaHab = scanner.nextDouble();
                        scanner.nextLine();

                        planetaMod.setName(nuevoNom);
                        planetaMod.setDistancia(nuevaDist);
                        planetaMod.setTemperatura(nuevaTemp);
                        planetaMod.setNivelHabitable(nuevaHab);
                        System.out.println("Planeta modificado exitosamente.");
                        break;

                    case 11:
                        System.out.print("Código de planeta a eliminar: ");
                        int codEliminar = scanner.nextInt();
                        scanner.nextLine();

                        boolean eliminado = false;
                        for (int i = 0; i < nave.getPlanetas().size(); i++) {
                            if (nave.getPlanetas().get(i).getCodigo() == codEliminar) {
                                nave.getPlanetas().remove(i);
                                eliminado = true;
                                break;
                            }
                        }
                        if (eliminado) {
                            System.out.println("Planeta eliminado.");
                        } else {
                            System.out.println("Planeta no encontrado.");
                        }
                        break;

                    case 12:
                        int instalados = 0;
                        Modulo mayorConsumo = null;
                        Modulo[] modulosReporte = nave.getModulo();
                        for (int i = 0; i < modulosReporte.length; i++) {
                            if (modulosReporte[i] != null) {
                                instalados++;
                                if (mayorConsumo == null || modulosReporte[i].getConsumoEnergia() > mayorConsumo.getConsumoEnergia()) {
                                    mayorConsumo = modulosReporte[i];
                                }
                            }
                        }
                        int disponibles = modulosReporte.length - instalados;

                        System.out.println("Módulos instalados: " + instalados);
                        System.out.println("Espacios disponibles: " + disponibles);
                        if (mayorConsumo != null) {
                            System.out.println("Módulo mayor consumo: " + mayorConsumo.getNombre() + " (" + mayorConsumo.getConsumoEnergia() + ")");
                        } else {
                            System.out.println("Módulo mayor consumo: N/A");
                        }

                        ArrayList<Planeta> listaP = nave.getPlanetas();
                        System.out.println("Planetas descubiertos: " + listaP.size());
                        if (!listaP.isEmpty()) {
                            Planeta mayorHab = listaP.get(0);
                            Planeta menorHab = listaP.get(0);
                            double sumaHab = 0;

                            for (int i = 0; i < listaP.size(); i++) {
                                Planeta pActual = listaP.get(i);
                                if (pActual.getNivelHabitable() > mayorHab.getNivelHabitable()) {
                                    mayorHab = pActual;
                                }
                                if (pActual.getNivelHabitable() < menorHab.getNivelHabitable()) {
                                    menorHab = pActual;
                                }
                                sumaHab += pActual.getNivelHabitable();
                            }
                            System.out.println("Mayor habitabilidad: " + mayorHab.getName() + " (" + mayorHab.getNivelHabitable() + ")");
                            System.out.println("Menor habitabilidad: " + menorHab.getName() + " (" + menorHab.getNivelHabitable() + ")");
                            System.out.println("Promedio habitabilidad: " + (sumaHab / listaP.size()));
                        } else {
                            System.out.println("Estadísticas habitabilidad: N/A");
                        }
                        break;

                    case 13:
                        System.out.println("Saliendo del sistema.");
                        break;

                    default:
                        System.out.println("Opción inválida.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida.");
                scanner.nextLine();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (opcion != 13);
    }
}