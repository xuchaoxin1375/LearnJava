package experiment7.exp1;

public class EnumPay {
    public static void main(String[] args) {
        Pay pay1=Pay.ALI_PAY;
        Pay pay2=Pay.WE_CHAT_PAY;

        Pay.CASH.show();
        pay1.show();
        Pay.WE_CHAT_PAY.show();
        Pay.BANKCARD.show();
        Pay.CREDIT_CARD.show();
    /*    System.out.println(Pay.CASH);
        System.out.println(pay1);
        System.out.println(pay2);
        System.out.println(Pay.BANKCARD);
        System.out.println(Pay.CREDIT_CARD);*/



    }
}
