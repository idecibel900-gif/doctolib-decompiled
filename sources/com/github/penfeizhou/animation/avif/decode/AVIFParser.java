package com.github.penfeizhou.animation.avif.decode;

import com.github.penfeizhou.animation.avif.io.AVIFReader;
import com.github.penfeizhou.animation.io.Reader;
import java.io.IOException;
import org.aomedia.avif.android.AvifDecoder;

/* JADX INFO: loaded from: classes3.dex */
public abstract class AVIFParser {
    public static boolean isAVIF(Reader reader) {
        try {
            return AvifDecoder.isAvifImage((reader instanceof AVIFReader ? (AVIFReader) reader : new AVIFReader(reader)).toDirectByteBuffer());
        } catch (IOException unused) {
            return false;
        }
    }
}
