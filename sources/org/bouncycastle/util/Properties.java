package org.bouncycastle.util;

import java.security.AccessControlException;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.security.Security;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public abstract class Properties {
    private static final ThreadLocal threadProperties = new ThreadLocal();

    public static String getPropertyValue(final String str) {
        String str2;
        String str3 = (String) AccessController.doPrivileged(new PrivilegedAction() { // from class: org.bouncycastle.util.Properties.1
            @Override // java.security.PrivilegedAction
            public Object run() {
                return Security.getProperty(str);
            }
        });
        if (str3 != null) {
            return str3;
        }
        Map map = (Map) threadProperties.get();
        return (map == null || (str2 = (String) map.get(str)) == null) ? (String) AccessController.doPrivileged(new PrivilegedAction() { // from class: org.bouncycastle.util.Properties.2
            @Override // java.security.PrivilegedAction
            public Object run() {
                return System.getProperty(str);
            }
        }) : str2;
    }

    public static boolean isOverrideSet(String str) {
        try {
            return isSetTrue(getPropertyValue(str));
        } catch (AccessControlException unused) {
            return false;
        }
    }

    private static boolean isSetTrue(String str) {
        if (str == null || str.length() != 4) {
            return false;
        }
        return (str.charAt(0) == 't' || str.charAt(0) == 'T') && (str.charAt(1) == 'r' || str.charAt(1) == 'R') && ((str.charAt(2) == 'u' || str.charAt(2) == 'U') && (str.charAt(3) == 'e' || str.charAt(3) == 'E'));
    }
}
