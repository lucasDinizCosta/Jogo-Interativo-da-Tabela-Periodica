package InterfaceGrafica;

import javax.swing.JOptionPane;

public class AuxSortearPerguntaEnsinoMedio{
	private Aluno aluno;
		
	public void proximaPergunta(InterfaceGrafica.Aluno aluno){
		this.aluno = aluno;		//O Aluno auxiliar recebe os dados do Aluno criado no janela principal
		this.aluno.setIndiceDestrave(this.aluno.getIndiceDestrave()+1);		//Atualiza o índice de destrave do aluno
		if(this.aluno.vazioPerguntaIndividual()==false){	//Se o arraylist de Pergunta individual não estiver vazio, ou seja ele ainda tem perguntas a serem respondidas
			int numeroDaPergunta = this.aluno.getPergIndividual();	//Sorteia um indice do array
			switch (numeroDaPergunta) {
			case 1:
				this.aluno.apagarPerguntaIndividual();
				perguntasEnsinoMedio.Pergunta1 p1 = new perguntasEnsinoMedio.Pergunta1(this.aluno);
				break;
			case 2:
				this.aluno.apagarPerguntaIndividual();
				perguntasEnsinoMedio.Pergunta2 p2 = new perguntasEnsinoMedio.Pergunta2(this.aluno);
				break;
			case 3:
				this.aluno.apagarPerguntaIndividual();
				perguntasEnsinoMedio.Pergunta3 p3 = new perguntasEnsinoMedio.Pergunta3(this.aluno);
				break;
			case 4:
				this.aluno.apagarPerguntaIndividual();
				perguntasEnsinoMedio.Pergunta4 p4 = new perguntasEnsinoMedio.Pergunta4(this.aluno);
				break;
			case 5:
				this.aluno.apagarPerguntaIndividual();
				perguntasEnsinoMedio.Pergunta5 p5 = new perguntasEnsinoMedio.Pergunta5(this.aluno);
				break;
			case 6:
				this.aluno.apagarPerguntaIndividual();
				perguntasEnsinoMedio.Pergunta6 p6 = new perguntasEnsinoMedio.Pergunta6(this.aluno);
				break;
			case 7:
				this.aluno.apagarPerguntaIndividual();
				perguntasEnsinoMedio.Pergunta7 p7 = new perguntasEnsinoMedio.Pergunta7(this.aluno);
				break;
			case 8:
				this.aluno.apagarPerguntaIndividual();
				perguntasEnsinoMedio.Pergunta8 p8 = new perguntasEnsinoMedio.Pergunta8(this.aluno);
				break;
			case 9:
				this.aluno.apagarPerguntaIndividual();
				perguntasEnsinoMedio.Pergunta9 p9 = new perguntasEnsinoMedio.Pergunta9(this.aluno);
				break;
			case 10:
				this.aluno.apagarPerguntaIndividual();
				perguntasEnsinoMedio.Pergunta10 p10 = new perguntasEnsinoMedio.Pergunta10(this.aluno);
				break;
			case 11:
				this.aluno.apagarPerguntaIndividual();
				perguntasEnsinoMedio.Pergunta11 p11 = new perguntasEnsinoMedio.Pergunta11(this.aluno);
				break;
			case 12:
				this.aluno.apagarPerguntaIndividual();
				perguntasEnsinoMedio.Pergunta12 p12 = new perguntasEnsinoMedio.Pergunta12(this.aluno);
				break;
			case 13:
				this.aluno.apagarPerguntaIndividual();
				perguntasEnsinoMedio.Pergunta13 p13 = new perguntasEnsinoMedio.Pergunta13(this.aluno);
				break;
			case 14:
				this.aluno.apagarPerguntaIndividual();
				perguntasEnsinoMedio.Pergunta14 p14 = new perguntasEnsinoMedio.Pergunta14(this.aluno);
				break;
			case 15:
				this.aluno.apagarPerguntaIndividual();
				perguntasEnsinoMedio.Pergunta15 p15 = new perguntasEnsinoMedio.Pergunta15(this.aluno);
				break;
			case 16:
				this.aluno.apagarPerguntaIndividual();
				perguntasEnsinoMedio.Pergunta16 p16 = new perguntasEnsinoMedio.Pergunta16(this.aluno);
				break;
			case 17:
				this.aluno.apagarPerguntaIndividual();
				perguntasEnsinoMedio.Pergunta17 p17 = new perguntasEnsinoMedio.Pergunta17(this.aluno);
				break;
			case 18:
				this.aluno.apagarPerguntaIndividual();
				perguntasEnsinoMedio.Pergunta18 p18 = new perguntasEnsinoMedio.Pergunta18(this.aluno);
				break;
			case 19:
				this.aluno.apagarPerguntaIndividual();
				perguntasEnsinoMedio.Pergunta19 p19 = new perguntasEnsinoMedio.Pergunta19(this.aluno);
				break;
			case 20:
				this.aluno.apagarPerguntaIndividual();
				perguntasEnsinoMedio.Pergunta20 p20 = new perguntasEnsinoMedio.Pergunta20(this.aluno);
				break;
			case 21:
				this.aluno.apagarPerguntaIndividual();
				perguntasEnsinoMedio.Pergunta21 p21 = new perguntasEnsinoMedio.Pergunta21(this.aluno);
				break;
			case 22:
				this.aluno.apagarPerguntaIndividual();
				perguntasEnsinoMedio.Pergunta22 p22 = new perguntasEnsinoMedio.Pergunta22(this.aluno);
				break;
			case 23:
				this.aluno.apagarPerguntaIndividual();
				perguntasEnsinoMedio.Pergunta23 p23 = new perguntasEnsinoMedio.Pergunta23(this.aluno);
				break;
			case 24:
				this.aluno.apagarPerguntaIndividual();
				perguntasEnsinoMedio.Pergunta24 p24 = new perguntasEnsinoMedio.Pergunta24(this.aluno);
				break;
			case 25:
				this.aluno.apagarPerguntaIndividual();
				perguntasEnsinoMedio.Pergunta25 p25 = new perguntasEnsinoMedio.Pergunta25(this.aluno);
				break;
			case 26:
				this.aluno.apagarPerguntaIndividual();
				perguntasEnsinoMedio.Pergunta26 p26 = new perguntasEnsinoMedio.Pergunta26(this.aluno);
				break;
			case 27:
				this.aluno.apagarPerguntaIndividual();
				perguntasEnsinoMedio.Pergunta27 p27 = new perguntasEnsinoMedio.Pergunta27(this.aluno);
				break;
			case 28:
				this.aluno.apagarPerguntaIndividual();
				perguntasEnsinoMedio.Pergunta28 p28 = new perguntasEnsinoMedio.Pergunta28(this.aluno);
				break;
			case 29:
				this.aluno.apagarPerguntaIndividual();
				perguntasEnsinoMedio.Pergunta29 p29 = new perguntasEnsinoMedio.Pergunta29(this.aluno);
				break;
			case 30:
				this.aluno.apagarPerguntaIndividual();
				perguntasEnsinoMedio.Pergunta30 p30 = new perguntasEnsinoMedio.Pergunta30(this.aluno);
				break;
			case 31:
				this.aluno.apagarPerguntaIndividual();
				perguntasEnsinoMedio.Pergunta31 p31 = new perguntasEnsinoMedio.Pergunta31(this.aluno);
				break;
			case 32:
				this.aluno.apagarPerguntaIndividual();
				perguntasEnsinoMedio.Pergunta32 p32 = new perguntasEnsinoMedio.Pergunta32(this.aluno);
				break;
			case 33:
				this.aluno.apagarPerguntaIndividual();
				perguntasEnsinoMedio.Pergunta33 p33 = new perguntasEnsinoMedio.Pergunta33(this.aluno);
				break;
			case 34:
				this.aluno.apagarPerguntaIndividual();
				perguntasEnsinoMedio.Pergunta34 p34 = new perguntasEnsinoMedio.Pergunta34(this.aluno);
				break;
			case 35:
				this.aluno.apagarPerguntaIndividual();
				perguntasEnsinoMedio.Pergunta35 p35 = new perguntasEnsinoMedio.Pergunta35(this.aluno);
				break;
			case 36:
				this.aluno.apagarPerguntaIndividual();
				perguntasEnsinoMedio.Pergunta36 p36 = new perguntasEnsinoMedio.Pergunta36(this.aluno);
				break;
			case 37:
				this.aluno.apagarPerguntaIndividual();
				perguntasEnsinoMedio.Pergunta37 p37 = new perguntasEnsinoMedio.Pergunta37(this.aluno);
				break;
			case 38:
				this.aluno.apagarPerguntaIndividual();
				perguntasEnsinoMedio.Pergunta38 p38 = new perguntasEnsinoMedio.Pergunta38(this.aluno);
				break;
			case 39:
				this.aluno.apagarPerguntaIndividual();
				perguntasEnsinoMedio.Pergunta39 p39 = new perguntasEnsinoMedio.Pergunta39(this.aluno);
				break;
			case 40:
				this.aluno.apagarPerguntaIndividual();
				perguntasEnsinoMedio.Pergunta40 p40 = new perguntasEnsinoMedio.Pergunta40(this.aluno);
				break;
			default: System.out.println("Erro");
			}
		}
		else{	//Se a.vazioPerguntaIndividual()==true	
			JOptionPane.showMessageDialog(null, "Obrigado por ter jogado");
			InterfaceGrafica.relatorio relatorio = new InterfaceGrafica.relatorio(this.aluno, this.aluno.getNomeComputadorCentral());
		}
	}
}