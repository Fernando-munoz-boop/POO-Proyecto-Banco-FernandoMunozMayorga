public class Main {
    public static void main(String[] args) {

        
        System.out.println("=== PRUEBA 1: Encapsulamiento ===");
        CuentaBancaria miCuenta = new CuentaBancaria("001", "Luzdary Rivera", 10000);
        // miCuenta.saldo = 50000;
        // ^ Esta línea NO compila: 'saldo' es private en CuentaBancaria, por lo que solo
        //   se puede usar dentro de esa clase. Desde Main el compilador da error de acceso.
        //   La única forma de cambiar el saldo es depositar() o retirar().
        System.out.println("Saldo (por getter): Lps. " + miCuenta.getSaldo());

        //PRUEBA 2 Atributos públicos
        System.out.println("\n=== PRUEBA 2: Acceso directo a atributos publicos ===");
        System.out.println("Titular: " + miCuenta.titular);
        System.out.println("Numero de cuenta: " + miCuenta.numeroCuenta);

        //PRUEBA 3 CuentaAhorro y comisión por exceso
        System.out.println("\n-- PRUEBA 3: CuentaAhorro (4 retiros)--");
        CuentaAhorro ahorro = new CuentaAhorro("002", " Fernando Muñoz", 3000, 5);
        for (int i = 1; i <= 4; i++) {
            System.out.println("Retiro " + i + ":");
            ahorro.retirarConComision(100);
            System.out.println("Saldo: Lps. " + ahorro.getSaldo());
        }

        //PRUEBA 4 Interés mensual
        System.out.println("\n-- PRUEBA 4: Rendimiento de ahorro--");
        System.out.println("Saldo antes del interes: Lps. " + ahorro.getSaldo());
        ahorro.aplicarInteresMensual();
        System.out.println("Saldo despues del interes: Lps. " + ahorro.getSaldo());

        //PRUEBA 5 CuentaCorriente y sobregiro
        System.out.println("\n-- PRUEBA 5: CuentaCorriente (sobregiro) --");
        CuentaCorriente corriente = new CuentaCorriente("003", "David Reyes", 1000,
                "Inversiones Rivera S.A.", 5000);
        System.out.println("Empresa: " + corriente.nombreEmpresa);
        corriente.retirarConSobregiro(3500);
        System.out.println("Saldo: Lps. " + corriente.getSaldo());
        System.out.println("Sobregiro utilizado: Lps. " + corriente.getSobregiroUtilizado());

        //PRUEBA 6 Amortización de deuda
        System.out.println("\n-- PRUEBA 6: Pago del sobregiro --");
        corriente.pagarSobregiro(1000);
        System.out.println("Sobregiro utilizado: Lps. " + corriente.getSobregiroUtilizado());
        corriente.pagarSobregiro(2000); 
        System.out.println("Estado final - Saldo: Lps. " + corriente.getSaldo()
                + " | Sobregiro utilizado: Lps. " + corriente.getSobregiroUtilizado());
    }
}
