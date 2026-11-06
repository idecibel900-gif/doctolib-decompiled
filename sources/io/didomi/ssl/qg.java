package io.didomi.ssl;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\b\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0007¨\u0006\u000b"}, d2 = {"Lio/didomi/sdk/qg;", "Lio/didomi/sdk/ng;", "Lio/didomi/sdk/hg$e;", "section", "", "a", "Lio/didomi/sdk/b5;", "Lio/didomi/sdk/b5;", "binding", "<init>", "(Lio/didomi/sdk/b5;)V", "android_release"}, k = 1, mv = {1, 8, 0})
public final class qg extends ng {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final b5 binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public qg(b5 binding) {
        super(binding);
        Intrinsics.checkNotNullParameter(binding, "binding");
        this.binding = binding;
    }

    public final void a(hg.Section section) {
        Intrinsics.checkNotNullParameter(section, "section");
        this.binding.getRoot().setText(section.getText());
    }
}
