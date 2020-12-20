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
        //������ɳ���
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
/*����˵��ע��
   һ����ݼ�

  ����/** ,�����Enter�����Զ����ݲ����ͷ���ֵ����ע��ģ��*/
    /**
     * ��ӡ��ƽ��ֵ�������к�Ľ����
     */
    public void printSortedResult(){
        for(Pet pet:petList){
            System.out.println(pet);
        }
    }
}
