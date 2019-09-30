package lesson11.task1;

import java.util.List;

public class StudentGroupApp {

    public static void main(String[] args) {
        Group group = new Group(5);
        group.addStudent(new Student("Ivanov", 22));
        group.addStudent(new ContractStudent("Petrov", 25, 800));
        group.addStudent(new Student("Sidorov", 27));
        group.addStudent(new ContractStudent("Volkova", 23, 700));
        group.addStudent(new Student("Zayceva", 23));

        printContractStudentsInfo(group.getContractStudents());
    }

    public static void printContractStudentsInfo(List<ContractStudent> students) {
        for (ContractStudent student : students) {
            System.out.printf("Name: %1$-10s Contract price: %2$.1f$\n", student.getName(),
                        student.getContractPrice());
        }
    }
}
