package com.thejoa703.ioc;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//ver-1
//@Data
//ver-2
@Getter @Setter 
@RequiredArgsConstructor @ToString @EqualsAndHashCode
//@NoArgsConstructor
@AllArgsConstructor
public class DITest2 {
	private final String name;
	private int age;
}
