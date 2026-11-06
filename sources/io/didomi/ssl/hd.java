package io.didomi.ssl;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000M\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001\u0014\u0018\u0000 $2\u00020\u0001:\u0001\u0005B\u0007¢\u0006\u0004\b\"\u0010#J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J$\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\u001a\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u0013\u001a\u00020\u0004H\u0016R\u0014\u0010\u0016\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0015R\"\u0010\u001d\u001a\u00020\u00178\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0005\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0018\u0010!\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 ¨\u0006%"}, d2 = {"Lio/didomi/sdk/hd;", "Landroidx/fragment/app/Fragment;", "Lio/didomi/sdk/gi;", "listType", "", "a", "Landroid/content/Context;", "context", "onAttach", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "parent", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "view", "onViewCreated", "onDestroyView", "io/didomi/sdk/hd$b", "Lio/didomi/sdk/hd$b;", "callback", "Lio/didomi/sdk/qe;", "b", "Lio/didomi/sdk/qe;", "()Lio/didomi/sdk/qe;", "setModel", "(Lio/didomi/sdk/qe;)V", "model", "Lio/didomi/sdk/x2;", "c", "Lio/didomi/sdk/x2;", "binding", "<init>", "()V", "d", "android_release"}, k = 1, mv = {1, 8, 0})
public final class hd extends Fragment {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final b callback = new b();

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public qe model;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private x2 binding;

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¨\u0006\b"}, d2 = {"io/didomi/sdk/hd$b", "Lio/didomi/sdk/ge$a;", "Lio/didomi/sdk/gi;", "listType", "", "a", "", "position", "android_release"}, k = 1, mv = {1, 8, 0})
    public static final class b implements ge.a {
        b() {
        }

        @Override // io.didomi.sdk.ge.a
        public void a(gi listType) {
            Intrinsics.checkNotNullParameter(listType, "listType");
            hd.this.a(listType);
        }

        @Override // io.didomi.sdk.ge.a
        public void a(final int position) {
            FragmentActivity fragmentActivityRequireActivity = hd.this.requireActivity();
            final hd hdVar = hd.this;
            fragmentActivityRequireActivity.runOnUiThread(new Runnable() { // from class: io.didomi.sdk.hd$b$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    hd.b.a(hdVar, position);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void a(hd this$0, int i) {
            RecyclerView recyclerView;
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            x2 x2Var = this$0.binding;
            if (x2Var == null || (recyclerView = x2Var.b) == null) {
                return;
            }
            recyclerView.smoothScrollToPosition(i);
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "it", "", "a", "(I)Ljava/lang/Boolean;"}, k = 3, mv = {1, 8, 0})
    static final class c extends Lambda implements Function1 {
        final /* synthetic */ RecyclerView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(RecyclerView recyclerView) {
            super(1);
            this.a = recyclerView;
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0010  */
        public final Boolean a(int i) {
            boolean z;
            RecyclerView.Adapter adapter = this.a.getAdapter();
            if (adapter != null) {
                z = adapter.getItemViewType(i) == 1;
            }
            return Boolean.valueOf(z);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return a(((Number) obj).intValue());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Didomi.INSTANCE.getInstance().getComponent$android_release().a(this);
        super.onAttach(context);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        x2 x2VarA = x2.a(inflater, parent, false);
        this.binding = x2VarA;
        FrameLayout root = x2VarA.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "inflate(inflater, parent…g = it\n            }.root");
        return root;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        RecyclerView recyclerView;
        super.onDestroyView();
        x2 x2Var = this.binding;
        if (x2Var != null && (recyclerView = x2Var.b) != null) {
            recyclerView.setAdapter(null);
            recyclerView.setLayoutManager(null);
            recyclerView.setOnKeyListener(null);
        }
        this.binding = null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        RecyclerView recyclerView;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        x2 x2Var = this.binding;
        if (x2Var == null || (recyclerView = x2Var.b) == null) {
            return;
        }
        recyclerView.setAdapter(new ge(this.callback, a().E1()));
        recyclerView.setItemAnimator(null);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), 1, false));
        recyclerView.addItemDecoration(new g6(recyclerView, false, new c(recyclerView), 2, null));
        recyclerView.setHasFixedSize(true);
    }

    public final qe a() {
        qe qeVar = this.model;
        if (qeVar != null) {
            return qeVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("model");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(gi listType) {
        Purpose purpose = (Purpose) a().getSelectedPurpose().getValue();
        if (purpose == null) {
            return;
        }
        requireActivity().getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.didomi_enter_from_right, R.anim.didomi_fade_out, R.anim.didomi_fade_in, R.anim.didomi_exit_to_right_alpha).replace(R.id.container_ctv_preferences_secondary, yd.INSTANCE.a(purpose, listType)).addToBackStack("io.didomi.dialog.TV_PURPOSE_VENDORS_FRAGMENT").commit();
    }
}
