package io.sentry.util;

import io.sentry.FilterString;
import io.sentry.SentryEvent;
import io.sentry.protocol.Message;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public abstract class ErrorUtils {
    public static boolean isIgnored(List list, SentryEvent sentryEvent) {
        if (sentryEvent != null && list != null && !list.isEmpty()) {
            HashSet hashSet = new HashSet();
            Message message = sentryEvent.getMessage();
            if (message != null) {
                String message2 = message.getMessage();
                if (message2 != null) {
                    hashSet.add(message2);
                }
                String formatted = message.getFormatted();
                if (formatted != null) {
                    hashSet.add(formatted);
                }
            }
            Throwable throwable = sentryEvent.getThrowable();
            if (throwable != null) {
                hashSet.add(throwable.toString());
            }
            Iterator it = list.iterator();
            while (it.hasNext()) {
                if (hashSet.contains(((FilterString) it.next()).getFilterString())) {
                    return true;
                }
            }
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                FilterString filterString = (FilterString) it2.next();
                Iterator it3 = hashSet.iterator();
                while (it3.hasNext()) {
                    if (filterString.matches((String) it3.next())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
