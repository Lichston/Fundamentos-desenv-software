public class App {
    public static void main(String[] args) {
        Consultas consultas = new Consultas();
        System.out.println("Dia em que mais choveu no ano de 1980: ");
        System.out.println(consultas.diaQueMaisChoveuNoAno(1980));
        System.out.println("Dias em que a temperatura máxima foi maior que 20");

        consultas.diasEmQue().forEach(System.out::println);
    }
}
