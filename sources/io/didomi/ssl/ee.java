package io.didomi.ssl;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.style.StyleSpan;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import net.openid.appauth.AuthorizationRequest;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0017\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u0015"}, d2 = {"Lio/didomi/sdk/ee;", "Lio/didomi/sdk/ja;", "", "k", "Landroid/content/Context;", "context", "", "a", "", "Lio/didomi/sdk/be;", "b", "(Landroid/content/Context;)Ljava/util/List;", "j", "()Ljava/lang/String;", "listTypeLabel", "Lio/didomi/sdk/zh;", "vendorRepository", "Lio/didomi/sdk/n7;", "languagesHelper", "<init>", "(Lio/didomi/sdk/zh;Lio/didomi/sdk/n7;)V", "android_release"}, k = 1, mv = {1, 8, 0})
public class ee extends ja {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ee(zh vendorRepository, n7 languagesHelper) {
        super(vendorRepository, languagesHelper);
        Intrinsics.checkNotNullParameter(vendorRepository, "vendorRepository");
        Intrinsics.checkNotNullParameter(languagesHelper, "languagesHelper");
    }

    private final CharSequence a(Context context) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        String string = context.getResources().getString(R.string.didomi_iab_tag);
        Intrinsics.checkNotNullExpressionValue(string, "context.resources.getStr…(R.string.didomi_iab_tag)");
        int i = 0;
        for (Object obj : i()) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            Vendor vendor = (Vendor) obj;
            spannableStringBuilder.append((CharSequence) ("* " + fc.f(vendor.getName())));
            if (vendor.isIabVendor()) {
                StyleSpan styleSpan = new StyleSpan(1);
                int length = spannableStringBuilder.length();
                spannableStringBuilder.append((CharSequence) (' ' + string));
                spannableStringBuilder.setSpan(styleSpan, length, spannableStringBuilder.length(), 17);
            }
            if (i < CollectionsKt.getLastIndex(i())) {
                spannableStringBuilder.append((CharSequence) "\n");
            }
            i = i2;
        }
        return fc.k(spannableStringBuilder.toString());
    }

    private final String j() {
        return e() == gi.PurposeLI ? n7.a(getLanguagesHelper(), "legitimate_interest", (gc) null, (Map) null, 6, (Object) null) : n7.a(getLanguagesHelper(), AuthorizationRequest.Prompt.CONSENT, (gc) null, (Map) null, 6, (Object) null);
    }

    private final String k() {
        int size = i().size();
        return n7.a(getLanguagesHelper(), size == 1 ? "single_partner_count" : "simple_partners_count", null, MapsKt.mapOf(TuplesKt.to("{nb}", String.valueOf(size))), null, 10, null);
    }

    public final List<be> b(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ArrayList arrayList = new ArrayList();
        arrayList.add(new be.Header(0, 1, null));
        arrayList.add(new be.Title(f(), j(), k(), 0, 8, null));
        arrayList.add(new be.Content(a(context), 0, 2, null));
        arrayList.add(new be.Footer(0, 1, null));
        return arrayList;
    }
}
