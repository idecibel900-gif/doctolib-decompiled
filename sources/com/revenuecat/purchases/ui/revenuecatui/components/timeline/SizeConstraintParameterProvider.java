package com.revenuecat.purchases.ui.revenuecatui.components.timeline;

import androidx.compose.ui.tooling.preview.PreviewParameterProvider;
import com.revenuecat.purchases.paywalls.components.properties.SizeConstraint;
import kotlin.Metadata;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/timeline/SizeConstraintParameterProvider;", "Landroidx/compose/ui/tooling/preview/PreviewParameterProvider;", "Lcom/revenuecat/purchases/paywalls/components/properties/SizeConstraint;", "()V", "values", "Lkotlin/sequences/Sequence;", "getValues", "()Lkotlin/sequences/Sequence;", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class SizeConstraintParameterProvider implements PreviewParameterProvider {
    private final Sequence values = SequencesKt.sequenceOf(SizeConstraint.Fit.INSTANCE, SizeConstraint.Fill.INSTANCE, new SizeConstraint.Fixed(100, null));

    @Override // androidx.compose.ui.tooling.preview.PreviewParameterProvider
    public /* bridge */ /* synthetic */ int getCount() {
        return super.getCount();
    }

    @Override // androidx.compose.ui.tooling.preview.PreviewParameterProvider
    public Sequence getValues() {
        return this.values;
    }
}
