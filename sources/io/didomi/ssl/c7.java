package io.didomi.ssl;

import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\u0012\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¨\u0006\u0005"}, d2 = {"Lio/didomi/sdk/b7;", "Lio/didomi/sdk/jh;", "userChoicesInfoProvider", "", "a", "android_release"}, k = 2, mv = {1, 8, 0})
public final class c7 {
    public static final void a(InitialPurposesHolder initialPurposesHolder, jh userChoicesInfoProvider) {
        Intrinsics.checkNotNullParameter(initialPurposesHolder, "<this>");
        Intrinsics.checkNotNullParameter(userChoicesInfoProvider, "userChoicesInfoProvider");
        userChoicesInfoProvider.i(CollectionsKt.toMutableSet(initialPurposesHolder.d()));
        userChoicesInfoProvider.e(CollectionsKt.toMutableSet(initialPurposesHolder.b()));
        userChoicesInfoProvider.k(CollectionsKt.toMutableSet(initialPurposesHolder.c()));
        userChoicesInfoProvider.g(CollectionsKt.toMutableSet(initialPurposesHolder.a()));
    }
}
