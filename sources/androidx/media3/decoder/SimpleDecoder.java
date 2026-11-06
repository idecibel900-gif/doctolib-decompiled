package androidx.media3.decoder;

import androidx.media3.common.util.Assertions;
import java.util.ArrayDeque;

/* JADX INFO: loaded from: classes.dex */
public abstract class SimpleDecoder implements Decoder {
    private int availableInputBufferCount;
    private final DecoderInputBuffer[] availableInputBuffers;
    private int availableOutputBufferCount;
    private final DecoderOutputBuffer[] availableOutputBuffers;
    private final Thread decodeThread;
    private DecoderInputBuffer dequeuedInputBuffer;
    private DecoderException exception;
    private boolean flushed;
    private final Object lock = new Object();
    private long outputStartTimeUs = -9223372036854775807L;
    private final ArrayDeque queuedInputBuffers = new ArrayDeque();
    private final ArrayDeque queuedOutputBuffers = new ArrayDeque();
    private boolean released;
    private int skippedOutputBufferCount;

    protected abstract DecoderInputBuffer createInputBuffer();

    protected abstract DecoderOutputBuffer createOutputBuffer();

    protected abstract DecoderException createUnexpectedDecodeException(Throwable th);

    protected abstract DecoderException decode(DecoderInputBuffer decoderInputBuffer, DecoderOutputBuffer decoderOutputBuffer, boolean z);

    protected SimpleDecoder(DecoderInputBuffer[] decoderInputBufferArr, DecoderOutputBuffer[] decoderOutputBufferArr) {
        this.availableInputBuffers = decoderInputBufferArr;
        this.availableInputBufferCount = decoderInputBufferArr.length;
        for (int i = 0; i < this.availableInputBufferCount; i++) {
            this.availableInputBuffers[i] = createInputBuffer();
        }
        this.availableOutputBuffers = decoderOutputBufferArr;
        this.availableOutputBufferCount = decoderOutputBufferArr.length;
        for (int i2 = 0; i2 < this.availableOutputBufferCount; i2++) {
            this.availableOutputBuffers[i2] = createOutputBuffer();
        }
        Thread thread = new Thread("ExoPlayer:SimpleDecoder") { // from class: androidx.media3.decoder.SimpleDecoder.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                SimpleDecoder.this.run();
            }
        };
        this.decodeThread = thread;
        thread.start();
    }

    protected final void setInitialInputBufferSize(int i) {
        Assertions.checkState(this.availableInputBufferCount == this.availableInputBuffers.length);
        for (DecoderInputBuffer decoderInputBuffer : this.availableInputBuffers) {
            decoderInputBuffer.ensureSpaceForWrite(i);
        }
    }

    protected final boolean isAtLeastOutputStartTimeUs(long j) {
        boolean z;
        synchronized (this.lock) {
            long j2 = this.outputStartTimeUs;
            z = j2 == -9223372036854775807L || j >= j2;
        }
        return z;
    }

    @Override // androidx.media3.decoder.Decoder
    public final void setOutputStartTimeUs(long j) {
        synchronized (this.lock) {
            try {
                Assertions.checkState(this.availableInputBufferCount == this.availableInputBuffers.length || this.flushed);
                this.outputStartTimeUs = j;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.media3.decoder.Decoder
    public final DecoderInputBuffer dequeueInputBuffer() {
        DecoderInputBuffer decoderInputBuffer;
        synchronized (this.lock) {
            maybeThrowException();
            Assertions.checkState(this.dequeuedInputBuffer == null);
            int i = this.availableInputBufferCount;
            if (i == 0) {
                decoderInputBuffer = null;
            } else {
                DecoderInputBuffer[] decoderInputBufferArr = this.availableInputBuffers;
                int i2 = i - 1;
                this.availableInputBufferCount = i2;
                decoderInputBuffer = decoderInputBufferArr[i2];
            }
            this.dequeuedInputBuffer = decoderInputBuffer;
        }
        return decoderInputBuffer;
    }

    @Override // androidx.media3.decoder.Decoder
    public final void queueInputBuffer(DecoderInputBuffer decoderInputBuffer) {
        synchronized (this.lock) {
            maybeThrowException();
            Assertions.checkArgument(decoderInputBuffer == this.dequeuedInputBuffer);
            this.queuedInputBuffers.addLast(decoderInputBuffer);
            maybeNotifyDecodeLoop();
            this.dequeuedInputBuffer = null;
        }
    }

    @Override // androidx.media3.decoder.Decoder
    public final DecoderOutputBuffer dequeueOutputBuffer() {
        synchronized (this.lock) {
            try {
                maybeThrowException();
                if (this.queuedOutputBuffers.isEmpty()) {
                    return null;
                }
                return (DecoderOutputBuffer) this.queuedOutputBuffers.removeFirst();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    protected void releaseOutputBuffer(DecoderOutputBuffer decoderOutputBuffer) {
        synchronized (this.lock) {
            releaseOutputBufferInternal(decoderOutputBuffer);
            maybeNotifyDecodeLoop();
        }
    }

    @Override // androidx.media3.decoder.Decoder
    public final void flush() {
        synchronized (this.lock) {
            try {
                this.flushed = true;
                this.skippedOutputBufferCount = 0;
                DecoderInputBuffer decoderInputBuffer = this.dequeuedInputBuffer;
                if (decoderInputBuffer != null) {
                    releaseInputBufferInternal(decoderInputBuffer);
                    this.dequeuedInputBuffer = null;
                }
                while (!this.queuedInputBuffers.isEmpty()) {
                    releaseInputBufferInternal((DecoderInputBuffer) this.queuedInputBuffers.removeFirst());
                }
                while (!this.queuedOutputBuffers.isEmpty()) {
                    ((DecoderOutputBuffer) this.queuedOutputBuffers.removeFirst()).release();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.media3.decoder.Decoder
    public void release() {
        synchronized (this.lock) {
            this.released = true;
            this.lock.notify();
        }
        try {
            this.decodeThread.join();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
        }
    }

    private void maybeThrowException() throws DecoderException {
        DecoderException decoderException = this.exception;
        if (decoderException != null) {
            throw decoderException;
        }
    }

    private void maybeNotifyDecodeLoop() {
        if (canDecodeBuffer()) {
            this.lock.notify();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void run() {
        do {
            try {
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
        } while (decode());
    }

    private boolean decode() {
        DecoderException decoderExceptionCreateUnexpectedDecodeException;
        synchronized (this.lock) {
            while (!this.released && !canDecodeBuffer()) {
                try {
                    this.lock.wait();
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (this.released) {
                return false;
            }
            DecoderInputBuffer decoderInputBuffer = (DecoderInputBuffer) this.queuedInputBuffers.removeFirst();
            DecoderOutputBuffer[] decoderOutputBufferArr = this.availableOutputBuffers;
            int i = this.availableOutputBufferCount - 1;
            this.availableOutputBufferCount = i;
            DecoderOutputBuffer decoderOutputBuffer = decoderOutputBufferArr[i];
            boolean z = this.flushed;
            this.flushed = false;
            if (decoderInputBuffer.isEndOfStream()) {
                decoderOutputBuffer.addFlag(4);
            } else {
                decoderOutputBuffer.timeUs = decoderInputBuffer.timeUs;
                if (decoderInputBuffer.isFirstSample()) {
                    decoderOutputBuffer.addFlag(134217728);
                }
                if (!isAtLeastOutputStartTimeUs(decoderInputBuffer.timeUs)) {
                    decoderOutputBuffer.shouldBeSkipped = true;
                }
                try {
                    decoderExceptionCreateUnexpectedDecodeException = decode(decoderInputBuffer, decoderOutputBuffer, z);
                } catch (OutOfMemoryError e) {
                    decoderExceptionCreateUnexpectedDecodeException = createUnexpectedDecodeException(e);
                } catch (RuntimeException e2) {
                    decoderExceptionCreateUnexpectedDecodeException = createUnexpectedDecodeException(e2);
                }
                if (decoderExceptionCreateUnexpectedDecodeException != null) {
                    synchronized (this.lock) {
                        this.exception = decoderExceptionCreateUnexpectedDecodeException;
                    }
                    return false;
                }
            }
            synchronized (this.lock) {
                try {
                    if (this.flushed) {
                        decoderOutputBuffer.release();
                    } else if (decoderOutputBuffer.shouldBeSkipped) {
                        this.skippedOutputBufferCount++;
                        decoderOutputBuffer.release();
                    } else {
                        decoderOutputBuffer.skippedOutputBufferCount = this.skippedOutputBufferCount;
                        this.skippedOutputBufferCount = 0;
                        this.queuedOutputBuffers.addLast(decoderOutputBuffer);
                    }
                    releaseInputBufferInternal(decoderInputBuffer);
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            return true;
        }
    }

    private boolean canDecodeBuffer() {
        return !this.queuedInputBuffers.isEmpty() && this.availableOutputBufferCount > 0;
    }

    private void releaseInputBufferInternal(DecoderInputBuffer decoderInputBuffer) {
        decoderInputBuffer.clear();
        DecoderInputBuffer[] decoderInputBufferArr = this.availableInputBuffers;
        int i = this.availableInputBufferCount;
        this.availableInputBufferCount = i + 1;
        decoderInputBufferArr[i] = decoderInputBuffer;
    }

    private void releaseOutputBufferInternal(DecoderOutputBuffer decoderOutputBuffer) {
        decoderOutputBuffer.clear();
        DecoderOutputBuffer[] decoderOutputBufferArr = this.availableOutputBuffers;
        int i = this.availableOutputBufferCount;
        this.availableOutputBufferCount = i + 1;
        decoderOutputBufferArr[i] = decoderOutputBuffer;
    }
}
