package io.didomi.ssl;

import android.view.KeyEvent;
import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u0014\u0010\n\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\t¨\u0006\r"}, d2 = {"Lio/didomi/sdk/xf;", "Lio/didomi/sdk/zf;", "Lio/didomi/sdk/wf$i;", "legitimateInterest", "Lio/didomi/sdk/lf$a;", "callback", "", "a", "Lio/didomi/sdk/x4;", "Lio/didomi/sdk/x4;", "binding", "<init>", "(Lio/didomi/sdk/x4;)V", "android_release"}, k = 1, mv = {1, 8, 0})
public final class xf extends zf {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final x4 binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public xf(x4 binding) {
        super(binding);
        Intrinsics.checkNotNullParameter(binding, "binding");
        this.binding = binding;
    }

    public final void a(final wf.LegitimateInterest legitimateInterest, final lf.a callback) {
        Intrinsics.checkNotNullParameter(legitimateInterest, "legitimateInterest");
        Intrinsics.checkNotNullParameter(callback, "callback");
        final x4 x4Var = this.binding;
        x4Var.e.setText(legitimateInterest.getText());
        x4Var.d.setText(legitimateInterest.getIsChecked() ? legitimateInterest.getStatusOn() : legitimateInterest.getStatusOff());
        x4Var.b.setChecked(legitimateInterest.getIsChecked());
        this.itemView.setOnClickListener(new View.OnClickListener() { // from class: io.didomi.sdk.xf$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                xf.a(x4Var, legitimateInterest, callback, view);
            }
        });
        this.itemView.setOnKeyListener(new View.OnKeyListener() { // from class: io.didomi.sdk.xf$$ExternalSyntheticLambda1
            @Override // android.view.View.OnKeyListener
            public final boolean onKey(View view, int i, KeyEvent keyEvent) {
                return xf.a(callback, view, i, keyEvent);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(x4 this_apply, wf.LegitimateInterest legitimateInterest, lf.a callback, View view) {
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        Intrinsics.checkNotNullParameter(legitimateInterest, "$legitimateInterest");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        boolean zIsChecked = this_apply.b.isChecked();
        boolean z = !zIsChecked;
        this_apply.d.setText(!zIsChecked ? legitimateInterest.getStatusOn() : legitimateInterest.getStatusOff());
        this_apply.b.setChecked(z);
        callback.b(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean a(lf.a callback, View view, int i, KeyEvent keyEvent) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        if (i != 22 || keyEvent.getAction() != 1) {
            return false;
        }
        callback.c();
        return true;
    }
}
