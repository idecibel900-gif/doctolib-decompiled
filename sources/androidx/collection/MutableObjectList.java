package androidx.collection;

import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class MutableObjectList extends ObjectList {
    public MutableObjectList(int i) {
        super(i, null);
    }

    public /* synthetic */ MutableObjectList(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 16 : i);
    }

    public final boolean add(Object obj) {
        int i = this._size + 1;
        Object[] objArr = this.content;
        if (objArr.length < i) {
            resizeStorage(i, objArr);
        }
        Object[] objArr2 = this.content;
        int i2 = this._size;
        objArr2[i2] = obj;
        this._size = i2 + 1;
        return true;
    }

    public final void clear() {
        ArraysKt.fill(this.content, (Object) null, 0, this._size);
        this._size = 0;
    }

    public final void resizeStorage(int i, Object[] oldContent) {
        Intrinsics.checkNotNullParameter(oldContent, "oldContent");
        int length = oldContent.length;
        this.content = ArraysKt.copyInto(oldContent, new Object[Math.max(i, (length * 3) / 2)], 0, 0, length);
    }
}
