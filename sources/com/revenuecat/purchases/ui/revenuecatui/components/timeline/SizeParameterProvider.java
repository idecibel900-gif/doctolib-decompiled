package com.revenuecat.purchases.ui.revenuecatui.components.timeline;

import androidx.compose.ui.tooling.preview.PreviewParameterProvider;
import com.revenuecat.purchases.paywalls.components.properties.Size;
import com.revenuecat.purchases.paywalls.components.properties.SizeConstraint;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.sequences.Sequence;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/timeline/SizeParameterProvider;", "Landroidx/compose/ui/tooling/preview/PreviewParameterProvider;", "Lcom/revenuecat/purchases/paywalls/components/properties/Size;", "()V", "allSizeConstraints", "", "Lcom/revenuecat/purchases/paywalls/components/properties/SizeConstraint;", "values", "Lkotlin/sequences/Sequence;", "getValues", "()Lkotlin/sequences/Sequence;", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class SizeParameterProvider implements PreviewParameterProvider {
    private final List<SizeConstraint> allSizeConstraints;
    private final Sequence values;

    @Override // androidx.compose.ui.tooling.preview.PreviewParameterProvider
    public /* bridge */ /* synthetic */ int getCount() {
        return super.getCount();
    }

    public SizeParameterProvider() {
        List<SizeConstraint> listListOf = CollectionsKt.listOf((Object[]) new SizeConstraint[]{SizeConstraint.Fit.INSTANCE, SizeConstraint.Fill.INSTANCE, new SizeConstraint.Fixed(200, null)});
        this.allSizeConstraints = listListOf;
        ArrayList<Pair> arrayList = new ArrayList();
        for (SizeConstraint sizeConstraint : listListOf) {
            List<SizeConstraint> list = this.allSizeConstraints;
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList2.add(TuplesKt.to(sizeConstraint, (SizeConstraint) it.next()));
            }
            CollectionsKt.addAll(arrayList, arrayList2);
        }
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
        for (Pair pair : arrayList) {
            arrayList3.add(new Size((SizeConstraint) pair.getFirst(), (SizeConstraint) pair.getSecond()));
        }
        this.values = CollectionsKt.asSequence(arrayList3);
    }

    @Override // androidx.compose.ui.tooling.preview.PreviewParameterProvider
    public Sequence getValues() {
        return this.values;
    }
}
