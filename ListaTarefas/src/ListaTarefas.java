import java.util.ArrayList;
import java.util.List;

public class ListaTarefas {
    private List<String> tarefas;

    public ListaTarefas() {
        this.tarefas = new ArrayList<>();
    }

    public void adicionar(String tarefa){
        tarefas.add(tarefa);
    }

    public void remover(String tarefa){
        tarefas.remove(tarefa);
    }

    public List<String> listar(){
        return new ArrayList<>(tarefas);
    }

    public void marcar_concluida(String tarefa){
        int index = tarefas.indexOf(tarefa);
        if (index != -1){
            tarefas.set(index, tarefa + " - finalizada");
        }
    }

    public int total(){
        return tarefas.size();
    }

    //Teste
    
    public static void main(String[] args){
        ListaTarefas lista = new ListaTarefas();
        lista.adicionar("Teste");
        lista.adicionar("A");
        lista.marcar_concluida("A");
        System.out.println(lista.listar());
        lista.remover("Teste");
        System.out.println(lista.listar());
        System.out.println("Total: " + lista.total());
    }
}