
import javax.swing.JOptionPane;

public class Principal {

    /**
     * Estados do AFD.
     */
    enum Estado {
        S0, S1, S2, S3
    }

    //Armazena o estado inicial
    static Estado estado_inicial = Estado.S0;
    //Armazena o estado final
    static Estado estado_final = Estado.S3;
    //Armazena o estado atual
    static Estado estado_atual = estado_inicial;
    //Armazena se a entrada é válida
    static boolean valido = true;

    //Indice da letra da entrada
    static int i = 0;

    // Retorna um caracter da entrada e avança o indice para o próximo
    public static char proximoCaracter(String entrada) {
        char retorno = 0;
        if (i < entrada.length()) {
            retorno = entrada.charAt(i);
            i = i + 1;
        } else {
            retorno = 0;
        }
        return retorno;
    }

    // Estado 0
    public static void avaliaEstadoS0(String entrada) {
        //Atualiza o estado atual
        estado_atual = Estado.S0;

        //Recupera um caracter
        char avaliar = proximoCaracter(entrada);

        // Estado 0 para 1
        if (avaliar == 'a') {
            //Avança para o próximo estado
            avaliaEstadoS1(entrada);
        } else {
            // Estado 0 para 2
            if (avaliar == 'b') {
                //Avança para o próximo estado
                avaliaEstadoS2(entrada);
            } else {
                valido = false;
            }
        }
    }

    // Estado 1
    public static void avaliaEstadoS1(String entrada) {
        //Atualiza o estado atual
        estado_atual = Estado.S1;

        //Recupera um caracter
        char avaliar = proximoCaracter(entrada);

        // Estado 1 para 3
        if (avaliar == 'a') {
            //Avança para o próximo estado
            avaliaEstadoS3(entrada);
        } else {
            // Estado 1 para 2
            if (avaliar == 'b') {
                //Avança para o próximo estado
                avaliaEstadoS2(entrada);
            } else {
                valido = false;
            }
        }
    }

    // Estado 2
    public static void avaliaEstadoS2(String entrada) {
        //Atualiza o estado atual
        estado_atual = Estado.S2;

        //Recupera um caracter
        char avaliar = proximoCaracter(entrada);

        // Estado 2 para 1
        if (avaliar == 'a') {
            //Avança para o próximo estado
            avaliaEstadoS1(entrada);
        } else {
            // Estado 2 para 3
            if (avaliar == 'b') {
                //Avança para o próximo estado
                avaliaEstadoS3(entrada);
            } else {
                valido = false;
            }
        }
    }

    // Estado 2 (Estado final)
    public static void avaliaEstadoS3(String entrada) {
        //Atualiza o estado atual
        estado_atual = Estado.S3;

        //Se tem caracteres para avaliar verifica qual caracteres são válidos
        if (i < entrada.length()) {

            //Recupera um caracter
            char avaliar = proximoCaracter(entrada);

            // Estado 2 para 2
            if (avaliar == 'a') {
                //Avança para o próximo estado
                avaliaEstadoS3(entrada);
            } else {
                // Estado 2 para 2
                if (avaliar == 'b') {
                    //Avança para o próximo estado
                    avaliaEstadoS3(entrada);
                } else {
                    //Letras diferentes de a e ba
                    valido = false;
                }
            }
        }
    }

    public static void main(String args[]) {

        System.out.println("\nImplementacao recursiva:\n");

        String entrada = "";
        if (args.length != 0) {
            entrada = args[0];
        } else {
            entrada = JOptionPane.showInputDialog("Digite uma palavra a ser avaliada:");
        }

        //Avalia o estado inicial
        avaliaEstadoS0(entrada);

        ///Verifica se o estado atual é igual ao estado final
        if ((estado_atual == estado_final) && (valido == true)) {
            System.out.println("Entrada valida   :" + entrada);
        } else {
            System.out.println("Entrada invalida :" + entrada);
        }
    }
}
