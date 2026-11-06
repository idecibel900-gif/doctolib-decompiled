package expo.modules.calendar.next;

import android.content.ContentValues;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class CalendarBuilderNext {
    private final ContentValues eventValues = new ContentValues();

    public final long getAsLong(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        Long asLong = this.eventValues.getAsLong(key);
        Intrinsics.checkNotNullExpressionValue(asLong, "getAsLong(...)");
        return asLong.longValue();
    }

    public final CalendarBuilderNext put(String key, String str) {
        Intrinsics.checkNotNullParameter(key, "key");
        if (str != null) {
            this.eventValues.put(key, str);
        }
        return this;
    }

    public final CalendarBuilderNext put(String key, Integer num) {
        Intrinsics.checkNotNullParameter(key, "key");
        if (num != null) {
            this.eventValues.put(key, Integer.valueOf(num.intValue()));
        }
        return this;
    }

    public final CalendarBuilderNext put(String key, Long l) {
        Intrinsics.checkNotNullParameter(key, "key");
        if (l != null) {
            this.eventValues.put(key, Long.valueOf(l.longValue()));
        }
        return this;
    }

    public final CalendarBuilderNext put(String key, Boolean bool) {
        Intrinsics.checkNotNullParameter(key, "key");
        if (bool != null) {
            this.eventValues.put(key, bool);
        }
        return this;
    }

    public final CalendarBuilderNext putNull(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.eventValues.putNull(key);
        return this;
    }

    public final ContentValues build() {
        return this.eventValues;
    }
}
