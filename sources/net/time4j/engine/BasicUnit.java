package net.time4j.engine;

/* JADX INFO: loaded from: classes5.dex */
public abstract class BasicUnit implements ChronoUnit {
    protected abstract UnitRule derive(Chronology chronology);

    protected BasicUnit() {
    }
}
