package com.gupb.manager.python;

import org.junit.jupiter.api.Test;
import com.gupb.manager.model.BotStatus;
import com.gupb.manager.model.Team;
import com.gupb.manager.python.PythonRunner;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;



@RunWith(SpringRunner.class )
@SpringBootTest
public class PythonRunnerTest {
    @Autowired
    private static final PythonRunner p = new PythonRunner();

    @Test
    public void runTest() {
        //
/*
        for (int ii = 0; ii < 5; ii++) {
            System.out.println("Hello, world!");
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
*/
        PythonPackageManager pkg = new PythonPackageManager();

        pkg.createVirtualEnvironment("/home/burooo/IO-TEST/testXD/te5ting-s0mething/src/main/java/com/gupb/manager/python/GUPB-test/", "nejm");

        /*
        Thread t = new Thread(p);
        t.start();
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        */
    }
}
