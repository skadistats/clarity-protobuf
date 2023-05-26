package skadistats.clarity.wire.shared.common;

import com.google.protobuf.GeneratedMessage;
import skadistats.clarity.wire.KindToClassMessageRegistry;
import skadistats.clarity.wire.shared.common.proto.Demo;

public class DemoPackets {

    private static final KindToClassMessageRegistry K2C;
    static {
        K2C = new KindToClassMessageRegistry(16);
        K2C.put(Demo.EDemoCommands.DEM_ClassInfo_VALUE, Demo.CDemoClassInfo.class);
        K2C.put(Demo.EDemoCommands.DEM_ConsoleCmd_VALUE, Demo.CDemoConsoleCmd.class);
        K2C.put(Demo.EDemoCommands.DEM_CustomData_VALUE, Demo.CDemoCustomData.class);
        K2C.put(Demo.EDemoCommands.DEM_CustomDataCallbacks_VALUE, Demo.CDemoCustomDataCallbacks.class);
        K2C.put(Demo.EDemoCommands.DEM_FileHeader_VALUE, Demo.CDemoFileHeader.class);
        K2C.put(Demo.EDemoCommands.DEM_FileInfo_VALUE, Demo.CDemoFileInfo.class);
        K2C.put(Demo.EDemoCommands.DEM_FullPacket_VALUE, Demo.CDemoFullPacket.class);
        K2C.put(Demo.EDemoCommands.DEM_Packet_VALUE, Demo.CDemoPacket.class);
        K2C.put(Demo.EDemoCommands.DEM_SendTables_VALUE, Demo.CDemoSendTables.class);
        K2C.put(Demo.EDemoCommands.DEM_SignonPacket_VALUE, Demo.CDemoPacket.class);
        K2C.put(Demo.EDemoCommands.DEM_StringTables_VALUE, Demo.CDemoStringTables.class);
        K2C.put(Demo.EDemoCommands.DEM_Stop_VALUE, Demo.CDemoStop.class);
        K2C.put(Demo.EDemoCommands.DEM_SyncTick_VALUE, Demo.CDemoSyncTick.class);
        K2C.put(Demo.EDemoCommands.DEM_UserCmd_VALUE, Demo.CDemoUserCmd.class);
        K2C.put(Demo.EDemoCommands.DEM_SaveGame_VALUE, Demo.CDemoSaveGame.class);
        K2C.put(Demo.EDemoCommands.DEM_SpawnGroups_VALUE, Demo.CDemoSpawnGroups.class);
    }

    public static Class<? extends GeneratedMessage> classForKind(int kind) {
        return K2C.classForKind(kind);
    }

}
