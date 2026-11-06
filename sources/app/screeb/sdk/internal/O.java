package app.screeb.sdk.internal;

import com.facebook.react.fabric.mounting.mountitems.IntBufferBatchMountItem;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.CharsetEncoder;
import java.util.ArrayDeque;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes3.dex */
public final class O {
    public ByteBuffer a;
    public final ArrayDeque b;
    public final CharsetEncoder c;
    public ByteBuffer d;

    public O(int i) {
        ByteBuffer byteBufferOrder = ByteBuffer.allocate(i).order(ByteOrder.LITTLE_ENDIAN);
        Intrinsics.checkNotNullExpressionValue(byteBufferOrder, "order(...)");
        this.a = byteBufferOrder;
        this.b = new ArrayDeque(2);
        this.c = Charsets.UTF_8.newEncoder();
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER);
        Intrinsics.checkNotNullExpressionValue(byteBufferAllocate, "allocate(...)");
        this.d = byteBufferAllocate;
    }

    public final ByteBuffer a() {
        ByteBuffer byteBufferOrder;
        ByteBuffer byteBuffer = this.a;
        byteBuffer.flip();
        int iCapacity = byteBuffer.capacity();
        synchronized (this.b) {
            Iterator it = this.b.iterator();
            Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
            while (it.hasNext()) {
                byteBufferOrder = (ByteBuffer) it.next();
                if (byteBufferOrder.capacity() >= iCapacity) {
                    it.remove();
                    byteBufferOrder.clear();
                    byteBufferOrder.order(ByteOrder.LITTLE_ENDIAN);
                    Intrinsics.checkNotNull(byteBufferOrder);
                }
            }
            Unit unit = Unit.INSTANCE;
            byteBufferOrder = ByteBuffer.allocate(iCapacity).order(ByteOrder.LITTLE_ENDIAN);
            Intrinsics.checkNotNullExpressionValue(byteBufferOrder, "order(...)");
        }
        this.a = byteBufferOrder;
        return byteBuffer;
    }

    public final void a(byte b, long j) {
        a(11);
        this.a.put(b);
        ByteBuffer buf = this.a;
        Intrinsics.checkNotNullParameter(buf, "buf");
        long j2 = (j >> 63) ^ (j << 1);
        Intrinsics.checkNotNullParameter(buf, "buf");
        while (((-128) & j2) != 0) {
            buf.put((byte) ((j2 & 127) | 128));
            j2 >>>= 7;
        }
        buf.put((byte) (j2 & 127));
    }

    public final void a(int i) {
        if (this.a.remaining() >= i) {
            return;
        }
        int iPosition = this.a.position() + i;
        int iCapacity = this.a.capacity();
        while (iCapacity < iPosition) {
            iCapacity *= 2;
        }
        ByteBuffer byteBufferOrder = ByteBuffer.allocate(iCapacity).order(ByteOrder.LITTLE_ENDIAN);
        this.a.flip();
        byteBufferOrder.put(this.a);
        this.a = byteBufferOrder;
    }

    public final void a(long j) {
        a(10);
        ByteBuffer buf = this.a;
        Intrinsics.checkNotNullParameter(buf, "buf");
        long j2 = (j >> 63) ^ (j << 1);
        Intrinsics.checkNotNullParameter(buf, "buf");
        while (((-128) & j2) != 0) {
            buf.put((byte) ((j2 & 127) | 128));
            j2 >>>= 7;
        }
        buf.put((byte) (j2 & 127));
    }

    public final void a(ByteBuffer readBuffer) {
        Intrinsics.checkNotNullParameter(readBuffer, "readBuffer");
        readBuffer.clear();
        synchronized (this.b) {
            try {
                if (this.b.size() < 2) {
                    this.b.addLast(readBuffer);
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void b(long j) {
        a(10);
        ByteBuffer buf = this.a;
        Intrinsics.checkNotNullParameter(buf, "buf");
        while (((-128) & j) != 0) {
            buf.put((byte) ((j & 127) | 128));
            j >>>= 7;
        }
        buf.put((byte) (j & 127));
    }

    public final boolean b() {
        return this.a.position() == 0;
    }

    public final void c() {
        this.a.clear();
    }
}
