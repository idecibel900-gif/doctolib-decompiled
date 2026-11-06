package com.revenuecat.purchases.ui.revenuecatui.composables;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.InfiniteRepeatableSpec;
import androidx.compose.animation.core.RepeatMode;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R!\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/composables/PlaceholderDefaults;", "", "()V", "fadeAnimationSpec", "Landroidx/compose/animation/core/InfiniteRepeatableSpec;", "", "getFadeAnimationSpec", "()Landroidx/compose/animation/core/InfiniteRepeatableSpec;", "fadeAnimationSpec$delegate", "Lkotlin/Lazy;", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PlaceholderDefaults {
    public static final PlaceholderDefaults INSTANCE = new PlaceholderDefaults();

    /* JADX INFO: renamed from: fadeAnimationSpec$delegate, reason: from kotlin metadata */
    private static final Lazy fadeAnimationSpec = LazyKt.lazy(new Function0() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.PlaceholderDefaults$fadeAnimationSpec$2
        @Override // kotlin.jvm.functions.Function0
        public final InfiniteRepeatableSpec invoke() {
            return AnimationSpecKt.m67infiniteRepeatable9IiC70o$default(AnimationSpecKt.tween$default(600, 200, null, 4, null), RepeatMode.Reverse, 0L, 4, null);
        }
    });
    public static final int $stable = 8;

    private PlaceholderDefaults() {
    }

    public final InfiniteRepeatableSpec getFadeAnimationSpec() {
        return (InfiniteRepeatableSpec) fadeAnimationSpec.getValue();
    }
}
