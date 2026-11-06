package com.swmansion.rnscreens.gamma.helpers;

/* JADX INFO: loaded from: classes4.dex */
final class NewArchAwareViewIdGenerator implements ViewIdProviding {
    private int nextId = 3;

    @Override // com.swmansion.rnscreens.gamma.helpers.ViewIdProviding
    public int generateViewId() {
        int i = this.nextId;
        progressViewId();
        return i;
    }

    private final void progressViewId() {
        int i = this.nextId + 2;
        this.nextId = i;
        if (isValidReactRootTag(i)) {
            this.nextId += 2;
        }
    }

    private final boolean isValidReactRootTag(int i) {
        return i % 10 == 1;
    }
}
