/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dmexample;

import java.util.concurrent.Callable;

/**
 *
 * @author pikachu
 */
public class SummatorDM implements Callable<String>{
    private int num;
    public int partSum;
    public int endSum;
    
    SummatorDM() {
        this.endSum=0;
        this.partSum=0;
        this.num=0;
    }
    private synchronized String SummIt() {
        num++;
        if (num==1) {
            this.partSum=num;
            return null;
        }
        else {
            int part = this.partSum;
            int iterator = num;
            this.partSum+=this.num;
            this.endSum=this.partSum;
            return "Thread: "+Thread.currentThread().getName()+": "+part+"+"+iterator+": Sum = "+this.partSum+" ; EndSum= "+this.endSum;
        }
    }

    @Override
    public String call() throws Exception {
        return SummIt();
    }

}
