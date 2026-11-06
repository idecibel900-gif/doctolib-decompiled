package androidx.compose.ui.contentcapture;

import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.LongSparseArray;
import android.view.View;
import android.view.autofill.AutofillId;
import android.view.translation.TranslationRequestValue;
import android.view.translation.TranslationResponseValue;
import android.view.translation.ViewTranslationRequest;
import android.view.translation.ViewTranslationResponse;
import androidx.collection.ArraySet;
import androidx.collection.IntObjectMap;
import androidx.collection.IntObjectMapKt;
import androidx.collection.MutableIntObjectMap;
import androidx.collection.MutableIntSet;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.Owner;
import androidx.compose.ui.platform.AndroidComposeView;
import androidx.compose.ui.platform.SemanticsNodeCopy;
import androidx.compose.ui.platform.SemanticsNodeWithAdjustedBounds;
import androidx.compose.ui.platform.SemanticsUtils_androidKt;
import androidx.compose.ui.platform.coreshims.AutofillIdCompat;
import androidx.compose.ui.platform.coreshims.ContentCaptureSessionCompat;
import androidx.compose.ui.platform.coreshims.ViewCompatShims;
import androidx.compose.ui.platform.coreshims.ViewStructureCompat;
import androidx.compose.ui.semantics.AccessibilityAction;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsActions;
import androidx.compose.ui.semantics.SemanticsConfiguration;
import androidx.compose.ui.semantics.SemanticsConfigurationKt;
import androidx.compose.ui.semantics.SemanticsNode;
import androidx.compose.ui.semantics.SemanticsProperties;
import androidx.compose.ui.semantics.SemanticsPropertyKey;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutInput;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.util.ListUtilsKt;
import androidx.core.util.LongSparseArrayKt;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import kotlin.KotlinNothingValueException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.LongIterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;

/* JADX INFO: loaded from: classes.dex */
public final class AndroidContentCaptureManager implements ContentCaptureManager, DefaultLifecycleObserver, View.OnAttachStateChangeListener {
    private final MutableIntObjectMap bufferedAppearedNodes;
    private final MutableIntSet bufferedDisappearedNodes;
    private boolean checkingForSemanticsChanges;
    private ContentCaptureSessionCompat contentCaptureSession;
    private long currentSemanticsNodesSnapshotTimestampMillis;
    private Function0 onContentCaptureSession;
    private SemanticsNodeCopy previousSemanticsRoot;
    private final ArraySet subtreeChangedLayoutNodes;
    private final AndroidComposeView view;
    private long SendRecurringContentCaptureEventsIntervalMillis = 100;
    private TranslateStatus translateStatus = TranslateStatus.SHOW_ORIGINAL;
    private boolean currentSemanticsNodesInvalidated = true;
    private final Channel boundsUpdateChannel = ChannelKt.Channel$default(1, null, null, 6, null);
    private final Handler handler = new Handler(Looper.getMainLooper());
    private IntObjectMap currentSemanticsNodes = IntObjectMapKt.intObjectMapOf();
    private MutableIntObjectMap previousSemanticsNodes = IntObjectMapKt.mutableIntObjectMapOf();
    private final Runnable contentCaptureChangeChecker = new Runnable() { // from class: androidx.compose.ui.contentcapture.AndroidContentCaptureManager$$ExternalSyntheticLambda0
        @Override // java.lang.Runnable
        public final void run() {
            AndroidContentCaptureManager.contentCaptureChangeChecker$lambda$0(this.f$0);
        }
    };

    private enum TranslateStatus {
        SHOW_ORIGINAL,
        SHOW_TRANSLATED
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
    }

    public AndroidContentCaptureManager(AndroidComposeView androidComposeView, Function0 function0) {
        this.view = androidComposeView;
        this.onContentCaptureSession = function0;
        int i = 0;
        int i2 = 1;
        DefaultConstructorMarker defaultConstructorMarker = null;
        this.bufferedAppearedNodes = new MutableIntObjectMap(i, i2, defaultConstructorMarker);
        this.bufferedDisappearedNodes = new MutableIntSet(i, i2, defaultConstructorMarker);
        this.subtreeChangedLayoutNodes = new ArraySet(i, i2, defaultConstructorMarker);
        this.previousSemanticsRoot = new SemanticsNodeCopy(androidComposeView.getSemanticsOwner().getUnmergedRootSemanticsNode(), IntObjectMapKt.intObjectMapOf());
    }

    public final AndroidComposeView getView() {
        return this.view;
    }

    public final IntObjectMap getCurrentSemanticsNodes$ui_release() {
        if (this.currentSemanticsNodesInvalidated) {
            this.currentSemanticsNodesInvalidated = false;
            this.currentSemanticsNodes = SemanticsUtils_androidKt.getAllUncoveredSemanticsNodesToIntObjectMap(this.view.getSemanticsOwner());
            this.currentSemanticsNodesSnapshotTimestampMillis = System.currentTimeMillis();
        }
        return this.currentSemanticsNodes;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void contentCaptureChangeChecker$lambda$0(AndroidContentCaptureManager androidContentCaptureManager) {
        if (androidContentCaptureManager.isEnabled$ui_release()) {
            Owner.measureAndLayout$default(androidContentCaptureManager.view, false, 1, null);
            androidContentCaptureManager.sendSemanticsStructureChangeEvents(androidContentCaptureManager.view.getSemanticsOwner().getUnmergedRootSemanticsNode(), androidContentCaptureManager.previousSemanticsRoot);
            androidContentCaptureManager.sendContentCaptureStructureChangeEvents(androidContentCaptureManager.view.getSemanticsOwner().getUnmergedRootSemanticsNode(), androidContentCaptureManager.previousSemanticsRoot);
            androidContentCaptureManager.checkForContentCapturePropertyChanges(androidContentCaptureManager.getCurrentSemanticsNodes$ui_release());
            androidContentCaptureManager.updateSemanticsCopy();
            androidContentCaptureManager.checkingForSemanticsChanges = false;
        }
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        this.handler.removeCallbacks(this.contentCaptureChangeChecker);
        this.contentCaptureSession = null;
    }

    public final boolean isEnabled$ui_release() {
        return ContentCaptureManager.Companion.isEnabled() && this.contentCaptureSession != null;
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onStart(LifecycleOwner lifecycleOwner) {
        this.contentCaptureSession = (ContentCaptureSessionCompat) this.onContentCaptureSession.invoke();
        updateBuffersOnAppeared(this.view.getSemanticsOwner().getUnmergedRootSemanticsNode());
        notifyContentCaptureChanges();
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onStop(LifecycleOwner lifecycleOwner) {
        updateBuffersOnDisappeared(this.view.getSemanticsOwner().getUnmergedRootSemanticsNode());
        notifyContentCaptureChanges();
        this.contentCaptureSession = null;
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0062  */
    /* JADX WARN: Code duplicated, block: B:28:0x0063  */
    /* JADX WARN: Code duplicated, block: B:31:0x006e A[Catch: all -> 0x0035, TryCatch #1 {all -> 0x0035, blocks: (B:13:0x0030, B:25:0x0056, B:29:0x0066, B:31:0x006e, B:33:0x0077, B:34:0x007a, B:36:0x007e, B:37:0x0087, B:20:0x0048), top: B:48:0x0022 }] */
    /* JADX WARN: Code duplicated, block: B:33:0x0077 A[Catch: all -> 0x0035, TryCatch #1 {all -> 0x0035, blocks: (B:13:0x0030, B:25:0x0056, B:29:0x0066, B:31:0x006e, B:33:0x0077, B:34:0x007a, B:36:0x007e, B:37:0x0087, B:20:0x0048), top: B:48:0x0022 }] */
    /* JADX WARN: Code duplicated, block: B:36:0x007e A[Catch: all -> 0x0035, TryCatch #1 {all -> 0x0035, blocks: (B:13:0x0030, B:25:0x0056, B:29:0x0066, B:31:0x006e, B:33:0x0077, B:34:0x007a, B:36:0x007e, B:37:0x0087, B:20:0x0048), top: B:48:0x0022 }] */
    /* JADX WARN: Code duplicated, block: B:40:0x009b  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0098, code lost:
    
        if (kotlinx.coroutines.DelayKt.delay(r6, r0) == r1) goto L39;
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x0098 -> B:14:0x0033). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object boundsUpdatesEventLoop$ui_release(kotlin.coroutines.Continuation r10) throws java.lang.Throwable {
        /*
            r9 = this;
            boolean r0 = r10 instanceof androidx.compose.ui.contentcapture.AndroidContentCaptureManager$boundsUpdatesEventLoop$1
            if (r0 == 0) goto L13
            r0 = r10
            androidx.compose.ui.contentcapture.AndroidContentCaptureManager$boundsUpdatesEventLoop$1 r0 = (androidx.compose.ui.contentcapture.AndroidContentCaptureManager$boundsUpdatesEventLoop$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.compose.ui.contentcapture.AndroidContentCaptureManager$boundsUpdatesEventLoop$1 r0 = new androidx.compose.ui.contentcapture.AndroidContentCaptureManager$boundsUpdatesEventLoop$1
            r0.<init>(r9, r10)
        L18:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L4c
            if (r2 == r4) goto L40
            if (r2 != r3) goto L38
            java.lang.Object r2 = r0.L$1
            kotlinx.coroutines.channels.ChannelIterator r2 = (kotlinx.coroutines.channels.ChannelIterator) r2
            java.lang.Object r5 = r0.L$0
            androidx.compose.ui.contentcapture.AndroidContentCaptureManager r5 = (androidx.compose.ui.contentcapture.AndroidContentCaptureManager) r5
            kotlin.ResultKt.throwOnFailure(r10)     // Catch: java.lang.Throwable -> L35
        L33:
            r10 = r2
            goto L56
        L35:
            r10 = move-exception
            goto La5
        L38:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L40:
            java.lang.Object r2 = r0.L$1
            kotlinx.coroutines.channels.ChannelIterator r2 = (kotlinx.coroutines.channels.ChannelIterator) r2
            java.lang.Object r5 = r0.L$0
            androidx.compose.ui.contentcapture.AndroidContentCaptureManager r5 = (androidx.compose.ui.contentcapture.AndroidContentCaptureManager) r5
            kotlin.ResultKt.throwOnFailure(r10)     // Catch: java.lang.Throwable -> L35
            goto L66
        L4c:
            kotlin.ResultKt.throwOnFailure(r10)
            kotlinx.coroutines.channels.Channel r10 = r9.boundsUpdateChannel     // Catch: java.lang.Throwable -> La3
            kotlinx.coroutines.channels.ChannelIterator r10 = r10.iterator()     // Catch: java.lang.Throwable -> La3
            r5 = r9
        L56:
            r0.L$0 = r5     // Catch: java.lang.Throwable -> L35
            r0.L$1 = r10     // Catch: java.lang.Throwable -> L35
            r0.label = r4     // Catch: java.lang.Throwable -> L35
            java.lang.Object r2 = r10.hasNext(r0)     // Catch: java.lang.Throwable -> L35
            if (r2 != r1) goto L63
            goto L9a
        L63:
            r8 = r2
            r2 = r10
            r10 = r8
        L66:
            java.lang.Boolean r10 = (java.lang.Boolean) r10     // Catch: java.lang.Throwable -> L35
            boolean r10 = r10.booleanValue()     // Catch: java.lang.Throwable -> L35
            if (r10 == 0) goto L9b
            r2.next()     // Catch: java.lang.Throwable -> L35
            boolean r10 = r5.isEnabled$ui_release()     // Catch: java.lang.Throwable -> L35
            if (r10 == 0) goto L7a
            r5.notifyContentCaptureChanges()     // Catch: java.lang.Throwable -> L35
        L7a:
            boolean r10 = r5.checkingForSemanticsChanges     // Catch: java.lang.Throwable -> L35
            if (r10 != 0) goto L87
            r5.checkingForSemanticsChanges = r4     // Catch: java.lang.Throwable -> L35
            android.os.Handler r10 = r5.handler     // Catch: java.lang.Throwable -> L35
            java.lang.Runnable r6 = r5.contentCaptureChangeChecker     // Catch: java.lang.Throwable -> L35
            r10.post(r6)     // Catch: java.lang.Throwable -> L35
        L87:
            androidx.collection.ArraySet r10 = r5.subtreeChangedLayoutNodes     // Catch: java.lang.Throwable -> L35
            r10.clear()     // Catch: java.lang.Throwable -> L35
            long r6 = r5.SendRecurringContentCaptureEventsIntervalMillis     // Catch: java.lang.Throwable -> L35
            r0.L$0 = r5     // Catch: java.lang.Throwable -> L35
            r0.L$1 = r2     // Catch: java.lang.Throwable -> L35
            r0.label = r3     // Catch: java.lang.Throwable -> L35
            java.lang.Object r10 = kotlinx.coroutines.DelayKt.delay(r6, r0)     // Catch: java.lang.Throwable -> L35
            if (r10 != r1) goto L33
        L9a:
            return r1
        L9b:
            androidx.collection.ArraySet r10 = r5.subtreeChangedLayoutNodes
            r10.clear()
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        La3:
            r10 = move-exception
            r5 = r9
        La5:
            androidx.collection.ArraySet r0 = r5.subtreeChangedLayoutNodes
            r0.clear()
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.contentcapture.AndroidContentCaptureManager.boundsUpdatesEventLoop$ui_release(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void onSemanticsChange$ui_release() {
        this.currentSemanticsNodesInvalidated = true;
        if (!isEnabled$ui_release() || this.checkingForSemanticsChanges) {
            return;
        }
        this.checkingForSemanticsChanges = true;
        this.handler.post(this.contentCaptureChangeChecker);
    }

    public final void onLayoutChange$ui_release(LayoutNode layoutNode) {
        this.currentSemanticsNodesInvalidated = true;
        if (isEnabled$ui_release()) {
            notifySubtreeStateChangeIfNeeded(layoutNode);
        }
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0095 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:28:0x0097 A[LOOP:1: B:15:0x0057->B:28:0x0097, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:46:0x009a A[EDGE_INSN: B:46:0x009a->B:29:0x009a BREAK  A[LOOP:1: B:15:0x0057->B:28:0x0097], SYNTHETIC] */
    private final void sendSemanticsStructureChangeEvents(SemanticsNode semanticsNode, SemanticsNodeCopy semanticsNodeCopy) {
        int i = 0;
        MutableIntSet mutableIntSet = new MutableIntSet(i, 1, null);
        List replacedChildren$ui_release = semanticsNode.getReplacedChildren$ui_release();
        int size = replacedChildren$ui_release.size();
        for (int i2 = 0; i2 < size; i2++) {
            SemanticsNode semanticsNode2 = (SemanticsNode) replacedChildren$ui_release.get(i2);
            if (getCurrentSemanticsNodes$ui_release().contains(semanticsNode2.getId())) {
                if (!semanticsNodeCopy.getChildren().contains(semanticsNode2.getId())) {
                    notifySubtreeStateChangeIfNeeded(semanticsNode.getLayoutNode$ui_release());
                    return;
                }
                mutableIntSet.add(semanticsNode2.getId());
            }
        }
        MutableIntSet children = semanticsNodeCopy.getChildren();
        int[] iArr = children.elements;
        long[] jArr = children.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i3 = 0;
            while (true) {
                long j = jArr[i3];
                if ((((~j) << 7) & j & (-9187201950435737472L)) == -9187201950435737472L) {
                    if (i3 != length) {
                        break;
                        break;
                    }
                    i3++;
                } else {
                    int i4 = 8 - ((~(i3 - length)) >>> 31);
                    for (int i5 = 0; i5 < i4; i5++) {
                        if ((255 & j) < 128 && !mutableIntSet.contains(iArr[(i3 << 3) + i5])) {
                            notifySubtreeStateChangeIfNeeded(semanticsNode.getLayoutNode$ui_release());
                            return;
                        }
                        j >>= 8;
                    }
                    if (i4 != 8) {
                        break;
                    } else if (i3 != length) {
                        break;
                    } else {
                        i3++;
                    }
                }
            }
        }
        List replacedChildren$ui_release2 = semanticsNode.getReplacedChildren$ui_release();
        int size2 = replacedChildren$ui_release2.size();
        while (i < size2) {
            SemanticsNode semanticsNode3 = (SemanticsNode) replacedChildren$ui_release2.get(i);
            if (getCurrentSemanticsNodes$ui_release().contains(semanticsNode3.getId())) {
                Object obj = this.previousSemanticsNodes.get(semanticsNode3.getId());
                if (obj == null) {
                    InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("node not present in pruned tree before this change");
                    throw new KotlinNothingValueException();
                }
                sendSemanticsStructureChangeEvents(semanticsNode3, (SemanticsNodeCopy) obj);
            }
            i++;
        }
    }

    /* JADX WARN: Code duplicated, block: B:24:0x007d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:25:0x007f A[LOOP:1: B:13:0x0040->B:25:0x007f, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:44:0x0082 A[EDGE_INSN: B:44:0x0082->B:26:0x0082 BREAK  A[LOOP:1: B:13:0x0040->B:25:0x007f], SYNTHETIC] */
    private final void sendContentCaptureStructureChangeEvents(SemanticsNode semanticsNode, SemanticsNodeCopy semanticsNodeCopy) {
        List replacedChildren$ui_release = semanticsNode.getReplacedChildren$ui_release();
        int size = replacedChildren$ui_release.size();
        for (int i = 0; i < size; i++) {
            SemanticsNode semanticsNode2 = (SemanticsNode) replacedChildren$ui_release.get(i);
            if (getCurrentSemanticsNodes$ui_release().contains(semanticsNode2.getId()) && !semanticsNodeCopy.getChildren().contains(semanticsNode2.getId())) {
                updateBuffersOnAppeared(semanticsNode2);
            }
        }
        MutableIntObjectMap mutableIntObjectMap = this.previousSemanticsNodes;
        int[] iArr = mutableIntObjectMap.keys;
        long[] jArr = mutableIntObjectMap.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i2 = 0;
            while (true) {
                long j = jArr[i2];
                if ((((~j) << 7) & j & (-9187201950435737472L)) == -9187201950435737472L) {
                    if (i2 != length) {
                        break;
                        break;
                    }
                    i2++;
                } else {
                    int i3 = 8 - ((~(i2 - length)) >>> 31);
                    for (int i4 = 0; i4 < i3; i4++) {
                        if ((255 & j) < 128) {
                            int i5 = iArr[(i2 << 3) + i4];
                            if (!getCurrentSemanticsNodes$ui_release().contains(i5)) {
                                bufferContentCaptureViewDisappeared(i5);
                            }
                        }
                        j >>= 8;
                    }
                    if (i3 != 8) {
                        break;
                    } else if (i2 != length) {
                        break;
                    } else {
                        i2++;
                    }
                }
            }
        }
        List replacedChildren$ui_release2 = semanticsNode.getReplacedChildren$ui_release();
        int size2 = replacedChildren$ui_release2.size();
        for (int i6 = 0; i6 < size2; i6++) {
            SemanticsNode semanticsNode3 = (SemanticsNode) replacedChildren$ui_release2.get(i6);
            if (getCurrentSemanticsNodes$ui_release().contains(semanticsNode3.getId()) && this.previousSemanticsNodes.contains(semanticsNode3.getId())) {
                Object obj = this.previousSemanticsNodes.get(semanticsNode3.getId());
                if (obj == null) {
                    InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("node not present in pruned tree before this change");
                    throw new KotlinNothingValueException();
                }
                sendContentCaptureStructureChangeEvents(semanticsNode3, (SemanticsNodeCopy) obj);
            }
        }
    }

    private final void sendContentCaptureTextUpdateEvent(int i, String str) {
        ContentCaptureSessionCompat contentCaptureSessionCompat;
        if (Build.VERSION.SDK_INT >= 29 && (contentCaptureSessionCompat = this.contentCaptureSession) != null) {
            AutofillId autofillIdNewAutofillId = contentCaptureSessionCompat.newAutofillId(i);
            if (autofillIdNewAutofillId == null) {
                InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("Invalid content capture ID");
                throw new KotlinNothingValueException();
            }
            contentCaptureSessionCompat.notifyViewTextChanged(autofillIdNewAutofillId, str);
        }
    }

    /* JADX WARN: Code duplicated, block: B:14:0x005d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:15:0x005f A[LOOP:0: B:5:0x0017->B:15:0x005f, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:19:0x0062 A[EDGE_INSN: B:19:0x0062->B:16:0x0062 BREAK  A[LOOP:0: B:5:0x0017->B:15:0x005f], SYNTHETIC] */
    private final void updateSemanticsCopy() {
        this.previousSemanticsNodes.clear();
        IntObjectMap currentSemanticsNodes$ui_release = getCurrentSemanticsNodes$ui_release();
        int[] iArr = currentSemanticsNodes$ui_release.keys;
        Object[] objArr = currentSemanticsNodes$ui_release.values;
        long[] jArr = currentSemanticsNodes$ui_release.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i = 0;
            while (true) {
                long j = jArr[i];
                if ((((~j) << 7) & j & (-9187201950435737472L)) == -9187201950435737472L) {
                    if (i != length) {
                        break;
                        break;
                    }
                    i++;
                } else {
                    int i2 = 8 - ((~(i - length)) >>> 31);
                    for (int i3 = 0; i3 < i2; i3++) {
                        if ((255 & j) < 128) {
                            int i4 = (i << 3) + i3;
                            this.previousSemanticsNodes.set(iArr[i4], new SemanticsNodeCopy(((SemanticsNodeWithAdjustedBounds) objArr[i4]).getSemanticsNode(), getCurrentSemanticsNodes$ui_release()));
                        }
                        j >>= 8;
                    }
                    if (i2 != 8) {
                        break;
                    } else if (i != length) {
                        break;
                    } else {
                        i++;
                    }
                }
            }
        }
        this.previousSemanticsRoot = new SemanticsNodeCopy(this.view.getSemanticsOwner().getUnmergedRootSemanticsNode(), getCurrentSemanticsNodes$ui_release());
    }

    private final void notifySubtreeStateChangeIfNeeded(LayoutNode layoutNode) {
        if (this.subtreeChangedLayoutNodes.add(layoutNode)) {
            this.boundsUpdateChannel.mo5449trySendJP2dKIU(Unit.INSTANCE);
        }
    }

    private final ViewStructureCompat toViewStructure(SemanticsNode semanticsNode) {
        AutofillIdCompat autofillId;
        AutofillId autofillId2;
        String strM2081toLegacyClassNameV4PA4sw;
        ContentCaptureSessionCompat contentCaptureSessionCompat = this.contentCaptureSession;
        if (contentCaptureSessionCompat == null || Build.VERSION.SDK_INT < 29 || (autofillId = ViewCompatShims.getAutofillId(this.view)) == null) {
            return null;
        }
        SemanticsNode parent = semanticsNode.getParent();
        if (parent != null) {
            autofillId2 = contentCaptureSessionCompat.newAutofillId(parent.getId());
            if (autofillId2 == null) {
                return null;
            }
        } else {
            autofillId2 = autofillId.toAutofillId();
        }
        ViewStructureCompat viewStructureCompatNewVirtualViewStructure = contentCaptureSessionCompat.newVirtualViewStructure(autofillId2, semanticsNode.getId());
        if (viewStructureCompatNewVirtualViewStructure == null) {
            return null;
        }
        SemanticsConfiguration unmergedConfig$ui_release = semanticsNode.getUnmergedConfig$ui_release();
        SemanticsProperties semanticsProperties = SemanticsProperties.INSTANCE;
        if (unmergedConfig$ui_release.contains(semanticsProperties.getPassword())) {
            return null;
        }
        Bundle extras = viewStructureCompatNewVirtualViewStructure.getExtras();
        if (extras != null) {
            extras.putLong("android.view.contentcapture.EventTimestamp", this.currentSemanticsNodesSnapshotTimestampMillis);
        }
        String str = (String) SemanticsConfigurationKt.getOrNull(unmergedConfig$ui_release, semanticsProperties.getTestTag());
        if (str != null) {
            viewStructureCompatNewVirtualViewStructure.setId(semanticsNode.getId(), null, null, str);
        }
        List list = (List) SemanticsConfigurationKt.getOrNull(unmergedConfig$ui_release, semanticsProperties.getText());
        if (list != null) {
            viewStructureCompatNewVirtualViewStructure.setClassName("android.widget.TextView");
            viewStructureCompatNewVirtualViewStructure.setText(ListUtilsKt.fastJoinToString$default(list, "\n", null, null, 0, null, null, 62, null));
        }
        AnnotatedString annotatedString = (AnnotatedString) SemanticsConfigurationKt.getOrNull(unmergedConfig$ui_release, semanticsProperties.getEditableText());
        if (annotatedString != null) {
            viewStructureCompatNewVirtualViewStructure.setClassName("android.widget.EditText");
            viewStructureCompatNewVirtualViewStructure.setText(annotatedString);
        }
        List list2 = (List) SemanticsConfigurationKt.getOrNull(unmergedConfig$ui_release, semanticsProperties.getContentDescription());
        if (list2 != null) {
            viewStructureCompatNewVirtualViewStructure.setContentDescription(ListUtilsKt.fastJoinToString$default(list2, "\n", null, null, 0, null, null, 62, null));
        }
        Role role = (Role) SemanticsConfigurationKt.getOrNull(unmergedConfig$ui_release, semanticsProperties.getRole());
        if (role != null && (strM2081toLegacyClassNameV4PA4sw = SemanticsUtils_androidKt.m2081toLegacyClassNameV4PA4sw(role.m2101unboximpl())) != null) {
            viewStructureCompatNewVirtualViewStructure.setClassName(strM2081toLegacyClassNameV4PA4sw);
        }
        TextLayoutResult textLayoutResult = SemanticsUtils_androidKt.getTextLayoutResult(unmergedConfig$ui_release);
        if (textLayoutResult != null) {
            TextLayoutInput layoutInput = textLayoutResult.getLayoutInput();
            viewStructureCompatNewVirtualViewStructure.setTextStyle(TextUnit.m2622getValueimpl(layoutInput.getStyle().m2233getFontSizeXSAIIZE()) * layoutInput.getDensity().getDensity() * layoutInput.getDensity().getFontScale(), 0, 0, 0);
        }
        Rect boundsInParent$ui_release = semanticsNode.getBoundsInParent$ui_release();
        viewStructureCompatNewVirtualViewStructure.setDimens((int) boundsInParent$ui_release.getLeft(), (int) boundsInParent$ui_release.getTop(), 0, 0, (int) boundsInParent$ui_release.getWidth(), (int) boundsInParent$ui_release.getHeight());
        return viewStructureCompatNewVirtualViewStructure;
    }

    private final void bufferContentCaptureViewAppeared(int i, ViewStructureCompat viewStructureCompat) {
        if (viewStructureCompat == null) {
            return;
        }
        if (this.bufferedDisappearedNodes.contains(i)) {
            this.bufferedDisappearedNodes.remove(i);
        } else {
            this.bufferedAppearedNodes.set(i, viewStructureCompat);
        }
    }

    private final void bufferContentCaptureViewDisappeared(int i) {
        if (this.bufferedAppearedNodes.containsKey(i)) {
            this.bufferedAppearedNodes.remove(i);
        } else {
            this.bufferedDisappearedNodes.add(i);
        }
    }

    /* JADX WARN: Code duplicated, block: B:48:0x00f1 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:49:0x00f3 A[LOOP:3: B:39:0x00c4->B:49:0x00f3, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:61:0x00f6 A[EDGE_INSN: B:61:0x00f6->B:50:0x00f6 BREAK  A[LOOP:3: B:39:0x00c4->B:49:0x00f3], SYNTHETIC] */
    private final void notifyContentCaptureChanges() {
        char c;
        long j;
        long j2;
        ContentCaptureSessionCompat contentCaptureSessionCompat = this.contentCaptureSession;
        if (contentCaptureSessionCompat != null && Build.VERSION.SDK_INT >= 29) {
            char c2 = 7;
            if (this.bufferedAppearedNodes.isNotEmpty()) {
                ArrayList arrayList = new ArrayList();
                MutableIntObjectMap mutableIntObjectMap = this.bufferedAppearedNodes;
                Object[] objArr = mutableIntObjectMap.values;
                long[] jArr = mutableIntObjectMap.metadata;
                int length = jArr.length - 2;
                if (length >= 0) {
                    int i = 0;
                    j = 128;
                    while (true) {
                        long j3 = jArr[i];
                        j2 = 255;
                        if ((((~j3) << c2) & j3 & (-9187201950435737472L)) != -9187201950435737472L) {
                            int i2 = 8 - ((~(i - length)) >>> 31);
                            int i3 = 0;
                            while (i3 < i2) {
                                if ((j3 & 255) < 128) {
                                    arrayList.add((ViewStructureCompat) objArr[(i << 3) + i3]);
                                }
                                j3 >>= 8;
                                i3++;
                                c2 = c2;
                            }
                            c = c2;
                            if (i2 != 8) {
                                break;
                            }
                        } else {
                            c = c2;
                        }
                        if (i == length) {
                            break;
                        }
                        i++;
                        c2 = c;
                    }
                } else {
                    c = 7;
                    j = 128;
                    j2 = 255;
                }
                ArrayList arrayList2 = new ArrayList(arrayList.size());
                int size = arrayList.size();
                for (int i4 = 0; i4 < size; i4++) {
                    arrayList2.add(((ViewStructureCompat) arrayList.get(i4)).toViewStructure());
                }
                contentCaptureSessionCompat.notifyViewsAppeared(arrayList2);
                this.bufferedAppearedNodes.clear();
            } else {
                c = 7;
                j = 128;
                j2 = 255;
            }
            if (this.bufferedDisappearedNodes.isNotEmpty()) {
                ArrayList arrayList3 = new ArrayList();
                MutableIntSet mutableIntSet = this.bufferedDisappearedNodes;
                int[] iArr = mutableIntSet.elements;
                long[] jArr2 = mutableIntSet.metadata;
                int length2 = jArr2.length - 2;
                if (length2 >= 0) {
                    int i5 = 0;
                    while (true) {
                        long j4 = jArr2[i5];
                        if ((((~j4) << c) & j4 & (-9187201950435737472L)) == -9187201950435737472L) {
                            if (i5 != length2) {
                                break;
                                break;
                            }
                            i5++;
                        } else {
                            int i6 = 8 - ((~(i5 - length2)) >>> 31);
                            for (int i7 = 0; i7 < i6; i7++) {
                                if ((j4 & j2) < j) {
                                    arrayList3.add(Integer.valueOf(iArr[(i5 << 3) + i7]));
                                }
                                j4 >>= 8;
                            }
                            if (i6 != 8) {
                                break;
                            } else if (i5 != length2) {
                                break;
                            } else {
                                i5++;
                            }
                        }
                    }
                }
                ArrayList arrayList4 = new ArrayList(arrayList3.size());
                int size2 = arrayList3.size();
                for (int i8 = 0; i8 < size2; i8++) {
                    arrayList4.add(Long.valueOf(((Number) arrayList3.get(i8)).intValue()));
                }
                contentCaptureSessionCompat.notifyViewsDisappeared(CollectionsKt.toLongArray(arrayList4));
                this.bufferedDisappearedNodes.clear();
            }
        }
    }

    private final void updateBuffersOnAppeared(SemanticsNode semanticsNode) {
        if (isEnabled$ui_release()) {
            updateTranslationOnAppeared(semanticsNode);
            bufferContentCaptureViewAppeared(semanticsNode.getId(), toViewStructure(semanticsNode));
            List replacedChildren$ui_release = semanticsNode.getReplacedChildren$ui_release();
            int size = replacedChildren$ui_release.size();
            for (int i = 0; i < size; i++) {
                updateBuffersOnAppeared((SemanticsNode) replacedChildren$ui_release.get(i));
            }
        }
    }

    private final void updateBuffersOnDisappeared(SemanticsNode semanticsNode) {
        if (isEnabled$ui_release()) {
            bufferContentCaptureViewDisappeared(semanticsNode.getId());
            List replacedChildren$ui_release = semanticsNode.getReplacedChildren$ui_release();
            int size = replacedChildren$ui_release.size();
            for (int i = 0; i < size; i++) {
                updateBuffersOnDisappeared((SemanticsNode) replacedChildren$ui_release.get(i));
            }
        }
    }

    private final void updateTranslationOnAppeared(SemanticsNode semanticsNode) {
        AccessibilityAction accessibilityAction;
        Function1 function1;
        Function1 function2;
        SemanticsConfiguration unmergedConfig$ui_release = semanticsNode.getUnmergedConfig$ui_release();
        Boolean bool = (Boolean) SemanticsConfigurationKt.getOrNull(unmergedConfig$ui_release, SemanticsProperties.INSTANCE.getIsShowingTextSubstitution());
        if (this.translateStatus == TranslateStatus.SHOW_ORIGINAL && Intrinsics.areEqual(bool, Boolean.TRUE)) {
            AccessibilityAction accessibilityAction2 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(unmergedConfig$ui_release, SemanticsActions.INSTANCE.getShowTextSubstitution());
            if (accessibilityAction2 == null || (function2 = (Function1) accessibilityAction2.getAction()) == null) {
                return;
            }
            return;
        }
        if (this.translateStatus != TranslateStatus.SHOW_TRANSLATED || !Intrinsics.areEqual(bool, Boolean.FALSE) || (accessibilityAction = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(unmergedConfig$ui_release, SemanticsActions.INSTANCE.getShowTextSubstitution())) == null || (function1 = (Function1) accessibilityAction.getAction()) == null) {
            return;
        }
    }

    public final void onShowTranslation$ui_release() {
        this.translateStatus = TranslateStatus.SHOW_TRANSLATED;
        showTranslatedText();
    }

    public final void onHideTranslation$ui_release() {
        this.translateStatus = TranslateStatus.SHOW_ORIGINAL;
        hideTranslatedText();
    }

    public final void onClearTranslation$ui_release() {
        this.translateStatus = TranslateStatus.SHOW_ORIGINAL;
        clearTranslatedText();
    }

    private final void showTranslatedText() {
        AccessibilityAction accessibilityAction;
        Function1 function1;
        IntObjectMap currentSemanticsNodes$ui_release = getCurrentSemanticsNodes$ui_release();
        Object[] objArr = currentSemanticsNodes$ui_release.values;
        long[] jArr = currentSemanticsNodes$ui_release.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            return;
        }
        int i = 0;
        while (true) {
            long j = jArr[i];
            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                int i2 = 8 - ((~(i - length)) >>> 31);
                for (int i3 = 0; i3 < i2; i3++) {
                    if ((255 & j) < 128) {
                        SemanticsConfiguration unmergedConfig$ui_release = ((SemanticsNodeWithAdjustedBounds) objArr[(i << 3) + i3]).getSemanticsNode().getUnmergedConfig$ui_release();
                        if (Intrinsics.areEqual(SemanticsConfigurationKt.getOrNull(unmergedConfig$ui_release, SemanticsProperties.INSTANCE.getIsShowingTextSubstitution()), Boolean.FALSE) && (accessibilityAction = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(unmergedConfig$ui_release, SemanticsActions.INSTANCE.getShowTextSubstitution())) != null && (function1 = (Function1) accessibilityAction.getAction()) != null) {
                        }
                    }
                    j >>= 8;
                }
                if (i2 != 8) {
                    return;
                }
            }
            if (i == length) {
                return;
            } else {
                i++;
            }
        }
    }

    private final void hideTranslatedText() {
        AccessibilityAction accessibilityAction;
        Function1 function1;
        IntObjectMap currentSemanticsNodes$ui_release = getCurrentSemanticsNodes$ui_release();
        Object[] objArr = currentSemanticsNodes$ui_release.values;
        long[] jArr = currentSemanticsNodes$ui_release.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            return;
        }
        int i = 0;
        while (true) {
            long j = jArr[i];
            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                int i2 = 8 - ((~(i - length)) >>> 31);
                for (int i3 = 0; i3 < i2; i3++) {
                    if ((255 & j) < 128) {
                        SemanticsConfiguration unmergedConfig$ui_release = ((SemanticsNodeWithAdjustedBounds) objArr[(i << 3) + i3]).getSemanticsNode().getUnmergedConfig$ui_release();
                        if (Intrinsics.areEqual(SemanticsConfigurationKt.getOrNull(unmergedConfig$ui_release, SemanticsProperties.INSTANCE.getIsShowingTextSubstitution()), Boolean.TRUE) && (accessibilityAction = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(unmergedConfig$ui_release, SemanticsActions.INSTANCE.getShowTextSubstitution())) != null && (function1 = (Function1) accessibilityAction.getAction()) != null) {
                        }
                    }
                    j >>= 8;
                }
                if (i2 != 8) {
                    return;
                }
            }
            if (i == length) {
                return;
            } else {
                i++;
            }
        }
    }

    private final void clearTranslatedText() {
        AccessibilityAction accessibilityAction;
        Function0 function0;
        IntObjectMap currentSemanticsNodes$ui_release = getCurrentSemanticsNodes$ui_release();
        Object[] objArr = currentSemanticsNodes$ui_release.values;
        long[] jArr = currentSemanticsNodes$ui_release.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            return;
        }
        int i = 0;
        while (true) {
            long j = jArr[i];
            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                int i2 = 8 - ((~(i - length)) >>> 31);
                for (int i3 = 0; i3 < i2; i3++) {
                    if ((255 & j) < 128) {
                        SemanticsConfiguration unmergedConfig$ui_release = ((SemanticsNodeWithAdjustedBounds) objArr[(i << 3) + i3]).getSemanticsNode().getUnmergedConfig$ui_release();
                        if (SemanticsConfigurationKt.getOrNull(unmergedConfig$ui_release, SemanticsProperties.INSTANCE.getIsShowingTextSubstitution()) != null && (accessibilityAction = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(unmergedConfig$ui_release, SemanticsActions.INSTANCE.getClearTextSubstitution())) != null && (function0 = (Function0) accessibilityAction.getAction()) != null) {
                        }
                    }
                    j >>= 8;
                }
                if (i2 != 8) {
                    return;
                }
            }
            if (i == length) {
                return;
            } else {
                i++;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static final class ViewTranslationHelperMethods {
        public static final ViewTranslationHelperMethods INSTANCE = new ViewTranslationHelperMethods();

        private ViewTranslationHelperMethods() {
        }

        public final void onVirtualViewTranslationResponses(final AndroidContentCaptureManager androidContentCaptureManager, final LongSparseArray<ViewTranslationResponse> longSparseArray) {
            if (Build.VERSION.SDK_INT < 31) {
                return;
            }
            if (Intrinsics.areEqual(Looper.getMainLooper().getThread(), Thread.currentThread())) {
                doTranslation(androidContentCaptureManager, longSparseArray);
            } else {
                androidContentCaptureManager.getView().post(new Runnable() { // from class: androidx.compose.ui.contentcapture.AndroidContentCaptureManager$ViewTranslationHelperMethods$$ExternalSyntheticLambda3
                    @Override // java.lang.Runnable
                    public final void run() {
                        AndroidContentCaptureManager.ViewTranslationHelperMethods.onVirtualViewTranslationResponses$lambda$1(androidContentCaptureManager, longSparseArray);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onVirtualViewTranslationResponses$lambda$1(AndroidContentCaptureManager androidContentCaptureManager, LongSparseArray longSparseArray) {
            INSTANCE.doTranslation(androidContentCaptureManager, longSparseArray);
        }

        private final void doTranslation(AndroidContentCaptureManager androidContentCaptureManager, LongSparseArray longSparseArray) {
            TranslationResponseValue value;
            CharSequence text;
            SemanticsNodeWithAdjustedBounds semanticsNodeWithAdjustedBounds;
            SemanticsNode semanticsNode;
            AccessibilityAction accessibilityAction;
            Function1 function1;
            LongIterator longIteratorKeyIterator = LongSparseArrayKt.keyIterator(longSparseArray);
            while (longIteratorKeyIterator.hasNext()) {
                long jNextLong = longIteratorKeyIterator.nextLong();
                ViewTranslationResponse viewTranslationResponseM = AndroidContentCaptureManager$ViewTranslationHelperMethods$$ExternalSyntheticApiModelOutline2.m(longSparseArray.get(jNextLong));
                if (viewTranslationResponseM != null && (value = viewTranslationResponseM.getValue("android:text")) != null && (text = value.getText()) != null && (semanticsNodeWithAdjustedBounds = (SemanticsNodeWithAdjustedBounds) androidContentCaptureManager.getCurrentSemanticsNodes$ui_release().get((int) jNextLong)) != null && (semanticsNode = semanticsNodeWithAdjustedBounds.getSemanticsNode()) != null && (accessibilityAction = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), SemanticsActions.INSTANCE.getSetTextSubstitution())) != null && (function1 = (Function1) accessibilityAction.getAction()) != null) {
                }
            }
        }

        /* JADX WARN: Code duplicated, block: B:13:0x0072  */
        public final void onCreateVirtualViewTranslationRequests(AndroidContentCaptureManager androidContentCaptureManager, long[] jArr, int[] iArr, Consumer<ViewTranslationRequest> consumer) {
            SemanticsNode semanticsNode;
            String strFastJoinToString$default;
            for (long j : jArr) {
                SemanticsNodeWithAdjustedBounds semanticsNodeWithAdjustedBounds = (SemanticsNodeWithAdjustedBounds) androidContentCaptureManager.getCurrentSemanticsNodes$ui_release().get((int) j);
                if (semanticsNodeWithAdjustedBounds != null && (semanticsNode = semanticsNodeWithAdjustedBounds.getSemanticsNode()) != null) {
                    AndroidContentCaptureManager$ViewTranslationHelperMethods$$ExternalSyntheticApiModelOutline1.m();
                    ViewTranslationRequest.Builder builderM = AndroidContentCaptureManager$ViewTranslationHelperMethods$$ExternalSyntheticApiModelOutline0.m(androidContentCaptureManager.getView().getAutofillId(), semanticsNode.getId());
                    List list = (List) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), SemanticsProperties.INSTANCE.getText());
                    if (list != null && (strFastJoinToString$default = ListUtilsKt.fastJoinToString$default(list, "\n", null, null, 0, null, null, 62, null)) != null) {
                        builderM.setValue("android:text", TranslationRequestValue.forText(new AnnotatedString(strFastJoinToString$default, null, null, 6, null)));
                        consumer.accept(builderM.build());
                    }
                }
            }
        }
    }

    public final void onCreateVirtualViewTranslationRequests$ui_release(long[] jArr, int[] iArr, Consumer consumer) {
        ViewTranslationHelperMethods.INSTANCE.onCreateVirtualViewTranslationRequests(this, jArr, iArr, consumer);
    }

    public final void onVirtualViewTranslationResponses$ui_release(AndroidContentCaptureManager androidContentCaptureManager, LongSparseArray longSparseArray) {
        ViewTranslationHelperMethods.INSTANCE.onVirtualViewTranslationResponses(androidContentCaptureManager, longSparseArray);
    }

    private final void checkForContentCapturePropertyChanges(IntObjectMap intObjectMap) {
        int[] iArr = intObjectMap.keys;
        long[] jArr = intObjectMap.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            return;
        }
        int i = 0;
        while (true) {
            long j = jArr[i];
            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                int i2 = 8;
                int i3 = 8 - ((~(i - length)) >>> 31);
                int i4 = 0;
                while (i4 < i3) {
                    if ((255 & j) < 128) {
                        int i5 = iArr[(i << 3) + i4];
                        SemanticsNodeCopy semanticsNodeCopy = (SemanticsNodeCopy) this.previousSemanticsNodes.get(i5);
                        SemanticsNodeWithAdjustedBounds semanticsNodeWithAdjustedBounds = (SemanticsNodeWithAdjustedBounds) intObjectMap.get(i5);
                        SemanticsNode semanticsNode = semanticsNodeWithAdjustedBounds != null ? semanticsNodeWithAdjustedBounds.getSemanticsNode() : null;
                        if (semanticsNode == null) {
                            InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("no value for specified key");
                            throw new KotlinNothingValueException();
                        }
                        if (semanticsNodeCopy == null) {
                            Iterator it = semanticsNode.getUnmergedConfig$ui_release().iterator();
                            while (it.hasNext()) {
                                Object key = ((Map.Entry) it.next()).getKey();
                                SemanticsProperties semanticsProperties = SemanticsProperties.INSTANCE;
                                if (Intrinsics.areEqual(key, semanticsProperties.getText())) {
                                    List list = (List) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), semanticsProperties.getText());
                                    sendContentCaptureTextUpdateEvent(semanticsNode.getId(), String.valueOf(list != null ? (AnnotatedString) CollectionsKt.firstOrNull(list) : null));
                                }
                            }
                        } else {
                            Iterator it2 = semanticsNode.getUnmergedConfig$ui_release().iterator();
                            while (it2.hasNext()) {
                                SemanticsPropertyKey semanticsPropertyKey = (SemanticsPropertyKey) ((Map.Entry) it2.next()).getKey();
                                SemanticsProperties semanticsProperties2 = SemanticsProperties.INSTANCE;
                                if (Intrinsics.areEqual(semanticsPropertyKey, semanticsProperties2.getText())) {
                                    List list2 = (List) SemanticsConfigurationKt.getOrNull(semanticsNodeCopy.getUnmergedConfig(), semanticsProperties2.getText());
                                    AnnotatedString annotatedString = list2 != null ? (AnnotatedString) CollectionsKt.firstOrNull(list2) : null;
                                    int i6 = i2;
                                    List list3 = (List) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), semanticsProperties2.getText());
                                    AnnotatedString annotatedString2 = list3 != null ? (AnnotatedString) CollectionsKt.firstOrNull(list3) : null;
                                    if (!Intrinsics.areEqual(annotatedString, annotatedString2)) {
                                        sendContentCaptureTextUpdateEvent(semanticsNode.getId(), String.valueOf(annotatedString2));
                                    }
                                    i2 = i6;
                                }
                            }
                        }
                    }
                    int i7 = i2;
                    j >>= i7;
                    i4++;
                    i2 = i7;
                }
                if (i3 != i2) {
                    return;
                }
            }
            if (i == length) {
                return;
            } else {
                i++;
            }
        }
    }
}
