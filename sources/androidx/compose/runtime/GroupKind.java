package androidx.compose.runtime;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes.dex */
abstract class GroupKind {
    public static final Companion Companion = new Companion(null);
    private static final int Group = m1067constructorimpl(0);
    private static final int Node = m1067constructorimpl(1);
    private static final int ReusableNode = m1067constructorimpl(2);

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    private static int m1067constructorimpl(int i) {
        return i;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: renamed from: getGroup-ULZAiWs, reason: not valid java name */
        public final int m1068getGroupULZAiWs() {
            return GroupKind.Group;
        }

        /* JADX INFO: renamed from: getNode-ULZAiWs, reason: not valid java name */
        public final int m1069getNodeULZAiWs() {
            return GroupKind.Node;
        }

        /* JADX INFO: renamed from: getReusableNode-ULZAiWs, reason: not valid java name */
        public final int m1070getReusableNodeULZAiWs() {
            return GroupKind.ReusableNode;
        }
    }
}
