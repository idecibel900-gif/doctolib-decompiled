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
import net.openid.appauth.AuthorizationRequest;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0081\u0002\u0018\u0000 \u00102\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u0010B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0006\u0010\u000e\u001a\u00020\u000fR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u0011"}, d2 = {"Lexpo/modules/calendar/next/records/AlarmMethod;", "Lexpo/modules/kotlin/types/Enumerable;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "ALARM", "ALERT", "EMAIL", "SMS", "DEFAULT", "toAndroidValue", "", "Companion", "expo-calendar_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public enum AlarmMethod implements Enumerable {
    ALARM("alarm"),
    ALERT("alert"),
    EMAIL(AuthorizationRequest.Scope.EMAIL),
    SMS("sms"),
    DEFAULT("default");

    private final String value;
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[AlarmMethod.values().length];
            try {
                iArr[AlarmMethod.ALERT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AlarmMethod.ALARM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[AlarmMethod.EMAIL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[AlarmMethod.SMS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static EnumEntries getEntries() {
        return $ENTRIES;
    }

    AlarmMethod(String str) {
        this.value = str;
    }

    public final String getValue() {
        return this.value;
    }

    public final int toAndroidValue() {
        int i = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        int i2 = 1;
        if (i != 1) {
            i2 = 4;
            if (i != 2) {
                if (i != 3) {
                    return i != 4 ? 0 : 3;
                }
                return 2;
            }
        }
        return i2;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final AlarmMethod fromAndroidValue(int i) {
            if (i == 0) {
                return AlarmMethod.DEFAULT;
            }
            if (i == 1) {
                return AlarmMethod.ALERT;
            }
            if (i == 2) {
                return AlarmMethod.EMAIL;
            }
            if (i == 3) {
                return AlarmMethod.SMS;
            }
            if (i == 4) {
                return AlarmMethod.ALARM;
            }
            return AlarmMethod.DEFAULT;
        }

        public final List fromReminderString(String str) {
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
                Iterator<E> it = AlarmMethod.getEntries().iterator();
                do {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                } while (!Intrinsics.areEqual(((AlarmMethod) next).getValue(), str2));
                AlarmMethod alarmMethod = (AlarmMethod) next;
                if (alarmMethod == null) {
                    alarmMethod = AlarmMethod.DEFAULT;
                }
                arrayList2.add(alarmMethod);
            }
            return arrayList2;
        }
    }
}
