package io.didomi.ssl;

import com.iabtcf.utils.IntIterable;
import com.iabtcf.utils.IntIterator;
import com.opentok.android.PublisherKit;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\"\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\u0006\tB\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0014\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¨\u0006\n"}, d2 = {"Lio/didomi/sdk/d7;", "", "", "", "intSet", "Lcom/iabtcf/utils/IntIterable;", "a", "<init>", "()V", "b", "android_release"}, k = 1, mv = {1, 8, 0})
public final class d7 {
    public static final d7 a = new d7();

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u0011\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0096\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\u0013\u0010\n\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0096\u0002J\b\u0010\u000b\u001a\u00020\u0002H\u0016R\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\r¨\u0006\u0013"}, d2 = {"Lio/didomi/sdk/d7$a;", "Lcom/iabtcf/utils/IntIterable;", "", "element", "", "contains", "Lio/didomi/sdk/d7$b;", "a", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "equals", "hashCode", "", "Ljava/util/Set;", "mutableIntSet", "", "intSet", "<init>", "(Ljava/util/Set;)V", "android_release"}, k = 1, mv = {1, 8, 0})
    public static final class a extends IntIterable {

        /* JADX INFO: renamed from: a, reason: from kotlin metadata */
        private final Set<Integer> mutableIntSet;

        public a(Set<Integer> intSet) {
            Intrinsics.checkNotNullParameter(intSet, "intSet");
            this.mutableIntSet = CollectionsKt.toMutableSet(intSet);
        }

        @Override // com.iabtcf.utils.IntIterable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public b intIterator() {
            return new b(this.mutableIntSet);
        }

        @Override // com.iabtcf.utils.IntIterable
        public boolean contains(int element) {
            return this.mutableIntSet.contains(Integer.valueOf(element));
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof IntIterable) && Intrinsics.areEqual(this.mutableIntSet, ((IntIterable) other).toSet());
        }

        public int hashCode() {
            return this.mutableIntSet.hashCode();
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010)\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0003\u001a\u00020\u0002H\u0096\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\t\u0010\t\u001a\u00020\bH\u0096\u0002R\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u000b¨\u0006\u0011"}, d2 = {"Lio/didomi/sdk/d7$b;", "Lcom/iabtcf/utils/IntIterator;", "", "a", "()Ljava/lang/Integer;", "nextInt", "", "remove", "", "hasNext", "", "Ljava/util/Iterator;", "iterator", "", "intSet", "<init>", "(Ljava/util/Set;)V", "android_release"}, k = 1, mv = {1, 8, 0})
    public static final class b implements IntIterator {

        /* JADX INFO: renamed from: a, reason: from kotlin metadata */
        private final Iterator<Integer> iterator;

        public b(Set<Integer> intSet) {
            Intrinsics.checkNotNullParameter(intSet, "intSet");
            this.iterator = CollectionsKt.toMutableList((Collection) intSet).iterator();
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Integer next() {
            return this.iterator.next();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.iterator.hasNext();
        }

        @Override // com.iabtcf.utils.OfInt
        public int nextInt() {
            return this.iterator.next().intValue();
        }

        @Override // java.util.Iterator
        public void remove() {
            this.iterator.remove();
        }
    }

    private d7() {
    }

    public final IntIterable a(Set<Integer> intSet) {
        Intrinsics.checkNotNullParameter(intSet, "intSet");
        return new a(intSet);
    }
}
