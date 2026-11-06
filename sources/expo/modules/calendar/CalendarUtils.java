package expo.modules.calendar;

import j$.util.DesugarTimeZone;
import java.text.SimpleDateFormat;

/* JADX INFO: loaded from: classes4.dex */
public final class CalendarUtils {
    public static final CalendarUtils INSTANCE = new CalendarUtils();
    private static final SimpleDateFormat allDayRecurrenceSDF;
    private static final SimpleDateFormat recurrenceRuleSDF;
    private static final SimpleDateFormat sdf;

    private CalendarUtils() {
    }

    static {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        simpleDateFormat.setTimeZone(DesugarTimeZone.getTimeZone("GMT"));
        sdf = simpleDateFormat;
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyyMMdd'T'HHmmss'Z'");
        simpleDateFormat2.setTimeZone(DesugarTimeZone.getTimeZone("GMT"));
        recurrenceRuleSDF = simpleDateFormat2;
        SimpleDateFormat simpleDateFormat3 = new SimpleDateFormat("yyyyMMdd");
        simpleDateFormat3.setTimeZone(DesugarTimeZone.getTimeZone("GMT"));
        allDayRecurrenceSDF = simpleDateFormat3;
    }

    public final SimpleDateFormat getSdf() {
        return sdf;
    }

    public final SimpleDateFormat getRecurrenceRuleSDF() {
        return recurrenceRuleSDF;
    }

    public final SimpleDateFormat getAllDayRecurrenceSDF() {
        return allDayRecurrenceSDF;
    }
}
