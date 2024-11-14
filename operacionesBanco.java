import javax.swing.JOptionPane;
import Base.Cliente;
import Base.Cuenta;

public class operacionesBanco {

    Banco banco = new Banco();

    public operacionesBanco(){
        menuOpciones();
          }

  public void menuOpciones() {
    JOptionPane.showMessageDialog(null, "Bienvenido al menu de tu Banco MuchoDinero");
    String opcionTxt = JOptionPane.showInputDialog("Selecione una opción: \n °1 Crear una nueva Cuenta \n °2 Consultar el dinero que hay en el Banco \n °3 Consignar dinero \n °4 Retirar dinero \n °5 ¿Quien es el cliente con el mayor saldo?");
    int opcion = Integer.parseInt(opcionTxt);

    switch (opcion) {
        
        case 1:
            crearCuenta(banco);
            break;

        case 2:
            consultarTotal(banco);
            break;

        case 3: // Consignar dinero
            String numeroCuenta = JOptionPane.showInputDialog("Ingrese el número de la cuenta:");
            Cuenta cuenta = banco.buscarCuenta(numeroCuenta);
            if (cuenta != null) {
                double cantidad = Double.parseDouble(JOptionPane.showInputDialog("¿Cuanto dinero desea consignar?"));
                cuenta.consignar(cantidad);
                JOptionPane.showMessageDialog(null, "Consignación realizada con éxito.");
            } else {
                JOptionPane.showMessageDialog(null, "Cuenta no encontrada.");
            }
            break;

        case 4: // Retirar diner
            //la opción de retirar dinero de forma similar a consignar
            numeroCuenta = JOptionPane.showInputDialog("Ingrese el número de cuenta:");
            cuenta = banco.buscarCuenta(numeroCuenta);
            if (cuenta != null) {
                double cantidad = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la cantidad a retirar:"));
                if (cuenta.retirar(cantidad)) {
                    JOptionPane.showMessageDialog(null, "Retiro exitoso");
                } else {
                    JOptionPane.showMessageDialog(null, "Fondos insuficientes.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Cuenta no encontrada.");
            }
            break;
            
         case 5: // Consultar cliente con mayor saldo
         Cliente clienteMayorSaldo = banco.consultarClienteMayorSaldo();
         if (clienteMayorSaldo != null) {
             JOptionPane.showMessageDialog(null, "El cliente con mayor saldo es: " + clienteMayorSaldo.getNombre());
         } else {
             JOptionPane.showMessageDialog(null, "No hay clientes en el banco.");
         }
         break;
    }
    JOptionPane.showMessageDialog(null, "Opción inválida."); 
}

public void crearCuenta(Banco banco){
    int deseaAñadirNuevaCuenta = JOptionPane.YES_OPTION;
    
    do {

    String informacion = "";

    String numero = JOptionPane.showInputDialog("Ingrese el numero de cuenta:");
    String saldoInicialTxt = JOptionPane.showInputDialog("Ingrese el saldo inicial");
    double saldoInicial = Double.parseDouble(saldoInicialTxt);
    String tipo = JOptionPane.showInputDialog("Ingrese el tipo de cuenta:");
    String cedulaTitular = JOptionPane.showInputDialog("Ingrese el numero de Cedula:");
    String nombreTitular = JOptionPane.showInputDialog("Ingrese el nombre del Titular:");
    deseaAñadirNuevaCuenta = JOptionPane.showConfirmDialog(null, "¿Desea añadir más cuenta?", "continuar", JOptionPane.YES_NO_CANCEL_OPTION);
    
    banco.adicionarCuenta(numero, saldoInicial, tipo, cedulaTitular, nombreTitular);
    informacion += String.format("Numero de cuenta: %s \n Saldo: %s \n Tipo de cuenta: %s \n Cedula del titular: %s \n Nombre del titular: %s", numero, saldoInicial, tipo, cedulaTitular,nombreTitular);
    JOptionPane.showMessageDialog(null, informacion);
         
        } while (deseaAñadirNuevaCuenta == JOptionPane.YES_OPTION);
      }


    public void consultarTotal(Banco banco){

    JOptionPane.showMessageDialog(null, banco.consultarTotalDinero());

      }
}