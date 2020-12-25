package studio.thevipershow.vac.metrics;

import org.bstats.bukkit.Metrics.CustomChart;
import org.jetbrains.annotations.NotNull;

public interface Metrics {

    int id = 9763;

    /**
     * Start the metrics service
     */
    void startService();

    /**
     * Register a new chart.
     * @param chart The chart.
     */
    void addCustomChart(@NotNull CustomChart chart);
}
