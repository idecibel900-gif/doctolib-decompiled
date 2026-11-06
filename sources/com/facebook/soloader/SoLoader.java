package com.facebook.soloader;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Bundle;
import android.os.StrictMode;
import android.text.TextUtils;
import com.facebook.react.fabric.mounting.mountitems.IntBufferBatchMountItem;
import com.facebook.soloader.nativeloader.NativeLoader;
import com.facebook.soloader.nativeloader.SystemDelegate;
import com.facebook.soloader.observer.ObserverHolder;
import com.facebook.soloader.recovery.DefaultRecoveryStrategyFactory;
import com.facebook.soloader.recovery.RecoveryStrategy;
import com.facebook.soloader.recovery.RecoveryStrategyFactory;
import com.revenuecat.purchases.common.Constants;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: loaded from: classes3.dex */
public class SoLoader {
    private static int sFlags;
    static SoFileLoader sSoFileLoader;
    private static final ReentrantReadWriteLock sSoSourcesLock = new ReentrantReadWriteLock();
    static Context sApplicationContext = null;
    private static volatile SoSource[] sSoSources = null;
    private static final AtomicInteger sSoSourcesVersion = new AtomicInteger(0);
    private static RecoveryStrategyFactory sRecoveryStrategyFactory = null;
    private static final Set sLoadedLibraries = Collections.newSetFromMap(new ConcurrentHashMap());
    private static final Map sLoadingLibraries = new HashMap();
    private static final Set sLoadedAndJniInvoked = Collections.newSetFromMap(new ConcurrentHashMap());
    private static final Map sInvokingJniForLibrary = new HashMap();
    private static boolean isEnabled = true;
    private static int sAppType = 0;
    private static ExternalSoMapping externalSoMapping = null;
    static final boolean SYSTRACE_LIBRARY_LOADING = true;

    private static int makeRecoveryFlags(int i) {
        return (i & 2048) != 0 ? 1 : 0;
    }

    public static void init(Context context, int i) throws IOException {
        init(context, i, null);
    }

    public static void init(Context context, int i, SoFileLoader soFileLoader) {
        if (isInitialized()) {
            LogUtil.w("SoLoader", "SoLoader already initialized");
            return;
        }
        LogUtil.w("SoLoader", "Initializing SoLoader: " + i);
        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskWrites = StrictMode.allowThreadDiskWrites();
        try {
            boolean zInitEnableConfig = initEnableConfig(context);
            isEnabled = zInitEnableConfig;
            if (zInitEnableConfig) {
                int appType = getAppType(context);
                sAppType = appType;
                if ((i & 128) == 0 && SysUtil.isSupportedDirectLoad(context, appType)) {
                    i |= 8;
                }
                initSoLoader(context, soFileLoader, i);
                initSoSources(context, i);
                LogUtil.v("SoLoader", "Init SoLoader delegate");
                NativeLoader.initIfUninitialized(new NativeLoaderToSoLoaderDelegate());
            } else {
                initDummySoSource();
                LogUtil.v("SoLoader", "Init System Loader delegate");
                NativeLoader.initIfUninitialized(new SystemDelegate());
            }
            LogUtil.w("SoLoader", "SoLoader initialized: " + i);
        } finally {
            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskWrites);
        }
    }

    public static void init(Context context, boolean z) {
        try {
            init(context, z ? 1 : 0, null);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void init(Context context, ExternalSoMapping externalSoMapping2) throws IOException {
        synchronized (SoLoader.class) {
            externalSoMapping = externalSoMapping2;
        }
        init(context, 0);
    }

    private static boolean initEnableConfig(Context context) {
        String packageName;
        if (externalSoMapping != null) {
            return true;
        }
        Bundle bundle = null;
        try {
            packageName = context.getPackageName();
            try {
                bundle = context.getPackageManager().getApplicationInfo(packageName, 128).metaData;
            } catch (Exception e) {
                e = e;
                LogUtil.w("SoLoader", "Unexpected issue with package manager (" + packageName + ")", e);
            }
        } catch (Exception e2) {
            e = e2;
            packageName = null;
        }
        return bundle == null || bundle.getBoolean("com.facebook.soloader.enabled", true);
    }

    private static void initSoSources(Context context, int i) {
        ReentrantReadWriteLock.WriteLock writeLock;
        if (sSoSources != null) {
            return;
        }
        ReentrantReadWriteLock reentrantReadWriteLock = sSoSourcesLock;
        reentrantReadWriteLock.writeLock().lock();
        try {
            if (sSoSources == null) {
                sFlags = i;
                ArrayList arrayList = new ArrayList();
                boolean z = true;
                boolean z2 = (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_PADDING) != 0;
                boolean z3 = (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_OVERFLOW_INSET) != 0;
                if (z2) {
                    addSystemLoadWrapperSoSource(context, arrayList);
                } else if (z3) {
                    addSystemLibSoSource(arrayList);
                    arrayList.add(0, new DirectSplitSoSource("base"));
                } else {
                    addSystemLibSoSource(arrayList);
                    if (context != null) {
                        if ((i & 1) != 0) {
                            addApplicationSoSource(arrayList, getApplicationSoSourceFlags());
                            LogUtil.d("SoLoader", "Adding exo package source: lib-main");
                            arrayList.add(0, new ExoSoSource(context, "lib-main"));
                        } else {
                            if (SysUtil.isSupportedDirectLoad(context, sAppType)) {
                                addDirectApkSoSource(context, arrayList);
                            }
                            addApplicationSoSource(arrayList, getApplicationSoSourceFlags());
                            if ((i & 4096) == 0) {
                                z = false;
                            }
                            addBackupSoSource(context, arrayList, z);
                        }
                    }
                }
                SoSource[] soSourceArr = (SoSource[]) arrayList.toArray(new SoSource[arrayList.size()]);
                int iMakePrepareFlags = makePrepareFlags();
                int length = soSourceArr.length;
                while (true) {
                    int i2 = length - 1;
                    if (length <= 0) {
                        break;
                    }
                    LogUtil.i("SoLoader", "Preparing SO source: " + soSourceArr[i2]);
                    boolean z4 = SYSTRACE_LIBRARY_LOADING;
                    if (z4) {
                        Api18TraceUtils.beginTraceSection("SoLoader", "_", soSourceArr[i2].getClass().getSimpleName());
                    }
                    soSourceArr[i2].prepare(iMakePrepareFlags);
                    if (z4) {
                        Api18TraceUtils.endSection();
                    }
                    length = i2;
                }
                sSoSources = soSourceArr;
                sSoSourcesVersion.getAndIncrement();
                LogUtil.i("SoLoader", "init finish: " + sSoSources.length + " SO sources prepared");
                writeLock = sSoSourcesLock.writeLock();
            } else {
                writeLock = reentrantReadWriteLock.writeLock();
            }
            writeLock.unlock();
        } catch (Throwable th) {
            sSoSourcesLock.writeLock().unlock();
            throw th;
        }
    }

    private static void initDummySoSource() {
        if (sSoSources != null) {
            return;
        }
        sSoSourcesLock.writeLock().lock();
        try {
            if (sSoSources == null) {
                sSoSources = new SoSource[0];
            }
        } finally {
            sSoSourcesLock.writeLock().unlock();
        }
    }

    private static int getApplicationSoSourceFlags() {
        int i = sAppType;
        if (i == 1) {
            return 0;
        }
        if (i == 2 || i == 3) {
            return 1;
        }
        throw new RuntimeException("Unsupported app type, we should not reach here");
    }

    private static void addDirectApkSoSource(Context context, ArrayList arrayList) {
        DirectApkSoSource directApkSoSource = new DirectApkSoSource(context);
        LogUtil.d("SoLoader", "validating/adding directApk source: " + directApkSoSource.toString());
        if (directApkSoSource.isValid()) {
            arrayList.add(0, directApkSoSource);
        }
    }

    private static void addApplicationSoSource(ArrayList arrayList, int i) {
        ApplicationSoSource applicationSoSource = new ApplicationSoSource(sApplicationContext, i);
        LogUtil.d("SoLoader", "Adding application source: " + applicationSoSource.toString());
        arrayList.add(0, applicationSoSource);
    }

    private static void addBackupSoSource(Context context, ArrayList arrayList, boolean z) {
        if ((sFlags & 8) != 0) {
            return;
        }
        arrayList.add(0, new BackupSoSource(context, "lib-main", !z));
    }

    private static void addSystemLibSoSource(ArrayList arrayList) {
        String str = SysUtil.is64Bit() ? "/system/lib64:/vendor/lib64" : "/system/lib:/vendor/lib";
        String str2 = System.getenv("LD_LIBRARY_PATH");
        if (str2 != null && !str2.equals("")) {
            str = str2 + Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR + str;
        }
        for (String str3 : new HashSet(Arrays.asList(str.split(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR)))) {
            LogUtil.d("SoLoader", "adding system library source: " + str3);
            arrayList.add(new DirectorySoSource(new File(str3), 2));
        }
    }

    private static void addSystemLoadWrapperSoSource(Context context, ArrayList arrayList) {
        SystemLoadWrapperSoSource systemLoadWrapperSoSource = new SystemLoadWrapperSoSource();
        LogUtil.d("SoLoader", "adding systemLoadWrapper source: " + systemLoadWrapperSoSource);
        arrayList.add(0, systemLoadWrapperSoSource);
    }

    private static int makePrepareFlags() {
        sSoSourcesLock.writeLock().lock();
        try {
            int i = sFlags;
            int i2 = (i & 2) != 0 ? 1 : 0;
            if ((i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER) != 0) {
                i2 |= 4;
            }
            if ((i & 128) == 0) {
                i2 |= 8;
            }
            return i2;
        } finally {
            sSoSourcesLock.writeLock().unlock();
        }
    }

    private static synchronized void initSoLoader(Context context, SoFileLoader soFileLoader, int i) {
        if (context != null) {
            try {
                Context applicationContext = context.getApplicationContext();
                if (applicationContext == null) {
                    LogUtil.w("SoLoader", "context.getApplicationContext returned null, holding reference to original context.ApplicationSoSource fallbacks to: " + context.getApplicationInfo().nativeLibraryDir);
                } else {
                    context = applicationContext;
                }
                sApplicationContext = context;
                sRecoveryStrategyFactory = new DefaultRecoveryStrategyFactory(context, makeRecoveryFlags(i));
            } catch (Throwable th) {
                throw th;
            }
        }
        if (soFileLoader != null || sSoFileLoader == null) {
            if (soFileLoader != null) {
                sSoFileLoader = soFileLoader;
            } else {
                sSoFileLoader = new InstrumentedSoFileLoader(new SoFileLoaderImpl());
            }
        }
    }

    private static int getAppType(Context context) {
        int i = sAppType;
        if (i != 0) {
            return i;
        }
        int i2 = 1;
        if (context == null) {
            LogUtil.d("SoLoader", "context is null, fallback to THIRD_PARTY_APP appType");
            return 1;
        }
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        int i3 = applicationInfo.flags;
        if ((i3 & 1) != 0) {
            i2 = (i3 & 128) != 0 ? 3 : 2;
        }
        LogUtil.d("SoLoader", "ApplicationInfo.flags is: " + applicationInfo.flags + " appType is: " + i2);
        return i2;
    }

    public static final class WrongAbiError extends UnsatisfiedLinkError {
        WrongAbiError(Throwable th, String str) {
            super("APK was built for a different platform. Supported ABIs: " + Arrays.toString(SysUtil.getSupportedAbis()) + " error: " + str);
            initCause(th);
        }
    }

    public static boolean loadLibrary(String str) {
        return isEnabled ? loadLibrary(str, 0) : NativeLoader.loadLibrary(str);
    }

    public static boolean loadLibrary(String str, int i) {
        Boolean boolLoadLibraryOnNonAndroid = loadLibraryOnNonAndroid(str);
        if (boolLoadLibraryOnNonAndroid != null) {
            return boolLoadLibraryOnNonAndroid.booleanValue();
        }
        if (!isEnabled) {
            return NativeLoader.loadLibrary(str);
        }
        if (sAppType != 2) {
        }
        return loadLibraryOnAndroid(str, i);
    }

    private static boolean loadLibraryOnAndroid(String str, int i) {
        String strMapLibName;
        ExternalSoMapping externalSoMapping2 = externalSoMapping;
        if (externalSoMapping2 != null) {
            strMapLibName = externalSoMapping2.mapLibName(str);
        } else {
            strMapLibName = MergedSoMapping.mapLibName(str);
        }
        String str2 = strMapLibName != null ? strMapLibName : str;
        ObserverHolder.onLoadLibraryStart(str, strMapLibName, i);
        try {
            boolean zLoadLibraryBySoName = loadLibraryBySoName(System.mapLibraryName(str2), str, strMapLibName, i, null);
            ObserverHolder.onLoadLibraryEnd(null, zLoadLibraryBySoName);
            return zLoadLibraryBySoName;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                ObserverHolder.onLoadLibraryEnd(th, false);
                throw th2;
            }
        }
    }

    private static Boolean loadLibraryOnNonAndroid(String str) {
        Boolean boolValueOf;
        if (sSoSources != null) {
            return null;
        }
        ReentrantReadWriteLock reentrantReadWriteLock = sSoSourcesLock;
        reentrantReadWriteLock.readLock().lock();
        try {
            if (sSoSources == null) {
                if ("http://www.android.com/".equals(System.getProperty("java.vendor.url"))) {
                    assertInitialized();
                } else {
                    synchronized (SoLoader.class) {
                        try {
                            boolean zContains = sLoadedLibraries.contains(str);
                            boolean z = !zContains;
                            if (!zContains) {
                                System.loadLibrary(str);
                            }
                            boolValueOf = Boolean.valueOf(z);
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    reentrantReadWriteLock.readLock().unlock();
                    return boolValueOf;
                }
            }
            reentrantReadWriteLock.readLock().unlock();
            return null;
        } catch (Throwable th2) {
            sSoSourcesLock.readLock().unlock();
            throw th2;
        }
    }

    static void loadDependency(String str, int i, StrictMode.ThreadPolicy threadPolicy) {
        ObserverHolder.onLoadDependencyStart(str, i);
        try {
            ObserverHolder.onLoadDependencyEnd(null, loadLibraryBySoNameImpl(str, null, null, i | 1, threadPolicy));
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                ObserverHolder.onLoadDependencyEnd(th, false);
                throw th2;
            }
        }
    }

    private static boolean loadLibraryBySoName(String str, String str2, String str3, int i, StrictMode.ThreadPolicy threadPolicy) {
        RecoveryStrategy recoveryStrategyRecover = null;
        while (true) {
            try {
                return loadLibraryBySoNameImpl(str, str2, str3, i, threadPolicy);
            } catch (UnsatisfiedLinkError e) {
                recoveryStrategyRecover = recover(str, e, recoveryStrategyRecover);
            }
        }
    }

    private static RecoveryStrategy recover(String str, UnsatisfiedLinkError unsatisfiedLinkError, RecoveryStrategy recoveryStrategy) {
        LogUtil.w("SoLoader", "Running a recovery step for " + str + " due to " + unsatisfiedLinkError.toString());
        ReentrantReadWriteLock reentrantReadWriteLock = sSoSourcesLock;
        reentrantReadWriteLock.writeLock().lock();
        try {
            if (recoveryStrategy == null) {
                try {
                    recoveryStrategy = getRecoveryStrategy();
                    if (recoveryStrategy == null) {
                        LogUtil.w("SoLoader", "No recovery strategy");
                        throw unsatisfiedLinkError;
                    }
                } catch (NoBaseApkException e) {
                    LogUtil.e("SoLoader", "Base APK not found during recovery", e);
                    throw e;
                } catch (Exception e2) {
                    LogUtil.e("SoLoader", "Got an exception during recovery, will throw the initial error instead", e2);
                    throw unsatisfiedLinkError;
                }
            }
            if (recoverLocked(unsatisfiedLinkError, recoveryStrategy)) {
                sSoSourcesVersion.getAndIncrement();
                reentrantReadWriteLock.writeLock().unlock();
                return recoveryStrategy;
            }
            reentrantReadWriteLock.writeLock().unlock();
            LogUtil.w("SoLoader", "Failed to recover");
            throw unsatisfiedLinkError;
        } catch (Throwable th) {
            sSoSourcesLock.writeLock().unlock();
            throw th;
        }
    }

    private static boolean recoverLocked(UnsatisfiedLinkError unsatisfiedLinkError, RecoveryStrategy recoveryStrategy) {
        ObserverHolder.onRecoveryStart(recoveryStrategy);
        try {
            boolean zRecover = recoveryStrategy.recover(unsatisfiedLinkError, sSoSources);
            ObserverHolder.onRecoveryEnd(null);
            return zRecover;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                ObserverHolder.onRecoveryEnd(th);
                throw th2;
            }
        }
    }

    private static synchronized RecoveryStrategy getRecoveryStrategy() {
        RecoveryStrategyFactory recoveryStrategyFactory;
        recoveryStrategyFactory = sRecoveryStrategyFactory;
        return recoveryStrategyFactory == null ? null : recoveryStrategyFactory.get();
    }

    private static boolean loadLibraryBySoNameImpl(String str, String str2, String str3, int i, StrictMode.ThreadPolicy threadPolicy) {
        boolean z;
        Object obj;
        Object obj2;
        if (!TextUtils.isEmpty(str2) && sLoadedAndJniInvoked.contains(str2)) {
            return false;
        }
        Set set = sLoadedLibraries;
        if (set.contains(str) && str3 == null) {
            return false;
        }
        synchronized (SoLoader.class) {
            try {
                if (!set.contains(str)) {
                    z = false;
                } else {
                    if (str3 == null) {
                        return false;
                    }
                    z = true;
                }
                Map map = sLoadingLibraries;
                if (map.containsKey(str)) {
                    obj = map.get(str);
                } else {
                    Object obj3 = new Object();
                    map.put(str, obj3);
                    obj = obj3;
                }
                Map map2 = sInvokingJniForLibrary;
                if (map2.containsKey(str2)) {
                    obj2 = map2.get(str2);
                } else {
                    Object obj4 = new Object();
                    map2.put(str2, obj4);
                    obj2 = obj4;
                }
                ReentrantReadWriteLock reentrantReadWriteLock = sSoSourcesLock;
                reentrantReadWriteLock.readLock().lock();
                try {
                    synchronized (obj) {
                        if (!z) {
                            if (set.contains(str)) {
                                if (str3 == null) {
                                    reentrantReadWriteLock.readLock().unlock();
                                    return false;
                                }
                                z = true;
                            }
                            if (!z) {
                                try {
                                    LogUtil.d("SoLoader", "About to load: " + str);
                                    doLoadLibraryBySoName(str, str2, i, threadPolicy);
                                    LogUtil.d("SoLoader", "Loaded: " + str);
                                    set.add(str);
                                } catch (UnsatisfiedLinkError e) {
                                    String message = e.getMessage();
                                    if (message != null && message.contains("unexpected e_machine:")) {
                                        throw new WrongAbiError(e, message.substring(message.lastIndexOf("unexpected e_machine:")));
                                    }
                                    throw e;
                                }
                            }
                        }
                        synchronized (obj2) {
                            if ((i & 16) == 0 && str3 != null) {
                                try {
                                    if (TextUtils.isEmpty(str2) || !sLoadedAndJniInvoked.contains(str2)) {
                                        boolean z2 = SYSTRACE_LIBRARY_LOADING;
                                        if (z2 && externalSoMapping == null) {
                                            Api18TraceUtils.beginTraceSection("MergedSoMapping.invokeJniOnload[", str2, "]");
                                        }
                                        try {
                                            try {
                                                LogUtil.d("SoLoader", "About to invoke JNI_OnLoad for merged library " + str2 + ", which was merged into " + str);
                                                ExternalSoMapping externalSoMapping2 = externalSoMapping;
                                                if (externalSoMapping2 != null) {
                                                    externalSoMapping2.invokeJniOnload(str2);
                                                } else {
                                                    MergedSoMapping.invokeJniOnload(str2);
                                                }
                                                sLoadedAndJniInvoked.add(str2);
                                                if (z2 && externalSoMapping == null) {
                                                    Api18TraceUtils.endSection();
                                                }
                                            } catch (UnsatisfiedLinkError e2) {
                                                throw new RuntimeException("Failed to call JNI_OnLoad from '" + str2 + "', which has been merged into '" + str + "'.  See comment for details.", e2);
                                            }
                                        } catch (Throwable th) {
                                            if (SYSTRACE_LIBRARY_LOADING && externalSoMapping == null) {
                                                Api18TraceUtils.endSection();
                                            }
                                            throw th;
                                        }
                                    }
                                } catch (Throwable th2) {
                                    throw th2;
                                }
                            }
                        }
                        reentrantReadWriteLock.readLock().unlock();
                        return !z;
                    }
                } catch (Throwable th3) {
                    sSoSourcesLock.readLock().unlock();
                    throw th3;
                }
            } catch (Throwable th4) {
                throw th4;
            }
        }
    }

    private static void doLoadLibraryBySoName(String str, String str2, int i, StrictMode.ThreadPolicy threadPolicy) {
        boolean z;
        ReentrantReadWriteLock reentrantReadWriteLock = sSoSourcesLock;
        reentrantReadWriteLock.readLock().lock();
        try {
            if (sSoSources == null) {
                LogUtil.e("SoLoader", "Could not load: " + str + " because SoLoader is not initialized");
                throw new UnsatisfiedLinkError("SoLoader not initialized, couldn't find DSO to load: " + str);
            }
            reentrantReadWriteLock.readLock().unlock();
            if (threadPolicy == null) {
                threadPolicy = StrictMode.allowThreadDiskReads();
                z = true;
            } else {
                z = false;
            }
            if (SYSTRACE_LIBRARY_LOADING) {
                if (str2 != null) {
                    Api18TraceUtils.beginTraceSection("SoLoader.loadLibrary[", str2, "]");
                }
                Api18TraceUtils.beginTraceSection("SoLoader.loadLibrary[", str, "]");
            }
            try {
                reentrantReadWriteLock.readLock().lock();
                try {
                    try {
                        for (SoSource soSource : sSoSources) {
                            if (loadLibraryFromSoSource(soSource, str, i, threadPolicy)) {
                                sSoSourcesLock.readLock().unlock();
                                if (SYSTRACE_LIBRARY_LOADING) {
                                    if (str2 != null) {
                                        Api18TraceUtils.endSection();
                                    }
                                    Api18TraceUtils.endSection();
                                }
                                if (z) {
                                    StrictMode.setThreadPolicy(threadPolicy);
                                    return;
                                }
                                return;
                            }
                        }
                        throw SoLoaderDSONotFoundError.create(str, sApplicationContext, sSoSources);
                    } catch (IOException e) {
                        SoLoaderULError soLoaderULError = new SoLoaderULError(str, e.toString());
                        soLoaderULError.initCause(e);
                        throw soLoaderULError;
                    }
                } catch (Throwable th) {
                    sSoSourcesLock.readLock().unlock();
                    throw th;
                }
            } catch (Throwable th2) {
                if (SYSTRACE_LIBRARY_LOADING) {
                    if (str2 != null) {
                        Api18TraceUtils.endSection();
                    }
                    Api18TraceUtils.endSection();
                }
                if (z) {
                    StrictMode.setThreadPolicy(threadPolicy);
                }
                throw th2;
            }
        } catch (Throwable th3) {
            sSoSourcesLock.readLock().unlock();
            throw th3;
        }
    }

    private static boolean loadLibraryFromSoSource(SoSource soSource, String str, int i, StrictMode.ThreadPolicy threadPolicy) {
        ObserverHolder.onSoSourceLoadLibraryStart(soSource);
        try {
            boolean z = soSource.loadLibrary(str, i, threadPolicy) != 0;
            ObserverHolder.onSoSourceLoadLibraryEnd(null);
            return z;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                ObserverHolder.onSoSourceLoadLibraryEnd(th);
                throw th2;
            }
        }
    }

    private static void assertInitialized() {
        if (!isInitialized()) {
            throw new IllegalStateException("SoLoader.init() not yet called");
        }
    }

    public static boolean isInitialized() {
        if (sSoSources != null) {
            return true;
        }
        sSoSourcesLock.readLock().lock();
        try {
            return sSoSources != null;
        } finally {
            sSoSourcesLock.readLock().unlock();
        }
    }
}
