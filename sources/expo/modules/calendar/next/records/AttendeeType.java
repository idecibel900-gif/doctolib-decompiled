package expo.modules.calendar.next.records;

import com.amazon.a.a.o.b.f;
import expo.modules.kotlin.types.Enumerable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \r2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\rB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lexpo/modules/calendar/next/records/AttendeeType;", "Lexpo/modules/kotlin/types/Enumerable;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "RESOURCE", "OPTIONAL", "REQUIRED", "NONE", "Companion", "expo-calendar_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public enum AttendeeType implements Enumerable {
    RESOURCE("resource"),
    OPTIONAL("optional"),
    REQUIRED("required"),
    NONE("none");

    private final String value;
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    public static EnumEntries getEntries() {
        return $ENTRIES;
    }

    AttendeeType(String str) {
        this.value = str;
    }

    public final String getValue() {
        return this.value;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final AttendeeType fromAndroidValue(int i) {
            Object next;
            Iterator<E> it = AttendeeType.getEntries().iterator();
            while (it.hasNext()) {
                next = it.next();
                if (Intrinsics.areEqual(((AttendeeType) next).getValue(), expo.modules.calendar.domain.attendee.enums.AttendeeType.INSTANCE.fromContentProviderValue(i).getValue())) {
                    return (AttendeeType) next;
                }
            }
            next = null;
            return (AttendeeType) next;
        }

        public final List fromAttendeeTypesString(String str) {
            List listSplit$default;
            Object next;
            if (str == null || (listSplit$default = StringsKt.split$default((CharSequence) str, new String[]{f.a}, false, 0, 6, (Object) null)) == null) {
                return CollectionsKt.emptyList();
            }
            ArrayList<String> arrayList = new ArrayList();
            for (Object obj : listSplit$default) {
                if (!StringsKt.isBlank((String) obj)) {
                    arrayList.add(obj);
                }
            }
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
            for (String str2 : arrayList) {
                Iterator<E> it = AttendeeType.getEntries().iterator();
                do {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                } while (!Intrinsics.areEqual(((AttendeeType) next).getValue(), str2));
                AttendeeType attendeeType = (AttendeeType) next;
                if (attendeeType == null) {
                    attendeeType = AttendeeType.NONE;
                }
                arrayList2.add(attendeeType);
            }
            return arrayList2;
        }
    }
}
