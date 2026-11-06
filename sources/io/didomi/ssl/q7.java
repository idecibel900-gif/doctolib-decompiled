package io.didomi.ssl;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u001a$\u0010\u0006\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003¨\u0006\u0007"}, d2 = {"T", "", "", "Ljava/lang/Class;", "clazz", "", "a", "android_release"}, k = 2, mv = {1, 8, 0})
public final class q7 {
    public static final <T> int a(List<? extends Object> list, Class<T> clazz) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        return CollectionsKt.filterIsInstance(list, clazz).size();
    }
}
