package com.revenuecat.purchases.ui.revenuecatui.components.image;

import androidx.compose.ui.tooling.preview.PreviewParameterProvider;
import com.revenuecat.purchases.paywalls.components.properties.FitMode;
import com.revenuecat.purchases.paywalls.components.properties.Size;
import com.revenuecat.purchases.paywalls.components.properties.SizeConstraint;
import kotlin.Metadata;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/image/PreviewParametersProvider;", "Landroidx/compose/ui/tooling/preview/PreviewParameterProvider;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/image/PreviewParameters;", "()V", "values", "Lkotlin/sequences/Sequence;", "getValues", "()Lkotlin/sequences/Sequence;", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class PreviewParametersProvider implements PreviewParameterProvider {
    private final Sequence values;

    @Override // androidx.compose.ui.tooling.preview.PreviewParameterProvider
    public /* bridge */ /* synthetic */ int getCount() {
        return super.getCount();
    }

    public PreviewParametersProvider() {
        Size size = new Size(new SizeConstraint.Fixed(200, null), new SizeConstraint.Fixed(200, null));
        FitMode fitMode = FitMode.FILL;
        PreviewParameters previewParameters = new PreviewParameters(100, 100, size, fitMode, null);
        Size size2 = new Size(new SizeConstraint.Fixed(200, null), new SizeConstraint.Fixed(200, null));
        FitMode fitMode2 = FitMode.FIT;
        PreviewParameters previewParameters2 = new PreviewParameters(100, 100, size2, fitMode2, null);
        PreviewParameters previewParameters3 = new PreviewParameters(100, 100, new Size(new SizeConstraint.Fixed(200, null), new SizeConstraint.Fixed(50, null)), fitMode, null);
        PreviewParameters previewParameters4 = new PreviewParameters(100, 100, new Size(new SizeConstraint.Fixed(200, null), new SizeConstraint.Fixed(50, null)), fitMode2, null);
        PreviewParameters previewParameters5 = new PreviewParameters(100, 100, new Size(new SizeConstraint.Fixed(50, null), new SizeConstraint.Fixed(200, null)), fitMode, null);
        PreviewParameters previewParameters6 = new PreviewParameters(100, 100, new Size(new SizeConstraint.Fixed(50, null), new SizeConstraint.Fixed(200, null)), fitMode2, null);
        SizeConstraint.Fixed fixed = new SizeConstraint.Fixed(72, null);
        SizeConstraint.Fit fit = SizeConstraint.Fit.INSTANCE;
        PreviewParameters previewParameters7 = new PreviewParameters(100, 100, new Size(fixed, fit), fitMode, null);
        PreviewParameters previewParameters8 = new PreviewParameters(100, 100, new Size(fit, new SizeConstraint.Fixed(72, null)), fitMode, null);
        SizeConstraint.Fill fill = SizeConstraint.Fill.INSTANCE;
        this.values = SequencesKt.sequenceOf(previewParameters, previewParameters2, previewParameters3, previewParameters4, previewParameters5, previewParameters6, previewParameters7, previewParameters8, new PreviewParameters(1909, 1306, new Size(fill, fit), fitMode2, null), new PreviewParameters(1306, 1909, new Size(fit, fill), fitMode2, null));
    }

    @Override // androidx.compose.ui.tooling.preview.PreviewParameterProvider
    public Sequence getValues() {
        return this.values;
    }
}
