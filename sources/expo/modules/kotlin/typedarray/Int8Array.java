package expo.modules.kotlin.typedarray;

import expo.modules.kotlin.jni.JavaScriptTypedArray;
import java.nio.ByteBuffer;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class Int8Array implements TypedArray, GenericTypedArray, RawTypedArrayHolder {
    private final JavaScriptTypedArray rawArray;

    @Override // expo.modules.kotlin.typedarray.TypedArray
    public int getLength() {
        return this.rawArray.getLength();
    }

    public byte readByte(int i) {
        return this.rawArray.readByte(i);
    }

    @Override // expo.modules.kotlin.typedarray.TypedArray
    public ByteBuffer toDirectBuffer() {
        return this.rawArray.toDirectBuffer();
    }

    @Override // expo.modules.kotlin.typedarray.GenericTypedArray
    public Byte get(int i) {
        if (i < 0 || i >= getLength()) {
            throw new IndexOutOfBoundsException();
        }
        return Byte.valueOf(readByte(i));
    }

    public Int8Array(JavaScriptTypedArray rawArray) {
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
