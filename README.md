# Um Jogo Diferente - Ballit Championship 

## Sobre

Um Jogo Diferente é um sistema de contagem de pontos para o campeonato fictício de Ballit, com uma interface gráfica interativa e funcional. O código permite registrar as pontuações durante o jogo e determinar o vencedor com base nos pontos acumulados. O projeto possui uma interface gráfica que exibe as informações dos times, seus pontos, e fornece botões para registrar as ações de cada time.

## Features

- **Contador de Pontos:** Contabiliza pontos por diferentes ações, como "blots" (5 pontos), "plifs" (1 ponto) e "advrunghs" (desconta 10 pontos).
- **Exibição de Times:** Exibe o nome dos times (Time A e Time B) e suas respectivas pontuações.
- **Fase do Jogo:** Realiza o controle de início e fim do jogo, permitindo navegar entre os times, suas pontuações e os jogos a serem jogados.


## Modo de uso

1. **Iniciar o Jogo:**
   - O jogo começa clicando no botão "Start". Isso irá exibir os nomes dos times e preparar a interface para a contagem dos pontos.
   
2. **Adicionar Pontos:**
   - Durante o jogo, é possível adicionar pontos aos times utilizando os botões correspondentes:
     - **Blot A / Blot B:** Adiciona 5 pontos ao Time A ou Time B, respectivamente.
     - **Plif A / Plif B:** Adiciona 1 ponto ao Time A ou Time B, respectivamente.
     - **Advrungh A / Advrungh B:** Subtrai 10 pontos do Time A ou Time B, respectivamente.
   
3. **Encerrar o Jogo:**
   - Quando o jogo for finalizado, clique no botão "End". O sistema calculará o vencedor com base nos pontos totais e transitará para a próxima interface.
   - Caso os times empatem em pontos, o sistema abre a interface de Grusht, que determina o vencedor de acordo com o volume do grito da torcida (contada em decibéis).
   - O campeonato continua até que todos os jogos sejam pontuados e ao final determina um vencedor.
