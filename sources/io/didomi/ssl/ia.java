package io.didomi.ssl;

import android.text.SpannableStringBuilder;
import android.text.SpannedString;
import android.text.style.StyleSpan;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u0000 \u00142\u00020\u0001:\u0001\u0005B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\f\u001a\u00020\t¢\u0006\u0004\b\u0012\u0010\u0013J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\b\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0007R\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u001b\u0010\u0011\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0005\u0010\u0010¨\u0006\u0015"}, d2 = {"Lio/didomi/sdk/ia;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lio/didomi/sdk/ea;", "vendor", "", "a", "Lio/didomi/sdk/r3;", "Lio/didomi/sdk/r3;", "binding", "Lio/didomi/sdk/ah;", "b", "Lio/didomi/sdk/ah;", "themeProvider", "", "c", "Lkotlin/Lazy;", "()Ljava/lang/String;", "iabTag", "<init>", "(Lio/didomi/sdk/r3;Lio/didomi/sdk/ah;)V", "d", "android_release"}, k = 1, mv = {1, 8, 0})
public final class ia extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final r3 binding;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final ah themeProvider;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final Lazy iabTag;

    @Metadata(d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 8, 0})
    static final class b extends Lambda implements Function0 {
        b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            return ia.this.binding.getRoot().getContext().getResources().getString(R.string.didomi_iab_tag);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ia(r3 binding, ah themeProvider) {
        super(binding.getRoot());
        Intrinsics.checkNotNullParameter(binding, "binding");
        Intrinsics.checkNotNullParameter(themeProvider, "themeProvider");
        this.binding = binding;
        this.themeProvider = themeProvider;
        this.iabTag = LazyKt.lazy(new b());
    }

    private final String a() {
        return (String) this.iabTag.getValue();
    }

    public final void a(PurposeVendorDisplay vendor) {
        Intrinsics.checkNotNullParameter(vendor, "vendor");
        TextView bind$lambda$2 = this.binding.c;
        Intrinsics.checkNotNullExpressionValue(bind$lambda$2, "bind$lambda$2");
        zg.a(bind$lambda$2, this.themeProvider.i().c());
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(vendor.getLabel());
        if (vendor.getIsIab()) {
            StyleSpan styleSpan = new StyleSpan(1);
            int length = spannableStringBuilder.length();
            spannableStringBuilder.append((CharSequence) (' ' + a()));
            spannableStringBuilder.setSpan(styleSpan, length, spannableStringBuilder.length(), 17);
        }
        SpannedString spannedStringValueOf = SpannedString.valueOf(spannableStringBuilder);
        Intrinsics.checkNotNullExpressionValue(spannedStringValueOf, "valueOf(this)");
        bind$lambda$2.setText(spannedStringValueOf);
        ImageView bind$lambda$3 = this.binding.b;
        Intrinsics.checkNotNullExpressionValue(bind$lambda$3, "bind$lambda$3");
        a7.a(bind$lambda$3, this.themeProvider.i().n().getTextColor());
        bind$lambda$3.setPadding(0, this.binding.c.getLineHeight() / 2, 0, 0);
    }
}
