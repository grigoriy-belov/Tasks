package lesson11.task1;

public class ContractStudent extends Student {
    private double contractPrice;

    public ContractStudent(String name, int age, double contractPrice) {
        super(name, age);
        this.contractPrice = contractPrice;
    }

    public double getContractPrice() {
        return contractPrice;
    }

    public void setContractPrice(double contractPrice) {
        this.contractPrice = contractPrice;
    }

    @Override
    public String toString() {
        return "ContractStudent{" +
                "contractPrice=" + contractPrice +
                ", name='" + super.getName() + '\'' +
                ", age=" + super.getAge() +
                '}';
    }
}
