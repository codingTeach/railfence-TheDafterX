import javax.swing.JOptionPane

// LA FUNCIÓN DEL CIFRADO RAILFENCE
fun micifradoRailfence(TEXTO: String, RAILES: Int): String {
    // CREAMOS UNA LISTA DE STRINGBUILDERS PARA CADA RAIL
    val RAILES_LISTA = List(RAILES) { StringBuilder() }
    var DIRECCION = 1   // DIRECCION DEFAULT
    var RAIL_ACTUAL = 0 //POSICIÓN DEFAULT

    // RECORREMOS EL TEXTO Y DISTRIBUIMOS LOS CARACTERES EN LOS RAILES
    for (CARACTER in TEXTO) {
        RAILES_LISTA[RAIL_ACTUAL].append(CARACTER)
        RAIL_ACTUAL += DIRECCION

        // CAMBIAMOS LA DIRECCIÓN SI LLEGAMOS AL PRIMER O ÚLTIMO RAIL
        if (RAIL_ACTUAL == 0 || RAIL_ACTUAL == RAILES - 1) {
            DIRECCION *= -1
        }
    }

    // CONCATENAMOS TODOS LOS RAILES PARA OBTENER EL TEXTO CIFRADO
    return RAILES_LISTA.joinToString("") { it.toString() }
}

// FUNCIÓN PRINCIPAL
fun main() {
    // SOLICITAMOS AL USUARIO QUE INGRESE EL TEXTO Y EL NÚMERO DE RAILES
    val TEXTO_ORIGINAL = JOptionPane.showInputDialog("Ingrese el texto a cifrar:")
    val RAILES = JOptionPane.showInputDialog("Ingrese el número de railes:").toInt()

    // CIFRAMOS EL TEXTO USANDO LA FUNCIÓN CIFRADORAILFENCE
    val TEXTO_CIFRADO = micifradoRailfence(TEXTO_ORIGINAL, RAILES)

    // MOSTRAMOS EL TEXTO CIFRADO EN UNA VENTANA EMERGENTE
    JOptionPane.showMessageDialog(null, "Texto cifrado: $TEXTO_CIFRADO")
}