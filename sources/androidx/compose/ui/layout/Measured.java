package androidx.compose.ui.layout;

/* JADX INFO: loaded from: classes.dex */
public interface Measured {
    int get(AlignmentLine alignmentLine);

    default Object getParentData() {
        return null;
    }
}
