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
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

public class RelatorioJogadoresAuxiliar{
	//Variáveis responsáveis por armazenar o nome do item que é selecionado nas comboboxes correspondentes
	private String dia = null;
	private String mes = null; 
	private String ano = null;
	private String escola = null;
	private String dificuldade = null;
	private String turma = null;
	private Path caminho = Paths.get("Histórico");
	
	//Elementos da janela
	private JLabel escritoDificuldade = new JLabel("Dificuldade:");
	private JLabel escritoAno = new JLabel("Ano:");
	private JLabel escritoMes = new JLabel("Mes:");
	private JLabel escritoDia = new JLabel("Dia:");
	private JLabel escritoEscola = new JLabel("Escola:");
	private JLabel escritoTurma = new JLabel("Turma:");
	private JLabel escritoTituloCentral = new JLabel("Relatório dos Jogadores");
	private Font fonteTitulos = new Font("Arial", Font.BOLD, 14);
	private JButton consultar = new JButton("Consultar");
	private JComboBox<String> comboDificuldades = new JComboBox<String>();
	private JComboBox<String> comboAno = new JComboBox<String>();
	private JComboBox<String> comboMes = new JComboBox<String>();
	private JComboBox<String> comboDia = new JComboBox<String>();
	private JComboBox<String> comboEscola = new JComboBox<String>();
	private JComboBox<String> comboTurma = new JComboBox<String>();
	private Color corFundo = new Color(187, 204, 208);
	private Color corBotoes = new Color(204, 255, 255);
	
	//Variáveis controladoras da tabela
	private String [] colunas = {"nº", "Nome", "Ano escolar", "Escola", "Pontuação", "Data"};	// Nomes das colunas - 6 Colunas no total
	private Object [][] dados;
	private JTable tabela;
	private JScrollPane barraRolagem;
	private JPanel painelFundo;
	private ArrayList<Aluno> alunos = new ArrayList<Aluno>();	//Arraylist responsável por armazenar os dados dos alunos contidos nos relatórios
	
	//Variáveis responsáveis pela ligação entre as janelas
	private JFrame JanelaPrincipal;								//Janela auxiliar que irá me permitir voltar ao menu principal sem sair do jogo
	private JFrame janelaRelatorioJogadores = new JFrame();
	
	/**
	 * Ações dos elementos que estão na janela
	 */
	
	private ActionListener acaoComboDificuldades = new ActionListener(){
		public void actionPerformed(ActionEvent elemento) {
			if(elemento.getSource()==comboDificuldades){
				//Limpa as comboboxes e as oculta
				comboAno.setSelectedItem(null);
				comboMes.setSelectedItem(null);
				comboDia.setSelectedItem(null);
				comboEscola.setSelectedItem(null);
				comboTurma.setSelectedItem(null);
				comboMes.setEnabled(false);
				comboDia.setEnabled(false);
				comboEscola.setEnabled(false);
				comboTurma.setEnabled(false);
				comboAno.removeAllItems();
				comboMes.removeAllItems();
				comboDia.removeAllItems();
				comboEscola.removeAllItems();
				comboTurma.removeAllItems();
				dificuldade = comboDificuldades.getSelectedItem() + "";
				comboAno.setEnabled(true);
				atributosComboAno();
			}
		}
	};
	
	private ActionListener acaoComboAno = new ActionListener(){
		public void actionPerformed(ActionEvent elemento) {
			if(elemento.getSource()==comboAno){
				ano = comboAno.getSelectedItem() + "";
				comboMes.setSelectedItem(null);
				comboDia.setSelectedItem(null);
				comboEscola.setSelectedItem(null);
				comboTurma.setSelectedItem(null);
				comboMes.removeAllItems();
				comboDia.removeAllItems();
				comboEscola.removeAllItems();
				comboTurma.removeAllItems();
				comboDia.setEnabled(false);
				comboEscola.setEnabled(false);
				comboTurma.setEnabled(false);
				if(comboAno.getSelectedItem()!=null){
					atributosComboMes();
					comboMes.setEnabled(true);
				}
			}
		}
	};
	
	private ActionListener acaoComboMes = new ActionListener(){
		public void actionPerformed(ActionEvent elemento) {
			if(elemento.getSource()==comboMes){
				mes = comboMes.getSelectedItem()+"";
				comboDia.setSelectedItem(null);
				comboEscola.setSelectedItem(null);
				comboTurma.setSelectedItem(null);
				comboDia.removeAllItems();
				comboEscola.removeAllItems();
				comboTurma.removeAllItems();
				comboEscola.setEnabled(false);
				comboTurma.setEnabled(false);
				if(comboMes.getSelectedItem()!=null){
					atributosComboDia();
					comboDia.setEnabled(true);
				}
			}
		}
	};
	
	private ActionListener acaoComboDia = new ActionListener(){
		public void actionPerformed(ActionEvent elemento) {
			if(elemento.getSource()==comboDia){
				dia = comboDia.getSelectedItem()+"";
				comboEscola.setSelectedItem(null);
				comboTurma.setSelectedItem(null);
				comboEscola.removeAllItems();
				comboTurma.removeAllItems();
				comboTurma.setEnabled(false);
				if(comboDia.getSelectedItem()!=null){
					atributosComboEscola();
					comboEscola.setEnabled(true);
				}
			}
		}
	};
	
	private ActionListener acaoComboEscola = new ActionListener(){
		public void actionPerformed(ActionEvent elemento) {
			if(elemento.getSource()==comboEscola){
				escola = comboEscola.getSelectedItem()+"";
				comboTurma.setSelectedItem(null);
				comboTurma.removeAllItems();
				if(comboEscola.getSelectedItem()!=null){
					atributosComboTurma();
					comboTurma.setEnabled(true);
				}
			}
		}
	};
	
	private ActionListener acaoComboTurma = new ActionListener(){
		public void actionPerformed(ActionEvent elemento) {
			if(elemento.getSource()==comboTurma){
				turma = comboTurma.getSelectedItem()+"";
			}
		}
	};
	
	private ActionListener acaoBotao = new ActionListener(){
		public void actionPerformed(ActionEvent elemento) {
			if(elemento.getSource()==consultar){
				/*
				Usado para exibir no console e ter um controle do que está armazenado nas variáveis (voltado para o programador)
				
				System.out.println("Diagrama de Variaveis: ");
				System.out.println("Dificuldade: "+ dificuldade);
				System.out.println("Ano: "+ ano);
				System.out.println("Mes: "+ mes);
				System.out.println("Dia: "+ dia);
				System.out.println("Escola: "+ escola);
				System.out.println("Turma: "+ turma);
				System.out.println("Indice Dificuldade: "+ comboDificuldades.getSelectedIndex());
				*/
				Path caminhoRelatorio;
				if(comboDificuldades.getSelectedIndex()!=-1){	//Se for selecionado algum elemento na combobox em
					//ENTROU NO RELATORIO GERAL
					caminhoRelatorio = Paths.get("Histórico\\"+dificuldade+"\\Relatório Geral.txt");
					if((comboAno.getSelectedIndex()!=-1)&&(comboMes.getSelectedIndex()!=-1)&&(comboDia.getSelectedIndex()!=-1)){
						if((comboEscola.getSelectedIndex()==-1)&&(comboTurma.getSelectedIndex()==-1)){
							//ENTROU NO RELATORIO DIARIO
							caminhoRelatorio = Paths.get("Histórico\\"+dificuldade+"\\"+ano+"\\"+mes+"\\"+dia+"\\Relatório Diário.txt");
						}
						if(comboEscola.getSelectedIndex()!=-1){
							if(comboTurma.getSelectedIndex()==-1){
								//ENTROU NO RELATORIO DA ESCOLA
								caminhoRelatorio = Paths.get("Histórico\\"+dificuldade+"\\"+ano+"\\"+mes+"\\"+dia+"\\"+escola+"\\Relatório da Escola.txt");
							}
							else if(comboTurma.getSelectedIndex()!=-1){
								//ENTROU NO RELATORIO DA TURMA
								caminhoRelatorio = Paths.get("Histórico\\"+dificuldade+"\\"+ano+"\\"+mes+"\\"+dia+"\\"+escola+"\\"+turma+"\\Relatório de Turma.txt");
							}
						}
					}
					lerArquivos(caminhoRelatorio);
					atribDadosJTable();
					painelFundo.setVisible(false);
					ajustaTabela(dados);
				}else{
					JOptionPane.showMessageDialog(null, "<HTML>Há 4 relatórios disponíveis, para acessá-los selecione como descrito abaixo:<br>->Relatório Geral:"
					+ " Selecione uma dificuldade e clique em consultar<br>->Relatório Diário: Selecione Selecione até o campo dia e clique em consultar<br>->Relatório"
					+ " da Escola: Selecione até o campo escola e clique em consultar<br>->Relatório de Turma: Selecione até o campo Turma e clique em consultar<br><br>"
					+ "Siga as instruções acima pois qualquer outra forma estará incorreta<br>e não acessará nenhum relatório.</HTML>");
				}
			}
		}
	};
	
	public RelatorioJogadoresAuxiliar(JFrame JanelaPrincipal){
		this.JanelaPrincipal = JanelaPrincipal;
		JanelaPrincipal.dispose();
		iniciarJanela();
	}
	
	public void iniciarJanela(){
		Janela();
		botaoConfirmar();
		comboBoxes();
		Escritos();
		verificaExistenciaPastas();
		atribDadosJTable();
		ajustaTabela(dados);
		janelaRelatorioJogadores.setVisible(true);	//Torna a janela visível somente após adicionar todos os elementos na janela
	}
	
	public void Janela(){
		janelaRelatorioJogadores.setSize(794, 471);
		janelaRelatorioJogadores.setTitle("Relatório dos Jogadores");
		janelaRelatorioJogadores.setLayout(null);
		janelaRelatorioJogadores.addWindowListener(Window);
		janelaRelatorioJogadores.setResizable(false);
		janelaRelatorioJogadores.setLocationRelativeTo(null);
		janelaRelatorioJogadores.getContentPane().setBackground(corFundo);
	}
	
	public void botaoConfirmar(){
		consultar.setBounds(312, 344, 105, 25);
		consultar.addActionListener(acaoBotao);
		consultar.setFont(new Font("Georgia", Font.BOLD,12));
		consultar.setBackground(corBotoes);
		janelaRelatorioJogadores.add(consultar);
	}
	
	public void comboBoxes(){
		setComboDificuldades();
		setComboAno();
		setComboMes();
		setComboDia();
		setComboEscola();
		setComboTurma();
	}
	
	public void Escritos(){
		escritoDificuldade.setBounds(35, 78, 90, 30);
		escritoAno.setBounds(165, 78, 50, 30);
		escritoMes.setBounds(275, 78, 50, 30);
		escritoDia.setBounds(385, 78, 50, 30);
		escritoEscola.setBounds(495, 78, 70, 30);
		escritoTurma.setBounds(675, 78, 70, 30);
		escritoTituloCentral.setBounds(178, 22, 500, 50);
		escritoDificuldade.setFont(fonteTitulos);
		escritoAno.setFont(fonteTitulos);
		escritoMes.setFont(fonteTitulos);
		escritoDia.setFont(fonteTitulos);
		escritoEscola.setFont(fonteTitulos);
		escritoTurma.setFont(fonteTitulos);
		escritoTituloCentral.setFont(new Font("Arial", Font.BOLD, 40));
		janelaRelatorioJogadores.add(escritoDificuldade);
		janelaRelatorioJogadores.add(escritoAno);
		janelaRelatorioJogadores.add(escritoMes);
		janelaRelatorioJogadores.add(escritoDia);
		janelaRelatorioJogadores.add(escritoEscola);
		janelaRelatorioJogadores.add(escritoTurma);
		janelaRelatorioJogadores.add(escritoTituloCentral);
	}
	
	public void setComboDificuldades(){
		comboDificuldades.addItem("9º Ano");
		comboDificuldades.addItem("1º Ano");
		comboDificuldades.addItem("2º Ano");
		comboDificuldades.addItem("3º Ano");
		comboDificuldades.setBounds(32, 108, 100, 25);
		comboDificuldades.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		comboDificuldades.setSelectedItem(null);		//Não é selecionado nenhum elemento da combobox incialmente, por isso é null
		comboDificuldades.addActionListener(acaoComboDificuldades);
		janelaRelatorioJogadores.add(comboDificuldades);
	}
	
	public void setComboAno(){
		comboAno.setEnabled(false);
		comboAno.setBounds(162, 108, 80, 25);
		comboAno.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		comboAno.setSelectedItem(null);
		comboAno.setMaximumRowCount(4);	// Representa que o limite de campos que aparece na combobox será 4, além disso é usado uma barra de scroll
		comboAno.addActionListener(acaoComboAno);
		janelaRelatorioJogadores.add(comboAno);
	}
	
	public void setComboMes(){
		comboMes.setEnabled(false);
		comboMes.setBounds(272, 108, 80, 25);
		comboMes.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		comboMes.setSelectedItem(null);
		comboMes.setMaximumRowCount(4);	// Representa que o limite de campos que aparece na combobox será 4, além disso é usado uma barra de scroll
		comboMes.addActionListener(acaoComboMes);
		janelaRelatorioJogadores.add(comboMes);
	}
	
	public void setComboDia(){
		comboDia.setEnabled(false);
		comboDia.setBounds(382, 108, 80, 25);
		comboDia.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		comboDia.setSelectedItem(null);
		comboDia.setMaximumRowCount(4);	// Representa que o limite de campos que aparece na combobox será 4, além disso é usado uma barra de scroll
		comboDia.addActionListener(acaoComboDia);
		janelaRelatorioJogadores.add(comboDia);
	}
	
	public void setComboEscola(){
		comboEscola.setEnabled(false);
		comboEscola.setBounds(492, 108, 150, 25);
		comboEscola.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		comboEscola.setSelectedItem(null);
		comboEscola.setMaximumRowCount(4);	// Representa que o limite de campos que aparece na combobox será 4, além disso é usado uma barra de scroll
		comboEscola.addActionListener(acaoComboEscola);
		janelaRelatorioJogadores.add(comboEscola);
	}
	
	public void setComboTurma(){
		comboTurma.setEnabled(false);
		comboTurma.setBounds(672, 108, 90, 25);
		comboTurma.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		comboTurma.setSelectedItem(null);
		comboTurma.setMaximumRowCount(4);	// Representa que o limite de campos que aparece na combobox será 4, além disso é usado uma barra de scroll
		comboTurma.addActionListener(acaoComboTurma);
		janelaRelatorioJogadores.add(comboTurma);
	}
	
	public boolean itemRepetidoComboBox(JComboBox comboBox, Object elemento){
		for(int i = 0; i < comboBox.getItemCount(); i++){
			if(elemento.equals(comboBox.getItemAt(i))==true)
				return true;
		}
		return false;
	}
	
	public void atributosComboAno(){
		caminho = Paths.get("Histórico\\"+comboDificuldades.getSelectedItem());
		String[] anos = caminho.toFile().list();	//Captura o nome das pastas dos anos que o jogo foi jogado
		for(int i = 0; i < anos.length; i++){
			if((anos[i].contains(".")==false)&&(itemRepetidoComboBox(comboAno, anos[i])==false)){	//Adiciona na combobox se o elemento não tiver ponto no nome e verifica se o elemento já não foi inserido na combobox
				comboAno.addItem(anos[i]);
			}
		}
		comboAno.setSelectedItem(null);
	}

	public void atributosComboMes(){
		caminho = Paths.get("Histórico\\"+comboDificuldades.getSelectedItem()+"\\"+comboAno.getSelectedItem());
		String[] meses = caminho.toFile().list();	//Captura o nome das pastas dos meses que o jogo foi jogado
		for(int i = 0; i < meses.length; i++){
			if((meses[i].contains(".")==false)&&(itemRepetidoComboBox(comboMes, meses[i])==false)){	//Adiciona na combobox se o elemento não tiver ponto no nome e verifica se o elemento já não foi inserido na combobox
				comboMes.addItem(meses[i]);
			}
		}
		comboMes.setSelectedItem(null);
	}
	
	public void atributosComboDia(){
		caminho = Paths.get("Histórico\\"+comboDificuldades.getSelectedItem()+"\\"+comboAno.getSelectedItem()+"\\"+comboMes.getSelectedItem());
		String[] dias = caminho.toFile().list();	//Captura o nome das pastas dos dias que o jogo foi jogado
		for(int i = 0; i < dias.length; i++){
			if((dias[i].contains(".")==false)&&(itemRepetidoComboBox(comboDia, dias[i])==false)){
				comboDia.addItem(dias[i]);
			}
		}
		comboDia.setSelectedItem(null);
	}
	
	public void atributosComboEscola(){
		try{
			caminho = Paths.get("Histórico\\"+comboDificuldades.getSelectedItem()+"\\"+comboAno.getSelectedItem()+"\\"+comboMes.getSelectedItem()+"\\"+comboDia.getSelectedItem());
			String[] escolas = caminho.toFile().list();	//Captura o nome das pastas das escolas que jogaram o jogo
			ArrayList<String> ordemAlfabetica = new ArrayList<String>();	//Armazenará e colocará os elementos da combobox em ordem alfabética através desse arraylist
			for(int i = 0; i < escolas.length; i++){
				if((escolas[i].contains(".")==false)&&(ordemAlfabetica.contains(escolas[i])==false)){	//Adiciona na arraylist se o elemento não tiver ponto no nome e verifica se o elemento já não foi inserido no arraylist
					ordemAlfabetica.add(escolas[i]);
				}
			}
			Collections.sort(ordemAlfabetica, new Comparator<String>() {	//Organizando os elementos da arraylist em ordem alfabética
				@Override
				public int compare(String s1, String s2) {
					return s1.compareToIgnoreCase(s2);
				}
			});
			for(int i=0; i<ordemAlfabetica.size();i++){		//Adicionando os elementos ordenados na combobox
				comboEscola.addItem(ordemAlfabetica.get(i));
			}
			comboEscola.setSelectedItem(null);
		}
		catch(Exception erro){
			erro.printStackTrace();
		}
	}

	public void atributosComboTurma(){
		caminho = Paths.get("Histórico\\"+comboDificuldades.getSelectedItem()+"\\"+comboAno.getSelectedItem()+"\\"+comboMes.getSelectedItem()+"\\"+comboDia.getSelectedItem()+"\\"+comboEscola.getSelectedItem());
		String[] turmas = caminho.toFile().list();	//Captura o nome das pastas das Turmas que jogaram o jogo
		for(int i = 0; i < turmas.length; i++){
			if((turmas[i].contains("Turma")==true)&&(turmas[i].contains(".")==false)&&(itemRepetidoComboBox(comboTurma, turmas[i])==false)){
				comboTurma.addItem(turmas[i]);
			}
		}
		comboTurma.setSelectedItem(null);
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
			if(caminhoAuxiliar.toFile().exists()==true){	//O Arquivo só pode ser lido se o caminho existir, caso contrário acarreta em um erro que será tratado pelo try e catch
				Charset utf8charset = Charset.forName("UTF-8");		//Tipo de codificação do Arquivo
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
					String Escola = linha.substring(linha.indexOf("Escola: ")+8, linha.indexOf(" \tData"));
					String data = linha.substring(linha.indexOf("Data: ") + 6, linha.length());
					diaAux = data.substring(0, 2);
					mesAux = data.substring(3, 5);
					anoJogadoAux = data.substring(6, data.length());
					a = new Aluno(nomeAux, anoAux);
					a.setPonto(pontoAux);
					a.setDia(diaAux);
					a.setMes(mesAux);
					a.setAnoJogado(anoJogadoAux);
					a.setEscola(Escola);
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
			String[] linha = {Integer.toString(i+1), alunos.get(i).getNome(), alunos.get(i).getAno(), alunos.get(i).getEscola(), Integer.toString(alunos.get(i).getPonto()), alunos.get(i).getDia()+"/"+alunos.get(i).getMes()+"/"+alunos.get(i).getAnoJogado()};
			for(int j = 0; j<6; j ++){
				dados[i][j] = linha[j];
			}
		}
	}
	
	public void verificaCaminho(Path diretorio){	// Verifica a existência do diretorio passado como parâmetro
		try{
			Path caminho3 = diretorio;
			if(caminho3.toFile().exists()==false){	// O Diretório NÃO existe
				caminho3.toFile().setWritable(true);
				caminho3.toFile().setReadable(true);
				caminho3.toFile().mkdir();
			}
			else if(caminho3.toFile().exists()==true){	// O Diretório SIM existe
				//Se o caminho existe não ocorrerá nada
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
			String quebraLinha = System.lineSeparator();	//Realiza quebra de linha, não é usado o "\n" pois certos editores de texto não reconhecem a quebra de linha 
			caminhoArquivo.toFile().setWritable(true);	//Permite ser escrito
			caminhoArquivo.toFile().setReadable(true);	//Permite ser lido
			OutputStreamWriter bufferOut = new OutputStreamWriter(new FileOutputStream(caminhoArquivo.toString()),"UTF-8");
			bufferOut.write("");
			if(a!=null){	//Se o relatório não for vazio
				for(int i=0; i<a.size(); i++){
					Aluno aluno = a.get(i);	//Captura o aluno na posição determinada no arraylist de alunos	
					bufferOut.write((i+1)+") "+"Nome: "+aluno.getNome()+" \tAno: "+aluno.getAno()+" \tPontuação Total: "+aluno.getPonto()+" \tEscola: "+aluno.getEscola()+" \tData: "+aluno.getDia()+"/"+aluno.getMes()+"/"+aluno.getAnoJogado()+quebraLinha);
				}
			}
			bufferOut.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}