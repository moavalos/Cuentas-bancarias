package interfaz;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import dominio.Banco;
import dominio.Cliente;
import dominio.Cuenta;

public class TestBanco {

	@Test
	public void queSePuedaAgregarUnaCuentaAlBanco() {
		String nombreBanco = "Supervielle";
		Banco banco = new Banco(nombreBanco);

		Integer idCliente = 1;
		String nombreCliente = "Pepe";
		Cliente cliente = new Cliente(nombreCliente, idCliente);

		Integer idCuenta = 1;
		Double saldoInicial = 50.0;
		Cuenta cuenta = new Cuenta(idCuenta, cliente, saldoInicial);

		banco.agregarCuenta(cuenta);

		Cuenta cuentaEncontrada = banco.buscarCuentaPorId(idCuenta);
		assertEquals(cuentaEncontrada, cuenta);

		/*
		 * Integer valorEsperado = 1; Integer valorObtenido =
		 * banco.obtenerCantidadDeCuentas(); assertEquals(valorEsperado, valorObtenido);
		 */

		/*
		 * test extraer plata y depositar en una cuenta, pero que no se permita extraer
		 * más de lo permitido. extraer depósitos y fondos insuficientes. 4to método
		 * (que se pueda hacer una transferencia) 5to pasar dos transferencia buscar por
		 * cuenta y buscar id cuentas
		 */

	}
}
