package experiment7.exp1;
/*֧����ʽ��Cash���ֽ𣩡�WeChatPay��΢�ţ���Alipay(֧����)��BankCard(���п�)��CreditCard(���ÿ�)���֣�
����һ��ö����Pay����������֧����ʽ����Pay�г�Ա����final String type��֧�����ͣ���double mount��֧������
���췽��ΪPay(String type){��}��

��payʵ���˽ӿ�Message��Message��һ������show(),
Ҫ��ÿ��֧����ʽ��������ʵ�����������������PayEnum�д���5��ö�������
����֧���������show()����

 */
enum Pay implements Message{
    CASH(1000.0){
        @Override
        public void show() {
            System.out.println("�ֽ�֧��"+limitPay);
        }
    },
    WE_CHAT_PAY(6666.6){
        @Override
        public void show() {
            System.out.println("֧����֧��"+limitPay);
        }
    },
    ALI_PAY( 19999.9 ){
        @Override
        public void show() {
            System.out.println("΢��֧��֧��"+limitPay);
        }
    },
    BANKCARD(10000.0){
        @Override
        public void show() {
            System.out.println("����֧��"+limitPay);
        }
    },
    CREDIT_CARD(8888.8){
        @Override
        public void show() {
            System.out.println("���ÿ�֧��"+limitPay);
        }
    };
double limitPay;

    private Pay(double limitPay){
        this.limitPay=limitPay;
    }

    public double getLimitPay() {
        return limitPay;
    }

}
