import java.io.PrintWriter;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.Random;

public class Quicksort {

    private static Log log = new Log();

	  public static void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
        log.addMov(3);
    }

    public static void quicksort(int[] array, int esq, int dir) {
    
        int i = esq, j = dir, pivo = array[(esq + dir) / 2];

        while (i <= j) {
            
            log.addComp();
            while (array[i] < pivo) {
                i++;
            }
            
            log.addComp();
            while (array[j] > pivo) {
                j--;
            }
            
            log.addComp();
            if (i <= j) {
                swap(array, i, j);
                i++;
                j--;
            }
        }

        if (esq < j) {
            quicksort(array, esq, j);
        }
        if (i < dir) {
            quicksort(array, i, dir);
        }
    }


    public static void createLog() throws IOException {
        int n = 100;
        Timer timer = new Timer();
        PrintWriter writer = new PrintWriter("quicksort.txt", "UTF-8");
        writer.println("Matricula: 866018\n");

        Random rand = new Random();

        while (n <= 1000000) {
            int[] array = new int[n];

            for (int i = 0; i < n; i++) {
                array[i] = rand.nextInt(n);
            }

            timer.start();
            quicksort(array, 0, n-1);
            timer.stop();

            writer.println("Tempo com " + n + ": " + timer.getTime() + "s\t" +
                           "Comparações: " + log.getComp() + "\t" +
                           "Movimentações: " + log.getMov() + "\n");

            n *= 10;
            log.setMov(0);
            log.setComp(0);
        }

        writer.close();
    }

    public static void main(String[] args) throws IOException {
        createLog();
    }

}

class Timer {
    private Instant fim, inicio;

    public void start() {
        this.inicio = Instant.now();
    }

    public void stop() {
        this.fim = Instant.now();
    }

    public double getTime() {
        return Duration.between(inicio, fim).toMillis() / 1000.0;
    }
}

class Log {
    private long comp, mov;

    public Log() {
        comp = 0;
        mov = 0;
    }

    public void addComp() {
        this.comp++;
    }

    public void addMov() {
        this.mov++;
    }

    public void addComp(long comp) {
        this.comp += comp;
    }

    public void addMov(long mov) {
        this.mov += mov;
    }

    public void setComp(long comp) {
        this.comp = comp;
    }

    public long getComp() {
        return comp;
    }

    public void setMov(long mov) {
        this.mov = mov;
    }

    public long getMov() {
        return mov;
    }
}

