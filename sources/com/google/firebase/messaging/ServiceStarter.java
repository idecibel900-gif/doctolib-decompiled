package com.google.firebase.messaging;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import java.util.ArrayDeque;
import java.util.Queue;

/* JADX INFO: loaded from: classes4.dex */
public class ServiceStarter {
    static final String ACTION_MESSAGING_EVENT = "com.google.firebase.MESSAGING_EVENT";
    static final int ERROR_ILLEGAL_STATE_EXCEPTION = 402;
    static final int ERROR_ILLEGAL_STATE_EXCEPTION_FALLBACK_TO_BIND = 403;
    static final int ERROR_NOT_FOUND = 404;
    static final int ERROR_SECURITY_EXCEPTION = 401;
    public static final int ERROR_UNKNOWN = 500;
    private static final String EXTRA_WRAPPED_INTENT = "wrapped_intent";
    private static final String PERMISSIONS_MISSING_HINT = "this should normally be included by the manifest merger, but may needed to be manually added to your manifest";
    public static final int SUCCESS = -1;
    private static ServiceStarter instance;
    private String firebaseMessagingServiceClassName = null;
    private Boolean hasWakeLockPermission = null;
    private Boolean hasAccessNetworkStatePermission = null;
    private final Queue<Intent> messagingEvents = new ArrayDeque();

    static synchronized ServiceStarter getInstance() {
        try {
            if (instance == null) {
                instance = new ServiceStarter();
            }
        } catch (Throwable th) {
            throw th;
        }
        return instance;
    }

    private ServiceStarter() {
    }

    Intent getMessagingEvent() {
        return this.messagingEvents.poll();
    }

    public int startMessagingService(Context context, Intent intent) {
        this.messagingEvents.offer(intent);
        Intent intent2 = new Intent(ACTION_MESSAGING_EVENT);
        intent2.setPackage(context.getPackageName());
        return doStartService(context, intent2);
    }

    private int doStartService(Context context, Intent intent) {
        ComponentName componentNameStartService;
        String strResolveServiceClassName = resolveServiceClassName(context, intent);
        if (strResolveServiceClassName != null) {
            intent.setClassName(context.getPackageName(), strResolveServiceClassName);
        }
        try {
            if (hasWakeLockPermission(context)) {
                componentNameStartService = WakeLockHolder.startWakefulService(context, intent);
            } else {
                componentNameStartService = context.startService(intent);
            }
            return componentNameStartService == null ? 404 : -1;
        } catch (IllegalStateException e) {
            e.toString();
            return ERROR_ILLEGAL_STATE_EXCEPTION;
        } catch (SecurityException unused) {
            return 401;
        }
    }

    private synchronized String resolveServiceClassName(Context context, Intent intent) {
        ServiceInfo serviceInfo;
        String str;
        try {
            String str2 = this.firebaseMessagingServiceClassName;
            if (str2 != null) {
                return str2;
            }
            ResolveInfo resolveInfoResolveService = context.getPackageManager().resolveService(intent, 0);
            if (resolveInfoResolveService != null && (serviceInfo = resolveInfoResolveService.serviceInfo) != null) {
                if (context.getPackageName().equals(serviceInfo.packageName) && (str = serviceInfo.name) != null) {
                    if (str.startsWith(".")) {
                        this.firebaseMessagingServiceClassName = context.getPackageName() + serviceInfo.name;
                    } else {
                        this.firebaseMessagingServiceClassName = serviceInfo.name;
                    }
                    return this.firebaseMessagingServiceClassName;
                }
                return null;
            }
            return null;
        } catch (Throwable th) {
            throw th;
        }
    }

    boolean hasWakeLockPermission(Context context) {
        if (this.hasWakeLockPermission == null) {
            this.hasWakeLockPermission = Boolean.valueOf(context.checkCallingOrSelfPermission("android.permission.WAKE_LOCK") == 0);
        }
        this.hasWakeLockPermission.booleanValue();
        return this.hasWakeLockPermission.booleanValue();
    }

    boolean hasAccessNetworkStatePermission(Context context) {
        if (this.hasAccessNetworkStatePermission == null) {
            this.hasAccessNetworkStatePermission = Boolean.valueOf(context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0);
        }
        this.hasWakeLockPermission.booleanValue();
        return this.hasAccessNetworkStatePermission.booleanValue();
    }

    public static void setForTesting(ServiceStarter serviceStarter) {
        instance = serviceStarter;
    }
}
