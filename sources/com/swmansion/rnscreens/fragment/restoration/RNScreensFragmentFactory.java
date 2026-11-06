package com.swmansion.rnscreens.fragment.restoration;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentFactory;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
public final class RNScreensFragmentFactory extends FragmentFactory {
    @Override // androidx.fragment.app.FragmentFactory
    public Fragment instantiate(ClassLoader classLoader, String className) {
        Intrinsics.checkNotNullParameter(classLoader, "classLoader");
        Intrinsics.checkNotNullParameter(className, "className");
        if (StringsKt.startsWith$default(className, "com.swmansion.rnscreens", false, 2, (Object) null)) {
            return new AutoRemovingFragment();
        }
        Fragment fragmentInstantiate = super.instantiate(classLoader, className);
        Intrinsics.checkNotNull(fragmentInstantiate);
        return fragmentInstantiate;
    }
}
