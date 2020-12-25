package studio.thevipershow.vac.model.data;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class CheckFlag {

    private final VacFlag flag;
    private final long creationTime;
}
