package com.swmansion.rnscreens.bottomsheet;

import android.view.View;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.WindowInsetsCompat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class BottomSheetWindowInsetListenerChain implements OnApplyWindowInsetsListener {
    private final List listeners = new ArrayList();

    public final void addListener(OnApplyWindowInsetsListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listeners.add(listener);
    }

    @Override // androidx.core.view.OnApplyWindowInsetsListener
    public WindowInsetsCompat onApplyWindowInsets(View v, WindowInsetsCompat insets) {
        Intrinsics.checkNotNullParameter(v, "v");
        Intrinsics.checkNotNullParameter(insets, "insets");
        Iterator it = this.listeners.iterator();
        while (it.hasNext()) {
            ((OnApplyWindowInsetsListener) it.next()).onApplyWindowInsets(v, insets);
        }
        return insets;
    }
}
