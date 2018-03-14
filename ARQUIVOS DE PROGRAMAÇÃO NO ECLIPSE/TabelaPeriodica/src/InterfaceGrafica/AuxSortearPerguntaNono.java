package InterfaceGrafica;

import javax.swing.JOptionPane;

public class AuxSortearPerguntaNono {
	private Aluno aluno;
	
	public void proximaPergunta(InterfaceGrafica.Aluno aluno){	//Inicia a próxima pergunta, acredito que aqui que deveria colocar o verificador do Destrave
		this.aluno = aluno;
		this.aluno.setIndiceDestrave(this.aluno.getIndiceDestrave()+1);		//Atualiza o índice de destrave do aluno
		if(this.aluno.vazioPerguntaIndividual()==false){	//Se ainda tiver perguntas armazenadas
			int numeroDaPergunta = this.aluno.getPergIndividual();	//Sorteia um indice do array
			switch(numeroDaPergunta){
				case 1:
					this.aluno.apagarPerguntaIndividual();
					perguntasNonoAno.Pergunta1 p1 = new perguntasNonoAno.Pergunta1(this.aluno);
					break;
				case 2:
					this.aluno.apagarPerguntaIndividual();
					perguntasNonoAno.Pergunta2 p2 = new perguntasNonoAno.Pergunta2(this.aluno);
				 	break;
				case 3:
					this.aluno.apagarPerguntaIndividual();
					perguntasNonoAno.Pergunta3 p3 = new perguntasNonoAno.Pergunta3(this.aluno);
					break;
				case 4:
					this.aluno.apagarPerguntaIndividual();
					perguntasNonoAno.Pergunta4 p4 = new perguntasNonoAno.Pergunta4(this.aluno);
					break;
				case 5:
					this.aluno.apagarPerguntaIndividual();
					perguntasNonoAno.Pergunta5 p5 = new perguntasNonoAno.Pergunta5(this.aluno);
					break;
				case 6:
					this.aluno.apagarPerguntaIndividual();
					perguntasNonoAno.Pergunta6 p6 = new perguntasNonoAno.Pergunta6(this.aluno);
					break;
				case 7:
					this.aluno.apagarPerguntaIndividual();
					perguntasNonoAno.Pergunta7 p7 = new perguntasNonoAno.Pergunta7(this.aluno);
					break;
				case 8:
					this.aluno.apagarPerguntaIndividual();
					perguntasNonoAno.Pergunta8 p8 = new perguntasNonoAno.Pergunta8(this.aluno);
					break;
				case 9:
					this.aluno.apagarPerguntaIndividual();
					perguntasNonoAno.Pergunta9 p9 = new perguntasNonoAno.Pergunta9(this.aluno);
					break;
				case 10:
					this.aluno.apagarPerguntaIndividual();
					perguntasNonoAno.Pergunta10 p10 = new perguntasNonoAno.Pergunta10(this.aluno);
					break;
				case 11:
					this.aluno.apagarPerguntaIndividual();
					perguntasNonoAno.Pergunta11 p11 = new perguntasNonoAno.Pergunta11(this.aluno);
					break;
				case 12:
					this.aluno.apagarPerguntaIndividual();
					perguntasNonoAno.Pergunta12 p12 = new perguntasNonoAno.Pergunta12(this.aluno);
					break;
				case 13:
					this.aluno.apagarPerguntaIndividual();
					perguntasNonoAno.Pergunta13 p13 = new perguntasNonoAno.Pergunta13(this.aluno);
					break;
				case 14:
					this.aluno.apagarPerguntaIndividual();
					perguntasNonoAno.Pergunta14 p14 = new perguntasNonoAno.Pergunta14(this.aluno);
					break;
				case 15:
					this.aluno.apagarPerguntaIndividual();
					perguntasNonoAno.Pergunta15 p15 = new perguntasNonoAno.Pergunta15(this.aluno);
					break;
				case 16:
					this.aluno.apagarPerguntaIndividual();
					perguntasNonoAno.Pergunta16 p16 = new perguntasNonoAno.Pergunta16(this.aluno);
					break;
				case 17:
					this.aluno.apagarPerguntaIndividual();
					perguntasNonoAno.Pergunta17 p17 = new perguntasNonoAno.Pergunta17(this.aluno);
					break;
				case 18:
					this.aluno.apagarPerguntaIndividual();
					perguntasNonoAno.Pergunta18 p18 = new perguntasNonoAno.Pergunta18(this.aluno);
					break;
				case 19:
					this.aluno.apagarPerguntaIndividual();
					perguntasNonoAno.Pergunta19 p19 = new perguntasNonoAno.Pergunta19(this.aluno);
					break;
				case 20:
					this.aluno.apagarPerguntaIndividual();
					perguntasNonoAno.Pergunta20 p20 = new perguntasNonoAno.Pergunta20(this.aluno);
					break;
				case 21:
					this.aluno.apagarPerguntaIndividual();
					perguntasNonoAno.Pergunta21 p21 = new perguntasNonoAno.Pergunta21(this.aluno);
					break;
				case 22:
					this.aluno.apagarPerguntaIndividual();
					perguntasNonoAno.Pergunta22 p22 = new perguntasNonoAno.Pergunta22(this.aluno);
					break;
				case 23:
					this.aluno.apagarPerguntaIndividual();
					perguntasNonoAno.Pergunta23 p23 = new perguntasNonoAno.Pergunta23(this.aluno);
					break;
				case 24:
					this.aluno.apagarPerguntaIndividual();
					perguntasNonoAno.Pergunta24 p24 = new perguntasNonoAno.Pergunta24(this.aluno);
					break;
				case 25:
					this.aluno.apagarPerguntaIndividual();
					perguntasNonoAno.Pergunta25 p25 = new perguntasNonoAno.Pergunta25(this.aluno);
					break;
				case 26:
					this.aluno.apagarPerguntaIndividual();
					perguntasNonoAno.Pergunta26 p26 = new perguntasNonoAno.Pergunta26(this.aluno);
					break;
				case 27:
					this.aluno.apagarPerguntaIndividual();
					perguntasNonoAno.Pergunta27 p27 = new perguntasNonoAno.Pergunta27(this.aluno);
					break;
				case 28:
					this.aluno.apagarPerguntaIndividual();
					perguntasNonoAno.Pergunta28 p28 = new perguntasNonoAno.Pergunta28(this.aluno);
					break;
				case 29:
					this.aluno.apagarPerguntaIndividual();
					perguntasNonoAno.Pergunta29 p29 = new perguntasNonoAno.Pergunta29(this.aluno);
					break;
				case 30:
					this.aluno.apagarPerguntaIndividual();
					perguntasNonoAno.Pergunta30 p30 = new perguntasNonoAno.Pergunta30(this.aluno);
					break;
				case 31:
					this.aluno.apagarPerguntaIndividual();
					perguntasNonoAno.Pergunta31 p31 = new perguntasNonoAno.Pergunta31(this.aluno);
					break;
				case 32:
					this.aluno.apagarPerguntaIndividual();
					perguntasNonoAno.Pergunta32 p32 = new perguntasNonoAno.Pergunta32(this.aluno);
					break;
				case 33:
					this.aluno.apagarPerguntaIndividual();
					perguntasNonoAno.Pergunta33 p33 = new perguntasNonoAno.Pergunta33(this.aluno);
					break;
				case 34:
					this.aluno.apagarPerguntaIndividual();
					perguntasNonoAno.Pergunta34 p34 = new perguntasNonoAno.Pergunta34(this.aluno);
					break;
				case 35:
					this.aluno.apagarPerguntaIndividual();
					perguntasNonoAno.Pergunta35 p35 = new perguntasNonoAno.Pergunta35(this.aluno);
					break;
				case 36:
					this.aluno.apagarPerguntaIndividual();
					perguntasNonoAno.Pergunta36 p36 = new perguntasNonoAno.Pergunta36(this.aluno);
					break;
				case 37:
					this.aluno.apagarPerguntaIndividual();
					perguntasNonoAno.Pergunta37 p37 = new perguntasNonoAno.Pergunta37(this.aluno);
					break;
				case 38:
					this.aluno.apagarPerguntaIndividual();
					perguntasNonoAno.Pergunta38 p38 = new perguntasNonoAno.Pergunta38(this.aluno);
					break;
				case 39:
					this.aluno.apagarPerguntaIndividual();
					perguntasNonoAno.Pergunta39 p39 = new perguntasNonoAno.Pergunta39(this.aluno);
					break;
				case 40:
					this.aluno.apagarPerguntaIndividual();
					perguntasNonoAno.Pergunta40 p40 = new perguntasNonoAno.Pergunta40(this.aluno);
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