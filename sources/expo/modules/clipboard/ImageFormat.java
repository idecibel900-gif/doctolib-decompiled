package expo.modules.clipboard;

import android.graphics.Bitmap;
import expo.modules.kotlin.types.Enumerable;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0080\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u000b\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\bj\u0002\b\tj\u0002\b\n¨\u0006\u0011"}, d2 = {"Lexpo/modules/clipboard/ImageFormat;", "Lexpo/modules/kotlin/types/Enumerable;", "", "jsName", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getJsName", "()Ljava/lang/String;", "JPG", "PNG", "compressFormat", "Landroid/graphics/Bitmap$CompressFormat;", "getCompressFormat", "()Landroid/graphics/Bitmap$CompressFormat;", "mimeType", "getMimeType", "expo-clipboard_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public enum ImageFormat implements Enumerable {
    JPG("jpeg"),
    PNG("png");

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    private final String jsName;

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ImageFormat.values().length];
            try {
                iArr[ImageFormat.JPG.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ImageFormat.PNG.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static EnumEntries getEntries() {
        return $ENTRIES;
    }

    ImageFormat(String str) {
        this.jsName = str;
    }

    public final String getJsName() {
        return this.jsName;
    }

    public final Bitmap.CompressFormat getCompressFormat() {
        int i = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        if (i == 1) {
            return Bitmap.CompressFormat.JPEG;
        }
        if (i != 2) {
            throw new NoWhenBranchMatchedException();
        }
        return Bitmap.CompressFormat.PNG;
    }

    public final String getMimeType() {
        int i = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        if (i == 1) {
            return "image/jpeg";
        }
        if (i != 2) {
            throw new NoWhenBranchMatchedException();
        }
        return "image/png";
    }
}
