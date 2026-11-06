package androidx.compose.ui.node;

/* JADX INFO: loaded from: classes.dex */
abstract class Snake {
    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static int[] m2002constructorimpl(int[] iArr) {
        return iArr;
    }

    /* JADX INFO: renamed from: getStartX-impl, reason: not valid java name */
    public static final int m2008getStartXimpl(int[] iArr) {
        return iArr[0];
    }

    /* JADX INFO: renamed from: getStartY-impl, reason: not valid java name */
    public static final int m2009getStartYimpl(int[] iArr) {
        return iArr[1];
    }

    /* JADX INFO: renamed from: getEndX-impl, reason: not valid java name */
    public static final int m2004getEndXimpl(int[] iArr) {
        return iArr[2];
    }

    /* JADX INFO: renamed from: getEndY-impl, reason: not valid java name */
    public static final int m2005getEndYimpl(int[] iArr) {
        return iArr[3];
    }

    /* JADX INFO: renamed from: getReverse-impl, reason: not valid java name */
    public static final boolean m2007getReverseimpl(int[] iArr) {
        return iArr[4] != 0;
    }

    /* JADX INFO: renamed from: getDiagonalSize-impl, reason: not valid java name */
    public static final int m2003getDiagonalSizeimpl(int[] iArr) {
        return Math.min(m2004getEndXimpl(iArr) - m2008getStartXimpl(iArr), m2005getEndYimpl(iArr) - m2009getStartYimpl(iArr));
    }

    /* JADX INFO: renamed from: getHasAdditionOrRemoval-impl, reason: not valid java name */
    private static final boolean m2006getHasAdditionOrRemovalimpl(int[] iArr) {
        return m2005getEndYimpl(iArr) - m2009getStartYimpl(iArr) != m2004getEndXimpl(iArr) - m2008getStartXimpl(iArr);
    }

    /* JADX INFO: renamed from: isAddition-impl, reason: not valid java name */
    private static final boolean m2010isAdditionimpl(int[] iArr) {
        return m2005getEndYimpl(iArr) - m2009getStartYimpl(iArr) > m2004getEndXimpl(iArr) - m2008getStartXimpl(iArr);
    }

    /* JADX INFO: renamed from: addDiagonalToStack-impl, reason: not valid java name */
    public static final void m2001addDiagonalToStackimpl(int[] iArr, IntStack intStack) {
        if (m2006getHasAdditionOrRemovalimpl(iArr)) {
            if (m2007getReverseimpl(iArr)) {
                intStack.pushDiagonal(m2008getStartXimpl(iArr), m2009getStartYimpl(iArr), m2003getDiagonalSizeimpl(iArr));
                return;
            } else if (m2010isAdditionimpl(iArr)) {
                intStack.pushDiagonal(m2008getStartXimpl(iArr), m2009getStartYimpl(iArr) + 1, m2003getDiagonalSizeimpl(iArr));
                return;
            } else {
                intStack.pushDiagonal(m2008getStartXimpl(iArr) + 1, m2009getStartYimpl(iArr), m2003getDiagonalSizeimpl(iArr));
                return;
            }
        }
        intStack.pushDiagonal(m2008getStartXimpl(iArr), m2009getStartYimpl(iArr), m2004getEndXimpl(iArr) - m2008getStartXimpl(iArr));
    }
}
