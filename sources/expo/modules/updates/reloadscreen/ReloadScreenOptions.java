package expo.modules.updates.reloadscreen;

import com.opentok.android.PublisherKit;
import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\r\u0010\u000eJ\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0010\u0010%\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u001bJ\u0010\u0010&\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u001bJ\u000b\u0010'\u001a\u0004\u0018\u00010\fHÆ\u0003JV\u0010(\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fHÆ\u0001¢\u0006\u0002\u0010)J\u0013\u0010*\u001a\u00020\t2\b\u0010+\u001a\u0004\u0018\u00010,HÖ\u0003J\t\u0010-\u001a\u00020.HÖ\u0001J\t\u0010/\u001a\u00020\u0003HÖ\u0001R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0013\u0010\u0010\u001a\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0016\u0010\u0010\u001a\u0004\b\u0017\u0010\u0018R \u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u001c\u0012\u0004\b\u0019\u0010\u0010\u001a\u0004\b\u001a\u0010\u001bR \u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u001c\u0012\u0004\b\u001d\u0010\u0010\u001a\u0004\b\u001e\u0010\u001bR\u001e\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001f\u0010\u0010\u001a\u0004\b \u0010!¨\u00060"}, d2 = {"Lexpo/modules/updates/reloadscreen/ReloadScreenOptions;", "Lexpo/modules/kotlin/records/Record;", "backgroundColor", "", "image", "Lexpo/modules/updates/reloadscreen/ReloadScreenImageSource;", "imageResizeMode", "Lexpo/modules/updates/reloadscreen/ImageResizeMode;", "imageFullScreen", "", "fade", "spinner", "Lexpo/modules/updates/reloadscreen/SpinnerOptions;", "<init>", "(Ljava/lang/String;Lexpo/modules/updates/reloadscreen/ReloadScreenImageSource;Lexpo/modules/updates/reloadscreen/ImageResizeMode;Ljava/lang/Boolean;Ljava/lang/Boolean;Lexpo/modules/updates/reloadscreen/SpinnerOptions;)V", "getBackgroundColor$annotations", "()V", "getBackgroundColor", "()Ljava/lang/String;", "getImage$annotations", "getImage", "()Lexpo/modules/updates/reloadscreen/ReloadScreenImageSource;", "getImageResizeMode$annotations", "getImageResizeMode", "()Lexpo/modules/updates/reloadscreen/ImageResizeMode;", "getImageFullScreen$annotations", "getImageFullScreen", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getFade$annotations", "getFade", "getSpinner$annotations", "getSpinner", "()Lexpo/modules/updates/reloadscreen/SpinnerOptions;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/String;Lexpo/modules/updates/reloadscreen/ReloadScreenImageSource;Lexpo/modules/updates/reloadscreen/ImageResizeMode;Ljava/lang/Boolean;Ljava/lang/Boolean;Lexpo/modules/updates/reloadscreen/SpinnerOptions;)Lexpo/modules/updates/reloadscreen/ReloadScreenOptions;", "equals", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "hashCode", "", "toString", "expo-updates_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class ReloadScreenOptions implements Record {
    private final String backgroundColor;
    private final Boolean fade;
    private final ReloadScreenImageSource image;
    private final Boolean imageFullScreen;
    private final ImageResizeMode imageResizeMode;
    private final SpinnerOptions spinner;

    public static /* synthetic */ ReloadScreenOptions copy$default(ReloadScreenOptions reloadScreenOptions, String str, ReloadScreenImageSource reloadScreenImageSource, ImageResizeMode imageResizeMode, Boolean bool, Boolean bool2, SpinnerOptions spinnerOptions, int i, Object obj) {
        if ((i & 1) != 0) {
            str = reloadScreenOptions.backgroundColor;
        }
        if ((i & 2) != 0) {
            reloadScreenImageSource = reloadScreenOptions.image;
        }
        if ((i & 4) != 0) {
            imageResizeMode = reloadScreenOptions.imageResizeMode;
        }
        if ((i & 8) != 0) {
            bool = reloadScreenOptions.imageFullScreen;
        }
        if ((i & 16) != 0) {
            bool2 = reloadScreenOptions.fade;
        }
        if ((i & 32) != 0) {
            spinnerOptions = reloadScreenOptions.spinner;
        }
        Boolean bool3 = bool2;
        SpinnerOptions spinnerOptions2 = spinnerOptions;
        return reloadScreenOptions.copy(str, reloadScreenImageSource, imageResizeMode, bool, bool3, spinnerOptions2);
    }

    @Field
    public static /* synthetic */ void getBackgroundColor$annotations() {
    }

    @Field
    public static /* synthetic */ void getFade$annotations() {
    }

    @Field
    public static /* synthetic */ void getImage$annotations() {
    }

    @Field
    public static /* synthetic */ void getImageFullScreen$annotations() {
    }

    @Field
    public static /* synthetic */ void getImageResizeMode$annotations() {
    }

    @Field
    public static /* synthetic */ void getSpinner$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getBackgroundColor() {
        return this.backgroundColor;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final ReloadScreenImageSource getImage() {
        return this.image;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final ImageResizeMode getImageResizeMode() {
        return this.imageResizeMode;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Boolean getImageFullScreen() {
        return this.imageFullScreen;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Boolean getFade() {
        return this.fade;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final SpinnerOptions getSpinner() {
        return this.spinner;
    }

    public final ReloadScreenOptions copy(String backgroundColor, ReloadScreenImageSource image, ImageResizeMode imageResizeMode, Boolean imageFullScreen, Boolean fade, SpinnerOptions spinner) {
        return new ReloadScreenOptions(backgroundColor, image, imageResizeMode, imageFullScreen, fade, spinner);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ReloadScreenOptions)) {
            return false;
        }
        ReloadScreenOptions reloadScreenOptions = (ReloadScreenOptions) other;
        return Intrinsics.areEqual(this.backgroundColor, reloadScreenOptions.backgroundColor) && Intrinsics.areEqual(this.image, reloadScreenOptions.image) && this.imageResizeMode == reloadScreenOptions.imageResizeMode && Intrinsics.areEqual(this.imageFullScreen, reloadScreenOptions.imageFullScreen) && Intrinsics.areEqual(this.fade, reloadScreenOptions.fade) && Intrinsics.areEqual(this.spinner, reloadScreenOptions.spinner);
    }

    public int hashCode() {
        String str = this.backgroundColor;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        ReloadScreenImageSource reloadScreenImageSource = this.image;
        int iHashCode2 = (iHashCode + (reloadScreenImageSource == null ? 0 : reloadScreenImageSource.hashCode())) * 31;
        ImageResizeMode imageResizeMode = this.imageResizeMode;
        int iHashCode3 = (iHashCode2 + (imageResizeMode == null ? 0 : imageResizeMode.hashCode())) * 31;
        Boolean bool = this.imageFullScreen;
        int iHashCode4 = (iHashCode3 + (bool == null ? 0 : bool.hashCode())) * 31;
        Boolean bool2 = this.fade;
        int iHashCode5 = (iHashCode4 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        SpinnerOptions spinnerOptions = this.spinner;
        return iHashCode5 + (spinnerOptions != null ? spinnerOptions.hashCode() : 0);
    }

    public String toString() {
        return "ReloadScreenOptions(backgroundColor=" + this.backgroundColor + ", image=" + this.image + ", imageResizeMode=" + this.imageResizeMode + ", imageFullScreen=" + this.imageFullScreen + ", fade=" + this.fade + ", spinner=" + this.spinner + ")";
    }

    public ReloadScreenOptions(String str, ReloadScreenImageSource reloadScreenImageSource, ImageResizeMode imageResizeMode, Boolean bool, Boolean bool2, SpinnerOptions spinnerOptions) {
        this.backgroundColor = str;
        this.image = reloadScreenImageSource;
        this.imageResizeMode = imageResizeMode;
        this.imageFullScreen = bool;
        this.fade = bool2;
        this.spinner = spinnerOptions;
    }

    public final String getBackgroundColor() {
        return this.backgroundColor;
    }

    public final ReloadScreenImageSource getImage() {
        return this.image;
    }

    public final ImageResizeMode getImageResizeMode() {
        return this.imageResizeMode;
    }

    public final Boolean getImageFullScreen() {
        return this.imageFullScreen;
    }

    public final Boolean getFade() {
        return this.fade;
    }

    public final SpinnerOptions getSpinner() {
        return this.spinner;
    }
}
