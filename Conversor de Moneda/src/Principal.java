import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        ConsultarMoneda consulta = new ConsultarMoneda();


        int opcion =0;
        while (opcion != 8) {
            System.out.println("**************************************\n");
            System.out.println("""
                    "Bienvenido(a) al convertidor de monedas"
                    
                    **Ingresa la opción de conversión que deseas realizar**
                    
                    1) dólar =>> peso argentino
                    2) peso argentino =>> dólar
                    3) dólar =>> real brasileño
                    4) real brasileño =>> dólar
                    5) dólar =>> peso colombiano
                    6) peso colombiano =>> dólar
                    7) convertir otra moneda
                    8) salir
                    **************************************""");


            opcion = lectura.nextInt();
            lectura.nextLine();

            switch (opcion) {
                case 1:
                    ConvertirMoneda.convertir("USD", "ARS", consulta, lectura);
                    break;
                case 2:
                    ConvertirMoneda.convertir("ARS", "USD", consulta, lectura);
                    break;
                case 3:
                    ConvertirMoneda.convertir("USD", "BRL", consulta, lectura);
                    break;
                case 4:
                    ConvertirMoneda.convertir("BRL", "USD", consulta, lectura);
                    break;
                case 5:
                    ConvertirMoneda.convertir("USD", "COP", consulta, lectura);
                    break;
                case 6:
                    ConvertirMoneda.convertir("COP", "USD", consulta, lectura);
                    break;
                case 7:
                    ConvertirMoneda.convertirOtraMoneda(consulta,lectura);
                    break;
                case 8:
                    System.out.println("saliendo...");
                    break;

                default:
                    System.out.println("opción no valida");
                    break;
            }
        }
    }

}

