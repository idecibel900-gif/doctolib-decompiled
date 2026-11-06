package expo.modules.video.records;

import com.opentok.android.PublisherKit;
import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b)\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BY\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\u0010\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0019J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J`\u0010)\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u0003HÆ\u0001¢\u0006\u0002\u0010*J\u0013\u0010+\u001a\u00020\u00032\b\u0010,\u001a\u0004\u0018\u00010-HÖ\u0003J\t\u0010.\u001a\u00020/HÖ\u0001J\t\u00100\u001a\u000201HÖ\u0001R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0012\u0010\u0010R\u001c\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010R\u001c\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0015\u0010\u000e\u001a\u0004\b\u0016\u0010\u0010R \u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u001a\u0012\u0004\b\u0017\u0010\u000e\u001a\u0004\b\u0018\u0010\u0019R\u001c\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001b\u0010\u000e\u001a\u0004\b\u001c\u0010\u0010R\u001c\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001d\u0010\u000e\u001a\u0004\b\u001e\u0010\u0010R\u001c\u0010\n\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001f\u0010\u000e\u001a\u0004\b \u0010\u0010¨\u00062"}, d2 = {"Lexpo/modules/video/records/ButtonOptions;", "Lexpo/modules/kotlin/records/Record;", "showNext", "", "showPrevious", "showSeekForward", "showSeekBackward", "showSubtitles", "showSettings", "showPlayPause", "showBottomBar", "<init>", "(ZZZZLjava/lang/Boolean;ZZZ)V", "getShowNext$annotations", "()V", "getShowNext", "()Z", "getShowPrevious$annotations", "getShowPrevious", "getShowSeekForward$annotations", "getShowSeekForward", "getShowSeekBackward$annotations", "getShowSeekBackward", "getShowSubtitles$annotations", "getShowSubtitles", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getShowSettings$annotations", "getShowSettings", "getShowPlayPause$annotations", "getShowPlayPause", "getShowBottomBar$annotations", "getShowBottomBar", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(ZZZZLjava/lang/Boolean;ZZZ)Lexpo/modules/video/records/ButtonOptions;", "equals", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "hashCode", "", "toString", "", "expo-video_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class ButtonOptions implements Record {
    private final boolean showBottomBar;
    private final boolean showNext;
    private final boolean showPlayPause;
    private final boolean showPrevious;
    private final boolean showSeekBackward;
    private final boolean showSeekForward;
    private final boolean showSettings;
    private final Boolean showSubtitles;

    public ButtonOptions() {
        this(false, false, false, false, null, false, false, false, 255, null);
    }

    public static /* synthetic */ ButtonOptions copy$default(ButtonOptions buttonOptions, boolean z, boolean z2, boolean z3, boolean z4, Boolean bool, boolean z5, boolean z6, boolean z7, int i, Object obj) {
        if ((i & 1) != 0) {
            z = buttonOptions.showNext;
        }
        if ((i & 2) != 0) {
            z2 = buttonOptions.showPrevious;
        }
        if ((i & 4) != 0) {
            z3 = buttonOptions.showSeekForward;
        }
        if ((i & 8) != 0) {
            z4 = buttonOptions.showSeekBackward;
        }
        if ((i & 16) != 0) {
            bool = buttonOptions.showSubtitles;
        }
        if ((i & 32) != 0) {
            z5 = buttonOptions.showSettings;
        }
        if ((i & 64) != 0) {
            z6 = buttonOptions.showPlayPause;
        }
        if ((i & 128) != 0) {
            z7 = buttonOptions.showBottomBar;
        }
        boolean z8 = z6;
        boolean z9 = z7;
        Boolean bool2 = bool;
        boolean z10 = z5;
        return buttonOptions.copy(z, z2, z3, z4, bool2, z10, z8, z9);
    }

    @Field
    public static /* synthetic */ void getShowBottomBar$annotations() {
    }

    @Field
    public static /* synthetic */ void getShowNext$annotations() {
    }

    @Field
    public static /* synthetic */ void getShowPlayPause$annotations() {
    }

    @Field
    public static /* synthetic */ void getShowPrevious$annotations() {
    }

    @Field
    public static /* synthetic */ void getShowSeekBackward$annotations() {
    }

    @Field
    public static /* synthetic */ void getShowSeekForward$annotations() {
    }

    @Field
    public static /* synthetic */ void getShowSettings$annotations() {
    }

    @Field
    public static /* synthetic */ void getShowSubtitles$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getShowNext() {
        return this.showNext;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getShowPrevious() {
        return this.showPrevious;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getShowSeekForward() {
        return this.showSeekForward;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getShowSeekBackward() {
        return this.showSeekBackward;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Boolean getShowSubtitles() {
        return this.showSubtitles;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getShowSettings() {
        return this.showSettings;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final boolean getShowPlayPause() {
        return this.showPlayPause;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final boolean getShowBottomBar() {
        return this.showBottomBar;
    }

    public final ButtonOptions copy(boolean showNext, boolean showPrevious, boolean showSeekForward, boolean showSeekBackward, Boolean showSubtitles, boolean showSettings, boolean showPlayPause, boolean showBottomBar) {
        return new ButtonOptions(showNext, showPrevious, showSeekForward, showSeekBackward, showSubtitles, showSettings, showPlayPause, showBottomBar);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ButtonOptions)) {
            return false;
        }
        ButtonOptions buttonOptions = (ButtonOptions) other;
        return this.showNext == buttonOptions.showNext && this.showPrevious == buttonOptions.showPrevious && this.showSeekForward == buttonOptions.showSeekForward && this.showSeekBackward == buttonOptions.showSeekBackward && Intrinsics.areEqual(this.showSubtitles, buttonOptions.showSubtitles) && this.showSettings == buttonOptions.showSettings && this.showPlayPause == buttonOptions.showPlayPause && this.showBottomBar == buttonOptions.showBottomBar;
    }

    public int hashCode() {
        int iHashCode = ((((((Boolean.hashCode(this.showNext) * 31) + Boolean.hashCode(this.showPrevious)) * 31) + Boolean.hashCode(this.showSeekForward)) * 31) + Boolean.hashCode(this.showSeekBackward)) * 31;
        Boolean bool = this.showSubtitles;
        return ((((((iHashCode + (bool == null ? 0 : bool.hashCode())) * 31) + Boolean.hashCode(this.showSettings)) * 31) + Boolean.hashCode(this.showPlayPause)) * 31) + Boolean.hashCode(this.showBottomBar);
    }

    public String toString() {
        return "ButtonOptions(showNext=" + this.showNext + ", showPrevious=" + this.showPrevious + ", showSeekForward=" + this.showSeekForward + ", showSeekBackward=" + this.showSeekBackward + ", showSubtitles=" + this.showSubtitles + ", showSettings=" + this.showSettings + ", showPlayPause=" + this.showPlayPause + ", showBottomBar=" + this.showBottomBar + ")";
    }

    public ButtonOptions(boolean z, boolean z2, boolean z3, boolean z4, Boolean bool, boolean z5, boolean z6, boolean z7) {
        this.showNext = z;
        this.showPrevious = z2;
        this.showSeekForward = z3;
        this.showSeekBackward = z4;
        this.showSubtitles = bool;
        this.showSettings = z5;
        this.showPlayPause = z6;
        this.showBottomBar = z7;
    }

    public /* synthetic */ ButtonOptions(boolean z, boolean z2, boolean z3, boolean z4, Boolean bool, boolean z5, boolean z6, boolean z7, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? false : z2, (i & 4) != 0 ? true : z3, (i & 8) != 0 ? true : z4, (i & 16) != 0 ? null : bool, (i & 32) != 0 ? true : z5, (i & 64) != 0 ? true : z6, (i & 128) != 0 ? true : z7);
    }

    public final boolean getShowNext() {
        return this.showNext;
    }

    public final boolean getShowPrevious() {
        return this.showPrevious;
    }

    public final boolean getShowSeekForward() {
        return this.showSeekForward;
    }

    public final boolean getShowSeekBackward() {
        return this.showSeekBackward;
    }

    public final Boolean getShowSubtitles() {
        return this.showSubtitles;
    }

    public final boolean getShowSettings() {
        return this.showSettings;
    }

    public final boolean getShowPlayPause() {
        return this.showPlayPause;
    }

    public final boolean getShowBottomBar() {
        return this.showBottomBar;
    }
}
