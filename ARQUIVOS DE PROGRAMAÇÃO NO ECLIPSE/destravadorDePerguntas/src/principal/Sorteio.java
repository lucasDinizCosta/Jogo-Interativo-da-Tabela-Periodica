package principal;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Sorteio {
	
	private String quebraLinha = System.lineSeparator();
	private Path caminho = Paths.get("Perguntas.txt");
	private Random Sorteio = new Random();	//Vari�vel usada para acessar os m�todos da classe Random
	private int numeroAleatorio; 			//Representa o numero sorteado da pergunta
	private ArrayList<Integer> perguntasSorteadasGeral = new ArrayList<Integer>(); //Armazenada as 10 perguntas sorteadas
	
	public void verificaExistencia(){	//Verifica se o arquivo existe ou n�o
		String textoTeste = "";
		byte[] textoEmByte = textoTeste.getBytes(); //array de bytes, converte o texto digitado para Bytes
		try{
			if(caminho.toFile().exists()==false){	//verifica se o arquivo de texto n�o existe
				caminho.toFile().setExecutable(true);
				caminho.toFile().setReadable(true);		//Fornece permiss�o para poder escrever, ler e executar o arquivo
				caminho.toFile().setWritable(true);
				Files.write(caminho, textoEmByte);	//Cria o arquivo de texto no caminho a partir de uma string convertida em um vetor de Bytes
			}
			else if(caminho.toFile().exists()==true){	//Se o arquivo de texto existir, ser� deletado e criado um novo
				caminho.toFile().setExecutable(true);
				caminho.toFile().setReadable(true);		//Fornece permiss�o para poder escrever, ler e executar o arquivo
				caminho.toFile().setWritable(true);
				Files.write(caminho, textoEmByte);	
													
			}
		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println("Erro na existencia do arquivo");
		}
	}
	
	public void sortearPerguntasNonoAno(){
		verificaExistencia();
		numeroAleatorio = Sorteio.nextInt(40)+1;	
		while(perguntasSorteadasGeral.size()<10){	//Sorteia todas as perguntas entre as 40 perguntas do Nono Ano
			numeroAleatorio = Sorteio.nextInt(40)+1;
			if(perguntasSorteadasGeral.contains(numeroAleatorio)==false){	//Adiciona somente perguntas diferentes
				perguntasSorteadasGeral.add(numeroAleatorio);
			}
		}
		try{
			int numLinha = 0;	//Respons�vel por pegar cada posi��o do arraylist das perguntas sorteadas
			byte[] texto = Files.readAllBytes(caminho); //Ir� retornar um array de bytes
			String leitura = new String(texto);			//O Texto em bytes foi passado como parametro e � convertido para string
			while(numLinha<10){							//L� as linhas do arquivo de texto
				switch(numLinha){
				case 0:
					leitura = leitura + Integer.toString(perguntasSorteadasGeral.get(numLinha));
					break;
				case 1:
					leitura = leitura + quebraLinha + Integer.toString(perguntasSorteadasGeral.get(numLinha));
					break;
				case 2:
					leitura = leitura + quebraLinha + Integer.toString(perguntasSorteadasGeral.get(numLinha));
					break;
				case 3:
					leitura = leitura + quebraLinha + Integer.toString(perguntasSorteadasGeral.get(numLinha));
					break;
				case 4:
					leitura = leitura + quebraLinha + Integer.toString(perguntasSorteadasGeral.get(numLinha));
					break;
				case 5:
					leitura = leitura + quebraLinha + Integer.toString(perguntasSorteadasGeral.get(numLinha));
					break;
				case 6:
					leitura = leitura + quebraLinha + Integer.toString(perguntasSorteadasGeral.get(numLinha));
					break;
				case 7:
					leitura = leitura + quebraLinha + Integer.toString(perguntasSorteadasGeral.get(numLinha));
					break;
				case 8:
					leitura = leitura + quebraLinha + Integer.toString(perguntasSorteadasGeral.get(numLinha));
					break;
				case 9:
					System.out.println("Perguntas Sorteadas com sucesso.");
					leitura = leitura + quebraLinha + Integer.toString(perguntasSorteadasGeral.get(numLinha));
					break;
				default: System.out.println("Erro no switch do Sorteio.");
				}
				numLinha++;
			}
			Files.write(caminho, leitura.getBytes());	//Cria o arquivo de texto com as perguntas de uma vez s�
		}catch(Exception erro){
			erro.printStackTrace();
			System.out.println("Erro na leitura de arquivos");
		}
	}
	
	public void sortearPerguntasEnsinoMedio(){
		verificaExistencia();
		numeroAleatorio = Sorteio.nextInt(40)+1;	
		while(perguntasSorteadasGeral.size()<10){	//Sorteia todas as perguntas entre as 40 perguntas do Ensino M�dio
			numeroAleatorio = Sorteio.nextInt(40)+1;
			if(perguntasSorteadasGeral.contains(numeroAleatorio)==false){
				perguntasSorteadasGeral.add(numeroAleatorio);
			}
		}
		try{
			int numLinha = 0;	//Respons�vel por pegar cada posi��o do arraylist das perguntas sorteadas
			byte[] texto = Files.readAllBytes(caminho); 	//Ir� retornar um array de bytes
			String leitura = new String(texto);				//O Texto em bytes foi passado como parametro e � convertido para string
			while(numLinha<10){
				switch(numLinha){
				case 0:
					leitura = leitura + Integer.toString(perguntasSorteadasGeral.get(numLinha));
					break;
				case 1:
					leitura = leitura + quebraLinha + Integer.toString(perguntasSorteadasGeral.get(numLinha));
					break;
				case 2:
					leitura = leitura + quebraLinha + Integer.toString(perguntasSorteadasGeral.get(numLinha));
					break;
				case 3:
					leitura = leitura + quebraLinha + Integer.toString(perguntasSorteadasGeral.get(numLinha));
					break;
				case 4:
					leitura = leitura + quebraLinha + Integer.toString(perguntasSorteadasGeral.get(numLinha));
					break;
				case 5:
					leitura = leitura + quebraLinha + Integer.toString(perguntasSorteadasGeral.get(numLinha));
					break;
				case 6:
					leitura = leitura + quebraLinha + Integer.toString(perguntasSorteadasGeral.get(numLinha));
					break;
				case 7:
					leitura = leitura + quebraLinha + Integer.toString(perguntasSorteadasGeral.get(numLinha));
					break;
				case 8:
					leitura = leitura + quebraLinha + Integer.toString(perguntasSorteadasGeral.get(numLinha));
					break;
				case 9:
					System.out.println("Perguntas Sorteadas com sucesso.");
					leitura = leitura + quebraLinha + Integer.toString(perguntasSorteadasGeral.get(numLinha));
					break;
				default: System.out.println("Erro no switch do Sorteio.");
				}
				numLinha++;
			}
			Files.write(caminho, leitura.getBytes());	//Cria o arquivo de texto com as perguntas de uma vez s�
		}catch(Exception erro){
			erro.printStackTrace();
			System.out.println("Erro na leitura de arquivos");
		}
	}
	
	/**
	 * Retorna se o arquivo das perguntas sorteadas est� vazio ou n�o
	 */
	
	public boolean getVazioSorteio(){
		try{
			int tamanho = 0;
			Scanner scan = new Scanner(caminho, "UTF-8");	//Vari�vel de leitura do Arquivo de Texto
			byte[] texto = Files.readAllBytes(caminho); 	// ir� retornar um array de bytes
			String s = "";
			while(scan.hasNextLine()){	//L� as linhas do arquivo de texto
				s = scan.nextLine();
				tamanho++;			
			}
			if(tamanho==0){
				return true;
			}
			else if(tamanho!=0){
				return false;
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
}
