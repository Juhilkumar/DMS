package com.dms.meeting.abstractfactory;

import com.dms.meeting.*;
import com.dms.meeting.interfaces.IScheduleMeetingModel;
import com.dms.meeting.interfaces.IViewMeetingsModel;

public class MeetingConcreteFactoryTest extends MeetingAbstractFactoryTest {
    public IScheduleMeetingModel createScheduleMeetingModel(){ return new ScheduleMeetingModel(new ScheduleMeetingDAOMock()); }

    public IViewMeetingsModel createViewMeetingsModel(){
        return new ViewMeetingsModel(new ViewMeetingsDAOMock());
    }

}
