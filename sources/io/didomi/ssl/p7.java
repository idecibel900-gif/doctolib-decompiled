package io.didomi.ssl;

import android.text.Editable;
import android.text.Html;
import java.util.List;
import java.util.Vector;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.xml.sax.XMLReader;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u0000 \n2\u00020\u0001:\u0001\u0005B\u0007¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J(\u0010\u000f\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rH\u0016R\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0011R\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0011¨\u0006\u0017"}, d2 = {"Lio/didomi/sdk/p7;", "Landroid/text/Html$TagHandler;", "", "tag", "", "a", "Landroid/text/Editable;", "output", "b", "d", "c", "", "opening", "Lorg/xml/sax/XMLReader;", "xmlReader", "handleTag", "Ljava/util/Vector;", "Ljava/util/Vector;", "parents", "", "counters", "<init>", "()V", "android_release"}, k = 1, mv = {1, 8, 0})
public final class p7 implements Html.TagHandler {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final Vector<String> parents = new Vector<>();

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final Vector<Integer> counters = new Vector<>();

    private final void a(String tag) {
        Vector<String> vector = this.parents;
        vector.add(vector.size(), tag);
        Vector<Integer> vector2 = this.counters;
        vector2.add(vector2.size(), 0);
    }

    private final void b(Editable output) {
        if (Intrinsics.areEqual(CollectionsKt.lastOrNull((List) this.parents), "ul-tag")) {
            d(output);
        } else if (Intrinsics.areEqual(CollectionsKt.lastOrNull((List) this.parents), "ol-tag")) {
            c(output);
        }
    }

    private final void c(Editable output) {
        if (output.length() > 0) {
            output.append("\n");
        }
        int size = this.counters.size();
        for (int i = 1; i < size; i++) {
            output.append("\t");
        }
        int iIntValue = this.counters.lastElement().intValue() + 1;
        output.append((CharSequence) (iIntValue + ". "));
        Vector<Integer> vector = this.counters;
        vector.removeElementAt(vector.size() - 1);
        Vector<Integer> vector2 = this.counters;
        vector2.add(vector2.size(), Integer.valueOf(iIntValue));
    }

    private final void d(Editable output) {
        if (output.length() > 0) {
            output.append("\n");
        }
        int size = this.counters.size();
        for (int i = 1; i < size; i++) {
            output.append("\t");
        }
        output.append("• ");
    }

    @Override // android.text.Html.TagHandler
    public void handleTag(boolean opening, String tag, Editable output, XMLReader xmlReader) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(output, "output");
        Intrinsics.checkNotNullParameter(xmlReader, "xmlReader");
        if (Intrinsics.areEqual(tag, "ul-tag") || Intrinsics.areEqual(tag, "ol-tag")) {
            if (opening) {
                a(tag);
                return;
            } else {
                a(output);
                return;
            }
        }
        if (Intrinsics.areEqual(tag, "li-tag") && opening) {
            b(output);
        }
    }

    private final void a(Editable output) {
        if (this.parents.size() == 1) {
            output.append("\n");
        }
        Vector<String> vector = this.parents;
        vector.removeElementAt(vector.size() - 1);
        Vector<Integer> vector2 = this.counters;
        vector2.removeElementAt(vector2.size() - 1);
    }
}
