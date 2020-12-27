package tech.harmless.minecraft.htlib.lib;

@Deprecated
public class HTLibHandle {

    public final int htId;
    public final String id;
    public final String version;

    public HTLibHandle(int htId, String id, String version) {
        this.htId = htId;
        this.id = id;
        this.version = version;
    }
}
