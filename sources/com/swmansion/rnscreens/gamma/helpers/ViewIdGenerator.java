package com.swmansion.rnscreens.gamma.helpers;

/* JADX INFO: loaded from: classes4.dex */
public final class ViewIdGenerator implements ViewIdProviding {
    public static final ViewIdGenerator INSTANCE = new ViewIdGenerator();
    private static final ViewIdProviding defaultGenerator = new NewArchAwareViewIdGenerator();
    private static ViewIdProviding externalGenerator;

    private ViewIdGenerator() {
    }

    @Override // com.swmansion.rnscreens.gamma.helpers.ViewIdProviding
    public int generateViewId() {
        ViewIdProviding viewIdProviding = externalGenerator;
        return viewIdProviding != null ? viewIdProviding.generateViewId() : defaultGenerator.generateViewId();
    }
}
