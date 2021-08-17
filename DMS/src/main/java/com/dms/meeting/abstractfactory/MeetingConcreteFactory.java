package com.dms.meeting.abstractfactory;

import com.dms.meeting.ScheduleMeetingDAO;
import com.dms.meeting.ScheduleMeetingModel;
import com.dms.meeting.ViewMeetingsDAO;
import com.dms.meeting.ViewMeetingsModel;
import com.dms.meeting.interfaces.IScheduleMeetingModel;
import com.dms.meeting.interfaces.IViewMeetingsModel;

public class MeetingConcreteFactory extends MeetingAbstractFactory {
    public IScheduleMeetingModel createScheduleMeetingModel(){ return new ScheduleMeetingModel(new ScheduleMeetingDAO()); }

    public IViewMeetingsModel createViewMeetingsModel(){
        return new ViewMeetingsModel(new ViewMeetingsDAO());
    }

}
