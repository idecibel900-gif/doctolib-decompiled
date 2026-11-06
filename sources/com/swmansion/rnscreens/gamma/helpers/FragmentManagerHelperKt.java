package com.swmansion.rnscreens.gamma.helpers;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public abstract class FragmentManagerHelperKt {
    public static final FragmentTransaction createTransactionWithReordering(FragmentManager fragmentManager) {
        Intrinsics.checkNotNullParameter(fragmentManager, "<this>");
        FragmentTransaction reorderingAllowed = fragmentManager.beginTransaction().setReorderingAllowed(true);
        Intrinsics.checkNotNullExpressionValue(reorderingAllowed, "setReorderingAllowed(...)");
        return reorderingAllowed;
    }
}
