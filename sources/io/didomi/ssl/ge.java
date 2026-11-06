package io.didomi.ssl;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\fB\u001d\u0012\u0006\u0010\u0011\u001a\u00020\u000f\u0012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012¢\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0003H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0016J\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0003H\u0016J\u0018\u0010\f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0003H\u0016R\u0014\u0010\u0011\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u0010R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lio/didomi/sdk/ge;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lio/didomi/sdk/ne;", "", "getItemCount", "position", "", "getItemId", "getItemViewType", "Landroid/view/ViewGroup;", "parent", "viewType", "a", "holder", "", "Lio/didomi/sdk/ge$a;", "Lio/didomi/sdk/ge$a;", "callback", "", "Lio/didomi/sdk/gd;", "b", "Ljava/util/List;", "list", "<init>", "(Lio/didomi/sdk/ge$a;Ljava/util/List;)V", "android_release"}, k = 1, mv = {1, 8, 0})
public final class ge extends RecyclerView.Adapter {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final a callback;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final List<gd> list;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&¨\u0006\b"}, d2 = {"Lio/didomi/sdk/ge$a;", "", "Lio/didomi/sdk/gi;", "listType", "", "a", "", "position", "android_release"}, k = 1, mv = {1, 8, 0})
    public interface a {
        void a(int position);

        void a(gi listType);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ge(a callback, List<? extends gd> list) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        Intrinsics.checkNotNullParameter(list, "list");
        this.callback = callback;
        this.list = list;
        setHasStableIds(true);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.list.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int position) {
        return this.list.get(position).a();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return this.list.get(position).getTypeId();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ne onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (viewType == 100) {
            w3 w3VarA = w3.a(LayoutInflater.from(parent.getContext()), parent, false);
            Intrinsics.checkNotNullExpressionValue(w3VarA, "inflate(LayoutInflater.f….context), parent, false)");
            return new ie(w3VarA);
        }
        if (viewType == 0) {
            y3 y3VarA = y3.a(LayoutInflater.from(parent.getContext()), parent, false);
            Intrinsics.checkNotNullExpressionValue(y3VarA, "inflate(LayoutInflater.f….context), parent, false)");
            return new je(y3VarA);
        }
        if (viewType == 1) {
            a4 a4VarA = a4.a(LayoutInflater.from(parent.getContext()), parent, false);
            Intrinsics.checkNotNullExpressionValue(a4VarA, "inflate(LayoutInflater.f….context), parent, false)");
            return new le(a4VarA);
        }
        if (viewType == 2) {
            z3 z3VarA = z3.a(LayoutInflater.from(parent.getContext()), parent, false);
            Intrinsics.checkNotNullExpressionValue(z3VarA, "inflate(LayoutInflater.f….context), parent, false)");
            return new ke(z3VarA);
        }
        if (viewType == 3) {
            x3 x3VarA = x3.a(LayoutInflater.from(parent.getContext()), parent, false);
            Intrinsics.checkNotNullExpressionValue(x3VarA, "inflate(LayoutInflater.f….context), parent, false)");
            return new he(x3VarA);
        }
        if (viewType == 4) {
            b4 b4VarA = b4.a(LayoutInflater.from(parent.getContext()), parent, false);
            Intrinsics.checkNotNullExpressionValue(b4VarA, "inflate(LayoutInflater.f….context), parent, false)");
            return new me(b4VarA);
        }
        throw new ClassCastException("Unknown viewType " + viewType);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(ne holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (holder instanceof he) {
            gd gdVar = this.list.get(position);
            Intrinsics.checkNotNull(gdVar, "null cannot be cast to non-null type io.didomi.sdk.purpose.ctv.model.TVPurposeAdditionalInfo.AdditionalDescription");
            ((he) holder).a((gd.AdditionalDescription) gdVar);
            return;
        }
        if (holder instanceof le) {
            gd gdVar2 = this.list.get(position);
            Intrinsics.checkNotNull(gdVar2, "null cannot be cast to non-null type io.didomi.sdk.purpose.ctv.model.TVPurposeAdditionalInfo.Title");
            ((le) holder).a((gd.Title) gdVar2);
        } else if (holder instanceof ke) {
            gd gdVar3 = this.list.get(position);
            Intrinsics.checkNotNull(gdVar3, "null cannot be cast to non-null type io.didomi.sdk.purpose.ctv.model.TVPurposeAdditionalInfo.Subtitle");
            ((ke) holder).a((gd.Subtitle) gdVar3);
        } else if (holder instanceof me) {
            a aVar = this.callback;
            gd gdVar4 = this.list.get(position);
            Intrinsics.checkNotNull(gdVar4, "null cannot be cast to non-null type io.didomi.sdk.purpose.ctv.model.TVPurposeAdditionalInfo.VendorsCount");
            ((me) holder).a(aVar, position, (gd.VendorsCount) gdVar4);
        }
    }
}
