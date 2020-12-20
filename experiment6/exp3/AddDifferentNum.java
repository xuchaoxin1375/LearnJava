package experiment6.exp3;

import java.util.List;

 class AddDifferentNum {
    public void add(List<Integer> list, int tmp) {
        if (list.contains(tmp)) {
            throw new SameIntegerException(tmp, list);
        } else {
            list.add(tmp);
        }

    }
}
/*
��������:(��Integer.parseInt()��Դ������Կ���,throw�׳��쳣��,�����ڱ�����������catch.
����,throw xxException �ڷ���û����try��ס(����һ�㶼��RunningTimeException)
����������try...catch�ڵ�������ִ��,�ڳ���׽����һ���쳣����뿪��(�����л�δִ�еĲ��־�������ִ������)
Ҳ����˵,��������,����Ҫ��Ҫ�ڷ�����ֱ�Ӵ���(����try...catch).
��Ȼ,һ�����ҵ���߼��ֵķ�����������Ļ�,�ǿ���ֵ�׳�if(){throw}��,��main()����ȥtry catch.


public static int parseInt(String s, int radix)
                throws NumberFormatException
    {
        *
         * WARNING: This method may be invoked early during VM initialization
         * before IntegerCache is initialized. Care must be taken to not use
         * the valueOf method.
         *

        if (s == null) {
                throw new NumberFormatException("null");
                }

                if (radix < Character.MIN_RADIX) {
        throw new NumberFormatException("radix " + radix +
        " less than Character.MIN_RADIX");
        }

        if (radix > Character.MAX_RADIX) {
        throw new NumberFormatException("radix " + radix +
        " greater than Character.MAX_RADIX");
        }

        boolean negative = false;
        int i = 0, len = s.length();
        int limit = -Integer.MAX_VALUE;

        if (len > 0) {
        char firstChar = s.charAt(0);
        if (firstChar < '0') { // Possible leading "+" or "-"
        if (firstChar == '-') {
        negative = true;
        limit = Integer.MIN_VALUE;
        } else if (firstChar != '+') {
        throw NumberFormatException.forInputString(s, radix);
        }

        if (len == 1) { // Cannot have lone "+" or "-"
        throw NumberFormatException.forInputString(s, radix);
        }
        i++;
        }
        int multmin = limit / radix;
        int result = 0;
        while (i < len) {
        // Accumulating negatively avoids surprises near MAX_VALUE
        int digit = Character.digit(s.charAt(i++), radix);
        if (digit < 0 || result < multmin) {
        throw NumberFormatException.forInputString(s, radix);
        }
        result *= radix;
        if (result < limit + digit) {
        throw NumberFormatException.forInputString(s, radix);
        }
        result -= digit;
        }
        return negative ? result : -result;
        } else {
        throw NumberFormatException.forInputString(s, radix);
        }
        }
 */