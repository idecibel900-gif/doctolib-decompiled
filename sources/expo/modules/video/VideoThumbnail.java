package expo.modules.video;

import android.graphics.Bitmap;
import expo.modules.kotlin.sharedobjects.SharedRef;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0017\u001a\u00020\u000eH\u0016R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0006\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\f\u0010\nR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0014\u0010\u0013\u001a\u00020\u0014X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0018"}, d2 = {"Lexpo/modules/video/VideoThumbnail;", "Lexpo/modules/kotlin/sharedobjects/SharedRef;", "Landroid/graphics/Bitmap;", "ref", "requestedTime", "Lkotlin/time/Duration;", "actualTime", "<init>", "(Landroid/graphics/Bitmap;JJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getRequestedTime-UwyO8pc", "()J", "J", "getActualTime-UwyO8pc", "width", "", "getWidth", "()I", "height", "getHeight", "nativeRefType", "", "getNativeRefType", "()Ljava/lang/String;", "getAdditionalMemoryPressure", "expo-video_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VideoThumbnail extends SharedRef<Bitmap> {
    private final long actualTime;
    private final int height;
    private final String nativeRefType;
    private final long requestedTime;
    private final int width;

    public /* synthetic */ VideoThumbnail(Bitmap bitmap, long j, long j2, DefaultConstructorMarker defaultConstructorMarker) {
        this(bitmap, j, j2);
    }

    /* JADX INFO: renamed from: getRequestedTime-UwyO8pc, reason: not valid java name and from getter */
    public final long getRequestedTime() {
        return this.requestedTime;
    }

    /* JADX INFO: renamed from: getActualTime-UwyO8pc, reason: not valid java name and from getter */
    public final long getActualTime() {
        return this.actualTime;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private VideoThumbnail(Bitmap ref, long j, long j2) {
        super(ref, null, 2, null);
        Intrinsics.checkNotNullParameter(ref, "ref");
        this.requestedTime = j;
        this.actualTime = j2;
        this.width = ref.getWidth();
        this.height = ref.getHeight();
        this.nativeRefType = "image";
    }

    public final int getWidth() {
        return this.width;
    }

    public final int getHeight() {
        return this.height;
    }

    @Override // expo.modules.kotlin.sharedobjects.SharedRef
    public String getNativeRefType() {
        return this.nativeRefType;
    }

    @Override // expo.modules.kotlin.sharedobjects.SharedObject
    public int getAdditionalMemoryPressure() {
        return ((Bitmap) getRef()).getByteCount();
    }
}
