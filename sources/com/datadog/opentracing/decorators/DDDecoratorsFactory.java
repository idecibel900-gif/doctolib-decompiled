package com.datadog.opentracing.decorators;

import com.datadog.legacy.trace.api.Config;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public abstract class DDDecoratorsFactory {
    public static List createBuiltinDecorators() {
        ArrayList arrayList = new ArrayList();
        for (AbstractDecorator abstractDecorator : Arrays.asList(new ForceManualDropDecorator(), new ForceManualKeepDecorator(), new PeerServiceDecorator(), new ServiceNameDecorator(), new ServiceNameDecorator("service", false))) {
            if (Config.get().isRuleEnabled(abstractDecorator.getClass().getSimpleName())) {
                arrayList.add(abstractDecorator);
            }
        }
        Iterator it = Config.get().getSplitByTags().iterator();
        while (it.hasNext()) {
            arrayList.add(new ServiceNameDecorator((String) it.next(), true));
        }
        return arrayList;
    }
}
