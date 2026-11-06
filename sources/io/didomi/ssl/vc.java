package io.didomi.ssl;

import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.StyleSpan;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B)\b\u0007\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0005\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0004R\u0011\u0010\u000b\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, d2 = {"Lio/didomi/sdk/vc;", "Lio/didomi/sdk/n1;", "", "k", "()Ljava/lang/String;", "additionalDataProcessingHeaderLabel", "e", "illustrationsHeaderLabel", "Landroid/text/Spannable;", "l", "()Landroid/text/Spannable;", "completeDescriptionText", "Lio/didomi/sdk/e0;", "configurationRepository", "Lio/didomi/sdk/b6;", "eventsRepository", "Lio/didomi/sdk/u7;", "logoProvider", "Lio/didomi/sdk/n7;", "languagesHelper", "<init>", "(Lio/didomi/sdk/e0;Lio/didomi/sdk/b6;Lio/didomi/sdk/u7;Lio/didomi/sdk/n7;)V", "android_release"}, k = 1, mv = {1, 8, 0})
public final class vc extends n1 {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public vc(e0 configurationRepository, b6 eventsRepository, u7 logoProvider, n7 languagesHelper) {
        super(configurationRepository, eventsRepository, logoProvider, languagesHelper);
        Intrinsics.checkNotNullParameter(configurationRepository, "configurationRepository");
        Intrinsics.checkNotNullParameter(eventsRepository, "eventsRepository");
        Intrinsics.checkNotNullParameter(logoProvider, "logoProvider");
        Intrinsics.checkNotNullParameter(languagesHelper, "languagesHelper");
    }

    @Override // io.didomi.ssl.n1
    public String e() {
        return n7.a(getLanguagesHelper(), "purpose_illustration_explanation", gc.UPPER_CASE, null, null, 12, null);
    }

    public final String k() {
        return n7.a(getLanguagesHelper(), "additional_data_processing", null, null, null, 14, null);
    }

    public final Spannable l() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(b());
        List<String> listD = d();
        if (listD.isEmpty()) {
            listD = null;
        }
        if (listD != null) {
            if (spannableStringBuilder.length() > 0) {
                spannableStringBuilder.append((CharSequence) "\n\n");
            }
            StyleSpan styleSpan = new StyleSpan(1);
            int length = spannableStringBuilder.length();
            spannableStringBuilder.append((CharSequence) e());
            spannableStringBuilder.setSpan(styleSpan, length, spannableStringBuilder.length(), 17);
            Iterator<T> it = listD.iterator();
            while (it.hasNext()) {
                spannableStringBuilder.append((CharSequence) ("\n\n" + ((String) it.next())));
            }
        } else {
            String strC = c();
            String str = strC.length() > 0 ? strC : null;
            if (str != null) {
                if (spannableStringBuilder.length() > 0) {
                    spannableStringBuilder.append((CharSequence) "\n\n");
                }
                spannableStringBuilder.append((CharSequence) str);
            }
        }
        SpannableString spannableStringValueOf = SpannableString.valueOf(spannableStringBuilder);
        Intrinsics.checkNotNullExpressionValue(spannableStringValueOf, "valueOf(this)");
        return spannableStringValueOf;
    }
}
