Arquivo criado para atualização e explicação de commits:

Commit 08/04/2025 - Código faz a escolha da série por meio da váriavel aux que se encontra na func leArquivo, caso queira testar outro valor só alterar lá. Por enquanto somente printa no terminal todos os dados da série (Pra confirmação do split, funcionando 100%), próximo passo agora é fazer a func retornar como um objeto para um arraylist de shows.


2-Commit 08/04/2025 - Código já armazena parte do show como objeto, restando tratar o cast e listed in como arraylist's e foi encontrado problema em campos onde se tem "" na descrição ou nos atores

Commit 09/04/2025 - Código arrumado, agora o código faz a atribuição dos objetos sem ter nenhum erro na leitura das linhas e na atribuição das variaveis, todas as séries já são lidas sem problemas. Resta arrumar a atribuição dos dois arrays (cast & listed_in) e a troca da data para tipo (date).
Obs: O código se encontra sem identação e com alguns comentários soltos/inuteis por conta dos breakpoints realizados para localização dos erros de leitura, porém não compromete em nada na execução.

2 Commit 09/04/2025 (Mais recente) - ArrayList1s funcionando porém com um erro de indexoutofbound, faltando só a confirmação do size para arrumar este erro e finalizar essa parte do ArrayList. Restando somente o clone/imprimir e lidar com a data como date.
