package issues.raceCondition;

import java.util.concurrent.Semaphore;

public class Contador {

    private int contador = 0;

    private final Semaphore semaphore;

    public Contador(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    public void incrementarContador() {
        try {
            semaphore.acquire(); // Adquiere el semáforo antes de modificar el contador
            contador++;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            semaphore.release(); // Libera el semáforo después de la modificación
        }
    }

    public int getContador(){
        return contador;
    }
}
