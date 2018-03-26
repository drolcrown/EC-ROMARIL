package util;

import org.jgroups.util.Tuple;

import java.util.ArrayList;
import java.util.List;

public class JsonUtil {
    public List<Tuple> desmembrarJson(String json){
        String tupla, tupla2;
        List<Tuple> vetorTupla = new ArrayList<Tuple>();
        Boolean chave = true;

        for(int i = 0; i < json.length(); i++){
            if(json.charAt(i) == '\"'){
                tupla = "";
                tupla2 = "";
                while(json.charAt(i) != '\n' && json.charAt(i) != '}') {
                    i++;
                    if(json.charAt(i) == ':'){
                        chave = false;
                    }
                    if(json.charAt(i) != '\"' && json.charAt(i) != ' ' && json.charAt(i) != ':'
                            && json.charAt(i) != ',' && json.charAt(i) != '\n' && json.charAt(i) != '}') {
                        if(chave) {
                            tupla += json.charAt(i);
                        }else{
                            tupla2 += json.charAt(i);
                        }
                    }
                }
                vetorTupla.add(new Tuple<String, String>(tupla, tupla2));
                chave = true;
            }
        }
        return vetorTupla;
    }
}
