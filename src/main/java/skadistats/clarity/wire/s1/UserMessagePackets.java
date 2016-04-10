package skadistats.clarity.wire.s1;

import com.google.protobuf.GeneratedMessage;
import skadistats.clarity.wire.common.proto.DotaUserMessages;
import skadistats.clarity.wire.s1.proto.S1DotaUserMessages;
import skadistats.clarity.wire.s1.proto.S1UserMessages;

import java.util.HashMap;
import java.util.Map;

public class UserMessagePackets {

    private static final Map<Integer, Class<? extends GeneratedMessage>> USERMSG;
    static {
        USERMSG = new HashMap<>();

        /* 15 */ USERMSG.put(S1UserMessages.EBaseUserMessages.UM_ResetHUD_VALUE, S1UserMessages.CUserMsg_ResetHUD.class);
        /* 18 */ USERMSG.put(S1UserMessages.EBaseUserMessages.UM_SayText2_VALUE, S1UserMessages.CUserMsg_SayText2.class);
        /* 24 */ USERMSG.put(S1UserMessages.EBaseUserMessages.UM_TextMsg_VALUE, S1UserMessages.CUserMsg_TextMsg.class);
        /* 27 */ USERMSG.put(S1UserMessages.EBaseUserMessages.UM_VGUIMenu_VALUE, S1UserMessages.CUserMsg_VGUIMenu.class);
        /* 28 */ USERMSG.put(S1UserMessages.EBaseUserMessages.UM_VoiceMask_VALUE, S1UserMessages.CUserMsg_VoiceMask.class);
        /* 30 */ USERMSG.put(S1UserMessages.EBaseUserMessages.UM_SendAudio_VALUE, S1UserMessages.CUserMsg_SendAudio.class);
        
//        /*  1 */ USERMSG.put(S1UserMessages.EBaseUserMessages.UM_AchievementEvent_VALUE, S1UserMessages.CUserMsg_AchievementEvent.class);
//        /*  2 */ USERMSG.put(S1UserMessages.EBaseUserMessages.UM_CloseCaption_VALUE, S1UserMessages.CUserMsg_CloseCaption.class);
//        /*  3 */ USERMSG.put(S1UserMessages.EBaseUserMessages.UM_CloseCaptionDirect_VALUE, S1UserMessages.CUserMsg_CloseCaption.class);
//        /*  4 */ USERMSG.put(S1UserMessages.EBaseUserMessages.UM_CurrentTimescale_VALUE, S1UserMessages.CUserMsg_CurrentTimescale.class);
//        /*  5 */ USERMSG.put(S1UserMessages.EBaseUserMessages.UM_DesiredTimescale_VALUE, S1UserMessages.CUserMsg_DesiredTimescale.class);
//        /*  6 */ USERMSG.put(S1UserMessages.EBaseUserMessages.UM_Fade_VALUE, S1UserMessages.CUserMsg_Fade.class);
//        /*  7 */ USERMSG.put(S1UserMessages.EBaseUserMessages.UM_GameTitle_VALUE, S1UserMessages.CUserMsg_GameTitle.class);
//        /*  8 */ USERMSG.put(S1UserMessages.EBaseUserMessages.UM_Geiger_VALUE, S1UserMessages.CUserMsg_Geiger.class);
//        /*  9 */ USERMSG.put(S1UserMessages.EBaseUserMessages.UM_HintText_VALUE, S1UserMessages.CUserMsg_HintText.class);
//        /* 10 */ USERMSG.put(S1UserMessages.EBaseUserMessages.UM_HudMsg_VALUE, S1UserMessages.CUserMsg_HudMsg.class);
//        /* 11 */ USERMSG.put(S1UserMessages.EBaseUserMessages.UM_HudText_VALUE, S1UserMessages.CUserMsg_HudText.class);
//        /* 12 */ USERMSG.put(S1UserMessages.EBaseUserMessages.UM_KeyHintText_VALUE, S1UserMessages.CUserMsg_KeyHintText.class);
//        /* 13 */ USERMSG.put(S1UserMessages.EBaseUserMessages.UM_MessageText_VALUE, S1UserMessages.CUserMsg_MessageText.class);
//        /* 14 */ USERMSG.put(S1UserMessages.EBaseUserMessages.UM_RequestState_VALUE, S1UserMessages.CUserMsg_RequestState.class);
//        /* 16 */ USERMSG.put(S1UserMessages.EBaseUserMessages.UM_Rumble_VALUE, S1UserMessages.CUserMsg_Rumble.class);
//        /* 17 */ USERMSG.put(S1UserMessages.EBaseUserMessages.UM_SayText_VALUE, S1UserMessages.CUserMsg_SayText.class);
//        /* 19 */ USERMSG.put(S1UserMessages.EBaseUserMessages.UM_SayTextChannel_VALUE, S1UserMessages.CUserMsg_SayTextChannel.class);
//        /* 20 */ USERMSG.put(S1UserMessages.EBaseUserMessages.UM_Shake_VALUE, S1UserMessages.CUserMsg_Shake.class);
//        /* 21 */ USERMSG.put(S1UserMessages.EBaseUserMessages.UM_ShakeDir_VALUE, S1UserMessages.CUserMsg_ShakeDir.class);
//        /* 22 */ USERMSG.put(S1UserMessages.EBaseUserMessages.UM_StatsCrawlMsg_VALUE, S1UserMessages.CUserMsg_StatsCrawlMsg.class);
//        /* 23 */ USERMSG.put(S1UserMessages.EBaseUserMessages.UM_StatsSkipState_VALUE, S1UserMessages.CUserMsg_StatsSkipState.class);
//        /* 25 */ USERMSG.put(S1UserMessages.EBaseUserMessages.UM_Tilt_VALUE, S1UserMessages.CUserMsg_Tilt.class);
//        /* 26 */ USERMSG.put(S1UserMessages.EBaseUserMessages.UM_Train_VALUE, S1UserMessages.CUserMsg_Train.class);
//        /* 29 */ USERMSG.put(S1UserMessages.EBaseUserMessages.UM_VoiceSubtitle_VALUE, S1UserMessages.CUserMsg_VoiceSubtitle.class);
//        /* 31 */ USERMSG.put(S1UserMessages.EBaseUserMessages.UM_CameraTransition_VALUE, S1UserMessages.CUserMsg_CameraTransition.class);

        /*  66 */ USERMSG.put(S1DotaUserMessages.EDotaUserMessages.DOTA_UM_ChatEvent_VALUE, DotaUserMessages.CDOTAUserMsg_ChatEvent.class);
        /*  71 */ USERMSG.put(S1DotaUserMessages.EDotaUserMessages.DOTA_UM_CreateLinearProjectile_VALUE, DotaUserMessages.CDOTAUserMsg_CreateLinearProjectile.class);
        /*  72 */ USERMSG.put(S1DotaUserMessages.EDotaUserMessages.DOTA_UM_DestroyLinearProjectile_VALUE, DotaUserMessages.CDOTAUserMsg_DestroyLinearProjectile.class);
        /*  73 */ USERMSG.put(S1DotaUserMessages.EDotaUserMessages.DOTA_UM_DodgeTrackingProjectiles_VALUE, DotaUserMessages.CDOTAUserMsg_DodgeTrackingProjectiles.class);
        /*  74 */ USERMSG.put(S1DotaUserMessages.EDotaUserMessages.DOTA_UM_GlobalLightColor_VALUE, DotaUserMessages.CDOTAUserMsg_GlobalLightColor.class);
        /*  75 */ USERMSG.put(S1DotaUserMessages.EDotaUserMessages.DOTA_UM_GlobalLightDirection_VALUE, DotaUserMessages.CDOTAUserMsg_GlobalLightDirection.class);
        /*  77 */ USERMSG.put(S1DotaUserMessages.EDotaUserMessages.DOTA_UM_LocationPing_VALUE, DotaUserMessages.CDOTAUserMsg_LocationPing.class);
        /*  78 */ USERMSG.put(S1DotaUserMessages.EDotaUserMessages.DOTA_UM_MapLine_VALUE, DotaUserMessages.CDOTAUserMsg_MapLine.class);
        /*  81 */ USERMSG.put(S1DotaUserMessages.EDotaUserMessages.DOTA_UM_MinimapEvent_VALUE, DotaUserMessages.CDOTAUserMsg_MinimapEvent.class);
        /*  82 */ USERMSG.put(S1DotaUserMessages.EDotaUserMessages.DOTA_UM_NevermoreRequiem_VALUE, DotaUserMessages.CDOTAUserMsg_NevermoreRequiem.class);
        /*  83 */ USERMSG.put(S1DotaUserMessages.EDotaUserMessages.DOTA_UM_OverheadEvent_VALUE, DotaUserMessages.CDOTAUserMsg_OverheadEvent.class);
        /*  85 */ USERMSG.put(S1DotaUserMessages.EDotaUserMessages.DOTA_UM_SharedCooldown_VALUE, DotaUserMessages.CDOTAUserMsg_SharedCooldown.class);
        /*  86 */ USERMSG.put(S1DotaUserMessages.EDotaUserMessages.DOTA_UM_SpectatorPlayerClick_VALUE, DotaUserMessages.CDOTAUserMsg_SpectatorPlayerClick.class);
        /*  88 */ USERMSG.put(S1DotaUserMessages.EDotaUserMessages.DOTA_UM_UnitEvent_VALUE, DotaUserMessages.CDOTAUserMsg_UnitEvent.class);
        /*  89 */ USERMSG.put(S1DotaUserMessages.EDotaUserMessages.DOTA_UM_ParticleManager_VALUE, DotaUserMessages.CDOTAUserMsg_ParticleManager.class);
        /*  90 */ USERMSG.put(S1DotaUserMessages.EDotaUserMessages.DOTA_UM_BotChat_VALUE, DotaUserMessages.CDOTAUserMsg_BotChat.class);
        /*  91 */ USERMSG.put(S1DotaUserMessages.EDotaUserMessages.DOTA_UM_HudError_VALUE, DotaUserMessages.CDOTAUserMsg_HudError.class);
        /*  97 */ USERMSG.put(S1DotaUserMessages.EDotaUserMessages.DOTA_UM_WorldLine_VALUE, DotaUserMessages.CDOTAUserMsg_WorldLine.class);
        /* 100 */ USERMSG.put(S1DotaUserMessages.EDotaUserMessages.DOTA_UM_HalloweenDrops_VALUE, DotaUserMessages.CDOTAUserMsg_HalloweenDrops.class);
        /* 101 */ USERMSG.put(S1DotaUserMessages.EDotaUserMessages.DOTA_UM_ChatWheel_VALUE, DotaUserMessages.CDOTAUserMsg_ChatWheel.class);
        /* 106 */ USERMSG.put(S1DotaUserMessages.EDotaUserMessages.DOTA_UM_GamerulesStateChanged_VALUE, DotaUserMessages.CDOTAUserMsg_GamerulesStateChanged.class);
        /* 110 */ USERMSG.put(S1DotaUserMessages.EDotaUserMessages.DOTA_UM_SendStatPopup_VALUE, DotaUserMessages.CDOTAUserMsg_SendStatPopup.class);
        /* 112 */ USERMSG.put(S1DotaUserMessages.EDotaUserMessages.DOTA_UM_SendRoshanPopup_VALUE, DotaUserMessages.CDOTAUserMsg_SendRoshanPopup.class);
        /* 127 */ USERMSG.put(S1DotaUserMessages.EDotaUserMessages.DOTA_UM_AbilitySteal_VALUE, DotaUserMessages.CDOTAUserMsg_AbilitySteal.class);
        /* 128 */ USERMSG.put(S1DotaUserMessages.EDotaUserMessages.DOTA_UM_CourierKilledAlert_VALUE, DotaUserMessages.CDOTAUserMsg_CourierKilledAlert.class);
        /* 129 */ USERMSG.put(S1DotaUserMessages.EDotaUserMessages.DOTA_UM_EnemyItemAlert_VALUE, DotaUserMessages.CDOTAUserMsg_EnemyItemAlert.class);
        /* 135 */ USERMSG.put(S1DotaUserMessages.EDotaUserMessages.DOTA_UM_PredictionResult_VALUE, DotaUserMessages.CDOTAUserMsg_PredictionResult.class);
        /* 140 */ USERMSG.put(S1DotaUserMessages.EDotaUserMessages.DOTA_UM_SpectatorPlayerUnitOrders_VALUE, DotaUserMessages.CDOTAUserMsg_SpectatorPlayerUnitOrders.class);
        /* 142 */ USERMSG.put(S1DotaUserMessages.EDotaUserMessages.DOTA_UM_ProjectionAbility_VALUE, DotaUserMessages.CDOTAUserMsg_ProjectionAbility.class);
        /* 143 */ USERMSG.put(S1DotaUserMessages.EDotaUserMessages.DOTA_UM_ProjectionEvent_VALUE, DotaUserMessages.CDOTAUserMsg_ProjectionEvent.class);

//        /*  64 */ USERMSG.put(S1DotaUserMessages.EDotaUserMessages.DOTA_UM_AddUnitToSelection_VALUE, DotaUserMessages.CDOTAUserMsg_AddUnitToSelection.class);
//        /*  65 */ USERMSG.put(S1DotaUserMessages.EDotaUserMessages.DOTA_UM_AIDebugLine_VALUE, DotaUserMessages.CDOTAUserMsg_AIDebugLine.class);
//        /*  67 */ USERMSG.put(S1DotaUserMessages.EDotaUserMessages.DOTA_UM_CombatHeroPositions_VALUE, DotaUserMessages.CDOTAUserMsg_CombatHeroPositions.class);
//        /*  68 */ USERMSG.put(S1DotaUserMessages.EDotaUserMessages.DOTA_UM_CombatLogData_VALUE, DotaUserMessages.CDOTAUserMsg_CombatLogData.class);
//        /*  70 */ USERMSG.put(S1DotaUserMessages.EDotaUserMessages.DOTA_UM_CombatLogShowDeath_VALUE, DotaUserMessages.CDOTAUserMsg_CombatLogShowDeath.class);
//        /*  74 */ USERMSG.put(S1DotaUserMessages.EDotaUserMessages.DOTA_UM_GlobalLightColor_VALUE, DotaUserMessages.CDOTAUserMsg_GlobalLightColor.class);
//        /*  75 */ USERMSG.put(S1DotaUserMessages.EDotaUserMessages.DOTA_UM_GlobalLightDirection_VALUE, DotaUserMessages.CDOTAUserMsg_GlobalLightDirection.class);
//        /*  76 */ USERMSG.put(S1DotaUserMessages.EDotaUserMessages.DOTA_UM_InvalidCommand_VALUE, DotaUserMessages.CDOTAUserMsg_InvalidCommand.class);
//        /*  79 */ USERMSG.put(S1DotaUserMessages.EDotaUserMessages.DOTA_UM_MiniKillCamInfo_VALUE, DotaUserMessages.CDOTAUserMsg_MiniKillCamInfo.class);
//        /*  80 */ USERMSG.put(S1DotaUserMessages.EDotaUserMessages.DOTA_UM_MinimapDebugPoint_VALUE, DotaUserMessages.CDOTAUserMsg_MinimapDebugPoint.class);
//        /*  84 */ USERMSG.put(S1DotaUserMessages.EDotaUserMessages.DOTA_UM_SetNextAutobuyItem_VALUE, DotaUserMessages.CDOTAUserMsg_SetNextAutobuyItem.class);
//        /*  85 */ USERMSG.put(S1DotaUserMessages.EDotaUserMessages.DOTA_UM_SharedCooldown_VALUE, DotaUserMessages.CDOTAUserMsg_SharedCooldown.class);
//        /*  86 */ USERMSG.put(S1DotaUserMessages.EDotaUserMessages.DOTA_UM_SpectatorPlayerClick_VALUE, DotaUserMessages.CDOTAUserMsg_SpectatorPlayerClick.class);
//        /*  87 */ USERMSG.put(S1DotaUserMessages.EDotaUserMessages.DOTA_UM_TutorialTipInfo_VALUE, DotaUserMessages.CDOTAUserMsg_TutorialTipInfo.class);
//        /*  92 */ USERMSG.put(S1DotaUserMessages.EDotaUserMessages.DOTA_UM_ItemPurchased_VALUE, DotaUserMessages.CDOTAUserMsg_ItemPurchased.class);
//        /*  93 */ USERMSG.put(S1DotaUserMessages.EDotaUserMessages.DOTA_UM_Ping_VALUE, DotaUserMessages.CDOTAUserMsg_Ping.class);
//        /*  94 */ USERMSG.put(S1DotaUserMessages.EDotaUserMessages.DOTA_UM_ItemFound_VALUE, DotaUserMessages.CDOTAUserMsg_ItemFound.class);
//        /*  95 */ USERMSG.put(S1DotaUserMessages.EDotaUserMessages.DOTA_UM_CharacterSpeakConcept_VALUE, DotaUserMessages.CDOTAUserMsg_CharacterSpeakConcept.class);
//        /*  96 */ USERMSG.put(S1DotaUserMessages.EDotaUserMessages.DOTA_UM_SwapVerify_VALUE, DotaUserMessages.CDOTAUserMsg_SwapVerify.class);
//        /*  98 */ USERMSG.put(S1DotaUserMessages.EDotaUserMessages.DOTA_UM_TournamentDrop_VALUE, DotaUserMessages.CDOTAUserMsg_TournamentDrop.class);
//        /*  99 */ USERMSG.put(S1DotaUserMessages.EDotaUserMessages.DOTA_UM_ItemAlert_VALUE, DotaUserMessages.CDOTAUserMsg_ItemAlert.class);
//        /* 102 */ USERMSG.put(S1DotaUserMessages.EDotaUserMessages.DOTA_UM_ReceivedXmasGift_VALUE, DotaUserMessages.CDOTAUserMsg_ReceivedXmasGift.class);
//        /* 103 */ USERMSG.put(S1DotaUserMessages.EDotaUserMessages.DOTA_UM_UpdateSharedContent_VALUE, DotaUserMessages.CDOTAUserMsg_UpdateSharedContent.class);
//        /* 104 */ USERMSG.put(S1DotaUserMessages.EDotaUserMessages.DOTA_UM_TutorialRequestExp_VALUE, DotaUserMessages.CDOTAUserMsg_TutorialRequestExp.class);
//        /* 105 */ USERMSG.put(S1DotaUserMessages.EDotaUserMessages.DOTA_UM_TutorialPingMinimap_VALUE, DotaUserMessages.CDOTAUserMsg_TutorialPingMinimap.class);
//        /* 107 */ USERMSG.put(S1DotaUserMessages.EDotaUserMessages.DOTA_UM_ShowSurvey_VALUE, DotaUserMessages.CDOTAUserMsg_ShowSurvey.class);
//        /* 108 */ USERMSG.put(S1DotaUserMessages.EDotaUserMessages.DOTA_UM_TutorialFade_VALUE, DotaUserMessages.CDOTAUserMsg_TutorialFade.class);
//        /* 109 */ USERMSG.put(S1DotaUserMessages.EDotaUserMessages.DOTA_UM_AddQuestLogEntry_VALUE, DotaUserMessages.CDOTAUserMsg_AddQuestLogEntry.class);
//        /* 111 */ USERMSG.put(S1DotaUserMessages.EDotaUserMessages.DOTA_UM_TutorialFinish_VALUE, DotaUserMessages.CDOTAUserMsg_TutorialFinish.class);
//        /* 113 */ USERMSG.put(S1DotaUserMessages.EDotaUserMessages.DOTA_UM_SendGenericToolTip_VALUE, DotaUserMessages.CDOTAUserMsg_SendGenericToolTip.class);
//        /* 114 */ USERMSG.put(S1DotaUserMessages.EDotaUserMessages.DOTA_UM_SendFinalGold_VALUE, DotaUserMessages.CDOTAUserMsg_SendFinalGold.class);
//        /* 115 */ USERMSG.put(S1DotaUserMessages.EDotaUserMessages.DOTA_UM_CustomMsg_VALUE, DotaUserMessages.CDOTAUserMsg_CustomMsg.class);
//        /* 116 */ USERMSG.put(S1DotaUserMessages.EDotaUserMessages.DOTA_UM_CoachHUDPing_VALUE, DotaUserMessages.CDOTAUserMsg_CoachHUDPing.class);
//        /* 117 */ USERMSG.put(S1DotaUserMessages.EDotaUserMessages.DOTA_UM_ClientLoadGridNav_VALUE, DotaUserMessages.CDOTAUserMsg_ClientLoadGridNav.class);
//        /* 118 */ USERMSG.put(S1DotaUserMessages.EDotaUserMessages.DOTA_UM_AbilityPing_VALUE, DotaUserMessages.CDOTAUserMsg_AbilityPing.class);
//        /* 119 */ USERMSG.put(S1DotaUserMessages.EDotaUserMessages.DOTA_UM_ShowGenericPopup_VALUE, DotaUserMessages.CDOTAUserMsg_ShowGenericPopup.class);
//        /* 120 */ USERMSG.put(S1DotaUserMessages.EDotaUserMessages.DOTA_UM_VoteStart_VALUE, DotaUserMessages.CDOTAUserMsg_VoteStart.class);
//        /* 121 */ USERMSG.put(S1DotaUserMessages.EDotaUserMessages.DOTA_UM_VoteUpdate_VALUE, DotaUserMessages.CDOTAUserMsg_VoteUpdate.class);
//        /* 122 */ USERMSG.put(S1DotaUserMessages.EDotaUserMessages.DOTA_UM_VoteEnd_VALUE, DotaUserMessages.CDOTAUserMsg_VoteEnd.class);
//        /* 123 */ USERMSG.put(S1DotaUserMessages.EDotaUserMessages.DOTA_UM_BoosterState_VALUE, DotaUserMessages.CDOTAUserMsg_BoosterState.class);
//        /* 124 */ USERMSG.put(S1DotaUserMessages.EDotaUserMessages.DOTA_UM_WillPurchaseAlert_VALUE, DotaUserMessages.CDOTAUserMsg_WillPurchaseAlert.class);
//        /* 125 */ USERMSG.put(S1DotaUserMessages.EDotaUserMessages.DOTA_UM_TutorialMinimapPosition_VALUE, DotaUserMessages.CDOTAUserMsg_TutorialMinimapPosition.class);
//        /* 126 */ USERMSG.put(S1DotaUserMessages.EDotaUserMessages.DOTA_UM_PlayerMMR_VALUE, DotaUserMessages.CDOTAUserMsg_PlayerMMR.class);
//        /* 129 */ USERMSG.put(S1DotaUserMessages.EDotaUserMessages.DOTA_UM_EnemyItemAlert_VALUE, DotaUserMessages.CDOTAUserMsg_EnemyItemAlert.class);
//        /* 130 */ USERMSG.put(S1DotaUserMessages.EDotaUserMessages.DOTA_UM_StatsMatchDetails_VALUE, DotaUserMessages.CDOTAUserMsg_StatsMatchDetails.class);
//        /* 131 */ USERMSG.put(S1DotaUserMessages.EDotaUserMessages.DOTA_UM_MiniTaunt_VALUE, DotaUserMessages.CDOTAUserMsg_MiniTaunt.class);
//        /* 132 */ USERMSG.put(S1DotaUserMessages.EDotaUserMessages.DOTA_UM_BuyBackStateAlert_VALUE, DotaUserMessages.CDOTAUserMsg_BuyBackStateAlert.class);
//        /* 133 */ USERMSG.put(S1DotaUserMessages.EDotaUserMessages.DOTA_UM_QuickBuyAlert_VALUE, DotaUserMessages.CDOTAUserMsg_QuickBuyAlert.class);
//        /* 134 */ USERMSG.put(S1DotaUserMessages.EDotaUserMessages.DOTA_UM_StatsHeroDetails_VALUE, DotaUserMessages.CDOTAUserMsg_StatsHeroDetails.class);
//        /* 136 */ USERMSG.put(S1DotaUserMessages.EDotaUserMessages.DOTA_UM_ModifierAlert_VALUE, DotaUserMessages.CDOTAUserMsg_ModifierAlert.class);
//        /* 137 */ USERMSG.put(S1DotaUserMessages.EDotaUserMessages.DOTA_UM_HPManaAlert_VALUE, DotaUserMessages.CDOTAUserMsg_HPManaAlert.class);
//        /* 138 */ USERMSG.put(S1DotaUserMessages.EDotaUserMessages.DOTA_UM_GlyphAlert_VALUE, DotaUserMessages.CDOTAUserMsg_GlyphAlert.class);
//        /* 139 */ USERMSG.put(S1DotaUserMessages.EDotaUserMessages.DOTA_UM_BeastChat_VALUE, DotaUserMessages.CDOTAUserMsg_BeastChat.class);
//        /* 141 */ USERMSG.put(S1DotaUserMessages.EDotaUserMessages.DOTA_UM_CompendiumState_VALUE, DotaUserMessages.CDOTAUserMsg_CompendiumState.class);

    }

    public static boolean isKnownClass(Class<? extends GeneratedMessage> clazz) {
        return USERMSG.containsValue(clazz);
    }

    public static Class<? extends GeneratedMessage> classForKind(int kind) {
        return USERMSG.get(kind);
    }

}
