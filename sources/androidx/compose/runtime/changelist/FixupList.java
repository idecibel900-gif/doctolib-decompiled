package androidx.compose.runtime.changelist;

import androidx.compose.runtime.Anchor;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.PreconditionsKt;
import androidx.compose.runtime.RememberManager;
import androidx.compose.runtime.SlotWriter;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class FixupList extends OperationsDebugStringFormattable {
    private final Operations operations = new Operations();
    private final Operations pendingOperations = new Operations();

    public final boolean isEmpty() {
        return this.operations.isEmpty();
    }

    public final void clear() {
        this.pendingOperations.clear();
        this.operations.clear();
    }

    public final void executeAndFlushAllPendingFixups(Applier applier, SlotWriter slotWriter, RememberManager rememberManager) {
        if (!this.pendingOperations.isEmpty()) {
            ComposerKt.composeImmediateRuntimeError("FixupList has pending fixup operations that were not realized. Were there mismatched insertNode() and endNodeInsert() calls?");
        }
        this.operations.executeAndFlushAllPendingOperations(applier, slotWriter, rememberManager);
    }

    public final void createAndInsertNode(Function0 function0, int i, Anchor anchor) {
        int i2;
        int i3;
        int i4;
        Operations operations = this.operations;
        Operation.InsertNodeFixup insertNodeFixup = Operation.InsertNodeFixup.INSTANCE;
        operations.pushOp(insertNodeFixup);
        Operations operationsM1101constructorimpl = Operations.WriteScope.m1101constructorimpl(operations);
        Operations.WriteScope.m1104setObjectDKhxnng(operationsM1101constructorimpl, Operation.ObjectParameter.m1093constructorimpl(0), function0);
        Operations.WriteScope.m1103setIntA6tL2VI(operationsM1101constructorimpl, Operation.IntParameter.m1091constructorimpl(0), i);
        Operations.WriteScope.m1104setObjectDKhxnng(operationsM1101constructorimpl, Operation.ObjectParameter.m1093constructorimpl(1), anchor);
        if (operations.pushedIntMask == operations.createExpectedArgMask(insertNodeFixup.getInts()) && operations.pushedObjectMask == operations.createExpectedArgMask(insertNodeFixup.getObjects())) {
            i2 = 0;
            i3 = 1;
        } else {
            StringBuilder sb = new StringBuilder();
            i2 = 0;
            i3 = 1;
            int i5 = 0;
            int i6 = 0;
            for (int ints = insertNodeFixup.getInts(); i6 < ints; ints = ints) {
                if (((1 << i6) & operations.pushedIntMask) != 0) {
                    if (i5 > 0) {
                        sb.append(", ");
                    }
                    sb.append(insertNodeFixup.mo1089intParamNamew8GmfQM(Operation.IntParameter.m1091constructorimpl(i6)));
                    i5++;
                }
                i6++;
            }
            String string = sb.toString();
            Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
            StringBuilder sb2 = new StringBuilder();
            int objects = insertNodeFixup.getObjects();
            int i7 = 0;
            int i8 = 0;
            while (i8 < objects) {
                if (((1 << i8) & operations.pushedObjectMask) != 0) {
                    if (i5 > 0) {
                        sb2.append(", ");
                    }
                    i4 = i8;
                    sb2.append(insertNodeFixup.mo1090objectParamName31yXWZQ(Operation.ObjectParameter.m1093constructorimpl(i4)));
                    i7++;
                } else {
                    i4 = i8;
                }
                i8 = i4 + 1;
            }
            String string2 = sb2.toString();
            Intrinsics.checkNotNullExpressionValue(string2, "StringBuilder().apply(builderAction).toString()");
            PreconditionsKt.throwIllegalStateException("Error while pushing " + insertNodeFixup + ". Not all arguments were provided. Missing " + i5 + " int arguments (" + string + ") and " + i7 + " object arguments (" + string2 + ").");
        }
        Operations operations2 = this.pendingOperations;
        Operation.PostInsertNodeFixup postInsertNodeFixup = Operation.PostInsertNodeFixup.INSTANCE;
        operations2.pushOp(postInsertNodeFixup);
        Operations operationsM1101constructorimpl2 = Operations.WriteScope.m1101constructorimpl(operations2);
        Operations.WriteScope.m1103setIntA6tL2VI(operationsM1101constructorimpl2, Operation.IntParameter.m1091constructorimpl(i2), i);
        Operations.WriteScope.m1104setObjectDKhxnng(operationsM1101constructorimpl2, Operation.ObjectParameter.m1093constructorimpl(i2), anchor);
        if (((operations2.pushedIntMask == operations2.createExpectedArgMask(postInsertNodeFixup.getInts()) && operations2.pushedObjectMask == operations2.createExpectedArgMask(postInsertNodeFixup.getObjects())) ? i3 : i2) == 0) {
            StringBuilder sb3 = new StringBuilder();
            int ints2 = postInsertNodeFixup.getInts();
            int i9 = i2;
            int i10 = i9;
            while (i9 < ints2) {
                if (((i3 << i9) & operations2.pushedIntMask) != 0) {
                    if (i10 > 0) {
                        sb3.append(", ");
                    }
                    sb3.append(postInsertNodeFixup.mo1089intParamNamew8GmfQM(Operation.IntParameter.m1091constructorimpl(i9)));
                    i10++;
                }
                i9++;
            }
            String string3 = sb3.toString();
            Intrinsics.checkNotNullExpressionValue(string3, "StringBuilder().apply(builderAction).toString()");
            StringBuilder sb4 = new StringBuilder();
            int objects2 = postInsertNodeFixup.getObjects();
            int i11 = i2;
            int i12 = i11;
            while (i12 < objects2) {
                if (((i3 << i12) & operations2.pushedObjectMask) != 0) {
                    if (i10 > 0) {
                        sb4.append(", ");
                    }
                    sb4.append(postInsertNodeFixup.mo1090objectParamName31yXWZQ(Operation.ObjectParameter.m1093constructorimpl(i12)));
                    i11++;
                }
                i12++;
                operations2 = operations2;
            }
            String string4 = sb4.toString();
            Intrinsics.checkNotNullExpressionValue(string4, "StringBuilder().apply(builderAction).toString()");
            PreconditionsKt.throwIllegalStateException("Error while pushing " + postInsertNodeFixup + ". Not all arguments were provided. Missing " + i10 + " int arguments (" + string3 + ") and " + i11 + " object arguments (" + string4 + ").");
        }
    }

    public final void endNodeInsert() {
        if (!this.pendingOperations.isNotEmpty()) {
            ComposerKt.composeImmediateRuntimeError("Cannot end node insertion, there are no pending operations that can be realized.");
        }
        this.pendingOperations.popInto(this.operations);
    }

    public final void updateNode(Object obj, Function2 function2) {
        Operations operations = this.operations;
        Operation.UpdateNode updateNode = Operation.UpdateNode.INSTANCE;
        operations.pushOp(updateNode);
        Operations operationsM1101constructorimpl = Operations.WriteScope.m1101constructorimpl(operations);
        Operations.WriteScope.m1104setObjectDKhxnng(operationsM1101constructorimpl, Operation.ObjectParameter.m1093constructorimpl(0), obj);
        int iM1093constructorimpl = Operation.ObjectParameter.m1093constructorimpl(1);
        Intrinsics.checkNotNull(function2, "null cannot be cast to non-null type @[ExtensionFunctionType] kotlin.Function2<kotlin.Any?, kotlin.Any?, kotlin.Unit>");
        Operations.WriteScope.m1104setObjectDKhxnng(operationsM1101constructorimpl, iM1093constructorimpl, (Function2) TypeIntrinsics.beforeCheckcastToFunctionOfArity(function2, 2));
        if (operations.pushedIntMask == operations.createExpectedArgMask(updateNode.getInts()) && operations.pushedObjectMask == operations.createExpectedArgMask(updateNode.getObjects())) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        int ints = updateNode.getInts();
        int i = 0;
        for (int i2 = 0; i2 < ints; i2++) {
            if (((1 << i2) & operations.pushedIntMask) != 0) {
                if (i > 0) {
                    sb.append(", ");
                }
                sb.append(updateNode.mo1089intParamNamew8GmfQM(Operation.IntParameter.m1091constructorimpl(i2)));
                i++;
            }
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        StringBuilder sb2 = new StringBuilder();
        int objects = updateNode.getObjects();
        int i3 = 0;
        for (int i4 = 0; i4 < objects; i4++) {
            if (((1 << i4) & operations.pushedObjectMask) != 0) {
                if (i > 0) {
                    sb2.append(", ");
                }
                sb2.append(updateNode.mo1090objectParamName31yXWZQ(Operation.ObjectParameter.m1093constructorimpl(i4)));
                i3++;
            }
        }
        String string2 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(string2, "StringBuilder().apply(builderAction).toString()");
        PreconditionsKt.throwIllegalStateException("Error while pushing " + updateNode + ". Not all arguments were provided. Missing " + i + " int arguments (" + string + ") and " + i3 + " object arguments (" + string2 + ").");
    }
}
