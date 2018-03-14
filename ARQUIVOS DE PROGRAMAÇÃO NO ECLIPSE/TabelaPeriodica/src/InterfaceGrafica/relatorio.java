package InterfaceGrafica;

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

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class relatorio implements ActionListener{

	private JLabel[] status = new JLabel[10];
	private JLabel nomeAluno = new JLabel();
	private JButton sair = new JButton("Sair");
	private String rodada = "";		// Pasta da rodada em que o jogador se encontra
	
	private ImageIcon imagemFundo = new ImageIcon(getClass().getResource("/imagens/Janela Relatório.jpg"));
	private JLabel fundo = new JLabel();
	private Color corFundo = new Color(186, 204, 208);
	private Color corCorreta = new Color(58, 151, 71);
	private Color corErrada = new Color(213, 21, 18);
	private JFrame janela = new JFrame();
	private Font fonteStatus = new Font("Arial Black", Font.BOLD, 14);
	
	private InterfaceGrafica.Aluno aluno;
	private String nomeComputadorCentral;

	public relatorio(InterfaceGrafica.Aluno aluno, String nomeComputadorCentral){
		this.nomeComputadorCentral = nomeComputadorCentral;
		this.aluno = aluno;
		setPerguntas();
		gravarRelatorio();
		Respostas();
		botaoSair();
		setFundo();
		setJanela();
	}
	
	public void gravarRelatorio(){
		try{
			verificaExistenciaPastas();	// Verifica a existencia das subpastas no pc do aluno
			verificarExistenciaEscola();	// Verifica a pasta da escola
			String quebraLinha = System.lineSeparator(); // ou poderia ser assim System.getProperty("line.separator");
			Path caminho = Paths.get("Histórico\\"+this.aluno.getAno()+"\\"+this.aluno.getAnoJogado()+"\\"+this.aluno.getMes()+"\\"+this.aluno.getDia()+"\\"+this.aluno.getNomeEscola()+"\\"+rodada+"\\"+this.aluno.getNome().replaceAll(" ", "")+".txt");
			caminho.toFile().setWritable(true);	// Permissão de escrita no arquivo
			caminho.toFile().setReadable(true);	// Permissão de ler o arquivo
			OutputStreamWriter bufferOut = new OutputStreamWriter(new FileOutputStream(""+caminho),"UTF-8");	//CODIFICAÇÃO UTF-8 COMPATIVEL PARA A LEITURA NO COMPUTADOR CENTRAL COM ACENTOS E OUTROS
			int indice = 0;	// Indice para escanear a pontuação e Acerto ou erro de cada pergunta
			String relatorio = "\t\t\t\tRelatório do jogador: "+quebraLinha+"Nome: "+this.aluno.getNome()+"\t\t\tAno: "+this.aluno.getAno()+"\t\tPontuação Total: "+this.aluno.getPonto()+quebraLinha;
			relatorio+="Data: "+this.aluno.getDia()+"/"+this.aluno.getMes()+"/"+this.aluno.getAnoJogado();
			relatorio+="\t\tEscola: "+this.aluno.getNomeEscola()+quebraLinha+quebraLinha;
			while(indice<10 && this.aluno.getSizeRegistroPontosPerguntas()==10){	//loop utilizado para guardar o status do jogador
				if(this.aluno.getResposta(indice) == true){ 
					relatorio+="Pergunta "+(indice+1)+" -> "+this.aluno.getRegistroPontosPerguntas(indice)+ " -> Acertou"+quebraLinha;
				}
				else if(this.aluno.getResposta(indice) == false){
					relatorio+="Pergunta "+(indice+1)+" -> "+this.aluno.getRegistroPontosPerguntas(indice)+ " -> Errou"+quebraLinha;
				}
				indice++;
			}
			bufferOut.write(relatorio);	//Escrevendo toda String do relatório montada no arquivo de texto
			bufferOut.close();
			Historico historico = new Historico(nomeComputadorCentral);	// Antes de mandar o relatório para o computador central será atualizado os relatorios do computador do aluno
			historico.setRelatorioEscola(this.aluno);
			enviarRelatorioCompCentral(caminho);
		}
		catch(Exception erro){
			erro.printStackTrace();
			System.out.println("Erro na leitura do arquivo do Relatório");
            System.exit(0);
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
		caminho3 = Paths.get("Histórico\\"+this.aluno.getAno());
		verificaCaminho(caminho3);
		caminho3 = Paths.get("Histórico\\"+this.aluno.getAno()+"\\"+this.aluno.getAnoJogado());
		verificaCaminho(caminho3);
		caminho3 = Paths.get("Histórico\\"+this.aluno.getAno()+"\\"+this.aluno.getAnoJogado()+"\\"+this.aluno.getMes());
		verificaCaminho(caminho3);
		caminho3 = Paths.get("Histórico\\"+this.aluno.getAno()+"\\"+this.aluno.getAnoJogado()+"\\"+this.aluno.getMes()+"\\"+this.aluno.getDia());
		verificaCaminho(caminho3);
		caminho3 = Paths.get("Histórico\\"+this.aluno.getAno()+"\\"+this.aluno.getAnoJogado()+"\\"+this.aluno.getMes()+"\\"+this.aluno.getDia()+"\\"+this.aluno.getNomeEscola());
		verificaCaminho(caminho3);
		caminho3 = Paths.get("Histórico\\"+this.aluno.getAno()+"\\"+this.aluno.getAnoJogado()+"\\"+this.aluno.getMes()+"\\"+this.aluno.getDia()+"\\"+this.aluno.getNomeEscola()+"\\"+rodada);
		verificaCaminho(caminho3);
	}
	
	public void verificarExistenciaEscola(){
		Path caminho3 = Paths.get("Histórico\\"+this.aluno.getAno()+"\\"+this.aluno.getAnoJogado()+"\\"+this.aluno.getMes()+"\\"+this.aluno.getDia()+"\\"+this.aluno.getNomeEscola());
		verificaCaminho(caminho3);	//Verificando a pasta da ESCOLA se existe, se não a cria
		try{
			if(caminho3.toFile().exists()==true){	//Verifica se a Pasta ESCOLA existe no Computador Central
				String[] aux = caminho3.toFile().list();
				ArrayList<String> rodadas = new ArrayList<String>();
				for(int i = 0; i<aux.length;i++)	//Capturar somente o nome de pastas com exceção se tiver '.'
				{
					if((aux[i].contains(".")==false)&&(aux[i].contains("Rodada")==true)){	//Captura o nome das subpastas de RODADAS
						rodadas.add(aux[i]);
					}
				}	// Guarda o nome das pastas das rodadas existentes
				if(rodadas.size()==0){	//SE NÃO HOUVER PASTA DE RODADAS
					caminho3 = Paths.get("Histórico\\"+this.aluno.getAno()+"\\"+this.aluno.getAnoJogado()+"\\"+this.aluno.getMes()+"\\"+this.aluno.getDia()+"\\"+this.aluno.getNomeEscola()+"\\"+(rodadas.size()+1)+"ª Rodada");
					verificaCaminho(caminho3);
				}
				aux = caminho3.toFile().list(); // Faz outro escaneamento
				rodadas.clear();	//Limpar o arraylist para o novo processo
				for(int i = 0; i<aux.length;i++)	//Capturar somente o nome de pastas com exceção se tiver '.'
				{
					if((aux[i].contains(".")==false)&&(aux[i].contains("Rodada")==true)){	//Captura o nome das subpastas de RODADAS
						rodadas.add(aux[i]);
					}
				}	// Guarda o nome das pastas das rodadas existentes
				ArrayList<String> pastasNaoContemAluno = new ArrayList<String>();
				for(int i = 0; i < rodadas.size(); i++){
					caminho3 = Paths.get("Histórico\\"+this.aluno.getAno()+"\\"+this.aluno.getAnoJogado()+"\\"+this.aluno.getMes()+"\\"+this.aluno.getDia()+"\\"+this.aluno.getNomeEscola()+"\\"+rodadas.get(i));
					 if(verificaContemArquivoAluno(caminho3)==false){	//Se a pasta não contém o arquivo do aluno
						 pastasNaoContemAluno.add(rodadas.get(i));
					 }
				}
				if(pastasNaoContemAluno.size()==0){	//Se todas as pastas contém o arquivo do Aluno
					caminho3 = Paths.get("Histórico\\"+this.aluno.getAno()+"\\"+this.aluno.getAnoJogado()+"\\"+this.aluno.getMes()+"\\"+this.aluno.getDia()+"\\"+this.aluno.getNomeEscola()+"\\"+(rodadas.size()+1)+"ª Rodada");
					verificaCaminho(caminho3);
					rodada = (rodadas.size()+1)+"ª Rodada";	//Após criar a pasta a variavel rodada receberá ela
				}
				else{	//Se contem alguma pasta de rodada que nao tem arquivo do aluno
					rodada = (pastasNaoContemAluno.get(0));	//A Primeira pasta que não contem o arquivo é a escolhida para armazená-lo
				}  
			}
		}
		catch(Exception erro){
			erro.printStackTrace();
			System.out.println("Ocorreu um erro");
		}
	}
	
	public boolean verificaContemArquivoAluno(Path caminhoRodada){
		String[] nomesArquivos = caminhoRodada.toFile().list();
		ArrayList<String> guardaNomes = new ArrayList<String>();
		for(int i = 0; i <nomesArquivos.length;i++){
			guardaNomes.add(nomesArquivos[i]);
		}
		if(guardaNomes.contains(this.aluno.getNome().replaceAll(" ", "")+".txt")){	// Se a pasta de rodada contem arquivo com o nome do aluno SEM ESPAÇOS, pois o nome dos relatorios não possuem espaços
			return true;	// retorna true caso contenha o nome do aluno em arquivo
		}
		else{
			return false;	// retorna false caso não contenha o nome do aluno em arquivo
		}
	}
	
	public void enviarRelatorioCompCentral(Path caminho){
		try{
			Path caminhoCompCentral = Paths.get("\\\\"+nomeComputadorCentral+"\\Jogo Interativo Tabela Periódica\\Histórico\\"+this.aluno.getAno()+"\\"+this.aluno.getAnoJogado()+"\\"+this.aluno.getMes()+"\\"+this.aluno.getDia()+"\\"+this.aluno.getNomeEscola());
			if(caminhoCompCentral.toFile().exists()==true){
				String[] aux = caminhoCompCentral.toFile().list();
				ArrayList<String> turmas = new ArrayList<String>();
				for(int i = 0; i<aux.length;i++)	//Capturar somente o nome de pastas com exceção se contiver '.'
				{
					if(aux[i].contains(".")==false){	//Captura o nome das subpastas de TURMAS
						turmas.add(aux[i]);
					}
				}
				caminhoCompCentral = Paths.get("\\\\"+nomeComputadorCentral+"\\Jogo Interativo Tabela Periódica\\Histórico\\"+this.aluno.getAno()+"\\"+this.aluno.getAnoJogado()+"\\"+this.aluno.getMes()+"\\"+this.aluno.getDia()+"\\"+this.aluno.getNomeEscola()+"\\"+turmas.get(turmas.size()-1));
				if(caminhoCompCentral.toFile().exists()==true){
					aux = caminhoCompCentral.toFile().list();
					ArrayList<String> rodadas = new ArrayList<String>();
					for(int i = 0; i<aux.length;i++)	//Capturar somente o nome de pastas com exceção se contiver '.'
					{
						if(aux[i].contains(".")==false){	//Captura o nome das subpastas de RODADAS
							rodadas.add(aux[i]);
						}
					}
					caminhoCompCentral = Paths.get("\\\\"+nomeComputadorCentral+"\\Jogo Interativo Tabela Periódica\\Histórico\\"+this.aluno.getAno()+"\\"+this.aluno.getAnoJogado()+"\\"+this.aluno.getMes()+"\\"+this.aluno.getDia()+"\\"+this.aluno.getNomeEscola()+"\\"+turmas.get(turmas.size()-1)+"\\"+rodadas.get(rodadas.size()-1)+"\\"+this.aluno.getNome().replaceAll(" ", "")+".txt");
					Files.copy(caminho, caminhoCompCentral);	//Responsável por copiar o arquivo de caminho para a pasta do computador central
				}
				else{
					System.out.println("Não existe a pasta da Rodada na pasta do pc central");
				}
			}
			else{
				System.out.println("Não existe a pasta da Turma na pasta do pc central");
			}
			
		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println("Não conseguiu enviar o relatório");
		}
	}
	
	public void Respostas(){
		int contador = 0;
		while(contador<10){
			status[contador] = new JLabel();
			status[contador].setBackground(corFundo);
			status[contador].setFont(fonteStatus);
			if(this.aluno.getResposta(contador)==true){
				status[contador].setText("Correta");
				status[contador].setOpaque(true);
				status[contador].setForeground(corCorreta);
			}
			else if(this.aluno.getResposta(contador)==false){
				status[contador].setText("Errada");
				status[contador].setOpaque(true);
				status[contador].setForeground(corErrada);
			}
			janela.add(status[contador]);
			contador++;
		}
		status[0].setBounds(182,(150+26*0), 70, 13);
		status[1].setBounds(182,(150+26*1), 70, 13);
		status[2].setBounds(182,(150+26*2), 70, 13);
		status[3].setBounds(182,(150+26*3), 70, 13);
		status[4].setBounds(182,(151+26*4), 70, 13);
		status[5].setBounds(182,(150+26*5), 70, 13);
		status[6].setBounds(182,(150+26*6), 70, 13);
		status[7].setBounds(182,(151+26*7), 70, 13);
		status[8].setBounds(182,(152+26*8), 70, 13);
		status[9].setBounds(191,(153+26*9), 70, 13);
	}
	
	public void botaoSair(){
		sair.setBounds(82, 426, 60, 28);
		sair.setBackground(new Color(173, 252, 205));
		sair.setFont(fonteStatus);
		sair.setOpaque(true);
		sair.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		sair.addActionListener(this);
		janela.add(sair);
	}
	
	public void setJanela(){
		janela.setTitle("Obrigado por ter jogado!");
		janela.setLayout(null);
		janela.setSize(800,500);
		janela.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		janela.setLocationRelativeTo(null);
		janela.setResizable(false);
		janela.setVisible(true);
		janela.addWindowListener(Window);
	}
	
	public void setFundo(){
		fundo.setIcon(imagemFundo);
		fundo.setBounds(0, 0, 794, 471);
		janela.add(fundo);
	}
	
	public void setPerguntas(){
		nomeAluno.setBounds(143, 107, 420, 15);
		nomeAluno.setText(this.aluno.getNome());
		nomeAluno.setFont(fonteStatus);
		janela.add(nomeAluno);
	}
	
	WindowListener Window = new WindowAdapter() 
	{  
	    public void windowClosing( WindowEvent e )  
	    {  
	    	int num = JOptionPane.showConfirmDialog(null, "Deseja finalizar?", "certeza?", JOptionPane.YES_NO_CANCEL_OPTION);
	    	if(num == JOptionPane.YES_OPTION){
	    		System.exit(0);
	    	}
	    }  
	};
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==sair){
			janela.dispose();
			JanelaPrincipal jp = new JanelaPrincipal(nomeComputadorCentral);
		}
	}
}