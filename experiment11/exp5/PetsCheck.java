package experiment11.exp5;

/**
 * 假设一个宠物店有1000个动物，一次宠物体检，给每个宠物的
 * 体重、活跃度、灵敏度  进行了打分（100分制），
 * 现在要实现宠物按照上述   三个指标的平均值降序排列，并输出所有宠物的详细信息，
 * 输出信息包括：名字、年龄、体重、活跃度、灵敏度及平均值，
 * <p>
 * 请实现相应的程序。
 * 额外要求：
 * 1）必须包含2个类：宠物类Pet，宠物店类PetShop，
 * 宠物店类包含一个属性pets，包含其所有的宠物；
 * 2）宠物信息必须包含名字、年龄、体重、活跃度、灵敏度；宠物店信息必须包含名字、所有宠物信息；
 * 3）1000个宠物随机产生，每个宠物各指标随机产生（0-100分之间）；
 * 4）以上属性是规定属性，其它属性根据编程需要自行添加。
 */
public class PetsCheck {
    public static void main(String[] args) {
    /*一句话实现一个需求。
    * 将各个功能尽合适的封装到类中。*/
        PetShop petShop = new PetShop("petShop1");
        petShop.sort_3();
        petShop.printSortedResult();
        //System.out.println(petShop.getPetList());
    }
}
