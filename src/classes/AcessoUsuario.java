package classes;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AcessoUsuario {

    private static final SimpleDateFormat dateTimeFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
	
	private String idUsuario;
	private Date horarioLogin;
	private Date horarioLogoff;

	public AcessoUsuario() {  }

	public AcessoUsuario(String idUsuario, Date horarioLogin, Date horarioLogoff) {
		super();
		this.idUsuario = idUsuario;
		this.horarioLogin = horarioLogin;
		this.horarioLogoff = horarioLogoff;
	}

	public String getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Date getHorarioLogin() {
		return horarioLogin;
	}

	public void setHorarioLogin(Date horarioLogin) {
		this.horarioLogin = horarioLogin;
	}

	public Date getHorarioLogoff() {
		return horarioLogoff;
	}

	public void setHorarioLogoff(Date horarioLogoff) {
		this.horarioLogoff = horarioLogoff;
	}

    @Override
    public String toString() {
        String horarioLoginFormatado = horarioLogin != null ? dateTimeFormat.format(horarioLogin) : "N/A";
        String horarioLogoffFormatado = horarioLogoff != null ? dateTimeFormat.format(horarioLogoff) : "N/A";
        return "AcessoUsuario [idUsuario=" + idUsuario + ", horarioLogin=" + horarioLoginFormatado + ", horarioLogoff="
                + horarioLogoffFormatado + "]";
    }
}
