package champollion;
import java.util.HashMap;

public class Enseignant extends Personne {	
        private float hPrevues;
        HashMap<UE, ServicePrevu> heureUE = new HashMap<UE, ServicePrevu>();

    public Enseignant(String nom, String email) {
        super(nom, email);
    }
    
    /**
     * Calcule le nombre total d'heures prévues pour cet enseignant
     * en "heures équivalent TD"
     * Pour le calcul :
     * 1 heure de cours magistral vaut 1,5 h "équivalent TD"
     * 1 heure de TD vaut 1h "équivalent TD"
     * 1 heure de TP vaut 0,75h "équivalent TD"
     * @return le nombre total d'heures "équivalent TD" prévues pour cet enseignant
     **/
      
    public float heuresPrevues() {    
        for (ServicePrevu td  : heureUE.values()){
        hPrevues = td.getHeureCM()*1.5f+td.getHeureTD()+td.getHeureTP()*0.75f;           
        }
        return hPrevues;
    }

    /**
     * Calcule le nombre total d'heures prévues pour cet enseignant dans l'UE spécifiée
     * en "heures équivalent TD"
     * Pour le calcul :
     * 1 heure de cours magistral vaut 1,5 h "équivalent TD"
     * 1 heure de TD vaut 1h "équivalent TD"
     * 1 heure de TP vaut 0,75h "équivalent TD"
     * @param ue l'UE concernée
     * @return le nombre total d'heures "équivalent TD" prévues pour cet enseignant
     **/
    public float heuresPrevuesPourUE(UE ue) {
         hPrevues=heureUE.get(ue).getHeureCM()*1.5f+heureUE.get(ue).getHeureTD()+heureUE.get(ue).getHeureTP()*0.75f;
         return hPrevues;
    }
    
    /**
     * Ajoute un enseignement au service prévu pour cet enseignant
     * @param ue l'UE concernée
     * @param volumeCM le volume d'heures de cours magitral 
     * @param volumeTD le volume d'heures de TD 
     * @param volumeTP le volume d'heures de TP 
     */
  
     public void ajouteEnseignement(UE ue, float volumeCM, float volumeTD, float volumeTP) {
         ServicePrevu td = heureUE.get(ue);
         if(td==null){
            td = new ServicePrevu();
            td.setHeureCM(volumeCM);
            td.setHeureTD(volumeTD);
            td.setHeureTP(volumeTP);
         }
         else{
            td.setHeureCM(volumeCM+td.getHeureCM());
            td.setHeureTD(volumeTD+td.getHeureTD());
            td.setHeureTP(volumeTP+td.getHeureTP());
         }         
         heureUE.put(ue, td);
     }
         	
}
