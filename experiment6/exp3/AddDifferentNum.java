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
附上样例:(从Integer.parseInt()的源代码可以看出,throw抛出异常后,不是在本方法中立即catch.
而且,throw xxException 在方法没有用try套住(尽管一般都是RunningTimeException)
不过这样将try...catch在调用者中执行,在程序捕捉到第一个异常后就离开了(方法中还未执行的部分就来不及执行完整)
也就是说,看需求啦,到底要不要在方法中直接处理(套上try...catch).
当然,一般如果业务逻辑分的分配的清楚合理的话,是可以值抛出if(){throw}后,让main()方法去try catch.


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