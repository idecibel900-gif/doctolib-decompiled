package io.didomi.ssl;

import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lio/didomi/sdk/ne;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroidx/viewbinding/ViewBinding;", "binding", "<init>", "(Landroidx/viewbinding/ViewBinding;)V", "android_release"}, k = 1, mv = {1, 8, 0})
public abstract class ne extends RecyclerView.ViewHolder {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ne(ViewBinding binding) {
        super(binding.getRoot());
        Intrinsics.checkNotNullParameter(binding, "binding");
    }
}
