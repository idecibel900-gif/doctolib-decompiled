package expo.modules.calendar.domain.event;

import com.amazon.a.a.o.b.f;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public abstract class EventRepositoryKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Pair buildSelectionForEventsQuery(long j, long j2, List list) {
        List listMutableListOf = CollectionsKt.mutableListOf("begin >= ?", "end <= ?", "visible = ?");
        List listMutableListOf2 = CollectionsKt.mutableListOf(String.valueOf(j), String.valueOf(j2), "1");
        if (!list.isEmpty()) {
            int size = list.size();
            String[] strArr = new String[size];
            for (int i = 0; i < size; i++) {
                strArr[i] = "?";
            }
            listMutableListOf.add("calendar_id IN (" + ArraysKt.joinToString$default(strArr, f.a, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null) + ")");
            CollectionsKt.addAll(listMutableListOf2, list);
        }
        return TuplesKt.to("(" + CollectionsKt.joinToString$default(listMutableListOf, " AND ", null, null, 0, null, new Function1() { // from class: expo.modules.calendar.domain.event.EventRepositoryKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return EventRepositoryKt.buildSelectionForEventsQuery$lambda$0((String) obj);
            }
        }, 30, null) + ")", listMutableListOf2.toArray(new String[0]));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence buildSelectionForEventsQuery$lambda$0(String condition) {
        Intrinsics.checkNotNullParameter(condition, "condition");
        return "(" + condition + ")";
    }
}
