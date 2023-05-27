package skadistats.clarity.wire.csgo.s2;

import com.google.protobuf.GeneratedMessage;
import skadistats.clarity.wire.ClassToKindMessageRegistry;
import skadistats.clarity.wire.KindToClassMessageRegistry;
import skadistats.clarity.wire.csgo.common.proto.CsgoUserMessages;
import skadistats.clarity.wire.csgo.s2.proto.CSGOS2GameEvents;
import skadistats.clarity.wire.csgo.s2.proto.CSGOS2MessageId;
import skadistats.clarity.wire.csgo.s2.proto.CSGOS2UserMessages;
import skadistats.clarity.wire.shared.common.proto.CommonNetMessages;
import skadistats.clarity.wire.shared.common.proto.CommonNetworkBaseTypes;
import skadistats.clarity.wire.shared.demo.proto.DemoNetMessages;
import skadistats.clarity.wire.shared.s2.proto.S2GameEvents;
import skadistats.clarity.wire.shared.s2.proto.S2NetMessages;
import skadistats.clarity.wire.shared.s2.proto.S2NetworkBaseTypes;
import skadistats.clarity.wire.shared.s2.proto.S2TempEntities;
import skadistats.clarity.wire.shared.s2.proto.S2UserMessages;

public class EmbeddedPackets {

    private static final KindToClassMessageRegistry K2C;

    static {
        K2C = new KindToClassMessageRegistry(100);

        /*   0 */ K2C.put(CSGOS2MessageId.NET_Messages.net_NOP_VALUE, CommonNetworkBaseTypes.CNETMsg_NOP.class);
        /*   1 */ K2C.put(CSGOS2MessageId.NET_Messages.net_Disconnect_VALUE, CommonNetworkBaseTypes.CNETMsg_Disconnect.class);
        /*   4 */ K2C.put(CSGOS2MessageId.NET_Messages.net_Tick_VALUE, CommonNetworkBaseTypes.CNETMsg_Tick.class);
        /*   5 */ K2C.put(CSGOS2MessageId.NET_Messages.net_StringCmd_VALUE, CommonNetworkBaseTypes.CNETMsg_StringCmd.class);
        /*   6 */ K2C.put(CSGOS2MessageId.NET_Messages.net_SetConVar_VALUE, CommonNetworkBaseTypes.CNETMsg_SetConVar.class);
        /*   7 */ K2C.put(CSGOS2MessageId.NET_Messages.net_SignonState_VALUE, CommonNetworkBaseTypes.CNETMsg_SignonState.class);
        /*   8 */ K2C.put(CSGOS2MessageId.NET_Messages.net_SpawnGroup_Load_VALUE, S2NetworkBaseTypes.CNETMsg_SpawnGroup_Load.class);
        /*   9 */ K2C.put(CSGOS2MessageId.NET_Messages.net_SpawnGroup_ManifestUpdate_VALUE, S2NetworkBaseTypes.CNETMsg_SpawnGroup_ManifestUpdate.class);
        /*  11 */ K2C.put(CSGOS2MessageId.NET_Messages.net_SpawnGroup_SetCreationTick_VALUE, S2NetworkBaseTypes.CNETMsg_SpawnGroup_SetCreationTick.class);
        /*  12 */ K2C.put(CSGOS2MessageId.NET_Messages.net_SpawnGroup_Unload_VALUE, S2NetworkBaseTypes.CNETMsg_SpawnGroup_Unload.class);
        /*  13 */ K2C.put(CSGOS2MessageId.NET_Messages.net_SpawnGroup_LoadCompleted_VALUE, S2NetworkBaseTypes.CNETMsg_SpawnGroup_LoadCompleted.class);

        /*  40 */ K2C.put(CSGOS2MessageId.SVC_Messages.svc_ServerInfo_VALUE, DemoNetMessages.CSVCMsg_ServerInfo.class);
        /*  41 */ K2C.put(CSGOS2MessageId.SVC_Messages.svc_FlattenedSerializer_VALUE, S2NetMessages.CSVCMsg_FlattenedSerializer.class);
        /*  42 */ K2C.put(CSGOS2MessageId.SVC_Messages.svc_ClassInfo_VALUE, CommonNetMessages.CSVCMsg_ClassInfo.class);
        /*  44 */ K2C.put(CSGOS2MessageId.SVC_Messages.svc_CreateStringTable_VALUE, S2NetMessages.CSVCMsg_CreateStringTable.class);
        /*  45 */ K2C.put(CSGOS2MessageId.SVC_Messages.svc_UpdateStringTable_VALUE, CommonNetMessages.CSVCMsg_UpdateStringTable.class);
        /*  46 */ K2C.put(CSGOS2MessageId.SVC_Messages.svc_VoiceInit_VALUE, CommonNetMessages.CSVCMsg_VoiceInit.class);
        /*  47 */ K2C.put(CSGOS2MessageId.SVC_Messages.svc_VoiceData_VALUE, S2NetMessages.CSVCMsg_VoiceData.class);
        /*  48 */ K2C.put(CSGOS2MessageId.SVC_Messages.svc_Print_VALUE, CommonNetMessages.CSVCMsg_Print.class);
        /*  50 */ K2C.put(CSGOS2MessageId.SVC_Messages.svc_SetView_VALUE, CommonNetMessages.CSVCMsg_SetView.class);
        /*  51 */ K2C.put(CSGOS2MessageId.SVC_Messages.svc_ClearAllStringTables_VALUE, S2NetMessages.CSVCMsg_ClearAllStringTables.class);
        /*  55 */ K2C.put(CSGOS2MessageId.SVC_Messages.svc_PacketEntities_VALUE, CommonNetMessages.CSVCMsg_PacketEntities.class);
        /*  60 */ K2C.put(CSGOS2MessageId.SVC_Messages.svc_PeerList_VALUE, S2NetMessages.CSVCMsg_PeerList.class);
        /*  62 */ K2C.put(CSGOS2MessageId.SVC_Messages.svc_HLTVStatus_VALUE, S2NetMessages.CSVCMsg_HLTVStatus.class);
        /*  70 */ K2C.put(CSGOS2MessageId.SVC_Messages.svc_FullFrameSplit_VALUE, CommonNetMessages.CSVCMsg_FullFrameSplit.class);

        /* 101 */ K2C.put(CSGOS2MessageId.EBaseUserMessages.UM_AchievementEvent_VALUE, S2UserMessages.CUserMessageAchievementEvent.class);
        /* 102 */ K2C.put(CSGOS2MessageId.EBaseUserMessages.UM_CloseCaption_VALUE, S2UserMessages.CUserMessageCloseCaption.class);
        /* 103 */ K2C.put(CSGOS2MessageId.EBaseUserMessages.UM_CloseCaptionDirect_VALUE, S2UserMessages.CUserMessageCloseCaptionDirect.class);
        /* 104 */ K2C.put(CSGOS2MessageId.EBaseUserMessages.UM_CurrentTimescale_VALUE, S2UserMessages.CUserMessageCurrentTimescale.class);
        /* 105 */ K2C.put(CSGOS2MessageId.EBaseUserMessages.UM_DesiredTimescale_VALUE, S2UserMessages.CUserMessageDesiredTimescale.class);
        /* 106 */ K2C.put(CSGOS2MessageId.EBaseUserMessages.UM_Fade_VALUE, S2UserMessages.CUserMessageFade.class);
        /* 107 */ K2C.put(CSGOS2MessageId.EBaseUserMessages.UM_GameTitle_VALUE, S2UserMessages.CUserMessageGameTitle.class);
        /* 110 */ K2C.put(CSGOS2MessageId.EBaseUserMessages.UM_HudMsg_VALUE, S2UserMessages.CUserMessageHudMsg.class);
        /* 111 */ K2C.put(CSGOS2MessageId.EBaseUserMessages.UM_HudText_VALUE, S2UserMessages.CUserMessageHudText.class);
        /* 113 */ K2C.put(CSGOS2MessageId.EBaseUserMessages.UM_ColoredText_VALUE, S2UserMessages.CUserMessageColoredText.class);
        /* 115 */ K2C.put(CSGOS2MessageId.EBaseUserMessages.UM_ResetHUD_VALUE, S2UserMessages.CUserMessageResetHUD.class);
        /* 116 */ K2C.put(CSGOS2MessageId.EBaseUserMessages.UM_Rumble_VALUE, S2UserMessages.CUserMessageRumble.class);
        /* 117 */ K2C.put(CSGOS2MessageId.EBaseUserMessages.UM_SayText_VALUE, S2UserMessages.CUserMessageSayText.class);
        /* 118 */ K2C.put(CSGOS2MessageId.EBaseUserMessages.UM_SayText2_VALUE, S2UserMessages.CUserMessageSayText2.class);
        /* 119 */ K2C.put(CSGOS2MessageId.EBaseUserMessages.UM_SayTextChannel_VALUE, S2UserMessages.CUserMessageSayTextChannel.class);
        /* 120 */ K2C.put(CSGOS2MessageId.EBaseUserMessages.UM_Shake_VALUE, S2UserMessages.CUserMessageShake.class);
        /* 121 */ K2C.put(CSGOS2MessageId.EBaseUserMessages.UM_ShakeDir_VALUE, S2UserMessages.CUserMessageShakeDir.class);
        /* 124 */ K2C.put(CSGOS2MessageId.EBaseUserMessages.UM_TextMsg_VALUE, S2UserMessages.CUserMessageTextMsg.class);
        /* 125 */ K2C.put(CSGOS2MessageId.EBaseUserMessages.UM_ScreenTilt_VALUE, S2UserMessages.CUserMessageScreenTilt.class);
        /* 128 */ K2C.put(CSGOS2MessageId.EBaseUserMessages.UM_VoiceMask_VALUE, S2UserMessages.CUserMessageVoiceMask.class);
        /* 130 */ K2C.put(CSGOS2MessageId.EBaseUserMessages.UM_SendAudio_VALUE, S2UserMessages.CUserMessageSendAudio.class);
        /* 131 */ K2C.put(CSGOS2MessageId.EBaseUserMessages.UM_ItemPickup_VALUE, S2UserMessages.CUserMessageItemPickup.class);
        /* 132 */ K2C.put(CSGOS2MessageId.EBaseUserMessages.UM_AmmoDenied_VALUE, S2UserMessages.CUserMessageAmmoDenied.class);
        /* 134 */ K2C.put(CSGOS2MessageId.EBaseUserMessages.UM_ShowMenu_VALUE, S2UserMessages.CUserMessageShowMenu.class);
        /* 135 */ K2C.put(CSGOS2MessageId.EBaseUserMessages.UM_CreditsMsg_VALUE, S2UserMessages.CUserMessageCreditsMsg.class);
        /* 138 */ // TODO: seen in replay, no enum or protobuf definition
        /* 142 */ K2C.put(CSGOS2MessageId.EBaseUserMessages.UM_CloseCaptionPlaceholder_VALUE, S2UserMessages.CUserMessageCloseCaptionPlaceholder.class);
        /* 143 */ K2C.put(CSGOS2MessageId.EBaseUserMessages.UM_CameraTransition_VALUE, S2UserMessages.CUserMessageCameraTransition.class);
        /* 144 */ K2C.put(CSGOS2MessageId.EBaseUserMessages.UM_AudioParameter_VALUE, S2UserMessages.CUserMessageAudioParameter.class);
        /* 145 */ K2C.put(CSGOS2MessageId.EBaseUserMessages.UM_ParticleManager_VALUE, CSGOS2UserMessages.CUserMsg_ParticleManager.class);
        /* 146 */ K2C.put(CSGOS2MessageId.EBaseUserMessages.UM_HudError_VALUE, S2UserMessages.CUserMsg_HudError.class);
        /* 148 */ K2C.put(CSGOS2MessageId.EBaseUserMessages.UM_CustomGameEvent_VALUE, S2UserMessages.CUserMsg_CustomGameEvent.class);
        /* 149 */ K2C.put(CSGOS2MessageId.EBaseUserMessages.UM_AnimGraphUpdate_VALUE, S2UserMessages.CUserMessageAnimStateGraphState.class);
        /* 150 */ K2C.put(CSGOS2MessageId.EBaseUserMessages.UM_HapticsManagerPulse_VALUE, S2UserMessages.CUserMessageHapticsManagerPulse.class);
        /* 151 */ K2C.put(CSGOS2MessageId.EBaseUserMessages.UM_HapticsManagerEffect_VALUE, S2UserMessages.CUserMessageHapticsManagerEffect.class);
        /* 152 */ K2C.put(CSGOS2MessageId.EBaseUserMessages.UM_CommandQueueState_VALUE, S2UserMessages.CUserMessageCommandQueueState.class);
        /* 153 */ K2C.put(CSGOS2MessageId.EBaseUserMessages.UM_UpdateCssClasses_VALUE, S2UserMessages.CUserMessageUpdateCssClasses.class);
        /* 155 */ K2C.put(CSGOS2MessageId.EBaseUserMessages.UM_LagCompensationError_VALUE, S2UserMessages.CUserMessageLagCompensationError.class);
        /* 156 */ K2C.put(CSGOS2MessageId.EBaseUserMessages.UM_RequestDllStatus_VALUE, S2UserMessages.CUserMessageRequestDllStatus.class);
        /* 157 */ K2C.put(CSGOS2MessageId.EBaseUserMessages.UM_RequestUtilAction_VALUE, S2UserMessages.CUserMessageRequestUtilAction.class);

        /* 205 */ K2C.put(S2GameEvents.EBaseGameEvents.GE_Source1LegacyGameEventList_VALUE, CommonNetMessages.CSVCMsg_GameEventList.class);
        /* 206 */ K2C.put(S2GameEvents.EBaseGameEvents.GE_Source1LegacyListenEvents_VALUE, S2GameEvents.CMsgSource1LegacyListenEvents.class);
        /* 207 */ K2C.put(S2GameEvents.EBaseGameEvents.GE_Source1LegacyGameEvent_VALUE, CommonNetworkBaseTypes.CSVCMsg_GameEvent.class);
        /* 208 */ K2C.put(S2GameEvents.EBaseGameEvents.GE_SosStartSoundEvent_VALUE, S2GameEvents.CMsgSosStartSoundEvent.class);
        /* 209 */ K2C.put(S2GameEvents.EBaseGameEvents.GE_SosStopSoundEvent_VALUE, S2GameEvents.CMsgSosStopSoundEvent.class);
        /* 210 */ K2C.put(S2GameEvents.EBaseGameEvents.GE_SosSetSoundEventParams_VALUE, S2GameEvents.CMsgSosSetSoundEventParams.class);
        /* 212 */ K2C.put(S2GameEvents.EBaseGameEvents.GE_SosStopSoundEventHash_VALUE, S2GameEvents.CMsgSosStopSoundEventHash.class);

        /* 301 */ K2C.put(CSGOS2MessageId.ECstrike15UserMessages.CS_UM_VGUIMenu_VALUE, CsgoUserMessages.CCSUsrMsg_VGUIMenu.class);
        /* 302 */ K2C.put(CSGOS2MessageId.ECstrike15UserMessages.CS_UM_Geiger_VALUE, CsgoUserMessages.CCSUsrMsg_Geiger.class);
        /* 303 */ K2C.put(CSGOS2MessageId.ECstrike15UserMessages.CS_UM_Train_VALUE, CsgoUserMessages.CCSUsrMsg_Train.class);
        /* 304 */ K2C.put(CSGOS2MessageId.ECstrike15UserMessages.CS_UM_HudText_VALUE, CsgoUserMessages.CCSUsrMsg_HudText.class);
//      /* 305 */ K2C.put(CSGOS2MessageId.ECstrike15UserMessages.CS_UM_SayText_VALUE, S2UserMessages.CUserMessageSayText.class);
//      /* 306 */ K2C.put(CSGOS2MessageId.ECstrike15UserMessages.CS_UM_SayText2_VALUE, S2UserMessages.CUserMessageSayText2.class);
//      /* 307 */ K2C.put(CSGOS2MessageId.ECstrike15UserMessages.CS_UM_TextMsg_VALUE, S2UserMessages.CUserMessageTextMsg.class);
        /* 308 */ K2C.put(CSGOS2MessageId.ECstrike15UserMessages.CS_UM_HudMsg_VALUE, CsgoUserMessages.CCSUsrMsg_HudMsg.class);
        /* 309 */ K2C.put(CSGOS2MessageId.ECstrike15UserMessages.CS_UM_ResetHud_VALUE, CsgoUserMessages.CCSUsrMsg_ResetHud.class);
        /* 310 */ K2C.put(CSGOS2MessageId.ECstrike15UserMessages.CS_UM_GameTitle_VALUE, CsgoUserMessages.CCSUsrMsg_GameTitle.class);
        /* 312 */ K2C.put(CSGOS2MessageId.ECstrike15UserMessages.CS_UM_Shake_VALUE, CsgoUserMessages.CCSUsrMsg_Shake.class);
        /* 313 */ K2C.put(CSGOS2MessageId.ECstrike15UserMessages.CS_UM_Fade_VALUE, CsgoUserMessages.CCSUsrMsg_Fade.class);
        /* 314 */ K2C.put(CSGOS2MessageId.ECstrike15UserMessages.CS_UM_Rumble_VALUE, CsgoUserMessages.CCSUsrMsg_Rumble.class);
        /* 315 */ K2C.put(CSGOS2MessageId.ECstrike15UserMessages.CS_UM_CloseCaption_VALUE, CsgoUserMessages.CCSUsrMsg_CloseCaption.class);
        /* 316 */ K2C.put(CSGOS2MessageId.ECstrike15UserMessages.CS_UM_CloseCaptionDirect_VALUE, CsgoUserMessages.CCSUsrMsg_CloseCaptionDirect.class);
        /* 317 */ K2C.put(CSGOS2MessageId.ECstrike15UserMessages.CS_UM_SendAudio_VALUE, CsgoUserMessages.CCSUsrMsg_SendAudio.class);
        /* 318 */ K2C.put(CSGOS2MessageId.ECstrike15UserMessages.CS_UM_RawAudio_VALUE, CsgoUserMessages.CCSUsrMsg_RawAudio.class);
        /* 319 */ K2C.put(CSGOS2MessageId.ECstrike15UserMessages.CS_UM_VoiceMask_VALUE, CsgoUserMessages.CCSUsrMsg_VoiceMask.class);
        /* 320 */ K2C.put(CSGOS2MessageId.ECstrike15UserMessages.CS_UM_RequestState_VALUE, CsgoUserMessages.CCSUsrMsg_RequestState.class);
        /* 321 */ K2C.put(CSGOS2MessageId.ECstrike15UserMessages.CS_UM_Damage_VALUE, CsgoUserMessages.CCSUsrMsg_Damage.class);
        /* 322 */ K2C.put(CSGOS2MessageId.ECstrike15UserMessages.CS_UM_RadioText_VALUE, CsgoUserMessages.CCSUsrMsg_RadioText.class);
        /* 323 */ K2C.put(CSGOS2MessageId.ECstrike15UserMessages.CS_UM_HintText_VALUE, CsgoUserMessages.CCSUsrMsg_HintText.class);
        /* 324 */ K2C.put(CSGOS2MessageId.ECstrike15UserMessages.CS_UM_KeyHintText_VALUE, CsgoUserMessages.CCSUsrMsg_KeyHintText.class);
        /* 325 */ K2C.put(CSGOS2MessageId.ECstrike15UserMessages.CS_UM_ProcessSpottedEntityUpdate_VALUE, CsgoUserMessages.CCSUsrMsg_ProcessSpottedEntityUpdate.class);
        /* 326 */ K2C.put(CSGOS2MessageId.ECstrike15UserMessages.CS_UM_ReloadEffect_VALUE, CsgoUserMessages.CCSUsrMsg_ReloadEffect.class);
        /* 327 */ K2C.put(CSGOS2MessageId.ECstrike15UserMessages.CS_UM_AdjustMoney_VALUE, CsgoUserMessages.CCSUsrMsg_AdjustMoney.class);
//      /* 328 */ K2C.put(CSGOS2MessageId.ECstrike15UserMessages.CS_UM_UpdateTeamMoney_VALUE, CsgoUserMessages.CCSUsrMsg_UpdateTeamMoney.class);
        /* 329 */ K2C.put(CSGOS2MessageId.ECstrike15UserMessages.CS_UM_StopSpectatorMode_VALUE, CsgoUserMessages.CCSUsrMsg_StopSpectatorMode.class);
        /* 330 */ K2C.put(CSGOS2MessageId.ECstrike15UserMessages.CS_UM_KillCam_VALUE, CsgoUserMessages.CCSUsrMsg_KillCam.class);
        /* 331 */ K2C.put(CSGOS2MessageId.ECstrike15UserMessages.CS_UM_DesiredTimescale_VALUE, CsgoUserMessages.CCSUsrMsg_DesiredTimescale.class);
        /* 332 */ K2C.put(CSGOS2MessageId.ECstrike15UserMessages.CS_UM_CurrentTimescale_VALUE, CsgoUserMessages.CCSUsrMsg_CurrentTimescale.class);
        /* 333 */ K2C.put(CSGOS2MessageId.ECstrike15UserMessages.CS_UM_AchievementEvent_VALUE, CsgoUserMessages.CCSUsrMsg_AchievementEvent.class);
        /* 334 */ K2C.put(CSGOS2MessageId.ECstrike15UserMessages.CS_UM_MatchEndConditions_VALUE, CsgoUserMessages.CCSUsrMsg_MatchEndConditions.class);
        /* 335 */ K2C.put(CSGOS2MessageId.ECstrike15UserMessages.CS_UM_DisconnectToLobby_VALUE, CsgoUserMessages.CCSUsrMsg_DisconnectToLobby.class);
        /* 336 */ K2C.put(CSGOS2MessageId.ECstrike15UserMessages.CS_UM_PlayerStatsUpdate_VALUE, CsgoUserMessages.CCSUsrMsg_PlayerStatsUpdate.class);
        /* 338 */ K2C.put(CSGOS2MessageId.ECstrike15UserMessages.CS_UM_WarmupHasEnded_VALUE, CsgoUserMessages.CCSUsrMsg_WarmupHasEnded.class);
        /* 339 */ K2C.put(CSGOS2MessageId.ECstrike15UserMessages.CS_UM_ClientInfo_VALUE, CsgoUserMessages.CCSUsrMsg_ClientInfo.class);
        /* 340 */ K2C.put(CSGOS2MessageId.ECstrike15UserMessages.CS_UM_XRankGet_VALUE, CsgoUserMessages.CCSUsrMsg_XRankGet.class);
        /* 341 */ K2C.put(CSGOS2MessageId.ECstrike15UserMessages.CS_UM_XRankUpd_VALUE, CsgoUserMessages.CCSUsrMsg_XRankUpd.class);
        /* 345 */ K2C.put(CSGOS2MessageId.ECstrike15UserMessages.CS_UM_CallVoteFailed_VALUE, CsgoUserMessages.CCSUsrMsg_CallVoteFailed.class);
        /* 346 */ K2C.put(CSGOS2MessageId.ECstrike15UserMessages.CS_UM_VoteStart_VALUE, CsgoUserMessages.CCSUsrMsg_VoteStart.class);
        /* 347 */ K2C.put(CSGOS2MessageId.ECstrike15UserMessages.CS_UM_VotePass_VALUE, CsgoUserMessages.CCSUsrMsg_VotePass.class);
        /* 348 */ K2C.put(CSGOS2MessageId.ECstrike15UserMessages.CS_UM_VoteFailed_VALUE, CsgoUserMessages.CCSUsrMsg_VoteFailed.class);
        /* 349 */ K2C.put(CSGOS2MessageId.ECstrike15UserMessages.CS_UM_VoteSetup_VALUE, CsgoUserMessages.CCSUsrMsg_VoteSetup.class);
        /* 350 */ K2C.put(CSGOS2MessageId.ECstrike15UserMessages.CS_UM_ServerRankRevealAll_VALUE, CsgoUserMessages.CCSUsrMsg_ServerRankRevealAll.class);
        /* 351 */ K2C.put(CSGOS2MessageId.ECstrike15UserMessages.CS_UM_SendLastKillerDamageToClient_VALUE, CsgoUserMessages.CCSUsrMsg_SendLastKillerDamageToClient.class);
        /* 352 */ K2C.put(CSGOS2MessageId.ECstrike15UserMessages.CS_UM_ServerRankUpdate_VALUE, CsgoUserMessages.CCSUsrMsg_ServerRankUpdate.class);
        /* 353 */ K2C.put(CSGOS2MessageId.ECstrike15UserMessages.CS_UM_ItemPickup_VALUE, CsgoUserMessages.CCSUsrMsg_ItemPickup.class);
        /* 354 */ K2C.put(CSGOS2MessageId.ECstrike15UserMessages.CS_UM_ShowMenu_VALUE, CsgoUserMessages.CCSUsrMsg_ShowMenu.class);
        /* 355 */ K2C.put(CSGOS2MessageId.ECstrike15UserMessages.CS_UM_BarTime_VALUE, CsgoUserMessages.CCSUsrMsg_BarTime.class);
        /* 356 */ K2C.put(CSGOS2MessageId.ECstrike15UserMessages.CS_UM_AmmoDenied_VALUE, CsgoUserMessages.CCSUsrMsg_AmmoDenied.class);
        /* 357 */ K2C.put(CSGOS2MessageId.ECstrike15UserMessages.CS_UM_MarkAchievement_VALUE, CsgoUserMessages.CCSUsrMsg_MarkAchievement.class);
        /* 358 */ K2C.put(CSGOS2MessageId.ECstrike15UserMessages.CS_UM_MatchStatsUpdate_VALUE, CsgoUserMessages.CCSUsrMsg_MatchStatsUpdate.class);
        /* 359 */ K2C.put(CSGOS2MessageId.ECstrike15UserMessages.CS_UM_ItemDrop_VALUE, CsgoUserMessages.CCSUsrMsg_ItemDrop.class);
        /* 360 */ K2C.put(CSGOS2MessageId.ECstrike15UserMessages.CS_UM_GlowPropTurnOff_VALUE, CsgoUserMessages.CCSUsrMsg_GlowPropTurnOff.class);
        /* 361 */ K2C.put(CSGOS2MessageId.ECstrike15UserMessages.CS_UM_SendPlayerItemDrops_VALUE, CsgoUserMessages.CCSUsrMsg_SendPlayerItemDrops.class);
        /* 362 */ K2C.put(CSGOS2MessageId.ECstrike15UserMessages.CS_UM_RoundBackupFilenames_VALUE, CsgoUserMessages.CCSUsrMsg_RoundBackupFilenames.class);
        /* 363 */ K2C.put(CSGOS2MessageId.ECstrike15UserMessages.CS_UM_SendPlayerItemFound_VALUE, CsgoUserMessages.CCSUsrMsg_SendPlayerItemFound.class);
        /* 364 */ K2C.put(CSGOS2MessageId.ECstrike15UserMessages.CS_UM_ReportHit_VALUE, CsgoUserMessages.CCSUsrMsg_ReportHit.class);
        /* 365 */ K2C.put(CSGOS2MessageId.ECstrike15UserMessages.CS_UM_XpUpdate_VALUE, CsgoUserMessages.CCSUsrMsg_XpUpdate.class);
        /* 366 */ K2C.put(CSGOS2MessageId.ECstrike15UserMessages.CS_UM_QuestProgress_VALUE, CsgoUserMessages.CCSUsrMsg_QuestProgress.class);
        /* 367 */ K2C.put(CSGOS2MessageId.ECstrike15UserMessages.CS_UM_ScoreLeaderboardData_VALUE, CsgoUserMessages.CCSUsrMsg_ScoreLeaderboardData.class);
        /* 368 */ K2C.put(CSGOS2MessageId.ECstrike15UserMessages.CS_UM_PlayerDecalDigitalSignature_VALUE, CsgoUserMessages.CCSUsrMsg_PlayerDecalDigitalSignature.class);
        /* 369 */ K2C.put(CSGOS2MessageId.ECstrike15UserMessages.CS_UM_WeaponSound_VALUE, CsgoUserMessages.CCSUsrMsg_WeaponSound.class);
        /* 370 */ K2C.put(CSGOS2MessageId.ECstrike15UserMessages.CS_UM_UpdateScreenHealthBar_VALUE, CsgoUserMessages.CCSUsrMsg_UpdateScreenHealthBar.class);
        /* 371 */ K2C.put(CSGOS2MessageId.ECstrike15UserMessages.CS_UM_EntityOutlineHighlight_VALUE, CsgoUserMessages.CCSUsrMsg_EntityOutlineHighlight.class);
        /* 372 */ K2C.put(CSGOS2MessageId.ECstrike15UserMessages.CS_UM_SSUI_VALUE, CsgoUserMessages.CCSUsrMsg_SSUI.class);
        /* 373 */ K2C.put(CSGOS2MessageId.ECstrike15UserMessages.CS_UM_SurvivalStats_VALUE, CsgoUserMessages.CCSUsrMsg_SurvivalStats.class);
//      /* 374 */ K2C.put(CSGOS2MessageId.ECstrike15UserMessages.CS_UM_DisconnectToLobby2_VALUE, CsgoUserMessages.CCSUsrMsg_DisconnectToLobby2.class);
        /* 375 */ K2C.put(CSGOS2MessageId.ECstrike15UserMessages.CS_UM_EndOfMatchAllPlayersData_VALUE, CsgoUserMessages.CCSUsrMsg_EndOfMatchAllPlayersData.class);
        /* 376 */ K2C.put(CSGOS2MessageId.ECstrike15UserMessages.CS_UM_PostRoundDamageReport_VALUE, CsgoUserMessages.CCSUsrMsg_PostRoundDamageReport.class);
        /* 379 */ K2C.put(CSGOS2MessageId.ECstrike15UserMessages.CS_UM_RoundEndReportData_VALUE, CsgoUserMessages.CCSUsrMsg_RoundEndReportData.class);
        /* 380 */ K2C.put(CSGOS2MessageId.ECstrike15UserMessages.CS_UM_CurrentRoundOdds_VALUE, CsgoUserMessages.CCSUsrMsg_CurrentRoundOdds.class);
        /* 381 */ K2C.put(CSGOS2MessageId.ECstrike15UserMessages.CS_UM_DeepStats_VALUE, CsgoUserMessages.CCSUsrMsg_DeepStats.class);
//      /* 382 */ K2C.put(CSGOS2MessageId.ECstrike15UserMessages.CS_UM_UtilMsg_VALUE, CsgoUserMessages.CCSUsrMsg_UtilMsg.class);
        /* 383 */ K2C.put(CSGOS2MessageId.ECstrike15UserMessages.CS_UM_ShootInfo_VALUE, CsgoUserMessages.CCSUsrMsg_ShootInfo.class);

        /* 400 */ K2C.put(S2TempEntities.ETEProtobufIds.TE_EffectDispatchId_VALUE, S2TempEntities.CMsgTEEffectDispatch.class);
        /* 401 */ K2C.put(S2TempEntities.ETEProtobufIds.TE_ArmorRicochetId_VALUE, S2TempEntities.CMsgTEArmorRicochet.class);
        /* 402 */ K2C.put(S2TempEntities.ETEProtobufIds.TE_BeamEntPointId_VALUE, S2TempEntities.CMsgTEBeamEntPoint.class);
        /* 403 */ K2C.put(S2TempEntities.ETEProtobufIds.TE_BeamEntsId_VALUE, S2TempEntities.CMsgTEBeamEnts.class);
        /* 404 */ K2C.put(S2TempEntities.ETEProtobufIds.TE_BeamPointsId_VALUE, S2TempEntities.CMsgTEBeamPoints.class);
        /* 405 */ K2C.put(S2TempEntities.ETEProtobufIds.TE_BeamRingId_VALUE, S2TempEntities.CMsgTEBeamRing.class);
        /* 406 */ K2C.put(S2TempEntities.ETEProtobufIds.TE_BreakModelId_VALUE, S2TempEntities.CMsgTEBreakModel.class);
        /* 407 */ K2C.put(S2TempEntities.ETEProtobufIds.TE_BSPDecalId_VALUE, S2TempEntities.CMsgTEBSPDecal.class);
        /* 408 */ K2C.put(S2TempEntities.ETEProtobufIds.TE_BubblesId_VALUE, S2TempEntities.CMsgTEBubbles.class);
        /* 409 */ K2C.put(S2TempEntities.ETEProtobufIds.TE_BubbleTrailId_VALUE, S2TempEntities.CMsgTEBubbleTrail.class);
        /* 410 */ K2C.put(S2TempEntities.ETEProtobufIds.TE_DecalId_VALUE, S2TempEntities.CMsgTEDecal.class);
        /* 411 */ K2C.put(S2TempEntities.ETEProtobufIds.TE_WorldDecalId_VALUE, S2TempEntities.CMsgTEWorldDecal.class);
        /* 412 */ K2C.put(S2TempEntities.ETEProtobufIds.TE_EnergySplashId_VALUE, S2TempEntities.CMsgTEEnergySplash.class);
        /* 413 */ K2C.put(S2TempEntities.ETEProtobufIds.TE_FizzId_VALUE, S2TempEntities.CMsgTEFizz.class);
        /* 414 */ K2C.put(S2TempEntities.ETEProtobufIds.TE_ShatterSurfaceId_VALUE, S2TempEntities.CMsgTEShatterSurface.class);
        /* 415 */ K2C.put(S2TempEntities.ETEProtobufIds.TE_GlowSpriteId_VALUE, S2TempEntities.CMsgTEGlowSprite.class);
        /* 416 */ K2C.put(S2TempEntities.ETEProtobufIds.TE_ImpactId_VALUE, S2TempEntities.CMsgTEImpact.class);
        /* 417 */ K2C.put(S2TempEntities.ETEProtobufIds.TE_MuzzleFlashId_VALUE, S2TempEntities.CMsgTEMuzzleFlash.class);
        /* 418 */ K2C.put(S2TempEntities.ETEProtobufIds.TE_BloodStreamId_VALUE, S2TempEntities.CMsgTEBloodStream.class);
        /* 419 */ K2C.put(S2TempEntities.ETEProtobufIds.TE_ExplosionId_VALUE, S2TempEntities.CMsgTEExplosion.class);
        /* 420 */ K2C.put(S2TempEntities.ETEProtobufIds.TE_DustId_VALUE, S2TempEntities.CMsgTEDust.class);
        /* 421 */ K2C.put(S2TempEntities.ETEProtobufIds.TE_LargeFunnelId_VALUE, S2TempEntities.CMsgTELargeFunnel.class);
        /* 422 */ K2C.put(S2TempEntities.ETEProtobufIds.TE_SparksId_VALUE, S2TempEntities.CMsgTESparks.class);
        /* 423 */ K2C.put(S2TempEntities.ETEProtobufIds.TE_PhysicsPropId_VALUE, S2TempEntities.CMsgTEPhysicsProp.class);
        /* 424 */ K2C.put(S2TempEntities.ETEProtobufIds.TE_PlayerDecalId_VALUE, S2TempEntities.CMsgTEPlayerDecal.class);
        /* 425 */ K2C.put(S2TempEntities.ETEProtobufIds.TE_ProjectedDecalId_VALUE, S2TempEntities.CMsgTEProjectedDecal.class);
        /* 426 */ K2C.put(S2TempEntities.ETEProtobufIds.TE_SmokeId_VALUE, S2TempEntities.CMsgTESmoke.class);

        /* 450 */ K2C.put(CSGOS2GameEvents.ECsgoGameEvents.GE_PlayerAnimEventId_VALUE, CSGOS2GameEvents.CMsgTEPlayerAnimEvent.class);
        /* 451 */ K2C.put(CSGOS2GameEvents.ECsgoGameEvents.GE_RadioIconEventId_VALUE, CSGOS2GameEvents.CMsgTERadioIcon.class);
        /* 452 */ K2C.put(CSGOS2GameEvents.ECsgoGameEvents.GE_FireBulletsId_VALUE, CSGOS2GameEvents.CMsgTEFireBullets.class);
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
