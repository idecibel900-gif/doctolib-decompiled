package kotlinx.coroutines.channels;

import java.util.concurrent.CancellationException;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes5.dex */
public interface ReceiveChannel {
    void cancel(CancellationException cancellationException);

    ChannelIterator iterator();

    Object receive(Continuation continuation);

    /* JADX INFO: renamed from: receiveCatching-JP2dKIU */
    Object mo5447receiveCatchingJP2dKIU(Continuation continuation);

    /* JADX INFO: renamed from: tryReceive-PtdJZtk */
    Object mo5448tryReceivePtdJZtk();
}
