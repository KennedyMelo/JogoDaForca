import java.util.*;

public class Main {
    private static final String[] BANCO_PALAVRAS = {"JAVA", "COMPUTADOR", "PROGRAMA", "PROCESSAMENTO", "ALGORITMO"};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Ranking ranking = new Ranking();

        while (true) {
            System.out.print("Digite seu nome: ");
            String nome = sc.nextLine();
            Jogador jogador = new Jogador(nome);

            String palavra = BANCO_PALAVRAS[new Random().nextInt(BANCO_PALAVRAS.length)];
            Forca forca = new Forca(palavra, 6);

            System.out.println("Jogo iniciado! Boa sorte, " + nome + "!");
            System.out.println("DICA: Informática");
            while (!forca.venceu() && !forca.perdeu()) {
                System.out.println("Palavra: " + forca.getEstadoAtual());
                System.out.println("Tentativas restantes: " + forca.getTentativasRestantes());
                System.out.println("Letras já tentadas: " + forca.getLetrasTentadas());
                System.out.print("Digite uma letra: ");
                char letra = sc.nextLine().toUpperCase().charAt(0);
                forca.jogar(letra);
            }

            if (forca.venceu()) {
                System.out.println("Parabéns! Você venceu!");
                jogador.adicionarPontos(10);
            } else {
                System.out.println("Você perdeu! A palavra era: " + palavra);
            }
            System.out.println("Pontuação final: " + jogador.getPontuacao());
            ranking.adicionarJogador(jogador);

            System.out.print("Deseja jogar novamente? (s/n): ");
            if (!sc.nextLine().equalsIgnoreCase("s")) break;
        }
        ranking.exibirRanking();
    }
}
