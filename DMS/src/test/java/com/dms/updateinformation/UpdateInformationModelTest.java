package com.dms.updateinformation;

import com.dms.updateinformation.abstractfactory.UpdateInformationAbstractFactoryTest;
import com.dms.updateinformation.interfaces.IUpdateInformationModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UpdateInformationModelTest {
    UpdateInformationAbstractFactoryTest updateInformationAbstractFactoryTest;
    IUpdateInformationModel iUpdateInformationModel;

    @BeforeEach
    void init() {
        updateInformationAbstractFactoryTest = UpdateInformationAbstractFactoryTest.instance();
        iUpdateInformationModel = updateInformationAbstractFactoryTest.iUpdateInformationModel();
    }

    @Test
    public void getDetailsTest() throws SQLException{
        List<String> info = iUpdateInformationModel.getDetails("Parth");
        assertEquals("Parth",info.get(0));
        assertEquals("last",info.get(1));
    }

    @Test
    public void updateInformationTest() throws SQLException {
        assertEquals(true,iUpdateInformationModel.updateInformation("Parth","last",16-03-1995,"Parth@gmail.com","Parth@123","Parth"));
    }
}