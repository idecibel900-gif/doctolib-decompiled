package kotlin.sequences;

import java.util.Iterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: loaded from: classes5.dex */
public final class DropWhileSequence implements Sequence {
    private final Function1 predicate;
    private final Sequence sequence;

    public DropWhileSequence(Sequence sequence, Function1 predicate) {
        Intrinsics.checkNotNullParameter(sequence, "sequence");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        this.sequence = sequence;
        this.predicate = predicate;
    }

    /* JADX INFO: renamed from: kotlin.sequences.DropWhileSequence$iterator$1, reason: invalid class name */
    public static final class AnonymousClass1 implements Iterator, KMappedMarker {
        private int dropState = -1;
        private final Iterator iterator;
        private Object nextItem;

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        AnonymousClass1() {
            this.iterator = DropWhileSequence.this.sequence.iterator();
        }

        private final void drop() {
            while (this.iterator.hasNext()) {
                Object next = this.iterator.next();
                if (!((Boolean) DropWhileSequence.this.predicate.invoke(next)).booleanValue()) {
                    this.nextItem = next;
                    this.dropState = 1;
                    return;
                }
            }
            this.dropState = 0;
        }

        @Override // java.util.Iterator
        public Object next() {
            if (this.dropState == -1) {
                drop();
            }
            if (this.dropState == 1) {
                Object obj = this.nextItem;
                this.nextItem = null;
                this.dropState = 0;
                return obj;
            }
            return this.iterator.next();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.dropState == -1) {
                drop();
            }
            return this.dropState == 1 || this.iterator.hasNext();
        }
    }

    @Override // kotlin.sequences.Sequence
    public Iterator iterator() {
        return new AnonymousClass1();
    }
}
