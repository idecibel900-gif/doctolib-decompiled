package com.swmansion.enriched.markdown.input.editing;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class EditSession {
    private boolean didTextChangeRecently;
    private boolean isTextChanging;
    private EditPhase phase = EditPhase.Idle;

    public final EditPhase getPhase() {
        return this.phase;
    }

    public final boolean isTextChanging() {
        return this.isTextChanging;
    }

    public final void setTextChanging(boolean z) {
        this.isTextChanging = z;
    }

    public final boolean getDidTextChangeRecently() {
        return this.didTextChangeRecently;
    }

    public final void setDidTextChangeRecently(boolean z) {
        this.didTextChangeRecently = z;
    }

    public final boolean getShouldSuppressTextWatcher() {
        return this.phase != EditPhase.Idle;
    }

    public final boolean getShouldSuppressEvents() {
        return this.phase == EditPhase.Importing;
    }

    public final boolean getShouldSuppressAnchorSync() {
        return this.phase == EditPhase.ManagingAnchors;
    }

    public final void enter(EditPhase newPhase) {
        Intrinsics.checkNotNullParameter(newPhase, "newPhase");
        this.phase = newPhase;
    }

    public final void exit() {
        this.phase = EditPhase.Idle;
    }

    public final Object scoped(EditPhase newPhase, Function0 block) {
        Intrinsics.checkNotNullParameter(newPhase, "newPhase");
        Intrinsics.checkNotNullParameter(block, "block");
        EditPhase editPhase = this.phase;
        this.phase = newPhase;
        try {
            return block.invoke();
        } finally {
            this.phase = editPhase;
        }
    }
}
