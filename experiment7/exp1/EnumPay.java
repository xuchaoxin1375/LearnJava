package experiment7.exp1;

public class EnumPay {
    public static void main(String[] args) {
        /*可以分部:*/
        Pay pay1=Pay.ALI_PAY;
        pay1.show();
/*也可以利用其中成员对象的static特性,直接取得并使用.*/
        Pay.CASH.show();
        Pay.WE_CHAT_PAY.show();
        Pay.BANKCARD.show();
        Pay.CREDIT_CARD.show();

        //valueOf()
        System.out.println("test:valueOf()");
        Pay.valueOf("CASH").show();


    }
}
