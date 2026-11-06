package com.amazon.a.a.o.c.a;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Stack;

/* JADX INFO: loaded from: classes3.dex */
public class b {
    private static final int c = -1;
    private static final char d = '/';
    private static final char e = '\\';
    private static final char g;
    public static final char a = '.';
    public static final String b = Character.toString(a);
    private static final char f = File.separatorChar;

    private static boolean a(char c2) {
        return c2 == '/' || c2 == '\\';
    }

    static {
        if (a()) {
            g = d;
        } else {
            g = e;
        }
    }

    static boolean a() {
        return f == '\\';
    }

    public static String a(String str) {
        return a(str, f, true);
    }

    public static String a(String str, boolean z) {
        return a(str, z ? d : e, true);
    }

    public static String b(String str) {
        return a(str, f, false);
    }

    public static String b(String str, boolean z) {
        return a(str, z ? d : e, false);
    }

    private static String a(String str, char c2, boolean z) {
        boolean z2;
        if (str == null) {
            return null;
        }
        s(str);
        int length = str.length();
        if (length == 0) {
            return str;
        }
        int iF = f(str);
        if (iF < 0) {
            return null;
        }
        int i = length + 2;
        char[] cArr = new char[i];
        str.getChars(0, str.length(), cArr, 0);
        char c3 = f;
        if (c2 == c3) {
            c3 = g;
        }
        for (int i2 = 0; i2 < i; i2++) {
            if (cArr[i2] == c3) {
                cArr[i2] = c2;
            }
        }
        if (cArr[length - 1] != c2) {
            cArr[length] = c2;
            length++;
            z2 = false;
        } else {
            z2 = true;
        }
        int i3 = iF + 1;
        int i4 = i3;
        while (i4 < length) {
            if (cArr[i4] == c2) {
                int i5 = i4 - 1;
                if (cArr[i5] == c2) {
                    System.arraycopy(cArr, i4, cArr, i5, length - i4);
                    length--;
                    i4--;
                }
            }
            i4++;
        }
        int i6 = i3;
        while (i6 < length) {
            if (cArr[i6] == c2) {
                int i7 = i6 - 1;
                if (cArr[i7] == '.' && (i6 == i3 || cArr[i6 - 2] == c2)) {
                    if (i6 == length - 1) {
                        z2 = true;
                    }
                    System.arraycopy(cArr, i6 + 1, cArr, i7, length - i6);
                    length -= 2;
                    i6--;
                }
            }
            i6++;
        }
        int i8 = iF + 2;
        int i9 = i8;
        while (i9 < length) {
            if (cArr[i9] == c2 && cArr[i9 - 1] == '.' && cArr[i9 - 2] == '.' && (i9 == i8 || cArr[i9 - 3] == c2)) {
                if (i9 == i8) {
                    return null;
                }
                if (i9 == length - 1) {
                    z2 = true;
                }
                int i10 = i9 - 4;
                while (true) {
                    if (i10 >= iF) {
                        if (cArr[i10] == c2) {
                            int i11 = i10 + 1;
                            System.arraycopy(cArr, i9 + 1, cArr, i11, length - i9);
                            length -= i9 - i10;
                            i9 = i11;
                            break;
                        }
                        i10--;
                    } else {
                        int i12 = i9 + 1;
                        System.arraycopy(cArr, i12, cArr, iF, length - i9);
                        length -= i12 - iF;
                        i9 = i3;
                        break;
                    }
                }
            }
            i9++;
        }
        if (length <= 0) {
            return "";
        }
        if (length <= iF) {
            return new String(cArr, 0, length);
        }
        if (z2 && z) {
            return new String(cArr, 0, length);
        }
        return new String(cArr, 0, length - 1);
    }

    public static String a(String str, String str2) {
        int iF = f(str2);
        if (iF < 0) {
            return null;
        }
        if (iF > 0) {
            return a(str2);
        }
        if (str == null) {
            return null;
        }
        int length = str.length();
        if (length == 0) {
            return a(str2);
        }
        if (a(str.charAt(length - 1))) {
            return a(str + str2);
        }
        return a(str + d + str2);
    }

    public static boolean b(String str, String str2) throws IOException {
        if (str == null) {
            throw new IllegalArgumentException("Directory must not be null");
        }
        if (str2 == null) {
            return false;
        }
        d dVar = d.SYSTEM;
        if (dVar.b(str, str2)) {
            return false;
        }
        return dVar.c(str2, str);
    }

    public static String c(String str) {
        return (str == null || str.indexOf(92) == -1) ? str : str.replace(e, d);
    }

    public static String d(String str) {
        return (str == null || str.indexOf(47) == -1) ? str : str.replace(d, e);
    }

    public static String e(String str) {
        if (str == null) {
            return null;
        }
        if (a()) {
            return d(str);
        }
        return c(str);
    }

    public static int f(String str) {
        int iMin;
        if (str == null) {
            return -1;
        }
        int length = str.length();
        if (length == 0) {
            return 0;
        }
        char cCharAt = str.charAt(0);
        if (cCharAt == ':') {
            return -1;
        }
        if (length == 1) {
            if (cCharAt == '~') {
                return 2;
            }
            return a(cCharAt) ? 1 : 0;
        }
        if (cCharAt == '~') {
            int iIndexOf = str.indexOf(47, 1);
            int iIndexOf2 = str.indexOf(92, 1);
            if (iIndexOf == -1 && iIndexOf2 == -1) {
                return length + 1;
            }
            if (iIndexOf == -1) {
                iIndexOf = iIndexOf2;
            }
            if (iIndexOf2 == -1) {
                iIndexOf2 = iIndexOf;
            }
            iMin = Math.min(iIndexOf, iIndexOf2);
        } else {
            char cCharAt2 = str.charAt(1);
            if (cCharAt2 == ':') {
                char upperCase = Character.toUpperCase(cCharAt);
                if (upperCase < 'A' || upperCase > 'Z') {
                    return -1;
                }
                return (length == 2 || !a(str.charAt(2))) ? 2 : 3;
            }
            if (!a(cCharAt) || !a(cCharAt2)) {
                return a(cCharAt) ? 1 : 0;
            }
            int iIndexOf3 = str.indexOf(47, 2);
            int iIndexOf4 = str.indexOf(92, 2);
            if ((iIndexOf3 == -1 && iIndexOf4 == -1) || iIndexOf3 == 2 || iIndexOf4 == 2) {
                return -1;
            }
            if (iIndexOf3 == -1) {
                iIndexOf3 = iIndexOf4;
            }
            if (iIndexOf4 == -1) {
                iIndexOf4 = iIndexOf3;
            }
            iMin = Math.min(iIndexOf3, iIndexOf4);
        }
        return iMin + 1;
    }

    public static int g(String str) {
        if (str == null) {
            return -1;
        }
        return Math.max(str.lastIndexOf(47), str.lastIndexOf(92));
    }

    public static int h(String str) {
        int iLastIndexOf;
        if (str != null && g(str) <= (iLastIndexOf = str.lastIndexOf(46))) {
            return iLastIndexOf;
        }
        return -1;
    }

    public static String i(String str) {
        int iF;
        if (str == null || (iF = f(str)) < 0) {
            return null;
        }
        if (iF > str.length()) {
            s(str + d);
            return str + d;
        }
        String strSubstring = str.substring(0, iF);
        s(strSubstring);
        return strSubstring;
    }

    public static String j(String str) {
        return a(str, 1);
    }

    public static String k(String str) {
        return a(str, 0);
    }

    private static String a(String str, int i) {
        int iF;
        if (str == null || (iF = f(str)) < 0) {
            return null;
        }
        int iG = g(str);
        int i2 = i + iG;
        if (iF >= str.length() || iG < 0 || iF >= i2) {
            return "";
        }
        String strSubstring = str.substring(iF, i2);
        s(strSubstring);
        return strSubstring;
    }

    public static String l(String str) {
        return c(str, true);
    }

    public static String m(String str) {
        return c(str, false);
    }

    private static String c(String str, boolean z) {
        int iF;
        if (str == null || (iF = f(str)) < 0) {
            return null;
        }
        if (iF >= str.length()) {
            return z ? i(str) : str;
        }
        int iG = g(str);
        if (iG < 0) {
            return str.substring(0, iF);
        }
        int i = iG + (z ? 1 : 0);
        if (i == 0) {
            i++;
        }
        return str.substring(0, i);
    }

    public static String n(String str) {
        if (str == null) {
            return null;
        }
        s(str);
        return str.substring(g(str) + 1);
    }

    private static void s(String str) {
        int length = str.length();
        for (int i = 0; i < length; i++) {
            if (str.charAt(i) == 0) {
                throw new IllegalArgumentException("Null byte present in file/path name. There are no known legitimate use cases for such data, but several injection attacks may use it");
            }
        }
    }

    public static String o(String str) {
        return q(n(str));
    }

    public static String p(String str) {
        if (str == null) {
            return null;
        }
        int iH = h(str);
        if (iH == -1) {
            return "";
        }
        return str.substring(iH + 1);
    }

    public static String q(String str) {
        if (str == null) {
            return null;
        }
        s(str);
        int iH = h(str);
        return iH == -1 ? str : str.substring(0, iH);
    }

    public static boolean c(String str, String str2) {
        return a(str, str2, false, d.SENSITIVE);
    }

    public static boolean d(String str, String str2) {
        return a(str, str2, false, d.SYSTEM);
    }

    public static boolean e(String str, String str2) {
        return a(str, str2, true, d.SENSITIVE);
    }

    public static boolean f(String str, String str2) {
        return a(str, str2, true, d.SYSTEM);
    }

    public static boolean a(String str, String str2, boolean z, d dVar) {
        if (str == null || str2 == null) {
            return str == null && str2 == null;
        }
        if (z) {
            str = a(str);
            str2 = a(str2);
            if (str == null || str2 == null) {
                throw new NullPointerException("Error normalizing one or both of the file names");
            }
        }
        if (dVar == null) {
            dVar = d.SENSITIVE;
        }
        return dVar.b(str, str2);
    }

    public static boolean g(String str, String str2) {
        if (str == null) {
            return false;
        }
        s(str);
        if (str2 == null || str2.isEmpty()) {
            return h(str) == -1;
        }
        return p(str).equals(str2);
    }

    public static boolean a(String str, String[] strArr) {
        if (str == null) {
            return false;
        }
        s(str);
        if (strArr == null || strArr.length == 0) {
            return h(str) == -1;
        }
        String strP = p(str);
        for (String str2 : strArr) {
            if (strP.equals(str2)) {
                return true;
            }
        }
        return false;
    }

    public static boolean a(String str, Collection<String> collection) {
        if (str == null) {
            return false;
        }
        s(str);
        if (collection == null || collection.isEmpty()) {
            return h(str) == -1;
        }
        String strP = p(str);
        Iterator<String> it = collection.iterator();
        while (it.hasNext()) {
            if (strP.equals(it.next())) {
                return true;
            }
        }
        return false;
    }

    public static boolean h(String str, String str2) {
        return a(str, str2, d.SENSITIVE);
    }

    public static boolean i(String str, String str2) {
        return a(str, str2, d.SYSTEM);
    }

    public static boolean a(String str, String str2, d dVar) {
        if (str == null && str2 == null) {
            return true;
        }
        if (str != null && str2 != null) {
            if (dVar == null) {
                dVar = d.SENSITIVE;
            }
            String[] strArrR = r(str2);
            Stack stack = new Stack();
            boolean z = false;
            int length = 0;
            int i = 0;
            do {
                if (stack.size() > 0) {
                    int[] iArr = (int[]) stack.pop();
                    i = iArr[0];
                    length = iArr[1];
                    z = true;
                }
                while (i < strArrR.length) {
                    if (strArrR[i].equals("?")) {
                        length++;
                        if (length > str.length()) {
                            break;
                        }
                        z = false;
                        i++;
                    } else {
                        if (strArrR[i].equals("*")) {
                            if (i == strArrR.length - 1) {
                                length = str.length();
                            }
                            z = true;
                        } else if (z) {
                            length = dVar.a(str, length, strArrR[i]);
                            if (length == -1) {
                                break;
                            }
                            int iA = dVar.a(str, length + 1, strArrR[i]);
                            if (iA >= 0) {
                                stack.push(new int[]{i, iA});
                            }
                            length += strArrR[i].length();
                            z = false;
                        } else {
                            if (!dVar.b(str, length, strArrR[i])) {
                                break;
                            }
                            length += strArrR[i].length();
                            z = false;
                        }
                        i++;
                    }
                }
                if (i == strArrR.length && length == str.length()) {
                    return true;
                }
            } while (stack.size() > 0);
        }
        return false;
    }

    static String[] r(String str) {
        if (str.indexOf(63) == -1 && str.indexOf(42) == -1) {
            return new String[]{str};
        }
        char[] charArray = str.toCharArray();
        ArrayList arrayList = new ArrayList();
        StringBuilder sb = new StringBuilder();
        int length = charArray.length;
        int i = 0;
        char c2 = 0;
        while (i < length) {
            char c3 = charArray[i];
            if (c3 == '?' || c3 == '*') {
                if (sb.length() != 0) {
                    arrayList.add(sb.toString());
                    sb.setLength(0);
                }
                if (c3 == '?') {
                    arrayList.add("?");
                } else if (c2 != '*') {
                    arrayList.add("*");
                }
            } else {
                sb.append(c3);
            }
            i++;
            c2 = c3;
        }
        if (sb.length() != 0) {
            arrayList.add(sb.toString());
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }
}
