package expo.modules.kotlin.typedarray;

import expo.modules.kotlin.jni.JavaScriptTypedArray;
import java.nio.ByteBuffer;
import java.util.Iterator;
import kotlin.UByte;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class Uint8ClampedArray implements TypedArray, GenericTypedArray, RawTypedArrayHolder {
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

    /* JADX INFO: renamed from: get-Wa3L5BU, reason: not valid java name */
    public byte m4938getWa3L5BU(int i) {
        if (i < 0 || i >= getLength()) {
            throw new IndexOutOfBoundsException();
        }
        return UByte.m5253constructorimpl(readByte(i));
    }

    public Uint8ClampedArray(JavaScriptTypedArray rawArray) {
        Intrinsics.checkNotNullParameter(rawArray, "rawArray");
        this.rawArray = rawArray;
    }

    @Override // expo.modules.kotlin.typedarray.GenericTypedArray
    public /* bridge */ /* synthetic */ Object get(int i) {
        return UByte.m5252boximpl(m4938getWa3L5BU(i));
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
