package androidx.compose.foundation;

import android.view.KeyEvent;
import androidx.compose.foundation.gestures.PressGestureScope;
import androidx.compose.foundation.interaction.HoverInteraction$Enter;
import androidx.compose.foundation.interaction.HoverInteraction$Exit;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.ui.focus.FocusEventModifierNode;
import androidx.compose.ui.focus.FocusState;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.input.key.Key;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import androidx.compose.ui.input.key.KeyInputModifierNode;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerEventType;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNode;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.PointerInputModifierNode;
import androidx.compose.ui.node.SemanticsModifierNode;
import androidx.compose.ui.node.SemanticsModifierNodeKt;
import androidx.compose.ui.node.TraversableNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSizeKt;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractClickableNode extends DelegatingNode implements PointerInputModifierNode, KeyInputModifierNode, FocusEventModifierNode, SemanticsModifierNode, TraversableNode {
    private long centerOffset;
    private final Map currentKeyPressInteractions;
    private boolean enabled;
    private final FocusableInNonTouchMode focusableInNonTouchMode;
    private final FocusableNode focusableNode;
    private HoverInteraction$Enter hoverInteraction;
    private DelegatableNode indicationNode;
    private IndicationNodeFactory indicationNodeFactory;
    private MutableInteractionSource interactionSource;
    private boolean lazilyCreateIndication;
    private Function0 onClick;
    private String onClickLabel;
    private SuspendingPointerInputModifierNode pointerInputNode;
    private PressInteraction.Press pressInteraction;
    private Role role;
    private final boolean shouldAutoInvalidate;
    private final Object traverseKey;
    private MutableInteractionSource userProvidedInteractionSource;
    public static final TraverseKey TraverseKey = new TraverseKey(null);
    public static final int $stable = 8;

    public /* synthetic */ AbstractClickableNode(MutableInteractionSource mutableInteractionSource, IndicationNodeFactory indicationNodeFactory, boolean z, String str, Role role, Function0 function0, DefaultConstructorMarker defaultConstructorMarker) {
        this(mutableInteractionSource, indicationNodeFactory, z, str, role, function0);
    }

    public void applyAdditionalSemantics(SemanticsPropertyReceiver semanticsPropertyReceiver) {
    }

    public abstract Object clickPointerInput(PointerInputScope pointerInputScope, Continuation continuation);

    @Override // androidx.compose.ui.node.SemanticsModifierNode
    public final boolean getShouldMergeDescendantSemantics() {
        return true;
    }

    @Override // androidx.compose.ui.input.key.KeyInputModifierNode
    /* JADX INFO: renamed from: onPreKeyEvent-ZmokQxo, reason: not valid java name */
    public final boolean mo104onPreKeyEventZmokQxo(KeyEvent keyEvent) {
        return false;
    }

    private AbstractClickableNode(MutableInteractionSource mutableInteractionSource, IndicationNodeFactory indicationNodeFactory, boolean z, String str, Role role, Function0 function0) {
        this.interactionSource = mutableInteractionSource;
        this.indicationNodeFactory = indicationNodeFactory;
        this.onClickLabel = str;
        this.role = role;
        this.enabled = z;
        this.onClick = function0;
        this.focusableInNonTouchMode = new FocusableInNonTouchMode();
        this.focusableNode = new FocusableNode(this.interactionSource);
        this.currentKeyPressInteractions = new LinkedHashMap();
        this.centerOffset = Offset.Companion.m1235getZeroF1C5BW0();
        this.userProvidedInteractionSource = this.interactionSource;
        this.lazilyCreateIndication = shouldLazilyCreateIndication();
        this.traverseKey = TraverseKey;
    }

    protected final boolean getEnabled() {
        return this.enabled;
    }

    protected final Function0 getOnClick() {
        return this.onClick;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final boolean getShouldAutoInvalidate() {
        return this.shouldAutoInvalidate;
    }

    private final boolean shouldLazilyCreateIndication() {
        return this.userProvidedInteractionSource == null && this.indicationNodeFactory != null;
    }

    /* JADX WARN: Code duplicated, block: B:28:0x0072  */
    /* JADX INFO: renamed from: updateCommon-QzZPfjk, reason: not valid java name */
    protected final void m105updateCommonQzZPfjk(MutableInteractionSource mutableInteractionSource, IndicationNodeFactory indicationNodeFactory, boolean z, String str, Role role, Function0 function0) {
        boolean z2;
        boolean z3;
        DelegatableNode delegatableNode;
        if (Intrinsics.areEqual(this.userProvidedInteractionSource, mutableInteractionSource)) {
            z2 = false;
        } else {
            disposeInteractions();
            this.userProvidedInteractionSource = mutableInteractionSource;
            this.interactionSource = mutableInteractionSource;
            z2 = true;
        }
        if (!Intrinsics.areEqual(this.indicationNodeFactory, indicationNodeFactory)) {
            this.indicationNodeFactory = indicationNodeFactory;
            z2 = true;
        }
        if (this.enabled != z) {
            if (z) {
                delegate(this.focusableInNonTouchMode);
                delegate(this.focusableNode);
            } else {
                undelegate(this.focusableInNonTouchMode);
                undelegate(this.focusableNode);
                disposeInteractions();
            }
            SemanticsModifierNodeKt.invalidateSemantics(this);
            this.enabled = z;
        }
        if (!Intrinsics.areEqual(this.onClickLabel, str)) {
            this.onClickLabel = str;
            SemanticsModifierNodeKt.invalidateSemantics(this);
        }
        if (!Intrinsics.areEqual(this.role, role)) {
            this.role = role;
            SemanticsModifierNodeKt.invalidateSemantics(this);
        }
        this.onClick = function0;
        if (this.lazilyCreateIndication != shouldLazilyCreateIndication()) {
            boolean zShouldLazilyCreateIndication = shouldLazilyCreateIndication();
            this.lazilyCreateIndication = zShouldLazilyCreateIndication;
            z3 = (zShouldLazilyCreateIndication || this.indicationNode != null) ? z2 : true;
        }
        if (z3 && ((delegatableNode = this.indicationNode) != null || !this.lazilyCreateIndication)) {
            if (delegatableNode != null) {
                undelegate(delegatableNode);
            }
            this.indicationNode = null;
            initializeIndicationAndInteractionSourceIfNeeded();
        }
        this.focusableNode.update(this.interactionSource);
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final void onAttach() {
        if (!this.lazilyCreateIndication) {
            initializeIndicationAndInteractionSourceIfNeeded();
        }
        if (this.enabled) {
            delegate(this.focusableInNonTouchMode);
            delegate(this.focusableNode);
        }
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final void onDetach() {
        disposeInteractions();
        if (this.userProvidedInteractionSource == null) {
            this.interactionSource = null;
        }
        DelegatableNode delegatableNode = this.indicationNode;
        if (delegatableNode != null) {
            undelegate(delegatableNode);
        }
        this.indicationNode = null;
    }

    protected final void disposeInteractions() {
        MutableInteractionSource mutableInteractionSource = this.interactionSource;
        if (mutableInteractionSource != null) {
            PressInteraction.Press press = this.pressInteraction;
            if (press != null) {
                mutableInteractionSource.tryEmit(new PressInteraction.Cancel(press));
            }
            HoverInteraction$Enter hoverInteraction$Enter = this.hoverInteraction;
            if (hoverInteraction$Enter != null) {
                mutableInteractionSource.tryEmit(new HoverInteraction$Exit(hoverInteraction$Enter));
            }
            Iterator it = this.currentKeyPressInteractions.values().iterator();
            while (it.hasNext()) {
                mutableInteractionSource.tryEmit(new PressInteraction.Cancel((PressInteraction.Press) it.next()));
            }
        }
        this.pressInteraction = null;
        this.hoverInteraction = null;
        this.currentKeyPressInteractions.clear();
    }

    private final void initializeIndicationAndInteractionSourceIfNeeded() {
        IndicationNodeFactory indicationNodeFactory;
        if (this.indicationNode == null && (indicationNodeFactory = this.indicationNodeFactory) != null) {
            if (this.interactionSource == null) {
                this.interactionSource = InteractionSourceKt.MutableInteractionSource();
            }
            this.focusableNode.update(this.interactionSource);
            MutableInteractionSource mutableInteractionSource = this.interactionSource;
            Intrinsics.checkNotNull(mutableInteractionSource);
            DelegatableNode delegatableNodeCreate = indicationNodeFactory.create(mutableInteractionSource);
            delegate(delegatableNodeCreate);
            this.indicationNode = delegatableNodeCreate;
        }
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    /* JADX INFO: renamed from: onPointerEvent-H0pRuoY, reason: not valid java name */
    public final void mo103onPointerEventH0pRuoY(PointerEvent pointerEvent, PointerEventPass pointerEventPass, long j) {
        long jM2614getCenterozmzZPI = IntSizeKt.m2614getCenterozmzZPI(j);
        this.centerOffset = OffsetKt.Offset(IntOffset.m2591getXimpl(jM2614getCenterozmzZPI), IntOffset.m2592getYimpl(jM2614getCenterozmzZPI));
        initializeIndicationAndInteractionSourceIfNeeded();
        if (this.enabled && pointerEventPass == PointerEventPass.Main) {
            int iM1751getType7fucELk = pointerEvent.m1751getType7fucELk();
            PointerEventType.Companion companion = PointerEventType.Companion;
            if (PointerEventType.m1756equalsimpl0(iM1751getType7fucELk, companion.m1757getEnter7fucELk())) {
                BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), null, null, new AbstractClickableNode$onPointerEvent$1(this, null), 3, null);
            } else if (PointerEventType.m1756equalsimpl0(iM1751getType7fucELk, companion.m1758getExit7fucELk())) {
                BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), null, null, new AbstractClickableNode$onPointerEvent$2(this, null), 3, null);
            }
        }
        if (this.pointerInputNode == null) {
            this.pointerInputNode = (SuspendingPointerInputModifierNode) delegate(SuspendingPointerInputFilterKt.SuspendingPointerInputModifierNode(new AbstractClickableNode$onPointerEvent$3(this, null)));
        }
        SuspendingPointerInputModifierNode suspendingPointerInputModifierNode = this.pointerInputNode;
        if (suspendingPointerInputModifierNode != null) {
            suspendingPointerInputModifierNode.mo103onPointerEventH0pRuoY(pointerEvent, pointerEventPass, j);
        }
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    public final void onCancelPointerInput() {
        HoverInteraction$Enter hoverInteraction$Enter;
        MutableInteractionSource mutableInteractionSource = this.interactionSource;
        if (mutableInteractionSource != null && (hoverInteraction$Enter = this.hoverInteraction) != null) {
            mutableInteractionSource.tryEmit(new HoverInteraction$Exit(hoverInteraction$Enter));
        }
        this.hoverInteraction = null;
        SuspendingPointerInputModifierNode suspendingPointerInputModifierNode = this.pointerInputNode;
        if (suspendingPointerInputModifierNode != null) {
            suspendingPointerInputModifierNode.onCancelPointerInput();
        }
    }

    @Override // androidx.compose.ui.input.key.KeyInputModifierNode
    /* JADX INFO: renamed from: onKeyEvent-ZmokQxo, reason: not valid java name */
    public final boolean mo102onKeyEventZmokQxo(KeyEvent keyEvent) {
        initializeIndicationAndInteractionSourceIfNeeded();
        if (this.enabled && Clickable_androidKt.m144isPressZmokQxo(keyEvent)) {
            if (this.currentKeyPressInteractions.containsKey(Key.m1692boximpl(KeyEvent_androidKt.m1722getKeyZmokQxo(keyEvent)))) {
                return false;
            }
            PressInteraction.Press press = new PressInteraction.Press(this.centerOffset, null);
            this.currentKeyPressInteractions.put(Key.m1692boximpl(KeyEvent_androidKt.m1722getKeyZmokQxo(keyEvent)), press);
            if (this.interactionSource != null) {
                BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), null, null, new AbstractClickableNode$onKeyEvent$1(this, press, null), 3, null);
            }
            return true;
        }
        if (!this.enabled || !Clickable_androidKt.m142isClickZmokQxo(keyEvent)) {
            return false;
        }
        PressInteraction.Press press2 = (PressInteraction.Press) this.currentKeyPressInteractions.remove(Key.m1692boximpl(KeyEvent_androidKt.m1722getKeyZmokQxo(keyEvent)));
        if (press2 != null && this.interactionSource != null) {
            BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), null, null, new AbstractClickableNode$onKeyEvent$2$1(this, press2, null), 3, null);
        }
        this.onClick.invoke();
        return true;
    }

    @Override // androidx.compose.ui.focus.FocusEventModifierNode
    public final void onFocusEvent(FocusState focusState) {
        if (focusState.isFocused()) {
            initializeIndicationAndInteractionSourceIfNeeded();
        }
        if (this.enabled) {
            this.focusableNode.onFocusEvent(focusState);
        }
    }

    @Override // androidx.compose.ui.node.SemanticsModifierNode
    public final void applySemantics(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        Role role = this.role;
        if (role != null) {
            Intrinsics.checkNotNull(role);
            SemanticsPropertiesKt.m2116setRolekuIjeqM(semanticsPropertyReceiver, role.m2101unboximpl());
        }
        SemanticsPropertiesKt.onClick(semanticsPropertyReceiver, this.onClickLabel, new Function0() { // from class: androidx.compose.foundation.AbstractClickableNode.applySemantics.1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                AbstractClickableNode.this.getOnClick().invoke();
                return Boolean.TRUE;
            }
        });
        if (this.enabled) {
            this.focusableNode.applySemantics(semanticsPropertyReceiver);
        } else {
            SemanticsPropertiesKt.disabled(semanticsPropertyReceiver);
        }
        applyAdditionalSemantics(semanticsPropertyReceiver);
    }

    protected final Unit resetPointerInputHandler() {
        SuspendingPointerInputModifierNode suspendingPointerInputModifierNode = this.pointerInputNode;
        if (suspendingPointerInputModifierNode == null) {
            return null;
        }
        suspendingPointerInputModifierNode.resetPointerInputHandler();
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: handlePressInteraction-d-4ec7I, reason: not valid java name */
    protected final Object m101handlePressInteractiond4ec7I(PressGestureScope pressGestureScope, long j, Continuation continuation) {
        Object objCoroutineScope;
        MutableInteractionSource mutableInteractionSource = this.interactionSource;
        return (mutableInteractionSource == null || (objCoroutineScope = CoroutineScopeKt.coroutineScope(new AbstractClickableNode$handlePressInteraction$2$1(pressGestureScope, j, mutableInteractionSource, this, null), continuation)) != IntrinsicsKt.getCOROUTINE_SUSPENDED()) ? Unit.INSTANCE : objCoroutineScope;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean delayPressInteraction() {
        return ClickableKt.hasScrollableContainer(this) || Clickable_androidKt.isComposeRootInScrollableContainer(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void emitHoverEnter() {
        if (this.hoverInteraction == null) {
            HoverInteraction$Enter hoverInteraction$Enter = new HoverInteraction$Enter();
            MutableInteractionSource mutableInteractionSource = this.interactionSource;
            if (mutableInteractionSource != null) {
                BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), null, null, new AbstractClickableNode$emitHoverEnter$1$1(mutableInteractionSource, hoverInteraction$Enter, null), 3, null);
            }
            this.hoverInteraction = hoverInteraction$Enter;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void emitHoverExit() {
        HoverInteraction$Enter hoverInteraction$Enter = this.hoverInteraction;
        if (hoverInteraction$Enter != null) {
            HoverInteraction$Exit hoverInteraction$Exit = new HoverInteraction$Exit(hoverInteraction$Enter);
            MutableInteractionSource mutableInteractionSource = this.interactionSource;
            if (mutableInteractionSource != null) {
                BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), null, null, new AbstractClickableNode$emitHoverExit$1$1$1(mutableInteractionSource, hoverInteraction$Exit, null), 3, null);
            }
            this.hoverInteraction = null;
        }
    }

    @Override // androidx.compose.ui.node.TraversableNode
    public Object getTraverseKey() {
        return this.traverseKey;
    }

    public static final class TraverseKey {
        public /* synthetic */ TraverseKey(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private TraverseKey() {
        }
    }
}
