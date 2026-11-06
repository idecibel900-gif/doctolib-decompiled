package io.didomi.ssl;

import android.view.KeyEvent;
import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u0014\u0010\n\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\t¨\u0006\r"}, d2 = {"Lio/didomi/sdk/pf;", "Lio/didomi/sdk/zf;", "Lio/didomi/sdk/wf$d;", "dataCategory", "Lio/didomi/sdk/lf$a;", "callback", "", "a", "Lio/didomi/sdk/t4;", "Lio/didomi/sdk/t4;", "binding", "<init>", "(Lio/didomi/sdk/t4;)V", "android_release"}, k = 1, mv = {1, 8, 0})
public final class pf extends zf {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final t4 binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public pf(t4 binding) {
        super(binding);
        Intrinsics.checkNotNullParameter(binding, "binding");
        this.binding = binding;
    }

    public final void a(final wf.DataCategory dataCategory, final lf.a callback) {
        Intrinsics.checkNotNullParameter(dataCategory, "dataCategory");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.binding.b.setText(dataCategory.getText());
        final View view = this.itemView;
        view.setOnClickListener(new View.OnClickListener() { // from class: io.didomi.sdk.pf$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                pf.a(callback, dataCategory, view2);
            }
        });
        view.setOnKeyListener(new View.OnKeyListener() { // from class: io.didomi.sdk.pf$$ExternalSyntheticLambda1
            @Override // android.view.View.OnKeyListener
            public final boolean onKey(View view2, int i, KeyEvent keyEvent) {
                return pf.a(view, view2, i, keyEvent);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(lf.a callback, wf.DataCategory dataCategory, View view) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullParameter(dataCategory, "$dataCategory");
        callback.a(dataCategory.getElementId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean a(View this_apply, View view, int i, KeyEvent keyEvent) {
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        if (i != 22 || keyEvent.getAction() != 1) {
            return false;
        }
        this_apply.callOnClick();
        return true;
    }
}
