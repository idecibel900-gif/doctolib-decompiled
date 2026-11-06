package com.facebook.react.modules.network;

import com.facebook.common.logging.FLog;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class ProgressiveStringDecoder {
    public static final Companion Companion = new Companion(null);
    private final CharsetDecoder decoder;
    private byte[] remainder;

    public ProgressiveStringDecoder(Charset charset) {
        Intrinsics.checkNotNullParameter(charset, "charset");
        CharsetDecoder charsetDecoderNewDecoder = charset.newDecoder();
        Intrinsics.checkNotNullExpressionValue(charsetDecoderNewDecoder, "newDecoder(...)");
        this.decoder = charsetDecoderNewDecoder;
    }

    public final String decodeNext(byte[] data, int i) {
        Intrinsics.checkNotNullParameter(data, "data");
        byte[] bArr = this.remainder;
        if (bArr != null) {
            byte[] bArr2 = new byte[bArr.length + i];
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            System.arraycopy(data, 0, bArr2, bArr.length, i);
            i += bArr.length;
            data = bArr2;
        }
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(data, 0, i);
        byte[] bArr3 = null;
        boolean z = false;
        int i2 = 0;
        CharBuffer charBufferDecode = null;
        while (!z && i2 < 4) {
            try {
                charBufferDecode = this.decoder.decode(byteBufferWrap);
                z = true;
            } catch (CharacterCodingException unused) {
                i2++;
                byteBufferWrap = ByteBuffer.wrap(data, 0, i - i2);
            }
        }
        if (z && i2 > 0) {
            bArr3 = new byte[i2];
            System.arraycopy(data, i - i2, bArr3, 0, i2);
        }
        this.remainder = bArr3;
        if (!z) {
            FLog.w("ReactNative", "failed to decode string from byte array");
            return "";
        }
        if (charBufferDecode == null) {
            return "";
        }
        char[] cArrArray = charBufferDecode.array();
        Intrinsics.checkNotNullExpressionValue(cArrArray, "array(...)");
        return new String(cArrArray, 0, charBufferDecode.length());
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
