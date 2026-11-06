package androidx.media3.session;

import android.os.Handler;
import androidx.collection.ArrayMap;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import com.google.common.util.concurrent.AbstractFuture;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
final class SequencedFutureManager {
    private boolean isReleased;
    private int nextSequenceNumber;
    private Runnable pendingLazyReleaseCallback;
    private Handler releaseCallbackHandler;
    private final Object lock = new Object();
    private final ArrayMap seqToFutureMap = new ArrayMap();

    public int obtainNextSequenceNumber() {
        int i;
        synchronized (this.lock) {
            i = this.nextSequenceNumber;
            this.nextSequenceNumber = i + 1;
        }
        return i;
    }

    public SequencedFuture createSequencedFuture(Object obj) {
        SequencedFuture sequencedFutureCreate;
        synchronized (this.lock) {
            try {
                int iObtainNextSequenceNumber = obtainNextSequenceNumber();
                sequencedFutureCreate = SequencedFuture.create(iObtainNextSequenceNumber, obj);
                if (this.isReleased) {
                    sequencedFutureCreate.setWithTheValueOfResultWhenClosed();
                } else {
                    this.seqToFutureMap.put(Integer.valueOf(iObtainNextSequenceNumber), sequencedFutureCreate);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return sequencedFutureCreate;
    }

    public void setFutureResult(int i, Object obj) {
        synchronized (this.lock) {
            try {
                SequencedFuture sequencedFuture = (SequencedFuture) this.seqToFutureMap.remove(Integer.valueOf(i));
                if (sequencedFuture != null) {
                    if (sequencedFuture.getResultWhenClosed().getClass() == obj.getClass()) {
                        sequencedFuture.set(obj);
                    } else {
                        Log.w("SequencedFutureManager", "Type mismatch, expected " + sequencedFuture.getResultWhenClosed().getClass() + ", but was " + obj.getClass());
                    }
                }
                if (this.pendingLazyReleaseCallback != null && this.seqToFutureMap.isEmpty()) {
                    release();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void release() {
        ArrayList arrayList;
        synchronized (this.lock) {
            try {
                this.isReleased = true;
                arrayList = new ArrayList(this.seqToFutureMap.values());
                this.seqToFutureMap.clear();
                if (this.pendingLazyReleaseCallback != null) {
                    ((Handler) Assertions.checkNotNull(this.releaseCallbackHandler)).post(this.pendingLazyReleaseCallback);
                    this.pendingLazyReleaseCallback = null;
                    this.releaseCallbackHandler = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((SequencedFuture) it.next()).setWithTheValueOfResultWhenClosed();
        }
    }

    public static final class SequencedFuture extends AbstractFuture {
        private final Object resultWhenClosed;
        private final int sequenceNumber;

        private SequencedFuture(int i, Object obj) {
            this.sequenceNumber = i;
            this.resultWhenClosed = obj;
        }

        @Override // com.google.common.util.concurrent.AbstractFuture
        public boolean set(Object obj) {
            return super.set(obj);
        }

        public void setWithTheValueOfResultWhenClosed() {
            set(this.resultWhenClosed);
        }

        public int getSequenceNumber() {
            return this.sequenceNumber;
        }

        public Object getResultWhenClosed() {
            return this.resultWhenClosed;
        }

        public static SequencedFuture create(int i, Object obj) {
            return new SequencedFuture(i, obj);
        }
    }
}
