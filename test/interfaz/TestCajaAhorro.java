package interfaz;

import org.junit.Assert;
import org.junit.Test;

import dominio.CajaAhorro;

public class TestCajaAhorro {
	@Test
	public void quePermiteReservarSaldo() {
		CajaAhorro cuenta = dadoQueExisteCuenta();
		dadoQueDeposito(cuenta, 100.00);
		cuandoReservoSaldo(cuenta, 50.00);
		entoncesSuSaldoEs(cuenta, 50.00);
	}

	private void dadoQueDeposito(CajaAhorro cuenta, Double monto) {
		cuenta.depositar(monto);
	}

	private void entoncesSuSaldoEs(CajaAhorro cuenta, Double monto) {
		Assert.assertEquals(cuenta.getSaldo(), monto);
	}

	private CajaAhorro dadoQueExisteCuenta() {
		return new CajaAhorro(0.0);
	}

	private void cuandoReservoSaldo(CajaAhorro cuenta, Double monto) {
		cuenta.reservar(monto);
	}

}
