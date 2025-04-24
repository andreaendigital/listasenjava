/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package semana07;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Andrea
 */
public class Semana07 {

    //Variables estáticas, de clase.
    static String nombreTeatro = "TEATRO MORO";
    static int capacidadSala = 20;
    static int entradasDisponibles = capacidadSala; //se inicializa en su capacidad total
    //entradas disponibles = capaciadSala - entradasVendidas
    static int entradasVendidas = 0;
    static Venta ultimaVenta; //almacena la ultima venta realizada por el sistema
    static int idEntrada = 1;
    static ArrayList<Entrada> listaEntradas = new ArrayList<>(); //importamos. Se crea de manera global la lista, almacenamos todas las entradas en el historico
    static ArrayList<Entrada> ultimasEntradasVendidas = new ArrayList<>(); //Almacenamos las ultimas entradas vendidas
    static ArrayList<Venta> listaVentas = new ArrayList<>(); //para almacenar todas las ventas realizadas.
    static int idVenta =1;
    static int idBoleta = 1;
    static double totalIngresos = 0; 
    static int totalVentasRealizadas = 0;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;
        Boleta boleta = null;
                    
        do{ //ciclo principal que genera iteración del menú
            mostrarMenu();  
            opcion = validarInt(scanner);
   
            switch(opcion){
                case 1:
                    ultimaVenta = venderEntradas(scanner);
                    if (ultimaVenta == null){
                        ultimasEntradasVendidas.clear();
                    break;
                    }
                    boleta = generarBoleta(ultimasEntradasVendidas, ultimaVenta, idBoleta);
                    idBoleta++;

                    break;
                case 2:
                    generarTickets();
                    break;
                case 3:
                    mostrarBoleta(boleta, ultimaVenta);
                    break;
                case 4:
                    resumenVentas();
                    break;
                case 5:
                    listarVentas();
                    break;
                case 6:
                    mensajeCierreSistema();
                    break;
                default:
                    System.out.println("Opcion no valida intente nuevamente");
            }
        } while( 6 != opcion);
    
        scanner.close();
    }//Cierre void main
    
    public static void mensajeCierreSistema(){
            System.out.println("--------------------------------------------------------------");
            System.out.println("--//////////////////////////////////////////////////////////--");
            System.out.println("||                                                          ||");        
            System.out.println("||      Cerrando el Sistema. Gracias por su compra.         ||");
            System.out.println("||                                                          ||");
            System.out.println("--//////////////////////////////////////////////////////////--");
            System.out.println("--------------------------------------------------------------");
    }//Cierre mensajeCierreSistema
    public static void listarVentas(){
        
        if(listaVentas.isEmpty()){
            System.out.println("--------------------------------------------------------------");
            System.out.println("--//////////////////////////////////////////////////////////--");
            System.out.println("||                                                          ||");        
            System.out.println("||             Aun no hay ventas realizadas                 ||");
            System.out.println("||                                                          ||");
            System.out.println("--//////////////////////////////////////////////////////////--");
            System.out.println("--------------------------------------------------------------");
        }else{
            System.out.println("");  
            System.out.println("--------------------------------------------------------------------------");
            System.out.println("--//////////////////////////////////////////////////////////////////////--");
            System.out.println("||                                                                      ||");        
            System.out.println("||                     LISTADO DE VENTAS REALIZADAS                     ||");
            System.out.println("||                                                                      ||");
                for (Venta venta : listaVentas) {
                venta.listarVentas();
                }
            System.out.println("||                                                                      ||"); 
            System.out.println("--//////////////////////////////////////////////////////////////////////--");
            System.out.println("--------------------------------------------------------------------------");
        }
    }//Cierre listarVentas
    
    //Método que muestra el menú: 
    static void mostrarMenu(){
        System.out.println("\n**************** " + nombreTeatro +  " ****************");
        System.out.println("**************** Bienvenido  ****************");
        System.out.println("1. Comprar Entradas");
        System.out.println("2. Generar Tickets de Entradas");
        System.out.println("3. Generar Boleta");
        System.out.println("4. Resumen de Ventas");
        System.out.println("5. Listar Ventas Realizadas");
        System.out.println("6. Salir");
        System.out.println("Ingrese numero de la opcion que desea ejecutar:");
    }  
    
    //Leer la opción y manejar error
    public static int validarInt(Scanner scanner){
        int opcionBusqueda =-1;
        while(true){
            if(scanner.hasNextInt()){
                opcionBusqueda = scanner.nextInt();
                break;
            }else{
                System.out.println("Opcion no valida. Ingrese un numero, por favor.");
                scanner.next(); //Evita bucle y limpia la entrada
            }
        }
        return opcionBusqueda;
    }    //Cierre validarInt
    
    public static void resumenVentas(){
        System.out.println("======= RESUMEN DE VENTAS =======");
        System.out.println("Total de ventas realizadas: " + totalVentasRealizadas);
        System.out.println("Total de entradas vendidas: " + entradasVendidas);
        System.out.println("Total de entradas disponibles: " +entradasDisponibles);
        System.out.println("Ingresos acumulados: $" + totalIngresos);
        System.out.println("=================================");
    }//Cierre resumenVentas
    
    public static void generarTickets(){
        System.out.println("-----------------------------");
        System.out.println("Generar Tickets de Entradas");
        System.out.println("-----------------------------");
        if(ultimasEntradasVendidas.isEmpty()){
            System.out.println("No hay ventas realizadas aun. Realice una compra para generar sus tickets.");
        }else{
            for (Entrada e : ultimasEntradasVendidas) {
                e.detalleEntrada();
            }
        }  
    }//Cierre generarTickets
    
    public static Boleta generarBoleta(List ultimasEntradasVendidas, Venta ultimaVenta, int idBoleta){



        if(ultimaVenta != null){
        //Uso la primera entrada vendida como referencia para obtener la información transversal
        Entrada entradaReferencia = (Entrada) ultimasEntradasVendidas.get(0);
        return new Boleta (ultimaVenta, idBoleta, entradaReferencia );
        //Creo una sola boleta para toda la venta
        //Boleta boletaActual = new Boleta (ultimaVenta, idBoleta, entradaReferencia ) ;

    
        }else{
            System.out.println("-----------------------------");
            System.out.println("Generar Boleta");
            System.out.println("-----------------------------");  
            System.out.println("No hay ventas registradas aun. Realice una compra para generar la boleta respectiva.");
            return null;
        }
    }//Cierre generarBoleta
    
    
    
    public static void mostrarBoleta(Boleta boleta, Venta ultimaVenta){
        System.out.println("-----------------------------");
        System.out.println("Generar Boleta de Entradas");
        System.out.println("-----------------------------");
        
        if ( boleta != null && ultimaVenta != null ){
            boleta.imprimirBoleta(ultimaVenta);
        }else{
            
            System.out.println("No hay boletas para imprimir. Realice una compra para generar la venta y su respectiva boleta.");
        }
    }//Cierre mostrarBoleta

    
    public static String solicitarUbicacion(Scanner scanner){
    
        String ubicacionEntrada;

        // Manejo de error con ciclo do-while para validar la entrada
        do {
            System.out.println("Ingrese la ubicacion que desea comprar: (VIP, Platea, General)");
            ubicacionEntrada = scanner.next().trim().toLowerCase(); 

            // Validar que la ubicación sea una opción válida
            if (!ubicacionEntrada.equals("vip") && 
                !ubicacionEntrada.equals("platea") && 
                !ubicacionEntrada.equals("general")) {
                System.out.println("Ubicacion no valida, por favor ingrese VIP, Platea o General.");
            }

        } while (!ubicacionEntrada.equals("vip") && 
                 !ubicacionEntrada.equals("platea") && 
                 !ubicacionEntrada.equals("general"));

        return ubicacionEntrada;

    }//Cierre solicitarUbicacion
    
    public static int solicitarCantidadEntradas(Scanner scanner){
        int cantidadEntradas;
        //NUMERO DE ENTRADAS
        //manejo de error, validación ingreso usuario con ciclo do while
        do{
            System.out.println("\nIngrese la cantidad de entradas que desea: ");
            cantidadEntradas = validarInt(scanner);
            System.out.println("\n***************************");
            System.out.println("Usted desea comprar " + cantidadEntradas + " entradas");
                if (cantidadEntradas > entradasDisponibles) {
                    System.out.println("\n***************************");
                    System.out.println("Solo hay " + entradasDisponibles + " entradas disponibles.");
                    System.out.println("Por favor, ingrese una cantidad valida.");
                    System.out.println("***************************\n");
                } else if (cantidadEntradas <= 0) {
                    System.out.println("Debe ingresar al menos una entrada.");
                } else {
                    System.out.println("\n***************************");
                    System.out.println("Quedan " + entradasDisponibles + " entradas disponibles.");
                    System.out.println("***************************\n");
                    break; // cantidad válida, salimos del bucle
                }
        } while(true);
                        

        
    return cantidadEntradas;   
        
    }//Cierre soliicitarCantidadEntrads
   
    public static int solicitarEdad(Scanner scanner){
        int edad;
        System.out.println("--------------------------------------------------------------");
        System.out.println("\nAhora ingrese su edad para validar aplicacion de descuentos:");
        edad = validarInt(scanner);
        return edad;
    }//Cierre solicitarEdad
    
    public static String[] validarDescuento(Scanner scanner, int edad){
        String[] descuentoInfo = new String[2];

        //double descuento; 
        
        //Validación de edad y..
        // Calcular Precio final en un ciclo do while o while, aplicando los descuentos
            //Aplicar descuento 10% para estudiantes, 
            //15 % para personas de la tercera edad, mayores de 60 años. El cálculo sería precioBase * 0.85 corresponde al 15%
        //precioBase * 0.9 corresponde  al 10% de descuento para estudiantes 

        
                if(edad>60){
                System.out.println("------------------------------------");
                System.out.println("Aplica descuento del 15%, para tercera edad.");
                descuentoInfo[0] = "0.85";
                descuentoInfo[1] = "Tercera Edad. 15%";
                //totalPagar = (int) (precioBase * descuento)*cantidadEntradas;
                
                } else if (edad<23){
                     System.out.println("------------------------------------");
                    System.out.println("Aplica descuento del 10%, para estudiantes.");
                    descuentoInfo[0] = "0.9";
                    descuentoInfo[1] = "Estudiante. 10%";
                
                } else{
                        System.out.println("------------------------------------");
                        System.out.println("No aplica descuentos, tarifa normal.");
                        descuentoInfo[0] = "0";
                        descuentoInfo[1] = "Sin Descuento. Valor Normal de la entrada";
                        
                }

            return descuentoInfo; //retorno el array con la informacion

    }//Cierre de validarDescuento
    
    public static int calcularValorEntradas(Scanner scanner, int precioBase, double descuento, int cantidadEntradas){
      
        int totalPagar;
        
        if(descuento == 0){
           totalPagar = precioBase*cantidadEntradas;
        } else{
           totalPagar = (int) (precioBase*descuento)*cantidadEntradas;  
        }
        
        return totalPagar;
        
    }//Cierre calcularValorEntradas
    
    public static int precioSegunUbicacion(String ubicacionEntrada){
            
        int precioBase = 0;
            
            //Uso switch para asignar el precio Base de cada entrada según la ubicación elegida.
            switch (ubicacionEntrada){
                case "vip":
                    precioBase = 25000;
                        System.out.println("");  
                        System.out.println("-----------------------------------------------");
                        System.out.println("--///////////////////////////////////////////--");
                        System.out.println(" ");        
                        System.out.println("El valor de las entradas VIP es de $" + precioBase+ " cada una.");
                        System.out.println(" ");        
                        System.out.println("--///////////////////////////////////////////--");
                        System.out.println("-----------------------------------------------");
            
                    break;
                case "platea":
                    precioBase = 18000;
                        System.out.println("");  
                        System.out.println("-----------------------------------------------");
                        System.out.println("--///////////////////////////////////////////--");
                        System.out.println(" ");        
                        System.out.println("El valor de las entradas PLATEA es de $" + precioBase+ " cada una.");
                        System.out.println(" ");        
                        System.out.println("--///////////////////////////////////////////--");
                        System.out.println("-----------------------------------------------");
                    break;
                case "general":
                    precioBase = 10000;
                        System.out.println("");  
                        System.out.println("-----------------------------------------------");
                        System.out.println("--///////////////////////////////////////////--");
                        System.out.println(" ");        
                        System.out.println("El valor de las entradas GENERAL es de $" + precioBase+ " cada una.");
                        System.out.println(" ");        
                        System.out.println("--///////////////////////////////////////////--");
                        System.out.println("-----------------------------------------------");
                    break;
            }
        
        return precioBase;
        
    }//Cierre precioSegunUbicacion
    
    public static Venta venderEntradas(Scanner scanner){
        ///Retorna un objeto venta
        String nombreCliente;
               
        if (entradasDisponibles > 0){
            
            String ubicacionEntrada = solicitarUbicacion(scanner);
            int precioBase = precioSegunUbicacion(ubicacionEntrada);
            int cantidadEntradas = solicitarCantidadEntradas(scanner);
            
            int edad = solicitarEdad(scanner);
            String[] descuentoInfo = validarDescuento(scanner, edad);
            double descuento = Double.parseDouble(descuentoInfo[0]);
            
            String tipoDescuento = descuentoInfo[1];
            
            
            int totalPagar = calcularValorEntradas (scanner, precioBase, descuento, cantidadEntradas);
            
            System.out.println("\nFinalmente ingrese su nombre:");
            nombreCliente = scanner.next().trim().toLowerCase();
            
            //Cálculo del valor individual de cada entrada en la compra:   
            int valorUnitario = totalPagar/cantidadEntradas;
            
            mostrarResumenCompra(nombreCliente, cantidadEntradas, ubicacionEntrada, totalPagar, precioBase, valorUnitario);
            
            //Crear la venta y almacenarla en una lista
            Venta ventaRealizada = new Venta (idVenta, totalPagar, cantidadEntradas);
            idVenta++;
            totalVentasRealizadas++;
            totalIngresos += ventaRealizada.getTotalPagar();
            
            //almacenar la venta en una lista de ventas
            listaVentas.add(ventaRealizada); //almaceno cada venta en una lista
            
            
            //Crear la(s) entrada(s) y almacenarla(s) en una lista
            ultimasEntradasVendidas.clear();
            for(int i=1; i<= cantidadEntradas; i++){
                entradasVendidas++;
                entradasDisponibles--;
                
                Entrada nuevaEntrada = new Entrada(nombreCliente, idEntrada, tipoDescuento, ubicacionEntrada, valorUnitario, precioBase);
                ultimasEntradasVendidas.add(nuevaEntrada);
                listaEntradas.add(nuevaEntrada);
                //nuevaEntrada.detalleEntrada(); //puedo quitar esto de esta parte y luego lo pongo al llamar la impresión de los tickets
                
                //contadorEntradas++;
                idEntrada++; //permite asignarle un id a cada entrada, distinto y unico y secuencial
            }
            
            
            
         return ventaRealizada;     
            
        } else{
            System.out.println("\n*****************************************");
            System.out.println("No hay entradas disponibles para la venta");
            System.out.println("*****************************************");
          return null;
        }
       
    }   //Cierre venderEntradas  
    
    public static void mostrarResumenCompra (String nombreCliente, int cantidadEntradas, String ubicacionEntrada, double totalPagar, double precioBase, double valorUnitario){
                //Resumen de la compra
            System.out.println("-----------------------------------------------");
            System.out.println("--///////////////////////////////////////////--");
            System.out.println("||                                           ||");        
            System.out.println("||            RESUMEN DE LA COMPRA           ||");
            System.out.println("||                                           ||");
            System.out.println("|| A nombre de : " + nombreCliente+ "                      ||");
            System.out.println("|| Cantidad de entradas compradas: " + cantidadEntradas + "         ||" );

            System.out.println("|| Ubicacion de las entradas: " + ubicacionEntrada +"            ||");
            //System.out.println("Descuento aplicado: " + tipoEntrada);
            System.out.println("|| Precio final a pagar: " + totalPagar+"             ||");
            System.out.println("||*******************************************||"); 
            System.out.println("|| Valor unitario sin descuento: " + precioBase+"     ||");
            System.out.println("|| Valor unitario con descuento: " + valorUnitario+"     ||");
            System.out.println("||                                           ||");
            System.out.println("||                                           ||");
            System.out.println("--///////////////////////////////////////////--");
            System.out.println("-----------------------------------------------");
    
    

            System.out.println("\nProcesando la compra..... espere 3 segundos");
            
            try {
                Thread.sleep(3000); // Pausa de 3 segundos (3000 milisegundos)
            } catch (InterruptedException e) {
                 e.printStackTrace();
            }
            
            System.out.println("\n************************************"); 
            System.out.println("Has comprado la entrada exitosamente");
            System.out.println("************************************");   
    }//Cierre mostrarResumenCompra
    
    static class Entrada{

        //Variables de instancia, no estáticas:
        String nombreCliente; // quien compra la entrada
        int idEntrada; // id de la entrada
        String tipoDescuento; //descuento estudiante, descuento tercera edad, normal,
        String ubicacionEntrada; //vip, platea, balcon
        int valorEntrada; // valor precio unitario, no precio base
        int precioBase;
 
        //Constructor
        public Entrada(String nombreCliente, int idEntrada, String tipoDescuento, String ubicacionEntrada, int valorEntrada, int precioBase){
            this.nombreCliente = nombreCliente;
            this.idEntrada = idEntrada;
            this.tipoDescuento = tipoDescuento;
            this.ubicacionEntrada = ubicacionEntrada;
            this.valorEntrada = valorEntrada;
            this.precioBase = precioBase;
        } //Cierre constructor Entrada

        //Metodo para mostrar info de la Entrada
        public void detalleEntrada(){
            System.out.println("");  
            System.out.println("-----------------------------------------------");
            System.out.println("--///////////////////////////////////////////--");
            System.out.println("||                                           ||");        
            System.out.println("||            TICKET DETALLE ENTRADA         ||");
            System.out.println("||                                           ||");
            System.out.println("  Num de su entrada: " + idEntrada);
            System.out.println("  Tipo de Descuento: " + tipoDescuento); 
            System.out.println("  Ubicacion de la Entrada: " + ubicacionEntrada);
            System.out.println("  Entrada comprada a nombre de: " + nombreCliente);
            System.out.println("  Valor Unitario de la entrada: " + valorEntrada);
            System.out.println("--///////////////////////////////////////////--");
            System.out.println("-----------------------------------------------");
        }

        //Metodo Getter para acceder:
        public int getId(){
            return idEntrada;
        }

        public String getTipoEntrada() {
            return tipoDescuento;
        }

        public String getUbicacionEntrada() {
            return ubicacionEntrada;
        }

        public String getNombreCliente(){
            return nombreCliente;
        }

        public String getTipoDescuento(){
            return tipoDescuento;
        }

        public int getPrecioBase(){
            return precioBase;
        }

        public int getValorEntrada(){
            return valorEntrada;
        }
        
        
    }//Cierre clase Entrada
    
    static class Venta{
        //Variables de instancia, no estáticas:
        int idVenta; // id de la Boleta
        int totalPagar; //valor total a pagar
        int cantidadEntradas; //Cantidad de entradas compradas
        //List<Entrada> entradas; //Una lista de tipo entrada, llamada Entradas que contiene el detalle de cada entrada
        //Entrada entrada;
        
            //Constructor
            public Venta(int idVenta, int totalPagar, int cantidadEntradas){
                this.idVenta = idVenta;
                this.totalPagar = totalPagar;
                this.cantidadEntradas = cantidadEntradas;
                //this.entradas = entradas;
                //this.entrada = entrada;
            } //Cierre constructor Venta
            
            
            public int getCantidadEntradas(){
                return cantidadEntradas;
            }
    
            public int getTotalPagar(){
                return totalPagar;
            }
            
        public void listarVentas(){

            System.out.println("||  Num de Venta: " + idVenta + " || Cantidad de Entradas: " + cantidadEntradas + " || Total pagado: " + totalPagar + "   ||");

        }            
            
         
    }//Cierre clase Venta
     
    static class Boleta {
        //Variables de instancia, no estáticas:
        private Venta venta;
        private Entrada entrada;
        
        int idBoleta; // id de la Boleta
      
            //Constructor
            public Boleta(Venta venta, int idBoleta, Entrada entrada){
                this.venta = venta;
                this.idBoleta = idBoleta;
                this.entrada = entrada;
                
            } //Cierre constructor Entrada

 
            
            //Metodo para mostrar info de la Boleta
            public void imprimirBoleta(Venta venta){
                System.out.println("");
                System.out.println("-------------------------------------------------");
                System.out.println("--/////////////////////////////////////////////--");
                System.out.println("||                                             ||");
                System.out.println("||             BOLETA "+nombreTeatro+"             ||");
                System.out.println("||                                             ||");
                System.out.println("--/////////////////////////////////////////////--");
                System.out.println("-------------------------------------------------");
                System.out.println("||                                             ||");
                System.out.println("|| Num de boleta: " + idBoleta);
                System.out.println("|| Entrada comprada a nombre de: " + entrada.getNombreCliente() );
                System.out.println("|| Cantidad de Entradas compradas: " + venta.getCantidadEntradas() );
                System.out.println("|| Ubicacion de las Entradas: " + entrada.getUbicacionEntrada());

                System.out.println("|| Valor de la entrada segun Ubicacion: " + entrada.getPrecioBase());
                System.out.println("|| Tipo de Descuento Aplicado: " + entrada.getTipoDescuento()); 
                System.out.println("|| Valor Unitario de la entrada: " + entrada.getValorEntrada());
                System.out.println("|| Valor total a pagar: " + venta.getTotalPagar());
                System.out.println("||                                                 ");
                System.out.println("-------------------------------------------------");
                System.out.println("--/////////////////////////////////////////////--");
                System.out.println("||                                             ||");
                System.out.println("||                                             ||");
                System.out.println("||            GRACIAS POR SU COMPRA            ||");
                System.out.println("||                                             ||");
                System.out.println("||                                             ||");
                System.out.println("--/////////////////////////////////////////////--");
                System.out.println("-------------------------------------------------");


                                
            }//Cierre de imprimirBoleta

    } //Cierre clase Boleta


    

}//Cierre Clase Principal
