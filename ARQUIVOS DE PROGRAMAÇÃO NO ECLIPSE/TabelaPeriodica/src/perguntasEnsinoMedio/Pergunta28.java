package perguntasEnsinoMedio;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.Timer;
import javax.swing.TransferHandler;

import InterfaceGrafica.Aluno;
import InterfaceGrafica.AuxSortearPerguntaEnsinoMedio;

public class Pergunta28 implements ActionListener{
	
	//Pergunta: Coloque no tubo de ensaio dois metais alcalinos.
	
	//ELEMENTOS QUÍMICOS

	// Familia 1A
	private JLabel H = new JLabel();
	private JLabel Li = new JLabel();
	private JLabel Na = new JLabel();
	private JLabel K = new JLabel();
	private JLabel Rb = new JLabel();
	private JLabel Cs = new JLabel();
	private JLabel Fr = new JLabel();

	// Familia 2A
	private JLabel Be = new JLabel();
	private JLabel Mg = new JLabel();
	private JLabel Ca = new JLabel();
	private JLabel Sr = new JLabel();
	private JLabel Ba = new JLabel();
	private JLabel Ra = new JLabel();

	// Coluna 3B
	private JLabel Sc = new JLabel();
	private JLabel Y = new JLabel();
	private JLabel ligador = new JLabel();

	// Coluna 4B
	private JLabel Ti = new JLabel();
	private JLabel Zr = new JLabel();
	private JLabel Hf = new JLabel();
	private JLabel Rf = new JLabel();

	// Coluna 5B
	private JLabel V = new JLabel();
	private JLabel Nb = new JLabel();
	private JLabel Ta = new JLabel();
	private JLabel Db = new JLabel();

	// Coluna 6B
	private JLabel Cr = new JLabel();
	private JLabel Mo = new JLabel();
	private JLabel W = new JLabel();
	private JLabel Sg = new JLabel();

	// Coluna 7B
	private JLabel Mn = new JLabel();
	private JLabel Tc = new JLabel();
	private JLabel Re = new JLabel();
	private JLabel Bh = new JLabel();

	// Coluna 8B(ocupa 3 filas de elementos)
	// fila 1
	private JLabel Fe = new JLabel();
	private JLabel Ru = new JLabel();
	private JLabel Os = new JLabel();
	private JLabel Hs = new JLabel();
	// fila 2
	private JLabel Co = new JLabel();
	private JLabel Rh = new JLabel();
	private JLabel Ir = new JLabel();
	private JLabel Mt = new JLabel();
	// fila 3
	private JLabel Ni = new JLabel();
	private JLabel Pd = new JLabel();
	private JLabel Pt = new JLabel();
	private JLabel Ds = new JLabel();

	// Coluna 1B
	private JLabel Cu = new JLabel();
	private JLabel Ag = new JLabel();
	private JLabel Au = new JLabel();
	private JLabel Rg = new JLabel();

	// Coluna 2B
	private JLabel Zn = new JLabel();
	private JLabel Cd = new JLabel();
	private JLabel Hg = new JLabel();
	private JLabel Cn = new JLabel();

	// Família 3A
	private JLabel B = new JLabel();
	private JLabel Al = new JLabel();
	private JLabel Ga = new JLabel();
	private JLabel In = new JLabel();
	private JLabel Tl = new JLabel();
	private JLabel Uut = new JLabel();

	// Família 4A
	private JLabel C = new JLabel();
	private JLabel Si = new JLabel();
	private JLabel Ge = new JLabel();
	private JLabel Sn = new JLabel();
	private JLabel Pb = new JLabel();
	private JLabel Fl = new JLabel();

	// Família 5A
	private JLabel N = new JLabel();
	private JLabel P = new JLabel();
	private JLabel As = new JLabel();
	private JLabel Sb = new JLabel();
	private JLabel Bi = new JLabel();
	private JLabel Uup = new JLabel();

	// Família 6A
	private JLabel O = new JLabel();
	private JLabel S = new JLabel();
	private JLabel Se = new JLabel();
	private JLabel Te = new JLabel();
	private JLabel Po = new JLabel();
	private JLabel Lv = new JLabel();

	// Família 7A
	private JLabel F = new JLabel();
	private JLabel Cl = new JLabel();
	private JLabel Br = new JLabel();
	private JLabel I = new JLabel();
	private JLabel At = new JLabel();
	private JLabel Uus = new JLabel();

	// Família 8A(Gases Nobre)
	private JLabel He = new JLabel();
	private JLabel Ne = new JLabel();
	private JLabel Ar = new JLabel();
	private JLabel Kr = new JLabel();
	private JLabel Xe = new JLabel();
	private JLabel Rn = new JLabel();
	private JLabel Uuo = new JLabel();

	// Lantanídeos
	private JLabel La = new JLabel();
	private JLabel Ce = new JLabel();
	private JLabel Pr = new JLabel();
	private JLabel Nd = new JLabel();
	private JLabel Pm = new JLabel();
	private JLabel Sm = new JLabel();
	private JLabel Eu = new JLabel();
	private JLabel Gd = new JLabel();
	private JLabel Tb = new JLabel();
	private JLabel Dy = new JLabel();
	private JLabel Ho = new JLabel();
	private JLabel Er = new JLabel();
	private JLabel Tm = new JLabel();
	private JLabel Yb = new JLabel();
	private JLabel Lu = new JLabel();

	// Actinídeos
	private JLabel Ac = new JLabel();
	private JLabel Th = new JLabel();
	private JLabel Pa = new JLabel();
	private JLabel U = new JLabel();
	private JLabel Np = new JLabel();
	private JLabel Pu = new JLabel();
	private JLabel Am = new JLabel();
	private JLabel Cm = new JLabel();
	private JLabel Bk = new JLabel();
	private JLabel Cf = new JLabel();
	private JLabel Es = new JLabel();
	private JLabel Fm = new JLabel();
	private JLabel Md = new JLabel();
	private JLabel No = new JLabel();
	private JLabel Lr = new JLabel();
	
	//IMAGENS ELEMENTOS QUÍMICOS COLORIDAS

	// Coluna 1A

	private ImageIcon imagemH = new ImageIcon(getClass().getResource("/imagens/imagensPerguntasElementosColoridos/1 H.jpg"));
	private ImageIcon imagemLi = new ImageIcon(getClass().getResource("/imagens/imagensPerguntasElementosColoridos/3 Li.jpg"));
	private ImageIcon imagemNa = new ImageIcon(getClass().getResource("/imagens/imagensPerguntasElementosColoridos/11 Na.jpg"));
	private ImageIcon imagemK = new ImageIcon(getClass().getResource("/imagens/imagensPerguntasElementosColoridos/19 K.jpg"));
	private ImageIcon imagemRb = new ImageIcon(getClass().getResource("/imagens/imagensPerguntasElementosColoridos/37 Rb.jpg"));
	private ImageIcon imagemCs = new ImageIcon(getClass().getResource("/imagens/imagensPerguntasElementosColoridos/55 Cs.jpg"));
	private ImageIcon imagemFr = new ImageIcon(getClass().getResource("/imagens/imagensPerguntasElementosColoridos/87 Fr.jpg"));
	// Coluna2A
	private ImageIcon imagemBe = new ImageIcon(getClass().getResource("/imagens/imagensPerguntasElementosColoridos/4 Be.jpg"));
	private ImageIcon imagemMg = new ImageIcon(getClass().getResource("/imagens/imagensPerguntasElementosColoridos/12 Mg.jpg"));
	private ImageIcon imagemCa = new ImageIcon(getClass().getResource("/imagens/imagensPerguntasElementosColoridos/20 Ca.jpg"));
	private ImageIcon imagemSr = new ImageIcon(getClass().getResource("/imagens/imagensPerguntasElementosColoridos/38 Sr.jpg"));
	private ImageIcon imagemBa = new ImageIcon(getClass().getResource("/imagens/imagensPerguntasElementosColoridos/56 Ba.jpg"));
	private ImageIcon imagemRa = new ImageIcon(getClass().getResource("/imagens/imagensPerguntasElementosColoridos/88 Ra.jpg"));
	// Coluna 3B
	private ImageIcon imagemSc = new ImageIcon(getClass().getResource("/imagens/imagensPerguntasElementosColoridos/21 Sc.jpg"));
	private ImageIcon imagemY = new ImageIcon(getClass().getResource("/imagens/imagensPerguntasElementosColoridos/39 Y.jpg"));
	private ImageIcon imagemLigador = new ImageIcon(getClass().getResource("/imagens/imagensPerguntasElementosColoridos/57-71 89-103.jpg"));
	// Coluna 4B
	private ImageIcon imagemTi = new ImageIcon(getClass().getResource("/imagens/imagensPerguntasElementosColoridos/22 Ti.jpg"));
	private ImageIcon imagemZr = new ImageIcon(getClass().getResource("/imagens/imagensPerguntasElementosColoridos/40 Zr.jpg"));
	private ImageIcon imagemHf = new ImageIcon(getClass().getResource("/imagens/imagensPerguntasElementosColoridos/72 Hf.jpg"));
	private ImageIcon imagemRf = new ImageIcon(getClass().getResource("/imagens/imagensPerguntasElementosColoridos/104 Rf.jpg"));
	// Coluna 5B
	private ImageIcon imagemV = new ImageIcon(getClass().getResource("/imagens/imagensPerguntasElementosColoridos/23 V.jpg"));
	private ImageIcon imagemNb = new ImageIcon(getClass().getResource("/imagens/imagensPerguntasElementosColoridos/41 Nb.jpg"));
	private ImageIcon imagemTa = new ImageIcon(getClass().getResource("/imagens/imagensPerguntasElementosColoridos/73 Ta.jpg"));
	private ImageIcon imagemDb = new ImageIcon(getClass().getResource("/imagens/imagensPerguntasElementosColoridos/105 Db.jpg"));
	// Coluna 6B
	private ImageIcon imagemCr = new ImageIcon(getClass().getResource("/imagens/imagensPerguntasElementosColoridos/24 Cr.jpg"));
	private ImageIcon imagemMo = new ImageIcon(getClass().getResource("/imagens/imagensPerguntasElementosColoridos/42 Mo.jpg"));
	private ImageIcon imagemW = new ImageIcon(getClass().getResource("/imagens/imagensPerguntasElementosColoridos/74 W.jpg"));
	private ImageIcon imagemSg = new ImageIcon(getClass().getResource("/imagens/imagensPerguntasElementosColoridos/106 Sg.jpg"));
	// Coluna 7B
	private ImageIcon imagemMn = new ImageIcon(getClass().getResource("/imagens/imagensPerguntasElementosColoridos/25 Mn.jpg"));
	private ImageIcon imagemTc = new ImageIcon(getClass().getResource("/imagens/imagensPerguntasElementosColoridos/43 Tc.jpg"));
	private ImageIcon imagemRe = new ImageIcon(getClass().getResource("/imagens/imagensPerguntasElementosColoridos/75 Re.jpg"));
	private ImageIcon imagemBh = new ImageIcon(getClass().getResource("/imagens/imagensPerguntasElementosColoridos/107 Bh.jpg"));
	// Coluna 8B
	// Fila 1
	private ImageIcon imagemFe = new ImageIcon(getClass().getResource("/imagens/imagensPerguntasElementosColoridos/26 Fe.jpg"));
	private ImageIcon imagemRu = new ImageIcon(getClass().getResource("/imagens/imagensPerguntasElementosColoridos/44 Ru.jpg"));
	private ImageIcon imagemOs = new ImageIcon(getClass().getResource("/imagens/imagensPerguntasElementosColoridos/76 Os.jpg"));
	private ImageIcon imagemHs = new ImageIcon(getClass().getResource("/imagens/imagensPerguntasElementosColoridos/108 Hs.jpg"));

	// Fila 2
	private ImageIcon imagemCo = new ImageIcon(getClass().getResource("/imagens/imagensPerguntasElementosColoridos/27 Co.jpg"));
	private ImageIcon imagemRh = new ImageIcon(getClass().getResource("/imagens/imagensPerguntasElementosColoridos/45 Rh.jpg"));
	private ImageIcon imagemIr = new ImageIcon(getClass().getResource("/imagens/imagensPerguntasElementosColoridos/77 Ir.jpg"));
	private ImageIcon imagemMt = new ImageIcon(getClass().getResource("/imagens/imagensPerguntasElementosColoridos/109 Mt.jpg"));

	// Fila 3
	private ImageIcon imagemNi = new ImageIcon(getClass().getResource("/imagens/imagensPerguntasElementosColoridos/28 Ni.jpg"));
	private ImageIcon imagemPd = new ImageIcon(getClass().getResource("/imagens/imagensPerguntasElementosColoridos/46 Pd.jpg"));
	private ImageIcon imagemPt = new ImageIcon(getClass().getResource("/imagens/imagensPerguntasElementosColoridos/78 Pt.jpg"));
	private ImageIcon imagemDs = new ImageIcon(getClass().getResource("/imagens/imagensPerguntasElementosColoridos/110 Ds.jpg"));

	// Coluna 1B
	private ImageIcon imagemCu = new ImageIcon(getClass().getResource("/imagens/imagensPerguntasElementosColoridos/29 Cu.jpg"));
	private ImageIcon imagemAg = new ImageIcon(getClass().getResource("/imagens/imagensPerguntasElementosColoridos/47 Ag.jpg"));
	private ImageIcon imagemAu = new ImageIcon(getClass().getResource("/imagens/imagensPerguntasElementosColoridos/79 Au.jpg"));
	private ImageIcon imagemRg = new ImageIcon(getClass().getResource("/imagens/imagensPerguntasElementosColoridos/111 Rg.jpg"));

	// Coluna 2B
	private ImageIcon imagemZn = new ImageIcon(getClass().getResource("/imagens/imagensPerguntasElementosColoridos/30 Zn.jpg"));
	private ImageIcon imagemCd = new ImageIcon(getClass().getResource("/imagens/imagensPerguntasElementosColoridos/48 Cd.jpg"));
	private ImageIcon imagemHg = new ImageIcon(getClass().getResource("/imagens/imagensPerguntasElementosColoridos/80 Hg.jpg"));
	private ImageIcon imagemCn = new ImageIcon(getClass().getResource("/imagens/imagensPerguntasElementosColoridos/112 Cn.jpg"));

	// Familia 3A
	private ImageIcon imagemB = new ImageIcon(getClass().getResource("/imagens/imagensPerguntasElementosColoridos/5 B.jpg"));
	private ImageIcon imagemAl = new ImageIcon(getClass().getResource("/imagens/imagensPerguntasElementosColoridos/13 Al.jpg"));
	private ImageIcon imagemGa = new ImageIcon(getClass().getResource("/imagens/imagensPerguntasElementosColoridos/31 Ga.jpg"));
	private ImageIcon imagemIn = new ImageIcon(getClass().getResource("/imagens/imagensPerguntasElementosColoridos/49 In.jpg"));
	private ImageIcon imagemTl = new ImageIcon(getClass().getResource("/imagens/imagensPerguntasElementosColoridos/81 Tl.jpg"));
	private ImageIcon imagemUut = new ImageIcon(getClass().getResource("/imagens/imagensPerguntasElementosColoridos/113 Uut.jpg"));

	// Familia 4A
	private ImageIcon imagemC = new ImageIcon(getClass().getResource("/imagens/imagensPerguntasElementosColoridos/6 C.jpg"));
	private ImageIcon imagemSi = new ImageIcon(getClass().getResource("/imagens/imagensPerguntasElementosColoridos/14 Si.jpg"));
	private ImageIcon imagemGe = new ImageIcon(getClass().getResource("/imagens/imagensPerguntasElementosColoridos/32 Ge.jpg"));
	private ImageIcon imagemSn = new ImageIcon(getClass().getResource("/imagens/imagensPerguntasElementosColoridos/50 Sn.jpg"));
	private ImageIcon imagemPb = new ImageIcon(getClass().getResource("/imagens/imagensPerguntasElementosColoridos/82 Pb.jpg"));
	private ImageIcon imagemFl = new ImageIcon(getClass().getResource("/imagens/imagensPerguntasElementosColoridos/114 Fl.jpg"));

	// Familia 5A
	private ImageIcon imagemN = new ImageIcon(getClass().getResource("/imagens/imagensPerguntasElementosColoridos/7 N.jpg"));
	private ImageIcon imagemP = new ImageIcon(getClass().getResource("/imagens/imagensPerguntasElementosColoridos/15 P.jpg"));
	private ImageIcon imagemAs = new ImageIcon(getClass().getResource("/imagens/imagensPerguntasElementosColoridos/33 As.jpg"));
	private ImageIcon imagemSb = new ImageIcon(getClass().getResource("/imagens/imagensPerguntasElementosColoridos/51 Sb.jpg"));
	private ImageIcon imagemBi = new ImageIcon(getClass().getResource("/imagens/imagensPerguntasElementosColoridos/83 Bi.jpg"));
	private ImageIcon imagemUup = new ImageIcon(getClass().getResource("/imagens/imagensPerguntasElementosColoridos/115 Uup.jpg"));

	// Familia 6A
	private ImageIcon imagemO = new ImageIcon(getClass().getResource("/imagens/imagensPerguntasElementosColoridos/8 O.jpg"));
	private ImageIcon imagemS = new ImageIcon(getClass().getResource("/imagens/imagensPerguntasElementosColoridos/16 S.jpg"));
	private ImageIcon imagemSe = new ImageIcon(getClass().getResource("/imagens/imagensPerguntasElementosColoridos/34 Se.jpg"));
	private ImageIcon imagemTe = new ImageIcon(getClass().getResource("/imagens/imagensPerguntasElementosColoridos/52 Te.jpg"));
	private ImageIcon imagemPo = new ImageIcon(getClass().getResource("/imagens/imagensPerguntasElementosColoridos/84 Po.jpg"));
	private ImageIcon imagemLv = new ImageIcon(getClass().getResource("/imagens/imagensPerguntasElementosColoridos/116 Lv.jpg"));

	// Familia 7A
	private ImageIcon imagemF = new ImageIcon(getClass().getResource("/imagens/imagensPerguntasElementosColoridos/9 F.jpg"));
	private ImageIcon imagemCl = new ImageIcon(getClass().getResource("/imagens/imagensPerguntasElementosColoridos/17 Cl.jpg"));
	private ImageIcon imagemBr = new ImageIcon(getClass().getResource("/imagens/imagensPerguntasElementosColoridos/35 Br.jpg"));
	private ImageIcon imagemI = new ImageIcon(getClass().getResource("/imagens/imagensPerguntasElementosColoridos/53 I.jpg"));
	private ImageIcon imagemAt = new ImageIcon(getClass().getResource("/imagens/imagensPerguntasElementosColoridos/85 At.jpg"));
	private ImageIcon imagemUus = new ImageIcon(getClass().getResource("/imagens/imagensPerguntasElementosColoridos/117 Uus.jpg"));

	// Familia 8A
	private ImageIcon imagemHe = new ImageIcon(getClass().getResource("/imagens/imagensPerguntasElementosColoridos/2 He.jpg"));
	private ImageIcon imagemNe = new ImageIcon(getClass().getResource("/imagens/imagensPerguntasElementosColoridos/10 Ne.jpg"));
	private ImageIcon imagemAr = new ImageIcon(getClass().getResource("/imagens/imagensPerguntasElementosColoridos/18 Ar.jpg"));
	private ImageIcon imagemKr = new ImageIcon(getClass().getResource("/imagens/imagensPerguntasElementosColoridos/36 Kr.jpg"));
	private ImageIcon imagemXe = new ImageIcon(getClass().getResource("/imagens/imagensPerguntasElementosColoridos/54 Xe.jpg"));
	private ImageIcon imagemRn = new ImageIcon(getClass().getResource("/imagens/imagensPerguntasElementosColoridos/86 Rn.jpg"));
	private ImageIcon imagemUuo = new ImageIcon(getClass().getResource("/imagens/imagensPerguntasElementosColoridos/118 Uuo.jpg"));

	// Lantanideos
	private ImageIcon imagemLa = new ImageIcon(getClass().getResource("/imagens/imagensPerguntasElementosColoridos/57 La.jpg"));
	private ImageIcon imagemCe = new ImageIcon(getClass().getResource("/imagens/imagensPerguntasElementosColoridos/58 Ce.jpg"));
	private ImageIcon imagemPr = new ImageIcon(getClass().getResource("/imagens/imagensPerguntasElementosColoridos/59 Pr.jpg"));
	private ImageIcon imagemNd = new ImageIcon(getClass().getResource("/imagens/imagensPerguntasElementosColoridos/60 Nd.jpg"));
	private ImageIcon imagemPm = new ImageIcon(getClass().getResource("/imagens/imagensPerguntasElementosColoridos/61 Pm.jpg"));
	private ImageIcon imagemSm = new ImageIcon(getClass().getResource("/imagens/imagensPerguntasElementosColoridos/62 Sm.jpg"));
	private ImageIcon imagemEu = new ImageIcon(getClass().getResource("/imagens/imagensPerguntasElementosColoridos/63 Eu.jpg"));
	private ImageIcon imagemGd = new ImageIcon(getClass().getResource("/imagens/imagensPerguntasElementosColoridos/64 Gd.jpg"));
	private ImageIcon imagemTb = new ImageIcon(getClass().getResource("/imagens/imagensPerguntasElementosColoridos/65 Tb.jpg"));
	private ImageIcon imagemDy = new ImageIcon(getClass().getResource("/imagens/imagensPerguntasElementosColoridos/66 Dy.jpg"));
	private ImageIcon imagemHo = new ImageIcon(getClass().getResource("/imagens/imagensPerguntasElementosColoridos/67 Ho.jpg"));
	private ImageIcon imagemEr = new ImageIcon(getClass().getResource("/imagens/imagensPerguntasElementosColoridos/68 Er.jpg"));
	private ImageIcon imagemTm = new ImageIcon(getClass().getResource("/imagens/imagensPerguntasElementosColoridos/69 Tm.jpg"));
	private ImageIcon imagemYb = new ImageIcon(getClass().getResource("/imagens/imagensPerguntasElementosColoridos/70 Yb.jpg"));
	private ImageIcon imagemLu = new ImageIcon(getClass().getResource("/imagens/imagensPerguntasElementosColoridos/71 Lu.jpg"));

	// Actinideos
	private ImageIcon imagemAc = new ImageIcon(getClass().getResource("/imagens/imagensPerguntasElementosColoridos/89 Ac.jpg"));
	private ImageIcon imagemTh = new ImageIcon(getClass().getResource("/imagens/imagensPerguntasElementosColoridos/90 Th.jpg"));
	private ImageIcon imagemPa = new ImageIcon(getClass().getResource("/imagens/imagensPerguntasElementosColoridos/91 Pa.jpg"));
	private ImageIcon imagemU = new ImageIcon(getClass().getResource("/imagens/imagensPerguntasElementosColoridos/92 U.jpg"));
	private ImageIcon imagemNp = new ImageIcon(getClass().getResource("/imagens/imagensPerguntasElementosColoridos/93 Np.jpg"));
	private ImageIcon imagemPu = new ImageIcon(getClass().getResource("/imagens/imagensPerguntasElementosColoridos/94 Pu.jpg"));
	private ImageIcon imagemAm = new ImageIcon(getClass().getResource("/imagens/imagensPerguntasElementosColoridos/95 Am.jpg"));
	private ImageIcon imagemCm = new ImageIcon(getClass().getResource("/imagens/imagensPerguntasElementosColoridos/96 Cm.jpg"));
	private ImageIcon imagemBk = new ImageIcon(getClass().getResource("/imagens/imagensPerguntasElementosColoridos/97 Bk.jpg"));
	private ImageIcon imagemCf = new ImageIcon(getClass().getResource("/imagens/imagensPerguntasElementosColoridos/98 Cf.jpg"));
	private ImageIcon imagemEs = new ImageIcon(getClass().getResource("/imagens/imagensPerguntasElementosColoridos/99 Es.jpg"));
	private ImageIcon imagemFm = new ImageIcon(getClass().getResource("/imagens/imagensPerguntasElementosColoridos/100 Fm.jpg"));
	private ImageIcon imagemMd = new ImageIcon(getClass().getResource("/imagens/imagensPerguntasElementosColoridos/101 Md.jpg"));
	private ImageIcon imagemNo = new ImageIcon(getClass().getResource("/imagens/imagensPerguntasElementosColoridos/102 No.jpg"));
	private ImageIcon imagemLr = new ImageIcon(getClass().getResource("/imagens/imagensPerguntasElementosColoridos/103 Lr.jpg"));
	
	//ELEMENTOS DA JANELA
	
	private JLabel fundo = new JLabel();
	private JLabel pergunta = new JLabel();
	private JLabel quark = new JLabel();
	private JLabel resposta1 = new JLabel();
	private JLabel resposta2 = new JLabel();
	private JLabel tuboDeEnsaio = new JLabel();
	private ImageIcon imagemFundo = new ImageIcon(getClass().getResource("/imagens/Fundo.jpg"));
	private ImageIcon imagemPergunta = new ImageIcon(getClass().getResource("/imagens/imagensEnunciados/EnsinoMedio/28.jpg"));
	private ImageIcon imagemQuark = new ImageIcon(getClass().getResource("/imagens/imagensQuark/QuarkNormal.png"));
	private ImageIcon imagemTuboDeEnsaio = new ImageIcon(getClass().getResource("/imagens/TuboDeEnsaio.png"));
	private Font fonte = new Font("Arial Black",Font.BOLD,15);
	private JFrame janela = new JFrame();
		
	//BOTÕES
		
	private JButton responder = new JButton();
	private JButton tabelaConsulta = new JButton();
	private boolean paraThreads = false;	//RESPONSÁVEL POR CAPTURAR SE O USUÁRIO CLICOU NO BOTÃO DE RESPONDER OU SE NÃO RESPONDEU A TEMPO, PARA QUE AS THREADS DEIXEM DE SER EXECUTADAS PARA EVITAR GASTOS DESNECESSÁRIOS
	private ImageIcon imagemResponder = new ImageIcon(getClass().getResource("/imagens/BotãoResponder.jpg"));
	private ImageIcon imagemBotaoTabelaConsulta = new ImageIcon(getClass().getResource("/imagens/BotãoTabelaDeConsulta.png"));
		
	//PONTUAÇÃO
		
	private JLabel escritoPontuacao = new JLabel();
		
	//BÔNUS
		
	private JProgressBar barra = new JProgressBar(0,250);	//Barra de Bônus variando de 100 a 0
	private JPanel painel = new JPanel();	//Pane que armazena a barra
	private int porcentagem = 250;	//Começa no 100 pois a barra e decrescente
	private Timer t;	//Variável que conta a passagem do tempo focando na barra de bônus
	private JLabel tempoParaLeitura = new JLabel();	//Label que exibe o "Tempo de leitura" da pergunta
	private int contadorParaLeitura = 50;	//Contador do tempo de leitura, só será exibido na tela conforme cair 10 unidades
	private int pontosBonus = 250;	//Pontuação inicial de bônus que decairá com o tempo
	private JLabel labelPontosBonus = new JLabel(new String(Integer.toString(pontosBonus)));	//Label que exibe a pontuação Bônus
		
	/**
	 * Status do Jogador - Progresso
	 */
		
	private ImageIcon imagemAcerto;
	private ImageIcon imagemErro;
	private ImageIcon imagemAtual;
	private ImageIcon imagemMarcador;
	private int contRespostas = 0;	//Contador usado para caminhar no vetor de respostas
	private JLabel[] respostas = new JLabel[10];	//Vetor de respostas do usuário para que possa ser construido o status do jogador com base nos erros/acertos
		
	/**
	* Medidor de Level/Questão
	*/

	private JLabel numeroQuestao = new JLabel();
		
	/**
	 * Aluno auxiliar criado para receber os dados do jogador a cada pergunta
	*/
		
	private Aluno aluno;
		
	//Ligado ao Sorteio das perguntas
		
	private Path caminho;	//Captura o caminho onde se encontra o destravador de perguntas
	private DestraveAntesDaHora demorarDemais = new DestraveAntesDaHora();	//Se o usuário demorar para responder e for liberada outra pergunta, para que os usuários caminhem juntos ele terá como errada a pergunta
	private reparadorTabela reparador = new reparadorTabela();	//Thread para reparar os elementos fora de sua posição correta na tabela
	private CorretorTubo corretor = new CorretorTubo();	//Corrige as imagens ao adicionar no tubo de ensaio, pois não podem ter elementos iguais

	/**
	 * Função do Mouse - Copia a imagem dos elementos para outros locais através do TransferHandler
	 */
		
	private MouseListener m1 = new MouseListener() {
		public void mouseClicked(MouseEvent e) {
		}

		public void mouseEntered(MouseEvent e) {
		}

		public void mouseExited(MouseEvent e) {
		}

		public void mousePressed(MouseEvent e) { // captura a imagem quando o botão esquerdo do mouse é segurado, caso queira pesquisar assunto: "Drag and drop em java"
			if(paraThreads==false){	//A Função de mexer nas icons será válida enquanto o usuário não clicar no botão responder ou o destrave não for feito antes, para não "estragar" a tabela 
				JComponent jc = (JComponent) e.getSource();	//Cria um componente auxiliar igualmente ao do elemento selecionado na tabela
				TransferHandler th = jc.getTransferHandler(); // representa o local onde a imagem será dropada
				th.exportAsDrag(jc, e, TransferHandler.COPY); // exporta a copia da imagem pra outro lugar
			}
		}

		public void mouseReleased(MouseEvent e) {
		}
	};
	
	public Pergunta28(InterfaceGrafica.Aluno aluno){
		this.aluno = aluno;	//para poder receber o aluno criado na janela principal do programa ao selecionar o botão do ano e digitar o nome
		caminho = Paths.get("\\\\"+this.aluno.getNomeComputadorCentral()+"\\Jogo interativo Tabela Periódica\\Destravador.txt");
		demorarDemais.start();
		setTimer();
		setJanela();
		setElementosQuimicos();
		setBotoes();
		setRespostas();
		setMedidores();
		setPergunta();
		setBonus();
		setFundo();
		setStatusJogador();
		janela.setVisible(true);
	}
	
	public void setTimer(){	//Procedimento responsável por atribuir o controlador de tempo da barra de bônus e tempo de leitura
		t = new Timer(100, new ActionListener(){	//Forma como o tempo é transmitido na ordem de 1 Décimo de segundo para o Barra de bônus e o tempo para leitura
			public void actionPerformed(ActionEvent e){
			if(contadorParaLeitura>0){	//Contador do Relógio de 5 segundos que seria o tempo de leitura da pergunta
				if((contadorParaLeitura%10)==0){	//Como o tempo decái em Décimos de segundos, então só será exibido o contador cada vez que decair 10 decimos de segundos = 1 segundo
					tempoParaLeitura.setText(new String(Integer.toString((contadorParaLeitura/10))));	//Muda o texto da label do tempo para leitura para o novo tempo
				}
				responder.setEnabled(false);	//Botão responder fica inativo para que o usuário não responder antes de iniciar a contagem do bônus
				contadorParaLeitura--;	//Decrementa o contador de leitura com base no tempo de 1 décimo de segundo mas só é exibido se for divisor de 10 exato
			}
			else{	
			     //1 Décimo de segundo é o tempo de transição das porcertagens da barra de bônus 100 décimos de segundos = 10 segundos para esgotar a barra
				//Isso significa que em 10 segundos ela vai de 100 a 0
				responder.setEnabled(true);    //Reativa o Botão para que o usuário possa responder
				tempoParaLeitura.setVisible(false);	//O Contador do tempo para leitura some
				porcentagem--;  //A porcentagem descresce pois é uma barra de bônus que conforme o usuário demorar para responder menos pontos ele ganhará
				pontosBonus = pontosBonus-1;
				labelPontosBonus.setText(new String(Integer.toString(pontosBonus)));
				barra.setValue(porcentagem);  //Atualiza o valor da barra
				if (porcentagem <= 0) {  //Se a barra atingir zero, o bônus se esgota
					t.stop(); //Para o tempo da barra de bônus
				}
			 }
		  }
		});
		t.start();	//Inicia o tempo do bônus e tempo de leitura
		reparador.start();	//Inicia a Thread responsável por reparar os elementos químicos que estão em mais de uma posição ou têm suas posições trocadas
		corretor.start();	//Inicia o Corretor do tubo de Ensaio que é onde os usuários inserem suas repostas 
	}
	
	WindowListener Window = new WindowAdapter() 
	{  
	    public void windowClosing( WindowEvent e )  
	    {  
	    	int num = JOptionPane.showConfirmDialog(null, "Deseja sair do jogo? mas se sair não poderá jogar enquanto a rodada não terminar.", "Certeza?", JOptionPane.YES_NO_CANCEL_OPTION);
	    	if(num == JOptionPane.YES_OPTION){
	    		System.out.println("FECHANDO");
	    		System.exit(0);
	    	}
	    }  
	};
	
	public void setJanela(){
		janela.setLayout(null);
		janela.setTitle("Pergunta");
		janela.setSize(1030, 626);
		janela.setResizable(false);
		janela.setLocationRelativeTo(null);
		janela.addWindowListener(Window);
		janela.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	}
	
	public void setElementosQuimicos(){
		setDimensoes();
		setImagemElementosQuimicos();
		funcaoMouse();
		transferHandler();
		adicionarElementos();
	}
	
	public void setDimensoes(){
		// Atribuindo dimensões
		// 1A
		H.setBounds(293, 23, 39, 39);
		Li.setBounds(293, 62, 39, 39);
		Na.setBounds(293, 101, 39, 39);
		K.setBounds(293, 140, 39, 39);
		Rb.setBounds(293, 179, 39, 39);
		Cs.setBounds(293, 218, 39, 39);
		Fr.setBounds(293, 257, 39, 39);

		// 2A
		Be.setBounds(332, 62, 39, 39);
		Mg.setBounds(332, 101, 39, 39);
		Ca.setBounds(332, 140, 39, 39);
		Sr.setBounds(332, 179, 39, 39);
		Ba.setBounds(332, 218, 39, 39);
		Ra.setBounds(332, 257, 39, 39);

		// 3B
		Sc.setBounds(371, 140, 39, 39);
		Y.setBounds(371, 179, 39, 39);
		ligador.setBounds(371, 218, 39, 176);

		// 4B
		Ti.setBounds(410, 140, 39, 39);
		Zr.setBounds(410, 179, 39, 39);
		Hf.setBounds(410, 218, 39, 39);
		Rf.setBounds(410, 257, 39, 39);
		// 5B
		V.setBounds(449, 140, 39, 39);
		Nb.setBounds(449, 179, 39, 39);
		Ta.setBounds(449, 218, 39, 39);
		Db.setBounds(449, 257, 39, 39);
		// 6B
		Cr.setBounds(488, 140, 39, 39);
		Mo.setBounds(488, 179, 39, 39);
		W.setBounds(488, 218, 39, 39);
		Sg.setBounds(488, 257, 39, 39);
		// 7B
		Mn.setBounds(527, 140, 39, 39);
		Tc.setBounds(527, 179, 39, 39);
		Re.setBounds(527, 218, 39, 39);
		Bh.setBounds(527, 257, 39, 39);
		// 8B
		// Fila 1
		Fe.setBounds(566, 140, 39, 39);
		Ru.setBounds(566, 179, 39, 39);
		Os.setBounds(566, 218, 39, 39);
		Hs.setBounds(566, 257, 39, 39);
		// Fila 2
		Co.setBounds(605, 140, 39, 39);
		Rh.setBounds(605, 179, 39, 39);
		Ir.setBounds(605, 218, 39, 39);
		Mt.setBounds(605, 257, 39, 39);
		// Fila 3
		Ni.setBounds(644, 140, 39, 39);
		Pd.setBounds(644, 179, 39, 39);
		Pt.setBounds(644, 218, 39, 39);
		Ds.setBounds(644, 257, 39, 39);
		// 1B
		Cu.setBounds(683, 140, 39, 39);
		Ag.setBounds(683, 179, 39, 39);
		Au.setBounds(683, 218, 39, 39);
		Rg.setBounds(683, 257, 39, 39);
		// 2B
		Zn.setBounds(722, 140, 39, 39);
		Cd.setBounds(722, 179, 39, 39);
		Hg.setBounds(722, 218, 39, 39);
		Cn.setBounds(722, 257, 39, 39);
		// 3A
		B.setBounds(761, 62, 39, 39);
		Al.setBounds(761, 101, 39, 39);
		Ga.setBounds(761, 140, 39, 39);
		In.setBounds(761, 179, 39, 39);
		Tl.setBounds(761, 218, 39, 39);
		Uut.setBounds(761, 257, 39, 39);
		// 4A
		C.setBounds(800, 62, 39, 39);
		Si.setBounds(800, 101, 39, 39);
		Ge.setBounds(800, 140, 39, 39);
		Sn.setBounds(800, 179, 39, 39);
		Pb.setBounds(800, 218, 39, 39);
		Fl.setBounds(800, 257, 39, 39);
		// 5A
		N.setBounds(839, 62, 39, 39);
		P.setBounds(839, 101, 39, 39);
		As.setBounds(839, 140, 39, 39);
		Sb.setBounds(839, 179, 39, 39);
		Bi.setBounds(839, 218, 39, 39);
		Uup.setBounds(839, 257, 39, 39);
		// 6A
		O.setBounds(878, 62, 39, 39);
		S.setBounds(878, 101, 39, 39);
		Se.setBounds(878, 140, 39, 39);
		Te.setBounds(878, 179, 39, 39);
		Po.setBounds(878, 218, 39, 39);
		Lv.setBounds(878, 257, 39, 39);
		// 7A
		F.setBounds(917, 62, 39, 39);
		Cl.setBounds(917, 101, 39, 39);
		Br.setBounds(917, 140, 39, 39);
		I.setBounds(917, 179, 39, 39);
		At.setBounds(917, 218, 39, 39);
		Uus.setBounds(917, 257, 39, 39);
		// 8A
		He.setBounds(956, 23, 39, 39);
		Ne.setBounds(956, 62, 39, 39);
		Ar.setBounds(956, 101, 39, 39);
		Kr.setBounds(956, 140, 39, 39);
		Xe.setBounds(956, 179, 39, 39);
		Rn.setBounds(956, 218, 39, 39);
		Uuo.setBounds(956, 257, 39, 39);

		// Lantanideos
		La.setBounds(410, 316, 39, 39);
		Ce.setBounds(449, 316, 39, 39);
		Pr.setBounds(488, 316, 39, 39);
		Nd.setBounds(527, 316, 39, 39);
		Pm.setBounds(566, 316, 39, 39);
		Sm.setBounds(605, 316, 39, 39);
		Eu.setBounds(644, 316, 39, 39);
		Gd.setBounds(683, 316, 39, 39);
		Tb.setBounds(722, 316, 39, 39);
		Dy.setBounds(761, 316, 39, 39);
		Ho.setBounds(800, 316, 39, 39);
		Er.setBounds(839, 316, 39, 39);
		Tm.setBounds(878, 316, 39, 39);
		Yb.setBounds(917, 316, 39, 39);
		Lu.setBounds(956, 316, 39, 39);
		// Actinideos
		Ac.setBounds(410, 355, 39, 39);
		Th.setBounds(449, 355, 39, 39);
		Pa.setBounds(488, 355, 39, 39);
		U.setBounds(527, 355, 39, 39);
		Np.setBounds(566, 355, 39, 39);
		Pu.setBounds(605, 355, 39, 39);
		Am.setBounds(644, 355, 39, 39);
		Cm.setBounds(683, 355, 39, 39);
		Bk.setBounds(722, 355, 39, 39);
		Cf.setBounds(761, 355, 39, 39);
		Es.setBounds(800, 355, 39, 39);
		Fm.setBounds(839, 355, 39, 39);
		Md.setBounds(878, 355, 39, 39);
		No.setBounds(917, 355, 39, 39);
		Lr.setBounds(956, 355, 39, 39);
	}
	
	public void setImagemElementosQuimicos(){
		// Atribuindo imagens
		H.setIcon(imagemH); //Adicionando a imagem do elemento químico como ícone da Label
		Li.setIcon(imagemLi);
		Na.setIcon(imagemNa);
		K.setIcon(imagemK);
		Rb.setIcon(imagemRb);
		Cs.setIcon(imagemCs);
		Fr.setIcon(imagemFr);
		Be.setIcon(imagemBe);
		Mg.setIcon(imagemMg);
		Ca.setIcon(imagemCa);
		Sr.setIcon(imagemSr);
		Ba.setIcon(imagemBa);
		Ra.setIcon(imagemRa);
		Sc.setIcon(imagemSc);
		Y.setIcon(imagemY);
		ligador.setIcon(imagemLigador);
		Ti.setIcon(imagemTi);
		Zr.setIcon(imagemZr);
		Hf.setIcon(imagemHf);
		Rf.setIcon(imagemRf);
		V.setIcon(imagemV);
		Nb.setIcon(imagemNb);
		Ta.setIcon(imagemTa);
		Db.setIcon(imagemDb);
		Cr.setIcon(imagemCr);
		Mo.setIcon(imagemMo);
		W.setIcon(imagemW);
		Sg.setIcon(imagemSg);
		Mn.setIcon(imagemMn);
		Tc.setIcon(imagemTc);
		Re.setIcon(imagemRe);
		Bh.setIcon(imagemBh);
		Fe.setIcon(imagemFe);
		Ru.setIcon(imagemRu);
		Os.setIcon(imagemOs);
		Hs.setIcon(imagemHs);
		Co.setIcon(imagemCo);
		Rh.setIcon(imagemRh);
		Ir.setIcon(imagemIr);
		Mt.setIcon(imagemMt);
		Ni.setIcon(imagemNi);
		Pd.setIcon(imagemPd);
		Pt.setIcon(imagemPt);
		Ds.setIcon(imagemDs);
		Cu.setIcon(imagemCu);
		Ag.setIcon(imagemAg);
		Au.setIcon(imagemAu);
		Rg.setIcon(imagemRg);
		Zn.setIcon(imagemZn);
		Cd.setIcon(imagemCd);
		Hg.setIcon(imagemHg);
		Cn.setIcon(imagemCn);
		B.setIcon(imagemB);
		Al.setIcon(imagemAl);
		Ga.setIcon(imagemGa);
		In.setIcon(imagemIn);
		Tl.setIcon(imagemTl);
		Uut.setIcon(imagemUut);
		C.setIcon(imagemC);
		Si.setIcon(imagemSi);
		Ge.setIcon(imagemGe);
		Sn.setIcon(imagemSn);
		Pb.setIcon(imagemPb);
		Fl.setIcon(imagemFl);
		N.setIcon(imagemN);
		P.setIcon(imagemP);
		As.setIcon(imagemAs);
		Sb.setIcon(imagemSb);
		Bi.setIcon(imagemBi);
		Uup.setIcon(imagemUup);
		O.setIcon(imagemO);
		S.setIcon(imagemS);
		Se.setIcon(imagemSe);
		Te.setIcon(imagemTe);
		Po.setIcon(imagemPo);
		Lv.setIcon(imagemLv);
		F.setIcon(imagemF);
		Cl.setIcon(imagemCl);
		Br.setIcon(imagemBr);
		I.setIcon(imagemI);
		At.setIcon(imagemAt);
		Uus.setIcon(imagemUus);
		He.setIcon(imagemHe);
		Ne.setIcon(imagemNe);
		Ar.setIcon(imagemAr);
		Kr.setIcon(imagemKr);
		Xe.setIcon(imagemXe);
		Rn.setIcon(imagemRn);
		Uuo.setIcon(imagemUuo);
		// Lantanideos
		La.setIcon(imagemLa);
		Ce.setIcon(imagemCe);
		Pr.setIcon(imagemPr);
		Nd.setIcon(imagemNd);
		Pm.setIcon(imagemPm);
		Sm.setIcon(imagemSm);
		Eu.setIcon(imagemEu);
		Gd.setIcon(imagemGd);
		Tb.setIcon(imagemTb);
		Dy.setIcon(imagemDy);
		Ho.setIcon(imagemHo);
		Er.setIcon(imagemEr);
		Tm.setIcon(imagemTm);
		Yb.setIcon(imagemYb);
		Lu.setIcon(imagemLu);
		// Actinideos
		Ac.setIcon(imagemAc);
		Th.setIcon(imagemTh);
		Pa.setIcon(imagemPa);
		U.setIcon(imagemU);
		Np.setIcon(imagemNp);
		Pu.setIcon(imagemPu);
		Am.setIcon(imagemAm);
		Cm.setIcon(imagemCm);
		Bk.setIcon(imagemBk);
		Cf.setIcon(imagemCf);
		Es.setIcon(imagemEs);
		Fm.setIcon(imagemFm);
		Md.setIcon(imagemMd);
		No.setIcon(imagemNo);
		Lr.setIcon(imagemLr);
	}
	
	public void funcaoMouse(){
		// adiciona a função do mouse
		//Familia 1A
		H.addMouseListener(m1);
		Li.addMouseListener(m1);
		Na.addMouseListener(m1);
		K.addMouseListener(m1);
		Rb.addMouseListener(m1);
		Cs.addMouseListener(m1);
		Fr.addMouseListener(m1);
		// Familia 2A
		Be.addMouseListener(m1);
		Mg.addMouseListener(m1);
		Ca.addMouseListener(m1);
		Sr.addMouseListener(m1);
		Ba.addMouseListener(m1);
		Ra.addMouseListener(m1);
		// Coluna 3B
		Sc.addMouseListener(m1);
		Y.addMouseListener(m1);

		// Coluna 4B
		Ti.addMouseListener(m1);
		Zr.addMouseListener(m1);
		Hf.addMouseListener(m1);
		Rf.addMouseListener(m1);

		// Coluna 5B
		V.addMouseListener(m1);
		Nb.addMouseListener(m1);
		Ta.addMouseListener(m1);
		Db.addMouseListener(m1);

		// Coluna 6B
		Cr.addMouseListener(m1);
		Mo.addMouseListener(m1);
		W.addMouseListener(m1);
		Sg.addMouseListener(m1);

		// Coluna 7B
		Mn.addMouseListener(m1);
		Tc.addMouseListener(m1);
		Re.addMouseListener(m1);
		Bh.addMouseListener(m1);

		// Coluna 8B(ocupa 3 filas de elementos)
		// fila 1
		Fe.addMouseListener(m1);
		Ru.addMouseListener(m1);
		Os.addMouseListener(m1);
		Hs.addMouseListener(m1);
		// fila 2
		Co.addMouseListener(m1);
		Rh.addMouseListener(m1);
		Ir.addMouseListener(m1);
		Mt.addMouseListener(m1);
		// fila 3
		Ni.addMouseListener(m1);
		Pd.addMouseListener(m1);
		Pt.addMouseListener(m1);
		Ds.addMouseListener(m1);

		// Coluna 1B
		Cu.addMouseListener(m1);
		Ag.addMouseListener(m1);
		Au.addMouseListener(m1);
		Rg.addMouseListener(m1);

		// Coluna 2B
		Zn.addMouseListener(m1);
		Cd.addMouseListener(m1);
		Hg.addMouseListener(m1);
		Cn.addMouseListener(m1);

		// Família 3A
		B.addMouseListener(m1);
		Al.addMouseListener(m1);
		Ga.addMouseListener(m1);
		In.addMouseListener(m1);
		Tl.addMouseListener(m1);
		Uut.addMouseListener(m1);

		// Família 4A
		C.addMouseListener(m1);
		Si.addMouseListener(m1);
		Ge.addMouseListener(m1);
		Sn.addMouseListener(m1);
		Pb.addMouseListener(m1);
		Fl.addMouseListener(m1);

		// Família 5A
		N.addMouseListener(m1);
		P.addMouseListener(m1);
		As.addMouseListener(m1);
		Sb.addMouseListener(m1);
		Bi.addMouseListener(m1);
		Uup.addMouseListener(m1);

		// Família 6A
		O.addMouseListener(m1);
		S.addMouseListener(m1);
		Se.addMouseListener(m1);
		Te.addMouseListener(m1);
		Po.addMouseListener(m1);
		Lv.addMouseListener(m1);

		// Família 7A
		F.addMouseListener(m1);
		Cl.addMouseListener(m1);
		Br.addMouseListener(m1);
		I.addMouseListener(m1);
		At.addMouseListener(m1);
		Uus.addMouseListener(m1);

		// Família 8A(Gases Nobre)
		He.addMouseListener(m1);
		Ne.addMouseListener(m1);
		Ar.addMouseListener(m1);
		Kr.addMouseListener(m1);
		Xe.addMouseListener(m1);
		Rn.addMouseListener(m1);
		Uuo.addMouseListener(m1);

		// Lantanídeos
		La.addMouseListener(m1);
		Ce.addMouseListener(m1);
		Pr.addMouseListener(m1);
		Nd.addMouseListener(m1);
		Pm.addMouseListener(m1);
		Sm.addMouseListener(m1);
		Eu.addMouseListener(m1);
		Gd.addMouseListener(m1);
		Tb.addMouseListener(m1);
		Dy.addMouseListener(m1);
		Ho.addMouseListener(m1);
		Er.addMouseListener(m1);
		Tm.addMouseListener(m1);
		Yb.addMouseListener(m1);
		Lu.addMouseListener(m1);

		// Actinídeos
		Ac.addMouseListener(m1);
		Th.addMouseListener(m1);
		Pa.addMouseListener(m1);
		U.addMouseListener(m1);
		Np.addMouseListener(m1);
		Pu.addMouseListener(m1);
		Am.addMouseListener(m1);
		Cm.addMouseListener(m1);
		Bk.addMouseListener(m1);
		Cf.addMouseListener(m1);
		Es.addMouseListener(m1);
		Fm.addMouseListener(m1);
		Md.addMouseListener(m1);
		No.addMouseListener(m1);
		Lr.addMouseListener(m1);	
	}
	
	public void transferHandler(){
		// Familia 1A
		H.setTransferHandler(new TransferHandler("icon"));
		Li.setTransferHandler(new TransferHandler("icon"));
		Na.setTransferHandler(new TransferHandler("icon"));
		K.setTransferHandler(new TransferHandler("icon"));
		Rb.setTransferHandler(new TransferHandler("icon"));
		Cs.setTransferHandler(new TransferHandler("icon"));
		Fr.setTransferHandler(new TransferHandler("icon"));
		
		// Familia 2A
		Be.setTransferHandler(new TransferHandler("icon"));
		Mg.setTransferHandler(new TransferHandler("icon"));
		Ca.setTransferHandler(new TransferHandler("icon"));
		Sr.setTransferHandler(new TransferHandler("icon"));
		Ba.setTransferHandler(new TransferHandler("icon"));
		Ra.setTransferHandler(new TransferHandler("icon"));
		
		// Coluna 3B
		Sc.setTransferHandler(new TransferHandler("icon"));
		Y.setTransferHandler(new TransferHandler("icon"));

		// Coluna 4B
		Ti.setTransferHandler(new TransferHandler("icon"));
		Zr.setTransferHandler(new TransferHandler("icon"));
		Hf.setTransferHandler(new TransferHandler("icon"));
		Rf.setTransferHandler(new TransferHandler("icon"));

		// Coluna 5B
		V.setTransferHandler(new TransferHandler("icon"));
		Nb.setTransferHandler(new TransferHandler("icon"));
		Ta.setTransferHandler(new TransferHandler("icon"));
		Db.setTransferHandler(new TransferHandler("icon"));

		// Coluna 6B
		Cr.setTransferHandler(new TransferHandler("icon"));
		Mo.setTransferHandler(new TransferHandler("icon"));
		W.setTransferHandler(new TransferHandler("icon"));
		Sg.setTransferHandler(new TransferHandler("icon"));

		// Coluna 7B
		Mn.setTransferHandler(new TransferHandler("icon"));
		Tc.setTransferHandler(new TransferHandler("icon"));
		Re.setTransferHandler(new TransferHandler("icon"));
		Bh.setTransferHandler(new TransferHandler("icon"));

		// Coluna 8B(ocupa 3 filas de elementos)
		// fila 1
		Fe.setTransferHandler(new TransferHandler("icon"));
		Ru.setTransferHandler(new TransferHandler("icon"));
		Os.setTransferHandler(new TransferHandler("icon"));
		Hs.setTransferHandler(new TransferHandler("icon"));
		// fila 2
		Co.setTransferHandler(new TransferHandler("icon"));
		Rh.setTransferHandler(new TransferHandler("icon"));
		Ir.setTransferHandler(new TransferHandler("icon"));
		Mt.setTransferHandler(new TransferHandler("icon"));
		// fila 3
		Ni.setTransferHandler(new TransferHandler("icon"));
		Pd.setTransferHandler(new TransferHandler("icon"));
		Pt.setTransferHandler(new TransferHandler("icon"));
		Ds.setTransferHandler(new TransferHandler("icon"));

		// Coluna 1B
		Cu.setTransferHandler(new TransferHandler("icon"));
		Ag.setTransferHandler(new TransferHandler("icon"));
		Au.setTransferHandler(new TransferHandler("icon"));
		Rg.setTransferHandler(new TransferHandler("icon"));

		// Coluna 2B
		Zn.setTransferHandler(new TransferHandler("icon"));
		Cd.setTransferHandler(new TransferHandler("icon"));
		Hg.setTransferHandler(new TransferHandler("icon"));
		Cn.setTransferHandler(new TransferHandler("icon"));

		// Família 3A
		B.setTransferHandler(new TransferHandler("icon"));
		Al.setTransferHandler(new TransferHandler("icon"));
		Ga.setTransferHandler(new TransferHandler("icon"));
		In.setTransferHandler(new TransferHandler("icon"));
		Tl.setTransferHandler(new TransferHandler("icon"));
		Uut.setTransferHandler(new TransferHandler("icon"));

		// Família 4A
		C.setTransferHandler(new TransferHandler("icon"));
		Si.setTransferHandler(new TransferHandler("icon"));
		Ge.setTransferHandler(new TransferHandler("icon"));
		Sn.setTransferHandler(new TransferHandler("icon"));
		Pb.setTransferHandler(new TransferHandler("icon"));
		Fl.setTransferHandler(new TransferHandler("icon"));

		// Família 5A
		N.setTransferHandler(new TransferHandler("icon"));
		P.setTransferHandler(new TransferHandler("icon"));
		As.setTransferHandler(new TransferHandler("icon"));
		Sb.setTransferHandler(new TransferHandler("icon"));
		Bi.setTransferHandler(new TransferHandler("icon"));
		Uup.setTransferHandler(new TransferHandler("icon"));

		// Família 6A
		O.setTransferHandler(new TransferHandler("icon"));
		S.setTransferHandler(new TransferHandler("icon"));
		Se.setTransferHandler(new TransferHandler("icon"));
		Te.setTransferHandler(new TransferHandler("icon"));
		Po.setTransferHandler(new TransferHandler("icon"));
		Lv.setTransferHandler(new TransferHandler("icon"));

		// Família 7A
		F.setTransferHandler(new TransferHandler("icon"));
		Cl.setTransferHandler(new TransferHandler("icon"));
		Br.setTransferHandler(new TransferHandler("icon"));
		I.setTransferHandler(new TransferHandler("icon"));
		At.setTransferHandler(new TransferHandler("icon"));
		Uus.setTransferHandler(new TransferHandler("icon"));

		// Família 8A(Gases Nobre)
		He.setTransferHandler(new TransferHandler("icon"));
		Ne.setTransferHandler(new TransferHandler("icon"));
		Ar.setTransferHandler(new TransferHandler("icon"));
		Kr.setTransferHandler(new TransferHandler("icon"));
		Xe.setTransferHandler(new TransferHandler("icon"));
		Rn.setTransferHandler(new TransferHandler("icon"));
		Uuo.setTransferHandler(new TransferHandler("icon"));

		// Lantanídeos
		La.setTransferHandler(new TransferHandler("icon"));
		Ce.setTransferHandler(new TransferHandler("icon"));
		Pr.setTransferHandler(new TransferHandler("icon"));
		Nd.setTransferHandler(new TransferHandler("icon"));
		Pm.setTransferHandler(new TransferHandler("icon"));
		Sm.setTransferHandler(new TransferHandler("icon"));
		Eu.setTransferHandler(new TransferHandler("icon"));
		Gd.setTransferHandler(new TransferHandler("icon"));
		Tb.setTransferHandler(new TransferHandler("icon"));
		Dy.setTransferHandler(new TransferHandler("icon"));
		Ho.setTransferHandler(new TransferHandler("icon"));
		Er.setTransferHandler(new TransferHandler("icon"));
		Tm.setTransferHandler(new TransferHandler("icon"));
		Yb.setTransferHandler(new TransferHandler("icon"));
		Lu.setTransferHandler(new TransferHandler("icon"));

		// Actinídeos
		Ac.setTransferHandler(new TransferHandler("icon"));
		Th.setTransferHandler(new TransferHandler("icon"));
		Pa.setTransferHandler(new TransferHandler("icon"));
		 U.setTransferHandler(new TransferHandler("icon"));
		Np.setTransferHandler(new TransferHandler("icon"));
		Pu.setTransferHandler(new TransferHandler("icon"));
		Am.setTransferHandler(new TransferHandler("icon"));
		Cm.setTransferHandler(new TransferHandler("icon"));
		Bk.setTransferHandler(new TransferHandler("icon"));
		Cf.setTransferHandler(new TransferHandler("icon"));
		Es.setTransferHandler(new TransferHandler("icon"));
		Fm.setTransferHandler(new TransferHandler("icon"));
		Md.setTransferHandler(new TransferHandler("icon"));
		No.setTransferHandler(new TransferHandler("icon"));
		Lr.setTransferHandler(new TransferHandler("icon"));
		
		//CAMPO RESPOSTAS
		//recipiente1
		//recipiente2
		tuboDeEnsaio.setTransferHandler(new TransferHandler("icon"));
	}
	
	public void adicionarElementos(){
		fundo.add(H);
		fundo.add(Li);
		fundo.add(Na);
		fundo.add(K);
		fundo.add(Rb);
		fundo.add(Cs);
		fundo.add(Fr);
		fundo.add(Be);
		fundo.add(Mg);
		fundo.add(Ca);
		fundo.add(Sr);
		fundo.add(Ba);
		fundo.add(Ra);
		fundo.add(Sc);
		fundo.add(Y);
		fundo.add(ligador);
		fundo.add(Ti);
		fundo.add(Zr);
		fundo.add(Hf);
		fundo.add(Rf);
		fundo.add(V);
		fundo.add(Nb);
		fundo.add(Ta);
		fundo.add(Db);
		fundo.add(Cr);
		fundo.add(Mo);
		fundo.add(W);
		fundo.add(Sg);
		fundo.add(Mn);
		fundo.add(Tc);
		fundo.add(Re);
		fundo.add(Bh);
		fundo.add(Fe);
		fundo.add(Ru);
		fundo.add(Os);
		fundo.add(Hs);
		fundo.add(Co);
		fundo.add(Rh);
		fundo.add(Ir);
		fundo.add(Mt);
		fundo.add(Ni);
		fundo.add(Pd);
		fundo.add(Pt);
		fundo.add(Ds);
		fundo.add(Cu);
		fundo.add(Ag);
		fundo.add(Au);
		fundo.add(Rg);
		fundo.add(Zn);
		fundo.add(Cd);
		fundo.add(Hg);
		fundo.add(Cn);
		fundo.add(B);
		fundo.add(Al);
		fundo.add(Ga);
		fundo.add(In);
		fundo.add(Tl);
		fundo.add(Uut);
		fundo.add(C);
		fundo.add(Si);
		fundo.add(Ge);
		fundo.add(Sn);
		fundo.add(Pb);
		fundo.add(Fl);
		fundo.add(N);
		fundo.add(P);
		fundo.add(As);
		fundo.add(Sb);
		fundo.add(Bi);
		fundo.add(Uup);
		fundo.add(O);
		fundo.add(S);
		fundo.add(Se);
		fundo.add(Te);
		fundo.add(Po);
		fundo.add(Lv);
		fundo.add(F);
		fundo.add(Cl);
		fundo.add(Br);
		fundo.add(I);
		fundo.add(At);
		fundo.add(Uus);
		fundo.add(He);
		fundo.add(Ne);
		fundo.add(Ar);
		fundo.add(Kr);
		fundo.add(Xe);
		fundo.add(Rn);
		fundo.add(Uuo);
		fundo.add(La);
		fundo.add(Ce);
		fundo.add(Pr);
		fundo.add(Nd);
		fundo.add(Pm);
		fundo.add(Sm);
		fundo.add(Eu);
		fundo.add(Gd);
		fundo.add(Tb);
		fundo.add(Dy);
		fundo.add(Ho);
		fundo.add(Er);
		fundo.add(Tm);
		fundo.add(Yb);
		fundo.add(Lu);
		fundo.add(Ac);
		fundo.add(Th);
		fundo.add(Pa);
		fundo.add(U);
		fundo.add(Np);
		fundo.add(Pu);
		fundo.add(Am);
		fundo.add(Cm);
		fundo.add(Bk);
		fundo.add(Cf);
		fundo.add(Es);
		fundo.add(Fm);
		fundo.add(Md);
		fundo.add(No);
		fundo.add(Lr);
	}
	
	public void setBotoes(){
		setBotaoConsulta();
		setBotaoResponder();
	}
	
	public void setBotaoConsulta(){
		tabelaConsulta.setBounds(313, 452, 66, 39);
		tabelaConsulta.setIcon(imagemBotaoTabelaConsulta);
		tabelaConsulta.addActionListener(this);
		fundo.add(tabelaConsulta);
	}
	
	public void setBotaoResponder(){
		responder.setBounds(313, 511, 66, 66);
		responder.setIcon(imagemResponder);
		responder.addActionListener(this);
		fundo.add(responder);
	}
	
	public void setRespostas(){
		resposta1.setBounds(629,468, 39, 39);
		resposta2.setBounds(629,512, 39, 39);
		tuboDeEnsaio.setBounds(617,424, 62, 164);
		tuboDeEnsaio.setIcon(imagemTuboDeEnsaio);
		fundo.add(tuboDeEnsaio);
		fundo.add(resposta1);
		fundo.add(resposta2);	
	}
	
	public void setMedidores(){
		setPergunta();
		setMedidorQuestao();
		setMedidorPontos();
	}
	
	public void setMedidorQuestao(){
		numeroQuestao.setFont(fonte);
		numeroQuestao.setText("" + this.aluno.getIndiceDestrave());
		numeroQuestao.setBounds(63, 440, 30, 30);
		fundo.add(numeroQuestao);	
	}
	
	public void setMedidorPontos(){
		escritoPontuacao.setText("" + this.aluno.getPonto());
		escritoPontuacao.setFont(fonte);
		escritoPontuacao.setBounds(175, 524, 80, 20);
		fundo.add(escritoPontuacao);
	}
	
	public void setPergunta(){
		pergunta.setBounds(25, 22, 244,372);
		quark.setBounds(94, 244, 118, 139);
		pergunta.setIcon(imagemPergunta);
		quark.setIcon(imagemQuark);
		fundo.add(quark);
		fundo.add(pergunta);
		
	}
	
	/**
	 * Atribui as características da barra de bônus
	 */
	public void setBonus(){
		painel.setLayout(null);	//Atribui um layout null para o pane que recebe a barra para poder inserir a barra manualmente nela através dos pixels
		barra.setBackground(new Color(189,197,239));	//Troca a cor de fundo da barra enquanto ela está decaindo
		barra.setForeground(new Color(0,100,0));	//Troca a cor da barra de bônus que mostra ela decaindo
		barra.setOpaque(false);	//Torna o fundo da barra transparente
		barra.setBounds(0,0,118,14);
		painel.add(barra);	//Adiciona a barra na Pane conforme a posição descrita acima
		painel.setBounds(145, 554, 118, 14);//Atribuindo as dimensões do pane - Se for menor que a barra, ela aparecerá "cortada"
		tempoParaLeitura.setBounds(180, 447, 12, 18);
		labelPontosBonus.setBounds(100,549,35,25);
		labelPontosBonus.setFont(fonte);	//Troca a fonte utilizada na Label
		tempoParaLeitura.setFont(fonte);
		painel.setOpaque(false);	//Torna o fundo da Pane que suporta a barra de bônus transparente
		fundo.add(tempoParaLeitura);
		fundo.add(painel); 
		fundo.add(labelPontosBonus);
	}
	
	public void setFundo(){
		fundo.setLayout(null);
		fundo.setBounds(0, 0, 1024, 600);
		fundo.setIcon(imagemFundo);
		janela.add(fundo);
	}
	
	/**
	 *	STATUS DO JOGADOR
	 *	Responsável por atribuir o marcador dos acertos, erros ou pergunta atual
	 */
	
	public void setStatusJogador(){
		//this.aluno.setDados();
		boolean verificadorAtual = false; //Tem como objetivo captar a pergunta em que o usuário está 
		while(contRespostas < 10) { 	//Irá ler todo o vetor de respostas do usuário afim de montar o quadro do Progresso/Status dele
			respostas[contRespostas] = new JLabel();	//Constroi primeiro a posição do vetor label de respostas
			if(contRespostas < 5)	//Até a quinta pergunta será inserido em uma linha, a partir daí em uma outra linha
				respostas[contRespostas].setBounds((150 + (contRespostas * 19)), 483, 18, 17);
			else
				respostas[contRespostas].setBounds((150 + ((contRespostas - 5) * 19)), 501, 18, 17);
			
			if(this.aluno.getResposta(contRespostas) != null){	//Se o usuário já respondeu a pergunta a posição será true se acertou ou false se errou
				if(this.aluno.getResposta(contRespostas) == true){	//Se o usuário acertou a pergunta
					imagemAcerto = new ImageIcon(getClass().getResource("/imagens/imagensPerguntasStatusJogador/Acerto-"+(contRespostas+1)+".png"));
					respostas[contRespostas].setIcon(imagemAcerto);
				}	
				else if(aluno.getResposta(contRespostas) == false){ //Se o usuário errou a pergunta
					imagemErro = new ImageIcon(getClass().getResource("/imagens/imagensPerguntasStatusJogador/Erro-"+(contRespostas+1)+".png"));
					respostas[contRespostas].setIcon(imagemErro);
				}
			}
			else{	//Se a posição é null então o usuário ainda não respondeu a pergunta
				if(verificadorAtual == false){	//Se o vericadorAtual for falso significa que a pergunta analisada é a atual
					imagemAtual = new ImageIcon(getClass().getResource("/imagens/imagensPerguntasStatusJogador/Atual-"+(contRespostas+1)+".png"));
					verificadorAtual = true;
					respostas[contRespostas].setIcon(imagemAtual);
				}
				else{
					imagemMarcador = new ImageIcon(getClass().getResource("/imagens/imagensPerguntasStatusJogador/Marcador-"+(contRespostas+1)+".png"));
					respostas[contRespostas].setIcon(imagemMarcador);
				}
			}
			fundo.add(respostas[contRespostas]);
			contRespostas++;
		}
	}
	
	public void exibirRespostas(){
		//Deixar os elementos que não são respostas opacos de modo que realce apenas as respostas
		// Familia 1A
		H.setEnabled(false);
		Li.setEnabled(false);
		Na.setEnabled(false);
		K.setEnabled(false);
		Rb.setEnabled(false);
		Cs.setEnabled(false);
		Fr.setEnabled(false);

		// Familia 2A
		Be.setEnabled(false);
		Mg.setEnabled(false);
		Ca.setEnabled(false);
		Sr.setEnabled(false);
		Ba.setEnabled(false);
		Ra.setEnabled(false);

		// Coluna 3B
		Sc.setEnabled(false);
		Y.setEnabled(false);
		ligador.setEnabled(false);

		// Coluna 4B
		Ti.setEnabled(false);
		Zr.setEnabled(false);
		Hf.setEnabled(false);
		Rf.setEnabled(false);

		// Coluna 5B
		V.setEnabled(false);
		Nb.setEnabled(false);
		Ta.setEnabled(false);
		Db.setEnabled(false);

		// Coluna 6B
		Cr.setEnabled(false);
		Mo.setEnabled(false);
		W.setEnabled(false);
		Sg.setEnabled(false);

		// Coluna 7B
		Mn.setEnabled(false);
		Tc.setEnabled(false);
		Re.setEnabled(false);
		Bh.setEnabled(false);

		// Coluna 8B(ocupa 3 filas de elementos)
		// fila 1
		Fe.setEnabled(false);
		Ru.setEnabled(false);
		Os.setEnabled(false);
		Hs.setEnabled(false);
		// fila 2
		Co.setEnabled(false);
		Rh.setEnabled(false);
		Ir.setEnabled(false);
		Mt.setEnabled(false);
		// fila 3
		Ni.setEnabled(false);
		Pd.setEnabled(false);
		Pt.setEnabled(false);
		Ds.setEnabled(false);

		// Coluna 1B
		Cu.setEnabled(false);
		Ag.setEnabled(false);
		Au.setEnabled(false);
		Rg.setEnabled(false);

		// Coluna 2B
		Zn.setEnabled(false);
		Cd.setEnabled(false);
		Hg.setEnabled(false);
		Cn.setEnabled(false);

		// Família 3A
		B.setEnabled(false);
		Al.setEnabled(false);
		Ga.setEnabled(false);
		In.setEnabled(false);
		Tl.setEnabled(false);
		Uut.setEnabled(false);

		// Família 4A
		C.setEnabled(false);
		Si.setEnabled(false);
		Ge.setEnabled(false);
		Sn.setEnabled(false);
		Pb.setEnabled(false);
		Fl.setEnabled(false);

		// Família 5A
		N.setEnabled(false);
		P.setEnabled(false);
		As.setEnabled(false);
		Sb.setEnabled(false);
		Bi.setEnabled(false);
		Uup.setEnabled(false);

		// Família 6A
		O.setEnabled(false);
		S.setEnabled(false);
		Se.setEnabled(false);
		Te.setEnabled(false);
		Po.setEnabled(false);
		Lv.setEnabled(false);

		// Família 7A
		F.setEnabled(false);
		Cl.setEnabled(false);
		Br.setEnabled(false);
		I.setEnabled(false);
		At.setEnabled(false);
		Uus.setEnabled(false);

		// Família 8A(Gases Nobre)
		He.setEnabled(false);
		Ne.setEnabled(false);
		Ar.setEnabled(false);
		Kr.setEnabled(false);
		Xe.setEnabled(false);
		Rn.setEnabled(false);
		Uuo.setEnabled(false);

		// Lantanídeos
		La.setEnabled(false);
		Ce.setEnabled(false);
		Pr.setEnabled(false);
		Nd.setEnabled(false);
		Pm.setEnabled(false);
		Sm.setEnabled(false);
		Eu.setEnabled(false);
		Gd.setEnabled(false);
		Tb.setEnabled(false);
		Dy.setEnabled(false);
		Ho.setEnabled(false);
		Er.setEnabled(false);
		Tm.setEnabled(false);
		Yb.setEnabled(false);
		Lu.setEnabled(false);

		// Actinídeos
		Ac.setEnabled(false);
		Th.setEnabled(false);
		Pa.setEnabled(false);
		U.setEnabled(false);
		Np.setEnabled(false);
		Pu.setEnabled(false);
		Am.setEnabled(false);
		Cm.setEnabled(false);
		Bk.setEnabled(false);
		Cf.setEnabled(false);
		Es.setEnabled(false);
		Fm.setEnabled(false);
		Md.setEnabled(false);
		No.setEnabled(false);
		Lr.setEnabled(false);
	}

	public void actionPerformed(ActionEvent e){
		if(e.getSource()==tabelaConsulta){
			InterfaceGrafica.TabelaPeriodica tp = new InterfaceGrafica.TabelaPeriodica();
		}
		if(e.getSource()==responder){
			if(resposta1.getIcon()==imagemLi||resposta1.getIcon()==imagemNa||resposta1.getIcon()==imagemK||resposta1.getIcon()==imagemRb||resposta1.getIcon()==imagemCs||resposta1.getIcon()==imagemFr){ 
				t.stop();	//Parar o bônus
				paraThreads = true;
				exibirRespostas();	//Exibe somente as possíveis respostas
				verificadorDeDestraveProximaPergunta liberar = new verificadorDeDestraveProximaPergunta();
				if(resposta2.getIcon()==imagemLi||resposta2.getIcon()==imagemNa||resposta2.getIcon()==imagemK||resposta2.getIcon()==imagemRb||resposta2.getIcon()==imagemCs||resposta2.getIcon()==imagemFr){
					if(pontosBonus>=0){ //Garante que a pontuação adicionada seja sempre positiva ou igual a zero
						this.aluno.setPonto(this.aluno.getPonto()+200+pontosBonus);
						this.aluno.setRegistroPontosPerguntas(200+pontosBonus);
						this.aluno.setResposta(new Boolean(true));
						InterfaceGrafica.janelaConfirmacao janelaConf = new InterfaceGrafica.janelaConfirmacao(janela, pontosBonus, this.aluno, liberar, 0);
					}
				}
				else{	//Caso o usuário errar pelo menos uma das respostas, nesse caso contará como erro total
					this.aluno.setRegistroPontosPerguntas(0);
					this.aluno.setResposta(new Boolean(false));
					InterfaceGrafica.janelaConfirmacao janelaConf = new InterfaceGrafica.janelaConfirmacao(janela, pontosBonus, this.aluno, liberar, 1);
				}
			}
			else{	//Se a 1ª resposta está errada
				t.stop();	//Parar o Bônus
				paraThreads = true;	
				exibirRespostas();
				this.aluno.setRegistroPontosPerguntas(0);
				this.aluno.setResposta(new Boolean(false));
				verificadorDeDestraveProximaPergunta liberar = new verificadorDeDestraveProximaPergunta();
				InterfaceGrafica.janelaConfirmacao janelaConf = new InterfaceGrafica.janelaConfirmacao(janela, pontosBonus, this.aluno, liberar, 1);
			}
		}
	}
	
	
	/**
	 *	ATUALIZEI COM OS NOVOS ELEMENTOS QUÍMICOS INSERIDOS NA TABELA
	 * 	Thread criada para reparar os elementos em posições indevidas ou duplicados devido ao arraste do usuário para sua posição
	 */
	public class reparadorTabela extends Thread{
		Timer t3 = new Timer(10, new ActionListener(){	//Representa 1 décimo de segundo
			public void actionPerformed(ActionEvent e){
				if(paraThreads==false){	//Enquanto o usuário não tiver respondido ou a próxima pergunta não for liberada a correção da tabela será válida, caso contrário a reparação é finalizada para consumir menos processamento
					if(H.getIcon()!=imagemH||Li.getIcon()!=imagemLi||Na.getIcon()!=imagemNa||K.getIcon()!=imagemK||Rb.getIcon()!=imagemRb||Cs.getIcon()!=imagemCs||Fr.getIcon()!=imagemFr||Be.getIcon()!=imagemBe||Mg.getIcon()!=imagemMg||Ca.getIcon()!=imagemCa||Sr.getIcon()!=imagemSr||Ba.getIcon()!=imagemBa||Ra.getIcon()!=imagemRa||Sc.getIcon()!=imagemSc||Y.getIcon()!=imagemY||Ti.getIcon()!=imagemTi||Zr.getIcon()!=imagemZr||Hf.getIcon()!=imagemHf||Rf.getIcon()!=imagemRf||V.getIcon()!=imagemV||Nb.getIcon()!=imagemNb||Ta.getIcon()!=imagemTa||Db.getIcon()!=imagemDb||Cr.getIcon()!=imagemCr||Mo.getIcon()!=imagemMo||W.getIcon()!=imagemW||Sg.getIcon()!=imagemSg
						||Mn.getIcon()!=imagemMn||Tc.getIcon()!=imagemTc||Re.getIcon()!=imagemRe||Bh.getIcon()!=imagemBh||Fe.getIcon()!=imagemFe||Ru.getIcon()!=imagemRu||Os.getIcon()!=imagemOs||Hs.getIcon()!=imagemHs||Co.getIcon()!=imagemCo||Rh.getIcon()!=imagemRh||Ir.getIcon()!=imagemIr||Mt.getIcon()!=imagemMt||Ni.getIcon()!=imagemNi||Pd.getIcon()!=imagemPd||Pt.getIcon()!=imagemPt||Ds.getIcon()!=imagemDs||Cu.getIcon()!=imagemCu||Ag.getIcon()!=imagemAg||Au.getIcon()!=imagemAu||Rg.getIcon()!=imagemRg||Zn.getIcon()!=imagemZn||Cd.getIcon()!=imagemCd||Hg.getIcon()!=imagemHg||Cn.getIcon()!=imagemCn||B.getIcon()!=imagemB||Al.getIcon()!=imagemAl
						||Ga.getIcon()!=imagemGa||In.getIcon()!=imagemIn||Tl.getIcon()!=imagemTl||Uut.getIcon()!=imagemUut||C.getIcon()!=imagemC||Si.getIcon()!=imagemSi||Ge.getIcon()!=imagemGe||Sn.getIcon()!=imagemSn||Pb.getIcon()!=imagemPb||Fl.getIcon()!=imagemFl||N.getIcon()!=imagemN||P.getIcon()!=imagemP||As.getIcon()!=imagemAs||Sb.getIcon()!=imagemSb||Bi.getIcon()!=imagemBi||Uup.getIcon()!=imagemUup||O.getIcon()!=imagemO||S.getIcon()!=imagemS||Se.getIcon()!=imagemSe||Te.getIcon()!=imagemTe||Po.getIcon()!=imagemPo||Lv.getIcon()!=imagemLv||F.getIcon()!=imagemF||Cl.getIcon()!=imagemCl||Br.getIcon()!=imagemBr||I.getIcon()!=imagemI||At.getIcon()!=imagemAt||Uus.getIcon()!=imagemUus||He.getIcon()!=imagemHe||Ne.getIcon()!=imagemNe||Ar.getIcon()!=imagemAr||Kr.getIcon()!=imagemKr
						||Xe.getIcon()!=imagemXe||Rn.getIcon()!=imagemRn||Uuo.getIcon()!=imagemUuo||La.getIcon()!=imagemLa||Ce.getIcon()!=imagemCe||Pr.getIcon()!=imagemPr||Nd.getIcon()!=imagemNd||Pm.getIcon()!=imagemPm||Sm.getIcon()!=imagemSm||Eu.getIcon()!=imagemEu||Gd.getIcon()!=imagemGd||Tb.getIcon()!=imagemTb||Dy.getIcon()!=imagemDy||Ho.getIcon()!=imagemHo||Er.getIcon()!=imagemEr||Tm.getIcon()!=imagemTm||Yb.getIcon()!=imagemYb||Lu.getIcon()!=imagemLu||Ac.getIcon()!=imagemAc||Th.getIcon()!=imagemTh||Pa.getIcon()!=imagemPa||U.getIcon()!=imagemU||Np.getIcon()!=imagemNp||Pu.getIcon()!=imagemPu||Am.getIcon()!=imagemAm||Cm.getIcon()!=imagemCm||Bk.getIcon()!=imagemBk
						||Cf.getIcon()!=imagemCf||Es.getIcon()!=imagemEs||Fm.getIcon()!=imagemFm||Md.getIcon()!=imagemMd||No.getIcon()!=imagemNo||Lr.getIcon()!=imagemLr)
						{
							setImagemElementosQuimicos();
						}
				}
				else{
					parar();
				}
			}
		});
		public void run(){
			t3.start();
		}
		
		public void parar(){
			t3.stop();
		}
	}
	
	public class CorretorTubo extends Thread{
		private JLabel aux = new JLabel(); //Label auxiliar importante, servirá para poder reatribuir a imagem da primeira label e do segundo já tiverem imagem e o aluno queira colocar outras respostas no lugar
		Timer t = new Timer(1, new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(paraThreads==false){	//Enquanto o usuário não tiver respondido ou a próxima pergunta não for liberada, a correção do tubo será válida, caso contrário a correção é finalizada para consumir menos processamento
					if(contadorParaLeitura > 0){	//Se o tempo de leitura for maior que zero significa que nenhuma resposta pode ser atribuida ainda
						resposta1.setIcon(null);
						resposta2.setIcon(null);
						tuboDeEnsaio.setIcon(imagemTuboDeEnsaio);
					}
					else{
						if(tuboDeEnsaio.getIcon()!=imagemTuboDeEnsaio){		//Caso a imagem do tubo seja alterada, ou seja se foi inserida uma resposta
							if(resposta1.getIcon()!=null&&resposta2.getIcon()==null){	//Se foi inserida somente uma resposta
								resposta2.setIcon(tuboDeEnsaio.getIcon());
								tuboDeEnsaio.setIcon(imagemTuboDeEnsaio);
							}
							if(resposta1.getIcon()==null&&resposta2.getIcon()==null){	//Se não foi inserida nenhuma resposta
								resposta1.setIcon(tuboDeEnsaio.getIcon());
								tuboDeEnsaio.setIcon(imagemTuboDeEnsaio);
							}
							if(resposta1.getIcon()!=null&&resposta2.getIcon()!=null){	//Se as duas respostas já foram inseridas
								if(resposta1.getIcon()==resposta2.getIcon()||resposta1.getIcon()==tuboDeEnsaio.getIcon()||resposta2.getIcon()==tuboDeEnsaio.getIcon()){	//Se tentar inserir o mesmo elemento químico 2 vezes
									resposta1.setIcon(null);
									resposta2.setIcon(null);
									tuboDeEnsaio.setIcon(imagemTuboDeEnsaio);
								}
								if(resposta2.getIcon()==tuboDeEnsaio.getIcon()){	//Se o campo da 2ª resposta for igual a inserida no tubo de ensaio
									resposta1.setIcon(tuboDeEnsaio.getIcon());
									resposta2.setIcon(null);
									tuboDeEnsaio.setIcon(imagemTuboDeEnsaio);
								}
								if(resposta1.getIcon()==tuboDeEnsaio.getIcon()){	//Se for tentar inserir a mesma resposta contida no 1ª resposta
									resposta1.setIcon(tuboDeEnsaio.getIcon());
									tuboDeEnsaio.setIcon(imagemTuboDeEnsaio);
								}
								if((resposta1.getIcon()!=resposta2.getIcon())&&(resposta1.getIcon()!=tuboDeEnsaio.getIcon())&&(resposta2.getIcon()!=tuboDeEnsaio.getIcon())&&(tuboDeEnsaio.getIcon()!=imagemTuboDeEnsaio)){	//Se as duas respostas já foram preenchidas mas o usuário quis trocar e inseriu mais um elemento para substituir
									if(aux.getIcon()!=resposta1.getIcon()){	//Se a label auxiliar tiver imagem diferente da resposta 1
										resposta2.setIcon(tuboDeEnsaio.getIcon());
										aux.setIcon(resposta1.getIcon());
									}
									else{
										resposta1.setIcon(tuboDeEnsaio.getIcon());
									}
									tuboDeEnsaio.setIcon(imagemTuboDeEnsaio);
								}
							}
						}
					}	
				}
				else{
					parar();
				}
			}
		});
		
		public void run(){
			t.start();
		}
		
		public void parar(){
			t.stop();
		}
		
	}
	
	public class DestraveAntesDaHora extends Thread{
		private int indice2 = 0; //-> Indice especial para trabalhar nessa thread afim de evitar trabalhar com variavel global e dar problema

		Timer tempoDestraveAntesHora = new Timer(500, new ActionListener(){	//Tempo de análise de 0,5 segundos
			public void actionPerformed(ActionEvent e){
				if(paraThreads==false){	//Caso o botão responder não foi clicado a variável continuará falsa
					if(indice2 <= Pergunta28.this.aluno.getIndiceDestrave()){ 	//Se o indice2 for menor ou igual ao do aluno, significa que está aguardando um novo destrave
						try{	//Tratar excessões existentes
							if(caminho.toFile().exists()){	//Se o arquivo de texto existe com Destravador existe através da rede
								Scanner scan = new Scanner(caminho, "UTF-8");	//Variável de leitura do Arquivo de Texto
								while(scan.hasNextLine()){	//Repetirá enquanto houver linhas a serem lidas
									scan.nextLine(); // vai capturando as strings das linhas, por consequência chega ao final do arquivo e armazena a ultima linha na string s
									indice2++;	//Captura quantas linhas/destravamentos estão no arquivo
								}
								if(indice2 == Pergunta28.this.aluno.getIndiceDestrave()){	//Se os destraves do arquivo estão conforme o do aluno, qualquer outro significa iniciar nova pergunta
									indice2 = 0;	//Zera o indice para que volte a ler o arquivo de texto novamente até verificar a existência de um novo destrave
								}
							}	
						}catch(Exception erro){
							erro.printStackTrace();
							System.out.println("Erro na leitura de arquivos");
						}
					}
					else if(indice2 > Pergunta28.this.aluno.getIndiceDestrave()){	//Se o destrave da próxima pergunta foi feito e o botão responder não foi clicado
						t.stop();
						tempoDestraveAntesHora.stop();
						Pergunta28.this.aluno.setRegistroPontosPerguntas(0);
						Pergunta28.this.aluno.setResposta(new Boolean(false));
						if(Pergunta28.this.aluno.getSizeRegistroPontosPerguntas()<10){
							verificadorDeDestraveProximaPergunta liberar = new verificadorDeDestraveProximaPergunta();										//TESTAR
							InterfaceGrafica.janelaConfirmacao janelaConf = new InterfaceGrafica.janelaConfirmacao(janela, pontosBonus, aluno, liberar, 2);	//TESTAR
						}
						else if(Pergunta28.this.aluno.getSizeRegistroPontosPerguntas()>=10){
							janela.dispose();
							AuxSortearPerguntaEnsinoMedio sort = new AuxSortearPerguntaEnsinoMedio();
							sort.proximaPergunta(Pergunta28.this.aluno);
						}
					}
				}
				else{	//Se o botão responder foi clicado
					tempoDestraveAntesHora.stop();
				}
			}
		});
		
		public void run(){
			tempoDestraveAntesHora.start();
		}
	}
	
	public class verificadorDeDestraveProximaPergunta extends Thread implements ActionListener{	//VERIFICA SE O DESTRAVE FOI FEITO E O ARQUIVO EXISTE
		private JFrame j2 = new JFrame("Aguarde!");
		private JLabel mensagem = new JLabel("Aguarde até a próxima pergunta ser liberada");
		private JLabel imagem = new JLabel(new ImageIcon(getClass().getResource("/imagens/IconeAlerta.png")));
		private Font fonte2 = new Font("Arial",Font.BOLD,12);
		private JButton proxima = new JButton("Próxima");
		private int indice3 = 0; 	//->Indice usado somente na thread para evitar possíveis erros em usar variavel global
		
		Timer t5 = new Timer(1000, new ActionListener(){	//Representa 1 segundo
			public void actionPerformed(ActionEvent e){
				if(indice3 <= Pergunta28.this.aluno.getIndiceDestrave()){
					try{	//esse erro tratado seria caso a URL seja inválida
						if(caminho.toFile().exists()){	//Se o arquivo de texto existe
							Scanner scan = new Scanner(caminho, "UTF-8");	//Variável de leitura do Arquivo de Texto
							while(scan.hasNextLine()){	//Repetirá enquanto houver linhas a serem lidas
								scan.nextLine(); // vai capturando as strings das linhas, por consequência chega ao final do arquivo e armazena a ultima linha na string s
								indice3++;//exibe quantos destravamentos já foram
							}
							if((indice3==10)&&(Pergunta28.this.aluno.getSizePerguntaIndividual()==0)){	//Representa o destrave da ultima pergunta
								t5.stop();
							}
							if(indice3==Pergunta28.this.aluno.getIndiceDestrave()){	//Se o número de destraves do arquivo for equivalente ao do aluno será necessário um novo destrave
								System.out.println("É Necessário um novo destrave");
								indice3=0;
							}
						}	
					}catch(Exception erro){
						erro.printStackTrace();
						System.out.println("Erro na leitura de arquivos");
					}
				}
				else if(indice3 > Pergunta28.this.aluno.getIndiceDestrave()){
					mensagem.setText("Pergunta liberada, clique no botão para prosseguir");
					proxima.setEnabled(true);
					t5.stop();
				}
			}
		});
		
		public void actionPerformed(ActionEvent e){
			if(e.getSource()==proxima){
				janela.dispose();
				j2.dispose();
				AuxSortearPerguntaEnsinoMedio sort = new AuxSortearPerguntaEnsinoMedio();
				sort.proximaPergunta(Pergunta28.this.aluno);
			}
		}

		public void JanelaTransicao(){
			//JANELA
			if(Pergunta28.this.aluno.getSizePerguntaIndividual()>0){	//Enquanto houver perguntas a serem respondidas
				j2.setAlwaysOnTop(true);	//Mantém sempre em evidência na janela
				j2.setSize(510, 128);
				j2.setLayout(null);
				j2.getContentPane().setBackground(new Color(187,204,208));
				j2.setLocation(janela.getX()+242,janela.getY()+254);
				j2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				j2.setResizable(false);
				
				//BOTÃO
				proxima.setBounds(205, 62, 100, 23);
				mensagem.setBounds(121, 28, 300, 15);
				imagem.setBounds(89, 23, 25, 25);
				proxima.setBackground(new Color(144,238,144));
				proxima.setFont(fonte2);
				proxima.setBorder(BorderFactory.createLineBorder(Color.BLACK));
				proxima.addActionListener(this);
				proxima.setEnabled(false);
				j2.add(proxima);
				j2.add(imagem);
				j2.add(mensagem);
				j2.setVisible(true);	//Deixar aqui pois os elementos da janela devem ser adicionados primeiro na janela para que ela possa ser exibida
			}
			else{
				t5.stop();
				janela.dispose();	//Finaliza a janela da pergunta
				AuxSortearPerguntaEnsinoMedio sort = new AuxSortearPerguntaEnsinoMedio();
				sort.proximaPergunta(aluno);
			}
		}
		
		public void run(){
			JanelaTransicao();
			t5.start();
		}
	}
}