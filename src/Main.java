import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    public static List<Person> generateClients() {
        return List.of(
                new Person("��������", "��������", 4),
                new Person("������", "�������", 7),
                new Person("�������", "��������", 2),
                new Person("������", "���������", 6),
                new Person("������", "����������", 3)
        );
    }

    public static void main(String[] args) {
        Queue<Person> lineForTheRide = new LinkedList<>(generateClients());

        while (!lineForTheRide.isEmpty()) {

            Person nextClient = lineForTheRide.poll();
//            if (nextClient.getTickets() == 0){
//                System.out.println(nextClient.getName() + " " + nextClient.getSurname() + " ������ �� ������, " +
//                        "������� �� �������� :(");
//                lineForTheRide.remove(nextClient);
//            } else {
                System.out.println(nextClient.getName() + " " + nextClient.getSurname() +
                        " ����� ����������� �� �����������. � ������� " + nextClient.getTickets() + " ������(��).");

                int howManyTicketsLeft = nextClient.getTickets();


                if (howManyTicketsLeft > 0) {
                    System.out.println("� " + nextClient.getName() + " " + nextClient.getSurname() + " �������� �� �����������. " +
                            "�������� " + (nextClient.getTickets() - 1) + " ��.");
                    howManyTicketsLeft -= 1;
                    nextClient.setTickets(howManyTicketsLeft);
                    lineForTheRide.offer(nextClient);


                    if (nextClient.getTickets() == 0){
                        System.out.println(nextClient.getName() + " " + nextClient.getSurname() + " ������ �� ������, " +
                                "������� �� �������� :(");
                        lineForTheRide.remove(nextClient);
                }
                    System.out.println("\n");
            }

        }
        System.out.println("������ ���������, ��� ����������.");
    }
}