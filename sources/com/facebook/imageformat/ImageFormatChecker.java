package com.facebook.imageformat;

import com.facebook.common.internal.ByteStreams;
import com.facebook.common.internal.Throwables;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class ImageFormatChecker {
    public static final Companion Companion = new Companion(null);
    private static final Lazy instance$delegate = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, new Function0() { // from class: com.facebook.imageformat.ImageFormatChecker$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return ImageFormatChecker.instance_delegate$lambda$2();
        }
    });
    private boolean binaryXmlEnabled;
    private List customImageFormatCheckers;
    private final DefaultImageFormatChecker defaultFormatChecker = new DefaultImageFormatChecker();
    private int maxHeaderLength;

    public static final ImageFormat getImageFormat_WrapIOException(InputStream inputStream) {
        return Companion.getImageFormat_WrapIOException(inputStream);
    }

    public static final ImageFormatChecker getInstance() {
        return Companion.getInstance();
    }

    private ImageFormatChecker() {
        updateMaxHeaderLength();
    }

    public final ImageFormatChecker setBinaryXmlEnabled(boolean z) {
        this.binaryXmlEnabled = z;
        return this;
    }

    public final ImageFormat determineImageFormat(InputStream is) throws IOException {
        Intrinsics.checkNotNullParameter(is, "is");
        int i = this.maxHeaderLength;
        byte[] bArr = new byte[i];
        int headerFromStream = Companion.readHeaderFromStream(i, is, bArr);
        ImageFormat imageFormatDetermineFormat = this.defaultFormatChecker.determineFormat(bArr, headerFromStream);
        if (Intrinsics.areEqual(imageFormatDetermineFormat, DefaultImageFormats.BINARY_XML) && !this.binaryXmlEnabled) {
            imageFormatDetermineFormat = ImageFormat.UNKNOWN;
        }
        if (imageFormatDetermineFormat != ImageFormat.UNKNOWN) {
            return imageFormatDetermineFormat;
        }
        List list = this.customImageFormatCheckers;
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ImageFormat imageFormatDetermineFormat2 = ((ImageFormat.FormatChecker) it.next()).determineFormat(bArr, headerFromStream);
                if (imageFormatDetermineFormat2 != ImageFormat.UNKNOWN) {
                    return imageFormatDetermineFormat2;
                }
            }
        }
        return ImageFormat.UNKNOWN;
    }

    private final void updateMaxHeaderLength() {
        this.maxHeaderLength = this.defaultFormatChecker.getHeaderSize();
        List list = this.customImageFormatCheckers;
        if (list != null) {
            Intrinsics.checkNotNull(list);
            Iterator it = list.iterator();
            while (it.hasNext()) {
                this.maxHeaderLength = Math.max(this.maxHeaderLength, ((ImageFormat.FormatChecker) it.next()).getHeaderSize());
            }
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int readHeaderFromStream(int i, InputStream inputStream, byte[] bArr) throws IOException {
            if (bArr.length < i) {
                throw new IllegalStateException("Check failed.");
            }
            if (inputStream.markSupported()) {
                try {
                    inputStream.mark(i);
                    return ByteStreams.read(inputStream, bArr, 0, i);
                } finally {
                    inputStream.reset();
                }
            }
            return ByteStreams.read(inputStream, bArr, 0, i);
        }

        public final ImageFormatChecker getInstance() {
            return (ImageFormatChecker) ImageFormatChecker.instance$delegate.getValue();
        }

        public final ImageFormat getImageFormat(InputStream is) {
            Intrinsics.checkNotNullParameter(is, "is");
            return getInstance().determineImageFormat(is);
        }

        public final ImageFormat getImageFormat_WrapIOException(InputStream is) {
            Intrinsics.checkNotNullParameter(is, "is");
            try {
                return getImageFormat(is);
            } catch (IOException e) {
                throw Throwables.propagate(e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ImageFormatChecker instance_delegate$lambda$2() {
        return new ImageFormatChecker();
    }
}
