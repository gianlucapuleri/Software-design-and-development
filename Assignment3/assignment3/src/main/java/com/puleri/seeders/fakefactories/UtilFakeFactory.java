package com.puleri.seeders.fakefactories;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

class UtilFakeFactory {

    public static <T> List<T> randomSubList(List<T> list, int newSize) {
        list = new ArrayList<>(list);
        Collections.shuffle(list);
        return list.subList(0, newSize);
    }

    public static <T> T randomFromList(List<T> list) {
        Random rand = new Random();
        return list.get(rand.nextInt(list.size()));
    }
    
    public enum CalciatoriRuolo {
    	portiere,
    	difensore,
    	centrocampista,
    	attaccante;
    	
    	private static final List<CalciatoriRuolo> VALUES =
    			Collections.unmodifiableList(Arrays.asList(values()));
    	private static final int SIZE = VALUES.size();
    	private static final Random RANDOM = new Random();

    	public static CalciatoriRuolo randomRole()  {
    		return VALUES.get(RANDOM.nextInt(SIZE));
      }
    }
    
    public enum DirigentiRuolo {
    	allenatore,
    	osservatore,
    	magazziniere,
    	preparatore,
    	AD;
    	
    	private static final List<DirigentiRuolo> VALUES =
    			Collections.unmodifiableList(Arrays.asList(values()));
    	private static final int SIZE = VALUES.size();
    	private static final Random RANDOM = new Random();

    	public static DirigentiRuolo randomRole()  {
    		return VALUES.get(RANDOM.nextInt(SIZE));
      }
    }
}
