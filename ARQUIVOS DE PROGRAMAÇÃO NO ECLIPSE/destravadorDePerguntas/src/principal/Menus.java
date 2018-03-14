package principal;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;

public class Menus implements ActionListener{

	// A Pasta Historico é criada na raiz do arquivo do jogo, nesse caso dentro do Eclipse
	private String quebraLinha = System.lineSeparator();
	private Path caminhoDestravador = Paths.get("Destravador.txt");
	private Path caminhoPerguntas = Paths.get("Perguntas.txt");
	private Path caminhoEscola = Paths.get("NomeDaEscola.txt");
	private Path caminhoData = Paths.get("Data.txt");
	private Path caminhoDificuldade = Paths.get("Dificuldade.txt");
	private int indice = 0;				//índice usado para ler o arquivo responsável por liberar as perguntas
	private int tempoDeEspera = 0; 		//índice para contar o tempo de 5 segundos e não haver 2 destraves consecutivos
	private boolean contCliqueBotao = false;
	private int rodadasJogadas = 0;
	private int contadorTurma = 1;	// Evitar escolas de mesmo nome no mesmo dia
	
	//Dados Gerais
	private String dia = "";
	private String mes = "";
	private String ano = "";
	private String dificuldade = "";
	private String NomeDaEscola = "Padrão";	//Um nome "Padrão" para caso não for atribuido nenhum nome
	
	//Elementos do Painel do computador central
	private JButton botaoLiberar = new JButton("Liberar pergunta");
	private JButton botaoSorteio;
	private JButton botaoRelatorio = new JButton("Relatório dos Jogadores");
	private JButton botaoConsultaTabela = new JButton("Tabela de Consulta");
	private JLabel escritoDificuldadeSelecionada;
	private JLabel escritoData;
	private JLabel escritoEscola;
	private JLabel escritoTurma;
	private JLabel escritoRodada;
	private Font fonteEscrito = new Font("Arial Black", Font.BOLD, 16);
	private JFrame janela = new JFrame("Painel do Computador central");
	private int proxDestrave = 0;
	private JLabel escritoPerguntaEmQueEsta = new JLabel("Pergunta liberada: " +proxDestrave);
	private Color corFundo = new Color(187, 204, 208);
	private Color corBotoes = new Color(204, 255, 255);
	
	public Menus(){
		data data = new data();
	}
	
	public int getIndiceDestrave(){
		return proxDestrave;
	}
	
	public void verificaCaminho(Path diretorio){	// Verifica a existência do diretorio passado no parâmetro
		try{
			Path caminhoAux = diretorio;
			if(caminhoAux.toFile().exists()==false){	// A Diretório NãO existe
				caminhoAux.toFile().setWritable(true);
				caminhoAux.toFile().setReadable(true);
				caminhoAux.toFile().mkdir();
			}
			else if(caminhoAux.toFile().exists()==true){	// A Diretório SIM existe
				//Se o caminho existe não ocorrerá nada
			}
		}
		catch(Exception erro){
			erro.printStackTrace();
		}
	}
	
	public void verificaExistenciaPastas(){ //Verifica a existencia das pastas, se não existe irá criá-las
		Path caminhoAux = Paths.get("Histórico");
		verificaCaminho(caminhoAux);
		caminhoAux = Paths.get("Histórico\\"+dificuldade);
		verificaCaminho(caminhoAux);
		caminhoAux = Paths.get("Histórico\\"+dificuldade+"\\"+ano);
		verificaCaminho(caminhoAux);
		caminhoAux = Paths.get("Histórico\\"+dificuldade+"\\"+ano+"\\"+mes);
		verificaCaminho(caminhoAux);
		caminhoAux = Paths.get("Histórico\\"+dificuldade+"\\"+ano+"\\"+mes+"\\"+dia);
		verificaCaminho(caminhoAux);
	}
	
	public void setNomeDaEscola(){
		try{
			// Trocando a cor de fundo da OptionPane nome da escola
			UIManager UI = new UIManager();
			UI.put("OptionPane.background",new ColorUIResource(corFundo));
			UI.put("Panel.background",new ColorUIResource(corFundo));
			this.NomeDaEscola = JOptionPane.showInputDialog(null,"Digite o Nome da Escola: ");
			while((NomeDaEscola.equals("Padrão"))||(NomeDaEscola.equals(""))||(NomeDaEscola.contains("|")==true)||(NomeDaEscola.contains("<")==true)||(NomeDaEscola.contains(",")==true)||(NomeDaEscola.contains(">")==true)||(NomeDaEscola.contains(".")==true)
			||(NomeDaEscola.contains(":")==true)||(NomeDaEscola.contains(";")==true)||(NomeDaEscola.contains("?")==true)||(NomeDaEscola.contains("/")==true)||(NomeDaEscola.contains("}")==true)||(NomeDaEscola.contains("]")==true)||(NomeDaEscola.contains("{")==true)
			||(NomeDaEscola.contains("]")==true)||(NomeDaEscola.contains("{")==true)||(NomeDaEscola.contains("[")==true)||(NomeDaEscola.contains("+")==true)||(NomeDaEscola.contains("\"")==true)){	// Se o nome da escola não for digitado corretamente ou for clicado no botão cancelar
				this.NomeDaEscola = JOptionPane.showInputDialog(null,"Digite corretamente o nome da Escola:");
			}
			escritoEscola = new JLabel("\tNome da Escola: "+NomeDaEscola);
			Path caminhoAux = Paths.get("Histórico\\"+dificuldade+"\\"+ano+"\\"+mes+"\\"+dia+"\\"+NomeDaEscola);
			if(caminhoAux.toFile().exists()==false){
				caminhoAux.toFile().setWritable(true);
				caminhoAux.toFile().setReadable(true);
				caminhoAux.toFile().mkdir();
				caminhoAux = Paths.get("Histórico\\"+dificuldade+"\\"+ano+"\\"+mes+"\\"+dia+"\\"+NomeDaEscola+"\\Turma 1");
				caminhoAux.toFile().setWritable(true);
				caminhoAux.toFile().setReadable(true);
				caminhoAux.toFile().mkdir();
			}
			else if(caminhoAux.toFile().exists()==true){
				String[] pastasTurmas = caminhoAux.toFile().list();
				ArrayList<String> aux = new ArrayList<String>();
				for(int i=0; i<pastasTurmas.length; i++){
					if((pastasTurmas[i].contains(".")==false)&&(pastasTurmas[i].contains("Turma")==true)){
						aux.add(pastasTurmas[i]);
					}
				}
				contadorTurma = aux.size() + 1;		//Armazena quantas turmas já existem, por isso armazena o número de pastas e será adicionada uma unidade pois ela representa a nova pasta que será criada
				caminhoAux = Paths.get("Histórico\\"+dificuldade+"\\"+ano+"\\"+mes+"\\"+dia+"\\"+NomeDaEscola+"\\Turma "+contadorTurma);
				if(caminhoAux.toFile().exists()==false){	//Cria a pasta da Turma se não existir
					caminhoAux.toFile().setWritable(true);
					caminhoAux.toFile().setReadable(true);
					caminhoAux.toFile().mkdir();
				}
				else if(caminhoAux.toFile().exists()==true){	//Se a pasta da Turma existir não ocorrerá nada
				}
			}
		}
		catch(Exception e){
			if(e.toString()=="java.lang.NullPointerException"){		//Tratando a Excessão de caso ele clique no x e o nome da escola não for digitado
				JOptionPane.showMessageDialog(null, "Como o nome da escola não foi digitado corretamente, para evitar erros o programa será finalizado.");
				if(caminhoDestravador.toFile().exists()==true)	// Destravador
    				caminhoDestravador.toFile().delete();						//	Os arquivos serão apagados com o objetivo de evitar erros
    			if(caminhoPerguntas.toFile().exists()==true) //	Perguntas	//	Os arquivos serão apagados com o objetivo de evitar erros
    				caminhoPerguntas.toFile().delete();						//	Os arquivos serão apagados com o objetivo de evitar erros
    			if(caminhoEscola.toFile().exists()==true) // Nome da Escola
    				caminhoEscola.toFile().delete();
    			if(caminhoData.toFile().exists()==true) // Data do Dia
    				caminhoData.toFile().delete();
    			if(caminhoDificuldade.toFile().exists()==true) // Dificuldade
    				caminhoDificuldade.toFile().delete();
    			System.exit(0);
			}
			e.printStackTrace();
		}
	}
	
	public void arquivoNomeEscola(){
		try{
			caminhoEscola.toFile().setWritable(true);
			caminhoEscola.toFile().setReadable(true);
			OutputStreamWriter bufferOut = new OutputStreamWriter(new FileOutputStream(""+caminhoEscola),"UTF-8");
			bufferOut.write("\tNome da Escola: ("+NomeDaEscola+")");
			bufferOut.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void arquivoDificuldade(){
		try{
			caminhoDificuldade.toFile().setWritable(true);
			caminhoDificuldade.toFile().setReadable(true);
			OutputStreamWriter bufferOut = new OutputStreamWriter(new FileOutputStream(""+caminhoDificuldade),"UTF-8");
			bufferOut.write("\tDificuldade: ("+dificuldade+")");
			bufferOut.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void ajustaDificuldade(){	//Como as dificuldades estavam expressas em nomes como "Nono Ano", "Primeiro Ano"... estou tendo que ajustar para "9º Ano", "1º Ano"...
		if(dificuldade.equals("Nono Ano")){
			dificuldade = "9º Ano";
		}
		if(dificuldade.equals("Primeiro Ano")){
			dificuldade = "1º Ano";
		}
		if(dificuldade.equals("Segundo Ano")){
			dificuldade = "2º Ano";
		}
		if(dificuldade.equals("Terceiro Ano")){
			dificuldade = "3º Ano";
		}
	}
	
	public void verificaRodadas(){	//Cria a pasta das rodadas jogadas
		try{
			Path caminhoAux = Paths.get("Histórico\\"+dificuldade+"\\"+ano+"\\"+mes+"\\"+dia+"\\"+NomeDaEscola+"\\Turma "+contadorTurma);
			String[] aux = caminhoAux.toFile().list(); 				//Captura os itens contidos na pasta da turma
			ArrayList<String> rodadas = new ArrayList<String>();	//Adicionam somente as pastas de rodadas
			for(int i = 0; i < aux.length; i++){
				if((aux[i].contains(".")==false)&&(aux[i].contains("Rodada")==true)){	//Adiciona somente pastas que contenham Rodada no nome ao arraylist 
					rodadas.add(aux[i]);
				}
			}
			rodadasJogadas = rodadas.size()+1;
			escritoRodada.setText("Rodada: "+ rodadasJogadas);	//Exibe na tela a rodada atual
			caminhoAux = Paths.get("Histórico\\"+dificuldade+"\\"+ano+"\\"+mes+"\\"+dia+"\\"+NomeDaEscola+"\\Turma "+contadorTurma+"\\"+rodadasJogadas+"ª Rodada");
			if(caminhoAux.toFile().exists()==false){	//Se a pasta da rodada não existe ela será criada
				caminhoAux.toFile().setWritable(true);
				caminhoAux.toFile().setReadable(true);
				caminhoAux.toFile().mkdir();
			}
			else if(caminhoAux.toFile().exists()==true){}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void arquivoDestravador(){
		DestraveDepoisDeCincoSegundos tempo = new DestraveDepoisDeCincoSegundos();
		tempo.start();
		String textoTeste = "";
		byte[] textoEmByte = textoTeste.getBytes(); // Converte o texto digitado para Bytes
		try{
			caminhoDestravador.toFile().setWritable(true);
			caminhoDestravador.toFile().setReadable(true);
			if(caminhoDestravador.toFile().exists()==false){	// Verifica se o arquivo de texto não existe
				Files.write(caminhoDestravador, textoEmByte);	//Cria o arquivo de texto no caminhoDestravador a partir de uma string convertida em um vetor de Bytes
			}
			else if(caminhoDestravador.toFile().exists()==true){
				Files.write(caminhoDestravador, textoEmByte);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	public void Janela(){
		//Janela
		janela.setSize(695, 374);
		janela.setLayout(null);
		janela.setLocationRelativeTo(null);
		janela.setResizable(false);
		janela.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		janela.setVisible(true);
		janela.addWindowListener(Window);
		janela.getContentPane().setBackground(corFundo);
		
		//Elementos
		escritoTurma = new JLabel("Turma: "+ contadorTurma);
		botaoSorteio = new JButton("Sorteio "+ dificuldade);
		escritoRodada = new JLabel("Rodada: "+ rodadasJogadas);
		botaoLiberar.setBounds(104, 35, 130, 30);
		botaoSorteio.setBounds(104, 105, 130, 30);
		botaoRelatorio.setBounds(79, 185, 180, 30);
		botaoConsultaTabela.setBounds(79, 261, 180, 30);
		escritoDificuldadeSelecionada.setBounds(340, 28, 350, 30);
		escritoEscola.setBounds(340, 79, 350, 30);
		escritoTurma.setBounds(340, 130, 130, 30);
		escritoRodada.setBounds(340, 182, 135, 30);
		escritoData.setBounds(340, 233, 180, 30);
		escritoPerguntaEmQueEsta.setBounds(340, 284, 280, 30);
		botaoLiberar.setBackground(corBotoes);
		botaoSorteio.setBackground(corBotoes);
		botaoRelatorio.setBackground(corBotoes);
		botaoConsultaTabela.setBackground(corBotoes);
		botaoLiberar.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		botaoSorteio.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		botaoRelatorio.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		botaoConsultaTabela.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		botaoLiberar.addActionListener(this);
		botaoSorteio.addActionListener(this);
		botaoRelatorio.addActionListener(this);
		botaoConsultaTabela.addActionListener(this);
		escritoDificuldadeSelecionada.setFont(fonteEscrito);
		escritoEscola.setFont(fonteEscrito);
		escritoTurma.setFont(fonteEscrito);
		escritoRodada.setFont(fonteEscrito);
		escritoData.setFont(fonteEscrito);
		escritoPerguntaEmQueEsta.setFont(fonteEscrito);
		janela.add(escritoDificuldadeSelecionada);
		janela.add(escritoEscola);
		janela.add(escritoTurma);
		janela.add(escritoRodada);
		janela.add(escritoData);
		janela.add(escritoPerguntaEmQueEsta);
		janela.add(botaoLiberar);
		janela.add(botaoSorteio);
		janela.add(botaoRelatorio);
		janela.add(botaoConsultaTabela);
	}
	
	WindowListener Window = new WindowAdapter() 
	{  
	    public void windowClosing( WindowEvent e )  
	    {  
	    	int num = JOptionPane.showConfirmDialog(null, "Deseja finalizar?", "certeza?", JOptionPane.YES_NO_CANCEL_OPTION);
	    	if(num == JOptionPane.YES_OPTION){
	    		try{
	    		if(caminhoDestravador.toFile().exists()){	//Se o arquivo de Destrave existe
					Scanner scan = new Scanner(caminhoDestravador, "UTF-8");	//Variável de leitura do Arquivo de Texto
					byte[] texto = Files.readAllBytes(caminhoDestravador); // irá retornar um array de bytes
					String leitura = new String(texto);	//o texto em bytes foi passado como parametro.
					if(leitura.isEmpty()==true){	//Se o arquivo de texto do Destrave estiver vazio, ou seja, não houver perguntas liberadas
						if(caminhoDestravador.toFile().exists()==true)	// DESTRAVADOR
		    				caminhoDestravador.toFile().delete();						
		    			if(caminhoPerguntas.toFile().exists()==true) //	PERGUNTAS	
		    				caminhoPerguntas.toFile().delete();						
		    			if(caminhoEscola.toFile().exists()==true) // NOMEDAESCOLA
		    				caminhoEscola.toFile().delete();
		    			if(caminhoData.toFile().exists()==true) // DATA DO DIA
		    				caminhoData.toFile().delete();
		    			if(caminhoDificuldade.toFile().exists()==true) // DIFICULDADE
		    				caminhoDificuldade.toFile().delete();
		    			System.exit(0);
		    		}
		    		else
		    			JOptionPane.showMessageDialog(null,"Termine a liberação de perguntas primeiro");
	    			}
	    		}
	    		catch(Exception erro){
	    			erro.printStackTrace();
	    		}
	    	}
	    }  
	};
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==botaoLiberar){
			Sorteio sort = new Sorteio();
			try{
				if((tempoDeEspera<=5)&&(contCliqueBotao==true)){		//Se o tempoDeEspera for menor que 5 segundos e o botão foi clicado
					JOptionPane.showMessageDialog(null, "clique em OK e espere 5 segundos para poder destravar a próxima pergunta");	
				}	
				if((caminhoPerguntas.toFile().exists()==true)&&(sort.getVazioSorteio()==false)&&(contCliqueBotao==false)&&(tempoDeEspera<=5)){	//Só irá liberar as perguntas se o arquivo das perguntas existir e não for vazio, o botão de destrave não for clicado e o tempo for menor que 5 segundos
					if(caminhoDestravador.toFile().exists()){						//Se o arquivo de texto existe
						Scanner scan = new Scanner(caminhoDestravador, "UTF-8");	//Variável de leitura do Arquivo de Texto
						byte[] texto = Files.readAllBytes(caminhoDestravador); 		//irá retornar um array de bytes
						String leitura = new String(texto);							//o texto em bytes foi passado como parametro.
						String s = "";
						while(scan.hasNextLine()){	//Lá as linhas do arquivo de texto
							s = scan.nextLine(); 	//Vai capturando as strings das linhas, por consequência chega ao final do arquivo e armazena a ultima linha na string s
							indice++;				//Captura o numero de linhas do arquivo que é o mesmo dos destravamentos
						}
						switch(indice){				//Habilita o Destravamento das outras perguntas;
							case 0:
								verificaRodadas();	//Cria a pasta da rodada ao ter o primeiro destrave
								proxDestrave++;
								escritoPerguntaEmQueEsta.setText("Pergunta liberada: " +proxDestrave);
								leitura = leitura+(indice+1);
								Files.write(caminhoDestravador, leitura.getBytes());
								contCliqueBotao = true;
								break;
							case 1:
								proxDestrave++;
								escritoPerguntaEmQueEsta.setText("Pergunta liberada: " +proxDestrave);
								leitura = leitura+quebraLinha+(indice+1);
								Files.write(caminhoDestravador, leitura.getBytes());
								contCliqueBotao = true;
								break;
							case 2:
								proxDestrave++;
								escritoPerguntaEmQueEsta.setText("Pergunta liberada: " +proxDestrave);
								leitura = leitura+quebraLinha+(indice+1);
								Files.write(caminhoDestravador, leitura.getBytes());
								contCliqueBotao = true;
								break;
							case 3:
								proxDestrave++;
								escritoPerguntaEmQueEsta.setText("Pergunta liberada: " +proxDestrave);
								leitura = leitura+quebraLinha+(indice+1);
								Files.write(caminhoDestravador, leitura.getBytes());
								contCliqueBotao = true;
								break;
							case 4:
								proxDestrave++;
								escritoPerguntaEmQueEsta.setText("Pergunta liberada: " +proxDestrave);
								leitura = leitura+quebraLinha+(indice+1);
								Files.write(caminhoDestravador, leitura.getBytes());
								contCliqueBotao = true;
								break;
							case 5:
								proxDestrave++;
								escritoPerguntaEmQueEsta.setText("Pergunta liberada: " +proxDestrave);
								leitura = leitura+quebraLinha+(indice+1);
								Files.write(caminhoDestravador, leitura.getBytes());
								contCliqueBotao = true;
								break;
							case 6:
								proxDestrave++;
								escritoPerguntaEmQueEsta.setText("Pergunta liberada: " +proxDestrave);
								leitura = leitura+quebraLinha+(indice+1);
								Files.write(caminhoDestravador, leitura.getBytes());
								contCliqueBotao = true;
								break;
							case 7:
								proxDestrave++;
								escritoPerguntaEmQueEsta.setText("Pergunta liberada: " +proxDestrave);
								leitura = leitura+quebraLinha+(indice+1);
								Files.write(caminhoDestravador, leitura.getBytes());
								contCliqueBotao = true;
								break;
							case 8:
								proxDestrave++;
								escritoPerguntaEmQueEsta.setText("Pergunta liberada: " +proxDestrave);
								leitura = leitura+quebraLinha+(indice+1);
								Files.write(caminhoDestravador, leitura.getBytes());
								contCliqueBotao = true;
								break;
							case 9:
								proxDestrave++;
								escritoPerguntaEmQueEsta.setText("Pergunta liberada: " +proxDestrave);
								leitura = leitura+quebraLinha+(indice+1);
								Files.write(caminhoDestravador, leitura.getBytes());
								contCliqueBotao = true;
								break;
							case 10:
								proxDestrave = 0;	//Como todas as perguntas já foram liberadas então a variável é zerada
								escritoPerguntaEmQueEsta.setText("Pergunta liberada: " +proxDestrave);
								leitura = leitura+quebraLinha+(indice+1);
								Files.write(caminhoDestravador, leitura.getBytes());
								JOptionPane.showMessageDialog(null, "Jogo concluido com sucesso");
								if(caminhoDestravador.toFile().exists()==true){
									if(caminhoPerguntas.toFile().exists()==true){
										Files.write(caminhoPerguntas, (new String("")).getBytes());		//Cria um arquivo de perguntas vazio
									}
									arquivoDestravador();	//Cria o arquivo destravador vazio
								}
								break;
							default: System.out.println("Erro no Switch");
							}
							indice = 0;
						}
					}
					else if((caminhoPerguntas.toFile().exists()==false)){	//Se o caminhoPerguntas não existe e se existir está vazio
						JOptionPane.showMessageDialog(null, "é necessário o sorteio das perguntas antes");
					}
				}catch(Exception erro){
					System.out.println("Erro na leitura de arquivos");
					erro.printStackTrace();
			}	
		}
		
		if(e.getSource()==botaoSorteio){
			Sorteio sort = new Sorteio();
			System.out.println(dificuldade);
			if(dificuldade.equals("9º Ano")){
				sort.sortearPerguntasNonoAno();
			}
			else if((dificuldade.equals("1º Ano"))||(dificuldade.equals("2º Ano"))||(dificuldade.equals("3º Ano"))){
				sort.sortearPerguntasEnsinoMedio();
			}
		}
		
		if(e.getSource()==botaoRelatorio){
			janela.setVisible(false);
			RelatorioJogadores relatorio = new RelatorioJogadores(dia, mes, ano, dificuldade, NomeDaEscola, janela, getIndiceDestrave());
		}
		
		if(e.getSource()==botaoConsultaTabela){
			TabelaPeriodica tp = new TabelaPeriodica();
		}
	}
	
	public class DestraveDepoisDeCincoSegundos extends Thread{
		
		Timer t6 = new Timer(1000, new ActionListener(){	//Tempo representa 1 segundo
			public void actionPerformed(ActionEvent e){
				if((contCliqueBotao == true)&&(tempoDeEspera > 5)){	//Se o botão foi clicado e se passaram mais de 5 segundos
					contCliqueBotao = false;						//A variável de controle se torna falsa tornando o botão para ser clicado novamente
					tempoDeEspera = 0;
				}
				else if((contCliqueBotao==true)&&(tempoDeEspera<6)){	//Se o botão foi clicado e o tempo é menor que 6 segundos
					tempoDeEspera++;
				}
			}
		});
		
		public void run(){
			t6.start();
		}
	}
	
	public class data implements ActionListener{
		
		private JComboBox<String> comboDificuldade = new JComboBox<String>();
		private JFrame janelaData = new JFrame("Data e Dificuldade");
		private JTextField campoDia = new JTextField("");
		private JTextField campoMes = new JTextField("");
		private JTextField campoAno = new JTextField("");
		private JLabel escritoDia = new JLabel("Dia");
		private JLabel escritoMes = new JLabel("Mês");
		private JLabel escritoAno = new JLabel("Ano");
		private JLabel instrucaoData = new JLabel("<HTML>Coloque a data de hoje nos espaços abaixo:");
		private JLabel instrucaoDificuldade = new JLabel("<HTML>Selecione a dificuldade que a turma irá jogar na caixa abaixo: ");
		private Font fonte = new Font("Georgia", Font.BOLD,15);
		private JButton confirmar = new JButton("Confirmar");
		private int diaNum = 0;
		private int mesNum = 0;
		private int anoNum = 0;
			
		public void setJanela(){
			janelaData.setSize(350, 220);
			janelaData.setLayout(null);
			janelaData.getContentPane().setBackground(corFundo);
			janelaData.setLocationRelativeTo(null);
			janelaData.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			janelaData.setResizable(false);
			confirmar.setBounds(110,165,104,20);
			confirmar.addActionListener(this);
			confirmar.setFont(new Font("Georgia", Font.BOLD,12));
			confirmar.setBackground(new Color(153,255,204));
			janelaData.add(confirmar);
			setTextFields();
			janelaData.setVisible(true);
		}
		
		public void setComboBoxDificuldade(){
			comboDificuldade.setBounds(105, 125, 115, 25);
			comboDificuldade.addItem("Nono Ano");
			comboDificuldade.addItem("Primeiro Ano");	
			comboDificuldade.addItem("Segundo Ano");
			comboDificuldade.addItem("Terceiro Ano");
			comboDificuldade.setSelectedItem(null);		
			comboDificuldade.addActionListener(this);
			comboDificuldade.setBackground(new Color(204,255,255));
			comboDificuldade.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			instrucaoDificuldade.setBounds(19, 90, 325, 25);
			instrucaoDificuldade.setFont(new Font("Arial", Font.PLAIN|Font.BOLD,12));
			janelaData.add(instrucaoDificuldade);
			janelaData.add(comboDificuldade);
		}
			
		public void setTextFields(){
			campoDia = defineTipoQuantCaract(2, "0,1,2,3,4,5,6,7,8,9");
			campoMes = defineTipoQuantCaract(2, "0,1,2,3,4,5,6,7,8,9");
			campoAno = defineTipoQuantCaract(4, "0,1,2,3,4,5,6,7,8,9");
			escritoDia.setFont(fonte);
			escritoMes.setFont(fonte);
			escritoAno.setFont(fonte);
			instrucaoData.setFont(new Font("Arial", Font.PLAIN|Font.BOLD,11));
			escritoDia.setBounds(49, 30, 35, 20);
			escritoMes.setBounds(149, 30, 35, 20);
			escritoAno.setBounds(249, 30, 35, 20);
			instrucaoData.setBounds(49, 3, 250, 20);
			campoDia.setBackground(new Color(204,255,255));
			campoMes.setBackground(new Color(204,255,255));
			campoAno.setBackground(new Color(204,255,255));
			campoDia.setBounds(15, 50, 90, 25);
			campoMes.setBounds(115, 50, 90, 25);
			campoAno.setBounds(215, 50, 100, 25);
			campoDia.setFont(fonte);
			campoMes.setFont(fonte);
			campoAno.setFont(fonte);
			campoDia.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			campoMes.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			campoAno.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			campoDia.setHorizontalAlignment(JTextField.CENTER);
			campoMes.setHorizontalAlignment(JTextField.CENTER);
			campoAno.setHorizontalAlignment(JTextField.CENTER);
			janelaData.add(campoDia);
			janelaData.add(campoMes);
			janelaData.add(campoAno);
			janelaData.add(escritoDia);
			janelaData.add(escritoMes);
			janelaData.add(escritoAno);				
			janelaData.add(instrucaoData);
			setComboBoxDificuldade();
		}
		
		public void arquivoData(){
			try{
				caminhoData.toFile().setWritable(true);
				caminhoData.toFile().setReadable(true);
				if(caminhoData.toFile().exists()==false){
					Files.write(caminhoData, new String("\tData de hoje: ("+dia+"/"+mes+"/"+ano+")").getBytes());
				}
				else if(caminhoData.toFile().exists()==true){
					Files.write(caminhoData, new String("\tData de hoje: ("+dia+"/"+mes+"/"+ano+")").getBytes());
				}
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
		
		/**
		 * Define quais caracteres serão válidos nos campos
		 */
			
		public JTextField defineTipoQuantCaract(int tamanho, String caracteres){
			try{
				String quantidade="";
				for(int i=0; i<tamanho;i++){
					quantidade = quantidade+"*";
				}
				javax.swing.text.MaskFormatter nome = new javax.swing.text.MaskFormatter(quantidade);
				nome.setValidCharacters(caracteres);	//Atribui quais caracteres serão válidos
				nome.setPlaceholderCharacter('0');		//Cada espaço é preenchido por "0"
				return new javax.swing.JFormattedTextField(nome);
				}
			catch(Exception e){
				JOptionPane.showMessageDialog(null,"Ocorreu um erro");
				return new JTextField();
			}
		}
			
		public data(){
			setJanela();
		}

		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==confirmar){
				if(comboDificuldade.getSelectedItem()!=null){	//Caso for selecionada uma dificuldade 
					diaNum = Integer.parseInt(campoDia.getText());
					mesNum = Integer.parseInt(campoMes.getText());
					anoNum = Integer.parseInt(campoAno.getText());
					if(((diaNum!=0)&&(diaNum<32))&&((mesNum!=0)&&(mesNum<13))&&(anoNum>=2015)){		//Corrige dadas inválidas
						dia = campoDia.getText();	//
						mes = campoMes.getText();	//	ATRIBUI DIA/MES/ANO
						ano = campoAno.getText();	//
						escritoData = new JLabel("Data: "+dia+"/"+mes+"/"+ano);
						String dificuldadeAux = "";
						if(dificuldade.equals("Nono Ano"))
							dificuldadeAux = "9º Ano";
						if(dificuldade.equals("Primeiro Ano"))
							dificuldadeAux = "1º Ano";
						if(dificuldade.equals("Segundo Ano"))
							dificuldadeAux = "2º Ano";
						if(dificuldade.equals("Terceiro Ano"))
							dificuldadeAux = "3º Ano";
						escritoDificuldadeSelecionada = new JLabel("Dificuldade selecionada: "+dificuldadeAux);
						arquivoData();
						arquivoDificuldade();	
						ajustaDificuldade();
						janelaData.dispose();	//Finaliza a janela de data
						verificaExistenciaPastas();
						setNomeDaEscola();
						arquivoNomeEscola();
						arquivoDestravador();
						Janela();
					}
					else{
						JOptionPane.showMessageDialog(null, "Apresenta parâmetros inválidos.");
					}
				}
				else{
					JOptionPane.showMessageDialog(null, "Selecione uma dificuldade:");
				}
			}
			
			if(e.getSource()==comboDificuldade){	//Ação da ComboBox de Dificuldade
				if(comboDificuldade.getSelectedItem()!=null){
					switch(comboDificuldade.getSelectedIndex()){	//Captura a dificuldade selecionada
						case 0:	//Nono ano
							dificuldade = "Nono Ano";
							break;
						case 1:	//Primeiro ano
							dificuldade = "Primeiro Ano";
							break;
						case 2:	//Segundo ano
							dificuldade = "Segundo Ano";
							break;
						case 3: //Terceiro ano
							dificuldade = "Terceiro Ano";
							break;
						default: System.out.println("Erro ao selecionar dificuldade");
					}
				}
			}
		}
	}
}