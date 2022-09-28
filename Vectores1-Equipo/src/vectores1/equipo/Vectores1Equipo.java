package vectores1.equipo;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

// @author Galileo Padilla 
public class Vectores1Equipo {

    public static void main(String[] args) {
        String equipo[], salida = "", nombre;
        JTextArea hoja = new JTextArea();
        boolean salir = false;
        int opcion, indice, cantidad, jugador, nuevoDorsal;

        do {
            cantidad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de jugadores que administrara"));
        } while (cantidad < 0 || cantidad > 30);

        equipo = new String[cantidad];

        //Llenar vector
        for (indice = 0; indice < equipo.length; indice++) {
            equipo[indice] = "VACIO";
        }

        while (!salir) {
            opcion = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la opcion que desee\n1. Ver lista de jugadores\n2. Registrar un jugador\n3. Eliminar un jugador\n4. Editar nombre\n5. Cambiar Dorsal\nCualquier otro para salir"));
            if (opcion == 1) { // Ver array
                salida = "";
                for (indice = 0; indice < equipo.length; indice++) {

                    if (indice == (equipo.length - 1)) {
                        salida += (indice + 1) + "- " + equipo[indice];
                    } else {
                        salida += (indice + 1) + "- " + equipo[indice] + "\n";
                    }
                }
                hoja.setText(salida);
                JOptionPane.showMessageDialog(null, hoja);
            } else if (opcion == 2) { // Registrar un jugador
                jugador = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el dorsal del jugador a registrar"));
                if (jugador < 0 || jugador > cantidad) {
                    JOptionPane.showMessageDialog(null, "Error. esta ingresando un valor invalido");
                } else {
                    if (!equipo[jugador - 1].equals("VACIO")) { //Hay un jugador
                        JOptionPane.showMessageDialog(null, "Error. El dorsal seleccionado se encuentra ocupado por el jugador " + equipo[jugador - 1]);
                    } else {
                        nombre = JOptionPane.showInputDialog("Ingrese el nombre del jugador a registrar");
                        if (!nombre.isEmpty()) {
                            equipo[jugador - 1] = nombre;
                            JOptionPane.showMessageDialog(null, "Jugador registrado con exito");
                        } else {
                            JOptionPane.showMessageDialog(null, "Error. Debe ingresar un valor no vacio");
                        }
                    }
                }
            } else if (opcion == 3) { //Eliminar un jugador
                jugador = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el dorsal del jugador a eliminar"));
                if (jugador < 0 || jugador > cantidad) {
                    JOptionPane.showMessageDialog(null, "Error. esta ingresando un valor invalido");
                } else {
                    if (equipo[jugador - 1].equals("VACIO")) { //Hay un jugador
                        JOptionPane.showMessageDialog(null, "Error. No hay un jugador registrado con este dorsal");
                    } else {
                        JOptionPane.showMessageDialog(null, "El jugador " + equipo[jugador - 1] + " ha sido eliminado con exito");
                        equipo[jugador - 1] = "VACIO";
                    }
                }
            } else if (opcion == 4) { // Editar nombre
                jugador = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el dorsal del jugador a editar nombre"));
                if (jugador < 0 || jugador > cantidad) {
                    JOptionPane.showMessageDialog(null, "Error. esta ingresando un valor invalido");
                } else {
                    if (equipo[jugador - 1].equals("VACIO")) { //Hay un jugador
                        JOptionPane.showMessageDialog(null, "Error. El dorsal seleccionado se encuentra vacio");
                    } else {
                        nombre = JOptionPane.showInputDialog("Ingrese el nombre del jugador a editar");
                        if (!nombre.isEmpty()) {
                            equipo[jugador - 1] = nombre;
                            JOptionPane.showMessageDialog(null, "Nombre editado con exito");
                        } else {
                            JOptionPane.showMessageDialog(null, "Error. Debe ingresar un valor no vacio");
                        }
                    }
                }
            } else if (opcion == 5) { //Cambiar numero
                jugador = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el dorsal del jugador a cambiar"));

                if (jugador < 0 || jugador > cantidad || equipo[jugador - 1].equals("VACIO")) {
                    if (equipo[jugador - 1].equals("VACIO")) {
                        JOptionPane.showMessageDialog(null, "Error. Este dorsal se encuentra vacio");
                    } else {
                        JOptionPane.showMessageDialog(null, "Error. esta ingresando un valor invalido");
                    }

                } else {

                    nuevoDorsal = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el nuevo dorsal del jugador " + equipo[jugador - 1]));

                    if (nuevoDorsal < 0 || nuevoDorsal > cantidad || equipo[nuevoDorsal - 1].equals("VACIO")) {
                        if (equipo[jugador - 1].equals("VACIO")) {
                            JOptionPane.showMessageDialog(null, "Error. Este dorsal se encuentra vacio");
                        } else if (nuevoDorsal < 0 || nuevoDorsal > cantidad) {
                            JOptionPane.showMessageDialog(null, "Error. esta ingresando un valor invalido");
                        } else {
                            equipo[nuevoDorsal - 1] = equipo[jugador - 1];
                            equipo[jugador - 1] = "VACIO";
                            JOptionPane.showMessageDialog(null, "Dorsal cambiado con exito");
                        }
                    }
                }
            } else {
                salir = true;
            }
        }
    }

}
