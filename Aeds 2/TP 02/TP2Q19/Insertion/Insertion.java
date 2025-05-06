import java.io.PrintWriter;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.Random;

public class Insertion {

    private static Log log = new Log();

    public static void insertionsort(int[] array, int n) {

	    for (int i = 1; i < n; i++) {
		int chave = array[i];
		log.addMov();
		int j = i - 1;

		while (j >= 0 && array[j] > chave) {
		    log.addComp();
		    array[j + 1] = array[j];
		    log.addMov();
		    j--;
		}
		array[j + 1] = chave;
		log.addMov();
	    }

        

    }


    public static void createLog() throws IOException {
        int n = 100;
        Timer timer = new Timer();
        PrintWriter writer = new PrintWriter("insertion.txt", "UTF-8");
        writer.println("Matricula: 866018\n");

        Random rand = new Random();

        while (n <= 100000) {
            int[] array = new int[n];

            for (int i = 0; i < n; i++) {
                array[i] = rand.nextInt(n);
            }

            timer.start();
            insertionsort(array, n);
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

    public void addComp(int comp) {
        this.comp += comp;
    }

    public void addMov(int mov) {
        this.mov += mov;
    }

    public void setComp(int comp) {
        this.comp = comp;
    }

    public long getComp() {
        return comp;
    }

    public void setMov(int mov) {
        this.mov = mov;
    }

    public long getMov() {
        return mov;
    }

}

