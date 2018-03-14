# Universidade Federal de Juiz de Fora (UFJF) - (2015/2016) #
###Projeto: Jogo Interativo da Tabela Periódica

## Objetivo:
<p align = "justify">Desenvolver um jogo interativo de perguntas e respostas sobre os conhecimentos da tabela periódica. Ele será utilizado para demonstrar aos integrantes do ensino médio e fundamental a importância da tabela periódica e incentivar o estudar o estudo da química por parte dos alunos</p>.

## Níveis de dificuldades:
<p align = "justify">As perguntas são divididas nos seguintes níveis de dificuldades:</p>
- 9º Ano (antiga 8ª série do ensino fundamental);
- 1º Ano (Ensino médio);
- 2º Ano (Ensino médio);
- 3º Ano (Ensino médio);

## Ideia do projeto:
<p align = "justify">Cada aluno irá jogar em seu computador em um laboratório de informática, preenchendo seu nome e escolhendo seu ano de ensino. A partir dai o programa busca pela rede no computador central os arquivos com o nome da escola, data, dificuldade e perguntas sorteadas, a dificuldade e perguntas são buscadas para ter um controle de que os alunos jogarão na mesma dificuldade e responderão as mesmas perguntas.</p>
<p align = "justify">Um instrutor que coordenará a partida estará responsável por liberar as perguntas que os alunos irão responder, isso é feito para que todos caminhem juntos durante a partida. Ao final da partida será criado um arquivo de texto com os dados do aluno na partida e enviados para computador central, em seguida o instrutor terá uma tabela de ranking com os dados dos alunos, assim caso seja viável, esse aluno poderá ser premiado.</p>
<p align = "justify">A ideia é que a competição incentive os alunos tentarem o seu melhor e com isso acabará por aprofundar ao aluno um interesse maior pela química, e principalmente pela tabela periódica e a importância da mesma.</p>

## Tipicidades:
<p align = "justify">Para que os alunos não respondam as perguntas na mesma ordem, evitando que um olhe a resposta do outro, é feito um sorteio individual das 10 perguntas para cada computador. Eles responderão as mesmas perguntas mas em uma ordem diferente.</p>

## Comentários de programação:
- A linguagem de programação utilizada para desenvolver a aplicação foi o Java para desktop;
- A IDE utilizada foi o Eclipse;
- O projeto apresenta duas partes: 
	- <p align = "justify">1 - Parte jogável que se situará nos computadores dos alunos;</p> 
	- <p align = "justify">2 - Parte do painel central que controlará a partida, destravando perguntas e tendo um controle dos registros de jogadores e se situará no computador do instrutor da partida;</p>
- <p align = "justify">O diretório do computador central deve ser compartilhado em rede para que a primeira parte consiga ter acesso a enviar e ler arquivo de lá.</p>
- <p align = "justify"> Os computadores devem estar ligados em rede, não é necessário internet mas a rede é essencial para que os computadores possam mandar arquivos entre si.</p>
- <p align = "justify"> Foram utilizados a leitura e gravação em arquivos de texto com a codificação "UTF-8";</p>
**Comentário**:Não utilizei banco de dados pois durante o projeto, infelizmente não sabia trabalhar com banco de dados;

##Requisitos:
- Deve-se estar instalado o Java JRE em cada uma das máquinas;
- Computadores ligados em rede;
- Jogo funcional e testado no windows 7, 8, 8.1 e 10;
- Pelo menos dois computadores: um pra destravar as perguntas e outro pra jogar;
- <p align = "justify">Um arquivo de texto com o nome do computador central deve estar presente na diretório na parte jogável do jogo, pois é a partir dele que o computador conseguirá encontrar o caminho na rede pra enviar e ler arquivos;
- As máquinas devem possuir sistemas operacional similares, pois caso tenham sistemas diferentes pode ser que esse computador não consiga ser identificado na rede;

##Créditos do projeto:

**Orientadores**:

- Flávia Souza Bastos;
- Eloi Cesar;

**Designers (parte gráfica)**:

- Lívia Caniato;
- Adriano Santos;
- Lucas Diniz da Costa;

**Programação (parte da codificação)**:

- Lucas Diniz da Costa;

**Perguntas**:

- Eloi Cesar;