package io.github.mortuusars.thief.network;


import com.google.common.base.Preconditions;
import dev.architectury.injectables.annotations.ExpectPlatform;
import io.github.mortuusars.thief.network.packet.Packet;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.players.PlayerList;
import net.minecraft.world.entity.Entity;
import org.jetbrains.annotations.Nullable;

import java.util.function.Predicate;

public class Packets {
    @ExpectPlatform
    public static void sendToServer(Packet packet) {
        throw new AssertionError();
    }

    @ExpectPlatform
    public static void sendToClient(Packet packet, ServerPlayer player) {
        throw new AssertionError();
    }

    @ExpectPlatform
    public static void sendToAllClients(Packet packet) {
        throw new AssertionError();
    }

    @ExpectPlatform
    public static void sendToPlayersTrackingEntity(Entity entity, Packet packet) {
        throw new AssertionError();
    }

    public static void sendToClients(Packet packet, PlayerList playerList, @Nullable ServerPlayer excludedPlayer) {
        for (ServerPlayer player : playerList.getPlayers()) {
            if (player != excludedPlayer)
                sendToClient(packet, player);
        }
    }

    public static void sendToClients(Packet packet, ServerPlayer origin, Predicate<ServerPlayer> filter) {
        Preconditions.checkState(origin.getServer() != null, "Server cannot be null");
        for (ServerPlayer player : origin.getServer().getPlayerList().getPlayers()) {
            if (filter.test(player))
                sendToClient(packet, player);
        }
    }

    public static void sendToOtherClients(Packet packet, ServerPlayer excludedPlayer) {
        sendToClients(packet, excludedPlayer, serverPlayer -> !serverPlayer.equals(excludedPlayer));
    }

    public static void sendToOtherClients(Packet packet, ServerPlayer excludedPlayer, Predicate<ServerPlayer> filter) {
        sendToClients(packet, excludedPlayer, serverPlayer -> !serverPlayer.equals(excludedPlayer) && filter.test(serverPlayer));
    }
}