package classes;
public class Funcionario {

	private String nome;
	private String idFuncionario;
	private String cpf;
	private double salario;
	private String cargoSetor;
	private String situacao;
	private String email;
	
	public Funcionario() {  }
	
	public Funcionario(String nome, String idFuncionario, String cpf, double salario, String cargoSetor,
			String situacao, String email) {
		super();
		this.nome = nome;
		this.idFuncionario = idFuncionario;
		this.cpf = cpf;
		this.salario = salario;
		this.cargoSetor = cargoSetor;
		this.situacao = situacao;
		this.email = email;
	}



	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getIdFuncionario() {
		return idFuncionario;
	}
	public void setIdFuncionario(String idFuncionario) {
		this.idFuncionario = idFuncionario;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	public String getCargoSetor() {
		return cargoSetor;
	}
	public void setCargoSetor(String cargoSetor) {
		this.cargoSetor = cargoSetor;
	}
	public String getSituacao() {
		return situacao;
	}
	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Funcionario [nome=" + nome + ", idFuncionario=" + idFuncionario + ", cpf=" + cpf + ", salario="
				+ salario + ", cargoSetor=" + cargoSetor + ", situacao=" + situacao + ", email=" + email + "]";
	}
	
}