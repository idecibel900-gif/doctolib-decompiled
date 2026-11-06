package androidx.compose.ui.geometry;

/* JADX INFO: loaded from: classes.dex */
public abstract class RectKt {
    /* JADX INFO: renamed from: Rect-tz77jQw, reason: not valid java name */
    public static final Rect m1247Recttz77jQw(long j, long j2) {
        return new Rect(Offset.m1223getXimpl(j), Offset.m1224getYimpl(j), Offset.m1223getXimpl(j) + Size.m1261getWidthimpl(j2), Offset.m1224getYimpl(j) + Size.m1259getHeightimpl(j2));
    }

    /* JADX INFO: renamed from: Rect-0a9Yr6o, reason: not valid java name */
    public static final Rect m1246Rect0a9Yr6o(long j, long j2) {
        return new Rect(Offset.m1223getXimpl(j), Offset.m1224getYimpl(j), Offset.m1223getXimpl(j2), Offset.m1224getYimpl(j2));
    }
}
