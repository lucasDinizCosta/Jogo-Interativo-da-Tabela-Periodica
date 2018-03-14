package InterfaceGrafica;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class TabelaPeriodica implements ActionListener{
	//Inserindo as Imagens-Icones dos Elementos
	//As imagens estão sendo usadas do pacote imagens
	//Especificações
	private ImageIcon imagemEspec = new ImageIcon(getClass().getResource("/imagens/imagensElementosTabelaConsulta/Especificações.PNG"));	
	
	//Coluna 1A
    private ImageIcon imagemH = new ImageIcon(getClass().getResource("/imagens/imagensElementosTabelaConsulta/H.PNG"));
	private ImageIcon imagemLi = new ImageIcon(getClass().getResource("/imagens/imagensElementosTabelaConsulta/Li.PNG"));
	private ImageIcon imagemNa = new ImageIcon(getClass().getResource("/imagens/imagensElementosTabelaConsulta/Na.PNG"));
	private ImageIcon imagemK = new ImageIcon(getClass().getResource("/imagens/imagensElementosTabelaConsulta/K.PNG"));
	private ImageIcon imagemRb = new ImageIcon(getClass().getResource("/imagens/imagensElementosTabelaConsulta/Rb.PNG"));
	private ImageIcon imagemCs = new ImageIcon(getClass().getResource("/imagens/imagensElementosTabelaConsulta/Cs.PNG"));
	private ImageIcon imagemFr = new ImageIcon(getClass().getResource("/imagens/imagensElementosTabelaConsulta/Fr.PNG"));
	//Coluna2A
	private ImageIcon imagemBe = new ImageIcon(getClass().getResource("/imagens/imagensElementosTabelaConsulta/Be.PNG"));
	private ImageIcon imagemMg = new ImageIcon(getClass().getResource("/imagens/imagensElementosTabelaConsulta/Mg.PNG"));
	private ImageIcon imagemCa = new ImageIcon(getClass().getResource("/imagens/imagensElementosTabelaConsulta/Ca.PNG"));
	private ImageIcon imagemSr = new ImageIcon(getClass().getResource("/imagens/imagensElementosTabelaConsulta/Sr.PNG"));
	private ImageIcon imagemBa = new ImageIcon(getClass().getResource("/imagens/imagensElementosTabelaConsulta/Ba.PNG"));
	private ImageIcon imagemRa = new ImageIcon(getClass().getResource("/imagens/imagensElementosTabelaConsulta/Ra.PNG"));
	//Coluna 3B
	private ImageIcon imagemSc = new ImageIcon(getClass().getResource("/imagens/imagensElementosTabelaConsulta/Sc.PNG"));
	private ImageIcon imagemY = new ImageIcon(getClass().getResource("/imagens/imagensElementosTabelaConsulta/Y.PNG"));
	private ImageIcon imagemLantanideos = new ImageIcon(getClass().getResource("/imagens/imagensElementosTabelaConsulta/57-71.PNG"));
	private ImageIcon imagemActinideos = new ImageIcon(getClass().getResource("/imagens/imagensElementosTabelaConsulta/89-103.PNG"));
	//Coluna 4B
	private ImageIcon imagemTi = new ImageIcon(getClass().getResource("/imagens/imagensElementosTabelaConsulta/Ti.PNG"));
	private ImageIcon imagemZr = new ImageIcon(getClass().getResource("/imagens/imagensElementosTabelaConsulta/Zr.PNG"));
	private ImageIcon imagemHf = new ImageIcon(getClass().getResource("/imagens/imagensElementosTabelaConsulta/Hf.PNG"));
	private ImageIcon imagemRf = new ImageIcon(getClass().getResource("/imagens/imagensElementosTabelaConsulta/Rf.PNG"));
	//Coluna 5B
	private ImageIcon imagemV = new ImageIcon(getClass().getResource("/imagens/imagensElementosTabelaConsulta/V.PNG"));
	private ImageIcon imagemNb = new ImageIcon(getClass().getResource("/imagens/imagensElementosTabelaConsulta/Nb.PNG"));
	private ImageIcon imagemTa = new ImageIcon(getClass().getResource("/imagens/imagensElementosTabelaConsulta/Ta.PNG"));
	private ImageIcon imagemDb = new ImageIcon(getClass().getResource("/imagens/imagensElementosTabelaConsulta/Db.PNG"));
	//Coluna 6B
	private ImageIcon imagemCr = new ImageIcon(getClass().getResource("/imagens/imagensElementosTabelaConsulta/Cr.PNG"));
	private ImageIcon imagemMo = new ImageIcon(getClass().getResource("/imagens/imagensElementosTabelaConsulta/Mo.PNG"));
	private ImageIcon imagemW = new ImageIcon(getClass().getResource("/imagens/imagensElementosTabelaConsulta/W.PNG"));
	private ImageIcon imagemSg = new ImageIcon(getClass().getResource("/imagens/imagensElementosTabelaConsulta/Sg.PNG"));
	//Coluna 7B
	private ImageIcon imagemMn = new ImageIcon(getClass().getResource("/imagens/imagensElementosTabelaConsulta/Mn.PNG"));
	private ImageIcon imagemTc = new ImageIcon(getClass().getResource("/imagens/imagensElementosTabelaConsulta/Tc.PNG"));
	private ImageIcon imagemRe = new ImageIcon(getClass().getResource("/imagens/imagensElementosTabelaConsulta/Re.PNG"));
	private ImageIcon imagemBh = new ImageIcon(getClass().getResource("/imagens/imagensElementosTabelaConsulta/Bh.PNG"));
	//Coluna 8B
	//Fila 1
	private ImageIcon imagemFe = new ImageIcon(getClass().getResource("/imagens/imagensElementosTabelaConsulta/Fe.PNG"));
	private ImageIcon imagemRu = new ImageIcon(getClass().getResource("/imagens/imagensElementosTabelaConsulta/Ru.PNG"));
	private ImageIcon imagemOs = new ImageIcon(getClass().getResource("/imagens/imagensElementosTabelaConsulta/Os.PNG"));
	private ImageIcon imagemHs = new ImageIcon(getClass().getResource("/imagens/imagensElementosTabelaConsulta/Hs.PNG"));
	
	//Fila 2
	private ImageIcon imagemCo = new ImageIcon(getClass().getResource("/imagens/imagensElementosTabelaConsulta/Co.PNG"));
	private ImageIcon imagemRh = new ImageIcon(getClass().getResource("/imagens/imagensElementosTabelaConsulta/Rh.PNG"));
	private ImageIcon imagemIr = new ImageIcon(getClass().getResource("/imagens/imagensElementosTabelaConsulta/Ir.PNG"));
	private ImageIcon imagemMt = new ImageIcon(getClass().getResource("/imagens/imagensElementosTabelaConsulta/Mt.PNG"));
	
	//Fila 3
	private ImageIcon imagemNi = new ImageIcon(getClass().getResource("/imagens/imagensElementosTabelaConsulta/Ni.PNG"));
	private ImageIcon imagemPd = new ImageIcon(getClass().getResource("/imagens/imagensElementosTabelaConsulta/Pd.PNG"));
	private ImageIcon imagemPt = new ImageIcon(getClass().getResource("/imagens/imagensElementosTabelaConsulta/Pt.PNG"));
	private ImageIcon imagemDs = new ImageIcon(getClass().getResource("/imagens/imagensElementosTabelaConsulta/Ds.PNG"));
	
	//Coluna 1B
	private ImageIcon imagemCu = new ImageIcon(getClass().getResource("/imagens/imagensElementosTabelaConsulta/Cu.PNG"));
	private ImageIcon imagemAg = new ImageIcon(getClass().getResource("/imagens/imagensElementosTabelaConsulta/Ag.PNG"));
	private ImageIcon imagemAu = new ImageIcon(getClass().getResource("/imagens/imagensElementosTabelaConsulta/Au.PNG"));
	private ImageIcon imagemRg = new ImageIcon(getClass().getResource("/imagens/imagensElementosTabelaConsulta/Rg.PNG"));

	//Coluna 2B
	private ImageIcon imagemZn = new ImageIcon(getClass().getResource("/imagens/imagensElementosTabelaConsulta/Zn.PNG"));
	private ImageIcon imagemCd = new ImageIcon(getClass().getResource("/imagens/imagensElementosTabelaConsulta/Cd.PNG"));
	private ImageIcon imagemHg = new ImageIcon(getClass().getResource("/imagens/imagensElementosTabelaConsulta/Hg.PNG"));
	private ImageIcon imagemCn = new ImageIcon(getClass().getResource("/imagens/imagensElementosTabelaConsulta/Cn.PNG"));
	
	//Familia 3A
	private ImageIcon imagemB = new ImageIcon(getClass().getResource("/imagens/imagensElementosTabelaConsulta/B.PNG"));
	private ImageIcon imagemAl = new ImageIcon(getClass().getResource("/imagens/imagensElementosTabelaConsulta/Al.PNG"));
	private ImageIcon imagemGa = new ImageIcon(getClass().getResource("/imagens/imagensElementosTabelaConsulta/Ga.PNG"));
	private ImageIcon imagemIn = new ImageIcon(getClass().getResource("/imagens/imagensElementosTabelaConsulta/In.PNG"));
	private ImageIcon imagemTl = new ImageIcon(getClass().getResource("/imagens/imagensElementosTabelaConsulta/Tl.PNG"));
	private ImageIcon imagemUut = new ImageIcon(getClass().getResource("/imagens/imagensElementosTabelaConsulta/Uut.PNG"));
	
	//Familia 4A
	private ImageIcon imagemC = new ImageIcon(getClass().getResource("/imagens/imagensElementosTabelaConsulta/C.PNG"));
	private ImageIcon imagemSi = new ImageIcon(getClass().getResource("/imagens/imagensElementosTabelaConsulta/Si.PNG"));
	private ImageIcon imagemGe = new ImageIcon(getClass().getResource("/imagens/imagensElementosTabelaConsulta/Ge.PNG"));
	private ImageIcon imagemSn = new ImageIcon(getClass().getResource("/imagens/imagensElementosTabelaConsulta/Sn.PNG"));
	private ImageIcon imagemPb = new ImageIcon(getClass().getResource("/imagens/imagensElementosTabelaConsulta/Pb.PNG"));
	private ImageIcon imagemFl = new ImageIcon(getClass().getResource("/imagens/imagensElementosTabelaConsulta/Fl.PNG"));
	
	//Familia 5A
	private ImageIcon imagemN = new ImageIcon(getClass().getResource("/imagens/imagensElementosTabelaConsulta/N.PNG"));
	private ImageIcon imagemP = new ImageIcon(getClass().getResource("/imagens/imagensElementosTabelaConsulta/P.PNG"));
	private ImageIcon imagemAs = new ImageIcon(getClass().getResource("/imagens/imagensElementosTabelaConsulta/As.PNG"));
	private ImageIcon imagemSb = new ImageIcon(getClass().getResource("/imagens/imagensElementosTabelaConsulta/Sb.PNG"));
	private ImageIcon imagemBi = new ImageIcon(getClass().getResource("/imagens/imagensElementosTabelaConsulta/Bi.PNG"));
	private ImageIcon imagemUup = new ImageIcon(getClass().getResource("/imagens/imagensElementosTabelaConsulta/Uup.PNG"));
	
	//Familia 6A
	private ImageIcon imagemO = new ImageIcon(getClass().getResource("/imagens/imagensElementosTabelaConsulta/O.PNG"));
	private ImageIcon imagemS = new ImageIcon(getClass().getResource("/imagens/imagensElementosTabelaConsulta/S.PNG"));
	private ImageIcon imagemSe = new ImageIcon(getClass().getResource("/imagens/imagensElementosTabelaConsulta/Se.PNG"));
	private ImageIcon imagemTe = new ImageIcon(getClass().getResource("/imagens/imagensElementosTabelaConsulta/Te.PNG"));
	private ImageIcon imagemPo = new ImageIcon(getClass().getResource("/imagens/imagensElementosTabelaConsulta/Po.PNG"));
	private ImageIcon imagemLv = new ImageIcon(getClass().getResource("/imagens/imagensElementosTabelaConsulta/Lv.PNG"));
	
	//Familia 7A
	private ImageIcon imagemF = new ImageIcon(getClass().getResource("/imagens/imagensElementosTabelaConsulta/F.PNG"));
	private ImageIcon imagemCl = new ImageIcon(getClass().getResource("/imagens/imagensElementosTabelaConsulta/Cl.PNG"));
	private ImageIcon imagemBr = new ImageIcon(getClass().getResource("/imagens/imagensElementosTabelaConsulta/Br.PNG"));
	private ImageIcon imagemI = new ImageIcon(getClass().getResource("/imagens/imagensElementosTabelaConsulta/I.PNG"));
	private ImageIcon imagemAt = new ImageIcon(getClass().getResource("/imagens/imagensElementosTabelaConsulta/At.PNG"));
	private ImageIcon imagemUus = new ImageIcon(getClass().getResource("/imagens/imagensElementosTabelaConsulta/Uus.PNG"));
	
	//Familia 8A
	private ImageIcon imagemHe = new ImageIcon(getClass().getResource("/imagens/imagensElementosTabelaConsulta/He.PNG"));
	private ImageIcon imagemNe = new ImageIcon(getClass().getResource("/imagens/imagensElementosTabelaConsulta/Ne.PNG"));
	private ImageIcon imagemAr = new ImageIcon(getClass().getResource("/imagens/imagensElementosTabelaConsulta/Ar.PNG"));
	private ImageIcon imagemKr= new ImageIcon(getClass().getResource("/imagens/imagensElementosTabelaConsulta/Kr.PNG"));
	private ImageIcon imagemXe = new ImageIcon(getClass().getResource("/imagens/imagensElementosTabelaConsulta/Xe.PNG"));
	private ImageIcon imagemRn = new ImageIcon(getClass().getResource("/imagens/imagensElementosTabelaConsulta/Rn.PNG"));
	private ImageIcon imagemUuo = new ImageIcon(getClass().getResource("/imagens/imagensElementosTabelaConsulta/Uuo.PNG"));
	
	//Lantanideos
	private ImageIcon imagemLa = new ImageIcon(getClass().getResource("/imagens/imagensElementosTabelaConsulta/La.PNG"));
	private ImageIcon imagemCe = new ImageIcon(getClass().getResource("/imagens/imagensElementosTabelaConsulta/Ce.PNG"));
	private ImageIcon imagemPr = new ImageIcon(getClass().getResource("/imagens/imagensElementosTabelaConsulta/Pr.PNG"));
	private ImageIcon imagemNd = new ImageIcon(getClass().getResource("/imagens/imagensElementosTabelaConsulta/Nd.PNG"));
	private ImageIcon imagemPm = new ImageIcon(getClass().getResource("/imagens/imagensElementosTabelaConsulta/Pm.PNG"));
	private ImageIcon imagemSm = new ImageIcon(getClass().getResource("/imagens/imagensElementosTabelaConsulta/Sm.PNG"));
	private ImageIcon imagemEu = new ImageIcon(getClass().getResource("/imagens/imagensElementosTabelaConsulta/Eu.PNG"));
	private ImageIcon imagemGd = new ImageIcon(getClass().getResource("/imagens/imagensElementosTabelaConsulta/Gd.PNG"));
	private ImageIcon imagemTb = new ImageIcon(getClass().getResource("/imagens/imagensElementosTabelaConsulta/Tb.PNG"));
	private ImageIcon imagemDy = new ImageIcon(getClass().getResource("/imagens/imagensElementosTabelaConsulta/Dy.PNG"));
	private ImageIcon imagemHo = new ImageIcon(getClass().getResource("/imagens/imagensElementosTabelaConsulta/Ho.PNG"));
	private ImageIcon imagemEr = new ImageIcon(getClass().getResource("/imagens/imagensElementosTabelaConsulta/Er.PNG"));
	private ImageIcon imagemTm = new ImageIcon(getClass().getResource("/imagens/imagensElementosTabelaConsulta/Tm.PNG"));
	private ImageIcon imagemYb = new ImageIcon(getClass().getResource("/imagens/imagensElementosTabelaConsulta/Yb.PNG"));
	private ImageIcon imagemLu = new ImageIcon(getClass().getResource("/imagens/imagensElementosTabelaConsulta/Lu.PNG"));

	//Actinideos
	private ImageIcon imagemAc = new ImageIcon(getClass().getResource("/imagens/imagensElementosTabelaConsulta/Ac.PNG"));
	private ImageIcon imagemTh = new ImageIcon(getClass().getResource("/imagens/imagensElementosTabelaConsulta/Th.PNG"));
	private ImageIcon imagemPa = new ImageIcon(getClass().getResource("/imagens/imagensElementosTabelaConsulta/Pa.PNG"));
	private ImageIcon imagemU = new ImageIcon(getClass().getResource("/imagens/imagensElementosTabelaConsulta/U.PNG"));
	private ImageIcon imagemNp = new ImageIcon(getClass().getResource("/imagens/imagensElementosTabelaConsulta/Np.PNG"));
	private ImageIcon imagemPu = new ImageIcon(getClass().getResource("/imagens/imagensElementosTabelaConsulta/Pu.PNG"));
	private ImageIcon imagemAm = new ImageIcon(getClass().getResource("/imagens/imagensElementosTabelaConsulta/Am.PNG"));
	private ImageIcon imagemCm = new ImageIcon(getClass().getResource("/imagens/imagensElementosTabelaConsulta/Cm.PNG"));
	private ImageIcon imagemBk = new ImageIcon(getClass().getResource("/imagens/imagensElementosTabelaConsulta/Bk.PNG"));
	private ImageIcon imagemCf = new ImageIcon(getClass().getResource("/imagens/imagensElementosTabelaConsulta/Cf.PNG"));
	private ImageIcon imagemEs = new ImageIcon(getClass().getResource("/imagens/imagensElementosTabelaConsulta/Es.PNG"));
	private ImageIcon imagemFm = new ImageIcon(getClass().getResource("/imagens/imagensElementosTabelaConsulta/Fm.PNG"));
	private ImageIcon imagemMd = new ImageIcon(getClass().getResource("/imagens/imagensElementosTabelaConsulta/Md.PNG"));
	private ImageIcon imagemNo = new ImageIcon(getClass().getResource("/imagens/imagensElementosTabelaConsulta/No.PNG"));
	private ImageIcon imagemLr = new ImageIcon(getClass().getResource("/imagens/imagensElementosTabelaConsulta/Lr.PNG"));
	
	//Botoes dos Elementos
	//Familia 1A
	private JButton H = new JButton();
	private JButton Li = new JButton();
	private JButton Na = new JButton();
	private JButton K = new JButton();
	private JButton Rb = new JButton();
	private JButton Cs = new JButton();
	private JButton Fr = new JButton();
	//Familia 2A
	private JButton Be = new JButton();
	private JButton Mg = new JButton();
	private JButton Ca = new JButton();
	private JButton Sr = new JButton();
	private JButton Ba = new JButton();
	private JButton Ra = new JButton();
	//Coluna 3B
	private JButton Sc = new JButton();
	private JButton Y = new JButton();
	private JButton Lantanideos = new JButton();
	private JButton Actinideos = new JButton();
	
	//Coluna 4B
	private JButton Ti = new JButton();
	private JButton Zr = new JButton();
	private JButton Hf = new JButton();
	private JButton Rf = new JButton();
	
	//Coluna 5B
	private JButton V = new JButton();
	private JButton Nb = new JButton();
	private JButton Ta = new JButton();
	private JButton Db = new JButton();
	
	//Coluna 6B
	private JButton Cr = new JButton();
	private JButton Mo = new JButton();
	private JButton W = new JButton();
	private JButton Sg = new JButton();
	
	//Coluna 7B
	private JButton Mn = new JButton();
	private JButton Tc = new JButton();
	private JButton Re = new JButton();
	private JButton Bh = new JButton();
	
	//Coluna 8B(ocupa 3 filas de elementos)
	//fila 1
	private JButton Fe = new JButton();
	private JButton Ru = new JButton();
	private JButton Os = new JButton();
	private JButton Hs = new JButton();
	//fila 2
	private JButton Co = new JButton();
	private JButton Rh = new JButton();
	private JButton Ir = new JButton();
	private JButton Mt = new JButton();
	//fila 3
	private JButton Ni = new JButton();
	private JButton Pd = new JButton();
	private JButton Pt = new JButton();
	private JButton Ds = new JButton();
	
	//Coluna 1B
	private JButton Cu = new JButton();
	private JButton Ag = new JButton();
	private JButton Au = new JButton();
	private JButton Rg = new JButton();
	
	//Coluna 2B
	private JButton Zn = new JButton();
	private JButton Cd = new JButton();
	private JButton Hg = new JButton();
	private JButton Cn = new JButton();
	
	//Família 3A
	private JButton B = new JButton();
	private JButton Al = new JButton();
	private JButton Ga = new JButton();
	private JButton In = new JButton();
	private JButton Tl = new JButton();
	private JButton Uut = new JButton();
	
	//Família 4A
	private JButton C = new JButton();
	private JButton Si = new JButton();
	private JButton Ge = new JButton();
	private JButton Sn = new JButton();
	private JButton Pb = new JButton();
	private JButton Fl = new JButton();
	
	//Família 5A
	private JButton N = new JButton();
	private JButton P = new JButton();
	private JButton As = new JButton();
	private JButton Sb = new JButton();
	private JButton Bi = new JButton();
	private JButton Uup = new JButton();
	
	//Família 6A
	private JButton O  = new JButton();
	private JButton S  = new JButton();
	private JButton Se = new JButton();
	private JButton Te = new JButton();
	private JButton Po = new JButton();
	private JButton Lv = new JButton();
	
	//Família 7A
	private JButton F   = new JButton();
	private JButton Cl  = new JButton();
	private JButton Br  = new JButton();
	private JButton I   = new JButton();
	private JButton At  = new JButton();
	private JButton Uus = new JButton();
	
	//Família 8A(Gases Nobre)
	private JButton He = new JButton();
	private JButton Ne = new JButton();
	private JButton Ar = new JButton();
	private JButton Kr = new JButton();
	private JButton Xe = new JButton();
	private JButton Rn = new JButton();
	private JButton Uuo = new JButton();
	
	//Lantanídeos
	private JButton La = new JButton();
	private JButton Ce = new JButton();
	private JButton Pr = new JButton();
	private JButton Nd = new JButton();
	private JButton Pm = new JButton();
	private JButton Sm = new JButton();
	private JButton Eu = new JButton();
	private JButton Gd = new JButton();
	private JButton Tb = new JButton();
	private JButton Dy = new JButton();
	private JButton Ho = new JButton();
	private JButton Er = new JButton();
	private JButton Tm = new JButton();
	private JButton Yb = new JButton();
	private JButton Lu = new JButton();
	
	//Actinídeos
	private JButton Ac = new JButton();
	private JButton Th = new JButton();
	private JButton Pa = new JButton();
	private JButton U  = new JButton();
	private JButton Np = new JButton();
	private JButton Pu = new JButton();
	private JButton Am = new JButton();
	private JButton Cm = new JButton();
	private JButton Bk = new JButton();
	private JButton Cf = new JButton();
	private JButton Es = new JButton();
	private JButton Fm = new JButton();
	private JButton Md = new JButton();
	private JButton No = new JButton();
	private JButton Lr = new JButton();
	
	//Inserindo o título Tabela Periódica na tela
	private JLabel tituloTabelaPeriodica = new JLabel("Tabela Periódica");
	private Font fonteTP = new Font("Arial Black", Font.BOLD, 50);//atribuindo fonte a tabela
	
	//label da imagem
	private JLabel especificacoes = new JLabel();
	
	//Label do numero das familias
	private JLabel grupo1A = new JLabel("1A");
	private JLabel grupo2A = new JLabel("2A");
	private JLabel grupo3B = new JLabel("3B");
	private JLabel grupo4B = new JLabel("4B");
	private JLabel grupo5B = new JLabel("5B");
	private JLabel grupo6B = new JLabel("6B");
	private JLabel grupo7B = new JLabel("7B");
	private JLabel grupo8B = new JLabel("8B");
	private JLabel grupo1B = new JLabel("1B");
	private JLabel grupo2B = new JLabel("2B");
	private JLabel grupo3A = new JLabel("3A");
	private JLabel grupo4A = new JLabel("4A");
	private JLabel grupo5A = new JLabel("5A");
	private JLabel grupo6A = new JLabel("6A");
	private JLabel grupo7A = new JLabel("7A");
	private JLabel grupo8A = new JLabel("8A");
	private Font fonteNumFam = new Font("Arial Black", Font.BOLD, 15);
	private JLabel barraEsq = new JLabel();
	private JLabel barraDir = new JLabel();
	private ImageIcon imagemBarraEsq = new ImageIcon(getClass().getResource("/imagens/imagensElementosTabelaConsulta/barraEsq.PNG"));
	private ImageIcon imagemBarraDir = new ImageIcon(getClass().getResource("/imagens/imagensElementosTabelaConsulta/barraDir.PNG"));
	
	//Label numero periodos
	private JLabel periodo1 = new JLabel("1");
	private JLabel periodo2 = new JLabel("2");
	private JLabel periodo3 = new JLabel("3");
	private JLabel periodo4 = new JLabel("4");
	private JLabel periodo5 = new JLabel("5");
	private JLabel periodo6 = new JLabel("6");
	private JLabel periodo7 = new JLabel("7");
	
	//Informações adicionais
	private JButton Info = new JButton("<html>Informações<br><CENTER>Extras");
	private ImageIcon ImageInfo = new ImageIcon(getClass().getResource("/imagens/imagensElementosTabelaConsulta/Informações adicionais.PNG"));
	private Color corFundo = new Color(153,204,255);  //RGB
	private Font fonteInfo = new Font("Arial", Font.BOLD, 18);
	
	//Fontes
	private JButton Fontes = new JButton("Fontes");
	
	//Janela para inserir os elementos
	private JFrame janelaTabela = new JFrame();
	
	public TabelaPeriodica(){
		setImage();
		Colunas();
		setTituloTabela();
		adicionaFunc();
		NumerosFamilias();
		NumerosPeriodos();
		setEspecificacoes();
		setJanela();
	}
	
	public void setEspecificacoes(){
		especificacoes.setIcon(imagemEspec);
		especificacoes.setBounds(165, 60, 555, 135);
		janelaTabela.add(especificacoes);
	}
	
	public void setTituloTabela(){
		//Escrito da Tabela periódica em cima
		tituloTabelaPeriodica.setFont(fonteTP);
		tituloTabelaPeriodica.setBounds(221,10,800,50);
		janelaTabela.add(tituloTabelaPeriodica);
	}
	
	public void setJanela(){
		janelaTabela.setLayout(null);
		janelaTabela.setTitle("Tabela Periódica");
		janelaTabela.getContentPane().setBackground(Color.white);//acessa o conteudo da pane que é a janela e atribui a cor branca
		janelaTabela.setSize(1090,590);
		janelaTabela.setResizable(false);	
		janelaTabela.setLocationRelativeTo(null);
		janelaTabela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		janelaTabela.setVisible(true);
		
	}
	
	public void botaoInfoeFontes(){
		//Informações adicionais
		Info.setBackground(corFundo);	
		Info.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		Info.setFont(fonteInfo);
		Info.setBounds(70, 448, 120, 51);
		janelaTabela.add(Info);
		//Botao Fontes
		Fontes.setBackground(corFundo);
		Fontes.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		Fontes.setFont(fonteInfo);
		Fontes.setBounds(70, 501, 120, 50);
		janelaTabela.add(Fontes);
	}
	
	public void NumerosPeriodos(){
		periodo1.setFont(fonteNumFam);
		periodo2.setFont(fonteNumFam);
		periodo3.setFont(fonteNumFam);
		periodo4.setFont(fonteNumFam);
		periodo5.setFont(fonteNumFam);
		periodo6.setFont(fonteNumFam);
		periodo7.setFont(fonteNumFam);
		periodo1.setBounds(33, 82, 25, 25);
		periodo2.setBounds(33, 133, 25, 25);
		periodo3.setBounds(33, 185, 25, 25);
		periodo4.setBounds(33, 237, 25, 25);
		periodo5.setBounds(33, 289, 25, 25);
		periodo6.setBounds(33, 341, 25, 25);
		periodo7.setBounds(33, 393, 25, 25);
		janelaTabela.add(periodo1);
		janelaTabela.add(periodo2);
		janelaTabela.add(periodo3);
		janelaTabela.add(periodo4);
		janelaTabela.add(periodo5);
		janelaTabela.add(periodo6);
		janelaTabela.add(periodo7);	
	}
	
	public void NumerosFamilias(){
		grupo1A.setFont(fonteNumFam);
		grupo2A.setFont(fonteNumFam);
		grupo3B.setFont(fonteNumFam);
		grupo4B.setFont(fonteNumFam);
		grupo5B.setFont(fonteNumFam);
		grupo6B.setFont(fonteNumFam);
		grupo7B.setFont(fonteNumFam);
		barraEsq.setIcon(imagemBarraEsq);
		grupo8B.setFont(fonteNumFam);
		barraDir.setIcon(imagemBarraDir);
		grupo1B.setFont(fonteNumFam);
		grupo2B.setFont(fonteNumFam);
		grupo3A.setFont(fonteNumFam);
		grupo4A.setFont(fonteNumFam);
		grupo5A.setFont(fonteNumFam);
		grupo6A.setFont(fonteNumFam);
		grupo7A.setFont(fonteNumFam);
		grupo8A.setFont(fonteNumFam);
		grupo1A.setBounds(60, 50, 25, 25);
		grupo2A.setBounds(121, 102, 25, 25);
		grupo3B.setBounds(178, 206, 25, 25);
		grupo4B.setBounds(235, 206, 25, 25);
		grupo5B.setBounds(294, 206, 25, 25);
		grupo6B.setBounds(349, 206, 25, 25);
		grupo7B.setBounds(406, 206, 25, 25);
		barraEsq.setBounds(472, 213, 48, 12);
		grupo8B.setBounds(520, 206, 25, 25);
		barraDir.setBounds(543, 213, 48, 12);
		grupo1B.setBounds(634, 206, 25, 25);
		grupo2B.setBounds(691, 206, 25, 25);
		grupo3A.setBounds(748, 102, 25, 25);
		grupo4A.setBounds(805, 102, 25, 25);
		grupo5A.setBounds(862, 102, 25, 25);
		grupo6A.setBounds(919, 102, 25, 25);
		grupo7A.setBounds(976, 102, 25, 25);
		grupo8A.setBounds(1033, 50, 25, 25);
		janelaTabela.add(grupo1A);
		janelaTabela.add(grupo2A);
		janelaTabela.add(grupo3B);
		janelaTabela.add(grupo4B);
		janelaTabela.add(grupo5B);
		janelaTabela.add(grupo6B);
		janelaTabela.add(grupo7B);
		janelaTabela.add(barraEsq);
		janelaTabela.add(grupo8B);
		janelaTabela.add(barraDir);
		janelaTabela.add(grupo1B);
		janelaTabela.add(grupo2B);
		janelaTabela.add(grupo3A);
		janelaTabela.add(grupo4A);
		janelaTabela.add(grupo5A);
		janelaTabela.add(grupo6A);
		janelaTabela.add(grupo7A);
		janelaTabela.add(grupo8A);
	}
	
	public void Colunas(){
		Coluna1A();
		Coluna2A();
		Coluna3B();
		Coluna4B();
		Coluna5B();
		Coluna6B();
		Coluna7B();
		Coluna8B();
		Coluna1B();
		Coluna2B();
		Coluna3A();
		Coluna4A();
		Coluna5A();
		Coluna6A();
		Coluna7A();
		Coluna8A();
		ColunaLantanideos();
		ColunaActinideos();
		AdicionarElementos();
		botaoInfoeFontes();
	}
	
	public void setImage(){
		H.setIcon(imagemH);	//adicionando a imagem como icone do elemento;
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
		Lantanideos.setIcon(imagemLantanideos);
		Actinideos.setIcon(imagemActinideos);
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
		//Lantanideos
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
		//Actinideos
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
	
	public void AdicionarElementos(){
		janelaTabela.add(H);
		janelaTabela.add(Li);
		janelaTabela.add(Na);
		janelaTabela.add(K);
		janelaTabela.add(Rb);
		janelaTabela.add(Cs);
		janelaTabela.add(Fr);
		janelaTabela.add(Be);
		janelaTabela.add(Mg);
		janelaTabela.add(Ca);
		janelaTabela.add(Sr);
		janelaTabela.add(Ba);
		janelaTabela.add(Ra);
		janelaTabela.add(Sc);
		janelaTabela.add(Y);
		janelaTabela.add(Lantanideos);
		janelaTabela.add(Actinideos);
		janelaTabela.add(Ti);
		janelaTabela.add(Zr);
		janelaTabela.add(Hf);
		janelaTabela.add(Rf);
		janelaTabela.add(V);
		janelaTabela.add(Nb);
		janelaTabela.add(Ta);
		janelaTabela.add(Db);
		janelaTabela.add(Cr);
		janelaTabela.add(Mo);
		janelaTabela.add(W);
		janelaTabela.add(Sg);
		janelaTabela.add(Mn);
		janelaTabela.add(Tc);
		janelaTabela.add(Re);
		janelaTabela.add(Bh);
		janelaTabela.add(Fe);
		janelaTabela.add(Ru);
		janelaTabela.add(Os);
		janelaTabela.add(Hs);
		janelaTabela.add(Co);
		janelaTabela.add(Rh);
		janelaTabela.add(Ir);
		janelaTabela.add(Mt);
		janelaTabela.add(Ni);
		janelaTabela.add(Pd);
		janelaTabela.add(Pt);
		janelaTabela.add(Ds);
		janelaTabela.add(Cu);
		janelaTabela.add(Ag);
		janelaTabela.add(Au);
		janelaTabela.add(Rg);
		janelaTabela.add(Zn);
		janelaTabela.add(Cd);
		janelaTabela.add(Hg);
		janelaTabela.add(Cn);
		janelaTabela.add(B);
		janelaTabela.add(Al);
		janelaTabela.add(Ga);
		janelaTabela.add(In);
		janelaTabela.add(Tl);
		janelaTabela.add(Uut);
		janelaTabela.add(C);
		janelaTabela.add(Si);
		janelaTabela.add(Ge);
		janelaTabela.add(Sn);
		janelaTabela.add(Pb);
		janelaTabela.add(Fl);
		janelaTabela.add(N);
		janelaTabela.add(P);
		janelaTabela.add(As);
		janelaTabela.add(Sb);
		janelaTabela.add(Bi);
		janelaTabela.add(Uup);
		janelaTabela.add(O);
		janelaTabela.add(S);
		janelaTabela.add(Se);
		janelaTabela.add(Te);
		janelaTabela.add(Po);
		janelaTabela.add(Lv);
		janelaTabela.add(F);
		janelaTabela.add(Cl);
		janelaTabela.add(Br);
		janelaTabela.add(I);
		janelaTabela.add(At);
		janelaTabela.add(Uus);
		janelaTabela.add(He);
		janelaTabela.add(Ne);
		janelaTabela.add(Ar);
		janelaTabela.add(Kr);
		janelaTabela.add(Xe);
		janelaTabela.add(Rn);
		janelaTabela.add(Uuo);
		janelaTabela.add(La);
		janelaTabela.add(Ce);
		janelaTabela.add(Pr);
		janelaTabela.add(Nd);
		janelaTabela.add(Pm);
		janelaTabela.add(Sm);
		janelaTabela.add(Eu);
		janelaTabela.add(Gd);
		janelaTabela.add(Tb);
		janelaTabela.add(Dy);
		janelaTabela.add(Ho);
		janelaTabela.add(Er);
		janelaTabela.add(Tm);
		janelaTabela.add(Yb);
		janelaTabela.add(Lu);
		janelaTabela.add(Ac);
		janelaTabela.add(Th);
		janelaTabela.add(Pa);
		janelaTabela.add(U);
		janelaTabela.add(Np);
		janelaTabela.add(Pu);
		janelaTabela.add(Am);
		janelaTabela.add(Cm);
		janelaTabela.add(Bk);
		janelaTabela.add(Cf);
		janelaTabela.add(Es);
		janelaTabela.add(Fm);
		janelaTabela.add(Md);
		janelaTabela.add(No);
		janelaTabela.add(Lr);
	}
	
	public void Coluna1A(){
		H.setBounds(47, 69, 56, 51);
		Li.setBounds(47, 121, 56, 51);
		Na.setBounds(47, 173, 56, 51);
		K.setBounds(47, 225, 56, 51);
		Rb.setBounds(47, 277, 56, 51);
		Cs.setBounds(47, 329, 56, 51);
		Fr.setBounds(47, 381, 56, 51);
	}
	
	public void Coluna2A(){
		Be.setBounds(104, 121, 56, 51);
		Mg.setBounds(104, 173, 56, 51);
		Ca.setBounds(104, 225, 56, 51);
		Sr.setBounds(104, 277, 56, 51);
		Ba.setBounds(104, 329, 56, 51);
		Ra.setBounds(104, 381, 56, 51);
	}
	
	public void Coluna3B(){
		Sc.setBounds(161, 225, 56, 51);
		Y.setBounds(161, 277, 56, 51);
		Lantanideos.setBounds(161, 329, 56, 51);
		Actinideos.setBounds(161, 381, 56, 51);
	}
	
	public void Coluna4B(){
		Ti.setBounds(218, 225, 56, 51);
		Zr.setBounds(218, 277, 56, 51);
		Hf.setBounds(218, 329, 56, 51);
		Rf.setBounds(218, 381, 56, 51);
	}
	
	public void Coluna5B(){
		V.setBounds(275, 225, 56, 51);
		Nb.setBounds(275, 277, 56, 51);
		Ta.setBounds(275, 329, 56, 51);
		Db.setBounds(275, 381, 56, 51);
	}
	
	public void Coluna6B(){
		Cr.setBounds(332, 225, 56, 51);
		Mo.setBounds(332, 277, 56, 51);
		W.setBounds(332, 329, 56, 51);
		Sg.setBounds(332, 381, 56, 51);
	}
	
	public void Coluna7B(){
		Mn.setBounds(389, 225, 56, 51);
		Tc.setBounds(389, 277, 56, 51);
		Re.setBounds(389, 329, 56, 51);
		Bh.setBounds(389, 381, 56, 51);
	}
	
	public void Coluna8B(){
		//Fila 1
		Fe.setBounds(446, 225, 56, 51);
		Ru.setBounds(446, 277, 56, 51);
		Os.setBounds(446, 329, 56, 51);
		Hs.setBounds(446, 381, 56, 51);
		//Fila 2
		Co.setBounds(503, 225, 56, 51);
		Rh.setBounds(503, 277, 56, 51);
		Ir.setBounds(503, 329, 56, 51);
		Mt.setBounds(503, 381, 56, 51);
		//Fila 3
		Ni.setBounds(560, 225, 56, 51);
		Pd.setBounds(560, 277, 56, 51);
		Pt.setBounds(560, 329, 56, 51);
		Ds.setBounds(560, 381, 56, 51);
	}
	
	public void Coluna1B(){
		Cu.setBounds(617, 225, 56, 51);
		Ag.setBounds(617, 277, 56, 51);
		Au.setBounds(617, 329, 56, 51);
		Rg.setBounds(617, 381, 56, 51);
	}
	
	public void Coluna2B(){
		Zn.setBounds(674, 225, 56, 51);
		Cd.setBounds(674, 277, 56, 51);
		Hg.setBounds(674, 329, 56, 51);
		Cn.setBounds(674, 381, 56, 51);
	}
	
	public void Coluna3A(){
		B.setBounds(731, 121, 56, 51);
		Al.setBounds(731, 173, 56, 51);
		Ga.setBounds(731, 225, 56, 51);
		In.setBounds(731, 277, 56, 51);
		Tl.setBounds(731, 329, 56, 51);
		Uut.setBounds(731, 381, 56, 51);
	}
	
	public void Coluna4A(){
		C.setBounds(788, 121, 56, 51);
		Si.setBounds(788, 173, 56, 51);
		Ge.setBounds(788, 225, 56, 51);
		Sn.setBounds(788, 277, 56, 51);
		Pb.setBounds(788, 329, 56, 51);
		Fl.setBounds(788, 381, 56, 51);
	}
	
	public void Coluna5A(){
		N.setBounds(845, 121, 56, 51);
		P.setBounds(845, 173, 56, 51);
		As.setBounds(845, 225, 56, 51);
		Sb.setBounds(845, 277, 56, 51);
		Bi.setBounds(845, 329, 56, 51);
		Uup.setBounds(845, 381, 56, 51);
	}
	
	public void Coluna6A(){
		O.setBounds(902, 121, 56, 51);
		S.setBounds(902, 173, 56, 51);
		Se.setBounds(902, 225, 56, 51);
		Te.setBounds(902, 277, 56, 51);
		Po.setBounds(902, 329, 56, 51);
		Lv.setBounds(902, 381, 56, 51);
	}
	
	public void Coluna7A(){
		F.setBounds(959, 121, 56, 51);
		Cl.setBounds(959, 173, 56, 51);
		Br.setBounds(959, 225, 56, 51);
		I.setBounds(959, 277, 56, 51);
		At.setBounds(959, 329, 56, 51);
		Uus.setBounds(959, 381, 56, 51);
	}
	
	public void Coluna8A(){
		He.setBounds(1016, 69, 56, 51);
		Ne.setBounds(1016, 121, 56, 51);
		Ar.setBounds(1016, 173, 56, 51);
		Kr.setBounds(1016, 225, 56, 51);
		Xe.setBounds(1016, 277, 56, 51);
		Rn.setBounds(1016, 329, 56, 51);
		Uuo.setBounds(1016, 381, 56, 51);
	}
	
	public void ColunaLantanideos(){
		La.setBounds(218, 448, 56, 51);
		Ce.setBounds(275, 448, 56, 51);
		Pr.setBounds(332, 448, 56, 51);
		Nd.setBounds(389, 448, 56, 51);
		Pm.setBounds(446, 448, 56, 51);
		Sm.setBounds(503, 448, 56, 51);
		Eu.setBounds(560, 448, 56, 51);
		Gd.setBounds(617, 448, 56, 51);
		Tb.setBounds(674, 448, 56, 51);
		Dy.setBounds(731, 448, 56, 51);
		Ho.setBounds(788, 448, 56, 51);
		Er.setBounds(845, 448, 56, 51);
		Tm.setBounds(902, 448, 56, 51);
		Yb.setBounds(959, 448, 56, 51);
		Lu.setBounds(1016, 448, 56, 51);
	}
	
	public void ColunaActinideos(){
		Ac.setBounds(218, 500, 56, 51);
		Th.setBounds(275, 500, 56, 51);
		Pa.setBounds(332, 500, 56, 51);
		U.setBounds(389, 500, 56, 51);
		Np.setBounds(446, 500, 56, 51);
		Pu.setBounds(503, 500, 56, 51);
		Am.setBounds(560, 500, 56, 51);
		Cm.setBounds(617, 500, 56, 51);
		Bk.setBounds(674, 500, 56, 51);
		Cf.setBounds(731, 500, 56, 51);
		Es.setBounds(788, 500, 56, 51);
		Fm.setBounds(845, 500, 56, 51);
		Md.setBounds(902, 500, 56, 51);
		No.setBounds(959, 500, 56, 51);
		Lr.setBounds(1016, 500, 56, 51);
	}
	
	public void actionPerformed(ActionEvent e) {
		//1A
		if(e.getSource()==H){	
			JOptionPane.showMessageDialog(null, "Número Atômico: 1\nMassa: 1,00794\nDistribuição Eletronica:\nK - 1");
		}
		if(e.getSource()==Li){
			JOptionPane.showMessageDialog(null, "Número Atômico: 3\nMassa: 6,941\nDistribuição Eletronica:\nK - 2\nL - 1");
		}
		if(e.getSource()==Na){
			JOptionPane.showMessageDialog(null, "Número Atômico: 11\nMassa: 22,98976...\nDistribuição Eletronica:\nK - 2\nL - 8\nM - 1");
		}
		if(e.getSource()==K){
			JOptionPane.showMessageDialog(null, "Número Atômico: 19\nMassa: 39,0983\nDistribuição Eletronica:\nK - 2\nL - 8\nM - 8\nN - 1");
		}
		if(e.getSource()==Rb){
			JOptionPane.showMessageDialog(null, "Número Atômico: 37\nMassa: 85,4678\nDistribuição Eletronica:\nK - 2\nL - 8\nM - 18\nN - 8\nO - 1");
		}
		if(e.getSource()==Cs){
			JOptionPane.showMessageDialog(null, "Número Atômico: 55\nMassa: 132,9054...\nDistribuição Eletronica:\nK - 2\nL - 8\nM - 18\nN - 18\nO - 8\nP - 1");
		}
		if(e.getSource()==Fr){
			JOptionPane.showMessageDialog(null, "Número Atômico: 87\nMassa: 223\nDistribuição Eletronica:\nK - 2\nL - 8\nM - 18\nN - 32\nO - 18\nP - 8\nQ - 1");
		}
		//2A
		if(e.getSource()==Be){
			JOptionPane.showMessageDialog(null, "Número Atômico: 4\nMassa: 9,012182\nDistribuição Eletronica:\nK - 2\nL - 2");
		}
		if(e.getSource()==Mg){
			JOptionPane.showMessageDialog(null, "Número Atômico: 12\nMassa: 24,305\nDistribuição Eletronica:\nK - 2\nL - 8\nM - 2");
		}
		if(e.getSource()==Ca){
			JOptionPane.showMessageDialog(null, "Número Atômico: 20\nMassa: 40,078\nDistribuição Eletronica:\nK - 2\nL - 8\nM - 8\nN - 2");
		}
		if(e.getSource()==Sr){
			JOptionPane.showMessageDialog(null, "Número Atômico: 38\nMassa: 87,62\nDistribuição Eletronica:\nK - 2\nL - 8\nM - 18\nN - 8\nO - 2");
		}
		if(e.getSource()==Ba){
			JOptionPane.showMessageDialog(null, "Número Atômico: 56\nMassa: 137,327\nDistribuição Eletronica:\nK - 2\nL - 8\nM - 18\nN - 18\nO - 8\nP - 2");
		}
		if(e.getSource()==Ra){
			JOptionPane.showMessageDialog(null, "Número Atômico: 88\nMassa: 226\nDistribuição Eletronica:\nK - 2\nL - 8\nM - 18\nN - 32\nO - 18\nP - 8\nQ - 2");
		}
		//3B
		if(e.getSource()==Sc){
			JOptionPane.showMessageDialog(null, "Número Atômico: 21\nMassa: 44,955912\nDistribuição Eletronica:\nK - 2\nL - 8\nM - 9\nN - 2");
		}
		if(e.getSource()==Y){
			JOptionPane.showMessageDialog(null, "Número Atômico: 39\nMassa: 88,90585\nDistribuição Eletronica:\nK - 2\nL - 8\nM - 18\nN - 9\nO - 2");
		}
		//4B
		if(e.getSource()==Ti){
			JOptionPane.showMessageDialog(null, "Número Atômico: 22\nMassa: 47,867\nDistribuição Eletronica:\nK - 2\nL - 8\nM - 10\nN - 2");
		}
		if(e.getSource()==Zr){
			JOptionPane.showMessageDialog(null, "Número Atômico: 40\nMassa: 91,224\nDistribuição Eletronica:\nK - 2\nL - 8\nM - 18\nN - 10\nO - 2");
		}
		if(e.getSource()==Hf){
			JOptionPane.showMessageDialog(null, "Número Atômico: 72\nMassa: 178,49\nDistribuição Eletronica:\nK - 2\nL - 8\nM - 18\nN - 32\nO- 10\nP - 2");
		}
		if(e.getSource()==Rf){
			JOptionPane.showMessageDialog(null, "Número Atômico: 104\nMassa: 267\nDistribuição Eletronica:\nK - 2\nL - 8\nM - 18\nN - 32\nO - 32\nP - 10\nQ - 2");
		}
		//5B
		if(e.getSource()==V){
			JOptionPane.showMessageDialog(null, "Número Atômico: 23\nMassa: 50,9415\nDistribuição Eletronica:\nK - 2\nL - 8\nM - 11\nN - 2");
		}
		if(e.getSource()==Nb){
			JOptionPane.showMessageDialog(null, "Número Atômico: 41\nMassa: 92,90638\nDistribuição Eletronica:\nK - 2\nL - 8\nM - 18\nN - 12\nO - 1");
		}
		if(e.getSource()==Ta){
			JOptionPane.showMessageDialog(null, "Número Atômico: 73\nMassa: 180,94788\nDistribuição Eletronica:\nK - 2\nL - 8\nM - 18\nN - 32\nO - 11\nP - 2");
		}
		if(e.getSource()==Db){
			JOptionPane.showMessageDialog(null, "Número Atômico: 105\nMassa: 268\nDistribuição Eletronica:\nK - 2\nL - 8\nM - 18\nN - 32\nO - 32\nP - 11\nQ - 2");
		}
		//6B
		if(e.getSource()==Cr){
			JOptionPane.showMessageDialog(null, "Número Atômico: 24\nMassa: 51,9961\nDistribuição Eletronica:\nK - 2\nL - 8\nM - 13\nN - 1");
		}
		if(e.getSource()==Mo){
			JOptionPane.showMessageDialog(null, "Número Atômico: 42\nMassa: 95,96\nDistribuição Eletronica:\nK - 2\nL - 8\nM - 18\nN - 13\nO - 1");
		}
		if(e.getSource()==W){
			JOptionPane.showMessageDialog(null, "Número Atômico: 74\nMassa: 183,84\nDistribuição Eletronica:\nK - 2\nL - 8\nM - 18\nN - 32\nO - 12\nP - 2");
		}
		if(e.getSource()==Sg){
			JOptionPane.showMessageDialog(null, "Número Atômico: 106\nMassa: 271\nDistribuição Eletronica:\nK - 2\nL - 8\nM - 18\nN - 32\nO - 32\nP - 12\nQ - 2");
		}
		//7B
		if(e.getSource()==Mn){
			JOptionPane.showMessageDialog(null, "Número Atômico: 25\nMassa: 54,938045\nDistribuição Eletronica:\nK - 2\nL - 8\nM - 13\nN - 2");
		}
		if(e.getSource()==Tc){
			JOptionPane.showMessageDialog(null, "Número Atômico: 43\nMassa: (98)\nDistribuição Eletronica:\nK - 2\nL - 8\nM - 18\nN - 13\nO - 2");
		}
		if(e.getSource()==Re){
			JOptionPane.showMessageDialog(null, "Número Atômico: 75\nMassa: 186,207\nDistribuição Eletronica:\nK - 2\nL - 8\nM - 18\nN - 32\nO - 13\nP - 2");
		}
		if(e.getSource()==Bh){
			JOptionPane.showMessageDialog(null, "Número Atômico: 107\nMassa: 272\nDistribuição Eletronica:\nK - 2\nL - 8\nM - 18\nN - 32\nO - 32\nP - 13\nQ - 2");
		}
		//8B
		if(e.getSource()==Fe){
			JOptionPane.showMessageDialog(null, "Número Atômico: 26\nMassa: 55,845\nDistribuição Eletronica:\nK - 2\nL - 8\nM - 14\nN - 2");
		}
		if(e.getSource()==Ru){
			JOptionPane.showMessageDialog(null, "Número Atômico: 44\nMassa: 101,07\nDistribuição Eletronica:\nK - 2\nL - 8\nM - 18\nN - 15\nO - 1");
		}
		if(e.getSource()==Os){
			JOptionPane.showMessageDialog(null, "Número Atômico: 76\nMassa: 190,23\nDistribuição Eletronica:\nK - 2\nL - 8\nM - 18\nN - 32\nO - 14\nP - 2");
		}
		if(e.getSource()==Hs){
			JOptionPane.showMessageDialog(null, "Número Atômico: 108\nMassa: 270\nDistribuição Eletronica:\nK - 2\nL - 8\nM - 18\nN - 32\nO - 32\nP - 14\nQ - 2");		
			}
		if(e.getSource()==Co){
			JOptionPane.showMessageDialog(null, "Número Atômico: 27\nMassa: 58,933195\nDistribuição Eletronica:\nK - 2\nL - 8\nM - 15\nN - 2");
		}
		if(e.getSource()==Rh){
			JOptionPane.showMessageDialog(null, "Número Atômico: 45\nMassa: 102,9055\nDistribuição Eletronica:\nK - 2\nL - 8\nM - 18\nN - 16\nO - 1");
		}
		if(e.getSource()==Ir){
			JOptionPane.showMessageDialog(null, "Número Atômico: 77\nMassa: 192,217\nDistribuição Eletronica:\nK - 2\nL - 8\nM - 18\nN - 32\nO - 15\nP - 2");
		}
		if(e.getSource()==Mt){
			JOptionPane.showMessageDialog(null, "Número Atômico: 109\nMassa: 276\nDistribuição Eletronica:\nK - 2\nL - 8\nM - 18\nN - 32\nO - 32\nP - 15\nQ - 2");
		}
		if(e.getSource()==Ni){
			JOptionPane.showMessageDialog(null, "Número Atômico: 28\nMassa: 58,6934\nDistribuição Eletronica:\nK - 2\nL - 8\nM - 16\nN - 2");
		}
		if(e.getSource()==Pd){
			JOptionPane.showMessageDialog(null, "Número Atômico: 46\nMassa: 106,42\nDistribuição Eletronica:\nK - 2\nL - 8\nM - 18\nN - 18");
		}
		if(e.getSource()==Pt){
			JOptionPane.showMessageDialog(null, "Número Atômico: 78\nMassa: 195,084\nDistribuição Eletronica:\nK - 2\nL - 8\nM - 18\nN - 32\nO - 17\nP - 1");
		}
		if(e.getSource()==Ds){
			JOptionPane.showMessageDialog(null, "Número Atômico: 110\nMassa: 281\nDistribuição Eletronica:\nK - 2\nL - 8\nM - 18\nN - 32\nO - 32\nP - 17\nQ - 1");
		}
		//1B
		if(e.getSource()==Cu){
			JOptionPane.showMessageDialog(null, "Número Atômico: 29\nMassa: 63,546\nDistribuição Eletronica:\nK - 2\nL - 8\nM - 18\nN - 1");
		}
		if(e.getSource()==Ag){
			JOptionPane.showMessageDialog(null, "Número Atômico: 47\nMassa: 107,8682\nDistribuição Eletronica:\nK - 2\nL - 8\nM - 18\nN - 18\nO - 1");
		}
		if(e.getSource()==Au){
			JOptionPane.showMessageDialog(null, "Número Atômico: 79\nMassa: 196,966569\nDistribuição Eletronica:\nK - 2\nL - 8\nM - 18\nN - 32\nO - 18\nP - 1");
		}
		if(e.getSource()==Rg){
			JOptionPane.showMessageDialog(null, "Número Atômico: 111\nMassa: 280\nDistribuição Eletronica:\nK - 2\nL - 8\nM - 18\nN - 32\nO - 32\nP - 18\nQ - 1");
		}
		//2B
		if(e.getSource()==Zn){
			JOptionPane.showMessageDialog(null, "Número Atômico: 30\nMassa: 65,38\nDistribuição Eletronica:\nK - 2\nL - 8\nM - 18\nN - 2");
		}
		if(e.getSource()==Cd){
			JOptionPane.showMessageDialog(null, "Número Atômico: 48\nMassa: 112,411\nDistribuição Eletronica:\nK - 2\nL - 8\nM - 18\nN - 18\nO - 2");
		}
		if(e.getSource()==Hg){
			JOptionPane.showMessageDialog(null, "Número Atômico: 80\nMassa: 200,59\nDistribuição Eletronica:\nK - 2\nL - 8\nM - 18\nN - 32\nO - 18\nP - 2");
		}
		if(e.getSource()==Cn){
			JOptionPane.showMessageDialog(null, "Número Atômico: 112\nMassa: 285\nDistribuição Eletronica:\nK - 2\nL - 8\nM - 18\nN - 32\nO - 32\nP - 18\nQ - 2");
		}
		//3A
		if(e.getSource()==B){
			JOptionPane.showMessageDialog(null, "Número Atômico: 5\nMassa: 10,811\nDistribuição Eletronica:\nK - 2\nL - 3");
		}
		if(e.getSource()==Al){
			JOptionPane.showMessageDialog(null, "Número Atômico: 13\nMassa: 26,9815386\nDistribuição Eletronica:\nK - 2\nL - 8\nM - 3");
		}
		if(e.getSource()==Ga){
			JOptionPane.showMessageDialog(null, "Número Atômico: 31\nMassa: 69,723\nDistribuição Eletronica:\nK - 2\nL - 8\nM - 18\nN - 3");
		}
		if(e.getSource()==In){
			JOptionPane.showMessageDialog(null, "Número Atômico: 49\nMassa: 114,818\nDistribuição Eletronica:\nK - 2\nL - 8\nM - 18\nN - 18\nO - 3");
		}
		if(e.getSource()==Tl){
			JOptionPane.showMessageDialog(null, "Número Atômico: 81\nMassa: 204,3833\nDistribuição Eletronica:\nK - 2\nL - 8\nM - 18\nN - 32\nO - 18\nP - 3");
		}
		if(e.getSource()==Uut){
			JOptionPane.showMessageDialog(null, "Número Atômico: 113\nMassa: 284\nDistribuição Eletronica:\nK - 2\nL - 8\nM - 18\nN - 32\nO - 32\nP - 18\nQ - 3");
		}
		//4A
		if(e.getSource()==C){
			JOptionPane.showMessageDialog(null, "Número Atômico: 6\nMassa: 12,0107\nDistribuição Eletronica:\nK - 2\nL - 4");
		}
		if(e.getSource()==Si){
			JOptionPane.showMessageDialog(null, "Número Atômico: 14\nMassa: 28,0855\nDistribuição Eletronica:\nK - 2\nL - 8\nM - 4");
		}
		if(e.getSource()==Ge){
			JOptionPane.showMessageDialog(null, "Número Atômico: 32\nMassa: 72,63\nDistribuição Eletronica:\nK - 2\nL - 8\nM - 18\nN - 4");		
			}
		if(e.getSource()==Sn){
			JOptionPane.showMessageDialog(null, "Número Atômico: 50\nMassa: 118,71\nDistribuição Eletronica:\nK - 2\nL - 8\nM - 18\nN - 18\nO - 4");
		}
		if(e.getSource()==Pb){
			JOptionPane.showMessageDialog(null, "Número Atômico: 82\nMassa: 207,2\nDistribuição Eletronica:\nK - 2\nL - 8\nM - 18\nN - 32\nO - 18\nP - 4");
		}
		if(e.getSource()==Fl){
			JOptionPane.showMessageDialog(null, "Número Atômico: 114\nMassa: 289\nDistribuição Eletronica:\nK - 2\nL - 8\nM - 18\nN - 32\nO - 32\nP - 13\nQ - 4");
		}
		//5A
		if(e.getSource()==N){
			JOptionPane.showMessageDialog(null, "Número Atômico: 7\nMassa: 14,0067\nDistribuição Eletronica:\nK - 2\nL - 5");
		}
		if(e.getSource()==P){
			JOptionPane.showMessageDialog(null, "Número Atômico: 15\nMassa: 30,973763\nDistribuição Eletronica:\nK - 2\nL - 8\nM - 5");
		}
		if(e.getSource()==As){
			JOptionPane.showMessageDialog(null, "Número Atômico: 33\nMassa: 74,9216\nDistribuição Eletronica:\nK - 2\nL - 8\nM - 18\nN - 5");
		}
		if(e.getSource()==Sb){
			JOptionPane.showMessageDialog(null, "Número Atômico: 51\nMassa: 121,76\nDistribuição Eletronica:\nK - 2\nL - 8\nM - 18\nN - 18\nO - 5");
		}
		if(e.getSource()==Bi){
			JOptionPane.showMessageDialog(null, "Número Atômico: 83\nMassa: 208,9804\nDistribuição Eletronica:\nK - 2\nL - 8\nM - 18\nN - 32\nO - 18\nP - 5");
		}
		if(e.getSource()==Uup){
			JOptionPane.showMessageDialog(null, "Número Atômico: 115\nMassa: 288\nDistribuição Eletronica:\nK - 2\nL - 8\nM - 18\nN - 32\nO - 32\nP - 18\nQ - 5");
		}
		//6A
		if(e.getSource()==O){
			JOptionPane.showMessageDialog(null, "Número Atômico: 8\nMassa: 15,9994\nDistribuição Eletronica:\nK - 2\nL - 6");
		}
		if(e.getSource()==S){
			JOptionPane.showMessageDialog(null, "Número Atômico: 16\nMassa: 32,065\nDistribuição Eletronica:\nK - 2\nL - 8\nM - 6");
		}
		if(e.getSource()==Se){
			JOptionPane.showMessageDialog(null, "Número Atômico: 34\nMassa: 78,96\nDistribuição Eletronica:\nK - 2\nL - 8\nM - 18\nN - 6");
		}
		if(e.getSource()==Te){
			JOptionPane.showMessageDialog(null, "Número Atômico: 52\nMassa: 127,6\nDistribuição Eletronica:\nK - 2\nL - 8\nM - 18\nN - 18\nO - 6");
		}
		if(e.getSource()==Po){
			JOptionPane.showMessageDialog(null, "Número Atômico: 84\nMassa: 209\nDistribuição Eletronica:\nK - 2\nL - 8\nM - 18\nN - 32\nO - 18\nP - 6");
		}
		if(e.getSource()==Lv){
			JOptionPane.showMessageDialog(null, "Número Atômico: 116\nMassa: 293\nDistribuição Eletronica:\nK - 2\nL - 8\nM - 18\nN - 32\nO - 32\nP - 18\nQ - 6");
		}
		//7A
		if(e.getSource()==F){
			JOptionPane.showMessageDialog(null, "Número Atômico: 9\nMassa: 18,9984032\nDistribuição Eletronica:\nK - 2\nL - 7");
		}
		if(e.getSource()==Cl){
			JOptionPane.showMessageDialog(null, "Número Atômico: 17\nMassa: 35,453\nDistribuição Eletronica:\nK - 2\nL - 8\nM - 7");
		}
		if(e.getSource()==Br){
			JOptionPane.showMessageDialog(null, "Número Atômico: 35\nMassa: 79,904\nDistribuição Eletronica:\nK - 2\nL - 8\nM - 18\nN - 7");
		}
		if(e.getSource()==I){
			JOptionPane.showMessageDialog(null, "Número Atômico: 53\nMassa: 126,90447\nDistribuição Eletronica:\nK - 2\nL - 8\nM - 18\nN - 18\nO - 7");
		}
		if(e.getSource()==At){
			JOptionPane.showMessageDialog(null, "Número Atômico: 85\nMassa: 210\nDistribuição Eletronica:\nK - 2\nL - 8\nM - 18\nN - 32\nO - 18\nP - 7");
		}
		if(e.getSource()==Uus){
			JOptionPane.showMessageDialog(null, "Número Atômico: 117\nMassa: 294\nDistribuição Eletronica:\nK - 2\nL - 8\nM - 18\nN - 32\nO - 32\nP - 18\nQ - 7");
		}
		//8A
		if(e.getSource()==He){
			JOptionPane.showMessageDialog(null, "Número Atômico: 2\nMassa: 4,002602\nDistribuição Eletronica:\nK - 2");
		}
		if(e.getSource()==Ne){
			JOptionPane.showMessageDialog(null, "Número Atômico: 10\nMassa: 20,1797\nDistribuição Eletronica:\nK - 2\nL - 8");
		}
		if(e.getSource()==Ar){
			JOptionPane.showMessageDialog(null, "Número Atômico: 18\nMassa: 39,948\nDistribuição Eletronica:\nK - 2\nL - 8\nM - 8");
		}
		if(e.getSource()==Kr){
			JOptionPane.showMessageDialog(null, "Número Atômico: 36\nMassa: 83,798\nDistribuição Eletronica:\nK - 2\nL - 8\nM - 18\nN - 8");
		}
		if(e.getSource()==Xe){
			JOptionPane.showMessageDialog(null, "Número Atômico: 54\nMassa: 131,293\nDistribuição Eletronica:\nK - 2\nL - 8\nM - 18\nN - 18\nO - 8");
		}
		if(e.getSource()==Rn){
			JOptionPane.showMessageDialog(null, "Número Atômico: 86\nMassa: 222\nDistribuição Eletronica:\nK - 2\nL - 8\nM - 18\nN - 32\nO - 18\nP - 8");
		}
		if(e.getSource()==Uuo){
			JOptionPane.showMessageDialog(null, "Número Atômico: 118\nMassa: 294\nDistribuição Eletronica:\nK - 2\nL - 8\nM - 18\nN - 32\nO - 32\nP - 18\nQ - 8");
		}
		//lant
		if(e.getSource()==La){
			JOptionPane.showMessageDialog(null, "Número Atômico: 57\nMassa: 138,90547\nDistribuição Eletronica:\nK - 2\nL - 8\nM - 18\nN - 18\nO - 9\nP - 2");
		}
		if(e.getSource()==Ce){
			JOptionPane.showMessageDialog(null, "Número Atômico: 58\nMassa: 140,116\nDistribuição Eletronica:\nK - 2\nL - 8\nM - 18\nN - 19\nO - 9\nP - 2");
		}
		if(e.getSource()==Pr){
			JOptionPane.showMessageDialog(null, "Número Atômico: 59\nMassa: 140,90765\nDistribuição Eletronica:\nK - 2\nL - 8\nM - 18\nN - 21\nO - 8\nP - 2");
		}
		if(e.getSource()==Nd){
			JOptionPane.showMessageDialog(null, "Número Atômico: 60\nMassa: 144,242\nDistribuição Eletronica:\nK - 2\nL - 8\nM - 18\nN - 22\nO - 8\nP - 2");
		}
		if(e.getSource()==Pm){
			JOptionPane.showMessageDialog(null, "Número Atômico: 61\nMassa: 145\nDistribuição Eletronica:\nK - 2\nL - 8\nM - 18\nN - 23\nO - 8\nP - 2");
		}
		if(e.getSource()==Sm){
			JOptionPane.showMessageDialog(null, "Número Atômico: 62\nMassa: 150,36\nDistribuição Eletronica:\nK - 2\nL - 8\nM - 18\nN - 24\nO - 8\nP - 2");
		}
		if(e.getSource()==Eu){
			JOptionPane.showMessageDialog(null, "Número Atômico: 63\nMassa: 151,964\nDistribuição Eletronica:\nK - 2\nL - 8\nM - 18\nN - 25\nO - 8\nP - 2");
		}
		if(e.getSource()==Gd){
			JOptionPane.showMessageDialog(null, "Número Atômico: 64\nMassa: 157,25\nDistribuição Eletronica:\nK - 2\nL - 8\nM - 18\nN - 25\nO - 9\nP - 2");
		}
		if(e.getSource()==Tb){
			JOptionPane.showMessageDialog(null, "Número Atômico: 65\nMassa: 158,92535\nDistribuição Eletronica:\nK - 2\nL - 8\nM - 18\nN - 27\nO - 8\nP - 2");
		}
		if(e.getSource()==Dy){
			JOptionPane.showMessageDialog(null, "Número Atômico: 66\nMassa: 162,5\nDistribuição Eletronica:\nK - 2\nL - 8\nM - 18\nN - 28\nO - 8\nP - 2");
		}
		if(e.getSource()==Ho){
			JOptionPane.showMessageDialog(null, "Número Atômico: 67\nMassa: 164,93032\nDistribuição Eletronica:\nK - 2\nL - 8\nM - 18\nN - 29\nO - 8\nP - 2");
		}
		if(e.getSource()==Er){
			JOptionPane.showMessageDialog(null, "Número Atômico: 68\nMassa: 167,259\nDistribuição Eletronica:\nK - 2\nL - 8\nM - 18\nN - 30\nO - 8\nP - 2");
		}
		if(e.getSource()==Tm){
			JOptionPane.showMessageDialog(null, "Número Atômico: 69\nMassa: 168,93421\nDistribuição Eletronica:\nK - 2\nL - 8\nM - 18\nN - 31\nO - 8\nP - 2");
		}
		if(e.getSource()==Yb){
			JOptionPane.showMessageDialog(null, "Número Atômico: 70\nMassa: 173,054\nDistribuição Eletronica:\nK - 2\nL - 8\nM - 18\nN - 32\nO - 8\nP - 2");
		}
		if(e.getSource()==Lu){
			JOptionPane.showMessageDialog(null, "Número Atômico: 71\nMassa: 174,9668\nDistribuição Eletronica:\nK - 2\nL - 8\nM - 18\nN - 32\nO - 9\nP - 2");
		}
		//Act
		if(e.getSource()==Ac){
			JOptionPane.showMessageDialog(null, "Número Atômico: 89\nMassa: 227\nDistribuição Eletronica:\nK - 2\nL - 8\nM - 18\nN - 32\nO - 18\nP - 9\nQ - 2");
		}
		if(e.getSource()==Th){
			JOptionPane.showMessageDialog(null, "Número Atômico: 90\nMassa: 232,03806\nDistribuição Eletronica:\nK - 2\nL - 8\nM - 18\nN - 32\nO - 18\nP - 10\nQ - 2");
		}
	    if(e.getSource()==Pa){
	    	JOptionPane.showMessageDialog(null, "Número Atômico: 91\nMassa: 231,03588\nDistribuição Eletronica:\nK - 2\nL - 8\nM - 18\nN - 32\nO - 20\nP - 9\nQ - 2");
	    }
		if(e.getSource()==U){
			JOptionPane.showMessageDialog(null, "Número Atômico: 92\nMassa: 238,02891\nDistribuição Eletronica:\nK - 2\nL - 8\nM - 18\nN - 32\nO - 21\nP - 9\nQ - 2");
		}
		if(e.getSource()==Np){
			JOptionPane.showMessageDialog(null, "Número Atômico: 93\nMassa: 237\nDistribuição Eletronica:\nK - 2\nL - 8\nM - 18\nN - 32\nO - 22\nP - 9\nQ - 2");
		}
		if(e.getSource()==Pu){
			JOptionPane.showMessageDialog(null, "Número Atômico: 94\nMassa: 244\nDistribuição Eletronica:\nK - 2\nL - 8\nM - 18\nN - 32\nO - 24\nP - 8\nQ - 2");
		}
		if(e.getSource()==Am){
			JOptionPane.showMessageDialog(null, "Número Atômico: 95\nMassa: 243\nDistribuição Eletronica:\nK - 2\nL - 8\nM - 18\nN - 32\nO - 25\nP - 8\nQ - 2");
		}
		if(e.getSource()==Cm){
			JOptionPane.showMessageDialog(null, "Número Atômico: 96\nMassa: 247\nDistribuição Eletronica:\nK - 2\nL - 8\nM - 18\nN - 32\nO - 25\nP - 9\nQ - 2");
		}
		if(e.getSource()==Bk){
			JOptionPane.showMessageDialog(null, "Número Atômico: 97\nMassa: 247\nDistribuição Eletronica:\nK - 2\nL - 8\nM - 18\nN - 32\nO - 27\nP - 8\nQ - 2");
		}
		if(e.getSource()==Cf){
			JOptionPane.showMessageDialog(null, "Número Atômico: 98\nMassa: 251\nDistribuição Eletronica:\nK - 2\nL - 8\nM - 18\nN - 32\nO - 28\nP - 8\nQ - 2");
		}
		if(e.getSource()==Es){
			JOptionPane.showMessageDialog(null, "Número Atômico: 99\nMassa: 252\nDistribuição Eletronica:\nK - 2\nL - 8\nM - 18\nN - 32\nO - 29\nP - 8\nQ - 2");
		}
		if(e.getSource()==Fm){
			JOptionPane.showMessageDialog(null, "Número Atômico: 100\nMassa: 257\nDistribuição Eletronica:\nK - 2\nL - 8\nM - 18\nN - 32\nO - 30\nP - 8\nQ - 2");
		}
		if(e.getSource()==Md){
			JOptionPane.showMessageDialog(null, "Número Atômico: 101\nMassa: 258\nDistribuição Eletronica:\nK - 2\nL - 8\nM - 18\nN - 32\nO - 31\nP - 8\nQ - 2");
		}
		if(e.getSource()==No){
			JOptionPane.showMessageDialog(null, "Número Atômico: 102\nMassa: 259\nDistribuição Eletronica:\nK - \nK - 2\nL - 8\nM - 18\nN - 32\nO - 32\nP - 8\nQ - 2");
		}
		if(e.getSource()==Lr){
			JOptionPane.showMessageDialog(null, "Número Atômico: 103\nMassa: 262\nDistribuição Eletronica:\nK - 2\nL - 8\nM - 18\nN - 32\nO - 32\nP - 8\nQ - 3");
		}
		//Informações adicionais
		if(e.getSource()==Info){
			JLabel infoAdicional = new JLabel(null, ImageInfo, JLabel.CENTER);
			infoAdicional.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			//JOptionPane.showMessageDialog(null, new JLabel(null, ImageInfo, JLabel.CENTER), "Informações adicionais", JOptionPane.DEFAULT_OPTION);
			JOptionPane.showMessageDialog(null, infoAdicional, "Informações adicionais", JOptionPane.DEFAULT_OPTION);
		}
		//Fontes
		if(e.getSource()==Fontes){
			JOptionPane.showMessageDialog(null, "<html>http://www.sbq.org.br/produto/tabela-peri%C3%B3dica-tamanho-grande-100x70-cm<br>http://www.2016online.com.br/2014/11/tabela-periodica-atualizada.html<br>http://www.tabelaperiodicacompleta.com/");
		}
	}
	
	public void adicionaFunc(){
		H.addActionListener(this);
		Li.addActionListener(this);
		Na.addActionListener(this);
		K.addActionListener(this);
		Rb.addActionListener(this);
		Cs.addActionListener(this);
		Fr.addActionListener(this);
		//2A
		Be.addActionListener(this);
		Mg.addActionListener(this);
		Ca.addActionListener(this);
		Sr.addActionListener(this);
		Ba.addActionListener(this);
		Ra.addActionListener(this);
		//3B
		Sc.addActionListener(this);
		Y.addActionListener(this);
		//4B
		Ti.addActionListener(this);
		Zr.addActionListener(this);
		Hf.addActionListener(this);
		Rf.addActionListener(this);
		//5B
		V.addActionListener(this);
		Nb.addActionListener(this);
		Ta.addActionListener(this);
		Db.addActionListener(this);
		//6B
		Cr.addActionListener(this);
		Mo.addActionListener(this);
		W.addActionListener(this);
		Sg.addActionListener(this);
		//7B
		Mn.addActionListener(this);
		Tc.addActionListener(this);
		Re.addActionListener(this);
		Bh.addActionListener(this);
		//8B
		Fe.addActionListener(this);
		Ru.addActionListener(this);
		Os.addActionListener(this);
		Hs.addActionListener(this);
		Co.addActionListener(this);
		Rh.addActionListener(this);
		Ir.addActionListener(this);
		Mt.addActionListener(this);
		Ni.addActionListener(this);
		Pd.addActionListener(this);
		Pt.addActionListener(this);
		Ds.addActionListener(this);
		//1B
		Cu.addActionListener(this);
		Ag.addActionListener(this);
		Au.addActionListener(this);
		Rg.addActionListener(this);
		//2B
		Zn.addActionListener(this);
		Cd.addActionListener(this);
		Hg.addActionListener(this);
		Cn.addActionListener(this);
		//3A
		B.addActionListener(this);
		Al.addActionListener(this);
		Ga.addActionListener(this);
		In.addActionListener(this);
		Tl.addActionListener(this);
		Uut.addActionListener(this);
		//4A
		C.addActionListener(this);
		Si.addActionListener(this);
		Ge.addActionListener(this);
		Sn.addActionListener(this);
		Pb.addActionListener(this);
		Fl.addActionListener(this);
		//5A
		N.addActionListener(this);
		P.addActionListener(this);
		As.addActionListener(this);
		Sb.addActionListener(this);
		Bi.addActionListener(this);
		Uup.addActionListener(this);
		//6A
		O.addActionListener(this);
		S.addActionListener(this);
		Se.addActionListener(this);
		Te.addActionListener(this);
		Po.addActionListener(this);
		Lv.addActionListener(this);
		//7A
		F.addActionListener(this);
		Cl.addActionListener(this);
		Br.addActionListener(this);
		I.addActionListener(this);
		At.addActionListener(this);
		Uus.addActionListener(this);
		//8A
		He.addActionListener(this);
		Ne.addActionListener(this);
		Ar.addActionListener(this);
		Kr.addActionListener(this);
		Xe.addActionListener(this);
		Rn.addActionListener(this);
		Uuo.addActionListener(this);
		//Lantanideos
		La.addActionListener(this);
		Ce.addActionListener(this);
		Pr.addActionListener(this);
		Nd.addActionListener(this);
		Pm.addActionListener(this);
		Sm.addActionListener(this);
		Eu.addActionListener(this);
		Gd.addActionListener(this);
		Tb.addActionListener(this);
		Dy.addActionListener(this);
		Ho.addActionListener(this);
		Er.addActionListener(this);
		Tm.addActionListener(this);
		Yb.addActionListener(this);
		Lu.addActionListener(this);
		//Actinideos
		Ac.addActionListener(this);
		Th.addActionListener(this);
		Pa.addActionListener(this);
		U.addActionListener(this);
		Np.addActionListener(this);
		Pu.addActionListener(this);
		Am.addActionListener(this);
		Cm.addActionListener(this);
		Bk.addActionListener(this);
		Cf.addActionListener(this);
		Es.addActionListener(this);
		Fm.addActionListener(this);
		Md.addActionListener(this);
		No.addActionListener(this);
		Lr.addActionListener(this);
		//Informações adicionais
		Info.addActionListener(this);
		//Fontes
		Fontes.addActionListener(this);
	}
}
