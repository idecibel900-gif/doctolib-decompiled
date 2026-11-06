package androidx.constraintlayout.compose;

import androidx.constraintlayout.core.parser.CLArray;
import androidx.constraintlayout.core.parser.CLNumber;
import androidx.constraintlayout.core.parser.CLObject;
import androidx.constraintlayout.core.parser.CLString;

/* JADX INFO: loaded from: classes.dex */
public abstract class BaseVerticalAnchorable implements VerticalAnchorable {
    private final String anchorName;
    private final CLObject containerObject;

    public BaseVerticalAnchorable(CLObject cLObject, int i) {
        this.containerObject = cLObject;
        this.anchorName = AnchorFunctions.INSTANCE.verticalAnchorIndexToAnchorName(i);
    }

    @Override // androidx.constraintlayout.compose.VerticalAnchorable
    /* JADX INFO: renamed from: linkTo-VpY3zN4, reason: not valid java name */
    public final void mo2679linkToVpY3zN4(ConstraintLayoutBaseScope.VerticalAnchor verticalAnchor, float f, float f2) {
        String strVerticalAnchorIndexToAnchorName = AnchorFunctions.INSTANCE.verticalAnchorIndexToAnchorName(verticalAnchor.getIndex$constraintlayout_compose_release());
        CLArray cLArray = new CLArray(new char[0]);
        cLArray.add(CLString.from(verticalAnchor.getId$constraintlayout_compose_release().toString()));
        cLArray.add(CLString.from(strVerticalAnchorIndexToAnchorName));
        cLArray.add(new CLNumber(f));
        cLArray.add(new CLNumber(f2));
        this.containerObject.put(this.anchorName, cLArray);
    }
}
