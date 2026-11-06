package io.didomi.ssl;

import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.google.firebase.messaging.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\u0006\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007R\u001a\u0010\n\u001a\u00020\u00068\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0007\u001a\u0004\b\b\u0010\tR\"\u0010\u0010\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\f\u001a\u0004\b\u0005\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0015"}, d2 = {"Lio/didomi/sdk/zb;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lio/didomi/sdk/o8;", Constants.ScionAnalytics.MessageType.DATA_MESSAGE, "", "a", "Lio/didomi/sdk/ah;", "Lio/didomi/sdk/ah;", "b", "()Lio/didomi/sdk/ah;", "themeProvider", "", "Z", "()Z", "setPreventListAccessibilityAnnouncement", "(Z)V", "preventListAccessibilityAnnouncement", "Landroidx/viewbinding/ViewBinding;", "binding", "<init>", "(Landroidx/viewbinding/ViewBinding;Lio/didomi/sdk/ah;)V", "android_release"}, k = 1, mv = {1, 8, 0})
public abstract class zb extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final ah themeProvider;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private boolean preventListAccessibilityAnnouncement;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zb(ViewBinding binding, ah themeProvider) {
        super(binding.getRoot());
        Intrinsics.checkNotNullParameter(binding, "binding");
        Intrinsics.checkNotNullParameter(themeProvider, "themeProvider");
        this.themeProvider = themeProvider;
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final boolean getPreventListAccessibilityAnnouncement() {
        return this.preventListAccessibilityAnnouncement;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    protected final ah getThemeProvider() {
        return this.themeProvider;
    }

    public final void a(o8 data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.preventListAccessibilityAnnouncement = data.getPreventListAccessibilityAnnouncement();
    }
}
