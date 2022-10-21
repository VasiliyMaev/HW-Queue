import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    public static List<Person> generateClients() {
        return List.of(
                new Person("Григорий", "Распутин", 4),
                new Person("Наташа", "Ростова", 7),
                new Person("Ибрагим", "Махмудов", 2),
                new Person("Теоден", "Роханский", 6),
                new Person("Любава", "Маруськина", 3)
        );
    }

    public static void main(String[] args) {
        Queue<Person> lineForTheRide = new LinkedList<>(generateClients());

        while (!lineForTheRide.isEmpty()) {

            Person nextClient = lineForTheRide.poll();
            if (nextClient.getTickets() == 0){
                System.out.println(nextClient.getName() + " " + nextClient.getSurname() + " больше не поедет, " +
                        "билетов не осталось :(");
                lineForTheRide.remove(nextClient);
            } else {
                System.out.println(nextClient.getName() + " " + nextClient.getSurname() +
                        " хочет прокатиться на аттракционе. В наличии " + nextClient.getTickets() + " билета(ов).");

                int howManyTicketsLeft = nextClient.getTickets();


                if (howManyTicketsLeft > 0) {
                    System.out.println("И " + nextClient.getName() + " " + nextClient.getSurname() + " катается на аттракционе. " +
                            "Осталось " + (nextClient.getTickets() - 1) + " шт.");
                    howManyTicketsLeft -= 1;
                    nextClient.setTickets(howManyTicketsLeft);
                    lineForTheRide.offer(nextClient);
                    System.out.println("\n");
                }
            }

        }
        System.out.println("Билеты кончились, все покатались.");
    }
}
