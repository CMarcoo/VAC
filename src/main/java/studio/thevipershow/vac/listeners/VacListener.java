package studio.thevipershow.vac.listeners;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.bukkit.event.Listener;
import studio.thevipershow.vac.Vac;

@RequiredArgsConstructor
@Getter
public abstract class VacListener implements Listener {

    protected final Vac vac;
}
