package com.example.seed.support.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/************************************************
 * Copyright (c) by anhui tonghui information technology Co., Ltd.
 * All right reserved.
 * Create Date: 2012-8-20
 * Create Author: doumingjun
 * File Name:  StringUtils
 * Last version:  1.0
 * Function: 字符处理工具类
 * Last Update Date:
 * Change Log:
 **************************************************/
public class StringUtils {
    /**
     * 7位ASCII字符，也叫作ISO646-US、Unicode字符集的基本拉丁块
     */
    public static final String US_ASCII = "US-ASCII";

    /**
     * ISO 拉丁字母表 No.1，也叫作 ISO-LATIN-1
     */
    public static final String ISO_8859_1 = "ISO-8859-1";

    /**
     * 8 位 UCS 转换格式
     */
    public static final String UTF_8 = "UTF-8";

    /**
     * 16 位 UCS 转换格式，Big Endian（最低地址存放高位字节）字节顺序
     */
    public static final String UTF_16BE = "UTF-16BE";

    /**
     * 16 位 UCS 转换格式，Little-endian（最高地址存放低位字节）字节顺序
     */
    public static final String UTF_16LE = "UTF-16LE";

    /**
     * 16 位 UCS 转换格式，字节顺序由可选的字节顺序标记来标识
     */
    public static final String UTF_16 = "UTF-16";

    /**
     * 中文超大字符集
     */
    public static final String GBK = "GBK";

    /**
     * 中文超大字符集
     */
    public static final String GB2312 = "GB2312";
    /**
     * The empty String {@code ""}.
     *
     * @since 2.0
     */
    public static final String EMPTY = "";

    /**
     * Represents a failed index search.
     *
     * @since 2.1
     */
    public static final int INDEX_NOT_FOUND = -1;

    /**
     * 判断字符串的编码
     *
     * @param str
     * @return
     */
    public static String getEncoding(String str) {
        String[] encodeStr = {UTF_8, ISO_8859_1, GBK, GB2312, US_ASCII,
                UTF_16BE, UTF_16LE, UTF_16};
        String encode = "";
        for (String string : encodeStr) {
            encode = checkEncoding(str, string);
            if (isNotBlank(encode)) {
                return encode;
            }
        }
        return "";
    }

    public static String checkEncoding(String str, String encode) {
        try {
            if (str.equals(new String(str.getBytes(encode), encode))) {
                String s = encode;
                return s;
            }
        } catch (Exception exception) {
        }
        return "";
    }

    /**
     * 字母Z使用了两个标签，这里有２７个值
     * <p>
     * i, u, v都不做声母, 跟随前面的字母
     */
    private char[] chartable = {'啊', '芭', '擦', '搭', '蛾', '发', '噶', '哈', '哈',
            '击', '喀', '垃', '妈', '拿', '哦', '啪', '期', '然', '撒', '塌', '塌', '塌',
            '挖', '昔', '压', '匝', '座'};

    private char[] alphatable = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I',
            'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V',
            'W', 'X', 'Y', 'Z'};

    /**
     * 切割字符长度
     *
     * @param str 源字符串
     * @param len 需要的长度
     * @param gb  中文字占2位
     * @return List<String>
     */
    public static List<String> subGbstring(String str, int len, boolean gb) {
        List<String> list = new ArrayList<String>();
        if (gb) {
            int nowlen = 0;
            int start = 0;
            StringUtils obj = new StringUtils();
            for (int i = 0; i < str.length(); i++) {
                int strgb = obj.gbValue(str.charAt(i));
                if (strgb < obj.table[0]) {// 非中文简体
                    nowlen++;
                } else {
                    nowlen += 2;
                }
                if (nowlen == len) {
                    list.add(str.substring(start, i + 1));
                    start = i + 1;
                    nowlen = 0;
                } else if (nowlen > len) {
                    list.add(str.substring(start, i));
                    start = i;
                    nowlen = 0;
                } else if (i + 1 == str.length()) {
                    list.add(str.substring(start, i + 1));
                    start = i;
                    nowlen = 0;
                }
            }
        } else {
            int end = len;
            for (int start = 0; start < str.length(); ) {
                if (end + 1 > str.length()) {
                    end = str.length();
                }
                list.add(str.substring(start, end));
                start = end + 1;
                end += start;
            }
        }
        return list;
    }

    public int[] table = new int[27];

    {// 初始化
        for (int i = 0; i < 27; ++i) {
            table[i] = gbValue(chartable[i]);
        }
    }

    /**
     * 主函数,输入字符得到他的声母,
     * <p>
     * 英文字母返回对应的大写字母
     * <p>
     * 其他非简体汉字返回 '0'
     *
     * @param ch
     * @return
     */
    public char charAlpha(char ch) {
        if (ch >= 'a' && ch <= 'z') {
            return (char) (ch - 'a' + 'A');
        }
        if (ch >= 'A' && ch <= 'Z') {
            return ch;
        }
        int gb = gbValue(ch);
        if (gb < table[0]) {
            return '0';
        }
        int i;
        for (i = 0; i < 26; ++i) {
            if (match(i, gb)) {
                break;
            }
        }
        if (i >= 26) {
			return '0';
		}else {
			return alphatable[i];
		}
    }

    /**
     * 根据一个包含汉字的字符串返回一个汉字拼音首字母的字符串
     *
     * @param SourceStr
     * @return
     */
    public String stringAlpha(String SourceStr) {
        StringBuffer result = new StringBuffer("");
        int StrLength = SourceStr.length();
        int i;
        try {
            for (i = 0; i < StrLength; i++) {
                result.append(charAlpha(SourceStr.charAt(i)));
            }
        } catch (Exception e) {
            result.append("");
        }
        return result.toString();
    }

    private boolean match(int i, int gb) {
        if (gb < table[i]) {
			return false;
		}
        int j = i + 1;
        // 字母Z使用了两个标签
        while (j < 26 && (table[j] == table[i])) {
			++j;
		}
        if (j == 26) {
			return gb <= table[j];
		}else{
        	return gb < table[j];
		}
    }

    // 取出汉字的编码
    private int gbValue(char ch) {
        String str = "";
        str += ch;
        try {
            byte[] bytes = str.getBytes("GB2312");
            if (bytes.length < 2) {
                return 0;
            }
            return (bytes[0] << 8 & 0xff00) + (bytes[1] & 0xff);
        } catch (Exception e) {
            return 0;
        }

    }

    /**
     * Md5加密
     *
     * @param s
     * @return
     */
    public static String getMd5(String s) {
        char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'A', 'B', 'C', 'D', 'E', 'F'};
        try {
            byte[] strTemp = s.getBytes();
            MessageDigest mdTemp = MessageDigest.getInstance("MD5");
            mdTemp.update(strTemp);
            byte[] md = mdTemp.digest();
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 得到一个n位的随机数 第一位不能为0
     *
     * @param n 位数
     * @return
     */
    public static String getRand(int n) {
        Random rnd = new Random();
        StringBuffer pass = new StringBuffer("0");
        int x = rnd.nextInt(9);
        /** 过滤第一位为0 */
        while (x == 0) {
            x = rnd.nextInt(9);
        }
        pass.append(String.valueOf(x));
        for (int i = 1; i < n; i++) {
            pass.append(String.valueOf(rnd.nextInt(9)));
        }
        return pass.toString();
    }

    /**
     * java按要求长度截取字段
     *
     * @param str 字符
     * @param num 长度
     * @return
     */
    public static String getStrLen(String str, int num) {
        int forNum = 0;
        int alli = 0;//
        int strLen = 0;// 要循环的长度
        if (num <= 0) {
            return str;
        }
        if (null == str) {
            return null;
        }
        if (str.length() >= num) {
            strLen = num;

        } else {
            strLen = str.length();
        }
        for (int i = 0; i < strLen; i++) {
            if (num == Math.floor(forNum / 2f)) {
				break;
			}
            if (str.substring(i, i + 1).getBytes().length > 1) {
                // 如果是字符
                alli = alli + 1;
            }
            alli = alli + 1;
            if (alli >= num) {
                return str.substring(0, i);
            }
        }
        return str.substring(0, strLen);
    }

    /**
     * 判断字符是否超过长度
     *
     * @param str
     * @param num
     * @return 超过规定字符返回true
     */
    public static boolean isLen(String str, int num) {
        int forNum = 0;
        int alli = 0;//
        int strLen = 0;// 要循环的长度
        if (str.length() >= num) {
            return true;// 超过规定字符返回true
        } else {
            strLen = str.length();
        }
        for (int i = 0; i < strLen; i++) {
            if (num == Math.floor(forNum / 2f)) {
				break;
			}
            if (str.substring(i, i + 1).getBytes().length > 1) {
                // 如果是字符
                alli = alli + 1;
            }
            alli = alli + 1;
        }
        if (alli > num) {
            return true;// 超过规定字符返回true
        }
        return false;// 不超过规定字符返回False
    }

    /**
     * 填充左边字符
     *
     * @param source   源字符串
     * @param fillChar 填充字符
     * @param len      填充到的长度
     * @return 填充后的字符串
     */
    public static String fillLeft(String source, char fillChar, int len) {
        StringBuffer ret = new StringBuffer();
        if (null == source)
            return ret.append("").toString();
        if (source.length() >= len) {
            ret.append(source);
        } else {
            int slen = source.length();
            while (ret.toString().length() + slen < len) {
                ret.append(fillChar);
            }
            ret.append(source);
        }
        return ret.toString();
    }

    /**
     * 填充右边字符
     *
     * @param source   源字符串
     * @param fillChar 填充字符
     * @param len      填充到的长度
     * @return 填充后的字符串
     */
    public static String filRight(String source, char fillChar, int len) {
        StringBuffer ret = new StringBuffer();
        if (null == source)
            return ret.append("").toString();
        if (source.length() >= len) {
            ret.append(source);
        } else {
            ret.append(source);
            while (ret.toString().length() < len) {
                ret.append(fillChar);
            }
        }
        return ret.toString();
    }

    public static String filterStr(String str) {
        if (null == str || "".equals(str)) {
            return str;
        }
        str = str.replaceAll("'", "''");
        return str;
    }

    /**
     * 检测字符是否是数字
     *
     * @param c
     * @return
     */
    public static boolean isDigit(char c) {
        String nums = "0123456789.";
        if (nums.indexOf(String.valueOf(c)) == -1) {
            return false;
        }
        return true;
    }

    public static String substring(String str, int num) {
        byte[] substr = new byte[num];
        System.arraycopy(str.getBytes(), 0, substr, 0, num);
        str = new String(substr);
        return str;
    }

    public static String checkStr(String inputStr) {
        StringBuffer error = new StringBuffer("");
        if (null != inputStr && !"".equals(inputStr.trim())) {
            char c;
            for (int i = 0; i < inputStr.length(); i++) {
                c = inputStr.charAt(i);
                if (c == '"') {
                    error.append(" 特殊字符[\"]");
                }
                if (c == '\'') {
                    error.append(" 特殊字符[']");
                }
                if (c == '<') {
                    error.append(" 特殊字符[<]");
                }
                if (c == '>') {
                    error.append(" 特殊字符[>]");
                }
                if (c == '&') {
                    error.append(" 特殊字符[&]");
                }
                if (c == '%') {
                    error.append(" 特殊字符[%]");
                }
            }
        }
        return error.toString();
    }

    /**
     * 检测字符是否为空,为空的时候返回提示
     *
     * @param str
     * @param msg 为空的时候返回提示
     * @return
     */
    public static String isBlankToMsg(String str, String msg) {
        String returnstr = "";
        if (EmptyUtil.isEmpty(str)) {
            returnstr = msg + ",";
        }
        return returnstr;
    }

    public static String getFileName(String filepath) {
        if (EmptyUtil.isNotEmpty(filepath)) {
            return filepath.substring(filepath.lastIndexOf("\\") + 1, filepath
                    .length());
        }
        return "";
    }

    public static String changeCharset(String str, String oldCharset,
                                       String newCharset) {
        if (str != null) {
            // 用默认字符编码解码字符串。
            byte[] bs = null;
            try {
                if (EmptyUtil.isNotEmpty(oldCharset)) {
                    bs = str.getBytes(oldCharset);
                } else {
                    bs = str.getBytes();
                }
            } catch (UnsupportedEncodingException e1) {
                e1.printStackTrace();
            }
            // 用新的字符编码生成字符串
            if (bs == null) {
                bs = str.getBytes();
            }
            try {
                String newstr = new String(bs, newCharset);
                return newstr;
            } catch (Exception e) {
                return null;
            }
        }
        return null;
    }

    /**
     * 拆分规格1.00*1000*1000拆成1.00 1000 1000
     *
     * @param str 规格
     * @return 拆分后的数组, 里面是数字, 不能包括非数字
     */
    public static StringBuilder[] getSplit(String str, String split) {
        String[] ggStr = null;
        // 取出数组
        if (null == str) {
            return null;
        }
        ggStr = str.split(split);
        StringBuilder[] b = new StringBuilder[ggStr.length];
        // 处理每个数组里的非数字字符
        for (int i = 0; i < ggStr.length; i++) {
            StringBuilder sBuffer = new StringBuilder();
            char[] c = ggStr[i].toCharArray();
            int data = 0;
            for (int j = 0; j < c.length; j++) {
                if (StringUtils.isDigit(c[j])) {
                    data++;
                    sBuffer.append(c[j]);
                } else if (data > 0) {
                    break;
                }
            }
            if (null == sBuffer || sBuffer.length() == 0) {
                sBuffer.append('0');
            }
            b[i] = sBuffer;
        }
        return b;
    }



    public static String makeSign(String value) {
        String str = "";
        if (null == value) {
            return str;
        }
        str = value.trim();// 去掉前后空格
        str = str.replaceAll(">", "&gt;");
        str = str.replaceAll("<", "&lt;");
        str = str.replaceAll("&", "&amp;");
        str = str.replaceAll("\"", "&quot;");
        return str;
    }

    /**
     * 截取超长的信息，多余用...
     *
     * @param str 备注
     * @param len 长
     * @return 截取后的信息
     */
    public static String intercept(String str, int len) {
        String newstr = "";
        if (null == str) {
            return newstr;
        }
        if (str.length() > len) {
            newstr = str.substring(0, len) + "...";
        } else {
            newstr = str;
        }
        return newstr;
    }

    /**
     * 转义页面输入的特殊符号
     *
     * @param str
     * @return
     */
    public static String replaceHtml(String str) {
        if (null == str) {
            return "";
        }
        str = StringUtils.replace(str, "&", "&amp;");
        str = StringUtils.replace(str, "'", "&apos;");
        str = StringUtils.replace(str, "\"", "&quot;");
        str = StringUtils.replace(str, "\n", "<br>");
        str = StringUtils.replace(str, "\t", "&nbsp;&nbsp;");// 替换跳格
        str = StringUtils.replace(str, " ", "&nbsp;");// 替换空格
        return str;
    }

    /**
     * 反向转义页面输入的特殊符号
     *
     * @param str
     * @return
     */
    public static String reReplaceHtml(String str) {
        if (null == str) {
            return "";
        }
        str = StringUtils.replace(str, "&amp;", "&");
        str = StringUtils.replace(str, "&apos;", "'");
        str = StringUtils.replace(str, "&quot;", "\"");
        str = StringUtils.replace(str, "<br>", "\n");
        str = StringUtils.replace(str, "&nbsp;&nbsp;", "\t");// 替换跳格
        str = StringUtils.replace(str, "&nbsp;", " ");// 替换空格
        return str;
    }

    /**
     * 所有参数为空的时候返回true
     *
     * @param args
     * @return true false
     */
    public static Boolean isBlankAll(Object... args) {
        Boolean flag = true;
        for (int i = 0; i < args.length; i++) {
            if (args[i] instanceof String) {
                if (!isBlank((String) args[i])) {
                    flag = false;
                }
            } else {
                if (null != args[i]) {
                    flag = false;
                }
            }
        }
        return flag;
    }

    /**
     * 只要有一个参数为空就返回true
     *
     * @param args
     * @return true false
     */
    public static Boolean isBlankOne(Object... args) {
        Boolean flag = false;
        for (int i = 0; i < args.length; i++) {
            if (args[i] instanceof String) {
                if (isBlank((String) args[i])) {
                    flag = true;
                }
            } else {
                if (null == args[i]) {
                    flag = true;
                }
            }
        }
        return flag;
    }

    /**
     * 把字符串第一个字母转成大写
     *
     * @param str
     * @return
     */
    public static String getFirstUpper(String str) {
        String newStr = "";
        if (str.length() > 0) {
            newStr = str.substring(0, 1).toUpperCase()
                    + str.substring(1, str.length());
        }
        return newStr;
    }

    /**
     * 获取一个字符在一个字符串里出现的次数
     *
     * @param tagetStr
     * @param str
     * @return
     */
    public static int indexOfAll(String tagetStr, String str) {
        int i = 0;
        if (null != tagetStr) {
            i = tagetStr.length() - tagetStr.replace(str, "").length();
        }
        return i;
    }

    /**
     * 转null字符串为""
     *
     * @param str
     * @return
     */
    public static String getNullTo(String str) {
        if (isBlank(str)) {
            str = "";
        }
        return str;
    }

    /**
     * 比较两个Long是否相等
     *
     * @param a
     * @param b
     * @return
     */
    public static boolean equals(Long a, Long b) {
        boolean flag = false;
        if (null == a) {
            a = 0L;
        }
        if (null == b) {
            b = 0L;
        }
        if (a.equals(b)) {
            flag = true;
        }
        return flag;
    }

    /**
     * 比较两个对象是否相等
     *
     * @param a
     * @param b
     * @return
     */
    public static boolean equals(Object a, Object b) {
        boolean flag = false;
        if (null == a) {
            a = "";
        }
        a = String.valueOf(a);
        if (null == b) {
            b = "";
        }
        b = String.valueOf(b);
        if (a.equals(b)) {
            flag = true;
        }
        return flag;
    }

    /**
     * 比较两个字符串是否相等
     *
     * @param a
     * @param b
     * @return
     */
    public static boolean equals(String a, String b) {
        boolean flag = false;
        if (null == a) {
            a = "";
        }
        if (null == b) {
            b = "";
        }
        if (a.equals(b)) {
            flag = true;
        }
        return flag;
    }


    // -----------------------------------------------------------------------

    /**
     * <p>
     * Checks if a CharSequence is empty ("") or null.
     * </p>
     *
     * <pre>
     * EmptyUtil.isEmpty(null)      = true
     * EmptyUtil.isEmpty(&quot;&quot;)        = true
     * EmptyUtil.isEmpty(&quot; &quot;)       = false
     * EmptyUtil.isEmpty(&quot;bob&quot;)     = false
     * EmptyUtil.isEmpty(&quot;  bob  &quot;) = false
     * </pre>
     *
     * <p>
     * NOTE: This method changed in Lang version 2.0. It no longer trims the
     * CharSequence. That functionality is available in isBlank().
     * </p>
     *
     * @param cs the CharSequence to check, may be null
     * @return {@code true} if the CharSequence is empty or null
     * @since 3.0 Changed signature from isEmpty(String) to
     * isEmpty(CharSequence)
     */
    public static boolean isEmpty(CharSequence cs) {
        return cs == null || cs.length() == 0;
    }

    /**
     * <p>
     * Checks if a CharSequence is not empty ("") and not null.
     * </p>
     *
     * <pre>
     * EmptyUtil.isNotEmpty(null)      = false
     * EmptyUtil.isNotEmpty(&quot;&quot;)        = false
     * EmptyUtil.isNotEmpty(&quot; &quot;)       = true
     * EmptyUtil.isNotEmpty(&quot;bob&quot;)     = true
     * EmptyUtil.isNotEmpty(&quot;  bob  &quot;) = true
     * </pre>
     *
     * @param cs the CharSequence to check, may be null
     * @return {@code true} if the CharSequence is not empty and not null
     * @since 3.0 Changed signature from isNotEmpty(String) to
     * isNotEmpty(CharSequence)
     */
    public static boolean isNotEmpty(CharSequence cs) {
        return !EmptyUtil.isEmpty(cs);
    }

    /**
     * <p>
     * Checks if a CharSequence is whitespace, empty ("") or null.
     * </p>
     *
     * <pre>
     * EmptyUtil.isEmpty(null)      = true
     * EmptyUtil.isEmpty(&quot;&quot;)        = true
     * EmptyUtil.isEmpty(&quot; &quot;)       = true
     * EmptyUtil.isEmpty(&quot;bob&quot;)     = false
     * EmptyUtil.isEmpty(&quot;  bob  &quot;) = false
     * </pre>
     *
     * @param cs the CharSequence to check, may be null
     * @return {@code true} if the CharSequence is null, empty or whitespace
     * @since 2.0
     * @since 3.0 Changed signature from isBlank(String) to
     * isBlank(CharSequence)
     */
    public static boolean isBlank(CharSequence cs) {
        int strLen;
        if (cs == null || (strLen = cs.length()) == 0) {
            return true;
        }
        for (int i = 0; i < strLen; i++) {
            if (Character.isWhitespace(cs.charAt(i)) == false) {
                return false;
            }
        }
        return true;
    }

    /**
     * 获取一个字符串在一个字符串中出现的次数
     *
     * @param str
     * @param ts
     * @return int
     * @Date 2016-2-16 下午2:36:47
     * @Author zhangdaye@itonghui.org
     */
    public int getStrShowCount(String str, String ts) {
        boolean flag = true;
        int i = 0;
        while (flag) {
            int index = str.indexOf(ts);
            if (index != -1) {
                i++;
                str = str.substring(index + ts.length());
            } else {
                flag = false;
            }
        }
        return i;
    }

    /**
     * <p>
     * Checks if a CharSequence is not empty (""), not null and not whitespace
     * only.
     * </p>
     *
     * <pre>
     * EmptyUtil.isEmpty(null)      = false
     * EmptyUtil.isEmpty(&quot;&quot;)        = false
     * EmptyUtil.isEmpty(&quot; &quot;)       = false
     * EmptyUtil.isEmpty(&quot;bob&quot;)     = true
     * EmptyUtil.isEmpty(&quot;  bob  &quot;) = true
     * </pre>
     *
     * @param cs the CharSequence to check, may be null
     * @return {@code true} if the CharSequence is not empty and not null and
     * not whitespace
     * @since 2.0
     * @since 3.0 Changed signature from isNotBlank(String) to
     * isNotBlank(CharSequence)
     */
    public static boolean isNotBlank(CharSequence cs) {
        return !EmptyUtil.isEmpty(cs);
    }

    // Trim
    // -----------------------------------------------------------------------

    /**
     * <p>
     * Removes control characters (char &lt;= 32) from both ends of this String,
     * handling {@code null} by returning {@code null}.
     * </p>
     *
     * <p>
     * The String is trimmed using {@link String#trim()}. Trim removes start
     * and end characters &lt;= 32. To strip whitespace use
     * {@link # strip(String)}.
     * </p>
     *
     * <p>
     * To trim your choice of characters, use the {@link # strip(String, String)}
     * methods.
     * </p>
     *
     * <pre>
     * StringUtils.trim(null)          = null
     * StringUtils.trim(&quot;&quot;)            = &quot;&quot;
     * StringUtils.trim(&quot;     &quot;)       = &quot;&quot;
     * StringUtils.trim(&quot;abc&quot;)         = &quot;abc&quot;
     * StringUtils.trim(&quot;    abc    &quot;) = &quot;abc&quot;
     * </pre>
     *
     * @param str the String to be trimmed, may be null
     * @return the trimmed string, {@code null} if null String input
     */
    public static String trim(String str) {
        return str == null ? null : str.trim();
    }

    /**
     * <p>
     * Removes control characters (char &lt;= 32) from both ends of this String
     * returning {@code null} if the String is empty ("") after the trim or if
     * it is {@code null}.
     *
     * <p>
     * The String is trimmed using {@link String#trim()}. Trim removes start
     * and end characters &lt;= 32. To strip whitespace use
     * </p>
     *
     * <pre>
     * StringUtils.trimToNull(null)          = null
     * StringUtils.trimToNull(&quot;&quot;)            = null
     * StringUtils.trimToNull(&quot;     &quot;)       = null
     * StringUtils.trimToNull(&quot;abc&quot;)         = &quot;abc&quot;
     * StringUtils.trimToNull(&quot;    abc    &quot;) = &quot;abc&quot;
     * </pre>
     *
     * @param str the String to be trimmed, may be null
     * @return the trimmed String, {@code null} if only chars &lt;= 32, empty or
     * null String input
     * @since 2.0
     */
    public static String trimToNull(String str) {
        String ts = trim(str);
        return isEmpty(ts) ? null : ts;
    }

    /**
     * <p>
     * Removes control characters (char &lt;= 32) from both ends of this String
     * returning an empty String ("") if the String is empty ("") after the trim
     * or if it is {@code null}.
     *
     * <p>
     * The String is trimmed using {@link String#trim()}. Trim removes start
     * and end characters &lt;= 32. To strip whitespace use
     * {@link # stripToEmpty(String)}.
     * </p>
     *
     * <pre>
     * StringUtils.trimToEmpty(null)          = &quot;&quot;
     * StringUtils.trimToEmpty(&quot;&quot;)            = &quot;&quot;
     * StringUtils.trimToEmpty(&quot;     &quot;)       = &quot;&quot;
     * StringUtils.trimToEmpty(&quot;abc&quot;)         = &quot;abc&quot;
     * StringUtils.trimToEmpty(&quot;    abc    &quot;) = &quot;abc&quot;
     * </pre>
     *
     * @param str the String to be trimmed, may be null
     * @return the trimmed String, or an empty String if {@code null} input
     * @since 2.0
     */
    public static String trimToEmpty(String str) {
        return str == null ? EMPTY : str.trim();
    }

    /**
     * <p>
     * Removes all occurrences of a substring from within the source string.
     * </p>
     *
     * <p>
     * A {@code null} source string will return {@code null}. An empty ("")
     * source string will return the empty string. A {@code null} remove string
     * will return the source string. An empty ("") remove string will return
     * the source string.
     * </p>
     *
     * <pre>
     * StringUtils.remove(null, *)        = null
     * StringUtils.remove(&quot;&quot;, *)          = &quot;&quot;
     * StringUtils.remove(*, null)        = *
     * StringUtils.remove(*, &quot;&quot;)          = *
     * StringUtils.remove(&quot;queued&quot;, &quot;ue&quot;) = &quot;qd&quot;
     * StringUtils.remove(&quot;queued&quot;, &quot;zz&quot;) = &quot;queued&quot;
     * </pre>
     *
     * @param str    the source String to search, may be null
     * @param remove the String to search for and remove, may be null
     * @return the substring with the string removed if found, {@code null} if
     * null String input
     * @since 2.1
     */
    public static String remove(String str, String remove) {
        if (isEmpty(str) || isEmpty(remove)) {
            return str;
        }
        return replace(str, remove, EMPTY, -1);
    }

    /**
     * <p>
     * Removes all occurrences of a character from within the source string.
     * </p>
     *
     * <p>
     * A {@code null} source string will return {@code null}. An empty ("")
     * source string will return the empty string.
     * </p>
     *
     * <pre>
     * StringUtils.remove(null, *)       = null
     * StringUtils.remove(&quot;&quot;, *)         = &quot;&quot;
     * StringUtils.remove(&quot;queued&quot;, 'u') = &quot;qeed&quot;
     * StringUtils.remove(&quot;queued&quot;, 'z') = &quot;queued&quot;
     * </pre>
     *
     * @param str    the source String to search, may be null
     * @param remove the char to search for and remove, may be null
     * @return the substring with the char removed if found, {@code null} if
     * null String input
     * @since 2.1
     */
    public static String remove(String str, char remove) {
        if (isEmpty(str) || str.indexOf(remove) == INDEX_NOT_FOUND) {
            return str;
        }
        char[] chars = str.toCharArray();
        int pos = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != remove) {
                chars[pos++] = chars[i];
            }
        }
        return new String(chars, 0, pos);
    }

    // Replacing
    // -----------------------------------------------------------------------

    /**
     * <p>
     * Replaces a String with another String inside a larger String, once.
     * </p>
     *
     * <p>
     * A {@code null} reference passed to this method is a no-op.
     * </p>
     *
     * <pre>
     * StringUtils.replaceOnce(null, *, *)        = null
     * StringUtils.replaceOnce(&quot;&quot;, *, *)          = &quot;&quot;
     * StringUtils.replaceOnce(&quot;any&quot;, null, *)    = &quot;any&quot;
     * StringUtils.replaceOnce(&quot;any&quot;, *, null)    = &quot;any&quot;
     * StringUtils.replaceOnce(&quot;any&quot;, &quot;&quot;, *)      = &quot;any&quot;
     * StringUtils.replaceOnce(&quot;aba&quot;, &quot;a&quot;, null)  = &quot;aba&quot;
     * StringUtils.replaceOnce(&quot;aba&quot;, &quot;a&quot;, &quot;&quot;)    = &quot;ba&quot;
     * StringUtils.replaceOnce(&quot;aba&quot;, &quot;a&quot;, &quot;z&quot;)   = &quot;zba&quot;
     * </pre>
     *
     * @param text         text to search and replace in, may be null
     * @param searchString the String to search for, may be null
     * @param replacement  the String to replace with, may be null
     * @return the text with any replacements processed, {@code null} if null
     * String input
     * @see #replace(String text, String searchString, String replacement, int
     * max)
     */
    public static String replaceOnce(String text, String searchString,
                                     String replacement) {
        return replace(text, searchString, replacement, 1);
    }

    /**
     * <p>
     * Replaces all occurrences of a String within another String.
     * </p>
     *
     * <p>
     * A {@code null} reference passed to this method is a no-op.
     * </p>
     *
     * <pre>
     * StringUtils.replace(null, *, *)        = null
     * StringUtils.replace(&quot;&quot;, *, *)          = &quot;&quot;
     * StringUtils.replace(&quot;any&quot;, null, *)    = &quot;any&quot;
     * StringUtils.replace(&quot;any&quot;, *, null)    = &quot;any&quot;
     * StringUtils.replace(&quot;any&quot;, &quot;&quot;, *)      = &quot;any&quot;
     * StringUtils.replace(&quot;aba&quot;, &quot;a&quot;, null)  = &quot;aba&quot;
     * StringUtils.replace(&quot;aba&quot;, &quot;a&quot;, &quot;&quot;)    = &quot;b&quot;
     * StringUtils.replace(&quot;aba&quot;, &quot;a&quot;, &quot;z&quot;)   = &quot;zbz&quot;
     * </pre>
     *
     * @param text         text to search and replace in, may be null
     * @param searchString the String to search for, may be null
     * @param replacement  the String to replace it with, may be null
     * @return the text with any replacements processed, {@code null} if null
     * String input
     * @see #replace(String text, String searchString, String replacement, int
     * max)
     */
    public static String replace(String text, String searchString,
                                 String replacement) {
        return replace(text, searchString, replacement, -1);
    }

    /**
     * <p>
     * Replaces a String with another String inside a larger String, for the
     * first {@code max} values of the search String.
     * </p>
     *
     * <p>
     * A {@code null} reference passed to this method is a no-op.
     * </p>
     *
     * <pre>
     * StringUtils.replace(null, *, *, *)         = null
     * StringUtils.replace(&quot;&quot;, *, *, *)           = &quot;&quot;
     * StringUtils.replace(&quot;any&quot;, null, *, *)     = &quot;any&quot;
     * StringUtils.replace(&quot;any&quot;, *, null, *)     = &quot;any&quot;
     * StringUtils.replace(&quot;any&quot;, &quot;&quot;, *, *)       = &quot;any&quot;
     * StringUtils.replace(&quot;any&quot;, *, *, 0)        = &quot;any&quot;
     * StringUtils.replace(&quot;abaa&quot;, &quot;a&quot;, null, -1) = &quot;abaa&quot;
     * StringUtils.replace(&quot;abaa&quot;, &quot;a&quot;, &quot;&quot;, -1)   = &quot;b&quot;
     * StringUtils.replace(&quot;abaa&quot;, &quot;a&quot;, &quot;z&quot;, 0)   = &quot;abaa&quot;
     * StringUtils.replace(&quot;abaa&quot;, &quot;a&quot;, &quot;z&quot;, 1)   = &quot;zbaa&quot;
     * StringUtils.replace(&quot;abaa&quot;, &quot;a&quot;, &quot;z&quot;, 2)   = &quot;zbza&quot;
     * StringUtils.replace(&quot;abaa&quot;, &quot;a&quot;, &quot;z&quot;, -1)  = &quot;zbzz&quot;
     * </pre>
     *
     * @param text         text to search and replace in, may be null
     * @param searchString the String to search for, may be null
     * @param replacement  the String to replace it with, may be null
     * @param max          maximum number of values to replace, or {@code -1} if no
     *                     maximum
     * @return the text with any replacements processed, {@code null} if null
     * String input
     */
    public static String replace(String text, String searchString,
                                 String replacement, int max) {
        if (isEmpty(text) || isEmpty(searchString) || replacement == null
                || max == 0) {
            return text;
        }
        int start = 0;
        int end = text.indexOf(searchString, start);
        if (end == INDEX_NOT_FOUND) {
            return text;
        }
        int replLength = searchString.length();
        int increase = replacement.length() - replLength;
        increase = increase < 0 ? 0 : increase;
        increase *= max < 0 ? 16 : max > 64 ? 64 : max;
        StringBuilder buf = new StringBuilder(text.length() + increase);
        while (end != INDEX_NOT_FOUND) {
            buf.append(text.substring(start, end)).append(replacement);
            start = end + replLength;
            if (--max == 0) {
                break;
            }
            end = text.indexOf(searchString, start);
        }
        buf.append(text.substring(start));
        return buf.toString();
    }

    /**
     * <p>
     * Replaces all occurrences of Strings within another String.
     * </p>
     *
     * <p>
     * A {@code null} reference passed to this method is a no-op, or if any
     * "search string" or "string to replace" is null, that replace will be
     * ignored. This will not repeat. For repeating replaces, call the
     * overloaded method.
     * </p>
     *
     * <pre>
     *  StringUtils.replaceEach(null, *, *)        = null
     *  StringUtils.replaceEach(&quot;&quot;, *, *)          = &quot;&quot;
     *  StringUtils.replaceEach(&quot;aba&quot;, null, null) = &quot;aba&quot;
     *  StringUtils.replaceEach(&quot;aba&quot;, new String[0], null) = &quot;aba&quot;
     *  StringUtils.replaceEach(&quot;aba&quot;, null, new String[0]) = &quot;aba&quot;
     *  StringUtils.replaceEach(&quot;aba&quot;, new String[]{&quot;a&quot;}, null)  = &quot;aba&quot;
     *  StringUtils.replaceEach(&quot;aba&quot;, new String[]{&quot;a&quot;}, new String[]{&quot;&quot;})  = &quot;b&quot;
     *  StringUtils.replaceEach(&quot;aba&quot;, new String[]{null}, new String[]{&quot;a&quot;})  = &quot;aba&quot;
     *  StringUtils.replaceEach(&quot;abcde&quot;, new String[]{&quot;ab&quot;, &quot;d&quot;}, new String[]{&quot;w&quot;, &quot;t&quot;})  = &quot;wcte&quot;
     *  (example of how it does not repeat)
     *  StringUtils.replaceEach(&quot;abcde&quot;, new String[]{&quot;ab&quot;, &quot;d&quot;}, new String[]{&quot;d&quot;, &quot;t&quot;})  = &quot;dcte&quot;
     * </pre>
     *
     * @param text            text to search and replace in, no-op if null
     * @param searchList      the Strings to search for, no-op if null
     * @param replacementList the Strings to replace them with, no-op if null
     * @return the text with any replacements processed, {@code null} if null
     * String input
     * @throws IllegalArgumentException if the lengths of the arrays are not the same (null is ok,
     *                                  and/or size 0)
     * @since 2.4
     */
    public static String replaceEach(String text, String[] searchList,
                                     String[] replacementList) {
        return replaceEach(text, searchList, replacementList, false, 0);
    }

    /**
     * <p>
     * Replaces all occurrences of Strings within another String.
     * </p>
     *
     * <p>
     * A {@code null} reference passed to this method is a no-op, or if any
     * "search string" or "string to replace" is null, that replace will be
     * ignored.
     * </p>
     *
     * <pre>
     *  StringUtils.replaceEach(null, *, *, *) = null
     *  StringUtils.replaceEach(&quot;&quot;, *, *, *) = &quot;&quot;
     *  StringUtils.replaceEach(&quot;aba&quot;, null, null, *) = &quot;aba&quot;
     *  StringUtils.replaceEach(&quot;aba&quot;, new String[0], null, *) = &quot;aba&quot;
     *  StringUtils.replaceEach(&quot;aba&quot;, null, new String[0], *) = &quot;aba&quot;
     *  StringUtils.replaceEach(&quot;aba&quot;, new String[]{&quot;a&quot;}, null, *) = &quot;aba&quot;
     *  StringUtils.replaceEach(&quot;aba&quot;, new String[]{&quot;a&quot;}, new String[]{&quot;&quot;}, *) = &quot;b&quot;
     *  StringUtils.replaceEach(&quot;aba&quot;, new String[]{null}, new String[]{&quot;a&quot;}, *) = &quot;aba&quot;
     *  StringUtils.replaceEach(&quot;abcde&quot;, new String[]{&quot;ab&quot;, &quot;d&quot;}, new String[]{&quot;w&quot;, &quot;t&quot;}, *) = &quot;wcte&quot;
     *  (example of how it repeats)
     *  StringUtils.replaceEach(&quot;abcde&quot;, new String[]{&quot;ab&quot;, &quot;d&quot;}, new String[]{&quot;d&quot;, &quot;t&quot;}, false) = &quot;dcte&quot;
     *  StringUtils.replaceEach(&quot;abcde&quot;, new String[]{&quot;ab&quot;, &quot;d&quot;}, new String[]{&quot;d&quot;, &quot;t&quot;}, true) = &quot;tcte&quot;
     *  StringUtils.replaceEach(&quot;abcde&quot;, new String[]{&quot;ab&quot;, &quot;d&quot;}, new String[]{&quot;d&quot;, &quot;ab&quot;}, true) = IllegalStateException
     *  StringUtils.replaceEach(&quot;abcde&quot;, new String[]{&quot;ab&quot;, &quot;d&quot;}, new String[]{&quot;d&quot;, &quot;ab&quot;}, false) = &quot;dcabe&quot;
     * </pre>
     *
     * @param text            text to search and replace in, no-op if null
     * @param searchList      the Strings to search for, no-op if null
     * @param replacementList the Strings to replace them with, no-op if null
     * @return the text with any replacements processed, {@code null} if null
     * String input
     * @throws IllegalStateException    if the search is repeating and there is an endless loop due
     *                                  to outputs of one being inputs to another
     * @throws IllegalArgumentException if the lengths of the arrays are not the same (null is ok,
     *                                  and/or size 0)
     * @since 2.4
     */
    public static String replaceEachRepeatedly(String text,
                                               String[] searchList, String[] replacementList) {
        // timeToLive should be 0 if not used or nothing to replace, else it's
        // the length of the replace array
        int timeToLive = searchList == null ? 0 : searchList.length;
        return replaceEach(text, searchList, replacementList, true, timeToLive);
    }

    /**
     * <p>
     * Replaces all occurrences of Strings within another String.
     * </p>
     *
     * <p>
     * A {@code null} reference passed to this method is a no-op, or if any
     * "search string" or "string to replace" is null, that replace will be
     * ignored.
     * </p>
     *
     * <pre>
     *  StringUtils.replaceEach(null, *, *, *) = null
     *  StringUtils.replaceEach(&quot;&quot;, *, *, *) = &quot;&quot;
     *  StringUtils.replaceEach(&quot;aba&quot;, null, null, *) = &quot;aba&quot;
     *  StringUtils.replaceEach(&quot;aba&quot;, new String[0], null, *) = &quot;aba&quot;
     *  StringUtils.replaceEach(&quot;aba&quot;, null, new String[0], *) = &quot;aba&quot;
     *  StringUtils.replaceEach(&quot;aba&quot;, new String[]{&quot;a&quot;}, null, *) = &quot;aba&quot;
     *  StringUtils.replaceEach(&quot;aba&quot;, new String[]{&quot;a&quot;}, new String[]{&quot;&quot;}, *) = &quot;b&quot;
     *  StringUtils.replaceEach(&quot;aba&quot;, new String[]{null}, new String[]{&quot;a&quot;}, *) = &quot;aba&quot;
     *  StringUtils.replaceEach(&quot;abcde&quot;, new String[]{&quot;ab&quot;, &quot;d&quot;}, new String[]{&quot;w&quot;, &quot;t&quot;}, *) = &quot;wcte&quot;
     *  (example of how it repeats)
     *  StringUtils.replaceEach(&quot;abcde&quot;, new String[]{&quot;ab&quot;, &quot;d&quot;}, new String[]{&quot;d&quot;, &quot;t&quot;}, false) = &quot;dcte&quot;
     *  StringUtils.replaceEach(&quot;abcde&quot;, new String[]{&quot;ab&quot;, &quot;d&quot;}, new String[]{&quot;d&quot;, &quot;t&quot;}, true) = &quot;tcte&quot;
     *  StringUtils.replaceEach(&quot;abcde&quot;, new String[]{&quot;ab&quot;, &quot;d&quot;}, new String[]{&quot;d&quot;, &quot;ab&quot;}, *) = IllegalStateException
     * </pre>
     *
     * @param text            text to search and replace in, no-op if null
     * @param searchList      the Strings to search for, no-op if null
     * @param replacementList the Strings to replace them with, no-op if null
     * @param repeat          if true, then replace repeatedly until there are no more
     *                        possible replacements or timeToLive < 0
     * @param timeToLive      if less than 0 then there is a circular reference and endless
     *                        loop
     * @return the text with any replacements processed, {@code null} if null
     * String input
     * @throws IllegalStateException    if the search is repeating and there is an endless loop due
     *                                  to outputs of one being inputs to another
     * @throws IllegalArgumentException if the lengths of the arrays are not the same (null is ok,
     *                                  and/or size 0)
     * @since 2.4
     */
    private static String replaceEach(String text, String[] searchList,
                                      String[] replacementList, boolean repeat, int timeToLive) {

        // mchyzer Performance note: This creates very few new objects (one
        // major goal)
        // let me know if there are performance requests, we can create a
        // harness to measure

        if (text == null || text.length() == 0 || searchList == null
                || searchList.length == 0 || replacementList == null
                || replacementList.length == 0) {
            return text;
        }

        // if recursing, this shouldn't be less than 0
        if (timeToLive < 0) {
            throw new IllegalStateException(
                    "Aborting to protect against StackOverflowError - "
                            + "output of one loop is the input of another");
        }

        int searchLength = searchList.length;
        int replacementLength = replacementList.length;

        // make sure lengths are ok, these need to be equal
        if (searchLength != replacementLength) {
            throw new IllegalArgumentException(
                    "Search and Replace array lengths don't match: "
                            + searchLength + " vs " + replacementLength);
        }

        // keep track of which still have matches
        boolean[] noMoreMatchesForReplIndex = new boolean[searchLength];

        // index on index that the match was found
        int textIndex = -1;
        int replaceIndex = -1;
        int tempIndex = -1;

        // index of replace array that will replace the search string found
        // NOTE: logic duplicated below START
        for (int i = 0; i < searchLength; i++) {
            if (noMoreMatchesForReplIndex[i] || searchList[i] == null
                    || searchList[i].length() == 0
                    || replacementList[i] == null) {
                continue;
            }
            tempIndex = text.indexOf(searchList[i]);

            // see if we need to keep searching for this
            if (tempIndex == -1) {
                noMoreMatchesForReplIndex[i] = true;
            } else {
                if (textIndex == -1 || tempIndex < textIndex) {
                    textIndex = tempIndex;
                    replaceIndex = i;
                }
            }
        }
        // NOTE: logic mostly below END

        // no search strings found, we are done
        if (textIndex == -1) {
            return text;
        }

        int start = 0;

        // get a good guess on the size of the result buffer so it doesn't have
        // to double if it goes over a bit
        int increase = 0;

        // count the replacement text elements that are larger than their
        // corresponding text being replaced
        for (int i = 0; i < searchList.length; i++) {
            if (searchList[i] == null || replacementList[i] == null) {
                continue;
            }
            int greater = replacementList[i].length() - searchList[i].length();
            if (greater > 0) {
                increase += 3 * greater; // assume 3 matches
            }
        }
        // have upper-bound at 20% increase, then let Java take over
        increase = Math.min(increase, text.length() / 5);

        StringBuilder buf = new StringBuilder(text.length() + increase);

        while (textIndex != -1) {

            for (int i = start; i < textIndex; i++) {
                buf.append(text.charAt(i));
            }
            buf.append(replacementList[replaceIndex]);

            start = textIndex + searchList[replaceIndex].length();

            textIndex = -1;
            replaceIndex = -1;
            tempIndex = -1;
            // find the next earliest match
            // NOTE: logic mostly duplicated above START
            for (int i = 0; i < searchLength; i++) {
                if (noMoreMatchesForReplIndex[i] || searchList[i] == null
                        || searchList[i].length() == 0
                        || replacementList[i] == null) {
                    continue;
                }
                tempIndex = text.indexOf(searchList[i], start);

                // see if we need to keep searching for this
                if (tempIndex == -1) {
                    noMoreMatchesForReplIndex[i] = true;
                } else {
                    if (textIndex == -1 || tempIndex < textIndex) {
                        textIndex = tempIndex;
                        replaceIndex = i;
                    }
                }
            }
            // NOTE: logic duplicated above END

        }
        int textLength = text.length();
        for (int i = start; i < textLength; i++) {
            buf.append(text.charAt(i));
        }
        String result = buf.toString();
        if (!repeat) {
            return result;
        }

        return replaceEach(result, searchList, replacementList, repeat,
                timeToLive - 1);
    }

    // Replace, character based
    // -----------------------------------------------------------------------

    /**
     * <p>
     * Replaces all occurrences of a character in a String with another. This is
     * a null-safe version of {@link String#replace(char, char)}.
     * </p>
     *
     * <p>
     * A {@code null} string input returns {@code null}. An empty ("") string
     * input returns an empty string.
     * </p>
     *
     * <pre>
     * StringUtils.replaceChars(null, *, *)        = null
     * StringUtils.replaceChars(&quot;&quot;, *, *)          = &quot;&quot;
     * StringUtils.replaceChars(&quot;abcba&quot;, 'b', 'y') = &quot;aycya&quot;
     * StringUtils.replaceChars(&quot;abcba&quot;, 'z', 'y') = &quot;abcba&quot;
     * </pre>
     *
     * @param str         String to replace characters in, may be null
     * @param searchChar  the character to search for, may be null
     * @param replaceChar the character to replace, may be null
     * @return modified String, {@code null} if null string input
     * @since 2.0
     */
    public static String replaceChars(String str, char searchChar,
                                      char replaceChar) {
        if (str == null) {
            return null;
        }
        return str.replace(searchChar, replaceChar);
    }

    /**
     * <p>
     * Replaces multiple characters in a String in one go. This method can also
     * be used to delete characters.
     * </p>
     *
     * <p>
     * For example:<br />
     * <code>replaceChars(&quot;hello&quot;, &quot;ho&quot;, &quot;jy&quot;) = jelly</code>.
     * </p>
     *
     * <p>
     * A {@code null} string input returns {@code null}. An empty ("") string
     * input returns an empty string. A null or empty set of search characters
     * returns the input string.
     * </p>
     *
     * <p>
     * The length of the search characters should normally equal the length of
     * the replace characters. If the search characters is longer, then the
     * extra search characters are deleted. If the search characters is shorter,
     * then the extra replace characters are ignored.
     * </p>
     *
     * <pre>
     * StringUtils.replaceChars(null, *, *)           = null
     * StringUtils.replaceChars(&quot;&quot;, *, *)             = &quot;&quot;
     * StringUtils.replaceChars(&quot;abc&quot;, null, *)       = &quot;abc&quot;
     * StringUtils.replaceChars(&quot;abc&quot;, &quot;&quot;, *)         = &quot;abc&quot;
     * StringUtils.replaceChars(&quot;abc&quot;, &quot;b&quot;, null)     = &quot;ac&quot;
     * StringUtils.replaceChars(&quot;abc&quot;, &quot;b&quot;, &quot;&quot;)       = &quot;ac&quot;
     * StringUtils.replaceChars(&quot;abcba&quot;, &quot;bc&quot;, &quot;yz&quot;)  = &quot;ayzya&quot;
     * StringUtils.replaceChars(&quot;abcba&quot;, &quot;bc&quot;, &quot;y&quot;)   = &quot;ayya&quot;
     * StringUtils.replaceChars(&quot;abcba&quot;, &quot;bc&quot;, &quot;yzx&quot;) = &quot;ayzya&quot;
     * </pre>
     *
     * @param str          String to replace characters in, may be null
     * @param searchChars  a set of characters to search for, may be null
     * @param replaceChars a set of characters to replace, may be null
     * @return modified String, {@code null} if null string input
     * @since 2.0
     */
    public static String replaceChars(String str, String searchChars,
                                      String replaceChars) {
        if (isEmpty(str) || isEmpty(searchChars)) {
            return str;
        }
        if (replaceChars == null) {
            replaceChars = EMPTY;
        }
        boolean modified = false;
        int replaceCharsLength = replaceChars.length();
        int strLength = str.length();
        StringBuilder buf = new StringBuilder(strLength);
        for (int i = 0; i < strLength; i++) {
            char ch = str.charAt(i);
            int index = searchChars.indexOf(ch);
            if (index >= 0) {
                modified = true;
                if (index < replaceCharsLength) {
                    buf.append(replaceChars.charAt(index));
                }
            } else {
                buf.append(ch);
            }
        }
        if (modified) {
            return buf.toString();
        }
        return str;
    }

    public static boolean isNumeric(String cs) {
        if (cs == null || cs.length() == 0) {
            return false;
        }
        int sz = cs.length();
        for (int i = 0; i < sz; i++) {
            if (Character.isDigit(cs.charAt(i)) == false) {
                return false;
            }
        }
        return true;
    }

    /**
     * unicode 转字符串
     */
    public static String unicode2String(String unicode) {

        StringBuffer string = new StringBuffer();

        String[] hex = unicode.split("\\\\u");

        for (int i = 1; i < hex.length; i++) {

            // 转换出每一个代码点
            int data = Integer.parseInt(hex[i], 16);

            // 追加成string
            string.append((char) data);
        }

        return string.toString();
    }
}
