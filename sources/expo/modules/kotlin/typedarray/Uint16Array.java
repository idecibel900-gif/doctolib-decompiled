package expo.modules.kotlin.typedarray;

import expo.modules.kotlin.jni.JavaScriptTypedArray;
import java.nio.ByteBuffer;
import java.util.Iterator;
import kotlin.UShort;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class Uint16Array implements TypedArray, GenericTypedArray, RawTypedArrayHolder {
    private final JavaScriptTypedArray rawArray;

    @Override // expo.modules.kotlin.typedarray.TypedArray
    public int getLength() {
        return this.rawArray.getLength();
    }

    public short read2Byte(int i) {
        return this.rawArray.read2Byte(i);
    }

    @Override // expo.modules.kotlin.typedarray.TypedArray
    public ByteBuffer toDirectBuffer() {
        return this.rawArray.toDirectBuffer();
    }

    /* JADX INFO: renamed from: get-BwKQO78, reason: not valid java name */
    public short m4935getBwKQO78(int i) {
        if (i < 0 || i >= getLength()) {
            throw new IndexOutOfBoundsException();
        }
        return UShort.m5320constructorimpl(read2Byte(i * 2));
    }

    public Uint16Array(JavaScriptTypedArray rawArray) {
        Intrinsics.checkNotNullParameter(rawArray, "rawArray");
        this.rawArray = rawArray;
    }

    @Override // expo.modules.kotlin.typedarray.GenericTypedArray
    public /* bridge */ /* synthetic */ Object get(int i) {
        return UShort.m5319boximpl(m4935getBwKQO78(i));
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
