package de.codingair.tradesystem.spigot.extras.external.fgvault;

import de.codingair.tradesystem.spigot.extras.external.EconomySupportType;
import de.codingair.tradesystem.spigot.extras.external.TypeCap;
import de.codingair.tradesystem.spigot.trade.gui.layout.types.impl.economy.EconomyIcon;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import ru.brfg.base.bukkit.FGBase;
import ru.brfg.base.manager.PlayerManager;

import java.math.BigDecimal;

public class TokenIcon extends EconomyIcon<ShowTokenIcon> {
    public TokenIcon(@NotNull ItemStack itemStack) {
        super(itemStack, "Token", "Tokens", false);
    }

    @Override
    public Class<ShowTokenIcon> getTargetClass() {
        return ShowTokenIcon.class;
    }

    private @NotNull PlayerManager getPlayerManager() {
        FGBase base = (FGBase) Bukkit.getPluginManager().getPlugin("FGBase");
        assert base != null;
        return FGBase.getPlayerManager();
    }

    @Override
    protected @NotNull BigDecimal getBalance(@NotNull Player player) {
        return BigDecimal.valueOf(getPlayerManager().getTokens(player.getName(), false));
    }

    @Override
    protected void withdraw(Player player, @NotNull BigDecimal value) {
        getPlayerManager().takeTokens(player.getName(), value.longValue(), false);
    }

    @Override
    protected void deposit(Player player, @NotNull BigDecimal value) {
        getPlayerManager().addTokens(player.getName(), value.longValue());
    }

    @Override
    protected @NotNull TypeCap getMaxSupportedValue() {
        return EconomySupportType.LONG;
    }
}
