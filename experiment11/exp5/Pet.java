package experiment11.exp5;

public class Pet {
    String name;
    double age;
    double weight;
    double activation;
    double sensitivity;
    //���ء���Ծ�ȡ������ȵ�ƽ��ֵ
    double average;

    public Pet(String name, double age, double weight, double activation, double sensitivity) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.activation = activation;
        this.sensitivity = sensitivity;
    }

    public double getAverage() {
        return average=(weight+age+sensitivity)/3;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", weight=" + weight +
                ", activation=" + activation +
                ", sensitivity=" + sensitivity +
                ", average=" + average +
                '}';
    }
}
