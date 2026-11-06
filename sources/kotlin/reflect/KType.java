package kotlin.reflect;

import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public interface KType extends KAnnotatedElement {
    List getArguments();

    KClassifier getClassifier();

    boolean isMarkedNullable();
}
