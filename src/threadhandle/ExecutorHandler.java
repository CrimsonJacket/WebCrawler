/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threadhandle;

/**
 *
 * @author crimson
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.logging.Level;
import java.util.logging.Logger;
import main.WebCrawler;
import page_utils.Page;

public class ExecutorHandler extends Thread {

    private int numOfDownloadThreads;
    private int numOfProcessThreads;

    public static ExecutorService dlExecutor;
    public static ExecutorService pExecutor;
    
    public static int donePagesCount = 0;
    public static List<String> toDo;
    public static URLQueue queue = new URLQueue();

    public ExecutorHandler(List<String> seeds) {
        this.numOfDownloadThreads = 5;
        this.numOfProcessThreads = 5;
        //this.seeds = seeds;
        this.toDo = seeds;
        ExecutorHandler.dlExecutor = Executors.newFixedThreadPool(numOfDownloadThreads);
        ExecutorHandler.pExecutor = Executors.newFixedThreadPool(numOfProcessThreads);
    }

    public ExecutorHandler(int d, int p, List<String> seeds) {
        this.numOfDownloadThreads = d;
        this.numOfProcessThreads = p;
        //this.seeds = seeds;
        this.toDo = seeds;
        ExecutorHandler.dlExecutor = Executors.newFixedThreadPool(numOfDownloadThreads);
        ExecutorHandler.pExecutor = Executors.newFixedThreadPool(numOfProcessThreads);
    }

    @Override
    public void run() {
        for (String seed : toDo) {
            for (String dupCheck : toDo){
                if(!seed.equalsIgnoreCase(dupCheck)){
                    queue.addURL(seed);
                }
            }            
        }
        queue.setWaiting(true);
        while (queue.isWaiting()) {
            ExecutorHandler.dlExecutor.execute(new Downloader(new Page(queue.getURL())));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(ExecutorHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        dlExecutor.shutdown();
        pExecutor.shutdown();

        int count = 1;
        for(Page page: WebCrawler.donePages){
            System.out.println(count + " | " + page.getLink() + " | " + page.getReferences().size());
            count++;
        }
    }
}