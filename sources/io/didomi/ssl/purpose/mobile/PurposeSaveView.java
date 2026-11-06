package io.didomi.ssl.purpose.mobile;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.amazon.a.a.o.b;
import com.google.firebase.messaging.Constants;
import io.didomi.ssl.Didomi;
import io.didomi.ssl.a7;
import io.didomi.ssl.ah;
import io.didomi.ssl.mi;
import io.didomi.ssl.ni;
import io.didomi.ssl.q5;
import io.didomi.ssl.zg;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010&\u001a\u00020%\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010'\u0012\b\b\u0002\u0010*\u001a\u00020)¢\u0006\u0004\b+\u0010,J\b\u0010\u0003\u001a\u00020\u0002H\u0014J\b\u0010\u0004\u001a\u00020\u0002H\u0014J\u001f\u0010\b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010\n\u001a\u00020\u0002J\u0006\u0010\b\u001a\u00020\u0002R.\u0010\u0011\u001a\u0004\u0018\u00010\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0018\u001a\u00020\u00128\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\n\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u0004\u0018\u00010\u001d8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u0004\u0018\u00010!8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#¨\u0006-"}, d2 = {"Lio/didomi/sdk/purpose/mobile/PurposeSaveView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "onFinishInflate", "onDetachedFromWindow", "", Constants.ScionAnalytics.PARAM_LABEL, b.c, "a", "(Ljava/lang/String;Ljava/lang/String;)Lkotlin/Unit;", "b", "value", "Ljava/lang/String;", "getDescriptionText", "()Ljava/lang/String;", "setDescriptionText", "(Ljava/lang/String;)V", "descriptionText", "Lio/didomi/sdk/ah;", "Lio/didomi/sdk/ah;", "getThemeProvider", "()Lio/didomi/sdk/ah;", "setThemeProvider", "(Lio/didomi/sdk/ah;)V", "themeProvider", "Lio/didomi/sdk/q5;", "c", "Lio/didomi/sdk/q5;", "binding", "Landroid/widget/ImageView;", "getLogoImage$android_release", "()Landroid/widget/ImageView;", "logoImage", "Landroid/widget/Button;", "getSaveButton$android_release", "()Landroid/widget/Button;", "saveButton", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "android_release"}, k = 1, mv = {1, 8, 0})
public final class PurposeSaveView extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private String descriptionText;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public ah themeProvider;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private q5 binding;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PurposeSaveView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final Unit a(String label, String description) {
        Intrinsics.checkNotNullParameter(label, "label");
        Intrinsics.checkNotNullParameter(description, "description");
        Button saveButton$android_release = getSaveButton$android_release();
        if (saveButton$android_release == null) {
            return null;
        }
        mi.a(saveButton$android_release, label, description, null, false, null, 0, null, null, 252, null);
        return Unit.INSTANCE;
    }

    public final void b() {
        TextView textView;
        Button saveButton$android_release = getSaveButton$android_release();
        if (saveButton$android_release != null) {
            ni.b(saveButton$android_release);
        }
        q5 q5Var = this.binding;
        if (q5Var == null || (textView = q5Var.d) == null) {
            return;
        }
        textView.setText((CharSequence) null);
        textView.setVisibility(8);
    }

    public final String getDescriptionText() {
        return this.descriptionText;
    }

    public final ImageView getLogoImage$android_release() {
        q5 q5Var = this.binding;
        if (q5Var != null) {
            return q5Var.c;
        }
        return null;
    }

    public final Button getSaveButton$android_release() {
        q5 q5Var = this.binding;
        if (q5Var != null) {
            return q5Var.b;
        }
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

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.binding = null;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        TextView textView;
        super.onFinishInflate();
        q5 q5VarA = q5.a(LayoutInflater.from(getContext()), this, true);
        this.binding = q5VarA;
        if (q5VarA != null && (textView = q5VarA.d) != null) {
            zg.a(textView, getThemeProvider().i().d());
        }
        ImageView logoImage$android_release = getLogoImage$android_release();
        if (logoImage$android_release != null) {
            a7.a(logoImage$android_release, getThemeProvider().g());
        }
    }

    public final void setDescriptionText(String str) {
        TextView textView;
        this.descriptionText = str;
        q5 q5Var = this.binding;
        if (q5Var == null || (textView = q5Var.d) == null || textView.getVisibility() != 0) {
            return;
        }
        textView.setText(str);
        requestLayout();
    }

    public final void setThemeProvider(ah ahVar) {
        Intrinsics.checkNotNullParameter(ahVar, "<set-?>");
        this.themeProvider = ahVar;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PurposeSaveView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final void a() {
        TextView textView;
        Button saveButton$android_release = getSaveButton$android_release();
        if (saveButton$android_release != null) {
            ni.a(saveButton$android_release);
        }
        q5 q5Var = this.binding;
        if (q5Var == null || (textView = q5Var.d) == null) {
            return;
        }
        textView.setText(this.descriptionText);
        textView.setVisibility(0);
    }

    public /* synthetic */ PurposeSaveView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PurposeSaveView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        Didomi.INSTANCE.getInstance().getComponent$android_release().a(this);
    }
}
