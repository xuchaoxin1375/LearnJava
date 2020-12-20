package experiment7.exp1;

/**
 * ���enum���� Pay ʵ�����Զ����Message�ӿ�(�е�show()����)
 * ֧����ʽ��Cash���ֽ𣩡�WeChatPay��΢�ţ���Alipay(֧����)��BankCard(���п�)��CreditCard(���ÿ�)���֣�
 * ����һ��ö����Pay����������֧����ʽ����Pay�г�Ա����final String type��֧�����ͣ���double mount��֧������
 * ���췽��ΪPay(String type){��}��
 * <p>
 * ��payʵ���˽ӿ�Message��Message��һ������show(),
 * Ҫ��ÿ��֧����ʽ��������ʵ�����������������PayEnum�д���5��ö�������
 * ����֧���������show()����
 */
enum Pay implements Message {
    /**
     * �Զ���ö����
     *
     * 1.˽�л���Ĺ���������֤����������ⲿ���������
     * 2.������ڲ�����ö�����ʵ����
     * ����Ϊ��public static final
     * 3.���������ʵ��������Ӧ������Ϊprivate final����
     * �ڹ������г�ʼ��
     * ʹ��enum����ö����
     *
     * ʹ��enum�����ö����Ĭ�ϼ̳���java.lang.Enum�࣬��
     * �˲����ټ̳�������
     * ö����Ĺ�����ֻ��ʹ��privateȨ�����η�
     * ö���������ʵ��������ö��������ʽ�г�(, �ָ� ; ��
     * β)������ͨ��ĳ�Ա�����Ʋ�ͬ,enum���г���ʵ��ϵͳ���Զ����public static final
     * ����(�ڲ���ʵ����ͬ��.)
     * ������ö����ĵ�һ������ö�������
     * JDK1.5�������switch���ʽ��ʹ��Enum�����ö�����
     * ������Ϊ���ʽ, case�Ӿ����ֱ��ʹ��ö��ֵ������,
     * �������ö������Ϊ�޶���
     * ע��,��дĳ��enumʱ,��Ա֮�����ö���','�ָ���.
     * ͬʱ,�����enumʵ����ĳ���ӿ�,��ô�ڲ���ÿ����Ա��������Ҫ�ֱ�ʵ�ָýӿ�.
     * ������
     * ���Ը��ܵ�,enum�����з�װ�����ɸ���������ļ�����.
     * ���ⲿ��ҪҪ�õ�ĳ������ʱ,ֱ��ʹ�ó�Ա���������ȡ�ü���.
     */
    CASH(1000.0) {
        @Override
        public void show() {
            System.out.println("�ֽ�֧��" + limitPay);
        }
    },
    WE_CHAT_PAY(6666.6) {
        @Override
        public void show() {
            System.out.println("֧����֧��" + limitPay);
        }
    },
    ALI_PAY(19999.9) {
        @Override
        public void show() {
            System.out.println("΢��֧��֧��" + limitPay);
        }
    },
    BANKCARD(10000.0) {
        @Override
        public void show() {
            System.out.println("����֧��" + limitPay);
        }
    },
    CREDIT_CARD(8888.8) {
        @Override
        public void show() {
            System.out.println("���ÿ�֧��" + limitPay);
        }
    };
    double limitPay;

    /*Modifier 'private' is redundant(�����/�����) for enum constructors*/

    /**
     * enum �Ĺ��췽������private,�ⲿ�޷�����.
     * @param limitPay
     */
    Pay(double limitPay) {
        this.limitPay = limitPay;
    }
    /*�÷������ų���,�ṩ���ⲿ����*/
    public double getLimitPay() {
        return limitPay;
    }

}
