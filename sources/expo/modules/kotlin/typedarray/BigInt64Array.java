package expo.modules.kotlin.typedarray;

import expo.modules.kotlin.jni.JavaScriptTypedArray;
import java.nio.ByteBuffer;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class BigInt64Array implements TypedArray, GenericTypedArray, RawTypedArrayHolder {
    private final JavaScriptTypedArray rawArray;

    @Override // expo.modules.kotlin.typedarray.TypedArray
    public int getLength() {
        return this.rawArray.getLength();
    }

    public long read8Byte(int i) {
        return this.rawArray.read8Byte(i);
    }

    @Override // expo.modules.kotlin.typedarray.TypedArray
    public ByteBuffer toDirectBuffer() {
        return this.rawArray.toDirectBuffer();
    }

    @Override // expo.modules.kotlin.typedarray.GenericTypedArray
    public Long get(int i) {
        if (i < 0 || i >= getLength()) {
            throw new IndexOutOfBoundsException();
        }
        return Long.valueOf(read8Byte(i * 8));
    }

    public BigInt64Array(JavaScriptTypedArray rawArray) {
        Intrinsics.checkNotNullParameter(rawArray, "rawArray");
        this.rawArray = rawArray;
    }

    @Override // expo.modules.kotlin.typedarray.RawTypedArrayHolder
    public JavaScriptTypedArray getRawArray() {
        return this.rawArray;
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        return GenericTypedArray.DefaultImpls.iterator(this);
    }
}
