package de.codingair.tradesystem.spigot.extras.external.fgvault;

import de.codingair.codingapi.tools.items.ItemBuilder;
import de.codingair.codingapi.tools.items.XMaterial;
import de.codingair.tradesystem.spigot.TradeSystem;
import de.codingair.tradesystem.spigot.events.TradeIconInitializeEvent;
import de.codingair.tradesystem.spigot.extras.external.PluginDependency;
import de.codingair.tradesystem.spigot.trade.gui.layout.registration.EditorInfo;
import de.codingair.tradesystem.spigot.trade.gui.layout.registration.TransitionTargetEditorInfo;
import de.codingair.tradesystem.spigot.trade.gui.layout.registration.Type;
import de.codingair.tradesystem.spigot.trade.gui.layout.registration.exceptions.TradeIconException;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.jetbrains.annotations.NotNull;

public class FGVaultDependency implements PluginDependency, Listener {

    @EventHandler
    public void onIconInitialize(TradeIconInitializeEvent e) {
        try {
            e.registerIcon(TradeSystem.getInstance(), FGTokensIcon.class, new EditorInfo("FGVault icon", Type.ECONOMY, (editor) -> new ItemBuilder(XMaterial.TRIPWIRE_HOOK), false, getPluginName()));
            e.registerIcon(TradeSystem.getInstance(), ShowFGTokensIcon.class, new TransitionTargetEditorInfo("FGVault preview icon", FGTokensIcon.class));
        } catch (TradeIconException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public @NotNull String getPluginName() {
        return "FGVault";
    }
}
