package expo.modules.kotlin.typedarray;

import expo.modules.kotlin.jni.JavaScriptTypedArray;
import java.nio.ByteBuffer;
import java.util.Iterator;
import kotlin.ULong;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class BigUint64Array implements TypedArray, GenericTypedArray, RawTypedArrayHolder {
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

    /* JADX INFO: renamed from: get-I7RO_PI, reason: not valid java name */
    public long m4934getI7RO_PI(int i) {
        if (i < 0 || i >= getLength()) {
            throw new IndexOutOfBoundsException();
        }
        return ULong.m5297constructorimpl(read8Byte(i * 8));
    }

    public BigUint64Array(JavaScriptTypedArray rawArray) {
        Intrinsics.checkNotNullParameter(rawArray, "rawArray");
        this.rawArray = rawArray;
    }

    @Override // expo.modules.kotlin.typedarray.GenericTypedArray
    public /* bridge */ /* synthetic */ Object get(int i) {
        return ULong.m5296boximpl(m4934getI7RO_PI(i));
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
