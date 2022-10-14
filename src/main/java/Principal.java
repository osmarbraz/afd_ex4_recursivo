
import javax.swing.JOptionPane;

public class Principal {

    //Armazena o estado inicial
    static int estado_inicial = 0;
    //Armazena o estado final
    static int estado_final = 3;
    //Armazena o estado atual
    static int estado_atual = estado_inicial;
    //Armazena o estado próximo
    static int estado_proximo = -1;

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
    public static void avaliaEstado0(String entrada) {
        //Atualiza o estado atual
        estado_atual = 0;
        //Recupera um caracter
        char avaliar = proximoCaracter(entrada);

        // Estado 0 para 1
        if (avaliar == 'a') {
            //Guarda o próximo estado
            estado_proximo = 1;

            avaliaEstado1(entrada);
        }

        // Estado 0 para 2
        if (avaliar == 'b') {
            //Guarda o próximo estado
            estado_proximo = 2;

            avaliaEstado2(entrada);
        }
    }

    // Estado 1
    public static void avaliaEstado1(String entrada) {
        //Atualiza o estado atual
        estado_atual = estado_proximo;
        //Recupera um caracter
        char avaliar = proximoCaracter(entrada);

        // Estado 1 para 3
        if (avaliar == 'a') {
            //Guarda o próximo estado
            estado_proximo = 3;

            avaliaEstado3(entrada);
        }

        // Estado 1 para 2
        if (avaliar == 'b') {
            //Guarda o próximo estado
            estado_proximo = 2;

            avaliaEstado2(entrada);
        }
    }

    // Estado 1
    public static void avaliaEstado2(String entrada) {
        //Atualiza o estado atual
        estado_atual = estado_proximo;
        //Recupera um caracter
        char avaliar = proximoCaracter(entrada);

        // Estado 2 para 1
        if (avaliar == 'a') {
            //Guarda o próximo estado
            estado_proximo = 2;

            avaliaEstado1(entrada);
        }

        // Estado 2 para 3
        if (avaliar == 'b') {
            //Guarda o próximo estado
            estado_proximo = 3;

            avaliaEstado3(entrada);
        }
    }

    // Estado 2 (Estado final)
    public static void avaliaEstado3(String entrada) {
        //Atualiza o estado atual
        estado_atual = estado_proximo;

        //Se tem caracteres a avaliar
        if (i < entrada.length()) {
            //Recupera um caracter
            char avaliar = proximoCaracter(entrada);

            // Estado 2 para 2
            if (avaliar == 'a') {
                //Guarda o próximo estado
                estado_proximo = 3;
                avaliaEstado3(entrada);
            } else {
                // Estado 2 para 2
                if (avaliar == 'b') {
                    //Guarda o próximo estado
                    estado_proximo = 3;
                    avaliaEstado3(entrada);
                } else {
                    //Letras diferentes de a e b
                    estado_proximo = -1;
                    avaliaEstado3(entrada);
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
        avaliaEstado0(entrada);

        //Verifica se o estado atual é igual ao estado final
        if (estado_atual == estado_final) {
            System.out.println("Entrada valida   :" + entrada);
        } else {
            System.out.println("Entrada invalida :" + entrada);
        }
    }
}
