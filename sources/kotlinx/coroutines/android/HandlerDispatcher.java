package kotlinx.coroutines.android;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.Delay;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: classes5.dex */
public abstract class HandlerDispatcher extends MainCoroutineDispatcher implements Delay {
    public /* synthetic */ HandlerDispatcher(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Override // kotlinx.coroutines.MainCoroutineDispatcher
    public abstract HandlerDispatcher getImmediate();

    private HandlerDispatcher() {
    }
}
