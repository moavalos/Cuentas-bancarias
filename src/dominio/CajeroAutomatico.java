package dominio;

public class CajeroAutomatico {

	private String cliente;
	private String numCuenta;
	private double tipoInteres;
	private double saldo;

	public CajeroAutomatico(String cliente, String numCuenta, double tipoInteres, double saldo) {
		this.cliente = cliente;
		this.numCuenta = numCuenta;
		this.tipoInteres = tipoInteres;
		this.saldo = saldo;

	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public String getNumCuenta() {
		return numCuenta;
	}

	public void setNumCuenta(String numCuenta) {
		this.numCuenta = numCuenta;
	}

	public double getTipoInteres() {
		return tipoInteres;
	}

	public void setTipoInteres(double tipoInteres) {
		this.tipoInteres = tipoInteres;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public String toString() {
		return "Usted es " + cliente + " , su numero de cuenta es " + numCuenta + " , el tipo de interes es "
				+ tipoInteres + " y su saldo es de " + saldo;
	}

}
