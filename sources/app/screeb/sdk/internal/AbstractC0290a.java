package app.screeb.sdk.internal;

import android.graphics.Rect;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: renamed from: app.screeb.sdk.internal.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC0290a {
    public static final Rect a;
    public static final int[] b;
    public static final int[] c;
    public static T d;
    public static int e;
    public static int f;
    public static final HashMap g;
    public static final HashMap h;
    public static final Method i;
    public static final Field j;
    public static final Method k;

    static {
        Method declaredMethod;
        Field declaredField;
        Class cls = Integer.TYPE;
        a = new Rect();
        b = new int[2];
        c = new int[2];
        g = new HashMap(4);
        h = new HashMap(32);
        Method method = null;
        try {
            declaredMethod = AccessibilityNodeInfo.class.getDeclaredMethod("getChildId", cls);
            declaredMethod.setAccessible(true);
        } catch (Throwable unused) {
            declaredMethod = null;
        }
        i = declaredMethod;
        try {
            declaredField = AccessibilityNodeInfo.class.getDeclaredField("mChildNodeIds");
            declaredField.setAccessible(true);
        } catch (Throwable unused2) {
            declaredField = null;
        }
        j = declaredField;
        try {
            Method declaredMethod2 = Class.forName("android.util.LongArray").getDeclaredMethod(com.amazon.a.a.o.b.au, cls);
            declaredMethod2.setAccessible(true);
            method = declaredMethod2;
        } catch (Throwable unused3) {
        }
        k = method;
    }

    public static byte a(AccessibilityNodeInfo accessibilityNodeInfo) {
        String string;
        CharSequence className = accessibilityNodeInfo.getClassName();
        if (className == null || (string = className.toString()) == null) {
            return (byte) 0;
        }
        if (StringsKt.endsWith$default(string, "Button", false, 2, (Object) null)) {
            return (byte) 4;
        }
        if (StringsKt.endsWith$default(string, "EditText", false, 2, (Object) null) || StringsKt.endsWith$default(string, "TextField", false, 2, (Object) null)) {
            return (byte) 3;
        }
        if (StringsKt.endsWith$default(string, "TextView", false, 2, (Object) null) || StringsKt.endsWith$default(string, "Text", false, 2, (Object) null)) {
            return (byte) 1;
        }
        return (StringsKt.endsWith$default(string, "ImageView", false, 2, (Object) null) || StringsKt.endsWith$default(string, "Image", false, 2, (Object) null)) ? (byte) 5 : (byte) 0;
    }

    public static int a(View hostView, N n, long j2, int i2, boolean z, T t) throws Throwable {
        AccessibilityNodeInfo accessibilityNodeInfoCreateAccessibilityNodeInfo;
        AccessibilityNodeInfo accessibilityNodeInfo;
        AccessibilityNodeProvider accessibilityNodeProvider;
        Object obj;
        Object obj2;
        Field declaredField;
        Field field;
        Intrinsics.checkNotNullParameter(hostView, "hostView");
        N buf = n;
        Intrinsics.checkNotNullParameter(buf, "buf");
        AccessibilityNodeProvider accessibilityNodeProvider2 = hostView.getAccessibilityNodeProvider();
        if (accessibilityNodeProvider2 == null) {
            Class<?> cls = hostView.getClass();
            HashMap map = g;
            Object obj3 = map.get(cls);
            if (obj3 == null) {
                Class<?> superclass = cls;
                while (true) {
                    if (superclass == null || Intrinsics.areEqual(superclass, View.class)) {
                        obj = obj3;
                        declaredField = null;
                        break;
                    }
                    try {
                        obj = obj3;
                        declaredField = superclass.getDeclaredField("accessibilityBridge");
                        break;
                    } catch (Throwable unused) {
                        superclass = superclass.getSuperclass();
                    }
                }
                if (declaredField != null) {
                    declaredField.setAccessible(true);
                    field = declaredField;
                } else {
                    field = null;
                }
                map.put(cls, field);
                obj = field;
            }
            obj = obj3;
            Field field2 = (Field) obj;
            if (field2 != null) {
                try {
                    obj2 = field2.get(hostView);
                } catch (Throwable unused2) {
                }
            } else {
                obj2 = null;
            }
            accessibilityNodeProvider2 = obj2 instanceof AccessibilityNodeProvider ? (AccessibilityNodeProvider) obj2 : null;
        }
        int i3 = 0;
        if (accessibilityNodeProvider2 == null) {
            return 0;
        }
        try {
            accessibilityNodeInfoCreateAccessibilityNodeInfo = accessibilityNodeProvider2.createAccessibilityNodeInfo(-1);
        } catch (Throwable unused3) {
            accessibilityNodeInfoCreateAccessibilityNodeInfo = null;
        }
        if (accessibilityNodeInfoCreateAccessibilityNodeInfo == null) {
            try {
                accessibilityNodeInfoCreateAccessibilityNodeInfo = accessibilityNodeProvider2.createAccessibilityNodeInfo(0);
            } catch (Throwable unused4) {
                accessibilityNodeInfoCreateAccessibilityNodeInfo = null;
            }
            if (accessibilityNodeInfoCreateAccessibilityNodeInfo == null) {
                return 0;
            }
        }
        int[] iArr = b;
        hostView.getLocationOnScreen(iArr);
        int i4 = iArr[0];
        int i5 = iArr[1];
        d = t;
        int[] iArr2 = c;
        hostView.getLocationInWindow(iArr2);
        e = iArr2[0] - i4;
        f = iArr2[1] - i5;
        float f2 = hostView.getResources().getDisplayMetrics().density;
        if (f2 <= 0.0f) {
            f2 = 1.0f;
        }
        float f3 = f2;
        try {
            int[] iArr3 = {0};
            int iA = 0;
            for (int childCount = accessibilityNodeInfoCreateAccessibilityNodeInfo.getChildCount(); i3 < childCount; childCount = childCount) {
                int i6 = i3;
                AccessibilityNodeInfo accessibilityNodeInfoA = a(accessibilityNodeProvider2, accessibilityNodeInfoCreateAccessibilityNodeInfo, i6);
                if (accessibilityNodeInfoA == null) {
                    accessibilityNodeProvider = accessibilityNodeProvider2;
                    accessibilityNodeInfo = accessibilityNodeInfoCreateAccessibilityNodeInfo;
                } else {
                    accessibilityNodeProvider = accessibilityNodeProvider2;
                    accessibilityNodeInfo = accessibilityNodeInfoCreateAccessibilityNodeInfo;
                    try {
                        iA += a(accessibilityNodeProvider, accessibilityNodeInfoA, buf, j2, i2, iArr3, 1, i4, i5, hostView.getWidth(), hostView.getHeight(), f3, z);
                    } catch (Throwable th) {
                        th = th;
                        d = null;
                        try {
                            accessibilityNodeInfo.recycle();
                        } catch (Throwable unused5) {
                        }
                        throw th;
                    }
                }
                i3 = i6 + 1;
                buf = n;
                accessibilityNodeInfoCreateAccessibilityNodeInfo = accessibilityNodeInfo;
                accessibilityNodeProvider2 = accessibilityNodeProvider;
            }
            AccessibilityNodeInfo accessibilityNodeInfo2 = accessibilityNodeInfoCreateAccessibilityNodeInfo;
            d = null;
            try {
                accessibilityNodeInfo2.recycle();
            } catch (Throwable unused6) {
            }
            return iA;
        } catch (Throwable th2) {
            th = th2;
            accessibilityNodeInfo = accessibilityNodeInfoCreateAccessibilityNodeInfo;
        }
    }

    /* JADX WARN: Code duplicated, block: B:108:0x0251  */
    /* JADX WARN: Code duplicated, block: B:113:0x025c A[Catch: all -> 0x008d, TryCatch #5 {all -> 0x008d, blocks: (B:6:0x0011, B:10:0x002e, B:12:0x006a, B:15:0x0078, B:17:0x0082, B:24:0x0092, B:37:0x00b8, B:39:0x00bc, B:42:0x00d8, B:46:0x00e5, B:48:0x00f1, B:53:0x0106, B:55:0x010c, B:93:0x01d3, B:95:0x0208, B:96:0x020f, B:98:0x0218, B:100:0x0233, B:102:0x0239, B:104:0x023f, B:106:0x0247, B:107:0x024e, B:121:0x0284, B:124:0x0290, B:128:0x02a9, B:131:0x02b0, B:133:0x02b6, B:141:0x02c9, B:144:0x02d0, B:147:0x02ed, B:149:0x02f6, B:152:0x030f, B:156:0x032b, B:160:0x0344, B:164:0x034d, B:168:0x0355, B:170:0x0368, B:172:0x0377, B:175:0x0382, B:138:0x02c1, B:113:0x025c, B:115:0x0264, B:118:0x026d, B:119:0x0274, B:120:0x0279, B:61:0x0124, B:63:0x012a, B:65:0x0130, B:67:0x0136, B:70:0x013e, B:78:0x014f, B:80:0x0156, B:82:0x015e, B:84:0x0167, B:87:0x0175, B:52:0x0100, B:27:0x0099, B:30:0x00a4, B:181:0x03a5, B:183:0x03a9), top: B:210:0x0011 }] */
    /* JADX WARN: Code duplicated, block: B:115:0x0264 A[Catch: all -> 0x008d, TryCatch #5 {all -> 0x008d, blocks: (B:6:0x0011, B:10:0x002e, B:12:0x006a, B:15:0x0078, B:17:0x0082, B:24:0x0092, B:37:0x00b8, B:39:0x00bc, B:42:0x00d8, B:46:0x00e5, B:48:0x00f1, B:53:0x0106, B:55:0x010c, B:93:0x01d3, B:95:0x0208, B:96:0x020f, B:98:0x0218, B:100:0x0233, B:102:0x0239, B:104:0x023f, B:106:0x0247, B:107:0x024e, B:121:0x0284, B:124:0x0290, B:128:0x02a9, B:131:0x02b0, B:133:0x02b6, B:141:0x02c9, B:144:0x02d0, B:147:0x02ed, B:149:0x02f6, B:152:0x030f, B:156:0x032b, B:160:0x0344, B:164:0x034d, B:168:0x0355, B:170:0x0368, B:172:0x0377, B:175:0x0382, B:138:0x02c1, B:113:0x025c, B:115:0x0264, B:118:0x026d, B:119:0x0274, B:120:0x0279, B:61:0x0124, B:63:0x012a, B:65:0x0130, B:67:0x0136, B:70:0x013e, B:78:0x014f, B:80:0x0156, B:82:0x015e, B:84:0x0167, B:87:0x0175, B:52:0x0100, B:27:0x0099, B:30:0x00a4, B:181:0x03a5, B:183:0x03a9), top: B:210:0x0011 }] */
    /* JADX WARN: Code duplicated, block: B:117:0x026b A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:118:0x026d A[Catch: all -> 0x008d, TryCatch #5 {all -> 0x008d, blocks: (B:6:0x0011, B:10:0x002e, B:12:0x006a, B:15:0x0078, B:17:0x0082, B:24:0x0092, B:37:0x00b8, B:39:0x00bc, B:42:0x00d8, B:46:0x00e5, B:48:0x00f1, B:53:0x0106, B:55:0x010c, B:93:0x01d3, B:95:0x0208, B:96:0x020f, B:98:0x0218, B:100:0x0233, B:102:0x0239, B:104:0x023f, B:106:0x0247, B:107:0x024e, B:121:0x0284, B:124:0x0290, B:128:0x02a9, B:131:0x02b0, B:133:0x02b6, B:141:0x02c9, B:144:0x02d0, B:147:0x02ed, B:149:0x02f6, B:152:0x030f, B:156:0x032b, B:160:0x0344, B:164:0x034d, B:168:0x0355, B:170:0x0368, B:172:0x0377, B:175:0x0382, B:138:0x02c1, B:113:0x025c, B:115:0x0264, B:118:0x026d, B:119:0x0274, B:120:0x0279, B:61:0x0124, B:63:0x012a, B:65:0x0130, B:67:0x0136, B:70:0x013e, B:78:0x014f, B:80:0x0156, B:82:0x015e, B:84:0x0167, B:87:0x0175, B:52:0x0100, B:27:0x0099, B:30:0x00a4, B:181:0x03a5, B:183:0x03a9), top: B:210:0x0011 }] */
    /* JADX WARN: Code duplicated, block: B:124:0x0290 A[Catch: all -> 0x008d, LOOP:0: B:122:0x028c->B:124:0x0290, LOOP_END, TryCatch #5 {all -> 0x008d, blocks: (B:6:0x0011, B:10:0x002e, B:12:0x006a, B:15:0x0078, B:17:0x0082, B:24:0x0092, B:37:0x00b8, B:39:0x00bc, B:42:0x00d8, B:46:0x00e5, B:48:0x00f1, B:53:0x0106, B:55:0x010c, B:93:0x01d3, B:95:0x0208, B:96:0x020f, B:98:0x0218, B:100:0x0233, B:102:0x0239, B:104:0x023f, B:106:0x0247, B:107:0x024e, B:121:0x0284, B:124:0x0290, B:128:0x02a9, B:131:0x02b0, B:133:0x02b6, B:141:0x02c9, B:144:0x02d0, B:147:0x02ed, B:149:0x02f6, B:152:0x030f, B:156:0x032b, B:160:0x0344, B:164:0x034d, B:168:0x0355, B:170:0x0368, B:172:0x0377, B:175:0x0382, B:138:0x02c1, B:113:0x025c, B:115:0x0264, B:118:0x026d, B:119:0x0274, B:120:0x0279, B:61:0x0124, B:63:0x012a, B:65:0x0130, B:67:0x0136, B:70:0x013e, B:78:0x014f, B:80:0x0156, B:82:0x015e, B:84:0x0167, B:87:0x0175, B:52:0x0100, B:27:0x0099, B:30:0x00a4, B:181:0x03a5, B:183:0x03a9), top: B:210:0x0011 }] */
    /* JADX WARN: Code duplicated, block: B:138:0x02c1 A[Catch: all -> 0x008d, TryCatch #5 {all -> 0x008d, blocks: (B:6:0x0011, B:10:0x002e, B:12:0x006a, B:15:0x0078, B:17:0x0082, B:24:0x0092, B:37:0x00b8, B:39:0x00bc, B:42:0x00d8, B:46:0x00e5, B:48:0x00f1, B:53:0x0106, B:55:0x010c, B:93:0x01d3, B:95:0x0208, B:96:0x020f, B:98:0x0218, B:100:0x0233, B:102:0x0239, B:104:0x023f, B:106:0x0247, B:107:0x024e, B:121:0x0284, B:124:0x0290, B:128:0x02a9, B:131:0x02b0, B:133:0x02b6, B:141:0x02c9, B:144:0x02d0, B:147:0x02ed, B:149:0x02f6, B:152:0x030f, B:156:0x032b, B:160:0x0344, B:164:0x034d, B:168:0x0355, B:170:0x0368, B:172:0x0377, B:175:0x0382, B:138:0x02c1, B:113:0x025c, B:115:0x0264, B:118:0x026d, B:119:0x0274, B:120:0x0279, B:61:0x0124, B:63:0x012a, B:65:0x0130, B:67:0x0136, B:70:0x013e, B:78:0x014f, B:80:0x0156, B:82:0x015e, B:84:0x0167, B:87:0x0175, B:52:0x0100, B:27:0x0099, B:30:0x00a4, B:181:0x03a5, B:183:0x03a9), top: B:210:0x0011 }] */
    /* JADX WARN: Code duplicated, block: B:139:0x02c6  */
    /* JADX WARN: Code duplicated, block: B:145:0x02e7  */
    /* JADX WARN: Code duplicated, block: B:147:0x02ed A[Catch: all -> 0x008d, TryCatch #5 {all -> 0x008d, blocks: (B:6:0x0011, B:10:0x002e, B:12:0x006a, B:15:0x0078, B:17:0x0082, B:24:0x0092, B:37:0x00b8, B:39:0x00bc, B:42:0x00d8, B:46:0x00e5, B:48:0x00f1, B:53:0x0106, B:55:0x010c, B:93:0x01d3, B:95:0x0208, B:96:0x020f, B:98:0x0218, B:100:0x0233, B:102:0x0239, B:104:0x023f, B:106:0x0247, B:107:0x024e, B:121:0x0284, B:124:0x0290, B:128:0x02a9, B:131:0x02b0, B:133:0x02b6, B:141:0x02c9, B:144:0x02d0, B:147:0x02ed, B:149:0x02f6, B:152:0x030f, B:156:0x032b, B:160:0x0344, B:164:0x034d, B:168:0x0355, B:170:0x0368, B:172:0x0377, B:175:0x0382, B:138:0x02c1, B:113:0x025c, B:115:0x0264, B:118:0x026d, B:119:0x0274, B:120:0x0279, B:61:0x0124, B:63:0x012a, B:65:0x0130, B:67:0x0136, B:70:0x013e, B:78:0x014f, B:80:0x0156, B:82:0x015e, B:84:0x0167, B:87:0x0175, B:52:0x0100, B:27:0x0099, B:30:0x00a4, B:181:0x03a5, B:183:0x03a9), top: B:210:0x0011 }] */
    /* JADX WARN: Code duplicated, block: B:149:0x02f6 A[Catch: all -> 0x008d, LOOP:1: B:148:0x02f4->B:149:0x02f6, LOOP_END, TryCatch #5 {all -> 0x008d, blocks: (B:6:0x0011, B:10:0x002e, B:12:0x006a, B:15:0x0078, B:17:0x0082, B:24:0x0092, B:37:0x00b8, B:39:0x00bc, B:42:0x00d8, B:46:0x00e5, B:48:0x00f1, B:53:0x0106, B:55:0x010c, B:93:0x01d3, B:95:0x0208, B:96:0x020f, B:98:0x0218, B:100:0x0233, B:102:0x0239, B:104:0x023f, B:106:0x0247, B:107:0x024e, B:121:0x0284, B:124:0x0290, B:128:0x02a9, B:131:0x02b0, B:133:0x02b6, B:141:0x02c9, B:144:0x02d0, B:147:0x02ed, B:149:0x02f6, B:152:0x030f, B:156:0x032b, B:160:0x0344, B:164:0x034d, B:168:0x0355, B:170:0x0368, B:172:0x0377, B:175:0x0382, B:138:0x02c1, B:113:0x025c, B:115:0x0264, B:118:0x026d, B:119:0x0274, B:120:0x0279, B:61:0x0124, B:63:0x012a, B:65:0x0130, B:67:0x0136, B:70:0x013e, B:78:0x014f, B:80:0x0156, B:82:0x015e, B:84:0x0167, B:87:0x0175, B:52:0x0100, B:27:0x0099, B:30:0x00a4, B:181:0x03a5, B:183:0x03a9), top: B:210:0x0011 }] */
    /* JADX WARN: Code duplicated, block: B:151:0x030c  */
    /* JADX WARN: Code duplicated, block: B:154:0x0328  */
    /* JADX WARN: Code duplicated, block: B:155:0x0329  */
    /* JADX WARN: Code duplicated, block: B:158:0x0340  */
    /* JADX WARN: Code duplicated, block: B:159:0x0343  */
    /* JADX WARN: Code duplicated, block: B:162:0x0348  */
    /* JADX WARN: Code duplicated, block: B:163:0x034b  */
    /* JADX WARN: Code duplicated, block: B:166:0x0351  */
    /* JADX WARN: Code duplicated, block: B:167:0x0354  */
    /* JADX WARN: Code duplicated, block: B:170:0x0368 A[Catch: all -> 0x008d, TryCatch #5 {all -> 0x008d, blocks: (B:6:0x0011, B:10:0x002e, B:12:0x006a, B:15:0x0078, B:17:0x0082, B:24:0x0092, B:37:0x00b8, B:39:0x00bc, B:42:0x00d8, B:46:0x00e5, B:48:0x00f1, B:53:0x0106, B:55:0x010c, B:93:0x01d3, B:95:0x0208, B:96:0x020f, B:98:0x0218, B:100:0x0233, B:102:0x0239, B:104:0x023f, B:106:0x0247, B:107:0x024e, B:121:0x0284, B:124:0x0290, B:128:0x02a9, B:131:0x02b0, B:133:0x02b6, B:141:0x02c9, B:144:0x02d0, B:147:0x02ed, B:149:0x02f6, B:152:0x030f, B:156:0x032b, B:160:0x0344, B:164:0x034d, B:168:0x0355, B:170:0x0368, B:172:0x0377, B:175:0x0382, B:138:0x02c1, B:113:0x025c, B:115:0x0264, B:118:0x026d, B:119:0x0274, B:120:0x0279, B:61:0x0124, B:63:0x012a, B:65:0x0130, B:67:0x0136, B:70:0x013e, B:78:0x014f, B:80:0x0156, B:82:0x015e, B:84:0x0167, B:87:0x0175, B:52:0x0100, B:27:0x0099, B:30:0x00a4, B:181:0x03a5, B:183:0x03a9), top: B:210:0x0011 }] */
    /* JADX WARN: Code duplicated, block: B:172:0x0377 A[Catch: all -> 0x008d, TryCatch #5 {all -> 0x008d, blocks: (B:6:0x0011, B:10:0x002e, B:12:0x006a, B:15:0x0078, B:17:0x0082, B:24:0x0092, B:37:0x00b8, B:39:0x00bc, B:42:0x00d8, B:46:0x00e5, B:48:0x00f1, B:53:0x0106, B:55:0x010c, B:93:0x01d3, B:95:0x0208, B:96:0x020f, B:98:0x0218, B:100:0x0233, B:102:0x0239, B:104:0x023f, B:106:0x0247, B:107:0x024e, B:121:0x0284, B:124:0x0290, B:128:0x02a9, B:131:0x02b0, B:133:0x02b6, B:141:0x02c9, B:144:0x02d0, B:147:0x02ed, B:149:0x02f6, B:152:0x030f, B:156:0x032b, B:160:0x0344, B:164:0x034d, B:168:0x0355, B:170:0x0368, B:172:0x0377, B:175:0x0382, B:138:0x02c1, B:113:0x025c, B:115:0x0264, B:118:0x026d, B:119:0x0274, B:120:0x0279, B:61:0x0124, B:63:0x012a, B:65:0x0130, B:67:0x0136, B:70:0x013e, B:78:0x014f, B:80:0x0156, B:82:0x015e, B:84:0x0167, B:87:0x0175, B:52:0x0100, B:27:0x0099, B:30:0x00a4, B:181:0x03a5, B:183:0x03a9), top: B:210:0x0011 }] */
    /* JADX WARN: Code duplicated, block: B:174:0x037e  */
    /* JADX WARN: Code duplicated, block: B:175:0x0382 A[Catch: all -> 0x008d, TRY_LEAVE, TryCatch #5 {all -> 0x008d, blocks: (B:6:0x0011, B:10:0x002e, B:12:0x006a, B:15:0x0078, B:17:0x0082, B:24:0x0092, B:37:0x00b8, B:39:0x00bc, B:42:0x00d8, B:46:0x00e5, B:48:0x00f1, B:53:0x0106, B:55:0x010c, B:93:0x01d3, B:95:0x0208, B:96:0x020f, B:98:0x0218, B:100:0x0233, B:102:0x0239, B:104:0x023f, B:106:0x0247, B:107:0x024e, B:121:0x0284, B:124:0x0290, B:128:0x02a9, B:131:0x02b0, B:133:0x02b6, B:141:0x02c9, B:144:0x02d0, B:147:0x02ed, B:149:0x02f6, B:152:0x030f, B:156:0x032b, B:160:0x0344, B:164:0x034d, B:168:0x0355, B:170:0x0368, B:172:0x0377, B:175:0x0382, B:138:0x02c1, B:113:0x025c, B:115:0x0264, B:118:0x026d, B:119:0x0274, B:120:0x0279, B:61:0x0124, B:63:0x012a, B:65:0x0130, B:67:0x0136, B:70:0x013e, B:78:0x014f, B:80:0x0156, B:82:0x015e, B:84:0x0167, B:87:0x0175, B:52:0x0100, B:27:0x0099, B:30:0x00a4, B:181:0x03a5, B:183:0x03a9), top: B:210:0x0011 }] */
    /* JADX WARN: Code duplicated, block: B:208:0x0144 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:59:0x0120 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:60:0x0122 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:77:0x014d  */
    /* JADX WARN: Code duplicated, block: B:80:0x0156 A[Catch: all -> 0x008d, TryCatch #5 {all -> 0x008d, blocks: (B:6:0x0011, B:10:0x002e, B:12:0x006a, B:15:0x0078, B:17:0x0082, B:24:0x0092, B:37:0x00b8, B:39:0x00bc, B:42:0x00d8, B:46:0x00e5, B:48:0x00f1, B:53:0x0106, B:55:0x010c, B:93:0x01d3, B:95:0x0208, B:96:0x020f, B:98:0x0218, B:100:0x0233, B:102:0x0239, B:104:0x023f, B:106:0x0247, B:107:0x024e, B:121:0x0284, B:124:0x0290, B:128:0x02a9, B:131:0x02b0, B:133:0x02b6, B:141:0x02c9, B:144:0x02d0, B:147:0x02ed, B:149:0x02f6, B:152:0x030f, B:156:0x032b, B:160:0x0344, B:164:0x034d, B:168:0x0355, B:170:0x0368, B:172:0x0377, B:175:0x0382, B:138:0x02c1, B:113:0x025c, B:115:0x0264, B:118:0x026d, B:119:0x0274, B:120:0x0279, B:61:0x0124, B:63:0x012a, B:65:0x0130, B:67:0x0136, B:70:0x013e, B:78:0x014f, B:80:0x0156, B:82:0x015e, B:84:0x0167, B:87:0x0175, B:52:0x0100, B:27:0x0099, B:30:0x00a4, B:181:0x03a5, B:183:0x03a9), top: B:210:0x0011 }] */
    /* JADX WARN: Code duplicated, block: B:84:0x0167 A[Catch: all -> 0x008d, TryCatch #5 {all -> 0x008d, blocks: (B:6:0x0011, B:10:0x002e, B:12:0x006a, B:15:0x0078, B:17:0x0082, B:24:0x0092, B:37:0x00b8, B:39:0x00bc, B:42:0x00d8, B:46:0x00e5, B:48:0x00f1, B:53:0x0106, B:55:0x010c, B:93:0x01d3, B:95:0x0208, B:96:0x020f, B:98:0x0218, B:100:0x0233, B:102:0x0239, B:104:0x023f, B:106:0x0247, B:107:0x024e, B:121:0x0284, B:124:0x0290, B:128:0x02a9, B:131:0x02b0, B:133:0x02b6, B:141:0x02c9, B:144:0x02d0, B:147:0x02ed, B:149:0x02f6, B:152:0x030f, B:156:0x032b, B:160:0x0344, B:164:0x034d, B:168:0x0355, B:170:0x0368, B:172:0x0377, B:175:0x0382, B:138:0x02c1, B:113:0x025c, B:115:0x0264, B:118:0x026d, B:119:0x0274, B:120:0x0279, B:61:0x0124, B:63:0x012a, B:65:0x0130, B:67:0x0136, B:70:0x013e, B:78:0x014f, B:80:0x0156, B:82:0x015e, B:84:0x0167, B:87:0x0175, B:52:0x0100, B:27:0x0099, B:30:0x00a4, B:181:0x03a5, B:183:0x03a9), top: B:210:0x0011 }] */
    /* JADX WARN: Code duplicated, block: B:86:0x016e  */
    /* JADX WARN: Code duplicated, block: B:87:0x0175 A[Catch: all -> 0x008d, TRY_LEAVE, TryCatch #5 {all -> 0x008d, blocks: (B:6:0x0011, B:10:0x002e, B:12:0x006a, B:15:0x0078, B:17:0x0082, B:24:0x0092, B:37:0x00b8, B:39:0x00bc, B:42:0x00d8, B:46:0x00e5, B:48:0x00f1, B:53:0x0106, B:55:0x010c, B:93:0x01d3, B:95:0x0208, B:96:0x020f, B:98:0x0218, B:100:0x0233, B:102:0x0239, B:104:0x023f, B:106:0x0247, B:107:0x024e, B:121:0x0284, B:124:0x0290, B:128:0x02a9, B:131:0x02b0, B:133:0x02b6, B:141:0x02c9, B:144:0x02d0, B:147:0x02ed, B:149:0x02f6, B:152:0x030f, B:156:0x032b, B:160:0x0344, B:164:0x034d, B:168:0x0355, B:170:0x0368, B:172:0x0377, B:175:0x0382, B:138:0x02c1, B:113:0x025c, B:115:0x0264, B:118:0x026d, B:119:0x0274, B:120:0x0279, B:61:0x0124, B:63:0x012a, B:65:0x0130, B:67:0x0136, B:70:0x013e, B:78:0x014f, B:80:0x0156, B:82:0x015e, B:84:0x0167, B:87:0x0175, B:52:0x0100, B:27:0x0099, B:30:0x00a4, B:181:0x03a5, B:183:0x03a9), top: B:210:0x0011 }] */
    /* JADX WARN: Code duplicated, block: B:95:0x0208 A[Catch: all -> 0x008d, TryCatch #5 {all -> 0x008d, blocks: (B:6:0x0011, B:10:0x002e, B:12:0x006a, B:15:0x0078, B:17:0x0082, B:24:0x0092, B:37:0x00b8, B:39:0x00bc, B:42:0x00d8, B:46:0x00e5, B:48:0x00f1, B:53:0x0106, B:55:0x010c, B:93:0x01d3, B:95:0x0208, B:96:0x020f, B:98:0x0218, B:100:0x0233, B:102:0x0239, B:104:0x023f, B:106:0x0247, B:107:0x024e, B:121:0x0284, B:124:0x0290, B:128:0x02a9, B:131:0x02b0, B:133:0x02b6, B:141:0x02c9, B:144:0x02d0, B:147:0x02ed, B:149:0x02f6, B:152:0x030f, B:156:0x032b, B:160:0x0344, B:164:0x034d, B:168:0x0355, B:170:0x0368, B:172:0x0377, B:175:0x0382, B:138:0x02c1, B:113:0x025c, B:115:0x0264, B:118:0x026d, B:119:0x0274, B:120:0x0279, B:61:0x0124, B:63:0x012a, B:65:0x0130, B:67:0x0136, B:70:0x013e, B:78:0x014f, B:80:0x0156, B:82:0x015e, B:84:0x0167, B:87:0x0175, B:52:0x0100, B:27:0x0099, B:30:0x00a4, B:181:0x03a5, B:183:0x03a9), top: B:210:0x0011 }] */
    /* JADX WARN: Code duplicated, block: B:98:0x0218 A[Catch: all -> 0x008d, TryCatch #5 {all -> 0x008d, blocks: (B:6:0x0011, B:10:0x002e, B:12:0x006a, B:15:0x0078, B:17:0x0082, B:24:0x0092, B:37:0x00b8, B:39:0x00bc, B:42:0x00d8, B:46:0x00e5, B:48:0x00f1, B:53:0x0106, B:55:0x010c, B:93:0x01d3, B:95:0x0208, B:96:0x020f, B:98:0x0218, B:100:0x0233, B:102:0x0239, B:104:0x023f, B:106:0x0247, B:107:0x024e, B:121:0x0284, B:124:0x0290, B:128:0x02a9, B:131:0x02b0, B:133:0x02b6, B:141:0x02c9, B:144:0x02d0, B:147:0x02ed, B:149:0x02f6, B:152:0x030f, B:156:0x032b, B:160:0x0344, B:164:0x034d, B:168:0x0355, B:170:0x0368, B:172:0x0377, B:175:0x0382, B:138:0x02c1, B:113:0x025c, B:115:0x0264, B:118:0x026d, B:119:0x0274, B:120:0x0279, B:61:0x0124, B:63:0x012a, B:65:0x0130, B:67:0x0136, B:70:0x013e, B:78:0x014f, B:80:0x0156, B:82:0x015e, B:84:0x0167, B:87:0x0175, B:52:0x0100, B:27:0x0099, B:30:0x00a4, B:181:0x03a5, B:183:0x03a9), top: B:210:0x0011 }] */
    /* JADX WARN: Code duplicated, block: B:99:0x022f  */
    public static int a(AccessibilityNodeProvider accessibilityNodeProvider, AccessibilityNodeInfo accessibilityNodeInfo, N n, long j2, int i2, int[] iArr, int i3, int i4, int i5, int i6, int i7, float f2, boolean z) {
        int i8;
        int i9;
        String strA;
        String strRemovePrefix;
        CharSequence text;
        CharSequence contentDescription;
        int childCount;
        int i10;
        int iA;
        AccessibilityNodeInfo accessibilityNodeInfoA;
        int i11;
        long j3;
        long j4;
        int length;
        int length2;
        int i12;
        int length3;
        CharSequence className;
        String str;
        int i13;
        int length4;
        int i14;
        long jCharAt;
        int i15;
        CharSequence contentDescription2;
        int i16;
        int length5;
        long jCharAt2;
        int i17;
        int i18;
        int i19;
        int childCount2;
        int[] iArr2;
        int iA2;
        int i20;
        AccessibilityNodeInfo accessibilityNodeInfoA2;
        int i21;
        int length6;
        int i22;
        String string;
        T t;
        AccessibilityNodeProvider accessibilityNodeProvider2 = accessibilityNodeProvider;
        int i23 = i3;
        if (i23 > 32) {
            try {
                accessibilityNodeInfo.recycle();
            } catch (Throwable unused) {
            }
            return 0;
        }
        try {
            int i24 = iArr[0];
            iArr[0] = i24 + 1;
            Rect rect = a;
            accessibilityNodeInfo.getBoundsInScreen(rect);
            int i25 = rect.left;
            int i26 = rect.top;
            int iWidth = rect.width();
            int iHeight = rect.height();
            if (iWidth != 0 && iHeight != 0) {
                int iRound = Math.round(i25 / f2) - Math.round(i4 / f2);
                int i27 = i5;
                int iRound2 = Math.round(i26 / f2) - Math.round(i27 / f2);
                int iRound3 = Math.round(iWidth / f2);
                int iRound4 = Math.round(iHeight / f2);
                String viewIdResourceName = accessibilityNodeInfo.getViewIdResourceName();
                if (Intrinsics.areEqual(viewIdResourceName, "screeb-no-capture") || Intrinsics.areEqual(viewIdResourceName, "screebNoCapture")) {
                    T t2 = d;
                    if (t2 != null) {
                        int i28 = i25 + e;
                        int i29 = i26 + f;
                        int[] iArr3 = T.d;
                        t2.a(i28, i29, iWidth + i28, iHeight + i29, i2, false);
                        Unit unit = Unit.INSTANCE;
                    }
                    try {
                        accessibilityNodeInfo.recycle();
                        return 0;
                    } catch (Throwable unused2) {
                        return 0;
                    }
                }
                int i30 = 1;
                boolean z2 = Intrinsics.areEqual(viewIdResourceName, "screeb-mask-text") || Intrinsics.areEqual(viewIdResourceName, "screebMaskText");
                boolean z3 = accessibilityNodeInfo.isPassword() || o0.a(accessibilityNodeInfo.getContentDescription()) || o0.a(accessibilityNodeInfo.getText()) || z2;
                if (z3 && (t = d) != null) {
                    int i31 = i25 + e;
                    int i32 = i26 + f;
                    int[] iArr4 = T.d;
                    t.a(i31, i32, i31 + iWidth, i32 + iHeight, i2, false);
                    Unit unit2 = Unit.INSTANCE;
                }
                boolean z4 = z2;
                try {
                    if (viewIdResourceName != null && viewIdResourceName.length() != 0 && !z4) {
                        i8 = i25;
                        i9 = i26;
                        if (StringsKt.startsWith$default(viewIdResourceName, "screebId:", false, 2, (Object) null)) {
                            strRemovePrefix = StringsKt.removePrefix(viewIdResourceName, "screebId:");
                            if (strRemovePrefix.length() != 0) {
                                strA = null;
                            }
                        } else {
                            strA = AbstractC0302g.a(viewIdResourceName);
                            strRemovePrefix = null;
                        }
                        if (accessibilityNodeInfo.getClassName() != null || Intrinsics.areEqual(accessibilityNodeInfo.getClassName(), "android.view.View")) {
                            if (strRemovePrefix == null && strA == null && (((text = accessibilityNodeInfo.getText()) == null || text.length() == 0) && (((contentDescription = accessibilityNodeInfo.getContentDescription()) == null || contentDescription.length() == 0) && !z3))) {
                                if (accessibilityNodeInfo.getChildCount() == 0) {
                                    try {
                                        accessibilityNodeInfo.recycle();
                                        return 0;
                                    } catch (Throwable unused3) {
                                        return 0;
                                    }
                                }
                                if (Math.abs(iWidth - i6) <= 2 && Math.abs(iHeight - i7) <= 2) {
                                    childCount = accessibilityNodeInfo.getChildCount();
                                    i10 = 0;
                                    iA = 0;
                                    while (i10 < childCount) {
                                        int i33 = childCount;
                                        accessibilityNodeInfoA = a(accessibilityNodeProvider2, accessibilityNodeInfo, i10);
                                        if (accessibilityNodeInfoA != null) {
                                            iA += a(accessibilityNodeProvider2, accessibilityNodeInfoA, n, j2, i2, iArr, i23 + 1, i4, i27, i6, i7, f2, z);
                                        }
                                        i10++;
                                        i23 = i3;
                                        i27 = i5;
                                        childCount = i33;
                                    }
                                    try {
                                        accessibilityNodeInfo.recycle();
                                    } catch (Throwable unused4) {
                                    }
                                    return iA;
                                }
                            }
                        }
                        i11 = iWidth;
                        long j5 = i2;
                        j3 = 1;
                        j4 = (((((-7046029254386353131L) * j5) ^ (7809847782465536322L * j2)) ^ ((((long) i24) + 1) * 5871781006564002453L)) & 72057594037927935L) | ((j5 & 255) << 56);
                        length = n.p.length();
                        StringBuilder sb = n.p;
                        sb.append("position:absolute;left:");
                        sb.append(iRound);
                        sb.append("px;top:");
                        sb.append(iRound2);
                        sb.append("px;width:");
                        sb.append(iRound3);
                        sb.append("px;height:");
                        sb.append(iRound4);
                        sb.append("px;margin:0");
                        if (z3) {
                            n.p.append(";background-color:#ccc;overflow:hidden");
                        }
                        length2 = n.p.length() - length;
                        if (strRemovePrefix != null) {
                            int length7 = n.q.length();
                            n.q.append(strRemovePrefix);
                            length3 = n.q.length() - length7;
                            i12 = length7;
                        } else {
                            i12 = -1;
                            length3 = 0;
                        }
                        className = accessibilityNodeInfo.getClassName();
                        if (className != null || (string = className.toString()) == null) {
                            str = null;
                        } else {
                            HashMap map = h;
                            Object objA = map.get(string);
                            if (objA == null) {
                                objA = AbstractC0302g.a(string);
                                map.put(string, objA);
                            }
                            str = (String) objA;
                        }
                        if (str == null || strA != null) {
                            int length8 = n.q.length();
                            if (str != null) {
                                n.q.append(str);
                            }
                            if (strA != null) {
                                if (str != null) {
                                    n.q.append(' ');
                                }
                                n.q.append(strA);
                            }
                            i13 = length8;
                            length4 = n.q.length() - length8;
                        } else {
                            i13 = -1;
                            length4 = 0;
                        }
                        i14 = i13 + length4;
                        jCharAt = 0;
                        i15 = i13;
                        while (i15 < i14) {
                            jCharAt = (jCharAt * ((long) 31)) + ((long) n.q.charAt(i15));
                            i15++;
                            length2 = length2;
                        }
                        int i34 = length2;
                        if (!z3 || z || accessibilityNodeInfo.getChildCount() > 0) {
                            contentDescription2 = null;
                        } else {
                            CharSequence text2 = accessibilityNodeInfo.getText();
                            if (text2 == null) {
                                contentDescription2 = accessibilityNodeInfo.getContentDescription();
                            } else {
                                contentDescription2 = text2.length() > 0 ? text2 : null;
                                if (contentDescription2 == null) {
                                    contentDescription2 = accessibilityNodeInfo.getContentDescription();
                                }
                            }
                        }
                        if (contentDescription2 != null || contentDescription2.length() == 0) {
                            i16 = -1;
                            length5 = 0;
                        } else {
                            int length9 = n.q.length();
                            n.q.append(contentDescription2);
                            i16 = length9;
                            length5 = n.q.length() - length9;
                        }
                        if (contentDescription2 != null) {
                            length6 = contentDescription2.length();
                            jCharAt2 = 0;
                            i22 = 0;
                            while (i22 < length6) {
                                jCharAt2 = (jCharAt2 * ((long) 31)) + ((long) contentDescription2.charAt(i22));
                                i22++;
                                length = length;
                            }
                        } else {
                            jCharAt2 = 0;
                        }
                        int i35 = length;
                        long j6 = (((long) iRound4) * ((long) 5)) + (((long) iRound3) * ((long) 7)) + (((long) iRound2) * ((long) 13)) + (((long) 17) * j2) + ((long) iRound);
                        if (z3) {
                            j3 = 0;
                        }
                        long j7 = ((j6 ^ j3) ^ (jCharAt2 * 1099511628211L)) ^ (jCharAt * 1099511628211L);
                        byte bA = a(accessibilityNodeInfo);
                        if (length3 > 0) {
                            i17 = 1;
                        } else {
                            i17 = 0;
                        }
                        int i36 = i17 | 4;
                        if (length4 > 0) {
                            i18 = 2;
                        } else {
                            i18 = 0;
                        }
                        int i37 = i36 | i18;
                        if (length5 > 0) {
                            i19 = 8;
                        } else {
                            i19 = 0;
                        }
                        n.a(j4, j2, bA, (byte) (i37 | i19), i35, i34, i12, length3, i13, length4, i16, length5, i24, j7);
                        if (!z3) {
                            childCount2 = accessibilityNodeInfo.getChildCount();
                            iArr2 = new int[]{0};
                            iA2 = 1;
                            i20 = 0;
                            while (i20 < childCount2) {
                                int i38 = i20;
                                accessibilityNodeInfoA2 = a(accessibilityNodeProvider2, accessibilityNodeInfo, i38);
                                if (accessibilityNodeInfoA2 == null) {
                                    i21 = i11;
                                } else {
                                    i21 = i11;
                                    iA2 += a(accessibilityNodeProvider2, accessibilityNodeInfoA2, n, j4, i2, iArr2, i3 + 1, i8, i9, i21, iHeight, f2, z);
                                }
                                i20 = i38 + 1;
                                accessibilityNodeProvider2 = accessibilityNodeProvider;
                                i11 = i21;
                            }
                            i30 = iA2;
                        }
                        accessibilityNodeInfo.recycle();
                        return i30;
                    }
                    i8 = i25;
                    i9 = i26;
                    accessibilityNodeInfo.recycle();
                } catch (Throwable unused5) {
                }
                strRemovePrefix = null;
                strA = null;
                if (accessibilityNodeInfo.getClassName() != null) {
                    if (strRemovePrefix == null) {
                        if (accessibilityNodeInfo.getChildCount() == 0) {
                            accessibilityNodeInfo.recycle();
                            return 0;
                        }
                        if (Math.abs(iWidth - i6) <= 2) {
                            childCount = accessibilityNodeInfo.getChildCount();
                            i10 = 0;
                            iA = 0;
                            while (i10 < childCount) {
                                int i39 = childCount;
                                accessibilityNodeInfoA = a(accessibilityNodeProvider2, accessibilityNodeInfo, i10);
                                if (accessibilityNodeInfoA != null) {
                                    iA += a(accessibilityNodeProvider2, accessibilityNodeInfoA, n, j2, i2, iArr, i23 + 1, i4, i27, i6, i7, f2, z);
                                }
                                i10++;
                                i23 = i3;
                                i27 = i5;
                                childCount = i39;
                            }
                            accessibilityNodeInfo.recycle();
                            return iA;
                        }
                    }
                } else if (strRemovePrefix == null) {
                    if (accessibilityNodeInfo.getChildCount() == 0) {
                        accessibilityNodeInfo.recycle();
                        return 0;
                    }
                    if (Math.abs(iWidth - i6) <= 2) {
                        childCount = accessibilityNodeInfo.getChildCount();
                        i10 = 0;
                        iA = 0;
                        while (i10 < childCount) {
                            int i310 = childCount;
                            accessibilityNodeInfoA = a(accessibilityNodeProvider2, accessibilityNodeInfo, i10);
                            if (accessibilityNodeInfoA != null) {
                                iA += a(accessibilityNodeProvider2, accessibilityNodeInfoA, n, j2, i2, iArr, i23 + 1, i4, i27, i6, i7, f2, z);
                            }
                            i10++;
                            i23 = i3;
                            i27 = i5;
                            childCount = i310;
                        }
                        accessibilityNodeInfo.recycle();
                        return iA;
                    }
                }
                i11 = iWidth;
                long j8 = i2;
                j3 = 1;
                j4 = (((((-7046029254386353131L) * j8) ^ (7809847782465536322L * j2)) ^ ((((long) i24) + 1) * 5871781006564002453L)) & 72057594037927935L) | ((j8 & 255) << 56);
                length = n.p.length();
                StringBuilder sb2 = n.p;
                sb2.append("position:absolute;left:");
                sb2.append(iRound);
                sb2.append("px;top:");
                sb2.append(iRound2);
                sb2.append("px;width:");
                sb2.append(iRound3);
                sb2.append("px;height:");
                sb2.append(iRound4);
                sb2.append("px;margin:0");
                if (z3) {
                    n.p.append(";background-color:#ccc;overflow:hidden");
                }
                length2 = n.p.length() - length;
                if (strRemovePrefix != null) {
                    int length10 = n.q.length();
                    n.q.append(strRemovePrefix);
                    length3 = n.q.length() - length10;
                    i12 = length10;
                } else {
                    i12 = -1;
                    length3 = 0;
                }
                className = accessibilityNodeInfo.getClassName();
                if (className != null) {
                    str = null;
                } else {
                    str = null;
                }
                if (str == null) {
                    int length11 = n.q.length();
                    if (str != null) {
                        n.q.append(str);
                    }
                    if (strA != null) {
                        if (str != null) {
                            n.q.append(' ');
                        }
                        n.q.append(strA);
                    }
                    i13 = length11;
                    length4 = n.q.length() - length11;
                } else {
                    int length12 = n.q.length();
                    if (str != null) {
                        n.q.append(str);
                    }
                    if (strA != null) {
                        if (str != null) {
                            n.q.append(' ');
                        }
                        n.q.append(strA);
                    }
                    i13 = length12;
                    length4 = n.q.length() - length12;
                }
                i14 = i13 + length4;
                jCharAt = 0;
                i15 = i13;
                while (i15 < i14) {
                    jCharAt = (jCharAt * ((long) 31)) + ((long) n.q.charAt(i15));
                    i15++;
                    length2 = length2;
                }
                int i311 = length2;
                if (z3) {
                    contentDescription2 = null;
                } else {
                    contentDescription2 = null;
                }
                if (contentDescription2 != null) {
                    i16 = -1;
                    length5 = 0;
                } else {
                    i16 = -1;
                    length5 = 0;
                }
                if (contentDescription2 != null) {
                    length6 = contentDescription2.length();
                    jCharAt2 = 0;
                    i22 = 0;
                    while (i22 < length6) {
                        jCharAt2 = (jCharAt2 * ((long) 31)) + ((long) contentDescription2.charAt(i22));
                        i22++;
                        length = length;
                    }
                } else {
                    jCharAt2 = 0;
                }
                int i312 = length;
                long j9 = (((long) iRound4) * ((long) 5)) + (((long) iRound3) * ((long) 7)) + (((long) iRound2) * ((long) 13)) + (((long) 17) * j2) + ((long) iRound);
                if (z3) {
                    j3 = 0;
                }
                long j10 = ((j9 ^ j3) ^ (jCharAt2 * 1099511628211L)) ^ (jCharAt * 1099511628211L);
                byte bA2 = a(accessibilityNodeInfo);
                if (length3 > 0) {
                    i17 = 1;
                } else {
                    i17 = 0;
                }
                int i313 = i17 | 4;
                if (length4 > 0) {
                    i18 = 2;
                } else {
                    i18 = 0;
                }
                int i314 = i313 | i18;
                if (length5 > 0) {
                    i19 = 8;
                } else {
                    i19 = 0;
                }
                n.a(j4, j2, bA2, (byte) (i314 | i19), i312, i311, i12, length3, i13, length4, i16, length5, i24, j10);
                if (!z3) {
                    childCount2 = accessibilityNodeInfo.getChildCount();
                    iArr2 = new int[]{0};
                    iA2 = 1;
                    i20 = 0;
                    while (i20 < childCount2) {
                        int i315 = i20;
                        accessibilityNodeInfoA2 = a(accessibilityNodeProvider2, accessibilityNodeInfo, i315);
                        if (accessibilityNodeInfoA2 == null) {
                            i21 = i11;
                        } else {
                            i21 = i11;
                            iA2 += a(accessibilityNodeProvider2, accessibilityNodeInfoA2, n, j4, i2, iArr2, i3 + 1, i8, i9, i21, iHeight, f2, z);
                        }
                        i20 = i315 + 1;
                        accessibilityNodeProvider2 = accessibilityNodeProvider;
                        i11 = i21;
                    }
                    i30 = iA2;
                }
                return i30;
            }
            try {
                accessibilityNodeInfo.recycle();
                return 0;
            } catch (Throwable unused6) {
                return 0;
            }
        } catch (Throwable th) {
            try {
                accessibilityNodeInfo.recycle();
            } catch (Throwable unused7) {
            }
            throw th;
        }
    }

    /* JADX WARN: Code duplicated, block: B:20:0x003d  */
    /* JADX WARN: Code duplicated, block: B:30:0x0038 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public static AccessibilityNodeInfo a(AccessibilityNodeProvider accessibilityNodeProvider, AccessibilityNodeInfo accessibilityNodeInfo, int i2) {
        Long l;
        Method method;
        Object objInvoke;
        Method method2 = i;
        try {
            if (method2 == null) {
                Field field = j;
                if (field == null || (method = k) == null) {
                    l = null;
                } else {
                    Object obj = field.get(accessibilityNodeInfo);
                    if (obj == null) {
                        return null;
                    }
                    objInvoke = method.invoke(obj, Integer.valueOf(i2));
                }
                if (l == null) {
                    try {
                    } catch (Throwable unused) {
                        return null;
                    }
                }
                try {
                } catch (Throwable unused2) {
                    return null;
                }
            }
            objInvoke = method2.invoke(accessibilityNodeInfo, Integer.valueOf(i2));
            Intrinsics.checkNotNull(objInvoke, "null cannot be cast to non-null type kotlin.Long");
            l = (Long) objInvoke;
        } catch (Throwable unused3) {
        }
        return l == null ? accessibilityNodeInfo.getChild(i2) : accessibilityNodeProvider.createAccessibilityNodeInfo((int) (l.longValue() >> 32));
    }
}
