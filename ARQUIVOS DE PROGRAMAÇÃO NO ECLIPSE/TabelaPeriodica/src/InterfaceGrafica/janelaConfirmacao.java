package InterfaceGrafica;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class janelaConfirmacao extends Thread implements ActionListener{
		private JFrame janelaAcerto = new JFrame("Resultado!");
		private JFrame janelaErro = new JFrame("Resultado!");
		private JFrame janelaAtrasado = new JFrame("Resultado!");
		private ImageIcon imagemQuarkTriste = new ImageIcon(getClass().getResource("/imagens/imagensQuark/QuarkTriste.png"));
		private ImageIcon imagemQuarkFeliz = new ImageIcon(getClass().getResource("/imagens/imagensQuark/QuarkFeliz.png"));
		private JLabel quarkTriste = new JLabel();
		private JLabel quarkFeliz = new JLabel();
		private JButton botaoOkAcerto = new JButton("OK");
		private JButton botaoOkErro = new JButton("OK");
		private JButton botaoOkAtraso = new JButton("OK");
		private JLabel mensagemAcerto = new JLabel();
		private JLabel mensagemErro = new JLabel("<HTML><LEFT>Que pena, sua<br>resposta está errada...<br>Confira a Tabela Periódica para<br>ver a solução.</LEFT></HTML>");
		private JLabel mensagemAtrasado = new JLabel("<HTML>Que pena... Você não respondeu a tempo e outra pergunta foi liberada.</HTML>");
		private Font fonteConfirmacao = new Font("Arial", Font.BOLD, 14);
		
		//Elementos auxiliares para capturar dados da janela das perguntas
		private JFrame janelaAuxiliar;
		private Aluno alunoAux;
		private int bonusAux;
		private Thread liberaPergunta;	//Captura a thread de liberar perguntas nas classes das perguntas
		
		public janelaConfirmacao(JFrame janela, int pontosBonus, Aluno aluno, Thread liberaPergunta, int confirmacao){
			janela.disable();	//Desabilita a janela da pergunta no sentido de não ser clicável e somente ser visível
			this.liberaPergunta = liberaPergunta;
			janelaAuxiliar = janela;	//Para pode posicionar a janela de confirmação conforme a janela da pergunta
			bonusAux = pontosBonus;
			alunoAux = aluno;
			switch(confirmacao){	//Abre a janela de erro/acerto/atrasado conforme o indice determinado
				case 0:
					setJanelaAcerto();
					break;
				case 1:
					setJanelaErro();
					break;
				case 2:
					setJanelaAtrasado();
					break;
				default: System.out.println("NENHUM NUMERO DE CONFIRMACAO VALIDO.");
			}
		}
		
		public void itensAcerto(){
			botaoOkAcerto.addActionListener(this);
			botaoOkAcerto.setBounds(10, 122, 58, 24);
			quarkFeliz.setIcon(imagemQuarkFeliz);
			quarkFeliz.setBounds(132, 14, 135, 139);
			mensagemAcerto.setBounds(10, 10, 135, 80);
			System.out.println("FOI ATÉ AQUI");
			mensagemAcerto.setText("<HTML>Resposta correta!<br><LEFT>Pontuação: 200"+ "<br>Bônus: "+ (bonusAux)+"<br>Total: " +(200+bonusAux)+ "</LEFT></HTML>");
			mensagemAcerto.setFont(fonteConfirmacao);
			janelaAcerto.add(quarkFeliz);
			janelaAcerto.add(botaoOkAcerto);
			janelaAcerto.add(mensagemAcerto);
		}
		
		public void itensErro(){
			botaoOkErro.addActionListener(this);
			botaoOkErro.setBounds(10, 107, 58, 24);
			quarkTriste.setIcon(imagemQuarkTriste);
			quarkTriste.setBounds(155, 14, 118, 139);
			mensagemErro.setBounds(10, 10, 160, 90);
			mensagemErro.setFont(fonteConfirmacao);
			janelaErro.add(quarkTriste);
			janelaErro.add(botaoOkErro);
			janelaErro.add(mensagemErro);
		}
		
		public void itensAtrasado(){
			botaoOkAtraso.addActionListener(this);
			botaoOkAtraso.setBounds(10, 107, 58, 24);
			quarkTriste.setIcon(imagemQuarkTriste);
			quarkTriste.setBounds(155, 14, 118, 139);
			mensagemAtrasado.setBounds(10, 10, 160, 90);
			mensagemAtrasado.setFont(fonteConfirmacao);
			janelaAtrasado.add(quarkTriste);
			janelaAtrasado.add(botaoOkAtraso);
			janelaAtrasado.add(mensagemAtrasado);
		}
		
		public void setJanelaAcerto(){
			janelaAcerto.setAlwaysOnTop(true);	//Mantém sempre em evidência na janela
			janelaAcerto.setSize(278, 182);
			janelaAcerto.setLayout(null);
			janelaAcerto.getContentPane().setBackground(new Color(187,204,208));
			janelaAcerto.setLocation(janelaAuxiliar.getX()+420,janelaAuxiliar.getY()+254);
			janelaAcerto.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			janelaAcerto.setResizable(false);
			itensAcerto();
			janelaAcerto.setVisible(true);
		}
		
		public void setJanelaErro(){
			janelaErro.setAlwaysOnTop(true);	//Mantém sempre em evidência na janela
			janelaErro.setSize(278, 182);
			janelaErro.setLayout(null);
			janelaErro.getContentPane().setBackground(new Color(187,204,208));
			janelaErro.setLocation(janelaAuxiliar.getX()+420,janelaAuxiliar.getY()+254);
			janelaErro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//JFrame.DO_NOTHING_ON_CLOSE
			janelaErro.setResizable(false);
			itensErro();
			janelaErro.setVisible(true);
		}
		
		public void setJanelaAtrasado(){
			janelaAtrasado.setAlwaysOnTop(true);	//Mantém sempre em evidência na janela
			janelaAtrasado.setSize(278, 182);
			janelaAtrasado.setLayout(null);
			janelaAtrasado.getContentPane().setBackground(new Color(187,204,208));
			janelaAtrasado.setLocation(janelaAuxiliar.getX()+420,janelaAuxiliar.getY()+254);
			janelaAtrasado.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//JFrame.DO_NOTHING_ON_CLOSE)
			janelaAtrasado.setResizable(false);
			itensAtrasado();
			janelaAtrasado.setVisible(true);
		}
		
		public void actionPerformed(ActionEvent e){
			if(e.getSource()==botaoOkAcerto){
				liberaPergunta.start();
				janelaAcerto.dispose();
			}
			if(e.getSource()==botaoOkErro){
				liberaPergunta.start();		//A Thread deve iniciar antes da janela fechar para que os elementos da Thread apareçam na janela
				janelaErro.dispose();
			}
			if(e.getSource()==botaoOkAtraso){
				liberaPergunta.start();
				janelaAtrasado.dispose();
			}
		}
		
		public void run(){
		}
	}