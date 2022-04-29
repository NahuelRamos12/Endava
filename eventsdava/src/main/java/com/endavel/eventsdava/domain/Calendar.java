package com.endavel.eventsdava.domain;

/*import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Calendar {

	/*LocalDate date;
	//LocalTime time;	
	
	@OneToMany
	List<Event> listEvents;
	
	}
	*/
	
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;
//day.getDayOfWeek().getDisplayName(TextStyle.FULL, español),%-10s
//.getDisplayName(TextStyle.FULL, español)

public class Calendar {
    public static void main( String ... args ) {
        //final Locale español = new Locale("es","MX");
        for ( LocalDate day = LocalDate.parse("2022-01-01"); day.getYear() < 2023 ; day = day.plusDays(1)) {
            System.out.printf(" %02d-%s-%s%n",                    
                    day.getDayOfMonth(),
                    day.getMonth().getValue(), day.getYear()
            );
        }
    }
} 	


 
