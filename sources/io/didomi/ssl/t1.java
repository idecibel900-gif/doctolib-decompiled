package io.didomi.ssl;

import io.didomi.ssl.config.app.SyncConfiguration;
import j$.util.DesugarTimeZone;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b%\u0010#J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J \u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H\u0002JD\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000e\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u0006H\u0002J\u0006\u0010\u0007\u001a\u00020\u0010J\u0006\u0010\u0011\u001a\u00020\u0004J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u0010J\u0006\u0010\u0015\u001a\u00020\u0014J\u0010\u0010\u0015\u001a\u00020\u00162\b\u0010\u0012\u001a\u0004\u0018\u00010\u0010J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u0006J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0004J\u000e\u0010\u0007\u001a\u00020\u00182\u0006\u0010\u0012\u001a\u00020\u0010J\u000e\u0010\u0011\u001a\u00020\u00182\u0006\u0010\u0012\u001a\u00020\u0010J,\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u00042\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u001b\u001a\u00020\u0016J\u0016\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R*\u0010$\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\b\u0011\u0010\u001d\u0012\u0004\b\"\u0010#\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u0006&"}, d2 = {"Lio/didomi/sdk/t1;", "", "Lio/didomi/sdk/n7;", "languagesHelper", "", "durationInSeconds", "", "a", "unit1Label", "unit2Label", "biggerUnitCount", "biggerUnitKey", "smallerUnit1Count", "smallerUnit1Key", "smallerUnit2Count", "smallerUnit2Key", "Ljava/util/Date;", "b", "date", "d", "Ljava/text/SimpleDateFormat;", "c", "", "timeInMs", "", "unitCount", "unitKey", "formatBigNumber", "Ljava/util/Calendar;", "Ljava/util/Calendar;", "getCalendar", "()Ljava/util/Calendar;", "setCalendar", "(Ljava/util/Calendar;)V", "getCalendar$annotations", "()V", "calendar", "<init>", "android_release"}, k = 1, mv = {1, 8, 0})
public final class t1 {
    public static final t1 a = new t1();

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private static Calendar calendar;

    private t1() {
    }

    public final Date a() {
        Calendar calendar2 = calendar;
        if (calendar2 == null) {
            calendar2 = Calendar.getInstance();
        }
        Date time = calendar2.getTime();
        Intrinsics.checkNotNullExpressionValue(time, "calendar ?: Calendar.getInstance()).time");
        return time;
    }

    public final long b() {
        Calendar calendar2 = calendar;
        if (calendar2 == null) {
            calendar2 = Calendar.getInstance();
        }
        return calendar2.getTimeInMillis();
    }

    public final SimpleDateFormat c() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.ENGLISH);
        simpleDateFormat.setTimeZone(DesugarTimeZone.getTimeZone("UTC"));
        return simpleDateFormat;
    }

    public final String d(Date date) {
        if (date == null) {
            return null;
        }
        return c().format(date);
    }

    public final Date a(String date) {
        if (date == null) {
            return null;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.ENGLISH);
        simpleDateFormat.setTimeZone(DesugarTimeZone.getTimeZone("UTC"));
        try {
            return simpleDateFormat.parse(date);
        } catch (ParseException unused) {
            return null;
        }
    }

    public final int b(Date date) {
        Intrinsics.checkNotNullParameter(date, "date");
        return (int) ((b() - date.getTime()) / ((long) 1000));
    }

    public final String b(n7 languagesHelper, long durationInSeconds) {
        Intrinsics.checkNotNullParameter(languagesHelper, "languagesHelper");
        String strA = a(this, languagesHelper, durationInSeconds, (String) null, false, 12, (Object) null);
        if (durationInSeconds < 60) {
            return strA;
        }
        return strA + " (" + a(languagesHelper, durationInSeconds, "second", true) + ')';
    }

    public final boolean c(Date date) {
        return date != null && date.getTime() < b();
    }

    public final String a(long timeInMs) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss", Locale.ENGLISH);
        simpleDateFormat.setTimeZone(DesugarTimeZone.getTimeZone("GMT"));
        return simpleDateFormat.format(Long.valueOf(timeInMs)) + " GMT";
    }

    public final int a(Date date) {
        Intrinsics.checkNotNullParameter(date, "date");
        return (int) ((b() - date.getTime()) / 86400000);
    }

    public static /* synthetic */ String a(t1 t1Var, n7 n7Var, long j, String str, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            str = null;
        }
        String str2 = str;
        if ((i & 8) != 0) {
            z = false;
        }
        return t1Var.a(n7Var, j, str2, z);
    }

    public final String a(n7 languagesHelper, long unitCount, String unitKey, boolean formatBigNumber) {
        String strValueOf;
        Intrinsics.checkNotNullParameter(languagesHelper, "languagesHelper");
        if (unitKey == null) {
            return a(languagesHelper, unitCount);
        }
        if (unitCount == 1) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String str = String.format("%s_singular", Arrays.copyOf(new Object[]{unitKey}, 1));
            Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
            return n7.a(languagesHelper, str, null, null, null, 14, null);
        }
        if (formatBigNumber) {
            strValueOf = NumberFormat.getNumberInstance(new Locale(languagesHelper.e())).format(unitCount);
        } else {
            strValueOf = String.valueOf(unitCount);
        }
        StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
        String str2 = String.format("%s_plural", Arrays.copyOf(new Object[]{unitKey}, 1));
        Intrinsics.checkNotNullExpressionValue(str2, "format(format, *args)");
        return n7.a(languagesHelper, str2, gc.NONE, MapsKt.mapOf(TuplesKt.to("{nb}", strValueOf)), null, 8, null);
    }

    private final String a(n7 languagesHelper, long durationInSeconds) {
        long j = 31536000;
        int i = (int) (durationInSeconds / j);
        int i2 = (int) (durationInSeconds % j);
        if (i2 == 0 && i > 0) {
            return a(languagesHelper, i, "year", 0L, (String) null, 0L, (String) null);
        }
        if (i2 > 31104000) {
            return a(languagesHelper, i + 1, "year", 0L, (String) null, 0L, (String) null);
        }
        long j2 = ((long) (i2 % 31536000)) / 2592000;
        if (j2 == 12) {
            i++;
            j2 = 0;
        }
        long j3 = (((long) i2) % 2592000) / ((long) SyncConfiguration.DEFAULT_FREQUENCY);
        if (i > 0) {
            return a(languagesHelper, i, "year", j2, "month", j3, "day");
        }
        long j4 = j2;
        long j5 = (i2 % SyncConfiguration.DEFAULT_FREQUENCY) / 3600;
        if (j4 > 0) {
            return a(languagesHelper, j4, "month", j3, "day", j5, "hour");
        }
        int i3 = (i2 % 3600) / 60;
        if (j3 > 0) {
            return a(languagesHelper, j3, "day", j5, "hour", i3, "minute");
        }
        int i4 = i2 % 60;
        if (j5 > 0) {
            return a(languagesHelper, j5, "hour", i3, "minute", i4, "second");
        }
        if (i3 > 0) {
            return a(languagesHelper, i3, "minute", i4, "second", 0L, (String) null);
        }
        return a(this, languagesHelper, i4, "second", false, 8, (Object) null);
    }

    private final String a(n7 languagesHelper, String unit1Label, String unit2Label) {
        return n7.a(languagesHelper, "composed_duration", gc.NONE, MapsKt.mapOf(TuplesKt.to("{unit1}", unit1Label), TuplesKt.to("{unit2}", unit2Label)), null, 8, null);
    }

    private final String a(n7 languagesHelper, long biggerUnitCount, String biggerUnitKey, long smallerUnit1Count, String smallerUnit1Key, long smallerUnit2Count, String smallerUnit2Key) {
        String strA = a(this, languagesHelper, biggerUnitCount, biggerUnitKey, false, 8, (Object) null);
        if (smallerUnit1Count > 0) {
            return a(languagesHelper, strA, a(this, languagesHelper, smallerUnit1Count, smallerUnit1Key, false, 8, (Object) null));
        }
        return smallerUnit2Count > 0 ? a(languagesHelper, strA, a(this, languagesHelper, smallerUnit2Count, smallerUnit2Key, false, 8, (Object) null)) : strA;
    }
}
