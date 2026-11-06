package io.didomi.ssl;

import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import io.didomi.ssl.models.DeviceStorageDisclosure;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00052\u00020\u0001:\u0001\u0016B\u0007¢\u0006\u0004\b)\u0010*J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016J$\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\u001a\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u0014\u001a\u00020\u0002H\u0016R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\"\u0010\u001f\u001a\u00020\u00198\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001a\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010%\u001a\u00020 8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\u0004\u0010!\u001a\u0004\b\u0016\u0010\"\"\u0004\b#\u0010$R\u0014\u0010(\u001a\u00020&8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010'¨\u0006+"}, d2 = {"Lio/didomi/sdk/ag;", "Landroidx/fragment/app/Fragment;", "", "d", "c", "e", "f", "Landroid/content/Context;", "context", "onAttach", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "parent", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "view", "onViewCreated", "onDestroyView", "Lio/didomi/sdk/w2;", "a", "Lio/didomi/sdk/w2;", "binding", "Lio/didomi/sdk/ug;", "b", "Lio/didomi/sdk/ug;", "()Lio/didomi/sdk/ug;", "setModel", "(Lio/didomi/sdk/ug;)V", "model", "Lio/didomi/sdk/xc;", "Lio/didomi/sdk/xc;", "()Lio/didomi/sdk/xc;", "setDisclosuresModel", "(Lio/didomi/sdk/xc;)V", "disclosuresModel", "Landroid/view/View$OnKeyListener;", "Landroid/view/View$OnKeyListener;", "keyListener", "<init>", "()V", "android_release"}, k = 1, mv = {1, 8, 0})
public final class ag extends Fragment {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private w2 binding;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public ug model;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public xc disclosuresModel;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private final View.OnKeyListener keyListener = new View.OnKeyListener() { // from class: io.didomi.sdk.ag$$ExternalSyntheticLambda2
        @Override // android.view.View.OnKeyListener
        public final boolean onKey(View view, int i, KeyEvent keyEvent) {
            return ag.a(this.f$0, view, i, keyEvent);
        }
    };

    private final void c() {
        w2 w2Var = this.binding;
        if (w2Var != null) {
            List<DeviceStorageDisclosure> listT = a().t();
            int size = listT != null ? listT.size() : 0;
            if (size >= 0 && size < 2) {
                ImageView imageView = w2Var.b;
                Intrinsics.checkNotNullExpressionValue(imageView, "imageCtvDeviceStorageDis…osureDetailLeftArrowImage");
                imageView.setVisibility(4);
                ImageView imageView2 = w2Var.c;
                Intrinsics.checkNotNullExpressionValue(imageView2, "imageCtvDeviceStorageDis…sureDetailRightArrowImage");
                imageView2.setVisibility(4);
                return;
            }
            int selectedIndex = a().getSelectedIndex();
            if (selectedIndex == 0) {
                ImageView imageView3 = w2Var.c;
                Intrinsics.checkNotNullExpressionValue(imageView3, "imageCtvDeviceStorageDis…sureDetailRightArrowImage");
                imageView3.setVisibility(0);
                ImageView imageView4 = w2Var.b;
                Intrinsics.checkNotNullExpressionValue(imageView4, "imageCtvDeviceStorageDis…osureDetailLeftArrowImage");
                imageView4.setVisibility(4);
                return;
            }
            if (selectedIndex == size - 1) {
                ImageView imageView5 = w2Var.c;
                Intrinsics.checkNotNullExpressionValue(imageView5, "imageCtvDeviceStorageDis…sureDetailRightArrowImage");
                imageView5.setVisibility(4);
                ImageView imageView6 = w2Var.b;
                Intrinsics.checkNotNullExpressionValue(imageView6, "imageCtvDeviceStorageDis…osureDetailLeftArrowImage");
                imageView6.setVisibility(0);
                return;
            }
            ImageView imageView7 = w2Var.c;
            Intrinsics.checkNotNullExpressionValue(imageView7, "imageCtvDeviceStorageDis…sureDetailRightArrowImage");
            imageView7.setVisibility(0);
            ImageView imageView8 = w2Var.b;
            Intrinsics.checkNotNullExpressionValue(imageView8, "imageCtvDeviceStorageDis…osureDetailLeftArrowImage");
            imageView8.setVisibility(0);
        }
    }

    private final void d() {
        c();
        e();
        f();
    }

    private final void e() {
        TextSwitcher textSwitcher;
        DeviceStorageDisclosure selectedDisclosure = a().getSelectedDisclosure();
        if (selectedDisclosure != null) {
            String strA = a().a(selectedDisclosure);
            w2 w2Var = this.binding;
            if (w2Var == null || (textSwitcher = w2Var.f) == null) {
                return;
            }
            textSwitcher.setText(strA);
        }
    }

    private final void f() {
        TextSwitcher textSwitcher;
        w2 w2Var = this.binding;
        if (w2Var == null || (textSwitcher = w2Var.g) == null) {
            return;
        }
        textSwitcher.setText(a().u());
    }

    public final xc a() {
        xc xcVar = this.disclosuresModel;
        if (xcVar != null) {
            return xcVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("disclosuresModel");
        return null;
    }

    public final ug b() {
        ug ugVar = this.model;
        if (ugVar != null) {
            return ugVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("model");
        return null;
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
        w2 w2VarA = w2.a(getLayoutInflater(), parent, false);
        this.binding = w2VarA;
        ConstraintLayout root = w2VarA.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "inflate(layoutInflater, …g = it\n            }.root");
        return root;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        ScrollView scrollView;
        super.onDestroyView();
        w2 w2Var = this.binding;
        if (w2Var != null && (scrollView = w2Var.e) != null) {
            scrollView.setOnKeyListener(null);
        }
        this.binding = null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        w2 w2Var = this.binding;
        if (w2Var != null) {
            w2Var.e.setOnKeyListener(this.keyListener);
            w2Var.f.setFactory(new ViewSwitcher.ViewFactory() { // from class: io.didomi.sdk.ag$$ExternalSyntheticLambda0
                @Override // android.widget.ViewSwitcher.ViewFactory
                public final View makeView() {
                    return ag.a(this.f$0);
                }
            });
            w2Var.g.setFactory(new ViewSwitcher.ViewFactory() { // from class: io.didomi.sdk.ag$$ExternalSyntheticLambda1
                @Override // android.widget.ViewSwitcher.ViewFactory
                public final View makeView() {
                    return ag.b(this.f$0);
                }
            });
            w2Var.d.getLayoutTransition().enableTransitionType(4);
            w2Var.h.setText(a().q());
        }
        d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean a(ag this$0, View view, int i, KeyEvent keyEvent) {
        TextSwitcher textSwitcher;
        TextSwitcher textSwitcher2;
        TextSwitcher textSwitcher3;
        TextSwitcher textSwitcher4;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i == 21 && keyEvent.getAction() == 1) {
            if (this$0.a().getSelectedIndex() > 0) {
                this$0.a().s();
                ug ugVarB = this$0.b();
                ugVarB.d(ugVarB.getDetailFocusedPosition() - 1);
                w2 w2Var = this$0.binding;
                if (w2Var != null && (textSwitcher4 = w2Var.g) != null) {
                    textSwitcher4.setInAnimation(textSwitcher4.getContext(), R.anim.didomi_text_enter_from_left_alpha);
                    textSwitcher4.setOutAnimation(textSwitcher4.getContext(), R.anim.didomi_text_exit_to_right_alpha);
                }
                w2 w2Var2 = this$0.binding;
                if (w2Var2 != null && (textSwitcher3 = w2Var2.f) != null) {
                    textSwitcher3.setInAnimation(textSwitcher3.getContext(), R.anim.didomi_text_enter_from_left_alpha);
                    textSwitcher3.setOutAnimation(textSwitcher3.getContext(), R.anim.didomi_text_exit_to_right_alpha);
                }
                this$0.d();
            }
        } else {
            if (i != 22 || keyEvent.getAction() != 1) {
                return false;
            }
            List<DeviceStorageDisclosure> listT = this$0.a().t();
            if (listT != null) {
                if (this$0.a().getSelectedIndex() < listT.size() - 1) {
                    this$0.a().r();
                    ug ugVarB2 = this$0.b();
                    ugVarB2.d(ugVarB2.getDetailFocusedPosition() + 1);
                    w2 w2Var3 = this$0.binding;
                    if (w2Var3 != null && (textSwitcher2 = w2Var3.g) != null) {
                        textSwitcher2.setInAnimation(textSwitcher2.getContext(), R.anim.didomi_text_enter_from_right_alpha);
                        textSwitcher2.setOutAnimation(textSwitcher2.getContext(), R.anim.didomi_text_exit_to_left_alpha);
                    }
                    w2 w2Var4 = this$0.binding;
                    if (w2Var4 != null && (textSwitcher = w2Var4.f) != null) {
                        textSwitcher.setInAnimation(textSwitcher.getContext(), R.anim.didomi_text_enter_from_right_alpha);
                        textSwitcher.setOutAnimation(textSwitcher.getContext(), R.anim.didomi_text_exit_to_left_alpha);
                    }
                    this$0.d();
                }
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final View b(ag this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        TextView textView = new TextView(this$0.getContext());
        textView.setTextAppearance(R.style.DidomiTVTextAction);
        return textView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final View a(ag this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        TextView textView = new TextView(this$0.getContext());
        textView.setTextAppearance(R.style.DidomiTVTextLarge);
        return textView;
    }
}
