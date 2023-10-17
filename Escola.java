
/**
 * Wrapper
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Escola {

    public static void main(String[] args) {

        System.out.println("=== Sistema de avaliação ===");
        System.out.println("Calculamos se você passou ou não com base em suas notas. Use vírgulas e não pontos.");

        List<Double> notas = pegarNotas(4);
        double result = calcularMedia(notas);
        darFeedback(result);

        System.out.println("=== Obrigado por usar o sistema de avaliação ===");

    }

    private static List<Double> pegarNotas(int MAX_NOTAS) {
        Scanner scanner = new Scanner(System.in);
        List<Double> notas = new ArrayList<>();

        for (int i = 0; i < MAX_NOTAS; i++) {
            String msg = String.format("Insira a próxima nota (%d/%d):", i + 1, MAX_NOTAS);
            System.out.println(msg);
            double input = scanner.nextDouble();
            notas.add(input);
        }
        scanner.close();
        return notas;
    }

    private static double calcularMedia(List<Double> notas) {

        double result = 0.0;

        for (Double i : notas) {
            result = result + i;
        }

        result = result / notas.size();
        return result;
    }

    private static void darFeedback(Double result) {
        if (result.isNaN()) {
            System.out.println("Erro! Tente novamente.");
            return;
        }
        String formattedNumber = String.format("%.2f", result);

        if (result > 7) {
            System.out.println("Nota " + formattedNumber + ". Aprovado!");
        } else if (result < 5) {
            System.out.println("Nota " + formattedNumber + ". Reprovado!");
        } else {
            System.out.println("Nota " + formattedNumber + ". Recuperação!");
        }
    }
}
