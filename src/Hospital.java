import java.text.SimpleDateFormat;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;// porque no toma el priorityQueue(porque viene default al java)
import java.util.List;

public class Hospital {
    private Map<String, Patient> totalPatient;
    private PriorityQueue<Patient> attentionQueue; //gestiona a los pacientes en espera
    private Map<String, AreaAtencion> areasAttention;// asignar paciente a areas especificas
    private List<Patient> patientAttended;// pacientes para la casa
    Hospital(){}
}
