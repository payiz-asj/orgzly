package com.orgzly;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class login_activityTest {
    private login_activity log;


    @Before
    public void setUp() throws Exception{
        log=new login_activity();
    }


    @Test
    public void f_test() throws Exception{
        assertEquals(4,log.f_test(2,2));
    }

    public void f_test2() throws Exception{
        assertEquals(3,log.f_test(2,2));
    }
}