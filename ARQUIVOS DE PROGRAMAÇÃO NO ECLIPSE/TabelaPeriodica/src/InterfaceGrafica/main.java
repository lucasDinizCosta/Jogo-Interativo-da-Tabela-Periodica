/**	
 * 	Última atualização: 13-12-2016	21:36
 * 	Programador: Lucas Diniz da Costa
 * 	Designers: Lívia Caniato e Adriano Santos
 * 	Projeto do do jogo interativo da tabela periódica desenvolvido para o Centro de Ciências da Universidade Federal de Juiz de Fora
 */

package InterfaceGrafica;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.JOptionPane;

public class main {
	private String nomeComputadorCentral = "";
	
	public void guardarNomeComputadorCentral(){
		try{
			Path arquivoNomeComputadorCentral = Paths.get("NomeComputadorCentral.txt");
			if(arquivoNomeComputadorCentral.toFile().exists()==true){
				Charset cs = Charset.forName("UTF-8");
				FileInputStream caminhoDoArquivo = new FileInputStream("NomeComputadorCentral.txt");	//Lê o arquivo de texto,  obrigatorio passar um caminho/path no construtor, faz a leitura de dados binários não importando a fonte
				InputStreamReader tradutorEncode = new InputStreamReader(caminhoDoArquivo, cs); 	//traduz os bytes com o encoding dado para o respectivo código, em outras palavras é um decodificador para o o encode específico nesse caso "UTF-8" mas poderia ser "ISO-8859-1"
																									//lê bytes de um lado, converte em caracteres do outro, através do uso de uma codificação de caracteres (encoding)
				BufferedReader bufferNomeComputadorCentral = new BufferedReader(tradutorEncode);	//concatena os diversos chars para formar uma String através do método readLine
				String linha = bufferNomeComputadorCentral.readLine();
				linha = linha.substring(linha.indexOf("(")+1, linha.indexOf(")"));
				nomeComputadorCentral = linha;
				bufferNomeComputadorCentral.close();
			}
			else if(arquivoNomeComputadorCentral.toFile().exists()==false){
				JOptionPane.showMessageDialog(null, "O Arquivo 'NomeComputadorCentral.txt' não foi encontrado na diretório, avise o responsável sobre o ocorrido.");
				System.exit(0);
			}
		}
		catch(Exception erro){
			erro.printStackTrace();
		}
	}
	
	public String getNomeComputadorCentral(){
		return nomeComputadorCentral;
	}
	
	public static void main(String[] args) {
		main m = new main();
		m.guardarNomeComputadorCentral();
		JanelaPrincipal jp = new JanelaPrincipal(m.getNomeComputadorCentral());
		
		/**
		 * MÉTODO ABAIXO PARA TESTAR O RELATÓRIO
		 */
		/*
			Aluno a = new Aluno("Lucas Diniz da Costa", "1º Ano", null, true);
			a.setDados();	//METODO PRA TESTAR A EMISSÃO DO RELATÓRIO
			relatorio r = new relatorio(a, nomeComputadorCentral);
		 */
		
		/**
		 * MÉTODO ABAIXO PARA TESTAR PERGUNTAS
		 */
		/*
			//ELE IRÁ TESTAR A PRIMEIRA PERGUNTA DO VETOR
			Aluno a = new Aluno("NOME", "ANO", null, true);
			a.testeSorteio(1, 1, 3, 4, 5, 6, 7, 8, 9, 10);
			
			//SE FOR NONO ANO
			AuxSortearPerguntaNono aux = new AuxSortearPerguntaNono();
			
			//SE FOR ENSINO MEDIO
			//AuxSortearPerguntaEnsinoMedio aux = new AuxSortearPerguntaEnsinoMedio();
			
			a.setIndiceDestrave(0);
			aux.proximaPergunta(a);
		*/
	}
}