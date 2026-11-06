package io.didomi.ssl;

import android.view.View;
import android.widget.TextView;
import com.google.firebase.messaging.Constants;
import io.didomi.ssl.view.mobile.DidomiToggle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\r\u001a\u00020\n¢\u0006\u0004\b\u0012\u0010\u0013J\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bR\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0011\u0010\u000f\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u000e¨\u0006\u0014"}, d2 = {"Lio/didomi/sdk/ci;", "Lio/didomi/sdk/ji;", "Lio/didomi/sdk/xh$a;", Constants.ScionAnalytics.MessageType.DATA_MESSAGE, "Lio/didomi/sdk/view/mobile/DidomiToggle$a;", "toggleCallback", "", "a", "Lio/didomi/sdk/view/mobile/DidomiToggle$b;", "state", "Lio/didomi/sdk/d5;", "c", "Lio/didomi/sdk/d5;", "binding", "()Lio/didomi/sdk/view/mobile/DidomiToggle$b;", "nextState", "Lio/didomi/sdk/ah;", "themeProvider", "<init>", "(Lio/didomi/sdk/ah;Lio/didomi/sdk/d5;)V", "android_release"}, k = 1, mv = {1, 8, 0})
public final class ci extends ji {

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final d5 binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ci(ah themeProvider, d5 binding) {
        super(themeProvider, binding);
        Intrinsics.checkNotNullParameter(themeProvider, "themeProvider");
        Intrinsics.checkNotNullParameter(binding, "binding");
        this.binding = binding;
        this.itemView.setBackgroundColor(themeProvider.a());
    }

    public final void a(xh.Bulk data, DidomiToggle.a toggleCallback) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(toggleCallback, "toggleCallback");
        super.a(data);
        TextView bind$lambda$0 = this.binding.b;
        Intrinsics.checkNotNullExpressionValue(bind$lambda$0, "bind$lambda$0");
        zg.a(bind$lambda$0, getThemeProvider().i().n());
        bind$lambda$0.setText(data.getTitle());
        final DidomiToggle didomiToggle = this.binding.c;
        didomiToggle.setCallback(null);
        didomiToggle.setAnimate(false);
        didomiToggle.setState(data.getState());
        didomiToggle.setHasMiddleState(data.getHasMiddleState());
        didomiToggle.setCallback(toggleCallback);
        didomiToggle.post(new Runnable() { // from class: io.didomi.sdk.ci$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                ci.a(didomiToggle);
            }
        });
        View itemView = this.itemView;
        Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
        mi.a(itemView, data.getAccessibilityLabel(), data.d().get(data.getState().ordinal()), data.g().get(data.getState().ordinal()), false, null, 0, null, b.c, 112, null);
    }

    public final DidomiToggle.b c() {
        return this.binding.c.getState().a(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(DidomiToggle this_apply) {
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        this_apply.setAnimate(true);
    }

    public final void a(xh.Bulk data, DidomiToggle.b state) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(state, "state");
        String accessibilityAnnounceStateLabel = data.getAccessibilityAnnounceStateLabel();
        if (accessibilityAnnounceStateLabel == null && (accessibilityAnnounceStateLabel = data.getAccessibilityLabel()) == null) {
            return;
        }
        View itemView = this.itemView;
        Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
        mi.a(itemView, accessibilityAnnounceStateLabel, data.g().get(state.ordinal()));
    }
}
