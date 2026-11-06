package kotlin.reflect;

import java.util.Collection;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public interface KClass extends KDeclarationContainer, KAnnotatedElement, KClassifier {
    Collection getConstructors();

    String getQualifiedName();

    String getSimpleName();

    List getSupertypes();

    int hashCode();

    boolean isInstance(Object obj);

    boolean isValue();
}
