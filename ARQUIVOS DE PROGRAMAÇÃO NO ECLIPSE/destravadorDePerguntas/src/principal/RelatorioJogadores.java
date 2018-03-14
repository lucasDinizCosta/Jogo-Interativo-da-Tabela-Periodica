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
	private JComboBox<String> comboDificuldades = new JComboBox<String>();	//Dificuldades: 9º Ano, 1º Ano, 2º Ano e 3º Ano
	private JComboBox<String> comboTipoRelatorio = new JComboBox<String>(); //Tipo de relatório: Geral e Diário
	private JComboBox<String> comboEscolas = new JComboBox<String>();	//Escolas
	private JComboBox<String> comboTurmas = new JComboBox<String>();	//Turmas
	private ImageIcon imagemFundo = new ImageIcon(getClass().getResource("/imagens/Fundo Relatorio Jogadores.PNG"));
	private JLabel fundo = new JLabel();
	private Color corFundo = new Color(187, 204, 208);
	
	//Variáveis que serão utilizadas para capturar os dados utilizados na janela dos menus
	private String dia = "";
	private String mes = ""; 		
	private String ano = "";		
	private String escola = "";		
	private String dificuldade = "";
	private int indiceDestrave = 0;
	
	private Path caminho = Paths.get("Histórico");
	private int contRodadas = 0;	//Contador de Rodadas computadas
	
	//Variáveis controladoras da tabela
	private String [] colunas = {"nº", "Nome", "Ano escolar", "Escola", "Pontuação", "Data"};	//Nomes das colunas - 6 colunas no total
	private Object [][] dados;
	private JTable tabela;
	private JScrollPane barraRolagem;
	private JPanel painelFundo;
	private ArrayList<Aluno> alunos = new ArrayList<Aluno>();	//Reponsável por armazenar os alunos de cada relatório e armazenar suas característica para assim, inserí-los na tabela
	
	//Janelas
	private JFrame janelaDestravador;	//Janela auxiliar que irá me permitir voltar a janela de menus sem sair do jogo
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
		janelaRelatorioJogadores.setVisible(true);	//Torna a janela visível somente após adicionar todos os elementos presentes na tela
	}
	
	public void setJanela(){
		janelaRelatorioJogadores.setSize(794,471);
		janelaRelatorioJogadores.setTitle("Relatório dos Jogadores");
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
		comboDificuldades.addItem("9º Ano");
		comboDificuldades.addItem("1º Ano");
		comboDificuldades.addItem("2º Ano");
		comboDificuldades.addItem("3º Ano");
		comboDificuldades.setBounds(32, 128, 120, 25);
		comboDificuldades.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		comboDificuldades.setSelectedItem(null);	// Não é selecionado nenhum elemento da combobox inicialmente, por isso é Null
		comboDificuldades.addActionListener(this);
		janelaRelatorioJogadores.add(comboDificuldades);
	}
	
	/**Quando o usuário clicar no x com o intuito de finalizar a janela irá ocorrer o método abaixo*/
	
	WindowListener Window = new WindowAdapter() 
	{  
	    public void windowClosing(WindowEvent e){
	    	janelaRelatorioJogadores.dispose();
	    	janelaDestravador.setVisible(true);
	    }  
	};
	
	public void setComboRelatorio(){
		comboTipoRelatorio.setEnabled(false);	//Torna a combobox "oculta", não interativa
		comboTipoRelatorio.addItem("Geral");
		comboTipoRelatorio.addItem("Diário");
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
		comboEscolas.setMaximumRowCount(4);	// Representa que o limite de campos que aparece na combobox será 4, além disso é usado uma barra de scroll
		comboEscolas.addActionListener(this);
		janelaRelatorioJogadores.add(comboEscolas);
	}
	
	public void setComboTurma(){
		comboTurmas.setEnabled(false);
		comboTurmas.setBounds(641,128,120,25);
		comboTurmas.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		comboTurmas.setSelectedItem(null);
		comboTurmas.setMaximumRowCount(4);	// Representa que o limite de campos que aparece na combobox será 2, além disso é usado uma barra de scroll
		comboTurmas.addActionListener(this);
		janelaRelatorioJogadores.add(comboTurmas);
	}
	
	public void AtributosComboEscola(){
		try{
			caminho = Paths.get("Histórico\\"+this.dificuldade+"\\"+this.ano+"\\"+this.mes+"\\"+this.dia);
			System.out.println(caminho);
			String[] escolas = caminho.toFile().list();		//Captura o nome das pastas das escolas que jogaram o jogo
			ArrayList<String> ordemAlfabetica = new ArrayList<String>();	//Armazenará e colocará os elementos da combobox em ordem alfabética através desse arraylist
			for(int i = 0; i < escolas.length; i++){
				if(escolas[i].contains(".")==false){	//Se o nome não paresentar ponto ele será capturado, isso faz ele capturar somente nome de pastas
					ordemAlfabetica.add(escolas[i]);
				}
			}
			Collections.sort(ordemAlfabetica, new Comparator<String>() {	//Organizando os elementos da arraylist em ordem alfabética
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
		caminho = Paths.get("Histórico\\"+this.dificuldade+"\\"+this.ano+"\\"+this.mes+"\\"+this.dia+"\\"+this.escola);
		String[] turmas = caminho.toFile().list();	//Armazena os nome das turmas do dia em um array
		for(int i = 0; i < turmas.length; i++){
			if((turmas[i].contains("Turma")==true)&&(turmas[i].contains(".")==false)){	// Só irá adicionar na combobox se tiver "Turma" no nome e não tiver "."
				comboTurmas.addItem(turmas[i]);
			}
		}
		comboTurmas.setSelectedItem(null);
	}
	
	public void lerArquivos(Path caminhoDesejado){
		try{
			alunos.clear();		//Limpa o Arraylist de alunos antes, de modo a evitar duplicatas de nomes
			Path caminhoAuxiliar = caminhoDesejado;
			if(caminhoAuxiliar.toFile().exists()==true){	//O Arquivo só pode ser lido se o caminho existir, caso contrário acarreta em um erro que será tratado pelo try e catch
				Charset utf8charset = Charset.forName("UTF-8");	//Tipo de codificação do Arquivo
				FileInputStream caminhoDoArquivo = new FileInputStream(caminhoAuxiliar.toFile().getPath());	//Lê o arquivo de texto, faz a leitura dos dados binários não importando a fonte
				InputStreamReader tradutorEncode = new InputStreamReader(caminhoDoArquivo, utf8charset); 	//Traduz os bytes com a codificação dada, em outras palavras é um decodificador para uma
																											//codificação específica, nesse caso "UTF-8" mas poderia ser "ISO-8859-1"
																											//Lê bytes de um lado e converte em caracteres do outro, através do uso de uma codificação de caracteres (encoding)
				BufferedReader bufferLeitura = new BufferedReader(tradutorEncode);	//Concatena os diversos chars para formar uma String através do método readLine		
				String linha = bufferLeitura.readLine();		//Passa o conteúdo da primeira linha para uma variável String
				String nomeAux = "", anoAux = "", diaAux = "", mesAux = "", anoJogadoAux = "";	//Variáveis auxiliares para capturar os dados dos alunos em cada linha
				int pontoAux = 0;
				Aluno a;	// Aluno auxiliar que irá receber os dados e esse aluno será armazenado no Arraylist de alunos
				while (linha != null){
					nomeAux = linha.substring(linha.indexOf("Nome: ")+6, linha.indexOf(" \tAno"));
					anoAux = linha.substring(linha.indexOf("Ano: ")+5, linha.indexOf(" \tPontuação"));
					pontoAux = Integer.parseInt(linha.substring(linha.indexOf("Pontuação Total: ")+17, linha.indexOf(" \tEscola")));
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
			else if(caminhoAuxiliar.toFile().exists()==false){	//Se o Arquivo de relatório não existe, para não dar problema ele será criado como arquivo vazio
				criarRelatorio(caminhoAuxiliar, null);
			}
		}catch(Exception erro){		//Tratamento de erros
			erro.printStackTrace();
			System.out.println("Erro na leitura de arquivos");
		}
	}

	/**
	 * Organiza os alunos de acordo com a pontuação do maior para o menor
	 */
	public ArrayList organizandoAlunos(ArrayList<Aluno> alunosAOrganizar){
		Aluno aux = new Aluno("Nome", "Ano");
		aux.setPonto(0);
		ArrayList<Aluno> alunosOrganizados = new ArrayList<Aluno>();
		for( int i=0; i < alunosAOrganizar.size(); i++ ){		//Método do BubbleSort em java, organiza do menor para o maior
			for( int j = alunosAOrganizar.size() - 1; j > i; j--){
				if(alunosAOrganizar.get(j).getPonto() < alunosAOrganizar.get(j-1).getPonto()){
					aux = alunosAOrganizar.get(j);
					alunosAOrganizar.set(j, alunosAOrganizar.get(j-1));
					alunosAOrganizar.set(j-1, aux);
				}
			}	
		}
		System.out.println("ORDENADO DO MENOR PRO MAIOR");
		for(int j = alunosAOrganizar.size()-1;j>=0;j--){	//Organizando de maior pontuação até o menor
		// LINHA COM PROBLEMA DE INDICE ---->	//System.out.println((j+1)+") Nome: "+alunos.get(j).getNome()+ " Ano: "+alunosAOrganizar.get(j).getAno()+ " Escola: " + alunosAOrganizar.get(j).getEscola()+" Pontuação: "+alunosAOrganizar.get(j).getPonto()+ " Data: " + alunosAOrganizar.get(j).getDia() +"/"+alunosAOrganizar.get(j).getMes()+"/"+ alunosAOrganizar.get(j).getAnoJogado());
			alunosOrganizados.add(alunosAOrganizar.get(j));
		}
		alunosOrganizados = retirarNomesRepetidos(alunosOrganizados);	//Receberá o arraylist de alunos Organizados por pontuação e sem repetição de nomes
		return alunosOrganizados;
	}
	
	public ArrayList retirarNomesRepetidos(ArrayList<Aluno> alunosAOrganizar){
		ArrayList<Aluno> alunosOrganizados = new ArrayList<Aluno>();
		for(int i = 0; i<alunosAOrganizar.size(); i++){
			boolean alunoNomeIgual = false;
			for(int j = 0;j<alunosOrganizados.size();j++){	//Analisa até o arrayList de alunosOrganizados acabar
				if(alunosOrganizados.get(j).getNome().equals(alunosAOrganizar.get(i).getNome())){
					alunoNomeIgual = true;	//Se o aluno do arraylist alunosOrganizados tiver o mesmo nome do aluno analisado alunosAOrganizar
				}
			}
			if(alunoNomeIgual == false){	//Só será acrescido o aluno com nome único e maior pontuação ao arraylist de alunosOrganizados, ou seja, captura a primeira ocorrência do aluno em alunosAOrganizar
				alunosOrganizados.add(alunosAOrganizar.get(i));
			}
		}
		return alunosOrganizados;
	}
	
	public void ajustaTabela(Object[][] dados){
		painelFundo = new JPanel();
		painelFundo.setLayout(null);
		tabela = new JTable(dados, colunas){
			public boolean isCellEditable(int dados, int coluna){	//Proibe a edição de células
				return false;
			}
		};
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer(){};	//É necessário caso queira centralizar as colunas
		centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);	
		tabela.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		tabela.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);	//Centralizando os elementos das colunas 0, 2 e 4
		tabela.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
		tabela.setPreferredScrollableViewportSize(new Dimension(731,159));	//Define o tamanho preferido da janela de exibição para esta tabela
		tabela.setFillsViewportHeight(true);	//Define se a tabela é sempre grande(ou não) o suficiente para preencher a altura de uma janela
		barraRolagem = new JScrollPane(tabela);
		barraRolagem.setWheelScrollingEnabled(true);							//Ativa a rolagem pelo scroll do mouse
		barraRolagem.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		tabela.getColumnModel().getColumn(0).setMinWidth(60);			//Define o tamanho da coluna 0 (Número da linha)
		tabela.getColumnModel().getColumn(1).setMinWidth(180);			//Define o tamanho da coluna 1 (Nome do aluno)
		tabela.getColumnModel().getColumn(2).setMinWidth(90);			//Define o tamanho da coluna 2 (Ano escolar)
		tabela.getColumnModel().getColumn(3).setMinWidth(180);			//Define o tamanho da coluna 3 (Nome da escola)
		tabela.getColumnModel().getColumn(4).setMinWidth(90);			//Define o tamanho da coluna 4 (Pontuação)
		tabela.getColumnModel().getColumn(5).setMinWidth(80);			//Define o tamanho da coluna 5 (Data)
		tabela.getTableHeader().setBackground(new Color(189,197,229));	//Colore o fundo do cabeçalho
		tabela.getTableHeader().setFont(new Font("Tahoma",Font.BOLD,13));
		tabela.setSelectionMode(0);		//Permite a seleção de somente uma linha
		tabela.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		tabela.getTableHeader().setBorder(BorderFactory.createLineBorder(Color.BLACK));
		barraRolagem.setBounds(0,0,731,181);
		painelFundo.add(barraRolagem);
		painelFundo.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		painelFundo.setBounds(32, 168, 731, 181);
		tabela.getTableHeader().setReorderingAllowed(false);	//Proibe a reordenação das colunas com o mouse
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
		try{	//Try e Catch são comandos usados na tentativa de tratar excessões e erros
			if(caminho.toFile().exists()==true){	//Verifica se a existência da pasta Histórico existe
				alunos.clear();	//Limpa o Arraylist de alunos antes, de modo a evitar duplicatas de nomes
				Path caminho5 = Paths.get("Histórico\\"+this.dificuldade+"\\"+this.ano+"\\"+this.mes+"\\"+this.dia+"\\"+this.escola+"\\"+turmaEscolhida);
				String[] diretoriosRodadas = caminho5.toFile().list();	//Captura o número de SubPastas(Rodadas) presente na pasta da Turma escolhida da Escola
				for(int i = 0; i < diretoriosRodadas.length;i++){	//Percorre as pastas das rodadas
					Path caminho6 = Paths.get(caminho5.toString()+"\\"+diretoriosRodadas[i]);
					if(caminho6.toFile().isDirectory()==true){	//Verifica se o arquivo diretorioRodadas realmente é uma pasta/Diretório
						String[] arquivosRelatorio = caminho6.toFile().list();	//arquivos das pastas das pastas de Rodadas
						for(int j = 0; j < arquivosRelatorio.length;j++){	//Irá analisar todos os arquvos de texto
							Path caminho3 = Paths.get(caminho6.toString()+"\\"+arquivosRelatorio[j]);
							FileInputStream caminhoDoArquivo = new FileInputStream(caminho3.toFile().getPath());	//Lê o arquivo de texto, faz a leitura dos dados binários não importando a fonte
							InputStreamReader tradutorEncode = new InputStreamReader(caminhoDoArquivo, "UTF-8"); 	//Traduz os bytes com a codificação dada, em outras palavras é um decodificador para uma
																													//codificação específica, nesse caso "UTF-8" mas poderia ser "ISO-8859-1"
																													//Lê bytes de um lado e converte em caracteres do outro, através do uso de uma codificação de caracteres (encoding)
							BufferedReader bufferLeitura = new BufferedReader(tradutorEncode);	//Concatena os diversos chars para formar uma String através do método readLine
							String linha = bufferLeitura.readLine();	//Passa o conteúdo da primeira linha para uma variável String
							int indice = 1;		//Índice usado para ter a ideia do número de linhas para a leitura
							String nomeAluno = "", anoAluno = "", diaAluno = "", mesAluno = "", anoJogadoAluno = "";
							int pontoAluno = 0;
							Aluno a;	//	ALUNO AUXILIAR QUE IRÁ RECEBER OS DADOS E ESSE ALUNO SERÁ ARMAZENADO NO ARRAYLIST DE ALUNOS
							while (linha != null) {
								if((linha!=null)){	//Captura a ultima linha do arquivo, que nesse caso, é onde está presente o nome da escola
									if(indice==2){	//Se o indice for correspondente a linha 2
										nomeAluno = linha.substring(linha.indexOf("Nome: ")+6, linha.indexOf("\t\t\tAno"));
										anoAluno = linha.substring(linha.indexOf("Ano: ")+5, linha.indexOf("\t\tPontuação Total: "));
										pontoAluno = Integer.parseInt(linha.substring(linha.indexOf("Pontuação Total: ")+17, linha.length()));
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
				alunos = organizandoAlunos(alunos);	//Organiza em ordem de maior pontuação
				Path caminhoRelatorioTurma = Paths.get("Histórico\\"+this.dificuldade+"\\"+this.ano+"\\"+this.mes+"\\"+this.dia+"\\"+this.escola+"\\"+turmaEscolhida+"\\Relatório de Turma.txt");
				criarRelatorio(caminhoRelatorioTurma, alunos);
				atualizarRelatorios(turmaEscolhida);
			}
			else if(caminho.toFile().exists()==false){
				System.out.println("Não existe a pasta histórico.");
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
			if(a!=null){	//Se o relatório não for vazio, ou seja, Arraylist alunos contém elementos
				for(int i=0;i<a.size();i++){
					Aluno aluno = a.get(i);	//Captura o aluno na posição determinada do Arraylist de alunos	
					bufferOut.write((i+1)+") "+"Nome: "+aluno.getNome()+" \tAno: "+aluno.getAno()+" \tPontuação Total: "+aluno.getPonto()+" \tEscola: "+aluno.getEscola()+" \tData: "+aluno.getDia()+"/"+aluno.getMes()+"/"+aluno.getAnoJogado()+quebraLinha);
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
				System.out.println("Relatório apagado com sucesso");
			}
			else{	//Arquivo do Relatorio determinado não existe
				System.out.println("Arquivo de Relatório inexistente");
			}
		}
		catch(Exception erro){
			erro.printStackTrace();
			System.out.println("Erro na leitura de arquivos");
		}
	}
	
	public void atualizarRelatorios(String turmaEscolhida){		// Atualizar os outros relatórios com base no novo relatório de turma
		Path caminhoRelatorioTurma = Paths.get("Histórico\\"+this.dificuldade+"\\"+this.ano+"\\"+this.mes+"\\"+this.dia+"\\"+this.escola+"\\"+turmaEscolhida+"\\Relatório de Turma.txt");
		Path caminhoRelatorioEscola = Paths.get("Histórico\\"+this.dificuldade+"\\"+this.ano+"\\"+this.mes+"\\"+this.dia+"\\"+this.escola+"\\Relatório da Escola.txt");
		Path caminhoRelatorioDiario = Paths.get("Histórico\\"+this.dificuldade+"\\"+this.ano+"\\"+this.mes+"\\"+this.dia+"\\Relatório Diário.txt");
		Path caminhoRelatorioGeral = Paths.get("Histórico\\"+this.dificuldade+"\\Relatório Geral.txt");
		
		/**	ARMAZENAGEM DOS ALUNOS DO RELATÓRIO DA TURMA*/
		lerArquivos(caminhoRelatorioTurma);
		ArrayList<Aluno> alunosTurma = new ArrayList<Aluno>();
		for(int i = 0; i < alunos.size();i++){	
			alunosTurma.add(alunos.get(i));		//Adiciona todos os alunos da turma no arraylist da turma
		}
		
		/**	ARMAZENAGEM DOS ALUNOS DO RELATÓRIO DA ESCOLA*/
		lerArquivos(caminhoRelatorioEscola);
		ArrayList<Aluno> alunosEscola = new ArrayList<Aluno>();
		for(int i = 0; i < alunos.size();i++){	
			alunosEscola.add(alunos.get(i));	//Adiciona todos os alunos da escola no arraylist da escola
		}
		
		/**	AJUSTANDO RELATORIO ESCOLA - TURMA*/
		apagarRelatorio(caminhoRelatorioEscola);	//Elimina o relatório da escola antigo
		for(int i = 0; i < alunosTurma.size();i++){	
			alunosEscola.add(alunosTurma.get(i));	//Adiciona todos os alunos da turma no arraylist da escola, mesmo com repetições
		}
		alunosEscola = organizandoAlunos(alunosEscola); //alunosEscola recebe o arraylist organizado
		criarRelatorio(caminhoRelatorioEscola, alunosEscola);	//cria o relatório da escola atualizado
		
		/**	ARMAZENAGEM DOS ALUNOS DO RELATÓRIO DIÁRIO*/
		lerArquivos(caminhoRelatorioDiario);	///	OLHAR AQUI, CORRIGIR, ELE GERA O RELATÓRIO DA TURMA CORRETAMENTE MAS OS OUTROS RELATÓRIOS FICAM EM BRANCO MAS SÃO APAGADOS E CRIADOS
		ArrayList<Aluno> alunosDiario = new ArrayList<Aluno>();
		for(int i = 0; i < alunos.size();i++){	
			alunosDiario.add(alunos.get(i));	//Adiciona todos os alunos do dia no arraylist alunosDiario
		}
		
		/**	ARMAZENAGEM DOS ALUNOS DO RELATÓRIO GERAL*/
		lerArquivos(caminhoRelatorioGeral);		/// POR VIA DAS DUVIDAS, PARA TESTAR EU POSSO MEDIR O TAMANHO DO ARRAYLIST AQUI EM UM PRINTLN
		ArrayList<Aluno> alunosGeral = new ArrayList<Aluno>();
		for(int i = 0; i < alunos.size();i++){	
			alunosGeral.add(alunos.get(i));	//Adiciona todos os alunos geral no arraylist alunosGeral
		}
		
		/**	AJUSTANDO RELATORIO ESCOLA - DIARIO*/
		apagarRelatorio(caminhoRelatorioDiario);	//Elimina o relatório diário antigo
		for(int i = 0; i < alunosEscola.size();i++){
			alunosDiario.add(alunosEscola.get(i));	//Adiciona todos os alunos da escola atualizado no arraylist alunosDiario
		}
		alunosDiario = organizandoAlunos(alunosDiario); //alunosDiario recebe o arraylist atualizado e organizado
		criarRelatorio(caminhoRelatorioDiario, alunosDiario);	//Cria o relatório Diário com os dados atualizados
		
		/**	AJUSTANDO RELATORIO DIÁRIO - GERAL*/
		apagarRelatorio(caminhoRelatorioGeral);	//Elimina o relatório geral antigo
		for(int i = 0; i < alunosDiario.size();i++){
			alunosGeral.add(alunosDiario.get(i));	//Adiciona todos os alunos Diário atualizado no arraylist alunosGeral
		}
		alunosGeral = organizandoAlunos(alunosGeral); //alunosGeral recebe o arraylist atualizado e organizado
		criarRelatorio(caminhoRelatorioGeral, alunosGeral);	//Cria o relatório Geral com os dados atualizados
	}
	
	public int getNumRodadas(String turmaSelecionada){	//Retorna o número de pastas de rodadas em uma determinada turma
		Path caminhoRelatorio = Paths.get("Histórico\\"+this.dificuldade+"\\"+this.ano+"\\"+this.mes+"\\"+this.dia+"\\"+this.escola+"\\"+turmaSelecionada);
		String[] aux = caminhoRelatorio.toFile().list();
		ArrayList<String> rodadas = new ArrayList<String>();
		for(int i = 0; i< aux.length; i++){
			if((aux[i].contains(".")== false)&&(aux[i].contains("Rodada")==true)){	//Captura o numero de pastas de rodadas
				rodadas.add(aux[i]);
			}
		}
		return rodadas.size();
	}
	
	public int getNumElemUltRod(String turmaSelecionada){	//Retorna o Número de alunos/arquivos presente na ultima pasta da ultima rodada
		try{
			Path caminhoRelatorio = Paths.get("Histórico\\"+this.dificuldade+"\\"+this.ano+"\\"+this.mes+"\\"+this.dia+"\\"+this.escola+"\\"+turmaSelecionada+"\\"+getNumRodadas(turmaSelecionada)+"ª Rodada");
			if(caminhoRelatorio.toFile().exists()==true){
				int numElemUltRod = caminhoRelatorio.toFile().list().length;
				return numElemUltRod;
			}
			else{
				System.out.println("Não há pasta de rodadas para se capturar o número de elementos");
				return 0;
			}
		}
		catch(Exception erro){
			erro.printStackTrace();
		}
		return 0;
	}
	
	public int getNumElemTurma(String turmaSelecionada){ 	//Retorna o número de alunos/arquivos presente no Relatório de Turma
		try{
			Path caminhoRelatorio = Paths.get("Histórico\\"+this.dificuldade+"\\"+this.ano+"\\"+this.mes+"\\"+this.dia+"\\"+this.escola+"\\"+turmaSelecionada+"\\Relatório de Turma.txt");
			if(caminhoRelatorio.toFile().exists()==true){
				lerArquivos(caminhoRelatorio);
				int numElem = alunos.size();
				return numElem;
			}
			else{
				System.out.println("Não existe o relatório de Turma para a "+turmaSelecionada);
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
			if(dificuldade.equals(comboDificuldades.getSelectedItem())){	//Se a dificuldade seleciona na combobox for a mesma da rodada que está ocorrendo
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
				//Analisa através do índice do elemento selecionado, e define a ação que irá ocorrer
				Path caminhoRelatorio;
				switch(comboDificuldades.getSelectedIndex()){
					case 0:
						caminhoRelatorio = Paths.get("Histórico\\9º Ano");
						if(caminhoRelatorio.toFile().exists()==false){
							caminhoRelatorio.toFile().mkdir();
						}
						caminhoRelatorio = Paths.get("Histórico\\9º Ano\\Relatório Geral.txt");
						lerArquivos(caminhoRelatorio);
						atribDadosJTable();
						painelFundo.setVisible(false);	//"Limpa" a tabela para depois atribuir os dados a tabela
						ajustaTabela(dados);
						break;
					case 1:
						caminhoRelatorio = Paths.get("Histórico\\1º Ano");
						if(caminhoRelatorio.toFile().exists()==false){
							caminhoRelatorio.toFile().mkdir();
						}
						caminhoRelatorio = Paths.get("Histórico\\1º Ano\\Relatório Geral.txt");
						lerArquivos(caminhoRelatorio);
						atribDadosJTable();
						painelFundo.setVisible(false);
						ajustaTabela(dados);
						break;
					case 2:
						caminhoRelatorio = Paths.get("Histórico\\2º Ano");
						if(caminhoRelatorio.toFile().exists()==false){
							caminhoRelatorio.toFile().mkdir();
						}
						caminhoRelatorio = Paths.get("Histórico\\2º Ano\\Relatório Geral.txt");
						lerArquivos(caminhoRelatorio);
						atribDadosJTable();
						painelFundo.setVisible(false);
						ajustaTabela(dados);
						break;
					case 3:
						caminhoRelatorio = Paths.get("Histórico\\3º Ano");
						if(caminhoRelatorio.toFile().exists()==false){
							caminhoRelatorio.toFile().mkdir();
						}
						caminhoRelatorio = Paths.get("Histórico\\3º Ano\\Relatório Geral.txt");
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
			if("Diário".equals(comboTipoRelatorio.getSelectedItem())){	//Se Diário for selecionado
				comboEscolas.setSelectedItem(null);
				comboTurmas.setSelectedItem(null);
				comboEscolas.setEnabled(true);
				comboTurmas.setEnabled(false);
				// LISTA NA TABELA O RELATÓRIO DIÁRIO
				Path caminhoRelatorio = Paths.get("Histórico\\"+this.dificuldade+"\\"+this.ano+"\\"+this.mes+"\\"+this.dia+"\\Relatório Diário.txt");
				lerArquivos(caminhoRelatorio);
				atribDadosJTable();
				painelFundo.setVisible(false);
				ajustaTabela(dados);
			}
			if("Geral".equals(comboTipoRelatorio.getSelectedItem())){	//Se Geral for selecionado -- para comparar strings usa-se .equals e não "==" 
				try{
					//Limpa o campo selecionado nas outras comboboxes e as oculta
					comboEscolas.setSelectedItem(null);
					comboTurmas.setSelectedItem(null);
					comboEscolas.setEnabled(false);
					comboTurmas.setEnabled(false);
					Path caminhoRelatorio = Paths.get("Histórico\\"+this.dificuldade+"\\Relatório Geral.txt");
					if(caminhoRelatorio.toFile().exists()==true){
						lerArquivos(caminhoRelatorio);
						atribDadosJTable();
						painelFundo.setVisible(false);	//"Limpa" a tabela para depois atribuir os dados a ela
						ajustaTabela(dados);
					}
					else{	//Se o arquivo do Relatório Geral não existe, ele será criado vazio	
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
				if((dificuldade.equals(comboDificuldades.getSelectedItem()))&&("Diário".equals(comboTipoRelatorio.getSelectedItem()))&&((comboEscolas.getSelectedItem()==null)==false)&&(indiceDestrave==0)){	//Se a dificuldade for a mesma da rodada, a opção "Diário" for selecionada, a comboBox escola estiver com a opção null selecionada, e o indice de destrave das perguntas for zero 
					if(escola.equals(comboEscolas.getSelectedItem())==true){	//Se a opção da escola selecionada tiver o mesmo nome que aquela utilizada na rodada
						comboTurmas.setSelectedItem(null);
						comboTurmas.setEnabled(true);
						Path caminhoRelatorio = Paths.get("Histórico\\"+this.dificuldade+"\\"+this.ano+"\\"+this.mes+"\\"+this.dia+"\\"+this.escola+"\\Relatório da Escola.txt");
						if(caminhoRelatorio.toFile().exists()==true){	//Se o relatório da escola existe
							lerArquivos(caminhoRelatorio);
							atribDadosJTable();
							painelFundo.setVisible(false);
							ajustaTabela(dados);
						}
						else{	//Se o relatório da escola não existe, como não existe ele será criado VAZIO
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
						Path caminhoRelatorio = Paths.get("Histórico\\"+this.dificuldade+"\\"+this.ano+"\\"+this.mes+"\\"+this.dia+"\\"+schoolSelected+"\\Relatório da Escola.txt");
						if(caminhoRelatorio.toFile().exists()==true){
							lerArquivos(caminhoRelatorio);
							atribDadosJTable();
							painelFundo.setVisible(false);
							ajustaTabela(dados);
						}
						else{	//Se o arquivo de texto do relatório de outra escola não existe ele é criado VAZIO
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
				if((comboTurmas.isEnabled()==true)&&((comboTurmas.getSelectedItem()==null)==false)){	//Se a combobox Turmas estiver ativa e houver um ítem selecionado nela
					String turmaSelecionada = comboTurmas.getSelectedItem().toString();
					Path caminhoRelatorio = Paths.get("Histórico\\"+this.dificuldade+"\\"+this.ano+"\\"+this.mes+"\\"+this.dia+"\\"+this.escola+"\\"+turmaSelecionada+"\\Relatório de Turma.txt");
					if(caminhoRelatorio.toFile().exists()==true){	//Se relatório da turma existe
						if(contRodadas < getNumRodadas(turmaSelecionada)){		//Se houver pastas de rodadas não atribuidas ao relatório de turma
							contRodadas = getNumRodadas(turmaSelecionada);
							apagarRelatorio(caminhoRelatorio);
							criandoRelatTurma(turmaSelecionada);
						}
						if(getNumElemUltRod(turmaSelecionada) != getNumElemTurma(turmaSelecionada)){	//Se houver mais elementos que o relatório de turma apresenta então ele será atualizado
							apagarRelatorio(caminhoRelatorio);
							criandoRelatTurma(turmaSelecionada);
						}
						lerArquivos(caminhoRelatorio);
						atribDadosJTable();
						painelFundo.setVisible(false);
						ajustaTabela(dados);
					}
					else{	//Se o arquivo do relatório da turma não existe então será lido as pastas das rodadas e assim criado um novo relatório da turma
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
		 * Qualquer mudança ao clicar nas combobox deverá ser atribuido o fundo novamente
		 */
		setFundo();	
	}
}