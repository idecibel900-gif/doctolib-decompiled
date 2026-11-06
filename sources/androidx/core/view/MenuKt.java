package androidx.core.view;

import android.view.Menu;
import android.view.MenuItem;
import java.util.Iterator;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.sequences.Sequence;

/* JADX INFO: loaded from: classes.dex */
public abstract class MenuKt {

    /* JADX INFO: renamed from: androidx.core.view.MenuKt$iterator$1, reason: invalid class name */
    public static final class AnonymousClass1 implements Iterator, KMappedMarker {
        final /* synthetic */ Menu $this_iterator;
        private int index;

        AnonymousClass1(Menu menu) {
            this.$this_iterator = menu;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.index < this.$this_iterator.size();
        }

        @Override // java.util.Iterator
        public MenuItem next() {
            Menu menu = this.$this_iterator;
            int i = this.index;
            this.index = i + 1;
            MenuItem item = menu.getItem(i);
            if (item != null) {
                return item;
            }
            throw new IndexOutOfBoundsException();
        }

        @Override // java.util.Iterator
        public void remove() {
            Menu menu = this.$this_iterator;
            int i = this.index - 1;
            this.index = i;
            MenuItem item = menu.getItem(i);
            if (item == null) {
                throw new IndexOutOfBoundsException();
            }
            menu.removeItem(item.getItemId());
        }
    }

    public static final Iterator iterator(Menu menu) {
        return new AnonymousClass1(menu);
    }

    public static final Sequence getChildren(final Menu menu) {
        return new Sequence() { // from class: androidx.core.view.MenuKt$children$1
            @Override // kotlin.sequences.Sequence
            public Iterator iterator() {
                return MenuKt.iterator(menu);
            }
        };
    }
}
