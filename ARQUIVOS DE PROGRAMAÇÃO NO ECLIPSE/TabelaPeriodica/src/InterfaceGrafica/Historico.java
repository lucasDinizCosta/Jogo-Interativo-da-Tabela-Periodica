package InterfaceGrafica;

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

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

public class Historico implements ActionListener{

	private JComboBox<String> comboDificuldades = new JComboBox<String>();	//DIFICULDADES - 9ºANO, 1ºANO, 2ºANO, 3ºANO
	private String dia = "";
	private String mes = ""; 
	private String ano = "";
	private String escola = "";
	private String dificuldade = "";
	private Path caminho = Paths.get("Histórico");
	private ArrayList<Aluno> alunos = new ArrayList<Aluno>();
	private Color corFundo = new Color(187, 204, 208);
	
	//LABELS
	private JLabel escritoDificuldade = new JLabel("Dificuldade:");
	private JLabel escritoTituloCentral = new JLabel("Relatório dos Jogadores");
	private Font fonteTitulos = new Font("Arial", Font.BOLD, 14);
	
	//JTable
	private String [] colunas = {"nº", "Nome", "Ano escolar", "Escola", "Pontuação", "Data"};	// Nomes das colunas - 6 Colunas no total
	private Object [][] dados;
	private JTable tabela;
	private JScrollPane barraRolagem;
	private JPanel painelFundo;
	
	private JFrame JanelaPrincipal;		//Janela auxiliar que irá me permitir voltar ao menu principal sem sair do jogo
	private JFrame janelaRelatorioJogadores = new JFrame();
	
	private String nomeComputadorCentral;
	
	//	Só haverá o relatório geral(Basta selecionar a dificuldade) acessivel no programa mas os outros só como arquivos de texto
	//  os relatórios serão atualizados assim que aparecer a janela de relatório pro aluno, ou seja atualiza
	
	public Historico(String nomeComputadorCentral){
		this.nomeComputadorCentral = nomeComputadorCentral;
	}
	
	public void iniciarJanela(JFrame JanelaPrincipal){
		this.JanelaPrincipal = JanelaPrincipal;
		setJanela();
		setComboDificuldades();
		verificaExistenciaPastas();
		atribDadosJTable();
		ajustaTabela(dados);
		janelaRelatorioJogadores.setVisible(true);	//TORNA A JANELA VISÍVEL SOMENTE APÓS ADICIONAR TODOS OS ELEMENTOS NA TELA
	}
	
	public void setJanela(){
		janelaRelatorioJogadores.setSize(794, 471);
		janelaRelatorioJogadores.setTitle("Relatório dos Jogadores");
		janelaRelatorioJogadores.setLayout(null);
		janelaRelatorioJogadores.addWindowListener(Window);
		janelaRelatorioJogadores.setResizable(false);
		janelaRelatorioJogadores.setLocationRelativeTo(null);
		janelaRelatorioJogadores.getContentPane().setBackground(corFundo);
		setEscritos();
	}
	
	public void setEscritos(){
		escritoDificuldade.setBounds(35, 78, 100,30);
		escritoTituloCentral.setBounds(178, 22, 500, 50);
		escritoDificuldade.setFont(fonteTitulos);
		escritoTituloCentral.setFont(new Font("Arial", Font.BOLD, 40));
		janelaRelatorioJogadores.add(escritoDificuldade);
		janelaRelatorioJogadores.add(escritoTituloCentral);
	}
	
	public void setComboDificuldades(){
		comboDificuldades.addItem("9º Ano");
		comboDificuldades.addItem("1º Ano");
		comboDificuldades.addItem("2º Ano");
		comboDificuldades.addItem("3º Ano");
		comboDificuldades.setBounds(32, 108, 120, 25);
		comboDificuldades.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		comboDificuldades.setSelectedItem(null);	//Não é selecionado nenhum elemento da combobox incialmente, por isso é null
		comboDificuldades.addActionListener(this);
		janelaRelatorioJogadores.add(comboDificuldades);
	}
	
	WindowListener Window = new WindowAdapter() 
	{  
	    public void windowClosing(WindowEvent e){
	    	janelaRelatorioJogadores.dispose();
	    	JanelaPrincipal.setVisible(true);
	    }  
	};
	
	/**
	 *  lerArquivos será responsável por ler os relatórios turma/escola/diário/Geral
	 */
	
	public void lerArquivos(Path caminhoDesejado){
		try{
			alunos.clear();	//Limpa o Arraylist de alunos antes, de modo a evitar duplicatas de nomes
			Path caminhoAuxiliar = caminhoDesejado;
			if(caminhoAuxiliar.toFile().exists()==true){	//O Arquivo só pode ser lido se o caminho existir, caso contrário acarreta em um erro que é tratado pelo try e catch
				Charset utf8charset = Charset.forName("UTF-8");	//Tipo de codificação do Arquivo
				FileInputStream caminhoDoArquivo = new FileInputStream(caminhoAuxiliar.toFile().getPath());	//Lê o arquivo de texto, é obrigatório passar um caminho/path no construtor, faz a leitura de dados binários não importando a fonte
				InputStreamReader tradutorEncode = new InputStreamReader(caminhoDoArquivo, utf8charset); 	//Traduz os bytes com o encoding dado para o respectivo código, em outras palavras é um decodificador para uma codificação específica nesse caso "UTF-8" mas poderia ser "ISO-8859-1"
																											//Lê bytes de um lado, converte em caracteres do outro, através do uso de uma codificação de caracteres (encoding)
				BufferedReader bufferLeitura = new BufferedReader(tradutorEncode);	//concatena os diversos chars para formar uma String através do método readLine
				String linha = bufferLeitura.readLine();		//Passa o conteúdo da primeira linha para uma variável String
				String nomeAux = "", anoAux = "", diaAux = "", mesAux = "", anoJogadoAux = "";	//Variáveis auxiliares para capturar os dados dos alunos em cada linha
				int pontoAux = 0;
				System.out.println(linha);
				Aluno a;	// Aluno auxiliar que irá receber os dados e esse aluno será armazenado no Arraylist de alunos
				while (linha != null) {
					if(linha != null){
						nomeAux = linha.substring(linha.indexOf("Nome: ")+6, linha.indexOf(" \tAno"));
						anoAux = linha.substring(linha.indexOf("Ano: ")+5, linha.indexOf(" \tPontuação Total"));
						System.out.println(nomeAux+" "+anoAux);
						pontoAux = Integer.parseInt(linha.substring(linha.indexOf("Pontuação Total: ")+17, linha.indexOf(" \tEscola")));
						String Escola = linha.substring(linha.indexOf("Escola: ")+8, linha.indexOf(" \tData"));
						// DATA
						String data = linha.substring(linha.indexOf("Data: ") + 6, linha.length());
						diaAux = data.substring(0, 2);
						mesAux = data.substring(3, 5);	//CAPTURANDO O DIA MES E ANO
						anoJogadoAux = data.substring(6, data.length());
						a = new Aluno(nomeAux, anoAux, nomeComputadorCentral, true);
						a.setPonto(pontoAux);
						a.setDia(diaAux);
						a.setMes(mesAux);
						a.setAnoJogado(anoJogadoAux);
						a.setEscola(Escola);
						alunos.add(a);
					}
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

	public ArrayList organizandoAlunos(ArrayList<Aluno> alunosAOrganizar){
		/*for(int i=0;i<alunosAOrganizar.size();i++){	//EXIBE NO CONSOLE A LISTA DOS ALUNOS
			System.out.println((i+1)+") Nome: "+alunosAOrganizar.get(i).getNome()+ " Ano: "+alunosAOrganizar.get(i).getAno()+ " Escola: " + alunosAOrganizar.get(i).getNomeEscola()+" Pontuação: "+alunosAOrganizar.get(i).getPonto()+ " Data: " + alunosAOrganizar.get(i).getDia() +"/"+alunosAOrganizar.get(i).getMes()+"/"+ alunosAOrganizar.get(i).getAnoJogado());
		}*/
		Aluno aux = new Aluno("Nome", "Ano", nomeComputadorCentral, true);
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
		for(int j = alunosAOrganizar.size()-1;j>=0;j--){	//ORGANIZANDO EM ORDEM DECRESCENTE
			alunosOrganizados.add(alunosAOrganizar.get(j));
		}
		alunosOrganizados = retirarNomesRepetidos(alunosOrganizados);	// receberá o arraylist de alunos Organizados por pontuação e sem repetição de nomes
		return alunosOrganizados;
	}
	
	public ArrayList retirarNomesRepetidos(ArrayList<Aluno> alunosAOrganizar){
		ArrayList<Aluno> alunosOrganizados = new ArrayList<Aluno>();
		for(int i = 0; i<alunosAOrganizar.size(); i++){
			boolean alunoNomeIgual = false;
			for(int j = 0;j<alunosOrganizados.size();j++){	//analisa até o arrayList de alunosOrganizados acabar
				if(alunosOrganizados.get(j).getNome().equals(alunosAOrganizar.get(i).getNome())){
					alunoNomeIgual = true;	//Se o aluno do arraylist alunosOrganizados tiver o mesmo nome do aluno analisado de alunos
				}
			}
			if(alunoNomeIgual == false){	//Só será acrescido o aluno com nome único e maior pontuação ao arraylist de alunosOrganizados, ou seja, captura a primeira ocorrência do aluno em Alunos
				alunosOrganizados.add(alunosAOrganizar.get(i));
			}
		}
		/*System.out.println(alunosOrganizados.size()+ " Alunos Organizados: ");
		for(int k = 0; k < alunosOrganizados.size();k++){
			System.out.println(alunosOrganizados.get(k).getNome() + " Pontos: " + alunosOrganizados.get(k).getPonto());
		}*/
		
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
		barraRolagem.setWheelScrollingEnabled(true);							// Ativa a rolagem pelo scroll do mouse
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
		painelFundo.setBounds(32, 148, 731, 181);
		tabela.getTableHeader().setReorderingAllowed(false);	//Proibe a reordenação das colunas com o mouse
		janelaRelatorioJogadores.add(painelFundo);
	}
	
	public void atribDadosJTable(){
		dados = new Object[alunos.size()][6];
		for(int i=0; i<alunos.size();i++){
			String[] linha = {Integer.toString(i+1), alunos.get(i).getNome(), alunos.get(i).getAno(), alunos.get(i).getNomeEscola(), Integer.toString(alunos.get(i).getPonto()), alunos.get(i).getDia()+"/"+alunos.get(i).getMes()+"/"+alunos.get(i).getAnoJogado()};
			for(int j = 0; j<6; j ++){
				dados[i][j] = linha[j];
			}
		}
	}
	
	public void setRelatorioEscola(Aluno alunoAtualizarRelatorio){		//É usado a partir da janela do relatório do jogador
		try{	//Try e Catch são comandos usados na tentativa de tratar excessões e erros
			if(caminho.toFile().exists()==true){	//Verificação de existência da pasta histórico
				alunos.clear();
				this.dia = alunoAtualizarRelatorio.getDia();
				this.mes = alunoAtualizarRelatorio.getMes();
				this.ano = alunoAtualizarRelatorio.getAnoJogado();
				this.dificuldade = alunoAtualizarRelatorio.getDificuldade();
				this.escola = alunoAtualizarRelatorio.getNomeEscola();
				Path caminho5 = Paths.get("Histórico\\"+dificuldade+"\\"+ano+"\\"+mes+"\\"+dia+"\\"+escola);
				String[] diretoriosRodadas = caminho5.toFile().list();	// Captura o número de SubPastas(Rodadas) presente na pasta da Escola
				for(int i = 0; i < diretoriosRodadas.length;i++){	//Percorre as pastas das rodadas
					Path caminho6 = Paths.get(caminho5.toString()+"\\"+diretoriosRodadas[i]);
					if(caminho6.toFile().isDirectory()==true){	// VERIFICA SE O PATH PASSADO É UM DIRETÓRIO/PASTA
						String[] arquivosRelatorio = caminho6.toFile().list();	//arquivos de texto das pastas de Rodadas
						for(int j = 0; j < arquivosRelatorio.length;j++){	//Irá analisar todos os arquvos de texto
							Path caminho3 = Paths.get(caminho6.toString()+"\\"+arquivosRelatorio[j]);
							FileInputStream caminhoDoArquivo = new FileInputStream(caminho3.toFile().getPath());	//Lê o arquivo de texto, é obrigatório passar um caminho/path no construtor, faz a leitura de dados binários não importando a fonte
							InputStreamReader tradutorEncode = new InputStreamReader(caminhoDoArquivo, "UTF-8"); 	//traduz os bytes com o encoding dado para o respectivo código, em outras palavras é um decodificador para o o encode específico nesse caso "UTF-8" mas poderia ser "ISO-8859-1"
																										//lê bytes de um lado, converte em caracteres do outro, através do uso de uma codificação de caracteres (encoding)
							BufferedReader bufferLeitura = new BufferedReader(tradutorEncode);	//concatena os diversos chars para formar uma String através do método readLine
						
							// loop que lê e imprime todas as linhas do arquivo
							String linha = bufferLeitura.readLine();
							int indice = 1;	//	INDICE USADO PARA TER A IDEIA O NÚMERO A LINHA PARA A LEITURA
							String nomeAluno = "", anoAluno = "", diaAluno = "", mesAluno = "", anoJogadoAluno = "";
							int pontoAluno = 0;
							Aluno a;	//	ALUNO AUXILIAR QUE IRÁ RECEBER OS DADOS E ESSE ALUNO SERÁ ARMAZENADO NO ARRAYLIST DE ALUNOS
							while (linha != null) {
								if((linha!=null)){	//Captura a ultima linha do arquivo, que nesse caso, é onde está presente o nome da escola
									if(indice==2){	//SE O INDICE FOR CORRESPONDENTE A LINHA 2
										System.out.println("LEITURA DA LINHA 2 PRA TESTE:  "+ linha);
										nomeAluno = linha.substring(linha.indexOf("Nome: ")+6, linha.indexOf("\t\t\tAno"));
										anoAluno = linha.substring(linha.indexOf("Ano: ")+5, linha.indexOf("\t\tPontuação Total: "));
										pontoAluno = Integer.parseInt(linha.substring(linha.indexOf("Pontuação Total: ")+17, linha.length()));
									}
									if(indice==3){
										// DATA
										String data = linha.substring(linha.indexOf("Data: ") + 6, linha.indexOf("\t\tEscola:"));
										diaAluno = data.substring(0, 2);
										mesAluno = data.substring(3, 5);	//CAPTURANDO O DIA MES E ANO
										anoJogadoAluno = data.substring(6, 10);
										// ESCOLA
										String Escola = linha.substring(linha.indexOf("Escola: ")+8, linha.length());
									
										a = new Aluno(nomeAluno, anoAluno, nomeComputadorCentral, true);
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
				alunos = organizandoAlunos(alunos);	//ORGANIZA EM ORDEM DE MAIOR PONTUAÇÃO
				Path caminhoRelatorioEscola = Paths.get("Histórico\\"+dificuldade+"\\"+ano+"\\"+mes+"\\"+dia+"\\"+escola+"\\Relatório da Escola.txt");
				criarRelatorio(caminhoRelatorioEscola, alunos);
				atualizarRelatorios();
			}
			else if(caminho.toFile().exists()==false){
				System.out.println("Não existe a pasta histórico.");
			}
		}catch(Exception erro){		//Tratamento de erros
			erro.printStackTrace();
			System.out.println("Erro na leitura de arquivos");
		}
	}
	
	public void verificaCaminho(Path diretorio){	// Verifica a existência do diretorio passado no parâmetro
		try{
			Path caminho3 = diretorio;
			if(caminho3.toFile().exists()==false){	// A Diretório NÃO existe
				caminho3.toFile().setWritable(true);
				caminho3.toFile().setReadable(true);
				caminho3.toFile().mkdir();
			}
			else if(caminho3.toFile().exists()==true){	// A Diretório SIM existe
				//SE O CAMINHO EXISTE NÃO OCORRERÁ NADA
			}
		}
		catch(Exception erro){
			erro.printStackTrace();
		}
	}
	
	public void verificaExistenciaPastas(){ //Verifica a existencia das pastas, se não existe irá criá-las
		Path caminho3 = Paths.get("Histórico");
		verificaCaminho(caminho3);
		caminho3 = Paths.get("Histórico\\9º Ano");
		verificaCaminho(caminho3);
		caminho3 = Paths.get("Histórico\\1º Ano");
		verificaCaminho(caminho3);
		caminho3 = Paths.get("Histórico\\2º Ano");
		verificaCaminho(caminho3);
		caminho3 = Paths.get("Histórico\\3º Ano");
		verificaCaminho(caminho3);
	}
	
	public void criarRelatorio(Path caminhoArquivo, ArrayList<Aluno> a){
		try{
			String quebraLinha = System.lineSeparator();
			caminhoArquivo.toFile().setWritable(true);
			caminhoArquivo.toFile().setReadable(true);
			OutputStreamWriter bufferOut = new OutputStreamWriter(new FileOutputStream(caminhoArquivo.toString()),"UTF-8");
			bufferOut.write("");
			if(a!=null){	//Se o relatório não for vazio, ou seja arraylist alunos contém elementos
				for(int i=0;i<a.size();i++){
					Aluno aluno = a.get(i);	//Captura o aluno na posição determinada do Arraylist de alunos	
					bufferOut.write((i+1)+") "+"Nome: "+aluno.getNome()+" \tAno: "+aluno.getAno()+" \tPontuação Total: "+aluno.getPonto()+" \tEscola: "+aluno.getNomeEscola()+" \tData: "+aluno.getDia()+"/"+aluno.getMes()+"/"+aluno.getAnoJogado()+quebraLinha);
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
	
	public void atualizarRelatorios(){	// Atualizar os outros relatórios com base no novo relatório de escola
		Path caminhoRelatorioEscola = Paths.get("Histórico\\"+dificuldade+"\\"+ano+"\\"+mes+"\\"+dia+"\\"+escola+"\\Relatório da Escola.txt");
		Path caminhoRelatorioDiario = Paths.get("Histórico\\"+dificuldade+"\\"+ano+"\\"+mes+"\\"+dia+"\\Relatório Diário.txt");
		Path caminhoRelatorioGeral = Paths.get("Histórico\\"+dificuldade+"\\Relatório Geral.txt");
		
		/**	ARMAZENAGEM DOS ALUNOS DO RELATÓRIO DA ESCOLA*/
		lerArquivos(caminhoRelatorioEscola);
		ArrayList<Aluno> alunosEscola = new ArrayList<Aluno>();
		for(int i = 0; i < alunos.size();i++){	
			alunosEscola.add(alunos.get(i));	//Adiciona todos os alunos da escola no arraylist da escola
		}
		
		/**	ARMAZENAGEM DOS ALUNOS DO RELATÓRIO DIÁRIO*/
		lerArquivos(caminhoRelatorioDiario);	
		ArrayList<Aluno> alunosDiario = new ArrayList<Aluno>();
		for(int i = 0; i < alunos.size();i++){	
			alunosDiario.add(alunos.get(i));	//Adiciona todos os alunosDiario no arraylist alunosDiario
		}
		
		/**	AJUSTANDO RELATORIO ESCOLA - DIARIO*/
		apagarRelatorio(caminhoRelatorioDiario);	//Elimina o relatório da escola antigo
		for(int i = 0; i < alunosEscola.size();i++){	
			alunosDiario.add(alunosEscola.get(i));	//Adiciona todos os alunos da escola no arraylist da Diario, mesmo com repetições
		}
		alunosDiario = organizandoAlunos(alunosDiario); //alunosDiario recebe o arraylist organizado
		criarRelatorio(caminhoRelatorioDiario, alunosDiario);
		
		
		/**	ARMAZENAGEM DOS ALUNOS DO RELATÓRIO GERAL*/
		lerArquivos(caminhoRelatorioGeral);		
		ArrayList<Aluno> alunosGeral = new ArrayList<Aluno>();
		for(int i = 0; i < alunos.size();i++){	
			alunosGeral.add(alunos.get(i));		//Adiciona todos os alunos da geral no arraylist da geral
		}
		
		/**	AJUSTANDO RELATORIO DIÁRIO - GERAL*/
		apagarRelatorio(caminhoRelatorioGeral);	//Elimina o relatório geral antigo
		for(int i = 0; i < alunosDiario.size();i++){
			alunosGeral.add(alunosDiario.get(i));
		}
		alunosGeral = organizandoAlunos(alunosGeral); //alunosGeral recebe o arraylist organizado
		criarRelatorio(caminhoRelatorioGeral, alunosGeral);	//Cria o relatório Geral com os dados atualizados
	}
	
	public int getNumRodadas(){	// Retorna o número de pastas de rodadas
		Path caminhoRelatorio = Paths.get("Histórico\\"+dificuldade+"\\"+ano+"\\"+mes+"\\"+dia+"\\"+escola);
		String[] aux = caminhoRelatorio.toFile().list();
		ArrayList<String> rodadas = new ArrayList<String>();
		for(int i = 0; i< aux.length; i++){
			if((aux[i].contains(".")== false)&&(aux[i].contains("Rodada")==true)){	//Captura o numero de pastas de rodadas
				rodadas.add(aux[i]);
			}
		}
		return rodadas.size();
	}
	
	public int getNumElemUltRod(){	//	Captura o Número de elementos presente na ultima pasta da ultima rodada
		try{
			Path caminhoRelatorio = Paths.get("Histórico\\"+dificuldade+"\\"+ano+"\\"+mes+"\\"+dia+"\\"+escola+"\\"+getNumRodadas()+"ª Rodada");
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
	
	public int getNumElemTurma(String turmaSelecionada){ // Retorna o número de alunos presente no Relatório de Turma
		try{
			Path caminhoRelatorio = Paths.get("Histórico\\"+dificuldade+"\\"+ano+"\\"+mes+"\\"+dia+"\\"+escola+"\\"+turmaSelecionada+"\\Relatório de Turma.txt");
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
}