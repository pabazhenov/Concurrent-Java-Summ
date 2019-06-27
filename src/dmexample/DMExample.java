package dmexample;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 *
 * @author pikachu
 */
public class DMExample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException, ExecutionException, Exception {
        System.out.println("Enter k value: ");
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        System.out.println("Enter N value: ");
        int n = sc.nextInt();
        
        ExecutorService em = Executors.newFixedThreadPool(k);
        SummatorDM summator = new SummatorDM();
        List<Future<String>> StringList;
        StringList = new ArrayList<Future<String>>();
        for (int i=1;i<=n;i++) {
            Future<String> future;
            future = em.submit(summator);
            StringList.add(future);
        }
        for (Future<String> element : StringList) {
            System.out.println(element.get());
        }
        em.shutdown();
        System.out.println("Sum = "+summator.endSum);       
    }
    
}
