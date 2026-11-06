package io.didomi.ssl;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\nB%\u0012\u0006\u0010\u0010\u001a\u00020\u000e\u0012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0006\u0010\u0019\u001a\u00020\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0003H\u0016J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0003H\u0016J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0003H\u0016R\u0014\u0010\u0010\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000fR\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0019\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018¨\u0006\u001c"}, d2 = {"Lio/didomi/sdk/y1;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lio/didomi/sdk/z1;", "", "getItemCount", "position", "", "getItemId", "holder", "", "a", "Landroid/view/ViewGroup;", "parent", "viewType", "Lio/didomi/sdk/y1$a;", "Lio/didomi/sdk/y1$a;", "callback", "", "Lio/didomi/sdk/w1;", "b", "Ljava/util/List;", "list", "Lio/didomi/sdk/ah;", "c", "Lio/didomi/sdk/ah;", "themeProvider", "<init>", "(Lio/didomi/sdk/y1$a;Ljava/util/List;Lio/didomi/sdk/ah;)V", "android_release"}, k = 1, mv = {1, 8, 0})
public final class y1 extends RecyclerView.Adapter {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final a callback;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final List<DeviceStorageDisclosureItem> list;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final ah themeProvider;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¨\u0006\u0006"}, d2 = {"Lio/didomi/sdk/y1$a;", "", "", "index", "", "a", "android_release"}, k = 1, mv = {1, 8, 0})
    public interface a {
        void a(int index);
    }

    public y1(a callback, List<DeviceStorageDisclosureItem> list, ah themeProvider) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        Intrinsics.checkNotNullParameter(list, "list");
        Intrinsics.checkNotNullParameter(themeProvider, "themeProvider");
        this.callback = callback;
        this.list = list;
        this.themeProvider = themeProvider;
        setHasStableIds(true);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(z1 holder, final int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.a(this.list.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: io.didomi.sdk.y1$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                y1.a(this.f$0, position, view);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.list.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int position) {
        return this.list.get(position).getId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(y1 this$0, int i, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.callback.a(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public z1 onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        k3 k3VarA = k3.a(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(k3VarA, "inflate(LayoutInflater.f….context), parent, false)");
        return new z1(k3VarA, this.themeProvider);
    }
}
