package experiment7.exp1;

/**
 * 这个enum类性 Pay 实现了自定义的Message接口(中的show()方法)
 * 支付方式有Cash（现金）、WeChatPay（微信）、Alipay(支付宝)、BankCard(银行卡)、CreditCard(信用卡)五种，
 * 建立一个枚举类Pay包含这五种支付方式。类Pay有成员变量final String type（支付类型）和double mount（支付金额），
 * 构造方法为Pay(String type){…}。
 * <p>
 * 类pay实现了接口Message，Message有一个方法show(),
 * 要求每个支付方式类对象各自实现了这个方法。在类PayEnum中创建5个枚举类对象，
 * 设置支付数额，调用show()方法
 */
enum Pay implements Message {
    /**
     * 自定义枚举类
     *
     * 1.私有化类的构造器，保证不能在类的外部创建其对象
     * 2.在类的内部创建枚举类的实例。
     * 声明为：public static final
     * 3.对象如果有实例变量，应该声明为private final，并
     * 在构造器中初始化
     * 使用enum定义枚举类
     *
     * 使用enum定义的枚举类默认继承了java.lang.Enum类，因
     * 此不能再继承其他类
     * 枚举类的构造器只能使用private权限修饰符
     * 枚举类的所有实例必须在枚举类中显式列出(, 分隔 ; 结
     * 尾)，与普通类的成员对象看似不同,enum中列出的实例系统会自动添加public static final
     * 修饰(内部其实是相同的.)
     * 必须在枚举类的第一行声明枚举类对象
     * JDK1.5后可以在switch表达式中使用Enum定义的枚举类的
     * 对象作为表达式, case子句可以直接使用枚举值的名字,
     * 无需添加枚举类作为限定。
     * 注意,编写某个enum时,成员之间是用逗号','分隔的.
     * 同时,如果该enum实现子某个接口,那么内部的每个成员常量都需要分别实现该接口.
     * 构造器
     * 可以感受到,enum是其中封装了若干个常量对象的集合体.
     * 当外部需要要用到某个常量时,直接使用成员访问运算符取得即可.
     */
    CASH(1000.0) {
        @Override
        public void show() {
            System.out.println("现金支付" + limitPay);
        }
    },
    WE_CHAT_PAY(6666.6) {
        @Override
        public void show() {
            System.out.println("支付宝支付" + limitPay);
        }
    },
    ALI_PAY(19999.9) {
        @Override
        public void show() {
            System.out.println("微信支付支付" + limitPay);
        }
    },
    BANKCARD(10000.0) {
        @Override
        public void show() {
            System.out.println("银行支付" + limitPay);
        }
    },
    CREDIT_CARD(8888.8) {
        @Override
        public void show() {
            System.out.println("信用卡支付" + limitPay);
        }
    };
    double limitPay;

    /*Modifier 'private' is redundant(多余的/冗余的) for enum constructors*/

    /**
     * enum 的构造方法都是private,外部无法访问.
     * @param limitPay
     */
    Pay(double limitPay) {
        this.limitPay = limitPay;
    }
    /*该方法开放出来,提供给外部调用*/
    public double getLimitPay() {
        return limitPay;
    }

}
