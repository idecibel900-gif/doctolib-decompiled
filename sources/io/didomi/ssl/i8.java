package io.didomi.ssl;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\b\u0017\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0007\u0012\u0006\u0010\u0010\u001a\u00020\u0005\u0012\u0006\u0010\u0012\u001a\u00020\t¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0003\u001a\u00020\u0002H\u0011¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0006\u001a\u00020\u0005H\u0017J\b\u0010\b\u001a\u00020\u0007H\u0017J\b\u0010\n\u001a\u00020\tH\u0017R\u0014\u0010\f\u001a\u00020\u00028\u0012X\u0092\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\u00078\u0012X\u0092\u0004¢\u0006\u0006\n\u0004\b\n\u0010\rR\u0014\u0010\u0010\u001a\u00020\u00058\u0012X\u0092\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\t8\u0012X\u0092\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0011¨\u0006\u0015"}, d2 = {"Lio/didomi/sdk/i8;", "", "Lio/didomi/sdk/DidomiInitializeParameters;", "a", "()Lio/didomi/sdk/DidomiInitializeParameters;", "Lio/didomi/sdk/h8;", "c", "Lio/didomi/sdk/gh;", "d", "Lio/didomi/sdk/r7;", "b", "Lio/didomi/sdk/DidomiInitializeParameters;", "parameters", "Lio/didomi/sdk/gh;", "userAgentRepository", "Lio/didomi/sdk/h8;", "organizationUserRepository", "Lio/didomi/sdk/r7;", "localPropertiesRepository", "<init>", "(Lio/didomi/sdk/DidomiInitializeParameters;Lio/didomi/sdk/gh;Lio/didomi/sdk/h8;Lio/didomi/sdk/r7;)V", "android_release"}, k = 1, mv = {1, 8, 0})
public class i8 {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final DidomiInitializeParameters parameters;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final gh userAgentRepository;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final h8 organizationUserRepository;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private final r7 localPropertiesRepository;

    public i8(DidomiInitializeParameters parameters, gh userAgentRepository, h8 organizationUserRepository, r7 localPropertiesRepository) {
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        Intrinsics.checkNotNullParameter(userAgentRepository, "userAgentRepository");
        Intrinsics.checkNotNullParameter(organizationUserRepository, "organizationUserRepository");
        Intrinsics.checkNotNullParameter(localPropertiesRepository, "localPropertiesRepository");
        this.parameters = parameters;
        this.userAgentRepository = userAgentRepository;
        this.organizationUserRepository = organizationUserRepository;
        this.localPropertiesRepository = localPropertiesRepository;
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public DidomiInitializeParameters getParameters() {
        return this.parameters;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public r7 getLocalPropertiesRepository() {
        return this.localPropertiesRepository;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public h8 getOrganizationUserRepository() {
        return this.organizationUserRepository;
    }

    /* JADX INFO: renamed from: d, reason: from getter */
    public gh getUserAgentRepository() {
        return this.userAgentRepository;
    }
}
