package InterfaceGrafica;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import javax.swing.JOptionPane;

public class Aluno {
	private String nome;
	private String ano;
	private String nomeDaEscola = "Padrão";
	private int ponto = 0;	//Pontuação inicial do jogador
	private String dia = "", mes = "" , anoJogado = "";
	private Boolean[] respostas = new Boolean[10]; //Declaração do vetor das respostas, por Default é null. Este é um Vetor criado com o objetivo de construir o status do jogador.
	private ArrayList<Integer> registroPontosPerguntas = new ArrayList<Integer>();	//registrará no relatório a pontuação conquistada a cada pergunta
	
	//Sorteio e análise do arquivo de texto
	private ArrayList<Integer> perguntasSorteadasGeral = new ArrayList<Integer>();		//Irá armazenar as perguntas que todos irão responder
	private ArrayList<Integer> perguntasSorteadasIndividual = new ArrayList<Integer>();	//Irá armazenar as perguntas em ordens diferentes para cada aluno
	private Random sorteio = new Random();	//Variável para gerar valores aleatórios
	private int indiceAleatorio;	//Indice Aleatório capturado do array perguntasSorteadasGeral que irá armazenar a pergunta em perguntasSorteadasIndividual
	private int indiceDestrave = 0;	//Indice de destrave de cada aluno, ele irá comparar esse indice com o do arquivo de texto, se forem iguais deve destravar
									//a próxima pergunta, se o do texto for maior que o do aluno quer dizer que o destrave já ocorreu, então gera a outra pergunta
	private boolean isJanelaHistorico; 

	//Sobre o arquivo de texto
	private String nomeComputadorCentral;
	private Path caminho;			//Caminho onde se encontra o arquivo com as perguntas sorteadas no computador central
	private String linhaDoArquivo;	//Armazena a leitura de cada linha do arquivo
	
	public Aluno(String nome, String ano, String nomeComputadorCentral, boolean isJanelaHistorico){	//esse dado será capturado quando o usuario clicar no ano desejado e digitar o nome na JOptionPane
		this.nome = nome;
		this.ano = ano;
		this.nomeComputadorCentral = nomeComputadorCentral;
		caminho = Paths.get("\\\\"+nomeComputadorCentral+"\\Jogo Interativo Tabela Periódica\\Perguntas.txt");
		this.isJanelaHistorico = isJanelaHistorico;		//Se a classe está sendo acessada através da janela do histórico, caso ocorrer não poderá verificar o getData e nem o sorteio de perguntas
		
		if(isJanelaHistorico==false){	//Se não tiver acessando da janela do histórico
			atribSorteioIndividual();	//Método final de sorteio, ele captura as perguntas do arquivo de texto no computador principal e sorteia as perguntas em ordens diferentes para cada aluno
			getData();	//Captura a data do arquivo de texto do computador central
		}	
	}
	/** MÉTODO PARA FACILITAR O TESTE DE EMISSÃO DO RELATÓRIO(DIRECIONADO AO PROGRAMADOR)*/
	
	public void setDados(){
		setRegistroPontosPerguntas(300);
		setRegistroPontosPerguntas(300);
		setRegistroPontosPerguntas(300);
		setRegistroPontosPerguntas(300);
		setRegistroPontosPerguntas(300);
		setRegistroPontosPerguntas(300);
		setRegistroPontosPerguntas(300);
		setRegistroPontosPerguntas(300);
		setRegistroPontosPerguntas(300);
		setRegistroPontosPerguntas(300);
		//ATRIBUIU OS 10 PONTOS DAS PERGUNTAS COMO SE TIVESSE JOGADO
		//ATRIBUINDO DATA
		this.dia = "24";
		this.mes = "02";
		this.anoJogado = "2016";
		this.ano = "1º Ano";
		//ATRIBUINDO VETOR DE RESPOSTAS ACERTADAS/ERRADAS
		setResposta(true);
		setResposta(true);
		setResposta(true);
		setResposta(true);
		setResposta(true);
		setResposta(true);
		setResposta(true);
		setResposta(true);
		setResposta(true);
		setResposta(true);
		//ATRIBUINDO ESCOLA
		this.nomeDaEscola = "TESTE";
		this.ponto = 4000;
		this.setIndiceDestrave(10);
	}
	
	public String getNomeComputadorCentral(){
		return nomeComputadorCentral;
	}
	
	/**
	 * MÉTODO TESTESORTEIO, ELE ESTÁ SENDO USADO PARA TESTAR AS PERGUNTAS
	 */
	public void testeSorteio(int perg1, int perg2, int perg3, int perg4, int perg5, int perg6, int perg7, int perg8, int perg9, int perg10){	//SAIRÁ NA VERSÃO FINAL
		perguntasSorteadasIndividual.add(perg1);
		perguntasSorteadasIndividual.add(perg2);
		perguntasSorteadasIndividual.add(perg3);
		perguntasSorteadasIndividual.add(perg4);
		perguntasSorteadasIndividual.add(perg5);		
		perguntasSorteadasIndividual.add(perg6);
		perguntasSorteadasIndividual.add(perg7);
		perguntasSorteadasIndividual.add(perg8);
		perguntasSorteadasIndividual.add(perg9);
		perguntasSorteadasIndividual.add(perg10);
	}
	
	public void getData(){
		try{	//Try e Catch são comandos usados na tentativa de tratar excessões e erros
			Path arquivoComData = Paths.get("\\\\"+nomeComputadorCentral+"\\Jogo Interativo Tabela Periódica\\Data.txt");
			String data = "";
			if(arquivoComData.toFile().exists()==true){
				Scanner scan = new Scanner(arquivoComData, "UTF-8"); //Variável de leitura do Arquivo de Texto
				while(scan.hasNextLine()){		//Lê as linhas do arquivo de texto, se "tem uma próxima linha?"
					data = scan.nextLine();		//Armazena a linha do arquivo
				}
				data = data.substring(data.indexOf("(")+1, data.indexOf(")"));
				System.out.println(data);
				dia = data.substring(0, 2);			//Lê a String até antes do indice final
				mes = data.substring(3, 5);
				anoJogado = data.substring(6, data.length());
			}
			else if(arquivoComData.toFile().exists()==false){
				System.out.println("O Arquivo de Data não existe");
			}
		}catch(Exception erro){		//Tratamento de erros
			erro.printStackTrace();
			System.out.println("Erro na leitura de arquivos");
		}
	}
	
	/**	
	 *	Métodos para verificar o destrave das perguntas e se foram realizados
	 */
	
	public void setIndiceDestrave(int indiceNovo){	//Indice de destrave guardado pelo aluno, ou seja até que pergunta ele chegou
		indiceDestrave = indiceNovo;
	}
	
	public int getIndiceDestrave(){
		return indiceDestrave;
	}
	
	/**
	 * 	Método para analisar o nome da escola
	 */
	
	public void setNomeEscola(){
		try{	//Try e Catch são comandos usados na tentativa de tratar excessões e erros
			Path arquivoNomeEscola = Paths.get("\\\\"+nomeComputadorCentral+"\\Jogo Interativo Tabela Periódica\\NomeDaEscola.txt");	//Criado para verificar se o arquivo existe, somente essa ideia
			if(arquivoNomeEscola.toFile().exists()==true){
				FileInputStream caminhoDoArquivo = new FileInputStream("\\\\"+nomeComputadorCentral+"\\Jogo Interativo Tabela Periódica\\NomeDaEscola.txt");
				InputStreamReader tradutorEncode = new InputStreamReader(caminhoDoArquivo, "UTF-8"); 																				
				BufferedReader bufferNomeEscola = new BufferedReader(tradutorEncode);
				String linha = bufferNomeEscola.readLine();				
				nomeDaEscola = linha.substring(linha.indexOf("(")+1, linha.indexOf(")"));
				bufferNomeEscola.close();
			}
			else if(arquivoNomeEscola.toFile().exists()==false){
				System.out.println("Não existe o arquivo de texto com o nome da escola");
				JOptionPane.showMessageDialog(null, "NÃO FOI ENCONTRADO O ARQUIVO DA ESCOLA");
			}
		}catch(Exception erro){		//Tratamento de erros
			erro.printStackTrace();
			System.out.println("Erro na leitura de arquivos");
		}
	}
	
	public String getNomeEscola(){
		return nomeDaEscola;
	}
	
	public void setEscola(String nomeEscola){	// Método criado exclusivamente com o objetivo de facilitar o trabalho na criação da janela Histórico
		nomeDaEscola = nomeEscola;
	}
	
	/**	
	 *	Métodos para analisar as perguntas individuais do sorteio
	 */
	
	public void setPergIndividual(int pergunta){	//Adiciona o numero da pergunta no arraylist das perguntas sorteadas individuais
		perguntasSorteadasIndividual.add(pergunta);
	}
	
	public int getPergIndividual(){		//retorna a primeira pergunta armazenada no arraylist de perguntas individuais
		return perguntasSorteadasIndividual.get(0);
	}
	
	public void apagarPerguntaIndividual(){	//Apaga Sempre a primeira posição do arraylist, pois ele se auto redimensiona
		perguntasSorteadasIndividual.remove(0);	//Irá apagar o array individual até ficar null e gerar o relatório
	}
	
	public boolean vazioPerguntaIndividual(){	//Verifica se o arraylis de perguntas individuais está vazio
		if(perguntasSorteadasIndividual.isEmpty()==false){	//Se ainda existem perguntas a serem lidas no arraylist individual
			return false;
		}
		else{	//Arraylist está vazio
			return true;
		}
	}
	
	public int getSizePerguntaIndividual(){		//retorna o tamanho do arraylist de perguntas individuais
		return perguntasSorteadasIndividual.size();
	}
	
	public int getTamVetRepostas(){
		return respostas.length;
	}
	
	public boolean getContainsPerguntaIndividual(int numeroAleatorio){	//Verificar se o arraylist Pergunta individual contém numero aleatório, ou seja tal pergunta
		if(perguntasSorteadasIndividual.contains(numeroAleatorio)==false){	//Arraylist contém elementos
			return false;
		}
		else{	//Arraylist está vazio
			return true;
		}
	}
	
	/**
	 * Atribui um sorteio individual para cada aluno baseada nas perguntas sorteadas gerais pelo computador central
	 */
	
	public void atribSorteioIndividual(){	//Realiza o sorteio individual analizando o arquivo com as perguntas sorteadas gerais
		verificaExistencia();				//Verifica se o arquivo de texto existe
		lendoPergSortGeral();				//se o arquivo de texto das perguntas existe então ele irá armazenar estas perguntas no arraylist de perguntas gerais
		while(this.perguntasSorteadasGeral.isEmpty()==false){	//enquanto o array geral apresenta elementos/perguntas
			indiceAleatorio = sorteio.nextInt(this.perguntasSorteadasGeral.size());	//Sorteia um indice aleatório baseado no tamanho de 0 a 9 do Array
			perguntasSorteadasIndividual.add((Integer) perguntasSorteadasGeral.get(indiceAleatorio));	//O array individual irá armazenar o elemento da posição aleatoria do array geral
			perguntasSorteadasGeral.remove(indiceAleatorio);	//após inserir no individual, o array geral elimina o elemento de mesmo indice do Array Geral
		}
		//Após atribuir o sorteio das perguntas individuais ele atribui o nome da escola
		setNomeEscola();
	}
	
	public void lendoPergSortGeral(){
		try{	//Try e Catch são comandos usados na tentativa de tratar excessões e erros
			if(caminho.toFile().exists()==true){
				Scanner scan = new Scanner(caminho, "UTF-8"); //Variável de leitura do Arquivo de Texto
				while(scan.hasNextLine()){					//Lê as linhas do arquivo de texto, se "tem uma próxima linha?"
					linhaDoArquivo = scan.nextLine();		//Armazena a linha do arquivo
					this.perguntasSorteadasGeral.add(Integer.parseInt(linhaDoArquivo));	//converte o conteúdo da linha do arquivo de texto pra int(numero)
				}
			}
			else if(caminho.toFile().exists()==false){
				System.out.println("O Arquivo de sorteio das perguntas não existe");
			}
			//e assim é adicionado no arraylist de perguntas gerais
		}catch(Exception erro){		//Tratamento de erros
			erro.printStackTrace();
			System.out.println("Erro na leitura de arquivos");
		}
	}
	
	public void verificaExistencia(){ //Verifica a existencia do Arquivo de Texto com as perguntas sorteadas
		try{
			if(caminho.toFile().exists()==false){	//verifica se o arquivo de texto não existe
				JOptionPane.showMessageDialog(null, "Verificamos que as perguntas não foram sorteadas, tente novamente assim\n que elas forem sorteadas pelo computador central, obrigado pela colaboração.");
				System.out.println("O arquivo com as perguntas sorteadas não existe");
			}
			else if(caminho.toFile().exists()==true){	//Se o arquivo de texto existir, será deletado e criado um novo
				//JOptionPane.showMessageDialog(null, "Arquivo existente, sorteando suas perguntas");
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * Métodos que retornam/concede os atributos do aluno
	 */
	
	public String getDificuldade(){
		return this.ano;
	}
	
	public String getNome(){
		return this.nome;
	}
	
	public String getAno(){
		return this.ano;
	}
	
	public void setAno(String ano){	//Na hora que o usuario digitar o nome na JOptionPane, ele irá atribuir o ano escolhido ao Aluno.
		this.ano = ano;
	}
	
	public int getPonto(){	//Retorna a pontuação do aluno
		return this.ponto;
	}
	
	public void setPonto(int ponto){	//Atribui o ponto, ou seja, criado para atualizar a pontuação do jogador conforme o progresso
		this.ponto = ponto;
	}
	
	/**
	 * 	Métodos para guardar/verificar a pontuação conquistada em cada pergunta, é o principal para gerar o relatório
	 */
	
	public void setRegistroPontosPerguntas(Integer num){	//Armazena os pontos+Bonus de cada pergunta num arraylist para gerar o relatório posteriormente
		this.registroPontosPerguntas.add(num);
	}
	
	public Integer getRegistroPontosPerguntas(int indice){	//captura o elemento(pontuação das respostas) através do indice armazenado no arraylist
		return this.registroPontosPerguntas.get(indice);
	}
	
	public int getSizeRegistroPontosPerguntas(){	//retorna o tamanho do array das respostas
		return this.registroPontosPerguntas.size();
	}
	
	/**
	 * 	MÉTODOS REPONSÁVEIS POR ARMAZENAR EM UM VETOR SE A RESPOSTA DA PERGUNTA ESTAVA CORRETA(ATRIBUI TRUE), INCORRETA(FALSE), OU NÃO FOI JOGADA(NULL)
	 */
	
	public void setResposta(Boolean resposta){	//Atribui a resposta a um vetor de Boolean que por default é null
		int indice=0;
		while(respostas[indice]!=null){	//analiza o vetor de Boolean até atingir um elemento null
			indice++;
		}
		respostas[indice] = resposta;
	}
	
	public Boolean getResposta(int posicao){	//Captura a resposta dada no vetor, retorna true se acertou, false para erro
		return respostas[posicao];
	}
	
	/**
	 * 	DATA EM QUE FOI CRIADO O ALUNO
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