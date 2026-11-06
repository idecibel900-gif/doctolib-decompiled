package expo.modules.calendar.extensions;

import expo.modules.calendar.CalendarUtils;
import expo.modules.calendar.exceptions.DateParseException;
import expo.modules.kotlin.types.Either;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes4.dex */
public abstract class EitherExtensionsKt {
    public static final Long getTimeInMillis(Either either) throws DateParseException {
        Intrinsics.checkNotNullParameter(either, "<this>");
        if (either.isSecondType(Reflection.getOrCreateKotlinClass(Long.TYPE))) {
            return (Long) either.second();
        }
        try {
            Date date = CalendarUtils.INSTANCE.getSdf().parse((String) either.first());
            if (date == null) {
                throw new DateParseException("Parsed date for string '" + either.first() + "' is null", null, 2, null);
            }
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            return Long.valueOf(calendar.getTimeInMillis());
        } catch (ParseException e) {
            throw new DateParseException("Date '" + either.first() + "' could not be parsed", e);
        }
    }
}
