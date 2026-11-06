package expo.modules.fetch;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class ResponseSink {
    private final List bodyQueue = new ArrayList();
    private boolean bodyUsed;
    private boolean isFinalized;

    public final boolean getBodyUsed() {
        return this.bodyUsed;
    }

    public final void appendBufferBody$expo_productionRelease(byte[] data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.bodyUsed = true;
        this.bodyQueue.add(data);
    }

    public final ByteBuffer finalize(boolean z) {
        ByteBuffer byteBufferAllocate;
        Iterator it = this.bodyQueue.iterator();
        int length = 0;
        while (it.hasNext()) {
            length += ((byte[]) it.next()).length;
        }
        if (z) {
            byteBufferAllocate = ByteBuffer.allocateDirect(length);
        } else {
            byteBufferAllocate = ByteBuffer.allocate(length);
        }
        Iterator it2 = this.bodyQueue.iterator();
        while (it2.hasNext()) {
            byteBufferAllocate.put((byte[]) it2.next());
        }
        this.bodyQueue.clear();
        this.bodyUsed = true;
        this.isFinalized = true;
        Intrinsics.checkNotNull(byteBufferAllocate);
        return byteBufferAllocate;
    }
}
