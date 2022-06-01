package dominio;

import java.util.Date;

public class Transaccion {
	private TipoTransaccion motivo;
	private Double monto;
	private Date fecha;

	public Transaccion(TipoTransaccion motivo, Double monto, Date fecha) {
		this.motivo = motivo;
		this.monto = monto;
		this.fecha = fecha;
	}

	public TipoTransaccion getMotivo() {
		return motivo;
	}

	public void setMotivo(TipoTransaccion motivo) {
		this.motivo = motivo;
	}

	public Double getMonto() {
		return monto;
	}

	public void setMonto(Double monto) {
		this.monto = monto;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
}
