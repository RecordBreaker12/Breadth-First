package breadth.first;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Optional;
import java.util.Queue;
import java.util.Set;

public class BreadthFirst {
    
    public static <T> Optional<No<T>> procura(T valor, No<T> inicio){
        Queue<No<T>> fila = new ArrayDeque<>();
        fila.add(inicio);
        
        No<T> atual;
        Set<No<T>> jaVisitou = new HashSet<>();
        
        while(!fila.isEmpty()){
            atual = fila.remove();
            System.out.println("Visitou no com valor: " + atual.getValor());
            if(atual.getValor().equals(valor)){
                return Optional.of(atual);
            }
            else{
                jaVisitou.add(atual);
                fila.addAll(atual.getVizinhos());
                fila.removeAll(jaVisitou);
            }
        }
        System.out.println("Valor não encontrado.");
        return Optional.empty();
    }
    
    public static void main(String[] args) {
        //**Representacao da imagem de exemplo**//
        No no0 = new No(0);
        No no1 = new No(1);
        No no2 = new No(2);
        No no3 = new No(3);
        No no4 = new No(4);
        No no5 = new No(5);
        No no6 = new No(6);
        No no7 = new No(7);
        no0.conectar(no2);
        no0.conectar(no3);
        no0.conectar(no4);
        no1.conectar(no5);
        no2.conectar(no4);
        no3.conectar(no1);
        no3.conectar(no5);
        no4.conectar(no2);
        no4.conectar(no7);
        no5.conectar(no1);
        no5.conectar(no3);
        no5.conectar(no7);
        no6.conectar(no4);
        no6.conectar(no5);
        procura(7, no0);
    }
    
}
