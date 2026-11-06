package androidx.compose.animation.core;

import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes.dex */
public interface TwoWayConverter {
    Function1 getConvertFromVector();

    Function1 getConvertToVector();
}
