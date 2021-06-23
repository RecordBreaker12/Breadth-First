package breadth.first;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class No<T> {
    private T valor;
    private Set<No<T>> vizinhos;
    
    public No(T valor){
        this.valor = valor;
        this.vizinhos = new HashSet<>();
    }
    
    public T getValor(){
        return valor;
    }
    
    public Set<No<T>> getVizinhos(){
        return Collections.unmodifiableSet(vizinhos);
    }
    
    public void conectar(No<T> no){
        if(this == no){
            throw new IllegalArgumentException ("Impossivel conectar um No a si mesmo!");
        }
        this.vizinhos.add(no);
    }
}
