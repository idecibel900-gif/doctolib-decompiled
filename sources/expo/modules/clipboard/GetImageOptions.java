package expo.modules.clipboard;

import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R$\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0006\u0010\u0003\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR$\u0010\u000b\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\r\u0010\u0003\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lexpo/modules/clipboard/GetImageOptions;", "Lexpo/modules/kotlin/records/Record;", "<init>", "()V", "imageFormat", "Lexpo/modules/clipboard/ImageFormat;", "getImageFormat$annotations", "getImageFormat", "()Lexpo/modules/clipboard/ImageFormat;", "setImageFormat", "(Lexpo/modules/clipboard/ImageFormat;)V", "jpegQuality", "", "getJpegQuality$annotations", "getJpegQuality", "()D", "setJpegQuality", "(D)V", "expo-clipboard_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GetImageOptions implements Record {
    private ImageFormat imageFormat = ImageFormat.JPG;
    private double jpegQuality = 1.0d;

    @Field(key = "format")
    public static /* synthetic */ void getImageFormat$annotations() {
    }

    @Field
    public static /* synthetic */ void getJpegQuality$annotations() {
    }

    public final ImageFormat getImageFormat() {
        return this.imageFormat;
    }

    public final void setImageFormat(ImageFormat imageFormat) {
        Intrinsics.checkNotNullParameter(imageFormat, "<set-?>");
        this.imageFormat = imageFormat;
    }

    public final double getJpegQuality() {
        return this.jpegQuality;
    }

    public final void setJpegQuality(double d) {
        this.jpegQuality = d;
    }
}
