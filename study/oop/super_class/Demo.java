package study.oop.super_class;
public class Demo{
    public static void main(String[] args) {
        Student student =new Student("student!");
        System.out.println(student.s);
        System.out.println("hello");
    }
}
class SuperClass {

    public SuperClass(String str){
        System.out.println("constructor of SuperClass");
        System.out.println(str);
    }

}
//�̳�
class Student extends SuperClass{
    String s;
    public Student(String st) {
        super("\t��������!");
        this.s= st;
    }

}