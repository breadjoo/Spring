package sample;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import lombok.ToString;

@ToString
@RequiredArgsConstructor
@Component
public class SampleHotel {
	
	private final Chef chef;

}
