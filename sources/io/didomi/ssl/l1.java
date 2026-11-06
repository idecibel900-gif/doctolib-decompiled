package io.didomi.ssl;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u0014\u0010\n\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\t¨\u0006\u0013"}, d2 = {"Lio/didomi/sdk/l1;", "Landroid/widget/LinearLayout;", "Lio/didomi/sdk/k1;", "dataCategoryDisplay", "Lio/didomi/sdk/xg;", "theme", "", "a", "Lio/didomi/sdk/l5;", "Lio/didomi/sdk/l5;", "binding", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "android_release"}, k = 1, mv = {1, 8, 0})
public final class l1 extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final l5 binding;

    public /* synthetic */ l1(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public final void a(DataCategoryDisplay dataCategoryDisplay, TextTheme theme) {
        Intrinsics.checkNotNullParameter(dataCategoryDisplay, "dataCategoryDisplay");
        Intrinsics.checkNotNullParameter(theme, "theme");
        TextView populate$lambda$0 = this.binding.c;
        Intrinsics.checkNotNullExpressionValue(populate$lambda$0, "populate$lambda$0");
        zg.a(populate$lambda$0, theme);
        populate$lambda$0.setText(dataCategoryDisplay.getTitle());
        TextView populate$lambda$1 = this.binding.b;
        Intrinsics.checkNotNullExpressionValue(populate$lambda$1, "populate$lambda$1");
        zg.a(populate$lambda$1, theme);
        populate$lambda$1.setText(dataCategoryDisplay.getDescription());
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l1(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        l5 l5VarA = l5.a(LayoutInflater.from(context), this, true);
        Intrinsics.checkNotNullExpressionValue(l5VarA, "inflate(LayoutInflater.from(context), this, true)");
        this.binding = l5VarA;
    }
}
