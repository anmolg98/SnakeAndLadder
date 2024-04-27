package Game;

import java.util.*;

public class Board {
     private Map<Integer,Integer> propMap;



      public Board(List<Props> props){
          propMap=new HashMap<>();

          for(Props prop:props){
              propMap.put(prop.getStart(), prop.getEnd());
          }

      }

      public boolean isPropStart(int start){
          if(propMap.containsKey(start)) return true;
          else return false;
      }

      public Integer getEnd(int start){
         return propMap.get(start);
      }
}
