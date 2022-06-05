package interfaz;

import java.util.Scanner;

import org.junit.Assert;
import org.junit.Test;

import dominio.CajeroAutomatico;
import dominio.Cuenta;

public class TestCuenta {

	final static int DEPOSITAR = 1, EXTRAER = 2, CONSULTAR = 3, SALIR = 4;

	@Test
	public void queAlCrearLacuentaSuSaldoSeaCero() {
		Cuenta cuenta = cuandoCreoCuenta();
		entoncesSuSaldoEs(cuenta, 0.0);

	}

	@Test
	public void queAlAgregarSaldoACuentaElMismoSeIncremente() {
		Cuenta cuenta = dadoQueExisteCuenta();
		cuandoAgregoSaldo(cuenta, 100.00);
		entoncesSuSaldoEs(cuenta, 100.00);
	}

	@Test
	public void queAlRetirarSaldoACuentaElMismoSeDecremente() {
		Cuenta cuenta = dadoQueExisteCuenta();
		dadoQueAgregoSaldo(cuenta, 100.00);
		cuandoExtraigoSaldo(cuenta, 50.00);
		entoncesSuSaldoEs(cuenta, 50.00);
	}

	@Test
	public void queNopuedoExtraerUnMontoSuperiorAlSaldoDeLaCuenta() {
		Cuenta cuenta = dadoQueExisteCuenta();
		dadoQueAgregoSaldo(cuenta, 100.00);
		cuandoExtraigoSaldo(cuenta, 200.00);
		entoncesSuSaldoEs(cuenta, 100.00);
	}

	@Test
	public void queNoPuedoDepositarValorNegativo() {
		Cuenta cuenta = dadoQueExisteCuenta();
		cuandoAgregoSaldo(cuenta, -100.00);
		entoncesSuSaldoEs(cuenta, 00.00);
	}

	@Test
	public void queNoPuedoExtraerValorNegativo() {
		Cuenta cuenta = dadoQueExisteCuenta();
		cuandoAgregoSaldo(cuenta, 200.00);
		cuandoExtraigoSaldo(cuenta, -100.00);
		entoncesSuSaldoEs(cuenta, 200.00);
	}

	@Test
	public void queSePuedaTranferirDineroAOtraCuenta() {
		Cuenta cuentaOrigen = dadoQueExisteCuenta();
		Cuenta cuentaDestino = dadoQueExisteCuenta();
		dadoQueAgregoSaldo(cuentaOrigen, 100.00);
		cuandoTransfieroSaldo(cuentaOrigen, cuentaDestino, 50.00);
		entoncesSuSaldoEs(cuentaOrigen, 50.00);
		entoncesSuSaldoEs(cuentaDestino, 50.00);
	}

	@Test
	public void queNoSePuedaTranferirMontoNegativoAOtraCuenta() {
		Cuenta cuentaOrigen = dadoQueExisteCuenta();
		Cuenta cuentaDestino = dadoQueExisteCuenta();
		dadoQueAgregoSaldo(cuentaOrigen, 100.00);
		cuandoTransfieroSaldo(cuentaOrigen, cuentaDestino, -50.00);
		entoncesSuSaldoEs(cuentaOrigen, 100.00);
		entoncesSuSaldoEs(cuentaDestino, 00.00);
	}

	@Test
	public void queNoSePuedaTranferirSinMontoSufuciente() {
		Cuenta cuentaOrigen = dadoQueExisteCuenta();
		Cuenta cuentaDestino = dadoQueExisteCuenta();
		dadoQueAgregoSaldo(cuentaOrigen, 100.00);
		cuandoTransfieroSaldo(cuentaOrigen, cuentaDestino, 150.00);
		entoncesSuSaldoEs(cuentaOrigen, 100.00);
		entoncesSuSaldoEs(cuentaDestino, 00.00);
	}

	@Test
	public void queSeRegistranTransaccionesPorDeposito() {
		Cuenta cuenta = dadoQueExisteCuenta();
		cuandoAgregoSaldo(cuenta, 100.00);
		cuandoAgregoSaldo(cuenta, 100.00);
		entoncesExisteTransaccion(cuenta, 2);
	}

	@Test
	public void queSeRegistranTransaccionesPorExtraccion() {
		Cuenta cuenta = dadoQueExisteCuenta();
		cuandoAgregoSaldo(cuenta, 100.00);
		cuandoExtraigoSaldo(cuenta, 100.00);
		entoncesExisteTransaccion(cuenta, 2);
	}

	@Test
	public void queSeRegistranTransaccionesPorTranferenciaEnOrigenYDetino() {
		Cuenta cuentaOrigen = dadoQueExisteCuenta();
		Cuenta cuentaDestino = dadoQueExisteCuenta();
		dadoQueAgregoSaldo(cuentaOrigen, 100.00);
		cuandoTransfieroSaldo(cuentaOrigen, cuentaDestino, 50.00);
		entoncesExisteTransaccion(cuentaOrigen, 2);
		entoncesExisteTransaccion(cuentaDestino, 1);
	}

	@Test
	public void queSeRegistraronLosDepositos() {
		Cuenta cuenta = dadoQueExisteCuenta();
		cuandoAgregoSaldo(cuenta, 100.00);
		cuandoAgregoSaldo(cuenta, 100.00);
		cuandoExtraigoSaldo(cuenta, 100.00);
		entoncesExisteDepositos(cuenta, 2);
	}

	private void entoncesExisteDepositos(Cuenta cuenta, Integer cantidad) {
		Assert.assertEquals(cantidad, (Integer) cuenta.getDepositos().size());

	}

	private void entoncesExisteTransaccion(Cuenta cuenta, Integer cantidad) {
		Assert.assertEquals(cantidad, (Integer) cuenta.getTransacciones().size());

	}

	private void cuandoTransfieroSaldo(Cuenta cuentaOrigen, Cuenta cuentaDestino, Double monto) {
		cuentaOrigen.tranferir(cuentaDestino, monto);

	}

	private void cuandoExtraigoSaldo(Cuenta cuenta, Double monto) {
		cuenta.extraer(monto);

	}

	private void dadoQueAgregoSaldo(Cuenta cuenta, Double monto) {
		cuenta.depositar(monto);

	}

	private Cuenta dadoQueExisteCuenta() {
		return new Cuenta(0.0);

	}

	private void cuandoAgregoSaldo(Cuenta cuenta, Double monto) {
		cuenta.depositar(monto);
	}

	private void entoncesSuSaldoEs(Cuenta cuenta, Double saldo) {
		Assert.assertEquals(saldo, cuenta.getSaldoInicial());

	}

	private Cuenta cuandoCreoCuenta() {
		return new Cuenta(0.0);

	}

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		Integer opcionDeseada = 0;
		String cliente = "", numCuenta = "";
		Double tipoInteres = 0.0, saldo = 250.0;
		CajeroAutomatico cajerito = new CajeroAutomatico(cliente, numCuenta, tipoInteres, saldo);

		do {
			System.out.println("");
			System.out.println("BIENVENIDO");
			System.out.println("-----------------------------");
			System.out.println("Seleccione la opcion deseada.");
			System.out.println("1 - Depositar");
			System.out.println("2 - Extraer");
			System.out.println("3 - Consultar");
			System.out.println("4 - Salir");

			opcionDeseada = teclado.nextInt();

			switch (opcionDeseada) {
			case DEPOSITAR:
				depositar(saldo, teclado);
				break;
			case EXTRAER:
				extraer(saldo, teclado);
				break;
			case CONSULTAR:
				consultar(cajerito);
				break;
			case SALIR:
				System.out.println("chauchis");
				break;
			default:
				System.out.println("ERROR");
				break;

			}
		} while (opcionDeseada != SALIR);

	}

	public static void depositar(Double saldo, Scanner teclado) {
		System.out.println("ingrese cuanto quiere depositar");
		double deposito = teclado.nextDouble();
		saldo = saldo + deposito;
		System.out.println("su saldo es de " + saldo);

	}

	public static void extraer(Double saldo, Scanner teclado) {
		System.out.println("ingrese cuanto quiere extraer");
		Double extraccion = teclado.nextDouble();
		if (saldo > extraccion) {
			saldo = saldo - extraccion;
		} else {
			System.out.println("error");
		}
		System.out.println("su saldo es de " + saldo);

	}

	public static String consultar(CajeroAutomatico cajerito) {
		return cajerito.toString();

	}

}
