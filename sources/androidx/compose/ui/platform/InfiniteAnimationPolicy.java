package androidx.compose.ui.platform;

import kotlin.coroutines.CoroutineContext;

/* JADX INFO: loaded from: classes.dex */
public interface InfiniteAnimationPolicy extends CoroutineContext.Element {
    public static final Key Key = Key.$$INSTANCE;

    public static final class Key implements CoroutineContext.Key {
        static final /* synthetic */ Key $$INSTANCE = new Key();

        private Key() {
        }
    }
}
