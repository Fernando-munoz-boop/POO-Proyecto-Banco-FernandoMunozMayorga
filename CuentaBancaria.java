
public class CuentaBancaria {
    public String numeroCuenta;
    public String titular;

    
    private double saldo;
    private int totalTransacciones;

   
    public CuentaBancaria(String numeroCuenta, String titular, double saldoInicial){
        this.numeroCuenta = numeroCuenta;
        this.titular = titular;
        // Si el saldo inicial es negativo, se asigna 0.0
        if (saldoInicial < 0) {
            this.saldo = 0.0;
        } else {
            this.saldo = saldoInicial;
        }
        this.totalTransacciones = 0;
    }

   
    public double getSaldo() {
        return saldo;
    }

    public int getTotalTransacciones() {
        return totalTransacciones;
    }

   
    public void depositar(double monto) {
        if (monto > 0) {
            saldo += monto;
            totalTransacciones++;
            System.out.println("Deposito exitoso: Lps. " + monto);
        } else {
            System.out.println("Error: el monto del depósito debe ser mayor que 0.");
        }
    }

    
    public boolean retirar(double monto) {
        if (monto > 0 && saldo >= monto) {
            saldo -= monto;
            totalTransacciones++;
            return true;
        }
        System.out.println("Error: monto inválido o saldo insuficiente.");
        return false;
    }

    
    public void mostrarDatos() {
        System.out.println("Titular: " + titular);
        System.out.println("Numero de cuenta: " + numeroCuenta);
        System.out.println("Saldo actual: Lps. " + saldo);
        System.out.println("Total de transacciones: " + totalTransacciones);
    }
    
}
