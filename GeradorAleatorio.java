import java.util.List;
import java.util.ArrayList;
import java.util.Random;
public class GeradorAleatorio implements Subject{

    private List <Observer> observers;
    private Random gerador = new Random();
    private int numeroAtual;

    public GeradorAleatorio(){
        this.observers = new ArrayList<>();
    }

    public void registrarObserver(Observer o){
        this.observers.add(o);
    }

    public void removerObserver (Observer o){
        this.observers.remove(o);
    }

    public void notificarObservers(){
        for (Observer o: observers) {
            o.atualizar(numeroAtual);
        }
    }

    public void iniciar (){
        while (true){
            this.numeroAtual = gerador.nextInt(20) + 1;
            notificarObservers();
            System.out.println("**************");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
    
}
