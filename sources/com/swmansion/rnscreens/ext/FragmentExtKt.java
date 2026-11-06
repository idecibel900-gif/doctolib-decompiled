package com.swmansion.rnscreens.ext;

import androidx.fragment.app.Fragment;
import com.swmansion.rnscreens.ScreenStackFragment;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public abstract class FragmentExtKt {
    public static final ScreenStackFragment asScreenStackFragment(Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        return (ScreenStackFragment) fragment;
    }
}
