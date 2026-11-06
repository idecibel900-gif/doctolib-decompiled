package expo.modules.kotlin.jni;

import com.facebook.jni.HybridData;
import expo.modules.kotlin.exception.Exceptions$IllegalArgument;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\b\b\u0007\u0018\u0000 +2\u00020\u00012\u00020\u0002:\u0001+B\u0011\b\u0013\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006B\u0011\b\u0016\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u0005\u0010\tJ\u0018\u0010\u000b\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0007H\u0082 ¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rH\u0096 ¢\u0006\u0004\b\u000e\u0010\u000fJ\u0018\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\rH\u0096 ¢\u0006\u0004\b\u0012\u0010\u0013J\u0018\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0010\u001a\u00020\rH\u0096 ¢\u0006\u0004\b\u0015\u0010\u0016J\u0018\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\rH\u0096 ¢\u0006\u0004\b\u0017\u0010\u0018J\u0018\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0010\u001a\u00020\rH\u0096 ¢\u0006\u0004\b\u001a\u0010\u001bJ\u0018\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0010\u001a\u00020\rH\u0096 ¢\u0006\u0004\b\u001d\u0010\u001eJ\u0018\u0010 \u001a\u00020\u001f2\u0006\u0010\u0010\u001a\u00020\rH\u0096 ¢\u0006\u0004\b \u0010!J\u0010\u0010\"\u001a\u00020\u0007H\u0096 ¢\u0006\u0004\b\"\u0010#J\u000f\u0010%\u001a\u00020$H\u0004¢\u0006\u0004\b%\u0010&J\u000f\u0010'\u001a\u00020\u0003H\u0016¢\u0006\u0004\b'\u0010(R\u0014\u0010)\u001a\u00020\u00038\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b)\u0010*¨\u0006,"}, d2 = {"Lexpo/modules/kotlin/jni/NativeArrayBuffer;", "Lexpo/modules/kotlin/jni/Destructible;", "", "Lcom/facebook/jni/HybridData;", "hybridData", "<init>", "(Lcom/facebook/jni/HybridData;)V", "Ljava/nio/ByteBuffer;", "byteBuffer", "(Ljava/nio/ByteBuffer;)V", "buffer", "initHybrid", "(Ljava/nio/ByteBuffer;)Lcom/facebook/jni/HybridData;", "", "size", "()I", "position", "", "readByte", "(I)B", "", "read2Byte", "(I)S", "read4Byte", "(I)I", "", "read8Byte", "(I)J", "", "readFloat", "(I)F", "", "readDouble", "(I)D", "toDirectBuffer", "()Ljava/nio/ByteBuffer;", "", "finalize", "()V", "getHybridDataForJNIDeallocator", "()Lcom/facebook/jni/HybridData;", "mHybridData", "Lcom/facebook/jni/HybridData;", "Companion", "expo-modules-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NativeArrayBuffer implements Destructible {
    private final HybridData mHybridData;

    private final native HybridData initHybrid(ByteBuffer buffer);

    public native short read2Byte(int position);

    public native int read4Byte(int position);

    public native long read8Byte(int position);

    public native byte readByte(int position);

    public native double readDouble(int position);

    public native float readFloat(int position);

    public native int size();

    public native ByteBuffer toDirectBuffer();

    private NativeArrayBuffer(HybridData hybridData) {
        this.mHybridData = hybridData;
    }

    public NativeArrayBuffer(ByteBuffer byteBuffer) throws Exceptions$IllegalArgument {
        Intrinsics.checkNotNullParameter(byteBuffer, "byteBuffer");
        if (!byteBuffer.isDirect()) {
            throw new Exceptions$IllegalArgument("ArrayBuffers can only be created from direct ByteBuffers", null, 2, null);
        }
        this.mHybridData = initHybrid(byteBuffer);
    }

    protected final void finalize() {
        this.mHybridData.resetNative();
    }

    @Override // expo.modules.kotlin.jni.Destructible
    /* JADX INFO: renamed from: getHybridDataForJNIDeallocator, reason: from getter */
    public HybridData getMHybridData() {
        return this.mHybridData;
    }
}
