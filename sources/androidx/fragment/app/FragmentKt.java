package androidx.fragment.app;

import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
public abstract class FragmentKt {
    public static final void setFragmentResult(Fragment fragment, String str, Bundle bundle) {
        fragment.getParentFragmentManager().setFragmentResult(str, bundle);
    }
}
