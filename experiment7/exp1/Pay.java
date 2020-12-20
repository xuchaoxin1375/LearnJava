package experiment7.exp1;
/*支付方式有Cash（现金）、WeChatPay（微信）、Alipay(支付宝)、BankCard(银行卡)、CreditCard(信用卡)五种，
建立一个枚举类Pay包含这五种支付方式。类Pay有成员变量final String type（支付类型）和double mount（支付金额），
构造方法为Pay(String type){…}。

类pay实现了接口Message，Message有一个方法show(),
要求每个支付方式类对象各自实现了这个方法。在类PayEnum中创建5个枚举类对象，
设置支付数额，调用show()方法

 */
enum Pay implements Message{
    CASH(1000.0){
        @Override
        public void show() {
            System.out.println("现金支付"+limitPay);
        }
    },
    WE_CHAT_PAY(6666.6){
        @Override
        public void show() {
            System.out.println("支付宝支付"+limitPay);
        }
    },
    ALI_PAY( 19999.9 ){
        @Override
        public void show() {
            System.out.println("微信支付支付"+limitPay);
        }
    },
    BANKCARD(10000.0){
        @Override
        public void show() {
            System.out.println("银行支付"+limitPay);
        }
    },
    CREDIT_CARD(8888.8){
        @Override
        public void show() {
            System.out.println("信用卡支付"+limitPay);
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
