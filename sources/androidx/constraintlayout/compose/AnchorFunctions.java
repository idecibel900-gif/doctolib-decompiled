package androidx.constraintlayout.compose;

/* JADX INFO: loaded from: classes.dex */
public final class AnchorFunctions {
    public static final AnchorFunctions INSTANCE = new AnchorFunctions();

    private AnchorFunctions() {
    }

    public final String horizontalAnchorIndexToAnchorName(int i) {
        if (i == 0 || i != 1) {
            return "top";
        }
        return "bottom";
    }

    public final String verticalAnchorIndexToAnchorName(int i) {
        if (i == -2) {
            return "start";
        }
        if (i == -1) {
            return "end";
        }
        if (i == 0) {
            return "left";
        }
        if (i != 1) {
            return "start";
        }
        return "right";
    }
}
