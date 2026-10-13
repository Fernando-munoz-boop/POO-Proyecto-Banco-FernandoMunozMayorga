
/**
 * @author munoz
 */
public class CuentaCorriente extends CuentaBancaria {
    //público
    public String nombreEmpresa;

    //privados
    private double limiteSobregiro;
    private double sobregiroUtilizado;

    // Constructor
    public CuentaCorriente(String numeroCuenta, String titular, double saldoInicial,
                           String nombreEmpresa, double limiteSobregiro) {
        super(numeroCuenta, titular, saldoInicial);
        this.nombreEmpresa = nombreEmpresa;
        this.limiteSobregiro = limiteSobregiro;
        this.sobregiroUtilizado = 0.0;
    }

    // Getters
    public double getLimiteSobregiro() {
        return limiteSobregiro;
    }

    public double getSobregiroUtilizado() {
        return sobregiroUtilizado;
    }

    // Retiro 
    public boolean retirarConSobregiro(double monto) {
        if (monto <= 0) {
            System.out.println("Error: el monto debe ser mayor que 0.");
            return false;
        }

        // Caso 1: el saldo alcanza, retiro normal
        if (getSaldo() >= monto) {
            return retirar(monto);
        }

        // Caso 2: el saldo no alcanza se revisa el cupo de crédito disponible
        double creditoDisponible = limiteSobregiro - sobregiroUtilizado;
        if (monto <= getSaldo() + creditoDisponible) {
            double diferencia = monto - getSaldo();  
            double recargo = diferencia * 0.03;      

            // Se usa todo el saldo disponible
            if (getSaldo() > 0) {
                retirar(getSaldo());
                 }

            sobregiroUtilizado += diferencia + recargo;
            System.out.println("Retiro con sobregiro realizado. Crédito usado: Lps. " + diferencia
                    + " | Recargo 3%: Lps. " + recargo);
            return true;
        }

        // Caso 3: excede el cupo, se rechaza
        System.out.println("Error: el monto excede el cupo de sobregiro autorizado.");
        return false;
    }

    
    public void pagarSobregiro(double monto) {
        if (monto <= 0) {
            System.out.println("Error: el monto del pago debe ser mayor que 0.");
            return;
        }

        if (monto <= sobregiroUtilizado) {
            sobregiroUtilizado -= monto;
            System.out.println("Pago aplicado al sobregiro: Lps. " + monto);
        } else {
            double excedente = monto - sobregiroUtilizado;
            System.out.println("Sobregiro pagado completamente: Lps. " + sobregiroUtilizado);
            sobregiroUtilizado = 0.0;
            depositar(excedente);   
        }
    }
}
