package com.revenuecat.purchases.ui.revenuecatui.components;

import androidx.window.core.layout.WindowWidthSizeClass;
import com.google.firebase.messaging.Constants;
import com.revenuecat.purchases.ui.revenuecatui.helpers.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0001\u0018\u0000 \u00062\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0006B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0007"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/ScreenCondition;", "", "(Ljava/lang/String;I)V", "COMPACT", "MEDIUM", "EXPANDED", "Companion", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public enum ScreenCondition {
    COMPACT,
    MEDIUM,
    EXPANDED;


    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/ScreenCondition$Companion;", "", "()V", Constants.MessagePayloadKeys.FROM, "Lcom/revenuecat/purchases/ui/revenuecatui/components/ScreenCondition;", "sizeClass", "Landroidx/window/core/layout/WindowWidthSizeClass;", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final /* synthetic */ ScreenCondition from(WindowWidthSizeClass sizeClass) {
            Intrinsics.checkNotNullParameter(sizeClass, "sizeClass");
            if (Intrinsics.areEqual(sizeClass, WindowWidthSizeClass.COMPACT)) {
                return ScreenCondition.COMPACT;
            }
            if (Intrinsics.areEqual(sizeClass, WindowWidthSizeClass.MEDIUM)) {
                return ScreenCondition.MEDIUM;
            }
            if (Intrinsics.areEqual(sizeClass, WindowWidthSizeClass.EXPANDED)) {
                return ScreenCondition.EXPANDED;
            }
            Logger.INSTANCE.d("Unexpected WindowWidthSizeClass: '" + sizeClass + "'. Falling back to COMPACT.");
            return ScreenCondition.COMPACT;
        }
    }
}
