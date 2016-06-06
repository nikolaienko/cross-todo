package ua.nure.nikolaienko;

import java.util.Collection;

/**
 * Created by vlad on 05.06.16.
 */
public interface SegmentChooser<T> {
    T chooseSegment(Collection<T> bonusSegment);
}
