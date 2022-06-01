package interfaz;

import org.junit.Assert;
import org.junit.Test;

import dominio.Cuenta;

public class TestCuenta {

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
}
