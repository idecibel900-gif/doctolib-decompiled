package io.didomi.ssl;

import androidx.appcompat.widget.AppCompatButton;
import com.google.firebase.messaging.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u000e2\u00020\u0001:\u0001\u0005B\u0017\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000f"}, d2 = {"Lio/didomi/sdk/y9;", "Lio/didomi/sdk/la;", "Lio/didomi/sdk/s9;", Constants.ScionAnalytics.MessageType.DATA_MESSAGE, "", "a", "Lio/didomi/sdk/o3;", "c", "Lio/didomi/sdk/o3;", "binding", "Lio/didomi/sdk/ah;", "themeProvider", "<init>", "(Lio/didomi/sdk/o3;Lio/didomi/sdk/ah;)V", "d", "android_release"}, k = 1, mv = {1, 8, 0})
public final class y9 extends la {

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final o3 binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y9(o3 binding, ah themeProvider) {
        super(binding, themeProvider);
        Intrinsics.checkNotNullParameter(binding, "binding");
        Intrinsics.checkNotNullParameter(themeProvider, "themeProvider");
        this.binding = binding;
    }

    public final void a(s9 data) {
        Intrinsics.checkNotNullParameter(data, "data");
        super.a((o9) data);
        AppCompatButton bind$lambda$0 = this.binding.getRoot();
        Intrinsics.checkNotNullExpressionValue(bind$lambda$0, "bind$lambda$0");
        mi.a(bind$lambda$0, data.getLabel(), data.getLabel(), null, false, null, 0, null, null, 252, null);
        s.a(bind$lambda$0, getThemeProvider().i().i());
        bind$lambda$0.setText(data.getLabel());
    }
}
