package io.sentry.react;

import com.facebook.react.bridge.ReadableMap;
import com.google.firebase.messaging.Constants;
import com.revenuecat.purchases.react.RNPurchasesModule;
import io.sentry.Breadcrumb;
import io.sentry.SentryLevel;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public abstract class RNSentryBreadcrumb {
    public static String getCurrentScreenFrom(ReadableMap readableMap) {
        String string = readableMap.hasKey("category") ? readableMap.getString("category") : null;
        if (string != null && "navigation".equals(string)) {
            ReadableMap map = readableMap.hasKey(Constants.ScionAnalytics.MessageType.DATA_MESSAGE) ? readableMap.getMap(Constants.ScionAnalytics.MessageType.DATA_MESSAGE) : null;
            if (map == null) {
                return null;
            }
            try {
                if (map.hasKey("to")) {
                    return map.getString("to");
                }
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:33:0x0099  */
    public static Breadcrumb fromMap(ReadableMap readableMap) {
        Breadcrumb breadcrumb = new Breadcrumb();
        if (readableMap.hasKey("message")) {
            breadcrumb.setMessage(readableMap.getString("message"));
        }
        if (readableMap.hasKey("type")) {
            breadcrumb.setType(readableMap.getString("type"));
        }
        if (readableMap.hasKey("category")) {
            breadcrumb.setCategory(readableMap.getString("category"));
        }
        if (readableMap.hasKey("origin")) {
            breadcrumb.setOrigin(readableMap.getString("origin"));
        } else {
            breadcrumb.setOrigin(RNPurchasesModule.PLATFORM_NAME);
        }
        if (readableMap.hasKey("level")) {
            String string = readableMap.getString("level");
            switch (string.hashCode()) {
                case 3237038:
                    string.equals("info");
                    breadcrumb.setLevel(SentryLevel.INFO);
                    break;
                case 95458899:
                    if (string.equals("debug")) {
                        breadcrumb.setLevel(SentryLevel.DEBUG);
                    } else {
                        breadcrumb.setLevel(SentryLevel.INFO);
                    }
                    break;
                case 96784904:
                    if (string.equals("error")) {
                        breadcrumb.setLevel(SentryLevel.ERROR);
                    } else {
                        breadcrumb.setLevel(SentryLevel.INFO);
                    }
                    break;
                case 97203460:
                    if (string.equals("fatal")) {
                        breadcrumb.setLevel(SentryLevel.FATAL);
                    } else {
                        breadcrumb.setLevel(SentryLevel.INFO);
                    }
                    break;
                case 1124446108:
                    if (string.equals("warning")) {
                        breadcrumb.setLevel(SentryLevel.WARNING);
                    } else {
                        breadcrumb.setLevel(SentryLevel.INFO);
                    }
                    break;
                default:
                    breadcrumb.setLevel(SentryLevel.INFO);
                    break;
            }
        }
        if (readableMap.hasKey(Constants.ScionAnalytics.MessageType.DATA_MESSAGE)) {
            for (Map.Entry<String, Object> entry : readableMap.getMap(Constants.ScionAnalytics.MessageType.DATA_MESSAGE).toHashMap().entrySet()) {
                if (entry.getValue() != null) {
                    breadcrumb.setData(entry.getKey(), entry.getValue());
                }
            }
        }
        return breadcrumb;
    }
}
