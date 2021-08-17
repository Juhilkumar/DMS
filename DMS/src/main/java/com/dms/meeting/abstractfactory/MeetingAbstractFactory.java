package com.dms.meeting.abstractfactory;

import com.dms.meeting.interfaces.IScheduleMeetingModel;
import com.dms.meeting.interfaces.IViewMeetingsModel;

public abstract class MeetingAbstractFactory {
    private static MeetingAbstractFactory  uniqueInstance = null;
    public abstract IScheduleMeetingModel createScheduleMeetingModel();
    public abstract IViewMeetingsModel createViewMeetingsModel();

    public static MeetingAbstractFactory instance() {
        if (null == uniqueInstance) {
            uniqueInstance = new MeetingConcreteFactory();
        }
        return uniqueInstance;
    }
}
