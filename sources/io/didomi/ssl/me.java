package io.didomi.ssl;

import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\f\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006R\u0014\u0010\f\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u000b¨\u0006\u000f"}, d2 = {"Lio/didomi/sdk/me;", "Lio/didomi/sdk/ne;", "Lio/didomi/sdk/ge$a;", "callback", "", "position", "Lio/didomi/sdk/gd$f;", "vendorsCount", "", "a", "Lio/didomi/sdk/b4;", "Lio/didomi/sdk/b4;", "binding", "<init>", "(Lio/didomi/sdk/b4;)V", "android_release"}, k = 1, mv = {1, 8, 0})
public final class me extends ne {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final b4 binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public me(b4 binding) {
        super(binding);
        Intrinsics.checkNotNullParameter(binding, "binding");
        this.binding = binding;
    }

    public final void a(final ge.a callback, final int position, final gd.VendorsCount vendorsCount) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        Intrinsics.checkNotNullParameter(vendorsCount, "vendorsCount");
        this.binding.c.setText(vendorsCount.getTitle());
        Button button = this.binding.b;
        button.setText(vendorsCount.getText());
        button.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: io.didomi.sdk.me$$ExternalSyntheticLambda0
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z) {
                me.a(callback, position, view, z);
            }
        });
        button.setOnClickListener(new View.OnClickListener() { // from class: io.didomi.sdk.me$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                me.a(callback, vendorsCount, view);
            }
        });
        button.setOnKeyListener(new View.OnKeyListener() { // from class: io.didomi.sdk.me$$ExternalSyntheticLambda2
            @Override // android.view.View.OnKeyListener
            public final boolean onKey(View view, int i, KeyEvent keyEvent) {
                return me.a(callback, vendorsCount, view, i, keyEvent);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(ge.a callback, int i, View view, boolean z) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        if (z) {
            callback.a(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(ge.a callback, gd.VendorsCount vendorsCount, View view) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullParameter(vendorsCount, "$vendorsCount");
        callback.a(vendorsCount.getType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean a(ge.a callback, gd.VendorsCount vendorsCount, View view, int i, KeyEvent keyEvent) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullParameter(vendorsCount, "$vendorsCount");
        if (i != 22 || keyEvent.getAction() != 1) {
            return false;
        }
        callback.a(vendorsCount.getType());
        return true;
    }
}
