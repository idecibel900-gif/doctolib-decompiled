package io.didomi.ssl;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 $2\u00020\u0001:\u0001\u0007B'\b\u0007\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001f\u0012\b\b\u0002\u0010!\u001a\u00020\u0003¢\u0006\u0004\b\"\u0010#J\u001e\u0010\u0007\u001a\u00020\u0006*\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bR\u0014\u0010\f\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u000bR\"\u0010\u0014\u001a\u00020\r8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u001c\u001a\u00020\u00158\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006%"}, d2 = {"Lio/didomi/sdk/r1;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/widget/TextView;", "", "color", "radius", "", "a", "Lio/didomi/sdk/p1;", "dataProcessingDisplay", "Lio/didomi/sdk/m5;", "Lio/didomi/sdk/m5;", "binding", "Lio/didomi/sdk/n7;", "b", "Lio/didomi/sdk/n7;", "getLanguagesHelper", "()Lio/didomi/sdk/n7;", "setLanguagesHelper", "(Lio/didomi/sdk/n7;)V", "languagesHelper", "Lio/didomi/sdk/ah;", "c", "Lio/didomi/sdk/ah;", "getThemeProvider", "()Lio/didomi/sdk/ah;", "setThemeProvider", "(Lio/didomi/sdk/ah;)V", "themeProvider", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "d", "android_release"}, k = 1, mv = {1, 8, 0})
public final class r1 extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final m5 binding;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public n7 languagesHelper;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public ah themeProvider;

    public /* synthetic */ r1(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public final void a(DataProcessingDisplay dataProcessingDisplay) {
        Intrinsics.checkNotNullParameter(dataProcessingDisplay, "dataProcessingDisplay");
        ImageView populate$lambda$0 = this.binding.b;
        Intrinsics.checkNotNullExpressionValue(populate$lambda$0, "populate$lambda$0");
        a7.a(populate$lambda$0, getThemeProvider().i().n().getTextColor());
        populate$lambda$0.setPadding(0, this.binding.c.getLineHeight() / 2, 0, 0);
        TextView populate$lambda$1 = this.binding.c;
        Intrinsics.checkNotNullExpressionValue(populate$lambda$1, "populate$lambda$1");
        zg.a(populate$lambda$1, getThemeProvider().i().n());
        populate$lambda$1.setText(StringsKt.trim(dataProcessingDisplay.getLabel()).toString());
        TextView populate$lambda$2 = this.binding.d;
        if (dataProcessingDisplay.getRetentionTime() == null) {
            Intrinsics.checkNotNullExpressionValue(populate$lambda$2, "populate$lambda$2");
            populate$lambda$2.setVisibility(8);
            return;
        }
        Intrinsics.checkNotNullExpressionValue(populate$lambda$2, "populate$lambda$2");
        a(populate$lambda$2, R.color.didomi_retention_time_background, 4);
        zg.a(populate$lambda$2, TextTheme.a(getThemeProvider().i().c(), null, -16777216, null, 5, null));
        String strA = n7.a(getLanguagesHelper(), "retention_time", null, null, null, 14, null);
        Integer retentionTime = dataProcessingDisplay.getRetentionTime();
        String strA2 = (retentionTime != null && retentionTime.intValue() == 1) ? n7.a(getLanguagesHelper(), "day_singular", null, null, null, 14, null) : n7.a(getLanguagesHelper(), "day_plural", null, MapsKt.mapOf(TuplesKt.to("{nb}", String.valueOf(dataProcessingDisplay.getRetentionTime()))), null, 10, null);
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format("<b>%s</b> %s", Arrays.copyOf(new Object[]{strA, strA2}, 2));
        Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
        populate$lambda$2.setText(fc.h(str));
    }

    public final n7 getLanguagesHelper() {
        n7 n7Var = this.languagesHelper;
        if (n7Var != null) {
            return n7Var;
        }
        Intrinsics.throwUninitializedPropertyAccessException("languagesHelper");
        return null;
    }

    public final ah getThemeProvider() {
        ah ahVar = this.themeProvider;
        if (ahVar != null) {
            return ahVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("themeProvider");
        return null;
    }

    public final void setLanguagesHelper(n7 n7Var) {
        Intrinsics.checkNotNullParameter(n7Var, "<set-?>");
        this.languagesHelper = n7Var;
    }

    public final void setThemeProvider(ah ahVar) {
        Intrinsics.checkNotNullParameter(ahVar, "<set-?>");
        this.themeProvider = ahVar;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r1(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        m5 m5VarA = m5.a(LayoutInflater.from(context), this, true);
        Intrinsics.checkNotNullExpressionValue(m5VarA, "inflate(LayoutInflater.from(context), this, true)");
        this.binding = m5VarA;
        Didomi.INSTANCE.getInstance().getComponent$android_release().a(this);
    }

    private final void a(TextView textView, int i, int i2) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(i2 * textView.getResources().getDisplayMetrics().density);
        gradientDrawable.setColor(ContextCompat.getColor(textView.getContext(), i));
        textView.setBackground(gradientDrawable);
    }
}
