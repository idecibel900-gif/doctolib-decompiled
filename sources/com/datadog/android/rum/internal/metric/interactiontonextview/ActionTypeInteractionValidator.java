package com.datadog.android.rum.internal.metric.interactiontonextview;

import com.datadog.android.rum.model.ActionEvent;
import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class ActionTypeInteractionValidator implements InteractionIngestionValidator {
    public static final Companion Companion = new Companion(null);
    private static final Set ALLOWED_TYPES = SetsKt.setOf((Object[]) new ActionEvent.ActionEventActionType[]{ActionEvent.ActionEventActionType.TAP, ActionEvent.ActionEventActionType.SWIPE, ActionEvent.ActionEventActionType.CLICK, ActionEvent.ActionEventActionType.BACK});

    @Override // com.datadog.android.rum.internal.metric.interactiontonextview.InteractionIngestionValidator
    public boolean validate(InternalInteractionContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return ALLOWED_TYPES.contains(context.getActionType$dd_sdk_android_rum_release());
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
