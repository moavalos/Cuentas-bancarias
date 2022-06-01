package dominio;

public class Cuenta {

	private Integer idCuenta;
	private Cliente cliente;
	private Double saldoInicial;

	public Cuenta(Integer idCuenta, Cliente cliente, Double saldoInicial) {
		this.idCuenta = idCuenta;
		this.cliente = cliente;
		this.saldoInicial = saldoInicial;
	}

	public Integer getIdCuenta() {
		return idCuenta;
	}

	public void setIdCuenta(Integer idCuenta) {
		this.idCuenta = idCuenta;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Double getSaldoInicial() {
		return saldoInicial;
	}

	public void setSaldoInicial(Double saldoInicial) {
		this.saldoInicial = saldoInicial;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idCuenta == null) ? 0 : idCuenta.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cuenta other = (Cuenta) obj;
		if (idCuenta == null)
			if (other.idCuenta != null)
				return false;
			else if (!idCuenta.equals(other.idCuenta))
				return false;
		return true;
	}

}
