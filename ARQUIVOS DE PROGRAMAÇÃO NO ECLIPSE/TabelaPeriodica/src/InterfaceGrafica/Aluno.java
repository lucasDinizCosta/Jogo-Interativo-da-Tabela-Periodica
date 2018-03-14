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
	private String nomeDaEscola = "Padr�o";
	private int ponto = 0;	//Pontua��o inicial do jogador
	private String dia = "", mes = "" , anoJogado = "";
	private Boolean[] respostas = new Boolean[10]; //Declara��o do vetor das respostas, por Default � null. Este � um Vetor criado com o objetivo de construir o status do jogador.
	private ArrayList<Integer> registroPontosPerguntas = new ArrayList<Integer>();	//registrar� no relat�rio a pontua��o conquistada a cada pergunta
	
	//Sorteio e an�lise do arquivo de texto
	private ArrayList<Integer> perguntasSorteadasGeral = new ArrayList<Integer>();		//Ir� armazenar as perguntas que todos ir�o responder
	private ArrayList<Integer> perguntasSorteadasIndividual = new ArrayList<Integer>();	//Ir� armazenar as perguntas em ordens diferentes para cada aluno
	private Random sorteio = new Random();	//Vari�vel para gerar valores aleat�rios
	private int indiceAleatorio;	//Indice Aleat�rio capturado do array perguntasSorteadasGeral que ir� armazenar a pergunta em perguntasSorteadasIndividual
	private int indiceDestrave = 0;	//Indice de destrave de cada aluno, ele ir� comparar esse indice com o do arquivo de texto, se forem iguais deve destravar
									//a pr�xima pergunta, se o do texto for maior que o do aluno quer dizer que o destrave j� ocorreu, ent�o gera a outra pergunta
	private boolean isJanelaHistorico; 

	//Sobre o arquivo de texto
	private String nomeComputadorCentral;
	private Path caminho;			//Caminho onde se encontra o arquivo com as perguntas sorteadas no computador central
	private String linhaDoArquivo;	//Armazena a leitura de cada linha do arquivo
	
	public Aluno(String nome, String ano, String nomeComputadorCentral, boolean isJanelaHistorico){	//esse dado ser� capturado quando o usuario clicar no ano desejado e digitar o nome na JOptionPane
		this.nome = nome;
		this.ano = ano;
		this.nomeComputadorCentral = nomeComputadorCentral;
		caminho = Paths.get("\\\\"+nomeComputadorCentral+"\\Jogo Interativo Tabela Peri�dica\\Perguntas.txt");
		this.isJanelaHistorico = isJanelaHistorico;		//Se a classe est� sendo acessada atrav�s da janela do hist�rico, caso ocorrer n�o poder� verificar o getData e nem o sorteio de perguntas
		
		if(isJanelaHistorico==false){	//Se n�o tiver acessando da janela do hist�rico
			atribSorteioIndividual();	//M�todo final de sorteio, ele captura as perguntas do arquivo de texto no computador principal e sorteia as perguntas em ordens diferentes para cada aluno
			getData();	//Captura a data do arquivo de texto do computador central
		}	
	}
	/** M�TODO PARA FACILITAR O TESTE DE EMISS�O DO RELAT�RIO(DIRECIONADO AO PROGRAMADOR)*/
	
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
		this.ano = "1� Ano";
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
	 * M�TODO TESTESORTEIO, ELE EST� SENDO USADO PARA TESTAR AS PERGUNTAS
	 */
	public void testeSorteio(int perg1, int perg2, int perg3, int perg4, int perg5, int perg6, int perg7, int perg8, int perg9, int perg10){	//SAIR� NA VERS�O FINAL
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
		try{	//Try e Catch s�o comandos usados na tentativa de tratar excess�es e erros
			Path arquivoComData = Paths.get("\\\\"+nomeComputadorCentral+"\\Jogo Interativo Tabela Peri�dica\\Data.txt");
			String data = "";
			if(arquivoComData.toFile().exists()==true){
				Scanner scan = new Scanner(arquivoComData, "UTF-8"); //Vari�vel de leitura do Arquivo de Texto
				while(scan.hasNextLine()){		//L� as linhas do arquivo de texto, se "tem uma pr�xima linha?"
					data = scan.nextLine();		//Armazena a linha do arquivo
				}
				data = data.substring(data.indexOf("(")+1, data.indexOf(")"));
				System.out.println(data);
				dia = data.substring(0, 2);			//L� a String at� antes do indice final
				mes = data.substring(3, 5);
				anoJogado = data.substring(6, data.length());
			}
			else if(arquivoComData.toFile().exists()==false){
				System.out.println("O Arquivo de Data n�o existe");
			}
		}catch(Exception erro){		//Tratamento de erros
			erro.printStackTrace();
			System.out.println("Erro na leitura de arquivos");
		}
	}
	
	/**	
	 *	M�todos para verificar o destrave das perguntas e se foram realizados
	 */
	
	public void setIndiceDestrave(int indiceNovo){	//Indice de destrave guardado pelo aluno, ou seja at� que pergunta ele chegou
		indiceDestrave = indiceNovo;
	}
	
	public int getIndiceDestrave(){
		return indiceDestrave;
	}
	
	/**
	 * 	M�todo para analisar o nome da escola
	 */
	
	public void setNomeEscola(){
		try{	//Try e Catch s�o comandos usados na tentativa de tratar excess�es e erros
			Path arquivoNomeEscola = Paths.get("\\\\"+nomeComputadorCentral+"\\Jogo Interativo Tabela Peri�dica\\NomeDaEscola.txt");	//Criado para verificar se o arquivo existe, somente essa ideia
			if(arquivoNomeEscola.toFile().exists()==true){
				FileInputStream caminhoDoArquivo = new FileInputStream("\\\\"+nomeComputadorCentral+"\\Jogo Interativo Tabela Peri�dica\\NomeDaEscola.txt");
				InputStreamReader tradutorEncode = new InputStreamReader(caminhoDoArquivo, "UTF-8"); 																				
				BufferedReader bufferNomeEscola = new BufferedReader(tradutorEncode);
				String linha = bufferNomeEscola.readLine();				
				nomeDaEscola = linha.substring(linha.indexOf("(")+1, linha.indexOf(")"));
				bufferNomeEscola.close();
			}
			else if(arquivoNomeEscola.toFile().exists()==false){
				System.out.println("N�o existe o arquivo de texto com o nome da escola");
				JOptionPane.showMessageDialog(null, "N�O FOI ENCONTRADO O ARQUIVO DA ESCOLA");
			}
		}catch(Exception erro){		//Tratamento de erros
			erro.printStackTrace();
			System.out.println("Erro na leitura de arquivos");
		}
	}
	
	public String getNomeEscola(){
		return nomeDaEscola;
	}
	
	public void setEscola(String nomeEscola){	// M�todo criado exclusivamente com o objetivo de facilitar o trabalho na cria��o da janela Hist�rico
		nomeDaEscola = nomeEscola;
	}
	
	/**	
	 *	M�todos para analisar as perguntas individuais do sorteio
	 */
	
	public void setPergIndividual(int pergunta){	//Adiciona o numero da pergunta no arraylist das perguntas sorteadas individuais
		perguntasSorteadasIndividual.add(pergunta);
	}
	
	public int getPergIndividual(){		//retorna a primeira pergunta armazenada no arraylist de perguntas individuais
		return perguntasSorteadasIndividual.get(0);
	}
	
	public void apagarPerguntaIndividual(){	//Apaga Sempre a primeira posi��o do arraylist, pois ele se auto redimensiona
		perguntasSorteadasIndividual.remove(0);	//Ir� apagar o array individual at� ficar null e gerar o relat�rio
	}
	
	public boolean vazioPerguntaIndividual(){	//Verifica se o arraylis de perguntas individuais est� vazio
		if(perguntasSorteadasIndividual.isEmpty()==false){	//Se ainda existem perguntas a serem lidas no arraylist individual
			return false;
		}
		else{	//Arraylist est� vazio
			return true;
		}
	}
	
	public int getSizePerguntaIndividual(){		//retorna o tamanho do arraylist de perguntas individuais
		return perguntasSorteadasIndividual.size();
	}
	
	public int getTamVetRepostas(){
		return respostas.length;
	}
	
	public boolean getContainsPerguntaIndividual(int numeroAleatorio){	//Verificar se o arraylist Pergunta individual cont�m numero aleat�rio, ou seja tal pergunta
		if(perguntasSorteadasIndividual.contains(numeroAleatorio)==false){	//Arraylist cont�m elementos
			return false;
		}
		else{	//Arraylist est� vazio
			return true;
		}
	}
	
	/**
	 * Atribui um sorteio individual para cada aluno baseada nas perguntas sorteadas gerais pelo computador central
	 */
	
	public void atribSorteioIndividual(){	//Realiza o sorteio individual analizando o arquivo com as perguntas sorteadas gerais
		verificaExistencia();				//Verifica se o arquivo de texto existe
		lendoPergSortGeral();				//se o arquivo de texto das perguntas existe ent�o ele ir� armazenar estas perguntas no arraylist de perguntas gerais
		while(this.perguntasSorteadasGeral.isEmpty()==false){	//enquanto o array geral apresenta elementos/perguntas
			indiceAleatorio = sorteio.nextInt(this.perguntasSorteadasGeral.size());	//Sorteia um indice aleat�rio baseado no tamanho de 0 a 9 do Array
			perguntasSorteadasIndividual.add((Integer) perguntasSorteadasGeral.get(indiceAleatorio));	//O array individual ir� armazenar o elemento da posi��o aleatoria do array geral
			perguntasSorteadasGeral.remove(indiceAleatorio);	//ap�s inserir no individual, o array geral elimina o elemento de mesmo indice do Array Geral
		}
		//Ap�s atribuir o sorteio das perguntas individuais ele atribui o nome da escola
		setNomeEscola();
	}
	
	public void lendoPergSortGeral(){
		try{	//Try e Catch s�o comandos usados na tentativa de tratar excess�es e erros
			if(caminho.toFile().exists()==true){
				Scanner scan = new Scanner(caminho, "UTF-8"); //Vari�vel de leitura do Arquivo de Texto
				while(scan.hasNextLine()){					//L� as linhas do arquivo de texto, se "tem uma pr�xima linha?"
					linhaDoArquivo = scan.nextLine();		//Armazena a linha do arquivo
					this.perguntasSorteadasGeral.add(Integer.parseInt(linhaDoArquivo));	//converte o conte�do da linha do arquivo de texto pra int(numero)
				}
			}
			else if(caminho.toFile().exists()==false){
				System.out.println("O Arquivo de sorteio das perguntas n�o existe");
			}
			//e assim � adicionado no arraylist de perguntas gerais
		}catch(Exception erro){		//Tratamento de erros
			erro.printStackTrace();
			System.out.println("Erro na leitura de arquivos");
		}
	}
	
	public void verificaExistencia(){ //Verifica a existencia do Arquivo de Texto com as perguntas sorteadas
		try{
			if(caminho.toFile().exists()==false){	//verifica se o arquivo de texto n�o existe
				JOptionPane.showMessageDialog(null, "Verificamos que as perguntas n�o foram sorteadas, tente novamente assim\n que elas forem sorteadas pelo computador central, obrigado pela colabora��o.");
				System.out.println("O arquivo com as perguntas sorteadas n�o existe");
			}
			else if(caminho.toFile().exists()==true){	//Se o arquivo de texto existir, ser� deletado e criado um novo
				//JOptionPane.showMessageDialog(null, "Arquivo existente, sorteando suas perguntas");
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * M�todos que retornam/concede os atributos do aluno
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
	
	public void setAno(String ano){	//Na hora que o usuario digitar o nome na JOptionPane, ele ir� atribuir o ano escolhido ao Aluno.
		this.ano = ano;
	}
	
	public int getPonto(){	//Retorna a pontua��o do aluno
		return this.ponto;
	}
	
	public void setPonto(int ponto){	//Atribui o ponto, ou seja, criado para atualizar a pontua��o do jogador conforme o progresso
		this.ponto = ponto;
	}
	
	/**
	 * 	M�todos para guardar/verificar a pontua��o conquistada em cada pergunta, � o principal para gerar o relat�rio
	 */
	
	public void setRegistroPontosPerguntas(Integer num){	//Armazena os pontos+Bonus de cada pergunta num arraylist para gerar o relat�rio posteriormente
		this.registroPontosPerguntas.add(num);
	}
	
	public Integer getRegistroPontosPerguntas(int indice){	//captura o elemento(pontua��o das respostas) atrav�s do indice armazenado no arraylist
		return this.registroPontosPerguntas.get(indice);
	}
	
	public int getSizeRegistroPontosPerguntas(){	//retorna o tamanho do array das respostas
		return this.registroPontosPerguntas.size();
	}
	
	/**
	 * 	M�TODOS REPONS�VEIS POR ARMAZENAR EM UM VETOR SE A RESPOSTA DA PERGUNTA ESTAVA CORRETA(ATRIBUI TRUE), INCORRETA(FALSE), OU N�O FOI JOGADA(NULL)
	 */
	
	public void setResposta(Boolean resposta){	//Atribui a resposta a um vetor de Boolean que por default � null
		int indice=0;
		while(respostas[indice]!=null){	//analiza o vetor de Boolean at� atingir um elemento null
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