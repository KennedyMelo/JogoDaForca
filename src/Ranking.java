import java.util.*;

public class Ranking {
    private List<Jogador> jogadores = new ArrayList<>();

    public void adicionarJogador(Jogador jogador) {
        jogadores.add(jogador);
    }

    public void exibirRanking() {
        jogadores.sort((a, b) -> b.getPontuacao() - a.getPontuacao());
        System.out.println("=== Ranking ===");
        for (Jogador j : jogadores) {
            System.out.println(j.getNome() + ": " + j.getPontuacao() + " pontos");
        }
    }
}
