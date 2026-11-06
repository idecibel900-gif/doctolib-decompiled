package kotlinx.coroutines.channels;

import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes5.dex */
public interface ChannelIterator {
    Object hasNext(Continuation continuation);

    Object next();
}
