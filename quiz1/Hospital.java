import java.util.*;

public class Hospital {
    private List<IntensiveCareWard> intensiveCareWards;

    public Hospital(List<IntensiveCareWard> i) {
        intensiveCareWards = i;
    };

    public List<IntensiveCareWard> getIntensiveCareWards() {
        return intensiveCareWards;
    }
}
