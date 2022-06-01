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

}
