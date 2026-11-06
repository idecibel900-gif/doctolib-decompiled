package io.didomi.ssl;

import android.os.Parcelable;
import com.amazon.a.a.o.b;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010 \n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001R\u0014\u0010\u0005\u001a\u00020\u00028&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u00028&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0004R\u001c\u0010\u000b\u001a\u00020\u00028&@&X¦\u000e¢\u0006\f\u001a\u0004\b\b\u0010\u0004\"\u0004\b\t\u0010\nR\u001c\u0010\u000e\u001a\u00020\u00028&@&X¦\u000e¢\u0006\f\u001a\u0004\b\f\u0010\u0004\"\u0004\b\r\u0010\nR\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00028&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u000f\u0010\u0004\"\u0004\b\u0010\u0010\nR$\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00128&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u0018"}, d2 = {"Lio/didomi/sdk/m1;", "Landroid/os/Parcelable;", "", "getId", "()Ljava/lang/String;", DiagnosticsEntry.ID_KEY, "getIabId", "iabId", "getName", "setName", "(Ljava/lang/String;)V", "name", "getDescription", "setDescription", b.c, "getDescriptionLegal", "setDescriptionLegal", "descriptionLegal", "", "getIllustrations", "()Ljava/util/List;", "setIllustrations", "(Ljava/util/List;)V", "illustrations", "android_release"}, k = 1, mv = {1, 8, 0})
public interface m1 extends Parcelable {
    String getDescription();

    String getDescriptionLegal();

    String getIabId();

    String getId();

    List<String> getIllustrations();

    String getName();

    void setDescription(String str);

    void setDescriptionLegal(String str);

    void setIllustrations(List<String> list);

    void setName(String str);
}
