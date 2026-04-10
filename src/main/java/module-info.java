module com.skadistats.clarity.protobuf {

    requires it.unimi.dsi.fastutil.core;
    requires java.logging;

    exports com.google.protobuf;
    exports skadistats.clarity.wire;
    exports skadistats.clarity.wire.csgo.common.proto;
    exports skadistats.clarity.wire.csgo.s1;
    exports skadistats.clarity.wire.csgo.s1.proto;
    exports skadistats.clarity.wire.csgo.s2;
    exports skadistats.clarity.wire.csgo.s2.proto;
    exports skadistats.clarity.wire.deadlock.proto;
    exports skadistats.clarity.wire.dota.common.proto;
    exports skadistats.clarity.wire.dota.s1;
    exports skadistats.clarity.wire.dota.s1.proto;
    exports skadistats.clarity.wire.dota.s2;
    exports skadistats.clarity.wire.dota.s2.proto;
    exports skadistats.clarity.wire.shared.common.proto;
    exports skadistats.clarity.wire.shared.demo;
    exports skadistats.clarity.wire.shared.demo.proto;
    exports skadistats.clarity.wire.shared.s1.proto;
    exports skadistats.clarity.wire.shared.s2.proto;

}
