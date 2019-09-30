package lesson11.task1;

import java.util.ArrayList;
import java.util.List;

public class Group {
    private Student[] students;
    private int count;

    public Group(int size) {
        students = new Student[size];
        count = 0;
    }

    public void addStudent(Student student) {
        if (count == students.length) {
            System.out.println("The group is full");
        } else {
            students[count++] = student;
        }
    }

    public List<ContractStudent> getContractStudents() {
        List<ContractStudent> contractStudents = new ArrayList<>();
        for (int i = 0; i < students.length; i++) {
            if (students[i] instanceof ContractStudent) {
                ContractStudent student = (ContractStudent) students[i];
                contractStudents.add(student);
            }
        }
        return contractStudents;
    }
}
