package com.facebook.soloader;

import android.os.StrictMode;
import com.amazon.a.a.o.c.a.b;
import com.facebook.soloader.observer.ObserverHolder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: loaded from: classes3.dex */
public abstract class NativeDeps {
    private static final int LIB_PREFIX_LEN = 3;
    private static final int LIB_SUFFIX_LEN = 3;
    private static byte[] sEncodedDeps = null;
    private static volatile boolean sInitialized = false;
    private static Map sPrecomputedDeps = null;
    private static List sPrecomputedLibs = null;
    private static volatile boolean sUseDepsFileAsync = false;
    private static final int LIB_PREFIX_SUFFIX_LEN = 3 + 3;
    private static final ReentrantReadWriteLock sWaitForDepsFileLock = new ReentrantReadWriteLock();
    private static final HashSet STANDARD_SYSTEM_LIBS = new HashSet() { // from class: com.facebook.soloader.NativeDeps.1
        {
            add("libEGL.so");
            add("libGLESv2.so");
            add("libGLESv3.so");
            add("libOpenSLES.so");
            add("libandroid.so");
            add("libc.so");
            add("libdl.so");
            add("libjnigraphics.so");
            add("liblog.so");
            add("libm.so");
            add("libstdc++.so");
            add("libz.so");
        }
    };

    public static void loadDependencies(String str, ElfByteChannel elfByteChannel, int i, StrictMode.ThreadPolicy threadPolicy) {
        String[] dependencies = getDependencies(str, elfByteChannel);
        LogUtil.d("SoLoader", "Loading " + str + "'s dependencies: " + Arrays.toString(dependencies));
        for (String str2 : dependencies) {
            if (!str2.startsWith("/") && !STANDARD_SYSTEM_LIBS.contains(str2)) {
                SoLoader.loadDependency(str2, i, threadPolicy);
            }
        }
    }

    public static String[] getDependencies(String str, ElfByteChannel elfByteChannel) {
        boolean z = SoLoader.SYSTRACE_LIBRARY_LOADING;
        if (z) {
            Api18TraceUtils.beginTraceSection("soloader.NativeDeps.getDependencies[", str, "]");
        }
        ObserverHolder.onGetDependenciesStart();
        try {
            try {
                try {
                    String[] strArrAwaitGetDepsFromPrecomputedDeps = awaitGetDepsFromPrecomputedDeps(str);
                    if (strArrAwaitGetDepsFromPrecomputedDeps == null) {
                        String[] strArrExtract_DT_NEEDED = MinElf.extract_DT_NEEDED(elfByteChannel);
                        ObserverHolder.onGetDependenciesEnd(null);
                        if (z) {
                            Api18TraceUtils.endSection();
                        }
                        return strArrExtract_DT_NEEDED;
                    }
                    ObserverHolder.onGetDependenciesEnd(null);
                    if (z) {
                        Api18TraceUtils.endSection();
                    }
                    return strArrAwaitGetDepsFromPrecomputedDeps;
                } catch (Error | RuntimeException e) {
                    throw e;
                }
            } catch (MinElf.ElfError e2) {
                throw SoLoaderULErrorFactory.create(str, e2);
            }
        } catch (Throwable th) {
            ObserverHolder.onGetDependenciesEnd(null);
            if (SoLoader.SYSTRACE_LIBRARY_LOADING) {
                Api18TraceUtils.endSection();
            }
            throw th;
        }
    }

    private static String[] awaitGetDepsFromPrecomputedDeps(String str) {
        if (sInitialized) {
            return tryGetDepsFromPrecomputedDeps(str);
        }
        if (!sUseDepsFileAsync) {
            return null;
        }
        sWaitForDepsFileLock.readLock().lock();
        try {
            return tryGetDepsFromPrecomputedDeps(str);
        } finally {
            sWaitForDepsFileLock.readLock().unlock();
        }
    }

    private static boolean libIsAtOffset(String str, int i) {
        int i2;
        int i3 = LIB_PREFIX_LEN;
        while (true) {
            int length = str.length();
            i2 = LIB_SUFFIX_LEN;
            if (i3 >= length - i2 || i >= sEncodedDeps.length || (str.codePointAt(i3) & 255) != sEncodedDeps[i]) {
                break;
            }
            i3++;
            i++;
        }
        return i3 == str.length() - i2;
    }

    private static int hashLib(String str) {
        int iCodePointAt = 5381;
        for (int i = LIB_PREFIX_LEN; i < str.length() - LIB_SUFFIX_LEN; i++) {
            iCodePointAt = str.codePointAt(i) + (iCodePointAt << 5) + iCodePointAt;
        }
        return iCodePointAt;
    }

    private static int getOffsetForLib(String str) {
        List list = (List) sPrecomputedDeps.get(Integer.valueOf(hashLib(str)));
        if (list == null) {
            return -1;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            int iIntValue = ((Integer) it.next()).intValue();
            if (libIsAtOffset(str, iIntValue)) {
                return iIntValue;
            }
        }
        return -1;
    }

    private static String getLibString(int i) {
        if (i >= sPrecomputedLibs.size()) {
            return null;
        }
        int iIntValue = ((Integer) sPrecomputedLibs.get(i)).intValue();
        int i2 = iIntValue;
        while (true) {
            byte[] bArr = sEncodedDeps;
            if (i2 >= bArr.length || bArr[i2] <= 32) {
                break;
            }
            i2++;
        }
        int i3 = (i2 - iIntValue) + LIB_PREFIX_SUFFIX_LEN;
        char[] cArr = new char[i3];
        cArr[0] = 'l';
        cArr[1] = 'i';
        cArr[2] = 'b';
        for (int i4 = 0; i4 < i3 - LIB_PREFIX_SUFFIX_LEN; i4++) {
            cArr[LIB_PREFIX_LEN + i4] = (char) sEncodedDeps[iIntValue + i4];
        }
        cArr[i3 - 3] = b.a;
        cArr[i3 - 2] = 's';
        cArr[i3 - 1] = 'o';
        return new String(cArr);
    }

    private static String[] getDepsForLibAtOffset(int i, int i2) {
        byte b;
        ArrayList arrayList = new ArrayList();
        int i3 = (i + i2) - LIB_PREFIX_SUFFIX_LEN;
        int i4 = 0;
        boolean z = false;
        while (true) {
            byte[] bArr = sEncodedDeps;
            if (i3 >= bArr.length || (b = bArr[i3]) == 10) {
                break;
            }
            if (b == 32) {
                if (z) {
                    String libString = getLibString(i4);
                    if (libString == null) {
                        return null;
                    }
                    arrayList.add(libString);
                    i4 = 0;
                    z = false;
                } else {
                    continue;
                }
            } else {
                if (b < 48 || b > 57) {
                    return null;
                }
                i4 = (i4 * 10) + (b - 48);
                z = true;
            }
            i3++;
        }
        if (z) {
            String libString2 = getLibString(i4);
            if (libString2 == null) {
                return null;
            }
            arrayList.add(libString2);
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    static String[] tryGetDepsFromPrecomputedDeps(String str) {
        int offsetForLib;
        if (sInitialized && str.length() > LIB_PREFIX_SUFFIX_LEN && (offsetForLib = getOffsetForLib(str)) != -1) {
            return getDepsForLibAtOffset(offsetForLib, str.length());
        }
        return null;
    }
}
