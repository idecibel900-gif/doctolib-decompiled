package io.didomi.ssl;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import io.didomi.ssl.models.DeviceStorageDisclosures;
import io.didomi.ssl.view.ctv.CenterLayoutManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import net.openid.appauth.AuthorizationRequest;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000u\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b*\u0001'\u0018\u0000 \f2\u00020\u00012\u00020\u0002:\u0001\u0006B\u0007¢\u0006\u0004\b;\u0010<J\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\u0005H\u0002J\b\u0010\t\u001a\u00020\u0005H\u0002J\b\u0010\n\u001a\u00020\u0005H\u0002J\b\u0010\u000b\u001a\u00020\u0005H\u0002J\b\u0010\f\u001a\u00020\u0005H\u0002J\b\u0010\r\u001a\u00020\u0005H\u0002J\b\u0010\u000e\u001a\u00020\u0005H\u0002J\b\u0010\u000f\u001a\u00020\u0005H\u0002J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\u0010\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0012\u0010\u0019\u001a\u00020\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010\u001b\u001a\u00020\u001aH\u0016J\u0012\u0010\u001d\u001a\u00020\u001c2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016J$\u0010#\u001a\u00020\"2\u0006\u0010\u001f\u001a\u00020\u001e2\b\u0010!\u001a\u0004\u0018\u00010 2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016J\u001a\u0010%\u001a\u00020\u00052\u0006\u0010$\u001a\u00020\"2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010&\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016R\u0014\u0010)\u001a\u00020'8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010(R\u0018\u0010-\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010,R\"\u00104\u001a\u00020.8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b/\u00101\"\u0004\b2\u00103R\"\u0010:\u001a\u0002058\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\u000e\u00106\u001a\u0004\b+\u00107\"\u0004\b8\u00109¨\u0006="}, d2 = {"Lio/didomi/sdk/uf;", "Landroidx/appcompat/app/AppCompatDialogFragment;", "Lio/didomi/sdk/dh;", "", "loaded", "", "a", "(Ljava/lang/Boolean;)V", "f", "g", "h", "k", "e", "i", "d", "j", "Landroidx/fragment/app/Fragment;", AuthorizationRequest.ResponseMode.FRAGMENT, "", "tag", "Landroid/content/Context;", "context", "onAttach", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "", "getTheme", "Landroid/app/Dialog;", "onCreateDialog", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "parent", "Landroid/view/View;", "onCreateView", "view", "onViewCreated", "onDestroyView", "io/didomi/sdk/uf$c", "Lio/didomi/sdk/uf$c;", "vendorDetailAdapterCallback", "Lio/didomi/sdk/f3;", "b", "Lio/didomi/sdk/f3;", "binding", "Lio/didomi/sdk/ug;", "c", "Lio/didomi/sdk/ug;", "()Lio/didomi/sdk/ug;", "setModel", "(Lio/didomi/sdk/ug;)V", "model", "Lio/didomi/sdk/xc;", "Lio/didomi/sdk/xc;", "()Lio/didomi/sdk/xc;", "setDisclosuresModel", "(Lio/didomi/sdk/xc;)V", "disclosuresModel", "<init>", "()V", "android_release"}, k = 1, mv = {1, 8, 0})
public final class uf extends AppCompatDialogFragment implements dh {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final c vendorDetailAdapterCallback = new c();

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private f3 binding;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public ug model;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public xc disclosuresModel;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class b extends FunctionReferenceImpl implements Function1 {
        b(Object obj) {
            super(1, obj, uf.class, "handleDeviceStorageDisclosures", "handleDeviceStorageDisclosures(Ljava/lang/Boolean;)V", 0);
        }

        public final void a(Boolean bool) {
            ((uf) this.receiver).a(bool);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((Boolean) obj);
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\t\u001a\u00020\u0002H\u0016J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\u000b\u001a\u00020\u0002H\u0016J\b\u0010\n\u001a\u00020\u0002H\u0016J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\fH\u0016¨\u0006\u0011"}, d2 = {"io/didomi/sdk/uf$c", "Lio/didomi/sdk/lf$a;", "", "e", "f", "d", "a", "", "isChecked", "c", "b", "g", "", "index", "", DiagnosticsEntry.ID_KEY, "position", "android_release"}, k = 1, mv = {1, 8, 0})
    public static final class c implements lf.a {
        c() {
        }

        @Override // io.didomi.sdk.lf.a
        public void a() {
            uf.this.e();
        }

        @Override // io.didomi.sdk.lf.a
        public void b(boolean isChecked) {
            uf.this.c().d(isChecked);
        }

        @Override // io.didomi.sdk.lf.a
        public void c() {
            uf.this.i();
        }

        @Override // io.didomi.sdk.lf.a
        public void d() {
            uf.this.h();
        }

        @Override // io.didomi.sdk.lf.a
        public void e() {
            uf.this.k();
        }

        @Override // io.didomi.sdk.lf.a
        public void f() {
            uf.this.g();
        }

        @Override // io.didomi.sdk.lf.a
        public void g() {
            uf.this.d();
        }

        @Override // io.didomi.sdk.lf.a
        public void a(boolean isChecked) {
            uf.this.c().c(isChecked);
        }

        @Override // io.didomi.sdk.lf.a
        public void b() {
            uf.this.j();
        }

        @Override // io.didomi.sdk.lf.a
        public void a(String id) {
            Intrinsics.checkNotNullParameter(id, "id");
            uf.this.requireActivity().getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.didomi_enter_from_right, R.anim.didomi_fade_out, R.anim.didomi_fade_in, R.anim.didomi_exit_to_right_alpha).replace(R.id.container_ctv_preferences_secondary, gf.INSTANCE.a(id)).addToBackStack("TVVendorDataCategoryFragment").commit();
        }

        @Override // io.didomi.sdk.lf.a
        public void b(int index) {
            uf.this.b().b(index);
            uf.this.f();
        }

        @Override // io.didomi.sdk.lf.a
        public void a(final int position) {
            uf.this.c().d(position);
            FragmentActivity fragmentActivityRequireActivity = uf.this.requireActivity();
            final uf ufVar = uf.this;
            fragmentActivityRequireActivity.runOnUiThread(new Runnable() { // from class: io.didomi.sdk.uf$c$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    uf.c.a(ufVar, position);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void a(uf this$0, int i) {
            RecyclerView recyclerView;
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            f3 f3Var = this$0.binding;
            if (f3Var == null || (recyclerView = f3Var.b) == null) {
                return;
            }
            recyclerView.smoothScrollToPosition(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j() {
        a(new cg(), "TVVendorEssentialDataFragment");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k() {
        a(new og(), "TVVendorPrivacyFragment");
    }

    @Override // androidx.fragment.app.DialogFragment
    public int getTheme() {
        return R.style.Didomi_Theme_TVDialog;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Didomi.INSTANCE.getInstance().getComponent$android_release().a(this);
        super.onAttach(context);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        c().d(0);
    }

    @Override // androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialogOnCreateDialog = super.onCreateDialog(savedInstanceState);
        dialogOnCreateDialog.setCancelable(false);
        dialogOnCreateDialog.setCanceledOnTouchOutside(false);
        Window window = dialogOnCreateDialog.getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new InsetDrawable((Drawable) new ColorDrawable(0), 0, 0, 0, 0));
        }
        Intrinsics.checkNotNullExpressionValue(dialogOnCreateDialog, "super.onCreateDialog(sav…), 0, 0, 0, 0))\n        }");
        return dialogOnCreateDialog;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        f3 f3VarA = f3.a(inflater, parent, false);
        this.binding = f3VarA;
        FrameLayout root = f3VarA.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "inflate(inflater, parent…nding = it\n        }.root");
        return root;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        RecyclerView recyclerView;
        super.onDestroyView();
        c().getSelectedVendorDeviceStorageDisclosuresLoaded().removeObservers(getViewLifecycleOwner());
        f3 f3Var = this.binding;
        if (f3Var != null && (recyclerView = f3Var.b) != null) {
            recyclerView.setAdapter(null);
            recyclerView.setLayoutManager(null);
        }
        this.binding = null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        RecyclerView recyclerView;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        f3 f3Var = this.binding;
        if (f3Var != null && (recyclerView = f3Var.b) != null) {
            recyclerView.setAdapter(new lf(this.vendorDetailAdapterCallback, c().u0()));
            recyclerView.setItemAnimator(null);
            Context context = recyclerView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            recyclerView.setLayoutManager(new CenterLayoutManager(context, 1, false));
            recyclerView.setHasFixedSize(true);
        }
        ug ugVarC = c();
        if (ugVarC.a0()) {
            a(Boolean.TRUE);
            return;
        }
        MutableLiveData selectedVendorDeviceStorageDisclosuresLoaded = ugVarC.getSelectedVendorDeviceStorageDisclosuresLoaded();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final b bVar = new b(this);
        selectedVendorDeviceStorageDisclosuresLoaded.observe(viewLifecycleOwner, new Observer() { // from class: io.didomi.sdk.uf$$ExternalSyntheticLambda1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                uf.a(bVar, obj);
            }
        });
        Object value = ugVarC.getSelectedVendor().getValue();
        Intrinsics.checkNotNull(value, "null cannot be cast to non-null type io.didomi.sdk.Vendor");
        ugVarC.B((Vendor) value);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d() {
        a(new ue(), "TVVendorAdditionalDataFragment");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e() {
        a(new ff(), "TVVendorConsentDataFragment");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f() {
        a(new ag(), "io.didomi.dialog.VENDOR_DISCLOSURES_DETAIL");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g() {
        a(new fg(), "TVVendorIabFragment");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h() {
        a(new jg(), "TVVendorLegIntClaimFragment");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i() {
        a(new lg(), "TVVendorLegIntDataFragment");
    }

    public final xc b() {
        xc xcVar = this.disclosuresModel;
        if (xcVar != null) {
            return xcVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("disclosuresModel");
        return null;
    }

    public final ug c() {
        ug ugVar = this.model;
        if (ugVar != null) {
            return ugVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("model");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // io.didomi.ssl.dh
    public void a() {
        final f3 f3Var = this.binding;
        if (f3Var != null) {
            f3Var.getRoot().postDelayed(new Runnable() { // from class: io.didomi.sdk.uf$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    uf.a(f3Var, this);
                }
            }, 100L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(f3 this_apply, uf this$0) {
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        RecyclerView.Adapter adapter = this_apply.b.getAdapter();
        lf lfVar = adapter instanceof lf ? (lf) adapter : null;
        if (lfVar != null) {
            lfVar.a(this$0.c().getDetailFocusedPosition());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(Boolean loaded) {
        Vendor vendor;
        DeviceStorageDisclosures deviceStorageDisclosures;
        RecyclerView recyclerView;
        if (!Intrinsics.areEqual(loaded, Boolean.TRUE) || (vendor = (Vendor) c().getSelectedVendor().getValue()) == null || (deviceStorageDisclosures = vendor.getDeviceStorageDisclosures()) == null) {
            return;
        }
        b().a(vendor.getName(), deviceStorageDisclosures);
        f3 f3Var = this.binding;
        RecyclerView.Adapter adapter = (f3Var == null || (recyclerView = f3Var.b) == null) ? null : recyclerView.getAdapter();
        lf lfVar = adapter instanceof lf ? (lf) adapter : null;
        if (lfVar != null) {
            lfVar.a(b().a(c().s(), yh.h(vendor)));
        }
    }

    private final void a(Fragment fragment, String tag) {
        requireActivity().getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.didomi_enter_from_right, R.anim.didomi_fade_out, R.anim.didomi_fade_in, R.anim.didomi_exit_to_right_alpha).replace(R.id.container_ctv_preferences_secondary, fragment, tag).addToBackStack(tag).commit();
    }
}
