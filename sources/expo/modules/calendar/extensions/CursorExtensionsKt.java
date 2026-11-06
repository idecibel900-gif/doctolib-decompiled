package expo.modules.calendar.extensions;

import android.database.Cursor;
import com.amazon.a.a.o.b.f;
import expo.modules.calendar.CalendarModule;
import expo.modules.calendar.exceptions.ColumnMissingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
public abstract class CursorExtensionsKt {
    public static final String getOptionalString(Cursor cursor, String columnName) {
        Intrinsics.checkNotNullParameter(cursor, "<this>");
        Intrinsics.checkNotNullParameter(columnName, "columnName");
        Integer numValueOf = Integer.valueOf(cursor.getColumnIndex(columnName));
        if (numValueOf.intValue() < 0) {
            numValueOf = null;
        }
        if (numValueOf != null) {
            return cursor.getString(numValueOf.intValue());
        }
        return null;
    }

    public static final String getRequiredString(Cursor cursor, String columnName) throws ColumnMissingException {
        Intrinsics.checkNotNullParameter(cursor, "<this>");
        Intrinsics.checkNotNullParameter(columnName, "columnName");
        String optionalString = getOptionalString(cursor, columnName);
        if (optionalString != null) {
            return optionalString;
        }
        throw new ColumnMissingException("String value not found for column `" + columnName + "`", null, 2, null);
    }

    public static /* synthetic */ int getIntOrDefault$default(Cursor cursor, String str, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return getIntOrDefault(cursor, str, i);
    }

    public static final int getIntOrDefault(Cursor cursor, String columnName, int i) {
        Intrinsics.checkNotNullParameter(cursor, "<this>");
        Intrinsics.checkNotNullParameter(columnName, "columnName");
        Integer numValueOf = Integer.valueOf(cursor.getColumnIndex(columnName));
        if (numValueOf.intValue() < 0) {
            numValueOf = null;
        }
        return numValueOf != null ? cursor.getInt(numValueOf.intValue()) : i;
    }

    public static final List getValueList(Cursor cursor, String columnName, Function1 mapper) {
        Object objInvoke;
        Intrinsics.checkNotNullParameter(cursor, "<this>");
        Intrinsics.checkNotNullParameter(columnName, "columnName");
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        List listSplit$default = StringsKt.split$default((CharSequence) getRequiredString(cursor, columnName), new String[]{f.a}, false, 0, 6, (Object) null);
        ArrayList arrayList = new ArrayList();
        Iterator it = listSplit$default.iterator();
        while (it.hasNext()) {
            try {
                objInvoke = mapper.invoke(Integer.valueOf(Integer.parseInt((String) it.next())));
            } catch (NumberFormatException unused) {
                CalendarModule.INSTANCE.getTAG$expo_calendar_release();
                objInvoke = null;
            }
            if (objInvoke != null) {
                arrayList.add(objInvoke);
            }
        }
        return CollectionsKt.toList(arrayList);
    }
}
