package InterfaceGrafica;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class JanelaPrincipal implements ActionListener{
	// Imagens botoes de dificuldade
	private ImageIcon primeiroAnoImagem = new ImageIcon(getClass().getResource("/imagens/BotãoPrimeiroAno.PNG"));
	private ImageIcon segundoAnoImagem = new ImageIcon(getClass().getResource("/imagens/BotãoSegundoAno.png"));
	private ImageIcon terceiroAnoImagem = new ImageIcon(getClass().getResource("/imagens/BotãoTerceiroAno.png"));
	private ImageIcon nonoAnoImagem = new ImageIcon(getClass().getResource("/imagens/BotãoNonoAno.PNG"));
	
	// Criando os Botoes de dificuldade
	private JButton nonoAno = new JButton();
	private JButton primeiroAno = new JButton();
	private JButton segundoAno = new JButton();
	private JButton terceiroAno = new JButton();
	
	// Fundo
	private ImageIcon ImagemFundo = new ImageIcon(getClass().getResource("/imagens/Janela Principal.jpg"));
	private JLabel Fundo = new JLabel();
	
	// Áreas Clicáveis
	private JPanel tabela = new JPanel();
	private JPanel sair = new JPanel();
	private JPanel historico = new JPanel();
	
	// Atributos
	private String dificuldade = "";
	private Aluno aluno;
	private JFrame janelaPrincipal = new JFrame();
	private String nomeComputadorCentral;
	
	public JanelaPrincipal(String nomeComputadorCentral){
		this.nomeComputadorCentral = nomeComputadorCentral;
		setJanela();
		botoesEnsino();
		areaClicavelTabela();
		areaClicavelSair();
		areaClicavelHistorico();
		setFundo();
		janelaPrincipal.setVisible(true);
	}
	
	public void setJanela(){
		janelaPrincipal.setTitle("Aprendendo com a Tabela Periódica");
		janelaPrincipal.setLayout(null);
		janelaPrincipal.setSize(1030, 626);
		janelaPrincipal.setResizable(false);
		janelaPrincipal.setLocationRelativeTo(null);
		janelaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void botoesEnsino(){
		nonoAno.setBounds(720, 184, 175, 68);
		primeiroAno.setBounds(720, 264, 175, 68);
		segundoAno.setBounds(720, 345, 175, 68);
		terceiroAno.setBounds(720, 427, 175, 68);
		nonoAno.setIcon(nonoAnoImagem);
		primeiroAno.setIcon(primeiroAnoImagem);
		segundoAno.setIcon(segundoAnoImagem);
		terceiroAno.setIcon(terceiroAnoImagem);
		nonoAno.addActionListener(this);
		primeiroAno.addActionListener(this);
		segundoAno.addActionListener(this);
		terceiroAno.addActionListener(this);
		janelaPrincipal.add(nonoAno);
		janelaPrincipal.add(primeiroAno);
		janelaPrincipal.add(segundoAno);
		janelaPrincipal.add(terceiroAno);	
	}
	
	public void areaClicavelTabela(){
		tabela.setLayout(null);		//limpando o layout pre-determinado do panel
		tabela.setBounds(456, 477, 202, 108);
		tabela.setOpaque(false);
		tabela.addMouseListener(TabelaMouseListener());
		janelaPrincipal.add(tabela);
	}
	
	public void areaClicavelSair(){
		sair.setLayout(null);		//limpando o layout pre-determinado do panel
		sair.setBounds(929, 561, 72, 27);
		sair.setOpaque(false);
		sair.addMouseListener(SairMouseListener());
		janelaPrincipal.add(sair);
	}
	
	public void areaClicavelHistorico(){
		historico.setLayout(null);		//limpando o layout pre-determinado do panel
		historico.setBounds(724, 554, 170, 31);
		historico.setOpaque(false);
		historico.addMouseListener(HistoricoMouseListener());
		janelaPrincipal.add(historico);
	}
	
	public void setFundo(){
		Fundo.setIcon(ImagemFundo);
		Fundo.setBounds(0, 0, 1024, 600);
		janelaPrincipal.add(Fundo);
	}
	
	public String getNomeComputadorCentral(){
		return nomeComputadorCentral;
	}
	
	private static MouseListener TabelaMouseListener()  //MÉTODO PARA A CAPTURA DO CLIQUE DO MOUSE, PARA ACESSAR A TABELA PERIODICA
    {  
        return new MouseAdapter()  
        {  
            @Override  
            public void mouseClicked( MouseEvent e )  	//ANALISA O EVENTO DO MOUSE, SE ELE FOI CLICADO INSTANCIAR UMA NOVA TABELA PERIODICA
            {  
                TabelaPeriodica tp = new TabelaPeriodica();
            }  
        };  
    }
	
	private static MouseListener SairMouseListener()  //MÉTODO PARA A CAPTURA DO CLIQUE DO MOUSE, PARA SAIR DO PROGRAMA
    {  
        return new MouseAdapter()  
        {  
            @Override  
            public void mouseClicked( MouseEvent e )  	//ANALISA O EVENTO DO MOUSE
            {  
                System.exit(0);
            }  
        };  
    }
	
	private MouseListener HistoricoMouseListener()	//MÉTODO PARA A CAPTURA DO CLIQUE DO MOUSE, PARA ACESSAR O HISTÓRICO DE JOGADORES
	{
		return new MouseAdapter()
		{
			public void mouseClicked( MouseEvent e){
				Historico historico = new Historico(getNomeComputadorCentral());
				janelaPrincipal.setVisible(false);
				historico.iniciarJanela(janelaPrincipal);
			}
		};
	}
	
	public boolean verificarArquivoDificuldade(){
		try{	//Try e Catch são comandos usados na tentativa de tratar excessões e erros
			Path arquivoDificuldade = Paths.get("\\\\"+nomeComputadorCentral+"\\Jogo Interativo Tabela Periódica\\Dificuldade.txt");	//Criado para verificar se o arquivo existe, somente essa ideia
			if(arquivoDificuldade.toFile().exists()==true){
				FileInputStream caminhoDoArquivo = new FileInputStream("\\\\"+nomeComputadorCentral+"\\Jogo Interativo Tabela Periódica\\Dificuldade.txt");	//Lê o arquivo de texto, é obrigatório passar um caminho/path no construtor, faz a leitura de dados binários não importando a fonte
				InputStreamReader tradutorEncode = new InputStreamReader(caminhoDoArquivo,"UTF-8");//caminhoDoArquivo, "UTF-8"); 	//traduz os bytes com o encoding dado para o respectivo código, em outras palavras é um decodificador para o o encode específico nesse caso "UTF-8" mas poderia ser "ISO-8859-1"
																								//	lê bytes de um lado, converte em caracteres do outro, através do uso de uma codificação de caracteres (encoding)
				BufferedReader bufferDificuldade = new BufferedReader(tradutorEncode);	//concatena os diversos chars para formar uma String através do método readLine
				String linha = bufferDificuldade.readLine();
				linha = linha.substring(linha.indexOf("(")+1, linha.indexOf(")"));
				System.out.println(linha);
				bufferDificuldade.close();
				if(dificuldade.equals(linha)){
					return true;
				}
				else{
					return false;
				}
			}
			else if(arquivoDificuldade.toFile().exists()==false){
				System.out.println("Não existe o arquivo de texto com a dificuldade");
				return false;
			}
		}catch(Exception erro){		//Tratamento de erros
			erro.printStackTrace();
			System.out.println("Erro na leitura de arquivos");
		}
		return false;
	}
	
	public void actionPerformed(ActionEvent e){
		String nome = null;
		if(e.getSource()==nonoAno){	
			dificuldade = "Nono Ano";
			if(verificarArquivoDificuldade()==true){	//Se a dificuldade selecionada for igual ao computador central
				nome = JOptionPane.showInputDialog(null,"Digite o seu nome para iniciar o jogo");
				while((nome.equals(""))||(nome.contains("|")==true)||(nome.contains("<")==true)||(nome.contains(",")==true)||(nome.contains(">")==true)||(nome.contains(".")==true)||(nome.contains(":")==true)||(nome.contains(";")==true)||(nome.contains("?")==true)||(nome.contains("/")==true)||(nome.contains("}")==true)||(nome.contains("]")==true)||(nome.contains("{")==true)||(nome.contains("]")==true)||(nome.contains("{")==true)||(nome.contains("[")==true)||(nome.contains("§")==true)||(nome.contains("\"")==true)){	//Se o nome da escola não for digitado ou clicado no botão cancelar
					nome = JOptionPane.showInputDialog(null,"Digite corretamente o seu nome:");
				}
				if(nome != null){
					Aluno aluno = new Aluno(nome, "9º Ano", nomeComputadorCentral, false);
					this.aluno = aluno;
					verificadorDeDestraveProximaPergunta liberar = new verificadorDeDestraveProximaPergunta(this.aluno);
					liberar.start();
				}
			}else{	//Caso o jogador tente selecionar uma dificuldade diferente do computador central, evitar que as perguntas sorteadas do pc central sejam de dificuldades diferentes, ou seja, evitar erros
				JOptionPane.showMessageDialog(null, "Dificuldade escolhida diferente dos demais, por favor selecione a mesma dificuldade do computador central ou espere o responsável selecionar a dificuldade primeiro.");
			}
		}
		
		if(e.getSource()==primeiroAno){
			dificuldade = "Primeiro Ano";
			if(verificarArquivoDificuldade()==true){
				nome = JOptionPane.showInputDialog(null,"Digite o seu nome para iniciar o jogo: ");
				while((nome.equals(""))||(nome.contains("|")==true)||(nome.contains("<")==true)||(nome.contains(",")==true)||(nome.contains(">")==true)||(nome.contains(".")==true)||(nome.contains(":")==true)||(nome.contains(";")==true)||(nome.contains("?")==true)||(nome.contains("/")==true)||(nome.contains("}")==true)||(nome.contains("]")==true)||(nome.contains("{")==true)||(nome.contains("]")==true)||(nome.contains("{")==true)||(nome.contains("[")==true)||(nome.contains("§")==true)||(nome.contains("\"")==true)||(nome==null)){	//Se o nome da escola não for digitado ou clicado no botão cancelar
					nome = JOptionPane.showInputDialog(null,"Digite corretamente o seu nome para iniciar o jogo: ");
				}
				if(nome != null){
					Aluno aluno = new Aluno(nome, "1º Ano", nomeComputadorCentral, false);
					this.aluno = aluno;
					verificadorDeDestraveProximaPergunta liberar = new verificadorDeDestraveProximaPergunta(this.aluno);
					liberar.start();
				}
			}else{	//Caso o jogador tente selecionar uma dificuldade diferente do computador central, evitar que as perguntas sorteadas do pc central sejam de dificuldades diferentes, ou seja, evitar erros
				JOptionPane.showMessageDialog(null, "Dificuldade escolhida diferente dos demais, por favor selecione a mesma dificuldade do computador central ou espere o responsável selecionar a dificuldade primeiro.");
			}
		}
		
		if(e.getSource()==segundoAno){
			dificuldade = "Segundo Ano";
			if(verificarArquivoDificuldade()==true){
				nome = JOptionPane.showInputDialog(null,"Digite o seu nome para iniciar o jogo: ");
				while((nome.equals(""))||(nome.contains("|")==true)||(nome.contains("<")==true)||(nome.contains(",")==true)||(nome.contains(">")==true)||(nome.contains(".")==true)||(nome.contains(":")==true)||(nome.contains(";")==true)||(nome.contains("?")==true)||(nome.contains("/")==true)||(nome.contains("}")==true)||(nome.contains("]")==true)||(nome.contains("{")==true)||(nome.contains("]")==true)||(nome.contains("{")==true)||(nome.contains("[")==true)||(nome.contains("§")==true)||(nome.contains("\"")==true)){	//Se o nome da escola não for digitado ou clicado no botão cancelar
					nome = JOptionPane.showInputDialog(null,"Digite corretamente o seu nome para iniciar o jogo: ");
				}
				if(nome != null){
					Aluno aluno = new Aluno(nome, "2º Ano", nomeComputadorCentral, false);
					this.aluno = aluno;				
					verificadorDeDestraveProximaPergunta liberar = new verificadorDeDestraveProximaPergunta(this.aluno);
					liberar.start();
				}
			}else{	//Caso o jogador tente selecionar uma dificuldade diferente do computador central, evitar que as perguntas sorteadas do pc central sejam de dificuldades diferentes, ou seja, evitar erros
				JOptionPane.showMessageDialog(null, "Dificuldade escolhida diferente dos demais, por favor selecione a mesma dificuldade do computador central ou espere o responsável selecionar a dificuldade primeiro.");
			}
		}
		
		if(e.getSource()==terceiroAno){
			dificuldade = "Terceiro Ano";
			if(verificarArquivoDificuldade()==true){
				nome = JOptionPane.showInputDialog(null,"Digite o seu nome para iniciar o jogo");
				while((nome.equals(""))||(nome.contains("|")==true)||(nome.contains("<")==true)||(nome.contains(",")==true)||(nome.contains(">")==true)||(nome.contains(".")==true)||(nome.contains(":")==true)||(nome.contains(";")==true)||(nome.contains("?")==true)||(nome.contains("/")==true)||(nome.contains("}")==true)||(nome.contains("]")==true)||(nome.contains("{")==true)||(nome.contains("]")==true)||(nome.contains("{")==true)||(nome.contains("[")==true)||(nome.contains("§")==true)||(nome.contains("\"")==true)){	//Se o nome da escola não for digitado ou clicado no botão cancelar
					nome = JOptionPane.showInputDialog(null,"Digite corretamente o seu nome para iniciar o jogo: ");
				}
				if(nome != null){
					Aluno aluno = new Aluno(nome, "3º Ano", nomeComputadorCentral, false);
					this.aluno = aluno;
					verificadorDeDestraveProximaPergunta liberar = new verificadorDeDestraveProximaPergunta(this.aluno);
					liberar.start();
				}
			}else{	//Caso o jogador tente selecionar uma dificuldade diferente do computador central, evitar que as perguntas sorteadas do pc central sejam de dificuldades diferentes, ou seja, evitar erros
				JOptionPane.showMessageDialog(null, "Dificuldade escolhida diferente dos demais, por favor selecione a mesma dificuldade do computador central ou espere o responsável selecionar a dificuldade primeiro.");
			}
		}
	} 

	public class verificadorDeDestraveProximaPergunta extends Thread implements ActionListener{	//Verifica se o destrave foi feito e o arquivo existe
		private Path caminho = Paths.get("\\\\"+nomeComputadorCentral+"\\Jogo Interativo Tabela Periódica\\Destravador.txt");
		private JFrame janelaDestrave = new JFrame("Aguarde!");
		private JLabel mensagem = new JLabel("Aguarde a primeira pergunta ser liberada");
		private JLabel imagem = new JLabel(new ImageIcon(getClass().getResource("/imagens/IconeAlerta.png")));
		private Font fonte2 = new Font("Arial",Font.BOLD,12);
		private InterfaceGrafica.Aluno aluno;
		private JButton proxima = new JButton("PRÓXIMA");
		private int indiceDestrave = 0; 
		
		Timer t5 = new Timer(1000, new ActionListener(){	//Tempo representa 1 segundo
			public void actionPerformed(ActionEvent e){
				if((caminho.toFile().exists()==false)||(JanelaPrincipal.this.aluno.vazioPerguntaIndividual()==true)){	//O caminho do destravador não conseguiu ser acessado e o vetor de perguntas do aluno está vazio
					t5.stop();
				}
				else{	//Se o Arquivo(Destravador) existe e conseguiu ser acessado, e se o arraylist de perguntas não estiver vazio
					if(indiceDestrave <= JanelaPrincipal.this.aluno.getIndiceDestrave()){
						janelaDestrave.setVisible(true);
							try{
								Scanner scan = new Scanner(caminho, "UTF-8");	//Variável de leitura do Arquivo de Texto
								while(scan.hasNextLine()){	//Lê as linhas do arquivo de texto
									scan.nextLine(); 		//guia para próxima linha
									indiceDestrave++;		//Quantos destravamentos já foram
								}
								if(indiceDestrave==JanelaPrincipal.this.aluno.getIndiceDestrave()){	//Se o indiceDestrave for igual ao do aluno
									System.out.println("É Necessário um novo destrave");
									indiceDestrave=0;		//A variável é zerada para que faça novamente uma análise até identificar um destrave disponível e assim liberar a pergunta
								}	
							}catch(Exception erro){
								erro.printStackTrace();
								System.out.println("Erro na leitura de arquivos");
							}
					}
					else if(indiceDestrave > JanelaPrincipal.this.aluno.getIndiceDestrave()){	//Se foi identificado um novo destrave no computador central
						if(indiceDestrave<2){	//Se ocorreu o destrave da primeira pergutna
							mensagem.setText("Pergunta liberada, clique no botão para prosseguir");
						}
						else{	//Se foi destravado mais de uma pergunta, o jogador não poderá começar a jogar
							imagem.setBounds(89, 23, 25, 25);
							mensagem.setBounds(121, janelaDestrave.getBounds().height/2-40, 450, 30);
							mensagem.setText("<HTML>Aguarde a Rodada terminar para poder jogar, clique no botão<br> para retornar ao menu principal.");
							proxima.setText("Menu");
						}
						proxima.setEnabled(true);
						t5.stop();
					}
				}
			}
		});
		
		public void actionPerformed(ActionEvent e){
			if(e.getSource()==proxima){
				if(indiceDestrave<=1){	//Se o destrave da primeira pergunta é disponível
					janelaPrincipal.dispose();
					janelaDestrave.dispose();
					if(dificuldade == "Nono Ano"){	//Se a dificuldade for 9º Ano acessa a proxima pergunta
						AuxSortearPerguntaNono sort = new AuxSortearPerguntaNono();
						sort.proximaPergunta(JanelaPrincipal.this.aluno);	
					}
					else if((dificuldade == "Primeiro Ano")||(dificuldade == "Segundo Ano")||(dificuldade == "Terceiro Ano")){	//Se a dificuldade for 1º Ano , 2º Ano ou 3º Ano acessa a próxima pergunta
						AuxSortearPerguntaEnsinoMedio sort = new AuxSortearPerguntaEnsinoMedio();
						sort.proximaPergunta(JanelaPrincipal.this.aluno);
					}
				}
				else{	//Se o indiceDestrave for > 1, ou seja já começou uma rodada e isso significa que o jogador não poderá ingressar e logo voltará para a janela principal
					janelaDestrave.dispose();
					janelaPrincipal.enable(true);
				}
			}
		}
		
		public verificadorDeDestraveProximaPergunta(InterfaceGrafica.Aluno aluno){
			this.aluno = aluno;
		}

		public void OptionPane(){	//parecida com uma JOptionPane
			//JANELA
			janelaDestrave.setAlwaysOnTop(true);
			janelaDestrave.setSize(510, 128);
			janelaDestrave.setLayout(null);
			janelaDestrave.getContentPane().setBackground(new Color(187,204,208));
			janelaDestrave.setLocation(janelaPrincipal.getX()+242, janelaPrincipal.getY()+254);
			janelaDestrave.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			janelaDestrave.setResizable(false);
			proxima.setBounds(205, 62, 100, 23);
			mensagem.setBounds(121, 28, 300, 15);
			imagem.setBounds(89, 23, 25, 25);
			proxima.setBackground(new Color(144,238,144));
			proxima.setFont(fonte2);
			proxima.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			proxima.addActionListener(this);
			proxima.setEnabled(false);	
			janelaDestrave.add(imagem);
			janelaDestrave.add(mensagem);
			janelaDestrave.add(proxima);
		}
		
		public void run(){
			OptionPane();
			t5.start();
		}
	}
}