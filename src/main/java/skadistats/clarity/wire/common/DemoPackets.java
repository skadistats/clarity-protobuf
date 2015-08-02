package skadistats.clarity.wire.common;

import com.google.protobuf.GeneratedMessage;
import skadistats.clarity.wire.common.proto.Demo;

import java.util.HashMap;
import java.util.Map;

public class DemoPackets {

    private static final Map<Integer, Class<? extends GeneratedMessage>> DEMO;
    static {
        DEMO = new HashMap<>();
        DEMO.put(Demo.EDemoCommands.DEM_ClassInfo_VALUE, Demo.CDemoClassInfo.class);
        DEMO.put(Demo.EDemoCommands.DEM_ConsoleCmd_VALUE, Demo.CDemoConsoleCmd.class);
        DEMO.put(Demo.EDemoCommands.DEM_CustomData_VALUE, Demo.CDemoCustomData.class);
        DEMO.put(Demo.EDemoCommands.DEM_CustomDataCallbacks_VALUE, Demo.CDemoCustomDataCallbacks.class);
        DEMO.put(Demo.EDemoCommands.DEM_FileHeader_VALUE, Demo.CDemoFileHeader.class);
        DEMO.put(Demo.EDemoCommands.DEM_FileInfo_VALUE, Demo.CDemoFileInfo.class);
        DEMO.put(Demo.EDemoCommands.DEM_FullPacket_VALUE, Demo.CDemoFullPacket.class);
        DEMO.put(Demo.EDemoCommands.DEM_Packet_VALUE, Demo.CDemoPacket.class);
        DEMO.put(Demo.EDemoCommands.DEM_SendTables_VALUE, Demo.CDemoSendTables.class);
        DEMO.put(Demo.EDemoCommands.DEM_SignonPacket_VALUE, Demo.CDemoPacket.class);
        DEMO.put(Demo.EDemoCommands.DEM_StringTables_VALUE, Demo.CDemoStringTables.class);
        DEMO.put(Demo.EDemoCommands.DEM_Stop_VALUE, Demo.CDemoStop.class);
        DEMO.put(Demo.EDemoCommands.DEM_SyncTick_VALUE, Demo.CDemoSyncTick.class);
        DEMO.put(Demo.EDemoCommands.DEM_UserCmd_VALUE, Demo.CDemoUserCmd.class);
        DEMO.put(Demo.EDemoCommands.DEM_SaveGame_VALUE, Demo.CDemoSaveGame.class);
        DEMO.put(Demo.EDemoCommands.DEM_SpawnGroups_VALUE, Demo.CDemoSpawnGroups.class);
    }

    public static Class<? extends GeneratedMessage> classForKind(int kind) {
        return DEMO.get(kind);
    }

}
