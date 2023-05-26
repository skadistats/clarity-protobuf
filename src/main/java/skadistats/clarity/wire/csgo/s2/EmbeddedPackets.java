package skadistats.clarity.wire.csgo.s2;

import com.google.protobuf.GeneratedMessage;
import skadistats.clarity.wire.ClassToKindMessageRegistry;
import skadistats.clarity.wire.KindToClassMessageRegistry;
import skadistats.clarity.wire.dota.common.proto.DotaUserMessages;
import skadistats.clarity.wire.common.proto.NetMessages;
import skadistats.clarity.wire.common.proto.NetworkBaseTypes;
import skadistats.clarity.wire.dota.s2.proto.S2GameEvents;
import skadistats.clarity.wire.dota.s2.proto.S2NetMessages;
import skadistats.clarity.wire.dota.s2.proto.S2TempEntities;
import skadistats.clarity.wire.dota.s2.proto.S2UserMessages;

public class EmbeddedPackets {

    private static final KindToClassMessageRegistry K2C;

    static {
        K2C = new KindToClassMessageRegistry(100);
        /*   0 */ K2C.put(NetworkBaseTypes.NET_Messages.net_NOP_VALUE, NetworkBaseTypes.CNETMsg_NOP.class);
        /*   1 */ K2C.put(NetworkBaseTypes.NET_Messages.net_Disconnect_VALUE, NetworkBaseTypes.CNETMsg_Disconnect.class);
        /*   4 */ K2C.put(NetworkBaseTypes.NET_Messages.net_Tick_VALUE, NetworkBaseTypes.CNETMsg_Tick.class);
        /*   6 */ K2C.put(NetworkBaseTypes.NET_Messages.net_SetConVar_VALUE, NetworkBaseTypes.CNETMsg_SetConVar.class);
        /*   7 */ K2C.put(NetworkBaseTypes.NET_Messages.net_SignonState_VALUE, NetworkBaseTypes.CNETMsg_SignonState.class);
        /*   8 */ K2C.put(NetworkBaseTypes.NET_Messages.net_SpawnGroup_Load_VALUE, NetworkBaseTypes.CNETMsg_SpawnGroup_Load.class);
        /*   9 */ K2C.put(NetworkBaseTypes.NET_Messages.net_SpawnGroup_ManifestUpdate_VALUE, NetworkBaseTypes.CNETMsg_SpawnGroup_ManifestUpdate.class);
        /*  11 */ K2C.put(NetworkBaseTypes.NET_Messages.net_SpawnGroup_SetCreationTick_VALUE, NetworkBaseTypes.CNETMsg_SpawnGroup_SetCreationTick.class);
        /*  12 */ K2C.put(NetworkBaseTypes.NET_Messages.net_SpawnGroup_Unload_VALUE, NetworkBaseTypes.CNETMsg_SpawnGroup_Unload.class);
        /*  12 */ K2C.put(NetworkBaseTypes.NET_Messages.net_SpawnGroup_LoadCompleted_VALUE, NetworkBaseTypes.CNETMsg_SpawnGroup_LoadCompleted.class);

        /*  20 */ K2C.put(S2NetMessages.CLC_Messages.clc_ClientInfo_VALUE, NetMessages.CCLCMsg_ClientInfo.class);
        /*  21 */ K2C.put(S2NetMessages.CLC_Messages.clc_Move_VALUE, NetMessages.CCLCMsg_Move.class);
        /*  23 */ K2C.put(S2NetMessages.CLC_Messages.clc_BaselineAck_VALUE, NetMessages.CCLCMsg_BaselineAck.class);
        /*  27 */ K2C.put(S2NetMessages.CLC_Messages.clc_LoadingProgress_VALUE, NetMessages.CCLCMsg_LoadingProgress.class);

        /*  40 */ K2C.put(S2NetMessages.SVC_Messages.svc_ServerInfo_VALUE, NetMessages.CSVCMsg_ServerInfo.class);
        /*  41 */ K2C.put(S2NetMessages.SVC_Messages.svc_FlattenedSerializer_VALUE, S2NetMessages.CSVCMsg_FlattenedSerializer.class);
        /*  42 */ K2C.put(S2NetMessages.SVC_Messages.svc_ClassInfo_VALUE, NetMessages.CSVCMsg_ClassInfo.class);
        /*  44 */ K2C.put(S2NetMessages.SVC_Messages.svc_CreateStringTable_VALUE, S2NetMessages.CSVCMsg_CreateStringTable.class);
        /*  45 */ K2C.put(S2NetMessages.SVC_Messages.svc_UpdateStringTable_VALUE, NetMessages.CSVCMsg_UpdateStringTable.class);
        /*  46 */ K2C.put(S2NetMessages.SVC_Messages.svc_VoiceInit_VALUE, NetMessages.CSVCMsg_VoiceInit.class);
        /*  47 */ K2C.put(S2NetMessages.SVC_Messages.svc_VoiceData_VALUE, S2NetMessages.CSVCMsg_VoiceData.class);
        /*  48 */ K2C.put(S2NetMessages.SVC_Messages.svc_Print_VALUE, NetMessages.CSVCMsg_Print.class);
        /*  50 */ K2C.put(S2NetMessages.SVC_Messages.svc_SetView_VALUE, NetMessages.CSVCMsg_SetView.class);
        /*  51 */ K2C.put(S2NetMessages.SVC_Messages.svc_ClearAllStringTables_VALUE, S2NetMessages.CSVCMsg_ClearAllStringTables.class);
        /*  55 */ K2C.put(S2NetMessages.SVC_Messages.svc_PacketEntities_VALUE, NetMessages.CSVCMsg_PacketEntities.class);
        /*  60 */ K2C.put(S2NetMessages.SVC_Messages.svc_PeerList_VALUE, S2NetMessages.CSVCMsg_PeerList.class);
        /*  62 */ K2C.put(S2NetMessages.SVC_Messages.svc_HLTVStatus_VALUE, S2NetMessages.CSVCMsg_HLTVStatus.class);
        /*  70 */ K2C.put(S2NetMessages.SVC_Messages.svc_FullFrameSplit_VALUE, NetMessages.CSVCMsg_FullFrameSplit.class);

        /* 106 */ K2C.put(S2UserMessages.EBaseUserMessages.UM_Fade_VALUE, S2UserMessages.CUserMessageFade.class);
        /* 114 */ K2C.put(S2UserMessages.EBaseUserMessages.UM_RequestState_VALUE, S2UserMessages.CUserMessageRequestState.class);
        /* 115 */ K2C.put(S2UserMessages.EBaseUserMessages.UM_ResetHUD_VALUE, S2UserMessages.CUserMessageResetHUD.class);
        /* 118 */ K2C.put(S2UserMessages.EBaseUserMessages.UM_SayText2_VALUE, S2UserMessages.CUserMessageSayText2.class);
        /* 124 */ K2C.put(S2UserMessages.EBaseUserMessages.UM_TextMsg_VALUE, S2UserMessages.CUserMessageTextMsg.class);
        /* 128 */ K2C.put(S2UserMessages.EBaseUserMessages.UM_VoiceMask_VALUE, S2UserMessages.CUserMessageVoiceMask.class);
        /* 130 */ K2C.put(S2UserMessages.EBaseUserMessages.UM_SendAudio_VALUE, S2UserMessages.CUserMessageSendAudio.class);
        /* 144 */ K2C.put(S2UserMessages.EBaseUserMessages.UM_AudioParameter_VALUE, S2UserMessages.CUserMessageAudioParameter.class);
        /* 145 */ K2C.put(S2UserMessages.EBaseUserMessages.UM_ParticleManager_VALUE, DotaUserMessages.CDOTAUserMsg_ParticleManager.class);
        /* 154 */  K2C.put(S2UserMessages.EBaseUserMessages.UM_ServerFrameTime_VALUE, S2UserMessages.CUserMessageServerFrameTime.class);

//        /* 101 */ K2C.put(S2UserMessages.EBaseUserMessages.UM_AchievementEvent_VALUE, S2UserMessages.CUserMessageAchievementEvent.class);
//        /* 102 */ K2C.put(S2UserMessages.EBaseUserMessages.UM_CloseCaption_VALUE, S2UserMessages.CUserMessageCloseCaption.class);
//        /* 103 */ K2C.put(S2UserMessages.EBaseUserMessages.UM_CloseCaptionDirect_VALUE, S2UserMessages.CUserMessageCloseCaptionDirect.class);
//        /* 104 */ K2C.put(S2UserMessages.EBaseUserMessages.UM_CurrentTimescale_VALUE, S2UserMessages.CUserMessageCurrentTimescale.class);
//        /* 105 */ K2C.put(S2UserMessages.EBaseUserMessages.UM_DesiredTimescale_VALUE, S2UserMessages.CUserMessageDesiredTimescale.class);
//        /* 107 */ K2C.put(S2UserMessages.EBaseUserMessages.UM_GameTitle_VALUE, S2UserMessages.CUserMessageGameTitle.class);
//        /* 109 */ K2C.put(S2UserMessages.EBaseUserMessages.UM_HintText_VALUE, S2UserMessages.CUserMessageHintText.class);
//        /* 110 */ K2C.put(S2UserMessages.EBaseUserMessages.UM_HudMsg_VALUE, S2UserMessages.CUserMessageHudMsg.class);
//        /* 111 */ K2C.put(S2UserMessages.EBaseUserMessages.UM_HudText_VALUE, S2UserMessages.CUserMessageHudText.class);
//        /* 112 */ K2C.put(S2UserMessages.EBaseUserMessages.UM_KeyHintText_VALUE, S2UserMessages.CUserMessageKeyHintText.class);
//        /* 113 */ K2C.put(S2UserMessages.EBaseUserMessages.UM_ColoredText_VALUE, S2UserMessages.CUserMessageColoredText.class);
//        /* 116 */ K2C.put(S2UserMessages.EBaseUserMessages.UM_Rumble_VALUE, S2UserMessages.CUserMessageRumble.class);
//        /* 117 */ K2C.put(S2UserMessages.EBaseUserMessages.UM_SayText_VALUE, S2UserMessages.CUserMessageSayText.class);
//        /* 119 */ K2C.put(S2UserMessages.EBaseUserMessages.UM_SayTextChannel_VALUE, S2UserMessages.CUserMessageSayTextChannel.class);
//        /* 120 */ K2C.put(S2UserMessages.EBaseUserMessages.UM_Shake_VALUE, S2UserMessages.CUserMessageShake.class);
//        /* 121 */ K2C.put(S2UserMessages.EBaseUserMessages.UM_ShakeDir_VALUE, S2UserMessages.CUserMessageShakeDir.class);
//        /* 125 */ K2C.put(S2UserMessages.EBaseUserMessages.UM_ScreenTilt_VALUE, S2UserMessages.CUserMessageScreenTilt.class);
//        /* 126 */ K2C.put(S2UserMessages.EBaseUserMessages.UM_Train_VALUE, S2UserMessages.CUserMessageTrain.class);
//        /* 127 */ K2C.put(S2UserMessages.EBaseUserMessages.UM_VGUIMenu_VALUE, S2UserMessages.CUserMessageVGUIMenu.class);
//        /* 129 */ K2C.put(S2UserMessages.EBaseUserMessages.UM_VoiceSubtitle_VALUE, S2UserMessages.CUserMessageVoiceSubtitle.class);
//        /* 131 */ K2C.put(S2UserMessages.EBaseUserMessages.UM_ItemPickup_VALUE, S2UserMessages.CUserMessageItemPickup.class);
//        /* 132 */ K2C.put(S2UserMessages.EBaseUserMessages.UM_AmmoDenied_VALUE, S2UserMessages.CUserMessageAmmoDenied.class);
//        /* 133 */ K2C.put(S2UserMessages.EBaseUserMessages.UM_CrosshairAngle_VALUE, S2UserMessages.CUserMessageCrosshairAngle.class);
//        /* 134 */ K2C.put(S2UserMessages.EBaseUserMessages.UM_ShowMenu_VALUE, S2UserMessages.CUserMessageShowMenu.class);
//        /* 135 */ K2C.put(S2UserMessages.EBaseUserMessages.UM_CreditsMsg_VALUE, S2UserMessages.CUserMessageCreditsMsg.class);
//        /* 142 */ K2C.put(S2UserMessages.EBaseUserMessages.UM_CloseCaptionPlaceholder_VALUE, S2UserMessages.CUserMessageCloseCaptionPlaceholder.class);        System.out.println(K2C.);

//        /* 143 */ K2C.put(S2UserMessages.EBaseUserMessages.UM_CameraTransition_VALUE, S2UserMessages.CUserMessageCameraTransition.class);
//        /* 148 */ K2C.put(S2UserMessages.EBaseUserMessages.UM_CustomGameEvent_VALUE, null);
//        /* 149 */ K2C.put(S2UserMessages.EBaseUserMessages.UM_AnimGraphUpdate_VALUE, null);
//        /* 150 */  K2C.put(S2UserMessages.EBaseUserMessages.UM_HapticsManagerPulse_VALUE, null);
//        /* 151 */  K2C.put(S2UserMessages.EBaseUserMessages.UM_HapticsManagerEffect_VALUE, null);
//        /* 152 */  K2C.put(S2UserMessages.EBaseUserMessages.UM_CommandQueueState_VALUE, null);
//        /* 153 */  K2C.put(S2UserMessages.EBaseUserMessages.UM_UpdateCssClasses_VALUE, null);
//        /* 155 */  K2C.put(S2UserMessages.EBaseUserMessages.UM_LagCompensationError_VALUE, null);
//        /* 156 */  K2C.put(S2UserMessages.EBaseUserMessages.UM_RequestDllStatus_VALUE, null);
//        /* 154 */  K2C.put(S2UserMessages.EBaseUserMessages.UM_RequestUtilAction_VALUE, null);

        /* 205 */ K2C.put(S2GameEvents.EBaseGameEvents.GE_Source1LegacyGameEventList_VALUE, NetMessages.CSVCMsg_GameEventList.class);
        /* 206 */ K2C.put(S2GameEvents.EBaseGameEvents.GE_Source1LegacyListenEvents_VALUE, S2GameEvents.CMsgSource1LegacyListenEvents.class);
        /* 207 */ K2C.put(S2GameEvents.EBaseGameEvents.GE_Source1LegacyGameEvent_VALUE, NetworkBaseTypes.CSVCMsg_GameEvent.class);
        /* 208 */ K2C.put(S2GameEvents.EBaseGameEvents.GE_SosStartSoundEvent_VALUE, S2GameEvents.CMsgSosStartSoundEvent.class);
        /* 209 */ K2C.put(S2GameEvents.EBaseGameEvents.GE_SosStopSoundEvent_VALUE, S2GameEvents.CMsgSosStopSoundEvent.class);
        /* 210 */ K2C.put(S2GameEvents.EBaseGameEvents.GE_SosSetSoundEventParams_VALUE, S2GameEvents.CMsgSosSetSoundEventParams.class);
        /* 212 */ K2C.put(S2GameEvents.EBaseGameEvents.GE_SosStopSoundEventHash_VALUE, S2GameEvents.CMsgSosStopSoundEventHash.class);

//        /* 200 */ K2C.put(S2GameEvents.EBaseGameEvents.GE_VDebugGameSessionIDEvent_VALUE, S2GameEvents.CMsgVDebugGameSessionIDEvent.class);
//        /* 201 */ K2C.put(S2GameEvents.EBaseGameEvents.GE_PlaceDecalEvent_VALUE, S2GameEvents.CMsgPlaceDecalEvent.class);
//        /* 202 */ K2C.put(S2GameEvents.EBaseGameEvents.GE_ClearWorldDecalsEvent_VALUE, S2GameEvents.CMsgClearWorldDecalsEvent.class);
//        /* 203 */ K2C.put(S2GameEvents.EBaseGameEvents.GE_ClearEntityDecalsEvent_VALUE, S2GameEvents.CMsgClearEntityDecalsEvent.class);
//        /* 204 */ K2C.put(S2GameEvents.EBaseGameEvents.GE_ClearDecalsForSkeletonInstanceEvent_VALUE, S2GameEvents.CMsgClearDecalsForSkeletonInstanceEvent.class);
//        /* 211 */ K2C.put(S2GameEvents.EBaseGameEvents.GE_SosSetLibraryStackFields_VALUE, S2GameEvents.CMsgSosSetLibraryStackFields.class);

        /* 400 */ K2C.put(S2TempEntities.ETEProtobufIds.TE_EffectDispatchId_VALUE, S2TempEntities.CMsgTEEffectDispatch.class);

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
