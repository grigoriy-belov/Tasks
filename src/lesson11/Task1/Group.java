package lesson11.Task1;

public class Group {
    private Student[] students;
    private int count;

    public Group(int size) {
        students = new Student[size];
        count = 0;
    }

    public void printContractStudentsInfo(Group group) {
        for (int i = 0; i < group.students.length; i++) {
            if (group.students[i] instanceof ContractStudent) {
                ContractStudent student = (ContractStudent) students[i];
                System.out.printf("Name: %1$-10s Contract price: %2$.1f$\n",student.getName(), student.getContractPrice());
            }
        }
    }

    public void addStudent(Student student) {
        if (count == students.length) {
            System.out.println("The group is full");
        } else {
            students[count++] = student;
        }
    }
}
