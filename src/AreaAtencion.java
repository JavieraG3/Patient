import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Comparator;

 class AreaAtencion{
    private String nombre;
    private PriorityQueue<Patient> pacientesHeap;//mantiene los paciente ordenados por orden de llegada y urgencia
    private int capacidadMaxima;

     public AreaAtencion(String nombre, int capacidadMaxima){// la cola para las pruebas se lo podemos dar de antemano ahi veremos
         this.nombre = nombre;
         this.capacidadMaxima = capacidadMaxima;

     Comparator<Patient> c = new Comparator<Patient>() {
       public int compare(Patient p1, Patient p2) {
         if (p1.getCategoria() < p2.getCategoria()) {
           return -1;
            }
              if (p1.getCategoria() > p2.getCategoria()) {
                 return 1;
                 } else {//tienen la misma categoria, se resuelve en base a su orden de llegada
                     if (p1.getArrivalTime() < p2.getArrivalTime()) {
                         return -1;
                     }
                     if (p1.getArrivalTime() > p2.getArrivalTime()) {
                         return 1;
                     } else {
                         return 0;
                     }
                 }
             }
         };
     pacientesHeap = new PriorityQueue<Patient>(c);

     }
     String getNombre(){
         return nombre;
     }
     void ingresarPaciente(Patient p){
         if(estaSaturada()){
             System.out.println("Se alcanzó la capacidad maxima en el área" + nombre);
         }else{
             pacientesHeap.offer(p);
             p.recordChange("Se ha ingresado paciente al area"+nombre);
         }
     }
     public Patient atenderPaciente() {
         if (!pacientesHeap.isEmpty()) { //verifico que no este vacia la cola de prioridad
             Patient p = pacientesHeap.poll(); //saco la cabeza / paciente prioritario
             p.setState("Atendido");//cambio el estado a atendido
             p.recordChange("Atendido en area"+nombre);//registro el cambio en el historial y en q area fue
             return p;//retorna la cabeza/paciente
         }else{
             return null;//cola vacia
         }
     }
     public boolean estaSaturada(){
         return pacientesHeap.size() >= capacidadMaxima;
     }
     public List<Patient> obtenerPacientesPorHeapSort(){
         PriorityQueue<Patient> aux= new PriorityQueue<Patient>(pacientesHeap); //creamos un auxiliar para no modificar el original

         List<Patient> ordenados= new ArrayList<Patient>();

         while(!aux.isEmpty()){
             ordenados.add(aux.poll()); //ahora al ser una lista se usa add, offer solo usamos en colas
         }

         return ordenados;
     }

}
