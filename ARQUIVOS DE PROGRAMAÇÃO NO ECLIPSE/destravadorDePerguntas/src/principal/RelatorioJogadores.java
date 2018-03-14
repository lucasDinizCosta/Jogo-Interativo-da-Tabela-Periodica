package principal;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

public class RelatorioJogadores implements ActionListener{
	
	//Elementos da janela
	private JComboBox<String> comboDificuldades = new JComboBox<String>();	//Dificuldades: 9� Ano, 1� Ano, 2� Ano e 3� Ano
	private JComboBox<String> comboTipoRelatorio = new JComboBox<String>(); //Tipo de relat�rio: Geral e Di�rio
	private JComboBox<String> comboEscolas = new JComboBox<String>();	//Escolas
	private JComboBox<String> comboTurmas = new JComboBox<String>();	//Turmas
	private ImageIcon imagemFundo = new ImageIcon(getClass().getResource("/imagens/Fundo Relatorio Jogadores.PNG"));
	private JLabel fundo = new JLabel();
	private Color corFundo = new Color(187, 204, 208);
	
	//Vari�veis que ser�o utilizadas para capturar os dados utilizados na janela dos menus
	private String dia = "";
	private String mes = ""; 		
	private String ano = "";		
	private String escola = "";		
	private String dificuldade = "";
	private int indiceDestrave = 0;
	
	private Path caminho = Paths.get("Hist�rico");
	private int contRodadas = 0;	//Contador de Rodadas computadas
	
	//Vari�veis controladoras da tabela
	private String [] colunas = {"n�", "Nome", "Ano escolar", "Escola", "Pontua��o", "Data"};	//Nomes das colunas - 6 colunas no total
	private Object [][] dados;
	private JTable tabela;
	private JScrollPane barraRolagem;
	private JPanel painelFundo;
	private ArrayList<Aluno> alunos = new ArrayList<Aluno>();	//Repons�vel por armazenar os alunos de cada relat�rio e armazenar suas caracter�stica para assim, inser�-los na tabela
	
	//Janelas
	private JFrame janelaDestravador;	//Janela auxiliar que ir� me permitir voltar a janela de menus sem sair do jogo
	private JFrame janelaRelatorioJogadores = new JFrame();
	
	public RelatorioJogadores(String dia, String mes, String ano, String dificuldade, String escola, JFrame janelaDestravador, int indiceDestrave){
		this.dia = dia;
		this.mes = mes;
		this.ano = ano;
		this.escola = escola; 
		this.janelaDestravador = janelaDestravador;
		this.indiceDestrave = indiceDestrave;
		this.dificuldade = dificuldade;
		setJanela();
		setComboDificuldades();
		setComboRelatorio();
		setComboEscola();
		setComboTurma();
		AtributosComboEscola();
		AtributosComboTurmas();
		atribDadosJTable();
		ajustaTabela(dados);
		setFundo();
		janelaRelatorioJogadores.setVisible(true);	//Torna a janela vis�vel somente ap�s adicionar todos os elementos presentes na tela
	}
	
	public void setJanela(){
		janelaRelatorioJogadores.setSize(794,471);
		janelaRelatorioJogadores.setTitle("Relat�rio dos Jogadores");
		janelaRelatorioJogadores.setLayout(null);
		janelaRelatorioJogadores.addWindowListener(Window);
		janelaRelatorioJogadores.setResizable(false);
		janelaRelatorioJogadores.setLocationRelativeTo(null);
		janelaRelatorioJogadores.getContentPane().setBackground(corFundo);
	}
	
	public void setFundo(){
		fundo.setBounds(0, 0, 794, 471);
		fundo.setIcon(imagemFundo);
		janelaRelatorioJogadores.add(fundo);
	}
	
	public void setComboDificuldades(){
		comboDificuldades.addItem("9� Ano");
		comboDificuldades.addItem("1� Ano");
		comboDificuldades.addItem("2� Ano");
		comboDificuldades.addItem("3� Ano");
		comboDificuldades.setBounds(32, 128, 120, 25);
		comboDificuldades.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		comboDificuldades.setSelectedItem(null);	// N�o � selecionado nenhum elemento da combobox inicialmente, por isso � Null
		comboDificuldades.addActionListener(this);
		janelaRelatorioJogadores.add(comboDificuldades);
	}
	
	/**Quando o usu�rio clicar no x com o intuito de finalizar a janela ir� ocorrer o m�todo abaixo*/
	
	WindowListener Window = new WindowAdapter() 
	{  
	    public void windowClosing(WindowEvent e){
	    	janelaRelatorioJogadores.dispose();
	    	janelaDestravador.setVisible(true);
	    }  
	};
	
	public void setComboRelatorio(){
		comboTipoRelatorio.setEnabled(false);	//Torna a combobox "oculta", n�o interativa
		comboTipoRelatorio.addItem("Geral");
		comboTipoRelatorio.addItem("Di�rio");
		comboTipoRelatorio.setBounds(229, 128, 120, 25);
		comboTipoRelatorio.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		comboTipoRelatorio.setSelectedItem(null);
		comboTipoRelatorio.addActionListener(this);
		janelaRelatorioJogadores.add(comboTipoRelatorio);
	}
	
	public void setComboEscola(){
		comboEscolas.setEnabled(false);
		comboEscolas.setBounds(410, 128, 150, 25);
		comboEscolas.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		comboEscolas.setMaximumRowCount(4);	// Representa que o limite de campos que aparece na combobox ser� 4, al�m disso � usado uma barra de scroll
		comboEscolas.addActionListener(this);
		janelaRelatorioJogadores.add(comboEscolas);
	}
	
	public void setComboTurma(){
		comboTurmas.setEnabled(false);
		comboTurmas.setBounds(641,128,120,25);
		comboTurmas.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		comboTurmas.setSelectedItem(null);
		comboTurmas.setMaximumRowCount(4);	// Representa que o limite de campos que aparece na combobox ser� 2, al�m disso � usado uma barra de scroll
		comboTurmas.addActionListener(this);
		janelaRelatorioJogadores.add(comboTurmas);
	}
	
	public void AtributosComboEscola(){
		try{
			caminho = Paths.get("Hist�rico\\"+this.dificuldade+"\\"+this.ano+"\\"+this.mes+"\\"+this.dia);
			System.out.println(caminho);
			String[] escolas = caminho.toFile().list();		//Captura o nome das pastas das escolas que jogaram o jogo
			ArrayList<String> ordemAlfabetica = new ArrayList<String>();	//Armazenar� e colocar� os elementos da combobox em ordem alfab�tica atrav�s desse arraylist
			for(int i = 0; i < escolas.length; i++){
				if(escolas[i].contains(".")==false){	//Se o nome n�o paresentar ponto ele ser� capturado, isso faz ele capturar somente nome de pastas
					ordemAlfabetica.add(escolas[i]);
				}
			}
			Collections.sort(ordemAlfabetica, new Comparator<String>() {	//Organizando os elementos da arraylist em ordem alfab�tica
				@Override
				public int compare(String s1, String s2) {	//Compara duas strings e retorna em ordem alfabetica
					return s1.compareToIgnoreCase(s2);
				}
			});
			for(int i=0; i<ordemAlfabetica.size();i++){		//Adicionando os elementos ordenados na combobox
				comboEscolas.addItem(ordemAlfabetica.get(i));
			}
			comboEscolas.setSelectedItem(null);
		}
		catch(Exception erro){
			erro.printStackTrace();
		}
	}

	public void AtributosComboTurmas(){
		caminho = Paths.get("Hist�rico\\"+this.dificuldade+"\\"+this.ano+"\\"+this.mes+"\\"+this.dia+"\\"+this.escola);
		String[] turmas = caminho.toFile().list();	//Armazena os nome das turmas do dia em um array
		for(int i = 0; i < turmas.length; i++){
			if((turmas[i].contains("Turma")==true)&&(turmas[i].contains(".")==false)){	// S� ir� adicionar na combobox se tiver "Turma" no nome e n�o tiver "."
				comboTurmas.addItem(turmas[i]);
			}
		}
		comboTurmas.setSelectedItem(null);
	}
	
	public void lerArquivos(Path caminhoDesejado){
		try{
			alunos.clear();		//Limpa o Arraylist de alunos antes, de modo a evitar duplicatas de nomes
			Path caminhoAuxiliar = caminhoDesejado;
			if(caminhoAuxiliar.toFile().exists()==true){	//O Arquivo s� pode ser lido se o caminho existir, caso contr�rio acarreta em um erro que ser� tratado pelo try e catch
				Charset utf8charset = Charset.forName("UTF-8");	//Tipo de codifica��o do Arquivo
				FileInputStream caminhoDoArquivo = new FileInputStream(caminhoAuxiliar.toFile().getPath());	//L� o arquivo de texto, faz a leitura dos dados bin�rios n�o importando a fonte
				InputStreamReader tradutorEncode = new InputStreamReader(caminhoDoArquivo, utf8charset); 	//Traduz os bytes com a codifica��o dada, em outras palavras � um decodificador para uma
																											//codifica��o espec�fica, nesse caso "UTF-8" mas poderia ser "ISO-8859-1"
																											//L� bytes de um lado e converte em caracteres do outro, atrav�s do uso de uma codifica��o de caracteres (encoding)
				BufferedReader bufferLeitura = new BufferedReader(tradutorEncode);	//Concatena os diversos chars para formar uma String atrav�s do m�todo readLine		
				String linha = bufferLeitura.readLine();		//Passa o conte�do da primeira linha para uma vari�vel String
				String nomeAux = "", anoAux = "", diaAux = "", mesAux = "", anoJogadoAux = "";	//Vari�veis auxiliares para capturar os dados dos alunos em cada linha
				int pontoAux = 0;
				Aluno a;	// Aluno auxiliar que ir� receber os dados e esse aluno ser� armazenado no Arraylist de alunos
				while (linha != null){
					nomeAux = linha.substring(linha.indexOf("Nome: ")+6, linha.indexOf(" \tAno"));
					anoAux = linha.substring(linha.indexOf("Ano: ")+5, linha.indexOf(" \tPontua��o"));
					pontoAux = Integer.parseInt(linha.substring(linha.indexOf("Pontua��o Total: ")+17, linha.indexOf(" \tEscola")));
					String escolaAux = linha.substring(linha.indexOf("Escola: ")+8, linha.indexOf(" \tData"));
					String data = linha.substring(linha.indexOf("Data: ") + 6, linha.length());
					diaAux = data.substring(0, 2);
					mesAux = data.substring(3, 5);
					anoJogadoAux = data.substring(6, data.length());
					a = new Aluno(nomeAux, anoAux);
					a.setPonto(pontoAux);
					a.setDia(diaAux);
					a.setMes(mesAux);
					a.setAnoJogado(anoJogadoAux);
					a.setEscola(escolaAux);
					alunos.add(a);
					linha = bufferLeitura.readLine();
				}
				bufferLeitura.close();
			}
			else if(caminhoAuxiliar.toFile().exists()==false){	//Se o Arquivo de relat�rio n�o existe, para n�o dar problema ele ser� criado como arquivo vazio
				criarRelatorio(caminhoAuxiliar, null);
			}
		}catch(Exception erro){		//Tratamento de erros
			erro.printStackTrace();
			System.out.println("Erro na leitura de arquivos");
		}
	}

	/**
	 * Organiza os alunos de acordo com a pontua��o do maior para o menor
	 */
	public ArrayList organizandoAlunos(ArrayList<Aluno> alunosAOrganizar){
		Aluno aux = new Aluno("Nome", "Ano");
		aux.setPonto(0);
		ArrayList<Aluno> alunosOrganizados = new ArrayList<Aluno>();
		for( int i=0; i < alunosAOrganizar.size(); i++ ){		//M�todo do BubbleSort em java, organiza do menor para o maior
			for( int j = alunosAOrganizar.size() - 1; j > i; j--){
				if(alunosAOrganizar.get(j).getPonto() < alunosAOrganizar.get(j-1).getPonto()){
					aux = alunosAOrganizar.get(j);
					alunosAOrganizar.set(j, alunosAOrganizar.get(j-1));
					alunosAOrganizar.set(j-1, aux);
				}
			}	
		}
		System.out.println("ORDENADO DO MENOR PRO MAIOR");
		for(int j = alunosAOrganizar.size()-1;j>=0;j--){	//Organizando de maior pontua��o at� o menor
		// LINHA COM PROBLEMA DE INDICE ---->	//System.out.println((j+1)+") Nome: "+alunos.get(j).getNome()+ " Ano: "+alunosAOrganizar.get(j).getAno()+ " Escola: " + alunosAOrganizar.get(j).getEscola()+" Pontua��o: "+alunosAOrganizar.get(j).getPonto()+ " Data: " + alunosAOrganizar.get(j).getDia() +"/"+alunosAOrganizar.get(j).getMes()+"/"+ alunosAOrganizar.get(j).getAnoJogado());
			alunosOrganizados.add(alunosAOrganizar.get(j));
		}
		alunosOrganizados = retirarNomesRepetidos(alunosOrganizados);	//Receber� o arraylist de alunos Organizados por pontua��o e sem repeti��o de nomes
		return alunosOrganizados;
	}
	
	public ArrayList retirarNomesRepetidos(ArrayList<Aluno> alunosAOrganizar){
		ArrayList<Aluno> alunosOrganizados = new ArrayList<Aluno>();
		for(int i = 0; i<alunosAOrganizar.size(); i++){
			boolean alunoNomeIgual = false;
			for(int j = 0;j<alunosOrganizados.size();j++){	//Analisa at� o arrayList de alunosOrganizados acabar
				if(alunosOrganizados.get(j).getNome().equals(alunosAOrganizar.get(i).getNome())){
					alunoNomeIgual = true;	//Se o aluno do arraylist alunosOrganizados tiver o mesmo nome do aluno analisado alunosAOrganizar
				}
			}
			if(alunoNomeIgual == false){	//S� ser� acrescido o aluno com nome �nico e maior pontua��o ao arraylist de alunosOrganizados, ou seja, captura a primeira ocorr�ncia do aluno em alunosAOrganizar
				alunosOrganizados.add(alunosAOrganizar.get(i));
			}
		}
		return alunosOrganizados;
	}
	
	public void ajustaTabela(Object[][] dados){
		painelFundo = new JPanel();
		painelFundo.setLayout(null);
		tabela = new JTable(dados, colunas){
			public boolean isCellEditable(int dados, int coluna){	//Proibe a edi��o de c�lulas
				return false;
			}
		};
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer(){};	//� necess�rio caso queira centralizar as colunas
		centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);	
		tabela.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		tabela.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);	//Centralizando os elementos das colunas 0, 2 e 4
		tabela.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
		tabela.setPreferredScrollableViewportSize(new Dimension(731,159));	//Define o tamanho preferido da janela de exibi��o para esta tabela
		tabela.setFillsViewportHeight(true);	//Define se a tabela � sempre grande(ou n�o) o suficiente para preencher a altura de uma janela
		barraRolagem = new JScrollPane(tabela);
		barraRolagem.setWheelScrollingEnabled(true);							//Ativa a rolagem pelo scroll do mouse
		barraRolagem.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		tabela.getColumnModel().getColumn(0).setMinWidth(60);			//Define o tamanho da coluna 0 (N�mero da linha)
		tabela.getColumnModel().getColumn(1).setMinWidth(180);			//Define o tamanho da coluna 1 (Nome do aluno)
		tabela.getColumnModel().getColumn(2).setMinWidth(90);			//Define o tamanho da coluna 2 (Ano escolar)
		tabela.getColumnModel().getColumn(3).setMinWidth(180);			//Define o tamanho da coluna 3 (Nome da escola)
		tabela.getColumnModel().getColumn(4).setMinWidth(90);			//Define o tamanho da coluna 4 (Pontua��o)
		tabela.getColumnModel().getColumn(5).setMinWidth(80);			//Define o tamanho da coluna 5 (Data)
		tabela.getTableHeader().setBackground(new Color(189,197,229));	//Colore o fundo do cabe�alho
		tabela.getTableHeader().setFont(new Font("Tahoma",Font.BOLD,13));
		tabela.setSelectionMode(0);		//Permite a sele��o de somente uma linha
		tabela.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		tabela.getTableHeader().setBorder(BorderFactory.createLineBorder(Color.BLACK));
		barraRolagem.setBounds(0,0,731,181);
		painelFundo.add(barraRolagem);
		painelFundo.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		painelFundo.setBounds(32, 168, 731, 181);
		tabela.getTableHeader().setReorderingAllowed(false);	//Proibe a reordena��o das colunas com o mouse
		janelaRelatorioJogadores.add(painelFundo);
	}
	
	public void atribDadosJTable(){
		dados = new Object[alunos.size()][6];
		for(int i=0; i<alunos.size();i++){
			String[] linha = {Integer.toString(i+1), alunos.get(i).getNome(), alunos.get(i).getAno(), alunos.get(i).getEscola(), Integer.toString(alunos.get(i).getPonto()), alunos.get(i).getDia()+"/"+alunos.get(i).getMes()+"/"+alunos.get(i).getAnoJogado()};
			for(int j = 0; j<6; j ++){
				dados[i][j] = linha[j];
			}
		}
	}
	
	public void criandoRelatTurma(String turmaEscolhida){
		try{	//Try e Catch s�o comandos usados na tentativa de tratar excess�es e erros
			if(caminho.toFile().exists()==true){	//Verifica se a exist�ncia da pasta Hist�rico existe
				alunos.clear();	//Limpa o Arraylist de alunos antes, de modo a evitar duplicatas de nomes
				Path caminho5 = Paths.get("Hist�rico\\"+this.dificuldade+"\\"+this.ano+"\\"+this.mes+"\\"+this.dia+"\\"+this.escola+"\\"+turmaEscolhida);
				String[] diretoriosRodadas = caminho5.toFile().list();	//Captura o n�mero de SubPastas(Rodadas) presente na pasta da Turma escolhida da Escola
				for(int i = 0; i < diretoriosRodadas.length;i++){	//Percorre as pastas das rodadas
					Path caminho6 = Paths.get(caminho5.toString()+"\\"+diretoriosRodadas[i]);
					if(caminho6.toFile().isDirectory()==true){	//Verifica se o arquivo diretorioRodadas realmente � uma pasta/Diret�rio
						String[] arquivosRelatorio = caminho6.toFile().list();	//arquivos das pastas das pastas de Rodadas
						for(int j = 0; j < arquivosRelatorio.length;j++){	//Ir� analisar todos os arquvos de texto
							Path caminho3 = Paths.get(caminho6.toString()+"\\"+arquivosRelatorio[j]);
							FileInputStream caminhoDoArquivo = new FileInputStream(caminho3.toFile().getPath());	//L� o arquivo de texto, faz a leitura dos dados bin�rios n�o importando a fonte
							InputStreamReader tradutorEncode = new InputStreamReader(caminhoDoArquivo, "UTF-8"); 	//Traduz os bytes com a codifica��o dada, em outras palavras � um decodificador para uma
																													//codifica��o espec�fica, nesse caso "UTF-8" mas poderia ser "ISO-8859-1"
																													//L� bytes de um lado e converte em caracteres do outro, atrav�s do uso de uma codifica��o de caracteres (encoding)
							BufferedReader bufferLeitura = new BufferedReader(tradutorEncode);	//Concatena os diversos chars para formar uma String atrav�s do m�todo readLine
							String linha = bufferLeitura.readLine();	//Passa o conte�do da primeira linha para uma vari�vel String
							int indice = 1;		//�ndice usado para ter a ideia do n�mero de linhas para a leitura
							String nomeAluno = "", anoAluno = "", diaAluno = "", mesAluno = "", anoJogadoAluno = "";
							int pontoAluno = 0;
							Aluno a;	//	ALUNO AUXILIAR QUE IR� RECEBER OS DADOS E ESSE ALUNO SER� ARMAZENADO NO ARRAYLIST DE ALUNOS
							while (linha != null) {
								if((linha!=null)){	//Captura a ultima linha do arquivo, que nesse caso, � onde est� presente o nome da escola
									if(indice==2){	//Se o indice for correspondente a linha 2
										nomeAluno = linha.substring(linha.indexOf("Nome: ")+6, linha.indexOf("\t\t\tAno"));
										anoAluno = linha.substring(linha.indexOf("Ano: ")+5, linha.indexOf("\t\tPontua��o Total: "));
										pontoAluno = Integer.parseInt(linha.substring(linha.indexOf("Pontua��o Total: ")+17, linha.length()));
									}
									if(indice==3){
										String dataAluno = linha.substring(linha.indexOf("Data: ") + 6, linha.indexOf("\t\tEscola:"));
										diaAluno = dataAluno.substring(0, 2);
										mesAluno = dataAluno.substring(3, 5);
										anoJogadoAluno = dataAluno.substring(6, 10);
										String Escola = linha.substring(linha.indexOf("Escola: ")+8, linha.length());
									
										a = new Aluno(nomeAluno, anoAluno);
										a.setPonto(pontoAluno);
										a.setDia(diaAluno);
										a.setMes(mesAluno);
										a.setAnoJogado(anoJogadoAluno);
										a.setEscola(Escola);
										alunos.add(a);
									}
								}
								indice++;
								linha = bufferLeitura.readLine();
							}
						bufferLeitura.close();
						}
					}
				}
				alunos = organizandoAlunos(alunos);	//Organiza em ordem de maior pontua��o
				Path caminhoRelatorioTurma = Paths.get("Hist�rico\\"+this.dificuldade+"\\"+this.ano+"\\"+this.mes+"\\"+this.dia+"\\"+this.escola+"\\"+turmaEscolhida+"\\Relat�rio de Turma.txt");
				criarRelatorio(caminhoRelatorioTurma, alunos);
				atualizarRelatorios(turmaEscolhida);
			}
			else if(caminho.toFile().exists()==false){
				System.out.println("N�o existe a pasta hist�rico.");
			}
		}catch(Exception erro){		//Tratamento de erros
			erro.printStackTrace();
			System.out.println("Erro na leitura de arquivos");
		}
	}
	
	public void criarRelatorio(Path caminhoArquivo, ArrayList<Aluno> a){
		try{
			String quebraLinha = System.lineSeparator();
			caminhoArquivo.toFile().setWritable(true);
			caminhoArquivo.toFile().setReadable(true);
			OutputStreamWriter bufferOut = new OutputStreamWriter(new FileOutputStream(caminhoArquivo.toString()),"UTF-8");
			bufferOut.write("");
			if(a!=null){	//Se o relat�rio n�o for vazio, ou seja, Arraylist alunos cont�m elementos
				for(int i=0;i<a.size();i++){
					Aluno aluno = a.get(i);	//Captura o aluno na posi��o determinada do Arraylist de alunos	
					bufferOut.write((i+1)+") "+"Nome: "+aluno.getNome()+" \tAno: "+aluno.getAno()+" \tPontua��o Total: "+aluno.getPonto()+" \tEscola: "+aluno.getEscola()+" \tData: "+aluno.getDia()+"/"+aluno.getMes()+"/"+aluno.getAnoJogado()+quebraLinha);
				}
			}
			bufferOut.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	public void apagarRelatorio(Path caminhoRelatorio){
		try{
			if(caminhoRelatorio.toFile().exists()==true){
				caminhoRelatorio.toFile().delete();	
				System.out.println("Relat�rio apagado com sucesso");
			}
			else{	//Arquivo do Relatorio determinado n�o existe
				System.out.println("Arquivo de Relat�rio inexistente");
			}
		}
		catch(Exception erro){
			erro.printStackTrace();
			System.out.println("Erro na leitura de arquivos");
		}
	}
	
	public void atualizarRelatorios(String turmaEscolhida){		// Atualizar os outros relat�rios com base no novo relat�rio de turma
		Path caminhoRelatorioTurma = Paths.get("Hist�rico\\"+this.dificuldade+"\\"+this.ano+"\\"+this.mes+"\\"+this.dia+"\\"+this.escola+"\\"+turmaEscolhida+"\\Relat�rio de Turma.txt");
		Path caminhoRelatorioEscola = Paths.get("Hist�rico\\"+this.dificuldade+"\\"+this.ano+"\\"+this.mes+"\\"+this.dia+"\\"+this.escola+"\\Relat�rio da Escola.txt");
		Path caminhoRelatorioDiario = Paths.get("Hist�rico\\"+this.dificuldade+"\\"+this.ano+"\\"+this.mes+"\\"+this.dia+"\\Relat�rio Di�rio.txt");
		Path caminhoRelatorioGeral = Paths.get("Hist�rico\\"+this.dificuldade+"\\Relat�rio Geral.txt");
		
		/**	ARMAZENAGEM DOS ALUNOS DO RELAT�RIO DA TURMA*/
		lerArquivos(caminhoRelatorioTurma);
		ArrayList<Aluno> alunosTurma = new ArrayList<Aluno>();
		for(int i = 0; i < alunos.size();i++){	
			alunosTurma.add(alunos.get(i));		//Adiciona todos os alunos da turma no arraylist da turma
		}
		
		/**	ARMAZENAGEM DOS ALUNOS DO RELAT�RIO DA ESCOLA*/
		lerArquivos(caminhoRelatorioEscola);
		ArrayList<Aluno> alunosEscola = new ArrayList<Aluno>();
		for(int i = 0; i < alunos.size();i++){	
			alunosEscola.add(alunos.get(i));	//Adiciona todos os alunos da escola no arraylist da escola
		}
		
		/**	AJUSTANDO RELATORIO ESCOLA - TURMA*/
		apagarRelatorio(caminhoRelatorioEscola);	//Elimina o relat�rio da escola antigo
		for(int i = 0; i < alunosTurma.size();i++){	
			alunosEscola.add(alunosTurma.get(i));	//Adiciona todos os alunos da turma no arraylist da escola, mesmo com repeti��es
		}
		alunosEscola = organizandoAlunos(alunosEscola); //alunosEscola recebe o arraylist organizado
		criarRelatorio(caminhoRelatorioEscola, alunosEscola);	//cria o relat�rio da escola atualizado
		
		/**	ARMAZENAGEM DOS ALUNOS DO RELAT�RIO DI�RIO*/
		lerArquivos(caminhoRelatorioDiario);	///	OLHAR AQUI, CORRIGIR, ELE GERA O RELAT�RIO DA TURMA CORRETAMENTE MAS OS OUTROS RELAT�RIOS FICAM EM BRANCO MAS S�O APAGADOS E CRIADOS
		ArrayList<Aluno> alunosDiario = new ArrayList<Aluno>();
		for(int i = 0; i < alunos.size();i++){	
			alunosDiario.add(alunos.get(i));	//Adiciona todos os alunos do dia no arraylist alunosDiario
		}
		
		/**	ARMAZENAGEM DOS ALUNOS DO RELAT�RIO GERAL*/
		lerArquivos(caminhoRelatorioGeral);		/// POR VIA DAS DUVIDAS, PARA TESTAR EU POSSO MEDIR O TAMANHO DO ARRAYLIST AQUI EM UM PRINTLN
		ArrayList<Aluno> alunosGeral = new ArrayList<Aluno>();
		for(int i = 0; i < alunos.size();i++){	
			alunosGeral.add(alunos.get(i));	//Adiciona todos os alunos geral no arraylist alunosGeral
		}
		
		/**	AJUSTANDO RELATORIO ESCOLA - DIARIO*/
		apagarRelatorio(caminhoRelatorioDiario);	//Elimina o relat�rio di�rio antigo
		for(int i = 0; i < alunosEscola.size();i++){
			alunosDiario.add(alunosEscola.get(i));	//Adiciona todos os alunos da escola atualizado no arraylist alunosDiario
		}
		alunosDiario = organizandoAlunos(alunosDiario); //alunosDiario recebe o arraylist atualizado e organizado
		criarRelatorio(caminhoRelatorioDiario, alunosDiario);	//Cria o relat�rio Di�rio com os dados atualizados
		
		/**	AJUSTANDO RELATORIO DI�RIO - GERAL*/
		apagarRelatorio(caminhoRelatorioGeral);	//Elimina o relat�rio geral antigo
		for(int i = 0; i < alunosDiario.size();i++){
			alunosGeral.add(alunosDiario.get(i));	//Adiciona todos os alunos Di�rio atualizado no arraylist alunosGeral
		}
		alunosGeral = organizandoAlunos(alunosGeral); //alunosGeral recebe o arraylist atualizado e organizado
		criarRelatorio(caminhoRelatorioGeral, alunosGeral);	//Cria o relat�rio Geral com os dados atualizados
	}
	
	public int getNumRodadas(String turmaSelecionada){	//Retorna o n�mero de pastas de rodadas em uma determinada turma
		Path caminhoRelatorio = Paths.get("Hist�rico\\"+this.dificuldade+"\\"+this.ano+"\\"+this.mes+"\\"+this.dia+"\\"+this.escola+"\\"+turmaSelecionada);
		String[] aux = caminhoRelatorio.toFile().list();
		ArrayList<String> rodadas = new ArrayList<String>();
		for(int i = 0; i< aux.length; i++){
			if((aux[i].contains(".")== false)&&(aux[i].contains("Rodada")==true)){	//Captura o numero de pastas de rodadas
				rodadas.add(aux[i]);
			}
		}
		return rodadas.size();
	}
	
	public int getNumElemUltRod(String turmaSelecionada){	//Retorna o N�mero de alunos/arquivos presente na ultima pasta da ultima rodada
		try{
			Path caminhoRelatorio = Paths.get("Hist�rico\\"+this.dificuldade+"\\"+this.ano+"\\"+this.mes+"\\"+this.dia+"\\"+this.escola+"\\"+turmaSelecionada+"\\"+getNumRodadas(turmaSelecionada)+"� Rodada");
			if(caminhoRelatorio.toFile().exists()==true){
				int numElemUltRod = caminhoRelatorio.toFile().list().length;
				return numElemUltRod;
			}
			else{
				System.out.println("N�o h� pasta de rodadas para se capturar o n�mero de elementos");
				return 0;
			}
		}
		catch(Exception erro){
			erro.printStackTrace();
		}
		return 0;
	}
	
	public int getNumElemTurma(String turmaSelecionada){ 	//Retorna o n�mero de alunos/arquivos presente no Relat�rio de Turma
		try{
			Path caminhoRelatorio = Paths.get("Hist�rico\\"+this.dificuldade+"\\"+this.ano+"\\"+this.mes+"\\"+this.dia+"\\"+this.escola+"\\"+turmaSelecionada+"\\Relat�rio de Turma.txt");
			if(caminhoRelatorio.toFile().exists()==true){
				lerArquivos(caminhoRelatorio);
				int numElem = alunos.size();
				return numElem;
			}
			else{
				System.out.println("N�o existe o relat�rio de Turma para a "+turmaSelecionada);
				return 0;
			}
		}
		catch(Exception erro){
			erro.printStackTrace();
		}
		return 0;
	}
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==comboDificuldades){
			if(dificuldade.equals(comboDificuldades.getSelectedItem())){	//Se a dificuldade seleciona na combobox for a mesma da rodada que est� ocorrendo
				comboTipoRelatorio.setEnabled(true);
			}
			else{
				//Limpa o campo selecionado nas outras comboboxes e as oculta
				comboTipoRelatorio.setSelectedItem(null);
				comboEscolas.setSelectedItem(null);
				comboTurmas.setSelectedItem(null);
				comboTipoRelatorio.setEnabled(false);
				comboEscolas.setEnabled(false);
				comboTurmas.setEnabled(false);
				//Analisa atrav�s do �ndice do elemento selecionado, e define a a��o que ir� ocorrer
				Path caminhoRelatorio;
				switch(comboDificuldades.getSelectedIndex()){
					case 0:
						caminhoRelatorio = Paths.get("Hist�rico\\9� Ano");
						if(caminhoRelatorio.toFile().exists()==false){
							caminhoRelatorio.toFile().mkdir();
						}
						caminhoRelatorio = Paths.get("Hist�rico\\9� Ano\\Relat�rio Geral.txt");
						lerArquivos(caminhoRelatorio);
						atribDadosJTable();
						painelFundo.setVisible(false);	//"Limpa" a tabela para depois atribuir os dados a tabela
						ajustaTabela(dados);
						break;
					case 1:
						caminhoRelatorio = Paths.get("Hist�rico\\1� Ano");
						if(caminhoRelatorio.toFile().exists()==false){
							caminhoRelatorio.toFile().mkdir();
						}
						caminhoRelatorio = Paths.get("Hist�rico\\1� Ano\\Relat�rio Geral.txt");
						lerArquivos(caminhoRelatorio);
						atribDadosJTable();
						painelFundo.setVisible(false);
						ajustaTabela(dados);
						break;
					case 2:
						caminhoRelatorio = Paths.get("Hist�rico\\2� Ano");
						if(caminhoRelatorio.toFile().exists()==false){
							caminhoRelatorio.toFile().mkdir();
						}
						caminhoRelatorio = Paths.get("Hist�rico\\2� Ano\\Relat�rio Geral.txt");
						lerArquivos(caminhoRelatorio);
						atribDadosJTable();
						painelFundo.setVisible(false);
						ajustaTabela(dados);
						break;
					case 3:
						caminhoRelatorio = Paths.get("Hist�rico\\3� Ano");
						if(caminhoRelatorio.toFile().exists()==false){
							caminhoRelatorio.toFile().mkdir();
						}
						caminhoRelatorio = Paths.get("Hist�rico\\3� Ano\\Relat�rio Geral.txt");
						lerArquivos(caminhoRelatorio);
						atribDadosJTable();
						painelFundo.setVisible(false);
						ajustaTabela(dados);
						break;
					default:
						System.out.println("Ocorreu um erro no Switch de dificuldades.");
				}
			}
		}
		
		if(e.getSource()==comboTipoRelatorio){
			if("Di�rio".equals(comboTipoRelatorio.getSelectedItem())){	//Se Di�rio for selecionado
				comboEscolas.setSelectedItem(null);
				comboTurmas.setSelectedItem(null);
				comboEscolas.setEnabled(true);
				comboTurmas.setEnabled(false);
				// LISTA NA TABELA O RELAT�RIO DI�RIO
				Path caminhoRelatorio = Paths.get("Hist�rico\\"+this.dificuldade+"\\"+this.ano+"\\"+this.mes+"\\"+this.dia+"\\Relat�rio Di�rio.txt");
				lerArquivos(caminhoRelatorio);
				atribDadosJTable();
				painelFundo.setVisible(false);
				ajustaTabela(dados);
			}
			if("Geral".equals(comboTipoRelatorio.getSelectedItem())){	//Se Geral for selecionado -- para comparar strings usa-se .equals e n�o "==" 
				try{
					//Limpa o campo selecionado nas outras comboboxes e as oculta
					comboEscolas.setSelectedItem(null);
					comboTurmas.setSelectedItem(null);
					comboEscolas.setEnabled(false);
					comboTurmas.setEnabled(false);
					Path caminhoRelatorio = Paths.get("Hist�rico\\"+this.dificuldade+"\\Relat�rio Geral.txt");
					if(caminhoRelatorio.toFile().exists()==true){
						lerArquivos(caminhoRelatorio);
						atribDadosJTable();
						painelFundo.setVisible(false);	//"Limpa" a tabela para depois atribuir os dados a ela
						ajustaTabela(dados);
					}
					else{	//Se o arquivo do Relat�rio Geral n�o existe, ele ser� criado vazio	
						lerArquivos(caminhoRelatorio);
						atribDadosJTable();
						painelFundo.setVisible(false);	//"Limpa" a tabela para depois atribuir os dados a ela
						ajustaTabela(dados);
					}
				}
				catch(Exception erro){
					erro.printStackTrace();
				}
			}
		}
		
		if(e.getSource()==comboEscolas){
			try{
				if((dificuldade.equals(comboDificuldades.getSelectedItem()))&&("Di�rio".equals(comboTipoRelatorio.getSelectedItem()))&&((comboEscolas.getSelectedItem()==null)==false)&&(indiceDestrave==0)){	//Se a dificuldade for a mesma da rodada, a op��o "Di�rio" for selecionada, a comboBox escola estiver com a op��o null selecionada, e o indice de destrave das perguntas for zero 
					if(escola.equals(comboEscolas.getSelectedItem())==true){	//Se a op��o da escola selecionada tiver o mesmo nome que aquela utilizada na rodada
						comboTurmas.setSelectedItem(null);
						comboTurmas.setEnabled(true);
						Path caminhoRelatorio = Paths.get("Hist�rico\\"+this.dificuldade+"\\"+this.ano+"\\"+this.mes+"\\"+this.dia+"\\"+this.escola+"\\Relat�rio da Escola.txt");
						if(caminhoRelatorio.toFile().exists()==true){	//Se o relat�rio da escola existe
							lerArquivos(caminhoRelatorio);
							atribDadosJTable();
							painelFundo.setVisible(false);
							ajustaTabela(dados);
						}
						else{	//Se o relat�rio da escola n�o existe, como n�o existe ele ser� criado VAZIO
							lerArquivos(caminhoRelatorio);
							atribDadosJTable();
							painelFundo.setVisible(false);
							ajustaTabela(dados);
						}
					}
					else{	//Se a escola selecionada tiver nome diferente
						comboTurmas.setSelectedItem(null);
						comboTurmas.setEnabled(false);
						String schoolSelected = comboEscolas.getSelectedItem()+"";
						Path caminhoRelatorio = Paths.get("Hist�rico\\"+this.dificuldade+"\\"+this.ano+"\\"+this.mes+"\\"+this.dia+"\\"+schoolSelected+"\\Relat�rio da Escola.txt");
						if(caminhoRelatorio.toFile().exists()==true){
							lerArquivos(caminhoRelatorio);
							atribDadosJTable();
							painelFundo.setVisible(false);
							ajustaTabela(dados);
						}
						else{	//Se o arquivo de texto do relat�rio de outra escola n�o existe ele � criado VAZIO
							lerArquivos(caminhoRelatorio);
							atribDadosJTable();
							painelFundo.setVisible(false);	//"LIMPA" A TABELA PRA DEPOIS ATRIBUIR OS DADOS A ELA
							ajustaTabela(dados);
						}
					}
				}
			}
			catch(Exception erro){
				erro.printStackTrace();
			}
		}
   			
		if(e.getSource()==comboTurmas){
			try{
				if((comboTurmas.isEnabled()==true)&&((comboTurmas.getSelectedItem()==null)==false)){	//Se a combobox Turmas estiver ativa e houver um �tem selecionado nela
					String turmaSelecionada = comboTurmas.getSelectedItem().toString();
					Path caminhoRelatorio = Paths.get("Hist�rico\\"+this.dificuldade+"\\"+this.ano+"\\"+this.mes+"\\"+this.dia+"\\"+this.escola+"\\"+turmaSelecionada+"\\Relat�rio de Turma.txt");
					if(caminhoRelatorio.toFile().exists()==true){	//Se relat�rio da turma existe
						if(contRodadas < getNumRodadas(turmaSelecionada)){		//Se houver pastas de rodadas n�o atribuidas ao relat�rio de turma
							contRodadas = getNumRodadas(turmaSelecionada);
							apagarRelatorio(caminhoRelatorio);
							criandoRelatTurma(turmaSelecionada);
						}
						if(getNumElemUltRod(turmaSelecionada) != getNumElemTurma(turmaSelecionada)){	//Se houver mais elementos que o relat�rio de turma apresenta ent�o ele ser� atualizado
							apagarRelatorio(caminhoRelatorio);
							criandoRelatTurma(turmaSelecionada);
						}
						lerArquivos(caminhoRelatorio);
						atribDadosJTable();
						painelFundo.setVisible(false);
						ajustaTabela(dados);
					}
					else{	//Se o arquivo do relat�rio da turma n�o existe ent�o ser� lido as pastas das rodadas e assim criado um novo relat�rio da turma
						contRodadas = getNumRodadas(turmaSelecionada);
						criandoRelatTurma(turmaSelecionada);
						lerArquivos(caminhoRelatorio);
						atribDadosJTable();
						painelFundo.setVisible(false);
						ajustaTabela(dados);
					}
				}
			}
			catch(Exception erro){
				erro.printStackTrace();
			}
		}
		/**
		 * Qualquer mudan�a ao clicar nas combobox dever� ser atribuido o fundo novamente
		 */
		setFundo();	
	}
}