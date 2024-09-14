package skadistats.clarity.wire.deadlock.proto;

import com.google.protobuf.GeneratedMessage;
import skadistats.clarity.wire.ClassToKindMessageRegistry;
import skadistats.clarity.wire.KindToClassMessageRegistry;
import skadistats.clarity.wire.shared.common.proto.CommonNetMessages;
import skadistats.clarity.wire.shared.common.proto.CommonNetworkBaseTypes;
import skadistats.clarity.wire.shared.demo.proto.DemoNetMessages;
import skadistats.clarity.wire.shared.demo.proto.DemoUserMessages;
import skadistats.clarity.wire.shared.s2.proto.S2GameEvents;
import skadistats.clarity.wire.shared.s2.proto.S2NetMessages;
import skadistats.clarity.wire.shared.s2.proto.S2NetworkBaseTypes;
import skadistats.clarity.wire.shared.s2.proto.S2TempEntities;
import skadistats.clarity.wire.shared.s2.proto.S2UserMessages;

public class EmbeddedPackets {

    private static final KindToClassMessageRegistry K2C;

    static {
        K2C = new KindToClassMessageRegistry(100);

        /*   0 */ K2C.put(DeadlockMessageId.NET_Messages.net_NOP_VALUE, CommonNetworkBaseTypes.CNETMsg_NOP.class);
        /*   1 */ K2C.put(DeadlockMessageId.NET_Messages.net_Disconnect_VALUE, CommonNetworkBaseTypes.CNETMsg_Disconnect.class);
        /*   4 */ K2C.put(DeadlockMessageId.NET_Messages.net_Tick_VALUE, CommonNetworkBaseTypes.CNETMsg_Tick.class);
        /*   5 */ K2C.put(DeadlockMessageId.NET_Messages.net_StringCmd_VALUE, CommonNetworkBaseTypes.CNETMsg_StringCmd.class);
        /*   6 */ K2C.put(DeadlockMessageId.NET_Messages.net_SetConVar_VALUE, CommonNetworkBaseTypes.CNETMsg_SetConVar.class);
        /*   7 */ K2C.put(DeadlockMessageId.NET_Messages.net_SignonState_VALUE, CommonNetworkBaseTypes.CNETMsg_SignonState.class);
        /*   8 */ K2C.put(DeadlockMessageId.NET_Messages.net_SpawnGroup_Load_VALUE, S2NetworkBaseTypes.CNETMsg_SpawnGroup_Load.class);
        /*   9 */ K2C.put(DeadlockMessageId.NET_Messages.net_SpawnGroup_ManifestUpdate_VALUE, S2NetworkBaseTypes.CNETMsg_SpawnGroup_ManifestUpdate.class);
        /*  11 */ K2C.put(DeadlockMessageId.NET_Messages.net_SpawnGroup_SetCreationTick_VALUE, S2NetworkBaseTypes.CNETMsg_SpawnGroup_SetCreationTick.class);
        /*  12 */ K2C.put(DeadlockMessageId.NET_Messages.net_SpawnGroup_Unload_VALUE, S2NetworkBaseTypes.CNETMsg_SpawnGroup_Unload.class);
        /*  13 */ K2C.put(DeadlockMessageId.NET_Messages.net_SpawnGroup_LoadCompleted_VALUE, S2NetworkBaseTypes.CNETMsg_SpawnGroup_LoadCompleted.class);

        /*  40 */ K2C.put(DeadlockMessageId.SVC_Messages.svc_ServerInfo_VALUE, DemoNetMessages.CSVCMsg_ServerInfo.class);
        /*  41 */ K2C.put(DeadlockMessageId.SVC_Messages.svc_FlattenedSerializer_VALUE, S2NetMessages.CSVCMsg_FlattenedSerializer.class);
        /*  42 */ K2C.put(DeadlockMessageId.SVC_Messages.svc_ClassInfo_VALUE, CommonNetMessages.CSVCMsg_ClassInfo.class);
        /*  44 */ K2C.put(DeadlockMessageId.SVC_Messages.svc_CreateStringTable_VALUE, S2NetMessages.CSVCMsg_CreateStringTable.class);
        /*  45 */ K2C.put(DeadlockMessageId.SVC_Messages.svc_UpdateStringTable_VALUE, CommonNetMessages.CSVCMsg_UpdateStringTable.class);
        /*  46 */ K2C.put(DeadlockMessageId.SVC_Messages.svc_VoiceInit_VALUE, CommonNetMessages.CSVCMsg_VoiceInit.class);
        /*  47 */ K2C.put(DeadlockMessageId.SVC_Messages.svc_VoiceData_VALUE, S2NetMessages.CSVCMsg_VoiceData.class);
        /*  48 */ K2C.put(DeadlockMessageId.SVC_Messages.svc_Print_VALUE, CommonNetMessages.CSVCMsg_Print.class);
        /*  50 */ K2C.put(DeadlockMessageId.SVC_Messages.svc_SetView_VALUE, CommonNetMessages.CSVCMsg_SetView.class);
        /*  51 */ K2C.put(DeadlockMessageId.SVC_Messages.svc_ClearAllStringTables_VALUE, S2NetMessages.CSVCMsg_ClearAllStringTables.class);
        /*  55 */ K2C.put(DeadlockMessageId.SVC_Messages.svc_PacketEntities_VALUE, CommonNetMessages.CSVCMsg_PacketEntities.class);
        /*  60 */ K2C.put(DeadlockMessageId.SVC_Messages.svc_PeerList_VALUE, S2NetMessages.CSVCMsg_PeerList.class);
        /*  62 */ K2C.put(DeadlockMessageId.SVC_Messages.svc_HLTVStatus_VALUE, S2NetMessages.CSVCMsg_HLTVStatus.class);
        /*  70 */ K2C.put(DeadlockMessageId.SVC_Messages.svc_FullFrameSplit_VALUE, CommonNetMessages.CSVCMsg_FullFrameSplit.class);
        /*  76 */ K2C.put(DeadlockMessageId.SVC_Messages.svc_UserCmds_VALUE, CommonNetMessages.CSVCMsg_UserCommands.class);

        /* 101 */ K2C.put(DeadlockMessageId.EBaseUserMessages.UM_AchievementEvent_VALUE, S2UserMessages.CUserMessageAchievementEvent.class);
        /* 102 */ K2C.put(DeadlockMessageId.EBaseUserMessages.UM_CloseCaption_VALUE, S2UserMessages.CUserMessageCloseCaption.class);
        /* 103 */ K2C.put(DeadlockMessageId.EBaseUserMessages.UM_CloseCaptionDirect_VALUE, S2UserMessages.CUserMessageCloseCaptionDirect.class);
        /* 104 */ K2C.put(DeadlockMessageId.EBaseUserMessages.UM_CurrentTimescale_VALUE, S2UserMessages.CUserMessageCurrentTimescale.class);
        /* 105 */ K2C.put(DeadlockMessageId.EBaseUserMessages.UM_DesiredTimescale_VALUE, S2UserMessages.CUserMessageDesiredTimescale.class);
        /* 106 */ K2C.put(DeadlockMessageId.EBaseUserMessages.UM_Fade_VALUE, S2UserMessages.CUserMessageFade.class);
        /* 107 */ K2C.put(DeadlockMessageId.EBaseUserMessages.UM_GameTitle_VALUE, S2UserMessages.CUserMessageGameTitle.class);
        /* 110 */ K2C.put(DeadlockMessageId.EBaseUserMessages.UM_HudMsg_VALUE, S2UserMessages.CUserMessageHudMsg.class);
        /* 111 */ K2C.put(DeadlockMessageId.EBaseUserMessages.UM_HudText_VALUE, S2UserMessages.CUserMessageHudText.class);
        /* 113 */ K2C.put(DeadlockMessageId.EBaseUserMessages.UM_ColoredText_VALUE, S2UserMessages.CUserMessageColoredText.class);
        /* 115 */ K2C.put(DeadlockMessageId.EBaseUserMessages.UM_ResetHUD_VALUE, S2UserMessages.CUserMessageResetHUD.class);
        /* 116 */ K2C.put(DeadlockMessageId.EBaseUserMessages.UM_Rumble_VALUE, S2UserMessages.CUserMessageRumble.class);
        /* 117 */ K2C.put(DeadlockMessageId.EBaseUserMessages.UM_SayText_VALUE, S2UserMessages.CUserMessageSayText.class);
        /* 118 */ K2C.put(DeadlockMessageId.EBaseUserMessages.UM_SayText2_VALUE, S2UserMessages.CUserMessageSayText2.class);
        /* 119 */ K2C.put(DeadlockMessageId.EBaseUserMessages.UM_SayTextChannel_VALUE, S2UserMessages.CUserMessageSayTextChannel.class);
        /* 120 */ K2C.put(DeadlockMessageId.EBaseUserMessages.UM_Shake_VALUE, S2UserMessages.CUserMessageShake.class);
        /* 121 */ K2C.put(DeadlockMessageId.EBaseUserMessages.UM_ShakeDir_VALUE, S2UserMessages.CUserMessageShakeDir.class);
        /* 124 */ K2C.put(DeadlockMessageId.EBaseUserMessages.UM_TextMsg_VALUE, S2UserMessages.CUserMessageTextMsg.class);
        /* 125 */ K2C.put(DeadlockMessageId.EBaseUserMessages.UM_ScreenTilt_VALUE, S2UserMessages.CUserMessageScreenTilt.class);
        /* 128 */ K2C.put(DeadlockMessageId.EBaseUserMessages.UM_VoiceMask_VALUE, S2UserMessages.CUserMessageVoiceMask.class);
        /* 130 */ K2C.put(DeadlockMessageId.EBaseUserMessages.UM_SendAudio_VALUE, S2UserMessages.CUserMessageSendAudio.class);
        /* 131 */ K2C.put(DeadlockMessageId.EBaseUserMessages.UM_ItemPickup_VALUE, S2UserMessages.CUserMessageItemPickup.class);
        /* 132 */ K2C.put(DeadlockMessageId.EBaseUserMessages.UM_AmmoDenied_VALUE, S2UserMessages.CUserMessageAmmoDenied.class);
        /* 134 */ K2C.put(DeadlockMessageId.EBaseUserMessages.UM_ShowMenu_VALUE, S2UserMessages.CUserMessageShowMenu.class);
        /* 135 */ K2C.put(DeadlockMessageId.EBaseUserMessages.UM_CreditsMsg_VALUE, S2UserMessages.CUserMessageCreditsMsg.class);

        /* 138 */ K2C.put(DeadlockMessageId.EBaseEntityMessages.EM_RemoveAllDecals_VALUE, S2UserMessages.CEntityMessageRemoveAllDecals.class);

        /* 142 */ K2C.put(DeadlockMessageId.EBaseUserMessages.UM_CloseCaptionPlaceholder_VALUE, S2UserMessages.CUserMessageCloseCaptionPlaceholder.class);
        /* 143 */ K2C.put(DeadlockMessageId.EBaseUserMessages.UM_CameraTransition_VALUE, S2UserMessages.CUserMessageCameraTransition.class);
        /* 144 */ K2C.put(DeadlockMessageId.EBaseUserMessages.UM_AudioParameter_VALUE, S2UserMessages.CUserMessageAudioParameter.class);
        /* 145 */ K2C.put(DeadlockMessageId.EBaseUserMessages.UM_ParticleManager_VALUE, DemoUserMessages.CUserMsg_ParticleManager.class);
        /* 146 */ K2C.put(DeadlockMessageId.EBaseUserMessages.UM_HudError_VALUE, S2UserMessages.CUserMsg_HudError.class);
        /* 148 */ K2C.put(DeadlockMessageId.EBaseUserMessages.UM_CustomGameEvent_VALUE, S2UserMessages.CUserMsg_CustomGameEvent.class);
        /* 149 */ K2C.put(DeadlockMessageId.EBaseUserMessages.UM_AnimGraphUpdate_VALUE, S2UserMessages.CUserMessageAnimStateGraphState.class);
        /* 150 */ K2C.put(DeadlockMessageId.EBaseUserMessages.UM_HapticsManagerPulse_VALUE, S2UserMessages.CUserMessageHapticsManagerPulse.class);
        /* 151 */ K2C.put(DeadlockMessageId.EBaseUserMessages.UM_HapticsManagerEffect_VALUE, S2UserMessages.CUserMessageHapticsManagerEffect.class);
        /* 152 */ K2C.put(DeadlockMessageId.EBaseUserMessages.UM_CommandQueueState_VALUE, S2UserMessages.CUserMessageCommandQueueState.class);
        /* 153 */ K2C.put(DeadlockMessageId.EBaseUserMessages.UM_UpdateCssClasses_VALUE, S2UserMessages.CUserMessageUpdateCssClasses.class);
        /* 155 */ K2C.put(DeadlockMessageId.EBaseUserMessages.UM_LagCompensationError_VALUE, S2UserMessages.CUserMessageLagCompensationError.class);
        /* 156 */ K2C.put(DeadlockMessageId.EBaseUserMessages.UM_RequestDllStatus_VALUE, S2UserMessages.CUserMessageRequestDllStatus.class);
        /* 157 */ K2C.put(DeadlockMessageId.EBaseUserMessages.UM_RequestUtilAction_VALUE, S2UserMessages.CUserMessageRequestUtilAction.class);
        /* 166 */ K2C.put(DeadlockMessageId.EBaseUserMessages.UM_PlayResponseConditional_VALUE, S2UserMessages.CUserMessage_PlayResponseConditional.class);

        /* 205 */ K2C.put(S2GameEvents.EBaseGameEvents.GE_Source1LegacyGameEventList_VALUE, CommonNetMessages.CSVCMsg_GameEventList.class);
        /* 206 */ K2C.put(S2GameEvents.EBaseGameEvents.GE_Source1LegacyListenEvents_VALUE, S2GameEvents.CMsgSource1LegacyListenEvents.class);
        /* 207 */ K2C.put(S2GameEvents.EBaseGameEvents.GE_Source1LegacyGameEvent_VALUE, CommonNetworkBaseTypes.CSVCMsg_GameEvent.class);
        /* 208 */ K2C.put(S2GameEvents.EBaseGameEvents.GE_SosStartSoundEvent_VALUE, S2GameEvents.CMsgSosStartSoundEvent.class);
        /* 209 */ K2C.put(S2GameEvents.EBaseGameEvents.GE_SosStopSoundEvent_VALUE, S2GameEvents.CMsgSosStopSoundEvent.class);
        /* 210 */ K2C.put(S2GameEvents.EBaseGameEvents.GE_SosSetSoundEventParams_VALUE, S2GameEvents.CMsgSosSetSoundEventParams.class);
        /* 212 */ K2C.put(S2GameEvents.EBaseGameEvents.GE_SosStopSoundEventHash_VALUE, S2GameEvents.CMsgSosStopSoundEventHash.class);

        /* 300 */ K2C.put(DeadlockMessageId.CitadelUserMessageIds.k_EUserMsg_Damage_VALUE, CitadelUserMessages.CCitadelUserMessage_Damage.class);
        /* 303 */ K2C.put(DeadlockMessageId.CitadelUserMessageIds.k_EUserMsg_MapPing_VALUE, CitadelUserMessages.CCitadelUserMsg_MapPing.class);
        /* 304 */ K2C.put(DeadlockMessageId.CitadelUserMessageIds.k_EUserMsg_TeamRewards_VALUE, null);
        /* 306 */ K2C.put(DeadlockMessageId.CitadelUserMessageIds.k_EUserMsg_AbilityFailed_VALUE, null);
        /* 308 */ K2C.put(DeadlockMessageId.CitadelUserMessageIds.k_EUserMsg_TriggerDamageFlash_VALUE, CitadelUserMessages.CCitadelUserMsg_TriggerDamageFlash.class);
        /* 309 */ K2C.put(DeadlockMessageId.CitadelUserMessageIds.k_EUserMsg_AbilitiesChanged_VALUE, null);
        /* 310 */ K2C.put(DeadlockMessageId.CitadelUserMessageIds.k_EUserMsg_RecentDamageSummary_VALUE, null);
        /* 311 */ K2C.put(DeadlockMessageId.CitadelUserMessageIds.k_EUserMsg_SpectatorTeamChanged_VALUE, null);
        /* 312 */ K2C.put(DeadlockMessageId.CitadelUserMessageIds.k_EUserMsg_ChatWheel_VALUE, CitadelUserMessages.CCitadelUserMsg_ChatWheel.class);
        /* 313 */ K2C.put(DeadlockMessageId.CitadelUserMessageIds.k_EUserMsg_GoldHistory_VALUE, null);
        /* 314 */ K2C.put(DeadlockMessageId.CitadelUserMessageIds.k_EUserMsg_ChatMsg_VALUE, CitadelUserMessages.CCitadelUserMsg_ChatMsg.class);
        /* 315 */ K2C.put(DeadlockMessageId.CitadelUserMessageIds.k_EUserMsg_QuickResponse_VALUE, null);
        /* 316 */ K2C.put(DeadlockMessageId.CitadelUserMessageIds.k_EUserMsg_PostMatchDetails_VALUE, CitadelUserMessages.CCitadelUserMsg_PostMatchDetails.class);
        /* 317 */ K2C.put(DeadlockMessageId.CitadelUserMessageIds.k_EUserMsg_ChatEvent_VALUE, CitadelUserMessages.CCitadelUserMsg_ChatEvent.class);
        /* 318 */ K2C.put(DeadlockMessageId.CitadelUserMessageIds.k_EUserMsg_AbilityInterrupted_VALUE, null);
        /* 319 */ K2C.put(DeadlockMessageId.CitadelUserMessageIds.k_EUserMsg_HeroKilled_VALUE, CitadelUserMessages.CCitadelUserMsg_HeroKilled.class);
        /* 320 */ K2C.put(DeadlockMessageId.CitadelUserMessageIds.k_EUserMsg_ReturnIdol_VALUE, null);
        /* 321 */ K2C.put(DeadlockMessageId.CitadelUserMessageIds.k_EUserMsg_SetClientCameraAngles_VALUE, null);
        /* 322 */ K2C.put(DeadlockMessageId.CitadelUserMessageIds.k_EUserMsg_MapLine_VALUE, null);
        /* 323 */ K2C.put(DeadlockMessageId.CitadelUserMessageIds.k_EUserMsg_BulletHit_VALUE, null);
        /* 324 */ K2C.put(DeadlockMessageId.CitadelUserMessageIds.k_EUserMsg_ObjectiveMask_VALUE, null);
        /* 325 */ K2C.put(DeadlockMessageId.CitadelUserMessageIds.k_EUserMsg_ModifierApplied_VALUE, null);
        /* 326 */ K2C.put(DeadlockMessageId.CitadelUserMessageIds.k_EUserMsg_CameraController_VALUE, null);
        /* 327 */ K2C.put(DeadlockMessageId.CitadelUserMessageIds.k_EUserMsg_AuraModifierApplied_VALUE, null);
        /* 329 */ K2C.put(DeadlockMessageId.CitadelUserMessageIds.k_EUserMsg_ObstructedShotFired_VALUE, null);
        /* 330 */ K2C.put(DeadlockMessageId.CitadelUserMessageIds.k_EUserMsg_AbilityLateFailure_VALUE, null);
        /* 331 */ K2C.put(DeadlockMessageId.CitadelUserMessageIds.k_EUserMsg_AbilityPing_VALUE, null);
        /* 332 */ K2C.put(DeadlockMessageId.CitadelUserMessageIds.k_EUserMsg_PostProcessingAnim_VALUE, CitadelUserMessages.CCitadelUserMsg_PostProcessingAnim.class);
        /* 333 */ K2C.put(DeadlockMessageId.CitadelUserMessageIds.k_EUserMsg_DeathReplayData_VALUE, null);
        /* 334 */ K2C.put(DeadlockMessageId.CitadelUserMessageIds.k_EUserMsg_PlayerLifetimeStatInfo_VALUE, null);
        /* 336 */ K2C.put(DeadlockMessageId.CitadelUserMessageIds.k_EUserMsg_ForceShopClosed_VALUE, null);
        /* 337 */ K2C.put(DeadlockMessageId.CitadelUserMessageIds.k_EUserMsg_StaminaDrained_VALUE, null);
        /* 338 */ K2C.put(DeadlockMessageId.CitadelUserMessageIds.k_EUserMsg_AbilityNotify_VALUE, CitadelUserMessages.CCitadelUserMessage_AbilityNotify.class);
        /* 339 */ K2C.put(DeadlockMessageId.CitadelUserMessageIds.k_EUserMsg_GetDamageStatsResponse_VALUE, null);
        /* 340 */ K2C.put(DeadlockMessageId.CitadelUserMessageIds.k_EUserMsg_ParticipantStartSoundEvent_VALUE, CitadelUserMessages.CCitadelUserMsg_ParticipantStartSoundEvent.class);
        /* 341 */ K2C.put(DeadlockMessageId.CitadelUserMessageIds.k_EUserMsg_ParticipantStopSoundEvent_VALUE, CitadelUserMessages.CCitadelUserMsg_ParticipantStopSoundEvent.class);
        /* 342 */ K2C.put(DeadlockMessageId.CitadelUserMessageIds.k_EUserMsg_ParticipantStopSoundEventHash_VALUE, CitadelUserMessages.CCitadelUserMsg_ParticipantStopSoundEventHash.class);
        /* 343 */ K2C.put(DeadlockMessageId.CitadelUserMessageIds.k_EUserMsg_ParticipantSetSoundEventParams_VALUE, CitadelUserMessages.CCitadelUserMsg_ParticipantSetSoundEventParams.class);
        /* 344 */ K2C.put(DeadlockMessageId.CitadelUserMessageIds.k_EUserMsg_ParticipantSetLibraryStackFields_VALUE, CitadelUserMessages.CCitadelUserMsg_ParticipantSetLibraryStackFields.class);
        /* 345 */ K2C.put(DeadlockMessageId.CitadelUserMessageIds.k_EUserMsg_CurrencyChanged_VALUE, null);
        /* 346 */ K2C.put(DeadlockMessageId.CitadelUserMessageIds.k_EUserMsg_GameOver_VALUE, CitadelUserMessages.CCitadelUserMessage_GameOver.class);
        /* 347 */ K2C.put(DeadlockMessageId.CitadelUserMessageIds.k_EUserMsg_BossKilled_VALUE, CitadelUserMessages.CCitadelUserMsg_BossKilled.class);

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

        /* 450 */ K2C.put(DeadlockGameEvents.ECitadelGameEvents.GE_FireBullets_VALUE, DeadlockGameEvents.CMsgFireBullets.class);
        /* 461 */ K2C.put(DeadlockGameEvents.ECitadelGameEvents.GE_BulletImpact_VALUE, DeadlockGameEvents.CMsgBulletImpact.class);

        /* 500 */ K2C.put(DeadlockMessageId.CitadelEntityMessageIds.k_EEntityMsg_BreakablePropSpawnDebris_VALUE, CitadelUserMessages.CCitadelEntityMsg_BreakablePropSpawnDebris.class);
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
