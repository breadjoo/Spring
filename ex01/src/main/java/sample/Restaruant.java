package sample;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Component
@ToString
@RequiredArgsConstructor
public class Restaruant {
	
	
		private final Chef chef;

}
