package io.github.mortuusars.thief.network.packet;

import io.github.mortuusars.thief.network.packet.clientbound.VillagerGossipsS2CP;
import io.github.mortuusars.thief.network.packet.clientbound.VillagerReputationS2CP;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;

import java.util.List;

public class S2CPackets {
    public static List<CustomPacketPayload.TypeAndCodec<? extends FriendlyByteBuf, ? extends CustomPacketPayload>> getDefinitions() {
        return List.of(
                new CustomPacketPayload.TypeAndCodec<>(VillagerReputationS2CP.TYPE, VillagerReputationS2CP.STREAM_CODEC),
                new CustomPacketPayload.TypeAndCodec<>(VillagerGossipsS2CP.TYPE, VillagerGossipsS2CP.STREAM_CODEC)
        );
    }
}