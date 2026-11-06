package androidx.constraintlayout.compose;

import androidx.constraintlayout.core.parser.CLArray;
import androidx.constraintlayout.core.parser.CLNumber;
import androidx.constraintlayout.core.parser.CLObject;
import androidx.constraintlayout.core.parser.CLString;

/* JADX INFO: loaded from: classes.dex */
public abstract class BaseHorizontalAnchorable implements HorizontalAnchorable {
    private final String anchorName;
    private final CLObject containerObject;

    public BaseHorizontalAnchorable(CLObject cLObject, int i) {
        this.containerObject = cLObject;
        this.anchorName = AnchorFunctions.INSTANCE.horizontalAnchorIndexToAnchorName(i);
    }

    @Override // androidx.constraintlayout.compose.HorizontalAnchorable
    /* JADX INFO: renamed from: linkTo-VpY3zN4, reason: not valid java name */
    public final void mo2678linkToVpY3zN4(ConstraintLayoutBaseScope.HorizontalAnchor horizontalAnchor, float f, float f2) {
        String strHorizontalAnchorIndexToAnchorName = AnchorFunctions.INSTANCE.horizontalAnchorIndexToAnchorName(horizontalAnchor.getIndex$constraintlayout_compose_release());
        CLArray cLArray = new CLArray(new char[0]);
        cLArray.add(CLString.from(horizontalAnchor.getId$constraintlayout_compose_release().toString()));
        cLArray.add(CLString.from(strHorizontalAnchorIndexToAnchorName));
        cLArray.add(new CLNumber(f));
        cLArray.add(new CLNumber(f2));
        this.containerObject.put(this.anchorName, cLArray);
    }
}
