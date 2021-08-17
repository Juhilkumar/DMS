package com.dms.studentaccount;

import org.junit.jupiter.api.Test;
import java.sql.SQLException;
import static org.mockito.Mockito.*;

class StudentAccountTest {
    StudentAccountModel studentAccount = mock(StudentAccountModel.class);

    @Test
    void deductMoney() throws SQLException {
        doNothing().when(studentAccount).deductMoney(22251);
        studentAccount.deductMoney(22251);
        verify(studentAccount,times(1)).deductMoney(22251);
    }

    @Test
    void depositMoney() throws SQLException {
        doNothing().when(studentAccount).depositMoney(22251);
        studentAccount.depositMoney(22251);
        verify(studentAccount,times(1)).depositMoney(22251);
    }
}