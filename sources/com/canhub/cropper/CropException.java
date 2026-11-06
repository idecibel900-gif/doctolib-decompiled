package com.canhub.cropper;

import android.net.Uri;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public abstract class CropException extends Exception {
    public static final Companion Companion = new Companion(null);

    public /* synthetic */ CropException(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }

    private CropException(String str) {
        super(str);
    }

    public static final class FailedToLoadBitmap extends CropException {
        public static final Companion Companion = new Companion(null);

        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FailedToLoadBitmap(Uri uri, String str) {
            super("crop: Failed to load sampled bitmap: " + uri + "\r\n" + str, null);
            Intrinsics.checkNotNullParameter(uri, "uri");
        }
    }

    public static final class FailedToDecodeImage extends CropException {
        public static final Companion Companion = new Companion(null);

        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FailedToDecodeImage(Uri uri) {
            super("crop: Failed to decode image: " + uri, null);
            Intrinsics.checkNotNullParameter(uri, "uri");
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
