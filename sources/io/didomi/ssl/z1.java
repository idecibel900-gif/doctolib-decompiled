package io.didomi.ssl;

import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\f\u001a\u00020\t¢\u0006\u0004\b\r\u0010\u000eJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\b\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0007R\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lio/didomi/sdk/z1;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lio/didomi/sdk/w1;", "item", "", "a", "Lio/didomi/sdk/k3;", "Lio/didomi/sdk/k3;", "binding", "Lio/didomi/sdk/ah;", "b", "Lio/didomi/sdk/ah;", "themeProvider", "<init>", "(Lio/didomi/sdk/k3;Lio/didomi/sdk/ah;)V", "android_release"}, k = 1, mv = {1, 8, 0})
public final class z1 extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final k3 binding;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final ah themeProvider;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z1(k3 binding, ah themeProvider) {
        super(binding.getRoot());
        Intrinsics.checkNotNullParameter(binding, "binding");
        Intrinsics.checkNotNullParameter(themeProvider, "themeProvider");
        this.binding = binding;
        this.themeProvider = themeProvider;
    }

    public final void a(DeviceStorageDisclosureItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        TextView bind$lambda$0 = this.binding.d;
        Intrinsics.checkNotNullExpressionValue(bind$lambda$0, "bind$lambda$0");
        zg.a(bind$lambda$0, this.themeProvider.i().c());
        bind$lambda$0.setText(item.getTitle());
        TextView bind$lambda$1 = this.binding.b;
        if (StringsKt.isBlank(item.getDescription())) {
            Intrinsics.checkNotNullExpressionValue(bind$lambda$1, "bind$lambda$1");
            bind$lambda$1.setVisibility(8);
        } else {
            Intrinsics.checkNotNullExpressionValue(bind$lambda$1, "bind$lambda$1");
            zg.a(bind$lambda$1, this.themeProvider.i().d());
            bind$lambda$1.setText(item.getDescription());
            bind$lambda$1.setVisibility(0);
        }
        AppCompatImageView appCompatImageView = this.binding.c;
        Intrinsics.checkNotNullExpressionValue(appCompatImageView, "binding.disclosureItemDetailIndicator");
        a7.a(appCompatImageView, this.themeProvider.j());
    }
}
