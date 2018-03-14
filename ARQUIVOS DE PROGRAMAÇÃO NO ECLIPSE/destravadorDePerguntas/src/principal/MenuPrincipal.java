package principal;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MenuPrincipal implements ActionListener{
	private JFrame janela = new JFrame("Menu Principal");
	private JComboBox<String> comboOpcoes = new JComboBox<String>();
	private JLabel instrucaoMenu = new JLabel("<HTML>Selecione uma das opções no menu abaixo: </HTML>");
	private JButton confirmar = new JButton("Confirmar");
	private Color corFundo = new Color(187, 204, 208);
	private Color corBotoes = new Color(204, 255, 255);
	
	public MenuPrincipal(){
		Botoes();
		ComboBoxDificuldade();
		Janela();
	}
		
	public void Janela(){
		janela.setSize(350, 190);
		janela.setLayout(null);
		janela.getContentPane().setBackground(corFundo);
		janela.setLocationRelativeTo(null);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setResizable(false);
		janela.setVisible(true);
	}
	
	public void Botoes(){
		confirmar.setBounds(110,115,104,20);
		confirmar.addActionListener(this);
		confirmar.setFont(new Font("Georgia", Font.BOLD,12));
		confirmar.setBackground(corBotoes);
		janela.add(confirmar);
	}
	
	public void ComboBoxDificuldade(){
		comboOpcoes.setBounds(95, 65, 140, 25);
		comboOpcoes.addItem("Iniciar");
		comboOpcoes.addItem("Tabela Periódica");
		comboOpcoes.addItem("Relatório dos jogadores");
		comboOpcoes.setSelectedItem(null);
		comboOpcoes.addActionListener(this);
		comboOpcoes.setBackground(corBotoes);
		comboOpcoes.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		instrucaoMenu.setBounds(19, 20, 325, 25);
		instrucaoMenu.setFont(new Font("Arial", Font.BOLD, 15));
		janela.add(instrucaoMenu);
		janela.add(comboOpcoes);
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==confirmar){
			if(comboOpcoes.getSelectedIndex()==0){
				Menus m = new Menus();
				janela.dispose();
			}
			else if(comboOpcoes.getSelectedIndex()==1){
				TabelaPeriodica tp = new TabelaPeriodica();
			}
			else if(comboOpcoes.getSelectedIndex()==2){
				RelatorioJogadoresAuxiliar m = new RelatorioJogadoresAuxiliar(janela);
			}
		}
		
		if(e.getSource()==comboOpcoes){}
	}
}
