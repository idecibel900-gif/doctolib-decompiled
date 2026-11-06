package kotlinx.coroutines.channels;

import kotlin.ExceptionsKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.internal.OnUndeliveredElementKt;
import kotlinx.coroutines.internal.UndeliveredElementException;

/* JADX INFO: loaded from: classes5.dex */
public class ConflatedBufferedChannel extends BufferedChannel {
    private final int capacity;
    private final BufferOverflow onBufferOverflow;

    @Override // kotlinx.coroutines.channels.BufferedChannel, kotlinx.coroutines.channels.SendChannel
    public Object send(Object obj, Continuation continuation) {
        return send$suspendImpl(this, obj, continuation);
    }

    public ConflatedBufferedChannel(int i, BufferOverflow bufferOverflow, Function1 function1) {
        super(i, function1);
        this.capacity = i;
        this.onBufferOverflow = bufferOverflow;
        if (bufferOverflow == BufferOverflow.SUSPEND) {
            throw new IllegalArgumentException(("This implementation does not support suspension for senders, use " + Reflection.getOrCreateKotlinClass(BufferedChannel.class).getSimpleName() + " instead").toString());
        }
        if (i >= 1) {
            return;
        }
        throw new IllegalArgumentException(("Buffered channel capacity must be at least 1, but " + i + " was specified").toString());
    }

    @Override // kotlinx.coroutines.channels.BufferedChannel
    protected boolean isConflatedDropOldest() {
        return this.onBufferOverflow == BufferOverflow.DROP_OLDEST;
    }

    static /* synthetic */ Object send$suspendImpl(ConflatedBufferedChannel conflatedBufferedChannel, Object obj, Continuation continuation) throws Throwable {
        UndeliveredElementException undeliveredElementExceptionCallUndeliveredElementCatchingException$default;
        Object objM5466trySendImplMj0NB7M = conflatedBufferedChannel.m5466trySendImplMj0NB7M(obj, true);
        if (objM5466trySendImplMj0NB7M instanceof ChannelResult.Closed) {
            ChannelResult.m5455exceptionOrNullimpl(objM5466trySendImplMj0NB7M);
            Function1 function1 = conflatedBufferedChannel.onUndeliveredElement;
            if (function1 != null && (undeliveredElementExceptionCallUndeliveredElementCatchingException$default = OnUndeliveredElementKt.callUndeliveredElementCatchingException$default(function1, obj, null, 2, null)) != null) {
                ExceptionsKt.addSuppressed(undeliveredElementExceptionCallUndeliveredElementCatchingException$default, conflatedBufferedChannel.getSendException());
                throw undeliveredElementExceptionCallUndeliveredElementCatchingException$default;
            }
            throw conflatedBufferedChannel.getSendException();
        }
        return Unit.INSTANCE;
    }

    @Override // kotlinx.coroutines.channels.BufferedChannel, kotlinx.coroutines.channels.SendChannel
    /* JADX INFO: renamed from: trySend-JP2dKIU */
    public Object mo5449trySendJP2dKIU(Object obj) {
        return m5466trySendImplMj0NB7M(obj, false);
    }

    /* JADX INFO: renamed from: trySendImpl-Mj0NB7M, reason: not valid java name */
    private final Object m5466trySendImplMj0NB7M(Object obj, boolean z) {
        return this.onBufferOverflow == BufferOverflow.DROP_LATEST ? m5465trySendDropLatestMj0NB7M(obj, z) : m5450trySendDropOldestJP2dKIU(obj);
    }

    /* JADX INFO: renamed from: trySendDropLatest-Mj0NB7M, reason: not valid java name */
    private final Object m5465trySendDropLatestMj0NB7M(Object obj, boolean z) {
        Function1 function1;
        UndeliveredElementException undeliveredElementExceptionCallUndeliveredElementCatchingException$default;
        Object objMo5449trySendJP2dKIU = super.mo5449trySendJP2dKIU(obj);
        if (ChannelResult.m5459isSuccessimpl(objMo5449trySendJP2dKIU) || ChannelResult.m5458isClosedimpl(objMo5449trySendJP2dKIU)) {
            return objMo5449trySendJP2dKIU;
        }
        if (z && (function1 = this.onUndeliveredElement) != null && (undeliveredElementExceptionCallUndeliveredElementCatchingException$default = OnUndeliveredElementKt.callUndeliveredElementCatchingException$default(function1, obj, null, 2, null)) != null) {
            throw undeliveredElementExceptionCallUndeliveredElementCatchingException$default;
        }
        return ChannelResult.Companion.m5464successJP2dKIU(Unit.INSTANCE);
    }
}
