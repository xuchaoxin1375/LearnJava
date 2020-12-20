package experiment11.exp5;

import java.util.*;

public class PetShop {
    String shopName;
    List<Pet> petList = new ArrayList<>();

    /**
     *
     * @param shopName
     */
    public PetShop(String shopName) {
        this.shopName = shopName;
        //随机生成宠物
        for (int i = 0; i < 1000; i++) {
            petList.add(new Pet("pet" + i, 100 * Math.random(), 100 * Math.random(), 100 * Math.random(), 100 * Math.random()));
        }
    }

    public void sort_3() {
        Collections.sort(petList, new Comparator<Pet>() {
            @Override
            public int compare(Pet o1, Pet o2) {
                return (int) (o2.getAverage()-o1.getAverage());
            }
        });
    }

    public String getShopName() {
        return shopName;
    }

    public List<Pet> getPetList() {
        return petList;
    }

    public void setList(List<Pet> list) {
        this.petList = list;
    }

    @Override
    public String toString() {
        return "PetShop{" +
                "shopName='" + shopName + '\'' +
                ", petList=" + petList +
                '}';
    }
/*方法说明注释
   一、快捷键

  输入/** ,点击“Enter”，自动根据参数和返回值生成注释模板*/
    /**
     * 打印按平均值降序排列后的结果：
     */
    public void printSortedResult(){
        for(Pet pet:petList){
            System.out.println(pet);
        }
    }
}
