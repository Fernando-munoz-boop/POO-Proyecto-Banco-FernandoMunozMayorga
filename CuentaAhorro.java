
/**
 * @author munoz
 */
public class CuentaAhorro extends CuentaBancaria {
    //público
    public double tasaInteresAnual; // ejemplo: 4.5 significa 4.5%

    //privado
    private int retirosRealizadosMes;
    private double comisionPorExceso = 20.0;

    // Constructor
    public CuentaAhorro(String numeroCuenta, String titular, double saldoInicial, double tasaInteresAnual) {
        super(numeroCuenta, titular, saldoInicial);
        this.tasaInteresAnual = tasaInteresAnual;
        this.retirosRealizadosMes = 0;
    }

    // Retiro con comisión 
    public boolean retirarConComision(double monto) {
        if (retirosRealizadosMes >= 3) {
            
            double montoTotal = monto + comisionPorExceso;
            if (retirar(montoTotal)) {
                retirosRealizadosMes++;
                System.out.println("Retiro de Lps. " + monto + " realizado. Comisión cobrada: Lps. " + comisionPorExceso);
                return true;
            }
            return false;
        } else {
            // Menos de 3 retiros: retiro normal, sin recargo
            if (retirar(monto)) {
                retirosRealizadosMes++;
                System.out.println("Retiro de Lps. " + monto + " realizado sin comisión.");
                return true;
            }
            return false;
        }
    }

   
    public void aplicarInteresMensual() {
        double interes = (getSaldo() * (tasaInteresAnual / 100)) / 12;
        depositar(interes);
    }
}
