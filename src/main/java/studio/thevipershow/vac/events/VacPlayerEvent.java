package studio.thevipershow.vac.events;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.bukkit.event.Event;
import studio.thevipershow.vac.model.VacPlayer;

@RequiredArgsConstructor
@Getter
public abstract class VacPlayerEvent extends Event {

    private final VacPlayer vacPlayer;
}
