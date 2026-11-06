package expo.modules.video.records;

import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0014\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000fR \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u000b\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u000b\u0012\u0004\b\f\u0010\b\u001a\u0004\b\r\u0010\n¨\u0006\u0010"}, d2 = {"Lexpo/modules/video/records/VideoThumbnailOptions;", "Lexpo/modules/kotlin/records/Record;", "maxWidth", "", "maxHeight", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;)V", "getMaxWidth$annotations", "()V", "getMaxWidth", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getMaxHeight$annotations", "getMaxHeight", "toNativeSizeLimit", "Lkotlin/Pair;", "expo-video_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VideoThumbnailOptions implements Record {
    private final Integer maxHeight;
    private final Integer maxWidth;

    /* JADX WARN: Multi-variable type inference failed */
    public VideoThumbnailOptions() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    @Field
    public static /* synthetic */ void getMaxHeight$annotations() {
    }

    @Field
    public static /* synthetic */ void getMaxWidth$annotations() {
    }

    public VideoThumbnailOptions(Integer num, Integer num2) {
        this.maxWidth = num;
        this.maxHeight = num2;
    }

    public /* synthetic */ VideoThumbnailOptions(Integer num, Integer num2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : num2);
    }

    public final Integer getMaxWidth() {
        return this.maxWidth;
    }

    public final Integer getMaxHeight() {
        return this.maxHeight;
    }

    public final Pair<Integer, Integer> toNativeSizeLimit() {
        Integer num = this.maxWidth;
        if (num == null && this.maxHeight == null) {
            return null;
        }
        int iIntValue = num != null ? num.intValue() : Integer.MAX_VALUE;
        Integer num2 = this.maxHeight;
        int iIntValue2 = num2 != null ? num2.intValue() : Integer.MAX_VALUE;
        if (iIntValue < 1 || iIntValue2 < 1) {
            throw new IllegalArgumentException("Failed to generate a thumbnail: The maxWidth and maxHeight parameters must be greater than zero");
        }
        return TuplesKt.to(Integer.valueOf(iIntValue), Integer.valueOf(iIntValue2));
    }
}
