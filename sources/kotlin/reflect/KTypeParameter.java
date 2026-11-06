package kotlin.reflect;

import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public interface KTypeParameter extends KClassifier {
    String getName();

    List getUpperBounds();

    KVariance getVariance();
}
