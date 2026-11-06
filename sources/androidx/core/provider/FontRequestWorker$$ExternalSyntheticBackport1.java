package androidx.core.provider;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class FontRequestWorker$$ExternalSyntheticBackport1 {
    public static /* synthetic */ List m(Object[] objArr) {
        ArrayList arrayList = new ArrayList(objArr.length);
        for (Object obj : objArr) {
            Objects.requireNonNull(obj);
            arrayList.add(obj);
        }
        return Collections.unmodifiableList(arrayList);
    }
}
