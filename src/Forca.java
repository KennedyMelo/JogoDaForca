import java.util.*;

public class Forca {
    private String palavraSecreta;
    private char[] estadoAtual;
    private Set<Character> letrasTentadas = new HashSet<>();
    private int tentativasRestantes;

    public Forca(String palavraSecreta, int maxTentativas) {
        this.palavraSecreta = palavraSecreta.toUpperCase();
        this.estadoAtual = new char[palavraSecreta.length()];
        Arrays.fill(estadoAtual, '_');
        this.tentativasRestantes = maxTentativas;
    }

    public boolean jogar(char letra) {
        letra = Character.toUpperCase(letra);
        if (letrasTentadas.contains(letra)) return false;
        letrasTentadas.add(letra);

        boolean acertou = false;
        for (int i = 0; i < palavraSecreta.length(); i++) {
            if (palavraSecreta.charAt(i) == letra) {
                estadoAtual[i] = letra;
                acertou = true;
            }
        }
        if (!acertou) tentativasRestantes--;
        return acertou;
    }

    public boolean venceu() {
        return palavraSecreta.equals(new String(estadoAtual));
    }

    public boolean perdeu() {
        return tentativasRestantes <= 0;
    }

    public String getEstadoAtual() {
        return new String(estadoAtual);
    }

    public int getTentativasRestantes() {
        return tentativasRestantes;
    }

    public Set<Character> getLetrasTentadas() {
        return letrasTentadas;
    }
}
