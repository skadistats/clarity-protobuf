package skadistats.clarity.wire.s2;

import com.google.protobuf.GeneratedMessage;
import skadistats.clarity.wire.ClassToKindMessageRegistry;
import skadistats.clarity.wire.KindToClassMessageRegistry;
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
        /* 115 */ K2C.put(S2UserMessages.EBaseUserMessages.UM_ResetHUD_VALUE, S2UserMessages.CUserMessageResetHUD.class);
        /* 118 */ K2C.put(S2UserMessages.EBaseUserMessages.UM_SayText2_VALUE, S2UserMessages.CUserMessageSayText2.class);
        /* 124 */ K2C.put(S2UserMessages.EBaseUserMessages.UM_TextMsg_VALUE, S2UserMessages.CUserMessageTextMsg.class);
        /* 128 */ K2C.put(S2UserMessages.EBaseUserMessages.UM_VoiceMask_VALUE, S2UserMessages.CUserMessageVoiceMask.class);
        /* 130 */ K2C.put(S2UserMessages.EBaseUserMessages.UM_SendAudio_VALUE, S2UserMessages.CUserMessageSendAudio.class);
        /* 144 */ K2C.put(S2UserMessages.EBaseUserMessages.UM_AudioParameter_VALUE, S2UserMessages.CUserMessageAudioParameter.class);
        /* 145 */ K2C.put(S2UserMessages.EBaseUserMessages.UM_ParticleManager_VALUE, DotaUserMessages.CDOTAUserMsg_ParticleManager.class);

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
//        /* 114 */ K2C.put(S2UserMessages.EBaseUserMessages.UM_RequestState_VALUE, S2UserMessages.CUserMessageRequestState.class);
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
//        /* 142 */ K2C.put(S2UserMessages.EBaseUserMessages.UM_CloseCaptionPlaceholder_VALUE, S2UserMessages.CUserMessageCloseCaptionPlaceholder.class);
//        /* 143 */ K2C.put(S2UserMessages.EBaseUserMessages.UM_CameraTransition_VALUE, S2UserMessages.CUserMessageCameraTransition.class);
//        /* 148 */ K2C.put(S2UserMessages.EBaseUserMessages.UM_CustomGameEvent_VALUE, null);
//        /* 149 */ K2C.put(S2UserMessages.EBaseUserMessages.UM_HandHapticPulse_VALUE, null);

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

        /* 466 */ K2C.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_ChatEvent_VALUE, DotaUserMessages.CDOTAUserMsg_ChatEvent.class);
        /* 470 */ K2C.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_CombatLogBulkData_VALUE, DotaUserMessages.CDOTAUserMsg_CombatLogBulkData.class);
        /* 471 */ K2C.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_CreateLinearProjectile_VALUE, DotaUserMessages.CDOTAUserMsg_CreateLinearProjectile.class);
        /* 472 */ K2C.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_DestroyLinearProjectile_VALUE, DotaUserMessages.CDOTAUserMsg_DestroyLinearProjectile.class);
        /* 474 */ K2C.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_GlobalLightColor_VALUE, DotaUserMessages.CDOTAUserMsg_GlobalLightColor.class);
        /* 475 */ K2C.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_GlobalLightDirection_VALUE, DotaUserMessages.CDOTAUserMsg_GlobalLightDirection.class);
        /* 473 */ K2C.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_DodgeTrackingProjectiles_VALUE, DotaUserMessages.CDOTAUserMsg_DodgeTrackingProjectiles.class);
        /* 477 */ K2C.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_LocationPing_VALUE, DotaUserMessages.CDOTAUserMsg_LocationPing.class);
        /* 478 */ K2C.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_MapLine_VALUE, DotaUserMessages.CDOTAUserMsg_MapLine.class);
        /* 479 */ K2C.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_MiniKillCamInfo_VALUE, DotaUserMessages.CDOTAUserMsg_MiniKillCamInfo.class);
        /* 481 */ K2C.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_MinimapEvent_VALUE, DotaUserMessages.CDOTAUserMsg_MinimapEvent.class);
        /* 482 */ K2C.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_NevermoreRequiem_VALUE, DotaUserMessages.CDOTAUserMsg_NevermoreRequiem.class);
        /* 483 */ K2C.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_OverheadEvent_VALUE, DotaUserMessages.CDOTAUserMsg_OverheadEvent.class);
        /* 485 */ K2C.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_SharedCooldown_VALUE, DotaUserMessages.CDOTAUserMsg_SharedCooldown.class);
        /* 486 */ K2C.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_SpectatorPlayerClick_VALUE, DotaUserMessages.CDOTAUserMsg_SpectatorPlayerClick.class);
        /* 488 */ K2C.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_UnitEvent_VALUE, DotaUserMessages.CDOTAUserMsg_UnitEvent.class);
        /* 489 */ K2C.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_ParticleManager_VALUE, DotaUserMessages.CDOTAUserMsg_ParticleManager.class);
        /* 490 */ K2C.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_BotChat_VALUE, DotaUserMessages.CDOTAUserMsg_BotChat.class);
        /* 491 */ K2C.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_HudError_VALUE, DotaUserMessages.CDOTAUserMsg_HudError.class);
        /* 492 */ K2C.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_ItemPurchased_VALUE, DotaUserMessages.CDOTAUserMsg_ItemPurchased.class);
        /* 497 */ K2C.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_WorldLine_VALUE, DotaUserMessages.CDOTAUserMsg_WorldLine.class);
        /* 501 */ K2C.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_ChatWheel_VALUE, DotaUserMessages.CDOTAUserMsg_ChatWheel.class);
        /* 506 */ K2C.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_GamerulesStateChanged_VALUE, DotaUserMessages.CDOTAUserMsg_GamerulesStateChanged.class);
        /* 510 */ K2C.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_SendStatPopup_VALUE, DotaUserMessages.CDOTAUserMsg_SendStatPopup.class);
        /* 512 */ K2C.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_SendRoshanPopup_VALUE, DotaUserMessages.CDOTAUserMsg_SendRoshanPopup.class);
        /* 518 */ K2C.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_TE_Projectile_VALUE, DotaUserMessages.CDOTAUserMsg_TE_Projectile.class);
        /* 519 */ K2C.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_TE_ProjectileLoc_VALUE, DotaUserMessages.CDOTAUserMsg_TE_ProjectileLoc.class);
        /* 520 */ K2C.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_TE_DotaBloodImpact_VALUE, DotaUserMessages.CDOTAUserMsg_TE_DotaBloodImpact.class);
        /* 521 */ K2C.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_TE_UnitAnimation_VALUE, DotaUserMessages.CDOTAUserMsg_TE_UnitAnimation.class);
        /* 522 */ K2C.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_TE_UnitAnimationEnd_VALUE, DotaUserMessages.CDOTAUserMsg_TE_UnitAnimationEnd.class);
        /* 523 */ K2C.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_AbilityPing_VALUE, DotaUserMessages.CDOTAUserMsg_AbilityPing.class);
        /* 529 */ K2C.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_WillPurchaseAlert_VALUE, DotaUserMessages.CDOTAUserMsg_WillPurchaseAlert.class);
        /* 532 */ K2C.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_AbilitySteal_VALUE, DotaUserMessages.CDOTAUserMsg_AbilitySteal.class);
        /* 533 */ K2C.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_CourierKilledAlert_VALUE, DotaUserMessages.CDOTAUserMsg_CourierKilledAlert.class);
        /* 534 */ K2C.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_EnemyItemAlert_VALUE, DotaUserMessages.CDOTAUserMsg_EnemyItemAlert.class);
        /* 540 */ K2C.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_QuickBuyAlert_VALUE, DotaUserMessages.CDOTAUserMsg_QuickBuyAlert.class);
        /* 542 */ K2C.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_PredictionResult_VALUE, DotaUserMessages.CDOTAUserMsg_PredictionResult.class);
        /* 543 */ K2C.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_ModifierAlert_VALUE, DotaUserMessages.CDOTAUserMsg_ModifierAlert.class);
        /* 544 */ K2C.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_HPManaAlert_VALUE, DotaUserMessages.CDOTAUserMsg_HPManaAlert.class);
        /* 547 */ K2C.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_SpectatorPlayerUnitOrders_VALUE, DotaUserMessages.CDOTAUserMsg_SpectatorPlayerUnitOrders.class);
        /* 552 */ K2C.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_ProjectionAbility_VALUE, DotaUserMessages.CDOTAUserMsg_ProjectionAbility.class);
        /* 553 */ K2C.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_ProjectionEvent_VALUE, DotaUserMessages.CDOTAUserMsg_ProjectionEvent.class);
        /* 554 */ K2C.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_CombatLogDataHLTV_VALUE, DotaUserMessages.CMsgDOTACombatLogEntry.class);
        /* 555 */ K2C.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_XPAlert_VALUE, DotaUserMessages.CDOTAUserMsg_XPAlert.class);
        /* 556 */ K2C.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_UpdateQuestProgress_VALUE, DotaUserMessages.CDOTAUserMsg_UpdateQuestProgress.class);
        /* 557 */ K2C.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_MatchMetadata_VALUE, S2DotaMatchMetadata.CDOTAMatchMetadataFile.class);
        /* 558 */ K2C.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_MatchDetails_VALUE, S2DotaGcCommon.CMsgDOTAMatch.class);
        /* 563 */ K2C.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_SelectPenaltyGold_VALUE, DotaUserMessages.CDOTAUserMsg_SelectPenaltyGold.class);
        /* 564 */ K2C.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_RollDiceResult_VALUE, DotaUserMessages.CDOTAUserMsg_RollDiceResult.class);
        /* 565 */ K2C.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_FlipCoinResult_VALUE, DotaUserMessages.CDOTAUserMsg_FlipCoinResult.class);
        /* 567 */ K2C.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_TeamCaptainChanged_VALUE, DotaUserMessages.CDOTAUserMessage_TeamCaptainChanged.class);
        /* 568 */ K2C.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_SendRoshanSpectatorPhase_VALUE, DotaUserMessages.CDOTAUserMsg_SendRoshanSpectatorPhase.class);
        /* 571 */ K2C.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_TE_DestroyProjectile_VALUE, DotaUserMessages.CDOTAUserMsg_TE_DestroyProjectile.class);
        /* 572 */ K2C.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_HeroRelicProgress_VALUE, DotaUserMessages.CDOTAUserMsg_HeroRelicProgress.class);
        /* 574 */ K2C.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_ItemSold_VALUE, DotaUserMessages.CDOTAUserMsg_ItemSold.class);
        /* 575 */ K2C.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_DamageReport_VALUE, DotaUserMessages.CDOTAUserMsg_DamageReport.class);
        /* 576 */ K2C.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_SalutePlayer_VALUE, DotaUserMessages.CDOTAUserMsg_SalutePlayer.class);
        /* 577 */ K2C.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_TipAlert_VALUE, DotaUserMessages.CDOTAUserMsg_TipAlert.class);
        /* 579 */ K2C.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_EmptyTeleportAlert_VALUE, DotaUserMessages.CDOTAUserMsg_EmptyTeleportAlert.class);
        /* 580 */ K2C.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_MarsArenaOfBloodAttack_VALUE, DotaUserMessages.CDOTAUserMsg_MarsArenaOfBloodAttack.class);
        /* 581 */ K2C.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_ESArcanaCombo_VALUE, DotaUserMessages.CDOTAUserMsg_ESArcanaCombo.class);
        /* 582 */ K2C.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_ESArcanaComboSummary_VALUE, DotaUserMessages.CDOTAUserMsg_ESArcanaComboSummary.class);
        /* 583 */ K2C.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_HighFiveLeftHanging_VALUE, DotaUserMessages.CDOTAUserMsg_HighFiveLeftHanging.class);
        /* 584 */ K2C.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_HighFiveCompleted_VALUE, DotaUserMessages.CDOTAUserMsg_HighFiveCompleted.class);
        /* 585 */ K2C.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_ShovelUnearth_VALUE, DotaUserMessages.CDOTAUserMsg_ShovelUnearth.class);
        /* 586 */ K2C.put(S2DotaUserMessages.EDotaUserMessages.DOTA_EM_InvokerSpellCast_VALUE, DotaUserMessages.CDOTAEntityMsg_InvokerSpellCast.class);
        /* 587 */ K2C.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_RadarAlert_VALUE, DotaUserMessages.CDOTAUserMsg_RadarAlert.class);
        /* 588 */ K2C.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_AllStarEvent_VALUE, DotaUserMessages.CDOTAUserMsg_AllStarEvent.class);
        /* 589 */ K2C.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_TalentTreeAlert_VALUE, DotaUserMessages.CDOTAUserMsg_TalentTreeAlert.class);
        /* 590 */ K2C.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_QueuedOrderRemoved_VALUE, DotaUserMessages.CDOTAUserMsg_QueuedOrderRemoved.class);
        /* 591 */ K2C.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_DebugChallenge_VALUE, DotaUserMessages.CDOTAUserMsg_DebugChallenge.class);
        /* 592 */ K2C.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_OMArcanaCombo_VALUE, DotaUserMessages.CDOTAUserMsg_OMArcanaCombo.class);
        /* 593 */ K2C.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_FoundNeutralItem_VALUE, DotaUserMessages.CDOTAUserMsg_FoundNeutralItem.class);
        /* 594 */ K2C.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_OutpostCaptured_VALUE, DotaUserMessages.CDOTAUserMsg_OutpostCaptured.class);
        /* 595 */ K2C.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_OutpostGrantedXP_VALUE, DotaUserMessages.CDOTAUserMsg_OutpostGrantedXP.class);
        /* 596 */ K2C.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_MoveCameraToUnit_VALUE, DotaUserMessages.CDOTAUserMsg_MoveCameraToUnit.class);
        /* 597 */ K2C.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_PauseMinigameData_VALUE, DotaUserMessages.CDOTAUserMsg_PauseMinigameData.class);
        /* 598 */ K2C.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_VersusScene_PlayerBehavior_VALUE, DotaUserMessages.CDOTAUserMsg_VersusScene_PlayerBehavior.class);
        /* 600 */ K2C.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_QoP_ArcanaSummary_VALUE, DotaUserMessages.CDOTAUserMsg_QoP_ArcanaSummary.class);
        /* 601 */ K2C.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_HotPotato_Created_VALUE, DotaUserMessages.CDOTAUserMsg_HotPotato_Created.class);
        /* 602 */ K2C.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_HotPotato_Exploded_VALUE, DotaUserMessages.CDOTAUserMsg_HotPotato_Exploded.class);
        /* 603 */ K2C.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_WK_Arcana_Progress_VALUE, DotaUserMessages.CDOTAUserMsg_WK_Arcana_Progress.class);
        /* 604 */ K2C.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_GuildChallenge_Progress_VALUE, DotaUserMessages.CDOTAUserMsg_GuildChallenge_Progress.class);
        /* 605 */ K2C.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_WRArcanaProgress_VALUE, DotaUserMessages.CDOTAUserMsg_WRArcanaProgress.class);
        /* 606 */ K2C.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_WRArcanaSummary_VALUE, DotaUserMessages.CDOTAUserMsg_WRArcanaSummary.class);
        /* 605 */ K2C.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_WRArcanaProgress_VALUE, DotaUserMessages.CDOTAUserMsg_WRArcanaProgress.class);
        /* 606 */ K2C.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_WRArcanaSummary_VALUE, DotaUserMessages.CDOTAUserMsg_WRArcanaSummary.class);
        /* 612 */ K2C.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_ChatMessage_VALUE, DotaUserMessages.CDOTAUserMsg_ChatMessage.class);

//        /* 464 */ K2C.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_AddUnitToSelection_VALUE, null);
//        /* 465 */ K2C.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_AIDebugLine_VALUE, DotaUserMessages.CDOTAUserMsg_AIDebugLine.class);
//        /* 467 */ K2C.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_CombatHeroPositions_VALUE, DotaUserMessages.CDOTAUserMsg_CombatHeroPositions.class);
//        /* 468 */ K2C.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_CombatLogData_VALUE, null);
//        /* 476 */ K2C.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_InvalidCommand_VALUE, DotaUserMessages.CDOTAUserMsg_InvalidCommand.class);
//        /* 480 */ K2C.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_MinimapDebugPoint_VALUE, DotaUserMessages.CDOTAUserMsg_MinimapDebugPoint.class);
//        /* 484 */ K2C.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_SetNextAutobuyItem_VALUE, DotaUserMessages.CDOTAUserMsg_SetNextAutobuyItem.class);
//        /* 487 */ K2C.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_TutorialTipInfo_VALUE, DotaUserMessages.CDOTAUserMsg_TutorialTipInfo.class);
//        /* 493 */ K2C.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_Ping_VALUE, DotaUserMessages.CDOTAUserMsg_Ping.class);
//        /* 494 */ K2C.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_ItemFound_VALUE, DotaUserMessages.CDOTAUserMsg_ItemFound.class);
//        /* 495 */ K2C.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_CharacterSpeakConcept_VALUE, null);
//        /* 496 */ K2C.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_SwapVerify_VALUE, DotaUserMessages.CDOTAUserMsg_SwapVerify.class);
//        /* 498 */ K2C.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_TournamentDrop_VALUE, null);
//        /* 499 */ K2C.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_ItemAlert_VALUE, DotaUserMessages.CDOTAUserMsg_ItemAlert.class);
//        /* 500 */ K2C.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_HalloweenDrops_VALUE, DotaUserMessages.CDOTAUserMsg_HalloweenDrops.class);
//        /* 502 */ K2C.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_ReceivedXmasGift_VALUE, DotaUserMessages.CDOTAUserMsg_ReceivedXmasGift.class);
//        /* 503 */ K2C.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_UpdateSharedContent_VALUE, DotaUserMessages.CDOTAUserMsg_UpdateSharedContent.class);
//        /* 504 */ K2C.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_TutorialRequestExp_VALUE, DotaUserMessages.CDOTAUserMsg_TutorialRequestExp.class);
//        /* 505 */ K2C.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_TutorialPingMinimap_VALUE, DotaUserMessages.CDOTAUserMsg_TutorialPingMinimap.class);
//        /* 507 */ K2C.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_ShowSurvey_VALUE, DotaUserMessages.CDOTAUserMsg_ShowSurvey.class);
//        /* 508 */ K2C.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_TutorialFade_VALUE, DotaUserMessages.CDOTAUserMsg_TutorialFade.class);
//        /* 509 */ K2C.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_AddQuestLogEntry_VALUE, DotaUserMessages.CDOTAUserMsg_AddQuestLogEntry.class);
//        /* 511 */ K2C.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_TutorialFinish_VALUE, DotaUserMessages.CDOTAUserMsg_TutorialFinish.class);
//        /* 513 */ K2C.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_SendGenericToolTip_VALUE, DotaUserMessages.CDOTAUserMsg_SendGenericToolTip.class);
//        /* 514 */ K2C.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_SendFinalGold_VALUE, DotaUserMessages.CDOTAUserMsg_SendFinalGold.class);
//        /* 515 */ K2C.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_CustomMsg_VALUE, DotaUserMessages.CDOTAUserMsg_CustomMsg.class);
//        /* 516 */ K2C.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_CoachHUDPing_VALUE, DotaUserMessages.CDOTAUserMsg_CoachHUDPing.class);
//        /* 517 */ K2C.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_ClientLoadGridNav_VALUE, DotaUserMessages.CDOTAUserMsg_ClientLoadGridNav.class);
//        /* 524 */ K2C.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_ShowGenericPopup_VALUE, DotaUserMessages.CDOTAUserMsg_ShowGenericPopup.class);
//        /* 525 */ K2C.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_VoteStart_VALUE, DotaUserMessages.CDOTAUserMsg_VoteStart.class);
//        /* 526 */ K2C.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_VoteUpdate_VALUE, DotaUserMessages.CDOTAUserMsg_VoteUpdate.class);
//        /* 527 */ K2C.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_VoteEnd_VALUE, DotaUserMessages.CDOTAUserMsg_VoteEnd.class);
//        /* 528 */ K2C.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_BoosterState_VALUE, DotaUserMessages.CDOTAUserMsg_BoosterState.class);
//        /* 530 */ K2C.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_TutorialMinimapPosition_VALUE, DotaUserMessages.CDOTAUserMsg_TutorialMinimapPosition.class);
//        /* 531 */ K2C.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_PlayerMMR_VALUE, DotaUserMessages.CDOTAUserMsg_PlayerMMR.class);
//        /* 535 */ K2C.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_StatsMatchDetails_VALUE, DotaUserMessages.CDOTAUserMsg_StatsMatchDetails.class);
//        /* 536 */ K2C.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_MiniTaunt_VALUE, DotaUserMessages.CDOTAUserMsg_MiniTaunt.class);
//        /* 537 */ K2C.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_BuyBackStateAlert_VALUE, DotaUserMessages.CDOTAUserMsg_BuyBackStateAlert.class);
//        /* 538 */ K2C.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_SpeechBubble_VALUE, DotaUserMessages.CDOTAUserMsg_SpeechBubble.class);
//        /* 539 */ K2C.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_CustomHeaderMessage_VALUE, DotaUserMessages.CDOTAUserMsg_CustomHeaderMessage.class);
//        /* 541 */ K2C.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_StatsHeroDetails_VALUE, DotaUserMessages.CDOTAUserMsg_StatsHeroMinuteDetails.class);
//        /* 545 */ K2C.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_GlyphAlert_VALUE, DotaUserMessages.CDOTAUserMsg_GlyphAlert.class);
//        /* 546 */ K2C.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_BeastChat_VALUE, DotaUserMessages.CDOTAUserMsg_BeastChat.class);
//        /* 548 */ K2C.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_CustomHudElement_Create_VALUE, DotaUserMessages.CDOTAUserMsg_CustomHudElement_Create.class);
//        /* 549 */ K2C.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_CustomHudElement_Modify_VALUE, DotaUserMessages.CDOTAUserMsg_CustomHudElement_Modify.class);
//        /* 550 */ K2C.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_CustomHudElement_Destroy_VALUE, DotaUserMessages.CDOTAUserMsg_CustomHudElement_Destroy.class);
//        /* 551 */ K2C.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_CompendiumState_VALUE, DotaUserMessages.CDOTAUserMsg_CompendiumState.class);
//        /* 559 */ K2C.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_QuestStatus_VALUE, DotaUserMessages.CDOTAUserMsg_QuestStatus.class);
//        /* 560 */ K2C.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_SuggestHeroPick_VALUE, DotaUserMessages.CDOTAUserMsg_SuggestHeroPick.class);
//        /* 561 */ K2C.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_SuggestHeroRole_VALUE, DotaUserMessages.CDOTAUserMsg_SuggestHeroRole.class);
//        /* 562 */ K2C.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_KillcamDamageTaken_VALUE, DotaUserMessages.CDOTAUserMsg_KillcamDamageTaken.class);
//        /* 566 */ K2C.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_RequestItemSuggestions_VALUE, DotaUserMessages.CDOTAUserMessage_RequestItemSuggestions.class);
//        /* 569 */ K2C.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_ChatWheelCooldown_VALUE, DotaUserMessages.CDOTAUserMessage_ChatWheelCooldown.class);
//        /* 570 */ K2C.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_DismissAllStatPopups_VALUE, DotaUserMessages.CDOTAUserMessage_DismissAllStatPopups.class);
//        /* 573 */ K2C.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_AbilityDraftRequestAbility_VALUE, DotaUserMessages.CDOTAUserMessage_AbilityDraftRequestAbility.class);
//        /* 578 */ K2C.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_ReplaceQueryUnit_VALUE, DotaUserMessages.CDOTAUserMsg_ReplaceQueryUnit.class);
//        /* 579 */ K2C.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_EmptyTeleportAlert_VALUE, DotaUserMessages.CDOTAUserMsg_EmptyTeleportAlert.class);
//        /* 607 */ K2C.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_EmptyItemSlotAlert_VALUE, DotaUserMessages.CDOTAUserMsg_EmptyItemSlotAlert.class);
//        /* 608 */ K2C.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_AghsStatusAlert_VALUE, DotaUserMessages.CDOTAUserMsg_AghsStatusAlert.class);
//        /* 609 */ K2C.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_PingConfirmation_VALUE, DotaUserMessages.CDOTAUserMsg_PingConfirmation.class);
//        /* 610 */ K2C.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_MutedPlayers_VALUE, DotaUserMessages.CDOTAUserMsg_MutedPlayers.class);
//        /* 611 */ K2C.put(S2DotaUserMessages.EDotaUserMessages.DOTA_UM_ContextualTip_VALUE, DotaUserMessages.CDOTAUserMsg_ContextualTip.class);
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
