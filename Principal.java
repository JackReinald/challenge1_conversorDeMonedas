import java.io.IOException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        // Declaro los objetos
        Scanner lectura = new Scanner(System.in);
        ManejoDeAPI api = new ManejoDeAPI();


        String menu = """
            **************************************
            Bienvenido al menú de divisas.
            
            Elija una de las siguientes divisas
            usando sus siglas:
            
            *) ARS - Peso argentino
            *) BOB - Boliviano boliviano
            *) BRL - Real brasileño
            *) CLP - Peso chileno
            *) COP - Peso colombiano
            *) USD - Dólar estadounidense
                        
            **************************************
            """;
        while (true){
            System.out.println(menu);
            var divisa = lectura.nextLine();
            if (divisa.equalsIgnoreCase("salir")) break;

            System.out.println("Ahora elige de la lista la divisa hacia la cual quieres convertir: ");
            var divisaObjetivo = lectura.nextLine();
            if (divisaObjetivo.equalsIgnoreCase("salir")) break;

            System.out.printf("Ingresa la cantidad de %s que deseas convertir a %s%n",
                    divisa,divisaObjetivo);
            var cantidad = lectura.nextDouble();

            try {
                lectura.nextLine();
                ConsultaTasaDeCambio tasaDeCambio = api.buscaMoneda(divisa, divisaObjetivo, cantidad);
                System.out.println(tasaDeCambio);

                System.out.printf("%.2f %s equivalen a %.2f %s%n",
                        cantidad,
                        divisa,
                        tasaDeCambio.conversion_result(),
                        divisaObjetivo);

                GeneradorDeArchivo generador = new GeneradorDeArchivo();
                generador.guardarJson(tasaDeCambio);
            } catch (RuntimeException e){
                System.out.println(e.getMessage());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
