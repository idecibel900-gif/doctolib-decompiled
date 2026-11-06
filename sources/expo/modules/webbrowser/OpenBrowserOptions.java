package expo.modules.webbrowser;

import com.facebook.react.fabric.mounting.mountitems.IntBufferBatchMountItem;
import com.opentok.android.PublisherKit;
import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b+\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0080\b\u0018\u00002\u00020\u0001Bg\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\b\u0012\b\b\u0002\u0010\f\u001a\u00020\b\u0012\b\b\u0002\u0010\r\u001a\u00020\b¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0013J\u0010\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0013J\u000b\u0010)\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010*\u001a\u00020\bHÆ\u0003J\t\u0010+\u001a\u00020\bHÆ\u0003J\t\u0010,\u001a\u00020\bHÆ\u0003J\t\u0010-\u001a\u00020\bHÆ\u0003J\t\u0010.\u001a\u00020\bHÆ\u0003J\t\u0010/\u001a\u00020\bHÆ\u0003Jn\u00100\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\b2\b\b\u0002\u0010\r\u001a\u00020\bHÆ\u0001¢\u0006\u0002\u00101J\u0013\u00102\u001a\u00020\b2\b\u00103\u001a\u0004\u0018\u000104HÖ\u0003J\t\u00105\u001a\u00020\u0003HÖ\u0001J\t\u00106\u001a\u00020\u0006HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0014\u0012\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0014\u0012\u0004\b\u0015\u0010\u0011\u001a\u0004\b\u0016\u0010\u0013R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0017\u0010\u0011\u001a\u0004\b\u0018\u0010\u0019R\u001c\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001a\u0010\u0011\u001a\u0004\b\u001b\u0010\u001cR\u001c\u0010\t\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001d\u0010\u0011\u001a\u0004\b\u001e\u0010\u001cR\u001c\u0010\n\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001f\u0010\u0011\u001a\u0004\b \u0010\u001cR\u001c\u0010\u000b\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b!\u0010\u0011\u001a\u0004\b\"\u0010\u001cR\u001c\u0010\f\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b#\u0010\u0011\u001a\u0004\b$\u0010\u001cR\u001c\u0010\r\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b%\u0010\u0011\u001a\u0004\b&\u0010\u001c¨\u00067"}, d2 = {"Lexpo/modules/webbrowser/OpenBrowserOptions;", "Lexpo/modules/kotlin/records/Record;", "toolbarColor", "", "secondaryToolbarColor", "browserPackage", "", "showTitle", "", "enableDefaultShareMenuItem", "enableBarCollapsing", "showInRecents", "shouldCreateTask", "useProxyActivity", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;ZZZZZZ)V", "getToolbarColor$annotations", "()V", "getToolbarColor", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getSecondaryToolbarColor$annotations", "getSecondaryToolbarColor", "getBrowserPackage$annotations", "getBrowserPackage", "()Ljava/lang/String;", "getShowTitle$annotations", "getShowTitle", "()Z", "getEnableDefaultShareMenuItem$annotations", "getEnableDefaultShareMenuItem", "getEnableBarCollapsing$annotations", "getEnableBarCollapsing", "getShowInRecents$annotations", "getShowInRecents", "getShouldCreateTask$annotations", "getShouldCreateTask", "getUseProxyActivity$annotations", "getUseProxyActivity", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;ZZZZZZ)Lexpo/modules/webbrowser/OpenBrowserOptions;", "equals", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "hashCode", "toString", "expo-web-browser_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class OpenBrowserOptions implements Record {
    private final String browserPackage;
    private final boolean enableBarCollapsing;
    private final boolean enableDefaultShareMenuItem;
    private final Integer secondaryToolbarColor;
    private final boolean shouldCreateTask;
    private final boolean showInRecents;
    private final boolean showTitle;
    private final Integer toolbarColor;
    private final boolean useProxyActivity;

    public OpenBrowserOptions() {
        this(null, null, null, false, false, false, false, false, false, 511, null);
    }

    public static /* synthetic */ OpenBrowserOptions copy$default(OpenBrowserOptions openBrowserOptions, Integer num, Integer num2, String str, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, int i, Object obj) {
        if ((i & 1) != 0) {
            num = openBrowserOptions.toolbarColor;
        }
        if ((i & 2) != 0) {
            num2 = openBrowserOptions.secondaryToolbarColor;
        }
        if ((i & 4) != 0) {
            str = openBrowserOptions.browserPackage;
        }
        if ((i & 8) != 0) {
            z = openBrowserOptions.showTitle;
        }
        if ((i & 16) != 0) {
            z2 = openBrowserOptions.enableDefaultShareMenuItem;
        }
        if ((i & 32) != 0) {
            z3 = openBrowserOptions.enableBarCollapsing;
        }
        if ((i & 64) != 0) {
            z4 = openBrowserOptions.showInRecents;
        }
        if ((i & 128) != 0) {
            z5 = openBrowserOptions.shouldCreateTask;
        }
        if ((i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER) != 0) {
            z6 = openBrowserOptions.useProxyActivity;
        }
        boolean z7 = z5;
        boolean z8 = z6;
        boolean z9 = z3;
        boolean z10 = z4;
        boolean z11 = z2;
        String str2 = str;
        return openBrowserOptions.copy(num, num2, str2, z, z11, z9, z10, z7, z8);
    }

    @Field
    public static /* synthetic */ void getBrowserPackage$annotations() {
    }

    @Field
    public static /* synthetic */ void getEnableBarCollapsing$annotations() {
    }

    @Field
    public static /* synthetic */ void getEnableDefaultShareMenuItem$annotations() {
    }

    @Field
    public static /* synthetic */ void getSecondaryToolbarColor$annotations() {
    }

    @Field(key = "createTask")
    public static /* synthetic */ void getShouldCreateTask$annotations() {
    }

    @Field
    public static /* synthetic */ void getShowInRecents$annotations() {
    }

    @Field
    public static /* synthetic */ void getShowTitle$annotations() {
    }

    @Field
    public static /* synthetic */ void getToolbarColor$annotations() {
    }

    @Field
    public static /* synthetic */ void getUseProxyActivity$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Integer getToolbarColor() {
        return this.toolbarColor;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Integer getSecondaryToolbarColor() {
        return this.secondaryToolbarColor;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getBrowserPackage() {
        return this.browserPackage;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getShowTitle() {
        return this.showTitle;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getEnableDefaultShareMenuItem() {
        return this.enableDefaultShareMenuItem;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getEnableBarCollapsing() {
        return this.enableBarCollapsing;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final boolean getShowInRecents() {
        return this.showInRecents;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final boolean getShouldCreateTask() {
        return this.shouldCreateTask;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final boolean getUseProxyActivity() {
        return this.useProxyActivity;
    }

    public final OpenBrowserOptions copy(Integer toolbarColor, Integer secondaryToolbarColor, String browserPackage, boolean showTitle, boolean enableDefaultShareMenuItem, boolean enableBarCollapsing, boolean showInRecents, boolean shouldCreateTask, boolean useProxyActivity) {
        return new OpenBrowserOptions(toolbarColor, secondaryToolbarColor, browserPackage, showTitle, enableDefaultShareMenuItem, enableBarCollapsing, showInRecents, shouldCreateTask, useProxyActivity);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OpenBrowserOptions)) {
            return false;
        }
        OpenBrowserOptions openBrowserOptions = (OpenBrowserOptions) other;
        return Intrinsics.areEqual(this.toolbarColor, openBrowserOptions.toolbarColor) && Intrinsics.areEqual(this.secondaryToolbarColor, openBrowserOptions.secondaryToolbarColor) && Intrinsics.areEqual(this.browserPackage, openBrowserOptions.browserPackage) && this.showTitle == openBrowserOptions.showTitle && this.enableDefaultShareMenuItem == openBrowserOptions.enableDefaultShareMenuItem && this.enableBarCollapsing == openBrowserOptions.enableBarCollapsing && this.showInRecents == openBrowserOptions.showInRecents && this.shouldCreateTask == openBrowserOptions.shouldCreateTask && this.useProxyActivity == openBrowserOptions.useProxyActivity;
    }

    public int hashCode() {
        Integer num = this.toolbarColor;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
        Integer num2 = this.secondaryToolbarColor;
        int iHashCode2 = (iHashCode + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str = this.browserPackage;
        return ((((((((((((iHashCode2 + (str != null ? str.hashCode() : 0)) * 31) + Boolean.hashCode(this.showTitle)) * 31) + Boolean.hashCode(this.enableDefaultShareMenuItem)) * 31) + Boolean.hashCode(this.enableBarCollapsing)) * 31) + Boolean.hashCode(this.showInRecents)) * 31) + Boolean.hashCode(this.shouldCreateTask)) * 31) + Boolean.hashCode(this.useProxyActivity);
    }

    public String toString() {
        return "OpenBrowserOptions(toolbarColor=" + this.toolbarColor + ", secondaryToolbarColor=" + this.secondaryToolbarColor + ", browserPackage=" + this.browserPackage + ", showTitle=" + this.showTitle + ", enableDefaultShareMenuItem=" + this.enableDefaultShareMenuItem + ", enableBarCollapsing=" + this.enableBarCollapsing + ", showInRecents=" + this.showInRecents + ", shouldCreateTask=" + this.shouldCreateTask + ", useProxyActivity=" + this.useProxyActivity + ")";
    }

    public OpenBrowserOptions(Integer num, Integer num2, String str, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
        this.toolbarColor = num;
        this.secondaryToolbarColor = num2;
        this.browserPackage = str;
        this.showTitle = z;
        this.enableDefaultShareMenuItem = z2;
        this.enableBarCollapsing = z3;
        this.showInRecents = z4;
        this.shouldCreateTask = z5;
        this.useProxyActivity = z6;
    }

    public /* synthetic */ OpenBrowserOptions(Integer num, Integer num2, String str, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : num2, (i & 4) != 0 ? null : str, (i & 8) != 0 ? false : z, (i & 16) != 0 ? false : z2, (i & 32) != 0 ? false : z3, (i & 64) != 0 ? false : z4, (i & 128) != 0 ? true : z5, (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER) != 0 ? true : z6);
    }

    public final Integer getToolbarColor() {
        return this.toolbarColor;
    }

    public final Integer getSecondaryToolbarColor() {
        return this.secondaryToolbarColor;
    }

    public final String getBrowserPackage() {
        return this.browserPackage;
    }

    public final boolean getShowTitle() {
        return this.showTitle;
    }

    public final boolean getEnableDefaultShareMenuItem() {
        return this.enableDefaultShareMenuItem;
    }

    public final boolean getEnableBarCollapsing() {
        return this.enableBarCollapsing;
    }

    public final boolean getShowInRecents() {
        return this.showInRecents;
    }

    public final boolean getShouldCreateTask() {
        return this.shouldCreateTask;
    }

    public final boolean getUseProxyActivity() {
        return this.useProxyActivity;
    }
}
