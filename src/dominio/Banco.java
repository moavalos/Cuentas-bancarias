package dominio;

import java.util.ArrayList;

public class Banco {

	private String nombreBanco;
	private ArrayList<Cuenta> cuentas; // = new ArrayList<>();

	public Banco(String nombreBanco) {
		this.nombreBanco = nombreBanco;
		this.cuentas = new ArrayList<>();
	}

	public void agregarCuenta(Cuenta cuenta) {
		this.cuentas.add(cuenta); // ESTO ES UN MONTOOOOOOOOOOON

	}

	public Integer obtenerCantidadDeCuentas() {
		// return null; PRESTA MAS ATENCION MORAAAAAAAA
		return this.cuentas.size(); // QUEEEEEEEEEEEEEE
	}

	/*
	 * public Cuenta buscarCuentaPorId(Integer idCuenta) { for (int i = 0; i <
	 * cuentas.size(); i++) { if
	 * (this.cuentas.get(i).getIdCuenta().equals(idCuenta)) { return
	 * this.cuentas.get(i); } for (Cuenta cuenta : cuentas) { if
	 * (cuenta.getIdCuenta().equals(idCuenta)) return cuenta; } } return null; }
	 */

}
