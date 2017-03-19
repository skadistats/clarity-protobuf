package skadistats.clarity.wire.s2;

import com.google.protobuf.GeneratedMessage;
import skadistats.clarity.wire.common.proto.DotaUserMessages;
import skadistats.clarity.wire.common.proto.NetMessages;
import skadistats.clarity.wire.common.proto.NetworkBaseTypes;
import skadistats.clarity.wire.s2.proto.S2DotaGcCommon;
import skadistats.clarity.wire.s2.proto.S2DotaMatchMetadata;
import skadistats.clarity.wire.s2.proto.S2DotaUserMessages;
import skadistats.clarity.wire.s2.proto.S2GameEvents;
import skadistats.clarity.wire.s2.proto.S2NetMessages;
import skadistats.clarity.wire.s2.proto.S2TempEntities;
import skadistats.clarity.wire.s2.proto.S2UserMessages;

import java.util.HashMap;
import java.util.Map;

public class EmbeddedPackets {

    private static final Map<Integer, Class<? extends GeneratedMessage>> EMBED;
    private static final Map<Class<? extends GeneratedMessage>, Integer> REVERSE;

    static {
        EMBED = new HashMap<>();
        /*   0 */ EMBED.put(NetworkBaseTypes.NET_Messages.net_NOP_VALUE, NetworkBaseTypes.CNETMsg_NOP.class);
        /*   1 */ EMBED.put(NetworkBaseTypes.NET_Messages.net_Disconnect_VALUE, NetworkBaseTypes.CNETMsg_Disconnect.class);
        /*   4 */ EMBED.put(NetworkBaseTypes.NET_Messages.net_Tick_VALUE, NetworkBaseTypes.CNETMsg_Tick.class);
        /*   6 */ EMBED.put(NetworkBaseTypes.NET_Messages.net_SetConVar_VALUE, NetworkBaseTypes.CNETMsg_SetConVar.class);
        /*   7 */ EMBED.put(NetworkBaseTypes.NET_Messages.net_SignonState_VALUE, NetworkBaseTypes.CNETMsg_SignonState.class);
        /*   8 */ EMBED.put(NetworkBaseTypes.NET_Messages.net_SpawnGroup_Load_VALUE, NetworkBaseTypes.CNETMsg_SpawnGroup_Load.class);
        /*   9 */ EMBED.put(NetworkBaseTypes.NET_Messages.net_SpawnGroup_ManifestUpdate_VALUE, NetworkBaseTypes.CNETMsg_SpawnGroup_ManifestUpdate.class);
        /*  11 */ EMBED.put(NetworkBaseTypes.NET_Messages.net_SpawnGroup_SetCreationTick_VALUE, NetworkBaseTypes.CNETMsg_SpawnGroup_SetCreationTick.class);
        /*  12 */ EMBED.put(NetworkBaseTypes.NET_Messages.net_SpawnGroup_Unload_VALUE, NetworkBaseTypes.CNETMsg_SpawnGroup_Unload.class);
        /*  12 */ EMBED.put(NetworkBaseTypes.NET_Messages.net_SpawnGroup_LoadCompleted_VALUE, NetworkBaseTypes.CNETMsg_SpawnGroup_LoadCompleted.class);

        /*  20 */ EMBED.put(S2NetMessages.CLC_Messages.clc_ClientInfo_VALUE, NetMessages.CCLCMsg_ClientInfo.class);
        /*  21 */ EMBED.put(S2NetMessages.CLC_Messages.clc_Move_VALUE, NetMessages.CCLCMsg_Move.class);
        /*  23 */ EMBED.put(S2NetMessages.CLC_Messages.clc_BaselineAck_VALUE, NetMessages.CCLCMsg_BaselineAck.class);
        /*  27 */ EMBED.put(S2NetMessages.CLC_Messages.clc_LoadingProgress_VALUE, NetMessages.CCLCMsg_LoadingProgress.class);

        /*  40 */ EMBED.put(S2NetMessages.SVC_Messages.svc_ServerInfo_VALUE, NetMessages.CSVCMsg_ServerInfo.class);
        /*  41 */ EMBED.put(S2NetMessages.SVC_Messages.svc_FlattenedSerializer_VALUE, S2NetMessages.CSVCMsg_FlattenedSerializer.class);
        /*  42 */ EMBED.put(S2NetMessages.SVC_Messages.svc_ClassInfo_VALUE, NetMessages.CSVCMsg_ClassInfo.class);
        /*  44 */ EMBED.put(S2NetMessages.SVC_Messages.svc_CreateStringTable_VALUE, S2NetMessages.CSVCMsg_CreateStringTable.class);
        /*  45 */ EMBED.put(S2NetMessages.SVC_Messages.svc_UpdateStringTable_VALUE, NetMessages.CSVCMsg_UpdateStringTable.class);
        /*  46 */ EMBED.put(S2NetMessages.SVC_Messages.svc_VoiceInit_VALUE, NetMessages.CSVCMsg_VoiceInit.class);
        /*  47 */ EMBED.put(S2NetMessages.SVC_Messages.svc_VoiceData_VALUE, S2NetMessages.CSVCMsg_VoiceData.class);
        /*  48 */ EMBED.put(S2NetMessages.SVC_Messages.svc_Print_VALUE, NetMessages.CSVCMsg_Print.class);
        /*  50 */ EMBED.put(S2NetMessages.SVC_Messages.svc_SetView_VALUE, NetMessages.CSVCMsg_SetView.class);
        /*  51 */ EMBED.put(S2NetMessages.SVC_Messages.svc_ClearAllStringTables_VALUE, S2NetMessages.CSVCMsg_ClearAllStringTables.class);
        /*  55 */ EMBED.put(S2NetMessages.SVC_Messages.svc_PacketEntities_VALUE, NetMessages.CSVCMsg_PacketEntities.class);
        /*  60 */ EMBED.put(S2NetMessages.SVC_Messages.svc_PeerList_VALUE, S2NetMessages.CSVCMsg_PeerList.class);
        /*  62 */ EMBED.put(S2NetMessages.SVC_Messages.svc_HLTVStatus_VALUE, S2NetMessages.CSVCMsg_HLTVStatus.class);
        /*  70 */ EMBED.put(S2NetMessages.SVC_Messages.svc_FullFrameSplit_VALUE, NetMessages.CSVCMsg_FullFrameSplit.class);

        /* 115 */ EMBED.put(S2UserMessages.EBaseUserMessages.UM_ResetHUD_VALUE, S2UserMessages.CUserMessageResetHUD.class);
        /* 118 */ EMBED.put(S2UserMessages.EBaseUserMessages.UM_SayText2_VALUE, S2UserMessages.CUserMessageSayText2.class);
        /* 124 */ EMBED.put(S2UserMessages.EBaseUserMessages.UM_TextMsg_VALUE, S2UserMessages.CUserMessageTextMsg.class);
        /* 128 */ EMBED.put(S2UserMessages.EBaseUserMessages.UM_VoiceMask_VALUE, S2UserMessages.CUserMessageVoiceMask.class);
        /* 130 */ EMBED.put(S2UserMessages.EBaseUserMessages.UM_SendAudio_VALUE, S2UserMessages.CUserMessageSendAudio.class);

//        /* 101 */ EMBED.put(S2UserMessages.EBaseUserMessages.UM_AchievementEvent_VALUE, S2UserMessages.CUserMessageAchievementEvent.class);
//        /* 102 */ EMBED.put(S2UserMessages.EBaseUserMessages.UM_CloseCaption_VALUE, S2UserMessages.CUserMessageCloseCaption.class);
//        /* 103 */ EMBED.put(S2UserMessages.EBaseUserMessages.UM_CloseCaptionDirect_VALUE, S2UserMessages.CUserMessageCloseCaptionDirect.class);
//        /* 104 */ EMBED.put(S2UserMessages.EBaseUserMessages.UM_CurrentTimescale_VALUE, S2UserMessages.CUserMessageCurrentTimescale.class);
//        /* 105 */ EMBED.put(S2UserMessages.EBaseUserMessages.UM_DesiredTimescale_VALUE, S2UserMessages.CUserMessageDesiredTimescale.class);
//        /* 106 */ EMBED.put(S2UserMessages.EBaseUserMessages.UM_Fade_VALUE, S2UserMessages.CUserMessageFade.class);
//        /* 107 */ EMBED.put(S2UserMessages.EBaseUserMessages.UM_GameTitle_VALUE, S2UserMessages.CUserMessageGameTitle.class);
//        /* 109 */ EMBED.put(S2UserMessages.EBaseUserMessages.UM_HintText_VALUE, S2UserMessages.CUserMessageHintText.class);
//        /* 110 */ EMBED.put(S2UserMessages.EBaseUserMessages.UM_HudMsg_VALUE, S2UserMessages.CUserMessageHudMsg.class);
//        /* 111 */ EMBED.put(S2UserMessages.EBaseUserMessages.UM_HudText_VALUE, S2UserMessages.CUserMessageHudText.class);
//        /* 112 */ EMBED.put(S2UserMessages.EBaseUserMessages.UM_KeyHintText_VALUE, S2UserMessages.CUserMessageKeyHintText.class);
//        /* 113 */ EMBED.put(S2UserMessages.EBaseUserMessages.UM_ColoredText_VALUE, S2UserMessages.CUserMessageColoredText.class);
//        /* 114 */ EMBED.put(S2UserMessages.EBaseUserMessages.UM_RequestState_VALUE, S2UserMessages.CUserMessageRequestState.class);
//        /* 116 */ EMBED.put(S2UserMessages.EBaseUserMessages.UM_Rumble_VALUE, S2UserMessages.CUserMessageRumble.class);
//        /* 117 */ EMBED.put(S2UserMessages.EBaseUserMessages.UM_SayText_VALUE, S2UserMessages.CUserMessageSayText.class);
//        /* 119 */ EMBED.put(S2UserMessages.EBaseUserMessages.UM_SayTextChannel_VALUE, S2UserMessages.CUserMessageSayTextChannel.class);
//        /* 120 */ EMBED.put(S2UserMessages.EBaseUserMessages.UM_Shake_VALUE, S2UserMessages.CUserMessageShake.class);
//        /* 121 */ EMBED.put(S2UserMessages.EBaseUserMessages.UM_ShakeDir_VALUE, S2UserMessages.CUserMessageShakeDir.class);
//        /* 125 */ EMBED.put(S2UserMessages.EBaseUserMessages.UM_ScreenTilt_VALUE, S2UserMessages.CUserMessageScreenTilt.class);
//        /* 126 */ EMBED.put(S2UserMessages.EBaseUserMessages.UM_Train_VALUE, S2UserMessages.CUserMessageTrain.class);
//        /* 127 */ EMBED.put(S2UserMessages.EBaseUserMessages.UM_VGUIMenu_VALUE, S2UserMessages.CUserMessageVGUIMenu.class);
//        /* 129 */ EMBED.put(S2UserMessages.EBaseUserMessages.UM_VoiceSubtitle_VALUE, S2UserMessages.CUserMessageVoiceSubtitle.class);
//        /* 131 */ EMBED.put(S2UserMessages.EBaseUserMessages.UM_ItemPickup_VALUE, S2UserMessages.CUserMessageItemPickup.class);
//        /* 132 */ EMBED.put(S2UserMessages.EBaseUserMessages.UM_AmmoDenied_VALUE, S2UserMessages.CUserMessageAmmoDenied.class);
//        /* 133 */ EMBED.put(S2UserMessages.EBaseUserMessages.UM_CrosshairAngle_VALUE, S2UserMessages.CUserMessageCrosshairAngle.class);
//        /* 134 */ EMBED.put(S2UserMessages.EBaseUserMessages.UM_ShowMenu_VALUE, S2UserMessages.CUserMessageShowMenu.class);
//        /* 135 */ EMBED.put(S2UserMessages.EBaseUserMessages.UM_CreditsMsg_VALUE, S2UserMessages.CUserMessageCreditsMsg.class);
//        /* 142 */ EMBED.put(S2UserMessages.EBaseUserMessages.UM_CloseCaptionPlaceholder_VALUE, S2UserMessages.CUserMessageCloseCaptionPlaceholder.class);
//        /* 143 */ EMBED.put(S2UserMessages.EBaseUserMessages.UM_CameraTransition_VALUE, S2UserMessages.CUserMessageCameraTransition.class);
//        /* 144 */ EMBED.put(S2UserMessages.EBaseUserMessages.UM_AudioParameter_VALUE, S2UserMessages.CUserMessageAudioParameter.class);
//        /* 148 */ EMBED.put(S2UserMessages.EBaseUserMessages.UM_CustomGameEvent_VALUE, null);
//        /* 149 */ EMBED.put(S2UserMessages.EBaseUserMessages.UM_HandHapticPulse_VALUE, null);

        /* 205 */ EMBED.put(S2GameEvents.EBaseGameEvents.GE_Source1LegacyGameEventList_VALUE, NetMessages.CSVCMsg_GameEventList.class);
        /* 206 */ EMBED.put(S2GameEvents.EBaseGameEvents.GE_Source1LegacyListenEvents_VALUE, S2GameEvents.CMsgSource1LegacyListenEvents.class);
        /* 207 */ EMBED.put(S2GameEvents.EBaseGameEvents.GE_Source1LegacyGameEvent_VALUE, NetworkBaseTypes.CSVCMsg_GameEvent.class);
        /* 208 */ EMBED.put(S2GameEvents.EBaseGameEvents.GE_SosStartSoundEvent_VALUE, S2GameEvents.CMsgSosStartSoundEvent.class);
        /* 209 */ EMBED.put(S2GameEvents.EBaseGameEvents.GE_SosStopSoundEvent_VALUE, S2GameEvents.CMsgSosStopSoundEvent.class);
        /* 210 */ EMBED.put(S2GameEvents.EBaseGameEvents.GE_SosSetSoundEventParams_VALUE, S2GameEvents.CMsgSosSetSoundEventParams.class);
        /* 212 */ EMBED.put(S2GameEvents.EBaseGameEvents.GE_SosStopSoundEventHash_VALUE, S2GameEvents.CMsgSosStopSoundEventHash.class);

//        /* 200 */ EMBED.put(S2GameEvents.EBaseGameEvents.GE_VDebugGameSessionIDEvent_VALUE, S2GameEvents.CMsgVDebugGameSessionIDEvent.class);
//        /* 201 */ EMBED.put(S2GameEvents.EBaseGameEvents.GE_PlaceDecalEvent_VALUE, S2GameEvents.CMsgPlaceDecalEvent.class);
//        /* 202 */ EMBED.put(S2GameEvents.EBaseGameEvents.GE_ClearWorldDecalsEvent_VALUE, S2GameEvents.CMsgClearWorldDecalsEvent.class);
//        /* 203 */ EMBED.put(S2GameEvents.EBaseGameEvents.GE_ClearEntityDecalsEvent_VALUE, S2GameEvents.CMsgClearEntityDecalsEvent.class);
//        /* 204 */ EMBED.put(S2GameEvents.EBaseGameEvents.GE_ClearDecalsForSkeletonInstanceEvent_VALUE, S2GameEvents.CMsgClearDecalsForSkeletonInstanceEvent.class);
//        /* 211 */ EMBED.put(S2GameEvents.EBaseGameEvents.GE_SosSetLibraryStackFields_VALUE, S2GameEvents.CMsgSosSetLibraryStackFields.class);

        /* 400 */ EMBED.put(S2TempEntities.ETEProtobufIds.TE_EffectDispatchId_VALUE, S2TempEntities.CMsgTEEffectDispatch.class);

        /* 466 */ EMBED.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_ChatEvent_VALUE, DotaUserMessages.CDOTAUserMsg_ChatEvent.class);
        /* 471 */ EMBED.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_CreateLinearProjectile_VALUE, DotaUserMessages.CDOTAUserMsg_CreateLinearProjectile.class);
        /* 472 */ EMBED.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_DestroyLinearProjectile_VALUE, DotaUserMessages.CDOTAUserMsg_DestroyLinearProjectile.class);
        /* 474 */ EMBED.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_GlobalLightColor_VALUE, DotaUserMessages.CDOTAUserMsg_GlobalLightColor.class);
        /* 475 */ EMBED.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_GlobalLightDirection_VALUE, DotaUserMessages.CDOTAUserMsg_GlobalLightDirection.class);
        /* 473 */ EMBED.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_DodgeTrackingProjectiles_VALUE, DotaUserMessages.CDOTAUserMsg_DodgeTrackingProjectiles.class);
        /* 477 */ EMBED.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_LocationPing_VALUE, DotaUserMessages.CDOTAUserMsg_LocationPing.class);
        /* 478 */ EMBED.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_MapLine_VALUE, DotaUserMessages.CDOTAUserMsg_MapLine.class);
        /* 479 */ EMBED.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_MiniKillCamInfo_VALUE, DotaUserMessages.CDOTAUserMsg_MiniKillCamInfo.class);
        /* 481 */ EMBED.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_MinimapEvent_VALUE, DotaUserMessages.CDOTAUserMsg_MinimapEvent.class);
        /* 482 */ EMBED.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_NevermoreRequiem_VALUE, DotaUserMessages.CDOTAUserMsg_NevermoreRequiem.class);
        /* 483 */ EMBED.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_OverheadEvent_VALUE, DotaUserMessages.CDOTAUserMsg_OverheadEvent.class);
        /* 485 */ EMBED.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_SharedCooldown_VALUE, DotaUserMessages.CDOTAUserMsg_SharedCooldown.class);
        /* 486 */ EMBED.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_SpectatorPlayerClick_VALUE, DotaUserMessages.CDOTAUserMsg_SpectatorPlayerClick.class);
        /* 488 */ EMBED.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_UnitEvent_VALUE, DotaUserMessages.CDOTAUserMsg_UnitEvent.class);
        /* 489 */ EMBED.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_ParticleManager_VALUE, DotaUserMessages.CDOTAUserMsg_ParticleManager.class);
        /* 490 */ EMBED.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_BotChat_VALUE, DotaUserMessages.CDOTAUserMsg_BotChat.class);
        /* 491 */ EMBED.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_HudError_VALUE, DotaUserMessages.CDOTAUserMsg_HudError.class);
        /* 492 */ EMBED.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_ItemPurchased_VALUE, DotaUserMessages.CDOTAUserMsg_ItemPurchased.class);
        /* 497 */ EMBED.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_WorldLine_VALUE, DotaUserMessages.CDOTAUserMsg_WorldLine.class);
        /* 501 */ EMBED.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_ChatWheel_VALUE, DotaUserMessages.CDOTAUserMsg_ChatWheel.class);
        /* 506 */ EMBED.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_GamerulesStateChanged_VALUE, DotaUserMessages.CDOTAUserMsg_GamerulesStateChanged.class);
        /* 510 */ EMBED.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_SendStatPopup_VALUE, DotaUserMessages.CDOTAUserMsg_SendStatPopup.class);
        /* 512 */ EMBED.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_SendRoshanPopup_VALUE, DotaUserMessages.CDOTAUserMsg_SendRoshanPopup.class);
        /* 518 */ EMBED.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_TE_Projectile_VALUE, DotaUserMessages.CDOTAUserMsg_TE_Projectile.class);
        /* 519 */ EMBED.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_TE_ProjectileLoc_VALUE, DotaUserMessages.CDOTAUserMsg_TE_ProjectileLoc.class);
        /* 520 */ EMBED.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_TE_DotaBloodImpact_VALUE, DotaUserMessages.CDOTAUserMsg_TE_DotaBloodImpact.class);
        /* 521 */ EMBED.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_TE_UnitAnimation_VALUE, DotaUserMessages.CDOTAUserMsg_TE_UnitAnimation.class);
        /* 522 */ EMBED.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_TE_UnitAnimationEnd_VALUE, DotaUserMessages.CDOTAUserMsg_TE_UnitAnimationEnd.class);
        /* 532 */ EMBED.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_AbilitySteal_VALUE, DotaUserMessages.CDOTAUserMsg_AbilitySteal.class);
        /* 533 */ EMBED.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_CourierKilledAlert_VALUE, DotaUserMessages.CDOTAUserMsg_CourierKilledAlert.class);
        /* 534 */ EMBED.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_EnemyItemAlert_VALUE, DotaUserMessages.CDOTAUserMsg_EnemyItemAlert.class);
        /* 542 */ EMBED.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_PredictionResult_VALUE, DotaUserMessages.CDOTAUserMsg_PredictionResult.class);
        /* 544 */ EMBED.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_HPManaAlert_VALUE, DotaUserMessages.CDOTAUserMsg_HPManaAlert.class);
        /* 547 */ EMBED.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_SpectatorPlayerUnitOrders_VALUE, DotaUserMessages.CDOTAUserMsg_SpectatorPlayerUnitOrders.class);
        /* 552 */ EMBED.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_ProjectionAbility_VALUE, DotaUserMessages.CDOTAUserMsg_ProjectionAbility.class);
        /* 553 */ EMBED.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_ProjectionEvent_VALUE, DotaUserMessages.CDOTAUserMsg_ProjectionEvent.class);
        /* 554 */ EMBED.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_CombatLogDataHLTV_VALUE, DotaUserMessages.CMsgDOTACombatLogEntry.class);
        /* 557 */ EMBED.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_MatchMetadata_VALUE, S2DotaMatchMetadata.CDOTAMatchMetadataFile.class);
        /* 558 */ EMBED.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_MatchDetails_VALUE, S2DotaGcCommon.CMsgDOTAMatch.class);
        /* 563 */ EMBED.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_SelectPenaltyGold_VALUE, DotaUserMessages.CDOTAUserMsg_SelectPenaltyGold.class);

//        /* 464 */ EMBED.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_AddUnitToSelection_VALUE, null);
//        /* 465 */ EMBED.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_AIDebugLine_VALUE, DotaUserMessages.CDOTAUserMsg_AIDebugLine.class);
//        /* 467 */ EMBED.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_CombatHeroPositions_VALUE, DotaUserMessages.CDOTAUserMsg_CombatHeroPositions.class);
//        /* 468 */ EMBED.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_CombatLogData_VALUE, null);
//        /* 470 */ EMBED.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_CombatLogShowDeath_VALUE, DotaUserMessages.CDOTAUserMsg_CombatLogShowDeath.class);
//        /* 476 */ EMBED.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_InvalidCommand_VALUE, DotaUserMessages.CDOTAUserMsg_InvalidCommand.class);
//        /* 480 */ EMBED.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_MinimapDebugPoint_VALUE, DotaUserMessages.CDOTAUserMsg_MinimapDebugPoint.class);
//        /* 484 */ EMBED.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_SetNextAutobuyItem_VALUE, DotaUserMessages.CDOTAUserMsg_SetNextAutobuyItem.class);
//        /* 487 */ EMBED.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_TutorialTipInfo_VALUE, DotaUserMessages.CDOTAUserMsg_TutorialTipInfo.class);
//        /* 493 */ EMBED.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_Ping_VALUE, DotaUserMessages.CDOTAUserMsg_Ping.class);
//        /* 494 */ EMBED.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_ItemFound_VALUE, DotaUserMessages.CDOTAUserMsg_ItemFound.class);
//        /* 495 */ EMBED.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_CharacterSpeakConcept_VALUE, null);
//        /* 496 */ EMBED.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_SwapVerify_VALUE, DotaUserMessages.CDOTAUserMsg_SwapVerify.class);
//        /* 498 */ EMBED.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_TournamentDrop_VALUE, null);
//        /* 499 */ EMBED.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_ItemAlert_VALUE, DotaUserMessages.CDOTAUserMsg_ItemAlert.class);
//        /* 500 */ EMBED.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_HalloweenDrops_VALUE, DotaUserMessages.CDOTAUserMsg_HalloweenDrops.class);
//        /* 502 */ EMBED.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_ReceivedXmasGift_VALUE, DotaUserMessages.CDOTAUserMsg_ReceivedXmasGift.class);
//        /* 503 */ EMBED.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_UpdateSharedContent_VALUE, DotaUserMessages.CDOTAUserMsg_UpdateSharedContent.class);
//        /* 504 */ EMBED.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_TutorialRequestExp_VALUE, DotaUserMessages.CDOTAUserMsg_TutorialRequestExp.class);
//        /* 505 */ EMBED.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_TutorialPingMinimap_VALUE, DotaUserMessages.CDOTAUserMsg_TutorialPingMinimap.class);
//        /* 507 */ EMBED.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_ShowSurvey_VALUE, DotaUserMessages.CDOTAUserMsg_ShowSurvey.class);
//        /* 508 */ EMBED.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_TutorialFade_VALUE, DotaUserMessages.CDOTAUserMsg_TutorialFade.class);
//        /* 509 */ EMBED.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_AddQuestLogEntry_VALUE, DotaUserMessages.CDOTAUserMsg_AddQuestLogEntry.class);
//        /* 511 */ EMBED.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_TutorialFinish_VALUE, DotaUserMessages.CDOTAUserMsg_TutorialFinish.class);
//        /* 513 */ EMBED.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_SendGenericToolTip_VALUE, DotaUserMessages.CDOTAUserMsg_SendGenericToolTip.class);
//        /* 514 */ EMBED.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_SendFinalGold_VALUE, DotaUserMessages.CDOTAUserMsg_SendFinalGold.class);
//        /* 515 */ EMBED.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_CustomMsg_VALUE, DotaUserMessages.CDOTAUserMsg_CustomMsg.class);
//        /* 516 */ EMBED.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_CoachHUDPing_VALUE, DotaUserMessages.CDOTAUserMsg_CoachHUDPing.class);
//        /* 517 */ EMBED.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_ClientLoadGridNav_VALUE, DotaUserMessages.CDOTAUserMsg_ClientLoadGridNav.class);
//        /* 523 */ EMBED.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_AbilityPing_VALUE, DotaUserMessages.CDOTAUserMsg_AbilityPing.class);
//        /* 524 */ EMBED.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_ShowGenericPopup_VALUE, DotaUserMessages.CDOTAUserMsg_ShowGenericPopup.class);
//        /* 525 */ EMBED.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_VoteStart_VALUE, DotaUserMessages.CDOTAUserMsg_VoteStart.class);
//        /* 526 */ EMBED.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_VoteUpdate_VALUE, DotaUserMessages.CDOTAUserMsg_VoteUpdate.class);
//        /* 527 */ EMBED.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_VoteEnd_VALUE, DotaUserMessages.CDOTAUserMsg_VoteEnd.class);
//        /* 528 */ EMBED.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_BoosterState_VALUE, DotaUserMessages.CDOTAUserMsg_BoosterState.class);
//        /* 529 */ EMBED.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_WillPurchaseAlert_VALUE, DotaUserMessages.CDOTAUserMsg_WillPurchaseAlert.class);
//        /* 530 */ EMBED.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_TutorialMinimapPosition_VALUE, DotaUserMessages.CDOTAUserMsg_TutorialMinimapPosition.class);
//        /* 531 */ EMBED.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_PlayerMMR_VALUE, DotaUserMessages.CDOTAUserMsg_PlayerMMR.class);
//        /* 535 */ EMBED.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_StatsMatchDetails_VALUE, DotaUserMessages.CDOTAUserMsg_StatsMatchDetails.class);
//        /* 536 */ EMBED.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_MiniTaunt_VALUE, DotaUserMessages.CDOTAUserMsg_MiniTaunt.class);
//        /* 537 */ EMBED.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_BuyBackStateAlert_VALUE, DotaUserMessages.CDOTAUserMsg_BuyBackStateAlert.class);
//        /* 538 */ EMBED.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_SpeechBubble_VALUE, DotaUserMessages.CDOTAUserMsg_SpeechBubble.class);
//        /* 539 */ EMBED.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_CustomHeaderMessage_VALUE, DotaUserMessages.CDOTAUserMsg_CustomHeaderMessage.class);
//        /* 540 */ EMBED.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_QuickBuyAlert_VALUE, DotaUserMessages.CDOTAUserMsg_QuickBuyAlert.class);
//        /* 541 */ EMBED.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_StatsHeroDetails_VALUE, DotaUserMessages.CDOTAUserMsg_StatsHeroMinuteDetails.class);
//        /* 543 */ EMBED.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_ModifierAlert_VALUE, DotaUserMessages.CDOTAUserMsg_ModifierAlert.class);
//        /* 545 */ EMBED.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_GlyphAlert_VALUE, DotaUserMessages.CDOTAUserMsg_GlyphAlert.class);
//        /* 546 */ EMBED.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_BeastChat_VALUE, DotaUserMessages.CDOTAUserMsg_BeastChat.class);
//        /* 548 */ EMBED.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_CustomHudElement_Create_VALUE, DotaUserMessages.CDOTAUserMsg_CustomHudElement_Create.class);
//        /* 549 */ EMBED.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_CustomHudElement_Modify_VALUE, DotaUserMessages.CDOTAUserMsg_CustomHudElement_Modify.class);
//        /* 550 */ EMBED.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_CustomHudElement_Destroy_VALUE, DotaUserMessages.CDOTAUserMsg_CustomHudElement_Destroy.class);
//        /* 551 */ EMBED.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_CompendiumState_VALUE, DotaUserMessages.CDOTAUserMsg_CompendiumState.class);
//        /* 555 */ EMBED.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_XPAlert_VALUE, DotaUserMessages.CDOTAUserMsg_XPAlert.class);
//        /* 556 */ EMBED.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_UpdateQuestProgress_VALUE, DotaUserMessages.CDOTAUserMsg_UpdateQuestProgress.class);
//        /* 559 */ EMBED.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_QuestStatus_VALUE, DotaUserMessages.CDOTAUserMsg_QuestStatus.class);
//        /* 560 */ EMBED.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_SuggestHeroPick_VALUE, DotaUserMessages.CDOTAUserMsg_SuggestHeroPick.class);
//        /* 561 */ EMBED.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_SuggestHeroRole_VALUE, DotaUserMessages.CDOTAUserMsg_SuggestHeroRole.class);
//        /* 562 */ EMBED.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_KillcamDamageTaken_VALUE, DotaUserMessages.CDOTAUserMsg_KillcamDamageTaken.class);
//        /* 564 */ EMBED.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_RollDiceResult_VALUE, DotaUserMessages.CDOTAUserMsg_RollDiceResult.class);
//        /* 565 */ EMBED.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_FlipCoinResult_VALUE, DotaUserMessages.CDOTAUserMsg_FlipCoinResult.class);
//        /* 566 */ EMBED.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_RequestItemSuggestions_VALUE, DotaUserMessages.CDOTAUserMessage_RequestItemSuggestions.class);
//        /* 567 */ EMBED.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_TeamCaptainChanged_VALUE, DotaUserMessages.CDOTAUserMessage_TeamCaptainChanged.class);



        REVERSE = new HashMap<>();
        for (Map.Entry<Integer, Class<? extends GeneratedMessage>> e : EMBED.entrySet()) {
            REVERSE.put(e.getValue(), e.getKey());
        }

    }

    public static Class<? extends GeneratedMessage> classForKind(int kind) {
        return EMBED.get(kind);
    }

    public static Integer kindForClass(Class<? extends GeneratedMessage> clazz) {
        return REVERSE.get(clazz);
    }

}
