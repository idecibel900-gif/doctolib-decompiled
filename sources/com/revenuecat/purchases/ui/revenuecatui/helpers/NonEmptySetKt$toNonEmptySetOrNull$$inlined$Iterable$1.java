package com.revenuecat.purchases.ui.revenuecatui.helpers;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0010\u001c\n\u0002\u0010(\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0096\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"com/revenuecat/purchases/ui/revenuecatui/helpers/NonEmptySetKt$toNonEmptySetOrNull$$inlined$Iterable$1", "", "", "iterator", "()Ljava/util/Iterator;", "kotlin-stdlib"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class NonEmptySetKt$toNonEmptySetOrNull$$inlined$Iterable$1 implements Iterable, KMappedMarker {
    final /* synthetic */ Iterator $iterator$inlined;

    public NonEmptySetKt$toNonEmptySetOrNull$$inlined$Iterable$1(Iterator it) {
        this.$iterator$inlined = it;
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        return this.$iterator$inlined;
    }
}
