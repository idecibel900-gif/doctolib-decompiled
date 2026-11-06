package androidx.media3.container;

import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.Util;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/* JADX INFO: loaded from: classes.dex */
public final class ReorderingBufferQueue {
    private BuffersWithTimestamp lastQueuedBuffer;
    private final OutputConsumer outputConsumer;
    private final ArrayDeque unusedParsableByteArrays = new ArrayDeque();
    private final ArrayDeque unusedBuffersWithTimestamp = new ArrayDeque();
    private final PriorityQueue pendingBuffers = new PriorityQueue();
    private int reorderingQueueSize = -1;

    public interface OutputConsumer {
        void consume(long j, ParsableByteArray parsableByteArray);
    }

    public ReorderingBufferQueue(OutputConsumer outputConsumer) {
        this.outputConsumer = outputConsumer;
    }

    public void setMaxSize(int i) {
        Assertions.checkState(i >= 0);
        this.reorderingQueueSize = i;
        flushQueueDownToSize(i);
    }

    public int getMaxSize() {
        return this.reorderingQueueSize;
    }

    public void add(long j, ParsableByteArray parsableByteArray) {
        BuffersWithTimestamp buffersWithTimestamp;
        int i = this.reorderingQueueSize;
        if (i == 0 || (i != -1 && this.pendingBuffers.size() >= this.reorderingQueueSize && j < ((BuffersWithTimestamp) Util.castNonNull((BuffersWithTimestamp) this.pendingBuffers.peek())).presentationTimeUs)) {
            this.outputConsumer.consume(j, parsableByteArray);
            return;
        }
        ParsableByteArray parsableByteArrayCopy = copy(parsableByteArray);
        BuffersWithTimestamp buffersWithTimestamp2 = this.lastQueuedBuffer;
        if (buffersWithTimestamp2 != null && j == buffersWithTimestamp2.presentationTimeUs) {
            buffersWithTimestamp2.nalBuffers.add(parsableByteArrayCopy);
            return;
        }
        if (this.unusedBuffersWithTimestamp.isEmpty()) {
            buffersWithTimestamp = new BuffersWithTimestamp();
        } else {
            buffersWithTimestamp = (BuffersWithTimestamp) this.unusedBuffersWithTimestamp.pop();
        }
        buffersWithTimestamp.init(j, parsableByteArrayCopy);
        this.pendingBuffers.add(buffersWithTimestamp);
        this.lastQueuedBuffer = buffersWithTimestamp;
        int i2 = this.reorderingQueueSize;
        if (i2 != -1) {
            flushQueueDownToSize(i2);
        }
    }

    private ParsableByteArray copy(ParsableByteArray parsableByteArray) {
        ParsableByteArray parsableByteArray2;
        if (this.unusedParsableByteArrays.isEmpty()) {
            parsableByteArray2 = new ParsableByteArray();
        } else {
            parsableByteArray2 = (ParsableByteArray) this.unusedParsableByteArrays.pop();
        }
        parsableByteArray2.reset(parsableByteArray.bytesLeft());
        System.arraycopy(parsableByteArray.getData(), parsableByteArray.getPosition(), parsableByteArray2.getData(), 0, parsableByteArray2.bytesLeft());
        return parsableByteArray2;
    }

    public void clear() {
        this.pendingBuffers.clear();
    }

    public void flush() {
        flushQueueDownToSize(0);
    }

    private void flushQueueDownToSize(int i) {
        while (this.pendingBuffers.size() > i) {
            BuffersWithTimestamp buffersWithTimestamp = (BuffersWithTimestamp) Util.castNonNull((BuffersWithTimestamp) this.pendingBuffers.poll());
            for (int i2 = 0; i2 < buffersWithTimestamp.nalBuffers.size(); i2++) {
                this.outputConsumer.consume(buffersWithTimestamp.presentationTimeUs, (ParsableByteArray) buffersWithTimestamp.nalBuffers.get(i2));
                this.unusedParsableByteArrays.push((ParsableByteArray) buffersWithTimestamp.nalBuffers.get(i2));
            }
            buffersWithTimestamp.nalBuffers.clear();
            BuffersWithTimestamp buffersWithTimestamp2 = this.lastQueuedBuffer;
            if (buffersWithTimestamp2 != null && buffersWithTimestamp2.presentationTimeUs == buffersWithTimestamp.presentationTimeUs) {
                this.lastQueuedBuffer = null;
            }
            this.unusedBuffersWithTimestamp.push(buffersWithTimestamp);
        }
    }

    private static final class BuffersWithTimestamp implements Comparable {
        public long presentationTimeUs = -9223372036854775807L;
        public final List nalBuffers = new ArrayList();

        public void init(long j, ParsableByteArray parsableByteArray) {
            Assertions.checkArgument(j != -9223372036854775807L);
            Assertions.checkState(this.nalBuffers.isEmpty());
            this.presentationTimeUs = j;
            this.nalBuffers.add(parsableByteArray);
        }

        @Override // java.lang.Comparable
        public int compareTo(BuffersWithTimestamp buffersWithTimestamp) {
            return Long.compare(this.presentationTimeUs, buffersWithTimestamp.presentationTimeUs);
        }
    }
}
