package kotlinx.coroutines.flow;

import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes5.dex */
public interface FlowCollector {
    Object emit(Object obj, Continuation continuation);
}
