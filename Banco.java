import java.util.ArrayList;
import Base.Cliente;
import Base.Cuenta;

public class Banco {
    String nombre;
    ArrayList<Cuenta> cuentas;

    // Constructor
    public Banco() {
        this.cuentas = new ArrayList<>();
    }

    // Método para buscar una cuenta
    public Cuenta buscarCuenta(String numeroCuenta) {
        for (Cuenta cuenta : cuentas) {
            if (cuenta.getNumero().equals(numeroCuenta)) {
                return cuenta;
            }
        }
        return null;
    }

    // Método para añadir una nueva cuenta
    public boolean adicionarCuenta(String numero, double saldoInicial, String tipo, String cedulaTitular, String nombreTitular){
        Cliente cliente = new Cliente(cedulaTitular, nombreTitular);

        if (this.buscarCuenta(numero) != null){
            return false;
        }else {
            Cuenta cuenta = new Cuenta(numero, tipo, saldoInicial, cliente);
            cuentas.add(cuenta);
            return true;
        }
    }

    // Método para calcular el total de dinero
    public double consultarTotalDinero() {
        double total = 0;
        // Recorre la lista de cuentas y suma los saldos de cada cuenta
        for (Cuenta cuenta : cuentas) {
            total += cuenta.getSaldo();
        }
        return total;
    }

    // Método para encontrar el cliente con el mayor saldo
    public Cliente consultarClienteMayorSaldo() {
        // Inicializa una variable para almacenar el cliente con mayor saldo
        Cliente clienteMayorSaldo = null;
        double mayorSaldo = 0;
    
        // Recorre la lista de cuentas  y compara los saldos
        for (Cuenta cuenta : cuentas) {
            if (cuenta.getSaldo() > mayorSaldo) {
                mayorSaldo = cuenta.getSaldo();
                clienteMayorSaldo = cuenta.getTitular();
            }
        }
        return clienteMayorSaldo;
    }

} 