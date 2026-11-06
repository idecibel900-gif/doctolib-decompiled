package expo.modules.kotlin.jni;

import com.facebook.jni.HybridData;
import expo.modules.kotlin.typedarray.TypedArray;
import java.nio.ByteBuffer;
import java.util.NoSuchElementException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007H\u0082 ¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nH\u0096 ¢\u0006\u0004\b\u000b\u0010\fJ(\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0007H\u0096 ¢\u0006\u0004\b\u0012\u0010\u0013J(\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0007H\u0096 ¢\u0006\u0004\b\u0014\u0010\u0013J\u0018\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u000f\u001a\u00020\u0007H\u0096 ¢\u0006\u0004\b\u0016\u0010\u0017J\u0018\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u000f\u001a\u00020\u0007H\u0096 ¢\u0006\u0004\b\u0019\u0010\u001aJ\u0018\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0007H\u0096 ¢\u0006\u0004\b\u001b\u0010\u001cJ\u0018\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u000f\u001a\u00020\u0007H\u0096 ¢\u0006\u0004\b\u001e\u0010\u001fJ\u0018\u0010!\u001a\u00020 2\u0006\u0010\u000f\u001a\u00020\u0007H\u0096 ¢\u0006\u0004\b!\u0010\"J\u0018\u0010$\u001a\u00020#2\u0006\u0010\u000f\u001a\u00020\u0007H\u0096 ¢\u0006\u0004\b$\u0010%J \u0010'\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\u0015H\u0096 ¢\u0006\u0004\b'\u0010(J \u0010)\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\u0018H\u0096 ¢\u0006\u0004\b)\u0010*J \u0010+\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\u0007H\u0096 ¢\u0006\u0004\b+\u0010,J \u0010-\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\u001dH\u0096 ¢\u0006\u0004\b-\u0010.J \u0010/\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010&\u001a\u00020 H\u0096 ¢\u0006\u0004\b/\u00100J \u00101\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010&\u001a\u00020#H\u0096 ¢\u0006\u0004\b1\u00102R\u001b\u00108\u001a\u0002038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u00107R\u001b\u0010;\u001a\u00020\u00078VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b9\u00105\u001a\u0004\b:\u0010\tR\u001b\u0010>\u001a\u00020\u00078VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b<\u00105\u001a\u0004\b=\u0010\tR\u001b\u0010A\u001a\u00020\u00078VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b?\u00105\u001a\u0004\b@\u0010\t¨\u0006B"}, d2 = {"Lexpo/modules/kotlin/jni/JavaScriptTypedArray;", "Lexpo/modules/kotlin/jni/JavaScriptObject;", "Lexpo/modules/kotlin/typedarray/TypedArray;", "Lcom/facebook/jni/HybridData;", "hybridData", "<init>", "(Lcom/facebook/jni/HybridData;)V", "", "getRawKind", "()I", "Ljava/nio/ByteBuffer;", "toDirectBuffer", "()Ljava/nio/ByteBuffer;", "", "buffer", "position", "size", "", "read", "([BII)V", "write", "", "readByte", "(I)B", "", "read2Byte", "(I)S", "read4Byte", "(I)I", "", "read8Byte", "(I)J", "", "readFloat", "(I)F", "", "readDouble", "(I)D", "value", "writeByte", "(IB)V", "write2Byte", "(IS)V", "write4Byte", "(II)V", "write8Byte", "(IJ)V", "writeFloat", "(IF)V", "writeDouble", "(ID)V", "Lexpo/modules/kotlin/jni/TypedArrayKind;", "kind$delegate", "Lkotlin/Lazy;", "getKind", "()Lexpo/modules/kotlin/jni/TypedArrayKind;", "kind", "length$delegate", "getLength", "length", "byteLength$delegate", "getByteLength", "byteLength", "byteOffset$delegate", "getByteOffset", "byteOffset", "expo-modules-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class JavaScriptTypedArray extends JavaScriptObject implements TypedArray {

    /* JADX INFO: renamed from: byteLength$delegate, reason: from kotlin metadata */
    private final Lazy byteLength;

    /* JADX INFO: renamed from: byteOffset$delegate, reason: from kotlin metadata */
    private final Lazy byteOffset;

    /* JADX INFO: renamed from: kind$delegate, reason: from kotlin metadata */
    private final Lazy kind;

    /* JADX INFO: renamed from: length$delegate, reason: from kotlin metadata */
    private final Lazy length;

    private final native int getRawKind();

    public native void read(byte[] buffer, int position, int size);

    public native short read2Byte(int position);

    public native int read4Byte(int position);

    public native long read8Byte(int position);

    public native byte readByte(int position);

    public native double readDouble(int position);

    public native float readFloat(int position);

    @Override // expo.modules.kotlin.typedarray.TypedArray
    public native ByteBuffer toDirectBuffer();

    public native void write(byte[] buffer, int position, int size);

    public native void write2Byte(int position, short value);

    public native void write4Byte(int position, int value);

    public native void write8Byte(int position, long value);

    public native void writeByte(int position, byte value);

    public native void writeDouble(int position, double value);

    public native void writeFloat(int position, float value);

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JavaScriptTypedArray(HybridData hybridData) {
        super(hybridData);
        Intrinsics.checkNotNullParameter(hybridData, "hybridData");
        this.kind = LazyKt.lazy(new Function0() { // from class: expo.modules.kotlin.jni.JavaScriptTypedArray$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return JavaScriptTypedArray.kind_delegate$lambda$1(this.f$0);
            }
        });
        this.length = LazyKt.lazy(new Function0() { // from class: expo.modules.kotlin.jni.JavaScriptTypedArray$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Integer.valueOf(JavaScriptTypedArray.length_delegate$lambda$2(this.f$0));
            }
        });
        this.byteLength = LazyKt.lazy(new Function0() { // from class: expo.modules.kotlin.jni.JavaScriptTypedArray$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Integer.valueOf(JavaScriptTypedArray.byteLength_delegate$lambda$3(this.f$0));
            }
        });
        this.byteOffset = LazyKt.lazy(new Function0() { // from class: expo.modules.kotlin.jni.JavaScriptTypedArray$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Integer.valueOf(JavaScriptTypedArray.byteOffset_delegate$lambda$4(this.f$0));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TypedArrayKind kind_delegate$lambda$1(JavaScriptTypedArray javaScriptTypedArray) {
        int rawKind = javaScriptTypedArray.getRawKind();
        for (TypedArrayKind typedArrayKind : TypedArrayKind.getEntries()) {
            if (typedArrayKind.getValue() == rawKind) {
                return typedArrayKind;
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    @Override // expo.modules.kotlin.typedarray.TypedArray
    public int getLength() {
        return ((Number) this.length.getValue()).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int length_delegate$lambda$2(JavaScriptTypedArray javaScriptTypedArray) {
        return (int) javaScriptTypedArray.getProperty("length").getDouble();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int byteLength_delegate$lambda$3(JavaScriptTypedArray javaScriptTypedArray) {
        return (int) javaScriptTypedArray.getProperty("byteLength").getDouble();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int byteOffset_delegate$lambda$4(JavaScriptTypedArray javaScriptTypedArray) {
        return (int) javaScriptTypedArray.getProperty("byteOffset").getDouble();
    }
}
