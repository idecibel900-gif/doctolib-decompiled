package expo.modules.kotlin.typedarray;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes4.dex */
public interface TypedArray {
    int getLength();

    ByteBuffer toDirectBuffer();
}
