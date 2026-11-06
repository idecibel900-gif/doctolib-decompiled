package io.didomi.ssl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\u0002\n\u0000\u001a \u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004*\u00020\u00002\u000e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001\u001a\f\u0010\u0005\u001a\u00020\u0006*\u00020\u0000H\u0002¨\u0006\u0007"}, d2 = {"Lio/didomi/sdk/kb;", "", "", "iabPurposeIds", "", "a", "", "android_release"}, k = 2, mv = {1, 8, 0})
public final class lb {
    public static final List<String> a(kb kbVar, List<String> list) {
        List listEmptyList;
        Intrinsics.checkNotNullParameter(kbVar, "<this>");
        a(kbVar);
        if (list != null) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : list) {
                if (kbVar.e().containsKey((String) obj)) {
                    arrayList.add(obj);
                }
            }
            listEmptyList = new ArrayList();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                String str = kbVar.e().get((String) it.next());
                if (str != null) {
                    listEmptyList.add(str);
                }
            }
        } else {
            listEmptyList = null;
        }
        if (listEmptyList == null) {
            listEmptyList = CollectionsKt.emptyList();
        }
        return CollectionsKt.toMutableList((Collection) listEmptyList);
    }

    private static final void a(kb kbVar) {
        if (kbVar.e().isEmpty() && kbVar.f().isEmpty()) {
            List<Purpose> listC = kbVar.c();
            ArrayList<Purpose> arrayList = new ArrayList();
            for (Object obj : listC) {
                String iabId = ((Purpose) obj).getIabId();
                if (iabId != null && !StringsKt.isBlank(iabId)) {
                    arrayList.add(obj);
                }
            }
            for (Purpose purpose : arrayList) {
                Map<String, String> mapE = kbVar.e();
                String iabId2 = purpose.getIabId();
                Intrinsics.checkNotNull(iabId2, "null cannot be cast to non-null type kotlin.String");
                mapE.put(iabId2, purpose.getId());
                kbVar.f().put(purpose.getId(), purpose.getIabId());
            }
        }
    }
}
