package io.didomi.ssl;

import android.view.View;
import android.widget.TextView;
import com.google.firebase.messaging.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u000e2\u00020\u0001:\u0001\u0005B\u0017\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000f"}, d2 = {"Lio/didomi/sdk/k9;", "Lio/didomi/sdk/la;", "Lio/didomi/sdk/r9;", Constants.ScionAnalytics.MessageType.DATA_MESSAGE, "", "a", "Lio/didomi/sdk/n3;", "c", "Lio/didomi/sdk/n3;", "binding", "Lio/didomi/sdk/ah;", "themeProvider", "<init>", "(Lio/didomi/sdk/n3;Lio/didomi/sdk/ah;)V", "d", "android_release"}, k = 1, mv = {1, 8, 0})
public final class k9 extends la {

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final n3 binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k9(n3 binding, ah themeProvider) {
        super(binding, themeProvider);
        Intrinsics.checkNotNullParameter(binding, "binding");
        Intrinsics.checkNotNullParameter(themeProvider, "themeProvider");
        this.binding = binding;
    }

    public final void a(PurposeDisplayCategoryHeader data) {
        int i;
        Intrinsics.checkNotNullParameter(data, "data");
        super.a((o9) data);
        n3 n3Var = this.binding;
        TextView bind$lambda$2$lambda$0 = n3Var.c;
        int i2 = 0;
        if (StringsKt.isBlank(data.getTitleLabel())) {
            i = 8;
        } else {
            Intrinsics.checkNotNullExpressionValue(bind$lambda$2$lambda$0, "bind$lambda$2$lambda$0");
            zg.a(bind$lambda$2$lambda$0, j2.PREFERENCES_TITLE, getThemeProvider());
            bind$lambda$2$lambda$0.setText(data.getTitleLabel());
            i = 0;
        }
        bind$lambda$2$lambda$0.setVisibility(i);
        TextView bind$lambda$2$lambda$1 = n3Var.b;
        if (StringsKt.isBlank(data.getDescriptionLabel())) {
            i2 = 8;
        } else {
            Intrinsics.checkNotNullExpressionValue(bind$lambda$2$lambda$1, "bind$lambda$2$lambda$1");
            zg.a(bind$lambda$2$lambda$1, j2.PREFERENCES_DESCRIPTION, getThemeProvider());
            bind$lambda$2$lambda$1.setText(data.getDescriptionLabel());
        }
        bind$lambda$2$lambda$1.setVisibility(i2);
        View itemView = this.itemView;
        Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
        mi.a(itemView);
    }
}
