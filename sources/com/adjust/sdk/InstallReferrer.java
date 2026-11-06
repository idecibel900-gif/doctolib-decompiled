package com.adjust.sdk;

import android.content.Context;
import com.adjust.sdk.scheduler.SingleThreadCachedScheduler;
import com.adjust.sdk.scheduler.ThreadExecutor;
import com.adjust.sdk.scheduler.TimerOnce;
import com.android.installreferrer.api.InstallReferrerStateListener;
import io.didomi.ssl.config.app.SyncConfiguration;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public class InstallReferrer implements InvocationHandler {
    private static final String PACKAGE_BASE_NAME = "com.android.installreferrer.";
    private static final int STATUS_DEVELOPER_ERROR = 3;
    private static final int STATUS_FEATURE_NOT_SUPPORTED = 2;
    private static final int STATUS_OK = 0;
    private static final int STATUS_SERVICE_DISCONNECTED = -1;
    private static final int STATUS_SERVICE_UNAVAILABLE = 1;
    private Context context;
    private final InstallReferrerReadListener referrerCallback;
    private Object referrerClient;
    private int retryWaitTime = SyncConfiguration.DEFAULT_TIMEOUT;
    private ILogger logger = AdjustFactory.getLogger();
    private final AtomicBoolean shouldTryToRead = new AtomicBoolean(true);
    private int retries = 0;
    private TimerOnce retryTimer = new TimerOnce(new Runnable() { // from class: com.adjust.sdk.InstallReferrer.1
        @Override // java.lang.Runnable
        public final void run() {
            InstallReferrer.this.startConnection();
        }
    }, "InstallReferrer");
    private ThreadExecutor executor = new SingleThreadCachedScheduler("InstallReferrer");

    public InstallReferrer(Context context, InstallReferrerReadListener installReferrerReadListener) {
        this.context = context;
        this.referrerCallback = installReferrerReadListener;
    }

    private void closeReferrerClient() {
        Object obj = this.referrerClient;
        if (obj == null) {
            return;
        }
        try {
            Reflection.invokeInstanceMethod(obj, "endConnection", null, new Object[0]);
            this.logger.debug("Install Referrer API connection closed", new Object[0]);
        } catch (Exception e) {
            this.logger.error("closeReferrerClient error (%s) thrown by (%s)", e.getMessage(), e.getClass().getCanonicalName());
        }
        this.referrerClient = null;
    }

    private Object createInstallReferrerClient(Context context) {
        try {
            return Reflection.invokeInstanceMethod(Reflection.invokeStaticMethod("com.android.installreferrer.api.InstallReferrerClient", "newBuilder", new Class[]{Context.class}, context), "build", null, new Object[0]);
        } catch (ClassNotFoundException e) {
            this.referrerCallback.onFail(Util.formatString("InstallReferrer not integrated in project (%s) thrown by (%s)", e.getMessage(), e.getClass().getCanonicalName()));
            return null;
        } catch (Exception e2) {
            this.referrerCallback.onFail(Util.formatString("createInstallReferrerClient error (%s) from (%s)", e2.getMessage(), e2.getClass().getCanonicalName()));
            return null;
        }
    }

    private Object createProxyInstallReferrerStateListener(Class cls) {
        try {
            return Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, this);
        } catch (IllegalArgumentException unused) {
            this.referrerCallback.onFail("InstallReferrer proxy violating parameter restrictions");
            return null;
        } catch (NullPointerException unused2) {
            this.referrerCallback.onFail("Null argument passed to InstallReferrer proxy");
            return null;
        }
    }

    private Boolean getBooleanGooglePlayInstantParam(Object obj) {
        if (obj == null) {
            return null;
        }
        try {
            Boolean bool = (Boolean) Reflection.invokeInstanceMethod(obj, "getGooglePlayInstantParam", null, new Object[0]);
            bool.getClass();
            return bool;
        } catch (Exception unused) {
            return null;
        }
    }

    private long getInstallBeginTimestampSeconds(Object obj) {
        if (obj == null) {
            return -1L;
        }
        try {
            return ((Long) Reflection.invokeInstanceMethod(obj, "getInstallBeginTimestampSeconds", null, new Object[0])).longValue();
        } catch (Exception e) {
            this.logger.error("getInstallBeginTimestampSeconds error (%s) thrown by (%s)", e.getMessage(), e.getClass().getCanonicalName());
            return -1L;
        }
    }

    private long getInstallBeginTimestampServerSeconds(Object obj) {
        if (obj == null) {
            return -1L;
        }
        try {
            return ((Long) Reflection.invokeInstanceMethod(obj, "getInstallBeginTimestampServerSeconds", null, new Object[0])).longValue();
        } catch (Exception unused) {
            return -1L;
        }
    }

    private Object getInstallReferrer() {
        Object obj = this.referrerClient;
        if (obj == null) {
            return null;
        }
        try {
            return Reflection.invokeInstanceMethod(obj, "getInstallReferrer", null, new Object[0]);
        } catch (Exception e) {
            this.logger.error("getInstallReferrer error (%s) thrown by (%s)", e.getMessage(), e.getClass().getCanonicalName());
            return null;
        }
    }

    private Class getInstallReferrerStateListenerClass() {
        return InstallReferrerStateListener.class;
    }

    private long getReferrerClickTimestampSeconds(Object obj) {
        if (obj == null) {
            return -1L;
        }
        try {
            return ((Long) Reflection.invokeInstanceMethod(obj, "getReferrerClickTimestampSeconds", null, new Object[0])).longValue();
        } catch (Exception e) {
            this.logger.error("getReferrerClickTimestampSeconds error (%s) thrown by (%s)", e.getMessage(), e.getClass().getCanonicalName());
            return -1L;
        }
    }

    private long getReferrerClickTimestampServerSeconds(Object obj) {
        if (obj == null) {
            return -1L;
        }
        try {
            return ((Long) Reflection.invokeInstanceMethod(obj, "getReferrerClickTimestampServerSeconds", null, new Object[0])).longValue();
        } catch (Exception unused) {
            return -1L;
        }
    }

    private String getStringInstallReferrer(Object obj) {
        if (obj == null) {
            return null;
        }
        try {
            return (String) Reflection.invokeInstanceMethod(obj, "getInstallReferrer", null, new Object[0]);
        } catch (Exception e) {
            this.logger.error("getStringInstallReferrer error (%s) thrown by (%s)", e.getMessage(), e.getClass().getCanonicalName());
            return null;
        }
    }

    private String getStringInstallVersion(Object obj) {
        if (obj == null) {
            return null;
        }
        try {
            return (String) Reflection.invokeInstanceMethod(obj, "getInstallVersion", null, new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object invokeI(Object obj, Method method, Object[] objArr) {
        if (method == null) {
            this.referrerCallback.onFail("InstallReferrer invoke method null");
            return null;
        }
        String name = method.getName();
        if (name == null) {
            this.referrerCallback.onFail("InstallReferrer invoke method name null");
            return null;
        }
        this.logger.debug("InstallReferrer invoke method name: %s", name);
        if (objArr == null) {
            this.logger.warn("InstallReferrer invoke args null", new Object[0]);
            objArr = new Object[0];
        }
        for (Object obj2 : objArr) {
            this.logger.debug("InstallReferrer invoke arg: %s", obj2);
        }
        if (name.equals("onInstallReferrerSetupFinished")) {
            if (objArr.length != 1) {
                this.referrerCallback.onFail(Util.formatString("InstallReferrer invoke onInstallReferrerSetupFinished args lenght not 1: %d", Integer.valueOf(objArr.length)));
                return null;
            }
            Object obj3 = objArr[0];
            if (!(obj3 instanceof Integer)) {
                this.referrerCallback.onFail("InstallReferrer invoke onInstallReferrerSetupFinished arg not int");
                return null;
            }
            onInstallReferrerSetupFinishedIntI(((Integer) obj3).intValue());
        } else if (name.equals("onInstallReferrerServiceDisconnected")) {
            this.logger.debug("Connection to install referrer service was lost. Retrying ...", new Object[0]);
            retryI("onInstallReferrerServiceDisconnected");
        } else {
            this.referrerCallback.onFail(Util.formatString("Reflection call method name not expected: %s", name));
        }
        return null;
    }

    private void onInstallReferrerSetupFinishedIntI(int i) {
        if (i != -1) {
            if (i == 0) {
                try {
                    Object installReferrer = getInstallReferrer();
                    String stringInstallReferrer = getStringInstallReferrer(installReferrer);
                    long referrerClickTimestampSeconds = getReferrerClickTimestampSeconds(installReferrer);
                    long installBeginTimestampSeconds = getInstallBeginTimestampSeconds(installReferrer);
                    this.logger.debug("installReferrer: %s, clickTime: %d, installBeginTime: %d", stringInstallReferrer, Long.valueOf(referrerClickTimestampSeconds), Long.valueOf(installBeginTimestampSeconds));
                    String stringInstallVersion = getStringInstallVersion(installReferrer);
                    long referrerClickTimestampServerSeconds = getReferrerClickTimestampServerSeconds(installReferrer);
                    long installBeginTimestampServerSeconds = getInstallBeginTimestampServerSeconds(installReferrer);
                    Boolean booleanGooglePlayInstantParam = getBooleanGooglePlayInstantParam(installReferrer);
                    this.logger.debug("installVersion: %s, clickTimeServer: %d, installBeginServer: %d, googlePlayInstant: %b", stringInstallVersion, Long.valueOf(referrerClickTimestampServerSeconds), Long.valueOf(installBeginTimestampServerSeconds), booleanGooglePlayInstantParam);
                    this.logger.debug("Install Referrer read successfully. Closing connection", new Object[0]);
                    this.referrerCallback.onInstallReferrerRead(new ReferrerDetails(stringInstallReferrer, referrerClickTimestampSeconds, installBeginTimestampSeconds, referrerClickTimestampServerSeconds, installBeginTimestampServerSeconds, stringInstallVersion, booleanGooglePlayInstantParam, null), Constants.REFERRER_API_GOOGLE);
                } catch (Exception e) {
                    this.logger.warn("Couldn't get install referrer from client (%s). Retrying...", e.getMessage());
                }
            } else if (i == 1) {
                this.logger.debug("Could not initiate connection to the Install Referrer service. Retrying...", new Object[0]);
            } else if (i == 2) {
                this.referrerCallback.onFail("Install Referrer API not supported by the installed Play Store app. Closing connection");
            } else if (i != 3) {
                this.referrerCallback.onFail(Util.formatString("Unexpected response code of install referrer response: %d. Closing connection", Integer.valueOf(i)));
            } else {
                this.logger.debug("Install Referrer API general errors caused by incorrect usage. Retrying...", new Object[0]);
            }
            this.shouldTryToRead.set(false);
            closeReferrerClient();
            return;
        }
        this.logger.debug("Play Store service is not connected now. Retrying...", new Object[0]);
        retryI("end of onInstallReferrerSetupFinishedIntI");
    }

    private void retryI(String str) {
        if (!this.shouldTryToRead.get()) {
            this.referrerCallback.onFail(Util.formatString("Should not try to read Install referrer from %s", str));
            closeReferrerClient();
            return;
        }
        if (this.retries + 1 > 2) {
            this.referrerCallback.onFail(Util.formatString("Limit number of retry of %d for install referrer surpassed from %s", 2, str));
            return;
        }
        long fireIn = this.retryTimer.getFireIn();
        if (fireIn > 0) {
            this.logger.debug("Already waiting to retry to read install referrer in %d milliseconds", Long.valueOf(fireIn));
            return;
        }
        int i = this.retries + 1;
        this.retries = i;
        this.logger.debug("Retry number %d to connect to install referrer API", Integer.valueOf(i));
        this.retryTimer.startIn(this.retryWaitTime);
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(final Object obj, final Method method, final Object[] objArr) {
        this.executor.submit(new Runnable() { // from class: com.adjust.sdk.InstallReferrer.2
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    InstallReferrer.this.invokeI(obj, method, objArr);
                } catch (Throwable th) {
                    InstallReferrer.this.referrerCallback.onFail(Util.formatString("invoke error (%s) thrown by (%s)", th.getMessage(), th.getClass().getCanonicalName()));
                }
            }
        });
        return null;
    }

    public void startConnection() {
        Class installReferrerStateListenerClass;
        Object objCreateProxyInstallReferrerStateListener;
        if (!AdjustFactory.getTryInstallReferrer()) {
            this.referrerCallback.onFail("Sdk has been configured to not try install referrer");
            return;
        }
        closeReferrerClient();
        if (!this.shouldTryToRead.get()) {
            this.referrerCallback.onFail("Should not try to read the install referrer any longer");
            return;
        }
        Context context = this.context;
        if (context == null) {
            this.referrerCallback.onFail("Requires context to read the install referrer");
            return;
        }
        Object objCreateInstallReferrerClient = createInstallReferrerClient(context);
        this.referrerClient = objCreateInstallReferrerClient;
        if (objCreateInstallReferrerClient == null || (installReferrerStateListenerClass = getInstallReferrerStateListenerClass()) == null || (objCreateProxyInstallReferrerStateListener = createProxyInstallReferrerStateListener(installReferrerStateListenerClass)) == null) {
            return;
        }
        startConnection(installReferrerStateListenerClass, objCreateProxyInstallReferrerStateListener);
    }

    private void startConnection(Class cls, Object obj) {
        try {
            Reflection.invokeInstanceMethod(this.referrerClient, "startConnection", new Class[]{cls}, obj);
        } catch (InvocationTargetException e) {
            boolean zHasRootCause = Util.hasRootCause(e);
            InstallReferrerReadListener installReferrerReadListener = this.referrerCallback;
            if (zHasRootCause) {
                installReferrerReadListener.onFail(Util.formatString("InstallReferrer encountered an InvocationTargetException %s", Util.getRootCause(e)));
            } else {
                installReferrerReadListener.onFail("InstallReferrer encountered an InvocationTargetException");
            }
        } catch (Exception e2) {
            this.referrerCallback.onFail(Util.formatString("startConnection error (%s) thrown by (%s)", e2.getMessage(), e2.getClass().getCanonicalName()));
        }
    }
}
