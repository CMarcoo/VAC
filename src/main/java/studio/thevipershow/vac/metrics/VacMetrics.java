package studio.thevipershow.vac.metrics;

import java.util.Objects;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import studio.thevipershow.vac.Vac;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public final class VacMetrics implements Metrics {
    private static VacMetrics instance = null;
    private final Vac vac;

    public synchronized static VacMetrics getInstance(@NotNull Vac vac) {
        if (instance == null) {
            instance = new VacMetrics(vac);
        }
        return instance;
    }

    private org.bstats.bukkit.Metrics metrics = null;

    /**
     * Start the metrics service
     */
    @Override
    public void startService() {
        if (metrics != null) {
            throw new UnsupportedOperationException("Cannot start metrics twice!");
        } else {
            metrics = new org.bstats.bukkit.Metrics(vac, id);
        }
    }

    /**
     * Register a new chart.
     *
     * @param chart The chart.
     */
    @Override
    public void addCustomChart(@NotNull org.bstats.bukkit.Metrics.CustomChart chart) {
        if (metrics == null) {
            throw new UnsupportedOperationException("Cannot add a chart because the metrics are null.");
        } else {
            metrics.addCustomChart(Objects.requireNonNull(chart, "The added chart should not have been null!"));
        }
    }
}
