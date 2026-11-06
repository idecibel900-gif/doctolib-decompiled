package io.didomi.ssl;

import android.widget.TextView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\b\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0007¨\u0006\u000b"}, d2 = {"Lio/didomi/sdk/we;", "Lio/didomi/sdk/df;", "Lio/didomi/sdk/bf$a;", "item", "", "a", "Lio/didomi/sdk/n4;", "Lio/didomi/sdk/n4;", "binding", "<init>", "(Lio/didomi/sdk/n4;)V", "android_release"}, k = 1, mv = {1, 8, 0})
public final class we extends df {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final n4 binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public we(n4 binding) {
        super(binding);
        Intrinsics.checkNotNullParameter(binding, "binding");
        this.binding = binding;
    }

    public final void a(bf.Description item) {
        Intrinsics.checkNotNullParameter(item, "item");
        this.binding.d.setText(item.getTitle());
        TextView textView = this.binding.c;
        textView.setText(item.getDescription());
        String description = item.getDescription();
        textView.setVisibility((description == null || StringsKt.isBlank(description)) ? 8 : 0);
    }
}
