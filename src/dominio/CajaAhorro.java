package dominio;

public class CajaAhorro extends Cuenta {
	/*
	 * Similar a la anterior, pero se pide que luego de la quinta extracción de
	 * dinero se cobre un costo adicional por extracción de $ 6
	 */

	private Double reserva = 0.0;

	public CajaAhorro(Double reserva) {
		super(0.0);
		this.reserva = reserva;
	}

	public void reservar(Double monto) {
		this.reserva = monto;
		this.saldo = this.saldo - monto;
	}

	public Double getSaldo() {
		return this.saldo;
	}

	// Cuando deseo invocar el comportamiento del metodo sobreescrito.
	@Override
	public void depositar(Double monto) {
		this.saldo = this.saldo + monto;

	}

}
