package experiment11.exp4;

 class Tuple {
     String name;
     int number;

     public String getName() {
         return name;
     }

     public void setName(String name) {
         this.name = name;
     }

     public void setNumber(int number) {
         this.number = number;
     }

     public int getNumber() {
         return number;
     }

     public Tuple(String name, int number) {
         this.name = name;
         this.number = number;
     }
 }
