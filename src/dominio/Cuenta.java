package dominio;

import java.sql.Date;
import java.util.LinkedList;
import java.util.List;

public class Cuenta {

	/*
	 * private Integer idCuenta; private Cliente cliente;
	 */
	private Double saldoInicial;

	protected Double saldo = 0.0;
	protected List<Transaccion> transacciones = new LinkedList<Transaccion>();

	public Cuenta(Double saldoInicial) {
		this.saldoInicial = saldoInicial;
	}

	public Double getSaldoInicial() {
		return saldoInicial;
	}

	public void setSaldoInicial(Double saldoInicial) {
		this.saldoInicial = saldoInicial;
	}

	public void depositar(Double monto) {
		if (monto >= 0) {
			this.saldo = this.saldo + monto;
			this.transacciones.add(new Transaccion(TipoTransaccion.DEPOSITO, monto, new Date(0)));
		}
	}

	public void extraer(Double monto) {
		if (this.saldo >= monto && monto > 0) {
			this.saldo = this.saldo - monto;
			this.transacciones.add(new Transaccion(TipoTransaccion.EXTRACCION, monto, new Date(0)));
		}

	}

	public void tranferir(Cuenta cuentaDestino, Double monto) {
		if (monto >= 0 && monto <= this.saldo) {
			this.saldo = this.saldo - monto;
			cuentaDestino.depositar(monto);
			this.transacciones.add(new Transaccion(TipoTransaccion.TRANSFERENCIA, monto, new Date(0)));
		}
	}

	public List<Transaccion> getTransacciones() {
		return this.transacciones;
	}

	public List<Transaccion> getDepositos() {
		List<Transaccion> depositos = new LinkedList<Transaccion>();
		for (Transaccion transaccion : this.transacciones) {
			if (transaccion.getMotivo().equals(TipoTransaccion.DEPOSITO)) {
				depositos.add(transaccion);
			}
		}

		return depositos;
	}

	/*
	 * @Override public int hashCode() { final int prime = 31; int result = 1;
	 * result = prime * result + ((idCuenta == null) ? 0 : idCuenta.hashCode());
	 * return result; }
	 * 
	 * @Override public boolean equals(Object obj) { if (this == obj) return true;
	 * if (obj == null) return false; if (getClass() != obj.getClass()) return
	 * false; Cuenta other = (Cuenta) obj; if (idCuenta == null) if (other.idCuenta
	 * != null) return false; else if (!idCuenta.equals(other.idCuenta)) return
	 * false; return true; }
	 */

}
