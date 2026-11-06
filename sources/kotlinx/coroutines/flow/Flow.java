package kotlinx.coroutines.flow;

import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes5.dex */
public interface Flow {
    Object collect(FlowCollector flowCollector, Continuation continuation);
}
