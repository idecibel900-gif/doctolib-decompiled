package com.datadog.android.rum.metric.interactiontonextview;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class NoOpLastInteractionIdentifier implements LastInteractionIdentifier {
    @Override // com.datadog.android.rum.metric.interactiontonextview.LastInteractionIdentifier
    public boolean validate(PreviousViewLastInteractionContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return false;
    }
}
