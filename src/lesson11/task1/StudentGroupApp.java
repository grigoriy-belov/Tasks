package lesson11.task1;

public class StudentGroupApp {

    public static void main(String[] args) {
        Group group = new Group(5);
        group.addStudent(new Student("Ivanov", 22));
        group.addStudent(new ContractStudent("Petrov", 25, 800));
        group.addStudent(new Student("Sidorov", 27));
        group.addStudent(new ContractStudent("Volkova", 23, 700));
        group.addStudent(new Student("Zayceva", 23));

        group.printContractStudentsInfo(group);
    }
}
