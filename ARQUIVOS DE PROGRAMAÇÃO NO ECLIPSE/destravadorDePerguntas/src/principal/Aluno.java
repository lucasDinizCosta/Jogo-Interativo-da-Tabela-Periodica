package principal;

public class Aluno {
	private String nome;					//Identificação de Nome do jogador
	private String ano;						//Identificação do ano escolar do aluno
	private String nomeDaEscola = "Padrão"; //Idenfitcação do nome da Escola
	private int ponto = 0;					//Pontuação inicial do jogador
	private String dia, mes, anoJogado;	
	
	public Aluno(String nome, String ano){
		this.nome = nome;
		this.ano = ano;
	}
	
	/**
	 * Métodos que retornam/concedem os atributos do aluno
	 */
	
	public String getNome(){
		return this.nome;
	}
	
	public String getEscola(){
		return this.nomeDaEscola;
	}
	
	public void setEscola(String escola){
		this.nomeDaEscola = escola;
	}
	
	public String getAno(){
		return this.ano;
	}
	
	public void setAno(String ano){	
		this.ano = ano;
	}
	
	public int getPonto(){	
		return this.ponto;
	}
	
	public void setPonto(int ponto){	
		this.ponto = ponto;
	}
	
	/**
	 * 	Data em que foi criado o aluno
	 */
	
	public String getDia(){
		return dia;
	}
	
	public void setDia(String dia){	
		this.dia = dia;
	}
	
	public String getMes(){
		return mes;
	}
	
	public void setMes(String mes){
		this.mes = mes;
	}
	
	public String getAnoJogado(){
		return anoJogado;
	}
	
	public void setAnoJogado(String anoJogado){	
		this.anoJogado = anoJogado;
	}
}