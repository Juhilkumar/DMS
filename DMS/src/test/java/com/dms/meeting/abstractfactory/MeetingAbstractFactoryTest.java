package com.dms.meeting.abstractfactory;

import com.dms.meeting.interfaces.IScheduleMeetingModel;
import com.dms.meeting.interfaces.IViewMeetingsModel;

public abstract class MeetingAbstractFactoryTest {
    private static MeetingAbstractFactoryTest uniqueInstance = null;
    public abstract IScheduleMeetingModel createScheduleMeetingModel();
    public abstract IViewMeetingsModel createViewMeetingsModel();

    public static MeetingAbstractFactoryTest instance() {
        if (null == uniqueInstance) {
            uniqueInstance = new MeetingConcreteFactoryTest();
        }
        return uniqueInstance;
    }
}
