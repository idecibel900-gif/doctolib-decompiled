package com.swmansion.rnscreens.utils;

import com.facebook.react.uimanager.BackgroundStyleApplicator;
import com.facebook.react.views.view.ReactViewGroup;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public abstract class ViewBackgroundUtilsKt {
    public static final Integer resolveBackgroundColor(ReactViewGroup reactViewGroup) {
        Intrinsics.checkNotNullParameter(reactViewGroup, "<this>");
        return BackgroundStyleApplicator.getBackgroundColor(reactViewGroup);
    }
}
