package com.unistyles;

import com.margelo.nitro.unistyles.UnistylesNativeMiniRuntime;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* synthetic */ class NativePlatformAndroid$_listener$1 extends FunctionReferenceImpl implements Function0 {
    NativePlatformAndroid$_listener$1(Object obj) {
        super(0, obj, NativePlatformAndroid.class, "getMiniRuntime", "getMiniRuntime()Lcom/margelo/nitro/unistyles/UnistylesNativeMiniRuntime;", 0);
    }

    @Override // kotlin.jvm.functions.Function0
    public final UnistylesNativeMiniRuntime invoke() {
        return ((NativePlatformAndroid) this.receiver).get_miniRuntime();
    }
}
