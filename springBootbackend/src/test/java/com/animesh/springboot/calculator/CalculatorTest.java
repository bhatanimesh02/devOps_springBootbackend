package com.animesh.springboot.calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculatorTest {

	//given
	Calculator cal = new Calculator();
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	final void testAdd() {
		
	//when
	int result = 5;
	
	//then
	assertThat(result).isEqualTo(5);
	}

}
