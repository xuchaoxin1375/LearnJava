package experiment7.exp1;

public class EnumPay {
    public static void main(String[] args) {
        /*���Էֲ�:*/
        Pay pay1=Pay.ALI_PAY;
        pay1.show();
/*Ҳ�����������г�Ա�����static����,ֱ��ȡ�ò�ʹ��.*/
        Pay.CASH.show();
        Pay.WE_CHAT_PAY.show();
        Pay.BANKCARD.show();
        Pay.CREDIT_CARD.show();

        //valueOf()
        System.out.println("test:valueOf()");
        Pay.valueOf("CASH").show();


    }
}
