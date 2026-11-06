package org.apache.commons.io;

import com.amazon.a.a.o.c.a.b;
import java.io.File;

/* JADX INFO: loaded from: classes5.dex */
public abstract class FilenameUtils {
    private static final char OTHER_SEPARATOR;
    public static final String EXTENSION_SEPARATOR_STR = Character.toString(b.a);
    private static final char SYSTEM_SEPARATOR = File.separatorChar;

    static {
        if (isSystemWindows()) {
            OTHER_SEPARATOR = '/';
        } else {
            OTHER_SEPARATOR = '\\';
        }
    }

    static boolean isSystemWindows() {
        return SYSTEM_SEPARATOR == '\\';
    }

    public static int indexOfLastSeparator(String str) {
        if (str == null) {
            return -1;
        }
        return Math.max(str.lastIndexOf(47), str.lastIndexOf(92));
    }

    public static int indexOfExtension(String str) {
        int iLastIndexOf;
        if (str != null && indexOfLastSeparator(str) <= (iLastIndexOf = str.lastIndexOf(46))) {
            return iLastIndexOf;
        }
        return -1;
    }

    public static String getExtension(String str) {
        if (str == null) {
            return null;
        }
        int iIndexOfExtension = indexOfExtension(str);
        if (iIndexOfExtension == -1) {
            return "";
        }
        return str.substring(iIndexOfExtension + 1);
    }
}
