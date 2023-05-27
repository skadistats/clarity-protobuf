package skadistats.clarity.wire.dota.s1;

import com.google.protobuf.GeneratedMessage;
import skadistats.clarity.wire.ClassToKindMessageRegistry;
import skadistats.clarity.wire.KindToClassMessageRegistry;
import skadistats.clarity.wire.dota.s1.proto.DOTAS1MessageId;
import skadistats.clarity.wire.dota.s1.proto.DOTAS1NetMessages;
import skadistats.clarity.wire.shared.common.proto.CommonNetMessages;
import skadistats.clarity.wire.shared.common.proto.CommonNetworkBaseTypes;
import skadistats.clarity.wire.shared.demo.proto.DemoNetMessages;
import skadistats.clarity.wire.shared.s1.proto.S1NetMessages;

public class EmbeddedPackets {

    private static final KindToClassMessageRegistry K2C;
    static {
        K2C = new KindToClassMessageRegistry(25);
        /*   0 */ K2C.put(DOTAS1MessageId.NET_Messages.net_NOP_VALUE, CommonNetworkBaseTypes.CNETMsg_NOP.class);
        /*   1 */ K2C.put(DOTAS1MessageId.NET_Messages.net_Disconnect_VALUE, CommonNetworkBaseTypes.CNETMsg_Disconnect.class);

        /*   4 */ K2C.put(DOTAS1MessageId.NET_Messages.net_Tick_VALUE, CommonNetworkBaseTypes.CNETMsg_Tick.class);
        /*   5 */ K2C.put(DOTAS1MessageId.NET_Messages.net_StringCmd_VALUE, CommonNetworkBaseTypes.CNETMsg_StringCmd.class);
        /*   6 */ K2C.put(DOTAS1MessageId.NET_Messages.net_SetConVar_VALUE, CommonNetworkBaseTypes.CNETMsg_SetConVar.class);
        /*   7 */ K2C.put(DOTAS1MessageId.NET_Messages.net_SignonState_VALUE, CommonNetworkBaseTypes.CNETMsg_SignonState.class);

        /*   8 */ K2C.put(DOTAS1MessageId.SVC_Messages.svc_ServerInfo_VALUE, DemoNetMessages.CSVCMsg_ServerInfo.class);
        /*   9 */ K2C.put(DOTAS1MessageId.SVC_Messages.svc_SendTable_VALUE, S1NetMessages.CSVCMsg_SendTable.class);
        /*  10 */ K2C.put(DOTAS1MessageId.SVC_Messages.svc_ClassInfo_VALUE, CommonNetMessages.CSVCMsg_ClassInfo.class);
        /*  12 */ K2C.put(DOTAS1MessageId.SVC_Messages.svc_CreateStringTable_VALUE, S1NetMessages.CSVCMsg_CreateStringTable.class);
        /*  13 */ K2C.put(DOTAS1MessageId.SVC_Messages.svc_UpdateStringTable_VALUE, CommonNetMessages.CSVCMsg_UpdateStringTable.class);
        /*  14 */ K2C.put(DOTAS1MessageId.SVC_Messages.svc_VoiceInit_VALUE, CommonNetMessages.CSVCMsg_VoiceInit.class);
        /*  15 */ K2C.put(DOTAS1MessageId.SVC_Messages.svc_VoiceData_VALUE, DOTAS1NetMessages.CSVCMsg_VoiceData.class);
        /*  16 */ K2C.put(DOTAS1MessageId.SVC_Messages.svc_Print_VALUE, CommonNetMessages.CSVCMsg_Print.class);
        /*  17 */ K2C.put(DOTAS1MessageId.SVC_Messages.svc_Sounds_VALUE, CommonNetMessages.CSVCMsg_Sounds.class);
        /*  18 */ K2C.put(DOTAS1MessageId.SVC_Messages.svc_SetView_VALUE, CommonNetMessages.CSVCMsg_SetView.class);
        /*  21 */ K2C.put(DOTAS1MessageId.SVC_Messages.svc_BSPDecal_VALUE, CommonNetMessages.CSVCMsg_BSPDecal.class);
        /*  23 */ K2C.put(DOTAS1MessageId.SVC_Messages.svc_UserMessage_VALUE, CommonNetworkBaseTypes.CSVCMsg_UserMessage.class);
        /*  25 */ K2C.put(DOTAS1MessageId.SVC_Messages.svc_GameEvent_VALUE, CommonNetworkBaseTypes.CSVCMsg_GameEvent.class);
        /*  26 */ K2C.put(DOTAS1MessageId.SVC_Messages.svc_PacketEntities_VALUE, CommonNetMessages.CSVCMsg_PacketEntities.class);
        /*  27 */ K2C.put(DOTAS1MessageId.SVC_Messages.svc_TempEntities_VALUE, S1NetMessages.CSVCMsg_TempEntities.class);
        /*  28 */ K2C.put(DOTAS1MessageId.SVC_Messages.svc_Prefetch_VALUE, CommonNetMessages.CSVCMsg_Prefetch.class);
        /*  30 */ K2C.put(DOTAS1MessageId.SVC_Messages.svc_GameEventList_VALUE, CommonNetMessages.CSVCMsg_GameEventList.class);
        /*  33 */ K2C.put(DOTAS1MessageId.SVC_Messages.svc_FullFrameSplit_VALUE, CommonNetMessages.CSVCMsg_FullFrameSplit.class);
    }


    public static Class<? extends GeneratedMessage> classForKind(int kind) {
        return K2C.classForKind(kind);
    }

    private static ClassToKindMessageRegistry C2K;

    public static Integer kindForClass(Class<? extends GeneratedMessage> clazz) {
        if (C2K == null) {
            C2K = K2C.buildReverse();
        }
        return C2K.kindForClass(clazz);
    }

}
